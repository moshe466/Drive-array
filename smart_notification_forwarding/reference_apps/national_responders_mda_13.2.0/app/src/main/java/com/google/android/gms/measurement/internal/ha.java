package com.google.android.gms.measurement.internal;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
public final class ha extends c2.a {
    public static final Parcelable.Creator<ha> CREATOR = new ga();

    /* renamed from: f, reason: collision with root package name */
    public String f6091f;

    /* renamed from: g, reason: collision with root package name */
    public String f6092g;

    /* renamed from: h, reason: collision with root package name */
    public n9 f6093h;

    /* renamed from: i, reason: collision with root package name */
    public long f6094i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f6095j;

    /* renamed from: k, reason: collision with root package name */
    public String f6096k;

    /* renamed from: l, reason: collision with root package name */
    public q f6097l;

    /* renamed from: m, reason: collision with root package name */
    public long f6098m;

    /* renamed from: n, reason: collision with root package name */
    public q f6099n;

    /* renamed from: o, reason: collision with root package name */
    public long f6100o;

    /* renamed from: p, reason: collision with root package name */
    public q f6101p;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ha(ha haVar) {
        b2.p.k(haVar);
        this.f6091f = haVar.f6091f;
        this.f6092g = haVar.f6092g;
        this.f6093h = haVar.f6093h;
        this.f6094i = haVar.f6094i;
        this.f6095j = haVar.f6095j;
        this.f6096k = haVar.f6096k;
        this.f6097l = haVar.f6097l;
        this.f6098m = haVar.f6098m;
        this.f6099n = haVar.f6099n;
        this.f6100o = haVar.f6100o;
        this.f6101p = haVar.f6101p;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ha(String str, String str2, n9 n9Var, long j10, boolean z10, String str3, q qVar, long j11, q qVar2, long j12, q qVar3) {
        this.f6091f = str;
        this.f6092g = str2;
        this.f6093h = n9Var;
        this.f6094i = j10;
        this.f6095j = z10;
        this.f6096k = str3;
        this.f6097l = qVar;
        this.f6098m = j11;
        this.f6099n = qVar2;
        this.f6100o = j12;
        this.f6101p = qVar3;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int a10 = c2.c.a(parcel);
        c2.c.q(parcel, 2, this.f6091f, false);
        c2.c.q(parcel, 3, this.f6092g, false);
        c2.c.o(parcel, 4, this.f6093h, i10, false);
        c2.c.m(parcel, 5, this.f6094i);
        c2.c.c(parcel, 6, this.f6095j);
        c2.c.q(parcel, 7, this.f6096k, false);
        c2.c.o(parcel, 8, this.f6097l, i10, false);
        c2.c.m(parcel, 9, this.f6098m);
        c2.c.o(parcel, 10, this.f6099n, i10, false);
        c2.c.m(parcel, 11, this.f6100o);
        c2.c.o(parcel, 12, this.f6101p, i10, false);
        c2.c.b(parcel, a10);
    }
}
