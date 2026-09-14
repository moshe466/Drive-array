package androidx.fragment.app;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.util.LogWriter;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentManagerImpl;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Lifecycle;
import java.io.PrintWriter;
import java.util.ArrayList;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class BackStackRecord extends FragmentTransaction implements FragmentManager.BackStackEntry, FragmentManagerImpl.OpGenerator {
    final FragmentManagerImpl s;
    boolean t;
    int u = -1;

    public BackStackRecord(FragmentManagerImpl fragmentManagerImpl) {
        this.s = fragmentManagerImpl;
    }

    private static boolean isFragmentPostponed(FragmentTransaction.Op op) {
        Fragment fragment = op.b;
        return (fragment == null || !fragment.k || fragment.G == null || fragment.A || fragment.z || !fragment.m()) ? false : true;
    }

    int a(boolean z) {
        if (this.t) {
            throw new IllegalStateException("commit already called");
        }
        if (FragmentManagerImpl.C) {
            Log.v("FragmentManager", "Commit: " + this);
            PrintWriter printWriter = new PrintWriter(new LogWriter("FragmentManager"));
            dump("  ", printWriter);
            printWriter.close();
        }
        this.t = true;
        this.u = this.h ? this.s.allocBackStackIndex(this) : -1;
        this.s.enqueueAction(this, z);
        return this.u;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Fragment a(ArrayList<Fragment> arrayList, Fragment fragment) {
        Fragment fragment2 = fragment;
        int i = 0;
        while (i < this.a.size()) {
            FragmentTransaction.Op op = this.a.get(i);
            int i2 = op.a;
            if (i2 != 1) {
                if (i2 == 2) {
                    Fragment fragment3 = op.b;
                    int i3 = fragment3.x;
                    Fragment fragment4 = fragment2;
                    int i4 = i;
                    boolean z = false;
                    for (int size = arrayList.size() - 1; size >= 0; size--) {
                        Fragment fragment5 = arrayList.get(size);
                        if (fragment5.x == i3) {
                            if (fragment5 == fragment3) {
                                z = true;
                            } else {
                                if (fragment5 == fragment4) {
                                    this.a.add(i4, new FragmentTransaction.Op(9, fragment5));
                                    i4++;
                                    fragment4 = null;
                                }
                                FragmentTransaction.Op op2 = new FragmentTransaction.Op(3, fragment5);
                                op2.c = op.c;
                                op2.e = op.e;
                                op2.d = op.d;
                                op2.f = op.f;
                                this.a.add(i4, op2);
                                arrayList.remove(fragment5);
                                i4++;
                            }
                        }
                    }
                    if (z) {
                        this.a.remove(i4);
                        i4--;
                    } else {
                        op.a = 1;
                        arrayList.add(fragment3);
                    }
                    i = i4;
                    fragment2 = fragment4;
                } else if (i2 == 3 || i2 == 6) {
                    arrayList.remove(op.b);
                    Fragment fragment6 = op.b;
                    if (fragment6 == fragment2) {
                        this.a.add(i, new FragmentTransaction.Op(9, fragment6));
                        i++;
                        fragment2 = null;
                    }
                } else if (i2 != 7) {
                    if (i2 == 8) {
                        this.a.add(i, new FragmentTransaction.Op(9, fragment2));
                        i++;
                        fragment2 = op.b;
                    }
                }
                i++;
            }
            arrayList.add(op.b);
            i++;
        }
        return fragment2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a() {
        int size = this.a.size();
        for (int i = 0; i < size; i++) {
            FragmentTransaction.Op op = this.a.get(i);
            Fragment fragment = op.b;
            if (fragment != null) {
                fragment.a(this.f, this.g);
            }
            switch (op.a) {
                case 1:
                    fragment.a(op.c);
                    this.s.addFragment(fragment, false);
                    break;
                case 2:
                default:
                    throw new IllegalArgumentException("Unknown cmd: " + op.a);
                case 3:
                    fragment.a(op.d);
                    this.s.removeFragment(fragment);
                    break;
                case 4:
                    fragment.a(op.d);
                    this.s.hideFragment(fragment);
                    break;
                case 5:
                    fragment.a(op.c);
                    this.s.showFragment(fragment);
                    break;
                case 6:
                    fragment.a(op.d);
                    this.s.detachFragment(fragment);
                    break;
                case 7:
                    fragment.a(op.c);
                    this.s.attachFragment(fragment);
                    break;
                case 8:
                    this.s.setPrimaryNavigationFragment(fragment);
                    break;
                case 9:
                    this.s.setPrimaryNavigationFragment(null);
                    break;
                case 10:
                    this.s.setMaxLifecycle(fragment, op.h);
                    break;
            }
            if (!this.q && op.a != 1 && fragment != null) {
                this.s.i(fragment);
            }
        }
        if (this.q) {
            return;
        }
        FragmentManagerImpl fragmentManagerImpl = this.s;
        fragmentManagerImpl.a(fragmentManagerImpl.l, true);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(int i) {
        if (this.h) {
            if (FragmentManagerImpl.C) {
                Log.v("FragmentManager", "Bump nesting in " + this + " by " + i);
            }
            int size = this.a.size();
            for (int i2 = 0; i2 < size; i2++) {
                FragmentTransaction.Op op = this.a.get(i2);
                Fragment fragment = op.b;
                if (fragment != null) {
                    fragment.q += i;
                    if (FragmentManagerImpl.C) {
                        Log.v("FragmentManager", "Bump nesting of " + op.b + " to " + op.b.q);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // androidx.fragment.app.FragmentTransaction
    public void a(int i, Fragment fragment, @Nullable String str, int i2) {
        super.a(i, fragment, str, i2);
        fragment.r = this.s;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(Fragment.OnStartEnterTransitionListener onStartEnterTransitionListener) {
        for (int i = 0; i < this.a.size(); i++) {
            FragmentTransaction.Op op = this.a.get(i);
            if (isFragmentPostponed(op)) {
                op.b.a(onStartEnterTransitionListener);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a(ArrayList<BackStackRecord> arrayList, int i, int i2) {
        if (i2 == i) {
            return false;
        }
        int size = this.a.size();
        int i3 = -1;
        for (int i4 = 0; i4 < size; i4++) {
            Fragment fragment = this.a.get(i4).b;
            int i5 = fragment != null ? fragment.x : 0;
            if (i5 != 0 && i5 != i3) {
                for (int i6 = i; i6 < i2; i6++) {
                    BackStackRecord backStackRecord = arrayList.get(i6);
                    int size2 = backStackRecord.a.size();
                    for (int i7 = 0; i7 < size2; i7++) {
                        Fragment fragment2 = backStackRecord.a.get(i7).b;
                        if ((fragment2 != null ? fragment2.x : 0) == i5) {
                            return true;
                        }
                    }
                }
                i3 = i5;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Fragment b(ArrayList<Fragment> arrayList, Fragment fragment) {
        for (int size = this.a.size() - 1; size >= 0; size--) {
            FragmentTransaction.Op op = this.a.get(size);
            int i = op.a;
            if (i != 1) {
                if (i != 3) {
                    switch (i) {
                        case 8:
                            fragment = null;
                            break;
                        case 9:
                            fragment = op.b;
                            break;
                        case 10:
                            op.h = op.g;
                            break;
                    }
                }
                arrayList.add(op.b);
            }
            arrayList.remove(op.b);
        }
        return fragment;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(boolean z) {
        for (int size = this.a.size() - 1; size >= 0; size--) {
            FragmentTransaction.Op op = this.a.get(size);
            Fragment fragment = op.b;
            if (fragment != null) {
                fragment.a(FragmentManagerImpl.reverseTransit(this.f), this.g);
            }
            switch (op.a) {
                case 1:
                    fragment.a(op.f);
                    this.s.removeFragment(fragment);
                    break;
                case 2:
                default:
                    throw new IllegalArgumentException("Unknown cmd: " + op.a);
                case 3:
                    fragment.a(op.e);
                    this.s.addFragment(fragment, false);
                    break;
                case 4:
                    fragment.a(op.e);
                    this.s.showFragment(fragment);
                    break;
                case 5:
                    fragment.a(op.f);
                    this.s.hideFragment(fragment);
                    break;
                case 6:
                    fragment.a(op.e);
                    this.s.attachFragment(fragment);
                    break;
                case 7:
                    fragment.a(op.f);
                    this.s.detachFragment(fragment);
                    break;
                case 8:
                    this.s.setPrimaryNavigationFragment(null);
                    break;
                case 9:
                    this.s.setPrimaryNavigationFragment(fragment);
                    break;
                case 10:
                    this.s.setMaxLifecycle(fragment, op.g);
                    break;
            }
            if (!this.q && op.a != 3 && fragment != null) {
                this.s.i(fragment);
            }
        }
        if (this.q || !z) {
            return;
        }
        FragmentManagerImpl fragmentManagerImpl = this.s;
        fragmentManagerImpl.a(fragmentManagerImpl.l, true);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean b() {
        for (int i = 0; i < this.a.size(); i++) {
            if (isFragmentPostponed(this.a.get(i))) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean b(int i) {
        int size = this.a.size();
        for (int i2 = 0; i2 < size; i2++) {
            Fragment fragment = this.a.get(i2).b;
            int i3 = fragment != null ? fragment.x : 0;
            if (i3 != 0 && i3 == i) {
                return true;
            }
        }
        return false;
    }

    @Override // androidx.fragment.app.FragmentTransaction
    public int commit() {
        return a(false);
    }

    @Override // androidx.fragment.app.FragmentTransaction
    public int commitAllowingStateLoss() {
        return a(true);
    }

    @Override // androidx.fragment.app.FragmentTransaction
    public void commitNow() {
        disallowAddToBackStack();
        this.s.execSingleAction(this, false);
    }

    @Override // androidx.fragment.app.FragmentTransaction
    public void commitNowAllowingStateLoss() {
        disallowAddToBackStack();
        this.s.execSingleAction(this, true);
    }

    @Override // androidx.fragment.app.FragmentTransaction
    @NonNull
    public FragmentTransaction detach(@NonNull Fragment fragment) {
        FragmentManagerImpl fragmentManagerImpl = fragment.r;
        if (fragmentManagerImpl == null || fragmentManagerImpl == this.s) {
            return super.detach(fragment);
        }
        throw new IllegalStateException("Cannot detach Fragment attached to a different FragmentManager. Fragment " + fragment.toString() + " is already attached to a FragmentManager.");
    }

    public void dump(String str, PrintWriter printWriter) {
        dump(str, printWriter, true);
    }

    public void dump(String str, PrintWriter printWriter, boolean z) {
        String str2;
        if (z) {
            printWriter.print(str);
            printWriter.print("mName=");
            printWriter.print(this.j);
            printWriter.print(" mIndex=");
            printWriter.print(this.u);
            printWriter.print(" mCommitted=");
            printWriter.println(this.t);
            if (this.f != 0) {
                printWriter.print(str);
                printWriter.print("mTransition=#");
                printWriter.print(Integer.toHexString(this.f));
                printWriter.print(" mTransitionStyle=#");
                printWriter.println(Integer.toHexString(this.g));
            }
            if (this.b != 0 || this.c != 0) {
                printWriter.print(str);
                printWriter.print("mEnterAnim=#");
                printWriter.print(Integer.toHexString(this.b));
                printWriter.print(" mExitAnim=#");
                printWriter.println(Integer.toHexString(this.c));
            }
            if (this.d != 0 || this.e != 0) {
                printWriter.print(str);
                printWriter.print("mPopEnterAnim=#");
                printWriter.print(Integer.toHexString(this.d));
                printWriter.print(" mPopExitAnim=#");
                printWriter.println(Integer.toHexString(this.e));
            }
            if (this.k != 0 || this.l != null) {
                printWriter.print(str);
                printWriter.print("mBreadCrumbTitleRes=#");
                printWriter.print(Integer.toHexString(this.k));
                printWriter.print(" mBreadCrumbTitleText=");
                printWriter.println(this.l);
            }
            if (this.m != 0 || this.n != null) {
                printWriter.print(str);
                printWriter.print("mBreadCrumbShortTitleRes=#");
                printWriter.print(Integer.toHexString(this.m));
                printWriter.print(" mBreadCrumbShortTitleText=");
                printWriter.println(this.n);
            }
        }
        if (this.a.isEmpty()) {
            return;
        }
        printWriter.print(str);
        printWriter.println("Operations:");
        int size = this.a.size();
        for (int i = 0; i < size; i++) {
            FragmentTransaction.Op op = this.a.get(i);
            switch (op.a) {
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
                    str2 = "cmd=" + op.a;
                    break;
            }
            printWriter.print(str);
            printWriter.print("  Op #");
            printWriter.print(i);
            printWriter.print(": ");
            printWriter.print(str2);
            printWriter.print(" ");
            printWriter.println(op.b);
            if (z) {
                if (op.c != 0 || op.d != 0) {
                    printWriter.print(str);
                    printWriter.print("enterAnim=#");
                    printWriter.print(Integer.toHexString(op.c));
                    printWriter.print(" exitAnim=#");
                    printWriter.println(Integer.toHexString(op.d));
                }
                if (op.e != 0 || op.f != 0) {
                    printWriter.print(str);
                    printWriter.print("popEnterAnim=#");
                    printWriter.print(Integer.toHexString(op.e));
                    printWriter.print(" popExitAnim=#");
                    printWriter.println(Integer.toHexString(op.f));
                }
            }
        }
    }

    @Override // androidx.fragment.app.FragmentManagerImpl.OpGenerator
    public boolean generateOps(ArrayList<BackStackRecord> arrayList, ArrayList<Boolean> arrayList2) {
        if (FragmentManagerImpl.C) {
            Log.v("FragmentManager", "Run: " + this);
        }
        arrayList.add(this);
        arrayList2.add(false);
        if (!this.h) {
            return true;
        }
        this.s.a(this);
        return true;
    }

    @Override // androidx.fragment.app.FragmentManager.BackStackEntry
    @Nullable
    public CharSequence getBreadCrumbShortTitle() {
        return this.m != 0 ? this.s.m.b().getText(this.m) : this.n;
    }

    @Override // androidx.fragment.app.FragmentManager.BackStackEntry
    public int getBreadCrumbShortTitleRes() {
        return this.m;
    }

    @Override // androidx.fragment.app.FragmentManager.BackStackEntry
    @Nullable
    public CharSequence getBreadCrumbTitle() {
        return this.k != 0 ? this.s.m.b().getText(this.k) : this.l;
    }

    @Override // androidx.fragment.app.FragmentManager.BackStackEntry
    public int getBreadCrumbTitleRes() {
        return this.k;
    }

    @Override // androidx.fragment.app.FragmentManager.BackStackEntry
    public int getId() {
        return this.u;
    }

    @Override // androidx.fragment.app.FragmentManager.BackStackEntry
    @Nullable
    public String getName() {
        return this.j;
    }

    @Override // androidx.fragment.app.FragmentTransaction
    @NonNull
    public FragmentTransaction hide(@NonNull Fragment fragment) {
        FragmentManagerImpl fragmentManagerImpl = fragment.r;
        if (fragmentManagerImpl == null || fragmentManagerImpl == this.s) {
            return super.hide(fragment);
        }
        throw new IllegalStateException("Cannot hide Fragment attached to a different FragmentManager. Fragment " + fragment.toString() + " is already attached to a FragmentManager.");
    }

    @Override // androidx.fragment.app.FragmentTransaction
    public boolean isEmpty() {
        return this.a.isEmpty();
    }

    @Override // androidx.fragment.app.FragmentTransaction
    @NonNull
    public FragmentTransaction remove(@NonNull Fragment fragment) {
        FragmentManagerImpl fragmentManagerImpl = fragment.r;
        if (fragmentManagerImpl == null || fragmentManagerImpl == this.s) {
            return super.remove(fragment);
        }
        throw new IllegalStateException("Cannot remove Fragment attached to a different FragmentManager. Fragment " + fragment.toString() + " is already attached to a FragmentManager.");
    }

    public void runOnCommitRunnables() {
        if (this.r != null) {
            for (int i = 0; i < this.r.size(); i++) {
                this.r.get(i).run();
            }
            this.r = null;
        }
    }

    @Override // androidx.fragment.app.FragmentTransaction
    @NonNull
    public FragmentTransaction setMaxLifecycle(@NonNull Fragment fragment, @NonNull Lifecycle.State state) {
        if (fragment.r != this.s) {
            throw new IllegalArgumentException("Cannot setMaxLifecycle for Fragment not attached to FragmentManager " + this.s);
        }
        if (state.isAtLeast(Lifecycle.State.CREATED)) {
            return super.setMaxLifecycle(fragment, state);
        }
        throw new IllegalArgumentException("Cannot set maximum Lifecycle below " + Lifecycle.State.CREATED);
    }

    @Override // androidx.fragment.app.FragmentTransaction
    @NonNull
    public FragmentTransaction setPrimaryNavigationFragment(@Nullable Fragment fragment) {
        FragmentManagerImpl fragmentManagerImpl;
        if (fragment == null || (fragmentManagerImpl = fragment.r) == null || fragmentManagerImpl == this.s) {
            return super.setPrimaryNavigationFragment(fragment);
        }
        throw new IllegalStateException("Cannot setPrimaryNavigation for Fragment attached to a different FragmentManager. Fragment " + fragment.toString() + " is already attached to a FragmentManager.");
    }

    @Override // androidx.fragment.app.FragmentTransaction
    @NonNull
    public FragmentTransaction show(@NonNull Fragment fragment) {
        FragmentManagerImpl fragmentManagerImpl = fragment.r;
        if (fragmentManagerImpl == null || fragmentManagerImpl == this.s) {
            return super.show(fragment);
        }
        throw new IllegalStateException("Cannot show Fragment attached to a different FragmentManager. Fragment " + fragment.toString() + " is already attached to a FragmentManager.");
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("BackStackEntry{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        if (this.u >= 0) {
            sb.append(" #");
            sb.append(this.u);
        }
        if (this.j != null) {
            sb.append(" ");
            sb.append(this.j);
        }
        sb.append("}");
        return sb.toString();
    }
}
