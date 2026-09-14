package F0;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.fragment.app.AbstractC0272g0;
import com.google.android.recaptcha.internal.zzln;
import com.google.crypto.tink.shaded.protobuf.C0341m;

/* renamed from: F0.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract /* synthetic */ class AbstractC0008a {
    public static void A(String str, String str2, String str3) {
        Log.e(str3, str + str2);
    }

    public static void B(StringBuilder sb, String str, String str2) {
        sb.append(str);
        Log.e(str2, sb.toString());
    }

    public static int C(int i, int i3, int i4) {
        return C0341m.M(i) + i3 + i4;
    }

    public static int D(int i, int i3, int i4, int i5) {
        return C0341m.N(i) + i3 + i4 + i5;
    }

    public static final void a(int i, View view, ViewGroup container) {
        kotlin.jvm.internal.j.e(view, "view");
        kotlin.jvm.internal.j.e(container, "container");
        AbstractC0272g0.J(2);
        int b4 = T.k.b(i);
        ViewGroup viewGroup = null;
        if (b4 != 0) {
            if (b4 != 1) {
                if (b4 != 2) {
                    if (b4 == 3) {
                        if (AbstractC0272g0.J(2)) {
                            view.toString();
                        }
                        view.setVisibility(4);
                        return;
                    }
                    return;
                }
                if (AbstractC0272g0.J(2)) {
                    view.toString();
                }
                view.setVisibility(8);
                return;
            }
            if (AbstractC0272g0.J(2)) {
                view.toString();
            }
            ViewParent parent = view.getParent();
            if (parent instanceof ViewGroup) {
                viewGroup = (ViewGroup) parent;
            }
            if (viewGroup == null) {
                if (AbstractC0272g0.J(2)) {
                    view.toString();
                    container.toString();
                }
                container.addView(view);
            }
            view.setVisibility(0);
            return;
        }
        ViewParent parent2 = view.getParent();
        if (parent2 instanceof ViewGroup) {
            viewGroup = (ViewGroup) parent2;
        }
        if (viewGroup != null) {
            if (AbstractC0272g0.J(2)) {
                view.toString();
                viewGroup.toString();
            }
            viewGroup.removeView(view);
        }
    }

    public static final boolean b(int i) {
        return !O1.a.a();
    }

    public static final boolean c(int i) {
        Boolean bool;
        if (O1.a.a()) {
            try {
                bool = (Boolean) Class.forName("org.conscrypt.Conscrypt").getMethod("isBoringSslFIPSBuild", null).invoke(null, null);
            } catch (Exception unused) {
                O1.a.f1533a.info("Conscrypt is not available or does not support checking for FIPS build.");
                bool = Boolean.FALSE;
            }
            if (!bool.booleanValue()) {
                return false;
            }
        }
        return true;
    }

    public static int d(int i, int i3, int i4) {
        return zzln.zzA(i) + i3 + i4;
    }

    public static int e(int i, int i3, int i4, int i5) {
        return ((i * i3) / i4) + i5;
    }

    public static int f(Class cls, int i) {
        return i - cls.getName().length();
    }

    public static int g(String str, int i, int i3) {
        return (str.hashCode() + i) * i3;
    }

    public static long h(long j2, long j3, long j4, long j5) {
        return j2 + j3 + j4 + j5;
    }

    public static W0.f i(String str, String str2, W0.f[] fVarArr, int i, int i3) {
        V0.b.a(str, str2, fVarArr);
        return new W0.f(i, i3);
    }

    public static String j(int i, String str, String str2) {
        return str + i + str2;
    }

    public static String k(String str, int i, int i3, String str2) {
        return str + i + str2 + i3;
    }

    public static String l(String str, long j2) {
        return str + j2;
    }

    public static String m(String str, androidx.fragment.app.G g3, String str2) {
        return str + g3 + str2;
    }

    public static String n(String str, String str2) {
        return str + str2;
    }

    public static String o(String str, String str2, String str3) {
        return str + str2 + str3;
    }

    public static String p(String str, String str2, String str3, String str4, String str5) {
        return str + str2 + str3 + str4 + str5;
    }

    public static String q(String str, StringBuilder sb) {
        return str + ((Object) sb);
    }

    public static String r(StringBuilder sb, int i, String str) {
        sb.append(i);
        sb.append(str);
        return sb.toString();
    }

    public static String s(StringBuilder sb, String str, char c4) {
        sb.append(str);
        sb.append(c4);
        return sb.toString();
    }

    public static String t(StringBuilder sb, String str, int i) {
        sb.append(str);
        sb.append(i);
        return sb.toString();
    }

    public static String u(StringBuilder sb, String str, String str2) {
        sb.append(str);
        sb.append(str2);
        return sb.toString();
    }

    public static String v(StringBuilder sb, String str, String str2, String str3) {
        sb.append(str);
        sb.append(str2);
        sb.append(str3);
        return sb.toString();
    }

    public static StringBuilder w(int i, String str, String str2) {
        StringBuilder sb = new StringBuilder(str);
        sb.append(i);
        sb.append(str2);
        return sb;
    }

    public static StringBuilder x(String str, String str2, long j2) {
        StringBuilder sb = new StringBuilder(str);
        sb.append(j2);
        sb.append(str2);
        return sb;
    }

    public static StringBuilder y(String str, String str2, String str3, String str4, String str5) {
        StringBuilder sb = new StringBuilder(str);
        sb.append(str2);
        sb.append(str3);
        sb.append(str4);
        sb.append(str5);
        return sb;
    }

    public static /* synthetic */ void z(Object obj) {
        if (obj != null) {
            throw new ClassCastException();
        }
    }
}
