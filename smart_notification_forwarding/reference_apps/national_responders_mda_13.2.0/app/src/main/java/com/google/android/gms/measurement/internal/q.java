package com.google.android.gms.measurement.internal;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
public final class q extends c2.a {
    public static final Parcelable.Creator<q> CREATOR = new v2.b();

    /* renamed from: f, reason: collision with root package name */
    public final String f6333f;

    /* renamed from: g, reason: collision with root package name */
    public final p f6334g;

    /* renamed from: h, reason: collision with root package name */
    public final String f6335h;

    /* renamed from: i, reason: collision with root package name */
    public final long f6336i;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(q qVar, long j10) {
        b2.p.k(qVar);
        this.f6333f = qVar.f6333f;
        this.f6334g = qVar.f6334g;
        this.f6335h = qVar.f6335h;
        this.f6336i = j10;
    }

    public q(String str, p pVar, String str2, long j10) {
        this.f6333f = str;
        this.f6334g = pVar;
        this.f6335h = str2;
        this.f6336i = j10;
    }

    public final String toString() {
        String str = this.f6335h;
        String str2 = this.f6333f;
        String valueOf = String.valueOf(this.f6334g);
        StringBuilder sb2 = new StringBuilder(String.valueOf(str).length() + 21 + String.valueOf(str2).length() + valueOf.length());
        sb2.append("origin=");
        sb2.append(str);
        sb2.append(",name=");
        sb2.append(str2);
        sb2.append(",params=");
        sb2.append(valueOf);
        return sb2.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int a10 = c2.c.a(parcel);
        c2.c.q(parcel, 2, this.f6333f, false);
        c2.c.o(parcel, 3, this.f6334g, i10, false);
        c2.c.q(parcel, 4, this.f6335h, false);
        c2.c.m(parcel, 5, this.f6336i);
        c2.c.b(parcel, a10);
    }
}
