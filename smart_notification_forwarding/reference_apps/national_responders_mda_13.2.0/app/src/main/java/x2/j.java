package x2;

import android.os.Parcel;
import android.os.Parcelable;
import b2.l0;

/* loaded from: classes.dex */
public final class j extends c2.a {
    public static final Parcelable.Creator<j> CREATOR = new k();

    /* renamed from: f, reason: collision with root package name */
    final int f15408f;

    /* renamed from: g, reason: collision with root package name */
    final l0 f15409g;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(int i10, l0 l0Var) {
        this.f15408f = i10;
        this.f15409g = l0Var;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int a10 = c2.c.a(parcel);
        c2.c.k(parcel, 1, this.f15408f);
        c2.c.o(parcel, 2, this.f15409g, i10, false);
        c2.c.b(parcel, a10);
    }
}
