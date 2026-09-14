package H0;

import F0.G1;
import G0.n;
import android.app.Activity;
import android.content.Context;
import android.os.Build;
import androidx.lifecycle.AbstractC0305o;
import androidx.lifecycle.EnumC0303m;
import androidx.lifecycle.InterfaceC0309t;
import androidx.lifecycle.r;
import g0.C0427c;
import io.flutter.Log;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.embedding.engine.plugins.activity.ActivityAware;
import io.flutter.embedding.engine.plugins.activity.ActivityPluginBinding;
import io.flutter.embedding.engine.plugins.lifecycle.FlutterLifecycleAdapter;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.EventChannel;
import io.flutter.plugin.common.MethodChannel;
import java.nio.charset.StandardCharsets;

/* loaded from: classes.dex */
public final class b implements FlutterPlugin, ActivityAware, r {

    /* renamed from: a, reason: collision with root package name */
    public final K0.f f845a = new Object();

    /* renamed from: b, reason: collision with root package name */
    public final K0.a f846b = new Object();

    /* renamed from: c, reason: collision with root package name */
    public final K0.d f847c = new K0.d();

    /* renamed from: d, reason: collision with root package name */
    public final h f848d;

    /* renamed from: e, reason: collision with root package name */
    public Context f849e;

    /* renamed from: f, reason: collision with root package name */
    public AbstractC0305o f850f;

