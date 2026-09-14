package k2;

import E1.m;
import F0.C0068p;
import F0.I1;
import a1.C0230a;
import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.google.android.gms.tasks.Task;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.embedding.engine.plugins.activity.ActivityAware;
import io.flutter.embedding.engine.plugins.activity.ActivityPluginBinding;
import io.flutter.plugin.common.EventChannel;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugin.common.PluginRegistry;
import kotlin.jvm.internal.j;
import s2.C0684i;

/* renamed from: k2.f, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0496f implements FlutterPlugin, MethodChannel.MethodCallHandler, PluginRegistry.ActivityResultListener, Application.ActivityLifecycleCallbacks, ActivityAware, EventChannel.StreamHandler {

    /* renamed from: a, reason: collision with root package name */
    public MethodChannel f5293a;

    /* renamed from: b, reason: collision with root package name */
    public EventChannel f5294b;

    /* renamed from: c, reason: collision with root package name */
    public C0493c f5295c;

    /* renamed from: d, reason: collision with root package name */
    public EventChannel.EventSink f5296d;

    /* renamed from: e, reason: collision with root package name */
    public InterfaceC0491a f5297e;

    /* renamed from: f, reason: collision with root package name */
    public MethodChannel.Result f5298f;

    /* renamed from: j, reason: collision with root package name */
    public Integer f5299j;

    /* renamed from: k, reason: collision with root package name */
    public E1.a f5300k;

    /* renamed from: l, reason: collision with root package name */
    public E1.d f5301l;

    public final void a(MethodChannel.Result result, F2.a aVar) {
        Activity activity;
        if (this.f5300k != null) {
            InterfaceC0491a interfaceC0491a = this.f5297e;
            if (interfaceC0491a != null) {
                activity = interfaceC0491a.a();
            } else {
                activity = null;
            }
            if (activity != null) {
                if (this.f5301l != null) {
                    aVar.invoke();
                    return;
                } else {
                    result.error("REQUIRE_CHECK_FOR_UPDATE", "Call checkForUpdate first!", null);
                    throw new IllegalArgumentException("kotlin.Unit");
                }
            }
            result.error("REQUIRE_FOREGROUND_ACTIVITY", "in_app_update requires a foreground activity", null);
            throw new IllegalArgumentException("kotlin.Unit");
        }
        result.error("REQUIRE_CHECK_FOR_UPDATE", "Call checkForUpdate first!", null);
        throw new IllegalArgumentException("kotlin.Unit");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity activity, Bundle bundle) {
        j.e(activity, "activity");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity activity) {
        j.e(activity, "activity");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity activity) {
        j.e(activity, "activity");
    }

    @Override // io.flutter.plugin.common.PluginRegistry.ActivityResultListener
    public final boolean onActivityResult(int i, int i3, Intent intent) {
        MethodChannel.Result result;
        if (i == 1276) {
            Integer num = this.f5299j;
            if (num != null && num.intValue() == 1) {
                if (i3 != -1) {
                    if (i3 != 0) {
                        if (i3 == 1 && (result = this.f5298f) != null) {
                            result.error("IN_APP_UPDATE_FAILED", "Some other error prevented either the user from providing consent or the update to proceed.", null);
                        }
                    } else {
                        MethodChannel.Result result2 = this.f5298f;
                        if (result2 != null) {
                            result2.error("USER_DENIED_UPDATE", String.valueOf(i3), null);
                        }
                    }
                } else {
                    MethodChannel.Result result3 = this.f5298f;
                    if (result3 != null) {
                        result3.success(null);
                    }
                }
                this.f5298f = null;
                return true;
            }
            Integer num2 = this.f5299j;
            if (num2 != null && num2.intValue() == 0) {
                if (i3 != 0) {
                    if (i3 == 1) {
                        MethodChannel.Result result4 = this.f5298f;
                        if (result4 != null) {
                            result4.error("IN_APP_UPDATE_FAILED", String.valueOf(i3), null);
                        }
                        this.f5298f = null;
                    }
                } else {
                    MethodChannel.Result result5 = this.f5298f;
                    if (result5 != null) {
                        result5.error("USER_DENIED_UPDATE", String.valueOf(i3), null);
                    }
                    this.f5298f = null;
                }
                return true;
            }
            return false;
        }
        return false;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity activity) {
        Task a2;
        j.e(activity, "activity");
        E1.d dVar = this.f5301l;
        if (dVar != null && (a2 = dVar.a()) != null) {
            a2.addOnSuccessListener(new J0.d(new C0068p(1, this, activity), 22));
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity activity, Bundle outState) {
        j.e(activity, "activity");
        j.e(outState, "outState");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity activity) {
        j.e(activity, "activity");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity activity) {
        j.e(activity, "activity");
    }

    @Override // io.flutter.embedding.engine.plugins.activity.ActivityAware
    public final void onAttachedToActivity(ActivityPluginBinding activityPluginBinding) {
        j.e(activityPluginBinding, "activityPluginBinding");
        this.f5297e = new C0494d(activityPluginBinding);
    }

    @Override // io.flutter.embedding.engine.plugins.FlutterPlugin
    public final void onAttachedToEngine(FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        j.e(flutterPluginBinding, "flutterPluginBinding");
        MethodChannel methodChannel = new MethodChannel(flutterPluginBinding.getBinaryMessenger(), "de.ffuf.in_app_update/methods");
        this.f5293a = methodChannel;
        methodChannel.setMethodCallHandler(this);
        EventChannel eventChannel = new EventChannel(flutterPluginBinding.getBinaryMessenger(), "de.ffuf.in_app_update/stateEvents");
        this.f5294b = eventChannel;
        eventChannel.setStreamHandler(this);
        C0493c c0493c = new C0493c(this, 0);
        this.f5295c = c0493c;
        E1.d dVar = this.f5301l;
        if (dVar != null) {
            dVar.b(c0493c);
        }
    }

    @Override // io.flutter.plugin.common.EventChannel.StreamHandler
    public final void onCancel(Object obj) {
        this.f5296d = null;
    }

    @Override // io.flutter.embedding.engine.plugins.activity.ActivityAware
    public final void onDetachedFromActivity() {
        this.f5297e = null;
    }

    @Override // io.flutter.embedding.engine.plugins.activity.ActivityAware
    public final void onDetachedFromActivityForConfigChanges() {
        this.f5297e = null;
    }

    @Override // io.flutter.embedding.engine.plugins.FlutterPlugin
    public final void onDetachedFromEngine(FlutterPlugin.FlutterPluginBinding binding) {
        j.e(binding, "binding");
        MethodChannel methodChannel = this.f5293a;
        if (methodChannel != null) {
            methodChannel.setMethodCallHandler(null);
            EventChannel eventChannel = this.f5294b;
            if (eventChannel != null) {
                eventChannel.setStreamHandler(null);
                E1.d dVar = this.f5301l;
                if (dVar != null) {
                    C0493c c0493c = this.f5295c;
                    if (c0493c != null) {
                        synchronized (dVar) {
                            E1.c cVar = dVar.f132b;
                            synchronized (cVar) {
                                cVar.f126a.y("unregisterListener", new Object[0]);
                                cVar.f129d.remove(c0493c);
                                cVar.a();
                            }
                        }
                        return;
                    }
                    j.i("installStateUpdatedListener");
                    throw null;
                }
                return;
            }
            j.i("event");
            throw null;
        }
        j.i("channel");
        throw null;
    }

    @Override // io.flutter.plugin.common.EventChannel.StreamHandler
    public final void onListen(Object obj, EventChannel.EventSink eventSink) {
        this.f5296d = eventSink;
    }

    @Override // io.flutter.plugin.common.MethodChannel.MethodCallHandler
    public final void onMethodCall(MethodCall call, final MethodChannel.Result result) {
        Activity activity;
        E1.f fVar;
        Application application;
        j.e(call, "call");
        j.e(result, "result");
        String str = call.method;
        if (str != null) {
            switch (str.hashCode()) {
                case -1873373639:
                    if (str.equals("performImmediateUpdate")) {
                        final int i = 1;
                        a(result, new F2.a(this) { // from class: k2.b

                            /* renamed from: b, reason: collision with root package name */
                            public final /* synthetic */ C0496f f5287b;

                            {
                                this.f5287b = this;
                            }

                            @Override // F2.a
                            public final Object invoke() {
                                switch (i) {
                                    case 0:
                                        C0496f c0496f = this.f5287b;
                                        c0496f.f5299j = 0;
                                        c0496f.f5298f = result;
                                        if (c0496f.f5301l != null) {
                                            E1.a aVar = c0496f.f5300k;
                                            j.b(aVar);
                                            InterfaceC0491a interfaceC0491a = c0496f.f5297e;
                                            j.b(interfaceC0491a);
                                            E1.d.c(aVar, interfaceC0491a.a(), m.a(0));
                                        }
                                        E1.d dVar = c0496f.f5301l;
                                        if (dVar != null) {
                                            dVar.b(new C0493c(c0496f, 1));
                                        }
                                        return C0684i.f6340a;
                                    default:
                                        C0496f c0496f2 = this.f5287b;
                                        c0496f2.f5299j = 1;
                                        c0496f2.f5298f = result;
                                        if (c0496f2.f5301l != null) {
                                            E1.a aVar2 = c0496f2.f5300k;
                                            j.b(aVar2);
                                            InterfaceC0491a interfaceC0491a2 = c0496f2.f5297e;
                                            j.b(interfaceC0491a2);
                                            E1.d.c(aVar2, interfaceC0491a2.a(), m.a(1));
                                        }
                                        return C0684i.f6340a;
                                }
                            }
                        });
                        return;
                    }
                    break;
                case -1541164682:
                    if (str.equals("startFlexibleUpdate")) {
                        final int i3 = 0;
                        a(result, new F2.a(this) { // from class: k2.b

                            /* renamed from: b, reason: collision with root package name */
                            public final /* synthetic */ C0496f f5287b;

                            {
                                this.f5287b = this;
                            }

                            @Override // F2.a
                            public final Object invoke() {
                                switch (i3) {
                                    case 0:
                                        C0496f c0496f = this.f5287b;
                                        c0496f.f5299j = 0;
                                        c0496f.f5298f = result;
                                        if (c0496f.f5301l != null) {
                                            E1.a aVar = c0496f.f5300k;
                                            j.b(aVar);
                                            InterfaceC0491a interfaceC0491a = c0496f.f5297e;
                                            j.b(interfaceC0491a);
                                            E1.d.c(aVar, interfaceC0491a.a(), m.a(0));
                                        }
                                        E1.d dVar = c0496f.f5301l;
                                        if (dVar != null) {
                                            dVar.b(new C0493c(c0496f, 1));
                                        }
                                        return C0684i.f6340a;
                                    default:
                                        C0496f c0496f2 = this.f5287b;
                                        c0496f2.f5299j = 1;
                                        c0496f2.f5298f = result;
                                        if (c0496f2.f5301l != null) {
                                            E1.a aVar2 = c0496f2.f5300k;
                                            j.b(aVar2);
                                            InterfaceC0491a interfaceC0491a2 = c0496f2.f5297e;
                                            j.b(interfaceC0491a2);
                                            E1.d.c(aVar2, interfaceC0491a2.a(), m.a(1));
                                        }
                                        return C0684i.f6340a;
                                }
                            }
                        });
                        return;
                    }
                    break;
                case -1317168438:
                    if (str.equals("checkForUpdate")) {
                        InterfaceC0491a interfaceC0491a = this.f5297e;
                        if (interfaceC0491a != null) {
                            activity = interfaceC0491a.a();
                        } else {
                            activity = null;
                        }
                        if (activity != null) {
                            InterfaceC0491a interfaceC0491a2 = this.f5297e;
                            if (interfaceC0491a2 != null) {
                                interfaceC0491a2.b(this);
                            }
                            InterfaceC0491a interfaceC0491a3 = this.f5297e;
                            if (interfaceC0491a3 != null && (application = interfaceC0491a3.a().getApplication()) != null) {
                                application.registerActivityLifecycleCallbacks(this);
                            }
                            InterfaceC0491a interfaceC0491a4 = this.f5297e;
                            j.b(interfaceC0491a4);
                            Context a2 = interfaceC0491a4.a();
                            synchronized (E1.b.class) {
                                try {
                                    if (E1.b.f125a == null) {
                                        Context applicationContext = a2.getApplicationContext();
                                        if (applicationContext != null) {
                                            a2 = applicationContext;
                                        }
                                        E1.b.f125a = new E1.f(new E1.e(a2, 0));
                                    }
                                    fVar = E1.b.f125a;
                                } catch (Throwable th) {
                                    throw th;
                                }
                            }
                            E1.d dVar = (E1.d) fVar.f135a.zza();
                            this.f5301l = dVar;
                            j.b(dVar);
                            Task a4 = dVar.a();
                            j.d(a4, "getAppUpdateInfo(...)");
                            a4.addOnSuccessListener(new J0.d(new C0068p(2, this, result), 23));
                            a4.addOnFailureListener(new C0230a(4, result));
                            return;
                        }
                        result.error("REQUIRE_FOREGROUND_ACTIVITY", "in_app_update requires a foreground activity", null);
                        throw new IllegalArgumentException("kotlin.Unit");
                    }
                    break;
                case -193504755:
                    if (str.equals("completeFlexibleUpdate")) {
                        a(result, new I1(this, 2));
                        return;
                    }
                    break;
            }
        }
        result.notImplemented();
    }

    @Override // io.flutter.embedding.engine.plugins.activity.ActivityAware
    public final void onReattachedToActivityForConfigChanges(ActivityPluginBinding activityPluginBinding) {
        j.e(activityPluginBinding, "activityPluginBinding");
        this.f5297e = new C0495e(activityPluginBinding);
    }
}
