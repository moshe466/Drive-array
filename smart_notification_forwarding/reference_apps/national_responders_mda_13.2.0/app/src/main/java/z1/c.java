package z1;

import android.os.Parcel;
import android.os.Parcelable;
import b2.o;

/* loaded from: classes.dex */
public class c extends c2.a {
    public static final Parcelable.Creator<c> CREATOR = new g();

    /* renamed from: f, reason: collision with root package name */
    private final String f16068f;

    /* renamed from: g, reason: collision with root package name */
    @Deprecated
    private final int f16069g;

    /* renamed from: h, reason: collision with root package name */
    private final long f16070h;

    public c(String str, int i10, long j10) {
        this.f16068f = str;
        this.f16069g = i10;
        this.f16070h = j10;
    }

    public c(String str, long j10) {
        this.f16068f = str;
        this.f16070h = j10;
        this.f16069g = -1;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof c) {
            c cVar = (c) obj;
            if (((g() != null && g().equals(cVar.g())) || (g() == null && cVar.g() == null)) && j() == cVar.j()) {
                return true;
            }
        }
        return false;
    }

    public String g() {
        return this.f16068f;
    }

    public final int hashCode() {
        return o.b(g(), Long.valueOf(j()));
    }

    public long j() {
        long j10 = this.f16070h;
        return j10 == -1 ? this.f16069g : j10;
    }

    public final String toString() {
        o.a c10 = o.c(this);
        c10.a("name", g());
        c10.a("version", Long.valueOf(j()));
        return c10.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int a10 = c2.c.a(parcel);
        c2.c.q(parcel, 1, g(), false);
        c2.c.k(parcel, 2, this.f16069g);
        c2.c.m(parcel, 3, j());
        c2.c.b(parcel, a10);
    }
}
