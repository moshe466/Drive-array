package androidx.core.view.accessibility;

import android.R;
import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.util.SparseArray;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.core.view.accessibility.g;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
public class d {

    /* renamed from: d, reason: collision with root package name */
    private static int f2532d;

    /* renamed from: a, reason: collision with root package name */
    private final AccessibilityNodeInfo f2533a;

    /* renamed from: b, reason: collision with root package name */
    public int f2534b = -1;

    /* renamed from: c, reason: collision with root package name */
    private int f2535c = -1;

    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: d, reason: collision with root package name */
        public static final a f2536d = new a(1, null);

        /* renamed from: e, reason: collision with root package name */
        public static final a f2537e = new a(2, null);

        /* renamed from: f, reason: collision with root package name */
        public static final a f2538f;

        /* renamed from: g, reason: collision with root package name */
        public static final a f2539g;

        /* renamed from: h, reason: collision with root package name */
        public static final a f2540h;

        /* renamed from: i, reason: collision with root package name */
        public static final a f2541i;

        /* renamed from: a, reason: collision with root package name */
        final Object f2542a;

        /* renamed from: b, reason: collision with root package name */
        private final Class<? extends g.a> f2543b;

        /* renamed from: c, reason: collision with root package name */
        protected final g f2544c;

        static {
            new a(4, null);
            new a(8, null);
            new a(16, null);
            new a(32, null);
            new a(64, null);
            new a(128, null);
            new a(256, null, g.b.class);
            new a(512, null, g.b.class);
            new a(1024, null, g.c.class);
            new a(2048, null, g.c.class);
            f2538f = new a(4096, null);
            f2539g = new a(8192, null);
            new a(16384, null);
            new a(32768, null);
            new a(65536, null);
            new a(131072, null, g.C0040g.class);
            new a(262144, null);
            new a(524288, null);
            new a(1048576, null);
            new a(2097152, null, g.h.class);
            int i10 = Build.VERSION.SDK_INT;
            new a(i10 >= 23 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SHOW_ON_SCREEN : null, R.id.accessibilityActionShowOnScreen, null, null, null);
            new a(i10 >= 23 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_TO_POSITION : null, R.id.accessibilityActionScrollToPosition, null, null, g.e.class);
            f2540h = new a(i10 >= 23 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_UP : null, R.id.accessibilityActionScrollUp, null, null, null);
            new a(i10 >= 23 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_LEFT : null, R.id.accessibilityActionScrollLeft, null, null, null);
            f2541i = new a(i10 >= 23 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_DOWN : null, R.id.accessibilityActionScrollDown, null, null, null);
            new a(i10 >= 23 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_RIGHT : null, R.id.accessibilityActionScrollRight, null, null, null);
            new a(i10 >= 29 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_UP : null, R.id.accessibilityActionPageUp, null, null, null);
            new a(i10 >= 29 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_DOWN : null, R.id.accessibilityActionPageDown, null, null, null);
            new a(i10 >= 29 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_LEFT : null, R.id.accessibilityActionPageLeft, null, null, null);
            new a(i10 >= 29 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_RIGHT : null, R.id.accessibilityActionPageRight, null, null, null);
            new a(i10 >= 23 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_CONTEXT_CLICK : null, R.id.accessibilityActionContextClick, null, null, null);
            new a(i10 >= 24 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SET_PROGRESS : null, R.id.accessibilityActionSetProgress, null, null, g.f.class);
            new a(i10 >= 26 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_MOVE_WINDOW : null, R.id.accessibilityActionMoveWindow, null, null, g.d.class);
            new a(i10 >= 28 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SHOW_TOOLTIP : null, R.id.accessibilityActionShowTooltip, null, null, null);
            new a(i10 >= 28 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_HIDE_TOOLTIP : null, R.id.accessibilityActionHideTooltip, null, null, null);
            new a(i10 >= 30 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_PRESS_AND_HOLD : null, R.id.accessibilityActionPressAndHold, null, null, null);
            new a(i10 >= 30 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_IME_ENTER : null, R.id.accessibilityActionImeEnter, null, null, null);
            new a(i10 >= 32 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_DRAG_START : null, R.id.ALT, null, null, null);
            new a(i10 >= 32 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_DRAG_DROP : null, R.id.CTRL, null, null, null);
            new a(i10 >= 32 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_DRAG_CANCEL : null, R.id.FUNCTION, null, null, null);
            new a(i10 >= 33 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SHOW_TEXT_SUGGESTIONS : null, R.id.KEYCODE_0, null, null, null);
        }

