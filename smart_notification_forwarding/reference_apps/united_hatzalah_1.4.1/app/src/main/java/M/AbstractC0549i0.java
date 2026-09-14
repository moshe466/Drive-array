package m;

import android.text.StaticLayout;
import android.widget.TextView;

/* renamed from: m.i0, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0549i0 {
    public abstract void a(StaticLayout.Builder builder, TextView textView);

    public boolean b(TextView textView) {
        Object obj = Boolean.FALSE;
        try {
            obj = C0551j0.d("getHorizontallyScrolling").invoke(textView, null);
        } catch (Exception unused) {
        }
        return ((Boolean) obj).booleanValue();
    }
}
