package b2;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
public class r extends c2.a {
    public static final Parcelable.Creator<r> CREATOR = new x0();

    /* renamed from: f, reason: collision with root package name */
    private final int f4068f;

    /* renamed from: g, reason: collision with root package name */
    private final boolean f4069g;

    /* renamed from: h, reason: collision with root package name */
    private final boolean f4070h;

    /* renamed from: i, reason: collision with root package name */
    private final int f4071i;

    /* renamed from: j, reason: collision with root package name */
    private final int f4072j;

    public r(int i10, boolean z10, boolean z11, int i11, int i12) {
        this.f4068f = i10;
        this.f4069g = z10;
        this.f4070h = z11;
        this.f4071i = i11;
        this.f4072j = i12;
    }

    public int g() {
        return this.f4071i;
    }

    public int j() {
        return this.f4072j;
    }

    public boolean l() {
        return this.f4069g;
    }

    public boolean s() {
        return this.f4070h;
    }

    public int t() {
        return this.f4068f;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int a10 = c2.c.a(parcel);
        c2.c.k(parcel, 1, t());
        c2.c.c(parcel, 2, l());
        c2.c.c(parcel, 3, s());
        c2.c.k(parcel, 4, g());
        c2.c.k(parcel, 5, j());
        c2.c.b(parcel, a10);
    }
}
