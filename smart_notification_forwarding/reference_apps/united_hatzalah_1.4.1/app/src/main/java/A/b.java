package A;

import android.app.Notification;
import android.content.Context;
import android.graphics.Insets;

/* loaded from: classes.dex */
public abstract class b {
    public static String a(Context context) {
        return context.getOpPackageName();
    }

    public static Insets b(int i, int i3, int i4, int i5) {
        return Insets.of(i, i3, i4, i5);
    }

    public static void c(Notification.Builder builder, boolean z3) {
        builder.setAllowSystemGeneratedContextualActions(z3);
    }

    public static void d(Notification.Builder builder) {
        builder.setBubbleMetadata(null);
    }

    public static void e(Notification.Action.Builder builder) {
        builder.setContextual(false);
    }
}