    /* renamed from: j, reason: collision with root package name */
    public Activity f851j;

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Object, K0.f] */
    /* JADX WARN: Type inference failed for: r0v1, types: [java.lang.Object, K0.a] */
    public b() {
        h hVar;
        if (Build.VERSION.SDK_INT >= 34) {
            hVar = h.f854a;
        } else {
            hVar = null;
        }
        this.f848d = hVar;
    }

    @Override // androidx.lifecycle.r
    public final void a(InterfaceC0309t interfaceC0309t, EnumC0303m enumC0303m) {
        int i = a.f844a[enumC0303m.ordinal()];
        if (i != 1) {
            if (i == 2 && this.f849e != null) {
                I0.b.f893c = false;
                I0.a.f889b = false;
                return;
            }
            return;
        }
        if (this.f849e != null) {
            I0.b.f893c = true;
            if (I0.b.f894d != null) {
                I0.b.c();
            }
            if (I0.b.f895e != null) {
                I0.b.b();
            }
            I0.a.f889b = true;
            if (I0.a.f890c != null) {
                I0.a.a();
            }
        }
    }

    @Override // io.flutter.embedding.engine.plugins.activity.ActivityAware
    public final void onAttachedToActivity(ActivityPluginBinding binding) {
        kotlin.jvm.internal.j.e(binding, "binding");
        AbstractC0305o activityLifecycle = FlutterLifecycleAdapter.getActivityLifecycle(binding);
        activityLifecycle.a(this);
        this.f850f = activityLifecycle;
        if (this.f848d != null) {
            Activity activity = binding.getActivity();
            kotlin.jvm.internal.j.d(activity, "getActivity(...)");
            h.b(activity);
        }
        this.f847c.f1076j = binding.getActivity();
        this.f851j = binding.getActivity();
    }

    @Override // io.flutter.embedding.engine.plugins.FlutterPlugin
    public final void onAttachedToEngine(FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        kotlin.jvm.internal.j.e(flutterPluginBinding, "flutterPluginBinding");
        BinaryMessenger binaryMessenger = flutterPluginBinding.getBinaryMessenger();
        kotlin.jvm.internal.j.d(binaryMessenger, "getBinaryMessenger(...)");
        this.f849e = flutterPluginBinding.getApplicationContext();
        Context applicationContext = flutterPluginBinding.getApplicationContext();
        kotlin.jvm.internal.j.d(applicationContext, "getApplicationContext(...)");
        K0.d dVar = this.f847c;
        dVar.getClass();
        if (dVar.f1071b != null) {
            Log.i("MethodCallHandler", "Tried to create channel without disposing old one.");
            MethodChannel methodChannel = dVar.f1071b;
            if (methodChannel != null) {
                methodChannel.setMethodCallHandler(null);
            }
            dVar.f1071b = null;
            dVar.f1070a = null;
            dVar.f1072c = null;
            I0.b.f895e = null;
        }
        MethodChannel methodChannel2 = new MethodChannel(binaryMessenger, "talsec.app/freerasp/methods");
        methodChannel2.setMethodCallHandler(dVar);
        dVar.f1071b = methodChannel2;
        dVar.f1070a = applicationContext;
        dVar.f1072c = new J0.e(binaryMessenger);
        G1 sink = dVar.f1077k;
        kotlin.jvm.internal.j.e(sink, "sink");
        I0.b.f895e = sink;
        I0.b.f893c = true;
        I0.b.b();
        K0.f fVar = this.f845a;
        if (fVar.f1079a != null) {
            Log.i("StreamCallHandler", "Tried to create channel without disposing old one.");
            EventChannel eventChannel = fVar.f1079a;
            if (eventChannel != null) {
                eventChannel.setStreamHandler(null);
            }
            fVar.f1079a = null;
            I0.b.f894d = null;
        }
        EventChannel eventChannel2 = new EventChannel(binaryMessenger, "talsec.app/freerasp/events");
        eventChannel2.setStreamHandler(fVar);
        fVar.f1079a = eventChannel2;
        K0.a aVar = this.f846b;
        if (aVar.f1064a != null) {
            Log.i("ExecStateStreamHandler", "Tried to create channel without disposing old one.");
            EventChannel eventChannel3 = aVar.f1064a;
            if (eventChannel3 != null) {
                eventChannel3.setStreamHandler(null);
            }
            aVar.f1064a = null;
            I0.a.f890c = null;
        }
        EventChannel eventChannel4 = new EventChannel(binaryMessenger, "talsec.app/freerasp/execution_state");
        eventChannel4.setStreamHandler(aVar);
        aVar.f1064a = eventChannel4;
    }

    @Override // io.flutter.embedding.engine.plugins.activity.ActivityAware
    public final void onDetachedFromActivity() {
        AbstractC0305o abstractC0305o = this.f850f;
        if (abstractC0305o != null) {
            abstractC0305o.b(this);
        }
        if (this.f848d != null) {
            Activity activity = this.f851j;
            kotlin.jvm.internal.j.b(activity);
            h.d(activity);
        }
        this.f847c.f1076j = null;
        this.f851j = null;
    }

    @Override // io.flutter.embedding.engine.plugins.activity.ActivityAware
    public final void onDetachedFromActivityForConfigChanges() {
        AbstractC0305o abstractC0305o = this.f850f;
        if (abstractC0305o != null) {
            abstractC0305o.b(this);
        }
        if (this.f848d != null) {
            Activity activity = this.f851j;
            kotlin.jvm.internal.j.b(activity);
            h.d(activity);
        }
        this.f847c.f1076j = null;
        this.f851j = null;
    }

    @Override // io.flutter.embedding.engine.plugins.FlutterPlugin
    public final void onDetachedFromEngine(FlutterPlugin.FlutterPluginBinding binding) {
        kotlin.jvm.internal.j.e(binding, "binding");
        K0.d dVar = this.f847c;
        MethodChannel methodChannel = dVar.f1071b;
        if (methodChannel != null) {
            methodChannel.setMethodCallHandler(null);
        }
        dVar.f1071b = null;
        dVar.f1070a = null;
        dVar.f1072c = null;
        I0.b.f895e = null;
        K0.f fVar = this.f845a;
        EventChannel eventChannel = fVar.f1079a;
        if (eventChannel != null) {
            eventChannel.setStreamHandler(null);
        }
        fVar.f1079a = null;
        I0.b.f894d = null;
        K0.a aVar = this.f846b;
        EventChannel eventChannel2 = aVar.f1064a;
        if (eventChannel2 != null) {
            eventChannel2.setStreamHandler(null);
        }
        aVar.f1064a = null;
        I0.a.f890c = null;
        Context applicationContext = binding.getApplicationContext();
        kotlin.jvm.internal.j.d(applicationContext, "getApplicationContext(...)");
        if (!K0.g.f1080a) {
            return;
        }
        K0.g.f1080a = false;
        n nVar = K0.e.f1078a;
        nVar.getClass();
        byte[] bArr = {-57, -107, -68, -70, 101, 72, 64};
        n.a(bArr, new byte[]{-3, 52, 48, 0, 72, -45, 4, -106});
        new String(bArr, StandardCharsets.UTF_8).intern();
        C0427c.a(applicationContext).d(nVar);
    }

    @Override // io.flutter.embedding.engine.plugins.activity.ActivityAware
    public final void onReattachedToActivityForConfigChanges(ActivityPluginBinding binding) {
        kotlin.jvm.internal.j.e(binding, "binding");
        this.f850f = FlutterLifecycleAdapter.getActivityLifecycle(binding);
        this.f851j = binding.getActivity();
        this.f847c.f1076j = binding.getActivity();
        AbstractC0305o abstractC0305o = this.f850f;
        if (abstractC0305o != null) {
            abstractC0305o.a(this);
        }
        if (this.f848d != null) {
            Activity activity = binding.getActivity();
            kotlin.jvm.internal.j.d(activity, "getActivity(...)");
            h.b(activity);
        }
    }
}
