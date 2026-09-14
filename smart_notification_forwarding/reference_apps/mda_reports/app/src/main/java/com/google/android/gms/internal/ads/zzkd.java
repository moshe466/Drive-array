package com.google.android.gms.internal.ads;

/* loaded from: classes.dex */
final class zzkd {
    public int index;
    public final int length;
    public int zzaup;
    public long zzauq;
    private final boolean zzaur;
    private final zzoj zzaus;
    private final zzoj zzaut;
    private int zzauu;
    private int zzauv;

    public zzkd(zzoj zzojVar, zzoj zzojVar2, boolean z) {
        this.zzaut = zzojVar;
        this.zzaus = zzojVar2;
        this.zzaur = z;
        zzojVar2.zzbe(12);
        this.length = zzojVar2.zzis();
        zzojVar.zzbe(12);
        this.zzauv = zzojVar.zzis();
        zzoc.checkState(zzojVar.readInt() == 1, "first_chunk must be 1");
        this.index = -1;
    }

    public final boolean zzgp() {
        int i = this.index + 1;
        this.index = i;
        if (i == this.length) {
            return false;
        }
        this.zzauq = this.zzaur ? this.zzaus.zzit() : this.zzaus.zzip();
        if (this.index == this.zzauu) {
            this.zzaup = this.zzaut.zzis();
            this.zzaut.zzbf(4);
            int i2 = this.zzauv - 1;
            this.zzauv = i2;
            this.zzauu = i2 > 0 ? this.zzaut.zzis() - 1 : -1;
        }
        return true;
    }
}
