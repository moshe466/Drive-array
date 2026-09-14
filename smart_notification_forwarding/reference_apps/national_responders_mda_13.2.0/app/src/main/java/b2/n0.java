package b2;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import b2.j;

/* loaded from: classes.dex */
public final class n0 extends c2.a {
    public static final Parcelable.Creator<n0> CREATOR = new o0();

    /* renamed from: f, reason: collision with root package name */
    final int f4050f;

    /* renamed from: g, reason: collision with root package name */
    final IBinder f4051g;

    /* renamed from: h, reason: collision with root package name */
    private final com.google.android.gms.common.a f4052h;

    /* renamed from: i, reason: collision with root package name */
    private final boolean f4053i;

    /* renamed from: j, reason: collision with root package name */
    private final boolean f4054j;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n0(int i10, IBinder iBinder, com.google.android.gms.common.a aVar, boolean z10, boolean z11) {
        this.f4050f = i10;
        this.f4051g = iBinder;
        this.f4052h = aVar;
        this.f4053i = z10;
        this.f4054j = z11;
    }

    public final boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof n0)) {
            return false;
        }
        n0 n0Var = (n0) obj;
        return this.f4052h.equals(n0Var.f4052h) && o.a(j(), n0Var.j());
    }

    public final com.google.android.gms.common.a g() {
        return this.f4052h;
    }

    public final j j() {
        IBinder iBinder = this.f4051g;
        if (iBinder == null) {
            return null;
        }
        return j.a.n(iBinder);
    }

    public final boolean l() {
        return this.f4053i;
    }

    public final boolean s() {
        return this.f4054j;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int a10 = c2.c.a(parcel);
        c2.c.k(parcel, 1, this.f4050f);
        c2.c.j(parcel, 2, this.f4051g, false);
        c2.c.o(parcel, 3, this.f4052h, i10, false);
        c2.c.c(parcel, 4, this.f4053i);
        c2.c.c(parcel, 5, this.f4054j);
        c2.c.b(parcel, a10);
    }
}
