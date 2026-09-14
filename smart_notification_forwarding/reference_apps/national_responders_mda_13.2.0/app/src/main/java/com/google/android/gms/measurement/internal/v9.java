package com.google.android.gms.measurement.internal;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import java.util.List;

/* loaded from: classes.dex */
public final class v9 extends c2.a {
    public static final Parcelable.Creator<v9> CREATOR = new x9();
    public final String A;
    public final String B;

    /* renamed from: f, reason: collision with root package name */
    public final String f6560f;

    /* renamed from: g, reason: collision with root package name */
    public final String f6561g;

    /* renamed from: h, reason: collision with root package name */
    public final String f6562h;

    /* renamed from: i, reason: collision with root package name */
    public final String f6563i;

    /* renamed from: j, reason: collision with root package name */
    public final long f6564j;

    /* renamed from: k, reason: collision with root package name */
    public final long f6565k;

    /* renamed from: l, reason: collision with root package name */
    public final String f6566l;

    /* renamed from: m, reason: collision with root package name */
    public final boolean f6567m;

    /* renamed from: n, reason: collision with root package name */
    public final boolean f6568n;

    /* renamed from: o, reason: collision with root package name */
    public final long f6569o;

    /* renamed from: p, reason: collision with root package name */
    public final String f6570p;

    /* renamed from: q, reason: collision with root package name */
    public final long f6571q;

    /* renamed from: r, reason: collision with root package name */
    public final long f6572r;

    /* renamed from: s, reason: collision with root package name */
    public final int f6573s;

    /* renamed from: t, reason: collision with root package name */
    public final boolean f6574t;

    /* renamed from: u, reason: collision with root package name */
    public final boolean f6575u;

    /* renamed from: v, reason: collision with root package name */
    public final boolean f6576v;

    /* renamed from: w, reason: collision with root package name */
    public final String f6577w;

    /* renamed from: x, reason: collision with root package name */
    public final Boolean f6578x;

    /* renamed from: y, reason: collision with root package name */
    public final long f6579y;

    /* renamed from: z, reason: collision with root package name */
    public final List<String> f6580z;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v9(String str, String str2, String str3, long j10, String str4, long j11, long j12, String str5, boolean z10, boolean z11, String str6, long j13, long j14, int i10, boolean z12, boolean z13, boolean z14, String str7, Boolean bool, long j15, List<String> list, String str8, String str9) {
        b2.p.g(str);
        this.f6560f = str;
        this.f6561g = TextUtils.isEmpty(str2) ? null : str2;
        this.f6562h = str3;
        this.f6569o = j10;
        this.f6563i = str4;
        this.f6564j = j11;
        this.f6565k = j12;
        this.f6566l = str5;
        this.f6567m = z10;
        this.f6568n = z11;
        this.f6570p = str6;
        this.f6571q = j13;
        this.f6572r = j14;
        this.f6573s = i10;
        this.f6574t = z12;
        this.f6575u = z13;
        this.f6576v = z14;
        this.f6577w = str7;
        this.f6578x = bool;
        this.f6579y = j15;
        this.f6580z = list;
        this.A = str8;
        this.B = str9;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public v9(String str, String str2, String str3, String str4, long j10, long j11, String str5, boolean z10, boolean z11, long j12, String str6, long j13, long j14, int i10, boolean z12, boolean z13, boolean z14, String str7, Boolean bool, long j15, List<String> list, String str8, String str9) {
        this.f6560f = str;
        this.f6561g = str2;
        this.f6562h = str3;
        this.f6569o = j12;
        this.f6563i = str4;
        this.f6564j = j10;
        this.f6565k = j11;
        this.f6566l = str5;
        this.f6567m = z10;
        this.f6568n = z11;
        this.f6570p = str6;
        this.f6571q = j13;
        this.f6572r = j14;
        this.f6573s = i10;
        this.f6574t = z12;
        this.f6575u = z13;
        this.f6576v = z14;
        this.f6577w = str7;
        this.f6578x = bool;
        this.f6579y = j15;
        this.f6580z = list;
        this.A = str8;
        this.B = str9;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int a10 = c2.c.a(parcel);
        c2.c.q(parcel, 2, this.f6560f, false);
        c2.c.q(parcel, 3, this.f6561g, false);
        c2.c.q(parcel, 4, this.f6562h, false);
        c2.c.q(parcel, 5, this.f6563i, false);
        c2.c.m(parcel, 6, this.f6564j);
        c2.c.m(parcel, 7, this.f6565k);
        c2.c.q(parcel, 8, this.f6566l, false);
        c2.c.c(parcel, 9, this.f6567m);
        c2.c.c(parcel, 10, this.f6568n);
        c2.c.m(parcel, 11, this.f6569o);
        c2.c.q(parcel, 12, this.f6570p, false);
        c2.c.m(parcel, 13, this.f6571q);
        c2.c.m(parcel, 14, this.f6572r);
        c2.c.k(parcel, 15, this.f6573s);
        c2.c.c(parcel, 16, this.f6574t);
        c2.c.c(parcel, 17, this.f6575u);
        c2.c.c(parcel, 18, this.f6576v);
        c2.c.q(parcel, 19, this.f6577w, false);
        c2.c.d(parcel, 21, this.f6578x, false);
        c2.c.m(parcel, 22, this.f6579y);
        c2.c.r(parcel, 23, this.f6580z, false);
        c2.c.q(parcel, 24, this.A, false);
        c2.c.q(parcel, 25, this.B, false);
        c2.c.b(parcel, a10);
    }
}
