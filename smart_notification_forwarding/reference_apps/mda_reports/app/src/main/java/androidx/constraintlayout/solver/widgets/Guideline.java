package androidx.constraintlayout.solver.widgets;

import androidx.constraintlayout.solver.LinearSystem;
import androidx.constraintlayout.solver.SolverVariable;
import androidx.constraintlayout.solver.widgets.ConstraintAnchor;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class Guideline extends ConstraintWidget {
    public static final int HORIZONTAL = 0;
    public static final int RELATIVE_BEGIN = 1;
    public static final int RELATIVE_END = 2;
    public static final int RELATIVE_PERCENT = 0;
    public static final int RELATIVE_UNKNWON = -1;
    public static final int VERTICAL = 1;
    protected float Z = -1.0f;
    protected int a0 = -1;
    protected int b0 = -1;
    private ConstraintAnchor mAnchor = this.r;
    private int mOrientation = 0;
    private boolean mIsPositionRelaxed = false;
    private int mMinimumPosition = 0;
    private Rectangle mHead = new Rectangle();
    private int mHeadSize = 8;

    /* renamed from: androidx.constraintlayout.solver.widgets.Guideline$1, reason: invalid class name */
    /* loaded from: classes.dex */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] a = new int[ConstraintAnchor.Type.values().length];

        static {
            try {
                a[ConstraintAnchor.Type.LEFT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[ConstraintAnchor.Type.RIGHT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[ConstraintAnchor.Type.TOP.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[ConstraintAnchor.Type.BOTTOM.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[ConstraintAnchor.Type.BASELINE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                a[ConstraintAnchor.Type.CENTER.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                a[ConstraintAnchor.Type.CENTER_X.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                a[ConstraintAnchor.Type.CENTER_Y.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                a[ConstraintAnchor.Type.NONE.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
        }
    }

    public Guideline() {
        this.z.clear();
        this.z.add(this.mAnchor);
        int length = this.y.length;
        for (int i = 0; i < length; i++) {
            this.y[i] = this.mAnchor;
        }
    }

    @Override // androidx.constraintlayout.solver.widgets.ConstraintWidget
    public void addToSolver(LinearSystem linearSystem) {
        ConstraintWidgetContainer constraintWidgetContainer = (ConstraintWidgetContainer) getParent();
        if (constraintWidgetContainer == null) {
            return;
        }
        ConstraintAnchor anchor = constraintWidgetContainer.getAnchor(ConstraintAnchor.Type.LEFT);
        ConstraintAnchor anchor2 = constraintWidgetContainer.getAnchor(ConstraintAnchor.Type.RIGHT);
        ConstraintWidget constraintWidget = this.B;
        boolean z = constraintWidget != null && constraintWidget.A[0] == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        if (this.mOrientation == 0) {
            anchor = constraintWidgetContainer.getAnchor(ConstraintAnchor.Type.TOP);
            anchor2 = constraintWidgetContainer.getAnchor(ConstraintAnchor.Type.BOTTOM);
            ConstraintWidget constraintWidget2 = this.B;
            z = constraintWidget2 != null && constraintWidget2.A[1] == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        }
        if (this.a0 != -1) {
            SolverVariable createObjectVariable = linearSystem.createObjectVariable(this.mAnchor);
            linearSystem.addEquality(createObjectVariable, linearSystem.createObjectVariable(anchor), this.a0, 6);
            if (z) {
                linearSystem.addGreaterThan(linearSystem.createObjectVariable(anchor2), createObjectVariable, 0, 5);
                return;
            }
            return;
        }
        if (this.b0 == -1) {
            if (this.Z != -1.0f) {
                linearSystem.addConstraint(LinearSystem.createRowDimensionPercent(linearSystem, linearSystem.createObjectVariable(this.mAnchor), linearSystem.createObjectVariable(anchor), linearSystem.createObjectVariable(anchor2), this.Z, this.mIsPositionRelaxed));
                return;
            }
            return;
        }
        SolverVariable createObjectVariable2 = linearSystem.createObjectVariable(this.mAnchor);
        SolverVariable createObjectVariable3 = linearSystem.createObjectVariable(anchor2);
        linearSystem.addEquality(createObjectVariable2, createObjectVariable3, -this.b0, 6);
        if (z) {
            linearSystem.addGreaterThan(createObjectVariable2, linearSystem.createObjectVariable(anchor), 0, 5);
            linearSystem.addGreaterThan(createObjectVariable3, createObjectVariable2, 0, 5);
        }
    }

    @Override // androidx.constraintlayout.solver.widgets.ConstraintWidget
    public boolean allowedInBarrier() {
        return true;
    }

    @Override // androidx.constraintlayout.solver.widgets.ConstraintWidget
    public void analyze(int i) {
        int i2;
        ResolutionAnchor resolutionNode;
        ConstraintAnchor constraintAnchor;
        ResolutionAnchor resolutionNode2;
        ConstraintAnchor constraintAnchor2;
        ConstraintAnchor constraintAnchor3;
        ResolutionAnchor resolutionNode3;
        int i3;
        ConstraintWidget parent = getParent();
        if (parent == null) {
            return;
        }
        if (getOrientation() == 1) {
            this.r.getResolutionNode().dependsOn(1, parent.r.getResolutionNode(), 0);
            this.t.getResolutionNode().dependsOn(1, parent.r.getResolutionNode(), 0);
            if (this.a0 != -1) {
                this.q.getResolutionNode().dependsOn(1, parent.q.getResolutionNode(), this.a0);
                resolutionNode2 = this.s.getResolutionNode();
                constraintAnchor3 = parent.q;
                resolutionNode3 = constraintAnchor3.getResolutionNode();
                i3 = this.a0;
            } else {
                if (this.b0 == -1) {
                    if (this.Z == -1.0f || parent.getHorizontalDimensionBehaviour() != ConstraintWidget.DimensionBehaviour.FIXED) {
                        return;
                    }
                    i2 = (int) (parent.C * this.Z);
                    this.q.getResolutionNode().dependsOn(1, parent.q.getResolutionNode(), i2);
                    resolutionNode = this.s.getResolutionNode();
                    constraintAnchor = parent.q;
                    resolutionNode.dependsOn(1, constraintAnchor.getResolutionNode(), i2);
                    return;
                }
                this.q.getResolutionNode().dependsOn(1, parent.s.getResolutionNode(), -this.b0);
                resolutionNode2 = this.s.getResolutionNode();
                constraintAnchor2 = parent.s;
                resolutionNode3 = constraintAnchor2.getResolutionNode();
                i3 = -this.b0;
            }
        } else {
            this.q.getResolutionNode().dependsOn(1, parent.q.getResolutionNode(), 0);
            this.s.getResolutionNode().dependsOn(1, parent.q.getResolutionNode(), 0);
            if (this.a0 != -1) {
                this.r.getResolutionNode().dependsOn(1, parent.r.getResolutionNode(), this.a0);
                resolutionNode2 = this.t.getResolutionNode();
                constraintAnchor3 = parent.r;
                resolutionNode3 = constraintAnchor3.getResolutionNode();
                i3 = this.a0;
            } else {
                if (this.b0 == -1) {
                    if (this.Z == -1.0f || parent.getVerticalDimensionBehaviour() != ConstraintWidget.DimensionBehaviour.FIXED) {
                        return;
                    }
                    i2 = (int) (parent.D * this.Z);
                    this.r.getResolutionNode().dependsOn(1, parent.r.getResolutionNode(), i2);
                    resolutionNode = this.t.getResolutionNode();
                    constraintAnchor = parent.r;
                    resolutionNode.dependsOn(1, constraintAnchor.getResolutionNode(), i2);
                    return;
                }
                this.r.getResolutionNode().dependsOn(1, parent.t.getResolutionNode(), -this.b0);
                resolutionNode2 = this.t.getResolutionNode();
                constraintAnchor2 = parent.t;
                resolutionNode3 = constraintAnchor2.getResolutionNode();
                i3 = -this.b0;
            }
        }
        resolutionNode2.dependsOn(1, resolutionNode3, i3);
    }

    void c() {
        int x = getX();
        if (this.mOrientation == 0) {
            x = getY();
        }
        setGuideBegin(x);
    }

    public void cyclePosition() {
        if (this.a0 != -1) {
            e();
        } else if (this.Z != -1.0f) {
            d();
        } else if (this.b0 != -1) {
            c();
        }
    }

    void d() {
        int width = getParent().getWidth() - getX();
        if (this.mOrientation == 0) {
            width = getParent().getHeight() - getY();
        }
        setGuideEnd(width);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e() {
        float x = getX() / getParent().getWidth();
        if (this.mOrientation == 0) {
            x = getY() / getParent().getHeight();
        }
        setGuidePercent(x);
    }

    public ConstraintAnchor getAnchor() {
        return this.mAnchor;
    }

    @Override // androidx.constraintlayout.solver.widgets.ConstraintWidget
    public ConstraintAnchor getAnchor(ConstraintAnchor.Type type) {
        switch (AnonymousClass1.a[type.ordinal()]) {
            case 1:
            case 2:
                if (this.mOrientation == 1) {
                    return this.mAnchor;
                }
                break;
            case 3:
            case 4:
                if (this.mOrientation == 0) {
                    return this.mAnchor;
                }
                break;
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
                return null;
        }
        throw new AssertionError(type.name());
    }

    @Override // androidx.constraintlayout.solver.widgets.ConstraintWidget
    public ArrayList<ConstraintAnchor> getAnchors() {
        return this.z;
    }

    public Rectangle getHead() {
        Rectangle rectangle = this.mHead;
        int drawX = getDrawX() - this.mHeadSize;
        int drawY = getDrawY();
        int i = this.mHeadSize;
        rectangle.setBounds(drawX, drawY - (i * 2), i * 2, i * 2);
        if (getOrientation() == 0) {
            Rectangle rectangle2 = this.mHead;
            int drawX2 = getDrawX() - (this.mHeadSize * 2);
            int drawY2 = getDrawY();
            int i2 = this.mHeadSize;
            rectangle2.setBounds(drawX2, drawY2 - i2, i2 * 2, i2 * 2);
        }
        return this.mHead;
    }

    public int getOrientation() {
        return this.mOrientation;
    }

    public int getRelativeBegin() {
        return this.a0;
    }

    public int getRelativeBehaviour() {
        if (this.Z != -1.0f) {
            return 0;
        }
        if (this.a0 != -1) {
            return 1;
        }
        return this.b0 != -1 ? 2 : -1;
    }

    public int getRelativeEnd() {
        return this.b0;
    }

    public float getRelativePercent() {
        return this.Z;
    }

    @Override // androidx.constraintlayout.solver.widgets.ConstraintWidget
    public String getType() {
        return "Guideline";
    }

    @Override // androidx.constraintlayout.solver.widgets.ConstraintWidget
    public void setDrawOrigin(int i, int i2) {
        float f;
        int height;
        if (this.mOrientation == 1) {
            int i3 = i - this.K;
            if (this.a0 != -1) {
                setGuideBegin(i3);
                return;
            } else if (this.b0 != -1) {
                setGuideEnd(getParent().getWidth() - i3);
                return;
            } else {
                if (this.Z == -1.0f) {
                    return;
                }
                f = i3;
                height = getParent().getWidth();
            }
        } else {
            int i4 = i2 - this.L;
            if (this.a0 != -1) {
                setGuideBegin(i4);
                return;
            } else if (this.b0 != -1) {
                setGuideEnd(getParent().getHeight() - i4);
                return;
            } else {
                if (this.Z == -1.0f) {
                    return;
                }
                f = i4;
                height = getParent().getHeight();
            }
        }
        setGuidePercent(f / height);
    }

    public void setGuideBegin(int i) {
        if (i > -1) {
            this.Z = -1.0f;
            this.a0 = i;
            this.b0 = -1;
        }
    }

    public void setGuideEnd(int i) {
        if (i > -1) {
            this.Z = -1.0f;
            this.a0 = -1;
            this.b0 = i;
        }
    }

    public void setGuidePercent(float f) {
        if (f > -1.0f) {
            this.Z = f;
            this.a0 = -1;
            this.b0 = -1;
        }
    }

    public void setGuidePercent(int i) {
        setGuidePercent(i / 100.0f);
    }

    public void setMinimumPosition(int i) {
        this.mMinimumPosition = i;
    }

    public void setOrientation(int i) {
        if (this.mOrientation == i) {
            return;
        }
        this.mOrientation = i;
        this.z.clear();
        this.mAnchor = this.mOrientation == 1 ? this.q : this.r;
        this.z.add(this.mAnchor);
        int length = this.y.length;
        for (int i2 = 0; i2 < length; i2++) {
            this.y[i2] = this.mAnchor;
        }
    }

    public void setPositionRelaxed(boolean z) {
        if (this.mIsPositionRelaxed == z) {
            return;
        }
        this.mIsPositionRelaxed = z;
    }

    @Override // androidx.constraintlayout.solver.widgets.ConstraintWidget
    public void updateFromSolver(LinearSystem linearSystem) {
        if (getParent() == null) {
            return;
        }
        int objectVariableValue = linearSystem.getObjectVariableValue(this.mAnchor);
        if (this.mOrientation == 1) {
            setX(objectVariableValue);
            setY(0);
            setHeight(getParent().getHeight());
            setWidth(0);
            return;
        }
        setX(0);
        setY(objectVariableValue);
        setWidth(getParent().getWidth());
        setHeight(0);
    }
}
