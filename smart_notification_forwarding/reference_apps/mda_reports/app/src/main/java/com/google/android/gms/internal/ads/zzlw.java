package com.google.android.gms.internal.ads;

import android.net.Uri;

/* loaded from: classes.dex */
final class zzlw implements zznx {
    private final Uri uri;
    private final zznl zzamu;
    private final zzlv zzazz;
    private final zzoe zzbaa;
    private final /* synthetic */ zzlp zzbat;
    private volatile boolean zzbaz;
    private long zzbbb;
    private final zzjj zzbay = new zzjj();
    private boolean zzbba = true;
    private long zzce = -1;

    public zzlw(zzlp zzlpVar, Uri uri, zznl zznlVar, zzlv zzlvVar, zzoe zzoeVar) {
        this.zzbat = zzlpVar;
        this.uri = (Uri) zzoc.checkNotNull(uri);
        this.zzamu = (zznl) zzoc.checkNotNull(zznlVar);
        this.zzazz = (zzlv) zzoc.checkNotNull(zzlvVar);
        this.zzbaa = zzoeVar;
    }

    @Override // com.google.android.gms.internal.ads.zznx
    public final void cancelLoad() {
        this.zzbaz = true;
    }

    public final void zze(long j, long j2) {
        this.zzbay.zzamw = j;
        this.zzbbb = j2;
        this.zzbba = true;
    }

    @Override // com.google.android.gms.internal.ads.zznx
    public final boolean zzhp() {
        return this.zzbaz;
    }

    @Override // com.google.android.gms.internal.ads.zznx
    public final void zzhq() {
        zzje zzjeVar;
        int i = 0;
        while (i == 0 && !this.zzbaz) {
            try {
                long j = this.zzbay.zzamw;
                this.zzce = this.zzamu.zza(new zznq(this.uri, j, -1L, zzlp.f(this.zzbat)));
                if (this.zzce != -1) {
                    this.zzce += j;
                }
                zzjeVar = new zzje(this.zzamu, j, this.zzce);
                try {
                    zzjd zza = this.zzazz.zza(zzjeVar, this.zzamu.getUri());
                    if (this.zzbba) {
                        zza.zzc(j, this.zzbbb);
                        this.zzbba = false;
                    }
                    while (i == 0 && !this.zzbaz) {
                        this.zzbaa.block();
                        i = zza.zza(zzjeVar, this.zzbay);
                        if (zzjeVar.getPosition() > zzlp.g(this.zzbat) + j) {
                            j = zzjeVar.getPosition();
                            this.zzbaa.zzim();
                            zzlp.i(this.zzbat).post(zzlp.h(this.zzbat));
                        }
                    }
                    if (i == 1) {
                        i = 0;
                    } else {
                        this.zzbay.zzamw = zzjeVar.getPosition();
                    }
                    zzoq.zza(this.zzamu);
                } catch (Throwable th) {
                    th = th;
                    if (i != 1 && zzjeVar != null) {
                        this.zzbay.zzamw = zzjeVar.getPosition();
                    }
                    zzoq.zza(this.zzamu);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                zzjeVar = null;
            }
        }
    }
}
