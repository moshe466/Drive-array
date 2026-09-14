package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
public final class f extends c2.a {
    public static final Parcelable.Creator<f> CREATOR = new i();

    /* renamed from: f, reason: collision with root package name */
    public final long f5295f;

    /* renamed from: g, reason: collision with root package name */
    public final long f5296g;

    /* renamed from: h, reason: collision with root package name */
    public final boolean f5297h;

    /* renamed from: i, reason: collision with root package name */
    public final String f5298i;

    /* renamed from: j, reason: collision with root package name */
    public final String f5299j;

    /* renamed from: k, reason: collision with root package name */
    public final String f5300k;

    /* renamed from: l, reason: collision with root package name */
    public final Bundle f5301l;

    public f(long j10, long j11, boolean z10, String str, String str2, String str3, Bundle bundle) {
        this.f5295f = j10;
        this.f5296g = j11;
        this.f5297h = z10;
        this.f5298i = str;
        this.f5299j = str2;
        this.f5300k = str3;
        this.f5301l = bundle;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int a10 = c2.c.a(parcel);
        c2.c.m(parcel, 1, this.f5295f);
        c2.c.m(parcel, 2, this.f5296g);
        c2.c.c(parcel, 3, this.f5297h);
        c2.c.q(parcel, 4, this.f5298i, false);
        c2.c.q(parcel, 5, this.f5299j, false);
        c2.c.q(parcel, 6, this.f5300k, false);
        c2.c.e(parcel, 7, this.f5301l, false);
        c2.c.b(parcel, a10);
    }
}
