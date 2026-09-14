package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
public final class zzoy {
    public final List<byte[]> zzafg;
    public final int zzaqu;

    private zzoy(List<byte[]> list, int i) {
        this.zzafg = list;
        this.zzaqu = i;
    }

    public static zzoy zzh(zzoj zzojVar) {
        try {
            zzojVar.zzbf(21);
            int readUnsignedByte = zzojVar.readUnsignedByte() & 3;
            int readUnsignedByte2 = zzojVar.readUnsignedByte();
            int position = zzojVar.getPosition();
            int i = 0;
            int i2 = 0;
            while (i < readUnsignedByte2) {
                zzojVar.zzbf(1);
                int readUnsignedShort = zzojVar.readUnsignedShort();
                int i3 = i2;
                for (int i4 = 0; i4 < readUnsignedShort; i4++) {
                    int readUnsignedShort2 = zzojVar.readUnsignedShort();
                    i3 += readUnsignedShort2 + 4;
                    zzojVar.zzbf(readUnsignedShort2);
                }
                i++;
                i2 = i3;
            }
            zzojVar.zzbe(position);
            byte[] bArr = new byte[i2];
            int i5 = 0;
            int i6 = 0;
            while (i5 < readUnsignedByte2) {
                zzojVar.zzbf(1);
                int readUnsignedShort3 = zzojVar.readUnsignedShort();
                int i7 = i6;
                for (int i8 = 0; i8 < readUnsignedShort3; i8++) {
                    int readUnsignedShort4 = zzojVar.readUnsignedShort();
                    System.arraycopy(zzoi.zzbga, 0, bArr, i7, zzoi.zzbga.length);
                    int length = i7 + zzoi.zzbga.length;
                    System.arraycopy(zzojVar.data, zzojVar.getPosition(), bArr, length, readUnsignedShort4);
                    i7 = length + readUnsignedShort4;
                    zzojVar.zzbf(readUnsignedShort4);
                }
                i5++;
                i6 = i7;
            }
            return new zzoy(i2 == 0 ? null : Collections.singletonList(bArr), readUnsignedByte + 1);
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new zzhd("Error parsing HEVC config", e);
        }
    }
}
