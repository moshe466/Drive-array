package I;

import java.io.PrintWriter;

/* loaded from: classes.dex */
public abstract class d {

    /* renamed from: a, reason: collision with root package name */
    public static final Object f886a = new Object();

    /* renamed from: b, reason: collision with root package name */
    public static char[] f887b = new char[24];

    public static void a(Object obj, StringBuilder sb) {
        int lastIndexOf;
        if (obj == null) {
            sb.append("null");
            return;
        }
        String simpleName = obj.getClass().getSimpleName();
        if (simpleName.length() <= 0 && (lastIndexOf = (simpleName = obj.getClass().getName()).lastIndexOf(46)) > 0) {
            simpleName = simpleName.substring(lastIndexOf + 1);
        }
        sb.append(simpleName);
        sb.append('{');
        sb.append(Integer.toHexString(System.identityHashCode(obj)));
    }

    public static void b(String str, float f4) {
        if (!Float.isNaN(f4)) {
            if (!Float.isInfinite(f4)) {
                return;
            } else {
                throw new IllegalArgumentException(str.concat(" must not be infinite"));
            }
        }
        throw new IllegalArgumentException(str.concat(" must not be NaN"));
    }

    public static void c(Object obj, String str) {
        if (obj != null) {
        } else {
            throw new NullPointerException(str);
        }
    }

    public static void d(long j2, PrintWriter printWriter) {
        synchronized (f886a) {
            printWriter.print(new String(f887b, 0, e(j2)));
        }
    }

    public static int e(long j2) {
        char c4;
        int i;
        int i3;
        int i4;
        boolean z3;
        boolean z4;
        boolean z5;
        if (f887b.length < 0) {
            f887b = new char[0];
        }
        char[] cArr = f887b;
        if (j2 == 0) {
            cArr[0] = '0';
            return 1;
        }
        if (j2 > 0) {
            c4 = '+';
        } else {
            j2 = -j2;
            c4 = '-';
        }
        int i5 = (int) (j2 % 1000);
        int floor = (int) Math.floor(j2 / 1000);
        if (floor > 86400) {
            i = floor / 86400;
            floor -= 86400 * i;
        } else {
            i = 0;
        }
        if (floor > 3600) {
            i3 = floor / 3600;
            floor -= i3 * 3600;
        } else {
            i3 = 0;
        }
        if (floor > 60) {
            int i6 = floor / 60;
            floor -= i6 * 60;
            i4 = i6;
        } else {
            i4 = 0;
        }
        cArr[0] = c4;
        int f4 = f(cArr, i, 'd', 1, false, 0);
        if (f4 != 1) {
            z3 = true;
        } else {
            z3 = false;
        }
        int f5 = f(cArr, i3, 'h', f4, z3, 0);
        if (f5 != 1) {
            z4 = true;
        } else {
            z4 = false;
        }
        int f6 = f(cArr, i4, 'm', f5, z4, 0);
        if (f6 != 1) {
            z5 = true;
        } else {
            z5 = false;
        }
        int f7 = f(cArr, i5, 'm', f(cArr, floor, 's', f6, z5, 0), true, 0);
        cArr[f7] = 's';
        return f7 + 1;
    }

    public static int f(char[] cArr, int i, char c4, int i3, boolean z3, int i4) {
        int i5;
        if (!z3 && i <= 0) {
            return i3;
        }
        if ((z3 && i4 >= 3) || i > 99) {
            int i6 = i / 100;
            cArr[i3] = (char) (i6 + 48);
            i5 = i3 + 1;
            i -= i6 * 100;
        } else {
            i5 = i3;
        }
        if ((z3 && i4 >= 2) || i > 9 || i3 != i5) {
            int i7 = i / 10;
            cArr[i5] = (char) (i7 + 48);
            i5++;
            i -= i7 * 10;
        }
        cArr[i5] = (char) (i + 48);
        cArr[i5 + 1] = c4;
        return i5 + 2;
    }
}
