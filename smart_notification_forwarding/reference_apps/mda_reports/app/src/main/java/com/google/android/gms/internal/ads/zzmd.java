package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.IdentityHashMap;

/* loaded from: classes.dex */
final class zzmd implements zzlz, zzmc {
    private zzmr zzadg;
    private zzmc zzbae;
    public final zzlz[] zzbbg;
    private final IdentityHashMap<zzmo, Integer> zzbbh = new IdentityHashMap<>();
    private int zzbbi;
    private zzlz[] zzbbj;
    private zzmn zzbbk;

    public zzmd(zzlz... zzlzVarArr) {
        this.zzbbg = zzlzVarArr;
    }

    @Override // com.google.android.gms.internal.ads.zzlz
    public final long zza(zzne[] zzneVarArr, boolean[] zArr, zzmo[] zzmoVarArr, boolean[] zArr2, long j) {
        int[] iArr = new int[zzneVarArr.length];
        int[] iArr2 = new int[zzneVarArr.length];
        for (int i = 0; i < zzneVarArr.length; i++) {
            iArr[i] = zzmoVarArr[i] == null ? -1 : this.zzbbh.get(zzmoVarArr[i]).intValue();
            iArr2[i] = -1;
            if (zzneVarArr[i] != null) {
                zzms zzid = zzneVarArr[i].zzid();
                int i2 = 0;
                while (true) {
                    zzlz[] zzlzVarArr = this.zzbbg;
                    if (i2 >= zzlzVarArr.length) {
                        break;
                    }
                    if (zzlzVarArr[i2].zzhg().zza(zzid) != -1) {
                        iArr2[i] = i2;
                        break;
                    }
                    i2++;
                }
            }
        }
        this.zzbbh.clear();
        zzmo[] zzmoVarArr2 = new zzmo[zzneVarArr.length];
        zzmo[] zzmoVarArr3 = new zzmo[zzneVarArr.length];
        zzne[] zzneVarArr2 = new zzne[zzneVarArr.length];
        ArrayList arrayList = new ArrayList(this.zzbbg.length);
        long j2 = j;
        int i3 = 0;
        while (i3 < this.zzbbg.length) {
            for (int i4 = 0; i4 < zzneVarArr.length; i4++) {
                zzne zzneVar = null;
                zzmoVarArr3[i4] = iArr[i4] == i3 ? zzmoVarArr[i4] : null;
                if (iArr2[i4] == i3) {
                    zzneVar = zzneVarArr[i4];
                }
                zzneVarArr2[i4] = zzneVar;
            }
            zzne[] zzneVarArr3 = zzneVarArr2;
            ArrayList arrayList2 = arrayList;
            zzne[] zzneVarArr4 = zzneVarArr2;
            int i5 = i3;
            long zza = this.zzbbg[i3].zza(zzneVarArr3, zArr, zzmoVarArr3, zArr2, j2);
            if (i5 == 0) {
                j2 = zza;
            } else if (zza != j2) {
                throw new IllegalStateException("Children enabled at different positions");
            }
            boolean z = false;
            for (int i6 = 0; i6 < zzneVarArr.length; i6++) {
                if (iArr2[i6] == i5) {
                    zzoc.checkState(zzmoVarArr3[i6] != null);
                    zzmoVarArr2[i6] = zzmoVarArr3[i6];
                    this.zzbbh.put(zzmoVarArr3[i6], Integer.valueOf(i5));
                    z = true;
                } else if (iArr[i6] == i5) {
                    zzoc.checkState(zzmoVarArr3[i6] == null);
                }
            }
            if (z) {
                arrayList2.add(this.zzbbg[i5]);
            }
            i3 = i5 + 1;
            arrayList = arrayList2;
            zzneVarArr2 = zzneVarArr4;
        }
        ArrayList arrayList3 = arrayList;
        System.arraycopy(zzmoVarArr2, 0, zzmoVarArr, 0, zzmoVarArr2.length);
        this.zzbbj = new zzlz[arrayList3.size()];
        arrayList3.toArray(this.zzbbj);
        this.zzbbk = new zzlq(this.zzbbj);
        return j2;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.google.android.gms.internal.ads.zzmc
    public final void zza(zzlz zzlzVar) {
        int i = this.zzbbi - 1;
        this.zzbbi = i;
        if (i > 0) {
            return;
        }
        int i2 = 0;
        for (zzlz zzlzVar2 : this.zzbbg) {
            i2 += zzlzVar2.zzhg().length;
        }
        zzms[] zzmsVarArr = new zzms[i2];
        zzlz[] zzlzVarArr = this.zzbbg;
        int length = zzlzVarArr.length;
        int i3 = 0;
        int i4 = 0;
        while (i3 < length) {
            zzmr zzhg = zzlzVarArr[i3].zzhg();
            int i5 = zzhg.length;
            int i6 = i4;
            int i7 = 0;
            while (i7 < i5) {
                zzmsVarArr[i6] = zzhg.zzav(i7);
                i7++;
                i6++;
            }
            i3++;
            i4 = i6;
        }
        this.zzadg = new zzmr(zzmsVarArr);
        this.zzbae.zza((zzlz) this);
    }

    @Override // com.google.android.gms.internal.ads.zzlz
    public final void zza(zzmc zzmcVar, long j) {
        this.zzbae = zzmcVar;
        zzlz[] zzlzVarArr = this.zzbbg;
        this.zzbbi = zzlzVarArr.length;
        for (zzlz zzlzVar : zzlzVarArr) {
            zzlzVar.zza(this, j);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzmq
    public final /* synthetic */ void zza(zzlz zzlzVar) {
        if (this.zzadg != null) {
            this.zzbae.zza((zzmc) this);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzlz
    public final void zzee(long j) {
        for (zzlz zzlzVar : this.zzbbj) {
            zzlzVar.zzee(j);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzlz, com.google.android.gms.internal.ads.zzmn
    public final boolean zzef(long j) {
        return this.zzbbk.zzef(j);
    }

    @Override // com.google.android.gms.internal.ads.zzlz
    public final long zzeg(long j) {
        long zzeg = this.zzbbj[0].zzeg(j);
        int i = 1;
        while (true) {
            zzlz[] zzlzVarArr = this.zzbbj;
            if (i >= zzlzVarArr.length) {
                return zzeg;
            }
            if (zzlzVarArr[i].zzeg(zzeg) != zzeg) {
                throw new IllegalStateException("Children seeked to different positions");
            }
            i++;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzlz
    public final void zzhf() {
        for (zzlz zzlzVar : this.zzbbg) {
            zzlzVar.zzhf();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzlz
    public final zzmr zzhg() {
        return this.zzadg;
    }

    @Override // com.google.android.gms.internal.ads.zzlz, com.google.android.gms.internal.ads.zzmn
    public final long zzhh() {
        return this.zzbbk.zzhh();
    }

    @Override // com.google.android.gms.internal.ads.zzlz
    public final long zzhi() {
        long zzhi = this.zzbbg[0].zzhi();
        int i = 1;
        while (true) {
            zzlz[] zzlzVarArr = this.zzbbg;
            if (i >= zzlzVarArr.length) {
                if (zzhi != -9223372036854775807L) {
                    for (zzlz zzlzVar : this.zzbbj) {
                        if (zzlzVar != this.zzbbg[0] && zzlzVar.zzeg(zzhi) != zzhi) {
                            throw new IllegalStateException("Children seeked to different positions");
                        }
                    }
                }
                return zzhi;
            }
            if (zzlzVarArr[i].zzhi() != -9223372036854775807L) {
                throw new IllegalStateException("Child reported discontinuity");
            }
            i++;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzlz
    public final long zzhj() {
        long j = Long.MAX_VALUE;
        for (zzlz zzlzVar : this.zzbbj) {
            long zzhj = zzlzVar.zzhj();
            if (zzhj != Long.MIN_VALUE) {
                j = Math.min(j, zzhj);
            }
        }
        if (j == Long.MAX_VALUE) {
            return Long.MIN_VALUE;
        }
        return j;
    }
}
