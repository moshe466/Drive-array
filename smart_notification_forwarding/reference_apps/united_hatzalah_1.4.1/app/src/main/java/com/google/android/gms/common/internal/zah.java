package com.google.android.gms.common.internal;

import android.content.Intent;
import androidx.fragment.app.G;

/* loaded from: classes.dex */
final class zah extends zaj {
    final /* synthetic */ Intent zaa;
    final /* synthetic */ G zab;
    final /* synthetic */ int zac;

    public zah(Intent intent, G g3, int i) {
        this.zaa = intent;
        this.zab = g3;
        this.zac = i;
    }

    @Override // com.google.android.gms.common.internal.zaj
    public final void zaa() {
        Intent intent = this.zaa;
        if (intent != null) {
            this.zab.startActivityForResult(intent, this.zac);
        }
    }
}
