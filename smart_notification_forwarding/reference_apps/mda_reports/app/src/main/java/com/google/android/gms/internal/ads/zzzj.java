package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.ConditionVariable;
import androidx.annotation.Nullable;
import com.google.android.gms.common.GooglePlayServicesUtilLight;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.common.wrappers.Wrappers;
import javax.annotation.ParametersAreNonnullByDefault;
import org.json.JSONException;
import org.json.JSONObject;

@ParametersAreNonnullByDefault
/* loaded from: classes.dex */
public final class zzzj implements SharedPreferences.OnSharedPreferenceChangeListener {
    private Context zzcgd;
    private final Object lock = new Object();
    private final ConditionVariable zzcga = new ConditionVariable();
    private volatile boolean zzxx = false;

    @VisibleForTesting
    private volatile boolean zzcgb = false;

    @Nullable
    private SharedPreferences zzcgc = null;
    private Bundle metaData = new Bundle();
    private JSONObject zzcge = new JSONObject();

    private final void zzqi() {
        if (this.zzcgc == null) {
            return;
        }
        try {
            this.zzcge = new JSONObject((String) zzayc.zza(new zzden(this) { // from class: com.google.android.gms.internal.ads.zzzl
                private final zzzj zzcgf;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.zzcgf = this;
                }

                @Override // com.google.android.gms.internal.ads.zzden
                public final Object get() {
                    return this.zzcgf.a();
                }
            }));
        } catch (JSONException unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ Object a(zzzc zzzcVar) {
        return zzzcVar.zza(this.zzcgc);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ String a() {
        return this.zzcgc.getString("flag_configuration", "{}");
    }

    public final void initialize(Context context) {
        if (this.zzxx) {
            return;
        }
        synchronized (this.lock) {
            if (this.zzxx) {
                return;
            }
            if (!this.zzcgb) {
                this.zzcgb = true;
            }
            this.zzcgd = context.getApplicationContext() == null ? context : context.getApplicationContext();
            try {
                this.metaData = Wrappers.packageManager(this.zzcgd).getApplicationInfo(this.zzcgd.getPackageName(), 128).metaData;
            } catch (PackageManager.NameNotFoundException | NullPointerException unused) {
            }
            try {
                Context remoteContext = GooglePlayServicesUtilLight.getRemoteContext(context);
                if (remoteContext == null && context != null && (remoteContext = context.getApplicationContext()) == null) {
                    remoteContext = context;
                }
                if (remoteContext == null) {
                    return;
                }
                zzve.zzow();
                this.zzcgc = remoteContext.getSharedPreferences("google_ads_flags", 0);
                if (this.zzcgc != null) {
                    this.zzcgc.registerOnSharedPreferenceChangeListener(this);
                }
                zzabn.zza(new zzzo(this));
                zzqi();
                this.zzxx = true;
            } finally {
                this.zzcgb = false;
                this.zzcga.open();
            }
        }
    }

    @Override // android.content.SharedPreferences.OnSharedPreferenceChangeListener
    public final void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
        if ("flag_configuration".equals(str)) {
            zzqi();
        }
    }

    public final <T> T zzd(final zzzc<T> zzzcVar) {
        if (!this.zzcga.block(5000L)) {
            synchronized (this.lock) {
                if (!this.zzcgb) {
                    throw new IllegalStateException("Flags.initialize() was not called!");
                }
            }
        }
        if (!this.zzxx || this.zzcgc == null) {
            synchronized (this.lock) {
                if (this.zzxx && this.zzcgc != null) {
                }
                return zzzcVar.zzqf();
            }
        }
        if (zzzcVar.getSource() != 2) {
            return (zzzcVar.getSource() == 1 && this.zzcge.has(zzzcVar.getKey())) ? zzzcVar.zza(this.zzcge) : (T) zzayc.zza(new zzden(this, zzzcVar) { // from class: com.google.android.gms.internal.ads.zzzm
                private final zzzj zzcgf;
                private final zzzc zzcgg;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.zzcgf = this;
                    this.zzcgg = zzzcVar;
                }

                @Override // com.google.android.gms.internal.ads.zzden
                public final Object get() {
                    return this.zzcgf.a(this.zzcgg);
                }
            });
        }
        Bundle bundle = this.metaData;
        return bundle == null ? zzzcVar.zzqf() : zzzcVar.zza(bundle);
    }
}
