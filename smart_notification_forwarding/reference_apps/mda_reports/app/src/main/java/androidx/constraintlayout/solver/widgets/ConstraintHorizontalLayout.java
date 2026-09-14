package androidx.constraintlayout.solver.widgets;

import androidx.constraintlayout.solver.LinearSystem;
import androidx.constraintlayout.solver.widgets.ConstraintAnchor;

/* loaded from: classes.dex */
public class ConstraintHorizontalLayout extends ConstraintWidgetContainer {
    private ContentAlignment mAlignment;

    /* loaded from: classes.dex */
    public enum ContentAlignment {
        BEGIN,
        MIDDLE,
        END,
        TOP,
        VERTICAL_MIDDLE,
        BOTTOM,
        LEFT,
        RIGHT
    }

    public ConstraintHorizontalLayout() {
        this.mAlignment = ContentAlignment.MIDDLE;
    }

    public ConstraintHorizontalLayout(int i, int i2) {
        super(i, i2);
        this.mAlignment = ContentAlignment.MIDDLE;
    }

    public ConstraintHorizontalLayout(int i, int i2, int i3, int i4) {
        super(i, i2, i3, i4);
        this.mAlignment = ContentAlignment.MIDDLE;
    }

    @Override // androidx.constraintlayout.solver.widgets.ConstraintWidget
    public void addToSolver(LinearSystem linearSystem) {
        if (this.Z.size() != 0) {
            int i = 0;
            int size = this.Z.size();
            ConstraintHorizontalLayout constraintHorizontalLayout = this;
            while (i < size) {
                ConstraintWidget constraintWidget = this.Z.get(i);
                if (constraintHorizontalLayout != this) {
                    constraintWidget.connect(ConstraintAnchor.Type.LEFT, constraintHorizontalLayout, ConstraintAnchor.Type.RIGHT);
                    constraintHorizontalLayout.connect(ConstraintAnchor.Type.RIGHT, constraintWidget, ConstraintAnchor.Type.LEFT);
                } else {
                    ConstraintAnchor.Strength strength = ConstraintAnchor.Strength.STRONG;
                    if (this.mAlignment == ContentAlignment.END) {
                        strength = ConstraintAnchor.Strength.WEAK;
                    }
                    ConstraintAnchor.Type type = ConstraintAnchor.Type.LEFT;
                    constraintWidget.connect(type, constraintHorizontalLayout, type, 0, strength);
                }
                ConstraintAnchor.Type type2 = ConstraintAnchor.Type.TOP;
                constraintWidget.connect(type2, this, type2);
                ConstraintAnchor.Type type3 = ConstraintAnchor.Type.BOTTOM;
                constraintWidget.connect(type3, this, type3);
                i++;
                constraintHorizontalLayout = constraintWidget;
            }
            if (constraintHorizontalLayout != this) {
                ConstraintAnchor.Strength strength2 = ConstraintAnchor.Strength.STRONG;
                if (this.mAlignment == ContentAlignment.BEGIN) {
                    strength2 = ConstraintAnchor.Strength.WEAK;
                }
                ConstraintAnchor.Type type4 = ConstraintAnchor.Type.RIGHT;
                constraintHorizontalLayout.connect(type4, this, type4, 0, strength2);
            }
        }
        super.addToSolver(linearSystem);
    }
}
