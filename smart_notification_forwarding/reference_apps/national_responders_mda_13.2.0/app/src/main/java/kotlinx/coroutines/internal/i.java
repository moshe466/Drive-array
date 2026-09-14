package kotlinx.coroutines.internal;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.ServiceLoader;
import java.util.Set;
import java.util.jar.JarFile;
import java.util.zip.ZipEntry;

/* loaded from: classes.dex */
public final class i {

    /* renamed from: a, reason: collision with root package name */
    public static final i f11628a = new i();

    private i() {
    }

    private final <S> S a(String str, ClassLoader classLoader, Class<S> cls) {
        Class<?> cls2 = Class.forName(str, false, classLoader);
        if (cls.isAssignableFrom(cls2)) {
            return cls.cast(cls2.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]));
        }
        throw new IllegalArgumentException(("Expected service of class " + cls + ", but found " + cls2).toString());
    }

    private final <S> List<S> b(Class<S> cls, ClassLoader classLoader) {
        List<S> n02;
        try {
            return d(cls, classLoader);
        } catch (Throwable unused) {
            n02 = m8.y.n0(ServiceLoader.load(cls, classLoader));
            return n02;
        }
    }

    private final List<String> e(URL url) {
        boolean w10;
        BufferedReader bufferedReader;
        String a02;
        String f02;
        String a03;
        String url2 = url.toString();
        w10 = mb.r.w(url2, "jar", false, 2, null);
        if (!w10) {
            bufferedReader = new BufferedReader(new InputStreamReader(url.openStream()));
            try {
                List<String> f10 = f11628a.f(bufferedReader);
                v8.a.a(bufferedReader, null);
                return f10;
            } catch (Throwable th) {
                try {
                    throw th;
                } finally {
                }
            }
        }
        a02 = mb.s.a0(url2, "jar:file:", null, 2, null);
        f02 = mb.s.f0(a02, '!', null, 2, null);
        a03 = mb.s.a0(url2, "!/", null, 2, null);
        JarFile jarFile = new JarFile(f02, false);
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(jarFile.getInputStream(new ZipEntry(a03)), "UTF-8"));
            try {
                List<String> f11 = f11628a.f(bufferedReader);
                v8.a.a(bufferedReader, null);
                jarFile.close();
                return f11;
            } finally {
            }
        } catch (Throwable th2) {
            try {
                throw th2;
            } catch (Throwable th3) {
                try {
                    jarFile.close();
                    throw th3;
                } catch (Throwable th4) {
                    l8.b.a(th2, th4);
                    throw th2;
                }
            }
        }
    }

    private final List<String> f(BufferedReader bufferedReader) {
        List<String> n02;
        String g02;
        CharSequence j02;
        boolean z10;
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        while (true) {
            String readLine = bufferedReader.readLine();
            if (readLine == null) {
                n02 = m8.y.n0(linkedHashSet);
                return n02;
            }
            g02 = mb.s.g0(readLine, "#", null, 2, null);
            j02 = mb.s.j0(g02);
            String obj = j02.toString();
            int i10 = 0;
            while (true) {
                if (i10 >= obj.length()) {
                    z10 = true;
                    break;
                }
                char charAt = obj.charAt(i10);
                i10++;
                if (!(charAt == '.' || Character.isJavaIdentifierPart(charAt))) {
                    z10 = false;
                    break;
                }
            }
            if (!z10) {
                throw new IllegalArgumentException(y8.k.j("Illegal service provider class name: ", obj).toString());
            }
            if (obj.length() > 0) {
                linkedHashSet.add(obj);
            }
        }
    }

    public final List<r> c() {
        r rVar;
        if (!j.a()) {
            return b(r.class, r.class.getClassLoader());
        }
        try {
            ArrayList arrayList = new ArrayList(2);
            r rVar2 = null;
            try {
                rVar = (r) r.class.cast(Class.forName("kotlinx.coroutines.android.AndroidDispatcherFactory", true, r.class.getClassLoader()).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]));
            } catch (ClassNotFoundException unused) {
                rVar = null;
            }
            if (rVar != null) {
                arrayList.add(rVar);
            }
            try {
                rVar2 = (r) r.class.cast(Class.forName("kotlinx.coroutines.test.internal.TestMainDispatcherFactory", true, r.class.getClassLoader()).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]));
            } catch (ClassNotFoundException unused2) {
            }
            if (rVar2 == null) {
                return arrayList;
            }
            arrayList.add(rVar2);
            return arrayList;
        } catch (Throwable unused3) {
            return b(r.class, r.class.getClassLoader());
        }
    }

    public final <S> List<S> d(Class<S> cls, ClassLoader classLoader) {
        Set r02;
        int n10;
        ArrayList list = Collections.list(classLoader.getResources(y8.k.j("META-INF/services/", cls.getName())));
        y8.k.d(list, "list(this)");
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            m8.v.r(arrayList, f11628a.e((URL) it.next()));
        }
        r02 = m8.y.r0(arrayList);
        if (!(!r02.isEmpty())) {
            throw new IllegalArgumentException("No providers were loaded with FastServiceLoader".toString());
        }
        n10 = m8.r.n(r02, 10);
        ArrayList arrayList2 = new ArrayList(n10);
        Iterator it2 = r02.iterator();
        while (it2.hasNext()) {
            arrayList2.add(f11628a.a((String) it2.next(), classLoader, cls));
        }
        return arrayList2;
    }
}
