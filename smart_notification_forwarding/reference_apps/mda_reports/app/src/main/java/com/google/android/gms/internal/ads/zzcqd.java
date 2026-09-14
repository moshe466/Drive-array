package com.google.android.gms.internal.ads;

import android.os.Bundle;

/* loaded from: classes.dex */
final /* synthetic */ class zzcqd implements zzdgf {
    static final zzdgf a = new zzcqd();

    private zzcqd() {
    }

    @Override // com.google.android.gms.internal.ads.zzdgf
    public final zzdhe zzf(Object obj) {
        final String str = (String) obj;
        return zzdgs.zzaj(new zzcty(str) { // from class: com.google.android.gms.internal.ads.zzcqc
            private final String zzcyz;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzcyz = str;
            }

            @Override // com.google.android.gms.internal.ads.zzcty
            public final void zzr(Object obj2) {
                ((Bundle) obj2).putString("ms", this.zzcyz);
            }
        });
    }
}
