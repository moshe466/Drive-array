package com.google.android.gms.internal.ads;

import android.net.Uri;
import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.dynamic.IObjectWrapper;

/* loaded from: classes.dex */
public final class zzack extends zzgc implements zzaci {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzack(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.formats.client.INativeAdImage");
    }

    @Override // com.google.android.gms.internal.ads.zzaci
    public final int getHeight() {
        Parcel a = a(5, c());
        int readInt = a.readInt();
        a.recycle();
        return readInt;
    }

    @Override // com.google.android.gms.internal.ads.zzaci
    public final double getScale() {
        Parcel a = a(3, c());
        double readDouble = a.readDouble();
        a.recycle();
        return readDouble;
    }

    @Override // com.google.android.gms.internal.ads.zzaci
    public final Uri getUri() {
        Parcel a = a(2, c());
        Uri uri = (Uri) zzge.zza(a, Uri.CREATOR);
        a.recycle();
        return uri;
    }

    @Override // com.google.android.gms.internal.ads.zzaci
    public final int getWidth() {
        Parcel a = a(4, c());
        int readInt = a.readInt();
        a.recycle();
        return readInt;
    }

    @Override // com.google.android.gms.internal.ads.zzaci
    public final IObjectWrapper zzrc() {
        Parcel a = a(1, c());
        IObjectWrapper asInterface = IObjectWrapper.Stub.asInterface(a.readStrongBinder());
        a.recycle();
        return asInterface;
    }
}
