package o1;

import F0.I1;
import F0.Q2;
import F0.RunnableC0064o;
import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.RenderEffect;
import android.graphics.Shader;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.provider.MediaStore;
import android.renderscript.Allocation;
import android.renderscript.Element;
import android.renderscript.RenderScript;
import android.renderscript.ScriptIntrinsicBlur;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import c.k;
import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.embedding.engine.plugins.activity.ActivityAware;
import io.flutter.embedding.engine.plugins.activity.ActivityPluginBinding;
import io.flutter.plugin.common.EventChannel;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.function.Consumer;
import s2.C0682g;

/* loaded from: classes.dex */
public final class j implements FlutterPlugin, MethodChannel.MethodCallHandler, ActivityAware, EventChannel.StreamHandler {

    /* renamed from: a, reason: collision with root package name */
    public MethodChannel f5931a;

    /* renamed from: b, reason: collision with root package name */
    public Context f5932b;

    /* renamed from: c, reason: collision with root package name */
    public Activity f5933c;

    /* renamed from: e, reason: collision with root package name */
    public P.a f5935e;

    /* renamed from: j, reason: collision with root package name */
    public EventChannel.EventSink f5937j;

    /* renamed from: l, reason: collision with root package name */
    public boolean f5939l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f5940m;

    /* renamed from: n, reason: collision with root package name */
    public boolean f5941n;

    /* renamed from: o, reason: collision with root package name */
    public boolean f5942o;
    public ImageView p;

    /* renamed from: q, reason: collision with root package name */
    public View f5943q;

    /* renamed from: r, reason: collision with root package name */
    public View f5944r;

    /* renamed from: u, reason: collision with root package name */
    public h f5947u;

    /* renamed from: v, reason: collision with root package name */
    public boolean f5948v;

    /* renamed from: w, reason: collision with root package name */
    public boolean f5949w;

    /* renamed from: x, reason: collision with root package name */
    public g f5950x;
    public f y;

    /* renamed from: d, reason: collision with root package name */
    public final C0682g f5934d = T.b.A(new I1(this, 3));

    /* renamed from: f, reason: collision with root package name */
    public final Handler f5936f = new Handler(Looper.getMainLooper());

    /* renamed from: k, reason: collision with root package name */
    public String f5938k = "";

    /* renamed from: s, reason: collision with root package name */
    public float f5945s = 30.0f;

    /* renamed from: t, reason: collision with root package name */
    public int f5946t = -16777216;

    /* renamed from: z, reason: collision with root package name */
    public final i f5951z = new i(this);

    public static final void a(final j jVar, final Activity activity) {
        Window window;
        final View decorView;
        if (jVar.f5943q == null && (window = activity.getWindow()) != null && (decorView = window.getDecorView()) != null) {
            final float f4 = jVar.f5945s;
            if (f4 < 0.1f) {
                f4 = 0.1f;
            }
            if (Build.VERSION.SDK_INT >= 31) {
                activity.runOnUiThread(new Runnable() { // from class: o1.c
                    @Override // java.lang.Runnable
                    public final void run() {
                        RenderEffect createBlurEffect;
                        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
                        float f5 = f4;
                        createBlurEffect = RenderEffect.createBlurEffect(f5, f5, Shader.TileMode.CLAMP);
                        View view = decorView;
                        view.setRenderEffect(createBlurEffect);
                        jVar.f5943q = view;
                    }
                });
            } else {
                activity.runOnUiThread(new Runnable() { // from class: o1.d
                    @Override // java.lang.Runnable
                    public final void run() {
                        ViewGroup viewGroup;
                        View view = decorView;
                        int width = view.getWidth();
                        int height = view.getHeight();
                        if (width > 0 && height > 0) {
                            Bitmap createBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
                            kotlin.jvm.internal.j.d(createBitmap, "createBitmap(...)");
                            view.draw(new Canvas(createBitmap));
                            Activity activity2 = activity;
                            RenderScript create = RenderScript.create(activity2);
                            Allocation createFromBitmap = Allocation.createFromBitmap(create, createBitmap);
                            Allocation createTyped = Allocation.createTyped(create, createFromBitmap.getType());
                            ScriptIntrinsicBlur create2 = ScriptIntrinsicBlur.create(create, Element.U8_4(create));
                            float f5 = f4;
                            if (f5 > 25.0f) {
                                f5 = 25.0f;
                            }
                            create2.setRadius(f5);
                            create2.setInput(createFromBitmap);
                            create2.forEach(createTyped);
                            createTyped.copyTo(createBitmap);
                            create2.destroy();
                            createFromBitmap.destroy();
                            createTyped.destroy();
                            create.destroy();
                            ImageView imageView = new ImageView(activity2);
                            imageView.setImageBitmap(createBitmap);
                            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
                            imageView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
                            if (view instanceof ViewGroup) {
                                viewGroup = (ViewGroup) view;
                            } else {
                                viewGroup = null;
                            }
                            if (viewGroup != null) {
                                viewGroup.addView(imageView);
                            }
                            jVar.f5943q = imageView;
                        }
                    }
                });
            }
        }
    }

