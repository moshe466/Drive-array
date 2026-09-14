package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public final class zzwm extends zzgc implements zzwk {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzwm(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.client.IMobileAdsSettingManager");
    }

    @Override // com.google.android.gms.internal.ads.zzwk
    public final String getVersionString() {
        Parcel a = a(9, c());
        String readString = a.readString();
        a.recycle();
        return readString;
    }

    @Override // com.google.android.gms.internal.ads.zzwk
    public final void initialize() {
        b(1, c());
    }

    @Override // com.google.android.gms.internal.ads.zzwk
    public final void setAppMuted(boolean z) {
        Parcel c = c();
        zzge.writeBoolean(c, z);
        b(4, c);
    }

    @Override // com.google.android.gms.internal.ads.zzwk
    public final void setAppVolume(float f) {
        Parcel c = c();
        c.writeFloat(f);
        b(2, c);
    }

    @Override // com.google.android.gms.internal.ads.zzwk
    public final void zza(zzagu zzaguVar) {
        Parcel c = c();
        zzge.zza(c, zzaguVar);
        b(12, c);
    }

    @Override // com.google.android.gms.internal.ads.zzwk
    public final void zza(zzalc zzalcVar) {
        Parcel c = c();
        zzge.zza(c, zzalcVar);
        b(11, c);
    }

    @Override // com.google.android.gms.internal.ads.zzwk
    public final void zza(zzyq zzyqVar) {
        Parcel c = c();
        zzge.zza(c, zzyqVar);
        b(14, c);
    }

    @Override // com.google.android.gms.internal.ads.zzwk
    public final void zza(String str, IObjectWrapper iObjectWrapper) {
        Parcel c = c();
        c.writeString(str);
        zzge.zza(c, iObjectWrapper);
        b(6, c);
    }

    @Override // com.google.android.gms.internal.ads.zzwk
    public final void zzb(IObjectWrapper iObjectWrapper, String str) {
        Parcel c = c();
        zzge.zza(c, iObjectWrapper);
        c.writeString(str);
        b(5, c);
    }

    @Override // com.google.android.gms.internal.ads.zzwk
    public final void zzcd(String str) {
        Parcel c = c();
        c.writeString(str);
        b(3, c);
    }

    @Override // com.google.android.gms.internal.ads.zzwk
    public final void zzce(String str) {
        Parcel c = c();
        c.writeString(str);
        b(10, c);
    }

    @Override // com.google.android.gms.internal.ads.zzwk
    public final float zzpe() {
        Parcel a = a(7, c());
        float readFloat = a.readFloat();
        a.recycle();
        return readFloat;
    }

    @Override // com.google.android.gms.internal.ads.zzwk
    public final boolean zzpf() {
        Parcel a = a(8, c());
        boolean zza = zzge.zza(a);
        a.recycle();
        return zza;
    }

    @Override // com.google.android.gms.internal.ads.zzwk
    public final List<zzagn> zzpg() {
        Parcel a = a(13, c());
        ArrayList createTypedArrayList = a.createTypedArrayList(zzagn.CREATOR);
        a.recycle();
        return createTypedArrayList;
    }
}
