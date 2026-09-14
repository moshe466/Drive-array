package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdfs;
import java.util.Collections;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.logging.Level;
import java.util.logging.Logger;

/* loaded from: classes.dex */
abstract class zzdgc<OutputT> extends zzdfs.zzj<OutputT> {
    private static final Logger zzgvj = Logger.getLogger(zzdgc.class.getName());
    private static final zzb zzgwi;
    private volatile int remaining;
    private volatile Set<Throwable> seenExceptions = null;

    /* loaded from: classes.dex */
    static final class zza extends zzb {
        private final AtomicReferenceFieldUpdater<zzdgc, Set<Throwable>> zzgwj;
        private final AtomicIntegerFieldUpdater<zzdgc> zzgwk;

        zza(AtomicReferenceFieldUpdater atomicReferenceFieldUpdater, AtomicIntegerFieldUpdater atomicIntegerFieldUpdater) {
            super();
            this.zzgwj = atomicReferenceFieldUpdater;
            this.zzgwk = atomicIntegerFieldUpdater;
        }

        @Override // com.google.android.gms.internal.ads.zzdgc.zzb
        final int a(zzdgc zzdgcVar) {
            return this.zzgwk.decrementAndGet(zzdgcVar);
        }

        @Override // com.google.android.gms.internal.ads.zzdgc.zzb
        final void a(zzdgc zzdgcVar, Set<Throwable> set, Set<Throwable> set2) {
            this.zzgwj.compareAndSet(zzdgcVar, null, set2);
        }
    }

    /* loaded from: classes.dex */
    static abstract class zzb {
        private zzb() {
        }

        abstract int a(zzdgc zzdgcVar);

        abstract void a(zzdgc zzdgcVar, Set<Throwable> set, Set<Throwable> set2);
    }

    /* loaded from: classes.dex */
    static final class zzc extends zzb {
        private zzc() {
            super();
        }

        @Override // com.google.android.gms.internal.ads.zzdgc.zzb
        final int a(zzdgc zzdgcVar) {
            int b;
            synchronized (zzdgcVar) {
                b = zzdgc.b(zzdgcVar);
            }
            return b;
        }

        @Override // com.google.android.gms.internal.ads.zzdgc.zzb
        final void a(zzdgc zzdgcVar, Set<Throwable> set, Set<Throwable> set2) {
            synchronized (zzdgcVar) {
                if (zzdgcVar.seenExceptions == null) {
                    zzdgcVar.seenExceptions = set2;
                }
            }
        }
    }

    static {
        Throwable th;
        zzb zzcVar;
        try {
            zzcVar = new zza(AtomicReferenceFieldUpdater.newUpdater(zzdgc.class, Set.class, "seenExceptions"), AtomicIntegerFieldUpdater.newUpdater(zzdgc.class, "remaining"));
            th = null;
        } catch (Throwable th2) {
            th = th2;
            zzcVar = new zzc();
        }
        zzgwi = zzcVar;
        if (th != null) {
            zzgvj.logp(Level.SEVERE, "com.google.common.util.concurrent.AggregateFutureState", "<clinit>", "SafeAtomicHelper is broken!", th);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzdgc(int i) {
        this.remaining = i;
    }

    static /* synthetic */ int b(zzdgc zzdgcVar) {
        int i = zzdgcVar.remaining - 1;
        zzdgcVar.remaining = i;
        return i;
    }

    abstract void a(Set<Throwable> set);

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Set<Throwable> h() {
        Set<Throwable> set = this.seenExceptions;
        if (set != null) {
            return set;
        }
        Set<Throwable> newSetFromMap = Collections.newSetFromMap(new ConcurrentHashMap());
        a(newSetFromMap);
        zzgwi.a(this, null, newSetFromMap);
        return this.seenExceptions;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int i() {
        return zzgwi.a(this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void j() {
        this.seenExceptions = null;
    }
}
