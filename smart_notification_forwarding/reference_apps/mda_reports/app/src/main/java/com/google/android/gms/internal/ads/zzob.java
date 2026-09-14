package com.google.android.gms.internal.ads;

import android.util.Pair;
import io.fabric.sdk.android.services.settings.SettingsJsonConstants;

/* loaded from: classes.dex */
public final class zzob {
    private static final byte[] zzbga = {0, 0, 0, 1};
    private static final int[] zzbgb = {96000, 88200, SettingsJsonConstants.SETTINGS_LOG_BUFFER_SIZE_DEFAULT, 48000, 44100, 32000, 24000, 22050, 16000, 12000, 11025, 8000, 7350};
    private static final int[] zzbgc = {0, 1, 2, 3, 4, 5, 6, 8, -1, -1, -1, 7, 8, -1, 8, -1};

    private static int zza(zzok zzokVar) {
        int zzbh = zzokVar.zzbh(5);
        return zzbh == 31 ? zzokVar.zzbh(6) + 32 : zzbh;
    }

    private static int zzb(zzok zzokVar) {
        int zzbh = zzokVar.zzbh(4);
        if (zzbh == 15) {
            return zzokVar.zzbh(24);
        }
        zzoc.checkArgument(zzbh < 13);
        return zzbgb[zzbh];
    }

    public static byte[] zzc(byte[] bArr, int i, int i2) {
        byte[] bArr2 = zzbga;
        byte[] bArr3 = new byte[bArr2.length + i2];
        System.arraycopy(bArr2, 0, bArr3, 0, bArr2.length);
        System.arraycopy(bArr, i, bArr3, zzbga.length, i2);
        return bArr3;
    }

    public static Pair<Integer, Integer> zze(byte[] bArr) {
        zzok zzokVar = new zzok(bArr);
        int zza = zza(zzokVar);
        int zzb = zzb(zzokVar);
        int zzbh = zzokVar.zzbh(4);
        if (zza == 5 || zza == 29) {
            zzb = zzb(zzokVar);
            if (zza(zzokVar) == 22) {
                zzbh = zzokVar.zzbh(4);
            }
        }
        int i = zzbgc[zzbh];
        zzoc.checkArgument(i != -1);
        return Pair.create(Integer.valueOf(zzb), Integer.valueOf(i));
    }
}
