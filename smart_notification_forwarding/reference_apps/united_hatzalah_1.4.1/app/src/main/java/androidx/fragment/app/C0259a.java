package androidx.fragment.app;

import F0.AbstractC0008a;
import java.io.PrintWriter;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Objects;
import org.apache.tika.utils.StringUtils;

/* renamed from: androidx.fragment.app.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0259a extends r0 implements InterfaceC0266d0 {

    /* renamed from: q, reason: collision with root package name */
    public final AbstractC0272g0 f3335q;

    /* renamed from: r, reason: collision with root package name */
    public boolean f3336r;

    /* renamed from: s, reason: collision with root package name */
    public int f3337s;

    public C0259a(AbstractC0272g0 abstractC0272g0) {
        abstractC0272g0.H();
        S s3 = abstractC0272g0.f3409w;
        if (s3 != null) {
            s3.f3321b.getClassLoader();
        }
        this.f3497a = new ArrayList();
        this.f3510o = false;
        this.f3337s = -1;
        this.f3335q = abstractC0272g0;
    }

    @Override // androidx.fragment.app.InterfaceC0266d0
    public final boolean a(ArrayList arrayList, ArrayList arrayList2) {
        if (AbstractC0272g0.J(2)) {
            toString();
        }
        arrayList.add(this);
        arrayList2.add(Boolean.FALSE);
        if (this.f3503g) {
            this.f3335q.f3392d.add(this);
            return true;
        }
        return true;
    }

    @Override // androidx.fragment.app.r0
    public final void c(int i, G g3, String str) {
        String str2 = g3.mPreviousWho;
        if (str2 != null) {
            a0.c.c(g3, str2);
        }
        Class<?> cls = g3.getClass();
        int modifiers = cls.getModifiers();
        if (!cls.isAnonymousClass() && Modifier.isPublic(modifiers) && (!cls.isMemberClass() || Modifier.isStatic(modifiers))) {
            if (str != null) {
                String str3 = g3.mTag;
                if (str3 != null && !str.equals(str3)) {
                    StringBuilder sb = new StringBuilder("Can't change tag of fragment ");
                    sb.append(g3);
                    sb.append(": was ");
                    throw new IllegalStateException(AbstractC0008a.v(sb, g3.mTag, " now ", str));
                }
                g3.mTag = str;
            }
            if (i != 0) {
                if (i != -1) {
                    int i3 = g3.mFragmentId;
                    if (i3 != 0 && i3 != i) {
                        throw new IllegalStateException("Can't change container ID of fragment " + g3 + ": was " + g3.mFragmentId + " now " + i);
                    }
                    g3.mFragmentId = i;
                    g3.mContainerId = i;
                } else {
                    throw new IllegalArgumentException("Can't add fragment " + g3 + " with tag " + str + " to container view with no id");
                }
            }
            b(new q0(g3, 1));
            g3.mFragmentManager = this.f3335q;
            return;
        }
        throw new IllegalStateException("Fragment " + cls.getCanonicalName() + " must be a public static class to be  properly recreated from instance state.");
    }

    public final void d(int i) {
        ArrayList arrayList = this.f3497a;
        if (this.f3503g) {
            if (AbstractC0272g0.J(2)) {
                toString();
            }
            int size = arrayList.size();
            for (int i3 = 0; i3 < size; i3++) {
                q0 q0Var = (q0) arrayList.get(i3);
                G g3 = q0Var.f3489b;
                if (g3 != null) {
                    g3.mBackStackNesting += i;
                    if (AbstractC0272g0.J(2)) {
                        Objects.toString(q0Var.f3489b);
                        int i4 = q0Var.f3489b.mBackStackNesting;
                    }
                }
            }
        }
    }

    public final void e() {
        ArrayList arrayList = this.f3497a;
        int size = arrayList.size() - 1;
        while (size >= 0) {
            q0 q0Var = (q0) arrayList.get(size);
            if (q0Var.f3490c) {
                if (q0Var.f3488a == 8) {
                    q0Var.f3490c = false;
                    arrayList.remove(size - 1);
                    size--;
                } else {
                    int i = q0Var.f3489b.mContainerId;
                    q0Var.f3488a = 2;
                    q0Var.f3490c = false;
                    for (int i3 = size - 1; i3 >= 0; i3--) {
                        q0 q0Var2 = (q0) arrayList.get(i3);
                        if (q0Var2.f3490c && q0Var2.f3489b.mContainerId == i) {
                            arrayList.remove(i3);
                            size--;
                        }
                    }
                }
            }
            size--;
        }
    }

    public final int f(boolean z3, boolean z4) {
        if (!this.f3336r) {
            if (AbstractC0272g0.J(2)) {
                toString();
                PrintWriter printWriter = new PrintWriter(new B0());
                g("  ", printWriter, true);
                printWriter.close();
            }
            this.f3336r = true;
            boolean z5 = this.f3503g;
            AbstractC0272g0 abstractC0272g0 = this.f3335q;
            if (z5) {
                this.f3337s = abstractC0272g0.f3398k.getAndIncrement();
            } else {
                this.f3337s = -1;
            }
            if (z4) {
                abstractC0272g0.x(this, z3);
            }
            return this.f3337s;
        }
        throw new IllegalStateException("commit already called");
    }

    public final void g(String str, PrintWriter printWriter, boolean z3) {
        String str2;
        ArrayList arrayList = this.f3497a;
        if (z3) {
            printWriter.print(str);
            printWriter.print("mName=");
            printWriter.print(this.f3504h);
            printWriter.print(" mIndex=");
            printWriter.print(this.f3337s);
            printWriter.print(" mCommitted=");
            printWriter.println(this.f3336r);
            if (this.f3502f != 0) {
                printWriter.print(str);
                printWriter.print("mTransition=#");
                printWriter.print(Integer.toHexString(this.f3502f));
            }
            if (this.f3498b != 0 || this.f3499c != 0) {
                printWriter.print(str);
                printWriter.print("mEnterAnim=#");
                printWriter.print(Integer.toHexString(this.f3498b));
                printWriter.print(" mExitAnim=#");
                printWriter.println(Integer.toHexString(this.f3499c));
            }
            if (this.f3500d != 0 || this.f3501e != 0) {
                printWriter.print(str);
                printWriter.print("mPopEnterAnim=#");
                printWriter.print(Integer.toHexString(this.f3500d));
                printWriter.print(" mPopExitAnim=#");
                printWriter.println(Integer.toHexString(this.f3501e));
            }
            if (this.i != 0 || this.f3505j != null) {
                printWriter.print(str);
                printWriter.print("mBreadCrumbTitleRes=#");
                printWriter.print(Integer.toHexString(this.i));
                printWriter.print(" mBreadCrumbTitleText=");
                printWriter.println(this.f3505j);
            }
            if (this.f3506k != 0 || this.f3507l != null) {
                printWriter.print(str);
                printWriter.print("mBreadCrumbShortTitleRes=#");
                printWriter.print(Integer.toHexString(this.f3506k));
                printWriter.print(" mBreadCrumbShortTitleText=");
                printWriter.println(this.f3507l);
            }
        }
        if (!arrayList.isEmpty()) {
            printWriter.print(str);
            printWriter.println("Operations:");
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                q0 q0Var = (q0) arrayList.get(i);
                switch (q0Var.f3488a) {
                    case 0:
                        str2 = "NULL";
                        break;
                    case 1:
                        str2 = "ADD";
                        break;
                    case 2:
                        str2 = "REPLACE";
                        break;
                    case 3:
                        str2 = "REMOVE";
                        break;
                    case 4:
                        str2 = "HIDE";
                        break;
                    case 5:
                        str2 = "SHOW";
                        break;
                    case 6:
                        str2 = "DETACH";
                        break;
                    case 7:
                        str2 = "ATTACH";
                        break;
                    case 8:
                        str2 = "SET_PRIMARY_NAV";
                        break;
                    case 9:
                        str2 = "UNSET_PRIMARY_NAV";
                        break;
                    case 10:
                        str2 = "OP_SET_MAX_LIFECYCLE";
                        break;
                    default:
                        str2 = "cmd=" + q0Var.f3488a;
                        break;
                }
                printWriter.print(str);
                printWriter.print("  Op #");
                printWriter.print(i);
                printWriter.print(": ");
                printWriter.print(str2);
                printWriter.print(StringUtils.SPACE);
                printWriter.println(q0Var.f3489b);
                if (z3) {
                    if (q0Var.f3491d != 0 || q0Var.f3492e != 0) {
                        printWriter.print(str);
                        printWriter.print("enterAnim=#");
                        printWriter.print(Integer.toHexString(q0Var.f3491d));
                        printWriter.print(" exitAnim=#");
                        printWriter.println(Integer.toHexString(q0Var.f3492e));
                    }
                    if (q0Var.f3493f != 0 || q0Var.f3494g != 0) {
                        printWriter.print(str);
                        printWriter.print("popEnterAnim=#");
                        printWriter.print(Integer.toHexString(q0Var.f3493f));
                        printWriter.print(" popExitAnim=#");
                        printWriter.println(Integer.toHexString(q0Var.f3494g));
                    }
                }
            }
        }
    }

    public final C0259a h(G g3) {
        AbstractC0272g0 abstractC0272g0 = g3.mFragmentManager;
        if (abstractC0272g0 != null && abstractC0272g0 != this.f3335q) {
            throw new IllegalStateException("Cannot remove Fragment attached to a different FragmentManager. Fragment " + g3.toString() + " is already attached to a FragmentManager.");
        }
        b(new q0(g3, 3));
        return this;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("BackStackEntry{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        if (this.f3337s >= 0) {
            sb.append(" #");
            sb.append(this.f3337s);
        }
        if (this.f3504h != null) {
            sb.append(StringUtils.SPACE);
            sb.append(this.f3504h);
        }
        sb.append("}");
        return sb.toString();
    }
}