    public static final void b(j jVar, Activity activity) {
        int identifier;
        if (jVar.p != null || (identifier = activity.getResources().getIdentifier("no_screenshot_image", "drawable", activity.getPackageName())) == 0) {
            return;
        }
        activity.runOnUiThread(new k(activity, jVar, identifier));
    }

    public static void n(j jVar, long j2, int i) {
        if ((i & 2) != 0) {
            j2 = 0;
        }
        jVar.getClass();
        String str = "";
        new Handler(Looper.getMainLooper()).postDelayed(new io.flutter.embedding.android.c(jVar, str, j2, "", 2), 100L);
    }

    public final SharedPreferences c() {
        Object a2 = this.f5934d.a();
        kotlin.jvm.internal.j.d(a2, "getValue(...)");
        return (SharedPreferences) a2;
    }

    /* JADX WARN: Type inference failed for: r1v3, types: [o1.g] */
    /* JADX WARN: Type inference failed for: r1v5, types: [o1.f] */
    public final void d() {
        Activity activity;
        Executor mainExecutor;
        Executor mainExecutor2;
        int addScreenRecordingCallback;
        int i = Build.VERSION.SDK_INT;
        if (i >= 35) {
            Activity activity2 = this.f5933c;
            if (activity2 != null && this.y == null) {
                ?? r12 = new Consumer() { // from class: o1.f
                    /* JADX WARN: Code restructure failed: missing block: B:4:0x000e, code lost:
                    
                        if (r4.intValue() == 1) goto L9;
                     */
                    @Override // java.util.function.Consumer
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                        To view partially-correct add '--show-bad-code' argument
                    */
                    public final void accept(java.lang.Object r4) {
                        /*
                            r3 = this;
                            java.lang.Integer r4 = (java.lang.Integer) r4
                            o1.j r0 = o1.j.this
                            boolean r1 = r0.f5948v
                            if (r4 != 0) goto L9
                            goto L11
                        L9:
                            int r4 = r4.intValue()
                            r2 = 1
                            if (r4 != r2) goto L11
                            goto L12
                        L11:
                            r2 = 0
                        L12:
                            r0.f5948v = r2
                            if (r2 == r1) goto L1e
                            long r1 = java.lang.System.currentTimeMillis()
                            r4 = 4
                            o1.j.n(r0, r1, r4)
                        L1e:
                            return
                        */
                        throw new UnsupportedOperationException("Method not decompiled: o1.f.accept(java.lang.Object):void");
                    }
                };
                WindowManager windowManager = activity2.getWindowManager();
                mainExecutor2 = activity2.getMainExecutor();
                addScreenRecordingCallback = windowManager.addScreenRecordingCallback(mainExecutor2, r12);
                this.y = r12;
                boolean z3 = this.f5948v;
                boolean z4 = true;
                if (addScreenRecordingCallback != 1) {
                    z4 = false;
                }
                this.f5948v = z4;
                if (z4 != z3) {
                    n(this, System.currentTimeMillis(), 4);
                    return;
                }
                return;
            }
            return;
        }
        if (i >= 34 && i >= 34 && (activity = this.f5933c) != null && this.f5950x == null) {
            ?? r13 = new Activity.ScreenCaptureCallback() { // from class: o1.g
                @Override // android.app.Activity.ScreenCaptureCallback
                public final void onScreenCaptured() {
                    j jVar = j.this;
                    jVar.f5948v = true;
                    j.n(jVar, System.currentTimeMillis(), 4);
                }
            };
            mainExecutor = activity.getMainExecutor();
            activity.registerScreenCaptureCallback(mainExecutor, r13);
            this.f5950x = r13;
        }
    }

