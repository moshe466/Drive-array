package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.View;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import javax.annotation.concurrent.GuardedBy;

/* loaded from: classes.dex */
public final class zzbst extends zzbrl<zzps> implements zzps {
    private final zzczl zzffc;

    @GuardedBy("this")
    private Map<View, zzpo> zzfiq;
    private final Context zzup;

    public zzbst(Context context, Set<zzbsu<zzps>> set, zzczl zzczlVar) {
        super(set);
        this.zzfiq = new WeakHashMap(1);
        this.zzup = context;
        this.zzffc = zzczlVar;
    }

    @Override // com.google.android.gms.internal.ads.zzps
    public final synchronized void zza(final zzpt zzptVar) {
        a(new zzbrn(zzptVar) { // from class: com.google.android.gms.internal.ads.zzbsw
            private final zzpt zzfis;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzfis = zzptVar;
            }

            @Override // com.google.android.gms.internal.ads.zzbrn
            public final void zzp(Object obj) {
                ((zzps) obj).zza(this.zzfis);
            }
        });
    }

    public final synchronized void zzq(View view) {
        zzpo zzpoVar = this.zzfiq.get(view);
        if (zzpoVar == null) {
            zzpoVar = new zzpo(this.zzup, view);
            zzpoVar.zza(this);
            this.zzfiq.put(view, zzpoVar);
        }
        if (this.zzffc != null && this.zzffc.zzdlm) {
            if (((Boolean) zzve.zzoy().zzd(zzzn.zzckj)).booleanValue()) {
                zzpoVar.zzen(((Long) zzve.zzoy().zzd(zzzn.zzcki)).longValue());
                return;
            }
        }
        zzpoVar.zzlp();
    }

    public final synchronized void zzr(View view) {
        if (this.zzfiq.containsKey(view)) {
            this.zzfiq.get(view).zzb(this);
            this.zzfiq.remove(view);
        }
    }
}
