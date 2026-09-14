package com.google.android.gms.measurement.internal;

import android.os.Bundle;

/* loaded from: classes.dex */
public final class v3 {

    /* renamed from: a, reason: collision with root package name */
    public String f6544a;

    /* renamed from: b, reason: collision with root package name */
    private String f6545b;

    /* renamed from: c, reason: collision with root package name */
    private long f6546c;

    /* renamed from: d, reason: collision with root package name */
    public Bundle f6547d;

    private v3(String str, String str2, Bundle bundle, long j10) {
        this.f6544a = str;
        this.f6545b = str2;
        this.f6547d = bundle == null ? new Bundle() : bundle;
        this.f6546c = j10;
    }

    public static v3 b(q qVar) {
        return new v3(qVar.f6333f, qVar.f6335h, qVar.f6334g.s(), qVar.f6336i);
    }

    public final q a() {
        return new q(this.f6544a, new p(new Bundle(this.f6547d)), this.f6545b, this.f6546c);
    }

    public final String toString() {
        String str = this.f6545b;
        String str2 = this.f6544a;
        String valueOf = String.valueOf(this.f6547d);
        StringBuilder sb2 = new StringBuilder(String.valueOf(str).length() + 21 + String.valueOf(str2).length() + valueOf.length());
        sb2.append("origin=");
        sb2.append(str);
        sb2.append(",name=");
        sb2.append(str2);
        sb2.append(",params=");
        sb2.append(valueOf);
        return sb2.toString();
    }
}
