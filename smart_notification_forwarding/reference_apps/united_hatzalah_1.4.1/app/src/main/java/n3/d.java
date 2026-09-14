package n3;

import T.k;
import androidx.lifecycle.N;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.ServiceConfigurationError;
import java.util.ServiceLoader;
import java.util.concurrent.LinkedBlockingQueue;
import p3.e;
import p3.f;
import p3.g;
import p3.h;

/* loaded from: classes.dex */
public abstract class d {

    /* renamed from: a, reason: collision with root package name */
    public static volatile int f5889a;

    /* renamed from: b, reason: collision with root package name */
    public static final p3.c f5890b = new p3.c(1);

    /* renamed from: c, reason: collision with root package name */
    public static final p3.c f5891c = new p3.c(0);

    /* renamed from: d, reason: collision with root package name */
    public static final boolean f5892d;

    /* renamed from: e, reason: collision with root package name */
    public static volatile p3.c f5893e;

    /* renamed from: f, reason: collision with root package name */
    public static final String[] f5894f;

    static {
        String str;
        boolean equalsIgnoreCase;
        try {
            str = System.getProperty("slf4j.detectLoggerNameMismatch");
        } catch (SecurityException unused) {
            str = null;
        }
        if (str == null) {
            equalsIgnoreCase = false;
        } else {
            equalsIgnoreCase = str.equalsIgnoreCase("true");
        }
        f5892d = equalsIgnoreCase;
        f5894f = new String[]{"2.0"};
    }

