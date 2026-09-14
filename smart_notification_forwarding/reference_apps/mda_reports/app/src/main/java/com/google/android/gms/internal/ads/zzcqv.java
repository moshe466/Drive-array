package com.google.android.gms.internal.ads;

import android.os.Bundle;

/* loaded from: classes.dex */
public final class zzcqv implements zzcub<Object> {
    private static final Object lock = new Object();
    private final String zzcdu;
    private final String zzdir;
    private final zzczu zzfgl;
    private final zzbnk zzgfb;
    private final zzdak zzgfc;

    public zzcqv(String str, String str2, zzbnk zzbnkVar, zzdak zzdakVar, zzczu zzczuVar) {
        this.zzdir = str;
        this.zzcdu = str2;
        this.zzgfb = zzbnkVar;
        this.zzgfc = zzdakVar;
        this.zzfgl = zzczuVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void a(Bundle bundle, Bundle bundle2) {
        if (!((Boolean) zzve.zzoy().zzd(zzzn.zzcpa)).booleanValue()) {
            if (((Boolean) zzve.zzoy().zzd(zzzn.zzcoz)).booleanValue()) {
                synchronized (lock) {
                    this.zzgfb.zzf(this.zzfgl.zzgml);
                    bundle2.putBundle("quality_signals", this.zzgfc.zzaov());
                }
                bundle2.putString("seq_num", this.zzdir);
                bundle2.putString("session_id", this.zzcdu);
            }
            this.zzgfb.zzf(this.zzfgl.zzgml);
            bundle = this.zzgfc.zzaov();
        }
        bundle2.putBundle("quality_signals", bundle);
        bundle2.putString("seq_num", this.zzdir);
        bundle2.putString("session_id", this.zzcdu);
    }

    @Override // com.google.android.gms.internal.ads.zzcub
    public final zzdhe<Object> zzanc() {
        final Bundle bundle = new Bundle();
        if (((Boolean) zzve.zzoy().zzd(zzzn.zzcpa)).booleanValue()) {
            this.zzgfb.zzf(this.zzfgl.zzgml);
            bundle.putAll(this.zzgfc.zzaov());
        }
        return zzdgs.zzaj(new zzcty(this, bundle) { // from class: com.google.android.gms.internal.ads.zzcqu
            private final Bundle zzdpq;
            private final zzcqv zzgfa;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzgfa = this;
                this.zzdpq = bundle;
            }

            @Override // com.google.android.gms.internal.ads.zzcty
            public final void zzr(Object obj) {
                this.zzgfa.a(this.zzdpq, (Bundle) obj);
            }
        });
    }
}
