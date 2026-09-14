package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.annotation.concurrent.GuardedBy;
import org.json.JSONObject;

/* loaded from: classes.dex */
public final class zzbht extends zzwj {
    private final zzazb zzbll;
    private final zzatv zzbng;
    private final zzcka zzfap;
    private final zzcis<zzdac, zzcjx> zzfaq;
    private final zzcob zzfar;
    private final zzceq zzfas;
    private final Context zzup;

    @GuardedBy("this")
    private boolean zzxx = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbht(Context context, zzazb zzazbVar, zzcka zzckaVar, zzcis<zzdac, zzcjx> zzcisVar, zzcob zzcobVar, zzceq zzceqVar, zzatv zzatvVar) {
        this.zzup = context;
        this.zzbll = zzazbVar;
        this.zzfap = zzckaVar;
        this.zzfaq = zzcisVar;
        this.zzfar = zzcobVar;
        this.zzfas = zzceqVar;
        this.zzbng = zzatvVar;
    }

    private final String zzaez() {
        Context applicationContext = this.zzup.getApplicationContext() == null ? this.zzup : this.zzup.getApplicationContext();
        try {
            String string = Wrappers.packageManager(applicationContext).getApplicationInfo(applicationContext.getPackageName(), 128).metaData.getString("com.google.android.gms.ads.APPLICATION_ID");
            return TextUtils.isEmpty(string) ? "" : (string.matches("^ca-app-pub-[0-9]{16}~[0-9]{10}$") || string.matches("^/\\d+~.+$")) ? string : "";
        } catch (PackageManager.NameNotFoundException | NullPointerException e) {
            zzavs.zza("Error getting metadata", e);
            return "";
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void a(Runnable runnable) {
        Preconditions.checkMainThread("Adapters must be initialized on the main thread.");
        Map<String, zzakx> zzvn = com.google.android.gms.ads.internal.zzq.zzku().zzvf().zzwa().zzvn();
        if (zzvn == null || zzvn.isEmpty()) {
            return;
        }
        if (runnable != null) {
            try {
                runnable.run();
            } catch (Throwable th) {
                zzayu.zzd("Could not initialize rewarded ads.", th);
                return;
            }
        }
        if (this.zzfap.zzamf()) {
            HashMap hashMap = new HashMap();
            Iterator<zzakx> it = zzvn.values().iterator();
            while (it.hasNext()) {
                for (zzaky zzakyVar : it.next().zzdbo) {
                    String str = zzakyVar.zzdct;
                    for (String str2 : zzakyVar.zzdcl) {
                        if (!hashMap.containsKey(str2)) {
                            hashMap.put(str2, new ArrayList());
                        }
                        if (str != null) {
                            ((Collection) hashMap.get(str2)).add(str);
                        }
                    }
                }
            }
            JSONObject jSONObject = new JSONObject();
            for (Map.Entry entry : hashMap.entrySet()) {
                String str3 = (String) entry.getKey();
                try {
                    zzcip<zzdac, zzcjx> zzd = this.zzfaq.zzd(str3, jSONObject);
                    if (zzd != null) {
                        zzdac zzdacVar = zzd.zzddn;
                        if (!zzdacVar.isInitialized() && zzdacVar.zzsp()) {
                            zzdacVar.zza(this.zzup, zzd.zzfyf, (List<String>) entry.getValue());
                            String valueOf = String.valueOf(str3);
                            zzayu.zzea(valueOf.length() != 0 ? "Initialized rewarded video mediation adapter ".concat(valueOf) : new String("Initialized rewarded video mediation adapter "));
                        }
                    }
                } catch (zzdab e) {
                    StringBuilder sb = new StringBuilder(String.valueOf(str3).length() + 56);
                    sb.append("Failed to initialize rewarded video mediation adapter \"");
                    sb.append(str3);
                    sb.append("\"");
                    zzayu.zzd(sb.toString(), e);
                }
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzwk
    public final String getVersionString() {
        return this.zzbll.zzbma;
    }

    @Override // com.google.android.gms.internal.ads.zzwk
    public final synchronized void initialize() {
        if (this.zzxx) {
            zzayu.zzez("Mobile ads is initialized already.");
            return;
        }
        zzzn.initialize(this.zzup);
        com.google.android.gms.ads.internal.zzq.zzku().zzd(this.zzup, this.zzbll);
        com.google.android.gms.ads.internal.zzq.zzkw().initialize(this.zzup);
        this.zzxx = true;
        this.zzfas.zzall();
        if (((Boolean) zzve.zzoy().zzd(zzzn.zzcko)).booleanValue()) {
            this.zzfar.zzamj();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzwk
    public final synchronized void setAppMuted(boolean z) {
        com.google.android.gms.ads.internal.zzq.zzkv().setAppMuted(z);
    }

    @Override // com.google.android.gms.internal.ads.zzwk
    public final synchronized void setAppVolume(float f) {
        com.google.android.gms.ads.internal.zzq.zzkv().setAppVolume(f);
    }

    @Override // com.google.android.gms.internal.ads.zzwk
    public final void zza(zzagu zzaguVar) {
        this.zzfas.zzb(zzaguVar);
    }

    @Override // com.google.android.gms.internal.ads.zzwk
    public final void zza(zzalc zzalcVar) {
        this.zzfap.zzb(zzalcVar);
    }

    @Override // com.google.android.gms.internal.ads.zzwk
    public final void zza(zzyq zzyqVar) {
        this.zzbng.zza(this.zzup, zzyqVar);
    }

    @Override // com.google.android.gms.internal.ads.zzwk
    public final void zza(@Nullable String str, IObjectWrapper iObjectWrapper) {
        zzzn.initialize(this.zzup);
        String zzaez = ((Boolean) zzve.zzoy().zzd(zzzn.zzcms)).booleanValue() ? zzaez() : "";
        if (!TextUtils.isEmpty(zzaez)) {
            str = zzaez;
        }
        if (TextUtils.isEmpty(str)) {
            return;
        }
        boolean booleanValue = ((Boolean) zzve.zzoy().zzd(zzzn.zzcmr)).booleanValue() | ((Boolean) zzve.zzoy().zzd(zzzn.zzcix)).booleanValue();
        Runnable runnable = null;
        if (((Boolean) zzve.zzoy().zzd(zzzn.zzcix)).booleanValue()) {
            booleanValue = true;
            final Runnable runnable2 = (Runnable) ObjectWrapper.unwrap(iObjectWrapper);
            runnable = new Runnable(this, runnable2) { // from class: com.google.android.gms.internal.ads.zzbhw
                private final zzbht zzfat;
                private final Runnable zzfau;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.zzfat = this;
                    this.zzfau = runnable2;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    zzazd.zzdwi.execute(new Runnable(this.zzfat, this.zzfau) { // from class: com.google.android.gms.internal.ads.zzbhv
                        private final zzbht zzfat;
                        private final Runnable zzfau;

                        /* JADX INFO: Access modifiers changed from: package-private */
                        {
                            this.zzfat = r1;
                            this.zzfau = r2;
                        }

                        @Override // java.lang.Runnable
                        public final void run() {
                            this.zzfat.a(this.zzfau);
                        }
                    });
                }
            };
        }
        if (booleanValue) {
            com.google.android.gms.ads.internal.zzq.zzky().zza(this.zzup, this.zzbll, str, runnable);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzwk
    public final void zzb(IObjectWrapper iObjectWrapper, String str) {
        if (iObjectWrapper == null) {
            zzayu.zzex("Wrapped context is null. Failed to open debug menu.");
            return;
        }
        Context context = (Context) ObjectWrapper.unwrap(iObjectWrapper);
        if (context == null) {
            zzayu.zzex("Context is null. Failed to open debug menu.");
            return;
        }
        zzawt zzawtVar = new zzawt(context);
        zzawtVar.setAdUnitId(str);
        zzawtVar.zzx(this.zzbll.zzbma);
        zzawtVar.showDialog();
    }

    @Override // com.google.android.gms.internal.ads.zzwk
    public final synchronized void zzcd(String str) {
        zzzn.initialize(this.zzup);
        if (!TextUtils.isEmpty(str)) {
            if (((Boolean) zzve.zzoy().zzd(zzzn.zzcmr)).booleanValue()) {
                com.google.android.gms.ads.internal.zzq.zzky().zza(this.zzup, this.zzbll, str, (Runnable) null);
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzwk
    public final void zzce(String str) {
        this.zzfar.zzgi(str);
    }

    @Override // com.google.android.gms.internal.ads.zzwk
    public final synchronized float zzpe() {
        return com.google.android.gms.ads.internal.zzq.zzkv().zzpe();
    }

    @Override // com.google.android.gms.internal.ads.zzwk
    public final synchronized boolean zzpf() {
        return com.google.android.gms.ads.internal.zzq.zzkv().zzpf();
    }

    @Override // com.google.android.gms.internal.ads.zzwk
    public final List<zzagn> zzpg() {
        return this.zzfas.zzalm();
    }
}
