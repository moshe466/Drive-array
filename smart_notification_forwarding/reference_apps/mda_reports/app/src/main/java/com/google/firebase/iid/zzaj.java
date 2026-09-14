package com.google.firebase.iid;

import android.os.Bundle;

/* loaded from: classes2.dex */
final class zzaj extends zzah<Bundle> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzaj(int i, int i2, Bundle bundle) {
        super(i, 1, bundle);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.firebase.iid.zzah
    public final void a(Bundle bundle) {
        Bundle bundle2 = bundle.getBundle("data");
        if (bundle2 == null) {
            bundle2 = Bundle.EMPTY;
        }
        a((zzaj) bundle2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.firebase.iid.zzah
    public final boolean a() {
        return false;
    }
}
