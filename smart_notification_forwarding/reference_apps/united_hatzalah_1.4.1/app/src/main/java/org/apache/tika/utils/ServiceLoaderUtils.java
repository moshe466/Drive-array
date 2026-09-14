package org.apache.tika.utils;

import F0.C0019c2;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import org.apache.tika.config.ServiceLoader;

/* loaded from: classes.dex */
public class ServiceLoaderUtils {
    public static <T> T newInstance(String str) {
        return (T) newInstance(str, ServiceLoader.class.getClassLoader());
    }

    public static <T> void sortLoadedClasses(List<T> list) {
        list.sort(new C0019c2(9));
    }

    public static <T> T newInstance(String str, ClassLoader classLoader) {
        try {
            return (T) Class.forName(str, true, classLoader).getDeclaredConstructor(null).newInstance(null);
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | NoSuchMethodException | InvocationTargetException e4) {
            throw new RuntimeException(e4);
        }
    }

    public static <T> T newInstance(Class cls, ServiceLoader serviceLoader) {
        try {
            try {
                return cls.getDeclaredConstructor(ServiceLoader.class).newInstance(serviceLoader);
            } catch (IllegalAccessException | InstantiationException | NoSuchMethodException | InvocationTargetException e4) {
                throw new RuntimeException(e4);
            }
        } catch (NoSuchMethodException unused) {
            return cls.getDeclaredConstructor(null).newInstance(null);
        } catch (InvocationTargetException e5) {
            throw new RuntimeException(e5);
        }
    }
}
