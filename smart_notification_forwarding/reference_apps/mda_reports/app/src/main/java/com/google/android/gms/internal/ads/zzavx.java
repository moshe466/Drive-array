package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Looper;
import android.security.NetworkSecurityPolicy;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.google.android.gms.common.util.PlatformVersion;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import javax.annotation.concurrent.GuardedBy;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public final class zzavx implements zzavu {

    @Nullable
    @GuardedBy("lock")
    private SharedPreferences zzcgc;
    private boolean zzdrw;
    private zzdhe<?> zzdry;

    @Nullable
    @GuardedBy("lock")
    private SharedPreferences.Editor zzdsa;

    @Nullable
    @GuardedBy("lock")
    private String zzdsc;

    @Nullable
    @GuardedBy("lock")
    private String zzdsd;
    private final Object lock = new Object();
    private final List<Runnable> zzdrx = new ArrayList();

    @Nullable
    @GuardedBy("lock")
    private zzqi zzdrz = null;

    @GuardedBy("lock")
    private boolean zzdsb = false;

    @GuardedBy("lock")
    private boolean zzdiv = true;

    @GuardedBy("lock")
    private boolean zzdji = false;

    @GuardedBy("lock")
    private String zzdjl = "";

    @GuardedBy("lock")
    private long zzdse = 0;

    @GuardedBy("lock")
    private long zzdsf = 0;

    @GuardedBy("lock")
    private long zzdsg = 0;

    @GuardedBy("lock")
    private int zzdsh = -1;

    @GuardedBy("lock")
    private int zzdsi = 0;

    @GuardedBy("lock")
    private Set<String> zzdsj = Collections.emptySet();

    @GuardedBy("lock")
    private JSONObject zzdsk = new JSONObject();

    @GuardedBy("lock")
    private boolean zzdku = true;

    @GuardedBy("lock")
    private boolean zzdlf = true;

    @GuardedBy("lock")
    private String zzdsl = null;

    @GuardedBy("lock")
    private int zzdsm = -1;

    private final void zzc(Bundle bundle) {
        zzazd.zzdwe.execute(new Runnable(this) { // from class: com.google.android.gms.internal.ads.zzavz
            private final zzavx zzdrv;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzdrv = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.zzdrv.zzvt();
            }
        });
    }

    private final void zzwh() {
        zzdhe<?> zzdheVar = this.zzdry;
        if (zzdheVar == null || zzdheVar.isDone()) {
            return;
        }
        try {
            this.zzdry.get(1L, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            zzayu.zzd("Interrupted while waiting for preferences loaded.", e);
        } catch (CancellationException e2) {
            e = e2;
            zzayu.zzc("Fail to initialize AdSharedPreferenceManager.", e);
        } catch (ExecutionException e3) {
            e = e3;
            zzayu.zzc("Fail to initialize AdSharedPreferenceManager.", e);
        } catch (TimeoutException e4) {
            e = e4;
            zzayu.zzc("Fail to initialize AdSharedPreferenceManager.", e);
        }
    }

    private final Bundle zzwi() {
        Bundle bundle = new Bundle();
        bundle.putBoolean("listener_registration_bundle", true);
        synchronized (this.lock) {
            bundle.putBoolean("use_https", this.zzdiv);
            bundle.putBoolean("content_url_opted_out", this.zzdku);
            bundle.putBoolean("content_vertical_opted_out", this.zzdlf);
            bundle.putBoolean("auto_collect_location", this.zzdji);
            bundle.putInt("version_code", this.zzdsi);
            bundle.putStringArray("never_pool_slots", (String[]) this.zzdsj.toArray(new String[0]));
            bundle.putString("app_settings_json", this.zzdjl);
            bundle.putLong("app_settings_last_update_ms", this.zzdse);
            bundle.putLong("app_last_background_time_ms", this.zzdsf);
            bundle.putInt("request_in_session_count", this.zzdsh);
            bundle.putLong("first_ad_req_time_ms", this.zzdsg);
            bundle.putString("native_advanced_settings", this.zzdsk.toString());
            bundle.putString("display_cutout", this.zzdsl);
            bundle.putInt("app_measurement_npa", this.zzdsm);
            if (this.zzdsc != null) {
                bundle.putString("content_url_hashes", this.zzdsc);
            }
            if (this.zzdsd != null) {
                bundle.putString("content_vertical_hashes", this.zzdsd);
            }
        }
        return bundle;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void a(Context context, String str) {
        boolean z = false;
        SharedPreferences sharedPreferences = context.getSharedPreferences(str, 0);
        SharedPreferences.Editor edit = sharedPreferences.edit();
        synchronized (this.lock) {
            this.zzcgc = sharedPreferences;
            this.zzdsa = edit;
            if (PlatformVersion.isAtLeastM() && !NetworkSecurityPolicy.getInstance().isCleartextTrafficPermitted()) {
                z = true;
            }
            this.zzdsb = z;
            this.zzdiv = this.zzcgc.getBoolean("use_https", this.zzdiv);
            this.zzdku = this.zzcgc.getBoolean("content_url_opted_out", this.zzdku);
            this.zzdsc = this.zzcgc.getString("content_url_hashes", this.zzdsc);
            this.zzdji = this.zzcgc.getBoolean("auto_collect_location", this.zzdji);
            this.zzdlf = this.zzcgc.getBoolean("content_vertical_opted_out", this.zzdlf);
            this.zzdsd = this.zzcgc.getString("content_vertical_hashes", this.zzdsd);
            this.zzdsi = this.zzcgc.getInt("version_code", this.zzdsi);
            this.zzdjl = this.zzcgc.getString("app_settings_json", this.zzdjl);
            this.zzdse = this.zzcgc.getLong("app_settings_last_update_ms", this.zzdse);
            this.zzdsf = this.zzcgc.getLong("app_last_background_time_ms", this.zzdsf);
            this.zzdsh = this.zzcgc.getInt("request_in_session_count", this.zzdsh);
            this.zzdsg = this.zzcgc.getLong("first_ad_req_time_ms", this.zzdsg);
            this.zzdsj = this.zzcgc.getStringSet("never_pool_slots", this.zzdsj);
            this.zzdsl = this.zzcgc.getString("display_cutout", this.zzdsl);
            this.zzdsm = this.zzcgc.getInt("app_measurement_npa", this.zzdsm);
            try {
                this.zzdsk = new JSONObject(this.zzcgc.getString("native_advanced_settings", "{}"));
            } catch (JSONException e) {
                zzayu.zzd("Could not convert native advanced settings to json object", e);
            }
            zzc(zzwi());
        }
    }

    public final void zza(final Context context, String str, boolean z) {
        final String concat;
        synchronized (this.lock) {
            if (this.zzcgc != null) {
                return;
            }
            if (str == null) {
                concat = "admob";
            } else {
                String valueOf = String.valueOf(str);
                concat = valueOf.length() != 0 ? "admob__".concat(valueOf) : new String("admob__");
            }
            this.zzdry = zzazd.zzdwe.submit(new Runnable(this, context, concat) { // from class: com.google.android.gms.internal.ads.zzavw
                private final Context zzcey;
                private final String zzdbl;
                private final zzavx zzdrv;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.zzdrv = this;
                    this.zzcey = context;
                    this.zzdbl = concat;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    this.zzdrv.a(this.zzcey, this.zzdbl);
                }
            });
            this.zzdrw = z;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzavu
    public final void zza(String str, String str2, boolean z) {
        zzwh();
        synchronized (this.lock) {
            JSONArray optJSONArray = this.zzdsk.optJSONArray(str);
            if (optJSONArray == null) {
                optJSONArray = new JSONArray();
            }
            int length = optJSONArray.length();
            for (int i = 0; i < optJSONArray.length(); i++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                if (optJSONObject == null) {
                    return;
                }
                if (str2.equals(optJSONObject.optString("template_id"))) {
                    if (z && optJSONObject.optBoolean("uses_media_view", false)) {
                        return;
                    } else {
                        length = i;
                    }
                }
            }
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("template_id", str2);
                jSONObject.put("uses_media_view", z);
                jSONObject.put("timestamp_ms", com.google.android.gms.ads.internal.zzq.zzkx().currentTimeMillis());
                optJSONArray.put(length, jSONObject);
                this.zzdsk.put(str, optJSONArray);
            } catch (JSONException e) {
                zzayu.zzd("Could not update native advanced settings", e);
            }
            if (this.zzdsa != null) {
                this.zzdsa.putString("native_advanced_settings", this.zzdsk.toString());
                this.zzdsa.apply();
            }
            Bundle bundle = new Bundle();
            bundle.putString("native_advanced_settings", this.zzdsk.toString());
            zzc(bundle);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzavu
    public final void zzao(boolean z) {
        zzwh();
        synchronized (this.lock) {
            if (this.zzdku == z) {
                return;
            }
            this.zzdku = z;
            if (this.zzdsa != null) {
                this.zzdsa.putBoolean("content_url_opted_out", z);
                this.zzdsa.apply();
            }
            Bundle bundle = new Bundle();
            bundle.putBoolean("content_url_opted_out", this.zzdku);
            bundle.putBoolean("content_vertical_opted_out", this.zzdlf);
            zzc(bundle);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzavu
    public final void zzap(boolean z) {
        zzwh();
        synchronized (this.lock) {
            if (this.zzdlf == z) {
                return;
            }
            this.zzdlf = z;
            if (this.zzdsa != null) {
                this.zzdsa.putBoolean("content_vertical_opted_out", z);
                this.zzdsa.apply();
            }
            Bundle bundle = new Bundle();
            bundle.putBoolean("content_url_opted_out", this.zzdku);
            bundle.putBoolean("content_vertical_opted_out", this.zzdlf);
            zzc(bundle);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzavu
    public final void zzaq(boolean z) {
        zzwh();
        synchronized (this.lock) {
            if (this.zzdji == z) {
                return;
            }
            this.zzdji = z;
            if (this.zzdsa != null) {
                this.zzdsa.putBoolean("auto_collect_location", z);
                this.zzdsa.apply();
            }
            Bundle bundle = new Bundle();
            bundle.putBoolean("auto_collect_location", z);
            zzc(bundle);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzavu
    public final void zzb(Runnable runnable) {
        this.zzdrx.add(runnable);
    }

    @Override // com.google.android.gms.internal.ads.zzavu
    public final void zzcp(int i) {
        zzwh();
        synchronized (this.lock) {
            if (this.zzdsi == i) {
                return;
            }
            this.zzdsi = i;
            if (this.zzdsa != null) {
                this.zzdsa.putInt("version_code", i);
                this.zzdsa.apply();
            }
            Bundle bundle = new Bundle();
            bundle.putInt("version_code", i);
            zzc(bundle);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzavu
    public final void zzcq(int i) {
        zzwh();
        synchronized (this.lock) {
            if (this.zzdsh == i) {
                return;
            }
            this.zzdsh = i;
            if (this.zzdsa != null) {
                this.zzdsa.putInt("request_in_session_count", i);
                this.zzdsa.apply();
            }
            Bundle bundle = new Bundle();
            bundle.putInt("request_in_session_count", i);
            zzc(bundle);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzavu
    public final void zzee(@Nullable String str) {
        zzwh();
        synchronized (this.lock) {
            if (str != null) {
                if (!str.equals(this.zzdsc)) {
                    this.zzdsc = str;
                    if (this.zzdsa != null) {
                        this.zzdsa.putString("content_url_hashes", str);
                        this.zzdsa.apply();
                    }
                    Bundle bundle = new Bundle();
                    bundle.putString("content_url_hashes", str);
                    zzc(bundle);
                }
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzavu
    public final void zzef(@Nullable String str) {
        zzwh();
        synchronized (this.lock) {
            if (str != null) {
                if (!str.equals(this.zzdsd)) {
                    this.zzdsd = str;
                    if (this.zzdsa != null) {
                        this.zzdsa.putString("content_vertical_hashes", str);
                        this.zzdsa.apply();
                    }
                    Bundle bundle = new Bundle();
                    bundle.putString("content_vertical_hashes", str);
                    zzc(bundle);
                }
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzavu
    public final void zzeg(String str) {
        zzwh();
        synchronized (this.lock) {
            long currentTimeMillis = com.google.android.gms.ads.internal.zzq.zzkx().currentTimeMillis();
            this.zzdse = currentTimeMillis;
            if (str != null && !str.equals(this.zzdjl)) {
                this.zzdjl = str;
                if (this.zzdsa != null) {
                    this.zzdsa.putString("app_settings_json", str);
                    this.zzdsa.putLong("app_settings_last_update_ms", currentTimeMillis);
                    this.zzdsa.apply();
                }
                Bundle bundle = new Bundle();
                bundle.putString("app_settings_json", str);
                bundle.putLong("app_settings_last_update_ms", currentTimeMillis);
                zzc(bundle);
                Iterator<Runnable> it = this.zzdrx.iterator();
                while (it.hasNext()) {
                    it.next().run();
                }
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzavu
    public final void zzeh(String str) {
        zzwh();
        synchronized (this.lock) {
            if (TextUtils.equals(this.zzdsl, str)) {
                return;
            }
            this.zzdsl = str;
            if (this.zzdsa != null) {
                this.zzdsa.putString("display_cutout", str);
                this.zzdsa.apply();
            }
            Bundle bundle = new Bundle();
            bundle.putString("display_cutout", str);
            zzc(bundle);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzavu
    public final void zzez(long j) {
        zzwh();
        synchronized (this.lock) {
            if (this.zzdsf == j) {
                return;
            }
            this.zzdsf = j;
            if (this.zzdsa != null) {
                this.zzdsa.putLong("app_last_background_time_ms", j);
                this.zzdsa.apply();
            }
            Bundle bundle = new Bundle();
            bundle.putLong("app_last_background_time_ms", j);
            zzc(bundle);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzavu
    public final void zzfa(long j) {
        zzwh();
        synchronized (this.lock) {
            if (this.zzdsg == j) {
                return;
            }
            this.zzdsg = j;
            if (this.zzdsa != null) {
                this.zzdsa.putLong("first_ad_req_time_ms", j);
                this.zzdsa.apply();
            }
            Bundle bundle = new Bundle();
            bundle.putLong("first_ad_req_time_ms", j);
            zzc(bundle);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzavu
    @Nullable
    public final zzqi zzvt() {
        if (!this.zzdrw) {
            return null;
        }
        if ((zzvu() && zzvw()) || !zzaaw.zzcsy.get().booleanValue()) {
            return null;
        }
        synchronized (this.lock) {
            if (Looper.getMainLooper() == null) {
                return null;
            }
            if (this.zzdrz == null) {
                this.zzdrz = new zzqi();
            }
            this.zzdrz.zzmb();
            zzayu.zzey("start fetching content...");
            return this.zzdrz;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzavu
    public final boolean zzvu() {
        boolean z;
        zzwh();
        synchronized (this.lock) {
            z = this.zzdku;
        }
        return z;
    }

    @Override // com.google.android.gms.internal.ads.zzavu
    @Nullable
    public final String zzvv() {
        String str;
        zzwh();
        synchronized (this.lock) {
            str = this.zzdsc;
        }
        return str;
    }

    @Override // com.google.android.gms.internal.ads.zzavu
    public final boolean zzvw() {
        boolean z;
        zzwh();
        synchronized (this.lock) {
            z = this.zzdlf;
        }
        return z;
    }

    @Override // com.google.android.gms.internal.ads.zzavu
    @Nullable
    public final String zzvx() {
        String str;
        zzwh();
        synchronized (this.lock) {
            str = this.zzdsd;
        }
        return str;
    }

    @Override // com.google.android.gms.internal.ads.zzavu
    public final boolean zzvy() {
        boolean z;
        zzwh();
        synchronized (this.lock) {
            z = this.zzdji;
        }
        return z;
    }

    @Override // com.google.android.gms.internal.ads.zzavu
    public final int zzvz() {
        int i;
        zzwh();
        synchronized (this.lock) {
            i = this.zzdsi;
        }
        return i;
    }

    @Override // com.google.android.gms.internal.ads.zzavu
    public final zzavf zzwa() {
        zzavf zzavfVar;
        zzwh();
        synchronized (this.lock) {
            zzavfVar = new zzavf(this.zzdjl, this.zzdse);
        }
        return zzavfVar;
    }

    @Override // com.google.android.gms.internal.ads.zzavu
    public final long zzwb() {
        long j;
        zzwh();
        synchronized (this.lock) {
            j = this.zzdsf;
        }
        return j;
    }

    @Override // com.google.android.gms.internal.ads.zzavu
    public final int zzwc() {
        int i;
        zzwh();
        synchronized (this.lock) {
            i = this.zzdsh;
        }
        return i;
    }

    @Override // com.google.android.gms.internal.ads.zzavu
    public final long zzwd() {
        long j;
        zzwh();
        synchronized (this.lock) {
            j = this.zzdsg;
        }
        return j;
    }

    @Override // com.google.android.gms.internal.ads.zzavu
    public final JSONObject zzwe() {
        JSONObject jSONObject;
        zzwh();
        synchronized (this.lock) {
            jSONObject = this.zzdsk;
        }
        return jSONObject;
    }

    @Override // com.google.android.gms.internal.ads.zzavu
    public final void zzwf() {
        zzwh();
        synchronized (this.lock) {
            this.zzdsk = new JSONObject();
            if (this.zzdsa != null) {
                this.zzdsa.remove("native_advanced_settings");
                this.zzdsa.apply();
            }
            Bundle bundle = new Bundle();
            bundle.putString("native_advanced_settings", "{}");
            zzc(bundle);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzavu
    public final String zzwg() {
        String str;
        zzwh();
        synchronized (this.lock) {
            str = this.zzdsl;
        }
        return str;
    }
}
