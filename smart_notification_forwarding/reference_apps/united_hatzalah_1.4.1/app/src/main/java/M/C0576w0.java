package m;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.uh.sf.R;
import java.lang.reflect.InvocationTargetException;

/* renamed from: m.w0, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0576w0 extends ListView {

    /* renamed from: a, reason: collision with root package name */
    public final Rect f5815a;

    /* renamed from: b, reason: collision with root package name */
    public int f5816b;

    /* renamed from: c, reason: collision with root package name */
    public int f5817c;

    /* renamed from: d, reason: collision with root package name */
    public int f5818d;

    /* renamed from: e, reason: collision with root package name */
    public int f5819e;

    /* renamed from: f, reason: collision with root package name */
    public int f5820f;

    /* renamed from: j, reason: collision with root package name */
    public C0572u0 f5821j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f5822k;

    /* renamed from: l, reason: collision with root package name */
    public final boolean f5823l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f5824m;

    /* renamed from: n, reason: collision with root package name */
    public M.d f5825n;

    /* renamed from: o, reason: collision with root package name */
    public G.a f5826o;

    public C0576w0(Context context, boolean z3) {
        super(context, null, R.attr.dropDownListViewStyle);
        this.f5815a = new Rect();
        this.f5816b = 0;
        this.f5817c = 0;
        this.f5818d = 0;
        this.f5819e = 0;
        this.f5823l = z3;
        setCacheColorHint(0);
    }

    public final int a(int i, int i3) {
        int makeMeasureSpec;
        int listPaddingTop = getListPaddingTop();
        int listPaddingBottom = getListPaddingBottom();
        int dividerHeight = getDividerHeight();
        Drawable divider = getDivider();
        ListAdapter adapter = getAdapter();
        if (adapter == null) {
            return listPaddingTop + listPaddingBottom;
        }
        int i4 = listPaddingTop + listPaddingBottom;
        if (dividerHeight <= 0 || divider == null) {
            dividerHeight = 0;
        }
        int count = adapter.getCount();
        int i5 = 0;
        View view = null;
        for (int i6 = 0; i6 < count; i6++) {
            int itemViewType = adapter.getItemViewType(i6);
            if (itemViewType != i5) {
                view = null;
                i5 = itemViewType;
            }
            view = adapter.getView(i6, view, this);
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = generateDefaultLayoutParams();
                view.setLayoutParams(layoutParams);
            }
            int i7 = layoutParams.height;
            if (i7 > 0) {
                makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i7, 1073741824);
            } else {
                makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
            }
            view.measure(i, makeMeasureSpec);
            view.forceLayout();
            if (i6 > 0) {
                i4 += dividerHeight;
            }
            i4 += view.getMeasuredHeight();
            if (i4 >= i3) {
                return i3;
            }
        }
        return i4;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0166  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x017c  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0161  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x014a A[ADDED_TO_REGION] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean b(android.view.MotionEvent r18, int r19) {
        /*
            Method dump skipped, instructions count: 394
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: m.C0576w0.b(android.view.MotionEvent, int):boolean");
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.view.ViewGroup, android.view.View
    public final void dispatchDraw(Canvas canvas) {
        Drawable selector;
        Rect rect = this.f5815a;
        if (!rect.isEmpty() && (selector = getSelector()) != null) {
            selector.setBounds(rect);
            selector.draw(canvas);
        }
        super.dispatchDraw(canvas);
    }

    @Override // android.widget.AbsListView, android.view.ViewGroup, android.view.View
    public final void drawableStateChanged() {
        if (this.f5826o == null) {
            super.drawableStateChanged();
            C0572u0 c0572u0 = this.f5821j;
            if (c0572u0 != null) {
                c0572u0.f5794b = true;
            }
            Drawable selector = getSelector();
            if (selector != null && this.f5824m && isPressed()) {
                selector.setState(getDrawableState());
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean hasFocus() {
        if (!this.f5823l && !super.hasFocus()) {
            return false;
        }
        return true;
    }

    @Override // android.view.View
    public final boolean hasWindowFocus() {
        if (!this.f5823l && !super.hasWindowFocus()) {
            return false;
        }
        return true;
    }

    @Override // android.view.View
    public final boolean isFocused() {
        if (!this.f5823l && !super.isFocused()) {
            return false;
        }
        return true;
    }

    @Override // android.view.View
    public final boolean isInTouchMode() {
        if ((this.f5823l && this.f5822k) || super.isInTouchMode()) {
            return true;
        }
        return false;
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.widget.AdapterView, android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        this.f5826o = null;
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public boolean onHoverEvent(MotionEvent motionEvent) {
        int i = Build.VERSION.SDK_INT;
        if (i < 26) {
            return super.onHoverEvent(motionEvent);
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 10 && this.f5826o == null) {
            G.a aVar = new G.a(this, 7);
            this.f5826o = aVar;
            post(aVar);
        }
        boolean onHoverEvent = super.onHoverEvent(motionEvent);
        if (actionMasked != 9 && actionMasked != 7) {
            setSelection(-1);
            return onHoverEvent;
        }
        int pointToPosition = pointToPosition((int) motionEvent.getX(), (int) motionEvent.getY());
        if (pointToPosition != -1 && pointToPosition != getSelectedItemPosition()) {
            View childAt = getChildAt(pointToPosition - getFirstVisiblePosition());
            if (childAt.isEnabled()) {
                requestFocus();
                if (i >= 30 && AbstractC0568s0.f5771d) {
                    try {
                        AbstractC0568s0.f5768a.invoke(this, Integer.valueOf(pointToPosition), childAt, Boolean.FALSE, -1, -1);
                        AbstractC0568s0.f5769b.invoke(this, Integer.valueOf(pointToPosition));
                        AbstractC0568s0.f5770c.invoke(this, Integer.valueOf(pointToPosition));
                    } catch (IllegalAccessException e4) {
                        e4.printStackTrace();
                    } catch (InvocationTargetException e5) {
                        e5.printStackTrace();
                    }
                } else {
                    setSelectionFromTop(pointToPosition, childAt.getTop() - getTop());
                }
            }
            Drawable selector = getSelector();
            if (selector != null && this.f5824m && isPressed()) {
                selector.setState(getDrawableState());
            }
        }
        return onHoverEvent;
    }

    @Override // android.widget.AbsListView, android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            this.f5820f = pointToPosition((int) motionEvent.getX(), (int) motionEvent.getY());
        }
        G.a aVar = this.f5826o;
        if (aVar != null) {
            C0576w0 c0576w0 = (C0576w0) aVar.f765b;
            c0576w0.f5826o = null;
            c0576w0.removeCallbacks(aVar);
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setListSelectionHidden(boolean z3) {
        this.f5822k = z3;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [android.graphics.drawable.Drawable$Callback, android.graphics.drawable.Drawable, m.u0] */
    @Override // android.widget.AbsListView
    public void setSelector(Drawable drawable) {
        C0572u0 c0572u0 = null;
        if (drawable != 0) {
            ?? drawable2 = new Drawable();
            Drawable drawable3 = drawable2.f5793a;
            if (drawable3 != null) {
                drawable3.setCallback(null);
            }
            drawable2.f5793a = drawable;
            drawable.setCallback(drawable2);
            drawable2.f5794b = true;
            c0572u0 = drawable2;
        }
        this.f5821j = c0572u0;
        super.setSelector(c0572u0);
        Rect rect = new Rect();
        if (drawable != 0) {
            drawable.getPadding(rect);
        }
        this.f5816b = rect.left;
        this.f5817c = rect.top;
        this.f5818d = rect.right;
        this.f5819e = rect.bottom;
    }
}
