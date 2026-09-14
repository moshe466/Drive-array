package com.google.android.gms.internal.ads;

import java.util.Set;

/* loaded from: classes.dex */
public final class zzboz extends zzbrl<zzbpa> implements zzbpa {
    public zzboz(Set<zzbsu<zzbpa>> set) {
        super(set);
    }

    @Override // com.google.android.gms.internal.ads.zzbpa
    public final void zzco(final int i) {
        a(new zzbrn(i) { // from class: com.google.android.gms.internal.ads.zzboy
            private final int zzdvv;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzdvv = i;
            }

            @Override // com.google.android.gms.internal.ads.zzbrn
            public final void zzp(Object obj) {
                ((zzbpa) obj).zzco(this.zzdvv);
            }
        });
    }
}
