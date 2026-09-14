package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public final class zzbck implements Iterable<zzbci> {
    private final List<zzbci> zzecz = new ArrayList();

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzbci a(zzbaz zzbazVar) {
        Iterator<zzbci> it = com.google.android.gms.ads.internal.zzq.zzlm().iterator();
        while (it.hasNext()) {
            zzbci next = it.next();
            if (next.a == zzbazVar) {
                return next;
            }
        }
        return null;
    }

    public static boolean zzc(zzbaz zzbazVar) {
        zzbci a = a(zzbazVar);
        if (a == null) {
            return false;
        }
        a.b.abort();
        return true;
    }

    @Override // java.lang.Iterable
    public final Iterator<zzbci> iterator() {
        return this.zzecz.iterator();
    }

    public final void zza(zzbci zzbciVar) {
        this.zzecz.add(zzbciVar);
    }

    public final void zzb(zzbci zzbciVar) {
        this.zzecz.remove(zzbciVar);
    }
}
