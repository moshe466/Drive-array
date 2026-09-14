package com.google.android.gms.internal.ads;

import androidx.annotation.VisibleForTesting;
import io.fabric.sdk.android.services.network.HttpRequest;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.net.ssl.SSLSocketFactory;

/* loaded from: classes.dex */
public final class zzat extends zzah {
    private final zzav zzck;
    private final SSLSocketFactory zzcl;

    public zzat() {
        this(null);
    }

    private zzat(zzav zzavVar) {
        this(null, null);
    }

    private zzat(zzav zzavVar, SSLSocketFactory sSLSocketFactory) {
        this.zzck = null;
        this.zzcl = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static InputStream zza(HttpURLConnection httpURLConnection) {
        try {
            return httpURLConnection.getInputStream();
        } catch (IOException unused) {
            return httpURLConnection.getErrorStream();
        }
    }

    @VisibleForTesting
    private static List<zzk> zza(Map<String, List<String>> map) {
        ArrayList arrayList = new ArrayList(map.size());
        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            if (entry.getKey() != null) {
                Iterator<String> it = entry.getValue().iterator();
                while (it.hasNext()) {
                    arrayList.add(new zzk(entry.getKey(), it.next()));
                }
            }
        }
        return arrayList;
    }

    private static void zza(HttpURLConnection httpURLConnection, zzq<?> zzqVar) {
        byte[] zzf = zzqVar.zzf();
        if (zzf != null) {
            httpURLConnection.setDoOutput(true);
            if (!httpURLConnection.getRequestProperties().containsKey("Content-Type")) {
                httpURLConnection.setRequestProperty("Content-Type", HttpRequest.CHARSET_UTF8.length() != 0 ? "application/x-www-form-urlencoded; charset=".concat(HttpRequest.CHARSET_UTF8) : new String("application/x-www-form-urlencoded; charset="));
            }
            DataOutputStream dataOutputStream = new DataOutputStream(httpURLConnection.getOutputStream());
            dataOutputStream.write(zzf);
            dataOutputStream.close();
        }
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:20:0x008a. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00bf A[Catch: all -> 0x0114, TryCatch #1 {all -> 0x0114, blocks: (B:14:0x0068, B:15:0x0070, B:17:0x0076, B:19:0x0086, B:20:0x008a, B:21:0x008d, B:22:0x010e, B:23:0x0113, B:24:0x0091, B:25:0x0096, B:27:0x009c, B:31:0x00a9, B:32:0x00af, B:34:0x00b8, B:36:0x00bf, B:48:0x00db, B:61:0x0106, B:62:0x010d), top: B:13:0x0068 }] */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0106 A[Catch: all -> 0x0114, TRY_ENTER, TryCatch #1 {all -> 0x0114, blocks: (B:14:0x0068, B:15:0x0070, B:17:0x0076, B:19:0x0086, B:20:0x008a, B:21:0x008d, B:22:0x010e, B:23:0x0113, B:24:0x0091, B:25:0x0096, B:27:0x009c, B:31:0x00a9, B:32:0x00af, B:34:0x00b8, B:36:0x00bf, B:48:0x00db, B:61:0x0106, B:62:0x010d), top: B:13:0x0068 }] */
    @Override // com.google.android.gms.internal.ads.zzah
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final com.google.android.gms.internal.ads.zzar zza(com.google.android.gms.internal.ads.zzq<?> r7, java.util.Map<java.lang.String, java.lang.String> r8) {
        /*
            Method dump skipped, instructions count: 308
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzat.zza(com.google.android.gms.internal.ads.zzq, java.util.Map):com.google.android.gms.internal.ads.zzar");
    }
}
