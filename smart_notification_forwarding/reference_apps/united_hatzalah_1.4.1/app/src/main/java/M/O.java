package m;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ViewTreeObserver;
import android.widget.ListAdapter;
import com.uh.sf.R;
import l.ViewTreeObserverOnGlobalLayoutListenerC0506d;

/* loaded from: classes.dex */
public final class O extends I0 implements Q {

    /* renamed from: E, reason: collision with root package name */
    public CharSequence f5568E;

    /* renamed from: F, reason: collision with root package name */
    public L f5569F;

    /* renamed from: G, reason: collision with root package name */
    public final Rect f5570G;

    /* renamed from: H, reason: collision with root package name */
    public int f5571H;

    /* renamed from: I, reason: collision with root package name */
    public final /* synthetic */ S f5572I;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public O(S s3, Context context, AttributeSet attributeSet) {
        super(context, attributeSet, R.attr.spinnerStyle);
        this.f5572I = s3;
        this.f5570G = new Rect();
        this.f5547r = s3;
        this.f5532A = true;
        this.f5533B.setFocusable(true);
        this.f5548s = new M(this, 0);
    }

    @Override // m.Q
    public final CharSequence d() {
        return this.f5568E;
    }

    @Override // m.Q
    public final void h(CharSequence charSequence) {
        this.f5568E = charSequence;
    }

    @Override // m.Q
    public final void k(int i) {
        this.f5571H = i;
    }

    @Override // m.Q
    public final void l(int i, int i3) {
        ViewTreeObserver viewTreeObserver;
        C0581z c0581z = this.f5533B;
        boolean isShowing = c0581z.isShowing();
        r();
        this.f5533B.setInputMethodMode(2);
        show();
        C0576w0 c0576w0 = this.f5536c;
        c0576w0.setChoiceMode(1);
        AbstractC0530I.d(c0576w0, i);
        AbstractC0530I.c(c0576w0, i3);
        S s3 = this.f5572I;
        int selectedItemPosition = s3.getSelectedItemPosition();
        C0576w0 c0576w02 = this.f5536c;
        if (c0581z.isShowing() && c0576w02 != null) {
            c0576w02.setListSelectionHidden(false);
            c0576w02.setSelection(selectedItemPosition);
            if (c0576w02.getChoiceMode() != 0) {
                c0576w02.setItemChecked(selectedItemPosition, true);
            }
        }
        if (!isShowing && (viewTreeObserver = s3.getViewTreeObserver()) != null) {
            ViewTreeObserverOnGlobalLayoutListenerC0506d viewTreeObserverOnGlobalLayoutListenerC0506d = new ViewTreeObserverOnGlobalLayoutListenerC0506d(this, 3);
            viewTreeObserver.addOnGlobalLayoutListener(viewTreeObserverOnGlobalLayoutListenerC0506d);
            this.f5533B.setOnDismissListener(new N(this, viewTreeObserverOnGlobalLayoutListenerC0506d));
        }
    }

    @Override // m.I0, m.Q
    public final void o(ListAdapter listAdapter) {
        super.o(listAdapter);
        this.f5569F = (L) listAdapter;
    }

    public final void r() {
        int i;
        int i3;
        S s3 = this.f5572I;
        Rect rect = s3.f5592k;
        C0581z c0581z = this.f5533B;
        Drawable background = c0581z.getBackground();
        if (background != null) {
            background.getPadding(rect);
            if (z1.a(s3)) {
                i = rect.right;
            } else {
                i = -rect.left;
            }
        } else {
            i = 0;
            rect.right = 0;
            rect.left = 0;
        }
        int paddingLeft = s3.getPaddingLeft();
        int paddingRight = s3.getPaddingRight();
        int width = s3.getWidth();
        int i4 = s3.f5591j;
        if (i4 == -2) {
            int a2 = s3.a(this.f5569F, c0581z.getBackground());
            int i5 = (s3.getContext().getResources().getDisplayMetrics().widthPixels - rect.left) - rect.right;
            if (a2 > i5) {
                a2 = i5;
            }
            q(Math.max(a2, (width - paddingLeft) - paddingRight));
        } else if (i4 == -1) {
            q((width - paddingLeft) - paddingRight);
        } else {
            q(i4);
        }
        if (z1.a(s3)) {
            i3 = (((width - paddingRight) - this.f5538e) - this.f5571H) + i;
        } else {
            i3 = paddingLeft + this.f5571H + i;
        }
        this.f5539f = i3;
    }
}
