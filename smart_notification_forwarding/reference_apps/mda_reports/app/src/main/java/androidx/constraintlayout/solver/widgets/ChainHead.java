package androidx.constraintlayout.solver.widgets;

import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class ChainHead {
    protected ConstraintWidget a;
    protected ConstraintWidget b;
    protected ConstraintWidget c;
    protected ConstraintWidget d;
    protected ConstraintWidget e;
    protected ConstraintWidget f;
    protected ConstraintWidget g;
    protected ArrayList<ConstraintWidget> h;
    protected int i;
    protected int j;
    protected float k = 0.0f;
    protected boolean l;
    protected boolean m;
    private boolean mDefined;
    private boolean mIsRtl;
    private int mOrientation;
    protected boolean n;

    public ChainHead(ConstraintWidget constraintWidget, int i, boolean z) {
        this.mIsRtl = false;
        this.a = constraintWidget;
        this.mOrientation = i;
        this.mIsRtl = z;
    }

    private void defineChainProperties() {
        int i = this.mOrientation * 2;
        boolean z = false;
        ConstraintWidget constraintWidget = this.a;
        ConstraintWidget constraintWidget2 = constraintWidget;
        boolean z2 = false;
        while (!z2) {
            this.i++;
            ConstraintWidget[] constraintWidgetArr = constraintWidget.Y;
            int i2 = this.mOrientation;
            ConstraintWidget constraintWidget3 = null;
            constraintWidgetArr[i2] = null;
            constraintWidget.X[i2] = null;
            if (constraintWidget.getVisibility() != 8) {
                if (this.b == null) {
                    this.b = constraintWidget;
                }
                this.d = constraintWidget;
                ConstraintWidget.DimensionBehaviour[] dimensionBehaviourArr = constraintWidget.A;
                int i3 = this.mOrientation;
                if (dimensionBehaviourArr[i3] == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                    int[] iArr = constraintWidget.e;
                    if (iArr[i3] == 0 || iArr[i3] == 3 || iArr[i3] == 2) {
                        this.j++;
                        float[] fArr = constraintWidget.W;
                        int i4 = this.mOrientation;
                        float f = fArr[i4];
                        if (f > 0.0f) {
                            this.k += fArr[i4];
                        }
                        if (isMatchConstraintEqualityCandidate(constraintWidget, this.mOrientation)) {
                            if (f < 0.0f) {
                                this.l = true;
                            } else {
                                this.m = true;
                            }
                            if (this.h == null) {
                                this.h = new ArrayList<>();
                            }
                            this.h.add(constraintWidget);
                        }
                        if (this.f == null) {
                            this.f = constraintWidget;
                        }
                        ConstraintWidget constraintWidget4 = this.g;
                        if (constraintWidget4 != null) {
                            constraintWidget4.X[this.mOrientation] = constraintWidget;
                        }
                        this.g = constraintWidget;
                    }
                }
            }
            if (constraintWidget2 != constraintWidget) {
                constraintWidget2.Y[this.mOrientation] = constraintWidget;
            }
            ConstraintAnchor constraintAnchor = constraintWidget.y[i + 1].c;
            if (constraintAnchor != null) {
                ConstraintWidget constraintWidget5 = constraintAnchor.a;
                ConstraintAnchor[] constraintAnchorArr = constraintWidget5.y;
                if (constraintAnchorArr[i].c != null && constraintAnchorArr[i].c.a == constraintWidget) {
                    constraintWidget3 = constraintWidget5;
                }
            }
            if (constraintWidget3 == null) {
                constraintWidget3 = constraintWidget;
                z2 = true;
            }
            constraintWidget2 = constraintWidget;
            constraintWidget = constraintWidget3;
        }
        this.c = constraintWidget;
        this.e = (this.mOrientation == 0 && this.mIsRtl) ? this.c : this.a;
        if (this.m && this.l) {
            z = true;
        }
        this.n = z;
    }

    private static boolean isMatchConstraintEqualityCandidate(ConstraintWidget constraintWidget, int i) {
        if (constraintWidget.getVisibility() != 8 && constraintWidget.A[i] == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
            int[] iArr = constraintWidget.e;
            if (iArr[i] == 0 || iArr[i] == 3) {
                return true;
            }
        }
        return false;
    }

    public void define() {
        if (!this.mDefined) {
            defineChainProperties();
        }
        this.mDefined = true;
    }

    public ConstraintWidget getFirst() {
        return this.a;
    }

    public ConstraintWidget getFirstMatchConstraintWidget() {
        return this.f;
    }

    public ConstraintWidget getFirstVisibleWidget() {
        return this.b;
    }

    public ConstraintWidget getHead() {
        return this.e;
    }

    public ConstraintWidget getLast() {
        return this.c;
    }

    public ConstraintWidget getLastMatchConstraintWidget() {
        return this.g;
    }

    public ConstraintWidget getLastVisibleWidget() {
        return this.d;
    }

    public float getTotalWeight() {
        return this.k;
    }
}
