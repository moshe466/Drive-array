package y1;

import android.os.Bundle;

/* loaded from: classes.dex */
final class w extends u<Bundle> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public w(int i10, int i11, Bundle bundle) {
        super(i10, 1, bundle);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // y1.u
    public final void a(Bundle bundle) {
        Bundle bundle2 = bundle.getBundle("data");
        if (bundle2 == null) {
            bundle2 = Bundle.EMPTY;
        }
        b(bundle2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // y1.u
    public final boolean d() {
        return false;
    }
}
