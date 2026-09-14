package androidx.transition;

import android.annotation.SuppressLint;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.core.view.ViewCompat;

@SuppressLint({"ViewConstructor"})
/* loaded from: classes.dex */
class GhostViewApi14 extends View implements GhostViewImpl {
    final View a;
    ViewGroup b;
    View c;
    int d;
    Matrix e;
    private int mDeltaX;
    private int mDeltaY;
    private final Matrix mMatrix;
    private final ViewTreeObserver.OnPreDrawListener mOnPreDrawListener;

    GhostViewApi14(View view) {
        super(view.getContext());
        this.mMatrix = new Matrix();
        this.mOnPreDrawListener = new ViewTreeObserver.OnPreDrawListener() { // from class: androidx.transition.GhostViewApi14.1
            @Override // android.view.ViewTreeObserver.OnPreDrawListener
            public boolean onPreDraw() {
                View view2;
                GhostViewApi14 ghostViewApi14 = GhostViewApi14.this;
                ghostViewApi14.e = ghostViewApi14.a.getMatrix();
                ViewCompat.postInvalidateOnAnimation(GhostViewApi14.this);
                GhostViewApi14 ghostViewApi142 = GhostViewApi14.this;
                ViewGroup viewGroup = ghostViewApi142.b;
                if (viewGroup == null || (view2 = ghostViewApi142.c) == null) {
                    return true;
                }
                viewGroup.endViewTransition(view2);
                ViewCompat.postInvalidateOnAnimation(GhostViewApi14.this.b);
                GhostViewApi14 ghostViewApi143 = GhostViewApi14.this;
                ghostViewApi143.b = null;
                ghostViewApi143.c = null;
                return true;
            }
        };
        this.a = view;
        setLayerType(2, null);
    }

    static GhostViewApi14 a(@NonNull View view) {
        return (GhostViewApi14) view.getTag(R.id.ghost_view);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static GhostViewImpl a(View view, ViewGroup viewGroup) {
        GhostViewApi14 a = a(view);
        if (a == null) {
            FrameLayout findFrameLayout = findFrameLayout(viewGroup);
            if (findFrameLayout == null) {
                return null;
            }
            a = new GhostViewApi14(view);
            findFrameLayout.addView(a);
        }
        a.d++;
        return a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void b(View view) {
        GhostViewApi14 a = a(view);
        if (a != null) {
            a.d--;
            if (a.d <= 0) {
                ViewParent parent = a.getParent();
                if (parent instanceof ViewGroup) {
                    ViewGroup viewGroup = (ViewGroup) parent;
                    viewGroup.endViewTransition(a);
                    viewGroup.removeView(a);
                }
            }
        }
    }

    private static FrameLayout findFrameLayout(ViewGroup viewGroup) {
        while (!(viewGroup instanceof FrameLayout)) {
            ViewParent parent = viewGroup.getParent();
            if (!(parent instanceof ViewGroup)) {
                return null;
            }
            viewGroup = (ViewGroup) parent;
        }
        return (FrameLayout) viewGroup;
    }

    private static void setGhostView(@NonNull View view, GhostViewApi14 ghostViewApi14) {
        view.setTag(R.id.ghost_view, ghostViewApi14);
    }

    @Override // android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        setGhostView(this.a, this);
        int[] iArr = new int[2];
        getLocationOnScreen(iArr);
        this.a.getLocationOnScreen(r0);
        int[] iArr2 = {(int) (iArr2[0] - this.a.getTranslationX()), (int) (iArr2[1] - this.a.getTranslationY())};
        this.mDeltaX = iArr2[0] - iArr[0];
        this.mDeltaY = iArr2[1] - iArr[1];
        this.a.getViewTreeObserver().addOnPreDrawListener(this.mOnPreDrawListener);
        this.a.setVisibility(4);
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        this.a.getViewTreeObserver().removeOnPreDrawListener(this.mOnPreDrawListener);
        this.a.setVisibility(0);
        setGhostView(this.a, null);
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        this.mMatrix.set(this.e);
        this.mMatrix.postTranslate(this.mDeltaX, this.mDeltaY);
        canvas.setMatrix(this.mMatrix);
        this.a.draw(canvas);
    }

    @Override // androidx.transition.GhostViewImpl
    public void reserveEndViewTransition(ViewGroup viewGroup, View view) {
        this.b = viewGroup;
        this.c = view;
    }

    @Override // android.view.View, androidx.transition.GhostViewImpl
    public void setVisibility(int i) {
        super.setVisibility(i);
        this.a.setVisibility(i == 0 ? 4 : 0);
    }
}
