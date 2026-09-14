package com.google.android.gms.internal.ads;

/* loaded from: classes.dex */
final class zzdbc {
    private final zzdbf zzgnw = new zzdbf();
    private int zzgnx;
    private int zzgny;
    private int zzgnz;
    private int zzgoa;
    private int zzgob;

    public final void zzape() {
        this.zzgnz++;
    }

    public final void zzapf() {
        this.zzgoa++;
    }

    public final void zzapg() {
        this.zzgnx++;
        this.zzgnw.zzgoq = true;
    }

    public final void zzaph() {
        this.zzgny++;
        this.zzgnw.zzgor = true;
    }

    public final void zzapi() {
        this.zzgob++;
    }

    public final zzdbf zzapj() {
        zzdbf zzdbfVar = (zzdbf) this.zzgnw.clone();
        zzdbf zzdbfVar2 = this.zzgnw;
        zzdbfVar2.zzgoq = false;
        zzdbfVar2.zzgor = false;
        return zzdbfVar;
    }

    public final String zzapk() {
        return "\n\tPool does not exist: " + this.zzgnz + "\n\tNew pools created: " + this.zzgnx + "\n\tPools removed: " + this.zzgny + "\n\tEntries added: " + this.zzgob + "\n\tNo entries retrieved: " + this.zzgoa + "\n";
    }
}
