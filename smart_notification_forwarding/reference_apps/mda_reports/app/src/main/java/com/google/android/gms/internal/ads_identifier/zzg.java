package com.google.android.gms.internal.ads_identifier;

import android.os.IBinder;
import android.os.Parcel;
import io.fabric.sdk.android.services.common.AdvertisingInfoServiceStrategy;

/* loaded from: classes.dex */
public final class zzg extends zza implements zze {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzg(IBinder iBinder) {
        super(iBinder, AdvertisingInfoServiceStrategy.AdvertisingInterface.ADVERTISING_ID_SERVICE_INTERFACE_TOKEN);
    }

    @Override // com.google.android.gms.internal.ads_identifier.zze
    public final String getId() {
        Parcel a = a(1, c());
        String readString = a.readString();
        a.recycle();
        return readString;
    }

    @Override // com.google.android.gms.internal.ads_identifier.zze
    public final boolean zzb(boolean z) {
        Parcel c = c();
        zzc.zza(c, true);
        Parcel a = a(2, c);
        boolean zza = zzc.zza(a);
        a.recycle();
        return zza;
    }

    @Override // com.google.android.gms.internal.ads_identifier.zze
    public final boolean zzc() {
        Parcel a = a(6, c());
        boolean zza = zzc.zza(a);
        a.recycle();
        return zza;
    }
}
