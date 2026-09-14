package com.google.android.recaptcha.internal;

import java.util.Iterator;
import java.util.List;
import t2.AbstractC0705g;
import t2.AbstractC0707i;
import t2.C0716r;

/* loaded from: classes.dex */
public final class zzhy {
    private List zza = C0716r.f6476a;

    public final long zza(long[] jArr) {
        Iterator it = AbstractC0707i.j0(AbstractC0705g.Q(jArr), this.zza).iterator();
        if (it.hasNext()) {
            Object next = it.next();
            while (it.hasNext()) {
                next = Long.valueOf(((Number) next).longValue() ^ ((Number) it.next()).longValue());
            }
            return ((Number) next).longValue();
        }
        throw new UnsupportedOperationException("Empty collection can't be reduced.");
    }

    public final void zzb(long[] jArr) {
        this.zza = AbstractC0705g.Q(jArr);
    }
}
