package J;

import F0.C0035g2;
import android.view.ContentInfo;
import android.view.View;
import java.util.Objects;

/* loaded from: classes.dex */
public abstract class P {
    public static String[] a(View view) {
        return view.getReceiveContentMimeTypes();
    }

    public static C0118f b(View view, C0118f c0118f) {
        ContentInfo n4 = c0118f.f982a.n();
        Objects.requireNonNull(n4);
        ContentInfo performReceiveContent = view.performReceiveContent(n4);
        if (performReceiveContent == null) {
            return null;
        }
        if (performReceiveContent == n4) {
            return c0118f;
        }
        return new C0118f(new C0035g2(performReceiveContent));
    }
}
