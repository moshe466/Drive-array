package com.google.android.gms.internal.ads;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.android.gms.internal.ads.zzdvx;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import javax.annotation.ParametersAreNonnullByDefault;
import javax.annotation.concurrent.GuardedBy;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@ParametersAreNonnullByDefault
/* loaded from: classes.dex */
public final class zzatf implements zzato {
    private static List<Future<Void>> zzdod = Collections.synchronizedList(new ArrayList());
    private final zzatn zzdld;

    @GuardedBy("lock")
    private final zzdwi zzdoe;

    @GuardedBy("lock")
    private final LinkedHashMap<String, zzdwm> zzdof;
    private final zzatq zzdoi;

    @VisibleForTesting
    private boolean zzdoj;
    private final zzatt zzdok;
    private final Context zzup;

    @GuardedBy("lock")
    private final List<String> zzdog = new ArrayList();

    @GuardedBy("lock")
    private final List<String> zzdoh = new ArrayList();
    private final Object lock = new Object();
    private HashSet<String> zzdol = new HashSet<>();
    private boolean zzdom = false;
    private boolean zzdon = false;
    private boolean zzdoo = false;

    public zzatf(Context context, zzazb zzazbVar, zzatn zzatnVar, String str, zzatq zzatqVar) {
        Preconditions.checkNotNull(zzatnVar, "SafeBrowsing config is not present.");
        this.zzup = context.getApplicationContext() != null ? context.getApplicationContext() : context;
        this.zzdof = new LinkedHashMap<>();
        this.zzdoi = zzatqVar;
        this.zzdld = zzatnVar;
        Iterator<String> it = this.zzdld.zzdow.iterator();
        while (it.hasNext()) {
            this.zzdol.add(it.next().toLowerCase(Locale.ENGLISH));
        }
        this.zzdol.remove("cookie".toLowerCase(Locale.ENGLISH));
        zzdwi zzdwiVar = new zzdwi();
        zzdwiVar.zzhxr = zzdvx.zzb.zzg.OCTAGON_AD;
        zzdwiVar.url = str;
        zzdwiVar.zzhxt = str;
        zzdvx.zzb.C0018zzb.zza zzbcw = zzdvx.zzb.C0018zzb.zzbcw();
        String str2 = this.zzdld.zzdos;
        if (str2 != null) {
            zzbcw.zzhl(str2);
        }
        zzdwiVar.zzhxv = (zzdvx.zzb.C0018zzb) zzbcw.zzbaf();
        zzdvx.zzb.zzi.zza zzbs = zzdvx.zzb.zzi.zzbdg().zzbs(Wrappers.packageManager(this.zzup).isCallerInstantApp());
        String str3 = zzazbVar.zzbma;
        if (str3 != null) {
            zzbs.zzho(str3);
        }
        long apkVersion = GoogleApiAvailabilityLight.getInstance().getApkVersion(this.zzup);
        if (apkVersion > 0) {
            zzbs.zzfu(apkVersion);
        }
        zzdwiVar.zzhyf = (zzdvx.zzb.zzi) zzbs.zzbaf();
        this.zzdoe = zzdwiVar;
        this.zzdok = new zzatt(this.zzup, this.zzdld.zzdoz, this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final /* synthetic */ Void c(String str) {
        return null;
    }

    @Nullable
    private final zzdwm zzdy(String str) {
        zzdwm zzdwmVar;
        synchronized (this.lock) {
            zzdwmVar = this.zzdof.get(str);
        }
        return zzdwmVar;
    }

    @VisibleForTesting
    private final zzdhe<Void> zzuo() {
        zzdhe<Void> zzb;
        if (!((this.zzdoj && this.zzdld.zzdoy) || (this.zzdoo && this.zzdld.zzdox) || (!this.zzdoj && this.zzdld.zzdov))) {
            return zzdgs.zzaj(null);
        }
        synchronized (this.lock) {
            this.zzdoe.zzhxw = new zzdwm[this.zzdof.size()];
            this.zzdof.values().toArray(this.zzdoe.zzhxw);
            this.zzdoe.zzhyg = (String[]) this.zzdog.toArray(new String[0]);
            this.zzdoe.zzhyh = (String[]) this.zzdoh.toArray(new String[0]);
            if (zzatp.isEnabled()) {
                String str = this.zzdoe.url;
                String str2 = this.zzdoe.zzhxx;
                StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 53 + String.valueOf(str2).length());
                sb.append("Sending SB report\n  url: ");
                sb.append(str);
                sb.append("\n  clickUrl: ");
                sb.append(str2);
                sb.append("\n  resources: \n");
                StringBuilder sb2 = new StringBuilder(sb.toString());
                for (zzdwm zzdwmVar : this.zzdoe.zzhxw) {
                    sb2.append("    [");
                    sb2.append(zzdwmVar.zzhzf.length);
                    sb2.append("] ");
                    sb2.append(zzdwmVar.url);
                }
                zzatp.zzea(sb2.toString());
            }
            zzdhe<String> zza = new zzaxk(this.zzup).zza(1, this.zzdld.zzdot, null, zzdvt.zza(this.zzdoe));
            if (zzatp.isEnabled()) {
                zza.addListener(new zzati(this), zzazd.zzdwe);
            }
            zzb = zzdgs.zzb(zza, zzath.a, zzazd.zzdwj);
        }
        return zzb;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ zzdhe a(Map map) {
        if (map != null) {
            try {
                for (String str : map.keySet()) {
                    JSONArray optJSONArray = new JSONObject((String) map.get(str)).optJSONArray("matches");
                    if (optJSONArray != null) {
                        synchronized (this.lock) {
                            int length = optJSONArray.length();
                            zzdwm zzdy = zzdy(str);
                            if (zzdy == null) {
                                String valueOf = String.valueOf(str);
                                zzatp.zzea(valueOf.length() != 0 ? "Cannot find the corresponding resource object for ".concat(valueOf) : new String("Cannot find the corresponding resource object for "));
                            } else {
                                zzdy.zzhzf = new String[length];
                                for (int i = 0; i < length; i++) {
                                    zzdy.zzhzf[i] = optJSONArray.getJSONObject(i).getString("threat_type");
                                }
                                this.zzdoj = (length > 0) | this.zzdoj;
                            }
                        }
                    }
                }
            } catch (JSONException e) {
                if (zzabf.zzcud.get().booleanValue()) {
                    zzayu.zzb("Failed to get SafeBrowsing metadata", e);
                }
                return zzdgs.zzk(new Exception("Safebrowsing report transmission failed."));
            }
        }
        if (this.zzdoj) {
            synchronized (this.lock) {
                this.zzdoe.zzhxr = zzdvx.zzb.zzg.OCTAGON_AD_SB_MATCH;
            }
        }
        return zzuo();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(String str) {
        synchronized (this.lock) {
            this.zzdog.add(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void b(String str) {
        synchronized (this.lock) {
            this.zzdoh.add(str);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzato
    public final void zza(String str, Map<String, String> map, int i) {
        synchronized (this.lock) {
            if (i == 3) {
                this.zzdoo = true;
            }
            if (this.zzdof.containsKey(str)) {
                if (i == 3) {
                    this.zzdof.get(str).zzhze = zzdvx.zzb.zzh.zza.zzhg(i);
                }
                return;
            }
            zzdwm zzdwmVar = new zzdwm();
            zzdwmVar.zzhze = zzdvx.zzb.zzh.zza.zzhg(i);
            zzdwmVar.zzhyy = Integer.valueOf(this.zzdof.size());
            zzdwmVar.url = str;
            zzdwmVar.zzhyz = new zzdwk();
            if (this.zzdol.size() > 0 && map != null) {
                ArrayList arrayList = new ArrayList();
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    String key = entry.getKey() != null ? entry.getKey() : "";
                    String value = entry.getValue() != null ? entry.getValue() : "";
                    if (this.zzdol.contains(key.toLowerCase(Locale.ENGLISH))) {
                        arrayList.add((zzdvx.zzb.zzc) ((zzdrt) zzdvx.zzb.zzc.zzbcy().zzbk(zzdqk.zzhf(key)).zzbl(zzdqk.zzhf(value)).zzbaf()));
                    }
                }
                zzdvx.zzb.zzc[] zzcVarArr = new zzdvx.zzb.zzc[arrayList.size()];
                arrayList.toArray(zzcVarArr);
                zzdwmVar.zzhyz.zzhyl = zzcVarArr;
            }
            this.zzdof.put(str, zzdwmVar);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzato
    public final String[] zza(String[] strArr) {
        return (String[]) this.zzdok.a(strArr).toArray(new String[0]);
    }

    @Override // com.google.android.gms.internal.ads.zzato
    public final void zzdv(String str) {
        synchronized (this.lock) {
            this.zzdoe.zzhxx = str;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzato
    public final void zzj(View view) {
        if (this.zzdld.zzdou && !this.zzdon) {
            com.google.android.gms.ads.internal.zzq.zzkq();
            Bitmap zzl = zzawb.zzl(view);
            if (zzl == null) {
                zzatp.zzea("Failed to capture the webview bitmap.");
            } else {
                this.zzdon = true;
                zzawb.zzc(new zzatg(this, zzl));
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzato
    public final zzatn zzuk() {
        return this.zzdld;
    }

    @Override // com.google.android.gms.internal.ads.zzato
    public final boolean zzul() {
        return PlatformVersion.isAtLeastKitKat() && this.zzdld.zzdou && !this.zzdon;
    }

    @Override // com.google.android.gms.internal.ads.zzato
    public final void zzum() {
        this.zzdom = true;
    }

    @Override // com.google.android.gms.internal.ads.zzato
    public final void zzun() {
        synchronized (this.lock) {
            zzdhe zzb = zzdgs.zzb(this.zzdoi.zza(this.zzup, this.zzdof.keySet()), new zzdgf(this) { // from class: com.google.android.gms.internal.ads.zzate
                private final zzatf zzdoc;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.zzdoc = this;
                }

                @Override // com.google.android.gms.internal.ads.zzdgf
                public final zzdhe zzf(Object obj) {
                    return this.zzdoc.a((Map) obj);
                }
            }, zzazd.zzdwj);
            zzdhe zza = zzdgs.zza(zzb, 10L, TimeUnit.SECONDS, zzazd.zzdwh);
            zzdgs.zza(zzb, new zzatj(this, zza), zzazd.zzdwj);
            zzdod.add(zza);
        }
    }
}
