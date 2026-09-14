package com.google.android.gms.internal.ads;

import java.util.Set;

/* loaded from: classes.dex */
public final class zzbte extends zzbrl<zzafx> implements zzafx {
    public zzbte(Set<zzbsu<zzafx>> set) {
        super(set);
    }

    @Override // com.google.android.gms.internal.ads.zzafx
    public final void zza(final zzasd zzasdVar) {
        a(new zzbrn(zzasdVar) { // from class: com.google.android.gms.internal.ads.zzbtg
            private final zzasd zzfiu;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzfiu = zzasdVar;
            }

            @Override // com.google.android.gms.internal.ads.zzbrn
            public final void zzp(Object obj) {
                ((zzafx) obj).zza(this.zzfiu);
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzafx
    public final synchronized void zzrs() {
        a(zzbtd.a);
    }

    @Override // com.google.android.gms.internal.ads.zzafx
    public final void zzrt() {
        a(zzbtf.a);
    }
}
