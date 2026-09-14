package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.Arrays;

/* loaded from: classes.dex */
public final class zzmg implements zzmb {
    private final zzmb[] zzbbn;
    private final ArrayList<zzmb> zzbbo;
    private zzme zzbbp;
    private zzhg zzbbq;
    private Object zzbbr;
    private zzmi zzbbt;
    private final zzhl zzacw = new zzhl();
    private int zzbbs = -1;

    public zzmg(zzmb... zzmbVarArr) {
        this.zzbbn = zzmbVarArr;
        this.zzbbo = new ArrayList<>(Arrays.asList(zzmbVarArr));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zza(int i, zzhg zzhgVar, Object obj) {
        zzmi zzmiVar;
        if (this.zzbbt == null) {
            int zzev = zzhgVar.zzev();
            int i2 = 0;
            while (true) {
                if (i2 >= zzev) {
                    if (this.zzbbs == -1) {
                        this.zzbbs = zzhgVar.zzew();
                    } else if (zzhgVar.zzew() != this.zzbbs) {
                        zzmiVar = new zzmi(1);
                    }
                    zzmiVar = null;
                } else {
                    if (zzhgVar.zza(i2, this.zzacw, false).zzagv) {
                        zzmiVar = new zzmi(0);
                        break;
                    }
                    i2++;
                }
            }
            this.zzbbt = zzmiVar;
        }
        if (this.zzbbt != null) {
            return;
        }
        this.zzbbo.remove(this.zzbbn[i]);
        if (i == 0) {
            this.zzbbq = zzhgVar;
            this.zzbbr = obj;
        }
        if (this.zzbbo.isEmpty()) {
            this.zzbbp.zzb(this.zzbbq, this.zzbbr);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzmb
    public final zzlz zza(int i, zznj zznjVar) {
        zzlz[] zzlzVarArr = new zzlz[this.zzbbn.length];
        for (int i2 = 0; i2 < zzlzVarArr.length; i2++) {
            zzlzVarArr[i2] = this.zzbbn[i2].zza(i, zznjVar);
        }
        return new zzmd(zzlzVarArr);
    }

    @Override // com.google.android.gms.internal.ads.zzmb
    public final void zza(zzgk zzgkVar, boolean z, zzme zzmeVar) {
        this.zzbbp = zzmeVar;
        int i = 0;
        while (true) {
            zzmb[] zzmbVarArr = this.zzbbn;
            if (i >= zzmbVarArr.length) {
                return;
            }
            zzmbVarArr[i].zza(zzgkVar, false, new zzmf(this, i));
            i++;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzmb
    public final void zzb(zzlz zzlzVar) {
        zzmd zzmdVar = (zzmd) zzlzVar;
        int i = 0;
        while (true) {
            zzmb[] zzmbVarArr = this.zzbbn;
            if (i >= zzmbVarArr.length) {
                return;
            }
            zzmbVarArr[i].zzb(zzmdVar.zzbbg[i]);
            i++;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzmb
    public final void zzhr() {
        zzmi zzmiVar = this.zzbbt;
        if (zzmiVar != null) {
            throw zzmiVar;
        }
        for (zzmb zzmbVar : this.zzbbn) {
            zzmbVar.zzhr();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzmb
    public final void zzhs() {
        for (zzmb zzmbVar : this.zzbbn) {
            zzmbVar.zzhs();
        }
    }
}
