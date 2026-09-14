package com.google.android.gms.internal.measurement;

import android.content.Context;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes.dex */
public abstract class t2<T> {

    /* renamed from: g, reason: collision with root package name */
    private static final Object f5602g = new Object();

    /* renamed from: h, reason: collision with root package name */
    private static volatile b3 f5603h;

    /* renamed from: i, reason: collision with root package name */
    private static c3 f5604i;

    /* renamed from: j, reason: collision with root package name */
    private static final AtomicInteger f5605j;

    /* renamed from: a, reason: collision with root package name */
    private final y2 f5606a;

    /* renamed from: b, reason: collision with root package name */
    private final String f5607b;

    /* renamed from: c, reason: collision with root package name */
    private final T f5608c;

    /* renamed from: d, reason: collision with root package name */
    private volatile int f5609d;

    /* renamed from: e, reason: collision with root package name */
    private volatile T f5610e;

    /* renamed from: f, reason: collision with root package name */
    private final boolean f5611f;

    static {
        new AtomicReference();
        f5604i = new c3(v2.f5633a);
        f5605j = new AtomicInteger();
    }

    private t2(y2 y2Var, String str, T t10, boolean z10) {
        this.f5609d = -1;
        if (y2Var.f5701a == null) {
            throw new IllegalArgumentException("Must pass a valid SharedPreferences file name or ContentProvider URI");
        }
        this.f5606a = y2Var;
        this.f5607b = str;
        this.f5608c = t10;
        this.f5611f = z10;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ t2(y2 y2Var, String str, Object obj, boolean z10, u2 u2Var) {
        this(y2Var, str, obj, z10);
    }

    private final String f(String str) {
        if (str != null && str.isEmpty()) {
            return this.f5607b;
        }
        String valueOf = String.valueOf(str);
        String valueOf2 = String.valueOf(this.f5607b);
        return valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void g() {
        f5605j.incrementAndGet();
    }

    @Deprecated
    public static void h(final Context context) {
        synchronized (f5602g) {
            b3 b3Var = f5603h;
            Context applicationContext = context.getApplicationContext();
            if (applicationContext != null) {
                context = applicationContext;
            }
            if (b3Var == null || b3Var.a() != context) {
                e2.d();
                a3.b();
                j2.b();
                f5603h = new b2(context, r3.a(new o3(context) { // from class: com.google.android.gms.internal.measurement.s2

                    /* renamed from: f, reason: collision with root package name */
                    private final Context f5582f;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        this.f5582f = context;
                    }

                    @Override // com.google.android.gms.internal.measurement.o3
                    public final Object zza() {
                        return t2.m(this.f5582f);
                    }
                }));
                f5605j.incrementAndGet();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static t2<Double> i(y2 y2Var, String str, double d10, boolean z10) {
        return new w2(y2Var, str, Double.valueOf(-3.0d), true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static t2<Long> j(y2 y2Var, String str, long j10, boolean z10) {
        return new u2(y2Var, str, Long.valueOf(j10), true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static t2<String> k(y2 y2Var, String str, String str2, boolean z10) {
        return new z2(y2Var, str, str2, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static t2<Boolean> l(y2 y2Var, String str, boolean z10, boolean z11) {
        return new x2(y2Var, str, Boolean.valueOf(z10), true);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final /* synthetic */ k3 m(Context context) {
        new o2();
        return o2.b(context);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final /* synthetic */ boolean p() {
        return true;
    }

    abstract T e(Object obj);

    public final String n() {
        return f(this.f5606a.f5703c);
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x00b0  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00e2 A[Catch: all -> 0x0103, TryCatch #0 {, blocks: (B:8:0x001c, B:10:0x0020, B:13:0x0029, B:15:0x0040, B:20:0x0051, B:22:0x0057, B:24:0x0065, B:26:0x0082, B:28:0x008c, B:31:0x00d2, B:33:0x00e2, B:35:0x00f6, B:36:0x00f9, B:37:0x00fd, B:38:0x00b1, B:40:0x00c7, B:43:0x00d0, B:47:0x0078, B:48:0x0091, B:50:0x009a, B:52:0x00aa, B:55:0x0101), top: B:7:0x001c }] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00b1 A[Catch: all -> 0x0103, TryCatch #0 {, blocks: (B:8:0x001c, B:10:0x0020, B:13:0x0029, B:15:0x0040, B:20:0x0051, B:22:0x0057, B:24:0x0065, B:26:0x0082, B:28:0x008c, B:31:0x00d2, B:33:0x00e2, B:35:0x00f6, B:36:0x00f9, B:37:0x00fd, B:38:0x00b1, B:40:0x00c7, B:43:0x00d0, B:47:0x0078, B:48:0x0091, B:50:0x009a, B:52:0x00aa, B:55:0x0101), top: B:7:0x001c }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final T o() {
        /*
            Method dump skipped, instructions count: 265
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.t2.o():java.lang.Object");
    }
}
