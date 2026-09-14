package s2;

import android.os.Parcel;
import android.os.Parcelable;

@Deprecated
/* loaded from: classes.dex */
public final class p extends c2.a {
    public static final Parcelable.Creator<p> CREATOR = new q();

    /* renamed from: f, reason: collision with root package name */
    public final int f14054f;

    /* renamed from: g, reason: collision with root package name */
    public final int f14055g;

    /* renamed from: h, reason: collision with root package name */
    public final long f14056h;

    /* renamed from: i, reason: collision with root package name */
    public final long f14057i;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(int i10, int i11, long j10, long j11) {
        this.f14054f = i10;
        this.f14055g = i11;
        this.f14056h = j10;
        this.f14057i = j11;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof p) {
            p pVar = (p) obj;
            if (this.f14054f == pVar.f14054f && this.f14055g == pVar.f14055g && this.f14056h == pVar.f14056h && this.f14057i == pVar.f14057i) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return b2.o.b(Integer.valueOf(this.f14055g), Integer.valueOf(this.f14054f), Long.valueOf(this.f14057i), Long.valueOf(this.f14056h));
    }

    public final String toString() {
        return "NetworkLocationStatus: Wifi status: " + this.f14054f + " Cell status: " + this.f14055g + " elapsed time NS: " + this.f14057i + " system time ms: " + this.f14056h;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int a10 = c2.c.a(parcel);
        c2.c.k(parcel, 1, this.f14054f);
        c2.c.k(parcel, 2, this.f14055g);
        c2.c.m(parcel, 3, this.f14056h);
        c2.c.m(parcel, 4, this.f14057i);
        c2.c.b(parcel, a10);
    }
}
