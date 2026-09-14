package N2;

import F0.AbstractC0008a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import t2.AbstractC0705g;
import t2.AbstractC0709k;

/* loaded from: classes.dex */
public abstract class f extends n {
    public static boolean N(CharSequence charSequence, CharSequence other, boolean z3) {
        kotlin.jvm.internal.j.e(charSequence, "<this>");
        kotlin.jvm.internal.j.e(other, "other");
        if (other instanceof String) {
            if (T(charSequence, (String) other, 0, z3, 2) >= 0) {
                return true;
            }
        } else if (S(charSequence, other, 0, charSequence.length(), z3, false) >= 0) {
            return true;
        }
        return false;
    }

    public static String P(String str) {
        int length = str.length() - 1;
        if (length < 0) {
            length = 0;
        }
        if (length >= 0) {
            int length2 = str.length();
            if (length > length2) {
                length = length2;
            }
            String substring = str.substring(0, length);
            kotlin.jvm.internal.j.d(substring, "substring(...)");
            return substring;
        }
        throw new IllegalArgumentException(AbstractC0008a.j(length, "Requested character count ", " is less than zero.").toString());
    }

    public static int Q(CharSequence charSequence) {
        kotlin.jvm.internal.j.e(charSequence, "<this>");
        return charSequence.length() - 1;
    }

    public static final int R(CharSequence charSequence, String string, int i, boolean z3) {
        kotlin.jvm.internal.j.e(charSequence, "<this>");
        kotlin.jvm.internal.j.e(string, "string");
        if (!z3 && (charSequence instanceof String)) {
            return ((String) charSequence).indexOf(string, i);
        }
        return S(charSequence, string, i, charSequence.length(), z3, false);
    }

    public static final int S(CharSequence charSequence, CharSequence charSequence2, int i, int i3, boolean z3, boolean z4) {
        K2.d dVar;
        if (!z4) {
            if (i < 0) {
                i = 0;
            }
            int length = charSequence.length();
            if (i3 > length) {
                i3 = length;
            }
            dVar = new K2.d(i, i3, 1);
        } else {
            int Q3 = Q(charSequence);
            if (i > Q3) {
                i = Q3;
            }
            if (i3 < 0) {
                i3 = 0;
            }
            dVar = new K2.d(i, i3, -1);
        }
        boolean z5 = charSequence instanceof String;
        int i4 = dVar.f1120c;
        int i5 = dVar.f1119b;
        int i6 = dVar.f1118a;
        if (z5 && (charSequence2 instanceof String)) {
            if ((i4 > 0 && i6 <= i5) || (i4 < 0 && i5 <= i6)) {
                int i7 = i6;
                while (true) {
                    String str = (String) charSequence2;
                    boolean z6 = z3;
                    if (n.K(0, i7, str.length(), str, (String) charSequence, z6)) {
                        return i7;
                    }
                    if (i7 == i5) {
                        break;
                    }
                    i7 += i4;
                    z3 = z6;
                }
            }
        } else {
            boolean z7 = z3;
            if ((i4 > 0 && i6 <= i5) || (i4 < 0 && i5 <= i6)) {
                while (true) {
                    CharSequence charSequence3 = charSequence;
                    CharSequence charSequence4 = charSequence2;
                    boolean z8 = z7;
                    z7 = z8;
                    if (W(charSequence4, 0, charSequence3, i6, charSequence2.length(), z8)) {
                        return i6;
                    }
                    if (i6 == i5) {
                        break;
                    }
                    i6 += i4;
                    charSequence2 = charSequence4;
                    charSequence = charSequence3;
                }
            }
        }
        return -1;
    }