    public final void e() {
        ViewGroup viewGroup;
        View view = this.f5943q;
        if (view == null) {
            return;
        }
        Activity activity = this.f5933c;
        if (activity != null) {
            activity.runOnUiThread(new e(view, activity, this));
            return;
        }
        if (Build.VERSION.SDK_INT >= 31) {
            view.setRenderEffect(null);
        } else {
            ViewParent parent = view.getParent();
            if (parent instanceof ViewGroup) {
                viewGroup = (ViewGroup) parent;
            } else {
                viewGroup = null;
            }
            if (viewGroup != null) {
                viewGroup.removeView(view);
            }
        }
        this.f5943q = null;
    }

    public final void f() {
        ViewGroup viewGroup;
        View view = this.f5944r;
        if (view == null) {
            return;
        }
        Activity activity = this.f5933c;
        if (activity != null) {
            activity.runOnUiThread(new RunnableC0064o(16, view, this));
            return;
        }
        ViewParent parent = view.getParent();
        if (parent instanceof ViewGroup) {
            viewGroup = (ViewGroup) parent;
        } else {
            viewGroup = null;
        }
        if (viewGroup != null) {
            viewGroup.removeView(view);
        }
        this.f5944r = null;
    }

    public final void g() {
        ViewGroup viewGroup;
        ImageView imageView = this.p;
        if (imageView == null) {
            return;
        }
        Activity activity = this.f5933c;
        if (activity != null) {
            activity.runOnUiThread(new RunnableC0064o(17, imageView, this));
            return;
        }
        ViewParent parent = imageView.getParent();
        if (parent instanceof ViewGroup) {
            viewGroup = (ViewGroup) parent;
        } else {
            viewGroup = null;
        }
        if (viewGroup != null) {
            viewGroup.removeView(imageView);
        }
        this.p = null;
    }

    public final void h(boolean z3) {
        Executors.newSingleThreadExecutor().execute(new RunnableC0598a(this, z3, 1));
    }

    public final void i(boolean z3) {
        Executors.newSingleThreadExecutor().execute(new RunnableC0598a(this, z3, 2));
    }

    public final void j(boolean z3) {
        Executors.newSingleThreadExecutor().execute(new RunnableC0598a(this, z3, 0));
    }

