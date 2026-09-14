package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
final /* synthetic */ class zzbzd implements zzded {
    static final zzded a = new zzbzd();

    private zzbzd() {
    }

    @Override // com.google.android.gms.internal.ads.zzded
    public final Object apply(Object obj) {
        ArrayList arrayList = new ArrayList();
        for (zzbzf zzbzfVar : (List) obj) {
            if (zzbzfVar != null) {
                arrayList.add(zzbzfVar);
            }
        }
        return arrayList;
    }
}
