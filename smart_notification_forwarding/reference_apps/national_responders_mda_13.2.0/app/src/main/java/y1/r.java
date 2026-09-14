package y1;

import android.os.Bundle;

/* loaded from: classes.dex */
final class r extends u<Void> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public r(int i10, int i11, Bundle bundle) {
        super(i10, 2, bundle);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // y1.u
    public final void a(Bundle bundle) {
        if (bundle.getBoolean("ack", false)) {
            b(null);
        } else {
            c(new t(4, "Invalid response to one way request"));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // y1.u
    public final boolean d() {
        return true;
    }
}
