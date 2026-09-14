package i2;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import androidx.lifecycle.AbstractC0305o;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.embedding.engine.plugins.activity.ActivityAware;
import io.flutter.embedding.engine.plugins.activity.ActivityPluginBinding;
import io.flutter.embedding.engine.plugins.lifecycle.FlutterLifecycleAdapter;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.EventChannel;
import io.flutter.plugin.common.MethodChannel;
import kotlin.jvm.internal.j;

/* renamed from: i2.e, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0454e implements MethodChannel.MethodCallHandler, FlutterPlugin, ActivityAware {

    /* renamed from: a, reason: collision with root package name */
    public ActivityPluginBinding f4990a;

    /* renamed from: b, reason: collision with root package name */
    public C0451b f4991b;

    /* renamed from: c, reason: collision with root package name */
    public Application f4992c;

    /* renamed from: d, reason: collision with root package name */
    public FlutterPlugin.FlutterPluginBinding f4993d;

    /* renamed from: e, reason: collision with root package name */
    public AbstractC0305o f4994e;

    /* renamed from: f, reason: collision with root package name */
    public C0452c f4995f;

    /* renamed from: j, reason: collision with root package name */
    public Activity f4996j;

    /* renamed from: k, reason: collision with root package name */
    public MethodChannel f4997k;

    @Override // io.flutter.embedding.engine.plugins.activity.ActivityAware
    public final void onAttachedToActivity(ActivityPluginBinding binding) {
        j.e(binding, "binding");
        this.f4990a = binding;
        FlutterPlugin.FlutterPluginBinding flutterPluginBinding = this.f4993d;
        if (flutterPluginBinding != null) {
            BinaryMessenger binaryMessenger = flutterPluginBinding.getBinaryMessenger();
            j.d(binaryMessenger, "getBinaryMessenger(...)");
            Context applicationContext = flutterPluginBinding.getApplicationContext();
            j.c(applicationContext, "null cannot be cast to non-null type android.app.Application");
            ActivityPluginBinding activityPluginBinding = this.f4990a;
            j.b(activityPluginBinding);
            Activity activity = activityPluginBinding.getActivity();
            j.d(activity, "getActivity(...)");
            ActivityPluginBinding activityPluginBinding2 = this.f4990a;
            j.b(activityPluginBinding2);
            this.f4996j = activity;
            this.f4992c = (Application) applicationContext;
            this.f4991b = new C0451b(activity);
            MethodChannel methodChannel = new MethodChannel(binaryMessenger, "miguelruivo.flutter.plugins.filepicker");
            this.f4997k = methodChannel;
            methodChannel.setMethodCallHandler(this);
            C0451b c0451b = this.f4991b;
            if (c0451b != null) {
                new EventChannel(binaryMessenger, "miguelruivo.flutter.plugins.filepickerevent").setStreamHandler(new C0453d(c0451b));
                this.f4995f = new C0452c(activity);
                activityPluginBinding2.addActivityResultListener(c0451b);
                AbstractC0305o activityLifecycle = FlutterLifecycleAdapter.getActivityLifecycle(activityPluginBinding2);
                this.f4994e = activityLifecycle;
                C0452c c0452c = this.f4995f;
                if (c0452c != null && activityLifecycle != null) {
                    activityLifecycle.a(c0452c);
                }
            }
        }
    }

    @Override // io.flutter.embedding.engine.plugins.FlutterPlugin
    public final void onAttachedToEngine(FlutterPlugin.FlutterPluginBinding binding) {
        j.e(binding, "binding");
        this.f4993d = binding;
    }

    @Override // io.flutter.embedding.engine.plugins.activity.ActivityAware
    public final void onDetachedFromActivity() {
        ActivityPluginBinding activityPluginBinding;
        C0451b c0451b = this.f4991b;
        if (c0451b != null && (activityPluginBinding = this.f4990a) != null) {
            activityPluginBinding.removeActivityResultListener(c0451b);
        }
        this.f4990a = null;
        C0452c c0452c = this.f4995f;
        if (c0452c != null) {
            AbstractC0305o abstractC0305o = this.f4994e;
            if (abstractC0305o != null) {
                abstractC0305o.b(c0452c);
            }
            Application application = this.f4992c;
            if (application != null) {
                application.unregisterActivityLifecycleCallbacks(c0452c);
            }
        }
        this.f4994e = null;
        C0451b c0451b2 = this.f4991b;
        if (c0451b2 != null) {
            c0451b2.f4986k = null;
        }
        this.f4991b = null;
        MethodChannel methodChannel = this.f4997k;
        if (methodChannel != null) {
            methodChannel.setMethodCallHandler(null);
        }
        this.f4997k = null;
        this.f4992c = null;
    }

    @Override // io.flutter.embedding.engine.plugins.activity.ActivityAware
    public final void onDetachedFromActivityForConfigChanges() {
        onDetachedFromActivity();
    }

    @Override // io.flutter.embedding.engine.plugins.FlutterPlugin
    public final void onDetachedFromEngine(FlutterPlugin.FlutterPluginBinding binding) {
        j.e(binding, "binding");
        this.f4993d = null;
    }

    /* JADX WARN: Removed duplicated region for block: B:82:0x0170  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0172 A[Catch: all -> 0x0179, TryCatch #0 {all -> 0x0179, blocks: (B:74:0x013b, B:76:0x0142, B:79:0x0149, B:80:0x0168, B:83:0x0175, B:85:0x0172, B:86:0x0164), top: B:73:0x013b }] */
    @Override // io.flutter.plugin.common.MethodChannel.MethodCallHandler
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void onMethodCall(io.flutter.plugin.common.MethodCall r11, io.flutter.plugin.common.MethodChannel.Result r12) {
        /*
            Method dump skipped, instructions count: 600
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: i2.C0454e.onMethodCall(io.flutter.plugin.common.MethodCall, io.flutter.plugin.common.MethodChannel$Result):void");
    }

    @Override // io.flutter.embedding.engine.plugins.activity.ActivityAware
    public final void onReattachedToActivityForConfigChanges(ActivityPluginBinding binding) {
        j.e(binding, "binding");
        onAttachedToActivity(binding);
    }
}
