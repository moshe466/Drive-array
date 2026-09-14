package com.google.android.gms.internal.ads;

import android.annotation.SuppressLint;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzgr implements zzgk {
    private int repeatMode;
    private final zzhf[] zzacq;
    private final zznf zzacr;
    private final zzng zzacs;
    private final zzddu zzact;
    private final zzgt zzacu;
    private final CopyOnWriteArraySet<zzgn> zzacv;
    private final zzhl zzacw;
    private final zzhi zzacx;
    private boolean zzacy;
    private boolean zzacz;
    private int zzada;
    private int zzadb;
    private int zzadc;
    private boolean zzadd;
    private zzhg zzade;
    private Object zzadf;
    private zzmr zzadg;
    private zzng zzadh;
    private zzhc zzadi;
    private zzgv zzadj;
    private int zzadk;
    private int zzadl;
    private long zzadm;

    @SuppressLint({"HandlerLeak"})
    public zzgr(zzhf[] zzhfVarArr, zznf zznfVar, zzha zzhaVar) {
        String str = zzoq.zzbgv;
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 26);
        sb.append("Init ExoPlayerLib/2.4.2 [");
        sb.append(str);
        sb.append("]");
        Log.i("ExoPlayerImpl", sb.toString());
        zzoc.checkState(zzhfVarArr.length > 0);
        this.zzacq = (zzhf[]) zzoc.checkNotNull(zzhfVarArr);
        this.zzacr = (zznf) zzoc.checkNotNull(zznfVar);
        this.zzacz = false;
        this.repeatMode = 0;
        this.zzada = 1;
        this.zzacv = new CopyOnWriteArraySet<>();
        this.zzacs = new zzng(new zzne[zzhfVarArr.length]);
        this.zzade = zzhg.zzagf;
        this.zzacw = new zzhl();
        this.zzacx = new zzhi();
        this.zzadg = zzmr.zzbdd;
        this.zzadh = this.zzacs;
        this.zzadi = zzhc.zzagb;
        this.zzact = new zzgq(this, Looper.myLooper() != null ? Looper.myLooper() : Looper.getMainLooper());
        this.zzadj = new zzgv(0, 0L);
        this.zzacu = new zzgt(zzhfVarArr, zznfVar, zzhaVar, this.zzacz, 0, this.zzact, this.zzadj, this);
    }

    private final int zzee() {
        if (this.zzade.isEmpty() || this.zzadb > 0) {
            return this.zzadk;
        }
        this.zzade.zza(this.zzadj.zzads, this.zzacx, false);
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(Message message) {
        switch (message.what) {
            case 0:
                this.zzadc--;
                return;
            case 1:
                this.zzada = message.arg1;
                Iterator<zzgn> it = this.zzacv.iterator();
                while (it.hasNext()) {
                    it.next().zza(this.zzacz, this.zzada);
                }
                return;
            case 2:
                this.zzadd = message.arg1 != 0;
                Iterator<zzgn> it2 = this.zzacv.iterator();
                while (it2.hasNext()) {
                    it2.next().zzg(this.zzadd);
                }
                return;
            case 3:
                if (this.zzadc == 0) {
                    zznh zznhVar = (zznh) message.obj;
                    this.zzacy = true;
                    this.zzadg = zznhVar.zzbef;
                    this.zzadh = zznhVar.zzbeg;
                    this.zzacr.zzd(zznhVar.zzbeh);
                    Iterator<zzgn> it3 = this.zzacv.iterator();
                    while (it3.hasNext()) {
                        it3.next().zza(this.zzadg, this.zzadh);
                    }
                    return;
                }
                return;
            case 4:
                int i = this.zzadb - 1;
                this.zzadb = i;
                if (i == 0) {
                    this.zzadj = (zzgv) message.obj;
                    if (message.arg1 != 0) {
                        Iterator<zzgn> it4 = this.zzacv.iterator();
                        while (it4.hasNext()) {
                            it4.next().zzed();
                        }
                        return;
                    }
                    return;
                }
                return;
            case 5:
                if (this.zzadb == 0) {
                    this.zzadj = (zzgv) message.obj;
                    Iterator<zzgn> it5 = this.zzacv.iterator();
                    while (it5.hasNext()) {
                        it5.next().zzed();
                    }
                    return;
                }
                return;
            case 6:
                zzgx zzgxVar = (zzgx) message.obj;
                this.zzadb -= zzgxVar.zzafy;
                if (this.zzadc == 0) {
                    this.zzade = zzgxVar.zzade;
                    this.zzadf = zzgxVar.zzadf;
                    this.zzadj = zzgxVar.zzadj;
                    Iterator<zzgn> it6 = this.zzacv.iterator();
                    while (it6.hasNext()) {
                        it6.next().zza(this.zzade, this.zzadf);
                    }
                    return;
                }
                return;
            case 7:
                zzhc zzhcVar = (zzhc) message.obj;
                if (this.zzadi.equals(zzhcVar)) {
                    return;
                }
                this.zzadi = zzhcVar;
                Iterator<zzgn> it7 = this.zzacv.iterator();
                while (it7.hasNext()) {
                    it7.next().zza(zzhcVar);
                }
                return;
            case 8:
                zzgl zzglVar = (zzgl) message.obj;
                Iterator<zzgn> it8 = this.zzacv.iterator();
                while (it8.hasNext()) {
                    it8.next().zza(zzglVar);
                }
                return;
            default:
                throw new IllegalStateException();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzgk
    public final long getBufferedPosition() {
        if (this.zzade.isEmpty() || this.zzadb > 0) {
            return this.zzadm;
        }
        this.zzade.zza(this.zzadj.zzads, this.zzacx, false);
        return this.zzacx.zzex() + zzgi.zzdm(this.zzadj.zzaey);
    }

    @Override // com.google.android.gms.internal.ads.zzgk
    public final long getDuration() {
        if (this.zzade.isEmpty()) {
            return -9223372036854775807L;
        }
        return zzgi.zzdm(this.zzade.zza(zzee(), this.zzacw, false).zzagj);
    }

    @Override // com.google.android.gms.internal.ads.zzgk
    public final int getPlaybackState() {
        return this.zzada;
    }

    @Override // com.google.android.gms.internal.ads.zzgk
    public final void release() {
        this.zzacu.release();
        this.zzact.removeCallbacksAndMessages(null);
    }

    @Override // com.google.android.gms.internal.ads.zzgk
    public final void seekTo(long j) {
        int zzee = zzee();
        if (zzee < 0 || (!this.zzade.isEmpty() && zzee >= this.zzade.zzev())) {
            throw new zzhb(this.zzade, zzee, j);
        }
        this.zzadb++;
        this.zzadk = zzee;
        if (!this.zzade.isEmpty()) {
            this.zzade.zza(zzee, this.zzacw, false);
            long zzdn = this.zzacw.zzagz + (j == -9223372036854775807L ? this.zzacw.zzagy : zzgi.zzdn(j));
            long j2 = this.zzade.zza(0, this.zzacx, false).zzagj;
            if (j2 != -9223372036854775807L) {
                int i = (zzdn > j2 ? 1 : (zzdn == j2 ? 0 : -1));
            }
        }
        this.zzadl = 0;
        if (j == -9223372036854775807L) {
            this.zzadm = 0L;
            this.zzacu.zza(this.zzade, zzee, -9223372036854775807L);
            return;
        }
        this.zzadm = j;
        this.zzacu.zza(this.zzade, zzee, zzgi.zzdn(j));
        Iterator<zzgn> it = this.zzacv.iterator();
        while (it.hasNext()) {
            it.next().zzed();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzgk
    public final void stop() {
        this.zzacu.stop();
    }

    @Override // com.google.android.gms.internal.ads.zzgk
    public final void zza(zzgn zzgnVar) {
        this.zzacv.add(zzgnVar);
    }

    @Override // com.google.android.gms.internal.ads.zzgk
    public final void zza(zzmb zzmbVar) {
        if (!this.zzade.isEmpty() || this.zzadf != null) {
            this.zzade = zzhg.zzagf;
            this.zzadf = null;
            Iterator<zzgn> it = this.zzacv.iterator();
            while (it.hasNext()) {
                it.next().zza(this.zzade, this.zzadf);
            }
        }
        if (this.zzacy) {
            this.zzacy = false;
            this.zzadg = zzmr.zzbdd;
            this.zzadh = this.zzacs;
            this.zzacr.zzd(null);
            Iterator<zzgn> it2 = this.zzacv.iterator();
            while (it2.hasNext()) {
                it2.next().zza(this.zzadg, this.zzadh);
            }
        }
        this.zzadc++;
        this.zzacu.zza(zzmbVar, true);
    }

    @Override // com.google.android.gms.internal.ads.zzgk
    public final void zza(zzgp... zzgpVarArr) {
        this.zzacu.zza(zzgpVarArr);
    }

    @Override // com.google.android.gms.internal.ads.zzgk
    public final void zzb(zzgn zzgnVar) {
        this.zzacv.remove(zzgnVar);
    }

    @Override // com.google.android.gms.internal.ads.zzgk
    public final void zzb(zzgp... zzgpVarArr) {
        this.zzacu.zzb(zzgpVarArr);
    }

    @Override // com.google.android.gms.internal.ads.zzgk
    public final boolean zzea() {
        return this.zzacz;
    }

    @Override // com.google.android.gms.internal.ads.zzgk
    public final int zzeb() {
        return this.zzacq.length;
    }

    @Override // com.google.android.gms.internal.ads.zzgk
    public final long zzec() {
        if (this.zzade.isEmpty() || this.zzadb > 0) {
            return this.zzadm;
        }
        this.zzade.zza(this.zzadj.zzads, this.zzacx, false);
        return this.zzacx.zzex() + zzgi.zzdm(this.zzadj.zzaex);
    }

    @Override // com.google.android.gms.internal.ads.zzgk
    public final void zzf(boolean z) {
        if (this.zzacz != z) {
            this.zzacz = z;
            this.zzacu.zzf(z);
            Iterator<zzgn> it = this.zzacv.iterator();
            while (it.hasNext()) {
                it.next().zza(z, this.zzada);
            }
        }
    }
}
