package androidx.fragment.app;

import androidx.fragment.app.f0;
import androidx.fragment.app.w;
import java.io.PrintWriter;
import java.util.ArrayList;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class a extends f0 implements w.n {

    /* renamed from: r, reason: collision with root package name */
    final w f2889r;

    /* renamed from: s, reason: collision with root package name */
    boolean f2890s;

    /* renamed from: t, reason: collision with root package name */
    int f2891t;

    /* renamed from: u, reason: collision with root package name */
    boolean f2892u;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(w wVar) {
        super(wVar.s0(), wVar.u0() != null ? wVar.u0().j().getClassLoader() : null);
        this.f2891t = -1;
        this.f2892u = false;
        this.f2889r = wVar;
    }

    public String A() {
        return this.f3002i;
    }

    public void B() {
        if (this.f3010q != null) {
            for (int i10 = 0; i10 < this.f3010q.size(); i10++) {
                this.f3010q.get(i10).run();
            }
            this.f3010q = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Fragment C(ArrayList<Fragment> arrayList, Fragment fragment) {
        for (int size = this.f2994a.size() - 1; size >= 0; size--) {
            f0.a aVar = this.f2994a.get(size);
            int i10 = aVar.f3011a;
            if (i10 != 1) {
                if (i10 != 3) {
                    switch (i10) {
                        case 8:
                            fragment = null;
                            break;
                        case 9:
                            fragment = aVar.f3012b;
                            break;
                        case 10:
                            aVar.f3019i = aVar.f3018h;
                            break;
                    }
                }
                arrayList.add(aVar.f3012b);
            }
            arrayList.remove(aVar.f3012b);
        }
        return fragment;
    }

    @Override // androidx.fragment.app.w.n
    public boolean a(ArrayList<a> arrayList, ArrayList<Boolean> arrayList2) {
        if (w.H0(2)) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Run: ");
            sb2.append(this);
        }
        arrayList.add(this);
        arrayList2.add(Boolean.FALSE);
        if (!this.f3000g) {
            return true;
        }
        this.f2889r.i(this);
        return true;
    }

    @Override // androidx.fragment.app.f0
    public int h() {
        return u(false);
    }

    @Override // androidx.fragment.app.f0
    public int i() {
        return u(true);
    }

    @Override // androidx.fragment.app.f0
    public void j() {
        l();
        this.f2889r.c0(this, false);
    }

    @Override // androidx.fragment.app.f0
    public void k() {
        l();
        this.f2889r.c0(this, true);
    }

    @Override // androidx.fragment.app.f0
    void m(int i10, Fragment fragment, String str, int i11) {
        super.m(i10, fragment, str, i11);
        fragment.f2850y = this.f2889r;
    }

    @Override // androidx.fragment.app.f0
    public f0 n(Fragment fragment) {
        w wVar = fragment.f2850y;
        if (wVar == null || wVar == this.f2889r) {
            return super.n(fragment);
        }
        throw new IllegalStateException("Cannot remove Fragment attached to a different FragmentManager. Fragment " + fragment.toString() + " is already attached to a FragmentManager.");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void t(int i10) {
        if (this.f3000g) {
            if (w.H0(2)) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Bump nesting in ");
                sb2.append(this);
                sb2.append(" by ");
                sb2.append(i10);
            }
            int size = this.f2994a.size();
            for (int i11 = 0; i11 < size; i11++) {
                f0.a aVar = this.f2994a.get(i11);
                Fragment fragment = aVar.f3012b;
                if (fragment != null) {
                    fragment.f2849x += i10;
                    if (w.H0(2)) {
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append("Bump nesting of ");
                        sb3.append(aVar.f3012b);
                        sb3.append(" to ");
                        sb3.append(aVar.f3012b.f2849x);
                    }
                }
            }
        }
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder(128);
        sb2.append("BackStackEntry{");
        sb2.append(Integer.toHexString(System.identityHashCode(this)));
        if (this.f2891t >= 0) {
            sb2.append(" #");
            sb2.append(this.f2891t);
        }
        if (this.f3002i != null) {
            sb2.append(" ");
            sb2.append(this.f3002i);
        }
        sb2.append("}");
        return sb2.toString();
    }

    int u(boolean z10) {
        if (this.f2890s) {
            throw new IllegalStateException("commit already called");
        }
        if (w.H0(2)) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Commit: ");
            sb2.append(this);
            PrintWriter printWriter = new PrintWriter(new k0("FragmentManager"));
            v("  ", printWriter);
            printWriter.close();
        }
        this.f2890s = true;
        this.f2891t = this.f3000g ? this.f2889r.l() : -1;
        this.f2889r.Z(this, z10);
        return this.f2891t;
    }

    public void v(String str, PrintWriter printWriter) {
        w(str, printWriter, true);
    }

    public void w(String str, PrintWriter printWriter, boolean z10) {
        String str2;
        if (z10) {
            printWriter.print(str);
            printWriter.print("mName=");
            printWriter.print(this.f3002i);
            printWriter.print(" mIndex=");
            printWriter.print(this.f2891t);
            printWriter.print(" mCommitted=");
            printWriter.println(this.f2890s);
            if (this.f2999f != 0) {
                printWriter.print(str);
                printWriter.print("mTransition=#");
                printWriter.print(Integer.toHexString(this.f2999f));
            }
            if (this.f2995b != 0 || this.f2996c != 0) {
                printWriter.print(str);
                printWriter.print("mEnterAnim=#");
                printWriter.print(Integer.toHexString(this.f2995b));
                printWriter.print(" mExitAnim=#");
                printWriter.println(Integer.toHexString(this.f2996c));
            }
            if (this.f2997d != 0 || this.f2998e != 0) {
                printWriter.print(str);
                printWriter.print("mPopEnterAnim=#");
                printWriter.print(Integer.toHexString(this.f2997d));
                printWriter.print(" mPopExitAnim=#");
                printWriter.println(Integer.toHexString(this.f2998e));
            }
            if (this.f3003j != 0 || this.f3004k != null) {
                printWriter.print(str);
                printWriter.print("mBreadCrumbTitleRes=#");
                printWriter.print(Integer.toHexString(this.f3003j));
                printWriter.print(" mBreadCrumbTitleText=");
                printWriter.println(this.f3004k);
            }
            if (this.f3005l != 0 || this.f3006m != null) {
                printWriter.print(str);
                printWriter.print("mBreadCrumbShortTitleRes=#");
                printWriter.print(Integer.toHexString(this.f3005l));
                printWriter.print(" mBreadCrumbShortTitleText=");
                printWriter.println(this.f3006m);
            }
        }
        if (this.f2994a.isEmpty()) {
            return;
        }
        printWriter.print(str);
        printWriter.println("Operations:");
        int size = this.f2994a.size();
        for (int i10 = 0; i10 < size; i10++) {
            f0.a aVar = this.f2994a.get(i10);
            switch (aVar.f3011a) {
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
                    str2 = "cmd=" + aVar.f3011a;
                    break;
            }
            printWriter.print(str);
            printWriter.print("  Op #");
            printWriter.print(i10);
            printWriter.print(": ");
            printWriter.print(str2);
            printWriter.print(" ");
            printWriter.println(aVar.f3012b);
            if (z10) {
                if (aVar.f3014d != 0 || aVar.f3015e != 0) {
                    printWriter.print(str);
                    printWriter.print("enterAnim=#");
                    printWriter.print(Integer.toHexString(aVar.f3014d));
                    printWriter.print(" exitAnim=#");
                    printWriter.println(Integer.toHexString(aVar.f3015e));
                }
                if (aVar.f3016f != 0 || aVar.f3017g != 0) {
                    printWriter.print(str);
                    printWriter.print("popEnterAnim=#");
                    printWriter.print(Integer.toHexString(aVar.f3016f));
                    printWriter.print(" popExitAnim=#");
                    printWriter.println(Integer.toHexString(aVar.f3017g));
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Failed to find 'out' block for switch in B:7:0x002b. Please report as an issue. */
    public void x() {
        w wVar;
        int size = this.f2994a.size();
        for (int i10 = 0; i10 < size; i10++) {
            f0.a aVar = this.f2994a.get(i10);
            Fragment fragment = aVar.f3012b;
            if (fragment != null) {
                fragment.f2844s = this.f2892u;
                fragment.L1(false);
                fragment.K1(this.f2999f);
                fragment.N1(this.f3007n, this.f3008o);
            }
            switch (aVar.f3011a) {
                case 1:
                    fragment.H1(aVar.f3014d, aVar.f3015e, aVar.f3016f, aVar.f3017g);
                    this.f2889r.m1(fragment, false);
                    this.f2889r.j(fragment);
                case 2:
                default:
                    throw new IllegalArgumentException("Unknown cmd: " + aVar.f3011a);
                case 3:
                    fragment.H1(aVar.f3014d, aVar.f3015e, aVar.f3016f, aVar.f3017g);
                    this.f2889r.f1(fragment);
                case 4:
                    fragment.H1(aVar.f3014d, aVar.f3015e, aVar.f3016f, aVar.f3017g);
                    this.f2889r.E0(fragment);
                case 5:
                    fragment.H1(aVar.f3014d, aVar.f3015e, aVar.f3016f, aVar.f3017g);
                    this.f2889r.m1(fragment, false);
                    this.f2889r.q1(fragment);
                case 6:
                    fragment.H1(aVar.f3014d, aVar.f3015e, aVar.f3016f, aVar.f3017g);
                    this.f2889r.x(fragment);
                case 7:
                    fragment.H1(aVar.f3014d, aVar.f3015e, aVar.f3016f, aVar.f3017g);
                    this.f2889r.m1(fragment, false);
                    this.f2889r.n(fragment);
                case 8:
                    wVar = this.f2889r;
                    wVar.o1(fragment);
                case 9:
                    wVar = this.f2889r;
                    fragment = null;
                    wVar.o1(fragment);
                case 10:
                    this.f2889r.n1(fragment, aVar.f3019i);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Failed to find 'out' block for switch in B:7:0x002f. Please report as an issue. */
    public void y() {
        w wVar;
        for (int size = this.f2994a.size() - 1; size >= 0; size--) {
            f0.a aVar = this.f2994a.get(size);
            Fragment fragment = aVar.f3012b;
            if (fragment != null) {
                fragment.f2844s = this.f2892u;
                fragment.L1(true);
                fragment.K1(w.j1(this.f2999f));
                fragment.N1(this.f3008o, this.f3007n);
            }
            switch (aVar.f3011a) {
                case 1:
                    fragment.H1(aVar.f3014d, aVar.f3015e, aVar.f3016f, aVar.f3017g);
                    this.f2889r.m1(fragment, true);
                    this.f2889r.f1(fragment);
                case 2:
                default:
                    throw new IllegalArgumentException("Unknown cmd: " + aVar.f3011a);
                case 3:
                    fragment.H1(aVar.f3014d, aVar.f3015e, aVar.f3016f, aVar.f3017g);
                    this.f2889r.j(fragment);
                case 4:
                    fragment.H1(aVar.f3014d, aVar.f3015e, aVar.f3016f, aVar.f3017g);
                    this.f2889r.q1(fragment);
                case 5:
                    fragment.H1(aVar.f3014d, aVar.f3015e, aVar.f3016f, aVar.f3017g);
                    this.f2889r.m1(fragment, true);
                    this.f2889r.E0(fragment);
                case 6:
                    fragment.H1(aVar.f3014d, aVar.f3015e, aVar.f3016f, aVar.f3017g);
                    this.f2889r.n(fragment);
                case 7:
                    fragment.H1(aVar.f3014d, aVar.f3015e, aVar.f3016f, aVar.f3017g);
                    this.f2889r.m1(fragment, true);
                    this.f2889r.x(fragment);
                case 8:
                    wVar = this.f2889r;
                    fragment = null;
                    wVar.o1(fragment);
                case 9:
                    wVar = this.f2889r;
                    wVar.o1(fragment);
                case 10:
                    this.f2889r.n1(fragment, aVar.f3018h);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Fragment z(ArrayList<Fragment> arrayList, Fragment fragment) {
        Fragment fragment2 = fragment;
        int i10 = 0;
        while (i10 < this.f2994a.size()) {
            f0.a aVar = this.f2994a.get(i10);
            int i11 = aVar.f3011a;
            if (i11 != 1) {
                if (i11 == 2) {
                    Fragment fragment3 = aVar.f3012b;
                    int i12 = fragment3.D;
                    boolean z10 = false;
                    for (int size = arrayList.size() - 1; size >= 0; size--) {
                        Fragment fragment4 = arrayList.get(size);
                        if (fragment4.D == i12) {
                            if (fragment4 == fragment3) {
                                z10 = true;
                            } else {
                                if (fragment4 == fragment2) {
                                    this.f2994a.add(i10, new f0.a(9, fragment4, true));
                                    i10++;
                                    fragment2 = null;
                                }
                                f0.a aVar2 = new f0.a(3, fragment4, true);
                                aVar2.f3014d = aVar.f3014d;
                                aVar2.f3016f = aVar.f3016f;
                                aVar2.f3015e = aVar.f3015e;
                                aVar2.f3017g = aVar.f3017g;
                                this.f2994a.add(i10, aVar2);
                                arrayList.remove(fragment4);
                                i10++;
                            }
                        }
                    }
                    if (z10) {
                        this.f2994a.remove(i10);
                        i10--;
                    } else {
                        aVar.f3011a = 1;
                        aVar.f3013c = true;
                        arrayList.add(fragment3);
                    }
                } else if (i11 == 3 || i11 == 6) {
                    arrayList.remove(aVar.f3012b);
                    Fragment fragment5 = aVar.f3012b;
                    if (fragment5 == fragment2) {
                        this.f2994a.add(i10, new f0.a(9, fragment5));
                        i10++;
                        fragment2 = null;
                    }
                } else if (i11 != 7) {
                    if (i11 == 8) {
                        this.f2994a.add(i10, new f0.a(9, fragment2, true));
                        aVar.f3013c = true;
                        i10++;
                        fragment2 = aVar.f3012b;
                    }
                }
                i10++;
            }
            arrayList.add(aVar.f3012b);
            i10++;
        }
        return fragment2;
    }
}
