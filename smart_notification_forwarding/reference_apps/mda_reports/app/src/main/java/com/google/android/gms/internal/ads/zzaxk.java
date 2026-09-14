package com.google.android.gms.internal.ads;

import android.content.Context;
import androidx.annotation.Nullable;
import io.fabric.sdk.android.services.network.HttpRequest;
import java.util.Map;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
/* loaded from: classes.dex */
public final class zzaxk {
    private static zzu zzdua;
    private static final Object zzdub = new Object();

    @Deprecated
    private static final zzaxo<Void> zzduc = new zzaxn();

    public zzaxk(Context context) {
        zzbh(context.getApplicationContext() != null ? context.getApplicationContext() : context);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0027 A[Catch: all -> 0x0036, TryCatch #0 {, blocks: (B:4:0x0003, B:6:0x0007, B:8:0x0010, B:12:0x0027, B:13:0x0030, B:14:0x002c, B:16:0x0032, B:17:0x0034), top: B:3:0x0003 }] */
    /* JADX WARN: Removed duplicated region for block: B:14:0x002c A[Catch: all -> 0x0036, TryCatch #0 {, blocks: (B:4:0x0003, B:6:0x0007, B:8:0x0010, B:12:0x0027, B:13:0x0030, B:14:0x002c, B:16:0x0032, B:17:0x0034), top: B:3:0x0003 }] */
    @com.google.android.gms.common.util.VisibleForTesting
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static com.google.android.gms.internal.ads.zzu zzbh(android.content.Context r3) {
        /*
            java.lang.Object r0 = com.google.android.gms.internal.ads.zzaxk.zzdub
            monitor-enter(r0)
            com.google.android.gms.internal.ads.zzu r1 = com.google.android.gms.internal.ads.zzaxk.zzdua     // Catch: java.lang.Throwable -> L36
            if (r1 != 0) goto L32
            com.google.android.gms.internal.ads.zzzn.initialize(r3)     // Catch: java.lang.Throwable -> L36
            boolean r1 = com.google.android.gms.common.util.ClientLibraryUtils.isPackageSide()     // Catch: java.lang.Throwable -> L36
            if (r1 != 0) goto L24
            com.google.android.gms.internal.ads.zzzc<java.lang.Boolean> r1 = com.google.android.gms.internal.ads.zzzn.zzcng     // Catch: java.lang.Throwable -> L36
            com.google.android.gms.internal.ads.zzzj r2 = com.google.android.gms.internal.ads.zzve.zzoy()     // Catch: java.lang.Throwable -> L36
            java.lang.Object r1 = r2.zzd(r1)     // Catch: java.lang.Throwable -> L36
            java.lang.Boolean r1 = (java.lang.Boolean) r1     // Catch: java.lang.Throwable -> L36
            boolean r1 = r1.booleanValue()     // Catch: java.lang.Throwable -> L36
            if (r1 == 0) goto L24
            r1 = 1
            goto L25
        L24:
            r1 = 0
        L25:
            if (r1 == 0) goto L2c
            com.google.android.gms.internal.ads.zzu r3 = com.google.android.gms.internal.ads.zzaxd.zzbg(r3)     // Catch: java.lang.Throwable -> L36
            goto L30
        L2c:
            com.google.android.gms.internal.ads.zzu r3 = com.google.android.gms.internal.ads.zzba.zza(r3)     // Catch: java.lang.Throwable -> L36
        L30:
            com.google.android.gms.internal.ads.zzaxk.zzdua = r3     // Catch: java.lang.Throwable -> L36
        L32:
            com.google.android.gms.internal.ads.zzu r3 = com.google.android.gms.internal.ads.zzaxk.zzdua     // Catch: java.lang.Throwable -> L36
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L36
            return r3
        L36:
            r3 = move-exception
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L36
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzaxk.zzbh(android.content.Context):com.google.android.gms.internal.ads.zzu");
    }

    public static zzdhe<zzo> zzeq(String str) {
        zzazl zzazlVar = new zzazl();
        zzdua.zze(new zzaxq(str, zzazlVar));
        return zzazlVar;
    }

    public final zzdhe<String> zza(int i, String str, @Nullable Map<String, String> map, @Nullable byte[] bArr) {
        zzaxr zzaxrVar = new zzaxr(null);
        zzaxm zzaxmVar = new zzaxm(this, str, zzaxrVar);
        zzayo zzayoVar = new zzayo(null);
        zzaxp zzaxpVar = new zzaxp(this, i, str, zzaxrVar, zzaxmVar, bArr, map, zzayoVar);
        if (zzayo.isEnabled()) {
            try {
                zzayoVar.zza(str, HttpRequest.METHOD_GET, zzaxpVar.getHeaders(), zzaxpVar.zzf());
            } catch (zzb e) {
                zzayu.zzez(e.getMessage());
            }
        }
        zzdua.zze(zzaxpVar);
        return zzaxrVar;
    }

    public final zzdhe<String> zzc(String str, Map<String, String> map) {
        return zza(0, str, map, null);
    }
}
