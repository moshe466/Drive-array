package m;

import F0.b3;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.appcompat.widget.Toolbar;
import com.uh.sf.R;
import g.AbstractC0424a;

/* loaded from: classes.dex */
public final class s1 implements InterfaceC0559n0 {

    /* renamed from: a, reason: collision with root package name */
    public final Toolbar f5772a;

    /* renamed from: b, reason: collision with root package name */
    public int f5773b;

    /* renamed from: c, reason: collision with root package name */
    public final View f5774c;

    /* renamed from: d, reason: collision with root package name */
    public Drawable f5775d;

    /* renamed from: e, reason: collision with root package name */
    public Drawable f5776e;

    /* renamed from: f, reason: collision with root package name */
    public final Drawable f5777f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f5778g;

    /* renamed from: h, reason: collision with root package name */
    public CharSequence f5779h;
    public final CharSequence i;

    /* renamed from: j, reason: collision with root package name */
    public final CharSequence f5780j;

    /* renamed from: k, reason: collision with root package name */
    public Window.Callback f5781k;

    /* renamed from: l, reason: collision with root package name */
    public boolean f5782l;

    /* renamed from: m, reason: collision with root package name */
    public C0548i f5783m;

    /* renamed from: n, reason: collision with root package name */
    public final int f5784n;

    /* renamed from: o, reason: collision with root package name */
    public final Drawable f5785o;

    public s1(Toolbar toolbar, boolean z3) {
        boolean z4;
        Drawable drawable;
        this.f5784n = 0;
        this.f5772a = toolbar;
        this.f5779h = toolbar.getTitle();
        this.i = toolbar.getSubtitle();
        if (this.f5779h != null) {
            z4 = true;
        } else {
            z4 = false;
        }
        this.f5778g = z4;
        this.f5777f = toolbar.getNavigationIcon();
        b3 t3 = b3.t(toolbar.getContext(), null, AbstractC0424a.f4627a, R.attr.actionBarStyle);
        TypedArray typedArray = (TypedArray) t3.f470c;
        int i = 15;
        this.f5785o = t3.o(15);
        if (z3) {
            CharSequence text = typedArray.getText(27);
            if (!TextUtils.isEmpty(text)) {
                this.f5778g = true;
                Toolbar toolbar2 = this.f5772a;
                this.f5779h = text;
                if ((this.f5773b & 8) != 0) {
                    toolbar2.setTitle(text);
                    if (this.f5778g) {
                        J.S.j(toolbar2.getRootView(), text);
                    }
                }
            }
            CharSequence text2 = typedArray.getText(25);
            if (!TextUtils.isEmpty(text2)) {
                this.i = text2;
                if ((this.f5773b & 8) != 0) {
                    toolbar.setSubtitle(text2);
                }
            }
            Drawable o2 = t3.o(20);
            if (o2 != null) {
                this.f5776e = o2;
                c();
            }
            Drawable o4 = t3.o(17);
            if (o4 != null) {
                this.f5775d = o4;
                c();
            }
            if (this.f5777f == null && (drawable = this.f5785o) != null) {
                this.f5777f = drawable;
                Toolbar toolbar3 = this.f5772a;
                if ((this.f5773b & 4) != 0) {
                    toolbar3.setNavigationIcon(drawable);
                } else {
                    toolbar3.setNavigationIcon((Drawable) null);
                }
            }
            a(typedArray.getInt(10, 0));
            int resourceId = typedArray.getResourceId(9, 0);
            if (resourceId != 0) {
                View inflate = LayoutInflater.from(toolbar.getContext()).inflate(resourceId, (ViewGroup) toolbar, false);
                View view = this.f5774c;
                if (view != null && (this.f5773b & 16) != 0) {
                    toolbar.removeView(view);
                }
                this.f5774c = inflate;
                if (inflate != null && (this.f5773b & 16) != 0) {
                    toolbar.addView(inflate);
                }
                a(this.f5773b | 16);
            }
            int layoutDimension = typedArray.getLayoutDimension(13, 0);
            if (layoutDimension > 0) {
                ViewGroup.LayoutParams layoutParams = toolbar.getLayoutParams();
                layoutParams.height = layoutDimension;
                toolbar.setLayoutParams(layoutParams);
            }
            int dimensionPixelOffset = typedArray.getDimensionPixelOffset(7, -1);
            int dimensionPixelOffset2 = typedArray.getDimensionPixelOffset(3, -1);
            if (dimensionPixelOffset >= 0 || dimensionPixelOffset2 >= 0) {
                int max = Math.max(dimensionPixelOffset, 0);
                int max2 = Math.max(dimensionPixelOffset2, 0);
                toolbar.d();
                toolbar.f3004w.a(max, max2);
            }
            int resourceId2 = typedArray.getResourceId(28, 0);
            if (resourceId2 != 0) {
                Context context = toolbar.getContext();
                toolbar.f2997o = resourceId2;
                C0537c0 c0537c0 = toolbar.f2987b;
                if (c0537c0 != null) {
                    c0537c0.setTextAppearance(context, resourceId2);
                }
            }
            int resourceId3 = typedArray.getResourceId(26, 0);
            if (resourceId3 != 0) {
                Context context2 = toolbar.getContext();
                toolbar.p = resourceId3;
                C0537c0 c0537c02 = toolbar.f2988c;
                if (c0537c02 != null) {
                    c0537c02.setTextAppearance(context2, resourceId3);
                }
            }
            int resourceId4 = typedArray.getResourceId(22, 0);
            if (resourceId4 != 0) {
                toolbar.setPopupTheme(resourceId4);
            }
        } else {
            if (toolbar.getNavigationIcon() != null) {
                this.f5785o = toolbar.getNavigationIcon();
            } else {
                i = 11;
            }
            this.f5773b = i;
        }
        t3.v();
        if (R.string.abc_action_bar_up_description != this.f5784n) {
            this.f5784n = R.string.abc_action_bar_up_description;
            if (TextUtils.isEmpty(toolbar.getNavigationContentDescription())) {
                int i3 = this.f5784n;
                this.f5780j = i3 != 0 ? toolbar.getContext().getString(i3) : null;
                b();
            }
        }
        this.f5780j = toolbar.getNavigationContentDescription();
        toolbar.setNavigationOnClickListener(new r1(this));
    }

