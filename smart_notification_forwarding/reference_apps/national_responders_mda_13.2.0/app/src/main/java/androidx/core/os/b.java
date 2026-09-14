package androidx.core.os;

import android.os.Bundle;
import android.os.IBinder;

/* loaded from: classes.dex */
final class b {
    static {
        new b();
    }

    private b() {
    }

    public static final void a(Bundle bundle, String str, IBinder iBinder) {
        y8.k.e(bundle, "bundle");
        y8.k.e(str, "key");
        bundle.putBinder(str, iBinder);
    }
}
