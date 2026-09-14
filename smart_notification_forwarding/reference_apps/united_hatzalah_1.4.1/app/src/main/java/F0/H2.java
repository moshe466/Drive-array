package F0;

import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.hardware.SyncFence;
import android.media.Image;
import android.media.ImageReader;
import android.provider.MediaStore;
import android.window.OnBackInvokedCallback;
import android.window.OnBackInvokedDispatcher;
import java.util.List;

/* loaded from: classes.dex */
public abstract /* synthetic */ class H2 {
    public static /* bridge */ /* synthetic */ void B(ImageReader.Builder builder) {
        builder.setImageFormat(34);
    }

    public static /* bridge */ /* synthetic */ void D(ImageReader.Builder builder) {
        builder.setUsage(256L);
    }

    public static /* bridge */ /* synthetic */ int a() {
        return MediaStore.getPickImagesMaxLimit();
    }

    public static /* bridge */ /* synthetic */ PackageInfo c(PackageManager packageManager, String str, PackageManager.PackageInfoFlags packageInfoFlags) {
        return packageManager.getPackageInfo(str, packageInfoFlags);
    }

    public static /* bridge */ /* synthetic */ PackageManager.PackageInfoFlags e() {
        return PackageManager.PackageInfoFlags.of(4096L);
    }

    public static /* bridge */ /* synthetic */ SyncFence g(Image image) {
        return image.getFence();
    }

    public static /* synthetic */ ImageReader.Builder h(int i, int i3) {
        return new ImageReader.Builder(i, i3);
    }

    public static /* bridge */ /* synthetic */ ImageReader i(ImageReader.Builder builder) {
        return builder.build();
    }

    public static /* bridge */ /* synthetic */ OnBackInvokedCallback k(Object obj) {
        return (OnBackInvokedCallback) obj;
    }

    public static /* bridge */ /* synthetic */ OnBackInvokedDispatcher o(Object obj) {
        return (OnBackInvokedDispatcher) obj;
    }

    public static /* bridge */ /* synthetic */ List s(PackageManager packageManager, Intent intent, PackageManager.ResolveInfoFlags resolveInfoFlags) {
        return packageManager.queryIntentActivities(intent, resolveInfoFlags);
    }

    public static /* synthetic */ void t() {
    }

    public static /* bridge */ /* synthetic */ void u(SyncFence syncFence) {
        syncFence.awaitForever();
    }

    public static /* bridge */ /* synthetic */ void v(ImageReader.Builder builder) {
        builder.setMaxImages(7);
    }
}