    public static ArrayList a() {
        ServiceLoader serviceLoader;
        ArrayList arrayList = new ArrayList();
        final ClassLoader classLoader = d.class.getClassLoader();
        String property = System.getProperty("slf4j.provider");
        p3.c cVar = null;
        if (property != null && !property.isEmpty()) {
            try {
                String str = "Attempting to load provider \"" + property + "\" specified via \"slf4j.provider\" system property";
                int i = p3.d.f5976a;
                if (k.b(2) >= k.b(p3.d.f5977b)) {
                    p3.d.b().println("SLF4J(I): " + str);
                }
                cVar = (p3.c) classLoader.loadClass(property).getConstructor(null).newInstance(null);
            } catch (ClassCastException e4) {
                p3.d.a("Specified SLF4JServiceProvider (" + property + ") does not implement SLF4JServiceProvider interface", e4);
            } catch (ClassNotFoundException e5) {
                e = e5;
                p3.d.a("Failed to instantiate the specified SLF4JServiceProvider (" + property + ")", e);
            } catch (IllegalAccessException e6) {
                e = e6;
                p3.d.a("Failed to instantiate the specified SLF4JServiceProvider (" + property + ")", e);
            } catch (InstantiationException e7) {
                e = e7;
                p3.d.a("Failed to instantiate the specified SLF4JServiceProvider (" + property + ")", e);
            } catch (NoSuchMethodException e8) {
                e = e8;
                p3.d.a("Failed to instantiate the specified SLF4JServiceProvider (" + property + ")", e);
            } catch (InvocationTargetException e9) {
                e = e9;
                p3.d.a("Failed to instantiate the specified SLF4JServiceProvider (" + property + ")", e);
            }
        }
        if (cVar != null) {
            arrayList.add(cVar);
            return arrayList;
        }
        if (System.getSecurityManager() == null) {
            serviceLoader = ServiceLoader.load(p3.c.class, classLoader);
        } else {
            serviceLoader = (ServiceLoader) AccessController.doPrivileged(new PrivilegedAction() { // from class: n3.c
                @Override // java.security.PrivilegedAction
                public final Object run() {
                    return ServiceLoader.load(p3.c.class, classLoader);
                }
            });
        }
        Iterator it = serviceLoader.iterator();
        while (it.hasNext()) {
            try {
                arrayList.add((p3.c) it.next());
            } catch (ServiceConfigurationError e10) {
                String str2 = "A service provider failed to instantiate:\n" + e10.getMessage();
                p3.d.b().println("SLF4J(E): " + str2);
            }
        }
        return arrayList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v8, types: [java.lang.SecurityManager] */
    public static b b(Class cls) {
        int i;
        g gVar;
        b c4 = c(cls.getName());
        if (f5892d) {
            g gVar2 = h.f5988a;
            Class cls2 = null;
            g gVar3 = gVar2;
            if (gVar2 == null) {
                if (h.f5989b) {
                    gVar3 = null;
                } else {
                    try {
                        gVar = new SecurityManager();
                    } catch (SecurityException unused) {
                        gVar = null;
                    }
                    h.f5988a = gVar;
                    h.f5989b = true;
                    gVar3 = gVar;
                }
            }
            if (gVar3 != null) {
                Class[] classContext = gVar3.getClassContext();
                String name = h.class.getName();
                int i3 = 0;
                while (i3 < classContext.length && !name.equals(classContext[i3].getName())) {
                    i3++;
                }
                if (i3 < classContext.length && (i = i3 + 2) < classContext.length) {
                    cls2 = classContext[i];
                } else {
                    throw new IllegalStateException("Failed to find org.slf4j.helpers.Util or its caller in the stack; this should not happen");
                }
            }
            if (cls2 != null && !cls2.isAssignableFrom(cls)) {
                p3.d.c("Detected logger name mismatch. Given name: \"" + c4.getName() + "\"; computed name: \"" + cls2.getName() + "\".");
                p3.d.c("See https://www.slf4j.org/codes.html#loggerNameMismatch for an explanation");
            }
        }
        return c4;
    }

    public static b c(String str) {
        p3.c cVar;
        a aVar;
        if (f5889a == 0) {
            synchronized (d.class) {
                try {
                    if (f5889a == 0) {
                        f5889a = 1;
                        d();
                    }
                } finally {
                }
            }
        }
        int i = f5889a;
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    if (i == 4) {
                        cVar = f5891c;
                    } else {
                        throw new IllegalStateException("Unreachable code");
                    }
                } else {
                    cVar = f5893e;
                }
            } else {
                throw new IllegalStateException("org.slf4j.LoggerFactory in failed state. Original exception was thrown EARLIER. See also https://www.slf4j.org/codes.html#unsuccessfulInit");
            }
        } else {
            cVar = f5890b;
        }
        switch (cVar.f5974a) {
            case 0:
                aVar = (N) cVar.f5975b;
                break;
            default:
                aVar = (f) cVar.f5975b;
                break;
        }
        return aVar.a(str);
    }

    public static final void d() {
        Enumeration<URL> resources;
        try {
            ArrayList a2 = a();
            h(a2);
            if (!a2.isEmpty()) {
                f5893e = (p3.c) a2.get(0);
                f5893e.getClass();
                f5893e.getClass();
                f5889a = 3;
                f(a2);
            } else {
                f5889a = 4;
                p3.d.c("No SLF4J providers were found.");
                p3.d.c("Defaulting to no-operation (NOP) logger implementation");
                p3.d.c("See https://www.slf4j.org/codes.html#noProviders for further details.");
                LinkedHashSet linkedHashSet = new LinkedHashSet();
                try {
                    ClassLoader classLoader = d.class.getClassLoader();
                    if (classLoader == null) {
                        resources = ClassLoader.getSystemResources("org/slf4j/impl/StaticLoggerBinder.class");
                    } else {
                        resources = classLoader.getResources("org/slf4j/impl/StaticLoggerBinder.class");
                    }
                    while (resources.hasMoreElements()) {
                        linkedHashSet.add(resources.nextElement());
                    }
                } catch (IOException e4) {
                    p3.d.a("Error getting resources from path", e4);
                }
                g(linkedHashSet);
            }
            e();
            if (f5889a == 3) {
                try {
                    switch (f5893e.f5974a) {
                        case 0:
                            boolean z3 = false;
                            for (String str : f5894f) {
                                if ("2.0.99".startsWith(str)) {
                                    z3 = true;
                                }
                            }
                            if (!z3) {
                                p3.d.c("The requested version 2.0.99 by your slf4j provider is not compatible with " + Arrays.asList(f5894f).toString());
                                p3.d.c("See https://www.slf4j.org/codes.html#version_mismatch for further details.");
                                return;
                            }
                            return;
                        default:
                            throw new UnsupportedOperationException();
                    }
                } catch (Throwable th) {
                    p3.d.a("Unexpected problem occurred during version sanity check", th);
                }
            }
        } catch (Exception e5) {
            f5889a = 2;
            p3.d.a("Failed to instantiate SLF4J LoggerFactory", e5);
            throw new IllegalStateException("Unexpected initialization failure", e5);
        }
    }

    public static void e() {
        p3.c cVar = f5890b;
        synchronized (cVar) {
            try {
                ((f) cVar.f5975b).f5985a = true;
                f fVar = (f) cVar.f5975b;
                fVar.getClass();
                ArrayList arrayList = new ArrayList(fVar.f5986b.values());
                int size = arrayList.size();
                int i = 0;
                while (i < size) {
                    Object obj = arrayList.get(i);
                    i++;
                    e eVar = (e) obj;
                    eVar.f5979b = c(eVar.f5978a);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        LinkedBlockingQueue linkedBlockingQueue = ((f) f5890b.f5975b).f5987c;
        int size2 = linkedBlockingQueue.size();
        ArrayList arrayList2 = new ArrayList(128);
        int i3 = 0;
        while (linkedBlockingQueue.drainTo(arrayList2, 128) != 0) {
            int size3 = arrayList2.size();
            int i4 = 0;
            while (i4 < size3) {
                Object obj2 = arrayList2.get(i4);
                i4++;
                o3.b bVar = (o3.b) obj2;
                if (bVar != null) {
                    e eVar2 = bVar.f5956b;
                    String str = eVar2.f5978a;
                    if (eVar2.f5979b != null) {
                        if (!(eVar2.f5979b instanceof p3.b)) {
                            if (eVar2.B()) {
                                if (eVar2.w(bVar.f5955a) && eVar2.B()) {
                                    try {
                                        eVar2.f5981d.invoke(eVar2.f5979b, bVar);
                                    } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException unused) {
                                    }
                                }
                            } else {
                                p3.d.c(str);
                            }
                        }
                    } else {
                        throw new IllegalStateException("Delegate logger cannot be null at this state.");
                    }
                }
                int i5 = i3 + 1;
                if (i3 == 0) {
                    if (bVar.f5956b.B()) {
                        p3.d.c("A number (" + size2 + ") of logging calls during the initialization phase have been intercepted and are");
                        p3.d.c("now being replayed. These are subject to the filtering rules of the underlying logging system.");
                        p3.d.c("See also https://www.slf4j.org/codes.html#replay");
                    } else if (!(bVar.f5956b.f5979b instanceof p3.b)) {
                        p3.d.c("The following set of substitute loggers may have been accessed");
                        p3.d.c("during the initialization phase. Logging calls during this");
                        p3.d.c("phase were not honored. However, subsequent logging calls to these");
                        p3.d.c("loggers will work as normally expected.");
                        p3.d.c("See also https://www.slf4j.org/codes.html#substituteLogger");
                    }
                }
                i3 = i5;
            }
            arrayList2.clear();
        }
        f fVar2 = (f) f5890b.f5975b;
        fVar2.f5986b.clear();
        fVar2.f5987c.clear();
    }

    public static void f(ArrayList arrayList) {
        if (!arrayList.isEmpty()) {
            if (arrayList.size() > 1) {
                String str = "Actual provider is of type [" + arrayList.get(0) + "]";
                int i = p3.d.f5976a;
                if (k.b(2) >= k.b(p3.d.f5977b)) {
                    p3.d.b().println("SLF4J(I): " + str);
                    return;
                }
                return;
            }
            String str2 = "Connected with provider of type [" + ((p3.c) arrayList.get(0)).getClass().getName() + "]";
            int i3 = p3.d.f5976a;
            if (k.b(1) >= k.b(p3.d.f5977b)) {
                p3.d.b().println("SLF4J(D): " + str2);
                return;
            }
            return;
        }
        throw new IllegalStateException("No providers were found which is impossible after successful initialization.");
    }

    public static void g(LinkedHashSet linkedHashSet) {
        if (linkedHashSet.isEmpty()) {
            return;
        }
        p3.d.c("Class path contains SLF4J bindings targeting slf4j-api versions 1.7.x or earlier.");
        Iterator it = linkedHashSet.iterator();
        while (it.hasNext()) {
            p3.d.c("Ignoring binding found at [" + ((URL) it.next()) + "]");
        }
        p3.d.c("See https://www.slf4j.org/codes.html#ignoredBindings for an explanation.");
    }

    public static void h(ArrayList arrayList) {
        if (arrayList.size() > 1) {
            p3.d.c("Class path contains multiple SLF4J providers.");
            int size = arrayList.size();
            int i = 0;
            while (i < size) {
                Object obj = arrayList.get(i);
                i++;
                p3.d.c("Found provider [" + ((p3.c) obj) + "]");
            }
            p3.d.c("See https://www.slf4j.org/codes.html#multiple_bindings for an explanation.");
        }
    }
}
