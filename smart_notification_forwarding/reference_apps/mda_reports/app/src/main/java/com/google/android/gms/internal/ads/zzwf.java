package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.dynamic.IObjectWrapper;

/* loaded from: classes.dex */
public final class zzwf extends zzgc implements zzwd {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzwf(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.client.IClientApi");
    }

    @Override // com.google.android.gms.internal.ads.zzwd
    public final zzacm zza(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2) {
        Parcel c = c();
        zzge.zza(c, iObjectWrapper);
        zzge.zza(c, iObjectWrapper2);
        Parcel a = a(5, c);
        zzacm zzn = zzacl.zzn(a.readStrongBinder());
        a.recycle();
        return zzn;
    }

    @Override // com.google.android.gms.internal.ads.zzwd
    public final zzacp zza(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2, IObjectWrapper iObjectWrapper3) {
        Parcel c = c();
        zzge.zza(c, iObjectWrapper);
        zzge.zza(c, iObjectWrapper2);
        zzge.zza(c, iObjectWrapper3);
        Parcel a = a(11, c);
        zzacp zzo = zzacs.zzo(a.readStrongBinder());
        a.recycle();
        return zzo;
    }

    @Override // com.google.android.gms.internal.ads.zzwd
    public final zzarl zza(IObjectWrapper iObjectWrapper, zzalc zzalcVar, int i) {
        Parcel c = c();
        zzge.zza(c, iObjectWrapper);
        zzge.zza(c, zzalcVar);
        c.writeInt(i);
        Parcel a = a(6, c);
        zzarl zzai = zzark.zzai(a.readStrongBinder());
        a.recycle();
        return zzai;
    }

    @Override // com.google.android.gms.internal.ads.zzwd
    public final zzvn zza(IObjectWrapper iObjectWrapper, String str, zzalc zzalcVar, int i) {
        zzvn zzvpVar;
        Parcel c = c();
        zzge.zza(c, iObjectWrapper);
        c.writeString(str);
        zzge.zza(c, zzalcVar);
        c.writeInt(i);
        Parcel a = a(3, c);
        IBinder readStrongBinder = a.readStrongBinder();
        if (readStrongBinder == null) {
            zzvpVar = null;
        } else {
            IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdLoaderBuilder");
            zzvpVar = queryLocalInterface instanceof zzvn ? (zzvn) queryLocalInterface : new zzvp(readStrongBinder);
        }
        a.recycle();
        return zzvpVar;
    }

    @Override // com.google.android.gms.internal.ads.zzwd
    public final zzvu zza(IObjectWrapper iObjectWrapper, zzuj zzujVar, String str, int i) {
        zzvu zzvwVar;
        Parcel c = c();
        zzge.zza(c, iObjectWrapper);
        zzge.zza(c, zzujVar);
        c.writeString(str);
        c.writeInt(i);
        Parcel a = a(10, c);
        IBinder readStrongBinder = a.readStrongBinder();
        if (readStrongBinder == null) {
            zzvwVar = null;
        } else {
            IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdManager");
            zzvwVar = queryLocalInterface instanceof zzvu ? (zzvu) queryLocalInterface : new zzvw(readStrongBinder);
        }
        a.recycle();
        return zzvwVar;
    }

    @Override // com.google.android.gms.internal.ads.zzwd
    public final zzvu zza(IObjectWrapper iObjectWrapper, zzuj zzujVar, String str, zzalc zzalcVar, int i) {
        zzvu zzvwVar;
        Parcel c = c();
        zzge.zza(c, iObjectWrapper);
        zzge.zza(c, zzujVar);
        c.writeString(str);
        zzge.zza(c, zzalcVar);
        c.writeInt(i);
        Parcel a = a(1, c);
        IBinder readStrongBinder = a.readStrongBinder();
        if (readStrongBinder == null) {
            zzvwVar = null;
        } else {
            IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdManager");
            zzvwVar = queryLocalInterface instanceof zzvu ? (zzvu) queryLocalInterface : new zzvw(readStrongBinder);
        }
        a.recycle();
        return zzvwVar;
    }

