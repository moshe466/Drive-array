package com.google.android.recaptcha.internal;

import android.util.Base64;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.SecureRandom;
import org.apache.tika.fork.ForkServer;

/* loaded from: classes.dex */
public final class zzqc {
    protected static final Charset zza = StandardCharsets.UTF_16;
    protected int[] zzb;
    protected int[] zzc;
    private final int[] zzd = {511133343, 1277647508, 107287496, 338123662};
    private byte[] zze;
    private byte[] zzf;
    private int zzg;

    public zzqc() {
    }

    public static int zza(int i, int i3) {
        if (i % 2 != 0) {
            return (i | i3) - (i & i3);
        }
        return ((~i) & i3) | ((~i3) & i);
    }

    public static String zze(String str, byte[] bArr, zzqd zzqdVar) {
        byte[] decode = Base64.decode(str, 0);
        byte[] bArr2 = new byte[12];
        int length = decode.length - 12;
        byte[] bArr3 = new byte[length];
        System.arraycopy(decode, 0, bArr2, 0, 12);
        System.arraycopy(decode, 12, bArr3, 0, length);
        return new String(new zzqc(bArr, bArr2).zzd(bArr3), zza);
    }

    public static String zzf(String str, byte[] bArr, zzqd zzqdVar) {
        byte[] bArr2 = new byte[12];
        new SecureRandom().nextBytes(bArr2);
        byte[] zzd = new zzqc(bArr, bArr2).zzd(str.getBytes(zza));
        int length = zzd.length;
        byte[] bArr3 = new byte[length + 12];
        System.arraycopy(bArr2, 0, bArr3, 0, 12);
        System.arraycopy(zzd, 0, bArr3, 12, length);
        return Base64.encodeToString(bArr3, 2);
    }

    private static final int zzg(byte[] bArr, int i) {
        int i3 = bArr[i] & ForkServer.ERROR;
        int i4 = bArr[i + 1] & ForkServer.ERROR;
        int i5 = bArr[i + 2] & ForkServer.ERROR;
        return ((bArr[i + 3] & ForkServer.ERROR) << 24) | (i4 << 8) | i3 | (i5 << 16);
    }

    public final void zzb(int i, int i3, int i4, int i5) {
        zzc(i, i3, i5, 16);
        zzc(i4, i5, i3, 12);
        zzc(i, i3, i5, 8);
        zzc(i4, i5, i3, 7);
    }

    public final void zzc(int i, int i3, int i4, int i5) {
        int[] iArr = this.zzb;
        int i6 = iArr[i] + iArr[i3];
        iArr[i] = i6;
        int zza2 = zza(iArr[i4], i6);
        iArr[i4] = zza2;
        iArr[i4] = (zza2 << i5) | (zza2 >>> (32 - i5));
    }

    public final byte[] zzd(byte[] bArr) {
        if (this.zzg == 1) {
            int length = bArr.length;
            byte[] bArr2 = new byte[length];
            int i = 0;
            while (length > 0) {
                int[] iArr = this.zzc;
                int[] iArr2 = this.zzb;
                int length2 = iArr.length;
                System.arraycopy(iArr, 0, iArr2, 0, 16);
                this.zzb[12] = this.zzg;
                for (int i3 = 0; i3 < 10; i3++) {
                    zzb(0, 4, 8, 12);
                    zzb(1, 5, 9, 13);
                    zzb(2, 6, 10, 14);
                    zzb(3, 7, 11, 15);
                    zzb(0, 5, 10, 15);
                    zzb(1, 6, 11, 12);
                    zzb(2, 7, 8, 13);
                    zzb(3, 4, 9, 14);
                }
                byte[] bArr3 = new byte[64];
                for (int i4 = 0; i4 < 16; i4++) {
                    int i5 = this.zzb[i4];
                    int i6 = i4 * 4;
                    bArr3[i6] = (byte) (i5 & 255);
                    bArr3[i6 + 1] = (byte) ((i5 >> 8) & 255);
                    bArr3[i6 + 2] = (byte) ((i5 >> 16) & 255);
                    bArr3[i6 + 3] = (byte) ((i5 >> 24) & 255);
                }
                for (int i7 = 0; i7 < Math.min(64, length); i7++) {
                    int i8 = i + i7;
                    bArr2[i8] = (byte) zza(bArr3[i7], bArr[i8]);
                }
                this.zzg++;
                length -= 64;
                i += 64;
            }
            return bArr2;
        }
        throw new IllegalStateException();
    }

    public zzqc(byte[] bArr, byte[] bArr2) {
        if (bArr.length == 32) {
            this.zze = bArr;
            this.zzg = 1;
            this.zzf = bArr2;
            this.zzb = new int[16];
            for (int i = 0; i < 4; i++) {
                this.zzb[i] = zza(this.zzd[i], 2131181306);
            }
            for (int i3 = 4; i3 < 12; i3++) {
                this.zzb[i3] = zzg(this.zze, (i3 - 4) * 4);
            }
            this.zzb[12] = this.zzg;
            for (int i4 = 13; i4 < 16; i4++) {
                this.zzb[i4] = zzg(this.zzf, (i4 - 13) * 4);
            }
            int[] iArr = new int[16];
            this.zzc = iArr;
            int[] iArr2 = this.zzb;
            int length = iArr2.length;
            System.arraycopy(iArr2, 0, iArr, 0, 16);
            return;
        }
        throw new IllegalArgumentException();
    }
}
