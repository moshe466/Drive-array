package m;

import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import java.lang.reflect.Method;

/* renamed from: m.s0, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0568s0 {

    /* renamed from: a, reason: collision with root package name */
    public static final Method f5768a;

    /* renamed from: b, reason: collision with root package name */
    public static final Method f5769b;

    /* renamed from: c, reason: collision with root package name */
    public static final Method f5770c;

    /* renamed from: d, reason: collision with root package name */
    public static final boolean f5771d;

    static {
        try {
            Class cls = Integer.TYPE;
            Class cls2 = Boolean.TYPE;
            Class cls3 = Float.TYPE;
            Method declaredMethod = AbsListView.class.getDeclaredMethod("positionSelector", cls, View.class, cls2, cls3, cls3);
            f5768a = declaredMethod;
            declaredMethod.setAccessible(true);
            Method declaredMethod2 = AdapterView.class.getDeclaredMethod("setSelectedPositionInt", cls);
            f5769b = declaredMethod2;
            declaredMethod2.setAccessible(true);
            Method declaredMethod3 = AdapterView.class.getDeclaredMethod("setNextSelectedPositionInt", cls);
            f5770c = declaredMethod3;
            declaredMethod3.setAccessible(true);
            f5771d = true;
        } catch (NoSuchMethodException e4) {
            e4.printStackTrace();
        }
    }
}
