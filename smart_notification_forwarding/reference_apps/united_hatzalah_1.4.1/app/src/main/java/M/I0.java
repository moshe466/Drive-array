package m;

import a.AbstractC0228a;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.PopupWindow;
import com.google.android.gms.common.api.Api;
import g.AbstractC0424a;
import java.lang.reflect.Method;
import java.util.WeakHashMap;
import l.InterfaceC0500D;

/* loaded from: classes.dex */
public abstract class I0 implements InterfaceC0500D {

    /* renamed from: C, reason: collision with root package name */
    public static final Method f5530C;

    /* renamed from: D, reason: collision with root package name */
    public static final Method f5531D;

    /* renamed from: A, reason: collision with root package name */
    public boolean f5532A;

    /* renamed from: B, reason: collision with root package name */
    public final C0581z f5533B;

    /* renamed from: a, reason: collision with root package name */
    public final Context f5534a;

    /* renamed from: b, reason: collision with root package name */
    public ListAdapter f5535b;

    /* renamed from: c, reason: collision with root package name */
    public C0576w0 f5536c;

    /* renamed from: f, reason: collision with root package name */
    public int f5539f;

    /* renamed from: j, reason: collision with root package name */
    public int f5540j;

    /* renamed from: l, reason: collision with root package name */
    public boolean f5542l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f5543m;

    /* renamed from: n, reason: collision with root package name */
    public boolean f5544n;

    /* renamed from: q, reason: collision with root package name */
    public P.b f5546q;

    /* renamed from: r, reason: collision with root package name */
    public View f5547r;

    /* renamed from: s, reason: collision with root package name */
    public AdapterView.OnItemClickListener f5548s;

    /* renamed from: x, reason: collision with root package name */
    public final Handler f5553x;

    /* renamed from: z, reason: collision with root package name */
    public Rect f5554z;

    /* renamed from: d, reason: collision with root package name */
    public final int f5537d = -2;

    /* renamed from: e, reason: collision with root package name */
    public int f5538e = -2;

    /* renamed from: k, reason: collision with root package name */
    public final int f5541k = 1002;

    /* renamed from: o, reason: collision with root package name */
    public int f5545o = 0;
    public final int p = Api.BaseClientBuilder.API_PRIORITY_OTHER;

    /* renamed from: t, reason: collision with root package name */
    public final F0 f5549t = new F0(this, 1);

    /* renamed from: u, reason: collision with root package name */
    public final H0 f5550u = new H0(this);

    /* renamed from: v, reason: collision with root package name */
    public final G0 f5551v = new G0(this);

    /* renamed from: w, reason: collision with root package name */
    public final F0 f5552w = new F0(this, 0);
    public final Rect y = new Rect();

    static {
        if (Build.VERSION.SDK_INT <= 28) {
            try {
                f5530C = PopupWindow.class.getDeclaredMethod("setClipToScreenEnabled", Boolean.TYPE);
            } catch (NoSuchMethodException unused) {
            }
            try {
                f5531D = PopupWindow.class.getDeclaredMethod("setEpicenterBounds", Rect.class);
            } catch (NoSuchMethodException unused2) {
            }
        }
    }

