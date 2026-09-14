package com.google.android.gms.measurement.internal;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class a1 implements Runnable {

    /* renamed from: f, reason: collision with root package name */
    private final /* synthetic */ String f5800f;

    /* renamed from: g, reason: collision with root package name */
    private final /* synthetic */ long f5801g;

    /* renamed from: h, reason: collision with root package name */
    private final /* synthetic */ a f5802h;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a1(a aVar, String str, long j10) {
        this.f5802h = aVar;
        this.f5800f = str;
        this.f5801g = j10;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f5802h.E(this.f5800f, this.f5801g);
    }
}
