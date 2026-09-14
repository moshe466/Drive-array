package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.WeakHashMap;
import java.util.concurrent.Callable;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzaqu implements Callable<zzaqt> {
    private final /* synthetic */ Context val$context;
    private final /* synthetic */ zzaqv zzdnh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzaqu(zzaqv zzaqvVar, Context context) {
        this.zzdnh = zzaqvVar;
        this.val$context = context;
    }

    @Override // java.util.concurrent.Callable
    public final /* synthetic */ zzaqt call() {
        WeakHashMap weakHashMap;
        zzaqt zzug;
        WeakHashMap weakHashMap2;
        weakHashMap = this.zzdnh.zzdni;
        zzaqx zzaqxVar = (zzaqx) weakHashMap.get(this.val$context);
        if (zzaqxVar != null) {
            if (!(zzaqxVar.zzdnl + zzaau.zzcsu.get().longValue() < com.google.android.gms.ads.internal.zzq.zzkx().currentTimeMillis())) {
                zzug = new zzaqs(this.val$context, zzaqxVar.zzdnm).zzug();
                weakHashMap2 = this.zzdnh.zzdni;
                weakHashMap2.put(this.val$context, new zzaqx(this.zzdnh, zzug));
                return zzug;
            }
        }
        zzug = new zzaqs(this.val$context).zzug();
        weakHashMap2 = this.zzdnh.zzdni;
        weakHashMap2.put(this.val$context, new zzaqx(this.zzdnh, zzug));
        return zzug;
    }
}
