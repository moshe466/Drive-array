package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes.dex */
final class zzkc extends zzjz {
    public final long zzaum;
    public final List<zzkb> zzaun;
    public final List<zzkc> zzauo;

    public zzkc(int i, long j) {
        super(i);
        this.zzaum = j;
        this.zzaun = new ArrayList();
        this.zzauo = new ArrayList();
    }

    @Override // com.google.android.gms.internal.ads.zzjz
    public final String toString() {
        String zzam = zzjz.zzam(this.type);
        String arrays = Arrays.toString(this.zzaun.toArray());
        String arrays2 = Arrays.toString(this.zzauo.toArray());
        StringBuilder sb = new StringBuilder(String.valueOf(zzam).length() + 22 + String.valueOf(arrays).length() + String.valueOf(arrays2).length());
        sb.append(zzam);
        sb.append(" leaves: ");
        sb.append(arrays);
        sb.append(" containers: ");
        sb.append(arrays2);
        return sb.toString();
    }

    public final zzkb zzao(int i) {
        int size = this.zzaun.size();
        for (int i2 = 0; i2 < size; i2++) {
            zzkb zzkbVar = this.zzaun.get(i2);
            if (zzkbVar.type == i) {
                return zzkbVar;
            }
        }
        return null;
    }

    public final zzkc zzap(int i) {
        int size = this.zzauo.size();
        for (int i2 = 0; i2 < size; i2++) {
            zzkc zzkcVar = this.zzauo.get(i2);
            if (zzkcVar.type == i) {
                return zzkcVar;
            }
        }
        return null;
    }
}
