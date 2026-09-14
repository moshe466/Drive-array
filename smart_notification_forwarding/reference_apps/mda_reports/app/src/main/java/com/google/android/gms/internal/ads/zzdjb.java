package com.google.android.gms.internal.ads;

import java.util.logging.Logger;

/* loaded from: classes.dex */
public class zzdjb implements zzdis<zzdhx> {
    private static final Logger logger = Logger.getLogger(zzdjb.class.getName());

    /* loaded from: classes.dex */
    static class zza implements zzdhx {
        private final zzdiq<zzdhx> zzgzb;

        private zza(zzdiq<zzdhx> zzdiqVar) {
            this.zzgzb = zzdiqVar;
        }

        @Override // com.google.android.gms.internal.ads.zzdhx
        public final byte[] zzc(byte[] bArr, byte[] bArr2) {
            return zzdoi.zza(this.zzgzb.zzasm().zzasl(), this.zzgzb.zzasm().zzasi().zzc(bArr, bArr2));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdis
    public final /* synthetic */ zzdhx zza(zzdiq<zzdhx> zzdiqVar) {
        return new zza(zzdiqVar);
    }

    @Override // com.google.android.gms.internal.ads.zzdis
    public final Class<zzdhx> zzarz() {
        return zzdhx.class;
    }
}