    public final boolean k() {
        Window window;
        try {
            Activity activity = this.f5933c;
            if (activity != null && (window = activity.getWindow()) != null) {
                window.addFlags(UserMetadata.MAX_INTERNAL_KEY_SIZE);
            }
            Executors.newSingleThreadExecutor().execute(new RunnableC0598a(this, true, 4));
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public final boolean l() {
        Window window;
        try {
            Activity activity = this.f5933c;
            if (activity != null && (window = activity.getWindow()) != null) {
                window.clearFlags(UserMetadata.MAX_INTERNAL_KEY_SIZE);
            }
            Executors.newSingleThreadExecutor().execute(new RunnableC0598a(this, false, 4));
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public final void m() {
        Activity activity;
        Activity activity2;
        int i = Build.VERSION.SDK_INT;
        if (i >= 35 && (activity2 = this.f5933c) != null) {
            f fVar = this.y;
            if (fVar == null) {
                fVar = null;
            }
            if (fVar != null) {
                activity2.getWindowManager().removeScreenRecordingCallback(fVar);
                this.y = null;
            }
        }
        if (i >= 34 && i >= 34 && (activity = this.f5933c) != null) {
            g gVar = this.f5950x;
            if (gVar == null) {
                gVar = null;
            }
            if (gVar != null) {
                activity.unregisterScreenCaptureCallback(gVar);
                this.f5950x = null;
            }
        }
    }

    @Override // io.flutter.embedding.engine.plugins.activity.ActivityAware
    public final void onAttachedToActivity(ActivityPluginBinding binding) {
        kotlin.jvm.internal.j.e(binding, "binding");
        this.f5933c = binding.getActivity();
        Executors.newSingleThreadExecutor().execute(new Q2(this, 14));
        if (this.f5949w) {
            d();
        }
    }

    @Override // io.flutter.embedding.engine.plugins.FlutterPlugin
    public final void onAttachedToEngine(FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        kotlin.jvm.internal.j.e(flutterPluginBinding, "flutterPluginBinding");
        Context applicationContext = flutterPluginBinding.getApplicationContext();
        kotlin.jvm.internal.j.d(applicationContext, "getApplicationContext(...)");
        this.f5932b = applicationContext;
        MethodChannel methodChannel = new MethodChannel(flutterPluginBinding.getBinaryMessenger(), "com.flutterplaza.no_screenshot_methods");
        this.f5931a = methodChannel;
        methodChannel.setMethodCallHandler(this);
        new EventChannel(flutterPluginBinding.getBinaryMessenger(), "com.flutterplaza.no_screenshot_streams").setStreamHandler(this);
        this.f5935e = new P.a(this, new Handler());
        Context context = this.f5932b;
        Application application = null;
        if (context != null) {
            if (context instanceof Application) {
                application = (Application) context;
            }
            if (application == null) {
                return;
            }
            h hVar = new h(this);
            this.f5947u = hVar;
            application.registerActivityLifecycleCallbacks(hVar);
            return;
        }
        kotlin.jvm.internal.j.i("context");
        throw null;
    }

    @Override // io.flutter.plugin.common.EventChannel.StreamHandler
    public final void onCancel(Object obj) {
        this.f5936f.removeCallbacks(this.f5951z);
        this.f5937j = null;
    }

    @Override // io.flutter.embedding.engine.plugins.activity.ActivityAware
    public final void onDetachedFromActivity() {
        m();
        g();
        e();
        f();
        this.f5933c = null;
    }

    @Override // io.flutter.embedding.engine.plugins.activity.ActivityAware
    public final void onDetachedFromActivityForConfigChanges() {
        m();
        g();
        e();
        f();
        this.f5933c = null;
    }

    @Override // io.flutter.embedding.engine.plugins.FlutterPlugin
    public final void onDetachedFromEngine(FlutterPlugin.FlutterPluginBinding binding) {
        Application application;
        kotlin.jvm.internal.j.e(binding, "binding");
        MethodChannel methodChannel = this.f5931a;
        if (methodChannel != null) {
            methodChannel.setMethodCallHandler(null);
            P.a aVar = this.f5935e;
            if (aVar != null) {
                Context context = this.f5932b;
                if (context != null) {
                    context.getContentResolver().unregisterContentObserver(aVar);
                } else {
                    kotlin.jvm.internal.j.i("context");
                    throw null;
                }
            }
            Context context2 = this.f5932b;
            if (context2 != null) {
                if (context2 instanceof Application) {
                    application = (Application) context2;
                } else {
                    application = null;
                }
                if (application == null) {
                    return;
                }
                h hVar = this.f5947u;
                if (hVar != null) {
                    application.unregisterActivityLifecycleCallbacks(hVar);
                }
                this.f5947u = null;
                return;
            }
            kotlin.jvm.internal.j.i("context");
            throw null;
        }
        kotlin.jvm.internal.j.i("methodChannel");
        throw null;
    }

    @Override // io.flutter.plugin.common.EventChannel.StreamHandler
    public final void onListen(Object obj, EventChannel.EventSink eventSink) {
        this.f5937j = eventSink;
        this.f5936f.postDelayed(this.f5951z, 1000L);
    }

    @Override // io.flutter.plugin.common.MethodChannel.MethodCallHandler
    public final void onMethodCall(MethodCall call, MethodChannel.Result result) {
        Window window;
        WindowManager.LayoutParams attributes;
        kotlin.jvm.internal.j.e(call, "call");
        kotlin.jvm.internal.j.e(result, "result");
        String str = call.method;
        if (str != null) {
            double d2 = 30.0d;
            int i = -16777216;
            switch (str.hashCode()) {
                case -1364299705:
                    if (str.equals("toggleScreenshotWithBlur")) {
                        Double d4 = (Double) call.argument("radius");
                        if (d4 != null) {
                            d2 = d4.doubleValue();
                        }
                        final float f4 = (float) d2;
                        boolean z3 = !c().getBoolean("is_blur_overlay_mode_enabled", false);
                        this.f5941n = z3;
                        this.f5945s = f4;
                        h(z3);
                        Executors.newSingleThreadExecutor().execute(new Runnable() { // from class: o1.b
                            @Override // java.lang.Runnable
                            public final void run() {
                                j.this.c().edit().putFloat("blur_radius", f4).apply();
                            }
                        });
                        if (this.f5941n) {
                            if (this.f5940m) {
                                this.f5940m = false;
                                j(false);
                                g();
                            }
                            if (this.f5942o) {
                                this.f5942o = false;
                                i(false);
                                f();
                            }
                            k();
                        } else {
                            l();
                            e();
                        }
                        n(this, 0L, 6);
                        result.success(Boolean.valueOf(this.f5941n));
                        return;
                    }
                    break;
                case -773730843:
                    if (str.equals("screenshotOn")) {
                        Boolean valueOf = Boolean.valueOf(l());
                        n(this, 0L, 6);
                        result.success(valueOf);
                        return;
                    }
                    break;
                case -690182701:
                    if (str.equals("screenshotWithBlur")) {
                        Double d5 = (Double) call.argument("radius");
                        if (d5 != null) {
                            d2 = d5.doubleValue();
                        }
                        final float f5 = (float) d2;
                        this.f5941n = true;
                        this.f5945s = f5;
                        h(true);
                        Executors.newSingleThreadExecutor().execute(new Runnable() { // from class: o1.b
                            @Override // java.lang.Runnable
                            public final void run() {
                                j.this.c().edit().putFloat("blur_radius", f5).apply();
                            }
                        });
                        if (this.f5940m) {
                            this.f5940m = false;
                            j(false);
                            g();
                        }
                        if (this.f5942o) {
                            this.f5942o = false;
                            i(false);
                            f();
                        }
                        k();
                        n(this, 0L, 6);
                        result.success(Boolean.TRUE);
                        return;
                    }
                    break;
                case -402810221:
                    if (str.equals("stopScreenshotListening")) {
                        P.a aVar = this.f5935e;
                        if (aVar != null) {
                            Context context = this.f5932b;
                            if (context != null) {
                                context.getContentResolver().unregisterContentObserver(aVar);
                            } else {
                                kotlin.jvm.internal.j.i("context");
                                throw null;
                            }
                        }
                        n(this, 0L, 6);
                        result.success("Listening stopped");
                        return;
                    }
                    break;
                case 80177015:
                    if (str.equals("screenshotWithColor")) {
                        Integer num = (Integer) call.argument("color");
                        if (num != null) {
                            i = num.intValue();
                        }
                        this.f5942o = true;
                        this.f5946t = i;
                        i(true);
                        Executors.newSingleThreadExecutor().execute(new io.flutter.plugins.imagepicker.b(this, i, 2));
                        if (this.f5940m) {
                            this.f5940m = false;
                            j(false);
                            g();
                        }
                        if (this.f5941n) {
                            this.f5941n = false;
                            h(false);
                            e();
                        }
                        k();
                        n(this, 0L, 6);
                        result.success(Boolean.TRUE);
                        return;
                    }
                    break;
                case 85647727:
                    if (str.equals("screenshotWithImage")) {
                        this.f5940m = true;
                        j(true);
                        if (this.f5941n) {
                            this.f5941n = false;
                            h(false);
                            e();
                        }
                        if (this.f5942o) {
                            this.f5942o = false;
                            i(false);
                            f();
                        }
                        k();
                        n(this, 0L, 6);
                        result.success(Boolean.TRUE);
                        return;
                    }
                    break;
                case 643637624:
                    if (str.equals("stopScreenRecordingListening")) {
                        if (this.f5949w) {
                            this.f5949w = false;
                            m();
                            this.f5948v = false;
                            n(this, 0L, 6);
                        }
                        n(this, 0L, 6);
                        result.success("Recording listening stopped");
                        return;
                    }
                    break;
                case 657386371:
                    if (str.equals("toggleScreenshotWithColor")) {
                        Integer num2 = (Integer) call.argument("color");
                        if (num2 != null) {
                            i = num2.intValue();
                        }
                        boolean z4 = !c().getBoolean("is_color_overlay_mode_enabled", false);
                        this.f5942o = z4;
                        this.f5946t = i;
                        i(z4);
                        Executors.newSingleThreadExecutor().execute(new io.flutter.plugins.imagepicker.b(this, i, 2));
                        if (this.f5942o) {
                            if (this.f5940m) {
                                this.f5940m = false;
                                j(false);
                                g();
                            }
                            if (this.f5941n) {
                                this.f5941n = false;
                                h(false);
                                e();
                            }
                            k();
                        } else {
                            l();
                            f();
                        }
                        n(this, 0L, 6);
                        result.success(Boolean.valueOf(this.f5942o));
                        return;
                    }
                    break;
                case 662857083:
                    if (str.equals("toggleScreenshotWithImage")) {
                        boolean z5 = !c().getBoolean("is_image_overlay_mode_enabled", false);
                        this.f5940m = z5;
                        j(z5);
                        if (this.f5940m) {
                            if (this.f5941n) {
                                this.f5941n = false;
                                h(false);
                                e();
                            }
                            if (this.f5942o) {
                                this.f5942o = false;
                                i(false);
                                f();
                            }
                            k();
                        } else {
                            l();
                            g();
                        }
                        n(this, 0L, 6);
                        result.success(Boolean.valueOf(this.f5940m));
                        return;
                    }
                    break;
                case 793231923:
                    if (str.equals("startScreenshotListening")) {
                        P.a aVar2 = this.f5935e;
                        if (aVar2 != null) {
                            Context context2 = this.f5932b;
                            if (context2 != null) {
                                context2.getContentResolver().registerContentObserver(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, true, aVar2);
                            } else {
                                kotlin.jvm.internal.j.i("context");
                                throw null;
                            }
                        }
                        result.success("Listening started");
                        return;
                    }
                    break;
                case 1583023066:
                    if (str.equals("toggleScreenshot")) {
                        Activity activity = this.f5933c;
                        if (activity != null && (window = activity.getWindow()) != null && (attributes = window.getAttributes()) != null) {
                            if ((attributes.flags & UserMetadata.MAX_INTERNAL_KEY_SIZE) != 0) {
                                l();
                            } else {
                                k();
                            }
                        }
                        Boolean bool = Boolean.TRUE;
                        n(this, 0L, 6);
                        result.success(bool);
                        return;
                    }
                    break;
                case 1784147497:
                    if (str.equals("screenshotOff")) {
                        Boolean valueOf2 = Boolean.valueOf(k());
                        n(this, 0L, 6);
                        result.success(valueOf2);
                        return;
                    }
                    break;
                case 2069544408:
                    if (str.equals("startScreenRecordingListening")) {
                        if (!this.f5949w) {
                            this.f5949w = true;
                            d();
                            n(this, 0L, 6);
                        }
                        result.success("Recording listening started");
                        return;
                    }
                    break;
            }
        }
        result.notImplemented();
    }

    @Override // io.flutter.embedding.engine.plugins.activity.ActivityAware
    public final void onReattachedToActivityForConfigChanges(ActivityPluginBinding binding) {
        kotlin.jvm.internal.j.e(binding, "binding");
        this.f5933c = binding.getActivity();
        Executors.newSingleThreadExecutor().execute(new Q2(this, 14));
        if (this.f5949w) {
            d();
        }
    }
}
