package J;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewParent;
import android.view.WindowInsets;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import com.uh.sf.R;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.WeakHashMap;
import m.C0571u;

/* loaded from: classes.dex */
public abstract class S {

    /* renamed from: a, reason: collision with root package name */
    public static WeakHashMap f954a = null;

    /* renamed from: b, reason: collision with root package name */
    public static Field f955b = null;

    /* renamed from: c, reason: collision with root package name */
    public static boolean f956c = false;

    /* renamed from: d, reason: collision with root package name */
    public static final D f957d = new Object();

    /* renamed from: e, reason: collision with root package name */
    public static final F f958e = new F();

    public static X a(View view) {
        if (f954a == null) {
            f954a = new WeakHashMap();
        }
        X x3 = (X) f954a.get(view);
        if (x3 == null) {
            X x4 = new X(view);
            f954a.put(view, x4);
            return x4;
        }
        return x3;
    }

    public static void b(View view, p0 p0Var) {
        WindowInsets a2;
        int i = Build.VERSION.SDK_INT;
        WindowInsets b4 = p0Var.b();
        if (b4 != null) {
            if (i >= 30) {
                a2 = O.a(view, b4);
            } else {
                a2 = H.a(view, b4);
            }
            if (!a2.equals(b4)) {
                p0.c(a2, view);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v5, types: [java.lang.Object, J.Q] */
    public static boolean c(View view, KeyEvent keyEvent) {
        if (Build.VERSION.SDK_INT < 28) {
            ArrayList arrayList = Q.f950d;
            Q q3 = (Q) view.getTag(R.id.tag_unhandled_key_event_manager);
            Q q4 = q3;
            if (q3 == null) {
                ?? obj = new Object();
                obj.f951a = null;
                obj.f952b = null;
                obj.f953c = null;
                view.setTag(R.id.tag_unhandled_key_event_manager, obj);
                q4 = obj;
            }
            if (keyEvent.getAction() == 0) {
                WeakHashMap weakHashMap = q4.f951a;
                if (weakHashMap != null) {
                    weakHashMap.clear();
                }
                ArrayList arrayList2 = Q.f950d;
                if (!arrayList2.isEmpty()) {
                    synchronized (arrayList2) {
                        try {
                            if (q4.f951a == null) {
                                q4.f951a = new WeakHashMap();
                            }
                            for (int size = arrayList2.size() - 1; size >= 0; size--) {
                                ArrayList arrayList3 = Q.f950d;
                                View view2 = (View) ((WeakReference) arrayList3.get(size)).get();
                                if (view2 == null) {
                                    arrayList3.remove(size);
                                } else {
                                    q4.f951a.put(view2, Boolean.TRUE);
                                    for (ViewParent parent = view2.getParent(); parent instanceof View; parent = parent.getParent()) {
                                        q4.f951a.put((View) parent, Boolean.TRUE);
                                    }
                                }
                            }
                        } finally {
                        }
                    }
                }
            }
            View a2 = q4.a(view);
            if (keyEvent.getAction() == 0) {
                int keyCode = keyEvent.getKeyCode();
                if (a2 != null && !KeyEvent.isModifierKey(keyCode)) {
                    if (q4.f952b == null) {
                        q4.f952b = new SparseArray();
                    }
                    q4.f952b.put(keyCode, new WeakReference(a2));
                }
            }
            if (a2 != null) {
                return true;
            }
            return false;
        }
        return false;
    }

    public static View.AccessibilityDelegate d(View view) {
        if (Build.VERSION.SDK_INT >= 29) {
            return N.a(view);
        }
        if (!f956c) {
            if (f955b == null) {
                try {
                    Field declaredField = View.class.getDeclaredField("mAccessibilityDelegate");
                    f955b = declaredField;
                    declaredField.setAccessible(true);
                } catch (Throwable unused) {
                    f956c = true;
                    return null;
                }
            }
            try {
                Object obj = f955b.get(view);
                if (obj instanceof View.AccessibilityDelegate) {
                    return (View.AccessibilityDelegate) obj;
                }
                return null;
            } catch (Throwable unused2) {
                f956c = true;
                return null;
            }
        }
        return null;
    }

    public static String[] e(C0571u c0571u) {
        if (Build.VERSION.SDK_INT >= 31) {
            return P.a(c0571u);
        }
        return (String[]) c0571u.getTag(R.id.tag_on_receive_content_mime_types);
    }

    public static void f(View view, int i) {
        Object tag;
        boolean z3;
        AccessibilityManager accessibilityManager = (AccessibilityManager) view.getContext().getSystemService("accessibility");
        if (accessibilityManager.isEnabled()) {
            int i3 = Build.VERSION.SDK_INT;
            CharSequence charSequence = null;
            if (i3 >= 28) {
                tag = M.a(view);
            } else {
                tag = view.getTag(R.id.tag_accessibility_pane_title);
                if (!CharSequence.class.isInstance(tag)) {
                    tag = null;
                }
            }
            if (((CharSequence) tag) != null && view.isShown() && view.getWindowVisibility() == 0) {
                z3 = true;
            } else {
                z3 = false;
            }
            int i4 = 32;
            if (view.getAccessibilityLiveRegion() == 0 && !z3) {
                if (i == 32) {
                    AccessibilityEvent obtain = AccessibilityEvent.obtain();
                    view.onInitializeAccessibilityEvent(obtain);
                    obtain.setEventType(32);
                    obtain.setContentChangeTypes(i);
                    obtain.setSource(view);
                    view.onPopulateAccessibilityEvent(obtain);
                    List<CharSequence> text = obtain.getText();
                    if (i3 >= 28) {
                        charSequence = M.a(view);
                    } else {
                        Object tag2 = view.getTag(R.id.tag_accessibility_pane_title);
                        if (CharSequence.class.isInstance(tag2)) {
                            charSequence = tag2;
                        }
                    }
                    text.add(charSequence);
                    accessibilityManager.sendAccessibilityEvent(obtain);
                    return;
                }
                if (view.getParent() != null) {
                    try {
                        view.getParent().notifySubtreeAccessibilityStateChanged(view, view, i);
                        return;
                    } catch (AbstractMethodError e4) {
                        Log.e("ViewCompat", view.getParent().getClass().getSimpleName().concat(" does not fully implement ViewParent"), e4);
                        return;
                    }
                }
                return;
            }
            AccessibilityEvent obtain2 = AccessibilityEvent.obtain();
            if (!z3) {
                i4 = 2048;
            }
            obtain2.setEventType(i4);
            obtain2.setContentChangeTypes(i);
            if (z3) {
                List<CharSequence> text2 = obtain2.getText();
                if (i3 >= 28) {
                    charSequence = M.a(view);
                } else {
                    Object tag3 = view.getTag(R.id.tag_accessibility_pane_title);
                    if (CharSequence.class.isInstance(tag3)) {
                        charSequence = tag3;
                    }
                }
                text2.add(charSequence);
                if (view.getImportantForAccessibility() == 0) {
                    view.setImportantForAccessibility(1);
                }
            }
            view.sendAccessibilityEventUnchecked(obtain2);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static C0118f g(View view, C0118f c0118f) {
        if (Log.isLoggable("ViewCompat", 3)) {
            Objects.toString(c0118f);
            view.getClass();
            view.getId();
        }
        if (Build.VERSION.SDK_INT >= 31) {
            return P.b(view, c0118f);
        }
        M.j jVar = (M.j) view.getTag(R.id.tag_on_receive_content_listener);
        InterfaceC0133v interfaceC0133v = f957d;
        if (jVar != null) {
            C0118f a2 = M.j.a(view, c0118f);
            if (a2 == null) {
                return null;
            }
            if (view instanceof InterfaceC0133v) {
                interfaceC0133v = (InterfaceC0133v) view;
            }
            return interfaceC0133v.a(a2);
        }
        if (view instanceof InterfaceC0133v) {
            interfaceC0133v = (InterfaceC0133v) view;
        }
        return interfaceC0133v.a(c0118f);
    }

    public static void h(View view, Context context, int[] iArr, AttributeSet attributeSet, TypedArray typedArray, int i) {
        if (Build.VERSION.SDK_INT >= 29) {
            N.b(view, context, iArr, attributeSet, typedArray, i, 0);
        }
    }

    public static void i(View view, C0114b c0114b) {
        C0113a c0113a;
        if (c0114b == null && (d(view) instanceof C0113a)) {
            c0114b = new C0114b();
        }
        if (view.getImportantForAccessibility() == 0) {
            view.setImportantForAccessibility(1);
        }
        if (c0114b == null) {
            c0113a = null;
        } else {
            c0113a = c0114b.f975b;
        }
        view.setAccessibilityDelegate(c0113a);
    }

    public static void j(View view, CharSequence charSequence) {
        boolean z3;
        new E(R.id.tag_accessibility_pane_title, CharSequence.class, 8, 28, 1).d(view, charSequence);
        F f4 = f958e;
        if (charSequence != null) {
            WeakHashMap weakHashMap = f4.f942a;
            if (view.isShown() && view.getWindowVisibility() == 0) {
                z3 = true;
            } else {
                z3 = false;
            }
            weakHashMap.put(view, Boolean.valueOf(z3));
            view.addOnAttachStateChangeListener(f4);
            if (view.isAttachedToWindow()) {
                view.getViewTreeObserver().addOnGlobalLayoutListener(f4);
                return;
            }
            return;
        }
        f4.f942a.remove(view);
        view.removeOnAttachStateChangeListener(f4);
        view.getViewTreeObserver().removeOnGlobalLayoutListener(f4);
    }
}
