package com.google.android.gms.internal.ads;

import com.google.logging.type.LogSeverity;
import java.nio.ShortBuffer;
import java.util.Arrays;

/* loaded from: classes.dex */
final class zzin {
    private final int zzafp;
    private float zzagc;
    private float zzagd;
    private final int zzalc;
    private final int zzald;
    private final int zzale;
    private final int zzalf;
    private final short[] zzalg;
    private int zzalh;
    private short[] zzali;
    private int zzalj;
    private short[] zzalk;
    private int zzall;
    private short[] zzalm;
    private int zzaln;
    private int zzalo;
    private int zzalp;
    private int zzalq;
    private int zzalr;
    private int zzals;
    private int zzalt;
    private int zzalu;
    private int zzalv;
    private int zzalw;

    public zzin(int i, int i2) {
        this.zzafp = i;
        this.zzalc = i2;
        this.zzald = i / LogSeverity.WARNING_VALUE;
        this.zzale = i / 65;
        this.zzalf = this.zzale * 2;
        int i3 = this.zzalf;
        this.zzalg = new short[i3];
        this.zzalh = i3;
        this.zzali = new short[i3 * i2];
        this.zzalj = i3;
        this.zzalk = new short[i3 * i2];
        this.zzall = i3;
        this.zzalm = new short[i3 * i2];
        this.zzaln = 0;
        this.zzalo = 0;
        this.zzalt = 0;
        this.zzagc = 1.0f;
        this.zzagd = 1.0f;
    }

    private final int zza(short[] sArr, int i, int i2, int i3) {
        int i4 = i * this.zzalc;
        int i5 = 1;
        int i6 = 0;
        int i7 = 0;
        int i8 = 255;
        while (i2 <= i3) {
            int i9 = 0;
            for (int i10 = 0; i10 < i2; i10++) {
                short s = sArr[i4 + i10];
                short s2 = sArr[i4 + i2 + i10];
                i9 += s >= s2 ? s - s2 : s2 - s;
            }
            if (i9 * i6 < i5 * i2) {
                i6 = i2;
                i5 = i9;
            }
            if (i9 * i8 > i7 * i2) {
                i8 = i2;
                i7 = i9;
            }
            i2++;
        }
        this.zzalv = i5 / i6;
        this.zzalw = i7 / i8;
        return i6;
    }

    private static void zza(int i, int i2, short[] sArr, int i3, short[] sArr2, int i4, short[] sArr3, int i5) {
        for (int i6 = 0; i6 < i2; i6++) {
            int i7 = (i4 * i2) + i6;
            int i8 = (i5 * i2) + i6;
            int i9 = (i3 * i2) + i6;
            for (int i10 = 0; i10 < i; i10++) {
                sArr[i9] = (short) (((sArr2[i7] * (i - i10)) + (sArr3[i8] * i10)) / i);
                i9 += i2;
                i7 += i2;
                i8 += i2;
            }
        }
    }

    private final void zza(short[] sArr, int i, int i2) {
        zzu(i2);
        int i3 = this.zzalc;
        System.arraycopy(sArr, i * i3, this.zzalk, this.zzalq * i3, i3 * i2);
        this.zzalq += i2;
    }

    private final void zzb(short[] sArr, int i, int i2) {
        int i3 = this.zzalf / i2;
        int i4 = this.zzalc;
        int i5 = i2 * i4;
        int i6 = i * i4;
        for (int i7 = 0; i7 < i3; i7++) {
            int i8 = 0;
            for (int i9 = 0; i9 < i5; i9++) {
                i8 += sArr[(i7 * i5) + i6 + i9];
            }
            this.zzalg[i7] = (short) (i8 / i5);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:81:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x00c9  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0104  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x00ba  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void zzfy() {
        /*
            Method dump skipped, instructions count: 585
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzin.zzfy():void");
    }

    private final void zzu(int i) {
        int i2 = this.zzalq + i;
        int i3 = this.zzalj;
        if (i2 > i3) {
            this.zzalj = i3 + (i3 / 2) + i;
            this.zzalk = Arrays.copyOf(this.zzalk, this.zzalj * this.zzalc);
        }
    }

    private final void zzv(int i) {
        int i2 = this.zzalp + i;
        int i3 = this.zzalh;
        if (i2 > i3) {
            this.zzalh = i3 + (i3 / 2) + i;
            this.zzali = Arrays.copyOf(this.zzali, this.zzalh * this.zzalc);
        }
    }

    public final void setSpeed(float f) {
        this.zzagc = f;
    }

    public final void zza(ShortBuffer shortBuffer) {
        int remaining = shortBuffer.remaining();
        int i = this.zzalc;
        int i2 = remaining / i;
        zzv(i2);
        shortBuffer.get(this.zzali, this.zzalp * this.zzalc, ((i * i2) << 1) / 2);
        this.zzalp += i2;
        zzfy();
    }

    public final void zzb(ShortBuffer shortBuffer) {
        int min = Math.min(shortBuffer.remaining() / this.zzalc, this.zzalq);
        shortBuffer.put(this.zzalk, 0, this.zzalc * min);
        this.zzalq -= min;
        short[] sArr = this.zzalk;
        int i = this.zzalc;
        System.arraycopy(sArr, min * i, sArr, 0, this.zzalq * i);
    }

    public final void zzc(float f) {
        this.zzagd = f;
    }

    public final void zzfb() {
        int i;
        int i2 = this.zzalp;
        float f = this.zzagc;
        float f2 = this.zzagd;
        int i3 = this.zzalq + ((int) ((((i2 / (f / f2)) + this.zzalr) / f2) + 0.5f));
        zzv((this.zzalf * 2) + i2);
        int i4 = 0;
        while (true) {
            i = this.zzalf;
            int i5 = this.zzalc;
            if (i4 >= i * 2 * i5) {
                break;
            }
            this.zzali[(i5 * i2) + i4] = 0;
            i4++;
        }
        this.zzalp += i * 2;
        zzfy();
        if (this.zzalq > i3) {
            this.zzalq = i3;
        }
        this.zzalp = 0;
        this.zzals = 0;
        this.zzalr = 0;
    }

    public final int zzfx() {
        return this.zzalq;
    }
}
