package comp3607project.tool;

import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;

public class DynamicClassLoader {
    private static URLClassLoader classLoader;
    private String classPath;
    private boolean isCompiled;

    public DynamicClassLoader(String directory) {
        classPath = directory;
        DynamicJavaCompiler compiler = new DynamicJavaCompiler(classPath);
        isCompiled = compiler.compile();
        
        try {
            classLoader = URLClassLoader.newInstance(new URL[] {
                new File(classPath).toURI().toURL()
            }); 
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Class<?> getClass(String name) {
        try {
            return Class.forName(name, true, classLoader);
        } catch (Exception e) {
            return null;
        }
    }

    public boolean getIsCompiled() {
        return isCompiled;
    }
}
