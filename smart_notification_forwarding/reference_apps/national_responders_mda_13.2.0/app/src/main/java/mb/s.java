package mb;

import m8.g0;

/* loaded from: classes.dex */
public class s extends r {
    public static /* synthetic */ boolean A(CharSequence charSequence, CharSequence charSequence2, boolean z10, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            z10 = false;
        }
        return y(charSequence, charSequence2, z10);
    }

    public static final boolean B(CharSequence charSequence, char c10, boolean z10) {
        int E;
        y8.k.e(charSequence, "<this>");
        if (charSequence.length() > 0) {
            E = E(charSequence);
            if (b.d(charSequence.charAt(E), c10, z10)) {
                return true;
            }
        }
        return false;
    }

    public static /* synthetic */ boolean C(CharSequence charSequence, char c10, boolean z10, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            z10 = false;
        }
        return B(charSequence, c10, z10);
    }

    public static d9.c D(CharSequence charSequence) {
        y8.k.e(charSequence, "<this>");
        return new d9.c(0, charSequence.length() - 1);
    }

    public static int E(CharSequence charSequence) {
        y8.k.e(charSequence, "<this>");
        return charSequence.length() - 1;
    }

    public static final int F(CharSequence charSequence, char c10, int i10, boolean z10) {
        y8.k.e(charSequence, "<this>");
        return (z10 || !(charSequence instanceof String)) ? L(charSequence, new char[]{c10}, i10, z10) : ((String) charSequence).indexOf(c10, i10);
    }

    public static final int G(CharSequence charSequence, String str, int i10, boolean z10) {
        y8.k.e(charSequence, "<this>");
        y8.k.e(str, "string");
        return (z10 || !(charSequence instanceof String)) ? I(charSequence, str, i10, charSequence.length(), z10, false, 16, null) : ((String) charSequence).indexOf(str, i10);
    }

    private static final int H(CharSequence charSequence, CharSequence charSequence2, int i10, int i11, boolean z10, boolean z11) {
        int E;
        int c10;
        int a10;
        d9.a e10;
        int a11;
        int c11;
        if (z11) {
            E = E(charSequence);
            c10 = d9.f.c(i10, E);
            a10 = d9.f.a(i11, 0);
            e10 = d9.f.e(c10, a10);
        } else {
            a11 = d9.f.a(i10, 0);
            c11 = d9.f.c(i11, charSequence.length());
            e10 = new d9.c(a11, c11);
        }
        if ((charSequence instanceof String) && (charSequence2 instanceof String)) {
            int c12 = e10.c();
            int f10 = e10.f();
            int g10 = e10.g();
            if ((g10 <= 0 || c12 > f10) && (g10 >= 0 || f10 > c12)) {
                return -1;
            }
            while (!r.p((String) charSequence2, 0, (String) charSequence, c12, charSequence2.length(), z10)) {
                if (c12 == f10) {
                    return -1;
                }
                c12 += g10;
            }
            return c12;
        }
        int c13 = e10.c();
        int f11 = e10.f();
        int g11 = e10.g();
        if ((g11 <= 0 || c13 > f11) && (g11 >= 0 || f11 > c13)) {
            return -1;
        }
        while (!R(charSequence2, 0, charSequence, c13, charSequence2.length(), z10)) {
            if (c13 == f11) {
                return -1;
            }
            c13 += g11;
        }
        return c13;
    }

    static /* synthetic */ int I(CharSequence charSequence, CharSequence charSequence2, int i10, int i11, boolean z10, boolean z11, int i12, Object obj) {
        return H(charSequence, charSequence2, i10, i11, z10, (i12 & 16) != 0 ? false : z11);
    }

    public static /* synthetic */ int J(CharSequence charSequence, char c10, int i10, boolean z10, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            i10 = 0;
        }
        if ((i11 & 4) != 0) {
            z10 = false;
        }
        return F(charSequence, c10, i10, z10);
    }

    public static /* synthetic */ int K(CharSequence charSequence, String str, int i10, boolean z10, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            i10 = 0;
        }
        if ((i11 & 4) != 0) {
            z10 = false;
        }
        return G(charSequence, str, i10, z10);
    }

    public static final int L(CharSequence charSequence, char[] cArr, int i10, boolean z10) {
        int a10;
        int E;
        boolean z11;
        char C;
        y8.k.e(charSequence, "<this>");
        y8.k.e(cArr, "chars");
        if (!z10 && cArr.length == 1 && (charSequence instanceof String)) {
            C = m8.k.C(cArr);
            return ((String) charSequence).indexOf(C, i10);
        }
        a10 = d9.f.a(i10, 0);
        E = E(charSequence);
        g0 it = new d9.c(a10, E).iterator();
        while (it.hasNext()) {
            int b10 = it.b();
            char charAt = charSequence.charAt(b10);
            int length = cArr.length;
            int i11 = 0;
            while (true) {
                if (i11 >= length) {
                    z11 = false;
                    break;
                }
                if (b.d(cArr[i11], charAt, z10)) {
                    z11 = true;
                    break;
                }
                i11++;
            }
            if (z11) {
                return b10;
            }
        }
        return -1;
    }

    public static final int M(CharSequence charSequence, char c10, int i10, boolean z10) {
        y8.k.e(charSequence, "<this>");
        return (z10 || !(charSequence instanceof String)) ? Q(charSequence, new char[]{c10}, i10, z10) : ((String) charSequence).lastIndexOf(c10, i10);
    }

    public static final int N(CharSequence charSequence, String str, int i10, boolean z10) {
        y8.k.e(charSequence, "<this>");
        y8.k.e(str, "string");
        return (z10 || !(charSequence instanceof String)) ? H(charSequence, str, i10, 0, z10, true) : ((String) charSequence).lastIndexOf(str, i10);
    }

    public static /* synthetic */ int O(CharSequence charSequence, char c10, int i10, boolean z10, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            i10 = E(charSequence);
        }
        if ((i11 & 4) != 0) {
            z10 = false;
        }
        return M(charSequence, c10, i10, z10);
    }

    public static /* synthetic */ int P(CharSequence charSequence, String str, int i10, boolean z10, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            i10 = E(charSequence);
        }
        if ((i11 & 4) != 0) {
            z10 = false;
        }
        return N(charSequence, str, i10, z10);
    }

    public static final int Q(CharSequence charSequence, char[] cArr, int i10, boolean z10) {
        int E;
        int c10;
        char C;
        y8.k.e(charSequence, "<this>");
        y8.k.e(cArr, "chars");
        if (!z10 && cArr.length == 1 && (charSequence instanceof String)) {
            C = m8.k.C(cArr);
            return ((String) charSequence).lastIndexOf(C, i10);
        }
        E = E(charSequence);
        for (c10 = d9.f.c(i10, E); -1 < c10; c10--) {
            char charAt = charSequence.charAt(c10);
            int length = cArr.length;
            boolean z11 = false;
            int i11 = 0;
            while (true) {
                if (i11 >= length) {
                    break;
                }
                if (b.d(cArr[i11], charAt, z10)) {
                    z11 = true;
                    break;
                }
                i11++;
            }
            if (z11) {
                return c10;
            }
        }
        return -1;
    }

    public static final boolean R(CharSequence charSequence, int i10, CharSequence charSequence2, int i11, int i12, boolean z10) {
        y8.k.e(charSequence, "<this>");
        y8.k.e(charSequence2, "other");
        if (i11 < 0 || i10 < 0 || i10 > charSequence.length() - i12 || i11 > charSequence2.length() - i12) {
            return false;
        }
        for (int i13 = 0; i13 < i12; i13++) {
            if (!b.d(charSequence.charAt(i10 + i13), charSequence2.charAt(i11 + i13), z10)) {
                return false;
            }
        }
        return true;
    }

    public static String S(String str, CharSequence charSequence) {
        y8.k.e(str, "<this>");
        y8.k.e(charSequence, "prefix");
        if (!W(str, charSequence, false, 2, null)) {
            return str;
        }
        String substring = str.substring(charSequence.length());
        y8.k.d(substring, "this as java.lang.String).substring(startIndex)");
        return substring;
    }

    public static final boolean T(CharSequence charSequence, char c10, boolean z10) {
        y8.k.e(charSequence, "<this>");
        return charSequence.length() > 0 && b.d(charSequence.charAt(0), c10, z10);
    }

    public static final boolean U(CharSequence charSequence, CharSequence charSequence2, boolean z10) {
        boolean w10;
        y8.k.e(charSequence, "<this>");
        y8.k.e(charSequence2, "prefix");
        if (z10 || !(charSequence instanceof String) || !(charSequence2 instanceof String)) {
            return R(charSequence, 0, charSequence2, 0, charSequence2.length(), z10);
        }
        w10 = r.w((String) charSequence, (String) charSequence2, false, 2, null);
        return w10;
    }

    public static /* synthetic */ boolean V(CharSequence charSequence, char c10, boolean z10, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            z10 = false;
        }
        return T(charSequence, c10, z10);
    }

    public static /* synthetic */ boolean W(CharSequence charSequence, CharSequence charSequence2, boolean z10, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            z10 = false;
        }
        return U(charSequence, charSequence2, z10);
    }

    public static final String X(String str, char c10, String str2) {
        int J;
        y8.k.e(str, "<this>");
        y8.k.e(str2, "missingDelimiterValue");
        J = J(str, c10, 0, false, 6, null);
        if (J == -1) {
            return str2;
        }
        String substring = str.substring(J + 1, str.length());
        y8.k.d(substring, "this as java.lang.String…ing(startIndex, endIndex)");
        return substring;
    }

    public static String Y(String str, String str2, String str3) {
        y8.k.e(str, "<this>");
        y8.k.e(str2, "delimiter");
        y8.k.e(str3, "missingDelimiterValue");
        int K = K(str, str2, 0, false, 6, null);
        if (K == -1) {
            return str3;
        }
        String substring = str.substring(K + str2.length(), str.length());
        y8.k.d(substring, "this as java.lang.String…ing(startIndex, endIndex)");
        return substring;
    }

    public static /* synthetic */ String Z(String str, char c10, String str2, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            str2 = str;
        }
        return X(str, c10, str2);
    }

    public static /* synthetic */ String a0(String str, String str2, String str3, int i10, Object obj) {
        String Y;
        if ((i10 & 2) != 0) {
            str3 = str;
        }
        Y = Y(str, str2, str3);
        return Y;
    }

    public static String b0(String str, char c10, String str2) {
        y8.k.e(str, "<this>");
        y8.k.e(str2, "missingDelimiterValue");
        int O = O(str, c10, 0, false, 6, null);
        if (O == -1) {
            return str2;
        }
        String substring = str.substring(O + 1, str.length());
        y8.k.d(substring, "this as java.lang.String…ing(startIndex, endIndex)");
        return substring;
    }

    public static /* synthetic */ String c0(String str, char c10, String str2, int i10, Object obj) {
        String b02;
        if ((i10 & 2) != 0) {
            str2 = str;
        }
        b02 = b0(str, c10, str2);
        return b02;
    }

    public static final String d0(String str, char c10, String str2) {
        int J;
        y8.k.e(str, "<this>");
        y8.k.e(str2, "missingDelimiterValue");
        J = J(str, c10, 0, false, 6, null);
        if (J == -1) {
            return str2;
        }
        String substring = str.substring(0, J);
        y8.k.d(substring, "this as java.lang.String…ing(startIndex, endIndex)");
        return substring;
    }

    public static final String e0(String str, String str2, String str3) {
        y8.k.e(str, "<this>");
        y8.k.e(str2, "delimiter");
        y8.k.e(str3, "missingDelimiterValue");
        int K = K(str, str2, 0, false, 6, null);
        if (K == -1) {
            return str3;
        }
        String substring = str.substring(0, K);
        y8.k.d(substring, "this as java.lang.String…ing(startIndex, endIndex)");
        return substring;
    }

    public static /* synthetic */ String f0(String str, char c10, String str2, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            str2 = str;
        }
        return d0(str, c10, str2);
    }

    public static /* synthetic */ String g0(String str, String str2, String str3, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            str3 = str;
        }
        return e0(str, str2, str3);
    }

    public static String h0(String str, char c10, String str2) {
        y8.k.e(str, "<this>");
        y8.k.e(str2, "missingDelimiterValue");
        int O = O(str, c10, 0, false, 6, null);
        if (O == -1) {
            return str2;
        }
        String substring = str.substring(0, O);
        y8.k.d(substring, "this as java.lang.String…ing(startIndex, endIndex)");
        return substring;
    }

    public static String i0(String str, String str2, String str3) {
        int P;
        y8.k.e(str, "<this>");
        y8.k.e(str2, "delimiter");
        y8.k.e(str3, "missingDelimiterValue");
        P = P(str, str2, 0, false, 6, null);
        if (P == -1) {
            return str3;
        }
        String substring = str.substring(0, P);
        y8.k.d(substring, "this as java.lang.String…ing(startIndex, endIndex)");
        return substring;
    }

    public static CharSequence j0(CharSequence charSequence) {
        y8.k.e(charSequence, "<this>");
        int length = charSequence.length() - 1;
        int i10 = 0;
        boolean z10 = false;
        while (i10 <= length) {
            boolean c10 = a.c(charSequence.charAt(!z10 ? i10 : length));
            if (z10) {
                if (!c10) {
                    break;
                }
                length--;
            } else if (c10) {
                i10++;
            } else {
                z10 = true;
            }
        }
        return charSequence.subSequence(i10, length + 1);
    }

    public static final boolean x(CharSequence charSequence, char c10, boolean z10) {
        int J;
        y8.k.e(charSequence, "<this>");
        J = J(charSequence, c10, 0, z10, 2, null);
        return J >= 0;
    }

    public static final boolean y(CharSequence charSequence, CharSequence charSequence2, boolean z10) {
        y8.k.e(charSequence, "<this>");
        y8.k.e(charSequence2, "other");
        if (charSequence2 instanceof String) {
            if (K(charSequence, (String) charSequence2, 0, z10, 2, null) >= 0) {
                return true;
            }
        } else if (I(charSequence, charSequence2, 0, charSequence.length(), z10, false, 16, null) >= 0) {
            return true;
        }
        return false;
    }

    public static /* synthetic */ boolean z(CharSequence charSequence, char c10, boolean z10, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            z10 = false;
        }
        return x(charSequence, c10, z10);
    }
}
