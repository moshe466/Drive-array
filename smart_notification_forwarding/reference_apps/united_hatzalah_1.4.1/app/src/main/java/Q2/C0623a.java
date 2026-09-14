package q2;

import android.content.Context;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.MethodChannel;
import kotlin.jvm.internal.j;

/* renamed from: q2.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0623a implements FlutterPlugin {

    /* renamed from: a, reason: collision with root package name */
    public MethodChannel f6154a;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v2, types: [io.flutter.plugin.common.MethodChannel$MethodCallHandler, q2.c, java.lang.Object] */
    @Override // io.flutter.embedding.engine.plugins.FlutterPlugin
    public final void onAttachedToEngine(FlutterPlugin.FlutterPluginBinding binding) {
        j.e(binding, "binding");
        BinaryMessenger binaryMessenger = binding.getBinaryMessenger();
        j.d(binaryMessenger, "getBinaryMessenger(...)");
        Context applicationContext = binding.getApplicationContext();
        j.d(applicationContext, "getApplicationContext(...)");
        this.f6154a = new MethodChannel(binaryMessenger, "PonnamKarthik/fluttertoast");
        ?? obj = new Object();
        obj.f6156a = applicationContext;
        MethodChannel methodChannel = this.f6154a;
        if (methodChannel != 0) {
            methodChannel.setMethodCallHandler(obj);
        }
    }

    @Override // io.flutter.embedding.engine.plugins.FlutterPlugin
    public final void onDetachedFromEngine(FlutterPlugin.FlutterPluginBinding p02) {
        j.e(p02, "p0");
        MethodChannel methodChannel = this.f6154a;
        if (methodChannel != null) {
            methodChannel.setMethodCallHandler(null);
        }
        this.f6154a = null;
    }
}
