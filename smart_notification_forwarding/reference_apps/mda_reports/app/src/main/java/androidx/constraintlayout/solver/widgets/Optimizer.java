package androidx.constraintlayout.solver.widgets;

import androidx.constraintlayout.solver.LinearSystem;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;

/* loaded from: classes.dex */
public class Optimizer {
    public static final int OPTIMIZATION_BARRIER = 2;
    public static final int OPTIMIZATION_CHAIN = 4;
    public static final int OPTIMIZATION_DIMENSIONS = 8;
    public static final int OPTIMIZATION_DIRECT = 1;
    public static final int OPTIMIZATION_GROUPS = 32;
    public static final int OPTIMIZATION_NONE = 0;
    public static final int OPTIMIZATION_RATIO = 16;
    public static final int OPTIMIZATION_STANDARD = 7;
    static boolean[] a = new boolean[3];

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:100:?, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:105:0x01e0, code lost:
    
        if (r6 != false) goto L106;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0070, code lost:
    
        if (r6 != false) goto L57;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x00f8, code lost:
    
        r3.dependsOn(r1, r7);
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x00eb, code lost:
    
        r3.dependsOn(r1, 1, r17.getResolutionWidth());
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0080, code lost:
    
        if (r6 != false) goto L57;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x008f, code lost:
    
        if (r6 != false) goto L73;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x00e9, code lost:
    
        if (r6 != false) goto L57;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x00f4, code lost:
    
        r7 = r17.getWidth();
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x010f, code lost:
    
        if (r6 != false) goto L57;
     */
    /* JADX WARN: Code restructure failed: missing block: B:95:0x01c4, code lost:
    
        if (r6 != false) goto L106;
     */
    /* JADX WARN: Code restructure failed: missing block: B:96:0x01c6, code lost:
    
        r4.dependsOn(r2, 1, r17.getResolutionHeight());
     */
    /* JADX WARN: Code restructure failed: missing block: B:97:?, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:99:0x01cf, code lost:
    
        r4.dependsOn(r2, r1);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void a(int r16, androidx.constraintlayout.solver.widgets.ConstraintWidget r17) {
        /*
            Method dump skipped, instructions count: 810
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.solver.widgets.Optimizer.a(int, androidx.constraintlayout.solver.widgets.ConstraintWidget):void");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(ConstraintWidget constraintWidget, int i, int i2) {
        int i3 = i * 2;
        int i4 = i3 + 1;
        constraintWidget.y[i3].getResolutionNode().f = constraintWidget.getParent().q.getResolutionNode();
        constraintWidget.y[i3].getResolutionNode().g = i2;
        constraintWidget.y[i3].getResolutionNode().b = 1;
        constraintWidget.y[i4].getResolutionNode().f = constraintWidget.y[i3].getResolutionNode();
        constraintWidget.y[i4].getResolutionNode().g = constraintWidget.getLength(i);
        constraintWidget.y[i4].getResolutionNode().b = 1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(ConstraintWidgetContainer constraintWidgetContainer, LinearSystem linearSystem, ConstraintWidget constraintWidget) {
        if (constraintWidgetContainer.A[0] != ConstraintWidget.DimensionBehaviour.WRAP_CONTENT && constraintWidget.A[0] == ConstraintWidget.DimensionBehaviour.MATCH_PARENT) {
            int i = constraintWidget.q.mMargin;
            int width = constraintWidgetContainer.getWidth() - constraintWidget.s.mMargin;
            ConstraintAnchor constraintAnchor = constraintWidget.q;
            constraintAnchor.e = linearSystem.createObjectVariable(constraintAnchor);
            ConstraintAnchor constraintAnchor2 = constraintWidget.s;
            constraintAnchor2.e = linearSystem.createObjectVariable(constraintAnchor2);
            linearSystem.addEquality(constraintWidget.q.e, i);
            linearSystem.addEquality(constraintWidget.s.e, width);
            constraintWidget.mHorizontalResolution = 2;
            constraintWidget.setHorizontalDimension(i, width);
        }
        if (constraintWidgetContainer.A[1] == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT || constraintWidget.A[1] != ConstraintWidget.DimensionBehaviour.MATCH_PARENT) {
            return;
        }
        int i2 = constraintWidget.r.mMargin;
        int height = constraintWidgetContainer.getHeight() - constraintWidget.t.mMargin;
        ConstraintAnchor constraintAnchor3 = constraintWidget.r;
        constraintAnchor3.e = linearSystem.createObjectVariable(constraintAnchor3);
        ConstraintAnchor constraintAnchor4 = constraintWidget.t;
        constraintAnchor4.e = linearSystem.createObjectVariable(constraintAnchor4);
        linearSystem.addEquality(constraintWidget.r.e, i2);
        linearSystem.addEquality(constraintWidget.t.e, height);
        if (constraintWidget.M > 0 || constraintWidget.getVisibility() == 8) {
            ConstraintAnchor constraintAnchor5 = constraintWidget.u;
            constraintAnchor5.e = linearSystem.createObjectVariable(constraintAnchor5);
            linearSystem.addEquality(constraintWidget.u.e, constraintWidget.M + i2);
        }
        constraintWidget.mVerticalResolution = 2;
        constraintWidget.setVerticalDimension(i2, height);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:10:0x0032, code lost:
    
        if (r7.U == 2) goto L14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x0034, code lost:
    
        r2 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:209:0x0036, code lost:
    
        r2 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:219:0x0048, code lost:
    
        if (r7.V == 2) goto L14;
     */
    /* JADX WARN: Removed duplicated region for block: B:120:0x01d6  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0109 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0105 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static boolean a(androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer r24, androidx.constraintlayout.solver.LinearSystem r25, int r26, int r27, androidx.constraintlayout.solver.widgets.ChainHead r28) {
        /*
            Method dump skipped, instructions count: 900
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.solver.widgets.Optimizer.a(androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer, androidx.constraintlayout.solver.LinearSystem, int, int, androidx.constraintlayout.solver.widgets.ChainHead):boolean");
    }

    private static boolean optimizableMatchConstraint(ConstraintWidget constraintWidget, int i) {
        ConstraintWidget.DimensionBehaviour[] dimensionBehaviourArr = constraintWidget.A;
        if (dimensionBehaviourArr[i] != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
            return false;
        }
        if (constraintWidget.E != 0.0f) {
            ConstraintWidget.DimensionBehaviour dimensionBehaviour = dimensionBehaviourArr[i != 0 ? (char) 0 : (char) 1];
            ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
            return false;
        }
        if (i == 0) {
            if (constraintWidget.c != 0 || constraintWidget.f != 0 || constraintWidget.g != 0) {
                return false;
            }
        } else if (constraintWidget.d != 0 || constraintWidget.i != 0 || constraintWidget.j != 0) {
            return false;
        }
        return true;
    }
}