    /* JADX WARN: Type inference failed for: r1v9, types: [m.z, android.widget.PopupWindow] */
    public I0(Context context, AttributeSet attributeSet, int i) {
        Drawable drawable;
        int resourceId;
        this.f5534a = context;
        this.f5553x = new Handler(context.getMainLooper());
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, AbstractC0424a.f4640o, i, 0);
        this.f5539f = obtainStyledAttributes.getDimensionPixelOffset(0, 0);
        int dimensionPixelOffset = obtainStyledAttributes.getDimensionPixelOffset(1, 0);
        this.f5540j = dimensionPixelOffset;
        if (dimensionPixelOffset != 0) {
            this.f5542l = true;
        }
        obtainStyledAttributes.recycle();
        ?? popupWindow = new PopupWindow(context, attributeSet, i, 0);
        TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, AbstractC0424a.f4643s, i, 0);
        if (obtainStyledAttributes2.hasValue(2)) {
            popupWindow.setOverlapAnchor(obtainStyledAttributes2.getBoolean(2, false));
        }
        if (obtainStyledAttributes2.hasValue(0) && (resourceId = obtainStyledAttributes2.getResourceId(0, 0)) != 0) {
            drawable = AbstractC0228a.q(context, resourceId);
        } else {
            drawable = obtainStyledAttributes2.getDrawable(0);
        }
        popupWindow.setBackgroundDrawable(drawable);
        obtainStyledAttributes2.recycle();
        this.f5533B = popupWindow;
        popupWindow.setInputMethodMode(1);
    }

    @Override // l.InterfaceC0500D
    public final boolean a() {
        return this.f5533B.isShowing();
    }

    public final int b() {
        return this.f5539f;
    }

    public final void c(int i) {
        this.f5539f = i;
    }

    @Override // l.InterfaceC0500D
    public final void dismiss() {
        C0581z c0581z = this.f5533B;
        c0581z.dismiss();
        c0581z.setContentView(null);
        this.f5536c = null;
        this.f5553x.removeCallbacks(this.f5549t);
    }

    public final Drawable f() {
        return this.f5533B.getBackground();
    }

    @Override // l.InterfaceC0500D
    public final C0576w0 g() {
        return this.f5536c;
    }

    public final void i(Drawable drawable) {
        this.f5533B.setBackgroundDrawable(drawable);
    }

    public final void j(int i) {
        this.f5540j = i;
        this.f5542l = true;
    }

    public final int n() {
        if (!this.f5542l) {
            return 0;
        }
        return this.f5540j;
    }

    public void o(ListAdapter listAdapter) {
        P.b bVar = this.f5546q;
        if (bVar == null) {
            this.f5546q = new P.b(this, 1);
        } else {
            ListAdapter listAdapter2 = this.f5535b;
            if (listAdapter2 != null) {
                listAdapter2.unregisterDataSetObserver(bVar);
            }
        }
        this.f5535b = listAdapter;
        if (listAdapter != null) {
            listAdapter.registerDataSetObserver(this.f5546q);
        }
        C0576w0 c0576w0 = this.f5536c;
        if (c0576w0 != null) {
            c0576w0.setAdapter(this.f5535b);
        }
    }

    public C0576w0 p(Context context, boolean z3) {
        return new C0576w0(context, z3);
    }

    public final void q(int i) {
        Drawable background = this.f5533B.getBackground();
        if (background != null) {
            Rect rect = this.y;
            background.getPadding(rect);
            this.f5538e = rect.left + rect.right + i;
            return;
        }
        this.f5538e = i;
    }

    @Override // l.InterfaceC0500D
    public final void show() {
        int i;
        boolean z3;
        int makeMeasureSpec;
        int i3;
        int i4;
        boolean z4;
        C0576w0 c0576w0;
        int i5;
        int i6;
        C0576w0 c0576w02 = this.f5536c;
        Context context = this.f5534a;
        C0581z c0581z = this.f5533B;
        int i7 = 0;
        if (c0576w02 == null) {
            C0576w0 p = p(context, !this.f5532A);
            this.f5536c = p;
            p.setAdapter(this.f5535b);
            this.f5536c.setOnItemClickListener(this.f5548s);
            this.f5536c.setFocusable(true);
            this.f5536c.setFocusableInTouchMode(true);
            this.f5536c.setOnItemSelectedListener(new C0(this, 0));
            this.f5536c.setOnScrollListener(this.f5551v);
            c0581z.setContentView(this.f5536c);
        }
        Drawable background = c0581z.getBackground();
        Rect rect = this.y;
        if (background != null) {
            background.getPadding(rect);
            int i8 = rect.top;
            i = rect.bottom + i8;
            if (!this.f5542l) {
                this.f5540j = -i8;
            }
        } else {
            rect.setEmpty();
            i = 0;
        }
        if (c0581z.getInputMethodMode() == 2) {
            z3 = true;
        } else {
            z3 = false;
        }
        int a2 = D0.a(c0581z, this.f5547r, this.f5540j, z3);
        int i9 = this.f5537d;
        if (i9 == -1) {
            i4 = a2 + i;
        } else {
            int i10 = this.f5538e;
            if (i10 != -2) {
                if (i10 != -1) {
                    makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i10, 1073741824);
                } else {
                    makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(context.getResources().getDisplayMetrics().widthPixels - (rect.left + rect.right), 1073741824);
                }
            } else {
                makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(context.getResources().getDisplayMetrics().widthPixels - (rect.left + rect.right), Integer.MIN_VALUE);
            }
            int a4 = this.f5536c.a(makeMeasureSpec, a2);
            if (a4 > 0) {
                i3 = this.f5536c.getPaddingBottom() + this.f5536c.getPaddingTop() + i;
            } else {
                i3 = 0;
            }
            i4 = a4 + i3;
        }
        if (this.f5533B.getInputMethodMode() == 2) {
            z4 = true;
        } else {
            z4 = false;
        }
        c0581z.setWindowLayoutType(this.f5541k);
        if (c0581z.isShowing()) {
            View view = this.f5547r;
            WeakHashMap weakHashMap = J.S.f954a;
            if (view.isAttachedToWindow()) {
                int i11 = this.f5538e;
                if (i11 == -1) {
                    i11 = -1;
                } else if (i11 == -2) {
                    i11 = this.f5547r.getWidth();
                }
                if (i9 == -1) {
                    if (z4) {
                        i9 = i4;
                    } else {
                        i9 = -1;
                    }
                    if (z4) {
                        if (this.f5538e == -1) {
                            i6 = -1;
                        } else {
                            i6 = 0;
                        }
                        c0581z.setWidth(i6);
                        c0581z.setHeight(0);
                    } else {
                        if (this.f5538e == -1) {
                            i7 = -1;
                        }
                        c0581z.setWidth(i7);
                        c0581z.setHeight(-1);
                    }
                } else if (i9 == -2) {
                    i9 = i4;
                }
                c0581z.setOutsideTouchable(true);
                View view2 = this.f5547r;
                int i12 = i11;
                int i13 = this.f5539f;
                int i14 = this.f5540j;
                if (i12 < 0) {
                    i5 = -1;
                } else {
                    i5 = i12;
                }
                if (i9 < 0) {
                    i9 = -1;
                }
                c0581z.update(view2, i13, i14, i5, i9);
                return;
            }
            return;
        }
        int i15 = this.f5538e;
        if (i15 == -1) {
            i15 = -1;
        } else if (i15 == -2) {
            i15 = this.f5547r.getWidth();
        }
        if (i9 == -1) {
            i9 = -1;
        } else if (i9 == -2) {
            i9 = i4;
        }
        c0581z.setWidth(i15);
        c0581z.setHeight(i9);
        if (Build.VERSION.SDK_INT <= 28) {
            Method method = f5530C;
            if (method != null) {
                try {
                    method.invoke(c0581z, Boolean.TRUE);
                } catch (Exception unused) {
                }
            }
        } else {
            E0.b(c0581z, true);
        }
        c0581z.setOutsideTouchable(true);
        c0581z.setTouchInterceptor(this.f5550u);
        if (this.f5544n) {
            c0581z.setOverlapAnchor(this.f5543m);
        }
        if (Build.VERSION.SDK_INT <= 28) {
            Method method2 = f5531D;
            if (method2 != null) {
                try {
                    method2.invoke(c0581z, this.f5554z);
                } catch (Exception e4) {
                    Log.e("ListPopupWindow", "Could not invoke setEpicenterBounds on PopupWindow", e4);
                }
            }
        } else {
            E0.a(c0581z, this.f5554z);
        }
        c0581z.showAsDropDown(this.f5547r, this.f5539f, this.f5540j, this.f5545o);
        this.f5536c.setSelection(-1);
        if ((!this.f5532A || this.f5536c.isInTouchMode()) && (c0576w0 = this.f5536c) != null) {
            c0576w0.setListSelectionHidden(true);
            c0576w0.requestLayout();
        }
        if (!this.f5532A) {
            this.f5553x.post(this.f5552w);
        }
    }
}
