package s2;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
public class d extends c2.a {
    public static final Parcelable.Creator<d> CREATOR = new u();

    /* renamed from: f, reason: collision with root package name */
    private final int f14006f;

    /* renamed from: g, reason: collision with root package name */
    private final int f14007g;

    /* renamed from: h, reason: collision with root package name */
    private final long f14008h;

    public d(int i10, int i11, long j10) {
        c.l(i11);
        this.f14006f = i10;
        this.f14007g = i11;
        this.f14008h = j10;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        return this.f14006f == dVar.f14006f && this.f14007g == dVar.f14007g && this.f14008h == dVar.f14008h;
    }

    public int g() {
        return this.f14006f;
    }

    public int hashCode() {
        return b2.o.b(Integer.valueOf(this.f14006f), Integer.valueOf(this.f14007g), Long.valueOf(this.f14008h));
    }

    public long j() {
        return this.f14008h;
    }

    public int l() {
        return this.f14007g;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("ActivityType " + this.f14006f);
        sb2.append(" ");
        sb2.append("TransitionType " + this.f14007g);
        sb2.append(" ");
        sb2.append("ElapsedRealTimeNanos " + this.f14008h);
        return sb2.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        b2.p.k(parcel);
        int a10 = c2.c.a(parcel);
        c2.c.k(parcel, 1, g());
        c2.c.k(parcel, 2, l());
        c2.c.m(parcel, 3, j());
        c2.c.b(parcel, a10);
    }
}
