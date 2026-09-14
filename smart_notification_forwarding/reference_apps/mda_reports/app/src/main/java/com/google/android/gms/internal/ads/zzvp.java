package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.ads.formats.PublisherAdViewOptions;

/* loaded from: classes.dex */
public final class zzvp extends zzgc implements zzvn {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzvp(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.client.IAdLoaderBuilder");
    }

    @Override // com.google.android.gms.internal.ads.zzvn
    public final void zza(PublisherAdViewOptions publisherAdViewOptions) {
        Parcel c = c();
        zzge.zza(c, publisherAdViewOptions);
        b(9, c);
    }

    @Override // com.google.android.gms.internal.ads.zzvn
    public final void zza(zzaby zzabyVar) {
        Parcel c = c();
        zzge.zza(c, zzabyVar);
        b(6, c);
    }

    @Override // com.google.android.gms.internal.ads.zzvn
    public final void zza(zzadi zzadiVar) {
        Parcel c = c();
        zzge.zza(c, zzadiVar);
        b(3, c);
    }

    @Override // com.google.android.gms.internal.ads.zzvn
    public final void zza(zzadj zzadjVar) {
        Parcel c = c();
        zzge.zza(c, zzadjVar);
        b(4, c);
    }

    @Override // com.google.android.gms.internal.ads.zzvn
    public final void zza(zzadu zzaduVar, zzuj zzujVar) {
        Parcel c = c();
        zzge.zza(c, zzaduVar);
        zzge.zza(c, zzujVar);
        b(8, c);
    }

    @Override // com.google.android.gms.internal.ads.zzvn
    public final void zza(zzadv zzadvVar) {
        Parcel c = c();
        zzge.zza(c, zzadvVar);
        b(10, c);
    }

    @Override // com.google.android.gms.internal.ads.zzvn
    public final void zza(zzagz zzagzVar) {
        Parcel c = c();
        zzge.zza(c, zzagzVar);
        b(13, c);
    }

    @Override // com.google.android.gms.internal.ads.zzvn
    public final void zza(zzahh zzahhVar) {
        Parcel c = c();
        zzge.zza(c, zzahhVar);
        b(14, c);
    }

    @Override // com.google.android.gms.internal.ads.zzvn
    public final void zza(String str, zzadp zzadpVar, zzado zzadoVar) {
        Parcel c = c();
        c.writeString(str);
        zzge.zza(c, zzadpVar);
        zzge.zza(c, zzadoVar);
        b(5, c);
    }

    @Override // com.google.android.gms.internal.ads.zzvn
    public final void zzb(zzvh zzvhVar) {
        Parcel c = c();
        zzge.zza(c, zzvhVar);
        b(2, c);
    }

    @Override // com.google.android.gms.internal.ads.zzvn
    public final void zzb(zzwi zzwiVar) {
        Parcel c = c();
        zzge.zza(c, zzwiVar);
        b(7, c);
    }

    @Override // com.google.android.gms.internal.ads.zzvn
    public final zzvm zzpd() {
        zzvm zzvoVar;
        Parcel a = a(1, c());
        IBinder readStrongBinder = a.readStrongBinder();
        if (readStrongBinder == null) {
            zzvoVar = null;
        } else {
            IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdLoader");
            zzvoVar = queryLocalInterface instanceof zzvm ? (zzvm) queryLocalInterface : new zzvo(readStrongBinder);
        }
        a.recycle();
        return zzvoVar;
    }
}
