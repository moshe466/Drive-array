package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.Iterator;

/* loaded from: classes.dex */
public final class p extends c2.a implements Iterable<String> {
    public static final Parcelable.Creator<p> CREATOR = new r();

    /* renamed from: f, reason: collision with root package name */
    private final Bundle f6302f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(Bundle bundle) {
        this.f6302f = bundle;
    }

    public final int g() {
        return this.f6302f.size();
    }

    @Override // java.lang.Iterable
    public final Iterator<String> iterator() {
        return new o(this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Object l(String str) {
        return this.f6302f.get(str);
    }

    public final Bundle s() {
        return new Bundle(this.f6302f);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Long t(String str) {
        return Long.valueOf(this.f6302f.getLong(str));
    }

    public final String toString() {
        return this.f6302f.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Double u(String str) {
        return Double.valueOf(this.f6302f.getDouble(str));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String v(String str) {
        return this.f6302f.getString(str);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int a10 = c2.c.a(parcel);
        c2.c.e(parcel, 2, s(), false);
        c2.c.b(parcel, a10);
    }
}
