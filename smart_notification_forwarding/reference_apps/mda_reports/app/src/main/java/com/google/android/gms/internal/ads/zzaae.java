package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
/* loaded from: classes.dex */
public final class zzaae {

    @Nullable
    private zzaae zzcse;
    private final List<zzaac> zzcsc = new LinkedList();
    private final Map<String, String> zzcsd = new LinkedHashMap();
    private final Object lock = new Object();

    @VisibleForTesting
    boolean a = true;

    public zzaae(boolean z, String str, String str2) {
        this.zzcsd.put("action", str);
        this.zzcsd.put("ad_format", str2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @VisibleForTesting
    public final Map<String, String> a() {
        synchronized (this.lock) {
            zzzu zzuz = com.google.android.gms.ads.internal.zzq.zzku().zzuz();
            if (zzuz != null && this.zzcse != null) {
                return zzuz.a(this.zzcsd, this.zzcse.a());
            }
            return this.zzcsd;
        }
    }

    public final boolean zza(zzaac zzaacVar, long j, String... strArr) {
        synchronized (this.lock) {
            for (String str : strArr) {
                this.zzcsc.add(new zzaac(j, str, zzaacVar));
            }
        }
        return true;
    }

    public final void zzc(@Nullable zzaae zzaaeVar) {
        synchronized (this.lock) {
            this.zzcse = zzaaeVar;
        }
    }

    @Nullable
    public final zzaac zzex(long j) {
        if (this.a) {
            return new zzaac(j, null, null);
        }
        return null;
    }

    public final void zzh(String str, String str2) {
        zzzu zzuz;
        if (!this.a || TextUtils.isEmpty(str2) || (zzuz = com.google.android.gms.ads.internal.zzq.zzku().zzuz()) == null) {
            return;
        }
        synchronized (this.lock) {
            zzzy zzcq = zzuz.zzcq(str);
            Map<String, String> map = this.zzcsd;
            map.put(str, zzcq.zzg(map.get(str), str2));
        }
    }

    public final String zzqt() {
        String sb;
        StringBuilder sb2 = new StringBuilder();
        synchronized (this.lock) {
            for (zzaac zzaacVar : this.zzcsc) {
                long time = zzaacVar.getTime();
                String zzqq = zzaacVar.zzqq();
                zzaac zzqr = zzaacVar.zzqr();
                if (zzqr != null && time > 0) {
                    long time2 = time - zzqr.getTime();
                    sb2.append(zzqq);
                    sb2.append('.');
                    sb2.append(time2);
                    sb2.append(',');
                }
            }
            this.zzcsc.clear();
            if (!TextUtils.isEmpty(null)) {
                sb2.append((String) null);
            } else if (sb2.length() > 0) {
                sb2.setLength(sb2.length() - 1);
            }
            sb = sb2.toString();
        }
        return sb;
    }
}
