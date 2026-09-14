package androidx.constraintlayout.solver;

import androidx.exifinterface.media.ExifInterface;
import java.util.Arrays;

/* loaded from: classes.dex */
public class SolverVariable {
    private static final boolean INTERNAL_DEBUG = false;
    public static final int STRENGTH_BARRIER = 7;
    public static final int STRENGTH_EQUALITY = 5;
    public static final int STRENGTH_FIXED = 6;
    public static final int STRENGTH_HIGH = 3;
    public static final int STRENGTH_HIGHEST = 4;
    public static final int STRENGTH_LOW = 1;
    public static final int STRENGTH_MEDIUM = 2;
    public static final int STRENGTH_NONE = 0;
    private static int uniqueConstantId = 1;
    private static int uniqueErrorId = 1;
    private static int uniqueId = 1;
    private static int uniqueSlackId = 1;
    private static int uniqueUnrestrictedId = 1;
    int a;
    float[] b;
    Type c;
    public float computedValue;
    ArrayRow[] d;
    int e;
    public int id;
    private String mName;
    public int strength;
    public int usageInRowCount;

    /* renamed from: androidx.constraintlayout.solver.SolverVariable$1, reason: invalid class name */
    /* loaded from: classes.dex */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] a = new int[Type.values().length];

        static {
            try {
                a[Type.UNRESTRICTED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[Type.CONSTANT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[Type.SLACK.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[Type.ERROR.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[Type.UNKNOWN.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    /* loaded from: classes.dex */
    public enum Type {
        UNRESTRICTED,
        CONSTANT,
        SLACK,
        ERROR,
        UNKNOWN
    }

    public SolverVariable(Type type, String str) {
        this.id = -1;
        this.a = -1;
        this.strength = 0;
        this.b = new float[7];
        this.d = new ArrayRow[8];
        this.e = 0;
        this.usageInRowCount = 0;
        this.c = type;
    }

    public SolverVariable(String str, Type type) {
        this.id = -1;
        this.a = -1;
        this.strength = 0;
        this.b = new float[7];
        this.d = new ArrayRow[8];
        this.e = 0;
        this.usageInRowCount = 0;
        this.mName = str;
        this.c = type;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a() {
        uniqueErrorId++;
    }

    private static String getUniqueName(Type type, String str) {
        StringBuilder sb;
        int i;
        if (str != null) {
            sb = new StringBuilder();
            sb.append(str);
            i = uniqueErrorId;
        } else {
            int i2 = AnonymousClass1.a[type.ordinal()];
            if (i2 == 1) {
                sb = new StringBuilder();
                sb.append("U");
                i = uniqueUnrestrictedId + 1;
                uniqueUnrestrictedId = i;
            } else if (i2 == 2) {
                sb = new StringBuilder();
                sb.append("C");
                i = uniqueConstantId + 1;
                uniqueConstantId = i;
            } else if (i2 == 3) {
                sb = new StringBuilder();
                sb.append(ExifInterface.LATITUDE_SOUTH);
                i = uniqueSlackId + 1;
                uniqueSlackId = i;
            } else if (i2 == 4) {
                sb = new StringBuilder();
                sb.append("e");
                i = uniqueErrorId + 1;
                uniqueErrorId = i;
            } else {
                if (i2 != 5) {
                    throw new AssertionError(type.name());
                }
                sb = new StringBuilder();
                sb.append(ExifInterface.GPS_MEASUREMENT_INTERRUPTED);
                i = uniqueId + 1;
                uniqueId = i;
            }
        }
        sb.append(i);
        return sb.toString();
    }

    public final void addToRow(ArrayRow arrayRow) {
        int i = 0;
        while (true) {
            int i2 = this.e;
            if (i >= i2) {
                ArrayRow[] arrayRowArr = this.d;
                if (i2 >= arrayRowArr.length) {
                    this.d = (ArrayRow[]) Arrays.copyOf(arrayRowArr, arrayRowArr.length * 2);
                }
                ArrayRow[] arrayRowArr2 = this.d;
                int i3 = this.e;
                arrayRowArr2[i3] = arrayRow;
                this.e = i3 + 1;
                return;
            }
            if (this.d[i] == arrayRow) {
                return;
            } else {
                i++;
            }
        }
    }

    public String getName() {
        return this.mName;
    }

    public final void removeFromRow(ArrayRow arrayRow) {
        int i = this.e;
        for (int i2 = 0; i2 < i; i2++) {
            if (this.d[i2] == arrayRow) {
                for (int i3 = 0; i3 < (i - i2) - 1; i3++) {
                    ArrayRow[] arrayRowArr = this.d;
                    int i4 = i2 + i3;
                    arrayRowArr[i4] = arrayRowArr[i4 + 1];
                }
                this.e--;
                return;
            }
        }
    }

    public void reset() {
        this.mName = null;
        this.c = Type.UNKNOWN;
        this.strength = 0;
        this.id = -1;
        this.a = -1;
        this.computedValue = 0.0f;
        this.e = 0;
        this.usageInRowCount = 0;
    }

    public void setName(String str) {
        this.mName = str;
    }

    public void setType(Type type, String str) {
        this.c = type;
    }

    public String toString() {
        return "" + this.mName;
    }

    public final void updateReferencesWithNewDefinition(ArrayRow arrayRow) {
        int i = this.e;
        for (int i2 = 0; i2 < i; i2++) {
            ArrayRow[] arrayRowArr = this.d;
            arrayRowArr[i2].variables.a(arrayRowArr[i2], arrayRow, false);
        }
        this.e = 0;
    }
}
