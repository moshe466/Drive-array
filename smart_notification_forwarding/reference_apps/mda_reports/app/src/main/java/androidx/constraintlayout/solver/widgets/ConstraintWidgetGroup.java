package androidx.constraintlayout.solver.widgets;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* loaded from: classes.dex */
public class ConstraintWidgetGroup {
    int a;
    int b;
    List<ConstraintWidget> c;
    List<ConstraintWidget> d;
    HashSet<ConstraintWidget> e;
    HashSet<ConstraintWidget> f;
    List<ConstraintWidget> g;
    List<ConstraintWidget> h;
    public List<ConstraintWidget> mConstrainedGroup;
    public final int[] mGroupDimensions;
    public boolean mSkipSolver;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ConstraintWidgetGroup(List<ConstraintWidget> list) {
        this.a = -1;
        this.b = -1;
        this.mSkipSolver = false;
        this.mGroupDimensions = new int[]{this.a, this.b};
        this.c = new ArrayList();
        this.d = new ArrayList();
        this.e = new HashSet<>();
        this.f = new HashSet<>();
        this.g = new ArrayList();
        this.h = new ArrayList();
        this.mConstrainedGroup = list;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ConstraintWidgetGroup(List<ConstraintWidget> list, boolean z) {
        this.a = -1;
        this.b = -1;
        this.mSkipSolver = false;
        this.mGroupDimensions = new int[]{this.a, this.b};
        this.c = new ArrayList();
        this.d = new ArrayList();
        this.e = new HashSet<>();
        this.f = new HashSet<>();
        this.g = new ArrayList();
        this.h = new ArrayList();
        this.mConstrainedGroup = list;
        this.mSkipSolver = z;
    }

    private void getWidgetsToSolveTraversal(ArrayList<ConstraintWidget> arrayList, ConstraintWidget constraintWidget) {
        if (constraintWidget.T) {
            return;
        }
        arrayList.add(constraintWidget);
        constraintWidget.T = true;
        if (constraintWidget.isFullyResolved()) {
            return;
        }
        if (constraintWidget instanceof Helper) {
            Helper helper = (Helper) constraintWidget;
            int i = helper.a0;
            for (int i2 = 0; i2 < i; i2++) {
                getWidgetsToSolveTraversal(arrayList, helper.Z[i2]);
            }
        }
        int length = constraintWidget.y.length;
        for (int i3 = 0; i3 < length; i3++) {
            ConstraintAnchor constraintAnchor = constraintWidget.y[i3].c;
            if (constraintAnchor != null) {
                ConstraintWidget constraintWidget2 = constraintAnchor.a;
                if (constraintAnchor != null && constraintWidget2 != constraintWidget.getParent()) {
                    getWidgetsToSolveTraversal(arrayList, constraintWidget2);
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0046  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x004e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void updateResolvedDimension(androidx.constraintlayout.solver.widgets.ConstraintWidget r7) {
        /*
            Method dump skipped, instructions count: 218
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.solver.widgets.ConstraintWidgetGroup.updateResolvedDimension(androidx.constraintlayout.solver.widgets.ConstraintWidget):void");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<ConstraintWidget> a() {
        if (!this.g.isEmpty()) {
            return this.g;
        }
        int size = this.mConstrainedGroup.size();
        for (int i = 0; i < size; i++) {
            ConstraintWidget constraintWidget = this.mConstrainedGroup.get(i);
            if (!constraintWidget.R) {
                getWidgetsToSolveTraversal((ArrayList) this.g, constraintWidget);
            }
        }
        this.h.clear();
        this.h.addAll(this.mConstrainedGroup);
        this.h.removeAll(this.g);
        return this.g;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Set<ConstraintWidget> a(int i) {
        if (i == 0) {
            return this.e;
        }
        if (i == 1) {
            return this.f;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(ConstraintWidget constraintWidget, int i) {
        HashSet<ConstraintWidget> hashSet;
        if (i == 0) {
            hashSet = this.e;
        } else if (i != 1) {
            return;
        } else {
            hashSet = this.f;
        }
        hashSet.add(constraintWidget);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b() {
        int size = this.h.size();
        for (int i = 0; i < size; i++) {
            updateResolvedDimension(this.h.get(i));
        }
    }

    public List<ConstraintWidget> getStartWidgets(int i) {
        if (i == 0) {
            return this.c;
        }
        if (i == 1) {
            return this.d;
        }
        return null;
    }
}
