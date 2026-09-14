package s0;

import android.graphics.Matrix;
import android.view.View;

/* loaded from: classes.dex */
class h0 {
    public void a(View view) {
        if (view.getVisibility() == 0) {
            view.setTag(j.f13938a, null);
        }
    }

    public float b(View view) {
        Float f10 = (Float) view.getTag(j.f13938a);
        float alpha = view.getAlpha();
        return f10 != null ? alpha / f10.floatValue() : alpha;
    }

    public void c(View view) {
        int i10 = j.f13938a;
        if (view.getTag(i10) == null) {
            view.setTag(i10, Float.valueOf(view.getAlpha()));
        }
    }

    public void d(View view, int i10, int i11, int i12, int i13) {
        view.setLeft(i10);
        view.setTop(i11);
        view.setRight(i12);
        view.setBottom(i13);
    }

    public void e(View view, float f10) {
        Float f11 = (Float) view.getTag(j.f13938a);
        if (f11 != null) {
            view.setAlpha(f11.floatValue() * f10);
        } else {
            view.setAlpha(f10);
        }
    }

    public void f(View view, Matrix matrix) {
        Object parent = view.getParent();
        if (parent instanceof View) {
            f((View) parent, matrix);
            matrix.preTranslate(-r0.getScrollX(), -r0.getScrollY());
        }
        matrix.preTranslate(view.getLeft(), view.getTop());
        Matrix matrix2 = view.getMatrix();
        if (matrix2.isIdentity()) {
            return;
        }
        matrix.preConcat(matrix2);
    }

    public void g(View view, Matrix matrix) {
        Object parent = view.getParent();
        if (parent instanceof View) {
            g((View) parent, matrix);
            matrix.postTranslate(r0.getScrollX(), r0.getScrollY());
        }
        matrix.postTranslate(view.getLeft(), view.getTop());
        Matrix matrix2 = view.getMatrix();
        if (matrix2.isIdentity()) {
            return;
        }
        Matrix matrix3 = new Matrix();
        if (matrix2.invert(matrix3)) {
            matrix.postConcat(matrix3);
        }
    }
}
