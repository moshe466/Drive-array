package com.google.android.gms.measurement.internal;

import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;

/* loaded from: classes.dex */
public final class r3 extends q5 {

    /* renamed from: c, reason: collision with root package name */
    private char f6365c;

    /* renamed from: d, reason: collision with root package name */
    private long f6366d;

    /* renamed from: e, reason: collision with root package name */
    private String f6367e;

    /* renamed from: f, reason: collision with root package name */
    private final t3 f6368f;

    /* renamed from: g, reason: collision with root package name */
    private final t3 f6369g;

    /* renamed from: h, reason: collision with root package name */
    private final t3 f6370h;

    /* renamed from: i, reason: collision with root package name */
    private final t3 f6371i;

    /* renamed from: j, reason: collision with root package name */
    private final t3 f6372j;

    /* renamed from: k, reason: collision with root package name */
    private final t3 f6373k;

    /* renamed from: l, reason: collision with root package name */
    private final t3 f6374l;

    /* renamed from: m, reason: collision with root package name */
    private final t3 f6375m;

    /* renamed from: n, reason: collision with root package name */
    private final t3 f6376n;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r3(t4 t4Var) {
        super(t4Var);
        this.f6365c = (char) 0;
        this.f6366d = -1L;
        this.f6368f = new t3(this, 6, false, false);
        this.f6369g = new t3(this, 6, true, false);
        this.f6370h = new t3(this, 6, false, true);
        this.f6371i = new t3(this, 5, false, false);
        this.f6372j = new t3(this, 5, true, false);
        this.f6373k = new t3(this, 5, false, true);
        this.f6374l = new t3(this, 4, false, false);
        this.f6375m = new t3(this, 3, false, false);
        this.f6376n = new t3(this, 2, false, false);
    }

    private static String E(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        int lastIndexOf = str.lastIndexOf(46);
        return lastIndexOf == -1 ? str : str.substring(0, lastIndexOf);
    }

    private final String P() {
        String str;
        synchronized (this) {
            if (this.f6367e == null) {
                this.f6367e = this.f6381a.M() != null ? this.f6381a.M() : "FA";
            }
            str = this.f6367e;
        }
        return str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static Object x(String str) {
        if (str == null) {
            return null;
        }
        return new w3(str);
    }

    private static String y(boolean z10, Object obj) {
        String str;
        String className;
        if (obj == null) {
            return "";
        }
        if (obj instanceof Integer) {
            obj = Long.valueOf(((Integer) obj).intValue());
        }
        int i10 = 0;
        if (obj instanceof Long) {
            if (!z10) {
                return String.valueOf(obj);
            }
            Long l10 = (Long) obj;
            if (Math.abs(l10.longValue()) < 100) {
                return String.valueOf(obj);
            }
            String str2 = String.valueOf(obj).charAt(0) == '-' ? "-" : "";
            String valueOf = String.valueOf(Math.abs(l10.longValue()));
            long round = Math.round(Math.pow(10.0d, valueOf.length() - 1));
            long round2 = Math.round(Math.pow(10.0d, valueOf.length()) - 1.0d);
            StringBuilder sb2 = new StringBuilder(str2.length() + 43 + str2.length());
            sb2.append(str2);
            sb2.append(round);
            sb2.append("...");
            sb2.append(str2);
            sb2.append(round2);
            return sb2.toString();
        }
        if (obj instanceof Boolean) {
            return String.valueOf(obj);
        }
        if (!(obj instanceof Throwable)) {
            if (!(obj instanceof w3)) {
                return z10 ? "-" : String.valueOf(obj);
            }
            str = ((w3) obj).f6585a;
            return str;
        }
        Throwable th = (Throwable) obj;
        StringBuilder sb3 = new StringBuilder(z10 ? th.getClass().getName() : th.toString());
        String E = E(t4.class.getCanonicalName());
        StackTraceElement[] stackTrace = th.getStackTrace();
        int length = stackTrace.length;
        while (true) {
            if (i10 >= length) {
                break;
            }
            StackTraceElement stackTraceElement = stackTrace[i10];
            if (!stackTraceElement.isNativeMethod() && (className = stackTraceElement.getClassName()) != null && E(className).equals(E)) {
                sb3.append(": ");
                sb3.append(stackTraceElement);
                break;
            }
            i10++;
        }
        return sb3.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String z(boolean z10, String str, Object obj, Object obj2, Object obj3) {
        String str2 = "";
        if (str == null) {
            str = "";
        }
        String y10 = y(z10, obj);
        String y11 = y(z10, obj2);
        String y12 = y(z10, obj3);
        StringBuilder sb2 = new StringBuilder();
        if (!TextUtils.isEmpty(str)) {
            sb2.append(str);
            str2 = ": ";
        }
        String str3 = ", ";
        if (!TextUtils.isEmpty(y10)) {
            sb2.append(str2);
            sb2.append(y10);
            str2 = ", ";
        }
        if (TextUtils.isEmpty(y11)) {
            str3 = str2;
        } else {
            sb2.append(str2);
            sb2.append(y11);
        }
        if (!TextUtils.isEmpty(y12)) {
            sb2.append(str3);
            sb2.append(y12);
        }
        return sb2.toString();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void A(int i10, String str) {
        Log.println(i10, P(), str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void B(int i10, boolean z10, boolean z11, String str, Object obj, Object obj2, Object obj3) {
        String str2;
        if (!z10 && C(i10)) {
            A(i10, z(false, str, obj, obj2, obj3));
        }
        if (z11 || i10 < 5) {
            return;
        }
        b2.p.k(str);
        q4 E = this.f6381a.E();
        if (E == null) {
            str2 = "Scheduler not set. Not logging error/warn";
        } else {
            if (E.p()) {
                if (i10 < 0) {
                    i10 = 0;
                }
                E.z(new u3(this, i10 >= 9 ? 8 : i10, str, obj, obj2, obj3));
                return;
            }
            str2 = "Scheduler not initialized. Not logging error/warn";
        }
        A(6, str2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean C(int i10) {
        return Log.isLoggable(P(), i10);
    }

    public final t3 F() {
        return this.f6368f;
    }

    public final t3 G() {
        return this.f6369g;
    }

    public final t3 H() {
        return this.f6370h;
    }

    public final t3 I() {
        return this.f6371i;
    }

    public final t3 J() {
        return this.f6372j;
    }

    public final t3 K() {
        return this.f6373k;
    }

    public final t3 L() {
        return this.f6374l;
    }

    public final t3 M() {
        return this.f6375m;
    }

    public final t3 N() {
        return this.f6376n;
    }

    public final String O() {
        Pair<String, Long> a10 = l().f5957d.a();
        if (a10 == null || a10 == e4.D) {
            return null;
        }
        String valueOf = String.valueOf(a10.second);
        String str = (String) a10.first;
        StringBuilder sb2 = new StringBuilder(valueOf.length() + 1 + String.valueOf(str).length());
        sb2.append(valueOf);
        sb2.append(":");
        sb2.append(str);
        return sb2.toString();
    }

    @Override // com.google.android.gms.measurement.internal.q5
    protected final boolean t() {
        return false;
    }
}