    public static /* synthetic */ int T(CharSequence charSequence, String str, int i, boolean z3, int i3) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            z3 = false;
        }
        return R(charSequence, str, i, z3);
    }

    public static boolean U(CharSequence charSequence) {
        kotlin.jvm.internal.j.e(charSequence, "<this>");
        for (int i = 0; i < charSequence.length(); i++) {
            if (!T.b.z(charSequence.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public static String V(int i, String str) {
        CharSequence charSequence;
        kotlin.jvm.internal.j.e(str, "<this>");
        if (i >= 0) {
            if (i <= str.length()) {
                charSequence = str.subSequence(0, str.length());
            } else {
                StringBuilder sb = new StringBuilder(i);
                sb.append((CharSequence) str);
                int length = i - str.length();
                int i3 = 1;
                if (1 <= length) {
                    while (true) {
                        sb.append(' ');
                        if (i3 == length) {
                            break;
                        }
                        i3++;
                    }
                }
                charSequence = sb;
            }
            return charSequence.toString();
        }
        throw new IllegalArgumentException(AbstractC0008a.j(i, "Desired length ", " is less than zero."));
    }

    public static final boolean W(CharSequence charSequence, int i, CharSequence other, int i3, int i4, boolean z3) {
        char upperCase;
        char upperCase2;
        kotlin.jvm.internal.j.e(charSequence, "<this>");
        kotlin.jvm.internal.j.e(other, "other");
        if (i3 >= 0 && i >= 0 && i <= charSequence.length() - i4 && i3 <= other.length() - i4) {
            for (int i5 = 0; i5 < i4; i5++) {
                char charAt = charSequence.charAt(i + i5);
                char charAt2 = other.charAt(i3 + i5);
                if (charAt == charAt2 || (z3 && ((upperCase = Character.toUpperCase(charAt)) == (upperCase2 = Character.toUpperCase(charAt2)) || Character.toLowerCase(upperCase) == Character.toLowerCase(upperCase2)))) {
                }
            }
            return true;
        }
        return false;
    }

    public static String X(String str, String delimiter) {
        kotlin.jvm.internal.j.e(delimiter, "delimiter");
        if (str.length() >= delimiter.length() + delimiter.length() && n.M(str, delimiter) && n.I(str, delimiter)) {
            String substring = str.substring(delimiter.length(), str.length() - delimiter.length());
            kotlin.jvm.internal.j.d(substring, "substring(...)");
            return substring;
        }
        return str;
    }

    public static final void Y(int i) {
        if (i >= 0) {
        } else {
            throw new IllegalArgumentException(e0.a.c(i, "Limit must be non-negative, but was ").toString());
        }
    }

    public static final List Z(CharSequence charSequence, String str, int i) {
        boolean z3;
        Y(i);
        int R3 = R(charSequence, str, 0, false);
        if (R3 != -1 && i != 1) {
            if (i > 0) {
                z3 = true;
            } else {
                z3 = false;
            }
            int i3 = 10;
            if (z3 && i <= 10) {
                i3 = i;
            }
            ArrayList arrayList = new ArrayList(i3);
            int i4 = 0;
            do {
                arrayList.add(charSequence.subSequence(i4, R3).toString());
                i4 = str.length() + R3;
                if (z3 && arrayList.size() == i - 1) {
                    break;
                }
                R3 = R(charSequence, str, i4, false);
            } while (R3 != -1);
            arrayList.add(charSequence.subSequence(i4, charSequence.length()).toString());
            return arrayList;
        }
        return T.b.B(charSequence.toString());
    }

    public static List a0(String str, char[] cArr) {
        kotlin.jvm.internal.j.e(str, "<this>");
        if (cArr.length == 1) {
            return Z(str, String.valueOf(cArr[0]), 0);
        }
        Y(0);
        M2.h hVar = new M2.h(new c(str, 0, new o(cArr, 0)));
        ArrayList arrayList = new ArrayList(AbstractC0709k.Y(hVar, 10));
        Iterator it = hVar.iterator();
        while (true) {
            b bVar = (b) it;
            if (bVar.hasNext()) {
                K2.f range = (K2.f) bVar.next();
                kotlin.jvm.internal.j.e(range, "range");
                arrayList.add(str.subSequence(range.f1118a, range.f1119b + 1).toString());
            } else {
                return arrayList;
            }
        }
    }

    public static List b0(String str, String[] strArr, int i) {
        int i3;
        if ((i & 4) != 0) {
            i3 = 0;
        } else {
            i3 = 2;
        }
        kotlin.jvm.internal.j.e(str, "<this>");
        if (strArr.length == 1) {
            String str2 = strArr[0];
            if (str2.length() != 0) {
                return Z(str, str2, i3);
            }
        }
        Y(i3);
        M2.h hVar = new M2.h(new c(str, i3, new o(AbstractC0705g.B(strArr), 1)));
        ArrayList arrayList = new ArrayList(AbstractC0709k.Y(hVar, 10));
        Iterator it = hVar.iterator();
        while (true) {
            b bVar = (b) it;
            if (bVar.hasNext()) {
                K2.f range = (K2.f) bVar.next();
                kotlin.jvm.internal.j.e(range, "range");
                arrayList.add(str.subSequence(range.f1118a, range.f1119b + 1).toString());
            } else {
                return arrayList;
            }
        }
    }

    public static String c0(String str, String delimiter, String str2) {
        kotlin.jvm.internal.j.e(delimiter, "delimiter");
        int T3 = T(str, delimiter, 0, false, 6);
        if (T3 == -1) {
            return str2;
        }
        String substring = str.substring(delimiter.length() + T3, str.length());
        kotlin.jvm.internal.j.d(substring, "substring(...)");
        return substring;
    }

    public static String d0(String str, char c4, String str2) {
        int lastIndexOf = str.lastIndexOf(c4, Q(str));
        if (lastIndexOf == -1) {
            return str2;
        }
        String substring = str.substring(lastIndexOf + 1, str.length());
        kotlin.jvm.internal.j.d(substring, "substring(...)");
        return substring;
    }

    public static CharSequence e0(String str) {
        int i;
        kotlin.jvm.internal.j.e(str, "<this>");
        int length = str.length() - 1;
        int i3 = 0;
        boolean z3 = false;
        while (i3 <= length) {
            if (!z3) {
                i = i3;
            } else {
                i = length;
            }
            boolean z4 = T.b.z(str.charAt(i));
            if (!z3) {
                if (!z4) {
                    z3 = true;
                } else {
                    i3++;
                }
            } else {
                if (!z4) {
                    break;
                }
                length--;
            }
        }
        return str.subSequence(i3, length + 1);
    }
}
