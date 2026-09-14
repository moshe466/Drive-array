package com.google.firebase.iid;

import android.os.Bundle;

/* loaded from: classes2.dex */
final class zzae extends zzah<Void> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzae(int i, int i2, Bundle bundle) {
        super(i, 2, bundle);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.firebase.iid.zzah
    public final void a(Bundle bundle) {
        if (bundle.getBoolean("ack", false)) {
            a((zzae) null);
        } else {
            a(new zzag(4, "Invalid response to one way request"));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.firebase.iid.zzah
    public final boolean a() {
        return true;
    }
}
