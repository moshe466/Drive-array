package com.google.android.gms.internal.ads;

import java.util.List;

/* loaded from: classes.dex */
final class zzdsp extends zzdso {
    private zzdsp() {
        super();
    }

    private static <E> zzdsb<E> zzc(Object obj, long j) {
        return (zzdsb) zzduy.f(obj, j);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.ads.zzdso
    public final <L> List<L> a(Object obj, long j) {
        zzdsb zzc = zzc(obj, j);
        if (zzc.zzaxp()) {
            return zzc;
        }
        int size = zzc.size();
        zzdsb zzfd = zzc.zzfd(size == 0 ? 10 : size << 1);
        zzduy.a(obj, j, zzfd);
        return zzfd;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.ads.zzdso
    public final <E> void a(Object obj, Object obj2, long j) {
        zzdsb zzc = zzc(obj, j);
        zzdsb zzc2 = zzc(obj2, j);
        int size = zzc.size();
        int size2 = zzc2.size();
        if (size > 0 && size2 > 0) {
            if (!zzc.zzaxp()) {
                zzc = zzc.zzfd(size2 + size);
            }
            zzc.addAll(zzc2);
        }
        if (size > 0) {
            zzc2 = zzc;
        }
        zzduy.a(obj, j, zzc2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.ads.zzdso
    public final void b(Object obj, long j) {
        zzc(obj, j).zzaxq();
    }
}
