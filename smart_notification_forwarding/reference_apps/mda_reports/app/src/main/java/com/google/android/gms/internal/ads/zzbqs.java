package com.google.android.gms.internal.ads;

import java.util.Set;

/* loaded from: classes.dex */
public final class zzbqs extends zzbrl<zzbqx> implements zzbqx {
    public zzbqs(Set<zzbsu<zzbqx>> set) {
        super(set);
    }

    @Override // com.google.android.gms.internal.ads.zzbqx
    public final void zzb(final zzaqk zzaqkVar) {
        a(new zzbrn(zzaqkVar) { // from class: com.google.android.gms.internal.ads.zzbqv
            private final zzaqk zzfhx;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzfhx = zzaqkVar;
            }

            @Override // com.google.android.gms.internal.ads.zzbrn
            public final void zzp(Object obj) {
                ((zzbqx) obj).zzb(this.zzfhx);
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzbqx
    public final void zzb(final zzczt zzcztVar) {
        a(new zzbrn(zzcztVar) { // from class: com.google.android.gms.internal.ads.zzbqu
            private final zzczt zzfhw;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzfhw = zzcztVar;
            }

            @Override // com.google.android.gms.internal.ads.zzbrn
            public final void zzp(Object obj) {
                ((zzbqx) obj).zzb(this.zzfhw);
            }
        });
    }
}
