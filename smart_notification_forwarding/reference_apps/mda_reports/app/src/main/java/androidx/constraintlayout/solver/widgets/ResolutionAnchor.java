package androidx.constraintlayout.solver.widgets;

import androidx.constraintlayout.solver.LinearSystem;
import androidx.constraintlayout.solver.SolverVariable;
import androidx.constraintlayout.solver.widgets.ConstraintAnchor;

/* loaded from: classes.dex */
public class ResolutionAnchor extends ResolutionNode {
    public static final int BARRIER_CONNECTION = 5;
    public static final int CENTER_CONNECTION = 2;
    public static final int CHAIN_CONNECTION = 4;
    public static final int DIRECT_CONNECTION = 1;
    public static final int MATCH_CONNECTION = 3;
    public static final int UNCONNECTED = 0;
    ConstraintAnchor c;
    ResolutionAnchor d;
    float e;
    ResolutionAnchor f;
    float g;
    private ResolutionAnchor opposite;
    private float oppositeOffset;
    int h = 0;
    private ResolutionDimension dimension = null;
    private int dimensionMultiplier = 1;
    private ResolutionDimension oppositeDimension = null;
    private int oppositeDimensionMultiplier = 1;

    public ResolutionAnchor(ConstraintAnchor constraintAnchor) {
        this.c = constraintAnchor;
    }

