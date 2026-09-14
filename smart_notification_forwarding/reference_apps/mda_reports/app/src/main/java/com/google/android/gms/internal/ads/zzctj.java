package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes.dex */
public final class zzctj implements zzcub<zzctg> {
    private final ScheduledExecutorService zzffx;
    private final zzczu zzfgl;
    private final zzdhd zzfov;
    private final zzcnz zzgbe;
    private String zzgeb;
    private final zzcob zzggk;
    private final Context zzup;

    public zzctj(zzdhd zzdhdVar, ScheduledExecutorService scheduledExecutorService, String str, zzcob zzcobVar, Context context, zzczu zzczuVar, zzcnz zzcnzVar) {
        this.zzfov = zzdhdVar;
        this.zzffx = scheduledExecutorService;
        this.zzgeb = str;
        this.zzggk = zzcobVar;
        this.zzup = context;
        this.zzfgl = zzczuVar;
        this.zzgbe = zzcnzVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ zzdhe a() {
        Map<String, List<Bundle>> zzr = this.zzggk.zzr(this.zzgeb, this.zzfgl.zzgmm);
        final ArrayList arrayList = new ArrayList();
        for (Map.Entry<String, List<Bundle>> entry : zzr.entrySet()) {
            final String key = entry.getKey();
            final List<Bundle> value = entry.getValue();
            Bundle bundle = this.zzfgl.zzgml.zzccf;
            final Bundle bundle2 = bundle != null ? bundle.getBundle(key) : null;
            arrayList.add(zzdgn.zze(zzdgs.zza(new zzdgd(this, key, value, bundle2) { // from class: com.google.android.gms.internal.ads.zzctl
                private final String zzcyr;
                private final zzctj zzggj;
                private final List zzggl;
                private final Bundle zzggm;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.zzggj = this;
                    this.zzcyr = key;
                    this.zzggl = value;
                    this.zzggm = bundle2;
                }

                @Override // com.google.android.gms.internal.ads.zzdgd
                public final zzdhe zzanm() {
                    return this.zzggj.a(this.zzcyr, this.zzggl, this.zzggm);
                }
            }, this.zzfov)).zza(((Long) zzve.zzoy().zzd(zzzn.zzckm)).longValue(), TimeUnit.MILLISECONDS, this.zzffx).zza(Throwable.class, new zzded(key) { // from class: com.google.android.gms.internal.ads.zzctk
                private final String zzcyz;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.zzcyz = key;
                }

                @Override // com.google.android.gms.internal.ads.zzded
                public final Object apply(Object obj) {
                    String valueOf = String.valueOf(this.zzcyz);
                    zzayu.zzex(valueOf.length() != 0 ? "Error calling adapter: ".concat(valueOf) : new String("Error calling adapter: "));
                    return null;
                }
            }, this.zzfov));
        }
        return zzdgs.zzi(arrayList).zza(new Callable(arrayList) { // from class: com.google.android.gms.internal.ads.zzctn
            private final List zzggn;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzggn = arrayList;
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.concurrent.Callable
            public final Object call() {
                List<zzdhe> list = this.zzggn;
                JSONArray jSONArray = new JSONArray();
                for (zzdhe zzdheVar : list) {
                    if (((JSONObject) zzdheVar.get()) != null) {
                        jSONArray.put(zzdheVar.get());
                    }
                }
                if (jSONArray.length() == 0) {
                    return null;
                }
                return new zzctg(jSONArray.toString());
            }
        }, this.zzfov);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ zzdhe a(String str, List list, Bundle bundle) {
        zzazl zzazlVar = new zzazl();
        this.zzgbe.zzgg(str);
        zzani zzgh = this.zzgbe.zzgh(str);
        if (zzgh == null) {
            throw new NullPointerException();
        }
        zzgh.zza(ObjectWrapper.wrap(this.zzup), this.zzgeb, bundle, (Bundle) list.get(0), this.zzfgl.zzblm, new zzcoh(str, zzgh, zzazlVar));
        return zzazlVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcub
    public final zzdhe<zzctg> zzanc() {
        return ((Boolean) zzve.zzoy().zzd(zzzn.zzckn)).booleanValue() ? zzdgs.zza(new zzdgd(this) { // from class: com.google.android.gms.internal.ads.zzcti
            private final zzctj zzggj;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzggj = this;
            }

            @Override // com.google.android.gms.internal.ads.zzdgd
            public final zzdhe zzanm() {
                return this.zzggj.a();
            }
        }, this.zzfov) : zzdgs.zzaj(null);
    }
}
