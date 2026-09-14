package com.google.android.gms.internal.ads;

import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.dynamic.IObjectWrapper;

/* loaded from: classes.dex */
public final class zzaov extends zzgc implements zzaot {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzaov(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.overlay.client.IAdOverlay");
    }

    @Override // com.google.android.gms.internal.ads.zzaot
    public final void onActivityResult(int i, int i2, Intent intent) {
        Parcel c = c();
        c.writeInt(i);
        c.writeInt(i2);
        zzge.zza(c, intent);
        b(12, c);
    }

    @Override // com.google.android.gms.internal.ads.zzaot
    public final void onBackPressed() {
        b(10, c());
    }

    @Override // com.google.android.gms.internal.ads.zzaot
    public final void onCreate(Bundle bundle) {
        Parcel c = c();
        zzge.zza(c, bundle);
        b(1, c);
    }

    @Override // com.google.android.gms.internal.ads.zzaot
    public final void onDestroy() {
        b(8, c());
    }

    @Override // com.google.android.gms.internal.ads.zzaot
    public final void onPause() {
        b(5, c());
    }

    @Override // com.google.android.gms.internal.ads.zzaot
    public final void onRestart() {
        b(2, c());
    }

    @Override // com.google.android.gms.internal.ads.zzaot
    public final void onResume() {
        b(4, c());
    }

    @Override // com.google.android.gms.internal.ads.zzaot
    public final void onSaveInstanceState(Bundle bundle) {
        Parcel c = c();
        zzge.zza(c, bundle);
        Parcel a = a(6, c);
        if (a.readInt() != 0) {
            bundle.readFromParcel(a);
        }
        a.recycle();
    }

    @Override // com.google.android.gms.internal.ads.zzaot
    public final void onStart() {
        b(3, c());
    }

    @Override // com.google.android.gms.internal.ads.zzaot
    public final void onStop() {
        b(7, c());
    }

    @Override // com.google.android.gms.internal.ads.zzaot
    public final void zzad(IObjectWrapper iObjectWrapper) {
        Parcel c = c();
        zzge.zza(c, iObjectWrapper);
        b(13, c);
    }

    @Override // com.google.android.gms.internal.ads.zzaot
    public final void zzdf() {
        b(9, c());
    }

    @Override // com.google.android.gms.internal.ads.zzaot
    public final boolean zztm() {
        Parcel a = a(11, c());
        boolean zza = zzge.zza(a);
        a.recycle();
        return zza;
    }
}
