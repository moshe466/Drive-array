package com.google.android.gms.internal.ads;

import android.content.Context;
import androidx.exifinterface.media.ExifInterface;
import com.google.android.gms.internal.ads.zzbs;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes.dex */
public final class zzey extends zzfw {
    private static zzfv<String> zzzp = new zzfv<>();
    private final Context zzzn;

    public zzey(zzei zzeiVar, String str, String str2, zzbs.zza.zzb zzbVar, int i, int i2, Context context) {
        super(zzeiVar, str, str2, zzbVar, i, 29);
        this.zzzn = context;
    }

    @Override // com.google.android.gms.internal.ads.zzfw
    protected final void a() {
        this.b.zzai(ExifInterface.LONGITUDE_EAST);
        AtomicReference<String> zzav = zzzp.zzav(this.zzzn.getPackageName());
        if (zzav.get() == null) {
            synchronized (zzav) {
                if (zzav.get() == null) {
                    zzav.set((String) this.c.invoke(null, this.zzzn));
                }
            }
        }
        String str = zzav.get();
        synchronized (this.b) {
            this.b.zzai(zzci.zza(str.getBytes(), true));
        }
    }
}
