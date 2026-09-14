package b2;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
public final class e1 extends c2.a {
    public static final Parcelable.Creator<e1> CREATOR = new f1();

    /* renamed from: f, reason: collision with root package name */
    Bundle f3972f;

    /* renamed from: g, reason: collision with root package name */
    z1.c[] f3973g;

    /* renamed from: h, reason: collision with root package name */
    int f3974h;

    /* renamed from: i, reason: collision with root package name */
    f f3975i;

    public e1() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public e1(Bundle bundle, z1.c[] cVarArr, int i10, f fVar) {
        this.f3972f = bundle;
        this.f3973g = cVarArr;
        this.f3974h = i10;
        this.f3975i = fVar;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int a10 = c2.c.a(parcel);
        c2.c.e(parcel, 1, this.f3972f, false);
        c2.c.s(parcel, 2, this.f3973g, i10, false);
        c2.c.k(parcel, 3, this.f3974h);
        c2.c.o(parcel, 4, this.f3975i, i10, false);
        c2.c.b(parcel, a10);
    }
}
