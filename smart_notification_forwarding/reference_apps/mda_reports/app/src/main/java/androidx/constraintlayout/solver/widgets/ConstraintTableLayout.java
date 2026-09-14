package androidx.constraintlayout.solver.widgets;

import androidx.constraintlayout.solver.LinearSystem;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class ConstraintTableLayout extends ConstraintWidgetContainer {
    public static final int ALIGN_CENTER = 0;
    private static final int ALIGN_FULL = 3;
    public static final int ALIGN_LEFT = 1;
    public static final int ALIGN_RIGHT = 2;
    private ArrayList<Guideline> mHorizontalGuidelines;
    private ArrayList<HorizontalSlice> mHorizontalSlices;
    private int mNumCols;
    private int mNumRows;
    private int mPadding;
    private boolean mVerticalGrowth;
    private ArrayList<Guideline> mVerticalGuidelines;
    private ArrayList<VerticalSlice> mVerticalSlices;
    private LinearSystem system;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class HorizontalSlice {
        ConstraintWidget a;
        ConstraintWidget b;

        HorizontalSlice(ConstraintTableLayout constraintTableLayout) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class VerticalSlice {
        ConstraintWidget a;
        ConstraintWidget b;
        int c = 1;

        VerticalSlice(ConstraintTableLayout constraintTableLayout) {
        }
    }

    public ConstraintTableLayout() {
        this.mVerticalGrowth = true;
        this.mNumCols = 0;
        this.mNumRows = 0;
        this.mPadding = 8;
        this.mVerticalSlices = new ArrayList<>();
        this.mHorizontalSlices = new ArrayList<>();
        this.mVerticalGuidelines = new ArrayList<>();
        this.mHorizontalGuidelines = new ArrayList<>();
        this.system = null;
    }

    public ConstraintTableLayout(int i, int i2) {
        super(i, i2);
        this.mVerticalGrowth = true;
        this.mNumCols = 0;
        this.mNumRows = 0;
        this.mPadding = 8;
        this.mVerticalSlices = new ArrayList<>();
        this.mHorizontalSlices = new ArrayList<>();
        this.mVerticalGuidelines = new ArrayList<>();
        this.mHorizontalGuidelines = new ArrayList<>();
        this.system = null;
    }

    public ConstraintTableLayout(int i, int i2, int i3, int i4) {
        super(i, i2, i3, i4);
        this.mVerticalGrowth = true;
        this.mNumCols = 0;
        this.mNumRows = 0;
        this.mPadding = 8;
        this.mVerticalSlices = new ArrayList<>();
        this.mHorizontalSlices = new ArrayList<>();
        this.mVerticalGuidelines = new ArrayList<>();
        this.mHorizontalGuidelines = new ArrayList<>();
        this.system = null;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x00be  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void setChildrenConnections() {
        /*
            r11 = this;
            java.util.ArrayList<androidx.constraintlayout.solver.widgets.ConstraintWidget> r0 = r11.Z
            int r0 = r0.size()
            r1 = 0
            r2 = 0
        L8:
            if (r1 >= r0) goto Ld5
            java.util.ArrayList<androidx.constraintlayout.solver.widgets.ConstraintWidget> r3 = r11.Z
            java.lang.Object r3 = r3.get(r1)
            androidx.constraintlayout.solver.widgets.ConstraintWidget r3 = (androidx.constraintlayout.solver.widgets.ConstraintWidget) r3
            int r4 = r3.getContainerItemSkip()
            int r2 = r2 + r4
            int r4 = r11.mNumCols
            int r5 = r2 % r4
            int r4 = r2 / r4
            java.util.ArrayList<androidx.constraintlayout.solver.widgets.ConstraintTableLayout$HorizontalSlice> r6 = r11.mHorizontalSlices
            java.lang.Object r4 = r6.get(r4)
            androidx.constraintlayout.solver.widgets.ConstraintTableLayout$HorizontalSlice r4 = (androidx.constraintlayout.solver.widgets.ConstraintTableLayout.HorizontalSlice) r4
            java.util.ArrayList<androidx.constraintlayout.solver.widgets.ConstraintTableLayout$VerticalSlice> r6 = r11.mVerticalSlices
            java.lang.Object r5 = r6.get(r5)
            androidx.constraintlayout.solver.widgets.ConstraintTableLayout$VerticalSlice r5 = (androidx.constraintlayout.solver.widgets.ConstraintTableLayout.VerticalSlice) r5
            androidx.constraintlayout.solver.widgets.ConstraintWidget r6 = r5.a
            androidx.constraintlayout.solver.widgets.ConstraintWidget r7 = r5.b
            androidx.constraintlayout.solver.widgets.ConstraintWidget r8 = r4.a
            androidx.constraintlayout.solver.widgets.ConstraintWidget r4 = r4.b
            androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type r9 = androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.LEFT
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r9 = r3.getAnchor(r9)
            androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type r10 = androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.LEFT
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r6 = r6.getAnchor(r10)
            int r10 = r11.mPadding
            r9.connect(r6, r10)
            boolean r6 = r7 instanceof androidx.constraintlayout.solver.widgets.Guideline
            if (r6 == 0) goto L53
            androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type r6 = androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.RIGHT
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r6 = r3.getAnchor(r6)
            androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type r9 = androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.LEFT
            goto L5b
        L53:
            androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type r6 = androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.RIGHT
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r6 = r3.getAnchor(r6)
            androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type r9 = androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.RIGHT
        L5b:
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r7 = r7.getAnchor(r9)
            int r9 = r11.mPadding
            r6.connect(r7, r9)
            int r5 = r5.c
            r6 = 1
            if (r5 == r6) goto L8a
            r6 = 2
            if (r5 == r6) goto L76
            r6 = 3
            if (r5 == r6) goto L70
            goto La0
        L70:
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r5 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            r3.setHorizontalDimensionBehaviour(r5)
            goto La0
        L76:
            androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type r5 = androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.LEFT
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r5 = r3.getAnchor(r5)
            androidx.constraintlayout.solver.widgets.ConstraintAnchor$Strength r6 = androidx.constraintlayout.solver.widgets.ConstraintAnchor.Strength.WEAK
            r5.setStrength(r6)
            androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type r5 = androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.RIGHT
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r5 = r3.getAnchor(r5)
            androidx.constraintlayout.solver.widgets.ConstraintAnchor$Strength r6 = androidx.constraintlayout.solver.widgets.ConstraintAnchor.Strength.STRONG
            goto L9d
        L8a:
            androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type r5 = androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.LEFT
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r5 = r3.getAnchor(r5)
            androidx.constraintlayout.solver.widgets.ConstraintAnchor$Strength r6 = androidx.constraintlayout.solver.widgets.ConstraintAnchor.Strength.STRONG
            r5.setStrength(r6)
            androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type r5 = androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.RIGHT
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r5 = r3.getAnchor(r5)
            androidx.constraintlayout.solver.widgets.ConstraintAnchor$Strength r6 = androidx.constraintlayout.solver.widgets.ConstraintAnchor.Strength.WEAK
        L9d:
            r5.setStrength(r6)
        La0:
            androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type r5 = androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.TOP
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r5 = r3.getAnchor(r5)
            androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type r6 = androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.TOP
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r6 = r8.getAnchor(r6)
            int r7 = r11.mPadding
            r5.connect(r6, r7)
            boolean r5 = r4 instanceof androidx.constraintlayout.solver.widgets.Guideline
            if (r5 == 0) goto Lbe
            androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type r5 = androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.BOTTOM
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r3 = r3.getAnchor(r5)
            androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type r5 = androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.TOP
            goto Lc6
        Lbe:
            androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type r5 = androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.BOTTOM
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r3 = r3.getAnchor(r5)
            androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type r5 = androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.BOTTOM
        Lc6:
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r4 = r4.getAnchor(r5)
            int r5 = r11.mPadding
            r3.connect(r4, r5)
            int r2 = r2 + 1
            int r1 = r1 + 1
            goto L8
        Ld5:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.solver.widgets.ConstraintTableLayout.setChildrenConnections():void");
    }

    private void setHorizontalSlices() {
        this.mHorizontalSlices.clear();
        float f = 100.0f / this.mNumRows;
        ConstraintWidget constraintWidget = this;
        float f2 = f;
        for (int i = 0; i < this.mNumRows; i++) {
            HorizontalSlice horizontalSlice = new HorizontalSlice(this);
            horizontalSlice.a = constraintWidget;
            if (i < this.mNumRows - 1) {
                Guideline guideline = new Guideline();
                guideline.setOrientation(0);
                guideline.setParent(this);
                guideline.setGuidePercent((int) f2);
                f2 += f;
                horizontalSlice.b = guideline;
                this.mHorizontalGuidelines.add(guideline);
            } else {
                horizontalSlice.b = this;
            }
            constraintWidget = horizontalSlice.b;
            this.mHorizontalSlices.add(horizontalSlice);
        }
        updateDebugSolverNames();
    }

    private void setVerticalSlices() {
        this.mVerticalSlices.clear();
        float f = 100.0f / this.mNumCols;
        ConstraintWidget constraintWidget = this;
        float f2 = f;
        for (int i = 0; i < this.mNumCols; i++) {
            VerticalSlice verticalSlice = new VerticalSlice(this);
            verticalSlice.a = constraintWidget;
            if (i < this.mNumCols - 1) {
                Guideline guideline = new Guideline();
                guideline.setOrientation(1);
                guideline.setParent(this);
                guideline.setGuidePercent((int) f2);
                f2 += f;
                verticalSlice.b = guideline;
                this.mVerticalGuidelines.add(guideline);
            } else {
                verticalSlice.b = this;
            }
            constraintWidget = verticalSlice.b;
            this.mVerticalSlices.add(verticalSlice);
        }
        updateDebugSolverNames();
    }

    private void updateDebugSolverNames() {
        if (this.system == null) {
            return;
        }
        int size = this.mVerticalGuidelines.size();
        for (int i = 0; i < size; i++) {
            this.mVerticalGuidelines.get(i).setDebugSolverName(this.system, getDebugName() + ".VG" + i);
        }
        int size2 = this.mHorizontalGuidelines.size();
        for (int i2 = 0; i2 < size2; i2++) {
            this.mHorizontalGuidelines.get(i2).setDebugSolverName(this.system, getDebugName() + ".HG" + i2);
        }
    }

    @Override // androidx.constraintlayout.solver.widgets.ConstraintWidget
    public void addToSolver(LinearSystem linearSystem) {
        super.addToSolver(linearSystem);
        int size = this.Z.size();
        if (size == 0) {
            return;
        }
        setTableDimensions();
        if (linearSystem == this.a0) {
            int size2 = this.mVerticalGuidelines.size();
            int i = 0;
            while (true) {
                boolean z = true;
                if (i >= size2) {
                    break;
                }
                Guideline guideline = this.mVerticalGuidelines.get(i);
                if (getHorizontalDimensionBehaviour() != ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
                    z = false;
                }
                guideline.setPositionRelaxed(z);
                guideline.addToSolver(linearSystem);
                i++;
            }
            int size3 = this.mHorizontalGuidelines.size();
            for (int i2 = 0; i2 < size3; i2++) {
                Guideline guideline2 = this.mHorizontalGuidelines.get(i2);
                guideline2.setPositionRelaxed(getVerticalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT);
                guideline2.addToSolver(linearSystem);
            }
            for (int i3 = 0; i3 < size; i3++) {
                this.Z.get(i3).addToSolver(linearSystem);
            }
        }
    }

    public void computeGuidelinesPercentPositions() {
        int size = this.mVerticalGuidelines.size();
        for (int i = 0; i < size; i++) {
            this.mVerticalGuidelines.get(i).e();
        }
        int size2 = this.mHorizontalGuidelines.size();
        for (int i2 = 0; i2 < size2; i2++) {
            this.mHorizontalGuidelines.get(i2).e();
        }
    }

    public void cycleColumnAlignment(int i) {
        VerticalSlice verticalSlice = this.mVerticalSlices.get(i);
        int i2 = verticalSlice.c;
        if (i2 == 0) {
            verticalSlice.c = 2;
        } else if (i2 == 1) {
            verticalSlice.c = 0;
        } else if (i2 == 2) {
            verticalSlice.c = 1;
        }
        setChildrenConnections();
    }

    public String getColumnAlignmentRepresentation(int i) {
        int i2 = this.mVerticalSlices.get(i).c;
        return i2 == 1 ? "L" : i2 == 0 ? "C" : i2 == 3 ? "F" : i2 == 2 ? "R" : "!";
    }

    public String getColumnsAlignmentRepresentation() {
        StringBuilder sb;
        String str;
        int size = this.mVerticalSlices.size();
        String str2 = "";
        for (int i = 0; i < size; i++) {
            int i2 = this.mVerticalSlices.get(i).c;
            if (i2 == 1) {
                sb = new StringBuilder();
                sb.append(str2);
                str = "L";
            } else if (i2 == 0) {
                sb = new StringBuilder();
                sb.append(str2);
                str = "C";
            } else if (i2 == 3) {
                sb = new StringBuilder();
                sb.append(str2);
                str = "F";
            } else if (i2 == 2) {
                sb = new StringBuilder();
                sb.append(str2);
                str = "R";
            }
            sb.append(str);
            str2 = sb.toString();
        }
        return str2;
    }

    @Override // androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer
    public ArrayList<Guideline> getHorizontalGuidelines() {
        return this.mHorizontalGuidelines;
    }

    public int getNumCols() {
        return this.mNumCols;
    }

    public int getNumRows() {
        return this.mNumRows;
    }

    public int getPadding() {
        return this.mPadding;
    }

    @Override // androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer, androidx.constraintlayout.solver.widgets.ConstraintWidget
    public String getType() {
        return "ConstraintTableLayout";
    }

    @Override // androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer
    public ArrayList<Guideline> getVerticalGuidelines() {
        return this.mVerticalGuidelines;
    }

    @Override // androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer
    public boolean handlesInternalConstraints() {
        return true;
    }

    public boolean isVerticalGrowth() {
        return this.mVerticalGrowth;
    }

    public void setColumnAlignment(int i, int i2) {
        if (i < this.mVerticalSlices.size()) {
            this.mVerticalSlices.get(i).c = i2;
            setChildrenConnections();
        }
    }

    public void setColumnAlignment(String str) {
        int i;
        int length = str.length();
        for (int i2 = 0; i2 < length; i2++) {
            char charAt = str.charAt(i2);
            if (charAt == 'L') {
                i = 1;
            } else {
                if (charAt != 'C') {
                    if (charAt == 'F') {
                        i = 3;
                    } else if (charAt == 'R') {
                        i = 2;
                    }
                }
                setColumnAlignment(i2, 0);
            }
            setColumnAlignment(i2, i);
        }
    }

    @Override // androidx.constraintlayout.solver.widgets.ConstraintWidget
    public void setDebugSolverName(LinearSystem linearSystem, String str) {
        this.system = linearSystem;
        super.setDebugSolverName(linearSystem, str);
        updateDebugSolverNames();
    }

    public void setNumCols(int i) {
        if (!this.mVerticalGrowth || this.mNumCols == i) {
            return;
        }
        this.mNumCols = i;
        setVerticalSlices();
        setTableDimensions();
    }

    public void setNumRows(int i) {
        if (this.mVerticalGrowth || this.mNumCols == i) {
            return;
        }
        this.mNumRows = i;
        setHorizontalSlices();
        setTableDimensions();
    }

    public void setPadding(int i) {
        if (i > 1) {
            this.mPadding = i;
        }
    }

    public void setTableDimensions() {
        int size = this.Z.size();
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            i += this.Z.get(i2).getContainerItemSkip();
        }
        int i3 = size + i;
        if (this.mVerticalGrowth) {
            if (this.mNumCols == 0) {
                setNumCols(1);
            }
            int i4 = this.mNumCols;
            int i5 = i3 / i4;
            if (i4 * i5 < i3) {
                i5++;
            }
            if (this.mNumRows == i5 && this.mVerticalGuidelines.size() == this.mNumCols - 1) {
                return;
            }
            this.mNumRows = i5;
            setHorizontalSlices();
        } else {
            if (this.mNumRows == 0) {
                setNumRows(1);
            }
            int i6 = this.mNumRows;
            int i7 = i3 / i6;
            if (i6 * i7 < i3) {
                i7++;
            }
            if (this.mNumCols == i7 && this.mHorizontalGuidelines.size() == this.mNumRows - 1) {
                return;
            }
            this.mNumCols = i7;
            setVerticalSlices();
        }
        setChildrenConnections();
    }

    public void setVerticalGrowth(boolean z) {
        this.mVerticalGrowth = z;
    }

    @Override // androidx.constraintlayout.solver.widgets.ConstraintWidget
    public void updateFromSolver(LinearSystem linearSystem) {
        super.updateFromSolver(linearSystem);
        if (linearSystem == this.a0) {
            int size = this.mVerticalGuidelines.size();
            for (int i = 0; i < size; i++) {
                this.mVerticalGuidelines.get(i).updateFromSolver(linearSystem);
            }
            int size2 = this.mHorizontalGuidelines.size();
            for (int i2 = 0; i2 < size2; i2++) {
                this.mHorizontalGuidelines.get(i2).updateFromSolver(linearSystem);
            }
        }
    }
}
