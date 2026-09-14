package com.google.android.gms.internal.ads;

import android.net.Uri;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.dynamic.IObjectWrapper;

/* loaded from: classes.dex */
public abstract class zzach extends zzgb implements zzaci {
    public zzach() {
        super("com.google.android.gms.ads.internal.formats.client.INativeAdImage");
    }

    public static zzaci zzm(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.INativeAdImage");
        return queryLocalInterface instanceof zzaci ? (zzaci) queryLocalInterface : new zzack(iBinder);
    }

    @Override // com.google.android.gms.internal.ads.zzgb
    protected final boolean a(int i, Parcel parcel, Parcel parcel2, int i2) {
        int width;
        if (i == 1) {
            IObjectWrapper zzrc = zzrc();
            parcel2.writeNoException();
            zzge.zza(parcel2, zzrc);
        } else if (i == 2) {
            Uri uri = getUri();
            parcel2.writeNoException();
            zzge.zzb(parcel2, uri);
        } else if (i != 3) {
            if (i == 4) {
                width = getWidth();
            } else {
                if (i != 5) {
                    return false;
                }
                width = getHeight();
            }
            parcel2.writeNoException();
            parcel2.writeInt(width);
        } else {
            double scale = getScale();
            parcel2.writeNoException();
            parcel2.writeDouble(scale);
        }
        return true;
    }
}
