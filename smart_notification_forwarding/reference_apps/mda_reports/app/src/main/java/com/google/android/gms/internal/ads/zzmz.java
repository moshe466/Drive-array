package com.google.android.gms.internal.ads;

import android.util.SparseArray;
import android.util.SparseBooleanArray;
import java.util.Arrays;
import java.util.Map;

/* loaded from: classes.dex */
public abstract class zzmz extends zznf {
    private zznc zzbdx;
    private final SparseArray<Map<zzmr, zznb>> zzbdv = new SparseArray<>();
    private final SparseBooleanArray zzbdw = new SparseBooleanArray();
    private int zzagh = 0;

    protected abstract zzne[] a(zzhe[] zzheVarArr, zzmr[] zzmrVarArr, int[][][] iArr);

    @Override // com.google.android.gms.internal.ads.zznf
    public final zznh zza(zzhe[] zzheVarArr, zzmr zzmrVar) {
        int[] iArr;
        int[] iArr2 = new int[zzheVarArr.length + 1];
        zzms[][] zzmsVarArr = new zzms[zzheVarArr.length + 1];
        int[][][] iArr3 = new int[zzheVarArr.length + 1][];
        for (int i = 0; i < zzmsVarArr.length; i++) {
            int i2 = zzmrVar.length;
            zzmsVarArr[i] = new zzms[i2];
            iArr3[i] = new int[i2];
        }
        int[] iArr4 = new int[zzheVarArr.length];
        for (int i3 = 0; i3 < iArr4.length; i3++) {
            iArr4[i3] = zzheVarArr[i3].zzdw();
        }
        for (int i4 = 0; i4 < zzmrVar.length; i4++) {
            zzms zzav = zzmrVar.zzav(i4);
            int length = zzheVarArr.length;
            int i5 = 0;
            int i6 = 0;
            while (true) {
                if (i5 >= zzheVarArr.length) {
                    i5 = length;
                    break;
                }
                zzhe zzheVar = zzheVarArr[i5];
                int i7 = length;
                int i8 = i6;
                for (int i9 = 0; i9 < zzav.length; i9++) {
                    int zza = zzheVar.zza(zzav.zzaw(i9)) & 3;
                    if (zza > i8) {
                        if (zza == 3) {
                            break;
                        }
                        i7 = i5;
                        i8 = zza;
                    }
                }
                i5++;
                i6 = i8;
                length = i7;
            }
            if (i5 == zzheVarArr.length) {
                iArr = new int[zzav.length];
            } else {
                zzhe zzheVar2 = zzheVarArr[i5];
                int[] iArr5 = new int[zzav.length];
                for (int i10 = 0; i10 < zzav.length; i10++) {
                    iArr5[i10] = zzheVar2.zza(zzav.zzaw(i10));
                }
                iArr = iArr5;
            }
            int i11 = iArr2[i5];
            zzmsVarArr[i5][i11] = zzav;
            iArr3[i5][i11] = iArr;
            iArr2[i5] = iArr2[i5] + 1;
        }
        zzmr[] zzmrVarArr = new zzmr[zzheVarArr.length];
        int[] iArr6 = new int[zzheVarArr.length];
        for (int i12 = 0; i12 < zzheVarArr.length; i12++) {
            int i13 = iArr2[i12];
            zzmrVarArr[i12] = new zzmr((zzms[]) Arrays.copyOf(zzmsVarArr[i12], i13));
            iArr3[i12] = (int[][]) Arrays.copyOf(iArr3[i12], i13);
            iArr6[i12] = zzheVarArr[i12].getTrackType();
        }
        zzmr zzmrVar2 = new zzmr((zzms[]) Arrays.copyOf(zzmsVarArr[zzheVarArr.length], iArr2[zzheVarArr.length]));
        zzne[] a = a(zzheVarArr, zzmrVarArr, iArr3);
        int i14 = 0;
        while (true) {
            if (i14 >= zzheVarArr.length) {
                zznc zzncVar = new zznc(iArr6, zzmrVarArr, iArr4, iArr3, zzmrVar2);
                zzhh[] zzhhVarArr = new zzhh[zzheVarArr.length];
                for (int i15 = 0; i15 < zzheVarArr.length; i15++) {
                    zzhhVarArr[i15] = a[i15] != null ? zzhh.zzagg : null;
                }
                return new zznh(zzmrVar, new zzng(a), zzncVar, zzhhVarArr);
            }
            if (this.zzbdw.get(i14)) {
                a[i14] = null;
            } else {
                zzmr zzmrVar3 = zzmrVarArr[i14];
                Map<zzmr, zznb> map = this.zzbdv.get(i14);
                if ((map != null ? map.get(zzmrVar3) : null) != null) {
                    throw new NoSuchMethodError();
                }
            }
            i14++;
        }
    }

    @Override // com.google.android.gms.internal.ads.zznf
    public final void zzd(Object obj) {
        this.zzbdx = (zznc) obj;
    }

    public final void zzf(int i, boolean z) {
        if (this.zzbdw.get(i) == z) {
            return;
        }
        this.zzbdw.put(i, z);
        a();
    }
}
