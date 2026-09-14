package a1;

import A.n;
import android.app.Activity;
import android.content.Context;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.embedding.engine.plugins.activity.ActivityAware;
import io.flutter.embedding.engine.plugins.activity.ActivityPluginBinding;
import io.flutter.plugin.common.MethodChannel;

/* renamed from: a1.c, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0232c implements FlutterPlugin, ActivityAware {

    /* renamed from: a, reason: collision with root package name */
    public C0233d f2754a;

    /* renamed from: b, reason: collision with root package name */
    public MethodChannel f2755b;

    /* renamed from: c, reason: collision with root package name */
    public ActivityPluginBinding f2756c;

    @Override // io.flutter.embedding.engine.plugins.activity.ActivityAware
    public final void onAttachedToActivity(ActivityPluginBinding activityPluginBinding) {
        Activity activity = activityPluginBinding.getActivity();
        C0233d c0233d = this.f2754a;
        if (c0233d != null) {
            c0233d.f2759c = activity;
        }
        this.f2756c = activityPluginBinding;
        activityPluginBinding.addActivityResultListener(c0233d);
        this.f2756c.addRequestPermissionsResultListener(this.f2754a);
    }

    @Override // io.flutter.embedding.engine.plugins.FlutterPlugin
    public final void onAttachedToEngine(FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        this.f2754a = new C0233d(flutterPluginBinding.getApplicationContext());
        Context applicationContext = flutterPluginBinding.getApplicationContext();
        MethodChannel methodChannel = new MethodChannel(flutterPluginBinding.getBinaryMessenger(), "flutter.baseflow.com/permissions/methods");
        this.f2755b = methodChannel;
        methodChannel.setMethodCallHandler(new C0231b(applicationContext, new n(26), this.f2754a, new n(27)));
    }

    @Override // io.flutter.embedding.engine.plugins.activity.ActivityAware
    public final void onDetachedFromActivity() {
        C0233d c0233d = this.f2754a;
        if (c0233d != null) {
            c0233d.f2759c = null;
        }
        ActivityPluginBinding activityPluginBinding = this.f2756c;
        if (activityPluginBinding != null) {
            activityPluginBinding.removeActivityResultListener(c0233d);
            this.f2756c.removeRequestPermissionsResultListener(this.f2754a);
        }
        this.f2756c = null;
    }

    @Override // io.flutter.embedding.engine.plugins.activity.ActivityAware
    public final void onDetachedFromActivityForConfigChanges() {
        onDetachedFromActivity();
    }

    @Override // io.flutter.embedding.engine.plugins.FlutterPlugin
    public final void onDetachedFromEngine(FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        this.f2755b.setMethodCallHandler(null);
        this.f2755b = null;
    }

    @Override // io.flutter.embedding.engine.plugins.activity.ActivityAware
    public final void onReattachedToActivityForConfigChanges(ActivityPluginBinding activityPluginBinding) {
        onAttachedToActivity(activityPluginBinding);
    }
}
