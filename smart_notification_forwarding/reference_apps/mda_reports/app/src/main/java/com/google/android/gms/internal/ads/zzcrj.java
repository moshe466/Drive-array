package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.concurrent.Callable;

/* loaded from: classes.dex */
public final class zzcrj implements zzcub<zzcrg> {
    private final zzdhd zzfov;
    private final Context zzup;

    public zzcrj(zzdhd zzdhdVar, Context context) {
        this.zzfov = zzdhdVar;
        this.zzup = context;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ zzcrg a() {
        double d;
        Intent registerReceiver = this.zzup.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        boolean z = false;
        if (registerReceiver != null) {
            int intExtra = registerReceiver.getIntExtra("status", -1);
            double intExtra2 = registerReceiver.getIntExtra(FirebaseAnalytics.Param.LEVEL, -1);
            double intExtra3 = registerReceiver.getIntExtra("scale", -1);
            Double.isNaN(intExtra2);
            Double.isNaN(intExtra3);
            d = intExtra2 / intExtra3;
            if (intExtra == 2 || intExtra == 5) {
                z = true;
            }
        } else {
            d = -1.0d;
        }
        return new zzcrg(d, z);
    }

    @Override // com.google.android.gms.internal.ads.zzcub
    public final zzdhe<zzcrg> zzanc() {
        return this.zzfov.submit(new Callable(this) { // from class: com.google.android.gms.internal.ads.zzcri
            private final zzcrj zzgfl;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzgfl = this;
            }

            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.zzgfl.a();
            }
        });
    }
}
