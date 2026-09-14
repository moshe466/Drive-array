package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import java.util.concurrent.Callable;

/* loaded from: classes.dex */
public final class zzcrx implements zzcub<zzcru> {
    private final zzdhd zzfov;
    private final Context zzup;

    public zzcrx(Context context, zzdhd zzdhdVar) {
        this.zzup = context;
        this.zzfov = zzdhdVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcub
    public final zzdhe<zzcru> zzanc() {
        return this.zzfov.submit(new Callable(this) { // from class: com.google.android.gms.internal.ads.zzcrw
            private final zzcrx zzgfw;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzgfw = this;
            }

            @Override // java.util.concurrent.Callable
            public final Object call() {
                String zzvv;
                String zzvx;
                String str;
                com.google.android.gms.ads.internal.zzq.zzkq();
                zzqi zzvt = com.google.android.gms.ads.internal.zzq.zzku().zzvf().zzvt();
                Bundle bundle = null;
                if (zzvt != null && zzvt != null && (!com.google.android.gms.ads.internal.zzq.zzku().zzvf().zzvu() || !com.google.android.gms.ads.internal.zzq.zzku().zzvf().zzvw())) {
                    if (zzvt.zzmf()) {
                        zzvt.wakeup();
                    }
                    zzqc zzmd = zzvt.zzmd();
                    if (zzmd != null) {
                        zzvv = zzmd.zzls();
                        str = zzmd.zzlt();
                        zzvx = zzmd.zzlu();
                        if (zzvv != null) {
                            com.google.android.gms.ads.internal.zzq.zzku().zzvf().zzee(zzvv);
                        }
                        if (zzvx != null) {
                            com.google.android.gms.ads.internal.zzq.zzku().zzvf().zzef(zzvx);
                        }
                    } else {
                        zzvv = com.google.android.gms.ads.internal.zzq.zzku().zzvf().zzvv();
                        zzvx = com.google.android.gms.ads.internal.zzq.zzku().zzvf().zzvx();
                        str = null;
                    }
                    Bundle bundle2 = new Bundle(1);
                    if (!com.google.android.gms.ads.internal.zzq.zzku().zzvf().zzvw()) {
                        if (zzvx == null || TextUtils.isEmpty(zzvx)) {
                            zzvx = "no_hash";
                        }
                        bundle2.putString("v_fp_vertical", zzvx);
                    }
                    if (zzvv != null && !com.google.android.gms.ads.internal.zzq.zzku().zzvf().zzvu()) {
                        bundle2.putString("fingerprint", zzvv);
                        if (!zzvv.equals(str)) {
                            bundle2.putString("v_fp", str);
                        }
                    }
                    if (!bundle2.isEmpty()) {
                        bundle = bundle2;
                    }
                }
                return new zzcru(bundle);
            }
        });
    }
}
