package com.opentok.android;

/* loaded from: classes.dex */
public class j {

    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private final String f8596a;

        /* renamed from: b, reason: collision with root package name */
        private final boolean f8597b;

        /* renamed from: c, reason: collision with root package name */
        private Object f8598c;

        public a() {
            this("[" + d() + "]", true);
        }

        public a(Object obj) {
            this("[" + obj.getClass().getCanonicalName() + "]", true);
            this.f8598c = obj;
        }

        public a(String str, boolean z10) {
            this.f8598c = null;
            this.f8596a = str;
            this.f8597b = z10 & false;
        }

        private String a(String str) {
            if (this.f8598c == null) {
                return str;
            }
            return str + " [" + this.f8598c.toString() + "] (" + System.currentTimeMillis() + ") {" + Thread.currentThread().getName() + "}";
        }

        private static String d() {
            StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
            String name = j.class.getName();
            String name2 = a.class.getName();
            boolean z10 = false;
            for (StackTraceElement stackTraceElement : stackTrace) {
                if (!z10 && stackTraceElement.getClassName().equals(name2)) {
                    z10 = true;
                } else if (z10 && !stackTraceElement.getClassName().equals(name2) && !stackTraceElement.getClassName().equals(name)) {
                    try {
                        return Class.forName(stackTraceElement.getClassName()).getSimpleName();
                    } catch (ClassNotFoundException unused) {
                        return stackTraceElement.getClassName();
                    }
                }
            }
            return name;
        }

        public void b(String str, Object... objArr) {
            if (this.f8597b) {
                a(String.format(str, objArr));
            }
        }

        public void c(String str, Object... objArr) {
            if (this.f8597b) {
                a(String.format(str, objArr));
            }
        }

        public void e(String str, Object... objArr) {
            if (this.f8597b) {
                a(String.format(str, objArr));
            }
        }

        public void f(String str, Object... objArr) {
            if (this.f8597b) {
                a(String.format(str, objArr));
            }
        }
    }

    public static a a(String str) {
        return new a(str, true);
    }
}
