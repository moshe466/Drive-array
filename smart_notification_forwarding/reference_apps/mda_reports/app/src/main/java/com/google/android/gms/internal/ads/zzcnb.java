package com.google.android.gms.internal.ads;

/* loaded from: classes.dex */
final class zzcnb implements zzbpx {
    private final /* synthetic */ zzcip zzgax;
    private final /* synthetic */ zzazl zzgbi;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzcnb(zzcna zzcnaVar, zzazl zzazlVar, zzcip zzcipVar) {
        this.zzgbi = zzazlVar;
        this.zzgax = zzcipVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbpx
    public final synchronized void onAdFailedToLoad(int i) {
        if (((Boolean) zzve.zzoy().zzd(zzzn.zzcot)).booleanValue()) {
            i = 3;
        }
        zzazl zzazlVar = this.zzgbi;
        String str = this.zzgax.zzfge;
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 23);
        sb.append("adapter ");
        sb.append(str);
        sb.append(" failed to load");
        zzazlVar.setException(new zzclr(sb.toString(), i));
    }

    @Override // com.google.android.gms.internal.ads.zzbpx
    public final synchronized void onAdLoaded() {
        this.zzgbi.set(null);
    }
}
