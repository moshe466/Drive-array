package K;

import android.app.ActivityManager;
import android.text.PrecomputedText;
import android.webkit.TracingConfig;

/* loaded from: classes.dex */
public abstract /* synthetic */ class c {
    public static /* bridge */ /* synthetic */ boolean D(CharSequence charSequence) {
        return charSequence instanceof PrecomputedText;
    }

    public static /* synthetic */ ActivityManager.TaskDescription b(int i, String str) {
        return new ActivityManager.TaskDescription(str, 0, i);
    }

    public static /* synthetic */ TracingConfig.Builder k() {
        return new TracingConfig.Builder();
    }
}
