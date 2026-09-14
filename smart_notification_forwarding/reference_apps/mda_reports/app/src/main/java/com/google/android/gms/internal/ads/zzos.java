package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public final class zzos {
    private final int height;
    private final int width;
    public final List<byte[]> zzafg;
    public final int zzaqu;
    public final float zzbgf;

    private zzos(List<byte[]> list, int i, int i2, int i3, float f) {
        this.zzafg = list;
        this.zzaqu = i;
        this.width = i2;
        this.height = i3;
        this.zzbgf = f;
    }

    public static zzos zzf(zzoj zzojVar) {
        int i;
        int i2;
        float f;
        try {
            zzojVar.zzbf(4);
            int readUnsignedByte = (zzojVar.readUnsignedByte() & 3) + 1;
            if (readUnsignedByte == 3) {
                throw new IllegalStateException();
            }
            ArrayList arrayList = new ArrayList();
            int readUnsignedByte2 = zzojVar.readUnsignedByte() & 31;
            for (int i3 = 0; i3 < readUnsignedByte2; i3++) {
                arrayList.add(zzg(zzojVar));
            }
            int readUnsignedByte3 = zzojVar.readUnsignedByte();
            for (int i4 = 0; i4 < readUnsignedByte3; i4++) {
                arrayList.add(zzg(zzojVar));
            }
            if (readUnsignedByte2 > 0) {
                zzoh zzd = zzoi.zzd((byte[]) arrayList.get(0), readUnsignedByte, ((byte[]) arrayList.get(0)).length);
                int i5 = zzd.width;
                int i6 = zzd.height;
                f = zzd.zzbgf;
                i = i5;
                i2 = i6;
            } else {
                i = -1;
                i2 = -1;
                f = 1.0f;
            }
            return new zzos(arrayList, readUnsignedByte, i, i2, f);
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new zzhd("Error parsing AVC config", e);
        }
    }

    private static byte[] zzg(zzoj zzojVar) {
        int readUnsignedShort = zzojVar.readUnsignedShort();
        int position = zzojVar.getPosition();
        zzojVar.zzbf(readUnsignedShort);
        return zzob.zzc(zzojVar.data, position, readUnsignedShort);
    }
}
