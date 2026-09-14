package com.google.android.gms.internal.ads;

/* loaded from: classes.dex */
final /* synthetic */ class zzaua implements zzaui {
    static final zzaui a = new zzaua();

    private zzaua() {
    }

    @Override // com.google.android.gms.internal.ads.zzaui
    public final Object zzb(zzbfq zzbfqVar) {
        String currentScreenName = zzbfqVar.getCurrentScreenName();
        if (currentScreenName != null) {
            return currentScreenName;
        }
        String currentScreenClass = zzbfqVar.getCurrentScreenClass();
        return currentScreenClass != null ? currentScreenClass : "";
    }
}
