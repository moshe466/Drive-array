package k2;

import android.os.Looper;

/* loaded from: classes.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    private static volatile ClassLoader f11193a;

    /* renamed from: b, reason: collision with root package name */
    private static volatile Thread f11194b;

    public static synchronized ClassLoader a() {
        ClassLoader classLoader;
        synchronized (b.class) {
            if (f11193a == null) {
                f11193a = b();
            }
            classLoader = f11193a;
        }
        return classLoader;
    }

    private static synchronized ClassLoader b() {
        synchronized (b.class) {
            ClassLoader classLoader = null;
            if (f11194b == null) {
                f11194b = c();
                if (f11194b == null) {
                    return null;
                }
            }
            synchronized (f11194b) {
                try {
                    classLoader = f11194b.getContextClassLoader();
                } catch (SecurityException e10) {
                    String message = e10.getMessage();
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("Failed to get thread context classloader ");
                    sb2.append(message);
                }
            }
            return classLoader;
        }
    }

    private static synchronized Thread c() {
        SecurityException e10;
        Thread thread;
        Thread thread2;
        ThreadGroup threadGroup;
        synchronized (b.class) {
            ThreadGroup threadGroup2 = Looper.getMainLooper().getThread().getThreadGroup();
            if (threadGroup2 == null) {
                return null;
            }
            synchronized (Void.class) {
                try {
                    int activeGroupCount = threadGroup2.activeGroupCount();
                    ThreadGroup[] threadGroupArr = new ThreadGroup[activeGroupCount];
                    threadGroup2.enumerate(threadGroupArr);
                    int i10 = 0;
                    int i11 = 0;
                    while (true) {
                        if (i11 >= activeGroupCount) {
                            threadGroup = null;
                            break;
                        }
                        threadGroup = threadGroupArr[i11];
                        if ("dynamiteLoader".equals(threadGroup.getName())) {
                            break;
                        }
                        i11++;
                    }
                    if (threadGroup == null) {
                        threadGroup = new ThreadGroup(threadGroup2, "dynamiteLoader");
                    }
                    int activeCount = threadGroup.activeCount();
                    Thread[] threadArr = new Thread[activeCount];
                    threadGroup.enumerate(threadArr);
                    while (true) {
                        if (i10 >= activeCount) {
                            thread2 = null;
                            break;
                        }
                        thread2 = threadArr[i10];
                        if ("GmsDynamite".equals(thread2.getName())) {
                            break;
                        }
                        i10++;
                    }
                } catch (SecurityException e11) {
                    e10 = e11;
                    thread = null;
                }
                if (thread2 == null) {
                    try {
                        thread = new a(threadGroup, "GmsDynamite");
                        try {
                            thread.setContextClassLoader(null);
                            thread.start();
                        } catch (SecurityException e12) {
                            e10 = e12;
                            String message = e10.getMessage();
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append("Failed to enumerate thread/threadgroup ");
                            sb2.append(message);
                            thread2 = thread;
                            return thread2;
                        }
                    } catch (SecurityException e13) {
                        e10 = e13;
                        thread = thread2;
                    }
                    thread2 = thread;
                }
            }
            return thread2;
        }
    }
}
