package com.google.android.gms.internal.ads;

import java.util.logging.Logger;

/* loaded from: classes.dex */
public class zzdkh implements zzdis<zzdib> {
    private static final Logger logger = Logger.getLogger(zzdkh.class.getName());

    /* loaded from: classes.dex */
    static class zza implements zzdib {
        private final zzdiq<zzdib> zzgzq;

        public zza(zzdiq<zzdib> zzdiqVar) {
            this.zzgzq = zzdiqVar;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdis
    public final /* synthetic */ zzdib zza(zzdiq<zzdib> zzdiqVar) {
        return new zza(zzdiqVar);
    }

    @Override // com.google.android.gms.internal.ads.zzdis
    public final Class<zzdib> zzarz() {
        return zzdib.class;
    }
}
