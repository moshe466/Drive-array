package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.WeakHashMap;
import java.util.concurrent.Future;

/* loaded from: classes.dex */
public final class zzaqv {
    private WeakHashMap<Context, zzaqx> zzdni = new WeakHashMap<>();

    public final Future<zzaqt> zzx(Context context) {
        return zzazd.zzdwe.submit(new zzaqu(this, context));
    }
}
