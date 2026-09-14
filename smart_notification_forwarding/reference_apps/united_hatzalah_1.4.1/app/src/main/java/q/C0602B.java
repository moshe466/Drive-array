package q;

import android.graphics.Path;
import android.os.Bundle;

/* renamed from: q.B, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0602B implements s.b {
    public static Path a(float f4, float f5, float f6, float f7) {
        Path path = new Path();
        path.moveTo(f4, f5);
        path.lineTo(f6, f7);
        return path;
    }

    @Override // s.b
    public Bundle toBundle() {
        Bundle bundle = new Bundle();
        bundle.putInt("androidx.browser.trusted.displaymode.KEY_ID", 0);
        return bundle;
    }
}
