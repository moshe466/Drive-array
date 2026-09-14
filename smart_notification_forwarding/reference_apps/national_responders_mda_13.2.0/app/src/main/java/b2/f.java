package b2;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
public class f extends c2.a {
    public static final Parcelable.Creator<f> CREATOR = new g1();

    /* renamed from: f, reason: collision with root package name */
    private final r f3976f;

    /* renamed from: g, reason: collision with root package name */
    private final boolean f3977g;

    /* renamed from: h, reason: collision with root package name */
    private final boolean f3978h;

    /* renamed from: i, reason: collision with root package name */
    private final int[] f3979i;

    /* renamed from: j, reason: collision with root package name */
    private final int f3980j;

    /* renamed from: k, reason: collision with root package name */
    private final int[] f3981k;

    public f(r rVar, boolean z10, boolean z11, int[] iArr, int i10, int[] iArr2) {
        this.f3976f = rVar;
        this.f3977g = z10;
        this.f3978h = z11;
        this.f3979i = iArr;
        this.f3980j = i10;
        this.f3981k = iArr2;
    }

    public int g() {
        return this.f3980j;
    }

    public int[] j() {
        return this.f3979i;
    }

    public int[] l() {
        return this.f3981k;
    }

    public boolean s() {
        return this.f3977g;
    }

    public boolean t() {
        return this.f3978h;
    }

    public final r u() {
        return this.f3976f;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int a10 = c2.c.a(parcel);
        c2.c.o(parcel, 1, this.f3976f, i10, false);
        c2.c.c(parcel, 2, s());
        c2.c.c(parcel, 3, t());
        c2.c.l(parcel, 4, j(), false);
        c2.c.k(parcel, 5, g());
        c2.c.l(parcel, 6, l(), false);
        c2.c.b(parcel, a10);
    }
}
