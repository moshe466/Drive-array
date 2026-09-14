package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.IBinder;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.ads.dynamite.ModuleDescriptor;

/* loaded from: classes.dex */
public final class zzayx {
    public static <T> T zza(Context context, String str, zzayw<IBinder, T> zzaywVar) {
        try {
            return zzaywVar.apply(zzbq(context).instantiate(str));
        } catch (Exception e) {
            throw new zzayz(e);
        }
    }

    public static Context zzbp(Context context) {
        return zzbq(context).getModuleContext();
    }

    private static DynamiteModule zzbq(Context context) {
        try {
            return DynamiteModule.load(context, DynamiteModule.PREFER_REMOTE, ModuleDescriptor.MODULE_ID);
        } catch (Exception e) {
            throw new zzayz(e);
        }
    }
}