    public final void a(int i) {
        View view;
        int i3 = this.f5773b ^ i;
        this.f5773b = i;
        if (i3 != 0) {
            if ((i3 & 4) != 0) {
                if ((i & 4) != 0) {
                    b();
                }
                int i4 = this.f5773b & 4;
                Toolbar toolbar = this.f5772a;
                if (i4 != 0) {
                    Drawable drawable = this.f5777f;
                    if (drawable == null) {
                        drawable = this.f5785o;
                    }
                    toolbar.setNavigationIcon(drawable);
                } else {
                    toolbar.setNavigationIcon((Drawable) null);
                }
            }
            if ((i3 & 3) != 0) {
                c();
            }
            int i5 = i3 & 8;
            Toolbar toolbar2 = this.f5772a;
            if (i5 != 0) {
                if ((i & 8) != 0) {
                    toolbar2.setTitle(this.f5779h);
                    toolbar2.setSubtitle(this.i);
                } else {
                    toolbar2.setTitle((CharSequence) null);
                    toolbar2.setSubtitle((CharSequence) null);
                }
            }
            if ((i3 & 16) != 0 && (view = this.f5774c) != null) {
                if ((i & 16) != 0) {
                    toolbar2.addView(view);
                } else {
                    toolbar2.removeView(view);
                }
            }
        }
    }

    public final void b() {
        if ((this.f5773b & 4) != 0) {
            boolean isEmpty = TextUtils.isEmpty(this.f5780j);
            Toolbar toolbar = this.f5772a;
            if (isEmpty) {
                toolbar.setNavigationContentDescription(this.f5784n);
            } else {
                toolbar.setNavigationContentDescription(this.f5780j);
            }
        }
    }

    public final void c() {
        Drawable drawable;
        int i = this.f5773b;
        if ((i & 2) != 0) {
            if ((i & 1) != 0) {
                drawable = this.f5776e;
                if (drawable == null) {
                    drawable = this.f5775d;
                }
            } else {
                drawable = this.f5775d;
            }
        } else {
            drawable = null;
        }
        this.f5772a.setLogo(drawable);
    }
}
