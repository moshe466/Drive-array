package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* loaded from: classes.dex */
public final class zzdxl<T> implements zzdxg<Set<T>> {
    private static final zzdxg<Set<Object>> zziae = zzdxf.zzbe(Collections.emptySet());
    private final List<zzdxp<T>> zziaf;
    private final List<zzdxp<Collection<T>>> zziag;

    private zzdxl(List<zzdxp<T>> list, List<zzdxp<Collection<T>>> list2) {
        this.zziaf = list;
        this.zziag = list2;
    }

    public static <T> zzdxn<T> zzar(int i, int i2) {
        return new zzdxn<>(i, i2);
    }

    @Override // com.google.android.gms.internal.ads.zzdxp
    public final /* synthetic */ Object get() {
        int size = this.zziaf.size();
        ArrayList arrayList = new ArrayList(this.zziag.size());
        int size2 = this.zziag.size();
        int i = size;
        for (int i2 = 0; i2 < size2; i2++) {
            Collection<T> collection = this.zziag.get(i2).get();
            i += collection.size();
            arrayList.add(collection);
        }
        HashSet a = zzdxb.a(i);
        int size3 = this.zziaf.size();
        for (int i3 = 0; i3 < size3; i3++) {
            a.add(zzdxm.checkNotNull(this.zziaf.get(i3).get()));
        }
        int size4 = arrayList.size();
        for (int i4 = 0; i4 < size4; i4++) {
            Iterator it = ((Collection) arrayList.get(i4)).iterator();
            while (it.hasNext()) {
                a.add(zzdxm.checkNotNull(it.next()));
            }
        }
        return Collections.unmodifiableSet(a);
    }
}
