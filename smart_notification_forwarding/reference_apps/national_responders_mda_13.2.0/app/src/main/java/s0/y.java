package s0;

import android.animation.LayoutTransition;
import android.view.ViewGroup;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* loaded from: classes.dex */
class y {

    /* renamed from: a, reason: collision with root package name */
    private static LayoutTransition f13995a;

    /* renamed from: b, reason: collision with root package name */
    private static Field f13996b;

    /* renamed from: c, reason: collision with root package name */
    private static boolean f13997c;

    /* renamed from: d, reason: collision with root package name */
    private static Method f13998d;

    /* renamed from: e, reason: collision with root package name */
    private static boolean f13999e;

    /* loaded from: classes.dex */
    static class a extends LayoutTransition {
        a() {
        }

        @Override // android.animation.LayoutTransition
        public boolean isChangingLayout() {
            return true;
        }
    }

    private static void a(LayoutTransition layoutTransition) {
        if (!f13999e) {
            try {
                Method declaredMethod = LayoutTransition.class.getDeclaredMethod("cancel", new Class[0]);
                f13998d = declaredMethod;
                declaredMethod.setAccessible(true);
            } catch (NoSuchMethodException unused) {
            }
            f13999e = true;
        }
        Method method = f13998d;
        if (method != null) {
            try {
                method.invoke(layoutTransition, new Object[0]);
            } catch (IllegalAccessException | InvocationTargetException unused2) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void b(ViewGroup viewGroup, boolean z10) {
        boolean z11 = false;
        if (f13995a == null) {
            a aVar = new a();
            f13995a = aVar;
            aVar.setAnimator(2, null);
            f13995a.setAnimator(0, null);
            f13995a.setAnimator(1, null);
            f13995a.setAnimator(3, null);
            f13995a.setAnimator(4, null);
        }
        if (z10) {
            LayoutTransition layoutTransition = viewGroup.getLayoutTransition();
            if (layoutTransition != null) {
                if (layoutTransition.isRunning()) {
                    a(layoutTransition);
                }
                if (layoutTransition != f13995a) {
                    viewGroup.setTag(j.f13940c, layoutTransition);
                }
            }
            viewGroup.setLayoutTransition(f13995a);
            return;
        }
        viewGroup.setLayoutTransition(null);
        if (!f13997c) {
            try {
                Field declaredField = ViewGroup.class.getDeclaredField("mLayoutSuppressed");
                f13996b = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException unused) {
            }
            f13997c = true;
        }
        Field field = f13996b;
        if (field != null) {
            try {
                boolean z12 = field.getBoolean(viewGroup);
                if (z12) {
                    try {
                        f13996b.setBoolean(viewGroup, false);
                    } catch (IllegalAccessException unused2) {
                    }
                }
                z11 = z12;
            } catch (IllegalAccessException unused3) {
            }
        }
        if (z11) {
            viewGroup.requestLayout();
        }
        int i10 = j.f13940c;
        LayoutTransition layoutTransition2 = (LayoutTransition) viewGroup.getTag(i10);
        if (layoutTransition2 != null) {
            viewGroup.setTag(i10, null);
            viewGroup.setLayoutTransition(layoutTransition2);
        }
    }
}
