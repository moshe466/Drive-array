package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public final class zzadg extends zzgc implements zzade {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzadg(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.formats.client.INativeCustomTemplateAd");
    }

    @Override // com.google.android.gms.internal.ads.zzade
    public final void destroy() {
        b(8, c());
    }

    @Override // com.google.android.gms.internal.ads.zzade
    public final List<String> getAvailableAssetNames() {
        Parcel a = a(3, c());
        ArrayList<String> createStringArrayList = a.createStringArrayList();
        a.recycle();
        return createStringArrayList;
    }

    @Override // com.google.android.gms.internal.ads.zzade
    public final String getCustomTemplateId() {
        Parcel a = a(4, c());
        String readString = a.readString();
        a.recycle();
        return readString;
    }

    @Override // com.google.android.gms.internal.ads.zzade
    public final zzxb getVideoController() {
        Parcel a = a(7, c());
        zzxb zzj = zzxe.zzj(a.readStrongBinder());
        a.recycle();
        return zzj;
    }

    @Override // com.google.android.gms.internal.ads.zzade
    public final void performClick(String str) {
        Parcel c = c();
        c.writeString(str);
        b(5, c);
    }

    @Override // com.google.android.gms.internal.ads.zzade
    public final void recordImpression() {
        b(6, c());
    }

    @Override // com.google.android.gms.internal.ads.zzade
    public final String zzct(String str) {
        Parcel c = c();
        c.writeString(str);
        Parcel a = a(1, c);
        String readString = a.readString();
        a.recycle();
        return readString;
    }

    @Override // com.google.android.gms.internal.ads.zzade
    public final zzaci zzcu(String str) {
        zzaci zzackVar;
        Parcel c = c();
        c.writeString(str);
        Parcel a = a(2, c);
        IBinder readStrongBinder = a.readStrongBinder();
        if (readStrongBinder == null) {
            zzackVar = null;
        } else {
            IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.INativeAdImage");
            zzackVar = queryLocalInterface instanceof zzaci ? (zzaci) queryLocalInterface : new zzack(readStrongBinder);
        }
        a.recycle();
        return zzackVar;
    }

    @Override // com.google.android.gms.internal.ads.zzade
    public final boolean zzp(IObjectWrapper iObjectWrapper) {
        Parcel c = c();
        zzge.zza(c, iObjectWrapper);
        Parcel a = a(10, c);
        boolean zza = zzge.zza(a);
        a.recycle();
        return zza;
    }

    @Override // com.google.android.gms.internal.ads.zzade
    public final void zzq(IObjectWrapper iObjectWrapper) {
        Parcel c = c();
        zzge.zza(c, iObjectWrapper);
        b(14, c);
    }

    @Override // com.google.android.gms.internal.ads.zzade
    public final IObjectWrapper zzrf() {
        Parcel a = a(11, c());
        IObjectWrapper asInterface = IObjectWrapper.Stub.asInterface(a.readStrongBinder());
        a.recycle();
        return asInterface;
    }

    @Override // com.google.android.gms.internal.ads.zzade
    public final IObjectWrapper zzrk() {
        Parcel a = a(9, c());
        IObjectWrapper asInterface = IObjectWrapper.Stub.asInterface(a.readStrongBinder());
        a.recycle();
        return asInterface;
    }

    @Override // com.google.android.gms.internal.ads.zzade
    public final boolean zzrl() {
        Parcel a = a(12, c());
        boolean zza = zzge.zza(a);
        a.recycle();
        return zza;
    }

    @Override // com.google.android.gms.internal.ads.zzade
    public final boolean zzrm() {
        Parcel a = a(13, c());
        boolean zza = zzge.zza(a);
        a.recycle();
        return zza;
    }

    @Override // com.google.android.gms.internal.ads.zzade
    public final void zzrn() {
        b(15, c());
    }
}
