package com.google.android.gms.measurement.internal;

/* loaded from: classes.dex */
final class o5 implements Runnable {

    /* renamed from: f, reason: collision with root package name */
    private final /* synthetic */ String f6284f;

    /* renamed from: g, reason: collision with root package name */
    private final /* synthetic */ String f6285g;

    /* renamed from: h, reason: collision with root package name */
    private final /* synthetic */ String f6286h;

    /* renamed from: i, reason: collision with root package name */
    private final /* synthetic */ long f6287i;

    /* renamed from: j, reason: collision with root package name */
    private final /* synthetic */ y4 f6288j;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o5(y4 y4Var, String str, String str2, String str3, long j10) {
        this.f6288j = y4Var;
        this.f6284f = str;
        this.f6285g = str2;
        this.f6286h = str3;
        this.f6287i = j10;
    }

    @Override // java.lang.Runnable
    public final void run() {
        e9 e9Var;
        e9 e9Var2;
        String str = this.f6284f;
        if (str == null) {
            e9Var2 = this.f6288j.f6633a;
            e9Var2.m0().O().R(this.f6285g, null);
        } else {
            c7 c7Var = new c7(this.f6286h, str, this.f6287i);
            e9Var = this.f6288j.f6633a;
            e9Var.m0().O().R(this.f6285g, c7Var);
        }
    }
}
