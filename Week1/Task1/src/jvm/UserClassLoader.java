package jvm;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;


public class UserClassLoader extends ClassLoader {

    public static void main(String[] args) throws Exception {
        final String className = "Hello";
        final String methodName = "hello";

        ClassLoader classLoader = new UserClassLoader();
        Class<?> clazz = classLoader.loadClass(className);

        Object instance = clazz.getDeclaredConstructor().newInstance();
        Method method = clazz.getMethod(methodName);
        method.invoke(instance);
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        final String suffix = ".xlass";
        InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream(name + ".xlass");
        try {
            int length = inputStream.available();
            byte[] byteArray = new byte[length];
            inputStream.read(byteArray);

            byte[] classBytes = new byte[byteArray.length];
            for (int i = 0; i < byteArray.length; i++) {
                classBytes[i] = (byte) (255 - byteArray[i]);
            }

            return defineClass(name, classBytes, 0, classBytes.length);
        } catch (IOException e) {
            throw new ClassNotFoundException(name, e);
        } finally {
            close(inputStream);
        }
    }

    private static void close(Closeable res) {
        if (null != res) {
            try {
                res.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