        public a(int i10, CharSequence charSequence) {
            this(null, i10, charSequence, null, null);
        }

        private a(int i10, CharSequence charSequence, Class<? extends g.a> cls) {
            this(null, i10, charSequence, null, cls);
        }

        a(Object obj) {
            this(obj, 0, null, null, null);
        }

        a(Object obj, int i10, CharSequence charSequence, g gVar, Class<? extends g.a> cls) {
            this.f2544c = gVar;
            if (Build.VERSION.SDK_INT >= 21 && obj == null) {
                obj = new AccessibilityNodeInfo.AccessibilityAction(i10, charSequence);
            }
            this.f2542a = obj;
            this.f2543b = cls;
        }

        public int a() {
            if (Build.VERSION.SDK_INT >= 21) {
                return ((AccessibilityNodeInfo.AccessibilityAction) this.f2542a).getId();
            }
            return 0;
        }

        public CharSequence b() {
            if (Build.VERSION.SDK_INT >= 21) {
                return ((AccessibilityNodeInfo.AccessibilityAction) this.f2542a).getLabel();
            }
            return null;
        }

        public boolean c(View view, Bundle bundle) {
            g.a newInstance;
            if (this.f2544c == null) {
                return false;
            }
            g.a aVar = null;
            Class<? extends g.a> cls = this.f2543b;
            if (cls != null) {
                try {
                    newInstance = cls.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                } catch (Exception unused) {
                }
                try {
                    newInstance.a(bundle);
                    aVar = newInstance;
                } catch (Exception unused2) {
                    aVar = newInstance;
                    Class<? extends g.a> cls2 = this.f2543b;
                    String name = cls2 == null ? "null" : cls2.getName();
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("Failed to execute command with argument class ViewCommandArgument: ");
                    sb2.append(name);
                    return this.f2544c.a(view, aVar);
                }
            }
            return this.f2544c.a(view, aVar);
        }

        public boolean equals(Object obj) {
            if (obj == null || !(obj instanceof a)) {
                return false;
            }
            Object obj2 = this.f2542a;
            Object obj3 = ((a) obj).f2542a;
            return obj2 == null ? obj3 == null : obj2.equals(obj3);
        }

