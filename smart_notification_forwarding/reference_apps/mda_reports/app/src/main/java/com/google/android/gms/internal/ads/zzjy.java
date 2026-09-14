package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

/* loaded from: classes.dex */
public final class zzjy {
    public int height;
    public int number;
    public int type;
    public int width;
    public zziv zzafh;
    public int zzafl;
    public byte[] zzafm;
    public int zzafo;
    public int zzafp;
    private String zzafv;
    public String zzapp;
    public int zzapq;
    public boolean zzapr;
    public byte[] zzaps;
    public zzjn zzapt;
    public byte[] zzapu;
    public int zzapv;
    public int zzapw;
    public int zzapx;
    public boolean zzapy;
    public int zzapz;
    public int zzaqa;
    public int zzaqb;
    public int zzaqc;
    public int zzaqd;
    public float zzaqe;
    public float zzaqf;
    public float zzaqg;
    public float zzaqh;
    public float zzaqi;
    public float zzaqj;
    public float zzaqk;
    public float zzaql;
    public float zzaqm;
    public float zzaqn;
    public int zzaqo;
    public long zzaqp;
    public long zzaqq;
    public boolean zzaqr;
    public boolean zzaqs;
    public zzjo zzaqt;
    public int zzaqu;

    private zzjy() {
        this.width = -1;
        this.height = -1;
        this.zzapv = -1;
        this.zzapw = -1;
        this.zzapx = 0;
        this.zzafm = null;
        this.zzafl = -1;
        this.zzapy = false;
        this.zzapz = -1;
        this.zzaqa = -1;
        this.zzaqb = -1;
        this.zzaqc = 1000;
        this.zzaqd = 200;
        this.zzaqe = -1.0f;
        this.zzaqf = -1.0f;
        this.zzaqg = -1.0f;
        this.zzaqh = -1.0f;
        this.zzaqi = -1.0f;
        this.zzaqj = -1.0f;
        this.zzaqk = -1.0f;
        this.zzaql = -1.0f;
        this.zzaqm = -1.0f;
        this.zzaqn = -1.0f;
        this.zzafo = 1;
        this.zzaqo = -1;
        this.zzafp = 8000;
        this.zzaqp = 0L;
        this.zzaqq = 0L;
        this.zzaqs = true;
        this.zzafv = "eng";
    }

    public /* synthetic */ zzjy(zzjw zzjwVar) {
        this();
    }

    public static /* synthetic */ String a(zzjy zzjyVar, String str) {
        zzjyVar.zzafv = str;
        return str;
    }

    private static List<byte[]> zza(zzoj zzojVar) {
        try {
            zzojVar.zzbf(16);
            if (zzojVar.zziq() != 826496599) {
                return null;
            }
            byte[] bArr = zzojVar.data;
            for (int position = zzojVar.getPosition() + 20; position < bArr.length - 4; position++) {
                if (bArr[position] == 0 && bArr[position + 1] == 0 && bArr[position + 2] == 1 && bArr[position + 3] == 15) {
                    return Collections.singletonList(Arrays.copyOfRange(bArr, position, bArr.length));
                }
            }
            throw new zzhd("Failed to find FourCC VC1 initialization data");
        } catch (ArrayIndexOutOfBoundsException unused) {
            throw new zzhd("Error parsing FourCC VC1 codec private");
        }
    }

    private static boolean zzb(zzoj zzojVar) {
        UUID uuid;
        UUID uuid2;
        try {
            int zzio = zzojVar.zzio();
            if (zzio == 1) {
                return true;
            }
            if (zzio == 65534) {
                zzojVar.zzbe(24);
                long readLong = zzojVar.readLong();
                uuid = zzjt.zzanp;
                if (readLong == uuid.getMostSignificantBits()) {
                    long readLong2 = zzojVar.readLong();
                    uuid2 = zzjt.zzanp;
                    if (readLong2 == uuid2.getLeastSignificantBits()) {
                        return true;
                    }
                }
            }
            return false;
        } catch (ArrayIndexOutOfBoundsException unused) {
            throw new zzhd("Error parsing MS/ACM codec private");
        }
    }

    private static List<byte[]> zzd(byte[] bArr) {
        try {
            if (bArr[0] != 2) {
                throw new zzhd("Error parsing vorbis codec private");
            }
            int i = 1;
            int i2 = 0;
            while (bArr[i] == -1) {
                i2 += 255;
                i++;
            }
            int i3 = i + 1;
            int i4 = i2 + bArr[i];
            int i5 = 0;
            while (bArr[i3] == -1) {
                i5 += 255;
                i3++;
            }
            int i6 = i3 + 1;
            int i7 = i5 + bArr[i3];
            if (bArr[i6] != 1) {
                throw new zzhd("Error parsing vorbis codec private");
            }
            byte[] bArr2 = new byte[i4];
            System.arraycopy(bArr, i6, bArr2, 0, i4);
            int i8 = i6 + i4;
            if (bArr[i8] != 3) {
                throw new zzhd("Error parsing vorbis codec private");
            }
            int i9 = i8 + i7;
            if (bArr[i9] != 5) {
                throw new zzhd("Error parsing vorbis codec private");
            }
            byte[] bArr3 = new byte[bArr.length - i9];
            System.arraycopy(bArr, i9, bArr3, 0, bArr.length - i9);
            ArrayList arrayList = new ArrayList(2);
            arrayList.add(bArr2);
            arrayList.add(bArr3);
            return arrayList;
        } catch (ArrayIndexOutOfBoundsException unused) {
            throw new zzhd("Error parsing vorbis codec private");
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:7:0x015f. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:17:0x02f6  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0300  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0323  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x02f8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void zza(com.google.android.gms.internal.ads.zzjf r30, int r31) {
        /*
            Method dump skipped, instructions count: 1376
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzjy.zza(com.google.android.gms.internal.ads.zzjf, int):void");
    }
}
