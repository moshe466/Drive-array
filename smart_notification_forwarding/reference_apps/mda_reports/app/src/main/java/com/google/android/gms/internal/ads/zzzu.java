package com.google.android.gms.internal.ads;

import android.content.Context;
import android.net.Uri;
import android.os.Environment;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.google.android.gms.common.util.VisibleForTesting;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
/* loaded from: classes.dex */
public final class zzzu {
    private File file;

    @VisibleForTesting
    private String zzbma;

    @VisibleForTesting
    private String zzcrj;

    @VisibleForTesting
    private BlockingQueue<zzaae> zzcrm = new ArrayBlockingQueue(100);

    @VisibleForTesting
    private LinkedHashMap<String, String> zzcrn = new LinkedHashMap<>();

    @VisibleForTesting
    private Map<String, zzzy> zzcro = new HashMap();
    private final HashSet<String> zzcrp = new HashSet<>(Arrays.asList("noop", "activeViewPingSent", "viewabilityChanged", "visibilityChanged"));
    private AtomicBoolean zzcrq;

    @VisibleForTesting
    private Context zzup;

    private final void zza(Map<String, String> map, String str) {
        FileOutputStream fileOutputStream;
        Uri.Builder buildUpon = Uri.parse(this.zzcrj).buildUpon();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            buildUpon.appendQueryParameter(entry.getKey(), entry.getValue());
        }
        StringBuilder sb = new StringBuilder(buildUpon.build().toString());
        if (!TextUtils.isEmpty(str)) {
            sb.append("&it=");
            sb.append(str);
        }
        String sb2 = sb.toString();
        if (!this.zzcrq.get()) {
            com.google.android.gms.ads.internal.zzq.zzkq();
            zzawb.zzb(this.zzup, this.zzbma, sb2);
            return;
        }
        File file = this.file;
        if (file == null) {
            zzayu.zzez("CsiReporter: File doesn't exists. Cannot write CSI data to file.");
            return;
        }
        FileOutputStream fileOutputStream2 = null;
        try {
            try {
                fileOutputStream = new FileOutputStream(file, true);
            } catch (IOException e) {
                e = e;
            }
        } catch (Throwable th) {
            th = th;
        }
        try {
            fileOutputStream.write(sb2.getBytes());
            fileOutputStream.write(10);
            try {
                fileOutputStream.close();
            } catch (IOException e2) {
                zzayu.zzd("CsiReporter: Cannot close file: sdk_csi_data.txt.", e2);
            }
        } catch (IOException e3) {
            e = e3;
            fileOutputStream2 = fileOutputStream;
            zzayu.zzd("CsiReporter: Cannot write to file: sdk_csi_data.txt.", e);
            if (fileOutputStream2 != null) {
                try {
                    fileOutputStream2.close();
                } catch (IOException e4) {
                    zzayu.zzd("CsiReporter: Cannot close file: sdk_csi_data.txt.", e4);
                }
            }
        } catch (Throwable th2) {
            th = th2;
            fileOutputStream2 = fileOutputStream;
            if (fileOutputStream2 != null) {
                try {
                    fileOutputStream2.close();
                } catch (IOException e5) {
                    zzayu.zzd("CsiReporter: Cannot close file: sdk_csi_data.txt.", e5);
                }
            }
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Map<String, String> a(Map<String, String> map, @Nullable Map<String, String> map2) {
        LinkedHashMap linkedHashMap = new LinkedHashMap(map);
        if (map2 == null) {
            return linkedHashMap;
        }
        for (Map.Entry<String, String> entry : map2.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            linkedHashMap.put(key, zzcq(key).zzg((String) linkedHashMap.get(key), value));
        }
        return linkedHashMap;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void a() {
        while (true) {
            try {
                zzaae take = this.zzcrm.take();
                String zzqt = take.zzqt();
                if (!TextUtils.isEmpty(zzqt)) {
                    zza(a(this.zzcrn, take.a()), zzqt);
                }
            } catch (InterruptedException e) {
                zzayu.zzd("CsiReporter:reporter interrupted", e);
                return;
            }
        }
    }

    public final void zza(Context context, String str, String str2, Map<String, String> map) {
        File externalStorageDirectory;
        this.zzup = context;
        this.zzbma = str;
        this.zzcrj = str2;
        this.zzcrq = new AtomicBoolean(false);
        this.zzcrq.set(zzaay.zzcth.get().booleanValue());
        if (this.zzcrq.get() && (externalStorageDirectory = Environment.getExternalStorageDirectory()) != null) {
            this.file = new File(externalStorageDirectory, "sdk_csi_data.txt");
        }
        for (Map.Entry<String, String> entry : map.entrySet()) {
            this.zzcrn.put(entry.getKey(), entry.getValue());
        }
        zzazd.zzdwe.execute(new Runnable(this) { // from class: com.google.android.gms.internal.ads.zzzt
            private final zzzu zzcrl;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzcrl = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.zzcrl.a();
            }
        });
        this.zzcro.put("action", zzzy.zzcrs);
        this.zzcro.put("ad_format", zzzy.zzcrs);
        this.zzcro.put("e", zzzy.zzcrt);
    }

    public final boolean zza(zzaae zzaaeVar) {
        return this.zzcrm.offer(zzaaeVar);
    }

    public final zzzy zzcq(String str) {
        zzzy zzzyVar = this.zzcro.get(str);
        return zzzyVar != null ? zzzyVar : zzzy.zzcrr;
    }

    public final void zzcr(String str) {
        if (this.zzcrp.contains(str)) {
            return;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("sdkVersion", this.zzbma);
        linkedHashMap.put("ue", str);
        zza(a(this.zzcrn, linkedHashMap), "");
    }
}
