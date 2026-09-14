package com.google.android.gms.internal.ads;

import java.util.Set;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* loaded from: classes.dex */
abstract class zzdfz<InputT, OutputT> extends zzdgc<OutputT> {
    private static final Logger logger = Logger.getLogger(zzdfz.class.getName());

    @NullableDecl
    private zzdet<? extends zzdhe<? extends InputT>> zzgwb;
    private final boolean zzgwc;
    private final boolean zzgwd;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public enum zza {
        OUTPUT_FUTURE_DONE,
        ALL_INPUT_FUTURES_PROCESSED
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzdfz(zzdet<? extends zzdhe<? extends InputT>> zzdetVar, boolean z, boolean z2) {
        super(zzdetVar.size());
        this.zzgwb = (zzdet) zzdei.checkNotNull(zzdetVar);
        this.zzgwc = z;
        this.zzgwd = z2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ zzdet a(zzdfz zzdfzVar, zzdet zzdetVar) {
        zzdfzVar.zzgwb = null;
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final void zza(int i, Future<? extends InputT> future) {
        try {
            a(i, (int) zzdgs.zzb(future));
        } catch (ExecutionException e) {
            zzi(e.getCause());
        } catch (Throwable th) {
            zzi(th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zza(@NullableDecl zzdet<? extends Future<? extends InputT>> zzdetVar) {
        int i = i();
        int i2 = 0;
        if (!(i >= 0)) {
            throw new IllegalStateException("Less than 0 remaining futures");
        }
        if (i == 0) {
            if (zzdetVar != null) {
                zzdfp zzdfpVar = (zzdfp) zzdetVar.iterator();
                while (zzdfpVar.hasNext()) {
                    Future<? extends InputT> future = (Future) zzdfpVar.next();
                    if (!future.isCancelled()) {
                        zza(i2, future);
                    }
                    i2++;
                }
            }
            j();
            l();
            a(zza.ALL_INPUT_FUTURES_PROCESSED);
        }
    }

    private static boolean zza(Set<Throwable> set, Throwable th) {
        while (th != null) {
            if (!set.add(th)) {
                return false;
            }
            th = th.getCause();
        }
        return true;
    }

    private final void zzi(Throwable th) {
        zzdei.checkNotNull(th);
        if (this.zzgwc && !setException(th) && zza(h(), th)) {
            zzj(th);
        } else if (th instanceof Error) {
            zzj(th);
        }
    }

    private static void zzj(Throwable th) {
        logger.logp(Level.SEVERE, "com.google.common.util.concurrent.AggregateFuture", "log", th instanceof Error ? "Input Future failed with Error" : "Got more than one input Future failure. Logging failures after the first", th);
    }

    abstract void a(int i, @NullableDecl InputT inputt);

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(zza zzaVar) {
        zzdei.checkNotNull(zzaVar);
        this.zzgwb = null;
    }

    @Override // com.google.android.gms.internal.ads.zzdgc
    final void a(Set<Throwable> set) {
        zzdei.checkNotNull(set);
        if (isCancelled()) {
            return;
        }
        zza(set, a());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzdfs
    public final void b() {
        super.b();
        zzdet<? extends zzdhe<? extends InputT>> zzdetVar = this.zzgwb;
        a(zza.OUTPUT_FUTURE_DONE);
        if (isCancelled() && (zzdetVar != null)) {
            boolean e = e();
            zzdfp zzdfpVar = (zzdfp) zzdetVar.iterator();
            while (zzdfpVar.hasNext()) {
                ((Future) zzdfpVar.next()).cancel(e);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzdfs
    public final String d() {
        zzdet<? extends zzdhe<? extends InputT>> zzdetVar = this.zzgwb;
        if (zzdetVar == null) {
            return null;
        }
        String valueOf = String.valueOf(zzdetVar);
        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 10);
        sb.append("futures=[");
        sb.append(valueOf);
        sb.append("]");
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void k() {
        if (this.zzgwb.isEmpty()) {
            l();
            return;
        }
        if (!this.zzgwc) {
            zzdga zzdgaVar = new zzdga(this, this.zzgwd ? this.zzgwb : null);
            zzdfp zzdfpVar = (zzdfp) this.zzgwb.iterator();
            while (zzdfpVar.hasNext()) {
                ((zzdhe) zzdfpVar.next()).addListener(zzdgaVar, zzdgl.INSTANCE);
            }
            return;
        }
        int i = 0;
        zzdfp zzdfpVar2 = (zzdfp) this.zzgwb.iterator();
        while (zzdfpVar2.hasNext()) {
            zzdhe zzdheVar = (zzdhe) zzdfpVar2.next();
            zzdheVar.addListener(new zzdfy(this, zzdheVar, i), zzdgl.INSTANCE);
            i++;
        }
    }

    abstract void l();
}
