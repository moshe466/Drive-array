package com.google.android.gms.measurement.internal;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class u3 implements Runnable {

    /* renamed from: f, reason: collision with root package name */
    private final /* synthetic */ int f6515f;

    /* renamed from: g, reason: collision with root package name */
    private final /* synthetic */ String f6516g;

    /* renamed from: h, reason: collision with root package name */
    private final /* synthetic */ Object f6517h;

    /* renamed from: i, reason: collision with root package name */
    private final /* synthetic */ Object f6518i;

    /* renamed from: j, reason: collision with root package name */
    private final /* synthetic */ Object f6519j;

    /* renamed from: k, reason: collision with root package name */
    private final /* synthetic */ r3 f6520k;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u3(r3 r3Var, int i10, String str, Object obj, Object obj2, Object obj3) {
        this.f6520k = r3Var;
        this.f6515f = i10;
        this.f6516g = str;
        this.f6517h = obj;
        this.f6518i = obj2;
        this.f6519j = obj3;
    }

    @Override // java.lang.Runnable
    public final void run() {
        char c10;
        long j10;
        char c11;
        long j11;
        r3 r3Var;
        char c12;
        e4 x10 = this.f6520k.f6381a.x();
        if (!x10.p()) {
            this.f6520k.A(6, "Persisted config not initialized. Not logging error/warn");
            return;
        }
        c10 = this.f6520k.f6365c;
        if (c10 == 0) {
            if (this.f6520k.m().C()) {
                r3Var = this.f6520k;
                c12 = 'C';
            } else {
                r3Var = this.f6520k;
                c12 = 'c';
            }
            r3Var.f6365c = c12;
        }
        j10 = this.f6520k.f6366d;
        if (j10 < 0) {
            this.f6520k.f6366d = 33025L;
        }
        char charAt = "01VDIWEA?".charAt(this.f6515f);
        c11 = this.f6520k.f6365c;
        j11 = this.f6520k.f6366d;
        String z10 = r3.z(true, this.f6516g, this.f6517h, this.f6518i, this.f6519j);
        StringBuilder sb2 = new StringBuilder(String.valueOf(z10).length() + 24);
        sb2.append("2");
        sb2.append(charAt);
        sb2.append(c11);
        sb2.append(j11);
        sb2.append(":");
        sb2.append(z10);
        String sb3 = sb2.toString();
        if (sb3.length() > 1024) {
            sb3 = this.f6516g.substring(0, 1024);
        }
        x10.f5957d.b(sb3, 1L);
    }
}
