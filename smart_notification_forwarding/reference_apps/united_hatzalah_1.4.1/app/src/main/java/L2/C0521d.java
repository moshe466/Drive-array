package l2;

import F0.G1;
import android.content.Context;
import android.net.ConnectivityManager;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.EventChannel;
import io.flutter.plugin.common.MethodChannel;

/* renamed from: l2.d, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0521d implements FlutterPlugin {

    /* renamed from: a, reason: collision with root package name */
    public MethodChannel f5490a;

    /* renamed from: b, reason: collision with root package name */
    public EventChannel f5491b;

    /* renamed from: c, reason: collision with root package name */
    public C0519b f5492c;

    @Override // io.flutter.embedding.engine.plugins.FlutterPlugin
    public final void onAttachedToEngine(FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        BinaryMessenger binaryMessenger = flutterPluginBinding.getBinaryMessenger();
        Context applicationContext = flutterPluginBinding.getApplicationContext();
        this.f5490a = new MethodChannel(binaryMessenger, "dev.fluttercommunity.plus/connectivity");
        this.f5491b = new EventChannel(binaryMessenger, "dev.fluttercommunity.plus/connectivity_status");
        G1 g12 = new G1((ConnectivityManager) applicationContext.getSystemService("connectivity"), 21);
        C0520c c0520c = new C0520c(g12);
        this.f5492c = new C0519b(applicationContext, g12);
        this.f5490a.setMethodCallHandler(c0520c);
        this.f5491b.setStreamHandler(this.f5492c);
    }

    @Override // io.flutter.embedding.engine.plugins.FlutterPlugin
    public final void onDetachedFromEngine(FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        this.f5490a.setMethodCallHandler(null);
        this.f5491b.setStreamHandler(null);
        this.f5492c.onCancel(null);
        this.f5490a = null;
        this.f5491b = null;
        this.f5492c = null;
    }
}
