package com.google.android.gms.internal.ads;

import java.util.Set;

/* loaded from: classes.dex */
public final class zzbou extends zzbrl<zzbow> implements zzbow {
    public zzbou(Set<zzbsu<zzbow>> set) {
        super(set);
    }

    @Override // com.google.android.gms.internal.ads.zzbow
    public final void onAdFailedToLoad(final int i) {
        a(new zzbrn(i) { // from class: com.google.android.gms.internal.ads.zzbox
            private final int zzdvv;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzdvv = i;
            }

            @Override // com.google.android.gms.internal.ads.zzbrn
            public final void zzp(Object obj) {
                ((zzbow) obj).onAdFailedToLoad(this.zzdvv);
            }
        });
    }
}
