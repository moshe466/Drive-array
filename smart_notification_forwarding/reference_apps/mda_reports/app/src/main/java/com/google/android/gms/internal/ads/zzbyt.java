package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
final /* synthetic */ class zzbyt implements zzded {
    static final zzded a = new zzbyt();

    private zzbyt() {
    }

    @Override // com.google.android.gms.internal.ads.zzded
    public final Object apply(Object obj) {
        ArrayList arrayList = new ArrayList();
        for (zzabu zzabuVar : (List) obj) {
            if (zzabuVar != null) {
                arrayList.add(zzabuVar);
            }
        }
        return arrayList;
    }
}
