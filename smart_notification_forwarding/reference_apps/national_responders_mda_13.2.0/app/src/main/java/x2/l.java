package x2;

import android.os.Parcel;
import android.os.Parcelable;
import b2.n0;

/* loaded from: classes.dex */
public final class l extends c2.a {
    public static final Parcelable.Creator<l> CREATOR = new m();

    /* renamed from: f, reason: collision with root package name */
    final int f15410f;

    /* renamed from: g, reason: collision with root package name */
    private final com.google.android.gms.common.a f15411g;

    /* renamed from: h, reason: collision with root package name */
    private final n0 f15412h;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(int i10, com.google.android.gms.common.a aVar, n0 n0Var) {
        this.f15410f = i10;
        this.f15411g = aVar;
        this.f15412h = n0Var;
    }

    public final com.google.android.gms.common.a g() {
        return this.f15411g;
    }

    public final n0 j() {
        return this.f15412h;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int a10 = c2.c.a(parcel);
        c2.c.k(parcel, 1, this.f15410f);
        c2.c.o(parcel, 2, this.f15411g, i10, false);
        c2.c.o(parcel, 3, this.f15412h, i10, false);
        c2.c.b(parcel, a10);
    }
}
