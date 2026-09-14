package com.google.android.gms.internal.ads;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzaxm implements zzy {
    private final /* synthetic */ String zzdug;
    private final /* synthetic */ zzaxr zzduh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzaxm(zzaxk zzaxkVar, String str, zzaxr zzaxrVar) {
        this.zzdug = str;
        this.zzduh = zzaxrVar;
    }

    @Override // com.google.android.gms.internal.ads.zzy
    public final void zzc(zzae zzaeVar) {
        String str = this.zzdug;
        String exc = zzaeVar.toString();
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 21 + String.valueOf(exc).length());
        sb.append("Failed to load URL: ");
        sb.append(str);
        sb.append("\n");
        sb.append(exc);
        zzayu.zzez(sb.toString());
        this.zzduh.zzb(null);
    }
}
