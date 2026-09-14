package androidx.fragment.app;

import android.animation.Animator;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import androidx.annotation.CallSuper;
import androidx.annotation.ContentView;
import androidx.annotation.LayoutRes;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.StringRes;
import androidx.core.app.SharedElementCallback;
import androidx.core.util.DebugUtils;
import androidx.core.view.LayoutInflaterCompat;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleRegistry;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.loader.app.LoaderManager;
import androidx.savedstate.SavedStateRegistry;
import androidx.savedstate.SavedStateRegistryController;
import androidx.savedstate.SavedStateRegistryOwner;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public class Fragment implements ComponentCallbacks, View.OnCreateContextMenuListener, LifecycleOwner, ViewModelStoreOwner, SavedStateRegistryOwner {
    static final Object W = new Object();
    boolean A;
    boolean B;
    boolean C;
    boolean D;
    boolean E;
    ViewGroup F;
    View G;
    View H;
    boolean I;
    boolean J;
    AnimationInfo K;
    Runnable L;
    boolean M;
    boolean N;
    float O;
    LayoutInflater P;
    boolean Q;
    Lifecycle.State R;
    LifecycleRegistry S;

    @Nullable
    FragmentViewLifecycleOwner T;
    MutableLiveData<LifecycleOwner> U;
    SavedStateRegistryController V;
    int b;
    Bundle c;
    SparseArray<Parcelable> d;

    @Nullable
    Boolean e;

    @NonNull
    String f;
    Bundle g;
    Fragment h;
    String i;
    int j;
    boolean k;
    boolean l;
    boolean m;
    private boolean mCalled;

    @LayoutRes
    private int mContentLayoutId;
    private Boolean mIsPrimaryNavigationFragment;
    boolean n;
    boolean o;
    boolean p;
    int q;
    FragmentManagerImpl r;
    FragmentHostCallback s;

    @NonNull
    FragmentManagerImpl t;
    Fragment u;
    int w;
    int x;
    String y;
    boolean z;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class AnimationInfo {
        View a;
        Animator b;
        int c;
        int d;
        int e;
        int f;
        Object g = null;
        Object h;
        Object i;
        Object j;
        Object k;
        Object l;
        Boolean m;
        Boolean n;
        SharedElementCallback o;
        SharedElementCallback p;
        boolean q;
        OnStartEnterTransitionListener r;
        boolean s;

        AnimationInfo() {
            Object obj = Fragment.W;
            this.h = obj;
            this.i = null;
            this.j = obj;
            this.k = null;
            this.l = obj;
            this.o = null;
            this.p = null;
        }
    }

    /* loaded from: classes.dex */
    public static class InstantiationException extends RuntimeException {
        public InstantiationException(@NonNull String str, @Nullable Exception exc) {
            super(str, exc);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface OnStartEnterTransitionListener {
        void onStartEnterTransition();

        void startListening();
    }

    @SuppressLint({"BanParcelableUsage"})
    /* loaded from: classes.dex */
    public static class SavedState implements Parcelable {

        @NonNull
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.ClassLoaderCreator<SavedState>() { // from class: androidx.fragment.app.Fragment.SavedState.1
            @Override // android.os.Parcelable.Creator
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel, null);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.ClassLoaderCreator
            public SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };
        final Bundle a;

        /* JADX INFO: Access modifiers changed from: package-private */
        public SavedState(Bundle bundle) {
            this.a = bundle;
        }

        SavedState(@NonNull Parcel parcel, @Nullable ClassLoader classLoader) {
            Bundle bundle;
            this.a = parcel.readBundle();
            if (classLoader == null || (bundle = this.a) == null) {
                return;
            }
            bundle.setClassLoader(classLoader);
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@NonNull Parcel parcel, int i) {
            parcel.writeBundle(this.a);
        }
    }

    public Fragment() {
        this.b = 0;
        this.f = UUID.randomUUID().toString();
        this.i = null;
        this.mIsPrimaryNavigationFragment = null;
        this.t = new FragmentManagerImpl();
        this.E = true;
        this.J = true;
        this.L = new Runnable() { // from class: androidx.fragment.app.Fragment.1
            @Override // java.lang.Runnable
            public void run() {
                Fragment.this.startPostponedEnterTransition();
            }
        };
        this.R = Lifecycle.State.RESUMED;
        this.U = new MutableLiveData<>();
        initLifecycle();
    }

    @ContentView
    public Fragment(@LayoutRes int i) {
        this();
        this.mContentLayoutId = i;
    }

    private AnimationInfo ensureAnimationInfo() {
        if (this.K == null) {
            this.K = new AnimationInfo();
        }
        return this.K;
    }

    private void initLifecycle() {
        this.S = new LifecycleRegistry(this);
        this.V = SavedStateRegistryController.create(this);
        if (Build.VERSION.SDK_INT >= 19) {
            this.S.addObserver(new LifecycleEventObserver() { // from class: androidx.fragment.app.Fragment.2
                @Override // androidx.lifecycle.LifecycleEventObserver
                public void onStateChanged(@NonNull LifecycleOwner lifecycleOwner, @NonNull Lifecycle.Event event) {
                    View view;
                    if (event != Lifecycle.Event.ON_STOP || (view = Fragment.this.G) == null) {
                        return;
                    }
                    view.cancelPendingInputEvents();
                }
            });
        }
    }

    @NonNull
    @Deprecated
    public static Fragment instantiate(@NonNull Context context, @NonNull String str) {
        return instantiate(context, str, null);
    }

    @NonNull
    @Deprecated
    public static Fragment instantiate(@NonNull Context context, @NonNull String str, @Nullable Bundle bundle) {
        try {
            Fragment newInstance = FragmentFactory.loadFragmentClass(context.getClassLoader(), str).getConstructor(new Class[0]).newInstance(new Object[0]);
            if (bundle != null) {
                bundle.setClassLoader(newInstance.getClass().getClassLoader());
                newInstance.setArguments(bundle);
            }
            return newInstance;
        } catch (IllegalAccessException e) {
            throw new InstantiationException("Unable to instantiate fragment " + str + ": make sure class name exists, is public, and has an empty constructor that is public", e);
        } catch (java.lang.InstantiationException e2) {
            throw new InstantiationException("Unable to instantiate fragment " + str + ": make sure class name exists, is public, and has an empty constructor that is public", e2);
        } catch (NoSuchMethodException e3) {
            throw new InstantiationException("Unable to instantiate fragment " + str + ": could not find Fragment constructor", e3);
        } catch (InvocationTargetException e4) {
            throw new InstantiationException("Unable to instantiate fragment " + str + ": calling Fragment constructor caused an exception", e4);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public Fragment a(@NonNull String str) {
        return str.equals(this.f) ? this : this.t.findFragmentByWho(str);
    }

    void a() {
        AnimationInfo animationInfo = this.K;
        OnStartEnterTransitionListener onStartEnterTransitionListener = null;
        if (animationInfo != null) {
            animationInfo.q = false;
            OnStartEnterTransitionListener onStartEnterTransitionListener2 = animationInfo.r;
            animationInfo.r = null;
            onStartEnterTransitionListener = onStartEnterTransitionListener2;
        }
        if (onStartEnterTransitionListener != null) {
            onStartEnterTransitionListener.onStartEnterTransition();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(int i) {
        if (this.K == null && i == 0) {
            return;
        }
        ensureAnimationInfo().d = i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(int i, int i2) {
        if (this.K == null && i == 0 && i2 == 0) {
            return;
        }
        ensureAnimationInfo();
        AnimationInfo animationInfo = this.K;
        animationInfo.e = i;
        animationInfo.f = i2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(Animator animator) {
        ensureAnimationInfo().b = animator;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(@NonNull Configuration configuration) {
        onConfigurationChanged(configuration);
        this.t.dispatchConfigurationChanged(configuration);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(Bundle bundle) {
        this.t.noteStateNotSaved();
        this.b = 2;
        this.mCalled = false;
        onActivityCreated(bundle);
        if (this.mCalled) {
            this.t.dispatchActivityCreated();
            return;
        }
        throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onActivityCreated()");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        this.t.noteStateNotSaved();
        this.p = true;
        this.T = new FragmentViewLifecycleOwner();
        this.G = onCreateView(layoutInflater, viewGroup, bundle);
        if (this.G != null) {
            this.T.a();
            this.U.setValue(this.T);
        } else {
            if (this.T.b()) {
                throw new IllegalStateException("Called getViewLifecycleOwner() but onCreateView() returned null");
            }
            this.T = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(@NonNull Menu menu) {
        if (this.z) {
            return;
        }
        if (this.D && this.E) {
            onOptionsMenuClosed(menu);
        }
        this.t.dispatchOptionsMenuClosed(menu);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(View view) {
        ensureAnimationInfo().a = view;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(OnStartEnterTransitionListener onStartEnterTransitionListener) {
        ensureAnimationInfo();
        OnStartEnterTransitionListener onStartEnterTransitionListener2 = this.K.r;
        if (onStartEnterTransitionListener == onStartEnterTransitionListener2) {
            return;
        }
        if (onStartEnterTransitionListener != null && onStartEnterTransitionListener2 != null) {
            throw new IllegalStateException("Trying to set a replacement startPostponedEnterTransition on " + this);
        }
        AnimationInfo animationInfo = this.K;
        if (animationInfo.q) {
            animationInfo.r = onStartEnterTransitionListener;
        }
        if (onStartEnterTransitionListener != null) {
            onStartEnterTransitionListener.startListening();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(boolean z) {
        onMultiWindowModeChanged(z);
        this.t.dispatchMultiWindowModeChanged(z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a(@NonNull Menu menu, @NonNull MenuInflater menuInflater) {
        boolean z = false;
        if (this.z) {
            return false;
        }
        if (this.D && this.E) {
            z = true;
            onCreateOptionsMenu(menu, menuInflater);
        }
        return z | this.t.dispatchCreateOptionsMenu(menu, menuInflater);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a(@NonNull MenuItem menuItem) {
        if (this.z) {
            return false;
        }
        return onContextItemSelected(menuItem) || this.t.dispatchContextItemSelected(menuItem);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public View b() {
        AnimationInfo animationInfo = this.K;
        if (animationInfo == null) {
            return null;
        }
        return animationInfo.a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(int i) {
        ensureAnimationInfo().c = i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(Bundle bundle) {
        this.t.noteStateNotSaved();
        this.b = 1;
        this.mCalled = false;
        this.V.performRestore(bundle);
        onCreate(bundle);
        this.Q = true;
        if (this.mCalled) {
            this.S.handleLifecycleEvent(Lifecycle.Event.ON_CREATE);
            return;
        }
        throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onCreate()");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(boolean z) {
        onPictureInPictureModeChanged(z);
        this.t.dispatchPictureInPictureModeChanged(z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean b(@NonNull Menu menu) {
        boolean z = false;
        if (this.z) {
            return false;
        }
        if (this.D && this.E) {
            z = true;
            onPrepareOptionsMenu(menu);
        }
        return z | this.t.dispatchPrepareOptionsMenu(menu);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean b(@NonNull MenuItem menuItem) {
        if (this.z) {
            return false;
        }
        return (this.D && this.E && onOptionsItemSelected(menuItem)) || this.t.dispatchOptionsItemSelected(menuItem);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Animator c() {
        AnimationInfo animationInfo = this.K;
        if (animationInfo == null) {
            return null;
        }
        return animationInfo.b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NonNull
    public LayoutInflater c(@Nullable Bundle bundle) {
        this.P = onGetLayoutInflater(bundle);
        return this.P;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(boolean z) {
        ensureAnimationInfo().s = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public SharedElementCallback d() {
        AnimationInfo animationInfo = this.K;
        if (animationInfo == null) {
            return null;
        }
        return animationInfo.o;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d(Bundle bundle) {
        onSaveInstanceState(bundle);
        this.V.performSave(bundle);
        Parcelable j = this.t.j();
        if (j != null) {
            bundle.putParcelable("android:support:fragments", j);
        }
    }

    public void dump(@NonNull String str, @Nullable FileDescriptor fileDescriptor, @NonNull PrintWriter printWriter, @Nullable String[] strArr) {
        printWriter.print(str);
        printWriter.print("mFragmentId=#");
        printWriter.print(Integer.toHexString(this.w));
        printWriter.print(" mContainerId=#");
        printWriter.print(Integer.toHexString(this.x));
        printWriter.print(" mTag=");
        printWriter.println(this.y);
        printWriter.print(str);
        printWriter.print("mState=");
        printWriter.print(this.b);
        printWriter.print(" mWho=");
        printWriter.print(this.f);
        printWriter.print(" mBackStackNesting=");
        printWriter.println(this.q);
        printWriter.print(str);
        printWriter.print("mAdded=");
        printWriter.print(this.k);
        printWriter.print(" mRemoving=");
        printWriter.print(this.l);
        printWriter.print(" mFromLayout=");
        printWriter.print(this.m);
        printWriter.print(" mInLayout=");
        printWriter.println(this.n);
        printWriter.print(str);
        printWriter.print("mHidden=");
        printWriter.print(this.z);
        printWriter.print(" mDetached=");
        printWriter.print(this.A);
        printWriter.print(" mMenuVisible=");
        printWriter.print(this.E);
        printWriter.print(" mHasMenu=");
        printWriter.println(this.D);
        printWriter.print(str);
        printWriter.print("mRetainInstance=");
        printWriter.print(this.B);
        printWriter.print(" mUserVisibleHint=");
        printWriter.println(this.J);
        if (this.r != null) {
            printWriter.print(str);
            printWriter.print("mFragmentManager=");
            printWriter.println(this.r);
        }
        if (this.s != null) {
            printWriter.print(str);
            printWriter.print("mHost=");
            printWriter.println(this.s);
        }
        if (this.u != null) {
            printWriter.print(str);
            printWriter.print("mParentFragment=");
            printWriter.println(this.u);
        }
        if (this.g != null) {
            printWriter.print(str);
            printWriter.print("mArguments=");
            printWriter.println(this.g);
        }
        if (this.c != null) {
            printWriter.print(str);
            printWriter.print("mSavedFragmentState=");
            printWriter.println(this.c);
        }
        if (this.d != null) {
            printWriter.print(str);
            printWriter.print("mSavedViewState=");
            printWriter.println(this.d);
        }
        Fragment targetFragment = getTargetFragment();
        if (targetFragment != null) {
            printWriter.print(str);
            printWriter.print("mTarget=");
            printWriter.print(targetFragment);
            printWriter.print(" mTargetRequestCode=");
            printWriter.println(this.j);
        }
        if (f() != 0) {
            printWriter.print(str);
            printWriter.print("mNextAnim=");
            printWriter.println(f());
        }
        if (this.F != null) {
            printWriter.print(str);
            printWriter.print("mContainer=");
            printWriter.println(this.F);
        }
        if (this.G != null) {
            printWriter.print(str);
            printWriter.print("mView=");
            printWriter.println(this.G);
        }
        if (this.H != null) {
            printWriter.print(str);
            printWriter.print("mInnerView=");
            printWriter.println(this.G);
        }
        if (b() != null) {
            printWriter.print(str);
            printWriter.print("mAnimatingAway=");
            printWriter.println(b());
            printWriter.print(str);
            printWriter.print("mStateAfterAnimating=");
            printWriter.println(i());
        }
        if (getContext() != null) {
            LoaderManager.getInstance(this).dump(str, fileDescriptor, printWriter, strArr);
        }
        printWriter.print(str);
        printWriter.println("Child " + this.t + ":");
        this.t.dump(str + "  ", fileDescriptor, printWriter, strArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public SharedElementCallback e() {
        AnimationInfo animationInfo = this.K;
        if (animationInfo == null) {
            return null;
        }
        return animationInfo.p;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e(@Nullable Bundle bundle) {
        Parcelable parcelable;
        if (bundle == null || (parcelable = bundle.getParcelable("android:support:fragments")) == null) {
            return;
        }
        this.t.a(parcelable);
        this.t.dispatchCreate();
    }

    public final boolean equals(@Nullable Object obj) {
        return super.equals(obj);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int f() {
        AnimationInfo animationInfo = this.K;
        if (animationInfo == null) {
            return 0;
        }
        return animationInfo.d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void f(Bundle bundle) {
        SparseArray<Parcelable> sparseArray = this.d;
        if (sparseArray != null) {
            this.H.restoreHierarchyState(sparseArray);
            this.d = null;
        }
        this.mCalled = false;
        onViewStateRestored(bundle);
        if (this.mCalled) {
            if (this.G != null) {
                this.T.a(Lifecycle.Event.ON_CREATE);
            }
        } else {
            throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onViewStateRestored()");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int g() {
        AnimationInfo animationInfo = this.K;
        if (animationInfo == null) {
            return 0;
        }
        return animationInfo.e;
    }

    @Nullable
    public final FragmentActivity getActivity() {
        FragmentHostCallback fragmentHostCallback = this.s;
        if (fragmentHostCallback == null) {
            return null;
        }
        return (FragmentActivity) fragmentHostCallback.a();
    }

    public boolean getAllowEnterTransitionOverlap() {
        Boolean bool;
        AnimationInfo animationInfo = this.K;
        if (animationInfo == null || (bool = animationInfo.n) == null) {
            return true;
        }
        return bool.booleanValue();
    }

    public boolean getAllowReturnTransitionOverlap() {
        Boolean bool;
        AnimationInfo animationInfo = this.K;
        if (animationInfo == null || (bool = animationInfo.m) == null) {
            return true;
        }
        return bool.booleanValue();
    }

    @Nullable
    public final Bundle getArguments() {
        return this.g;
    }

    @NonNull
    public final FragmentManager getChildFragmentManager() {
        if (this.s != null) {
            return this.t;
        }
        throw new IllegalStateException("Fragment " + this + " has not been attached yet.");
    }

    @Nullable
    public Context getContext() {
        FragmentHostCallback fragmentHostCallback = this.s;
        if (fragmentHostCallback == null) {
            return null;
        }
        return fragmentHostCallback.b();
    }

    @Nullable
    public Object getEnterTransition() {
        AnimationInfo animationInfo = this.K;
        if (animationInfo == null) {
            return null;
        }
        return animationInfo.g;
    }

    @Nullable
    public Object getExitTransition() {
        AnimationInfo animationInfo = this.K;
        if (animationInfo == null) {
            return null;
        }
        return animationInfo.i;
    }

    @Nullable
    public final FragmentManager getFragmentManager() {
        return this.r;
    }

    @Nullable
    public final Object getHost() {
        FragmentHostCallback fragmentHostCallback = this.s;
        if (fragmentHostCallback == null) {
            return null;
        }
        return fragmentHostCallback.onGetHost();
    }

    public final int getId() {
        return this.w;
    }

    @NonNull
    public final LayoutInflater getLayoutInflater() {
        LayoutInflater layoutInflater = this.P;
        return layoutInflater == null ? c((Bundle) null) : layoutInflater;
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    @Deprecated
    public LayoutInflater getLayoutInflater(@Nullable Bundle bundle) {
        FragmentHostCallback fragmentHostCallback = this.s;
        if (fragmentHostCallback == null) {
            throw new IllegalStateException("onGetLayoutInflater() cannot be executed until the Fragment is attached to the FragmentManager.");
        }
        LayoutInflater onGetLayoutInflater = fragmentHostCallback.onGetLayoutInflater();
        LayoutInflaterCompat.setFactory2(onGetLayoutInflater, this.t.f());
        return onGetLayoutInflater;
    }

    @Override // androidx.lifecycle.LifecycleOwner
    @NonNull
    public Lifecycle getLifecycle() {
        return this.S;
    }

    @NonNull
    @Deprecated
    public LoaderManager getLoaderManager() {
        return LoaderManager.getInstance(this);
    }

    @Nullable
    public final Fragment getParentFragment() {
        return this.u;
    }

    @Nullable
    public Object getReenterTransition() {
        AnimationInfo animationInfo = this.K;
        if (animationInfo == null) {
            return null;
        }
        Object obj = animationInfo.j;
        return obj == W ? getExitTransition() : obj;
    }

    @NonNull
    public final Resources getResources() {
        return requireContext().getResources();
    }

    public final boolean getRetainInstance() {
        return this.B;
    }

    @Nullable
    public Object getReturnTransition() {
        AnimationInfo animationInfo = this.K;
        if (animationInfo == null) {
            return null;
        }
        Object obj = animationInfo.h;
        return obj == W ? getEnterTransition() : obj;
    }

    @Override // androidx.savedstate.SavedStateRegistryOwner
    @NonNull
    public final SavedStateRegistry getSavedStateRegistry() {
        return this.V.getSavedStateRegistry();
    }

    @Nullable
    public Object getSharedElementEnterTransition() {
        AnimationInfo animationInfo = this.K;
        if (animationInfo == null) {
            return null;
        }
        return animationInfo.k;
    }

    @Nullable
    public Object getSharedElementReturnTransition() {
        AnimationInfo animationInfo = this.K;
        if (animationInfo == null) {
            return null;
        }
        Object obj = animationInfo.l;
        return obj == W ? getSharedElementEnterTransition() : obj;
    }

    @NonNull
    public final String getString(@StringRes int i) {
        return getResources().getString(i);
    }

    @NonNull
    public final String getString(@StringRes int i, @Nullable Object... objArr) {
        return getResources().getString(i, objArr);
    }

    @Nullable
    public final String getTag() {
        return this.y;
    }

    @Nullable
    public final Fragment getTargetFragment() {
        String str;
        Fragment fragment = this.h;
        if (fragment != null) {
            return fragment;
        }
        FragmentManagerImpl fragmentManagerImpl = this.r;
        if (fragmentManagerImpl == null || (str = this.i) == null) {
            return null;
        }
        return fragmentManagerImpl.f.get(str);
    }

    public final int getTargetRequestCode() {
        return this.j;
    }

    @NonNull
    public final CharSequence getText(@StringRes int i) {
        return getResources().getText(i);
    }

    @Deprecated
    public boolean getUserVisibleHint() {
        return this.J;
    }

    @Nullable
    public View getView() {
        return this.G;
    }

    @NonNull
    @MainThread
    public LifecycleOwner getViewLifecycleOwner() {
        FragmentViewLifecycleOwner fragmentViewLifecycleOwner = this.T;
        if (fragmentViewLifecycleOwner != null) {
            return fragmentViewLifecycleOwner;
        }
        throw new IllegalStateException("Can't access the Fragment View's LifecycleOwner when getView() is null i.e., before onCreateView() or after onDestroyView()");
    }

    @NonNull
    public LiveData<LifecycleOwner> getViewLifecycleOwnerLiveData() {
        return this.U;
    }

    @Override // androidx.lifecycle.ViewModelStoreOwner
    @NonNull
    public ViewModelStore getViewModelStore() {
        FragmentManagerImpl fragmentManagerImpl = this.r;
        if (fragmentManagerImpl != null) {
            return fragmentManagerImpl.e(this);
        }
        throw new IllegalStateException("Can't access ViewModels from detached fragment");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int h() {
        AnimationInfo animationInfo = this.K;
        if (animationInfo == null) {
            return 0;
        }
        return animationInfo.f;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public final boolean hasOptionsMenu() {
        return this.D;
    }

    public final int hashCode() {
        return super.hashCode();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int i() {
        AnimationInfo animationInfo = this.K;
        if (animationInfo == null) {
            return 0;
        }
        return animationInfo.c;
    }

    public final boolean isAdded() {
        return this.s != null && this.k;
    }

    public final boolean isDetached() {
        return this.A;
    }

    public final boolean isHidden() {
        return this.z;
    }

    public final boolean isInLayout() {
        return this.n;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public final boolean isMenuVisible() {
        return this.E;
    }

    public final boolean isRemoving() {
        return this.l;
    }

    public final boolean isResumed() {
        return this.b >= 4;
    }

    public final boolean isStateSaved() {
        FragmentManagerImpl fragmentManagerImpl = this.r;
        if (fragmentManagerImpl == null) {
            return false;
        }
        return fragmentManagerImpl.isStateSaved();
    }

    public final boolean isVisible() {
        View view;
        return (!isAdded() || isHidden() || (view = this.G) == null || view.getWindowToken() == null || this.G.getVisibility() != 0) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void j() {
        initLifecycle();
        this.f = UUID.randomUUID().toString();
        this.k = false;
        this.l = false;
        this.m = false;
        this.n = false;
        this.o = false;
        this.q = 0;
        this.r = null;
        this.t = new FragmentManagerImpl();
        this.s = null;
        this.w = 0;
        this.x = 0;
        this.y = null;
        this.z = false;
        this.A = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean k() {
        AnimationInfo animationInfo = this.K;
        if (animationInfo == null) {
            return false;
        }
        return animationInfo.s;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean l() {
        return this.q > 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean m() {
        AnimationInfo animationInfo = this.K;
        if (animationInfo == null) {
            return false;
        }
        return animationInfo.q;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void n() {
        this.t.noteStateNotSaved();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void o() {
        this.t.attachController(this.s, new FragmentContainer() { // from class: androidx.fragment.app.Fragment.4
            @Override // androidx.fragment.app.FragmentContainer
            @Nullable
            public View onFindViewById(int i) {
                View view = Fragment.this.G;
                if (view != null) {
                    return view.findViewById(i);
                }
                throw new IllegalStateException("Fragment " + this + " does not have a view");
            }

            @Override // androidx.fragment.app.FragmentContainer
            public boolean onHasView() {
                return Fragment.this.G != null;
            }
        }, this);
        this.mCalled = false;
        onAttach(this.s.b());
        if (this.mCalled) {
            return;
        }
        throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onAttach()");
    }

    @CallSuper
    public void onActivityCreated(@Nullable Bundle bundle) {
        this.mCalled = true;
    }

    public void onActivityResult(int i, int i2, @Nullable Intent intent) {
    }

    @CallSuper
    @Deprecated
    public void onAttach(@NonNull Activity activity) {
        this.mCalled = true;
    }

    @CallSuper
    public void onAttach(@NonNull Context context) {
        this.mCalled = true;
        FragmentHostCallback fragmentHostCallback = this.s;
        Activity a = fragmentHostCallback == null ? null : fragmentHostCallback.a();
        if (a != null) {
            this.mCalled = false;
            onAttach(a);
        }
    }

    public void onAttachFragment(@NonNull Fragment fragment) {
    }

    @Override // android.content.ComponentCallbacks
    @CallSuper
    public void onConfigurationChanged(@NonNull Configuration configuration) {
        this.mCalled = true;
    }

    public boolean onContextItemSelected(@NonNull MenuItem menuItem) {
        return false;
    }

    @CallSuper
    public void onCreate(@Nullable Bundle bundle) {
        this.mCalled = true;
        e(bundle);
        if (this.t.a(1)) {
            return;
        }
        this.t.dispatchCreate();
    }

    @Nullable
    public Animation onCreateAnimation(int i, boolean z, int i2) {
        return null;
    }

    @Nullable
    public Animator onCreateAnimator(int i, boolean z, int i2) {
        return null;
    }

    @Override // android.view.View.OnCreateContextMenuListener
    public void onCreateContextMenu(@NonNull ContextMenu contextMenu, @NonNull View view, @Nullable ContextMenu.ContextMenuInfo contextMenuInfo) {
        requireActivity().onCreateContextMenu(contextMenu, view, contextMenuInfo);
    }

    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater menuInflater) {
    }

    @Nullable
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        int i = this.mContentLayoutId;
        if (i != 0) {
            return layoutInflater.inflate(i, viewGroup, false);
        }
        return null;
    }

    @CallSuper
    public void onDestroy() {
        this.mCalled = true;
    }

    public void onDestroyOptionsMenu() {
    }

    @CallSuper
    public void onDestroyView() {
        this.mCalled = true;
    }

    @CallSuper
    public void onDetach() {
        this.mCalled = true;
    }

    @NonNull
    public LayoutInflater onGetLayoutInflater(@Nullable Bundle bundle) {
        return getLayoutInflater(bundle);
    }

    public void onHiddenChanged(boolean z) {
    }

    @CallSuper
    @Deprecated
    public void onInflate(@NonNull Activity activity, @NonNull AttributeSet attributeSet, @Nullable Bundle bundle) {
        this.mCalled = true;
    }

    @CallSuper
    public void onInflate(@NonNull Context context, @NonNull AttributeSet attributeSet, @Nullable Bundle bundle) {
        this.mCalled = true;
        FragmentHostCallback fragmentHostCallback = this.s;
        Activity a = fragmentHostCallback == null ? null : fragmentHostCallback.a();
        if (a != null) {
            this.mCalled = false;
            onInflate(a, attributeSet, bundle);
        }
    }

    @Override // android.content.ComponentCallbacks
    @CallSuper
    public void onLowMemory() {
        this.mCalled = true;
    }

    public void onMultiWindowModeChanged(boolean z) {
    }

    public boolean onOptionsItemSelected(@NonNull MenuItem menuItem) {
        return false;
    }

    public void onOptionsMenuClosed(@NonNull Menu menu) {
    }

    @CallSuper
    public void onPause() {
        this.mCalled = true;
    }

    public void onPictureInPictureModeChanged(boolean z) {
    }

    public void onPrepareOptionsMenu(@NonNull Menu menu) {
    }

    public void onPrimaryNavigationFragmentChanged(boolean z) {
    }

    public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
    }

    @CallSuper
    public void onResume() {
        this.mCalled = true;
    }

    public void onSaveInstanceState(@NonNull Bundle bundle) {
    }

    @CallSuper
    public void onStart() {
        this.mCalled = true;
    }

    @CallSuper
    public void onStop() {
        this.mCalled = true;
    }

    public void onViewCreated(@NonNull View view, @Nullable Bundle bundle) {
    }

    @CallSuper
    public void onViewStateRestored(@Nullable Bundle bundle) {
        this.mCalled = true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void p() {
        this.t.dispatchDestroy();
        this.S.handleLifecycleEvent(Lifecycle.Event.ON_DESTROY);
        this.b = 0;
        this.mCalled = false;
        this.Q = false;
        onDestroy();
        if (this.mCalled) {
            return;
        }
        throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onDestroy()");
    }

    public void postponeEnterTransition() {
        ensureAnimationInfo().q = true;
    }

    public final void postponeEnterTransition(long j, @NonNull TimeUnit timeUnit) {
        ensureAnimationInfo().q = true;
        FragmentManagerImpl fragmentManagerImpl = this.r;
        Handler c = fragmentManagerImpl != null ? fragmentManagerImpl.m.c() : new Handler(Looper.getMainLooper());
        c.removeCallbacks(this.L);
        c.postDelayed(this.L, timeUnit.toMillis(j));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void q() {
        this.t.dispatchDestroyView();
        if (this.G != null) {
            this.T.a(Lifecycle.Event.ON_DESTROY);
        }
        this.b = 1;
        this.mCalled = false;
        onDestroyView();
        if (this.mCalled) {
            LoaderManager.getInstance(this).markForRedelivery();
            this.p = false;
        } else {
            throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onDestroyView()");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void r() {
        this.mCalled = false;
        onDetach();
        this.P = null;
        if (this.mCalled) {
            if (this.t.isDestroyed()) {
                return;
            }
            this.t.dispatchDestroy();
            this.t = new FragmentManagerImpl();
            return;
        }
        throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onDetach()");
    }

    public void registerForContextMenu(@NonNull View view) {
        view.setOnCreateContextMenuListener(this);
    }

    public final void requestPermissions(@NonNull String[] strArr, int i) {
        FragmentHostCallback fragmentHostCallback = this.s;
        if (fragmentHostCallback != null) {
            fragmentHostCallback.onRequestPermissionsFromFragment(this, strArr, i);
            return;
        }
        throw new IllegalStateException("Fragment " + this + " not attached to Activity");
    }

    @NonNull
    public final FragmentActivity requireActivity() {
        FragmentActivity activity = getActivity();
        if (activity != null) {
            return activity;
        }
        throw new IllegalStateException("Fragment " + this + " not attached to an activity.");
    }

    @NonNull
    public final Bundle requireArguments() {
        Bundle arguments = getArguments();
        if (arguments != null) {
            return arguments;
        }
        throw new IllegalStateException("Fragment " + this + " does not have any arguments.");
    }

    @NonNull
    public final Context requireContext() {
        Context context = getContext();
        if (context != null) {
            return context;
        }
        throw new IllegalStateException("Fragment " + this + " not attached to a context.");
    }

    @NonNull
    public final FragmentManager requireFragmentManager() {
        FragmentManager fragmentManager = getFragmentManager();
        if (fragmentManager != null) {
            return fragmentManager;
        }
        throw new IllegalStateException("Fragment " + this + " not associated with a fragment manager.");
    }

    @NonNull
    public final Object requireHost() {
        Object host = getHost();
        if (host != null) {
            return host;
        }
        throw new IllegalStateException("Fragment " + this + " not attached to a host.");
    }

    @NonNull
    public final Fragment requireParentFragment() {
        Fragment parentFragment = getParentFragment();
        if (parentFragment != null) {
            return parentFragment;
        }
        if (getContext() == null) {
            throw new IllegalStateException("Fragment " + this + " is not attached to any Fragment or host");
        }
        throw new IllegalStateException("Fragment " + this + " is not a child Fragment, it is directly attached to " + getContext());
    }

    @NonNull
    public final View requireView() {
        View view = getView();
        if (view != null) {
            return view;
        }
        throw new IllegalStateException("Fragment " + this + " did not return a View from onCreateView() or this was called before onCreateView().");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void s() {
        onLowMemory();
        this.t.dispatchLowMemory();
    }

    public void setAllowEnterTransitionOverlap(boolean z) {
        ensureAnimationInfo().n = Boolean.valueOf(z);
    }

    public void setAllowReturnTransitionOverlap(boolean z) {
        ensureAnimationInfo().m = Boolean.valueOf(z);
    }

    public void setArguments(@Nullable Bundle bundle) {
        if (this.r != null && isStateSaved()) {
            throw new IllegalStateException("Fragment already added and state has been saved");
        }
        this.g = bundle;
    }

    public void setEnterSharedElementCallback(@Nullable SharedElementCallback sharedElementCallback) {
        ensureAnimationInfo().o = sharedElementCallback;
    }

    public void setEnterTransition(@Nullable Object obj) {
        ensureAnimationInfo().g = obj;
    }

    public void setExitSharedElementCallback(@Nullable SharedElementCallback sharedElementCallback) {
        ensureAnimationInfo().p = sharedElementCallback;
    }

    public void setExitTransition(@Nullable Object obj) {
        ensureAnimationInfo().i = obj;
    }

    public void setHasOptionsMenu(boolean z) {
        if (this.D != z) {
            this.D = z;
            if (!isAdded() || isHidden()) {
                return;
            }
            this.s.onSupportInvalidateOptionsMenu();
        }
    }

    public void setInitialSavedState(@Nullable SavedState savedState) {
        Bundle bundle;
        if (this.r != null) {
            throw new IllegalStateException("Fragment already added");
        }
        if (savedState == null || (bundle = savedState.a) == null) {
            bundle = null;
        }
        this.c = bundle;
    }

    public void setMenuVisibility(boolean z) {
        if (this.E != z) {
            this.E = z;
            if (this.D && isAdded() && !isHidden()) {
                this.s.onSupportInvalidateOptionsMenu();
            }
        }
    }

    public void setReenterTransition(@Nullable Object obj) {
        ensureAnimationInfo().j = obj;
    }

    public void setRetainInstance(boolean z) {
        this.B = z;
        FragmentManagerImpl fragmentManagerImpl = this.r;
        if (fragmentManagerImpl == null) {
            this.C = true;
        } else if (z) {
            fragmentManagerImpl.a(this);
        } else {
            fragmentManagerImpl.k(this);
        }
    }

    public void setReturnTransition(@Nullable Object obj) {
        ensureAnimationInfo().h = obj;
    }

    public void setSharedElementEnterTransition(@Nullable Object obj) {
        ensureAnimationInfo().k = obj;
    }

    public void setSharedElementReturnTransition(@Nullable Object obj) {
        ensureAnimationInfo().l = obj;
    }

    public void setTargetFragment(@Nullable Fragment fragment, int i) {
        FragmentManager fragmentManager = getFragmentManager();
        FragmentManager fragmentManager2 = fragment != null ? fragment.getFragmentManager() : null;
        if (fragmentManager != null && fragmentManager2 != null && fragmentManager != fragmentManager2) {
            throw new IllegalArgumentException("Fragment " + fragment + " must share the same FragmentManager to be set as a target fragment");
        }
        for (Fragment fragment2 = fragment; fragment2 != null; fragment2 = fragment2.getTargetFragment()) {
            if (fragment2 == this) {
                throw new IllegalArgumentException("Setting " + fragment + " as the target of " + this + " would create a target cycle");
            }
        }
        if (fragment == null) {
            this.i = null;
        } else {
            if (this.r == null || fragment.r == null) {
                this.i = null;
                this.h = fragment;
                this.j = i;
            }
            this.i = fragment.f;
        }
        this.h = null;
        this.j = i;
    }

    @Deprecated
    public void setUserVisibleHint(boolean z) {
        if (!this.J && z && this.b < 3 && this.r != null && isAdded() && this.Q) {
            this.r.performPendingDeferredStart(this);
        }
        this.J = z;
        this.I = this.b < 3 && !z;
        if (this.c != null) {
            this.e = Boolean.valueOf(z);
        }
    }

    public boolean shouldShowRequestPermissionRationale(@NonNull String str) {
        FragmentHostCallback fragmentHostCallback = this.s;
        if (fragmentHostCallback != null) {
            return fragmentHostCallback.onShouldShowRequestPermissionRationale(str);
        }
        return false;
    }

    public void startActivity(@SuppressLint({"UnknownNullness"}) Intent intent) {
        startActivity(intent, null);
    }

    public void startActivity(@SuppressLint({"UnknownNullness"}) Intent intent, @Nullable Bundle bundle) {
        FragmentHostCallback fragmentHostCallback = this.s;
        if (fragmentHostCallback != null) {
            fragmentHostCallback.onStartActivityFromFragment(this, intent, -1, bundle);
            return;
        }
        throw new IllegalStateException("Fragment " + this + " not attached to Activity");
    }

    public void startActivityForResult(@SuppressLint({"UnknownNullness"}) Intent intent, int i) {
        startActivityForResult(intent, i, null);
    }

    public void startActivityForResult(@SuppressLint({"UnknownNullness"}) Intent intent, int i, @Nullable Bundle bundle) {
        FragmentHostCallback fragmentHostCallback = this.s;
        if (fragmentHostCallback != null) {
            fragmentHostCallback.onStartActivityFromFragment(this, intent, i, bundle);
            return;
        }
        throw new IllegalStateException("Fragment " + this + " not attached to Activity");
    }

    public void startIntentSenderForResult(@SuppressLint({"UnknownNullness"}) IntentSender intentSender, int i, @Nullable Intent intent, int i2, int i3, int i4, @Nullable Bundle bundle) {
        FragmentHostCallback fragmentHostCallback = this.s;
        if (fragmentHostCallback != null) {
            fragmentHostCallback.onStartIntentSenderFromFragment(this, intentSender, i, intent, i2, i3, i4, bundle);
            return;
        }
        throw new IllegalStateException("Fragment " + this + " not attached to Activity");
    }

    public void startPostponedEnterTransition() {
        FragmentManagerImpl fragmentManagerImpl = this.r;
        if (fragmentManagerImpl == null || fragmentManagerImpl.m == null) {
            ensureAnimationInfo().q = false;
        } else if (Looper.myLooper() != this.r.m.c().getLooper()) {
            this.r.m.c().postAtFrontOfQueue(new Runnable() { // from class: androidx.fragment.app.Fragment.3
                @Override // java.lang.Runnable
                public void run() {
                    Fragment.this.a();
                }
            });
        } else {
            a();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void t() {
        this.t.dispatchPause();
        if (this.G != null) {
            this.T.a(Lifecycle.Event.ON_PAUSE);
        }
        this.S.handleLifecycleEvent(Lifecycle.Event.ON_PAUSE);
        this.b = 3;
        this.mCalled = false;
        onPause();
        if (this.mCalled) {
            return;
        }
        throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onPause()");
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        DebugUtils.buildShortClassTag(this, sb);
        sb.append(" (");
        sb.append(this.f);
        sb.append(")");
        if (this.w != 0) {
            sb.append(" id=0x");
            sb.append(Integer.toHexString(this.w));
        }
        if (this.y != null) {
            sb.append(" ");
            sb.append(this.y);
        }
        sb.append('}');
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void u() {
        boolean f = this.r.f(this);
        Boolean bool = this.mIsPrimaryNavigationFragment;
        if (bool == null || bool.booleanValue() != f) {
            this.mIsPrimaryNavigationFragment = Boolean.valueOf(f);
            onPrimaryNavigationFragmentChanged(f);
            this.t.b();
        }
    }

    public void unregisterForContextMenu(@NonNull View view) {
        view.setOnCreateContextMenuListener(null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void v() {
        this.t.noteStateNotSaved();
        this.t.execPendingActions();
        this.b = 4;
        this.mCalled = false;
        onResume();
        if (!this.mCalled) {
            throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onResume()");
        }
        this.S.handleLifecycleEvent(Lifecycle.Event.ON_RESUME);
        if (this.G != null) {
            this.T.a(Lifecycle.Event.ON_RESUME);
        }
        this.t.dispatchResume();
        this.t.execPendingActions();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void w() {
        this.t.noteStateNotSaved();
        this.t.execPendingActions();
        this.b = 3;
        this.mCalled = false;
        onStart();
        if (this.mCalled) {
            this.S.handleLifecycleEvent(Lifecycle.Event.ON_START);
            if (this.G != null) {
                this.T.a(Lifecycle.Event.ON_START);
            }
            this.t.dispatchStart();
            return;
        }
        throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onStart()");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void x() {
        this.t.dispatchStop();
        if (this.G != null) {
            this.T.a(Lifecycle.Event.ON_STOP);
        }
        this.S.handleLifecycleEvent(Lifecycle.Event.ON_STOP);
        this.b = 2;
        this.mCalled = false;
        onStop();
        if (this.mCalled) {
            return;
        }
        throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onStop()");
    }
}
