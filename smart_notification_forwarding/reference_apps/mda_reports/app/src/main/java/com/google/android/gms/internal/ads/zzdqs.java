package com.google.android.gms.internal.ads;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzdqs {
    private final byte[] buffer;
    private final zzdrb zzhic;

    private zzdqs(int i) {
        this.buffer = new byte[i];
        this.zzhic = zzdrb.zzw(this.buffer);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzdqs(int i, zzdqj zzdqjVar) {
        this(i);
    }

    public final zzdqk zzaya() {
        this.zzhic.zzazd();
        return new zzdqu(this.buffer);
    }

    public final zzdrb zzayb() {
        return this.zzhic;
    }
}
