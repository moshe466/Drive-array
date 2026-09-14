package com.google.android.gms.internal.ads;

import android.os.Bundle;
import androidx.annotation.Nullable;
import java.util.concurrent.Callable;

/* loaded from: classes.dex */
public final class zzcta implements zzcub<zzctb> {
    private final Bundle zzfhf;
    private final zzdhd zzfov;

    public zzcta(zzdhd zzdhdVar, @Nullable Bundle bundle) {
        this.zzfov = zzdhdVar;
        this.zzfhf = bundle;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ zzctb a() {
        return new zzctb(this.zzfhf);
    }

    @Override // com.google.android.gms.internal.ads.zzcub
    public final zzdhe<zzctb> zzanc() {
        return this.zzfov.submit(new Callable(this) { // from class: com.google.android.gms.internal.ads.zzctd
            private final zzcta zzggg;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzggg = this;
            }

            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.zzggg.a();
            }
        });
    }
}
