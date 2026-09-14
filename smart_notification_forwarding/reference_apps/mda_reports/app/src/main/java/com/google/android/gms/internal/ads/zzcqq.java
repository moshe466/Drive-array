package com.google.android.gms.internal.ads;

import android.os.Bundle;
import java.util.ArrayList;

/* loaded from: classes.dex */
final /* synthetic */ class zzcqq implements zzded {
    static final zzded a = new zzcqq();

    private zzcqq() {
    }

    @Override // com.google.android.gms.internal.ads.zzded
    public final Object apply(Object obj) {
        final ArrayList arrayList = (ArrayList) obj;
        if (arrayList.isEmpty()) {
            return null;
        }
        return new zzcty(arrayList) { // from class: com.google.android.gms.internal.ads.zzcqt
            private final ArrayList zzgex;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzgex = arrayList;
            }

            @Override // com.google.android.gms.internal.ads.zzcty
            public final void zzr(Object obj2) {
                ((Bundle) obj2).putStringArrayList("android_permissions", this.zzgex);
            }
        };
    }
}
