package C0;

import C0.g;
import C0.k;
import F0.C0035g2;
import F0.b3;
import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.os.IBinder;
import android.view.Window;
import android.view.WindowManager;
import androidx.window.layout.adapter.sidecar.DistinctElementSidecarCallback;
import androidx.window.sidecar.SidecarDeviceState;
import androidx.window.sidecar.SidecarDisplayFeature;
import androidx.window.sidecar.SidecarInterface;
import androidx.window.sidecar.SidecarWindowLayoutInfo;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.WeakHashMap;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.jvm.internal.j;
import t2.C0716r;
import x.InterfaceC0776g;

/* loaded from: classes.dex */
public final class k implements a {

    /* renamed from: a, reason: collision with root package name */
    public final SidecarInterface f95a;

    /* renamed from: b, reason: collision with root package name */
    public final g f96b;

    /* renamed from: c, reason: collision with root package name */
    public final LinkedHashMap f97c;

    /* renamed from: d, reason: collision with root package name */
    public final LinkedHashMap f98d;

    /* renamed from: e, reason: collision with root package name */
    public b3 f99e;

    public k(Context context) {
        kotlin.jvm.internal.j.e(context, "context");
        SidecarInterface a2 = i.a(context);
        g gVar = new g();
        this.f95a = a2;
        this.f96b = gVar;
        this.f97c = new LinkedHashMap();
        this.f98d = new LinkedHashMap();
    }

