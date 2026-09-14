package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public final class zzdwx {
    public static final zzdwx zzhzt = new zzdwx(1.0d, 0.0d, 0.0d, 1.0d, 0.0d, 0.0d, 1.0d, 0.0d, 0.0d);
    private static final zzdwx zzhzu = new zzdwx(0.0d, 1.0d, -1.0d, 0.0d, 0.0d, 0.0d, 1.0d, 0.0d, 0.0d);
    private static final zzdwx zzhzv = new zzdwx(-1.0d, 0.0d, 0.0d, -1.0d, 0.0d, 0.0d, 1.0d, 0.0d, 0.0d);
    private static final zzdwx zzhzw = new zzdwx(0.0d, -1.0d, 1.0d, 0.0d, 0.0d, 0.0d, 1.0d, 0.0d, 0.0d);
    private final double a;
    private final double b;
    private final double c;
    private final double d;
    private final double w;
    private final double zzhzp;
    private final double zzhzq;
    private final double zzhzr;
    private final double zzhzs;

    private zzdwx(double d, double d2, double d3, double d4, double d5, double d6, double d7, double d8, double d9) {
        this.zzhzp = d5;
        this.zzhzq = d6;
        this.w = d7;
        this.a = d;
        this.b = d2;
        this.c = d3;
        this.d = d4;
        this.zzhzr = d8;
        this.zzhzs = d9;
    }

    public static zzdwx zzp(ByteBuffer byteBuffer) {
        double zzd = zzbg.zzd(byteBuffer);
        double zzd2 = zzbg.zzd(byteBuffer);
        double zze = zzbg.zze(byteBuffer);
        return new zzdwx(zzd, zzd2, zzbg.zzd(byteBuffer), zzbg.zzd(byteBuffer), zze, zzbg.zze(byteBuffer), zzbg.zze(byteBuffer), zzbg.zzd(byteBuffer), zzbg.zzd(byteBuffer));
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || zzdwx.class != obj.getClass()) {
            return false;
        }
        zzdwx zzdwxVar = (zzdwx) obj;
        return Double.compare(zzdwxVar.a, this.a) == 0 && Double.compare(zzdwxVar.b, this.b) == 0 && Double.compare(zzdwxVar.c, this.c) == 0 && Double.compare(zzdwxVar.d, this.d) == 0 && Double.compare(zzdwxVar.zzhzr, this.zzhzr) == 0 && Double.compare(zzdwxVar.zzhzs, this.zzhzs) == 0 && Double.compare(zzdwxVar.zzhzp, this.zzhzp) == 0 && Double.compare(zzdwxVar.zzhzq, this.zzhzq) == 0 && Double.compare(zzdwxVar.w, this.w) == 0;
    }

    public final int hashCode() {
        long doubleToLongBits = Double.doubleToLongBits(this.zzhzp);
        long doubleToLongBits2 = Double.doubleToLongBits(this.zzhzq);
        int i = (((int) (doubleToLongBits ^ (doubleToLongBits >>> 32))) * 31) + ((int) (doubleToLongBits2 ^ (doubleToLongBits2 >>> 32)));
        long doubleToLongBits3 = Double.doubleToLongBits(this.w);
        int i2 = (i * 31) + ((int) (doubleToLongBits3 ^ (doubleToLongBits3 >>> 32)));
        long doubleToLongBits4 = Double.doubleToLongBits(this.a);
        int i3 = (i2 * 31) + ((int) (doubleToLongBits4 ^ (doubleToLongBits4 >>> 32)));
        long doubleToLongBits5 = Double.doubleToLongBits(this.b);
        int i4 = (i3 * 31) + ((int) (doubleToLongBits5 ^ (doubleToLongBits5 >>> 32)));
        long doubleToLongBits6 = Double.doubleToLongBits(this.c);
        int i5 = (i4 * 31) + ((int) (doubleToLongBits6 ^ (doubleToLongBits6 >>> 32)));
        long doubleToLongBits7 = Double.doubleToLongBits(this.d);
        int i6 = (i5 * 31) + ((int) (doubleToLongBits7 ^ (doubleToLongBits7 >>> 32)));
        long doubleToLongBits8 = Double.doubleToLongBits(this.zzhzr);
        int i7 = (i6 * 31) + ((int) (doubleToLongBits8 ^ (doubleToLongBits8 >>> 32)));
        long doubleToLongBits9 = Double.doubleToLongBits(this.zzhzs);
        return (i7 * 31) + ((int) (doubleToLongBits9 ^ (doubleToLongBits9 >>> 32)));
    }

    public final String toString() {
        if (equals(zzhzt)) {
            return "Rotate 0°";
        }
        if (equals(zzhzu)) {
            return "Rotate 90°";
        }
        if (equals(zzhzv)) {
            return "Rotate 180°";
        }
        if (equals(zzhzw)) {
            return "Rotate 270°";
        }
        double d = this.zzhzp;
        double d2 = this.zzhzq;
        double d3 = this.w;
        double d4 = this.a;
        double d5 = this.b;
        double d6 = this.c;
        double d7 = this.d;
        double d8 = this.zzhzr;
        double d9 = this.zzhzs;
        StringBuilder sb = new StringBuilder(260);
        sb.append("Matrix{u=");
        sb.append(d);
        sb.append(", v=");
        sb.append(d2);
        sb.append(", w=");
        sb.append(d3);
        sb.append(", a=");
        sb.append(d4);
        sb.append(", b=");
        sb.append(d5);
        sb.append(", c=");
        sb.append(d6);
        sb.append(", d=");
        sb.append(d7);
        sb.append(", tx=");
        sb.append(d8);
        sb.append(", ty=");
        sb.append(d9);
        sb.append("}");
        return sb.toString();
    }
}
