package n0;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import dalvik.system.BaseDexClassLoader;
import dalvik.system.DexClassLoader;
import dalvik.system.DexFile;
import dalvik.system.PathClassLoader;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.zip.ZipFile;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    private static final Set<File> f12159a = new HashSet();

    /* renamed from: b, reason: collision with root package name */
    private static final boolean f12160b = n(System.getProperty("java.vm.version"));

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: n0.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static final class C0253a {

        /* renamed from: b, reason: collision with root package name */
        private static final int f12161b = 4;

        /* renamed from: a, reason: collision with root package name */
        private final InterfaceC0254a f12162a;

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: n0.a$a$a, reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public interface InterfaceC0254a {
            Object a(File file, DexFile dexFile);
        }

        /* renamed from: n0.a$a$b */
        /* loaded from: classes.dex */
        private static class b implements InterfaceC0254a {

            /* renamed from: a, reason: collision with root package name */
            private final Constructor<?> f12163a;

            b(Class<?> cls) {
                Constructor<?> constructor = cls.getConstructor(File.class, ZipFile.class, DexFile.class);
                this.f12163a = constructor;
                constructor.setAccessible(true);
            }

            @Override // n0.a.C0253a.InterfaceC0254a
            public Object a(File file, DexFile dexFile) {
                return this.f12163a.newInstance(file, new ZipFile(file), dexFile);
            }
        }

        /* renamed from: n0.a$a$c */
        /* loaded from: classes.dex */
        private static class c implements InterfaceC0254a {

            /* renamed from: a, reason: collision with root package name */
            private final Constructor<?> f12164a;

            c(Class<?> cls) {
                Constructor<?> constructor = cls.getConstructor(File.class, File.class, DexFile.class);
                this.f12164a = constructor;
                constructor.setAccessible(true);
            }

            @Override // n0.a.C0253a.InterfaceC0254a
            public Object a(File file, DexFile dexFile) {
                return this.f12164a.newInstance(file, file, dexFile);
            }
        }

        /* renamed from: n0.a$a$d */
        /* loaded from: classes.dex */
        private static class d implements InterfaceC0254a {

            /* renamed from: a, reason: collision with root package name */
            private final Constructor<?> f12165a;

            d(Class<?> cls) {
                Constructor<?> constructor = cls.getConstructor(File.class, Boolean.TYPE, File.class, DexFile.class);
                this.f12165a = constructor;
                constructor.setAccessible(true);
            }

            @Override // n0.a.C0253a.InterfaceC0254a
            public Object a(File file, DexFile dexFile) {
                return this.f12165a.newInstance(file, Boolean.FALSE, file, dexFile);
            }
        }

        private C0253a() {
            InterfaceC0254a dVar;
            Class<?> cls = Class.forName("dalvik.system.DexPathList$Element");
            try {
                try {
                    dVar = new b(cls);
                } catch (NoSuchMethodException unused) {
                    dVar = new c(cls);
                }
            } catch (NoSuchMethodException unused2) {
                dVar = new d(cls);
            }
            this.f12162a = dVar;
        }

        static void a(ClassLoader classLoader, List<? extends File> list) {
            Object obj = a.g(classLoader, "pathList").get(classLoader);
            Object[] b10 = new C0253a().b(list);
            try {
                a.f(obj, "dexElements", b10);
            } catch (NoSuchFieldException unused) {
                a.f(obj, "pathElements", b10);
            }
        }

        private Object[] b(List<? extends File> list) {
            int size = list.size();
            Object[] objArr = new Object[size];
            for (int i10 = 0; i10 < size; i10++) {
                File file = list.get(i10);
                objArr[i10] = this.f12162a.a(file, DexFile.loadDex(file.getPath(), c(file), 0));
            }
            return objArr;
        }

        private static String c(File file) {
            File parentFile = file.getParentFile();
            String name = file.getName();
            return new File(parentFile, name.substring(0, name.length() - f12161b) + ".dex").getPath();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class b {
        static void a(ClassLoader classLoader, List<? extends File> list, File file) {
            IOException[] iOExceptionArr;
            Object obj = a.g(classLoader, "pathList").get(classLoader);
            ArrayList arrayList = new ArrayList();
            a.f(obj, "dexElements", b(obj, new ArrayList(list), file, arrayList));
            if (arrayList.size() > 0) {
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                }
                Field g10 = a.g(obj, "dexElementsSuppressedExceptions");
                IOException[] iOExceptionArr2 = (IOException[]) g10.get(obj);
                if (iOExceptionArr2 == null) {
                    iOExceptionArr = (IOException[]) arrayList.toArray(new IOException[arrayList.size()]);
                } else {
                    IOException[] iOExceptionArr3 = new IOException[arrayList.size() + iOExceptionArr2.length];
                    arrayList.toArray(iOExceptionArr3);
                    System.arraycopy(iOExceptionArr2, 0, iOExceptionArr3, arrayList.size(), iOExceptionArr2.length);
                    iOExceptionArr = iOExceptionArr3;
                }
                g10.set(obj, iOExceptionArr);
                IOException iOException = new IOException("I/O exception during makeDexElement");
                iOException.initCause((Throwable) arrayList.get(0));
                throw iOException;
            }
        }

        private static Object[] b(Object obj, ArrayList<File> arrayList, File file, ArrayList<IOException> arrayList2) {
            return (Object[]) a.h(obj, "makeDexElements", ArrayList.class, File.class, ArrayList.class).invoke(obj, arrayList, file, arrayList2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class c {
        static void a(ClassLoader classLoader, List<? extends File> list) {
            int size = list.size();
            Field g10 = a.g(classLoader, "path");
            StringBuilder sb2 = new StringBuilder((String) g10.get(classLoader));
            String[] strArr = new String[size];
            File[] fileArr = new File[size];
            ZipFile[] zipFileArr = new ZipFile[size];
            DexFile[] dexFileArr = new DexFile[size];
            ListIterator<? extends File> listIterator = list.listIterator();
            while (listIterator.hasNext()) {
                File next = listIterator.next();
                String absolutePath = next.getAbsolutePath();
                sb2.append(':');
                sb2.append(absolutePath);
                int previousIndex = listIterator.previousIndex();
                strArr[previousIndex] = absolutePath;
                fileArr[previousIndex] = next;
                zipFileArr[previousIndex] = new ZipFile(next);
                dexFileArr[previousIndex] = DexFile.loadDex(absolutePath, absolutePath + ".dex", 0);
            }
            g10.set(classLoader, sb2.toString());
            a.f(classLoader, "mPaths", strArr);
            a.f(classLoader, "mFiles", fileArr);
            a.f(classLoader, "mZips", zipFileArr);
            a.f(classLoader, "mDexs", dexFileArr);
        }
    }

    private static void d(Context context) {
        StringBuilder sb2;
        String str;
        StringBuilder sb3;
        String str2;
        File file = new File(context.getFilesDir(), "secondary-dexes");
        if (file.isDirectory()) {
            StringBuilder sb4 = new StringBuilder();
            sb4.append("Clearing old secondary dex dir (");
            sb4.append(file.getPath());
            sb4.append(").");
            File[] listFiles = file.listFiles();
            if (listFiles == null) {
                StringBuilder sb5 = new StringBuilder();
                sb5.append("Failed to list secondary dex dir content (");
                sb5.append(file.getPath());
                sb5.append(").");
                return;
            }
            for (File file2 : listFiles) {
                StringBuilder sb6 = new StringBuilder();
                sb6.append("Trying to delete old file ");
                sb6.append(file2.getPath());
                sb6.append(" of size ");
                sb6.append(file2.length());
                if (file2.delete()) {
                    sb3 = new StringBuilder();
                    str2 = "Deleted old file ";
                } else {
                    sb3 = new StringBuilder();
                    str2 = "Failed to delete old file ";
                }
                sb3.append(str2);
                sb3.append(file2.getPath());
            }
            if (file.delete()) {
                sb2 = new StringBuilder();
                str = "Deleted old secondary dex dir ";
            } else {
                sb2 = new StringBuilder();
                str = "Failed to delete secondary dex dir ";
            }
            sb2.append(str);
            sb2.append(file.getPath());
        }
    }

    private static void e(Context context, File file, File file2, String str, String str2, boolean z10) {
        Set<File> set = f12159a;
        synchronized (set) {
            if (set.contains(file)) {
                return;
            }
            set.add(file);
            int i10 = Build.VERSION.SDK_INT;
            if (i10 > 20) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("MultiDex is not guaranteed to work in SDK version ");
                sb2.append(i10);
                sb2.append(": SDK version higher than ");
                sb2.append(20);
                sb2.append(" should be backed by ");
                sb2.append("runtime with built-in multidex capabilty but it's not the ");
                sb2.append("case here: java.vm.version=\"");
                sb2.append(System.getProperty("java.vm.version"));
                sb2.append("\"");
            }
            ClassLoader j10 = j(context);
            if (j10 == null) {
                return;
            }
            try {
                d(context);
            } catch (Throwable unused) {
            }
            File k10 = k(context, file2, str);
            n0.b bVar = new n0.b(file, k10);
            IOException e10 = null;
            try {
                try {
                    m(j10, k10, bVar.H(context, str2, false));
                } catch (IOException e11) {
                    if (!z10) {
                        throw e11;
                    }
                    m(j10, k10, bVar.H(context, str2, true));
                }
                try {
                } catch (IOException e12) {
                    e10 = e12;
                }
                if (e10 != null) {
                    throw e10;
                }
            } finally {
                try {
                    bVar.close();
                } catch (IOException unused2) {
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void f(Object obj, String str, Object[] objArr) {
        Field g10 = g(obj, str);
        Object[] objArr2 = (Object[]) g10.get(obj);
        Object[] objArr3 = (Object[]) Array.newInstance(objArr2.getClass().getComponentType(), objArr2.length + objArr.length);
        System.arraycopy(objArr2, 0, objArr3, 0, objArr2.length);
        System.arraycopy(objArr, 0, objArr3, objArr2.length, objArr.length);
        g10.set(obj, objArr3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Field g(Object obj, String str) {
        for (Class<?> cls = obj.getClass(); cls != null; cls = cls.getSuperclass()) {
            try {
                Field declaredField = cls.getDeclaredField(str);
                if (!declaredField.isAccessible()) {
                    declaredField.setAccessible(true);
                }
                return declaredField;
            } catch (NoSuchFieldException unused) {
            }
        }
        throw new NoSuchFieldException("Field " + str + " not found in " + obj.getClass());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Method h(Object obj, String str, Class<?>... clsArr) {
        for (Class<?> cls = obj.getClass(); cls != null; cls = cls.getSuperclass()) {
            try {
                Method declaredMethod = cls.getDeclaredMethod(str, clsArr);
                if (!declaredMethod.isAccessible()) {
                    declaredMethod.setAccessible(true);
                }
                return declaredMethod;
            } catch (NoSuchMethodException unused) {
            }
        }
        throw new NoSuchMethodException("Method " + str + " with parameters " + Arrays.asList(clsArr) + " not found in " + obj.getClass());
    }

    private static ApplicationInfo i(Context context) {
        try {
            return context.getApplicationInfo();
        } catch (RuntimeException unused) {
            return null;
        }
    }

    private static ClassLoader j(Context context) {
        try {
            ClassLoader classLoader = context.getClassLoader();
            if (Build.VERSION.SDK_INT >= 14) {
                if (classLoader instanceof BaseDexClassLoader) {
                    return classLoader;
                }
            } else if ((classLoader instanceof DexClassLoader) || (classLoader instanceof PathClassLoader)) {
                return classLoader;
            }
            return null;
        } catch (RuntimeException unused) {
            return null;
        }
    }

    private static File k(Context context, File file, String str) {
        File file2 = new File(file, "code_cache");
        try {
            o(file2);
        } catch (IOException unused) {
            file2 = new File(context.getFilesDir(), "code_cache");
            o(file2);
        }
        File file3 = new File(file2, str);
        o(file3);
        return file3;
    }

    public static void l(Context context) {
        if (f12160b) {
            return;
        }
        int i10 = Build.VERSION.SDK_INT;
        if (i10 < 4) {
            throw new RuntimeException("MultiDex installation failed. SDK " + i10 + " is unsupported. Min SDK version is 4.");
        }
        try {
            ApplicationInfo i11 = i(context);
            if (i11 == null) {
                return;
            }
            e(context, new File(i11.sourceDir), new File(i11.dataDir), "secondary-dexes", "", true);
        } catch (Exception e10) {
            throw new RuntimeException("MultiDex installation failed (" + e10.getMessage() + ").");
        }
    }

    private static void m(ClassLoader classLoader, File file, List<? extends File> list) {
        if (list.isEmpty()) {
            return;
        }
        int i10 = Build.VERSION.SDK_INT;
        if (i10 >= 19) {
            b.a(classLoader, list, file);
        } else if (i10 >= 14) {
            C0253a.a(classLoader, list);
        } else {
            c.a(classLoader, list);
        }
    }

    static boolean n(String str) {
        boolean z10 = false;
        if (str != null) {
            StringTokenizer stringTokenizer = new StringTokenizer(str, ".");
            String nextToken = stringTokenizer.hasMoreTokens() ? stringTokenizer.nextToken() : null;
            String nextToken2 = stringTokenizer.hasMoreTokens() ? stringTokenizer.nextToken() : null;
            if (nextToken != null && nextToken2 != null) {
                try {
                    int parseInt = Integer.parseInt(nextToken);
                    int parseInt2 = Integer.parseInt(nextToken2);
                    if (parseInt > 2 || (parseInt == 2 && parseInt2 >= 1)) {
                        z10 = true;
                    }
                } catch (NumberFormatException unused) {
                }
            }
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("VM with version ");
        sb2.append(str);
        sb2.append(z10 ? " has multidex support" : " does not have multidex support");
        return z10;
    }

    private static void o(File file) {
        file.mkdir();
        if (file.isDirectory()) {
            return;
        }
        File parentFile = file.getParentFile();
        if (parentFile == null) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Failed to create dir ");
            sb2.append(file.getPath());
            sb2.append(". Parent file is null.");
        } else {
            StringBuilder sb3 = new StringBuilder();
            sb3.append("Failed to create dir ");
            sb3.append(file.getPath());
            sb3.append(". parent file is a dir ");
            sb3.append(parentFile.isDirectory());
            sb3.append(", a file ");
            sb3.append(parentFile.isFile());
            sb3.append(", exists ");
            sb3.append(parentFile.exists());
            sb3.append(", readable ");
            sb3.append(parentFile.canRead());
            sb3.append(", writable ");
            sb3.append(parentFile.canWrite());
        }
        throw new IOException("Failed to create directory " + file.getPath());
    }
}