    public final z0.j a(Activity activity) {
        IBinder iBinder;
        SidecarDeviceState sidecarDeviceState;
        WindowManager.LayoutParams attributes;
        Window window = activity.getWindow();
        SidecarWindowLayoutInfo sidecarWindowLayoutInfo = null;
        if (window != null && (attributes = window.getAttributes()) != null) {
            iBinder = attributes.token;
        } else {
            iBinder = null;
        }
        if (iBinder == null) {
            return new z0.j(C0716r.f6476a);
        }
        SidecarInterface sidecarInterface = this.f95a;
        if (sidecarInterface != null) {
            sidecarWindowLayoutInfo = sidecarInterface.getWindowLayoutInfo(iBinder);
        }
        SidecarInterface sidecarInterface2 = this.f95a;
        if (sidecarInterface2 == null || (sidecarDeviceState = sidecarInterface2.getDeviceState()) == null) {
            sidecarDeviceState = new SidecarDeviceState();
        }
        return this.f96b.d(sidecarWindowLayoutInfo, sidecarDeviceState);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void b(Activity activity) {
        IBinder iBinder;
        boolean z3;
        SidecarInterface sidecarInterface;
        WindowManager.LayoutParams attributes;
        Window window = activity.getWindow();
        if (window != null && (attributes = window.getAttributes()) != null) {
            iBinder = attributes.token;
        } else {
            iBinder = null;
        }
        if (iBinder != null) {
            SidecarInterface sidecarInterface2 = this.f95a;
            if (sidecarInterface2 != null) {
                sidecarInterface2.onWindowLayoutChangeListenerRemoved(iBinder);
            }
            LinkedHashMap linkedHashMap = this.f98d;
            I.a aVar = (I.a) linkedHashMap.get(activity);
            if (aVar != null) {
                if (activity instanceof InterfaceC0776g) {
                    ((InterfaceC0776g) activity).removeOnConfigurationChangedListener(aVar);
                }
                linkedHashMap.remove(activity);
            }
            b3 b3Var = this.f99e;
            if (b3Var != null) {
                ReentrantLock reentrantLock = (ReentrantLock) b3Var.f470c;
                reentrantLock.lock();
                try {
                    ((WeakHashMap) b3Var.f471d).put(activity, null);
                } finally {
                    reentrantLock.unlock();
                }
            }
            LinkedHashMap linkedHashMap2 = this.f97c;
            if (linkedHashMap2.size() == 1) {
                z3 = true;
            } else {
                z3 = false;
            }
            linkedHashMap2.remove(iBinder);
            if (z3 && (sidecarInterface = this.f95a) != null) {
                sidecarInterface.onDeviceStateListenersChanged(true);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void c(IBinder iBinder, final Activity activity) {
        SidecarInterface sidecarInterface;
        LinkedHashMap linkedHashMap = this.f97c;
        linkedHashMap.put(iBinder, activity);
        SidecarInterface sidecarInterface2 = this.f95a;
        if (sidecarInterface2 != null) {
            sidecarInterface2.onWindowLayoutChangeListenerAdded(iBinder);
        }
        if (linkedHashMap.size() == 1 && (sidecarInterface = this.f95a) != null) {
            sidecarInterface.onDeviceStateListenersChanged(false);
        }
        b3 b3Var = this.f99e;
        if (b3Var != null) {
            b3Var.u(activity, a(activity));
        }
        LinkedHashMap linkedHashMap2 = this.f98d;
        if (linkedHashMap2.get(activity) == null && (activity instanceof InterfaceC0776g)) {
            I.a aVar = new I.a() { // from class: C0.h
                @Override // I.a, androidx.window.extensions.core.util.function.Consumer
                public final void accept(Object obj) {
                    k this$0 = k.this;
                    kotlin.jvm.internal.j.e(this$0, "this$0");
                    Activity activity2 = activity;
                    kotlin.jvm.internal.j.e(activity2, "$activity");
                    b3 b3Var2 = this$0.f99e;
                    if (b3Var2 != null) {
                        b3Var2.u(activity2, this$0.a(activity2));
                    }
                }
            };
            linkedHashMap2.put(activity, aVar);
            ((InterfaceC0776g) activity).addOnConfigurationChangedListener(aVar);
        }
    }

    public final void d(C0035g2 c0035g2) {
        this.f99e = new b3(c0035g2);
        SidecarInterface sidecarInterface = this.f95a;
        if (sidecarInterface != null) {
            sidecarInterface.setSidecarCallback(new DistinctElementSidecarCallback(this.f96b, new SidecarInterface.SidecarCallback() { // from class: androidx.window.layout.adapter.sidecar.SidecarCompat$TranslatingCallback
                public void onDeviceStateChanged(SidecarDeviceState newDeviceState) {
                    IBinder iBinder;
                    SidecarInterface sidecarInterface2;
                    Window window;
                    WindowManager.LayoutParams attributes;
                    j.e(newDeviceState, "newDeviceState");
                    Collection<Activity> values = k.this.f97c.values();
                    k kVar = k.this;
                    for (Activity activity : values) {
                        SidecarWindowLayoutInfo sidecarWindowLayoutInfo = null;
                        if (activity != null && (window = activity.getWindow()) != null && (attributes = window.getAttributes()) != null) {
                            iBinder = attributes.token;
                        } else {
                            iBinder = null;
                        }
                        if (iBinder != null && (sidecarInterface2 = kVar.f95a) != null) {
                            sidecarWindowLayoutInfo = sidecarInterface2.getWindowLayoutInfo(iBinder);
                        }
                        b3 b3Var = kVar.f99e;
                        if (b3Var != null) {
                            b3Var.u(activity, kVar.f96b.d(sidecarWindowLayoutInfo, newDeviceState));
                        }
                    }
                }

                public void onWindowLayoutChanged(IBinder windowToken, SidecarWindowLayoutInfo newLayout) {
                    SidecarDeviceState sidecarDeviceState;
                    j.e(windowToken, "windowToken");
                    j.e(newLayout, "newLayout");
                    Activity activity = (Activity) k.this.f97c.get(windowToken);
                    if (activity != null) {
                        k kVar = k.this;
                        g gVar = kVar.f96b;
                        SidecarInterface sidecarInterface2 = kVar.f95a;
                        if (sidecarInterface2 == null || (sidecarDeviceState = sidecarInterface2.getDeviceState()) == null) {
                            sidecarDeviceState = new SidecarDeviceState();
                        }
                        z0.j d2 = gVar.d(newLayout, sidecarDeviceState);
                        b3 b3Var = k.this.f99e;
                        if (b3Var != null) {
                            b3Var.u(activity, d2);
                        }
                    }
                }
            }));
        }
    }

    public final boolean e() {
        Method method;
        Class<?> cls;
        Method method2;
        Class<?> cls2;
        Method method3;
        Class<?> cls3;
        Method method4;
        Class<?> cls4;
        Class<?> cls5;
        Class<?> cls6;
        Class<?> cls7;
        Class<?> cls8;
        try {
            SidecarInterface sidecarInterface = this.f95a;
            if (sidecarInterface != null && (cls8 = sidecarInterface.getClass()) != null) {
                method = cls8.getMethod("setSidecarCallback", SidecarInterface.SidecarCallback.class);
            } else {
                method = null;
            }
            if (method != null) {
                cls = method.getReturnType();
            } else {
                cls = null;
            }
            Class cls9 = Void.TYPE;
            if (kotlin.jvm.internal.j.a(cls, cls9)) {
                SidecarInterface sidecarInterface2 = this.f95a;
                if (sidecarInterface2 != null) {
                    sidecarInterface2.getDeviceState();
                }
                SidecarInterface sidecarInterface3 = this.f95a;
                if (sidecarInterface3 != null) {
                    sidecarInterface3.onDeviceStateListenersChanged(true);
                }
                SidecarInterface sidecarInterface4 = this.f95a;
                if (sidecarInterface4 != null && (cls7 = sidecarInterface4.getClass()) != null) {
                    method2 = cls7.getMethod("getWindowLayoutInfo", IBinder.class);
                } else {
                    method2 = null;
                }
                if (method2 != null) {
                    cls2 = method2.getReturnType();
                } else {
                    cls2 = null;
                }
                if (kotlin.jvm.internal.j.a(cls2, SidecarWindowLayoutInfo.class)) {
                    SidecarInterface sidecarInterface5 = this.f95a;
                    if (sidecarInterface5 != null && (cls6 = sidecarInterface5.getClass()) != null) {
                        method3 = cls6.getMethod("onWindowLayoutChangeListenerAdded", IBinder.class);
                    } else {
                        method3 = null;
                    }
                    if (method3 != null) {
                        cls3 = method3.getReturnType();
                    } else {
                        cls3 = null;
                    }
                    if (kotlin.jvm.internal.j.a(cls3, cls9)) {
                        SidecarInterface sidecarInterface6 = this.f95a;
                        if (sidecarInterface6 != null && (cls5 = sidecarInterface6.getClass()) != null) {
                            method4 = cls5.getMethod("onWindowLayoutChangeListenerRemoved", IBinder.class);
                        } else {
                            method4 = null;
                        }
                        if (method4 != null) {
                            cls4 = method4.getReturnType();
                        } else {
                            cls4 = null;
                        }
                        if (kotlin.jvm.internal.j.a(cls4, cls9)) {
                            SidecarDeviceState sidecarDeviceState = new SidecarDeviceState();
                            try {
                                sidecarDeviceState.posture = 3;
                            } catch (NoSuchFieldError unused) {
                                SidecarDeviceState.class.getMethod("setPosture", Integer.TYPE).invoke(sidecarDeviceState, 3);
                                Object invoke = SidecarDeviceState.class.getMethod("getPosture", null).invoke(sidecarDeviceState, null);
                                kotlin.jvm.internal.j.c(invoke, "null cannot be cast to non-null type kotlin.Int");
                                if (((Integer) invoke).intValue() != 3) {
                                    throw new Exception("Invalid device posture getter/setter");
                                }
                            }
                            SidecarDisplayFeature sidecarDisplayFeature = new SidecarDisplayFeature();
                            Rect rect = sidecarDisplayFeature.getRect();
                            kotlin.jvm.internal.j.d(rect, "displayFeature.rect");
                            sidecarDisplayFeature.setRect(rect);
                            sidecarDisplayFeature.getType();
                            sidecarDisplayFeature.setType(1);
                            SidecarWindowLayoutInfo sidecarWindowLayoutInfo = new SidecarWindowLayoutInfo();
                            try {
                                List list = sidecarWindowLayoutInfo.displayFeatures;
                                return true;
                            } catch (NoSuchFieldError unused2) {
                                ArrayList arrayList = new ArrayList();
                                arrayList.add(sidecarDisplayFeature);
                                SidecarWindowLayoutInfo.class.getMethod("setDisplayFeatures", List.class).invoke(sidecarWindowLayoutInfo, arrayList);
                                Object invoke2 = SidecarWindowLayoutInfo.class.getMethod("getDisplayFeatures", null).invoke(sidecarWindowLayoutInfo, null);
                                kotlin.jvm.internal.j.c(invoke2, "null cannot be cast to non-null type kotlin.collections.List<androidx.window.sidecar.SidecarDisplayFeature>");
                                if (arrayList.equals((List) invoke2)) {
                                    return true;
                                }
                                throw new Exception("Invalid display feature getter/setter");
                            }
                        }
                        throw new NoSuchMethodException("Illegal return type for 'onWindowLayoutChangeListenerRemoved': " + cls4);
                    }
                    throw new NoSuchMethodException("Illegal return type for 'onWindowLayoutChangeListenerAdded': " + cls3);
                }
                throw new NoSuchMethodException("Illegal return type for 'getWindowLayoutInfo': " + cls2);
            }
            throw new NoSuchMethodException("Illegal return type for 'setSidecarCallback': " + cls);
        } catch (Throwable unused3) {
            return false;
        }
    }
}
