package q2;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Locale;

/* loaded from: classes.dex */
public final class u0 extends c2.a implements s2.i {
    public static final Parcelable.Creator<u0> CREATOR = new v0();

    /* renamed from: f, reason: collision with root package name */
    private final String f13540f;

    /* renamed from: g, reason: collision with root package name */
    private final long f13541g;

    /* renamed from: h, reason: collision with root package name */
    private final short f13542h;

    /* renamed from: i, reason: collision with root package name */
    private final double f13543i;

    /* renamed from: j, reason: collision with root package name */
    private final double f13544j;

    /* renamed from: k, reason: collision with root package name */
    private final float f13545k;

    /* renamed from: l, reason: collision with root package name */
    private final int f13546l;

    /* renamed from: m, reason: collision with root package name */
    private final int f13547m;

    /* renamed from: n, reason: collision with root package name */
    private final int f13548n;

    public u0(String str, int i10, short s10, double d10, double d11, float f10, long j10, int i11, int i12) {
        if (str == null || str.length() > 100) {
            throw new IllegalArgumentException("requestId is null or too long: ".concat(String.valueOf(str)));
        }
        if (f10 <= 0.0f) {
            throw new IllegalArgumentException("invalid radius: " + f10);
        }
        if (d10 > 90.0d || d10 < -90.0d) {
            throw new IllegalArgumentException("invalid latitude: " + d10);
        }
        if (d11 > 180.0d || d11 < -180.0d) {
            throw new IllegalArgumentException("invalid longitude: " + d11);
        }
        int i13 = i10 & 7;
        if (i13 == 0) {
            throw new IllegalArgumentException("No supported transition specified: " + i10);
        }
        this.f13542h = s10;
        this.f13540f = str;
        this.f13543i = d10;
        this.f13544j = d11;
        this.f13545k = f10;
        this.f13541g = j10;
        this.f13546l = i13;
        this.f13547m = i11;
        this.f13548n = i12;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof u0) {
            u0 u0Var = (u0) obj;
            if (this.f13545k == u0Var.f13545k && this.f13543i == u0Var.f13543i && this.f13544j == u0Var.f13544j && this.f13542h == u0Var.f13542h) {
                return true;
            }
        }
        return false;
    }

    @Override // s2.i
    public final String f() {
        return this.f13540f;
    }

    public final int hashCode() {
        long doubleToLongBits = Double.doubleToLongBits(this.f13543i);
        long doubleToLongBits2 = Double.doubleToLongBits(this.f13544j);
        return ((((((((((int) (doubleToLongBits ^ (doubleToLongBits >>> 32))) + 31) * 31) + ((int) (doubleToLongBits2 ^ (doubleToLongBits2 >>> 32)))) * 31) + Float.floatToIntBits(this.f13545k)) * 31) + this.f13542h) * 31) + this.f13546l;
    }

    public final String toString() {
        Locale locale = Locale.US;
        Object[] objArr = new Object[9];
        short s10 = this.f13542h;
        objArr[0] = s10 != -1 ? s10 != 1 ? "UNKNOWN" : "CIRCLE" : "INVALID";
        objArr[1] = this.f13540f.replaceAll("\\p{C}", "?");
        objArr[2] = Integer.valueOf(this.f13546l);
        objArr[3] = Double.valueOf(this.f13543i);
        objArr[4] = Double.valueOf(this.f13544j);
        objArr[5] = Float.valueOf(this.f13545k);
        objArr[6] = Integer.valueOf(this.f13547m / 1000);
        objArr[7] = Integer.valueOf(this.f13548n);
        objArr[8] = Long.valueOf(this.f13541g);
        return String.format(locale, "Geofence[%s id:%s transitions:%d %.6f, %.6f %.0fm, resp=%ds, dwell=%dms, @%d]", objArr);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int a10 = c2.c.a(parcel);
        c2.c.q(parcel, 1, this.f13540f, false);
        c2.c.m(parcel, 2, this.f13541g);
        c2.c.p(parcel, 3, this.f13542h);
        c2.c.f(parcel, 4, this.f13543i);
        c2.c.f(parcel, 5, this.f13544j);
        c2.c.h(parcel, 6, this.f13545k);
        c2.c.k(parcel, 7, this.f13546l);
        c2.c.k(parcel, 8, this.f13547m);
        c2.c.k(parcel, 9, this.f13548n);
        c2.c.b(parcel, a10);
    }
}
