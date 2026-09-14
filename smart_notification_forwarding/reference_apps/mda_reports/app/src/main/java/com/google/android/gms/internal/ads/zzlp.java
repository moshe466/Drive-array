package com.google.android.gms.internal.ads;

import android.net.Uri;
import android.util.SparseArray;
import java.io.IOException;

/* loaded from: classes.dex */
public final class zzlp implements zzjf, zzlz, zzml, zznv<zzlw> {
    private final Uri uri;
    private final zzddu zzact;
    private boolean zzadv;
    private boolean zzaek;
    private long zzagj;
    private final zznl zzamu;
    private final int zzazs;
    private final zzma zzazt;
    private final zzme zzazu;
    private final zznj zzazv;
    private final String zzazw;
    private final long zzazx;
    private final zzlv zzazz;
    private zzmc zzbae;
    private zzjm zzbaf;
    private boolean zzbag;
    private boolean zzbah;
    private boolean zzbai;
    private int zzbaj;
    private zzmr zzbak;
    private boolean[] zzbal;
    private boolean[] zzbam;
    private boolean zzban;
    private long zzbao;
    private int zzbaq;
    private boolean zzbar;
    private final zznw zzazy = new zznw("Loader:ExtractorMediaPeriod");
    private final zzoe zzbaa = new zzoe();
    private final Runnable zzbab = new zzls(this);
    private final Runnable zzbac = new zzlr(this);
    private final zzddu zzaee = new zzddu();
    private long zzbap = -9223372036854775807L;
    private final SparseArray<zzmj> zzbad = new SparseArray<>();
    private long zzce = -1;

    public zzlp(Uri uri, zznl zznlVar, zzjd[] zzjdVarArr, int i, zzddu zzdduVar, zzma zzmaVar, zzme zzmeVar, zznj zznjVar, String str, int i2) {
        this.uri = uri;
        this.zzamu = zznlVar;
        this.zzazs = i;
        this.zzact = zzdduVar;
        this.zzazt = zzmaVar;
        this.zzazu = zzmeVar;
        this.zzazv = zznjVar;
        this.zzazw = str;
        this.zzazx = i2;
        this.zzazz = new zzlv(zzjdVarArr, this);
    }

    private final void startLoading() {
        zzjm zzjmVar;
        zzlw zzlwVar = new zzlw(this, this.uri, this.zzamu, this.zzazz, this.zzbaa);
        if (this.zzadv) {
            zzoc.checkState(zzho());
            long j = this.zzagj;
            if (j != -9223372036854775807L && this.zzbap >= j) {
                this.zzbar = true;
                this.zzbap = -9223372036854775807L;
                return;
            } else {
                zzlwVar.zze(this.zzbaf.zzdz(this.zzbap), this.zzbap);
                this.zzbap = -9223372036854775807L;
            }
        }
        this.zzbaq = zzhm();
        int i = this.zzazs;
        if (i == -1) {
            i = (this.zzadv && this.zzce == -1 && ((zzjmVar = this.zzbaf) == null || zzjmVar.getDurationUs() == -9223372036854775807L)) ? 6 : 3;
        }
        this.zzazy.zza(zzlwVar, this, i);
    }

    private final void zza(zzlw zzlwVar) {
        long j;
        if (this.zzce == -1) {
            j = zzlwVar.zzce;
            this.zzce = j;
        }
    }

    public final void zzhl() {
        if (this.zzaek || this.zzadv || this.zzbaf == null || !this.zzbag) {
            return;
        }
        int size = this.zzbad.size();
        for (int i = 0; i < size; i++) {
            if (this.zzbad.valueAt(i).zzhx() == null) {
                return;
            }
        }
        this.zzbaa.zzim();
        zzms[] zzmsVarArr = new zzms[size];
        this.zzbam = new boolean[size];
        this.zzbal = new boolean[size];
        this.zzagj = this.zzbaf.getDurationUs();
        int i2 = 0;
        while (true) {
            boolean z = true;
            if (i2 >= size) {
                this.zzbak = new zzmr(zzmsVarArr);
                this.zzadv = true;
                this.zzazu.zzb(new zzmp(this.zzagj, this.zzbaf.zzgh()), null);
                this.zzbae.zza((zzlz) this);
                return;
            }
            zzgw zzhx = this.zzbad.valueAt(i2).zzhx();
            zzmsVarArr[i2] = new zzms(zzhx);
            String str = zzhx.zzafe;
            if (!zzof.zzbi(str) && !zzof.zzbh(str)) {
                z = false;
            }
            this.zzbam[i2] = z;
            this.zzban = z | this.zzban;
            i2++;
        }
    }

