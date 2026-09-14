package com.google.android.gms.internal.ads;

import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzdho<V> extends zzdgm<V> {

    @NullableDecl
    private zzdhe<V> zzgxk;

    @NullableDecl
    private ScheduledFuture<?> zzgxl;

    private zzdho(zzdhe<V> zzdheVar) {
        this.zzgxk = (zzdhe) zzdei.checkNotNull(zzdheVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <V> zzdhe<V> a(zzdhe<V> zzdheVar, long j, TimeUnit timeUnit, ScheduledExecutorService scheduledExecutorService) {
        zzdho zzdhoVar = new zzdho(zzdheVar);
        zzdhq zzdhqVar = new zzdhq(zzdhoVar);
        zzdhoVar.zzgxl = scheduledExecutorService.schedule(zzdhqVar, j, timeUnit);
        zzdheVar.addListener(zzdhqVar, zzdgl.INSTANCE);
        return zzdhoVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ ScheduledFuture a(zzdho zzdhoVar, ScheduledFuture scheduledFuture) {
        zzdhoVar.zzgxl = null;
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzdfs
    public final void b() {
        a((Future<?>) this.zzgxk);
        ScheduledFuture<?> scheduledFuture = this.zzgxl;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(false);
        }
        this.zzgxk = null;
        this.zzgxl = null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzdfs
    public final String d() {
        zzdhe<V> zzdheVar = this.zzgxk;
        ScheduledFuture<?> scheduledFuture = this.zzgxl;
        if (zzdheVar == null) {
            return null;
        }
        String valueOf = String.valueOf(zzdheVar);
        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 14);
        sb.append("inputFuture=[");
        sb.append(valueOf);
        sb.append("]");
        String sb2 = sb.toString();
        if (scheduledFuture == null) {
            return sb2;
        }
        long delay = scheduledFuture.getDelay(TimeUnit.MILLISECONDS);
        if (delay <= 0) {
            return sb2;
        }
        String valueOf2 = String.valueOf(sb2);
        StringBuilder sb3 = new StringBuilder(String.valueOf(valueOf2).length() + 43);
        sb3.append(valueOf2);
        sb3.append(", remaining delay=[");
        sb3.append(delay);
        sb3.append(" ms]");
        return sb3.toString();
    }
}
