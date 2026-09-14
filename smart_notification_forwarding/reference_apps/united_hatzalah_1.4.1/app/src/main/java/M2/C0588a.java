package m2;

import android.app.ActivityManager;
import android.content.ContentResolver;
import android.content.Context;
import android.content.pm.PackageManager;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.MethodChannel;
import kotlin.jvm.internal.j;

/* renamed from: m2.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0588a implements FlutterPlugin {

    /* renamed from: a, reason: collision with root package name */
    public MethodChannel f5866a;

    @Override // io.flutter.embedding.engine.plugins.FlutterPlugin
    public final void onAttachedToEngine(FlutterPlugin.FlutterPluginBinding binding) {
        j.e(binding, "binding");
        BinaryMessenger binaryMessenger = binding.getBinaryMessenger();
        j.d(binaryMessenger, "getBinaryMessenger(...)");
        Context applicationContext = binding.getApplicationContext();
        j.d(applicationContext, "getApplicationContext(...)");
        this.f5866a = new MethodChannel(binaryMessenger, "dev.fluttercommunity.plus/device_info");
        PackageManager packageManager = applicationContext.getPackageManager();
        j.d(packageManager, "getPackageManager(...)");
        Object systemService = applicationContext.getSystemService("activity");
        j.c(systemService, "null cannot be cast to non-null type android.app.ActivityManager");
        ContentResolver contentResolver = applicationContext.getContentResolver();
        j.b(contentResolver);
        C0589b c0589b = new C0589b(packageManager, (ActivityManager) systemService, contentResolver);
        MethodChannel methodChannel = this.f5866a;
        if (methodChannel != null) {
            methodChannel.setMethodCallHandler(c0589b);
        } else {
            j.i("methodChannel");
            throw null;
        }
    }

    @Override // io.flutter.embedding.engine.plugins.FlutterPlugin
    public final void onDetachedFromEngine(FlutterPlugin.FlutterPluginBinding binding) {
        j.e(binding, "binding");
        MethodChannel methodChannel = this.f5866a;
        if (methodChannel != null) {
            methodChannel.setMethodCallHandler(null);
        } else {
            j.i("methodChannel");
            throw null;
        }
    }
}
