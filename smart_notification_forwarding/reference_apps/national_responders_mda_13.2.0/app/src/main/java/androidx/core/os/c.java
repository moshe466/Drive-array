package androidx.core.os;

import android.os.Bundle;
import android.util.Size;
import android.util.SizeF;

/* loaded from: classes.dex */
final class c {
    static {
        new c();
    }

    private c() {
    }

    public static final void a(Bundle bundle, String str, Size size) {
        y8.k.e(bundle, "bundle");
        y8.k.e(str, "key");
        bundle.putSize(str, size);
    }

    public static final void b(Bundle bundle, String str, SizeF sizeF) {
        y8.k.e(bundle, "bundle");
        y8.k.e(str, "key");
        bundle.putSizeF(str, sizeF);
    }
}
