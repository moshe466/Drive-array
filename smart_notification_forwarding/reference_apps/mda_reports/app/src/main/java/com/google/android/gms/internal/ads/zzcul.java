package com.google.android.gms.internal.ads;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.telephony.TelephonyManager;
import java.util.concurrent.Callable;

/* loaded from: classes.dex */
public final class zzcul implements zzcub<zzcui> {
    private final zzdhd zzfov;
    private final Context zzup;

    public zzcul(zzdhd zzdhdVar, Context context) {
        this.zzfov = zzdhdVar;
        this.zzup = context;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ zzcui a() {
        int i;
        boolean z;
        int i2;
        int i3;
        TelephonyManager telephonyManager = (TelephonyManager) this.zzup.getSystemService("phone");
        String networkOperator = telephonyManager.getNetworkOperator();
        int networkType = telephonyManager.getNetworkType();
        int phoneType = telephonyManager.getPhoneType();
        com.google.android.gms.ads.internal.zzq.zzkq();
        int i4 = -1;
        if (zzawb.zzq(this.zzup, "android.permission.ACCESS_NETWORK_STATE")) {
            ConnectivityManager connectivityManager = (ConnectivityManager) this.zzup.getSystemService("connectivity");
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            if (activeNetworkInfo != null) {
                int type = activeNetworkInfo.getType();
                int ordinal = activeNetworkInfo.getDetailedState().ordinal();
                i3 = type;
                i4 = ordinal;
            } else {
                i3 = -1;
            }
            if (Build.VERSION.SDK_INT >= 16) {
                i2 = i4;
                i = i3;
                z = connectivityManager.isActiveNetworkMetered();
            } else {
                i2 = i4;
                i = i3;
                z = false;
            }
        } else {
            i = -2;
            z = false;
            i2 = -1;
        }
        return new zzcui(networkOperator, i, networkType, phoneType, z, i2);
    }

    @Override // com.google.android.gms.internal.ads.zzcub
    public final zzdhe<zzcui> zzanc() {
        return this.zzfov.submit(new Callable(this) { // from class: com.google.android.gms.internal.ads.zzcuk
            private final zzcul zzghi;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzghi = this;
            }

            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.zzghi.a();
            }
        });
    }
}
