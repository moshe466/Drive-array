package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzdgh<V> extends zzdge<V, List<V>> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzdgh(zzdet<? extends zzdhe<? extends V>> zzdetVar, boolean z) {
        super(zzdetVar, true);
        k();
    }

    @Override // com.google.android.gms.internal.ads.zzdge
    public final /* synthetic */ Object zzh(List list) {
        ArrayList zzdz = zzdfc.zzdz(list.size());
        Iterator it = list.iterator();
        while (it.hasNext()) {
            zzdej zzdejVar = (zzdej) it.next();
            zzdz.add(zzdejVar != null ? zzdejVar.zzaqt() : null);
        }
        return Collections.unmodifiableList(zzdz);
    }
}
