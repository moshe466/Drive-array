package com.google.android.gms.internal.ads;

import java.util.logging.Logger;

/* loaded from: classes.dex */
class zzdkx implements zzdis<zzdio> {
    private static final Logger logger = Logger.getLogger(zzdkx.class.getName());

    /* loaded from: classes.dex */
    static class zza implements zzdio {
        private final zzdiq<zzdio> zzgzq;
        private final byte[] zzhae;

        private zza(zzdiq<zzdio> zzdiqVar) {
            this.zzhae = new byte[]{0};
            this.zzgzq = zzdiqVar;
        }

        @Override // com.google.android.gms.internal.ads.zzdio
        public final byte[] zzl(byte[] bArr) {
            return this.zzgzq.zzasm().zzask().equals(zzdnw.LEGACY) ? zzdoi.zza(this.zzgzq.zzasm().zzasl(), this.zzgzq.zzasm().zzasi().zzl(zzdoi.zza(bArr, this.zzhae))) : zzdoi.zza(this.zzgzq.zzasm().zzasl(), this.zzgzq.zzasm().zzasi().zzl(bArr));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdis
    public final /* synthetic */ zzdio zza(zzdiq<zzdio> zzdiqVar) {
        return new zza(zzdiqVar);
    }

    @Override // com.google.android.gms.internal.ads.zzdis
    public final Class<zzdio> zzarz() {
        return zzdio.class;
    }
}
