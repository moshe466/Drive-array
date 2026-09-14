package com.google.android.gms.measurement.internal;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class d6 implements Runnable {

    /* renamed from: f, reason: collision with root package name */
    private final /* synthetic */ String f5931f;

    /* renamed from: g, reason: collision with root package name */
    private final /* synthetic */ String f5932g;

    /* renamed from: h, reason: collision with root package name */
    private final /* synthetic */ Object f5933h;

    /* renamed from: i, reason: collision with root package name */
    private final /* synthetic */ long f5934i;

    /* renamed from: j, reason: collision with root package name */
    private final /* synthetic */ w5 f5935j;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d6(w5 w5Var, String str, String str2, Object obj, long j10) {
        this.f5935j = w5Var;
        this.f5931f = str;
        this.f5932g = str2;
        this.f5933h = obj;
        this.f5934i = j10;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f5935j.U(this.f5931f, this.f5932g, this.f5933h, this.f5934i);
    }
}
