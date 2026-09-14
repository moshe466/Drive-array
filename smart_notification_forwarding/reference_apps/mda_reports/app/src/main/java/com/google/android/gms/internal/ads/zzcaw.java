package com.google.android.gms.internal.ads;

import java.lang.ref.WeakReference;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzcaw<T> implements zzafn<Object> {
    private final WeakReference<T> zzfqs;
    private final String zzfqt;
    private final zzafn<T> zzfqu;
    private final /* synthetic */ zzcaj zzfqv;

    private zzcaw(zzcaj zzcajVar, WeakReference<T> weakReference, String str, zzafn<T> zzafnVar) {
        this.zzfqv = zzcajVar;
        this.zzfqs = weakReference;
        this.zzfqt = str;
        this.zzfqu = zzafnVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzcaw(zzcaj zzcajVar, WeakReference weakReference, String str, zzafn zzafnVar, zzcao zzcaoVar) {
        this(zzcajVar, weakReference, str, zzafnVar);
    }

    @Override // com.google.android.gms.internal.ads.zzafn
    public final void zza(Object obj, Map<String, String> map) {
        T t = this.zzfqs.get();
        if (t == null) {
            this.zzfqv.zzb(this.zzfqt, this);
        } else {
            this.zzfqu.zza(t, map);
        }
    }
}
