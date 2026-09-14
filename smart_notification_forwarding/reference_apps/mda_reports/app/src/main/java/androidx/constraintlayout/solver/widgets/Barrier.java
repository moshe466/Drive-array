package androidx.constraintlayout.solver.widgets;

import androidx.constraintlayout.solver.LinearSystem;
import androidx.constraintlayout.solver.SolverVariable;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class Barrier extends Helper {
    public static final int BOTTOM = 3;
    public static final int LEFT = 0;
    public static final int RIGHT = 1;
    public static final int TOP = 2;
    private int mBarrierType = 0;
    private ArrayList<ResolutionAnchor> mNodes = new ArrayList<>(4);
    private boolean mAllowsGoneWidget = true;

    @Override // androidx.constraintlayout.solver.widgets.ConstraintWidget
    public void addToSolver(LinearSystem linearSystem) {
        ConstraintAnchor[] constraintAnchorArr;
        boolean z;
        SolverVariable solverVariable;
        ConstraintAnchor constraintAnchor;
        int i;
        int i2;
        ConstraintAnchor[] constraintAnchorArr2 = this.y;
        constraintAnchorArr2[0] = this.q;
        constraintAnchorArr2[2] = this.r;
        constraintAnchorArr2[1] = this.s;
        constraintAnchorArr2[3] = this.t;
        int i3 = 0;
        while (true) {
            constraintAnchorArr = this.y;
            if (i3 >= constraintAnchorArr.length) {
                break;
            }
            constraintAnchorArr[i3].e = linearSystem.createObjectVariable(constraintAnchorArr[i3]);
            i3++;
        }
        int i4 = this.mBarrierType;
        if (i4 < 0 || i4 >= 4) {
            return;
        }
        ConstraintAnchor constraintAnchor2 = constraintAnchorArr[i4];
        for (int i5 = 0; i5 < this.a0; i5++) {
            ConstraintWidget constraintWidget = this.Z[i5];
            if ((this.mAllowsGoneWidget || constraintWidget.allowedInBarrier()) && ((((i = this.mBarrierType) == 0 || i == 1) && constraintWidget.getHorizontalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) || (((i2 = this.mBarrierType) == 2 || i2 == 3) && constraintWidget.getVerticalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT))) {
                z = true;
                break;
            }
        }
        z = false;
        int i6 = this.mBarrierType;
        if (i6 == 0 || i6 == 1 ? getParent().getHorizontalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT : getParent().getVerticalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
            z = false;
        }
        for (int i7 = 0; i7 < this.a0; i7++) {
            ConstraintWidget constraintWidget2 = this.Z[i7];
            if (this.mAllowsGoneWidget || constraintWidget2.allowedInBarrier()) {
                SolverVariable createObjectVariable = linearSystem.createObjectVariable(constraintWidget2.y[this.mBarrierType]);
                ConstraintAnchor[] constraintAnchorArr3 = constraintWidget2.y;
                int i8 = this.mBarrierType;
                constraintAnchorArr3[i8].e = createObjectVariable;
                if (i8 == 0 || i8 == 2) {
                    linearSystem.addLowerBarrier(constraintAnchor2.e, createObjectVariable, z);
                } else {
                    linearSystem.addGreaterBarrier(constraintAnchor2.e, createObjectVariable, z);
                }
            }
        }
        int i9 = this.mBarrierType;
        if (i9 == 0) {
            linearSystem.addEquality(this.s.e, this.q.e, 0, 6);
            if (z) {
                return;
            }
            solverVariable = this.q.e;
            constraintAnchor = this.B.s;
        } else if (i9 == 1) {
            linearSystem.addEquality(this.q.e, this.s.e, 0, 6);
            if (z) {
                return;
            }
            solverVariable = this.q.e;
            constraintAnchor = this.B.q;
        } else if (i9 == 2) {
            linearSystem.addEquality(this.t.e, this.r.e, 0, 6);
            if (z) {
                return;
            }
            solverVariable = this.r.e;
            constraintAnchor = this.B.t;
        } else {
            if (i9 != 3) {
                return;
            }
            linearSystem.addEquality(this.r.e, this.t.e, 0, 6);
            if (z) {
                return;
            }
            solverVariable = this.r.e;
            constraintAnchor = this.B.r;
        }
        linearSystem.addEquality(solverVariable, constraintAnchor.e, 0, 5);
    }

    @Override // androidx.constraintlayout.solver.widgets.ConstraintWidget
    public boolean allowedInBarrier() {
        return true;
    }

    public boolean allowsGoneWidget() {
        return this.mAllowsGoneWidget;
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0094 A[SYNTHETIC] */
    @Override // androidx.constraintlayout.solver.widgets.ConstraintWidget
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void analyze(int r8) {
        /*
            r7 = this;
            androidx.constraintlayout.solver.widgets.ConstraintWidget r8 = r7.B
            if (r8 != 0) goto L5
            return
        L5:
            androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer r8 = (androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer) r8
            r0 = 2
            boolean r8 = r8.optimizeFor(r0)
            if (r8 != 0) goto Lf
            return
        Lf:
            int r8 = r7.mBarrierType
            r1 = 3
            r2 = 1
            if (r8 == 0) goto L25
            if (r8 == r2) goto L22
            if (r8 == r0) goto L1f
            if (r8 == r1) goto L1c
            return
        L1c:
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r8 = r7.t
            goto L27
        L1f:
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r8 = r7.r
            goto L27
        L22:
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r8 = r7.s
            goto L27
        L25:
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r8 = r7.q
        L27:
            androidx.constraintlayout.solver.widgets.ResolutionAnchor r8 = r8.getResolutionNode()
            r3 = 5
            r8.setType(r3)
            int r3 = r7.mBarrierType
            r4 = 0
            r5 = 0
            if (r3 == 0) goto L44
            if (r3 != r2) goto L38
            goto L44
        L38:
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r3 = r7.q
            androidx.constraintlayout.solver.widgets.ResolutionAnchor r3 = r3.getResolutionNode()
            r3.resolve(r5, r4)
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r3 = r7.s
            goto L4f
        L44:
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r3 = r7.r
            androidx.constraintlayout.solver.widgets.ResolutionAnchor r3 = r3.getResolutionNode()
            r3.resolve(r5, r4)
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r3 = r7.t
        L4f:
            androidx.constraintlayout.solver.widgets.ResolutionAnchor r3 = r3.getResolutionNode()
            r3.resolve(r5, r4)
            java.util.ArrayList<androidx.constraintlayout.solver.widgets.ResolutionAnchor> r3 = r7.mNodes
            r3.clear()
            r3 = 0
        L5c:
            int r4 = r7.a0
            if (r3 >= r4) goto L97
            androidx.constraintlayout.solver.widgets.ConstraintWidget[] r4 = r7.Z
            r4 = r4[r3]
            boolean r6 = r7.mAllowsGoneWidget
            if (r6 != 0) goto L6f
            boolean r6 = r4.allowedInBarrier()
            if (r6 != 0) goto L6f
            goto L94
        L6f:
            int r6 = r7.mBarrierType
            if (r6 == 0) goto L84
            if (r6 == r2) goto L81
            if (r6 == r0) goto L7e
            if (r6 == r1) goto L7b
            r4 = r5
            goto L8a
        L7b:
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r4 = r4.t
            goto L86
        L7e:
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r4 = r4.r
            goto L86
        L81:
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r4 = r4.s
            goto L86
        L84:
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r4 = r4.q
        L86:
            androidx.constraintlayout.solver.widgets.ResolutionAnchor r4 = r4.getResolutionNode()
        L8a:
            if (r4 == 0) goto L94
            java.util.ArrayList<androidx.constraintlayout.solver.widgets.ResolutionAnchor> r6 = r7.mNodes
            r6.add(r4)
            r4.addDependent(r8)
        L94:
            int r3 = r3 + 1
            goto L5c
        L97:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.solver.widgets.Barrier.analyze(int):void");
    }

    @Override // androidx.constraintlayout.solver.widgets.ConstraintWidget
    public void resetResolutionNodes() {
        super.resetResolutionNodes();
        this.mNodes.clear();
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0030  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x005e  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0074  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0084  */
    @Override // androidx.constraintlayout.solver.widgets.ConstraintWidget
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void resolve() {
        /*
            r11 = this;
            int r0 = r11.mBarrierType
            r1 = 2139095039(0x7f7fffff, float:3.4028235E38)
            r2 = 3
            r3 = 2
            r4 = 1
            r5 = 0
            if (r0 == 0) goto L20
            if (r0 == r4) goto L18
            if (r0 == r3) goto L15
            if (r0 == r2) goto L12
            return
        L12:
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r0 = r11.t
            goto L1a
        L15:
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r0 = r11.r
            goto L22
        L18:
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r0 = r11.s
        L1a:
            androidx.constraintlayout.solver.widgets.ResolutionAnchor r0 = r0.getResolutionNode()
            r1 = 0
            goto L26
        L20:
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r0 = r11.q
        L22:
            androidx.constraintlayout.solver.widgets.ResolutionAnchor r0 = r0.getResolutionNode()
        L26:
            java.util.ArrayList<androidx.constraintlayout.solver.widgets.ResolutionAnchor> r5 = r11.mNodes
            int r5 = r5.size()
            r6 = 0
            r7 = 0
        L2e:
            if (r7 >= r5) goto L58
            java.util.ArrayList<androidx.constraintlayout.solver.widgets.ResolutionAnchor> r8 = r11.mNodes
            java.lang.Object r8 = r8.get(r7)
            androidx.constraintlayout.solver.widgets.ResolutionAnchor r8 = (androidx.constraintlayout.solver.widgets.ResolutionAnchor) r8
            int r9 = r8.b
            if (r9 == r4) goto L3d
            return
        L3d:
            int r9 = r11.mBarrierType
            if (r9 == 0) goto L4b
            if (r9 != r3) goto L44
            goto L4b
        L44:
            float r9 = r8.g
            int r10 = (r9 > r1 ? 1 : (r9 == r1 ? 0 : -1))
            if (r10 <= 0) goto L55
            goto L51
        L4b:
            float r9 = r8.g
            int r10 = (r9 > r1 ? 1 : (r9 == r1 ? 0 : -1))
            if (r10 >= 0) goto L55
        L51:
            androidx.constraintlayout.solver.widgets.ResolutionAnchor r1 = r8.f
            r6 = r1
            r1 = r9
        L55:
            int r7 = r7 + 1
            goto L2e
        L58:
            androidx.constraintlayout.solver.Metrics r5 = androidx.constraintlayout.solver.LinearSystem.getMetrics()
            if (r5 == 0) goto L69
            androidx.constraintlayout.solver.Metrics r5 = androidx.constraintlayout.solver.LinearSystem.getMetrics()
            long r7 = r5.barrierConnectionResolved
            r9 = 1
            long r7 = r7 + r9
            r5.barrierConnectionResolved = r7
        L69:
            r0.f = r6
            r0.g = r1
            r0.didResolve()
            int r0 = r11.mBarrierType
            if (r0 == 0) goto L84
            if (r0 == r4) goto L81
            if (r0 == r3) goto L7e
            if (r0 == r2) goto L7b
            return
        L7b:
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r0 = r11.r
            goto L86
        L7e:
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r0 = r11.t
            goto L86
        L81:
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r0 = r11.q
            goto L86
        L84:
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r0 = r11.s
        L86:
            androidx.constraintlayout.solver.widgets.ResolutionAnchor r0 = r0.getResolutionNode()
            r0.resolve(r6, r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.solver.widgets.Barrier.resolve():void");
    }

    public void setAllowsGoneWidget(boolean z) {
        this.mAllowsGoneWidget = z;
    }

    public void setBarrierType(int i) {
        this.mBarrierType = i;
    }
}
