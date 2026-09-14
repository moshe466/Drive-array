package androidx.constraintlayout.solver.widgets;

import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public class Analyzer {
    private Analyzer() {
    }

    public static void determineGroups(ConstraintWidgetContainer constraintWidgetContainer) {
        if ((constraintWidgetContainer.getOptimizationLevel() & 32) != 32) {
            singleGroup(constraintWidgetContainer);
            return;
        }
        constraintWidgetContainer.mSkipSolver = true;
        constraintWidgetContainer.mGroupsWrapOptimized = false;
        constraintWidgetContainer.mHorizontalWrapOptimized = false;
        constraintWidgetContainer.mVerticalWrapOptimized = false;
        ArrayList<ConstraintWidget> arrayList = constraintWidgetContainer.Z;
        List<ConstraintWidgetGroup> list = constraintWidgetContainer.mWidgetGroups;
        boolean z = constraintWidgetContainer.getHorizontalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        boolean z2 = constraintWidgetContainer.getVerticalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        boolean z3 = z || z2;
        list.clear();
        for (ConstraintWidget constraintWidget : arrayList) {
            constraintWidget.p = null;
            constraintWidget.T = false;
            constraintWidget.resetResolutionNodes();
        }
        for (ConstraintWidget constraintWidget2 : arrayList) {
            if (constraintWidget2.p == null && !determineGroups(constraintWidget2, list, z3)) {
                singleGroup(constraintWidgetContainer);
                constraintWidgetContainer.mSkipSolver = false;
                return;
            }
        }
        int i = 0;
        int i2 = 0;
        for (ConstraintWidgetGroup constraintWidgetGroup : list) {
            i = Math.max(i, getMaxDimension(constraintWidgetGroup, 0));
            i2 = Math.max(i2, getMaxDimension(constraintWidgetGroup, 1));
        }
        if (z) {
            constraintWidgetContainer.setHorizontalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.FIXED);
            constraintWidgetContainer.setWidth(i);
            constraintWidgetContainer.mGroupsWrapOptimized = true;
            constraintWidgetContainer.mHorizontalWrapOptimized = true;
            constraintWidgetContainer.mWrapFixedWidth = i;
        }
        if (z2) {
            constraintWidgetContainer.setVerticalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.FIXED);
            constraintWidgetContainer.setHeight(i2);
            constraintWidgetContainer.mGroupsWrapOptimized = true;
            constraintWidgetContainer.mVerticalWrapOptimized = true;
            constraintWidgetContainer.mWrapFixedHeight = i2;
        }
        setPosition(list, 0, constraintWidgetContainer.getWidth());
        setPosition(list, 1, constraintWidgetContainer.getHeight());
    }

    private static boolean determineGroups(ConstraintWidget constraintWidget, List<ConstraintWidgetGroup> list, boolean z) {
        ConstraintWidgetGroup constraintWidgetGroup = new ConstraintWidgetGroup(new ArrayList(), true);
        list.add(constraintWidgetGroup);
        return traverse(constraintWidget, constraintWidgetGroup, list, z);
    }

    private static int getMaxDimension(ConstraintWidgetGroup constraintWidgetGroup, int i) {
        int i2 = i * 2;
        List<ConstraintWidget> startWidgets = constraintWidgetGroup.getStartWidgets(i);
        int size = startWidgets.size();
        int i3 = 0;
        for (int i4 = 0; i4 < size; i4++) {
            ConstraintWidget constraintWidget = startWidgets.get(i4);
            ConstraintAnchor[] constraintAnchorArr = constraintWidget.y;
            int i5 = i2 + 1;
            i3 = Math.max(i3, getMaxDimensionTraversal(constraintWidget, i, constraintAnchorArr[i5].c == null || !(constraintAnchorArr[i2].c == null || constraintAnchorArr[i5].c == null), 0));
        }
        constraintWidgetGroup.mGroupDimensions[i] = i3;
        return i3;
    }

    private static int getMaxDimensionTraversal(ConstraintWidget constraintWidget, int i, boolean z, int i2) {
        int height;
        int baselineDistance;
        int i3;
        int i4;
        int i5;
        int i6;
        int width;
        int i7;
        int i8;
        int i9;
        int i10 = 0;
        if (!constraintWidget.R) {
            return 0;
        }
        boolean z2 = constraintWidget.u.c != null && i == 1;
        if (z) {
            height = constraintWidget.getBaselineDistance();
            baselineDistance = constraintWidget.getHeight() - constraintWidget.getBaselineDistance();
            i4 = i * 2;
            i3 = i4 + 1;
        } else {
            height = constraintWidget.getHeight() - constraintWidget.getBaselineDistance();
            baselineDistance = constraintWidget.getBaselineDistance();
            i3 = i * 2;
            i4 = i3 + 1;
        }
        ConstraintAnchor[] constraintAnchorArr = constraintWidget.y;
        if (constraintAnchorArr[i3].c == null || constraintAnchorArr[i4].c != null) {
            i5 = i3;
            i6 = 1;
        } else {
            i5 = i4;
            i4 = i3;
            i6 = -1;
        }
        int i11 = z2 ? i2 - height : i2;
        int margin = (constraintWidget.y[i4].getMargin() * i6) + getParentBiasOffset(constraintWidget, i);
        int i12 = i11 + margin;
        int width2 = (i == 0 ? constraintWidget.getWidth() : constraintWidget.getHeight()) * i6;
        Iterator<ResolutionNode> it = constraintWidget.y[i4].getResolutionNode().a.iterator();
        while (it.hasNext()) {
            i10 = Math.max(i10, getMaxDimensionTraversal(((ResolutionAnchor) it.next()).c.a, i, z, i12));
        }
        int i13 = 0;
        for (Iterator<ResolutionNode> it2 = constraintWidget.y[i5].getResolutionNode().a.iterator(); it2.hasNext(); it2 = it2) {
            i13 = Math.max(i13, getMaxDimensionTraversal(((ResolutionAnchor) it2.next()).c.a, i, z, width2 + i12));
        }
        if (z2) {
            i10 -= height;
            width = i13 + baselineDistance;
        } else {
            width = i13 + ((i == 0 ? constraintWidget.getWidth() : constraintWidget.getHeight()) * i6);
        }
        int i14 = 1;
        if (i == 1) {
            Iterator<ResolutionNode> it3 = constraintWidget.u.getResolutionNode().a.iterator();
            int i15 = 0;
            while (it3.hasNext()) {
                Iterator<ResolutionNode> it4 = it3;
                ResolutionAnchor resolutionAnchor = (ResolutionAnchor) it3.next();
                if (i6 == i14) {
                    i15 = Math.max(i15, getMaxDimensionTraversal(resolutionAnchor.c.a, i, z, height + i12));
                    i9 = i5;
                } else {
                    i9 = i5;
                    i15 = Math.max(i15, getMaxDimensionTraversal(resolutionAnchor.c.a, i, z, (baselineDistance * i6) + i12));
                }
                it3 = it4;
                i5 = i9;
                i14 = 1;
            }
            i7 = i5;
            int i16 = i15;
            i8 = (constraintWidget.u.getResolutionNode().a.size() <= 0 || z2) ? i16 : i6 == 1 ? i16 + height : i16 - baselineDistance;
        } else {
            i7 = i5;
            i8 = 0;
        }
        int max = margin + Math.max(i10, Math.max(width, i8));
        int i17 = i12 + width2;
        if (i6 != -1) {
            i12 = i17;
            i17 = i12;
        }
        if (z) {
            Optimizer.a(constraintWidget, i, i17);
            constraintWidget.setFrame(i17, i12, i);
        } else {
            constraintWidget.p.a(constraintWidget, i);
            constraintWidget.a(i17, i);
        }
        if (constraintWidget.getDimensionBehaviour(i) == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && constraintWidget.E != 0.0f) {
            constraintWidget.p.a(constraintWidget, i);
        }
        ConstraintAnchor[] constraintAnchorArr2 = constraintWidget.y;
        if (constraintAnchorArr2[i4].c != null && constraintAnchorArr2[i7].c != null) {
            ConstraintWidget parent = constraintWidget.getParent();
            ConstraintAnchor[] constraintAnchorArr3 = constraintWidget.y;
            if (constraintAnchorArr3[i4].c.a == parent && constraintAnchorArr3[i7].c.a == parent) {
                constraintWidget.p.a(constraintWidget, i);
            }
        }
        return max;
    }

    private static int getParentBiasOffset(ConstraintWidget constraintWidget, int i) {
        ConstraintAnchor constraintAnchor;
        int i2 = i * 2;
        ConstraintAnchor[] constraintAnchorArr = constraintWidget.y;
        ConstraintAnchor constraintAnchor2 = constraintAnchorArr[i2];
        ConstraintAnchor constraintAnchor3 = constraintAnchorArr[i2 + 1];
        ConstraintAnchor constraintAnchor4 = constraintAnchor2.c;
        if (constraintAnchor4 == null) {
            return 0;
        }
        ConstraintWidget constraintWidget2 = constraintAnchor4.a;
        ConstraintWidget constraintWidget3 = constraintWidget.B;
        if (constraintWidget2 != constraintWidget3 || (constraintAnchor = constraintAnchor3.c) == null || constraintAnchor.a != constraintWidget3) {
            return 0;
        }
        return (int) ((((constraintWidget3.getLength(i) - constraintAnchor2.getMargin()) - constraintAnchor3.getMargin()) - constraintWidget.getLength(i)) * (i == 0 ? constraintWidget.P : constraintWidget.Q));
    }

    private static void invalidate(ConstraintWidgetContainer constraintWidgetContainer, ConstraintWidget constraintWidget, ConstraintWidgetGroup constraintWidgetGroup) {
        constraintWidgetGroup.mSkipSolver = false;
        constraintWidgetContainer.mSkipSolver = false;
        constraintWidget.R = false;
    }

    private static int resolveDimensionRatio(ConstraintWidget constraintWidget) {
        if (constraintWidget.getHorizontalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
            int height = (int) (constraintWidget.F == 0 ? constraintWidget.getHeight() * constraintWidget.E : constraintWidget.getHeight() / constraintWidget.E);
            constraintWidget.setWidth(height);
            return height;
        }
        if (constraintWidget.getVerticalDimensionBehaviour() != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
            return -1;
        }
        int width = (int) (constraintWidget.F == 1 ? constraintWidget.getWidth() * constraintWidget.E : constraintWidget.getWidth() / constraintWidget.E);
        constraintWidget.setHeight(width);
        return width;
    }

    private static void setConnection(ConstraintAnchor constraintAnchor) {
        ResolutionAnchor resolutionNode = constraintAnchor.getResolutionNode();
        ConstraintAnchor constraintAnchor2 = constraintAnchor.c;
        if (constraintAnchor2 == null || constraintAnchor2.c == constraintAnchor) {
            return;
        }
        constraintAnchor2.getResolutionNode().addDependent(resolutionNode);
    }

    public static void setPosition(List<ConstraintWidgetGroup> list, int i, int i2) {
        int size = list.size();
        for (int i3 = 0; i3 < size; i3++) {
            for (ConstraintWidget constraintWidget : list.get(i3).a(i)) {
                if (constraintWidget.R) {
                    updateSizeDependentWidgets(constraintWidget, i, i2);
                }
            }
        }
    }

    private static void singleGroup(ConstraintWidgetContainer constraintWidgetContainer) {
        constraintWidgetContainer.mWidgetGroups.clear();
        constraintWidgetContainer.mWidgetGroups.add(0, new ConstraintWidgetGroup(constraintWidgetContainer.Z));
    }

    /* JADX WARN: Code restructure failed: missing block: B:139:0x0181, code lost:
    
        if (r3.a == r4) goto L123;
     */
    /* JADX WARN: Code restructure failed: missing block: B:159:0x0128, code lost:
    
        if (r3.a == r4) goto L92;
     */
    /* JADX WARN: Removed duplicated region for block: B:134:0x0173  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x01a0  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x01c2  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static boolean traverse(androidx.constraintlayout.solver.widgets.ConstraintWidget r8, androidx.constraintlayout.solver.widgets.ConstraintWidgetGroup r9, java.util.List<androidx.constraintlayout.solver.widgets.ConstraintWidgetGroup> r10, boolean r11) {
        /*
            Method dump skipped, instructions count: 560
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.solver.widgets.Analyzer.traverse(androidx.constraintlayout.solver.widgets.ConstraintWidget, androidx.constraintlayout.solver.widgets.ConstraintWidgetGroup, java.util.List, boolean):boolean");
    }

    private static void updateSizeDependentWidgets(ConstraintWidget constraintWidget, int i, int i2) {
        int i3 = i * 2;
        ConstraintAnchor[] constraintAnchorArr = constraintWidget.y;
        ConstraintAnchor constraintAnchor = constraintAnchorArr[i3];
        ConstraintAnchor constraintAnchor2 = constraintAnchorArr[i3 + 1];
        if ((constraintAnchor.c == null || constraintAnchor2.c == null) ? false : true) {
            Optimizer.a(constraintWidget, i, getParentBiasOffset(constraintWidget, i) + constraintAnchor.getMargin());
            return;
        }
        if (constraintWidget.E == 0.0f || constraintWidget.getDimensionBehaviour(i) != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
            int a = i2 - constraintWidget.a(i);
            int length = a - constraintWidget.getLength(i);
            constraintWidget.setFrame(length, a, i);
            Optimizer.a(constraintWidget, i, length);
            return;
        }
        int resolveDimensionRatio = resolveDimensionRatio(constraintWidget);
        int i4 = (int) constraintWidget.y[i3].getResolutionNode().g;
        constraintAnchor2.getResolutionNode().f = constraintAnchor.getResolutionNode();
        constraintAnchor2.getResolutionNode().g = resolveDimensionRatio;
        constraintAnchor2.getResolutionNode().b = 1;
        constraintWidget.setFrame(i4, i4 + resolveDimensionRatio, i);
    }
}
