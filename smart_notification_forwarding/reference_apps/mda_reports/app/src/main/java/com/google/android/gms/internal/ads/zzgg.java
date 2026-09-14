package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.dynamic.IObjectWrapper;

/* loaded from: classes.dex */
public final class zzgg extends zzgc implements zzgf {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzgg(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.clearcut.IClearcut");
    }

    @Override // com.google.android.gms.internal.ads.zzgf
    public final void zza(IObjectWrapper iObjectWrapper, String str) {
        Parcel c = c();
        zzge.zza(c, iObjectWrapper);
        c.writeString(str);
        b(2, c);
    }

    @Override // com.google.android.gms.internal.ads.zzgf
    public final void zza(IObjectWrapper iObjectWrapper, String str, String str2) {
        Parcel c = c();
        zzge.zza(c, iObjectWrapper);
        c.writeString(str);
        c.writeString(null);
        b(8, c);
    }

    @Override // com.google.android.gms.internal.ads.zzgf
    public final void zza(int[] iArr) {
        Parcel c = c();
        c.writeIntArray(null);
        b(4, c);
    }

    @Override // com.google.android.gms.internal.ads.zzgf
    public final void zzc(byte[] bArr) {
        Parcel c = c();
        c.writeByteArray(bArr);
        b(5, c);
    }

    @Override // com.google.android.gms.internal.ads.zzgf
    public final void zzdn() {
        b(3, c());
    }

    @Override // com.google.android.gms.internal.ads.zzgf
    public final void zzm(int i) {
        Parcel c = c();
        c.writeInt(i);
        b(6, c);
    }

    @Override // com.google.android.gms.internal.ads.zzgf
    public final void zzn(int i) {
        Parcel c = c();
        c.writeInt(i);
        b(7, c);
    }
}