    String a(int i) {
        return i == 1 ? "DIRECT" : i == 2 ? "CENTER" : i == 3 ? "MATCH" : i == 4 ? "CHAIN" : i == 5 ? "BARRIER" : "UNCONNECTED";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(LinearSystem linearSystem) {
        SolverVariable solverVariable = this.c.getSolverVariable();
        ResolutionAnchor resolutionAnchor = this.f;
        if (resolutionAnchor == null) {
            linearSystem.addEquality(solverVariable, (int) (this.g + 0.5f));
        } else {
            linearSystem.addEquality(solverVariable, linearSystem.createObjectVariable(resolutionAnchor.c), (int) (this.g + 0.5f), 6);
        }
    }

    public void dependsOn(int i, ResolutionAnchor resolutionAnchor, int i2) {
        this.h = i;
        this.d = resolutionAnchor;
        this.e = i2;
        this.d.addDependent(this);
    }

    public void dependsOn(ResolutionAnchor resolutionAnchor, int i) {
        this.d = resolutionAnchor;
        this.e = i;
        this.d.addDependent(this);
    }

    public void dependsOn(ResolutionAnchor resolutionAnchor, int i, ResolutionDimension resolutionDimension) {
        this.d = resolutionAnchor;
        this.d.addDependent(this);
        this.dimension = resolutionDimension;
        this.dimensionMultiplier = i;
        this.dimension.addDependent(this);
    }

    public float getResolvedValue() {
        return this.g;
    }

    @Override // androidx.constraintlayout.solver.widgets.ResolutionNode
    public void remove(ResolutionDimension resolutionDimension) {
        ResolutionDimension resolutionDimension2 = this.dimension;
        if (resolutionDimension2 == resolutionDimension) {
            this.dimension = null;
            this.e = this.dimensionMultiplier;
        } else if (resolutionDimension2 == this.oppositeDimension) {
            this.oppositeDimension = null;
            this.oppositeOffset = this.oppositeDimensionMultiplier;
        }
        resolve();
    }

    @Override // androidx.constraintlayout.solver.widgets.ResolutionNode
    public void reset() {
        super.reset();
        this.d = null;
        this.e = 0.0f;
        this.dimension = null;
        this.dimensionMultiplier = 1;
        this.oppositeDimension = null;
        this.oppositeDimensionMultiplier = 1;
        this.f = null;
        this.g = 0.0f;
        this.opposite = null;
        this.oppositeOffset = 0.0f;
        this.h = 0;
    }

    @Override // androidx.constraintlayout.solver.widgets.ResolutionNode
    public void resolve() {
        ResolutionAnchor resolutionAnchor;
        ResolutionAnchor resolutionAnchor2;
        ResolutionAnchor resolutionAnchor3;
        ResolutionAnchor resolutionAnchor4;
        ResolutionAnchor resolutionAnchor5;
        ResolutionAnchor resolutionAnchor6;
        float f;
        ResolutionAnchor resolutionAnchor7;
        float width;
        float f2;
        ResolutionAnchor resolutionAnchor8;
        float f3;
        boolean z = true;
        if (this.b == 1 || this.h == 4) {
            return;
        }
        ResolutionDimension resolutionDimension = this.dimension;
        if (resolutionDimension != null) {
            if (resolutionDimension.b != 1) {
                return;
            } else {
                this.e = this.dimensionMultiplier * resolutionDimension.c;
            }
        }
        ResolutionDimension resolutionDimension2 = this.oppositeDimension;
        if (resolutionDimension2 != null) {
            if (resolutionDimension2.b != 1) {
                return;
            } else {
                this.oppositeOffset = this.oppositeDimensionMultiplier * resolutionDimension2.c;
            }
        }
        if (this.h == 1 && ((resolutionAnchor8 = this.d) == null || resolutionAnchor8.b == 1)) {
            ResolutionAnchor resolutionAnchor9 = this.d;
            if (resolutionAnchor9 == null) {
                this.f = this;
                f3 = this.e;
            } else {
                this.f = resolutionAnchor9.f;
                f3 = resolutionAnchor9.g + this.e;
            }
            this.g = f3;
            didResolve();
            return;
        }
        if (this.h == 2 && (resolutionAnchor4 = this.d) != null && resolutionAnchor4.b == 1 && (resolutionAnchor5 = this.opposite) != null && (resolutionAnchor6 = resolutionAnchor5.d) != null && resolutionAnchor6.b == 1) {
            if (LinearSystem.getMetrics() != null) {
                LinearSystem.getMetrics().centerConnectionResolved++;
            }
            this.f = this.d.f;
            ResolutionAnchor resolutionAnchor10 = this.opposite;
            resolutionAnchor10.f = resolutionAnchor10.d.f;
            ConstraintAnchor.Type type = this.c.b;
            int i = 0;
            if (type != ConstraintAnchor.Type.RIGHT && type != ConstraintAnchor.Type.BOTTOM) {
                z = false;
            }
            if (z) {
                f = this.d.g;
                resolutionAnchor7 = this.opposite.d;
            } else {
                f = this.opposite.d.g;
                resolutionAnchor7 = this.d;
            }
            float f4 = f - resolutionAnchor7.g;
            ConstraintAnchor.Type type2 = this.c.b;
            if (type2 == ConstraintAnchor.Type.LEFT || type2 == ConstraintAnchor.Type.RIGHT) {
                width = f4 - this.c.a.getWidth();
                f2 = this.c.a.P;
            } else {
                width = f4 - r2.a.getHeight();
                f2 = this.c.a.Q;
            }
            int margin = this.c.getMargin();
            int margin2 = this.opposite.c.getMargin();
            if (this.c.getTarget() == this.opposite.c.getTarget()) {
                f2 = 0.5f;
                margin2 = 0;
            } else {
                i = margin;
            }
            float f5 = i;
            float f6 = margin2;
            float f7 = (width - f5) - f6;
            if (z) {
                ResolutionAnchor resolutionAnchor11 = this.opposite;
                resolutionAnchor11.g = resolutionAnchor11.d.g + f6 + (f7 * f2);
                this.g = (this.d.g - f5) - (f7 * (1.0f - f2));
            } else {
                this.g = this.d.g + f5 + (f7 * f2);
                ResolutionAnchor resolutionAnchor12 = this.opposite;
                resolutionAnchor12.g = (resolutionAnchor12.d.g - f6) - (f7 * (1.0f - f2));
            }
        } else {
            if (this.h != 3 || (resolutionAnchor = this.d) == null || resolutionAnchor.b != 1 || (resolutionAnchor2 = this.opposite) == null || (resolutionAnchor3 = resolutionAnchor2.d) == null || resolutionAnchor3.b != 1) {
                if (this.h == 5) {
                    this.c.a.resolve();
                    return;
                }
                return;
            }
            if (LinearSystem.getMetrics() != null) {
                LinearSystem.getMetrics().matchConnectionResolved++;
            }
            ResolutionAnchor resolutionAnchor13 = this.d;
            this.f = resolutionAnchor13.f;
            ResolutionAnchor resolutionAnchor14 = this.opposite;
            ResolutionAnchor resolutionAnchor15 = resolutionAnchor14.d;
            resolutionAnchor14.f = resolutionAnchor15.f;
            this.g = resolutionAnchor13.g + this.e;
            resolutionAnchor14.g = resolutionAnchor15.g + resolutionAnchor14.e;
        }
        didResolve();
        this.opposite.didResolve();
    }

    public void resolve(ResolutionAnchor resolutionAnchor, float f) {
        if (this.b == 0 || !(this.f == resolutionAnchor || this.g == f)) {
            this.f = resolutionAnchor;
            this.g = f;
            if (this.b == 1) {
                invalidate();
            }
            didResolve();
        }
    }

    public void setOpposite(ResolutionAnchor resolutionAnchor, float f) {
        this.opposite = resolutionAnchor;
        this.oppositeOffset = f;
    }

    public void setOpposite(ResolutionAnchor resolutionAnchor, int i, ResolutionDimension resolutionDimension) {
        this.opposite = resolutionAnchor;
        this.oppositeDimension = resolutionDimension;
        this.oppositeDimensionMultiplier = i;
    }

    public void setType(int i) {
        this.h = i;
    }

    public String toString() {
        StringBuilder sb;
        String str;
        if (this.b != 1) {
            sb = new StringBuilder();
            sb.append("{ ");
            sb.append(this.c);
            str = " UNRESOLVED} type: ";
        } else if (this.f == this) {
            sb = new StringBuilder();
            sb.append("[");
            sb.append(this.c);
            sb.append(", RESOLVED: ");
            sb.append(this.g);
            str = "]  type: ";
        } else {
            sb = new StringBuilder();
            sb.append("[");
            sb.append(this.c);
            sb.append(", RESOLVED: ");
            sb.append(this.f);
            sb.append(":");
            sb.append(this.g);
            str = "] type: ";
        }
        sb.append(str);
        sb.append(a(this.h));
        return sb.toString();
    }

    public void update() {
        ConstraintAnchor target = this.c.getTarget();
        if (target == null) {
            return;
        }
        if (target.getTarget() == this.c) {
            this.h = 4;
            target.getResolutionNode().h = 4;
        }
        int margin = this.c.getMargin();
        ConstraintAnchor.Type type = this.c.b;
        if (type == ConstraintAnchor.Type.RIGHT || type == ConstraintAnchor.Type.BOTTOM) {
            margin = -margin;
        }
        dependsOn(target.getResolutionNode(), margin);
    }
}
