package A;

import android.app.ForegroundServiceStartNotAllowedException;
import android.content.ClipData;
import android.graphics.fonts.Font;
import android.location.Location;
import android.os.VibratorManager;
import android.view.ContentInfo;

/* loaded from: classes.dex */
public abstract /* synthetic */ class f {
    public static /* bridge */ /* synthetic */ boolean B(Exception exc) {
        return exc instanceof ForegroundServiceStartNotAllowedException;
    }

    public static /* synthetic */ Font.Builder g(Font font) {
        return new Font.Builder(font);
    }

    public static /* bridge */ /* synthetic */ VibratorManager l(Object obj) {
        return (VibratorManager) obj;
    }

    public static /* synthetic */ ContentInfo.Builder n(ClipData clipData, int i) {
        return new ContentInfo.Builder(clipData, i);
    }

    public static /* bridge */ /* synthetic */ ContentInfo p(Object obj) {
        return (ContentInfo) obj;
    }

    public static /* bridge */ /* synthetic */ boolean z(Location location) {
        return location.isMock();
    }
}
