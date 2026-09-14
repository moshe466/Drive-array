package com.google.android.gms.internal.ads;

/* loaded from: classes.dex */
public class zzdsj {
    private static final zzdrg zzhhl = zzdrg.zzazh();
    private zzdqk zzhob;
    private volatile zzdte zzhoc;
    private volatile zzdqk zzhod;

    private final zzdte zzm(zzdte zzdteVar) {
        if (this.zzhoc == null) {
            synchronized (this) {
                if (this.zzhoc == null) {
                    try {
                        this.zzhoc = zzdteVar;
                        this.zzhod = zzdqk.zzhhx;
                    } catch (zzdse unused) {
                        this.zzhoc = zzdteVar;
                        this.zzhod = zzdqk.zzhhx;
                    }
                }
            }
        }
        return this.zzhoc;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzdsj)) {
            return false;
        }
        zzdsj zzdsjVar = (zzdsj) obj;
        zzdte zzdteVar = this.zzhoc;
        zzdte zzdteVar2 = zzdsjVar.zzhoc;
        return (zzdteVar == null && zzdteVar2 == null) ? zzaxk().equals(zzdsjVar.zzaxk()) : (zzdteVar == null || zzdteVar2 == null) ? zzdteVar != null ? zzdteVar.equals(zzdsjVar.zzm(zzdteVar.zzazz())) : zzm(zzdteVar2.zzazz()).equals(zzdteVar2) : zzdteVar.equals(zzdteVar2);
    }

    public int hashCode() {
        return 1;
    }

    public final zzdqk zzaxk() {
        if (this.zzhod != null) {
            return this.zzhod;
        }
        synchronized (this) {
            if (this.zzhod != null) {
                return this.zzhod;
            }
            this.zzhod = this.zzhoc == null ? zzdqk.zzhhx : this.zzhoc.zzaxk();
            return this.zzhod;
        }
    }

    public final int zzazu() {
        if (this.zzhod != null) {
            return this.zzhod.size();
        }
        if (this.zzhoc != null) {
            return this.zzhoc.zzazu();
        }
        return 0;
    }

    public final zzdte zzn(zzdte zzdteVar) {
        zzdte zzdteVar2 = this.zzhoc;
        this.zzhob = null;
        this.zzhod = null;
        this.zzhoc = zzdteVar;
        return zzdteVar2;
    }
}