        public int hashCode() {
            Object obj = this.f2542a;
            if (obj != null) {
                return obj.hashCode();
            }
            return 0;
        }
    }

    /* loaded from: classes.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        final Object f2545a;

        b(Object obj) {
            this.f2545a = obj;
        }

        public static b a(int i10, int i11, boolean z10, int i12) {
            int i13 = Build.VERSION.SDK_INT;
            return i13 >= 21 ? new b(AccessibilityNodeInfo.CollectionInfo.obtain(i10, i11, z10, i12)) : i13 >= 19 ? new b(AccessibilityNodeInfo.CollectionInfo.obtain(i10, i11, z10)) : new b(null);
        }
    }

    /* loaded from: classes.dex */
    public static class c {

        /* renamed from: a, reason: collision with root package name */
        final Object f2546a;

        c(Object obj) {
            this.f2546a = obj;
        }

        public static c a(int i10, int i11, int i12, int i13, boolean z10, boolean z11) {
            int i14 = Build.VERSION.SDK_INT;
            return i14 >= 21 ? new c(AccessibilityNodeInfo.CollectionItemInfo.obtain(i10, i11, i12, i13, z10, z11)) : i14 >= 19 ? new c(AccessibilityNodeInfo.CollectionItemInfo.obtain(i10, i11, i12, i13, z10)) : new c(null);
        }
    }

    private d(AccessibilityNodeInfo accessibilityNodeInfo) {
        this.f2533a = accessibilityNodeInfo;
    }

    public static d K(d dVar) {
        return u0(AccessibilityNodeInfo.obtain(dVar.f2533a));
    }

    private void O(View view) {
        SparseArray<WeakReference<ClickableSpan>> s10 = s(view);
        if (s10 != null) {
            ArrayList arrayList = new ArrayList();
            for (int i10 = 0; i10 < s10.size(); i10++) {
                if (s10.valueAt(i10).get() == null) {
                    arrayList.add(Integer.valueOf(i10));
                }
            }
            for (int i11 = 0; i11 < arrayList.size(); i11++) {
                s10.remove(((Integer) arrayList.get(i11)).intValue());
            }
        }
    }

    private void Q(int i10, boolean z10) {
        Bundle p10 = p();
        if (p10 != null) {
            int i11 = p10.getInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.BOOLEAN_PROPERTY_KEY", 0) & (~i10);
            if (!z10) {
                i10 = 0;
            }
            p10.putInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.BOOLEAN_PROPERTY_KEY", i10 | i11);
        }
    }

    private void d(ClickableSpan clickableSpan, Spanned spanned, int i10) {
        g("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_START_KEY").add(Integer.valueOf(spanned.getSpanStart(clickableSpan)));
        g("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_END_KEY").add(Integer.valueOf(spanned.getSpanEnd(clickableSpan)));
        g("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_FLAGS_KEY").add(Integer.valueOf(spanned.getSpanFlags(clickableSpan)));
        g("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ID_KEY").add(Integer.valueOf(i10));
    }

    private void f() {
        if (Build.VERSION.SDK_INT >= 19) {
            this.f2533a.getExtras().remove("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_START_KEY");
            this.f2533a.getExtras().remove("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_END_KEY");
            this.f2533a.getExtras().remove("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_FLAGS_KEY");
            this.f2533a.getExtras().remove("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ID_KEY");
        }
    }

    private List<Integer> g(String str) {
        if (Build.VERSION.SDK_INT < 19) {
            return new ArrayList();
        }
        ArrayList<Integer> integerArrayList = this.f2533a.getExtras().getIntegerArrayList(str);
        if (integerArrayList != null) {
            return integerArrayList;
        }
        ArrayList<Integer> arrayList = new ArrayList<>();
        this.f2533a.getExtras().putIntegerArrayList(str, arrayList);
        return arrayList;
    }

    private static String i(int i10) {
        if (i10 == 1) {
            return "ACTION_FOCUS";
        }
        if (i10 == 2) {
            return "ACTION_CLEAR_FOCUS";
        }
        switch (i10) {
            case 4:
                return "ACTION_SELECT";
            case 8:
                return "ACTION_CLEAR_SELECTION";
            case 16:
                return "ACTION_CLICK";
            case 32:
                return "ACTION_LONG_CLICK";
            case 64:
                return "ACTION_ACCESSIBILITY_FOCUS";
            case 128:
                return "ACTION_CLEAR_ACCESSIBILITY_FOCUS";
            case 256:
                return "ACTION_NEXT_AT_MOVEMENT_GRANULARITY";
            case 512:
                return "ACTION_PREVIOUS_AT_MOVEMENT_GRANULARITY";
            case 1024:
                return "ACTION_NEXT_HTML_ELEMENT";
            case 2048:
                return "ACTION_PREVIOUS_HTML_ELEMENT";
            case 4096:
                return "ACTION_SCROLL_FORWARD";
            case 8192:
                return "ACTION_SCROLL_BACKWARD";
            case 16384:
                return "ACTION_COPY";
            case 32768:
                return "ACTION_PASTE";
            case 65536:
                return "ACTION_CUT";
            case 131072:
                return "ACTION_SET_SELECTION";
            case 262144:
                return "ACTION_EXPAND";
            case 524288:
                return "ACTION_COLLAPSE";
            case 2097152:
                return "ACTION_SET_TEXT";
            case R.id.accessibilityActionMoveWindow:
                return "ACTION_MOVE_WINDOW";
            default:
                switch (i10) {
                    case R.id.accessibilityActionShowOnScreen:
                        return "ACTION_SHOW_ON_SCREEN";
                    case R.id.accessibilityActionScrollToPosition:
                        return "ACTION_SCROLL_TO_POSITION";
                    case R.id.accessibilityActionScrollUp:
                        return "ACTION_SCROLL_UP";
                    case R.id.accessibilityActionScrollLeft:
                        return "ACTION_SCROLL_LEFT";
                    case R.id.accessibilityActionScrollDown:
                        return "ACTION_SCROLL_DOWN";
                    case R.id.accessibilityActionScrollRight:
                        return "ACTION_SCROLL_RIGHT";
                    case R.id.accessibilityActionContextClick:
                        return "ACTION_CONTEXT_CLICK";
                    case R.id.accessibilityActionSetProgress:
                        return "ACTION_SET_PROGRESS";
                    default:
                        switch (i10) {
                            case R.id.accessibilityActionShowTooltip:
                                return "ACTION_SHOW_TOOLTIP";
                            case R.id.accessibilityActionHideTooltip:
                                return "ACTION_HIDE_TOOLTIP";
                            case R.id.accessibilityActionPageUp:
                                return "ACTION_PAGE_UP";
                            case R.id.accessibilityActionPageDown:
                                return "ACTION_PAGE_DOWN";
                            case R.id.accessibilityActionPageLeft:
                                return "ACTION_PAGE_LEFT";
                            case R.id.accessibilityActionPageRight:
                                return "ACTION_PAGE_RIGHT";
                            case R.id.accessibilityActionPressAndHold:
                                return "ACTION_PRESS_AND_HOLD";
                            default:
                                switch (i10) {
                                    case R.id.accessibilityActionImeEnter:
                                        return "ACTION_IME_ENTER";
                                    case R.id.ALT:
                                        return "ACTION_DRAG_START";
                                    case R.id.CTRL:
                                        return "ACTION_DRAG_DROP";
                                    case R.id.FUNCTION:
                                        return "ACTION_DRAG_CANCEL";
                                    default:
                                        return "ACTION_UNKNOWN";
                                }
                        }
                }
        }
    }

    public static ClickableSpan[] n(CharSequence charSequence) {
        if (charSequence instanceof Spanned) {
            return (ClickableSpan[]) ((Spanned) charSequence).getSpans(0, charSequence.length(), ClickableSpan.class);
        }
        return null;
    }

    private SparseArray<WeakReference<ClickableSpan>> q(View view) {
        SparseArray<WeakReference<ClickableSpan>> s10 = s(view);
        if (s10 != null) {
            return s10;
        }
        SparseArray<WeakReference<ClickableSpan>> sparseArray = new SparseArray<>();
        view.setTag(t.c.f14222c, sparseArray);
        return sparseArray;
    }

    private SparseArray<WeakReference<ClickableSpan>> s(View view) {
        return (SparseArray) view.getTag(t.c.f14222c);
    }

    public static d u0(AccessibilityNodeInfo accessibilityNodeInfo) {
        return new d(accessibilityNodeInfo);
    }

    private boolean w() {
        return !g("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_START_KEY").isEmpty();
    }

    private int x(ClickableSpan clickableSpan, SparseArray<WeakReference<ClickableSpan>> sparseArray) {
        if (sparseArray != null) {
            for (int i10 = 0; i10 < sparseArray.size(); i10++) {
                if (clickableSpan.equals(sparseArray.valueAt(i10).get())) {
                    return sparseArray.keyAt(i10);
                }
            }
        }
        int i11 = f2532d;
        f2532d = i11 + 1;
        return i11;
    }

    public boolean A() {
        return this.f2533a.isChecked();
    }

    public boolean B() {
        return this.f2533a.isClickable();
    }

    public boolean C() {
        return this.f2533a.isEnabled();
    }

    public boolean D() {
        return this.f2533a.isFocusable();
    }

    public boolean E() {
        return this.f2533a.isFocused();
    }

    public boolean F() {
        return this.f2533a.isLongClickable();
    }

    public boolean G() {
        return this.f2533a.isPassword();
    }

    public boolean H() {
        return this.f2533a.isScrollable();
    }

    public boolean I() {
        return this.f2533a.isSelected();
    }

    public boolean J() {
        if (Build.VERSION.SDK_INT >= 16) {
            return this.f2533a.isVisibleToUser();
        }
        return false;
    }

    public boolean L(int i10, Bundle bundle) {
        if (Build.VERSION.SDK_INT >= 16) {
            return this.f2533a.performAction(i10, bundle);
        }
        return false;
    }

    public void M() {
        this.f2533a.recycle();
    }

    public boolean N(a aVar) {
        if (Build.VERSION.SDK_INT >= 21) {
            return this.f2533a.removeAction((AccessibilityNodeInfo.AccessibilityAction) aVar.f2542a);
        }
        return false;
    }

    public void P(boolean z10) {
        if (Build.VERSION.SDK_INT >= 16) {
            this.f2533a.setAccessibilityFocused(z10);
        }
    }

    @Deprecated
    public void R(Rect rect) {
        this.f2533a.setBoundsInParent(rect);
    }

    public void S(Rect rect) {
        this.f2533a.setBoundsInScreen(rect);
    }

    public void T(boolean z10) {
        this.f2533a.setCheckable(z10);
    }

    public void U(boolean z10) {
        this.f2533a.setChecked(z10);
    }

    public void V(CharSequence charSequence) {
        this.f2533a.setClassName(charSequence);
    }

    public void W(boolean z10) {
        this.f2533a.setClickable(z10);
    }

    public void X(Object obj) {
        if (Build.VERSION.SDK_INT >= 19) {
            this.f2533a.setCollectionInfo(obj == null ? null : (AccessibilityNodeInfo.CollectionInfo) ((b) obj).f2545a);
        }
    }

    public void Y(Object obj) {
        if (Build.VERSION.SDK_INT >= 19) {
            this.f2533a.setCollectionItemInfo(obj == null ? null : (AccessibilityNodeInfo.CollectionItemInfo) ((c) obj).f2546a);
        }
    }

    public void Z(CharSequence charSequence) {
        this.f2533a.setContentDescription(charSequence);
    }

    public void a(int i10) {
        this.f2533a.addAction(i10);
    }

    public void a0(boolean z10) {
        if (Build.VERSION.SDK_INT >= 19) {
            this.f2533a.setContentInvalid(z10);
        }
    }

    public void b(a aVar) {
        if (Build.VERSION.SDK_INT >= 21) {
            this.f2533a.addAction((AccessibilityNodeInfo.AccessibilityAction) aVar.f2542a);
        }
    }

    public void b0(boolean z10) {
        this.f2533a.setEnabled(z10);
    }

    public void c(View view) {
        this.f2533a.addChild(view);
    }

    public void c0(CharSequence charSequence) {
        if (Build.VERSION.SDK_INT >= 21) {
            this.f2533a.setError(charSequence);
        }
    }

    public void d0(boolean z10) {
        this.f2533a.setFocusable(z10);
    }

    public void e(CharSequence charSequence, View view) {
        int i10 = Build.VERSION.SDK_INT;
        if (i10 < 19 || i10 >= 26) {
            return;
        }
        f();
        O(view);
        ClickableSpan[] n10 = n(charSequence);
        if (n10 == null || n10.length <= 0) {
            return;
        }
        p().putInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ACTION_ID_KEY", t.c.f14220a);
        SparseArray<WeakReference<ClickableSpan>> q10 = q(view);
        for (int i11 = 0; i11 < n10.length; i11++) {
            int x10 = x(n10[i11], q10);
            q10.put(x10, new WeakReference<>(n10[i11]));
            d(n10[i11], (Spanned) charSequence, x10);
        }
    }

    public void e0(boolean z10) {
        this.f2533a.setFocused(z10);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        AccessibilityNodeInfo accessibilityNodeInfo = this.f2533a;
        if (accessibilityNodeInfo == null) {
            if (dVar.f2533a != null) {
                return false;
            }
        } else if (!accessibilityNodeInfo.equals(dVar.f2533a)) {
            return false;
        }
        return this.f2535c == dVar.f2535c && this.f2534b == dVar.f2534b;
    }

    public void f0(boolean z10) {
        if (Build.VERSION.SDK_INT >= 28) {
            this.f2533a.setHeading(z10);
        } else {
            Q(2, z10);
        }
    }

    public void g0(CharSequence charSequence) {
        int i10 = Build.VERSION.SDK_INT;
        if (i10 >= 26) {
            this.f2533a.setHintText(charSequence);
        } else if (i10 >= 19) {
            this.f2533a.getExtras().putCharSequence("androidx.view.accessibility.AccessibilityNodeInfoCompat.HINT_TEXT_KEY", charSequence);
        }
    }

    public List<a> h() {
        List<AccessibilityNodeInfo.AccessibilityAction> actionList = Build.VERSION.SDK_INT >= 21 ? this.f2533a.getActionList() : null;
        if (actionList == null) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        int size = actionList.size();
        for (int i10 = 0; i10 < size; i10++) {
            arrayList.add(new a(actionList.get(i10)));
        }
        return arrayList;
    }

    public void h0(boolean z10) {
        this.f2533a.setLongClickable(z10);
    }

    public int hashCode() {
        AccessibilityNodeInfo accessibilityNodeInfo = this.f2533a;
        if (accessibilityNodeInfo == null) {
            return 0;
        }
        return accessibilityNodeInfo.hashCode();
    }

    public void i0(CharSequence charSequence) {
        this.f2533a.setPackageName(charSequence);
    }

    @Deprecated
    public int j() {
        return this.f2533a.getActions();
    }

    public void j0(CharSequence charSequence) {
        int i10 = Build.VERSION.SDK_INT;
        if (i10 >= 28) {
            this.f2533a.setPaneTitle(charSequence);
        } else if (i10 >= 19) {
            this.f2533a.getExtras().putCharSequence("androidx.view.accessibility.AccessibilityNodeInfoCompat.PANE_TITLE_KEY", charSequence);
        }
    }

    @Deprecated
    public void k(Rect rect) {
        this.f2533a.getBoundsInParent(rect);
    }

    public void k0(View view) {
        this.f2534b = -1;
        this.f2533a.setParent(view);
    }

    public void l(Rect rect) {
        this.f2533a.getBoundsInScreen(rect);
    }

    public void l0(boolean z10) {
        if (Build.VERSION.SDK_INT >= 28) {
            this.f2533a.setScreenReaderFocusable(z10);
        } else {
            Q(1, z10);
        }
    }

    public CharSequence m() {
        return this.f2533a.getClassName();
    }

    public void m0(boolean z10) {
        this.f2533a.setScrollable(z10);
    }

    public void n0(boolean z10) {
        this.f2533a.setSelected(z10);
    }

    public CharSequence o() {
        return this.f2533a.getContentDescription();
    }

    public void o0(boolean z10) {
        if (Build.VERSION.SDK_INT >= 26) {
            this.f2533a.setShowingHintText(z10);
        } else {
            Q(4, z10);
        }
    }

    public Bundle p() {
        return Build.VERSION.SDK_INT >= 19 ? this.f2533a.getExtras() : new Bundle();
    }

    public void p0(View view) {
        this.f2535c = -1;
        this.f2533a.setSource(view);
    }

    public void q0(CharSequence charSequence) {
        if (androidx.core.os.a.b()) {
            this.f2533a.setStateDescription(charSequence);
        } else if (Build.VERSION.SDK_INT >= 19) {
            this.f2533a.getExtras().putCharSequence("androidx.view.accessibility.AccessibilityNodeInfoCompat.STATE_DESCRIPTION_KEY", charSequence);
        }
    }

    public CharSequence r() {
        return this.f2533a.getPackageName();
    }

    public void r0(CharSequence charSequence) {
        this.f2533a.setText(charSequence);
    }

    public void s0(boolean z10) {
        if (Build.VERSION.SDK_INT >= 16) {
            this.f2533a.setVisibleToUser(z10);
        }
    }

    public CharSequence t() {
        if (!w()) {
            return this.f2533a.getText();
        }
        List<Integer> g10 = g("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_START_KEY");
        List<Integer> g11 = g("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_END_KEY");
        List<Integer> g12 = g("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_FLAGS_KEY");
        List<Integer> g13 = g("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ID_KEY");
        SpannableString spannableString = new SpannableString(TextUtils.substring(this.f2533a.getText(), 0, this.f2533a.getText().length()));
        for (int i10 = 0; i10 < g10.size(); i10++) {
            spannableString.setSpan(new androidx.core.view.accessibility.a(g13.get(i10).intValue(), this, p().getInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ACTION_ID_KEY")), g10.get(i10).intValue(), g11.get(i10).intValue(), g12.get(i10).intValue());
        }
        return spannableString;
    }

    public AccessibilityNodeInfo t0() {
        return this.f2533a;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(super.toString());
        Rect rect = new Rect();
        k(rect);
        sb2.append("; boundsInParent: " + rect);
        l(rect);
        sb2.append("; boundsInScreen: " + rect);
        sb2.append("; packageName: ");
        sb2.append(r());
        sb2.append("; className: ");
        sb2.append(m());
        sb2.append("; text: ");
        sb2.append(t());
        sb2.append("; contentDescription: ");
        sb2.append(o());
        sb2.append("; viewId: ");
        sb2.append(v());
        sb2.append("; uniqueId: ");
        sb2.append(u());
        sb2.append("; checkable: ");
        sb2.append(z());
        sb2.append("; checked: ");
        sb2.append(A());
        sb2.append("; focusable: ");
        sb2.append(D());
        sb2.append("; focused: ");
        sb2.append(E());
        sb2.append("; selected: ");
        sb2.append(I());
        sb2.append("; clickable: ");
        sb2.append(B());
        sb2.append("; longClickable: ");
        sb2.append(F());
        sb2.append("; enabled: ");
        sb2.append(C());
        sb2.append("; password: ");
        sb2.append(G());
        sb2.append("; scrollable: " + H());
        sb2.append("; [");
        if (Build.VERSION.SDK_INT >= 21) {
            List<a> h10 = h();
            for (int i10 = 0; i10 < h10.size(); i10++) {
                a aVar = h10.get(i10);
                String i11 = i(aVar.a());
                if (i11.equals("ACTION_UNKNOWN") && aVar.b() != null) {
                    i11 = aVar.b().toString();
                }
                sb2.append(i11);
                if (i10 != h10.size() - 1) {
                    sb2.append(", ");
                }
            }
        } else {
            int j10 = j();
            while (j10 != 0) {
                int numberOfTrailingZeros = 1 << Integer.numberOfTrailingZeros(j10);
                j10 &= ~numberOfTrailingZeros;
                sb2.append(i(numberOfTrailingZeros));
                if (j10 != 0) {
                    sb2.append(", ");
                }
            }
        }
        sb2.append("]");
        return sb2.toString();
    }

    public String u() {
        if (androidx.core.os.a.c()) {
            return this.f2533a.getUniqueId();
        }
        if (Build.VERSION.SDK_INT >= 19) {
            return this.f2533a.getExtras().getString("androidx.view.accessibility.AccessibilityNodeInfoCompat.UNIQUE_ID_KEY");
        }
        return null;
    }

    public String v() {
        if (Build.VERSION.SDK_INT >= 18) {
            return this.f2533a.getViewIdResourceName();
        }
        return null;
    }

    public boolean y() {
        if (Build.VERSION.SDK_INT >= 16) {
            return this.f2533a.isAccessibilityFocused();
        }
        return false;
    }

    public boolean z() {
        return this.f2533a.isCheckable();
    }
}
