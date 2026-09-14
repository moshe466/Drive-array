package atlow.chemi.mymada.helpers;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build;

/* loaded from: classes.dex */
public class UtilsJava {
    public static int getColorWrapper(Context context, int i) {
        return Build.VERSION.SDK_INT >= 23 ? context.getColor(i) : context.getResources().getColor(i);
    }

    public static Drawable getDrawable(Context context, int i) {
        return Build.VERSION.SDK_INT >= 21 ? context.getDrawable(i) : context.getResources().getDrawable(i);
    }
}
