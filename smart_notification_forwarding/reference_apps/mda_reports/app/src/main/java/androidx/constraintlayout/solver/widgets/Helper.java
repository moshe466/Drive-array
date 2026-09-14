package androidx.constraintlayout.solver.widgets;

import java.util.Arrays;

/* loaded from: classes.dex */
public class Helper extends ConstraintWidget {
    protected ConstraintWidget[] Z = new ConstraintWidget[4];
    protected int a0 = 0;

    public void add(ConstraintWidget constraintWidget) {
        int i = this.a0 + 1;
        ConstraintWidget[] constraintWidgetArr = this.Z;
        if (i > constraintWidgetArr.length) {
            this.Z = (ConstraintWidget[]) Arrays.copyOf(constraintWidgetArr, constraintWidgetArr.length * 2);
        }
        ConstraintWidget[] constraintWidgetArr2 = this.Z;
        int i2 = this.a0;
        constraintWidgetArr2[i2] = constraintWidget;
        this.a0 = i2 + 1;
    }

    public void removeAllIds() {
        this.a0 = 0;
    }
}
