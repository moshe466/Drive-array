package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.ArrayList;
import java.util.WeakHashMap;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
/* loaded from: classes.dex */
public final class zzpp {
    private final zzazb zzbll;
    private final zzais zzbnv;
    private final Context zzyv;
    private final Object lock = new Object();
    private final WeakHashMap<Object, Object> zzbnt = new WeakHashMap<>();
    private final ArrayList<Object> zzbnu = new ArrayList<>();

    public zzpp(Context context, zzazb zzazbVar) {
        this.zzyv = context.getApplicationContext();
        this.zzbll = zzazbVar;
        this.zzbnv = new zzais(context.getApplicationContext(), zzazbVar, (String) zzve.zzoy().zzd(zzzn.zzcgi));
    }
}
