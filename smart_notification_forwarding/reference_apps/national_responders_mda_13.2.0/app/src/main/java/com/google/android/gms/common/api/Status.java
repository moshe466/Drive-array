package com.google.android.gms.common.api;

import a2.d;
import a2.j;
import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;
import b2.o;
import c2.c;
import com.google.android.gms.common.internal.ReflectedParcelable;

/* loaded from: classes.dex */
public final class Status extends c2.a implements j, ReflectedParcelable {
    public static final Parcelable.Creator<Status> CREATOR;

    /* renamed from: k, reason: collision with root package name */
    public static final Status f4747k;

    /* renamed from: l, reason: collision with root package name */
    public static final Status f4748l;

    /* renamed from: m, reason: collision with root package name */
    public static final Status f4749m;

    /* renamed from: n, reason: collision with root package name */
    public static final Status f4750n;

    /* renamed from: f, reason: collision with root package name */
    final int f4751f;

    /* renamed from: g, reason: collision with root package name */
    private final int f4752g;

    /* renamed from: h, reason: collision with root package name */
    private final String f4753h;

    /* renamed from: i, reason: collision with root package name */
    private final PendingIntent f4754i;

    /* renamed from: j, reason: collision with root package name */
    private final com.google.android.gms.common.a f4755j;

    static {
        new Status(-1);
        f4747k = new Status(0);
        new Status(14);
        f4748l = new Status(8);
        f4749m = new Status(15);
        f4750n = new Status(16);
        new Status(17);
        new Status(18);
        CREATOR = new b();
    }

    public Status(int i10) {
        this(i10, (String) null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Status(int i10, int i11, String str, PendingIntent pendingIntent, com.google.android.gms.common.a aVar) {
        this.f4751f = i10;
        this.f4752g = i11;
        this.f4753h = str;
        this.f4754i = pendingIntent;
        this.f4755j = aVar;
    }

    public Status(int i10, String str) {
        this(1, i10, str, null, null);
    }

    public Status(int i10, String str, PendingIntent pendingIntent) {
        this(1, i10, str, pendingIntent, null);
    }

    public Status(com.google.android.gms.common.a aVar, String str) {
        this(aVar, str, 17);
    }

    @Deprecated
    public Status(com.google.android.gms.common.a aVar, String str, int i10) {
        this(1, i10, str, aVar.l(), aVar);
    }

    @Override // a2.j
    public Status c() {
        return this;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Status)) {
            return false;
        }
        Status status = (Status) obj;
        return this.f4751f == status.f4751f && this.f4752g == status.f4752g && o.a(this.f4753h, status.f4753h) && o.a(this.f4754i, status.f4754i) && o.a(this.f4755j, status.f4755j);
    }

    public com.google.android.gms.common.a g() {
        return this.f4755j;
    }

    public int hashCode() {
        return o.b(Integer.valueOf(this.f4751f), Integer.valueOf(this.f4752g), this.f4753h, this.f4754i, this.f4755j);
    }

    public int j() {
        return this.f4752g;
    }

    public String l() {
        return this.f4753h;
    }

    public boolean s() {
        return this.f4754i != null;
    }

    public boolean t() {
        return this.f4752g <= 0;
    }

    public String toString() {
        o.a c10 = o.c(this);
        c10.a("statusCode", u());
        c10.a("resolution", this.f4754i);
        return c10.toString();
    }

    public final String u() {
        String str = this.f4753h;
        return str != null ? str : d.a(this.f4752g);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        int a10 = c.a(parcel);
        c.k(parcel, 1, j());
        c.q(parcel, 2, l(), false);
        c.o(parcel, 3, this.f4754i, i10, false);
        c.o(parcel, 4, g(), i10, false);
        c.k(parcel, 1000, this.f4751f);
        c.b(parcel, a10);
    }
}
