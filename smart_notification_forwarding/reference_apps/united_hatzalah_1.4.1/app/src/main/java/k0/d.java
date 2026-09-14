package K0;

import F0.G1;
import G0.k;
import G0.l;
import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import androidx.lifecycle.EnumC0303m;
import androidx.lifecycle.InterfaceC0309t;
import androidx.lifecycle.r;
import com.google.firebase.messaging.Constants;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.j;

/* loaded from: classes.dex */
public final class d implements MethodChannel.MethodCallHandler, r {

    /* renamed from: a, reason: collision with root package name */
    public Context f1070a;

    /* renamed from: b, reason: collision with root package name */
    public MethodChannel f1071b;

    /* renamed from: c, reason: collision with root package name */
    public J0.e f1072c;

    /* renamed from: d, reason: collision with root package name */
    public final HandlerThread f1073d;

    /* renamed from: e, reason: collision with root package name */
    public final Handler f1074e;

    /* renamed from: f, reason: collision with root package name */
    public final Handler f1075f;

    /* renamed from: j, reason: collision with root package name */
    public Activity f1076j;

    /* renamed from: k, reason: collision with root package name */
    public final G1 f1077k;

    public d() {
        HandlerThread handlerThread = new HandlerThread("BackgroundThread");
        handlerThread.start();
        this.f1073d = handlerThread;
        this.f1074e = new Handler(handlerThread.getLooper());
        this.f1075f = new Handler(Looper.getMainLooper());
        this.f1077k = new G1(this, 5);
    }

    @Override // androidx.lifecycle.r
    public final void a(InterfaceC0309t interfaceC0309t, EnumC0303m enumC0303m) {
        if (c.f1069a[enumC0303m.ordinal()] == 1 && this.f1070a != null) {
            this.f1073d.quitSafely();
        }
    }

    @Override // io.flutter.plugin.common.MethodChannel.MethodCallHandler
    public final void onMethodCall(MethodCall call, MethodChannel.Result result) {
        j.e(call, "call");
        j.e(result, "result");
        String str = call.method;
        if (str != null) {
            switch (str.hashCode()) {
                case -1654809429:
                    if (str.equals("addToWhitelist")) {
                        try {
                            String str2 = (String) call.argument(RemoteConfigConstants.RequestFieldKey.PACKAGE_NAME);
                            Context context = this.f1070a;
                            if (context != null) {
                                if (str2 != null) {
                                    k.a(context, str2);
                                }
                                result.success(null);
                                return;
                            }
                            throw new IllegalStateException("Unable to add package to whitelist - context is null");
                        } catch (Throwable th) {
                            result.error(th.getClass().getName(), th.getMessage(), null);
                            return;
                        }
                    }
                    break;
                case -895975524:
                    if (str.equals("isScreenCaptureBlocked")) {
                        try {
                            int i = k.f826f;
                            result.success(Boolean.valueOf(k.f824d));
                            return;
                        } catch (Throwable th2) {
                            result.error(th2.getClass().getName(), th2.getMessage(), null);
                            return;
                        }
                    }
                    break;
                case -664623638:
                    if (str.equals("removeExternalId")) {
                        try {
                            Context context2 = this.f1070a;
                            if (context2 != null) {
                                k.g(context2);
                                result.success(null);
                                return;
                            }
                            throw new IllegalStateException("Unable to remove external ID - context is null");
                        } catch (Throwable th3) {
                            result.error(th3.getClass().getName(), th3.getMessage(), null);
                            return;
                        }
                    }
                    break;
                case -533232211:
                    if (str.equals("blockScreenCapture")) {
                        try {
                            Boolean bool = (Boolean) call.argument("enable");
                            if (bool != null) {
                                boolean booleanValue = bool.booleanValue();
                                Activity activity = this.f1076j;
                                if (activity != null) {
                                    k.c(activity, booleanValue);
                                    result.success(null);
                                    return;
                                }
                                throw new IllegalStateException("Unable to block screen capture - context is null");
                            }
                            throw new NullPointerException("Enable flag cannot be null.");
                        } catch (Throwable th4) {
                            result.error(th4.getClass().getName(), th4.getMessage(), null);
                            return;
                        }
                    }
                    break;
                case 109757538:
                    if (str.equals("start")) {
                        try {
                            l z3 = E1.b.z((String) call.argument("config"));
                            Context context3 = this.f1070a;
                            if (context3 != null) {
                                g.a(context3, z3);
                                result.success(null);
                                return;
                            }
                            throw new IllegalStateException("Unable to run Talsec - context is null");
                        } catch (Throwable th5) {
                            result.error(th5.getClass().getName(), th5.getMessage(), null);
                            return;
                        }
                    }
                    break;
                case 242576900:
                    if (str.equals("getAppIcon")) {
                        try {
                            String str3 = (String) call.argument(RemoteConfigConstants.RequestFieldKey.PACKAGE_NAME);
                            if (str3 != null) {
                                this.f1074e.post(new b(this, str3, result, 0));
                                return;
                            }
                            throw new NullPointerException("Package name cannot be null.");
                        } catch (Throwable th6) {
                            result.error(th6.getClass().getName(), th6.getMessage(), null);
                            return;
                        }
                    }
                    break;
                case 1572312583:
                    if (str.equals("storeExternalId")) {
                        try {
                            Context context4 = this.f1070a;
                            if (context4 != null) {
                                String str4 = (String) call.argument(Constants.ScionAnalytics.MessageType.DATA_MESSAGE);
                                if (str4 != null) {
                                    G0.c i3 = k.i(context4, str4);
                                    j.d(i3, "storeExternalId(...)");
                                    if (i3 instanceof G0.b) {
                                        result.success(null);
                                        return;
                                    } else {
                                        if (i3 instanceof G0.a) {
                                            result.error("external-id-failure", ((G0.a) i3).f798a, null);
                                            return;
                                        }
                                        throw new NoWhenBranchMatchedException();
                                    }
                                }
                                throw new NullPointerException("External ID data cannot be null.");
                            }
                            throw new IllegalStateException("Unable to store external ID - context is null");
                        } catch (Throwable th7) {
                            result.error(th7.getClass().getName(), th7.getMessage(), null);
                            return;
                        }
                    }
                    break;
            }
        }
        result.notImplemented();
    }
}
