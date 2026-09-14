package com.google.android.gms.internal.ads;

import android.os.Bundle;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

/* loaded from: classes.dex */
final class zzcqi implements zzcub<zzcty<Bundle>> {
    private final Set<String> zzgeu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzcqi(Set<String> set) {
        this.zzgeu = set;
    }

    @Override // com.google.android.gms.internal.ads.zzcub
    public final zzdhe<zzcty<Bundle>> zzanc() {
        final ArrayList arrayList = new ArrayList();
        Iterator<String> it = this.zzgeu.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next());
        }
        return zzdgs.zzaj(new zzcty(arrayList) { // from class: com.google.android.gms.internal.ads.zzcql
            private final ArrayList zzgex;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzgex = arrayList;
            }

            @Override // com.google.android.gms.internal.ads.zzcty
            public final void zzr(Object obj) {
                ((Bundle) obj).putStringArrayList("ad_types", this.zzgex);
            }
        });
    }
}
