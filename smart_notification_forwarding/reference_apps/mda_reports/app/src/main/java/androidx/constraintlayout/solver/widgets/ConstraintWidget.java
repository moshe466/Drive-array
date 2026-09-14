package androidx.constraintlayout.solver.widgets;

import androidx.constraintlayout.solver.Cache;
import androidx.constraintlayout.solver.LinearSystem;
import androidx.constraintlayout.solver.SolverVariable;
import androidx.constraintlayout.solver.widgets.ConstraintAnchor;
import androidx.exifinterface.media.ExifInterface;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class ConstraintWidget {
    private static final boolean AUTOTAG_CENTER = false;
    public static final int CHAIN_PACKED = 2;
    public static final int CHAIN_SPREAD = 0;
    public static final int CHAIN_SPREAD_INSIDE = 1;
    public static float DEFAULT_BIAS = 0.5f;
    public static final int GONE = 8;
    public static final int HORIZONTAL = 0;
    public static final int INVISIBLE = 4;
    public static final int MATCH_CONSTRAINT_PERCENT = 2;
    public static final int MATCH_CONSTRAINT_RATIO = 3;
    public static final int MATCH_CONSTRAINT_RATIO_RESOLVED = 4;
    public static final int MATCH_CONSTRAINT_SPREAD = 0;
    public static final int MATCH_CONSTRAINT_WRAP = 1;
    public static final int UNKNOWN = -1;
    public static final int VERTICAL = 1;
    public static final int VISIBLE = 0;
    private static final int WRAP = -2;
    protected DimensionBehaviour[] A;
    ConstraintWidget B;
    int C;
    int D;
    protected float E;
    protected int F;
    protected int G;
    protected int H;
    int I;
    int J;
    protected int K;
    protected int L;
    int M;
    protected int N;
    protected int O;
    float P;
    float Q;
    boolean R;
    boolean S;
    boolean T;
    int U;
    int V;
    float[] W;
    protected ConstraintWidget[] X;
    protected ConstraintWidget[] Y;
    ResolutionDimension a;
    ResolutionDimension b;
    int c;
    int d;
    int[] e;
    int f;
    int g;
    float h;
    int i;
    int j;
    float k;
    boolean l;
    boolean m;
    private float mCircleConstraintAngle;
    private Object mCompanionWidget;
    private int mContainerItemSkip;
    private String mDebugName;
    private int mDrawHeight;
    private int mDrawWidth;
    private int mDrawX;
    private int mDrawY;
    public int mHorizontalResolution;
    private int[] mMaxDimension;
    private String mType;
    public int mVerticalResolution;
    private int mVisibility;
    private int mWrapHeight;
    private int mWrapWidth;
    int n;
    float o;
    ConstraintWidgetGroup p;
    ConstraintAnchor q;
    ConstraintAnchor r;
    ConstraintAnchor s;
    ConstraintAnchor t;
    ConstraintAnchor u;
    ConstraintAnchor v;
    ConstraintAnchor w;
    ConstraintAnchor x;
    protected ConstraintAnchor[] y;
    protected ArrayList<ConstraintAnchor> z;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: androidx.constraintlayout.solver.widgets.ConstraintWidget$1, reason: invalid class name */
    /* loaded from: classes.dex */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] a;
        static final /* synthetic */ int[] b = new int[DimensionBehaviour.values().length];

        static {
            try {
                b[DimensionBehaviour.FIXED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                b[DimensionBehaviour.WRAP_CONTENT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                b[DimensionBehaviour.MATCH_PARENT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                b[DimensionBehaviour.MATCH_CONSTRAINT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            a = new int[ConstraintAnchor.Type.values().length];
            try {
                a[ConstraintAnchor.Type.LEFT.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                a[ConstraintAnchor.Type.TOP.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                a[ConstraintAnchor.Type.RIGHT.ordinal()] = 3;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                a[ConstraintAnchor.Type.BOTTOM.ordinal()] = 4;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                a[ConstraintAnchor.Type.BASELINE.ordinal()] = 5;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                a[ConstraintAnchor.Type.CENTER.ordinal()] = 6;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                a[ConstraintAnchor.Type.CENTER_X.ordinal()] = 7;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                a[ConstraintAnchor.Type.CENTER_Y.ordinal()] = 8;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                a[ConstraintAnchor.Type.NONE.ordinal()] = 9;
            } catch (NoSuchFieldError unused13) {
            }
        }
    }

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

    /* loaded from: classes.dex */
    public enum DimensionBehaviour {
        FIXED,
        WRAP_CONTENT,
        MATCH_CONSTRAINT,
        MATCH_PARENT
    }

    public ConstraintWidget() {
        this.mHorizontalResolution = -1;
        this.mVerticalResolution = -1;
        this.c = 0;
        this.d = 0;
        this.e = new int[2];
        this.f = 0;
        this.g = 0;
        this.h = 1.0f;
        this.i = 0;
        this.j = 0;
        this.k = 1.0f;
        this.n = -1;
        this.o = 1.0f;
        this.p = null;
        this.mMaxDimension = new int[]{Integer.MAX_VALUE, Integer.MAX_VALUE};
        this.mCircleConstraintAngle = 0.0f;
        this.q = new ConstraintAnchor(this, ConstraintAnchor.Type.LEFT);
        this.r = new ConstraintAnchor(this, ConstraintAnchor.Type.TOP);
        this.s = new ConstraintAnchor(this, ConstraintAnchor.Type.RIGHT);
        this.t = new ConstraintAnchor(this, ConstraintAnchor.Type.BOTTOM);
        this.u = new ConstraintAnchor(this, ConstraintAnchor.Type.BASELINE);
        this.v = new ConstraintAnchor(this, ConstraintAnchor.Type.CENTER_X);
        this.w = new ConstraintAnchor(this, ConstraintAnchor.Type.CENTER_Y);
        this.x = new ConstraintAnchor(this, ConstraintAnchor.Type.CENTER);
        this.y = new ConstraintAnchor[]{this.q, this.s, this.r, this.t, this.u, this.x};
        this.z = new ArrayList<>();
        DimensionBehaviour dimensionBehaviour = DimensionBehaviour.FIXED;
        this.A = new DimensionBehaviour[]{dimensionBehaviour, dimensionBehaviour};
        this.B = null;
        this.C = 0;
        this.D = 0;
        this.E = 0.0f;
        this.F = -1;
        this.G = 0;
        this.H = 0;
        this.I = 0;
        this.J = 0;
        this.mDrawX = 0;
        this.mDrawY = 0;
        this.mDrawWidth = 0;
        this.mDrawHeight = 0;
        this.K = 0;
        this.L = 0;
        this.M = 0;
        float f = DEFAULT_BIAS;
        this.P = f;
        this.Q = f;
        this.mContainerItemSkip = 0;
        this.mVisibility = 0;
        this.mDebugName = null;
        this.mType = null;
        this.R = false;
        this.S = false;
        this.T = false;
        this.U = 0;
        this.V = 0;
        this.W = new float[]{-1.0f, -1.0f};
        this.X = new ConstraintWidget[]{null, null};
        this.Y = new ConstraintWidget[]{null, null};
        addAnchors();
    }

    public ConstraintWidget(int i, int i2) {
        this(0, 0, i, i2);
    }

    public ConstraintWidget(int i, int i2, int i3, int i4) {
        this.mHorizontalResolution = -1;
        this.mVerticalResolution = -1;
        this.c = 0;
        this.d = 0;
        this.e = new int[2];
        this.f = 0;
        this.g = 0;
        this.h = 1.0f;
        this.i = 0;
        this.j = 0;
        this.k = 1.0f;
        this.n = -1;
        this.o = 1.0f;
        this.p = null;
        this.mMaxDimension = new int[]{Integer.MAX_VALUE, Integer.MAX_VALUE};
        this.mCircleConstraintAngle = 0.0f;
        this.q = new ConstraintAnchor(this, ConstraintAnchor.Type.LEFT);
        this.r = new ConstraintAnchor(this, ConstraintAnchor.Type.TOP);
        this.s = new ConstraintAnchor(this, ConstraintAnchor.Type.RIGHT);
        this.t = new ConstraintAnchor(this, ConstraintAnchor.Type.BOTTOM);
        this.u = new ConstraintAnchor(this, ConstraintAnchor.Type.BASELINE);
        this.v = new ConstraintAnchor(this, ConstraintAnchor.Type.CENTER_X);
        this.w = new ConstraintAnchor(this, ConstraintAnchor.Type.CENTER_Y);
        this.x = new ConstraintAnchor(this, ConstraintAnchor.Type.CENTER);
        this.y = new ConstraintAnchor[]{this.q, this.s, this.r, this.t, this.u, this.x};
        this.z = new ArrayList<>();
        DimensionBehaviour dimensionBehaviour = DimensionBehaviour.FIXED;
        this.A = new DimensionBehaviour[]{dimensionBehaviour, dimensionBehaviour};
        this.B = null;
        this.C = 0;
        this.D = 0;
        this.E = 0.0f;
        this.F = -1;
        this.G = 0;
        this.H = 0;
        this.I = 0;
        this.J = 0;
        this.mDrawX = 0;
        this.mDrawY = 0;
        this.mDrawWidth = 0;
        this.mDrawHeight = 0;
        this.K = 0;
        this.L = 0;
        this.M = 0;
        float f = DEFAULT_BIAS;
        this.P = f;
        this.Q = f;
        this.mContainerItemSkip = 0;
        this.mVisibility = 0;
        this.mDebugName = null;
        this.mType = null;
        this.R = false;
        this.S = false;
        this.T = false;
        this.U = 0;
        this.V = 0;
        this.W = new float[]{-1.0f, -1.0f};
        this.X = new ConstraintWidget[]{null, null};
        this.Y = new ConstraintWidget[]{null, null};
        this.G = i;
        this.H = i2;
        this.C = i3;
        this.D = i4;
        addAnchors();
        forceUpdateDrawPosition();
    }

    private void addAnchors() {
        this.z.add(this.q);
        this.z.add(this.r);
        this.z.add(this.s);
        this.z.add(this.t);
        this.z.add(this.v);
        this.z.add(this.w);
        this.z.add(this.x);
        this.z.add(this.u);
    }

    /* JADX WARN: Code restructure failed: missing block: B:66:0x01f0, code lost:
    
        if (r27 != false) goto L118;
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x01f9, code lost:
    
        r26.addGreaterThan(r29, r9, r1, 5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x01f7, code lost:
    
        if (r27 != false) goto L118;
     */
    /* JADX WARN: Removed duplicated region for block: B:101:0x0292  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x02e4  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x02e8 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:111:0x02f5 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:114:0x0303  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x030c  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x02d5  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x0107  */
    /* JADX WARN: Removed duplicated region for block: B:168:0x01cc A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00dd  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void applyConstraints(androidx.constraintlayout.solver.LinearSystem r26, boolean r27, androidx.constraintlayout.solver.SolverVariable r28, androidx.constraintlayout.solver.SolverVariable r29, androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour r30, boolean r31, androidx.constraintlayout.solver.widgets.ConstraintAnchor r32, androidx.constraintlayout.solver.widgets.ConstraintAnchor r33, int r34, int r35, int r36, int r37, float r38, boolean r39, boolean r40, int r41, int r42, int r43, float r44, boolean r45) {
        /*
            Method dump skipped, instructions count: 811
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.solver.widgets.ConstraintWidget.applyConstraints(androidx.constraintlayout.solver.LinearSystem, boolean, androidx.constraintlayout.solver.SolverVariable, androidx.constraintlayout.solver.SolverVariable, androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour, boolean, androidx.constraintlayout.solver.widgets.ConstraintAnchor, androidx.constraintlayout.solver.widgets.ConstraintAnchor, int, int, int, int, float, boolean, boolean, int, int, int, float, boolean):void");
    }

    private boolean isChainHead(int i) {
        int i2 = i * 2;
        ConstraintAnchor[] constraintAnchorArr = this.y;
        if (constraintAnchorArr[i2].c != null && constraintAnchorArr[i2].c.c != constraintAnchorArr[i2]) {
            int i3 = i2 + 1;
            if (constraintAnchorArr[i3].c != null && constraintAnchorArr[i3].c.c == constraintAnchorArr[i3]) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int a() {
        return this.G + this.K;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int a(int i) {
        if (i == 0) {
            return this.I;
        }
        if (i == 1) {
            return this.J;
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(int i, int i2) {
        if (i2 == 0) {
            this.I = i;
        } else if (i2 == 1) {
            this.J = i;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:116:0x02aa  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x02b9  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x02f8  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x0326  */
    /* JADX WARN: Removed duplicated region for block: B:130:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:132:0x031c  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x02c1  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x02b3  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x0237  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x01ab A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:74:0x01a1  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x01b7  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x01d0  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x0248 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0249  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void addToSolver(androidx.constraintlayout.solver.LinearSystem r39) {
        /*
            Method dump skipped, instructions count: 839
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.solver.widgets.ConstraintWidget.addToSolver(androidx.constraintlayout.solver.LinearSystem):void");
    }

    public boolean allowedInBarrier() {
        return this.mVisibility != 8;
    }

    public void analyze(int i) {
        Optimizer.a(i, this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int b() {
        return this.H + this.L;
    }

    public void connect(ConstraintAnchor.Type type, ConstraintWidget constraintWidget, ConstraintAnchor.Type type2) {
        connect(type, constraintWidget, type2, 0, ConstraintAnchor.Strength.STRONG);
    }

    public void connect(ConstraintAnchor.Type type, ConstraintWidget constraintWidget, ConstraintAnchor.Type type2, int i) {
        connect(type, constraintWidget, type2, i, ConstraintAnchor.Strength.STRONG);
    }

    public void connect(ConstraintAnchor.Type type, ConstraintWidget constraintWidget, ConstraintAnchor.Type type2, int i, ConstraintAnchor.Strength strength) {
        connect(type, constraintWidget, type2, i, strength, 0);
    }

    /* JADX WARN: Code restructure failed: missing block: B:100:0x01f2, code lost:
    
        if (r3.isConnected() != false) goto L91;
     */
    /* JADX WARN: Code restructure failed: missing block: B:101:0x01f4, code lost:
    
        r0.reset();
        r3.reset();
     */
    /* JADX WARN: Code restructure failed: missing block: B:109:0x0227, code lost:
    
        if (r3.isConnected() != false) goto L91;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void connect(androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type r16, androidx.constraintlayout.solver.widgets.ConstraintWidget r17, androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type r18, int r19, androidx.constraintlayout.solver.widgets.ConstraintAnchor.Strength r20, int r21) {
        /*
            Method dump skipped, instructions count: 577
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.solver.widgets.ConstraintWidget.connect(androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type, androidx.constraintlayout.solver.widgets.ConstraintWidget, androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type, int, androidx.constraintlayout.solver.widgets.ConstraintAnchor$Strength, int):void");
    }

    public void connect(ConstraintAnchor constraintAnchor, ConstraintAnchor constraintAnchor2, int i) {
        connect(constraintAnchor, constraintAnchor2, i, ConstraintAnchor.Strength.STRONG, 0);
    }

    public void connect(ConstraintAnchor constraintAnchor, ConstraintAnchor constraintAnchor2, int i, int i2) {
        connect(constraintAnchor, constraintAnchor2, i, ConstraintAnchor.Strength.STRONG, i2);
    }

    public void connect(ConstraintAnchor constraintAnchor, ConstraintAnchor constraintAnchor2, int i, ConstraintAnchor.Strength strength, int i2) {
        if (constraintAnchor.getOwner() == this) {
            connect(constraintAnchor.getType(), constraintAnchor2.getOwner(), constraintAnchor2.getType(), i, strength, i2);
        }
    }

    public void connectCircularConstraint(ConstraintWidget constraintWidget, float f, int i) {
        ConstraintAnchor.Type type = ConstraintAnchor.Type.CENTER;
        immediateConnect(type, constraintWidget, type, i, 0);
        this.mCircleConstraintAngle = f;
    }

    public void connectedTo(ConstraintWidget constraintWidget) {
    }

    public void createObjectVariables(LinearSystem linearSystem) {
        linearSystem.createObjectVariable(this.q);
        linearSystem.createObjectVariable(this.r);
        linearSystem.createObjectVariable(this.s);
        linearSystem.createObjectVariable(this.t);
        if (this.M > 0) {
            linearSystem.createObjectVariable(this.u);
        }
    }

    public void disconnectUnlockedWidget(ConstraintWidget constraintWidget) {
        ArrayList<ConstraintAnchor> anchors = getAnchors();
        int size = anchors.size();
        for (int i = 0; i < size; i++) {
            ConstraintAnchor constraintAnchor = anchors.get(i);
            if (constraintAnchor.isConnected() && constraintAnchor.getTarget().getOwner() == constraintWidget && constraintAnchor.getConnectionCreator() == 2) {
                constraintAnchor.reset();
            }
        }
    }

    public void disconnectWidget(ConstraintWidget constraintWidget) {
        ArrayList<ConstraintAnchor> anchors = getAnchors();
        int size = anchors.size();
        for (int i = 0; i < size; i++) {
            ConstraintAnchor constraintAnchor = anchors.get(i);
            if (constraintAnchor.isConnected() && constraintAnchor.getTarget().getOwner() == constraintWidget) {
                constraintAnchor.reset();
            }
        }
    }

    public void forceUpdateDrawPosition() {
        int i = this.G;
        int i2 = this.H;
        int i3 = this.C + i;
        int i4 = this.D + i2;
        this.mDrawX = i;
        this.mDrawY = i2;
        this.mDrawWidth = i3 - i;
        this.mDrawHeight = i4 - i2;
    }

    public ConstraintAnchor getAnchor(ConstraintAnchor.Type type) {
        switch (AnonymousClass1.a[type.ordinal()]) {
            case 1:
                return this.q;
            case 2:
                return this.r;
            case 3:
                return this.s;
            case 4:
                return this.t;
            case 5:
                return this.u;
            case 6:
                return this.x;
            case 7:
                return this.v;
            case 8:
                return this.w;
            case 9:
                return null;
            default:
                throw new AssertionError(type.name());
        }
    }

    public ArrayList<ConstraintAnchor> getAnchors() {
        return this.z;
    }

    public int getBaselineDistance() {
        return this.M;
    }

    public float getBiasPercent(int i) {
        if (i == 0) {
            return this.P;
        }
        if (i == 1) {
            return this.Q;
        }
        return -1.0f;
    }

    public int getBottom() {
        return getY() + this.D;
    }

    public Object getCompanionWidget() {
        return this.mCompanionWidget;
    }

    public int getContainerItemSkip() {
        return this.mContainerItemSkip;
    }

    public String getDebugName() {
        return this.mDebugName;
    }

    public DimensionBehaviour getDimensionBehaviour(int i) {
        if (i == 0) {
            return getHorizontalDimensionBehaviour();
        }
        if (i == 1) {
            return getVerticalDimensionBehaviour();
        }
        return null;
    }

    public float getDimensionRatio() {
        return this.E;
    }

    public int getDimensionRatioSide() {
        return this.F;
    }

    public int getDrawBottom() {
        return getDrawY() + this.mDrawHeight;
    }

    public int getDrawHeight() {
        return this.mDrawHeight;
    }

    public int getDrawRight() {
        return getDrawX() + this.mDrawWidth;
    }

    public int getDrawWidth() {
        return this.mDrawWidth;
    }

    public int getDrawX() {
        return this.mDrawX + this.K;
    }

    public int getDrawY() {
        return this.mDrawY + this.L;
    }

    public int getHeight() {
        if (this.mVisibility == 8) {
            return 0;
        }
        return this.D;
    }

    public float getHorizontalBiasPercent() {
        return this.P;
    }

    public ConstraintWidget getHorizontalChainControlWidget() {
        if (!isInHorizontalChain()) {
            return null;
        }
        ConstraintWidget constraintWidget = this;
        ConstraintWidget constraintWidget2 = null;
        while (constraintWidget2 == null && constraintWidget != null) {
            ConstraintAnchor anchor = constraintWidget.getAnchor(ConstraintAnchor.Type.LEFT);
            ConstraintAnchor target = anchor == null ? null : anchor.getTarget();
            ConstraintWidget owner = target == null ? null : target.getOwner();
            if (owner == getParent()) {
                return constraintWidget;
            }
            ConstraintAnchor target2 = owner == null ? null : owner.getAnchor(ConstraintAnchor.Type.RIGHT).getTarget();
            if (target2 == null || target2.getOwner() == constraintWidget) {
                constraintWidget = owner;
            } else {
                constraintWidget2 = constraintWidget;
            }
        }
        return constraintWidget2;
    }

    public int getHorizontalChainStyle() {
        return this.U;
    }

    public DimensionBehaviour getHorizontalDimensionBehaviour() {
        return this.A[0];
    }

    public int getInternalDrawBottom() {
        return this.mDrawY + this.mDrawHeight;
    }

    public int getInternalDrawRight() {
        return this.mDrawX + this.mDrawWidth;
    }

    public int getLeft() {
        return getX();
    }

    public int getLength(int i) {
        if (i == 0) {
            return getWidth();
        }
        if (i == 1) {
            return getHeight();
        }
        return 0;
    }

    public int getMaxHeight() {
        return this.mMaxDimension[1];
    }

    public int getMaxWidth() {
        return this.mMaxDimension[0];
    }

    public int getMinHeight() {
        return this.O;
    }

    public int getMinWidth() {
        return this.N;
    }

    public int getOptimizerWrapHeight() {
        int i;
        int i2 = this.D;
        if (this.A[1] != DimensionBehaviour.MATCH_CONSTRAINT) {
            return i2;
        }
        if (this.d == 1) {
            i = Math.max(this.i, i2);
        } else {
            i = this.i;
            if (i > 0) {
                this.D = i;
            } else {
                i = 0;
            }
        }
        int i3 = this.j;
        return (i3 <= 0 || i3 >= i) ? i : i3;
    }

    public int getOptimizerWrapWidth() {
        int i;
        int i2 = this.C;
        if (this.A[0] != DimensionBehaviour.MATCH_CONSTRAINT) {
            return i2;
        }
        if (this.c == 1) {
            i = Math.max(this.f, i2);
        } else {
            i = this.f;
            if (i > 0) {
                this.C = i;
            } else {
                i = 0;
            }
        }
        int i3 = this.g;
        return (i3 <= 0 || i3 >= i) ? i : i3;
    }

    public ConstraintWidget getParent() {
        return this.B;
    }

    public ResolutionDimension getResolutionHeight() {
        if (this.b == null) {
            this.b = new ResolutionDimension();
        }
        return this.b;
    }

    public ResolutionDimension getResolutionWidth() {
        if (this.a == null) {
            this.a = new ResolutionDimension();
        }
        return this.a;
    }

    public int getRight() {
        return getX() + this.C;
    }

    public WidgetContainer getRootWidgetContainer() {
        ConstraintWidget constraintWidget = this;
        while (constraintWidget.getParent() != null) {
            constraintWidget = constraintWidget.getParent();
        }
        if (constraintWidget instanceof WidgetContainer) {
            return (WidgetContainer) constraintWidget;
        }
        return null;
    }

    public int getTop() {
        return getY();
    }

    public String getType() {
        return this.mType;
    }

    public float getVerticalBiasPercent() {
        return this.Q;
    }

    public ConstraintWidget getVerticalChainControlWidget() {
        if (!isInVerticalChain()) {
            return null;
        }
        ConstraintWidget constraintWidget = this;
        ConstraintWidget constraintWidget2 = null;
        while (constraintWidget2 == null && constraintWidget != null) {
            ConstraintAnchor anchor = constraintWidget.getAnchor(ConstraintAnchor.Type.TOP);
            ConstraintAnchor target = anchor == null ? null : anchor.getTarget();
            ConstraintWidget owner = target == null ? null : target.getOwner();
            if (owner == getParent()) {
                return constraintWidget;
            }
            ConstraintAnchor target2 = owner == null ? null : owner.getAnchor(ConstraintAnchor.Type.BOTTOM).getTarget();
            if (target2 == null || target2.getOwner() == constraintWidget) {
                constraintWidget = owner;
            } else {
                constraintWidget2 = constraintWidget;
            }
        }
        return constraintWidget2;
    }

    public int getVerticalChainStyle() {
        return this.V;
    }

    public DimensionBehaviour getVerticalDimensionBehaviour() {
        return this.A[1];
    }

    public int getVisibility() {
        return this.mVisibility;
    }

    public int getWidth() {
        if (this.mVisibility == 8) {
            return 0;
        }
        return this.C;
    }

    public int getWrapHeight() {
        return this.mWrapHeight;
    }

    public int getWrapWidth() {
        return this.mWrapWidth;
    }

    public int getX() {
        return this.G;
    }

    public int getY() {
        return this.H;
    }

    public boolean hasAncestor(ConstraintWidget constraintWidget) {
        ConstraintWidget parent = getParent();
        if (parent == constraintWidget) {
            return true;
        }
        if (parent == constraintWidget.getParent()) {
            return false;
        }
        while (parent != null) {
            if (parent == constraintWidget || parent == constraintWidget.getParent()) {
                return true;
            }
            parent = parent.getParent();
        }
        return false;
    }

    public boolean hasBaseline() {
        return this.M > 0;
    }

    public void immediateConnect(ConstraintAnchor.Type type, ConstraintWidget constraintWidget, ConstraintAnchor.Type type2, int i, int i2) {
        getAnchor(type).connect(constraintWidget.getAnchor(type2), i, i2, ConstraintAnchor.Strength.STRONG, 0, true);
    }

    public boolean isFullyResolved() {
        return this.q.getResolutionNode().b == 1 && this.s.getResolutionNode().b == 1 && this.r.getResolutionNode().b == 1 && this.t.getResolutionNode().b == 1;
    }

    public boolean isHeightWrapContent() {
        return this.m;
    }

    public boolean isInHorizontalChain() {
        ConstraintAnchor constraintAnchor = this.q;
        ConstraintAnchor constraintAnchor2 = constraintAnchor.c;
        if (constraintAnchor2 != null && constraintAnchor2.c == constraintAnchor) {
            return true;
        }
        ConstraintAnchor constraintAnchor3 = this.s;
        ConstraintAnchor constraintAnchor4 = constraintAnchor3.c;
        return constraintAnchor4 != null && constraintAnchor4.c == constraintAnchor3;
    }

    public boolean isInVerticalChain() {
        ConstraintAnchor constraintAnchor = this.r;
        ConstraintAnchor constraintAnchor2 = constraintAnchor.c;
        if (constraintAnchor2 != null && constraintAnchor2.c == constraintAnchor) {
            return true;
        }
        ConstraintAnchor constraintAnchor3 = this.t;
        ConstraintAnchor constraintAnchor4 = constraintAnchor3.c;
        return constraintAnchor4 != null && constraintAnchor4.c == constraintAnchor3;
    }

    public boolean isInsideConstraintLayout() {
        ConstraintWidget parent = getParent();
        if (parent == null) {
            return false;
        }
        while (parent != null) {
            if (parent instanceof ConstraintWidgetContainer) {
                return true;
            }
            parent = parent.getParent();
        }
        return false;
    }

    public boolean isRoot() {
        return this.B == null;
    }

    public boolean isRootContainer() {
        ConstraintWidget constraintWidget;
        return (this instanceof ConstraintWidgetContainer) && ((constraintWidget = this.B) == null || !(constraintWidget instanceof ConstraintWidgetContainer));
    }

    public boolean isSpreadHeight() {
        return this.d == 0 && this.E == 0.0f && this.i == 0 && this.j == 0 && this.A[1] == DimensionBehaviour.MATCH_CONSTRAINT;
    }

    public boolean isSpreadWidth() {
        return this.c == 0 && this.E == 0.0f && this.f == 0 && this.g == 0 && this.A[0] == DimensionBehaviour.MATCH_CONSTRAINT;
    }

    public boolean isWidthWrapContent() {
        return this.l;
    }

    public void reset() {
        this.q.reset();
        this.r.reset();
        this.s.reset();
        this.t.reset();
        this.u.reset();
        this.v.reset();
        this.w.reset();
        this.x.reset();
        this.B = null;
        this.mCircleConstraintAngle = 0.0f;
        this.C = 0;
        this.D = 0;
        this.E = 0.0f;
        this.F = -1;
        this.G = 0;
        this.H = 0;
        this.mDrawX = 0;
        this.mDrawY = 0;
        this.mDrawWidth = 0;
        this.mDrawHeight = 0;
        this.K = 0;
        this.L = 0;
        this.M = 0;
        this.N = 0;
        this.O = 0;
        this.mWrapWidth = 0;
        this.mWrapHeight = 0;
        float f = DEFAULT_BIAS;
        this.P = f;
        this.Q = f;
        DimensionBehaviour[] dimensionBehaviourArr = this.A;
        DimensionBehaviour dimensionBehaviour = DimensionBehaviour.FIXED;
        dimensionBehaviourArr[0] = dimensionBehaviour;
        dimensionBehaviourArr[1] = dimensionBehaviour;
        this.mCompanionWidget = null;
        this.mContainerItemSkip = 0;
        this.mVisibility = 0;
        this.mType = null;
        this.U = 0;
        this.V = 0;
        float[] fArr = this.W;
        fArr[0] = -1.0f;
        fArr[1] = -1.0f;
        this.mHorizontalResolution = -1;
        this.mVerticalResolution = -1;
        int[] iArr = this.mMaxDimension;
        iArr[0] = Integer.MAX_VALUE;
        iArr[1] = Integer.MAX_VALUE;
        this.c = 0;
        this.d = 0;
        this.h = 1.0f;
        this.k = 1.0f;
        this.g = Integer.MAX_VALUE;
        this.j = Integer.MAX_VALUE;
        this.f = 0;
        this.i = 0;
        this.n = -1;
        this.o = 1.0f;
        ResolutionDimension resolutionDimension = this.a;
        if (resolutionDimension != null) {
            resolutionDimension.reset();
        }
        ResolutionDimension resolutionDimension2 = this.b;
        if (resolutionDimension2 != null) {
            resolutionDimension2.reset();
        }
        this.p = null;
        this.R = false;
        this.S = false;
        this.T = false;
    }

    public void resetAllConstraints() {
        DimensionBehaviour dimensionBehaviour;
        DimensionBehaviour dimensionBehaviour2;
        resetAnchors();
        setVerticalBiasPercent(DEFAULT_BIAS);
        setHorizontalBiasPercent(DEFAULT_BIAS);
        if (this instanceof ConstraintWidgetContainer) {
            return;
        }
        if (getHorizontalDimensionBehaviour() == DimensionBehaviour.MATCH_CONSTRAINT) {
            if (getWidth() == getWrapWidth()) {
                dimensionBehaviour2 = DimensionBehaviour.WRAP_CONTENT;
            } else if (getWidth() > getMinWidth()) {
                dimensionBehaviour2 = DimensionBehaviour.FIXED;
            }
            setHorizontalDimensionBehaviour(dimensionBehaviour2);
        }
        if (getVerticalDimensionBehaviour() == DimensionBehaviour.MATCH_CONSTRAINT) {
            if (getHeight() == getWrapHeight()) {
                dimensionBehaviour = DimensionBehaviour.WRAP_CONTENT;
            } else if (getHeight() <= getMinHeight()) {
                return;
            } else {
                dimensionBehaviour = DimensionBehaviour.FIXED;
            }
            setVerticalDimensionBehaviour(dimensionBehaviour);
        }
    }

    public void resetAnchor(ConstraintAnchor constraintAnchor) {
        if (getParent() != null && (getParent() instanceof ConstraintWidgetContainer) && ((ConstraintWidgetContainer) getParent()).handlesInternalConstraints()) {
            return;
        }
        ConstraintAnchor anchor = getAnchor(ConstraintAnchor.Type.LEFT);
        ConstraintAnchor anchor2 = getAnchor(ConstraintAnchor.Type.RIGHT);
        ConstraintAnchor anchor3 = getAnchor(ConstraintAnchor.Type.TOP);
        ConstraintAnchor anchor4 = getAnchor(ConstraintAnchor.Type.BOTTOM);
        ConstraintAnchor anchor5 = getAnchor(ConstraintAnchor.Type.CENTER);
        ConstraintAnchor anchor6 = getAnchor(ConstraintAnchor.Type.CENTER_X);
        ConstraintAnchor anchor7 = getAnchor(ConstraintAnchor.Type.CENTER_Y);
        if (constraintAnchor != anchor5) {
            if (constraintAnchor == anchor6) {
                if (anchor.isConnected() && anchor2.isConnected() && anchor.getTarget().getOwner() == anchor2.getTarget().getOwner()) {
                    anchor.reset();
                    anchor2.reset();
                }
                this.P = 0.5f;
            } else if (constraintAnchor == anchor7) {
                if (anchor3.isConnected() && anchor4.isConnected() && anchor3.getTarget().getOwner() == anchor4.getTarget().getOwner()) {
                    anchor3.reset();
                    anchor4.reset();
                }
            } else if (constraintAnchor == anchor || constraintAnchor == anchor2 ? !(!anchor.isConnected() || anchor.getTarget() != anchor2.getTarget()) : !((constraintAnchor != anchor3 && constraintAnchor != anchor4) || !anchor3.isConnected() || anchor3.getTarget() != anchor4.getTarget())) {
                anchor5.reset();
            }
            constraintAnchor.reset();
        }
        if (anchor.isConnected() && anchor2.isConnected() && anchor.getTarget() == anchor2.getTarget()) {
            anchor.reset();
            anchor2.reset();
        }
        if (anchor3.isConnected() && anchor4.isConnected() && anchor3.getTarget() == anchor4.getTarget()) {
            anchor3.reset();
            anchor4.reset();
        }
        this.P = 0.5f;
        this.Q = 0.5f;
        constraintAnchor.reset();
    }

    public void resetAnchors() {
        ConstraintWidget parent = getParent();
        if (parent != null && (parent instanceof ConstraintWidgetContainer) && ((ConstraintWidgetContainer) getParent()).handlesInternalConstraints()) {
            return;
        }
        int size = this.z.size();
        for (int i = 0; i < size; i++) {
            this.z.get(i).reset();
        }
    }

    public void resetAnchors(int i) {
        ConstraintWidget parent = getParent();
        if (parent != null && (parent instanceof ConstraintWidgetContainer) && ((ConstraintWidgetContainer) getParent()).handlesInternalConstraints()) {
            return;
        }
        int size = this.z.size();
        for (int i2 = 0; i2 < size; i2++) {
            ConstraintAnchor constraintAnchor = this.z.get(i2);
            if (i == constraintAnchor.getConnectionCreator()) {
                if (constraintAnchor.isVerticalAnchor()) {
                    setVerticalBiasPercent(DEFAULT_BIAS);
                } else {
                    setHorizontalBiasPercent(DEFAULT_BIAS);
                }
                constraintAnchor.reset();
            }
        }
    }

    public void resetResolutionNodes() {
        for (int i = 0; i < 6; i++) {
            this.y[i].getResolutionNode().reset();
        }
    }

    public void resetSolverVariables(Cache cache) {
        this.q.resetSolverVariable(cache);
        this.r.resetSolverVariable(cache);
        this.s.resetSolverVariable(cache);
        this.t.resetSolverVariable(cache);
        this.u.resetSolverVariable(cache);
        this.x.resetSolverVariable(cache);
        this.v.resetSolverVariable(cache);
        this.w.resetSolverVariable(cache);
    }

    public void resolve() {
    }

    public void setBaselineDistance(int i) {
        this.M = i;
    }

    public void setCompanionWidget(Object obj) {
        this.mCompanionWidget = obj;
    }

    public void setContainerItemSkip(int i) {
        if (i < 0) {
            i = 0;
        }
        this.mContainerItemSkip = i;
    }

    public void setDebugName(String str) {
        this.mDebugName = str;
    }

    public void setDebugSolverName(LinearSystem linearSystem, String str) {
        this.mDebugName = str;
        SolverVariable createObjectVariable = linearSystem.createObjectVariable(this.q);
        SolverVariable createObjectVariable2 = linearSystem.createObjectVariable(this.r);
        SolverVariable createObjectVariable3 = linearSystem.createObjectVariable(this.s);
        SolverVariable createObjectVariable4 = linearSystem.createObjectVariable(this.t);
        createObjectVariable.setName(str + ".left");
        createObjectVariable2.setName(str + ".top");
        createObjectVariable3.setName(str + ".right");
        createObjectVariable4.setName(str + ".bottom");
        if (this.M > 0) {
            linearSystem.createObjectVariable(this.u).setName(str + ".baseline");
        }
    }

    public void setDimension(int i, int i2) {
        this.C = i;
        int i3 = this.C;
        int i4 = this.N;
        if (i3 < i4) {
            this.C = i4;
        }
        this.D = i2;
        int i5 = this.D;
        int i6 = this.O;
        if (i5 < i6) {
            this.D = i6;
        }
    }

    public void setDimensionRatio(float f, int i) {
        this.E = f;
        this.F = i;
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:38:0x0084 -> B:31:0x0085). Please report as a decompilation issue!!! */
    public void setDimensionRatio(String str) {
        float f;
        int i = 0;
        if (str == null || str.length() == 0) {
            this.E = 0.0f;
            return;
        }
        int i2 = -1;
        int length = str.length();
        int indexOf = str.indexOf(44);
        int i3 = 0;
        if (indexOf > 0 && indexOf < length - 1) {
            String substring = str.substring(0, indexOf);
            if (substring.equalsIgnoreCase(ExifInterface.LONGITUDE_WEST)) {
                i2 = 0;
            } else if (substring.equalsIgnoreCase("H")) {
                i2 = 1;
            }
            i3 = indexOf + 1;
        }
        int indexOf2 = str.indexOf(58);
        if (indexOf2 < 0 || indexOf2 >= length - 1) {
            String substring2 = str.substring(i3);
            if (substring2.length() > 0) {
                f = Float.parseFloat(substring2);
            }
            f = 0.0f;
        } else {
            String substring3 = str.substring(i3, indexOf2);
            String substring4 = str.substring(indexOf2 + 1);
            if (substring3.length() > 0 && substring4.length() > 0) {
                float parseFloat = Float.parseFloat(substring3);
                float parseFloat2 = Float.parseFloat(substring4);
                if (parseFloat > 0.0f && parseFloat2 > 0.0f) {
                    f = i2 == 1 ? Math.abs(parseFloat2 / parseFloat) : Math.abs(parseFloat / parseFloat2);
                }
            }
            f = 0.0f;
        }
        i = (f > i ? 1 : (f == i ? 0 : -1));
        if (i > 0) {
            this.E = f;
            this.F = i2;
        }
    }

    public void setDrawHeight(int i) {
        this.mDrawHeight = i;
    }

    public void setDrawOrigin(int i, int i2) {
        this.mDrawX = i - this.K;
        this.mDrawY = i2 - this.L;
        this.G = this.mDrawX;
        this.H = this.mDrawY;
    }

    public void setDrawWidth(int i) {
        this.mDrawWidth = i;
    }

    public void setDrawX(int i) {
        this.mDrawX = i - this.K;
        this.G = this.mDrawX;
    }

    public void setDrawY(int i) {
        this.mDrawY = i - this.L;
        this.H = this.mDrawY;
    }

    public void setFrame(int i, int i2, int i3) {
        if (i3 == 0) {
            setHorizontalDimension(i, i2);
        } else if (i3 == 1) {
            setVerticalDimension(i, i2);
        }
        this.S = true;
    }

    public void setFrame(int i, int i2, int i3, int i4) {
        int i5;
        int i6;
        int i7 = i3 - i;
        int i8 = i4 - i2;
        this.G = i;
        this.H = i2;
        if (this.mVisibility == 8) {
            this.C = 0;
            this.D = 0;
            return;
        }
        if (this.A[0] != DimensionBehaviour.FIXED || i7 >= (i5 = this.C)) {
            i5 = i7;
        }
        if (this.A[1] != DimensionBehaviour.FIXED || i8 >= (i6 = this.D)) {
            i6 = i8;
        }
        this.C = i5;
        this.D = i6;
        int i9 = this.D;
        int i10 = this.O;
        if (i9 < i10) {
            this.D = i10;
        }
        int i11 = this.C;
        int i12 = this.N;
        if (i11 < i12) {
            this.C = i12;
        }
        this.S = true;
    }

    public void setGoneMargin(ConstraintAnchor.Type type, int i) {
        ConstraintAnchor constraintAnchor;
        int i2 = AnonymousClass1.a[type.ordinal()];
        if (i2 == 1) {
            constraintAnchor = this.q;
        } else if (i2 == 2) {
            constraintAnchor = this.r;
        } else if (i2 == 3) {
            constraintAnchor = this.s;
        } else if (i2 != 4) {
            return;
        } else {
            constraintAnchor = this.t;
        }
        constraintAnchor.d = i;
    }

    public void setHeight(int i) {
        this.D = i;
        int i2 = this.D;
        int i3 = this.O;
        if (i2 < i3) {
            this.D = i3;
        }
    }

    public void setHeightWrapContent(boolean z) {
        this.m = z;
    }

    public void setHorizontalBiasPercent(float f) {
        this.P = f;
    }

    public void setHorizontalChainStyle(int i) {
        this.U = i;
    }

    public void setHorizontalDimension(int i, int i2) {
        this.G = i;
        this.C = i2 - i;
        int i3 = this.C;
        int i4 = this.N;
        if (i3 < i4) {
            this.C = i4;
        }
    }

    public void setHorizontalDimensionBehaviour(DimensionBehaviour dimensionBehaviour) {
        this.A[0] = dimensionBehaviour;
        if (dimensionBehaviour == DimensionBehaviour.WRAP_CONTENT) {
            setWidth(this.mWrapWidth);
        }
    }

    public void setHorizontalMatchStyle(int i, int i2, int i3, float f) {
        this.c = i;
        this.f = i2;
        this.g = i3;
        this.h = f;
        if (f >= 1.0f || this.c != 0) {
            return;
        }
        this.c = 2;
    }

    public void setHorizontalWeight(float f) {
        this.W[0] = f;
    }

    public void setLength(int i, int i2) {
        if (i2 == 0) {
            setWidth(i);
        } else if (i2 == 1) {
            setHeight(i);
        }
    }

    public void setMaxHeight(int i) {
        this.mMaxDimension[1] = i;
    }

    public void setMaxWidth(int i) {
        this.mMaxDimension[0] = i;
    }

    public void setMinHeight(int i) {
        if (i < 0) {
            i = 0;
        }
        this.O = i;
    }

    public void setMinWidth(int i) {
        if (i < 0) {
            i = 0;
        }
        this.N = i;
    }

    public void setOffset(int i, int i2) {
        this.K = i;
        this.L = i2;
    }

    public void setOrigin(int i, int i2) {
        this.G = i;
        this.H = i2;
    }

    public void setParent(ConstraintWidget constraintWidget) {
        this.B = constraintWidget;
    }

    public void setType(String str) {
        this.mType = str;
    }

    public void setVerticalBiasPercent(float f) {
        this.Q = f;
    }

    public void setVerticalChainStyle(int i) {
        this.V = i;
    }

    public void setVerticalDimension(int i, int i2) {
        this.H = i;
        this.D = i2 - i;
        int i3 = this.D;
        int i4 = this.O;
        if (i3 < i4) {
            this.D = i4;
        }
    }

    public void setVerticalDimensionBehaviour(DimensionBehaviour dimensionBehaviour) {
        this.A[1] = dimensionBehaviour;
        if (dimensionBehaviour == DimensionBehaviour.WRAP_CONTENT) {
            setHeight(this.mWrapHeight);
        }
    }

    public void setVerticalMatchStyle(int i, int i2, int i3, float f) {
        this.d = i;
        this.i = i2;
        this.j = i3;
        this.k = f;
        if (f >= 1.0f || this.d != 0) {
            return;
        }
        this.d = 2;
    }

    public void setVerticalWeight(float f) {
        this.W[1] = f;
    }

    public void setVisibility(int i) {
        this.mVisibility = i;
    }

    public void setWidth(int i) {
        this.C = i;
        int i2 = this.C;
        int i3 = this.N;
        if (i2 < i3) {
            this.C = i3;
        }
    }

    public void setWidthWrapContent(boolean z) {
        this.l = z;
    }

    public void setWrapHeight(int i) {
        this.mWrapHeight = i;
    }

    public void setWrapWidth(int i) {
        this.mWrapWidth = i;
    }

    public void setX(int i) {
        this.G = i;
    }

    public void setY(int i) {
        this.H = i;
    }

    public void setupDimensionRatio(boolean z, boolean z2, boolean z3, boolean z4) {
        if (this.n == -1) {
            if (z3 && !z4) {
                this.n = 0;
            } else if (!z3 && z4) {
                this.n = 1;
                if (this.F == -1) {
                    this.o = 1.0f / this.o;
                }
            }
        }
        if (this.n == 0 && (!this.r.isConnected() || !this.t.isConnected())) {
            this.n = 1;
        } else if (this.n == 1 && (!this.q.isConnected() || !this.s.isConnected())) {
            this.n = 0;
        }
        if (this.n == -1 && (!this.r.isConnected() || !this.t.isConnected() || !this.q.isConnected() || !this.s.isConnected())) {
            if (this.r.isConnected() && this.t.isConnected()) {
                this.n = 0;
            } else if (this.q.isConnected() && this.s.isConnected()) {
                this.o = 1.0f / this.o;
                this.n = 1;
            }
        }
        if (this.n == -1) {
            if (z && !z2) {
                this.n = 0;
            } else if (!z && z2) {
                this.o = 1.0f / this.o;
                this.n = 1;
            }
        }
        if (this.n == -1) {
            if (this.f > 0 && this.i == 0) {
                this.n = 0;
            } else if (this.f == 0 && this.i > 0) {
                this.o = 1.0f / this.o;
                this.n = 1;
            }
        }
        if (this.n == -1 && z && z2) {
            this.o = 1.0f / this.o;
            this.n = 1;
        }
    }

    public String toString() {
        String str;
        StringBuilder sb = new StringBuilder();
        String str2 = "";
        if (this.mType != null) {
            str = "type: " + this.mType + " ";
        } else {
            str = "";
        }
        sb.append(str);
        if (this.mDebugName != null) {
            str2 = "id: " + this.mDebugName + " ";
        }
        sb.append(str2);
        sb.append("(");
        sb.append(this.G);
        sb.append(", ");
        sb.append(this.H);
        sb.append(") - (");
        sb.append(this.C);
        sb.append(" x ");
        sb.append(this.D);
        sb.append(") wrap: (");
        sb.append(this.mWrapWidth);
        sb.append(" x ");
        sb.append(this.mWrapHeight);
        sb.append(")");
        return sb.toString();
    }

    public void updateDrawPosition() {
        int i = this.G;
        int i2 = this.H;
        int i3 = this.C + i;
        int i4 = this.D + i2;
        this.mDrawX = i;
        this.mDrawY = i2;
        this.mDrawWidth = i3 - i;
        this.mDrawHeight = i4 - i2;
    }

    public void updateFromSolver(LinearSystem linearSystem) {
        int objectVariableValue = linearSystem.getObjectVariableValue(this.q);
        int objectVariableValue2 = linearSystem.getObjectVariableValue(this.r);
        int objectVariableValue3 = linearSystem.getObjectVariableValue(this.s);
        int objectVariableValue4 = linearSystem.getObjectVariableValue(this.t);
        int i = objectVariableValue4 - objectVariableValue2;
        if (objectVariableValue3 - objectVariableValue < 0 || i < 0 || objectVariableValue == Integer.MIN_VALUE || objectVariableValue == Integer.MAX_VALUE || objectVariableValue2 == Integer.MIN_VALUE || objectVariableValue2 == Integer.MAX_VALUE || objectVariableValue3 == Integer.MIN_VALUE || objectVariableValue3 == Integer.MAX_VALUE || objectVariableValue4 == Integer.MIN_VALUE || objectVariableValue4 == Integer.MAX_VALUE) {
            objectVariableValue4 = 0;
            objectVariableValue = 0;
            objectVariableValue2 = 0;
            objectVariableValue3 = 0;
        }
        setFrame(objectVariableValue, objectVariableValue2, objectVariableValue3, objectVariableValue4);
    }

    public void updateResolutionNodes() {
        for (int i = 0; i < 6; i++) {
            this.y[i].getResolutionNode().update();
        }
    }
}
