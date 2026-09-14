package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.Set;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public final class zzbpg extends zzbrl<zzbph> {
    public zzbpg(Set<zzbsu<zzbph>> set) {
        super(set);
    }

    public final void zza(zzbtk zzbtkVar, Executor executor) {
        zza(zzbsu.zzb(new zzbpk(this, zzbtkVar), executor));
    }

    public final void zzbv(final Context context) {
        a(new zzbrn(context) { // from class: com.google.android.gms.internal.ads.zzbpj
            private final Context zzcri;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzcri = context;
            }

            @Override // com.google.android.gms.internal.ads.zzbrn
            public final void zzp(Object obj) {
                ((zzbph) obj).zzbv(this.zzcri);
            }
        });
    }

    public final void zzbw(final Context context) {
        a(new zzbrn(context) { // from class: com.google.android.gms.internal.ads.zzbpi
            private final Context zzcri;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzcri = context;
            }

            @Override // com.google.android.gms.internal.ads.zzbrn
            public final void zzp(Object obj) {
                ((zzbph) obj).zzbw(this.zzcri);
            }
        });
    }

    public final void zzbx(final Context context) {
        a(new zzbrn(context) { // from class: com.google.android.gms.internal.ads.zzbpl
            private final Context zzcri;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzcri = context;
            }

            @Override // com.google.android.gms.internal.ads.zzbrn
            public final void zzp(Object obj) {
                ((zzbph) obj).zzbx(this.zzcri);
            }
        });
    }
}
