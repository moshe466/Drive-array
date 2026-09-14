package com.google.android.gms.internal.ads;

import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes.dex */
final class zzdpv {
    private final ConcurrentHashMap<zzdpu, List<Throwable>> zzhhe = new ConcurrentHashMap<>(16, 0.75f, 10);
    private final ReferenceQueue<Throwable> zzhhf = new ReferenceQueue<>();

    public final List<Throwable> zza(Throwable th, boolean z) {
        while (true) {
            Reference<? extends Throwable> poll = this.zzhhf.poll();
            if (poll == null) {
                break;
            }
            this.zzhhe.remove(poll);
        }
        List<Throwable> list = this.zzhhe.get(new zzdpu(th, null));
        if (!z || list != null) {
            return list;
        }
        Vector vector = new Vector(2);
        List<Throwable> putIfAbsent = this.zzhhe.putIfAbsent(new zzdpu(th, this.zzhhf), vector);
        return putIfAbsent == null ? vector : putIfAbsent;
    }
}
