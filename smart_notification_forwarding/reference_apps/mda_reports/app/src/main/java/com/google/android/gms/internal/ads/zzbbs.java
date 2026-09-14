package com.google.android.gms.internal.ads;

import android.content.Context;
import android.net.Uri;
import android.view.Surface;
import com.google.android.gms.common.util.VisibleForTesting;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* loaded from: classes.dex */
public final class zzbbs implements zzgn, zzma, zznz<zznl>, zzpd {

    @VisibleForTesting
    private static int zzebx;

    @VisibleForTesting
    private static int zzeby;
    private int bytesTransferred;
    private final zzbaw zzebe;
    private final zzhf zzeca;
    private zzgk zzecd;
    private ByteBuffer zzece;
    private boolean zzecf;
    private zzbca zzecg;
    private final Context zzup;
    private Set<WeakReference<zzbbp>> zzech = new HashSet();
    private final zzbbt zzebz = new zzbbt();
    private final zzhf zzecb = new zzij(zzky.zzazf);
    private final zzmz zzecc = new zzmy();

    public zzbbs(Context context, zzbaw zzbawVar) {
        this.zzup = context;
        this.zzebe = zzbawVar;
        this.zzeca = new zzox(this.zzup, zzky.zzazf, 0L, zzawb.zzdsr, this, -1);
        if (zzavs.zzvs()) {
            String valueOf = String.valueOf(this);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 28);
            sb.append("ExoPlayerAdapter initialize ");
            sb.append(valueOf);
            zzavs.zzed(sb.toString());
        }
        zzebx++;
        this.zzecd = zzgo.zza(new zzhf[]{this.zzecb, this.zzeca}, this.zzecc, this.zzebz);
        this.zzecd.zza(this);
    }

    @VisibleForTesting
    private final zzmb zzb(Uri uri, final String str) {
        zzno zznoVar;
        if (!this.zzecf || this.zzece.limit() <= 0) {
            final zzno zznoVar2 = this.zzebe.zzdzm > 0 ? new zzno(this, str) { // from class: com.google.android.gms.internal.ads.zzbbu
                private final String zzcyr;
                private final zzbbs zzeco;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.zzeco = this;
                    this.zzcyr = str;
                }

                @Override // com.google.android.gms.internal.ads.zzno
                public final zznl zzih() {
                    return this.zzeco.b(this.zzcyr);
                }
            } : new zzno(this, str) { // from class: com.google.android.gms.internal.ads.zzbbx
                private final String zzcyr;
                private final zzbbs zzeco;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.zzeco = this;
                    this.zzcyr = str;
                }

                @Override // com.google.android.gms.internal.ads.zzno
                public final zznl zzih() {
                    return this.zzeco.a(this.zzcyr);
                }
            };
            final zzno zznoVar3 = this.zzebe.zzdzn ? new zzno(this, zznoVar2) { // from class: com.google.android.gms.internal.ads.zzbbw
                private final zzbbs zzeco;
                private final zzno zzecp;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.zzeco = this;
                    this.zzecp = zznoVar2;
                }

                @Override // com.google.android.gms.internal.ads.zzno
                public final zznl zzih() {
                    return this.zzeco.a(this.zzecp);
                }
            } : zznoVar2;
            if (this.zzece.limit() > 0) {
                final byte[] bArr = new byte[this.zzece.limit()];
                this.zzece.get(bArr);
                zznoVar3 = new zzno(zznoVar3, bArr) { // from class: com.google.android.gms.internal.ads.zzbbz
                    private final byte[] zzdlq;
                    private final zzno zzecr;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        this.zzecr = zznoVar3;
                        this.zzdlq = bArr;
                    }

                    @Override // com.google.android.gms.internal.ads.zzno
                    public final zznl zzih() {
                        zzno zznoVar4 = this.zzecr;
                        byte[] bArr2 = this.zzdlq;
                        return new zzbcd(new zznm(bArr2), bArr2.length, zznoVar4.zzih());
                    }
                };
            }
            zznoVar = zznoVar3;
        } else {
            final byte[] bArr2 = new byte[this.zzece.limit()];
            this.zzece.get(bArr2);
            zznoVar = new zzno(bArr2) { // from class: com.google.android.gms.internal.ads.zzbbv
                private final byte[] zzdvy;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.zzdvy = bArr2;
                }

                @Override // com.google.android.gms.internal.ads.zzno
                public final zznl zzih() {
                    return new zznm(this.zzdvy);
                }
            };
        }
        zzji zzjiVar = zzbby.a;
        zzbaw zzbawVar = this.zzebe;
        return new zzlx(uri, zznoVar, zzjiVar, zzbawVar.zzdzo, zzawb.zzdsr, this, null, zzbawVar.zzdzk);
    }

    public static int zzzn() {
        return zzebx;
    }

    public static int zzzo() {
        return zzeby;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ zznl a(zzno zznoVar) {
        return new zzbbr(this.zzup, zznoVar.zzih(), this, new zzbbq(this) { // from class: com.google.android.gms.internal.ads.zzbcb
            private final zzbbs zzeco;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzeco = this;
            }

            @Override // com.google.android.gms.internal.ads.zzbbq
            public final void zzb(boolean z, long j) {
                this.zzeco.a(z, j);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ zznl a(String str) {
        zzbbs zzbbsVar = this.zzebe.zzdzn ? null : this;
        zzbaw zzbawVar = this.zzebe;
        return new zzns(str, null, zzbbsVar, zzbawVar.zzdzh, zzbawVar.zzdzj, true, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(float f, boolean z) {
        if (this.zzecd == null) {
            return;
        }
        zzgp zzgpVar = new zzgp(this.zzecb, 2, Float.valueOf(f));
        if (z) {
            this.zzecd.zzb(zzgpVar);
        } else {
            this.zzecd.zza(zzgpVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(Surface surface, boolean z) {
        if (this.zzecd == null) {
            return;
        }
        zzgp zzgpVar = new zzgp(this.zzeca, 1, surface);
        if (z) {
            this.zzecd.zzb(zzgpVar);
        } else {
            this.zzecd.zza(zzgpVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(boolean z) {
        if (this.zzecd == null) {
            return;
        }
        for (int i = 0; i < this.zzecd.zzeb(); i++) {
            this.zzecc.zzf(i, !z);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void a(boolean z, long j) {
        zzbca zzbcaVar = this.zzecg;
        if (zzbcaVar != null) {
            zzbcaVar.zzb(z, j);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ zznl b(String str) {
        zzbbs zzbbsVar = this.zzebe.zzdzn ? null : this;
        zzbaw zzbawVar = this.zzebe;
        zzbbp zzbbpVar = new zzbbp(str, zzbbsVar, zzbawVar.zzdzh, zzbawVar.zzdzj, zzbawVar.zzdzm);
        this.zzech.add(new WeakReference<>(zzbbpVar));
        return zzbbpVar;
    }

    public final void finalize() {
        zzebx--;
        if (zzavs.zzvs()) {
            String valueOf = String.valueOf(this);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 26);
            sb.append("ExoPlayerAdapter finalize ");
            sb.append(valueOf);
            zzavs.zzed(sb.toString());
        }
    }

    public final long getBytesTransferred() {
        return this.bytesTransferred;
    }

    public final void release() {
        zzgk zzgkVar = this.zzecd;
        if (zzgkVar != null) {
            zzgkVar.zzb(this);
            this.zzecd.release();
            this.zzecd = null;
            zzeby--;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzpd
    public final void zza(int i, int i2, int i3, float f) {
        zzbca zzbcaVar = this.zzecg;
        if (zzbcaVar != null) {
            zzbcaVar.zzn(i, i2);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzpd
    public final void zza(Surface surface) {
    }

    public final void zza(zzbca zzbcaVar) {
        this.zzecg = zzbcaVar;
    }

    @Override // com.google.android.gms.internal.ads.zzgn
    public final void zza(zzgl zzglVar) {
        zzbca zzbcaVar = this.zzecg;
        if (zzbcaVar != null) {
            zzbcaVar.zza("onPlayerError", zzglVar);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzgn
    public final void zza(zzhc zzhcVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzgn
    public final void zza(zzhg zzhgVar, Object obj) {
    }

    @Override // com.google.android.gms.internal.ads.zzgn
    public final void zza(zzmr zzmrVar, zzng zzngVar) {
    }

    @Override // com.google.android.gms.internal.ads.zznz
    public final /* synthetic */ void zza(zznl zznlVar, zznq zznqVar) {
        this.bytesTransferred = 0;
    }

    @Override // com.google.android.gms.internal.ads.zzgn
    public final void zza(boolean z, int i) {
        zzbca zzbcaVar = this.zzecg;
        if (zzbcaVar != null) {
            zzbcaVar.zzda(i);
        }
    }

    public final void zza(Uri[] uriArr, String str) {
        zza(uriArr, str, ByteBuffer.allocate(0), false);
    }

    public final void zza(Uri[] uriArr, String str, ByteBuffer byteBuffer, boolean z) {
        zzmb zzmgVar;
        if (this.zzecd == null) {
            return;
        }
        this.zzece = byteBuffer;
        this.zzecf = z;
        if (uriArr.length == 1) {
            zzmgVar = zzb(uriArr[0], str);
        } else {
            zzmb[] zzmbVarArr = new zzmb[uriArr.length];
            for (int i = 0; i < uriArr.length; i++) {
                zzmbVarArr[i] = zzb(uriArr[i], str);
            }
            zzmgVar = new zzmg(zzmbVarArr);
        }
        this.zzecd.zza(zzmgVar);
        zzeby++;
    }

    @Override // com.google.android.gms.internal.ads.zzma
    public final void zzb(IOException iOException) {
        zzbca zzbcaVar = this.zzecg;
        if (zzbcaVar != null) {
            zzbcaVar.zza("onLoadError", iOException);
        }
    }

    @Override // com.google.android.gms.internal.ads.zznz
    public final /* synthetic */ void zzc(zznl zznlVar, int i) {
        this.bytesTransferred += i;
    }

    public final void zzcz(int i) {
        Iterator<WeakReference<zzbbp>> it = this.zzech.iterator();
        while (it.hasNext()) {
            zzbbp zzbbpVar = it.next().get();
            if (zzbbpVar != null) {
                zzbbpVar.a(i);
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzpd
    public final void zzd(String str, long j, long j2) {
    }

    @Override // com.google.android.gms.internal.ads.zzpd
    public final void zze(int i, long j) {
    }

    @Override // com.google.android.gms.internal.ads.zzpd
    public final void zze(zzit zzitVar) {
    }

    @Override // com.google.android.gms.internal.ads.zznz
    public final /* bridge */ /* synthetic */ void zze(zznl zznlVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzgn
    public final void zzed() {
    }

    @Override // com.google.android.gms.internal.ads.zzpd
    public final void zzf(zzit zzitVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzgn
    public final void zzg(boolean z) {
    }

    @Override // com.google.android.gms.internal.ads.zzpd
    public final void zzk(zzgw zzgwVar) {
    }

    public final zzgk zzzm() {
        return this.zzecd;
    }

    public final zzbbt zzzp() {
        return this.zzebz;
    }
}
