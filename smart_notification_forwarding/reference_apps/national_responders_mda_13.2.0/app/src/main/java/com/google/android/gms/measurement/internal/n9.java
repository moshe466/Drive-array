package com.google.android.gms.measurement.internal;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
public final class n9 extends c2.a {
    public static final Parcelable.Creator<n9> CREATOR = new m9();

    /* renamed from: f, reason: collision with root package name */
    private final int f6258f;

    /* renamed from: g, reason: collision with root package name */
    public final String f6259g;

    /* renamed from: h, reason: collision with root package name */
    public final long f6260h;

    /* renamed from: i, reason: collision with root package name */
    public final Long f6261i;

    /* renamed from: j, reason: collision with root package name */
    public final String f6262j;

    /* renamed from: k, reason: collision with root package name */
    public final String f6263k;

    /* renamed from: l, reason: collision with root package name */
    public final Double f6264l;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n9(int i10, String str, long j10, Long l10, Float f10, String str2, String str3, Double d10) {
        this.f6258f = i10;
        this.f6259g = str;
        this.f6260h = j10;
        this.f6261i = l10;
        if (i10 == 1) {
            this.f6264l = f10 != null ? Double.valueOf(f10.doubleValue()) : null;
        } else {
            this.f6264l = d10;
        }
        this.f6262j = str2;
        this.f6263k = str3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public n9(p9 p9Var) {
        this(p9Var.f6330c, p9Var.f6331d, p9Var.f6332e, p9Var.f6329b);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public n9(String str, long j10, Object obj, String str2) {
        b2.p.g(str);
        this.f6258f = 2;
        this.f6259g = str;
        this.f6260h = j10;
        this.f6263k = str2;
        if (obj == null) {
            this.f6261i = null;
            this.f6264l = null;
            this.f6262j = null;
            return;
        }
        if (obj instanceof Long) {
            this.f6261i = (Long) obj;
            this.f6264l = null;
            this.f6262j = null;
        } else if (obj instanceof String) {
            this.f6261i = null;
            this.f6264l = null;
            this.f6262j = (String) obj;
        } else {
            if (!(obj instanceof Double)) {
                throw new IllegalArgumentException("User attribute given of un-supported type");
            }
            this.f6261i = null;
            this.f6264l = (Double) obj;
            this.f6262j = null;
        }
    }

    public final Object g() {
        Long l10 = this.f6261i;
        if (l10 != null) {
            return l10;
        }
        Double d10 = this.f6264l;
        if (d10 != null) {
            return d10;
        }
        String str = this.f6262j;
        if (str != null) {
            return str;
        }
        return null;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int a10 = c2.c.a(parcel);
        c2.c.k(parcel, 1, this.f6258f);
        c2.c.q(parcel, 2, this.f6259g, false);
        c2.c.m(parcel, 3, this.f6260h);
        c2.c.n(parcel, 4, this.f6261i, false);
        c2.c.i(parcel, 5, null, false);
        c2.c.q(parcel, 6, this.f6262j, false);
        c2.c.q(parcel, 7, this.f6263k, false);
        c2.c.g(parcel, 8, this.f6264l, false);
        c2.c.b(parcel, a10);
    }
}
