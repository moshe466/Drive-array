package androidx.fragment.app;

import android.R;
import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.os.Looper;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.ScaleAnimation;
import android.view.animation.Transformation;
import androidx.activity.OnBackPressedCallback;
import androidx.activity.OnBackPressedDispatcher;
import androidx.activity.OnBackPressedDispatcherOwner;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.ArraySet;
import androidx.core.util.DebugUtils;
import androidx.core.util.LogWriter;
import androidx.core.view.OneShotPreDrawListener;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class FragmentManagerImpl extends FragmentManager implements LayoutInflater.Factory2 {
    public static final int ANIM_STYLE_CLOSE_ENTER = 3;
    public static final int ANIM_STYLE_CLOSE_EXIT = 4;
    public static final int ANIM_STYLE_FADE_ENTER = 5;
    public static final int ANIM_STYLE_FADE_EXIT = 6;
    public static final int ANIM_STYLE_OPEN_ENTER = 1;
    public static final int ANIM_STYLE_OPEN_EXIT = 2;
    static boolean C = false;
    static final Interpolator D = new DecelerateInterpolator(2.5f);
    static final Interpolator E = new DecelerateInterpolator(1.5f);
    ArrayList<StartEnterTransitionListener> A;
    ArrayList<OpGenerator> b;
    boolean c;
    ArrayList<BackStackRecord> g;
    ArrayList<Fragment> h;
    ArrayList<BackStackRecord> i;
    ArrayList<Integer> j;
    ArrayList<FragmentManager.OnBackStackChangedListener> k;
    FragmentHostCallback m;
    private FragmentManagerViewModel mNonConfig;
    private OnBackPressedDispatcher mOnBackPressedDispatcher;
    FragmentContainer n;
    Fragment o;

    @Nullable
    Fragment p;
    boolean q;
    boolean r;
    boolean s;
    boolean t;
    boolean u;
    ArrayList<BackStackRecord> v;
    ArrayList<Boolean> w;
    ArrayList<Fragment> x;
    int d = 0;
    final ArrayList<Fragment> e = new ArrayList<>();
    final HashMap<String, Fragment> f = new HashMap<>();
    private final OnBackPressedCallback mOnBackPressedCallback = new OnBackPressedCallback(false) { // from class: androidx.fragment.app.FragmentManagerImpl.1
        @Override // androidx.activity.OnBackPressedCallback
        public void handleOnBackPressed() {
            FragmentManagerImpl.this.g();
        }
    };
    private final CopyOnWriteArrayList<FragmentLifecycleCallbacksHolder> mLifecycleCallbacks = new CopyOnWriteArrayList<>();
    int l = 0;
    Bundle y = null;
    SparseArray<Parcelable> z = null;
    Runnable B = new Runnable() { // from class: androidx.fragment.app.FragmentManagerImpl.2
        @Override // java.lang.Runnable
        public void run() {
            FragmentManagerImpl.this.execPendingActions();
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class AnimationOrAnimator {
        public final Animation animation;
        public final Animator animator;

        AnimationOrAnimator(Animator animator) {
            this.animation = null;
            this.animator = animator;
            if (animator == null) {
                throw new IllegalStateException("Animator cannot be null");
            }
        }

        AnimationOrAnimator(Animation animation) {
            this.animation = animation;
            this.animator = null;
            if (animation == null) {
                throw new IllegalStateException("Animation cannot be null");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class EndViewTransitionAnimation extends AnimationSet implements Runnable {
        private boolean mAnimating;
        private final View mChild;
        private boolean mEnded;
        private final ViewGroup mParent;
        private boolean mTransitionEnded;

        EndViewTransitionAnimation(@NonNull Animation animation, @NonNull ViewGroup viewGroup, @NonNull View view) {
            super(false);
            this.mAnimating = true;
            this.mParent = viewGroup;
            this.mChild = view;
            addAnimation(animation);
            this.mParent.post(this);
        }

        @Override // android.view.animation.AnimationSet, android.view.animation.Animation
        public boolean getTransformation(long j, Transformation transformation) {
            this.mAnimating = true;
            if (this.mEnded) {
                return !this.mTransitionEnded;
            }
            if (!super.getTransformation(j, transformation)) {
                this.mEnded = true;
                OneShotPreDrawListener.add(this.mParent, this);
            }
            return true;
        }

        @Override // android.view.animation.Animation
        public boolean getTransformation(long j, Transformation transformation, float f) {
            this.mAnimating = true;
            if (this.mEnded) {
                return !this.mTransitionEnded;
            }
            if (!super.getTransformation(j, transformation, f)) {
                this.mEnded = true;
                OneShotPreDrawListener.add(this.mParent, this);
            }
            return true;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.mEnded || !this.mAnimating) {
                this.mParent.endViewTransition(this.mChild);
                this.mTransitionEnded = true;
            } else {
                this.mAnimating = false;
                this.mParent.post(this);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class FragmentLifecycleCallbacksHolder {
        final FragmentManager.FragmentLifecycleCallbacks a;
        final boolean b;

        FragmentLifecycleCallbacksHolder(FragmentManager.FragmentLifecycleCallbacks fragmentLifecycleCallbacks, boolean z) {
            this.a = fragmentLifecycleCallbacks;
            this.b = z;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class FragmentTag {
        public static final int[] Fragment = {R.attr.name, R.attr.id, R.attr.tag};
        public static final int Fragment_id = 1;
        public static final int Fragment_name = 0;
        public static final int Fragment_tag = 2;

        private FragmentTag() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface OpGenerator {
        boolean generateOps(ArrayList<BackStackRecord> arrayList, ArrayList<Boolean> arrayList2);
    }

    /* loaded from: classes.dex */
    private class PopBackStackState implements OpGenerator {
        final String a;
        final int b;
        final int c;

        PopBackStackState(String str, int i, int i2) {
            this.a = str;
            this.b = i;
            this.c = i2;
        }

        @Override // androidx.fragment.app.FragmentManagerImpl.OpGenerator
        public boolean generateOps(ArrayList<BackStackRecord> arrayList, ArrayList<Boolean> arrayList2) {
            Fragment fragment = FragmentManagerImpl.this.p;
            if (fragment == null || this.b >= 0 || this.a != null || !fragment.getChildFragmentManager().popBackStackImmediate()) {
                return FragmentManagerImpl.this.a(arrayList, arrayList2, this.a, this.b, this.c);
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class StartEnterTransitionListener implements Fragment.OnStartEnterTransitionListener {
        final boolean a;
        final BackStackRecord b;
        private int mNumPostponed;

        StartEnterTransitionListener(BackStackRecord backStackRecord, boolean z) {
            this.a = z;
            this.b = backStackRecord;
        }

        public void cancelTransaction() {
            BackStackRecord backStackRecord = this.b;
            backStackRecord.s.a(backStackRecord, this.a, false, false);
        }

        public void completeTransaction() {
            boolean z = this.mNumPostponed > 0;
            FragmentManagerImpl fragmentManagerImpl = this.b.s;
            int size = fragmentManagerImpl.e.size();
            for (int i = 0; i < size; i++) {
                Fragment fragment = fragmentManagerImpl.e.get(i);
                fragment.a((Fragment.OnStartEnterTransitionListener) null);
                if (z && fragment.m()) {
                    fragment.startPostponedEnterTransition();
                }
            }
            BackStackRecord backStackRecord = this.b;
            backStackRecord.s.a(backStackRecord, this.a, !z, true);
        }

        public boolean isReady() {
            return this.mNumPostponed == 0;
        }

        @Override // androidx.fragment.app.Fragment.OnStartEnterTransitionListener
        public void onStartEnterTransition() {
            this.mNumPostponed--;
            if (this.mNumPostponed != 0) {
                return;
            }
            this.b.s.k();
        }

        @Override // androidx.fragment.app.Fragment.OnStartEnterTransitionListener
        public void startListening() {
            this.mNumPostponed++;
        }
    }

    static AnimationOrAnimator a(float f, float f2) {
        AlphaAnimation alphaAnimation = new AlphaAnimation(f, f2);
        alphaAnimation.setInterpolator(E);
        alphaAnimation.setDuration(220L);
        return new AnimationOrAnimator(alphaAnimation);
    }

    static AnimationOrAnimator a(float f, float f2, float f3, float f4) {
        AnimationSet animationSet = new AnimationSet(false);
        ScaleAnimation scaleAnimation = new ScaleAnimation(f, f2, f, f2, 1, 0.5f, 1, 0.5f);
        scaleAnimation.setInterpolator(D);
        scaleAnimation.setDuration(220L);
        animationSet.addAnimation(scaleAnimation);
        AlphaAnimation alphaAnimation = new AlphaAnimation(f3, f4);
        alphaAnimation.setInterpolator(E);
        alphaAnimation.setDuration(220L);
        animationSet.addAnimation(alphaAnimation);
        return new AnimationOrAnimator(animationSet);
    }

    private void addAddedFragments(ArraySet<Fragment> arraySet) {
        int i = this.l;
        if (i < 1) {
            return;
        }
        int min = Math.min(i, 3);
        int size = this.e.size();
        for (int i2 = 0; i2 < size; i2++) {
            Fragment fragment = this.e.get(i2);
            if (fragment.b < min) {
                a(fragment, min, fragment.f(), fragment.g(), false);
                if (fragment.G != null && !fragment.z && fragment.M) {
                    arraySet.add(fragment);
                }
            }
        }
    }

    private void animateRemoveFragment(@NonNull final Fragment fragment, @NonNull AnimationOrAnimator animationOrAnimator, int i) {
        final View view = fragment.G;
        final ViewGroup viewGroup = fragment.F;
        viewGroup.startViewTransition(view);
        fragment.b(i);
        Animation animation = animationOrAnimator.animation;
        if (animation != null) {
            EndViewTransitionAnimation endViewTransitionAnimation = new EndViewTransitionAnimation(animation, viewGroup, view);
            fragment.a(fragment.G);
            endViewTransitionAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: androidx.fragment.app.FragmentManagerImpl.3
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation2) {
                    viewGroup.post(new Runnable() { // from class: androidx.fragment.app.FragmentManagerImpl.3.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (fragment.b() != null) {
                                fragment.a((View) null);
                                AnonymousClass3 anonymousClass3 = AnonymousClass3.this;
                                FragmentManagerImpl fragmentManagerImpl = FragmentManagerImpl.this;
                                Fragment fragment2 = fragment;
                                fragmentManagerImpl.a(fragment2, fragment2.i(), 0, 0, false);
                            }
                        }
                    });
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation2) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation2) {
                }
            });
            fragment.G.startAnimation(endViewTransitionAnimation);
            return;
        }
        Animator animator = animationOrAnimator.animator;
        fragment.a(animator);
        animator.addListener(new AnimatorListenerAdapter() { // from class: androidx.fragment.app.FragmentManagerImpl.4
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator2) {
                viewGroup.endViewTransition(view);
                Animator c = fragment.c();
                fragment.a((Animator) null);
                if (c == null || viewGroup.indexOfChild(view) >= 0) {
                    return;
                }
                FragmentManagerImpl fragmentManagerImpl = FragmentManagerImpl.this;
                Fragment fragment2 = fragment;
                fragmentManagerImpl.a(fragment2, fragment2.i(), 0, 0, false);
            }
        });
        animator.setTarget(fragment.G);
        animator.start();
    }

    private void burpActive() {
        this.f.values().removeAll(Collections.singleton(null));
    }

    private void checkStateLoss() {
        if (isStateSaved()) {
            throw new IllegalStateException("Can not perform this action after onSaveInstanceState");
        }
    }

    private void cleanupExec() {
        this.c = false;
        this.w.clear();
        this.v.clear();
    }

    private void dispatchParentPrimaryNavigationFragmentChanged(@Nullable Fragment fragment) {
        if (fragment == null || this.f.get(fragment.f) != fragment) {
            return;
        }
        fragment.u();
    }

    private void dispatchStateChange(int i) {
        try {
            this.c = true;
            a(i, false);
            this.c = false;
            execPendingActions();
        } catch (Throwable th) {
            this.c = false;
            throw th;
        }
    }

    private void endAnimatingAwayFragments() {
        for (Fragment fragment : this.f.values()) {
            if (fragment != null) {
                if (fragment.b() != null) {
                    int i = fragment.i();
                    View b = fragment.b();
                    Animation animation = b.getAnimation();
                    if (animation != null) {
                        animation.cancel();
                        b.clearAnimation();
                    }
                    fragment.a((View) null);
                    a(fragment, i, 0, 0, false);
                } else if (fragment.c() != null) {
                    fragment.c().end();
                }
            }
        }
    }

    private void ensureExecReady(boolean z) {
        if (this.c) {
            throw new IllegalStateException("FragmentManager is already executing transactions");
        }
        if (this.m == null) {
            throw new IllegalStateException("Fragment host has been destroyed");
        }
        if (Looper.myLooper() != this.m.c().getLooper()) {
            throw new IllegalStateException("Must be called from main thread of fragment host");
        }
        if (!z) {
            checkStateLoss();
        }
        if (this.v == null) {
            this.v = new ArrayList<>();
            this.w = new ArrayList<>();
        }
        this.c = true;
        try {
            executePostponedTransaction(null, null);
        } finally {
            this.c = false;
        }
    }

    private static void executeOps(ArrayList<BackStackRecord> arrayList, ArrayList<Boolean> arrayList2, int i, int i2) {
        while (i < i2) {
            BackStackRecord backStackRecord = arrayList.get(i);
            if (arrayList2.get(i).booleanValue()) {
                backStackRecord.a(-1);
                backStackRecord.b(i == i2 + (-1));
            } else {
                backStackRecord.a(1);
                backStackRecord.a();
            }
            i++;
        }
    }

    private void executeOpsTogether(ArrayList<BackStackRecord> arrayList, ArrayList<Boolean> arrayList2, int i, int i2) {
        int i3;
        int i4;
        int i5 = i;
        boolean z = arrayList.get(i5).q;
        ArrayList<Fragment> arrayList3 = this.x;
        if (arrayList3 == null) {
            this.x = new ArrayList<>();
        } else {
            arrayList3.clear();
        }
        this.x.addAll(this.e);
        Fragment primaryNavigationFragment = getPrimaryNavigationFragment();
        boolean z2 = false;
        for (int i6 = i5; i6 < i2; i6++) {
            BackStackRecord backStackRecord = arrayList.get(i6);
            primaryNavigationFragment = !arrayList2.get(i6).booleanValue() ? backStackRecord.a(this.x, primaryNavigationFragment) : backStackRecord.b(this.x, primaryNavigationFragment);
            z2 = z2 || backStackRecord.h;
        }
        this.x.clear();
        if (!z) {
            FragmentTransition.a(this, arrayList, arrayList2, i, i2, false);
        }
        executeOps(arrayList, arrayList2, i, i2);
        if (z) {
            ArraySet<Fragment> arraySet = new ArraySet<>();
            addAddedFragments(arraySet);
            int postponePostponableTransactions = postponePostponableTransactions(arrayList, arrayList2, i, i2, arraySet);
            makeRemovedFragmentsInvisible(arraySet);
            i3 = postponePostponableTransactions;
        } else {
            i3 = i2;
        }
        if (i3 != i5 && z) {
            FragmentTransition.a(this, arrayList, arrayList2, i, i3, true);
            a(this.l, true);
        }
        while (i5 < i2) {
            BackStackRecord backStackRecord2 = arrayList.get(i5);
            if (arrayList2.get(i5).booleanValue() && (i4 = backStackRecord2.u) >= 0) {
                freeBackStackIndex(i4);
                backStackRecord2.u = -1;
            }
            backStackRecord2.runOnCommitRunnables();
            i5++;
        }
        if (z2) {
            h();
        }
    }

    private void executePostponedTransaction(ArrayList<BackStackRecord> arrayList, ArrayList<Boolean> arrayList2) {
        int indexOf;
        int indexOf2;
        ArrayList<StartEnterTransitionListener> arrayList3 = this.A;
        int size = arrayList3 == null ? 0 : arrayList3.size();
        int i = 0;
        while (i < size) {
            StartEnterTransitionListener startEnterTransitionListener = this.A.get(i);
            if (arrayList == null || startEnterTransitionListener.a || (indexOf2 = arrayList.indexOf(startEnterTransitionListener.b)) == -1 || !arrayList2.get(indexOf2).booleanValue()) {
                if (startEnterTransitionListener.isReady() || (arrayList != null && startEnterTransitionListener.b.a(arrayList, 0, arrayList.size()))) {
                    this.A.remove(i);
                    i--;
                    size--;
                    if (arrayList == null || startEnterTransitionListener.a || (indexOf = arrayList.indexOf(startEnterTransitionListener.b)) == -1 || !arrayList2.get(indexOf).booleanValue()) {
                        startEnterTransitionListener.completeTransaction();
                    }
                }
                i++;
            } else {
                this.A.remove(i);
                i--;
                size--;
            }
            startEnterTransitionListener.cancelTransaction();
            i++;
        }
    }

    private Fragment findFragmentUnder(Fragment fragment) {
        ViewGroup viewGroup = fragment.F;
        View view = fragment.G;
        if (viewGroup != null && view != null) {
            for (int indexOf = this.e.indexOf(fragment) - 1; indexOf >= 0; indexOf--) {
                Fragment fragment2 = this.e.get(indexOf);
                if (fragment2.F == viewGroup && fragment2.G != null) {
                    return fragment2;
                }
            }
        }
        return null;
    }

    private void forcePostponedTransactions() {
        if (this.A != null) {
            while (!this.A.isEmpty()) {
                this.A.remove(0).completeTransaction();
            }
        }
    }

    private boolean generateOpsForPendingActions(ArrayList<BackStackRecord> arrayList, ArrayList<Boolean> arrayList2) {
        synchronized (this) {
            if (this.b != null && this.b.size() != 0) {
                int size = this.b.size();
                boolean z = false;
                for (int i = 0; i < size; i++) {
                    z |= this.b.get(i).generateOps(arrayList, arrayList2);
                }
                this.b.clear();
                this.m.c().removeCallbacks(this.B);
                return z;
            }
            return false;
        }
    }

    private boolean isMenuAvailable(Fragment fragment) {
        return (fragment.D && fragment.E) || fragment.t.a();
    }

    private void makeRemovedFragmentsInvisible(ArraySet<Fragment> arraySet) {
        int size = arraySet.size();
        for (int i = 0; i < size; i++) {
            Fragment valueAt = arraySet.valueAt(i);
            if (!valueAt.k) {
                View requireView = valueAt.requireView();
                valueAt.O = requireView.getAlpha();
                requireView.setAlpha(0.0f);
            }
        }
    }

    private boolean popBackStackImmediate(String str, int i, int i2) {
        execPendingActions();
        ensureExecReady(true);
        Fragment fragment = this.p;
        if (fragment != null && i < 0 && str == null && fragment.getChildFragmentManager().popBackStackImmediate()) {
            return true;
        }
        boolean a = a(this.v, this.w, str, i, i2);
        if (a) {
            this.c = true;
            try {
                removeRedundantOperationsAndExecute(this.v, this.w);
            } finally {
                cleanupExec();
            }
        }
        updateOnBackPressedCallbackEnabled();
        c();
        burpActive();
        return a;
    }

    private int postponePostponableTransactions(ArrayList<BackStackRecord> arrayList, ArrayList<Boolean> arrayList2, int i, int i2, ArraySet<Fragment> arraySet) {
        int i3 = i2;
        for (int i4 = i2 - 1; i4 >= i; i4--) {
            BackStackRecord backStackRecord = arrayList.get(i4);
            boolean booleanValue = arrayList2.get(i4).booleanValue();
            if (backStackRecord.b() && !backStackRecord.a(arrayList, i4 + 1, i2)) {
                if (this.A == null) {
                    this.A = new ArrayList<>();
                }
                StartEnterTransitionListener startEnterTransitionListener = new StartEnterTransitionListener(backStackRecord, booleanValue);
                this.A.add(startEnterTransitionListener);
                backStackRecord.a(startEnterTransitionListener);
                if (booleanValue) {
                    backStackRecord.a();
                } else {
                    backStackRecord.b(false);
                }
                i3--;
                if (i4 != i3) {
                    arrayList.remove(i4);
                    arrayList.add(i3, backStackRecord);
                }
                addAddedFragments(arraySet);
            }
        }
        return i3;
    }

    private void removeRedundantOperationsAndExecute(ArrayList<BackStackRecord> arrayList, ArrayList<Boolean> arrayList2) {
        if (arrayList == null || arrayList.isEmpty()) {
            return;
        }
        if (arrayList2 == null || arrayList.size() != arrayList2.size()) {
            throw new IllegalStateException("Internal error with the back stack records");
        }
        executePostponedTransaction(arrayList, arrayList2);
        int size = arrayList.size();
        int i = 0;
        int i2 = 0;
        while (i < size) {
            if (!arrayList.get(i).q) {
                if (i2 != i) {
                    executeOpsTogether(arrayList, arrayList2, i2, i);
                }
                i2 = i + 1;
                if (arrayList2.get(i).booleanValue()) {
                    while (i2 < size && arrayList2.get(i2).booleanValue() && !arrayList.get(i2).q) {
                        i2++;
                    }
                }
                executeOpsTogether(arrayList, arrayList2, i, i2);
                i = i2 - 1;
            }
            i++;
        }
        if (i2 != size) {
            executeOpsTogether(arrayList, arrayList2, i2, size);
        }
    }

    public static int reverseTransit(int i) {
        if (i == 4097) {
            return 8194;
        }
        if (i == 4099) {
            return FragmentTransaction.TRANSIT_FRAGMENT_FADE;
        }
        if (i != 8194) {
            return 0;
        }
        return FragmentTransaction.TRANSIT_FRAGMENT_OPEN;
    }

    private void throwException(RuntimeException runtimeException) {
        Log.e("FragmentManager", runtimeException.getMessage());
        Log.e("FragmentManager", "Activity state:");
        PrintWriter printWriter = new PrintWriter(new LogWriter("FragmentManager"));
        FragmentHostCallback fragmentHostCallback = this.m;
        try {
            if (fragmentHostCallback != null) {
                fragmentHostCallback.onDump("  ", null, printWriter, new String[0]);
            } else {
                dump("  ", null, printWriter, new String[0]);
            }
            throw runtimeException;
        } catch (Exception e) {
            Log.e("FragmentManager", "Failed dumping state", e);
            throw runtimeException;
        }
    }

    public static int transitToStyleIndex(int i, boolean z) {
        if (i == 4097) {
            return z ? 1 : 2;
        }
        if (i == 4099) {
            return z ? 5 : 6;
        }
        if (i != 8194) {
            return -1;
        }
        return z ? 3 : 4;
    }

    private void updateOnBackPressedCallbackEnabled() {
        ArrayList<OpGenerator> arrayList = this.b;
        if (arrayList == null || arrayList.isEmpty()) {
            this.mOnBackPressedCallback.setEnabled(getBackStackEntryCount() > 0 && f(this.o));
        } else {
            this.mOnBackPressedCallback.setEnabled(true);
        }
    }

    AnimationOrAnimator a(Fragment fragment, int i, boolean z, int i2) {
        int transitToStyleIndex;
        int f = fragment.f();
        boolean z2 = false;
        fragment.a(0);
        ViewGroup viewGroup = fragment.F;
        if (viewGroup != null && viewGroup.getLayoutTransition() != null) {
            return null;
        }
        Animation onCreateAnimation = fragment.onCreateAnimation(i, z, f);
        if (onCreateAnimation != null) {
            return new AnimationOrAnimator(onCreateAnimation);
        }
        Animator onCreateAnimator = fragment.onCreateAnimator(i, z, f);
        if (onCreateAnimator != null) {
            return new AnimationOrAnimator(onCreateAnimator);
        }
        if (f != 0) {
            boolean equals = "anim".equals(this.m.b().getResources().getResourceTypeName(f));
            if (equals) {
                try {
                    Animation loadAnimation = AnimationUtils.loadAnimation(this.m.b(), f);
                    if (loadAnimation != null) {
                        return new AnimationOrAnimator(loadAnimation);
                    }
                    z2 = true;
                } catch (Resources.NotFoundException e) {
                    throw e;
                } catch (RuntimeException unused) {
                }
            }
            if (!z2) {
                try {
                    Animator loadAnimator = AnimatorInflater.loadAnimator(this.m.b(), f);
                    if (loadAnimator != null) {
                        return new AnimationOrAnimator(loadAnimator);
                    }
                } catch (RuntimeException e2) {
                    if (equals) {
                        throw e2;
                    }
                    Animation loadAnimation2 = AnimationUtils.loadAnimation(this.m.b(), f);
                    if (loadAnimation2 != null) {
                        return new AnimationOrAnimator(loadAnimation2);
                    }
                }
            }
        }
        if (i == 0 || (transitToStyleIndex = transitToStyleIndex(i, z)) < 0) {
            return null;
        }
        switch (transitToStyleIndex) {
            case 1:
                return a(1.125f, 1.0f, 0.0f, 1.0f);
            case 2:
                return a(1.0f, 0.975f, 1.0f, 0.0f);
            case 3:
                return a(0.975f, 1.0f, 0.0f, 1.0f);
            case 4:
                return a(1.0f, 1.075f, 1.0f, 0.0f);
            case 5:
                return a(0.0f, 1.0f);
            case 6:
                return a(1.0f, 0.0f);
            default:
                if (i2 == 0 && this.m.onHasWindowAnimations()) {
                    this.m.onGetWindowAnimations();
                }
                return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(int i, boolean z) {
        FragmentHostCallback fragmentHostCallback;
        if (this.m == null && i != 0) {
            throw new IllegalStateException("No activity");
        }
        if (z || i != this.l) {
            this.l = i;
            int size = this.e.size();
            for (int i2 = 0; i2 < size; i2++) {
                i(this.e.get(i2));
            }
            for (Fragment fragment : this.f.values()) {
                if (fragment != null && (fragment.l || fragment.A)) {
                    if (!fragment.M) {
                        i(fragment);
                    }
                }
            }
            l();
            if (this.q && (fragmentHostCallback = this.m) != null && this.l == 4) {
                fragmentHostCallback.onSupportInvalidateOptionsMenu();
                this.q = false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(Parcelable parcelable) {
        FragmentState fragmentState;
        if (parcelable == null) {
            return;
        }
        FragmentManagerState fragmentManagerState = (FragmentManagerState) parcelable;
        if (fragmentManagerState.a == null) {
            return;
        }
        for (Fragment fragment : this.mNonConfig.c()) {
            if (C) {
                Log.v("FragmentManager", "restoreSaveState: re-attaching retained " + fragment);
            }
            Iterator<FragmentState> it = fragmentManagerState.a.iterator();
            while (true) {
                if (it.hasNext()) {
                    fragmentState = it.next();
                    if (fragmentState.b.equals(fragment.f)) {
                        break;
                    }
                } else {
                    fragmentState = null;
                    break;
                }
            }
            if (fragmentState == null) {
                if (C) {
                    Log.v("FragmentManager", "Discarding retained Fragment " + fragment + " that was not found in the set of active Fragments " + fragmentManagerState.a);
                }
                a(fragment, 1, 0, 0, false);
                fragment.l = true;
                a(fragment, 0, 0, 0, false);
            } else {
                fragmentState.n = fragment;
                fragment.d = null;
                fragment.q = 0;
                fragment.n = false;
                fragment.k = false;
                Fragment fragment2 = fragment.h;
                fragment.i = fragment2 != null ? fragment2.f : null;
                fragment.h = null;
                Bundle bundle = fragmentState.m;
                if (bundle != null) {
                    bundle.setClassLoader(this.m.b().getClassLoader());
                    fragment.d = fragmentState.m.getSparseParcelableArray("android:view_state");
                    fragment.c = fragmentState.m;
                }
            }
        }
        this.f.clear();
        Iterator<FragmentState> it2 = fragmentManagerState.a.iterator();
        while (it2.hasNext()) {
            FragmentState next = it2.next();
            if (next != null) {
                Fragment instantiate = next.instantiate(this.m.b().getClassLoader(), getFragmentFactory());
                instantiate.r = this;
                if (C) {
                    Log.v("FragmentManager", "restoreSaveState: active (" + instantiate.f + "): " + instantiate);
                }
                this.f.put(instantiate.f, instantiate);
                next.n = null;
            }
        }
        this.e.clear();
        ArrayList<String> arrayList = fragmentManagerState.b;
        if (arrayList != null) {
            Iterator<String> it3 = arrayList.iterator();
            while (it3.hasNext()) {
                String next2 = it3.next();
                Fragment fragment3 = this.f.get(next2);
                if (fragment3 == null) {
                    throwException(new IllegalStateException("No instantiated fragment for (" + next2 + ")"));
                }
                fragment3.k = true;
                if (C) {
                    Log.v("FragmentManager", "restoreSaveState: added (" + next2 + "): " + fragment3);
                }
                if (this.e.contains(fragment3)) {
                    throw new IllegalStateException("Already added " + fragment3);
                }
                synchronized (this.e) {
                    this.e.add(fragment3);
                }
            }
        }
        BackStackState[] backStackStateArr = fragmentManagerState.c;
        if (backStackStateArr != null) {
            this.g = new ArrayList<>(backStackStateArr.length);
            int i = 0;
            while (true) {
                BackStackState[] backStackStateArr2 = fragmentManagerState.c;
                if (i >= backStackStateArr2.length) {
                    break;
                }
                BackStackRecord instantiate2 = backStackStateArr2[i].instantiate(this);
                if (C) {
                    Log.v("FragmentManager", "restoreAllState: back stack #" + i + " (index " + instantiate2.u + "): " + instantiate2);
                    PrintWriter printWriter = new PrintWriter(new LogWriter("FragmentManager"));
                    instantiate2.dump("  ", printWriter, false);
                    printWriter.close();
                }
                this.g.add(instantiate2);
                int i2 = instantiate2.u;
                if (i2 >= 0) {
                    setBackStackIndex(i2, instantiate2);
                }
                i++;
            }
        } else {
            this.g = null;
        }
        String str = fragmentManagerState.d;
        if (str != null) {
            this.p = this.f.get(str);
            dispatchParentPrimaryNavigationFragmentChanged(this.p);
        }
        this.d = fragmentManagerState.e;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(Parcelable parcelable, FragmentManagerNonConfig fragmentManagerNonConfig) {
        if (this.m instanceof ViewModelStoreOwner) {
            throwException(new IllegalStateException("You must use restoreSaveState when your FragmentHostCallback implements ViewModelStoreOwner"));
        }
        this.mNonConfig.a(fragmentManagerNonConfig);
        a(parcelable);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(BackStackRecord backStackRecord) {
        if (this.g == null) {
            this.g = new ArrayList<>();
        }
        this.g.add(backStackRecord);
    }

    void a(BackStackRecord backStackRecord, boolean z, boolean z2, boolean z3) {
        if (z) {
            backStackRecord.b(z3);
        } else {
            backStackRecord.a();
        }
        ArrayList arrayList = new ArrayList(1);
        ArrayList arrayList2 = new ArrayList(1);
        arrayList.add(backStackRecord);
        arrayList2.add(Boolean.valueOf(z));
        if (z2) {
            FragmentTransition.a(this, arrayList, arrayList2, 0, 1, true);
        }
        if (z3) {
            a(this.l, true);
        }
        for (Fragment fragment : this.f.values()) {
            if (fragment != null && fragment.G != null && fragment.M && backStackRecord.b(fragment.x)) {
                float f = fragment.O;
                if (f > 0.0f) {
                    fragment.G.setAlpha(f);
                }
                if (z3) {
                    fragment.O = 0.0f;
                } else {
                    fragment.O = -1.0f;
                    fragment.M = false;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(@NonNull Fragment fragment) {
        if (isStateSaved()) {
            if (C) {
                Log.v("FragmentManager", "Ignoring addRetainedFragment as the state is already saved");
            }
        } else if (this.mNonConfig.a(fragment) && C) {
            Log.v("FragmentManager", "Updating retained Fragments: Added " + fragment);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x0084, code lost:
    
        if (r0 != 3) goto L265;
     */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0301  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x04db  */
    /* JADX WARN: Removed duplicated region for block: B:52:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:55:0x02df  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void a(androidx.fragment.app.Fragment r19, int r20, int r21, int r22, boolean r23) {
        /*
            Method dump skipped, instructions count: 1284
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.app.FragmentManagerImpl.a(androidx.fragment.app.Fragment, int, int, int, boolean):void");
    }

    void a(@NonNull Fragment fragment, @NonNull Context context, boolean z) {
        Fragment fragment2 = this.o;
        if (fragment2 != null) {
            FragmentManager fragmentManager = fragment2.getFragmentManager();
            if (fragmentManager instanceof FragmentManagerImpl) {
                ((FragmentManagerImpl) fragmentManager).a(fragment, context, true);
            }
        }
        Iterator<FragmentLifecycleCallbacksHolder> it = this.mLifecycleCallbacks.iterator();
        while (it.hasNext()) {
            FragmentLifecycleCallbacksHolder next = it.next();
            if (!z || next.b) {
                next.a.onFragmentAttached(this, fragment, context);
            }
        }
    }

    void a(@NonNull Fragment fragment, @Nullable Bundle bundle, boolean z) {
        Fragment fragment2 = this.o;
        if (fragment2 != null) {
            FragmentManager fragmentManager = fragment2.getFragmentManager();
            if (fragmentManager instanceof FragmentManagerImpl) {
                ((FragmentManagerImpl) fragmentManager).a(fragment, bundle, true);
            }
        }
        Iterator<FragmentLifecycleCallbacksHolder> it = this.mLifecycleCallbacks.iterator();
        while (it.hasNext()) {
            FragmentLifecycleCallbacksHolder next = it.next();
            if (!z || next.b) {
                next.a.onFragmentActivityCreated(this, fragment, bundle);
            }
        }
    }

    void a(@NonNull Fragment fragment, @NonNull View view, @Nullable Bundle bundle, boolean z) {
        Fragment fragment2 = this.o;
        if (fragment2 != null) {
            FragmentManager fragmentManager = fragment2.getFragmentManager();
            if (fragmentManager instanceof FragmentManagerImpl) {
                ((FragmentManagerImpl) fragmentManager).a(fragment, view, bundle, true);
            }
        }
        Iterator<FragmentLifecycleCallbacksHolder> it = this.mLifecycleCallbacks.iterator();
        while (it.hasNext()) {
            FragmentLifecycleCallbacksHolder next = it.next();
            if (!z || next.b) {
                next.a.onFragmentViewCreated(this, fragment, view, bundle);
            }
        }
    }

    void a(@NonNull Fragment fragment, boolean z) {
        Fragment fragment2 = this.o;
        if (fragment2 != null) {
            FragmentManager fragmentManager = fragment2.getFragmentManager();
            if (fragmentManager instanceof FragmentManagerImpl) {
                ((FragmentManagerImpl) fragmentManager).a(fragment, true);
            }
        }
        Iterator<FragmentLifecycleCallbacksHolder> it = this.mLifecycleCallbacks.iterator();
        while (it.hasNext()) {
            FragmentLifecycleCallbacksHolder next = it.next();
            if (!z || next.b) {
                next.a.onFragmentDestroyed(this, fragment);
            }
        }
    }

    boolean a() {
        boolean z = false;
        for (Fragment fragment : this.f.values()) {
            if (fragment != null) {
                z = isMenuAvailable(fragment);
            }
            if (z) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a(int i) {
        return this.l >= i;
    }

    boolean a(ArrayList<BackStackRecord> arrayList, ArrayList<Boolean> arrayList2, String str, int i, int i2) {
        int size;
        ArrayList<BackStackRecord> arrayList3 = this.g;
        if (arrayList3 == null) {
            return false;
        }
        if (str == null && i < 0 && (i2 & 1) == 0) {
            int size2 = arrayList3.size() - 1;
            if (size2 < 0) {
                return false;
            }
            arrayList.add(this.g.remove(size2));
            arrayList2.add(true);
        } else {
            if (str != null || i >= 0) {
                size = this.g.size() - 1;
                while (size >= 0) {
                    BackStackRecord backStackRecord = this.g.get(size);
                    if ((str != null && str.equals(backStackRecord.getName())) || (i >= 0 && i == backStackRecord.u)) {
                        break;
                    }
                    size--;
                }
                if (size < 0) {
                    return false;
                }
                if ((i2 & 1) != 0) {
                    while (true) {
                        size--;
                        if (size < 0) {
                            break;
                        }
                        BackStackRecord backStackRecord2 = this.g.get(size);
                        if (str == null || !str.equals(backStackRecord2.getName())) {
                            if (i < 0 || i != backStackRecord2.u) {
                                break;
                            }
                        }
                    }
                }
            } else {
                size = -1;
            }
            if (size == this.g.size() - 1) {
                return false;
            }
            for (int size3 = this.g.size() - 1; size3 > size; size3--) {
                arrayList.add(this.g.remove(size3));
                arrayList2.add(true);
            }
        }
        return true;
    }

    public void addFragment(Fragment fragment, boolean z) {
        if (C) {
            Log.v("FragmentManager", "add: " + fragment);
        }
        g(fragment);
        if (fragment.A) {
            return;
        }
        if (this.e.contains(fragment)) {
            throw new IllegalStateException("Fragment already added: " + fragment);
        }
        synchronized (this.e) {
            this.e.add(fragment);
        }
        fragment.k = true;
        fragment.l = false;
        if (fragment.G == null) {
            fragment.N = false;
        }
        if (isMenuAvailable(fragment)) {
            this.q = true;
        }
        if (z) {
            j(fragment);
        }
    }

    @Override // androidx.fragment.app.FragmentManager
    public void addOnBackStackChangedListener(FragmentManager.OnBackStackChangedListener onBackStackChangedListener) {
        if (this.k == null) {
            this.k = new ArrayList<>();
        }
        this.k.add(onBackStackChangedListener);
    }

    public int allocBackStackIndex(BackStackRecord backStackRecord) {
        synchronized (this) {
            if (this.j != null && this.j.size() > 0) {
                int intValue = this.j.remove(this.j.size() - 1).intValue();
                if (C) {
                    Log.v("FragmentManager", "Adding back stack index " + intValue + " with " + backStackRecord);
                }
                this.i.set(intValue, backStackRecord);
                return intValue;
            }
            if (this.i == null) {
                this.i = new ArrayList<>();
            }
            int size = this.i.size();
            if (C) {
                Log.v("FragmentManager", "Setting back stack index " + size + " to " + backStackRecord);
            }
            this.i.add(backStackRecord);
            return size;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void attachController(@NonNull FragmentHostCallback fragmentHostCallback, @NonNull FragmentContainer fragmentContainer, @Nullable Fragment fragment) {
        if (this.m != null) {
            throw new IllegalStateException("Already attached");
        }
        this.m = fragmentHostCallback;
        this.n = fragmentContainer;
        this.o = fragment;
        if (this.o != null) {
            updateOnBackPressedCallbackEnabled();
        }
        if (fragmentHostCallback instanceof OnBackPressedDispatcherOwner) {
            OnBackPressedDispatcherOwner onBackPressedDispatcherOwner = (OnBackPressedDispatcherOwner) fragmentHostCallback;
            this.mOnBackPressedDispatcher = onBackPressedDispatcherOwner.getOnBackPressedDispatcher();
            Fragment fragment2 = onBackPressedDispatcherOwner;
            if (fragment != null) {
                fragment2 = fragment;
            }
            this.mOnBackPressedDispatcher.addCallback(fragment2, this.mOnBackPressedCallback);
        }
        this.mNonConfig = fragment != null ? fragment.r.d(fragment) : fragmentHostCallback instanceof ViewModelStoreOwner ? FragmentManagerViewModel.a(((ViewModelStoreOwner) fragmentHostCallback).getViewModelStore()) : new FragmentManagerViewModel(false);
    }

    public void attachFragment(Fragment fragment) {
        if (C) {
            Log.v("FragmentManager", "attach: " + fragment);
        }
        if (fragment.A) {
            fragment.A = false;
            if (fragment.k) {
                return;
            }
            if (this.e.contains(fragment)) {
                throw new IllegalStateException("Fragment already added: " + fragment);
            }
            if (C) {
                Log.v("FragmentManager", "add from attach: " + fragment);
            }
            synchronized (this.e) {
                this.e.add(fragment);
            }
            fragment.k = true;
            if (isMenuAvailable(fragment)) {
                this.q = true;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b() {
        updateOnBackPressedCallbackEnabled();
        dispatchParentPrimaryNavigationFragmentChanged(this.p);
    }

    void b(final Fragment fragment) {
        Animator animator;
        if (fragment.G != null) {
            AnimationOrAnimator a = a(fragment, fragment.g(), !fragment.z, fragment.h());
            if (a == null || (animator = a.animator) == null) {
                if (a != null) {
                    fragment.G.startAnimation(a.animation);
                    a.animation.start();
                }
                fragment.G.setVisibility((!fragment.z || fragment.k()) ? 0 : 8);
                if (fragment.k()) {
                    fragment.c(false);
                }
            } else {
                animator.setTarget(fragment.G);
                if (!fragment.z) {
                    fragment.G.setVisibility(0);
                } else if (fragment.k()) {
                    fragment.c(false);
                } else {
                    final ViewGroup viewGroup = fragment.F;
                    final View view = fragment.G;
                    viewGroup.startViewTransition(view);
                    a.animator.addListener(new AnimatorListenerAdapter(this) { // from class: androidx.fragment.app.FragmentManagerImpl.5
                        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                        public void onAnimationEnd(Animator animator2) {
                            viewGroup.endViewTransition(view);
                            animator2.removeListener(this);
                            Fragment fragment2 = fragment;
                            View view2 = fragment2.G;
                            if (view2 == null || !fragment2.z) {
                                return;
                            }
                            view2.setVisibility(8);
                        }
                    });
                }
                a.animator.start();
            }
        }
        if (fragment.k && isMenuAvailable(fragment)) {
            this.q = true;
        }
        fragment.N = false;
        fragment.onHiddenChanged(fragment.z);
    }

    void b(@NonNull Fragment fragment, @NonNull Context context, boolean z) {
        Fragment fragment2 = this.o;
        if (fragment2 != null) {
            FragmentManager fragmentManager = fragment2.getFragmentManager();
            if (fragmentManager instanceof FragmentManagerImpl) {
                ((FragmentManagerImpl) fragmentManager).b(fragment, context, true);
            }
        }
        Iterator<FragmentLifecycleCallbacksHolder> it = this.mLifecycleCallbacks.iterator();
        while (it.hasNext()) {
            FragmentLifecycleCallbacksHolder next = it.next();
            if (!z || next.b) {
                next.a.onFragmentPreAttached(this, fragment, context);
            }
        }
    }

    void b(@NonNull Fragment fragment, @Nullable Bundle bundle, boolean z) {
        Fragment fragment2 = this.o;
        if (fragment2 != null) {
            FragmentManager fragmentManager = fragment2.getFragmentManager();
            if (fragmentManager instanceof FragmentManagerImpl) {
                ((FragmentManagerImpl) fragmentManager).b(fragment, bundle, true);
            }
        }
        Iterator<FragmentLifecycleCallbacksHolder> it = this.mLifecycleCallbacks.iterator();
        while (it.hasNext()) {
            FragmentLifecycleCallbacksHolder next = it.next();
            if (!z || next.b) {
                next.a.onFragmentCreated(this, fragment, bundle);
            }
        }
    }

    void b(@NonNull Fragment fragment, boolean z) {
        Fragment fragment2 = this.o;
        if (fragment2 != null) {
            FragmentManager fragmentManager = fragment2.getFragmentManager();
            if (fragmentManager instanceof FragmentManagerImpl) {
                ((FragmentManagerImpl) fragmentManager).b(fragment, true);
            }
        }
        Iterator<FragmentLifecycleCallbacksHolder> it = this.mLifecycleCallbacks.iterator();
        while (it.hasNext()) {
            FragmentLifecycleCallbacksHolder next = it.next();
            if (!z || next.b) {
                next.a.onFragmentDetached(this, fragment);
            }
        }
    }

    @Override // androidx.fragment.app.FragmentManager
    @NonNull
    public FragmentTransaction beginTransaction() {
        return new BackStackRecord(this);
    }

    void c() {
        if (this.u) {
            this.u = false;
            l();
        }
    }

    void c(Fragment fragment) {
        if (!fragment.m || fragment.p) {
            return;
        }
        fragment.a(fragment.c(fragment.c), null, fragment.c);
        View view = fragment.G;
        if (view == null) {
            fragment.H = null;
            return;
        }
        fragment.H = view;
        view.setSaveFromParentEnabled(false);
        if (fragment.z) {
            fragment.G.setVisibility(8);
        }
        fragment.onViewCreated(fragment.G, fragment.c);
        a(fragment, fragment.G, fragment.c, false);
    }

    void c(@NonNull Fragment fragment, @Nullable Bundle bundle, boolean z) {
        Fragment fragment2 = this.o;
        if (fragment2 != null) {
            FragmentManager fragmentManager = fragment2.getFragmentManager();
            if (fragmentManager instanceof FragmentManagerImpl) {
                ((FragmentManagerImpl) fragmentManager).c(fragment, bundle, true);
            }
        }
        Iterator<FragmentLifecycleCallbacksHolder> it = this.mLifecycleCallbacks.iterator();
        while (it.hasNext()) {
            FragmentLifecycleCallbacksHolder next = it.next();
            if (!z || next.b) {
                next.a.onFragmentPreCreated(this, fragment, bundle);
            }
        }
    }

    void c(@NonNull Fragment fragment, boolean z) {
        Fragment fragment2 = this.o;
        if (fragment2 != null) {
            FragmentManager fragmentManager = fragment2.getFragmentManager();
            if (fragmentManager instanceof FragmentManagerImpl) {
                ((FragmentManagerImpl) fragmentManager).c(fragment, true);
            }
        }
        Iterator<FragmentLifecycleCallbacksHolder> it = this.mLifecycleCallbacks.iterator();
        while (it.hasNext()) {
            FragmentLifecycleCallbacksHolder next = it.next();
            if (!z || next.b) {
                next.a.onFragmentPaused(this, fragment);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int d() {
        return this.f.size();
    }

    @NonNull
    FragmentManagerViewModel d(@NonNull Fragment fragment) {
        return this.mNonConfig.c(fragment);
    }

    void d(@NonNull Fragment fragment, @NonNull Bundle bundle, boolean z) {
        Fragment fragment2 = this.o;
        if (fragment2 != null) {
            FragmentManager fragmentManager = fragment2.getFragmentManager();
            if (fragmentManager instanceof FragmentManagerImpl) {
                ((FragmentManagerImpl) fragmentManager).d(fragment, bundle, true);
            }
        }
        Iterator<FragmentLifecycleCallbacksHolder> it = this.mLifecycleCallbacks.iterator();
        while (it.hasNext()) {
            FragmentLifecycleCallbacksHolder next = it.next();
            if (!z || next.b) {
                next.a.onFragmentSaveInstanceState(this, fragment, bundle);
            }
        }
    }

    void d(@NonNull Fragment fragment, boolean z) {
        Fragment fragment2 = this.o;
        if (fragment2 != null) {
            FragmentManager fragmentManager = fragment2.getFragmentManager();
            if (fragmentManager instanceof FragmentManagerImpl) {
                ((FragmentManagerImpl) fragmentManager).d(fragment, true);
            }
        }
        Iterator<FragmentLifecycleCallbacksHolder> it = this.mLifecycleCallbacks.iterator();
        while (it.hasNext()) {
            FragmentLifecycleCallbacksHolder next = it.next();
            if (!z || next.b) {
                next.a.onFragmentResumed(this, fragment);
            }
        }
    }

    public void detachFragment(Fragment fragment) {
        if (C) {
            Log.v("FragmentManager", "detach: " + fragment);
        }
        if (fragment.A) {
            return;
        }
        fragment.A = true;
        if (fragment.k) {
            if (C) {
                Log.v("FragmentManager", "remove from detach: " + fragment);
            }
            synchronized (this.e) {
                this.e.remove(fragment);
            }
            if (isMenuAvailable(fragment)) {
                this.q = true;
            }
            fragment.k = false;
        }
    }

    public void dispatchActivityCreated() {
        this.r = false;
        this.s = false;
        dispatchStateChange(2);
    }

    public void dispatchConfigurationChanged(@NonNull Configuration configuration) {
        for (int i = 0; i < this.e.size(); i++) {
            Fragment fragment = this.e.get(i);
            if (fragment != null) {
                fragment.a(configuration);
            }
        }
    }

    public boolean dispatchContextItemSelected(@NonNull MenuItem menuItem) {
        if (this.l < 1) {
            return false;
        }
        for (int i = 0; i < this.e.size(); i++) {
            Fragment fragment = this.e.get(i);
            if (fragment != null && fragment.a(menuItem)) {
                return true;
            }
        }
        return false;
    }

    public void dispatchCreate() {
        this.r = false;
        this.s = false;
        dispatchStateChange(1);
    }

    public boolean dispatchCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater menuInflater) {
        if (this.l < 1) {
            return false;
        }
        ArrayList<Fragment> arrayList = null;
        boolean z = false;
        for (int i = 0; i < this.e.size(); i++) {
            Fragment fragment = this.e.get(i);
            if (fragment != null && fragment.a(menu, menuInflater)) {
                if (arrayList == null) {
                    arrayList = new ArrayList<>();
                }
                arrayList.add(fragment);
                z = true;
            }
        }
        if (this.h != null) {
            for (int i2 = 0; i2 < this.h.size(); i2++) {
                Fragment fragment2 = this.h.get(i2);
                if (arrayList == null || !arrayList.contains(fragment2)) {
                    fragment2.onDestroyOptionsMenu();
                }
            }
        }
        this.h = arrayList;
        return z;
    }

    public void dispatchDestroy() {
        this.t = true;
        execPendingActions();
        dispatchStateChange(0);
        this.m = null;
        this.n = null;
        this.o = null;
        if (this.mOnBackPressedDispatcher != null) {
            this.mOnBackPressedCallback.remove();
            this.mOnBackPressedDispatcher = null;
        }
    }

    public void dispatchDestroyView() {
        dispatchStateChange(1);
    }

    public void dispatchLowMemory() {
        for (int i = 0; i < this.e.size(); i++) {
            Fragment fragment = this.e.get(i);
            if (fragment != null) {
                fragment.s();
            }
        }
    }

    public void dispatchMultiWindowModeChanged(boolean z) {
        for (int size = this.e.size() - 1; size >= 0; size--) {
            Fragment fragment = this.e.get(size);
            if (fragment != null) {
                fragment.a(z);
            }
        }
    }

    public boolean dispatchOptionsItemSelected(@NonNull MenuItem menuItem) {
        if (this.l < 1) {
            return false;
        }
        for (int i = 0; i < this.e.size(); i++) {
            Fragment fragment = this.e.get(i);
            if (fragment != null && fragment.b(menuItem)) {
                return true;
            }
        }
        return false;
    }

    public void dispatchOptionsMenuClosed(@NonNull Menu menu) {
        if (this.l < 1) {
            return;
        }
        for (int i = 0; i < this.e.size(); i++) {
            Fragment fragment = this.e.get(i);
            if (fragment != null) {
                fragment.a(menu);
            }
        }
    }

    public void dispatchPause() {
        dispatchStateChange(3);
    }

    public void dispatchPictureInPictureModeChanged(boolean z) {
        for (int size = this.e.size() - 1; size >= 0; size--) {
            Fragment fragment = this.e.get(size);
            if (fragment != null) {
                fragment.b(z);
            }
        }
    }

    public boolean dispatchPrepareOptionsMenu(@NonNull Menu menu) {
        if (this.l < 1) {
            return false;
        }
        boolean z = false;
        for (int i = 0; i < this.e.size(); i++) {
            Fragment fragment = this.e.get(i);
            if (fragment != null && fragment.b(menu)) {
                z = true;
            }
        }
        return z;
    }

    public void dispatchResume() {
        this.r = false;
        this.s = false;
        dispatchStateChange(4);
    }

    public void dispatchStart() {
        this.r = false;
        this.s = false;
        dispatchStateChange(3);
    }

    public void dispatchStop() {
        this.s = true;
        dispatchStateChange(2);
    }

    @Override // androidx.fragment.app.FragmentManager
    public void dump(@NonNull String str, @Nullable FileDescriptor fileDescriptor, @NonNull PrintWriter printWriter, @Nullable String[] strArr) {
        int size;
        int size2;
        int size3;
        int size4;
        String str2 = str + "    ";
        if (!this.f.isEmpty()) {
            printWriter.print(str);
            printWriter.print("Active Fragments in ");
            printWriter.print(Integer.toHexString(System.identityHashCode(this)));
            printWriter.println(":");
            for (Fragment fragment : this.f.values()) {
                printWriter.print(str);
                printWriter.println(fragment);
                if (fragment != null) {
                    fragment.dump(str2, fileDescriptor, printWriter, strArr);
                }
            }
        }
        int size5 = this.e.size();
        if (size5 > 0) {
            printWriter.print(str);
            printWriter.println("Added Fragments:");
            for (int i = 0; i < size5; i++) {
                Fragment fragment2 = this.e.get(i);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i);
                printWriter.print(": ");
                printWriter.println(fragment2.toString());
            }
        }
        ArrayList<Fragment> arrayList = this.h;
        if (arrayList != null && (size4 = arrayList.size()) > 0) {
            printWriter.print(str);
            printWriter.println("Fragments Created Menus:");
            for (int i2 = 0; i2 < size4; i2++) {
                Fragment fragment3 = this.h.get(i2);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i2);
                printWriter.print(": ");
                printWriter.println(fragment3.toString());
            }
        }
        ArrayList<BackStackRecord> arrayList2 = this.g;
        if (arrayList2 != null && (size3 = arrayList2.size()) > 0) {
            printWriter.print(str);
            printWriter.println("Back Stack:");
            for (int i3 = 0; i3 < size3; i3++) {
                BackStackRecord backStackRecord = this.g.get(i3);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i3);
                printWriter.print(": ");
                printWriter.println(backStackRecord.toString());
                backStackRecord.dump(str2, printWriter);
            }
        }
        synchronized (this) {
            if (this.i != null && (size2 = this.i.size()) > 0) {
                printWriter.print(str);
                printWriter.println("Back Stack Indices:");
                for (int i4 = 0; i4 < size2; i4++) {
                    Object obj = (BackStackRecord) this.i.get(i4);
                    printWriter.print(str);
                    printWriter.print("  #");
                    printWriter.print(i4);
                    printWriter.print(": ");
                    printWriter.println(obj);
                }
            }
            if (this.j != null && this.j.size() > 0) {
                printWriter.print(str);
                printWriter.print("mAvailBackStackIndices: ");
                printWriter.println(Arrays.toString(this.j.toArray()));
            }
        }
        ArrayList<OpGenerator> arrayList3 = this.b;
        if (arrayList3 != null && (size = arrayList3.size()) > 0) {
            printWriter.print(str);
            printWriter.println("Pending Actions:");
            for (int i5 = 0; i5 < size; i5++) {
                Object obj2 = (OpGenerator) this.b.get(i5);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i5);
                printWriter.print(": ");
                printWriter.println(obj2);
            }
        }
        printWriter.print(str);
        printWriter.println("FragmentManager misc state:");
        printWriter.print(str);
        printWriter.print("  mHost=");
        printWriter.println(this.m);
        printWriter.print(str);
        printWriter.print("  mContainer=");
        printWriter.println(this.n);
        if (this.o != null) {
            printWriter.print(str);
            printWriter.print("  mParent=");
            printWriter.println(this.o);
        }
        printWriter.print(str);
        printWriter.print("  mCurState=");
        printWriter.print(this.l);
        printWriter.print(" mStateSaved=");
        printWriter.print(this.r);
        printWriter.print(" mStopped=");
        printWriter.print(this.s);
        printWriter.print(" mDestroyed=");
        printWriter.println(this.t);
        if (this.q) {
            printWriter.print(str);
            printWriter.print("  mNeedMenuInvalidate=");
            printWriter.println(this.q);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NonNull
    public ViewModelStore e(@NonNull Fragment fragment) {
        return this.mNonConfig.d(fragment);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NonNull
    public List<Fragment> e() {
        return new ArrayList(this.f.values());
    }

    void e(@NonNull Fragment fragment, boolean z) {
        Fragment fragment2 = this.o;
        if (fragment2 != null) {
            FragmentManager fragmentManager = fragment2.getFragmentManager();
            if (fragmentManager instanceof FragmentManagerImpl) {
                ((FragmentManagerImpl) fragmentManager).e(fragment, true);
            }
        }
        Iterator<FragmentLifecycleCallbacksHolder> it = this.mLifecycleCallbacks.iterator();
        while (it.hasNext()) {
            FragmentLifecycleCallbacksHolder next = it.next();
            if (!z || next.b) {
                next.a.onFragmentStarted(this, fragment);
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0027, code lost:
    
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void enqueueAction(androidx.fragment.app.FragmentManagerImpl.OpGenerator r2, boolean r3) {
        /*
            r1 = this;
            if (r3 != 0) goto L5
            r1.checkStateLoss()
        L5:
            monitor-enter(r1)
            boolean r0 = r1.t     // Catch: java.lang.Throwable -> L30
            if (r0 != 0) goto L24
            androidx.fragment.app.FragmentHostCallback r0 = r1.m     // Catch: java.lang.Throwable -> L30
            if (r0 != 0) goto Lf
            goto L24
        Lf:
            java.util.ArrayList<androidx.fragment.app.FragmentManagerImpl$OpGenerator> r3 = r1.b     // Catch: java.lang.Throwable -> L30
            if (r3 != 0) goto L1a
            java.util.ArrayList r3 = new java.util.ArrayList     // Catch: java.lang.Throwable -> L30
            r3.<init>()     // Catch: java.lang.Throwable -> L30
            r1.b = r3     // Catch: java.lang.Throwable -> L30
        L1a:
            java.util.ArrayList<androidx.fragment.app.FragmentManagerImpl$OpGenerator> r3 = r1.b     // Catch: java.lang.Throwable -> L30
            r3.add(r2)     // Catch: java.lang.Throwable -> L30
            r1.k()     // Catch: java.lang.Throwable -> L30
            monitor-exit(r1)     // Catch: java.lang.Throwable -> L30
            return
        L24:
            if (r3 == 0) goto L28
            monitor-exit(r1)     // Catch: java.lang.Throwable -> L30
            return
        L28:
            java.lang.IllegalStateException r2 = new java.lang.IllegalStateException     // Catch: java.lang.Throwable -> L30
            java.lang.String r3 = "Activity has been destroyed"
            r2.<init>(r3)     // Catch: java.lang.Throwable -> L30
            throw r2     // Catch: java.lang.Throwable -> L30
        L30:
            r2 = move-exception
            monitor-exit(r1)     // Catch: java.lang.Throwable -> L30
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.app.FragmentManagerImpl.enqueueAction(androidx.fragment.app.FragmentManagerImpl$OpGenerator, boolean):void");
    }

    public boolean execPendingActions() {
        ensureExecReady(true);
        boolean z = false;
        while (generateOpsForPendingActions(this.v, this.w)) {
            this.c = true;
            try {
                removeRedundantOperationsAndExecute(this.v, this.w);
                cleanupExec();
                z = true;
            } catch (Throwable th) {
                cleanupExec();
                throw th;
            }
        }
        updateOnBackPressedCallbackEnabled();
        c();
        burpActive();
        return z;
    }

    public void execSingleAction(OpGenerator opGenerator, boolean z) {
        if (z && (this.m == null || this.t)) {
            return;
        }
        ensureExecReady(z);
        if (opGenerator.generateOps(this.v, this.w)) {
            this.c = true;
            try {
                removeRedundantOperationsAndExecute(this.v, this.w);
            } finally {
                cleanupExec();
            }
        }
        updateOnBackPressedCallbackEnabled();
        c();
        burpActive();
    }

    @Override // androidx.fragment.app.FragmentManager
    public boolean executePendingTransactions() {
        boolean execPendingActions = execPendingActions();
        forcePostponedTransactions();
        return execPendingActions;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public LayoutInflater.Factory2 f() {
        return this;
    }

    void f(@NonNull Fragment fragment, boolean z) {
        Fragment fragment2 = this.o;
        if (fragment2 != null) {
            FragmentManager fragmentManager = fragment2.getFragmentManager();
            if (fragmentManager instanceof FragmentManagerImpl) {
                ((FragmentManagerImpl) fragmentManager).f(fragment, true);
            }
        }
        Iterator<FragmentLifecycleCallbacksHolder> it = this.mLifecycleCallbacks.iterator();
        while (it.hasNext()) {
            FragmentLifecycleCallbacksHolder next = it.next();
            if (!z || next.b) {
                next.a.onFragmentStopped(this, fragment);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean f(@Nullable Fragment fragment) {
        if (fragment == null) {
            return true;
        }
        FragmentManagerImpl fragmentManagerImpl = fragment.r;
        return fragment == fragmentManagerImpl.getPrimaryNavigationFragment() && f(fragmentManagerImpl.o);
    }

    @Override // androidx.fragment.app.FragmentManager
    @Nullable
    public Fragment findFragmentById(int i) {
        for (int size = this.e.size() - 1; size >= 0; size--) {
            Fragment fragment = this.e.get(size);
            if (fragment != null && fragment.w == i) {
                return fragment;
            }
        }
        for (Fragment fragment2 : this.f.values()) {
            if (fragment2 != null && fragment2.w == i) {
                return fragment2;
            }
        }
        return null;
    }

    @Override // androidx.fragment.app.FragmentManager
    @Nullable
    public Fragment findFragmentByTag(@Nullable String str) {
        if (str != null) {
            for (int size = this.e.size() - 1; size >= 0; size--) {
                Fragment fragment = this.e.get(size);
                if (fragment != null && str.equals(fragment.y)) {
                    return fragment;
                }
            }
        }
        if (str == null) {
            return null;
        }
        for (Fragment fragment2 : this.f.values()) {
            if (fragment2 != null && str.equals(fragment2.y)) {
                return fragment2;
            }
        }
        return null;
    }

    public Fragment findFragmentByWho(@NonNull String str) {
        Fragment a;
        for (Fragment fragment : this.f.values()) {
            if (fragment != null && (a = fragment.a(str)) != null) {
                return a;
            }
        }
        return null;
    }

    public void freeBackStackIndex(int i) {
        synchronized (this) {
            this.i.set(i, null);
            if (this.j == null) {
                this.j = new ArrayList<>();
            }
            if (C) {
                Log.v("FragmentManager", "Freeing back stack index " + i);
            }
            this.j.add(Integer.valueOf(i));
        }
    }

    void g() {
        execPendingActions();
        if (this.mOnBackPressedCallback.isEnabled()) {
            popBackStackImmediate();
        } else {
            this.mOnBackPressedDispatcher.onBackPressed();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void g(Fragment fragment) {
        if (this.f.get(fragment.f) != null) {
            return;
        }
        this.f.put(fragment.f, fragment);
        if (fragment.C) {
            if (fragment.B) {
                a(fragment);
            } else {
                k(fragment);
            }
            fragment.C = false;
        }
        if (C) {
            Log.v("FragmentManager", "Added fragment to active set " + fragment);
        }
    }

    void g(@NonNull Fragment fragment, boolean z) {
        Fragment fragment2 = this.o;
        if (fragment2 != null) {
            FragmentManager fragmentManager = fragment2.getFragmentManager();
            if (fragmentManager instanceof FragmentManagerImpl) {
                ((FragmentManagerImpl) fragmentManager).g(fragment, true);
            }
        }
        Iterator<FragmentLifecycleCallbacksHolder> it = this.mLifecycleCallbacks.iterator();
        while (it.hasNext()) {
            FragmentLifecycleCallbacksHolder next = it.next();
            if (!z || next.b) {
                next.a.onFragmentViewDestroyed(this, fragment);
            }
        }
    }

    @Override // androidx.fragment.app.FragmentManager
    public FragmentManager.BackStackEntry getBackStackEntryAt(int i) {
        return this.g.get(i);
    }

    @Override // androidx.fragment.app.FragmentManager
    public int getBackStackEntryCount() {
        ArrayList<BackStackRecord> arrayList = this.g;
        if (arrayList != null) {
            return arrayList.size();
        }
        return 0;
    }

    @Override // androidx.fragment.app.FragmentManager
    @Nullable
    public Fragment getFragment(Bundle bundle, String str) {
        String string = bundle.getString(str);
        if (string == null) {
            return null;
        }
        Fragment fragment = this.f.get(string);
        if (fragment == null) {
            throwException(new IllegalStateException("Fragment no longer exists for key " + str + ": unique id " + string));
        }
        return fragment;
    }

    @Override // androidx.fragment.app.FragmentManager
    @NonNull
    public FragmentFactory getFragmentFactory() {
        if (super.getFragmentFactory() == FragmentManager.a) {
            Fragment fragment = this.o;
            if (fragment != null) {
                return fragment.r.getFragmentFactory();
            }
            setFragmentFactory(new FragmentFactory() { // from class: androidx.fragment.app.FragmentManagerImpl.6
                @Override // androidx.fragment.app.FragmentFactory
                @NonNull
                public Fragment instantiate(@NonNull ClassLoader classLoader, @NonNull String str) {
                    FragmentHostCallback fragmentHostCallback = FragmentManagerImpl.this.m;
                    return fragmentHostCallback.instantiate(fragmentHostCallback.b(), str, null);
                }
            });
        }
        return super.getFragmentFactory();
    }

    @Override // androidx.fragment.app.FragmentManager
    public List<Fragment> getFragments() {
        List<Fragment> list;
        if (this.e.isEmpty()) {
            return Collections.emptyList();
        }
        synchronized (this.e) {
            list = (List) this.e.clone();
        }
        return list;
    }

    @Override // androidx.fragment.app.FragmentManager
    @Nullable
    public Fragment getPrimaryNavigationFragment() {
        return this.p;
    }

    void h() {
        if (this.k != null) {
            for (int i = 0; i < this.k.size(); i++) {
                this.k.get(i).onBackStackChanged();
            }
        }
    }

    void h(Fragment fragment) {
        if (this.f.get(fragment.f) == null) {
            return;
        }
        if (C) {
            Log.v("FragmentManager", "Removed fragment from active set " + fragment);
        }
        for (Fragment fragment2 : this.f.values()) {
            if (fragment2 != null && fragment.f.equals(fragment2.i)) {
                fragment2.h = fragment;
                fragment2.i = null;
            }
        }
        this.f.put(fragment.f, null);
        k(fragment);
        String str = fragment.i;
        if (str != null) {
            fragment.h = this.f.get(str);
        }
        fragment.j();
    }

    public void hideFragment(Fragment fragment) {
        if (C) {
            Log.v("FragmentManager", "hide: " + fragment);
        }
        if (fragment.z) {
            return;
        }
        fragment.z = true;
        fragment.N = true ^ fragment.N;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Deprecated
    public FragmentManagerNonConfig i() {
        if (this.m instanceof ViewModelStoreOwner) {
            throwException(new IllegalStateException("You cannot use retainNonConfig when your FragmentHostCallback implements ViewModelStoreOwner."));
        }
        return this.mNonConfig.d();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void i(Fragment fragment) {
        if (fragment == null) {
            return;
        }
        if (!this.f.containsKey(fragment.f)) {
            if (C) {
                Log.v("FragmentManager", "Ignoring moving " + fragment + " to state " + this.l + "since it is not added to " + this);
                return;
            }
            return;
        }
        int i = this.l;
        if (fragment.l) {
            i = fragment.l() ? Math.min(i, 1) : Math.min(i, 0);
        }
        a(fragment, i, fragment.g(), fragment.h(), false);
        if (fragment.G != null) {
            Fragment findFragmentUnder = findFragmentUnder(fragment);
            if (findFragmentUnder != null) {
                View view = findFragmentUnder.G;
                ViewGroup viewGroup = fragment.F;
                int indexOfChild = viewGroup.indexOfChild(view);
                int indexOfChild2 = viewGroup.indexOfChild(fragment.G);
                if (indexOfChild2 < indexOfChild) {
                    viewGroup.removeViewAt(indexOfChild2);
                    viewGroup.addView(fragment.G, indexOfChild);
                }
            }
            if (fragment.M && fragment.F != null) {
                float f = fragment.O;
                if (f > 0.0f) {
                    fragment.G.setAlpha(f);
                }
                fragment.O = 0.0f;
                fragment.M = false;
                AnimationOrAnimator a = a(fragment, fragment.g(), true, fragment.h());
                if (a != null) {
                    Animation animation = a.animation;
                    if (animation != null) {
                        fragment.G.startAnimation(animation);
                    } else {
                        a.animator.setTarget(fragment.G);
                        a.animator.start();
                    }
                }
            }
        }
        if (fragment.N) {
            b(fragment);
        }
    }

    @Override // androidx.fragment.app.FragmentManager
    public boolean isDestroyed() {
        return this.t;
    }

    @Override // androidx.fragment.app.FragmentManager
    public boolean isStateSaved() {
        return this.r || this.s;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Parcelable j() {
        ArrayList<String> arrayList;
        int size;
        forcePostponedTransactions();
        endAnimatingAwayFragments();
        execPendingActions();
        this.r = true;
        BackStackState[] backStackStateArr = null;
        if (this.f.isEmpty()) {
            return null;
        }
        ArrayList<FragmentState> arrayList2 = new ArrayList<>(this.f.size());
        boolean z = false;
        for (Fragment fragment : this.f.values()) {
            if (fragment != null) {
                if (fragment.r != this) {
                    throwException(new IllegalStateException("Failure saving state: active " + fragment + " was removed from the FragmentManager"));
                }
                FragmentState fragmentState = new FragmentState(fragment);
                arrayList2.add(fragmentState);
                if (fragment.b <= 0 || fragmentState.m != null) {
                    fragmentState.m = fragment.c;
                } else {
                    fragmentState.m = l(fragment);
                    String str = fragment.i;
                    if (str != null) {
                        Fragment fragment2 = this.f.get(str);
                        if (fragment2 == null) {
                            throwException(new IllegalStateException("Failure saving state: " + fragment + " has target not in fragment manager: " + fragment.i));
                        }
                        if (fragmentState.m == null) {
                            fragmentState.m = new Bundle();
                        }
                        putFragment(fragmentState.m, "android:target_state", fragment2);
                        int i = fragment.j;
                        if (i != 0) {
                            fragmentState.m.putInt("android:target_req_state", i);
                        }
                    }
                }
                if (C) {
                    Log.v("FragmentManager", "Saved state of " + fragment + ": " + fragmentState.m);
                }
                z = true;
            }
        }
        if (!z) {
            if (C) {
                Log.v("FragmentManager", "saveAllState: no fragments!");
            }
            return null;
        }
        int size2 = this.e.size();
        if (size2 > 0) {
            arrayList = new ArrayList<>(size2);
            Iterator<Fragment> it = this.e.iterator();
            while (it.hasNext()) {
                Fragment next = it.next();
                arrayList.add(next.f);
                if (next.r != this) {
                    throwException(new IllegalStateException("Failure saving state: active " + next + " was removed from the FragmentManager"));
                }
                if (C) {
                    Log.v("FragmentManager", "saveAllState: adding fragment (" + next.f + "): " + next);
                }
            }
        } else {
            arrayList = null;
        }
        ArrayList<BackStackRecord> arrayList3 = this.g;
        if (arrayList3 != null && (size = arrayList3.size()) > 0) {
            backStackStateArr = new BackStackState[size];
            for (int i2 = 0; i2 < size; i2++) {
                backStackStateArr[i2] = new BackStackState(this.g.get(i2));
                if (C) {
                    Log.v("FragmentManager", "saveAllState: adding back stack #" + i2 + ": " + this.g.get(i2));
                }
            }
        }
        FragmentManagerState fragmentManagerState = new FragmentManagerState();
        fragmentManagerState.a = arrayList2;
        fragmentManagerState.b = arrayList;
        fragmentManagerState.c = backStackStateArr;
        Fragment fragment3 = this.p;
        if (fragment3 != null) {
            fragmentManagerState.d = fragment3.f;
        }
        fragmentManagerState.e = this.d;
        return fragmentManagerState;
    }

    void j(Fragment fragment) {
        a(fragment, this.l, 0, 0, false);
    }

    void k() {
        synchronized (this) {
            boolean z = false;
            boolean z2 = (this.A == null || this.A.isEmpty()) ? false : true;
            if (this.b != null && this.b.size() == 1) {
                z = true;
            }
            if (z2 || z) {
                this.m.c().removeCallbacks(this.B);
                this.m.c().post(this.B);
                updateOnBackPressedCallbackEnabled();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void k(@NonNull Fragment fragment) {
        if (isStateSaved()) {
            if (C) {
                Log.v("FragmentManager", "Ignoring removeRetainedFragment as the state is already saved");
            }
        } else if (this.mNonConfig.e(fragment) && C) {
            Log.v("FragmentManager", "Updating retained Fragments: Removed " + fragment);
        }
    }

    Bundle l(Fragment fragment) {
        Bundle bundle;
        if (this.y == null) {
            this.y = new Bundle();
        }
        fragment.d(this.y);
        d(fragment, this.y, false);
        if (this.y.isEmpty()) {
            bundle = null;
        } else {
            bundle = this.y;
            this.y = null;
        }
        if (fragment.G != null) {
            m(fragment);
        }
        if (fragment.d != null) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putSparseParcelableArray("android:view_state", fragment.d);
        }
        if (!fragment.J) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putBoolean("android:user_visible_hint", fragment.J);
        }
        return bundle;
    }

    void l() {
        for (Fragment fragment : this.f.values()) {
            if (fragment != null) {
                performPendingDeferredStart(fragment);
            }
        }
    }

    void m(Fragment fragment) {
        if (fragment.H == null) {
            return;
        }
        SparseArray<Parcelable> sparseArray = this.z;
        if (sparseArray == null) {
            this.z = new SparseArray<>();
        } else {
            sparseArray.clear();
        }
        fragment.H.saveHierarchyState(this.z);
        if (this.z.size() > 0) {
            fragment.d = this.z;
            this.z = null;
        }
    }

    public void noteStateNotSaved() {
        this.r = false;
        this.s = false;
        int size = this.e.size();
        for (int i = 0; i < size; i++) {
            Fragment fragment = this.e.get(i);
            if (fragment != null) {
                fragment.n();
            }
        }
    }

    @Override // android.view.LayoutInflater.Factory2
    @Nullable
    public View onCreateView(@Nullable View view, @NonNull String str, @NonNull Context context, @NonNull AttributeSet attributeSet) {
        Fragment fragment;
        if (!"fragment".equals(str)) {
            return null;
        }
        String attributeValue = attributeSet.getAttributeValue(null, "class");
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, FragmentTag.Fragment);
        if (attributeValue == null) {
            attributeValue = obtainStyledAttributes.getString(0);
        }
        String str2 = attributeValue;
        int resourceId = obtainStyledAttributes.getResourceId(1, -1);
        String string = obtainStyledAttributes.getString(2);
        obtainStyledAttributes.recycle();
        if (str2 == null || !FragmentFactory.a(context.getClassLoader(), str2)) {
            return null;
        }
        int id = view != null ? view.getId() : 0;
        if (id == -1 && resourceId == -1 && string == null) {
            throw new IllegalArgumentException(attributeSet.getPositionDescription() + ": Must specify unique android:id, android:tag, or have a parent with an id for " + str2);
        }
        Fragment findFragmentById = resourceId != -1 ? findFragmentById(resourceId) : null;
        if (findFragmentById == null && string != null) {
            findFragmentById = findFragmentByTag(string);
        }
        if (findFragmentById == null && id != -1) {
            findFragmentById = findFragmentById(id);
        }
        if (C) {
            Log.v("FragmentManager", "onCreateView: id=0x" + Integer.toHexString(resourceId) + " fname=" + str2 + " existing=" + findFragmentById);
        }
        if (findFragmentById == null) {
            Fragment instantiate = getFragmentFactory().instantiate(context.getClassLoader(), str2);
            instantiate.m = true;
            instantiate.w = resourceId != 0 ? resourceId : id;
            instantiate.x = id;
            instantiate.y = string;
            instantiate.n = true;
            instantiate.r = this;
            FragmentHostCallback fragmentHostCallback = this.m;
            instantiate.s = fragmentHostCallback;
            instantiate.onInflate(fragmentHostCallback.b(), attributeSet, instantiate.c);
            addFragment(instantiate, true);
            fragment = instantiate;
        } else {
            if (findFragmentById.n) {
                throw new IllegalArgumentException(attributeSet.getPositionDescription() + ": Duplicate id 0x" + Integer.toHexString(resourceId) + ", tag " + string + ", or parent id 0x" + Integer.toHexString(id) + " with another fragment for " + str2);
            }
            findFragmentById.n = true;
            FragmentHostCallback fragmentHostCallback2 = this.m;
            findFragmentById.s = fragmentHostCallback2;
            findFragmentById.onInflate(fragmentHostCallback2.b(), attributeSet, findFragmentById.c);
            fragment = findFragmentById;
        }
        if (this.l >= 1 || !fragment.m) {
            j(fragment);
        } else {
            a(fragment, 1, 0, 0, false);
        }
        View view2 = fragment.G;
        if (view2 != null) {
            if (resourceId != 0) {
                view2.setId(resourceId);
            }
            if (fragment.G.getTag() == null) {
                fragment.G.setTag(string);
            }
            return fragment.G;
        }
        throw new IllegalStateException("Fragment " + str2 + " did not create a view.");
    }

    @Override // android.view.LayoutInflater.Factory
    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        return onCreateView(null, str, context, attributeSet);
    }

    public void performPendingDeferredStart(Fragment fragment) {
        if (fragment.I) {
            if (this.c) {
                this.u = true;
            } else {
                fragment.I = false;
                a(fragment, this.l, 0, 0, false);
            }
        }
    }

    @Override // androidx.fragment.app.FragmentManager
    public void popBackStack() {
        enqueueAction(new PopBackStackState(null, -1, 0), false);
    }

    @Override // androidx.fragment.app.FragmentManager
    public void popBackStack(int i, int i2) {
        if (i >= 0) {
            enqueueAction(new PopBackStackState(null, i, i2), false);
            return;
        }
        throw new IllegalArgumentException("Bad id: " + i);
    }

    @Override // androidx.fragment.app.FragmentManager
    public void popBackStack(@Nullable String str, int i) {
        enqueueAction(new PopBackStackState(str, -1, i), false);
    }

    @Override // androidx.fragment.app.FragmentManager
    public boolean popBackStackImmediate() {
        checkStateLoss();
        return popBackStackImmediate(null, -1, 0);
    }

    @Override // androidx.fragment.app.FragmentManager
    public boolean popBackStackImmediate(int i, int i2) {
        checkStateLoss();
        execPendingActions();
        if (i >= 0) {
            return popBackStackImmediate(null, i, i2);
        }
        throw new IllegalArgumentException("Bad id: " + i);
    }

    @Override // androidx.fragment.app.FragmentManager
    public boolean popBackStackImmediate(@Nullable String str, int i) {
        checkStateLoss();
        return popBackStackImmediate(str, -1, i);
    }

    @Override // androidx.fragment.app.FragmentManager
    public void putFragment(Bundle bundle, String str, Fragment fragment) {
        if (fragment.r != this) {
            throwException(new IllegalStateException("Fragment " + fragment + " is not currently in the FragmentManager"));
        }
        bundle.putString(str, fragment.f);
    }

    @Override // androidx.fragment.app.FragmentManager
    public void registerFragmentLifecycleCallbacks(@NonNull FragmentManager.FragmentLifecycleCallbacks fragmentLifecycleCallbacks, boolean z) {
        this.mLifecycleCallbacks.add(new FragmentLifecycleCallbacksHolder(fragmentLifecycleCallbacks, z));
    }

    public void removeFragment(Fragment fragment) {
        if (C) {
            Log.v("FragmentManager", "remove: " + fragment + " nesting=" + fragment.q);
        }
        boolean z = !fragment.l();
        if (!fragment.A || z) {
            synchronized (this.e) {
                this.e.remove(fragment);
            }
            if (isMenuAvailable(fragment)) {
                this.q = true;
            }
            fragment.k = false;
            fragment.l = true;
        }
    }

    @Override // androidx.fragment.app.FragmentManager
    public void removeOnBackStackChangedListener(FragmentManager.OnBackStackChangedListener onBackStackChangedListener) {
        ArrayList<FragmentManager.OnBackStackChangedListener> arrayList = this.k;
        if (arrayList != null) {
            arrayList.remove(onBackStackChangedListener);
        }
    }

    @Override // androidx.fragment.app.FragmentManager
    @Nullable
    public Fragment.SavedState saveFragmentInstanceState(@NonNull Fragment fragment) {
        Bundle l;
        if (fragment.r != this) {
            throwException(new IllegalStateException("Fragment " + fragment + " is not currently in the FragmentManager"));
        }
        if (fragment.b <= 0 || (l = l(fragment)) == null) {
            return null;
        }
        return new Fragment.SavedState(l);
    }

    public void setBackStackIndex(int i, BackStackRecord backStackRecord) {
        synchronized (this) {
            if (this.i == null) {
                this.i = new ArrayList<>();
            }
            int size = this.i.size();
            if (i < size) {
                if (C) {
                    Log.v("FragmentManager", "Setting back stack index " + i + " to " + backStackRecord);
                }
                this.i.set(i, backStackRecord);
            } else {
                while (size < i) {
                    this.i.add(null);
                    if (this.j == null) {
                        this.j = new ArrayList<>();
                    }
                    if (C) {
                        Log.v("FragmentManager", "Adding available back stack index " + size);
                    }
                    this.j.add(Integer.valueOf(size));
                    size++;
                }
                if (C) {
                    Log.v("FragmentManager", "Adding back stack index " + i + " with " + backStackRecord);
                }
                this.i.add(backStackRecord);
            }
        }
    }

    public void setMaxLifecycle(Fragment fragment, Lifecycle.State state) {
        if (this.f.get(fragment.f) == fragment && (fragment.s == null || fragment.getFragmentManager() == this)) {
            fragment.R = state;
            return;
        }
        throw new IllegalArgumentException("Fragment " + fragment + " is not an active fragment of FragmentManager " + this);
    }

    public void setPrimaryNavigationFragment(Fragment fragment) {
        if (fragment == null || (this.f.get(fragment.f) == fragment && (fragment.s == null || fragment.getFragmentManager() == this))) {
            Fragment fragment2 = this.p;
            this.p = fragment;
            dispatchParentPrimaryNavigationFragmentChanged(fragment2);
            dispatchParentPrimaryNavigationFragmentChanged(this.p);
            return;
        }
        throw new IllegalArgumentException("Fragment " + fragment + " is not an active fragment of FragmentManager " + this);
    }

    public void showFragment(Fragment fragment) {
        if (C) {
            Log.v("FragmentManager", "show: " + fragment);
        }
        if (fragment.z) {
            fragment.z = false;
            fragment.N = !fragment.N;
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("FragmentManager{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(" in ");
        Object obj = this.o;
        if (obj == null) {
            obj = this.m;
        }
        DebugUtils.buildShortClassTag(obj, sb);
        sb.append("}}");
        return sb.toString();
    }

    @Override // androidx.fragment.app.FragmentManager
    public void unregisterFragmentLifecycleCallbacks(@NonNull FragmentManager.FragmentLifecycleCallbacks fragmentLifecycleCallbacks) {
        synchronized (this.mLifecycleCallbacks) {
            int i = 0;
            int size = this.mLifecycleCallbacks.size();
            while (true) {
                if (i >= size) {
                    break;
                }
                if (this.mLifecycleCallbacks.get(i).a == fragmentLifecycleCallbacks) {
                    this.mLifecycleCallbacks.remove(i);
                    break;
                }
                i++;
            }
        }
    }
}
