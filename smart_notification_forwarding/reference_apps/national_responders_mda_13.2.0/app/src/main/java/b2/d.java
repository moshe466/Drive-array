package b2;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
public class d extends c2.a {
    public static final Parcelable.Creator<d> CREATOR = new w();

    /* renamed from: f, reason: collision with root package name */
    public final int f3953f;

    /* renamed from: g, reason: collision with root package name */
    public final String f3954g;

    public d(int i10, String str) {
        this.f3953f = i10;
        this.f3954g = str;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        return dVar.f3953f == this.f3953f && o.a(dVar.f3954g, this.f3954g);
    }

    public final int hashCode() {
        return this.f3953f;
    }

    public final String toString() {
        return this.f3953f + ":" + this.f3954g;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int a10 = c2.c.a(parcel);
        c2.c.k(parcel, 1, this.f3953f);
        c2.c.q(parcel, 2, this.f3954g, false);
        c2.c.b(parcel, a10);
    }
}
