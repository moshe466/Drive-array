package q0;

import android.graphics.Matrix;
import android.view.View;

/* loaded from: classes.dex */
public final class A extends z {
    @Override // m3.b
    public final void O(View view, float f4) {
        view.setTransitionAlpha(f4);
    }

    @Override // q0.z, m3.b
    public final void P(View view, int i) {
        view.setTransitionVisibility(i);
    }

    @Override // q0.z
    public final void Y(View view, int i, int i3, int i4, int i5) {
        view.setLeftTopRightBottom(i, i3, i4, i5);
    }

    @Override // q0.z
    public final void Z(View view, Matrix matrix) {
        view.transformMatrixToGlobal(matrix);
    }

    @Override // q0.z
    public final void a0(View view, Matrix matrix) {
        view.transformMatrixToLocal(matrix);
    }

    @Override // m3.b
    public final float w(View view) {
        float transitionAlpha;
        transitionAlpha = view.getTransitionAlpha();
        return transitionAlpha;
    }
}
