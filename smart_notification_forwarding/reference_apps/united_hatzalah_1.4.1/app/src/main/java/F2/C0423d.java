package f2;

import F0.AbstractC0008a;
import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.util.Log;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

/* renamed from: f2.d, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0423d implements MethodChannel.MethodCallHandler, FlutterPlugin {

    /* renamed from: a, reason: collision with root package name */
    public MethodChannel f4609a;

    /* renamed from: b, reason: collision with root package name */
    public C0420a f4610b;

    /* renamed from: c, reason: collision with root package name */
    public HandlerThread f4611c;

    /* renamed from: d, reason: collision with root package name */
    public Handler f4612d;

    public static String a(C0423d c0423d, MethodCall methodCall) {
        Map map = (Map) methodCall.arguments;
        C0420a c0420a = c0423d.f4610b;
        return AbstractC0008a.v(new StringBuilder(), c0420a.f4596a, "_", (String) map.get("key"));
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [f2.a, java.lang.Object] */
    @Override // io.flutter.embedding.engine.plugins.FlutterPlugin
    public final void onAttachedToEngine(FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        BinaryMessenger binaryMessenger = flutterPluginBinding.getBinaryMessenger();
        Context applicationContext = flutterPluginBinding.getApplicationContext();
        try {
            HashMap hashMap = new HashMap();
            ?? obj = new Object();
            obj.f4596a = "VGhpcyBpcyB0aGUgcHJlZml4IGZvciBhIHNlY3VyZSBzdG9yYWdlCg";
            obj.f4599d = "FlutterSecureStorage";
            obj.i = Boolean.FALSE;
            obj.f4600e = hashMap;
            obj.f4598c = applicationContext.getApplicationContext();
            obj.f4597b = StandardCharsets.UTF_8;
            this.f4610b = obj;
            HandlerThread handlerThread = new HandlerThread("com.it_nomads.fluttersecurestorage.worker");
            this.f4611c = handlerThread;
            handlerThread.start();
            this.f4612d = new Handler(this.f4611c.getLooper());
            MethodChannel methodChannel = new MethodChannel(binaryMessenger, "plugins.it_nomads.com/flutter_secure_storage");
            this.f4609a = methodChannel;
            methodChannel.setMethodCallHandler(this);
        } catch (Exception e4) {
            Log.e("FlutterSecureStoragePl", "Registration failed", e4);
        }
    }

    @Override // io.flutter.embedding.engine.plugins.FlutterPlugin
    public final void onDetachedFromEngine(FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        if (this.f4609a != null) {
            this.f4611c.quitSafely();
            this.f4611c = null;
            this.f4609a.setMethodCallHandler(null);
            this.f4609a = null;
        }
        this.f4610b = null;
    }

    @Override // io.flutter.plugin.common.MethodChannel.MethodCallHandler
    public final void onMethodCall(MethodCall methodCall, MethodChannel.Result result) {
        this.f4612d.post(new RunnableC0422c(this, methodCall, new C0421b(result)));
    }
}
