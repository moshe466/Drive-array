package z0;

import a.AbstractC0228a;
import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import androidx.window.extensions.core.util.function.Consumer;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import kotlin.jvm.internal.s;

/* loaded from: classes.dex */
public final class d extends kotlin.jvm.internal.k implements F2.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6820a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ e f6821b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ d(e eVar, int i) {
        super(0);
        this.f6820a = i;
        this.f6821b = eVar;
    }

    @Override // F2.a
    public final Object invoke() {
        boolean z3;
        Class cls;
        boolean z4;
        boolean z5;
        boolean z6;
        switch (this.f6820a) {
            case 0:
                Class<?> loadClass = this.f6821b.f6822a.loadClass("androidx.window.extensions.layout.FoldingFeature");
                kotlin.jvm.internal.j.d(loadClass, "loader.loadClass(FOLDING_FEATURE_CLASS)");
                Method getBoundsMethod = loadClass.getMethod("getBounds", null);
                Method getTypeMethod = loadClass.getMethod("getType", null);
                Method getStateMethod = loadClass.getMethod("getState", null);
                kotlin.jvm.internal.j.d(getBoundsMethod, "getBoundsMethod");
                if (getBoundsMethod.getReturnType().equals(AbstractC0228a.s(s.a(Rect.class))) && Modifier.isPublic(getBoundsMethod.getModifiers())) {
                    kotlin.jvm.internal.j.d(getTypeMethod, "getTypeMethod");
                    Class cls2 = Integer.TYPE;
                    if (getTypeMethod.getReturnType().equals(AbstractC0228a.s(s.a(cls2))) && Modifier.isPublic(getTypeMethod.getModifiers())) {
                        kotlin.jvm.internal.j.d(getStateMethod, "getStateMethod");
                        if (getStateMethod.getReturnType().equals(AbstractC0228a.s(s.a(cls2))) && Modifier.isPublic(getStateMethod.getModifiers())) {
                            z3 = true;
                            return Boolean.valueOf(z3);
                        }
                    }
                }
                z3 = false;
                return Boolean.valueOf(z3);
            case 1:
                e eVar = this.f6821b;
                try {
                    cls = eVar.f6823b.v();
                } catch (ClassNotFoundException unused) {
                    cls = null;
                }
                if (cls == null) {
                    return Boolean.FALSE;
                }
                Class<?> loadClass2 = eVar.f6822a.loadClass("androidx.window.extensions.layout.WindowLayoutComponent");
                kotlin.jvm.internal.j.d(loadClass2, "loader.loadClass(WINDOW_LAYOUT_COMPONENT_CLASS)");
                Method addListenerMethod = loadClass2.getMethod("addWindowLayoutInfoListener", Activity.class, cls);
                Method removeListenerMethod = loadClass2.getMethod("removeWindowLayoutInfoListener", cls);
                kotlin.jvm.internal.j.d(addListenerMethod, "addListenerMethod");
                if (Modifier.isPublic(addListenerMethod.getModifiers())) {
                    kotlin.jvm.internal.j.d(removeListenerMethod, "removeListenerMethod");
                    if (Modifier.isPublic(removeListenerMethod.getModifiers())) {
                        z4 = true;
                        return Boolean.valueOf(z4);
                    }
                }
                z4 = false;
                return Boolean.valueOf(z4);
            case 2:
                Class<?> loadClass3 = this.f6821b.f6822a.loadClass("androidx.window.extensions.layout.WindowLayoutComponent");
                kotlin.jvm.internal.j.d(loadClass3, "loader.loadClass(WINDOW_LAYOUT_COMPONENT_CLASS)");
                Method addListenerMethod2 = loadClass3.getMethod("addWindowLayoutInfoListener", Context.class, Consumer.class);
                Method removeListenerMethod2 = loadClass3.getMethod("removeWindowLayoutInfoListener", Consumer.class);
                kotlin.jvm.internal.j.d(addListenerMethod2, "addListenerMethod");
                if (Modifier.isPublic(addListenerMethod2.getModifiers())) {
                    kotlin.jvm.internal.j.d(removeListenerMethod2, "removeListenerMethod");
                    if (Modifier.isPublic(removeListenerMethod2.getModifiers())) {
                        z5 = true;
                        return Boolean.valueOf(z5);
                    }
                }
                z5 = false;
                return Boolean.valueOf(z5);
            default:
                e eVar2 = this.f6821b;
                Class<?> loadClass4 = ((ClassLoader) eVar2.f6824c.f218b).loadClass("androidx.window.extensions.WindowExtensions");
                kotlin.jvm.internal.j.d(loadClass4, "loader.loadClass(WindowE….WINDOW_EXTENSIONS_CLASS)");
                Method getWindowLayoutComponentMethod = loadClass4.getMethod("getWindowLayoutComponent", null);
                Class<?> loadClass5 = eVar2.f6822a.loadClass("androidx.window.extensions.layout.WindowLayoutComponent");
                kotlin.jvm.internal.j.d(loadClass5, "loader.loadClass(WINDOW_LAYOUT_COMPONENT_CLASS)");
                kotlin.jvm.internal.j.d(getWindowLayoutComponentMethod, "getWindowLayoutComponentMethod");
                if (Modifier.isPublic(getWindowLayoutComponentMethod.getModifiers()) && getWindowLayoutComponentMethod.getReturnType().equals(loadClass5)) {
                    z6 = true;
                } else {
                    z6 = false;
                }
                return Boolean.valueOf(z6);
        }
    }
}
