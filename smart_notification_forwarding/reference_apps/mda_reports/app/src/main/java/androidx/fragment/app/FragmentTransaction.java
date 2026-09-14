package androidx.fragment.app;

import android.view.View;
import androidx.annotation.AnimRes;
import androidx.annotation.AnimatorRes;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.annotation.StyleRes;
import androidx.core.view.ViewCompat;
import androidx.lifecycle.Lifecycle;
import java.lang.reflect.Modifier;
import java.util.ArrayList;

/* loaded from: classes.dex */
public abstract class FragmentTransaction {
    public static final int TRANSIT_ENTER_MASK = 4096;
    public static final int TRANSIT_EXIT_MASK = 8192;
    public static final int TRANSIT_FRAGMENT_CLOSE = 8194;
    public static final int TRANSIT_FRAGMENT_FADE = 4099;
    public static final int TRANSIT_FRAGMENT_OPEN = 4097;
    public static final int TRANSIT_NONE = 0;
    public static final int TRANSIT_UNSET = -1;
    int b;
    int c;
    int d;
    int e;
    int f;
    int g;
    boolean h;

    @Nullable
    String j;
    int k;
    CharSequence l;
    int m;
    CharSequence n;
    ArrayList<String> o;
    ArrayList<String> p;
    ArrayList<Runnable> r;
    ArrayList<Op> a = new ArrayList<>();
    boolean i = true;
    boolean q = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static final class Op {
        int a;
        Fragment b;
        int c;
        int d;
        int e;
        int f;
        Lifecycle.State g;
        Lifecycle.State h;

        /* JADX INFO: Access modifiers changed from: package-private */
        public Op() {
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public Op(int i, Fragment fragment) {
            this.a = i;
            this.b = fragment;
            Lifecycle.State state = Lifecycle.State.RESUMED;
            this.g = state;
            this.h = state;
        }

        Op(int i, @NonNull Fragment fragment, Lifecycle.State state) {
            this.a = i;
            this.b = fragment;
            this.g = fragment.R;
            this.h = state;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(int i, Fragment fragment, @Nullable String str, int i2) {
        Class<?> cls = fragment.getClass();
        int modifiers = cls.getModifiers();
        if (cls.isAnonymousClass() || !Modifier.isPublic(modifiers) || (cls.isMemberClass() && !Modifier.isStatic(modifiers))) {
            throw new IllegalStateException("Fragment " + cls.getCanonicalName() + " must be a public static class to be  properly recreated from instance state.");
        }
        if (str != null) {
            String str2 = fragment.y;
            if (str2 != null && !str.equals(str2)) {
                throw new IllegalStateException("Can't change tag of fragment " + fragment + ": was " + fragment.y + " now " + str);
            }
            fragment.y = str;
        }
        if (i != 0) {
            if (i == -1) {
                throw new IllegalArgumentException("Can't add fragment " + fragment + " with tag " + str + " to container view with no id");
            }
            int i3 = fragment.w;
            if (i3 != 0 && i3 != i) {
                throw new IllegalStateException("Can't change container ID of fragment " + fragment + ": was " + fragment.w + " now " + i);
            }
            fragment.w = i;
            fragment.x = i;
        }
        a(new Op(i2, fragment));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(Op op) {
        this.a.add(op);
        op.c = this.b;
        op.d = this.c;
        op.e = this.d;
        op.f = this.e;
    }

    @NonNull
    public FragmentTransaction add(@IdRes int i, @NonNull Fragment fragment) {
        a(i, fragment, null, 1);
        return this;
    }

    @NonNull
    public FragmentTransaction add(@IdRes int i, @NonNull Fragment fragment, @Nullable String str) {
        a(i, fragment, str, 1);
        return this;
    }

    @NonNull
    public FragmentTransaction add(@NonNull Fragment fragment, @Nullable String str) {
        a(0, fragment, str, 1);
        return this;
    }

    @NonNull
    public FragmentTransaction addSharedElement(@NonNull View view, @NonNull String str) {
        if (FragmentTransition.a()) {
            String transitionName = ViewCompat.getTransitionName(view);
            if (transitionName == null) {
                throw new IllegalArgumentException("Unique transitionNames are required for all sharedElements");
            }
            if (this.o == null) {
                this.o = new ArrayList<>();
                this.p = new ArrayList<>();
            } else {
                if (this.p.contains(str)) {
                    throw new IllegalArgumentException("A shared element with the target name '" + str + "' has already been added to the transaction.");
                }
                if (this.o.contains(transitionName)) {
                    throw new IllegalArgumentException("A shared element with the source name '" + transitionName + "' has already been added to the transaction.");
                }
            }
            this.o.add(transitionName);
            this.p.add(str);
        }
        return this;
    }

    @NonNull
    public FragmentTransaction addToBackStack(@Nullable String str) {
        if (!this.i) {
            throw new IllegalStateException("This FragmentTransaction is not allowed to be added to the back stack.");
        }
        this.h = true;
        this.j = str;
        return this;
    }

    @NonNull
    public FragmentTransaction attach(@NonNull Fragment fragment) {
        a(new Op(7, fragment));
        return this;
    }

    public abstract int commit();

    public abstract int commitAllowingStateLoss();

    public abstract void commitNow();

    public abstract void commitNowAllowingStateLoss();

    @NonNull
    public FragmentTransaction detach(@NonNull Fragment fragment) {
        a(new Op(6, fragment));
        return this;
    }

    @NonNull
    public FragmentTransaction disallowAddToBackStack() {
        if (this.h) {
            throw new IllegalStateException("This transaction is already being added to the back stack");
        }
        this.i = false;
        return this;
    }

    @NonNull
    public FragmentTransaction hide(@NonNull Fragment fragment) {
        a(new Op(4, fragment));
        return this;
    }

    public boolean isAddToBackStackAllowed() {
        return this.i;
    }

    public boolean isEmpty() {
        return this.a.isEmpty();
    }

    @NonNull
    public FragmentTransaction remove(@NonNull Fragment fragment) {
        a(new Op(3, fragment));
        return this;
    }

    @NonNull
    public FragmentTransaction replace(@IdRes int i, @NonNull Fragment fragment) {
        return replace(i, fragment, null);
    }

    @NonNull
    public FragmentTransaction replace(@IdRes int i, @NonNull Fragment fragment, @Nullable String str) {
        if (i == 0) {
            throw new IllegalArgumentException("Must use non-zero containerViewId");
        }
        a(i, fragment, str, 2);
        return this;
    }

    @NonNull
    public FragmentTransaction runOnCommit(@NonNull Runnable runnable) {
        disallowAddToBackStack();
        if (this.r == null) {
            this.r = new ArrayList<>();
        }
        this.r.add(runnable);
        return this;
    }

    @NonNull
    @Deprecated
    public FragmentTransaction setAllowOptimization(boolean z) {
        return setReorderingAllowed(z);
    }

    @NonNull
    public FragmentTransaction setBreadCrumbShortTitle(@StringRes int i) {
        this.m = i;
        this.n = null;
        return this;
    }

    @NonNull
    public FragmentTransaction setBreadCrumbShortTitle(@Nullable CharSequence charSequence) {
        this.m = 0;
        this.n = charSequence;
        return this;
    }

    @NonNull
    public FragmentTransaction setBreadCrumbTitle(@StringRes int i) {
        this.k = i;
        this.l = null;
        return this;
    }

    @NonNull
    public FragmentTransaction setBreadCrumbTitle(@Nullable CharSequence charSequence) {
        this.k = 0;
        this.l = charSequence;
        return this;
    }

    @NonNull
    public FragmentTransaction setCustomAnimations(@AnimRes @AnimatorRes int i, @AnimRes @AnimatorRes int i2) {
        return setCustomAnimations(i, i2, 0, 0);
    }

    @NonNull
    public FragmentTransaction setCustomAnimations(@AnimRes @AnimatorRes int i, @AnimRes @AnimatorRes int i2, @AnimRes @AnimatorRes int i3, @AnimRes @AnimatorRes int i4) {
        this.b = i;
        this.c = i2;
        this.d = i3;
        this.e = i4;
        return this;
    }

    @NonNull
    public FragmentTransaction setMaxLifecycle(@NonNull Fragment fragment, @NonNull Lifecycle.State state) {
        a(new Op(10, fragment, state));
        return this;
    }

    @NonNull
    public FragmentTransaction setPrimaryNavigationFragment(@Nullable Fragment fragment) {
        a(new Op(8, fragment));
        return this;
    }

    @NonNull
    public FragmentTransaction setReorderingAllowed(boolean z) {
        this.q = z;
        return this;
    }

    @NonNull
    public FragmentTransaction setTransition(int i) {
        this.f = i;
        return this;
    }

    @NonNull
    public FragmentTransaction setTransitionStyle(@StyleRes int i) {
        this.g = i;
        return this;
    }

    @NonNull
    public FragmentTransaction show(@NonNull Fragment fragment) {
        a(new Op(5, fragment));
        return this;
    }
}
