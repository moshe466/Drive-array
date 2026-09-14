package b1;

import A.f;
import F0.G1;
import android.os.Build;
import android.os.Vibrator;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.plugin.common.MethodChannel;

/* renamed from: b1.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0323b implements FlutterPlugin {

    /* renamed from: a, reason: collision with root package name */
    public MethodChannel f3802a;

    @Override // io.flutter.embedding.engine.plugins.FlutterPlugin
    public final void onAttachedToEngine(FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        Vibrator defaultVibrator;
        if (Build.VERSION.SDK_INT >= 31) {
            defaultVibrator = f.l(flutterPluginBinding.getApplicationContext().getSystemService("vibrator_manager")).getDefaultVibrator();
        } else {
            defaultVibrator = (Vibrator) flutterPluginBinding.getApplicationContext().getSystemService("vibrator");
        }
        C0322a c0322a = new C0322a(new G1(defaultVibrator, 12));
        MethodChannel methodChannel = new MethodChannel(flutterPluginBinding.getBinaryMessenger(), "vibration");
        this.f3802a = methodChannel;
        methodChannel.setMethodCallHandler(c0322a);
    }

    @Override // io.flutter.embedding.engine.plugins.FlutterPlugin
    public final void onDetachedFromEngine(FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        this.f3802a.setMethodCallHandler(null);
        this.f3802a = null;
    }
}
