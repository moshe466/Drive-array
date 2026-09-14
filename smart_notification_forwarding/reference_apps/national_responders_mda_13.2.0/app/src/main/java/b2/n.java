package b2;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
public class n extends c2.a {
    public static final Parcelable.Creator<n> CREATOR = new k0();

    /* renamed from: f, reason: collision with root package name */
    private final int f4041f;

    /* renamed from: g, reason: collision with root package name */
    private final int f4042g;

    /* renamed from: h, reason: collision with root package name */
    private final int f4043h;

    /* renamed from: i, reason: collision with root package name */
    private final long f4044i;

    /* renamed from: j, reason: collision with root package name */
    private final long f4045j;

    /* renamed from: k, reason: collision with root package name */
    private final String f4046k;

    /* renamed from: l, reason: collision with root package name */
    private final String f4047l;

    /* renamed from: m, reason: collision with root package name */
    private final int f4048m;

    /* renamed from: n, reason: collision with root package name */
    private final int f4049n;

    public n(int i10, int i11, int i12, long j10, long j11, String str, String str2, int i13, int i14) {
        this.f4041f = i10;
        this.f4042g = i11;
        this.f4043h = i12;
        this.f4044i = j10;
        this.f4045j = j11;
        this.f4046k = str;
        this.f4047l = str2;
        this.f4048m = i13;
        this.f4049n = i14;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int a10 = c2.c.a(parcel);
        c2.c.k(parcel, 1, this.f4041f);
        c2.c.k(parcel, 2, this.f4042g);
        c2.c.k(parcel, 3, this.f4043h);
        c2.c.m(parcel, 4, this.f4044i);
        c2.c.m(parcel, 5, this.f4045j);
        c2.c.q(parcel, 6, this.f4046k, false);
        c2.c.q(parcel, 7, this.f4047l, false);
        c2.c.k(parcel, 8, this.f4048m);
        c2.c.k(parcel, 9, this.f4049n);
        c2.c.b(parcel, a10);
    }
}
