package B;

import android.app.Notification;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.PorterDuff;
import android.graphics.drawable.Icon;
import android.location.Location;
import android.view.MenuItem;
import android.view.ViewConfiguration;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

/* loaded from: classes.dex */
public abstract class a {
    public static Notification.Builder a(Context context, String str) {
        return new Notification.Builder(context, str);
    }

    public static Icon b(Bitmap bitmap) {
        return Icon.createWithAdaptiveBitmap(bitmap);
    }

    public static float c(Location location) {
        return location.getBearingAccuracyDegrees();
    }

    public static float d(ViewConfiguration viewConfiguration) {
        return viewConfiguration.getScaledHorizontalScrollFactor();
    }

    public static float e(ViewConfiguration viewConfiguration) {
        return viewConfiguration.getScaledVerticalScrollFactor();
    }

    public static float f(Location location) {
        return location.getSpeedAccuracyMetersPerSecond();
    }

    public static float g(Location location) {
        return location.getVerticalAccuracyMeters();
    }

    public static boolean h(Location location) {
        return location.hasBearingAccuracy();
    }

    public static boolean i(Location location) {
        return location.hasSpeedAccuracy();
    }

    public static boolean j(Location location) {
        return location.hasVerticalAccuracy();
    }

    public static boolean k(File file, File file2) {
        try {
            Files.move(file.toPath(), file2.toPath(), StandardCopyOption.REPLACE_EXISTING);
            return true;
        } catch (IOException unused) {
            return false;
        }
    }

    public static void l(MenuItem menuItem, char c4, int i) {
        menuItem.setAlphabeticShortcut(c4, i);
    }

    public static void m(Notification.Builder builder) {
        builder.setBadgeIconType(0);
    }

    public static void n(MenuItem menuItem, CharSequence charSequence) {
        menuItem.setContentDescription(charSequence);
    }

    public static void o(Notification.Builder builder, int i) {
        builder.setGroupAlertBehavior(i);
    }

    public static void p(MenuItem menuItem, ColorStateList colorStateList) {
        menuItem.setIconTintList(colorStateList);
    }

    public static void q(MenuItem menuItem, PorterDuff.Mode mode) {
        menuItem.setIconTintMode(mode);
    }

    public static void r(MenuItem menuItem, char c4, int i) {
        menuItem.setNumericShortcut(c4, i);
    }

    public static void s(Notification.Builder builder) {
        builder.setSettingsText(null);
    }

    public static void t(Notification.Builder builder) {
        builder.setShortcutId(null);
    }

    public static void u(Notification.Builder builder) {
        builder.setTimeoutAfter(0L);
    }

    public static void v(MenuItem menuItem, CharSequence charSequence) {
        menuItem.setTooltipText(charSequence);
    }
}