    @Override // com.google.android.gms.internal.ads.zzwd
    public final zzwk zza(IObjectWrapper iObjectWrapper, int i) {
        zzwk zzwmVar;
        Parcel c = c();
        zzge.zza(c, iObjectWrapper);
        c.writeInt(i);
        Parcel a = a(9, c);
        IBinder readStrongBinder = a.readStrongBinder();
        if (readStrongBinder == null) {
            zzwmVar = null;
        } else {
            IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IMobileAdsSettingManager");
            zzwmVar = queryLocalInterface instanceof zzwk ? (zzwk) queryLocalInterface : new zzwm(readStrongBinder);
        }
        a.recycle();
        return zzwmVar;
    }

    @Override // com.google.android.gms.internal.ads.zzwd
    public final zzaot zzb(IObjectWrapper iObjectWrapper) {
        Parcel c = c();
        zzge.zza(c, iObjectWrapper);
        Parcel a = a(8, c);
        zzaot zzae = zzaos.zzae(a.readStrongBinder());
        a.recycle();
        return zzae;
    }

    @Override // com.google.android.gms.internal.ads.zzwd
    public final zzasg zzb(IObjectWrapper iObjectWrapper, String str, zzalc zzalcVar, int i) {
        Parcel c = c();
        zzge.zza(c, iObjectWrapper);
        c.writeString(str);
        zzge.zza(c, zzalcVar);
        c.writeInt(i);
        Parcel a = a(12, c);
        zzasg zzam = zzasj.zzam(a.readStrongBinder());
        a.recycle();
        return zzam;
    }

    @Override // com.google.android.gms.internal.ads.zzwd
    public final zzvu zzb(IObjectWrapper iObjectWrapper, zzuj zzujVar, String str, zzalc zzalcVar, int i) {
        zzvu zzvwVar;
        Parcel c = c();
        zzge.zza(c, iObjectWrapper);
        zzge.zza(c, zzujVar);
        c.writeString(str);
        zzge.zza(c, zzalcVar);
        c.writeInt(i);
        Parcel a = a(2, c);
        IBinder readStrongBinder = a.readStrongBinder();
        if (readStrongBinder == null) {
            zzvwVar = null;
        } else {
            IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdManager");
            zzvwVar = queryLocalInterface instanceof zzvu ? (zzvu) queryLocalInterface : new zzvw(readStrongBinder);
        }
        a.recycle();
        return zzvwVar;
    }

    @Override // com.google.android.gms.internal.ads.zzwd
    public final zzvu zzc(IObjectWrapper iObjectWrapper, zzuj zzujVar, String str, zzalc zzalcVar, int i) {
        zzvu zzvwVar;
        Parcel c = c();
        zzge.zza(c, iObjectWrapper);
        zzge.zza(c, zzujVar);
        c.writeString(str);
        zzge.zza(c, zzalcVar);
        c.writeInt(i);
        Parcel a = a(13, c);
        IBinder readStrongBinder = a.readStrongBinder();
        if (readStrongBinder == null) {
            zzvwVar = null;
        } else {
            IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdManager");
            zzvwVar = queryLocalInterface instanceof zzvu ? (zzvu) queryLocalInterface : new zzvw(readStrongBinder);
        }
        a.recycle();
        return zzvwVar;
    }

    @Override // com.google.android.gms.internal.ads.zzwd
    public final zzwk zzc(IObjectWrapper iObjectWrapper) {
        zzwk zzwmVar;
        Parcel c = c();
        zzge.zza(c, iObjectWrapper);
        Parcel a = a(4, c);
        IBinder readStrongBinder = a.readStrongBinder();
        if (readStrongBinder == null) {
            zzwmVar = null;
        } else {
            IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IMobileAdsSettingManager");
            zzwmVar = queryLocalInterface instanceof zzwk ? (zzwk) queryLocalInterface : new zzwm(readStrongBinder);
        }
        a.recycle();
        return zzwmVar;
    }

    @Override // com.google.android.gms.internal.ads.zzwd
    public final zzapd zzd(IObjectWrapper iObjectWrapper) {
        Parcel c = c();
        zzge.zza(c, iObjectWrapper);
        Parcel a = a(7, c);
        zzapd zzag = zzapc.zzag(a.readStrongBinder());
        a.recycle();
        return zzag;
    }
}
