package ic;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.concurrent.LinkedBlockingQueue;
import kc.f;
import kc.g;
import kc.h;
import org.slf4j.impl.StaticLoggerBinder;

/* loaded from: classes.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    static volatile int f10843a;

    /* renamed from: b, reason: collision with root package name */
    static final g f10844b = new g();

    /* renamed from: c, reason: collision with root package name */
    static final kc.d f10845c = new kc.d();

    /* renamed from: d, reason: collision with root package name */
    private static final String[] f10846d;

    /* renamed from: e, reason: collision with root package name */
    private static String f10847e;

    static {
        h.c("slf4j.detectLoggerNameMismatch");
        f10846d = new String[]{"1.6", "1.7"};
        f10847e = "org/slf4j/impl/StaticLoggerBinder.class";
    }

    private c() {
    }

    private static final void a() {
        Set<URL> set = null;
        try {
            try {
                if (!k()) {
                    set = f();
                    r(set);
                }
                StaticLoggerBinder.getSingleton();
                f10843a = 3;
                q(set);
            } catch (Exception e10) {
                e(e10);
                throw new IllegalStateException("Unexpected initialization failure", e10);
            } catch (NoClassDefFoundError e11) {
                if (!l(e11.getMessage())) {
                    e(e11);
                    throw e11;
                }
                f10843a = 4;
                h.a("Failed to load class \"org.slf4j.impl.StaticLoggerBinder\".");
                h.a("Defaulting to no-operation (NOP) logger implementation");
                h.a("See http://www.slf4j.org/codes.html#StaticLoggerBinder for further details.");
            } catch (NoSuchMethodError e12) {
                String message = e12.getMessage();
                if (message != null && message.contains("org.slf4j.impl.StaticLoggerBinder.getSingleton()")) {
                    f10843a = 2;
                    h.a("slf4j-api 1.6.x (or later) is incompatible with this binding.");
                    h.a("Your binding is version 1.5.5 or earlier.");
                    h.a("Upgrade your binding to version 1.6.x.");
                }
                throw e12;
            }
        } finally {
            n();
        }
    }

    private static void b(jc.d dVar, int i10) {
        if (dVar.a().j()) {
            c(i10);
        } else {
            if (dVar.a().k()) {
                return;
            }
            d();
        }
    }

    private static void c(int i10) {
        h.a("A number (" + i10 + ") of logging calls during the initialization phase have been intercepted and are");
        h.a("now being replayed. These are subject to the filtering rules of the underlying logging system.");
        h.a("See also http://www.slf4j.org/codes.html#replay");
    }

    private static void d() {
        h.a("The following set of substitute loggers may have been accessed");
        h.a("during the initialization phase. Logging calls during this");
        h.a("phase were not honored. However, subsequent logging calls to these");
        h.a("loggers will work as normally expected.");
        h.a("See also http://www.slf4j.org/codes.html#substituteLogger");
    }

    static void e(Throwable th) {
        f10843a = 2;
        h.b("Failed to instantiate SLF4J LoggerFactory", th);
    }

    static Set<URL> f() {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        try {
            ClassLoader classLoader = c.class.getClassLoader();
            Enumeration<URL> systemResources = classLoader == null ? ClassLoader.getSystemResources(f10847e) : classLoader.getResources(f10847e);
            while (systemResources.hasMoreElements()) {
                linkedHashSet.add(systemResources.nextElement());
            }
        } catch (IOException e10) {
            h.b("Error getting resources from path", e10);
        }
        return linkedHashSet;
    }

    private static void g() {
        g gVar = f10844b;
        synchronized (gVar) {
            gVar.e();
            for (f fVar : gVar.d()) {
                fVar.n(i(fVar.i()));
            }
        }
    }

    public static a h() {
        if (f10843a == 0) {
            synchronized (c.class) {
                if (f10843a == 0) {
                    f10843a = 1;
                    m();
                }
            }
        }
        int i10 = f10843a;
        if (i10 == 1) {
            return f10844b;
        }
        if (i10 == 2) {
            throw new IllegalStateException("org.slf4j.LoggerFactory in failed state. Original exception was thrown EARLIER. See also http://www.slf4j.org/codes.html#unsuccessfulInit");
        }
        if (i10 == 3) {
            return StaticLoggerBinder.getSingleton().getLoggerFactory();
        }
        if (i10 == 4) {
            return f10845c;
        }
        throw new IllegalStateException("Unreachable code");
    }

    public static b i(String str) {
        return h().a(str);
    }

    private static boolean j(Set<URL> set) {
        return set.size() > 1;
    }

    private static boolean k() {
        String d10 = h.d("java.vendor.url");
        if (d10 == null) {
            return false;
        }
        return d10.toLowerCase().contains("android");
    }

    private static boolean l(String str) {
        if (str == null) {
            return false;
        }
        return str.contains("org/slf4j/impl/StaticLoggerBinder") || str.contains("org.slf4j.impl.StaticLoggerBinder");
    }

    private static final void m() {
        a();
        if (f10843a == 3) {
            s();
        }
    }

    private static void n() {
        g();
        o();
        f10844b.b();
    }

    private static void o() {
        LinkedBlockingQueue<jc.d> c10 = f10844b.c();
        int size = c10.size();
        ArrayList<jc.d> arrayList = new ArrayList(128);
        int i10 = 0;
        while (c10.drainTo(arrayList, 128) != 0) {
            for (jc.d dVar : arrayList) {
                p(dVar);
                int i11 = i10 + 1;
                if (i10 == 0) {
                    b(dVar, size);
                }
                i10 = i11;
            }
            arrayList.clear();
        }
    }

    private static void p(jc.d dVar) {
        if (dVar == null) {
            return;
        }
        f a10 = dVar.a();
        String i10 = a10.i();
        if (a10.l()) {
            throw new IllegalStateException("Delegate logger cannot be null at this state.");
        }
        if (a10.k()) {
            return;
        }
        if (a10.j()) {
            a10.m(dVar);
        } else {
            h.a(i10);
        }
    }

    private static void q(Set<URL> set) {
        if (set == null || !j(set)) {
            return;
        }
        h.a("Actual binding is of type [" + StaticLoggerBinder.getSingleton().getLoggerFactoryClassStr() + "]");
    }

    private static void r(Set<URL> set) {
        if (j(set)) {
            h.a("Class path contains multiple SLF4J bindings.");
            Iterator<URL> it = set.iterator();
            while (it.hasNext()) {
                h.a("Found binding in [" + it.next() + "]");
            }
            h.a("See http://www.slf4j.org/codes.html#multiple_bindings for an explanation.");
        }
    }

    private static final void s() {
        try {
            String str = StaticLoggerBinder.REQUESTED_API_VERSION;
            boolean z10 = false;
            for (String str2 : f10846d) {
                if (str.startsWith(str2)) {
                    z10 = true;
                }
            }
            if (z10) {
                return;
            }
            h.a("The requested version " + str + " by your slf4j binding is not compatible with " + Arrays.asList(f10846d).toString());
            h.a("See http://www.slf4j.org/codes.html#version_mismatch for further details.");
        } catch (NoSuchFieldError unused) {
        } catch (Throwable th) {
            h.b("Unexpected problem occured during version sanity check", th);
        }
    }
}
