package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.Arrays;

/* loaded from: classes.dex */
final class zzdkm implements zzdop {
    private final String zzgzr;
    private final int zzgzs;
    private zzdlv zzgzt;
    private zzdlf zzgzu;
    private int zzgzv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzdkm(zzdng zzdngVar) {
        this.zzgzr = zzdngVar.zzavi();
        if (this.zzgzr.equals(zzdiy.zzgys)) {
            try {
                zzdlw zzaf = zzdlw.zzaf(zzdngVar.zzavj());
                this.zzgzt = (zzdlv) zzdit.zzb(zzdngVar);
                this.zzgzs = zzaf.getKeySize();
                return;
            } catch (zzdse e) {
                throw new GeneralSecurityException("invalid KeyFormat protobuf, expected AesGcmKeyFormat", e);
            }
        }
        if (!this.zzgzr.equals(zzdiy.zzgyr)) {
            String valueOf = String.valueOf(this.zzgzr);
            throw new GeneralSecurityException(valueOf.length() != 0 ? "unsupported AEAD DEM key type: ".concat(valueOf) : new String("unsupported AEAD DEM key type: "));
        }
        try {
            zzdlg zzx = zzdlg.zzx(zzdngVar.zzavj());
            this.zzgzu = (zzdlf) zzdit.zzb(zzdngVar);
            this.zzgzv = zzx.zzate().getKeySize();
            this.zzgzs = this.zzgzv + zzx.zzatf().getKeySize();
        } catch (zzdse e2) {
            throw new GeneralSecurityException("invalid KeyFormat protobuf, expected AesCtrHmacAeadKeyFormat", e2);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdop
    public final int zzasr() {
        return this.zzgzs;
    }

    @Override // com.google.android.gms.internal.ads.zzdop
    public final zzdhx zzm(byte[] bArr) {
        zzdte zzdteVar;
        if (bArr.length != this.zzgzs) {
            throw new GeneralSecurityException("Symmetric key has incorrect length");
        }
        if (this.zzgzr.equals(zzdiy.zzgys)) {
            zzdteVar = (zzdlv) zzdlv.zzatw().a(this.zzgzt).zzag(zzdqk.zzi(bArr, 0, this.zzgzs)).zzbaf();
        } else {
            if (!this.zzgzr.equals(zzdiy.zzgyr)) {
                throw new GeneralSecurityException("unknown DEM key type");
            }
            byte[] copyOfRange = Arrays.copyOfRange(bArr, 0, this.zzgzv);
            byte[] copyOfRange2 = Arrays.copyOfRange(bArr, this.zzgzv, this.zzgzs);
            zzdlj zzdljVar = (zzdlj) zzdlj.zzati().a(this.zzgzu.zzata()).zzaa(zzdqk.zzu(copyOfRange)).zzbaf();
            zzdteVar = (zzdlf) zzdlf.zzatc().zzed(this.zzgzu.getVersion()).zzb(zzdljVar).zzb((zzdmv) zzdmv.zzava().a(this.zzgzu.zzatb()).zzau(zzdqk.zzu(copyOfRange2)).zzbaf()).zzbaf();
        }
        return (zzdhx) zzdit.zza(this.zzgzr, zzdteVar, zzdhx.class);
    }
}
