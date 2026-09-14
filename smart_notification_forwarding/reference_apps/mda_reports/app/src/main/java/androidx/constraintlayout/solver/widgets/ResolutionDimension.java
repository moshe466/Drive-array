package androidx.constraintlayout.solver.widgets;

/* loaded from: classes.dex */
public class ResolutionDimension extends ResolutionNode {
    float c = 0.0f;

    public void remove() {
        this.b = 2;
    }

    @Override // androidx.constraintlayout.solver.widgets.ResolutionNode
    public void reset() {
        super.reset();
        this.c = 0.0f;
    }

    public void resolve(int i) {
        if (this.b == 0 || this.c != i) {
            this.c = i;
            if (this.b == 1) {
                invalidate();
            }
            didResolve();
        }
    }
}
