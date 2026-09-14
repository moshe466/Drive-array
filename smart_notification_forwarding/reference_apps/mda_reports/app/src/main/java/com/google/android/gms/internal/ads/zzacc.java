package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public final class zzacc extends zzgc implements zzaca {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzacc(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.formats.client.IAttributionInfo");
    }

    @Override // com.google.android.gms.internal.ads.zzaca
    public final String getText() {
        Parcel a = a(2, c());
        String readString = a.readString();
        a.recycle();
        return readString;
    }

    @Override // com.google.android.gms.internal.ads.zzaca
    public final List<zzaci> zzqx() {
        Parcel a = a(3, c());
        ArrayList zzb = zzge.zzb(a);
        a.recycle();
        return zzb;
    }
}
