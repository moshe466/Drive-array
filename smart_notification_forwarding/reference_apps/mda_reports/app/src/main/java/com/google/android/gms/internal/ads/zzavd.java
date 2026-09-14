package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.Parcelable;
import com.google.android.gms.common.util.Clock;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import javax.annotation.concurrent.GuardedBy;

/* loaded from: classes.dex */
public final class zzavd {
    private final Clock zzbmq;
    private final String zzdja;
    private final zzavp zzdpz;
    private final String zzdqb;
    private final Object lock = new Object();

    @GuardedBy("lock")
    private long zzdko = -1;

    @GuardedBy("lock")
    private long zzdqc = -1;

    @GuardedBy("lock")
    private boolean zzdkk = false;

    @GuardedBy("lock")
    private long zzdqd = -1;

    @GuardedBy("lock")
    private long zzdqe = 0;

    @GuardedBy("lock")
    private long zzdqf = -1;

    @GuardedBy("lock")
    private long zzdqg = -1;

    @GuardedBy("lock")
    private final LinkedList<zzavc> zzdqa = new LinkedList<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzavd(Clock clock, zzavp zzavpVar, String str, String str2) {
        this.zzbmq = clock;
        this.zzdpz = zzavpVar;
        this.zzdqb = str;
        this.zzdja = str2;
    }

    public final Bundle toBundle() {
        Bundle bundle;
        synchronized (this.lock) {
            bundle = new Bundle();
            bundle.putString("seq_num", this.zzdqb);
            bundle.putString("slotid", this.zzdja);
            bundle.putBoolean("ismediation", false);
            bundle.putLong("treq", this.zzdqf);
            bundle.putLong("tresponse", this.zzdqg);
            bundle.putLong("timp", this.zzdqc);
            bundle.putLong("tload", this.zzdqd);
            bundle.putLong("pcc", this.zzdqe);
            bundle.putLong("tfetch", this.zzdko);
            ArrayList<? extends Parcelable> arrayList = new ArrayList<>();
            Iterator<zzavc> it = this.zzdqa.iterator();
            while (it.hasNext()) {
                arrayList.add(it.next().toBundle());
            }
            bundle.putParcelableArrayList("tclick", arrayList);
        }
        return bundle;
    }

    public final void zzan(boolean z) {
        synchronized (this.lock) {
            if (this.zzdqg != -1) {
                this.zzdqd = this.zzbmq.elapsedRealtime();
            }
        }
    }

    public final void zze(zzug zzugVar) {
        synchronized (this.lock) {
            this.zzdqf = this.zzbmq.elapsedRealtime();
            this.zzdpz.zza(zzugVar, this.zzdqf);
        }
    }

    public final void zzey(long j) {
        synchronized (this.lock) {
            this.zzdqg = j;
            if (this.zzdqg != -1) {
                this.zzdpz.zzb(this);
            }
        }
    }

    public final void zzuv() {
        synchronized (this.lock) {
            if (this.zzdqg != -1 && this.zzdqc == -1) {
                this.zzdqc = this.zzbmq.elapsedRealtime();
                this.zzdpz.zzb(this);
            }
            this.zzdpz.zzuv();
        }
    }

    public final void zzuw() {
        synchronized (this.lock) {
            if (this.zzdqg != -1) {
                zzavc zzavcVar = new zzavc(this);
                zzavcVar.zzuu();
                this.zzdqa.add(zzavcVar);
                this.zzdqe++;
                this.zzdpz.zzuw();
                this.zzdpz.zzb(this);
            }
        }
    }

    public final void zzux() {
        synchronized (this.lock) {
            if (this.zzdqg != -1 && !this.zzdqa.isEmpty()) {
                zzavc last = this.zzdqa.getLast();
                if (last.zzus() == -1) {
                    last.zzut();
                    this.zzdpz.zzb(this);
                }
            }
        }
    }

    public final String zzuy() {
        return this.zzdqb;
    }
}
