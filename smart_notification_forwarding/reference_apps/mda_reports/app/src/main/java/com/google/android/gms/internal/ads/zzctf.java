package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import androidx.annotation.Nullable;

/* loaded from: classes.dex */
public final class zzctf implements zzcub<zzcty<Bundle>> {
    private final String zzfhg;
    private final Context zzup;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzctf(Context context, @Nullable String str) {
        this.zzup = context;
        this.zzfhg = str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void a(Bundle bundle) {
        bundle.putString("rewarded_sku_package", this.zzup.getPackageName());
    }

    @Override // com.google.android.gms.internal.ads.zzcub
    public final zzdhe<zzcty<Bundle>> zzanc() {
        return zzdgs.zzaj(this.zzfhg == null ? null : new zzcty(this) { // from class: com.google.android.gms.internal.ads.zzcte
            private final zzctf zzggh;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzggh = this;
            }

            @Override // com.google.android.gms.internal.ads.zzcty
            public final void zzr(Object obj) {
                this.zzggh.a((Bundle) obj);
            }
        });
    }
}
