package com.google.android.gms.measurement.internal;

import androidx.annotation.WorkerThread;
import com.google.android.gms.common.internal.Preconditions;
import java.net.URL;
import java.util.List;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
@WorkerThread
/* loaded from: classes.dex */
public final class zzib implements Runnable {
    private final URL zza;
    private final byte[] zzb;
    private final zzic zzc;
    private final String zzd;
    private final Map<String, String> zze;
    private final /* synthetic */ zzhz zzf;

    public zzib(zzhz zzhzVar, String str, URL url, byte[] bArr, Map<String, String> map, zzic zzicVar) {
        this.zzf = zzhzVar;
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(url);
        Preconditions.checkNotNull(zzicVar);
        this.zza = url;
        this.zzb = null;
        this.zzc = zzicVar;
        this.zzd = str;
        this.zze = null;
    }

    private final void zzb(final int i, final Exception exc, final byte[] bArr, final Map<String, List<String>> map) {
        this.zzf.zzq().zza(new Runnable(this, i, exc, bArr, map) { // from class: com.google.android.gms.measurement.internal.zzie
            private final zzib zza;
            private final int zzb;
            private final Exception zzc;
            private final byte[] zzd;
            private final Map zze;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zza = this;
                this.zzb = i;
                this.zzc = exc;
                this.zzd = bArr;
                this.zze = map;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.zza.a(this.zzb, this.zzc, this.zzd, this.zze);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void a(int i, Exception exc, byte[] bArr, Map map) {
        this.zzc.zza(this.zzd, i, exc, bArr, map);
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0070  */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void run() {
        /*
            r7 = this;
            com.google.android.gms.measurement.internal.zzhz r0 = r7.zzf
            r0.zzc()
            r0 = 0
            r1 = 0
            com.google.android.gms.measurement.internal.zzhz r2 = r7.zzf     // Catch: java.lang.Throwable -> L6a java.io.IOException -> L77
            java.net.URL r3 = r7.zza     // Catch: java.lang.Throwable -> L6a java.io.IOException -> L77
            java.net.HttpURLConnection r2 = r2.a(r3)     // Catch: java.lang.Throwable -> L6a java.io.IOException -> L77
            java.util.Map<java.lang.String, java.lang.String> r3 = r7.zze     // Catch: java.lang.Throwable -> L64 java.io.IOException -> L67
            if (r3 == 0) goto L39
            java.util.Map<java.lang.String, java.lang.String> r3 = r7.zze     // Catch: java.lang.Throwable -> L64 java.io.IOException -> L67
            java.util.Set r3 = r3.entrySet()     // Catch: java.lang.Throwable -> L64 java.io.IOException -> L67
            java.util.Iterator r3 = r3.iterator()     // Catch: java.lang.Throwable -> L64 java.io.IOException -> L67
        L1d:
            boolean r4 = r3.hasNext()     // Catch: java.lang.Throwable -> L64 java.io.IOException -> L67
            if (r4 == 0) goto L39
            java.lang.Object r4 = r3.next()     // Catch: java.lang.Throwable -> L64 java.io.IOException -> L67
            java.util.Map$Entry r4 = (java.util.Map.Entry) r4     // Catch: java.lang.Throwable -> L64 java.io.IOException -> L67
            java.lang.Object r5 = r4.getKey()     // Catch: java.lang.Throwable -> L64 java.io.IOException -> L67
            java.lang.String r5 = (java.lang.String) r5     // Catch: java.lang.Throwable -> L64 java.io.IOException -> L67
            java.lang.Object r4 = r4.getValue()     // Catch: java.lang.Throwable -> L64 java.io.IOException -> L67
            java.lang.String r4 = (java.lang.String) r4     // Catch: java.lang.Throwable -> L64 java.io.IOException -> L67
            r2.addRequestProperty(r5, r4)     // Catch: java.lang.Throwable -> L64 java.io.IOException -> L67
            goto L1d
        L39:
            int r1 = r2.getResponseCode()     // Catch: java.lang.Throwable -> L64 java.io.IOException -> L67
            java.util.Map r3 = r2.getHeaderFields()     // Catch: java.lang.Throwable -> L5c java.io.IOException -> L60
            com.google.android.gms.measurement.internal.zzhz r4 = r7.zzf     // Catch: java.lang.Throwable -> L50 java.io.IOException -> L56
            byte[] r4 = com.google.android.gms.measurement.internal.zzhz.a(r4, r2)     // Catch: java.lang.Throwable -> L50 java.io.IOException -> L56
            if (r2 == 0) goto L4c
            r2.disconnect()
        L4c:
            r7.zzb(r1, r0, r4, r3)
            return
        L50:
            r4 = move-exception
            r6 = r4
            r4 = r1
            r1 = r3
            r3 = r6
            goto L6e
        L56:
            r4 = move-exception
            r6 = r4
            r4 = r1
            r1 = r3
            r3 = r6
            goto L7b
        L5c:
            r3 = move-exception
            r4 = r1
            r1 = r0
            goto L6e
        L60:
            r3 = move-exception
            r4 = r1
            r1 = r0
            goto L7b
        L64:
            r3 = move-exception
            r1 = r0
            goto L6d
        L67:
            r3 = move-exception
            r1 = r0
            goto L7a
        L6a:
            r3 = move-exception
            r1 = r0
            r2 = r1
        L6d:
            r4 = 0
        L6e:
            if (r2 == 0) goto L73
            r2.disconnect()
        L73:
            r7.zzb(r4, r0, r0, r1)
            throw r3
        L77:
            r3 = move-exception
            r1 = r0
            r2 = r1
        L7a:
            r4 = 0
        L7b:
            if (r2 == 0) goto L80
            r2.disconnect()
        L80:
            r7.zzb(r4, r3, r0, r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzib.run():void");
    }
}