    private final int zzhm() {
        int size = this.zzbad.size();
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            i += this.zzbad.valueAt(i2).zzhv();
        }
        return i;
    }

    private final long zzhn() {
        int size = this.zzbad.size();
        long j = Long.MIN_VALUE;
        for (int i = 0; i < size; i++) {
            j = Math.max(j, this.zzbad.valueAt(i).zzhn());
        }
        return j;
    }

    private final boolean zzho() {
        return this.zzbap != -9223372036854775807L;
    }

    public final int a(int i, zzgy zzgyVar, zzis zzisVar, boolean z) {
        if (this.zzbai || zzho()) {
            return -3;
        }
        return this.zzbad.valueAt(i).zza(zzgyVar, zzisVar, z, this.zzbar, this.zzbao);
    }

    public final void a() {
        this.zzazy.zzbc(Integer.MIN_VALUE);
    }

    public final void a(int i, long j) {
        zzmj valueAt = this.zzbad.valueAt(i);
        if (!this.zzbar || j <= valueAt.zzhn()) {
            valueAt.zze(j, true);
        } else {
            valueAt.zzhz();
        }
    }

    public final boolean a(int i) {
        if (this.zzbar) {
            return true;
        }
        return !zzho() && this.zzbad.valueAt(i).zzhw();
    }

    public final void release() {
        this.zzazy.zza(new zzlu(this, this.zzazz));
        this.zzaee.removeCallbacksAndMessages(null);
        this.zzaek = true;
    }

    @Override // com.google.android.gms.internal.ads.zznv
    public final /* synthetic */ int zza(zzlw zzlwVar, long j, long j2, IOException iOException) {
        zzjm zzjmVar;
        zzlw zzlwVar2 = zzlwVar;
        zza(zzlwVar2);
        zzddu zzdduVar = this.zzact;
        if (zzdduVar != null && this.zzazt != null) {
            zzdduVar.post(new zzlt(this, iOException));
        }
        if (iOException instanceof zzmu) {
            return 3;
        }
        boolean z = zzhm() > this.zzbaq;
        if (this.zzce == -1 && ((zzjmVar = this.zzbaf) == null || zzjmVar.getDurationUs() == -9223372036854775807L)) {
            this.zzbao = 0L;
            this.zzbai = this.zzadv;
            int size = this.zzbad.size();
            for (int i = 0; i < size; i++) {
                this.zzbad.valueAt(i).zzk(!this.zzadv || this.zzbal[i]);
            }
            zzlwVar2.zze(0L, 0L);
        }
        this.zzbaq = zzhm();
        return z ? 1 : 0;
    }

    @Override // com.google.android.gms.internal.ads.zzlz
    public final long zza(zzne[] zzneVarArr, boolean[] zArr, zzmo[] zzmoVarArr, boolean[] zArr2, long j) {
        int i;
        zzoc.checkState(this.zzadv);
        for (int i2 = 0; i2 < zzneVarArr.length; i2++) {
            if (zzmoVarArr[i2] != null && (zzneVarArr[i2] == null || !zArr[i2])) {
                i = ((zzly) zzmoVarArr[i2]).track;
                zzoc.checkState(this.zzbal[i]);
                this.zzbaj--;
                this.zzbal[i] = false;
                this.zzbad.valueAt(i).disable();
                zzmoVarArr[i2] = null;
            }
        }
        boolean z = false;
        for (int i3 = 0; i3 < zzneVarArr.length; i3++) {
            if (zzmoVarArr[i3] == null && zzneVarArr[i3] != null) {
                zzne zzneVar = zzneVarArr[i3];
                zzoc.checkState(zzneVar.length() == 1);
                zzoc.checkState(zzneVar.zzax(0) == 0);
                int zza = this.zzbak.zza(zzneVar.zzid());
                zzoc.checkState(!this.zzbal[zza]);
                this.zzbaj++;
                this.zzbal[zza] = true;
                zzmoVarArr[i3] = new zzly(this, zza);
                zArr2[i3] = true;
                z = true;
            }
        }
        if (!this.zzbah) {
            int size = this.zzbad.size();
            for (int i4 = 0; i4 < size; i4++) {
                if (!this.zzbal[i4]) {
                    this.zzbad.valueAt(i4).disable();
                }
            }
        }
        if (this.zzbaj == 0) {
            this.zzbai = false;
            if (this.zzazy.isLoading()) {
                this.zzazy.zzil();
            }
        } else if (!this.zzbah ? j != 0 : z) {
            j = zzeg(j);
            for (int i5 = 0; i5 < zzmoVarArr.length; i5++) {
                if (zzmoVarArr[i5] != null) {
                    zArr2[i5] = true;
                }
            }
        }
        this.zzbah = true;
        return j;
    }

    @Override // com.google.android.gms.internal.ads.zzjf
    public final void zza(zzjm zzjmVar) {
        this.zzbaf = zzjmVar;
        this.zzaee.post(this.zzbab);
    }

    @Override // com.google.android.gms.internal.ads.zzlz
    public final void zza(zzmc zzmcVar, long j) {
        this.zzbae = zzmcVar;
        this.zzbaa.open();
        startLoading();
    }

    @Override // com.google.android.gms.internal.ads.zznv
    public final /* synthetic */ void zza(zzlw zzlwVar, long j, long j2) {
        zza(zzlwVar);
        this.zzbar = true;
        if (this.zzagj == -9223372036854775807L) {
            long zzhn = zzhn();
            this.zzagj = zzhn == Long.MIN_VALUE ? 0L : zzhn + 10000;
            this.zzazu.zzb(new zzmp(this.zzagj, this.zzbaf.zzgh()), null);
        }
        this.zzbae.zza((zzmc) this);
    }

    @Override // com.google.android.gms.internal.ads.zznv
    public final /* synthetic */ void zza(zzlw zzlwVar, long j, long j2, boolean z) {
        zza(zzlwVar);
        if (z || this.zzbaj <= 0) {
            return;
        }
        int size = this.zzbad.size();
        for (int i = 0; i < size; i++) {
            this.zzbad.valueAt(i).zzk(this.zzbal[i]);
        }
        this.zzbae.zza((zzmc) this);
    }

    @Override // com.google.android.gms.internal.ads.zzjf
    public final zzjo zzc(int i, int i2) {
        zzmj zzmjVar = this.zzbad.get(i);
        if (zzmjVar != null) {
            return zzmjVar;
        }
        zzmj zzmjVar2 = new zzmj(this.zzazv);
        zzmjVar2.zza(this);
        this.zzbad.put(i, zzmjVar2);
        return zzmjVar2;
    }

    @Override // com.google.android.gms.internal.ads.zzlz
    public final void zzee(long j) {
    }

    @Override // com.google.android.gms.internal.ads.zzlz, com.google.android.gms.internal.ads.zzmn
    public final boolean zzef(long j) {
        if (this.zzbar) {
            return false;
        }
        if (this.zzadv && this.zzbaj == 0) {
            return false;
        }
        boolean open = this.zzbaa.open();
        if (this.zzazy.isLoading()) {
            return open;
        }
        startLoading();
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzlz
    public final long zzeg(long j) {
        if (!this.zzbaf.zzgh()) {
            j = 0;
        }
        this.zzbao = j;
        int size = this.zzbad.size();
        boolean z = !zzho();
        for (int i = 0; z && i < size; i++) {
            if (this.zzbal[i]) {
                z = this.zzbad.valueAt(i).zze(j, false);
            }
        }
        if (!z) {
            this.zzbap = j;
            this.zzbar = false;
            if (this.zzazy.isLoading()) {
                this.zzazy.zzil();
            } else {
                for (int i2 = 0; i2 < size; i2++) {
                    this.zzbad.valueAt(i2).zzk(this.zzbal[i2]);
                }
            }
        }
        this.zzbai = false;
        return j;
    }

    @Override // com.google.android.gms.internal.ads.zzml
    public final void zzf(zzgw zzgwVar) {
        this.zzaee.post(this.zzbab);
    }

    @Override // com.google.android.gms.internal.ads.zzjf
    public final void zzgj() {
        this.zzbag = true;
        this.zzaee.post(this.zzbab);
    }

    @Override // com.google.android.gms.internal.ads.zzlz
    public final void zzhf() {
        this.zzazy.zzbc(Integer.MIN_VALUE);
    }

    @Override // com.google.android.gms.internal.ads.zzlz
    public final zzmr zzhg() {
        return this.zzbak;
    }

    @Override // com.google.android.gms.internal.ads.zzlz, com.google.android.gms.internal.ads.zzmn
    public final long zzhh() {
        if (this.zzbaj == 0) {
            return Long.MIN_VALUE;
        }
        return zzhj();
    }

    @Override // com.google.android.gms.internal.ads.zzlz
    public final long zzhi() {
        if (!this.zzbai) {
            return -9223372036854775807L;
        }
        this.zzbai = false;
        return this.zzbao;
    }

    @Override // com.google.android.gms.internal.ads.zzlz
    public final long zzhj() {
        long zzhn;
        if (this.zzbar) {
            return Long.MIN_VALUE;
        }
        if (zzho()) {
            return this.zzbap;
        }
        if (this.zzban) {
            zzhn = Long.MAX_VALUE;
            int size = this.zzbad.size();
            for (int i = 0; i < size; i++) {
                if (this.zzbam[i]) {
                    zzhn = Math.min(zzhn, this.zzbad.valueAt(i).zzhn());
                }
            }
        } else {
            zzhn = zzhn();
        }
        return zzhn == Long.MIN_VALUE ? this.zzbao : zzhn;
    }
}
