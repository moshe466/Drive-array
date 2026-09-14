package com.google.android.gms.measurement.internal;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class z implements Runnable {

    /* renamed from: f, reason: collision with root package name */
    private final /* synthetic */ String f6647f;

    /* renamed from: g, reason: collision with root package name */
    private final /* synthetic */ long f6648g;

    /* renamed from: h, reason: collision with root package name */
    private final /* synthetic */ a f6649h;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(a aVar, String str, long j10) {
        this.f6649h = aVar;
        this.f6647f = str;
        this.f6648g = j10;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f6649h.F(this.f6647f, this.f6648g);
    }
}
