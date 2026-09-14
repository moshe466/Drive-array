package com.google.android.gms.common.api;

import android.os.Parcel;
import android.os.Parcelable;
import b2.p;
import c2.c;
import com.google.android.gms.common.internal.ReflectedParcelable;

/* loaded from: classes.dex */
public final class Scope extends c2.a implements ReflectedParcelable {
    public static final Parcelable.Creator<Scope> CREATOR = new a();

    /* renamed from: f, reason: collision with root package name */
    final int f4745f;

    /* renamed from: g, reason: collision with root package name */
    private final String f4746g;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Scope(int i10, String str) {
        p.h(str, "scopeUri must not be null or empty");
        this.f4745f = i10;
        this.f4746g = str;
    }

    public Scope(String str) {
        this(1, str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Scope) {
            return this.f4746g.equals(((Scope) obj).f4746g);
        }
        return false;
    }

    public String g() {
        return this.f4746g;
    }

    public int hashCode() {
        return this.f4746g.hashCode();
    }

    public String toString() {
        return this.f4746g;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        int a10 = c.a(parcel);
        c.k(parcel, 1, this.f4745f);
        c.q(parcel, 2, g(), false);
        c.b(parcel, a10);
    }
}
