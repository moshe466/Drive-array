package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public final class zzhk {
    private static final int[] zzagm = {1, 2, 3, 6};
    private static final int[] zzagn = {48000, 44100, 32000};
    private static final int[] zzago = {24000, 22050, 16000};
    private static final int[] zzagp = {2, 1, 2, 3, 3, 4, 4, 5};
    private static final int[] zzagq = {32, 40, 48, 56, 64, 80, 96, 112, 128, 160, 192, 224, 256, 320, 384, 448, 512, 576, 640};
    private static final int[] zzagr = {69, 87, 104, 121, 139, 174, 208, 243, 278, 348, 417, 487, 557, 696, 835, 975, 1114, 1253, 1393};

    public static zzgw zza(zzoj zzojVar, String str, String str2, zziv zzivVar) {
        int i = zzagn[(zzojVar.readUnsignedByte() & 192) >> 6];
        int readUnsignedByte = zzojVar.readUnsignedByte();
        int i2 = zzagp[(readUnsignedByte & 56) >> 3];
        if ((readUnsignedByte & 4) != 0) {
            i2++;
        }
        return zzgw.zza(str, "audio/ac3", null, -1, -1, i2, i, null, null, 0, str2);
    }

    public static zzgw zzb(zzoj zzojVar, String str, String str2, zziv zzivVar) {
        zzojVar.zzbf(2);
        int i = zzagn[(zzojVar.readUnsignedByte() & 192) >> 6];
        int readUnsignedByte = zzojVar.readUnsignedByte();
        int i2 = zzagp[(readUnsignedByte & 14) >> 1];
        if ((readUnsignedByte & 1) != 0) {
            i2++;
        }
        return zzgw.zza(str, "audio/eac3", null, -1, -1, i2, i, null, null, 0, str2);
    }

    public static int zzey() {
        return 1536;
    }

    public static int zzh(ByteBuffer byteBuffer) {
        return (((byteBuffer.get(byteBuffer.position() + 4) & 192) >> 6) != 3 ? zzagm[(byteBuffer.get(byteBuffer.position() + 4) & 48) >> 4] : 6) * 256;
    }
}
