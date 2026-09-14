package androidx.fragment.app;

import F0.AbstractC0008a;
import android.animation.Animator;
import android.app.Activity;
import android.app.Application;
import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.IntentSender;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcelable;
import android.util.AndroidRuntimeException;
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
import androidx.fragment.app.strictmode.Violation;
import androidx.lifecycle.AbstractC0305o;
import androidx.lifecycle.C0311v;
import androidx.lifecycle.EnumC0303m;
import androidx.lifecycle.EnumC0304n;
import androidx.lifecycle.InterfaceC0299i;
import androidx.lifecycle.InterfaceC0309t;
import com.uh.sf.R;
import d0.AbstractC0356b;
import d0.C0357c;
import f.AbstractC0365a;
import f0.AbstractC0373b;
import f0.C0374c;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Objects;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import l0.C0514d;
import l0.C0515e;
import l0.InterfaceC0516f;
import org.apache.tika.metadata.TikaCoreProperties;
import t.C0695k;
import w.AbstractC0744b;

/* loaded from: classes.dex */
public abstract class G implements ComponentCallbacks, View.OnCreateContextMenuListener, InterfaceC0309t, androidx.lifecycle.a0, InterfaceC0299i, InterfaceC0516f {
    static final int ACTIVITY_CREATED = 4;
    static final int ATTACHED = 0;
    static final int AWAITING_ENTER_EFFECTS = 6;
    static final int AWAITING_EXIT_EFFECTS = 3;
    static final int CREATED = 1;
    static final int INITIALIZING = -1;
    static final int RESUMED = 7;
    static final int STARTED = 5;
    static final Object USE_DEFAULT_TRANSITION = new Object();
    static final int VIEW_CREATED = 2;
    boolean mAdded;
    D mAnimationInfo;
    Bundle mArguments;
    int mBackStackNesting;
    boolean mBeingSaved;
    private boolean mCalled;
    ViewGroup mContainer;
    int mContainerId;
    private int mContentLayoutId;
    androidx.lifecycle.X mDefaultFactory;
    boolean mDeferStart;
    boolean mDetached;
    int mFragmentId;
    AbstractC0272g0 mFragmentManager;
    boolean mFromLayout;
    boolean mHasMenu;
    boolean mHidden;
    boolean mHiddenChanged;
    S mHost;
    boolean mInDynamicContainer;
    boolean mInLayout;
    boolean mIsCreated;
    LayoutInflater mLayoutInflater;
    C0311v mLifecycleRegistry;
    G mParentFragment;
    boolean mPerformedCreateView;
    Handler mPostponedHandler;
    public String mPreviousWho;
    boolean mRemoving;
    boolean mRestored;
    boolean mRetainInstance;
    boolean mRetainInstanceChangedWhileDetached;
    Bundle mSavedFragmentState;
    C0515e mSavedStateRegistryController;
    Boolean mSavedUserVisibleHint;
    Bundle mSavedViewRegistryState;
    SparseArray<Parcelable> mSavedViewState;
    String mTag;
    G mTarget;
    int mTargetRequestCode;
    boolean mTransitioning;
    View mView;
    A0 mViewLifecycleOwner;
    int mState = -1;
    String mWho = UUID.randomUUID().toString();
    String mTargetWho = null;
    private Boolean mIsPrimaryNavigationFragment = null;
    AbstractC0272g0 mChildFragmentManager = new AbstractC0272g0();
    boolean mMenuVisible = true;
    boolean mUserVisibleHint = true;
    Runnable mPostponedDurationRunnable = new RunnableC0288x(this, 0);
    EnumC0304n mMaxState = EnumC0304n.f3611e;
    androidx.lifecycle.B mViewLifecycleOwnerLiveData = new androidx.lifecycle.A();
    private final AtomicInteger mNextLocalRequestCode = new AtomicInteger();
    private final ArrayList<E> mOnPreAttachedListeners = new ArrayList<>();
    private final E mSavedStateAttachListener = new C0289y(this);

    /* JADX WARN: Type inference failed for: r0v8, types: [androidx.lifecycle.B, androidx.lifecycle.A] */
    public G() {
        d();
    }

    @Deprecated
    public static G instantiate(Context context, String str) {
        return instantiate(context, str, null);
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [androidx.fragment.app.D, java.lang.Object] */
    public final D a() {
        if (this.mAnimationInfo == null) {
            ?? obj = new Object();
            obj.i = null;
            Object obj2 = USE_DEFAULT_TRANSITION;
            obj.f3278j = obj2;
            obj.f3279k = null;
            obj.f3280l = obj2;
            obj.f3281m = null;
            obj.f3282n = obj2;
            obj.f3284q = 1.0f;
            obj.f3285r = null;
            this.mAnimationInfo = obj;
        }
        return this.mAnimationInfo;
    }

    public final int b() {
        EnumC0304n enumC0304n = this.mMaxState;
        if (enumC0304n != EnumC0304n.f3608b && this.mParentFragment != null) {
            return Math.min(enumC0304n.ordinal(), this.mParentFragment.b());
        }
        return enumC0304n.ordinal();
    }

    public final G c(boolean z3) {
        String str;
        if (z3) {
            a0.b bVar = a0.c.f2749a;
            a0.c.b(new Violation(this, "Attempting to get target fragment from fragment " + this));
            a0.c.a(this).getClass();
        }
        G g3 = this.mTarget;
        if (g3 != null) {
            return g3;
        }
        AbstractC0272g0 abstractC0272g0 = this.mFragmentManager;
        if (abstractC0272g0 != null && (str = this.mTargetWho) != null) {
            return abstractC0272g0.f3391c.b(str);
        }
        return null;
    }

    public void callStartTransitionListener(boolean z3) {
        ViewGroup viewGroup;
        AbstractC0272g0 abstractC0272g0;
        D d2 = this.mAnimationInfo;
        if (d2 != null) {
            d2.f3286s = false;
        }
        if (this.mView != null && (viewGroup = this.mContainer) != null && (abstractC0272g0 = this.mFragmentManager) != null) {
            C0281p j2 = C0281p.j(viewGroup, abstractC0272g0);
            j2.l();
            if (z3) {
                this.mHost.f3322c.post(new RunnableC0282q(j2, 1));
            } else {
                j2.e();
            }
            Handler handler = this.mPostponedHandler;
            if (handler != null) {
                handler.removeCallbacks(this.mPostponedDurationRunnable);
                this.mPostponedHandler = null;
            }
        }
    }

    public O createFragmentContainer() {
        return new C0290z(this);
    }

    public final void d() {
        this.mLifecycleRegistry = new C0311v(this);
        this.mSavedStateRegistryController = new C0515e(this);
        this.mDefaultFactory = null;
        if (!this.mOnPreAttachedListeners.contains(this.mSavedStateAttachListener)) {
            E e4 = this.mSavedStateAttachListener;
            if (this.mState >= 0) {
                e4.a();
            } else {
                this.mOnPreAttachedListeners.add(e4);
            }
        }
    }

    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        printWriter.print(str);
        printWriter.print("mFragmentId=#");
        printWriter.print(Integer.toHexString(this.mFragmentId));
        printWriter.print(" mContainerId=#");
        printWriter.print(Integer.toHexString(this.mContainerId));
        printWriter.print(" mTag=");
        printWriter.println(this.mTag);
        printWriter.print(str);
        printWriter.print("mState=");
        printWriter.print(this.mState);
        printWriter.print(" mWho=");
        printWriter.print(this.mWho);
        printWriter.print(" mBackStackNesting=");
        printWriter.println(this.mBackStackNesting);
        printWriter.print(str);
        printWriter.print("mAdded=");
        printWriter.print(this.mAdded);
        printWriter.print(" mRemoving=");
        printWriter.print(this.mRemoving);
        printWriter.print(" mFromLayout=");
        printWriter.print(this.mFromLayout);
        printWriter.print(" mInLayout=");
        printWriter.println(this.mInLayout);
        printWriter.print(str);
        printWriter.print("mHidden=");
        printWriter.print(this.mHidden);
        printWriter.print(" mDetached=");
        printWriter.print(this.mDetached);
        printWriter.print(" mMenuVisible=");
        printWriter.print(this.mMenuVisible);
        printWriter.print(" mHasMenu=");
        printWriter.println(this.mHasMenu);
        printWriter.print(str);
        printWriter.print("mRetainInstance=");
        printWriter.print(this.mRetainInstance);
        printWriter.print(" mUserVisibleHint=");
        printWriter.println(this.mUserVisibleHint);
        if (this.mFragmentManager != null) {
            printWriter.print(str);
            printWriter.print("mFragmentManager=");
            printWriter.println(this.mFragmentManager);
        }
        if (this.mHost != null) {
            printWriter.print(str);
            printWriter.print("mHost=");
            printWriter.println(this.mHost);
        }
        if (this.mParentFragment != null) {
            printWriter.print(str);
            printWriter.print("mParentFragment=");
            printWriter.println(this.mParentFragment);
        }
        if (this.mArguments != null) {
            printWriter.print(str);
            printWriter.print("mArguments=");
            printWriter.println(this.mArguments);
        }
        if (this.mSavedFragmentState != null) {
            printWriter.print(str);
            printWriter.print("mSavedFragmentState=");
            printWriter.println(this.mSavedFragmentState);
        }
        if (this.mSavedViewState != null) {
            printWriter.print(str);
            printWriter.print("mSavedViewState=");
            printWriter.println(this.mSavedViewState);
        }
        if (this.mSavedViewRegistryState != null) {
            printWriter.print(str);
            printWriter.print("mSavedViewRegistryState=");
            printWriter.println(this.mSavedViewRegistryState);
        }
        G c4 = c(false);
        if (c4 != null) {
            printWriter.print(str);
            printWriter.print("mTarget=");
            printWriter.print(c4);
            printWriter.print(" mTargetRequestCode=");
            printWriter.println(this.mTargetRequestCode);
        }
        printWriter.print(str);
        printWriter.print("mPopDirection=");
        printWriter.println(getPopDirection());
        if (getEnterAnim() != 0) {
            printWriter.print(str);
            printWriter.print("getEnterAnim=");
            printWriter.println(getEnterAnim());
        }
        if (getExitAnim() != 0) {
            printWriter.print(str);
            printWriter.print("getExitAnim=");
            printWriter.println(getExitAnim());
        }
        if (getPopEnterAnim() != 0) {
            printWriter.print(str);
            printWriter.print("getPopEnterAnim=");
            printWriter.println(getPopEnterAnim());
        }
        if (getPopExitAnim() != 0) {
            printWriter.print(str);
            printWriter.print("getPopExitAnim=");
            printWriter.println(getPopExitAnim());
        }
        if (this.mContainer != null) {
            printWriter.print(str);
            printWriter.print("mContainer=");
            printWriter.println(this.mContainer);
        }
        if (this.mView != null) {
            printWriter.print(str);
            printWriter.print("mView=");
            printWriter.println(this.mView);
        }
        if (getAnimatingAway() != null) {
            printWriter.print(str);
            printWriter.print("mAnimatingAway=");
            printWriter.println(getAnimatingAway());
        }
        if (getContext() != null) {
            AbstractC0373b.a(this).b(str, fileDescriptor, printWriter, strArr);
        }
        printWriter.print(str);
        printWriter.println("Child " + this.mChildFragmentManager + TikaCoreProperties.NAMESPACE_PREFIX_DELIMITER);
        this.mChildFragmentManager.v(AbstractC0008a.n(str, "  "), fileDescriptor, printWriter, strArr);
    }

    public final C0287w e(AbstractC0365a abstractC0365a, B b4, e.b bVar) {
        if (this.mState <= 1) {
            AtomicReference atomicReference = new AtomicReference();
            C c4 = new C(this, b4, atomicReference, abstractC0365a, bVar);
            if (this.mState >= 0) {
                c4.a();
            } else {
                this.mOnPreAttachedListeners.add(c4);
            }
            return new C0287w(atomicReference);
        }
        throw new IllegalStateException(AbstractC0008a.m("Fragment ", this, " is attempting to registerForActivityResult after being created. Fragments must call registerForActivityResult() before they are created (i.e. initialization, onAttach(), or onCreate())."));
    }

    public final boolean equals(Object obj) {
        return super.equals(obj);
    }

    public G findFragmentByWho(String str) {
        if (str.equals(this.mWho)) {
            return this;
        }
        return this.mChildFragmentManager.f3391c.c(str);
    }

    public String generateActivityResultKey() {
        return "fragment_" + this.mWho + "_rq#" + this.mNextLocalRequestCode.getAndIncrement();
    }

    public final L getActivity() {
        S s3 = this.mHost;
        if (s3 == null) {
            return null;
        }
        return s3.f3320a;
    }

    public boolean getAllowEnterTransitionOverlap() {
        Boolean bool;
        D d2 = this.mAnimationInfo;
        if (d2 != null && (bool = d2.p) != null) {
            return bool.booleanValue();
        }
        return true;
    }

    public boolean getAllowReturnTransitionOverlap() {
        Boolean bool;
        D d2 = this.mAnimationInfo;
        if (d2 != null && (bool = d2.f3283o) != null) {
            return bool.booleanValue();
        }
        return true;
    }

    public View getAnimatingAway() {
        D d2 = this.mAnimationInfo;
        if (d2 == null) {
            return null;
        }
        d2.getClass();
        return null;
    }

    public final Bundle getArguments() {
        return this.mArguments;
    }

    public final AbstractC0272g0 getChildFragmentManager() {
        if (this.mHost != null) {
            return this.mChildFragmentManager;
        }
        throw new IllegalStateException(AbstractC0008a.m("Fragment ", this, " has not been attached yet."));
    }

    public Context getContext() {
        S s3 = this.mHost;
        if (s3 == null) {
            return null;
        }
        return s3.f3321b;
    }

    @Override // androidx.lifecycle.InterfaceC0299i
    public AbstractC0356b getDefaultViewModelCreationExtras() {
        Application application;
        Context applicationContext = requireContext().getApplicationContext();
        while (true) {
            if (applicationContext instanceof ContextWrapper) {
                if (applicationContext instanceof Application) {
                    application = (Application) applicationContext;
                    break;
                }
                applicationContext = ((ContextWrapper) applicationContext).getBaseContext();
            } else {
                application = null;
                break;
            }
        }
        if (application == null && AbstractC0272g0.J(3)) {
            Objects.toString(requireContext().getApplicationContext());
        }
        C0357c c0357c = new C0357c(0);
        LinkedHashMap linkedHashMap = c0357c.f4412a;
        if (application != null) {
            linkedHashMap.put(androidx.lifecycle.W.f3591d, application);
        }
        linkedHashMap.put(androidx.lifecycle.P.f3574a, this);
        linkedHashMap.put(androidx.lifecycle.P.f3575b, this);
        if (getArguments() != null) {
            linkedHashMap.put(androidx.lifecycle.P.f3576c, getArguments());
        }
        return c0357c;
    }

    @Override // androidx.lifecycle.InterfaceC0299i
    public androidx.lifecycle.X getDefaultViewModelProviderFactory() {
        Application application;
        if (this.mFragmentManager != null) {
            if (this.mDefaultFactory == null) {
                Context applicationContext = requireContext().getApplicationContext();
                while (true) {
                    if (applicationContext instanceof ContextWrapper) {
                        if (applicationContext instanceof Application) {
                            application = (Application) applicationContext;
                            break;
                        }
                        applicationContext = ((ContextWrapper) applicationContext).getBaseContext();
                    } else {
                        application = null;
                        break;
                    }
                }
                if (application == null && AbstractC0272g0.J(3)) {
                    Objects.toString(requireContext().getApplicationContext());
                }
                this.mDefaultFactory = new androidx.lifecycle.T(application, this, getArguments());
            }
            return this.mDefaultFactory;
        }
        throw new IllegalStateException("Can't access ViewModels from detached fragment");
    }

    public int getEnterAnim() {
        D d2 = this.mAnimationInfo;
        if (d2 == null) {
            return 0;
        }
        return d2.f3271b;
    }

    public Object getEnterTransition() {
        D d2 = this.mAnimationInfo;
        if (d2 == null) {
            return null;
        }
        return d2.i;
    }

    public w.t getEnterTransitionCallback() {
        D d2 = this.mAnimationInfo;
        if (d2 == null) {
            return null;
        }
        d2.getClass();
        return null;
    }

    public int getExitAnim() {
        D d2 = this.mAnimationInfo;
        if (d2 == null) {
            return 0;
        }
        return d2.f3272c;
    }

    public Object getExitTransition() {
        D d2 = this.mAnimationInfo;
        if (d2 == null) {
            return null;
        }
        return d2.f3279k;
    }

    public w.t getExitTransitionCallback() {
        D d2 = this.mAnimationInfo;
        if (d2 == null) {
            return null;
        }
        d2.getClass();
        return null;
    }

    public View getFocusedView() {
        D d2 = this.mAnimationInfo;
        if (d2 == null) {
            return null;
        }
        return d2.f3285r;
    }

    @Deprecated
    public final AbstractC0272g0 getFragmentManager() {
        return this.mFragmentManager;
    }

    public final Object getHost() {
        S s3 = this.mHost;
        if (s3 == null) {
            return null;
        }
        return ((K) s3).f3307e;
    }

    public final int getId() {
        return this.mFragmentId;
    }

    public final LayoutInflater getLayoutInflater() {
        LayoutInflater layoutInflater = this.mLayoutInflater;
        return layoutInflater == null ? performGetLayoutInflater(null) : layoutInflater;
    }

    @Override // androidx.lifecycle.InterfaceC0309t
    public AbstractC0305o getLifecycle() {
        return this.mLifecycleRegistry;
    }

    @Deprecated
    public AbstractC0373b getLoaderManager() {
        return AbstractC0373b.a(this);
    }

    public int getNextTransition() {
        D d2 = this.mAnimationInfo;
        if (d2 == null) {
            return 0;
        }
        return d2.f3275f;
    }

    public final G getParentFragment() {
        return this.mParentFragment;
    }

    public final AbstractC0272g0 getParentFragmentManager() {
        AbstractC0272g0 abstractC0272g0 = this.mFragmentManager;
        if (abstractC0272g0 != null) {
            return abstractC0272g0;
        }
        throw new IllegalStateException(AbstractC0008a.m("Fragment ", this, " not associated with a fragment manager."));
    }

    public boolean getPopDirection() {
        D d2 = this.mAnimationInfo;
        if (d2 == null) {
            return false;
        }
        return d2.f3270a;
    }

    public int getPopEnterAnim() {
        D d2 = this.mAnimationInfo;
        if (d2 == null) {
            return 0;
        }
        return d2.f3273d;
    }

    public int getPopExitAnim() {
        D d2 = this.mAnimationInfo;
        if (d2 == null) {
            return 0;
        }
        return d2.f3274e;
    }

    public float getPostOnViewCreatedAlpha() {
        D d2 = this.mAnimationInfo;
        if (d2 == null) {
            return 1.0f;
        }
        return d2.f3284q;
    }

    public Object getReenterTransition() {
        D d2 = this.mAnimationInfo;
        if (d2 == null) {
            return null;
        }
        Object obj = d2.f3280l;
        if (obj == USE_DEFAULT_TRANSITION) {
            return getExitTransition();
        }
        return obj;
    }

    public final Resources getResources() {
        return requireContext().getResources();
    }

    @Deprecated
    public final boolean getRetainInstance() {
        a0.b bVar = a0.c.f2749a;
        a0.c.b(new Violation(this, "Attempting to get retain instance for fragment " + this));
        a0.c.a(this).getClass();
        return this.mRetainInstance;
    }

    public Object getReturnTransition() {
        D d2 = this.mAnimationInfo;
        if (d2 == null) {
            return null;
        }
        Object obj = d2.f3278j;
        if (obj == USE_DEFAULT_TRANSITION) {
            return getEnterTransition();
        }
        return obj;
    }

    @Override // l0.InterfaceC0516f
    public final C0514d getSavedStateRegistry() {
        return this.mSavedStateRegistryController.f5481b;
    }

    public Object getSharedElementEnterTransition() {
        D d2 = this.mAnimationInfo;
        if (d2 == null) {
            return null;
        }
        return d2.f3281m;
    }

    public Object getSharedElementReturnTransition() {
        D d2 = this.mAnimationInfo;
        if (d2 == null) {
            return null;
        }
        Object obj = d2.f3282n;
        if (obj == USE_DEFAULT_TRANSITION) {
            return getSharedElementEnterTransition();
        }
        return obj;
    }

    public ArrayList<String> getSharedElementSourceNames() {
        ArrayList<String> arrayList;
        D d2 = this.mAnimationInfo;
        if (d2 != null && (arrayList = d2.f3276g) != null) {
            return arrayList;
        }
        return new ArrayList<>();
    }

    public ArrayList<String> getSharedElementTargetNames() {
        ArrayList<String> arrayList;
        D d2 = this.mAnimationInfo;
        if (d2 != null && (arrayList = d2.f3277h) != null) {
            return arrayList;
        }
        return new ArrayList<>();
    }

    public final String getString(int i) {
        return getResources().getString(i);
    }

    public final String getTag() {
        return this.mTag;
    }

    @Deprecated
    public final G getTargetFragment() {
        return c(true);
    }

    @Deprecated
    public final int getTargetRequestCode() {
        a0.b bVar = a0.c.f2749a;
        a0.c.b(new Violation(this, "Attempting to get target request code from fragment " + this));
        a0.c.a(this).getClass();
        return this.mTargetRequestCode;
    }

    public final CharSequence getText(int i) {
        return getResources().getText(i);
    }

    @Deprecated
    public boolean getUserVisibleHint() {
        return this.mUserVisibleHint;
    }

    public View getView() {
        return this.mView;
    }

    public InterfaceC0309t getViewLifecycleOwner() {
        A0 a02 = this.mViewLifecycleOwner;
        if (a02 != null) {
            return a02;
        }
        throw new IllegalStateException(AbstractC0008a.m("Can't access the Fragment View's LifecycleOwner for ", this, " when getView() is null i.e., before onCreateView() or after onDestroyView()"));
    }

    public androidx.lifecycle.A getViewLifecycleOwnerLiveData() {
        return this.mViewLifecycleOwnerLiveData;
    }

    @Override // androidx.lifecycle.a0
    public androidx.lifecycle.Z getViewModelStore() {
        if (this.mFragmentManager != null) {
            if (b() != 1) {
                HashMap hashMap = this.mFragmentManager.f3387O.f3429d;
                androidx.lifecycle.Z z3 = (androidx.lifecycle.Z) hashMap.get(this.mWho);
                if (z3 == null) {
                    androidx.lifecycle.Z z4 = new androidx.lifecycle.Z();
                    hashMap.put(this.mWho, z4);
                    return z4;
                }
                return z3;
            }
            throw new IllegalStateException("Calling getViewModelStore() before a Fragment reaches onCreate() when using setMaxLifecycle(INITIALIZED) is not supported");
        }
        throw new IllegalStateException("Can't access ViewModels from detached fragment");
    }

    public final boolean hasOptionsMenu() {
        return this.mHasMenu;
    }

    public final int hashCode() {
        return super.hashCode();
    }

    public void initState() {
        d();
        this.mPreviousWho = this.mWho;
        this.mWho = UUID.randomUUID().toString();
        this.mAdded = false;
        this.mRemoving = false;
        this.mFromLayout = false;
        this.mInLayout = false;
        this.mRestored = false;
        this.mBackStackNesting = 0;
        this.mFragmentManager = null;
        this.mChildFragmentManager = new AbstractC0272g0();
        this.mHost = null;
        this.mFragmentId = 0;
        this.mContainerId = 0;
        this.mTag = null;
        this.mHidden = false;
        this.mDetached = false;
    }

    public final boolean isAdded() {
        if (this.mHost != null && this.mAdded) {
            return true;
        }
        return false;
    }

    public final boolean isDetached() {
        return this.mDetached;
    }

    public final boolean isHidden() {
        boolean isHidden;
        if (!this.mHidden) {
            AbstractC0272g0 abstractC0272g0 = this.mFragmentManager;
            if (abstractC0272g0 != null) {
                G g3 = this.mParentFragment;
                abstractC0272g0.getClass();
                if (g3 == null) {
                    isHidden = false;
                } else {
                    isHidden = g3.isHidden();
                }
                if (isHidden) {
                    return true;
                }
            }
            return false;
        }
        return true;
    }

    public final boolean isInBackStack() {
        if (this.mBackStackNesting > 0) {
            return true;
        }
        return false;
    }

    public final boolean isInLayout() {
        return this.mInLayout;
    }

    public final boolean isMenuVisible() {
        boolean isMenuVisible;
        if (this.mMenuVisible) {
            if (this.mFragmentManager != null) {
                G g3 = this.mParentFragment;
                if (g3 == null) {
                    isMenuVisible = true;
                } else {
                    isMenuVisible = g3.isMenuVisible();
                }
                if (!isMenuVisible) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    public boolean isPostponed() {
        D d2 = this.mAnimationInfo;
        if (d2 == null) {
            return false;
        }
        return d2.f3286s;
    }

    public final boolean isRemoving() {
        return this.mRemoving;
    }

    public final boolean isResumed() {
        if (this.mState >= 7) {
            return true;
        }
        return false;
    }

    public final boolean isStateSaved() {
        AbstractC0272g0 abstractC0272g0 = this.mFragmentManager;
        if (abstractC0272g0 == null) {
            return false;
        }
        return abstractC0272g0.N();
    }

    public final boolean isVisible() {
        View view;
        if (isAdded() && !isHidden() && (view = this.mView) != null && view.getWindowToken() != null && this.mView.getVisibility() == 0) {
            return true;
        }
        return false;
    }

    public void noteStateNotSaved() {
        this.mChildFragmentManager.P();
    }

    @Deprecated
    public void onActivityCreated(Bundle bundle) {
        this.mCalled = true;
    }

    @Deprecated
    public void onActivityResult(int i, int i3, Intent intent) {
        if (AbstractC0272g0.J(2)) {
            toString();
            Objects.toString(intent);
        }
    }

    public void onAttach(Context context) {
        this.mCalled = true;
        S s3 = this.mHost;
        L l3 = s3 == null ? null : s3.f3320a;
        if (l3 != null) {
            this.mCalled = false;
            onAttach((Activity) l3);
        }
    }

    @Deprecated
    public void onAttachFragment(G g3) {
    }

    @Override // android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        this.mCalled = true;
    }

    public boolean onContextItemSelected(MenuItem menuItem) {
        return false;
    }

    public void onCreate(Bundle bundle) {
        this.mCalled = true;
        restoreChildFragmentState();
        AbstractC0272g0 abstractC0272g0 = this.mChildFragmentManager;
        if (abstractC0272g0.f3408v >= 1) {
            return;
        }
        abstractC0272g0.f3380H = false;
        abstractC0272g0.f3381I = false;
        abstractC0272g0.f3387O.f3432g = false;
        abstractC0272g0.u(1);
    }

    public Animation onCreateAnimation(int i, boolean z3, int i3) {
        return null;
    }

    public Animator onCreateAnimator(int i, boolean z3, int i3) {
        return null;
    }

    @Override // android.view.View.OnCreateContextMenuListener
    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
        requireActivity().onCreateContextMenu(contextMenu, view, contextMenuInfo);
    }

    @Deprecated
    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int i = this.mContentLayoutId;
        if (i != 0) {
            return layoutInflater.inflate(i, viewGroup, false);
        }
        return null;
    }

    public void onDestroy() {
        this.mCalled = true;
    }

    @Deprecated
    public void onDestroyOptionsMenu() {
    }

    public void onDestroyView() {
        this.mCalled = true;
    }

    public void onDetach() {
        this.mCalled = true;
    }

    public LayoutInflater onGetLayoutInflater(Bundle bundle) {
        return getLayoutInflater(bundle);
    }

    public void onHiddenChanged(boolean z3) {
    }

    public void onInflate(Context context, AttributeSet attributeSet, Bundle bundle) {
        this.mCalled = true;
        S s3 = this.mHost;
        L l3 = s3 == null ? null : s3.f3320a;
        if (l3 != null) {
            this.mCalled = false;
            onInflate((Activity) l3, attributeSet, bundle);
        }
    }

    @Override // android.content.ComponentCallbacks
    public void onLowMemory() {
        this.mCalled = true;
    }

    public void onMultiWindowModeChanged(boolean z3) {
    }

    @Deprecated
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        return false;
    }

    @Deprecated
    public void onOptionsMenuClosed(Menu menu) {
    }

    public void onPause() {
        this.mCalled = true;
    }

    public void onPictureInPictureModeChanged(boolean z3) {
    }

    @Deprecated
    public void onPrepareOptionsMenu(Menu menu) {
    }

    public void onPrimaryNavigationFragmentChanged(boolean z3) {
    }

    @Deprecated
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
    }

    public void onResume() {
        this.mCalled = true;
    }

    public void onSaveInstanceState(Bundle bundle) {
    }

    public void onStart() {
        this.mCalled = true;
    }

    public void onStop() {
        this.mCalled = true;
    }

    public void onViewCreated(View view, Bundle bundle) {
    }

    public void onViewStateRestored(Bundle bundle) {
        this.mCalled = true;
    }

    public void performActivityCreated(Bundle bundle) {
        Bundle bundle2;
        this.mChildFragmentManager.P();
        this.mState = 3;
        this.mCalled = false;
        onActivityCreated(bundle);
        if (this.mCalled) {
            if (AbstractC0272g0.J(3)) {
                toString();
            }
            if (this.mView != null) {
                Bundle bundle3 = this.mSavedFragmentState;
                if (bundle3 != null) {
                    bundle2 = bundle3.getBundle("savedInstanceState");
                } else {
                    bundle2 = null;
                }
                restoreViewState(bundle2);
            }
            this.mSavedFragmentState = null;
            AbstractC0272g0 abstractC0272g0 = this.mChildFragmentManager;
            abstractC0272g0.f3380H = false;
            abstractC0272g0.f3381I = false;
            abstractC0272g0.f3387O.f3432g = false;
            abstractC0272g0.u(4);
            return;
        }
        throw new AndroidRuntimeException(AbstractC0008a.m("Fragment ", this, " did not call through to super.onActivityCreated()"));
    }

    public void performAttach() {
        ArrayList<E> arrayList = this.mOnPreAttachedListeners;
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            E e4 = arrayList.get(i);
            i++;
            e4.a();
        }
        this.mOnPreAttachedListeners.clear();
        this.mChildFragmentManager.b(this.mHost, createFragmentContainer(), this);
        this.mState = 0;
        this.mCalled = false;
        onAttach((Context) this.mHost.f3321b);
        if (this.mCalled) {
            Iterator it = this.mFragmentManager.p.iterator();
            while (it.hasNext()) {
                ((l0) it.next()).a(this);
            }
            AbstractC0272g0 abstractC0272g0 = this.mChildFragmentManager;
            abstractC0272g0.f3380H = false;
            abstractC0272g0.f3381I = false;
            abstractC0272g0.f3387O.f3432g = false;
            abstractC0272g0.u(0);
            return;
        }
        throw new AndroidRuntimeException(AbstractC0008a.m("Fragment ", this, " did not call through to super.onAttach()"));
    }

    public void performConfigurationChanged(Configuration configuration) {
        onConfigurationChanged(configuration);
    }

    public boolean performContextItemSelected(MenuItem menuItem) {
        if (!this.mHidden) {
            if (onContextItemSelected(menuItem)) {
                return true;
            }
            return this.mChildFragmentManager.j(menuItem);
        }
        return false;
    }

    public void performCreate(Bundle bundle) {
        this.mChildFragmentManager.P();
        this.mState = 1;
        this.mCalled = false;
        this.mLifecycleRegistry.a(new A(this));
        onCreate(bundle);
        this.mIsCreated = true;
        if (this.mCalled) {
            this.mLifecycleRegistry.e(EnumC0303m.ON_CREATE);
            return;
        }
        throw new AndroidRuntimeException(AbstractC0008a.m("Fragment ", this, " did not call through to super.onCreate()"));
    }

    public boolean performCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        boolean z3 = false;
        if (this.mHidden) {
            return false;
        }
        if (this.mHasMenu && this.mMenuVisible) {
            onCreateOptionsMenu(menu, menuInflater);
            z3 = true;
        }
        return this.mChildFragmentManager.k(menu, menuInflater) | z3;
    }

    public void performCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mChildFragmentManager.P();
        this.mPerformedCreateView = true;
        this.mViewLifecycleOwner = new A0(this, getViewModelStore(), new RunnableC0286v(this, 0));
        View onCreateView = onCreateView(layoutInflater, viewGroup, bundle);
        this.mView = onCreateView;
        if (onCreateView != null) {
            this.mViewLifecycleOwner.b();
            if (AbstractC0272g0.J(3)) {
                Objects.toString(this.mView);
                toString();
            }
            androidx.lifecycle.P.f(this.mView, this.mViewLifecycleOwner);
            View view = this.mView;
            A0 a02 = this.mViewLifecycleOwner;
            kotlin.jvm.internal.j.e(view, "<this>");
            view.setTag(R.id.view_tree_view_model_store_owner, a02);
            T.b.H(this.mView, this.mViewLifecycleOwner);
            this.mViewLifecycleOwnerLiveData.h(this.mViewLifecycleOwner);
            return;
        }
        if (this.mViewLifecycleOwner.f3257e == null) {
            this.mViewLifecycleOwner = null;
            return;
        }
        throw new IllegalStateException("Called getViewLifecycleOwner() but onCreateView() returned null");
    }

    public void performDestroy() {
        this.mChildFragmentManager.l();
        this.mLifecycleRegistry.e(EnumC0303m.ON_DESTROY);
        this.mState = 0;
        this.mCalled = false;
        this.mIsCreated = false;
        onDestroy();
        if (this.mCalled) {
        } else {
            throw new AndroidRuntimeException(AbstractC0008a.m("Fragment ", this, " did not call through to super.onDestroy()"));
        }
    }

    public void performDestroyView() {
        this.mChildFragmentManager.u(1);
        if (this.mView != null) {
            A0 a02 = this.mViewLifecycleOwner;
            a02.b();
            if (a02.f3257e.f3618c.compareTo(EnumC0304n.f3609c) >= 0) {
                this.mViewLifecycleOwner.a(EnumC0303m.ON_DESTROY);
            }
        }
        this.mState = 1;
        this.mCalled = false;
        onDestroyView();
        if (this.mCalled) {
            C0695k c0695k = AbstractC0373b.a(this).f4489b.f4486b;
            int i = c0695k.f6369c;
            for (int i3 = 0; i3 < i; i3++) {
                ((C0374c) c0695k.f6368b[i3]).j();
            }
            this.mPerformedCreateView = false;
            return;
        }
        throw new AndroidRuntimeException(AbstractC0008a.m("Fragment ", this, " did not call through to super.onDestroyView()"));
    }

    public void performDetach() {
        this.mState = -1;
        this.mCalled = false;
        onDetach();
        this.mLayoutInflater = null;
        if (this.mCalled) {
            AbstractC0272g0 abstractC0272g0 = this.mChildFragmentManager;
            if (!abstractC0272g0.f3382J) {
                abstractC0272g0.l();
                this.mChildFragmentManager = new AbstractC0272g0();
                return;
            }
            return;
        }
        throw new AndroidRuntimeException(AbstractC0008a.m("Fragment ", this, " did not call through to super.onDetach()"));
    }

    public LayoutInflater performGetLayoutInflater(Bundle bundle) {
        LayoutInflater onGetLayoutInflater = onGetLayoutInflater(bundle);
        this.mLayoutInflater = onGetLayoutInflater;
        return onGetLayoutInflater;
    }

    public void performLowMemory() {
        onLowMemory();
    }

    public void performMultiWindowModeChanged(boolean z3) {
        onMultiWindowModeChanged(z3);
    }

    public boolean performOptionsItemSelected(MenuItem menuItem) {
        if (!this.mHidden) {
            if (this.mHasMenu && this.mMenuVisible && onOptionsItemSelected(menuItem)) {
                return true;
            }
            return this.mChildFragmentManager.p(menuItem);
        }
        return false;
    }

    public void performOptionsMenuClosed(Menu menu) {
        if (!this.mHidden) {
            if (this.mHasMenu && this.mMenuVisible) {
                onOptionsMenuClosed(menu);
            }
            this.mChildFragmentManager.q(menu);
        }
    }

    public void performPause() {
        this.mChildFragmentManager.u(5);
        if (this.mView != null) {
            this.mViewLifecycleOwner.a(EnumC0303m.ON_PAUSE);
        }
        this.mLifecycleRegistry.e(EnumC0303m.ON_PAUSE);
        this.mState = 6;
        this.mCalled = false;
        onPause();
        if (this.mCalled) {
        } else {
            throw new AndroidRuntimeException(AbstractC0008a.m("Fragment ", this, " did not call through to super.onPause()"));
        }
    }

    public void performPictureInPictureModeChanged(boolean z3) {
        onPictureInPictureModeChanged(z3);
    }

    public boolean performPrepareOptionsMenu(Menu menu) {
        boolean z3 = false;
        if (this.mHidden) {
            return false;
        }
        if (this.mHasMenu && this.mMenuVisible) {
            onPrepareOptionsMenu(menu);
            z3 = true;
        }
        return this.mChildFragmentManager.t(menu) | z3;
    }

    public void performPrimaryNavigationFragmentChanged() {
        this.mFragmentManager.getClass();
        boolean M3 = AbstractC0272g0.M(this);
        Boolean bool = this.mIsPrimaryNavigationFragment;
        if (bool != null && bool.booleanValue() == M3) {
            return;
        }
        this.mIsPrimaryNavigationFragment = Boolean.valueOf(M3);
        onPrimaryNavigationFragmentChanged(M3);
        AbstractC0272g0 abstractC0272g0 = this.mChildFragmentManager;
        abstractC0272g0.d0();
        abstractC0272g0.r(abstractC0272g0.f3411z);
    }

    public void performResume() {
        this.mChildFragmentManager.P();
        this.mChildFragmentManager.z(true);
        this.mState = 7;
        this.mCalled = false;
        onResume();
        if (this.mCalled) {
            C0311v c0311v = this.mLifecycleRegistry;
            EnumC0303m enumC0303m = EnumC0303m.ON_RESUME;
            c0311v.e(enumC0303m);
            if (this.mView != null) {
                this.mViewLifecycleOwner.f3257e.e(enumC0303m);
            }
            AbstractC0272g0 abstractC0272g0 = this.mChildFragmentManager;
            abstractC0272g0.f3380H = false;
            abstractC0272g0.f3381I = false;
            abstractC0272g0.f3387O.f3432g = false;
            abstractC0272g0.u(7);
            return;
        }
        throw new AndroidRuntimeException(AbstractC0008a.m("Fragment ", this, " did not call through to super.onResume()"));
    }

    public void performSaveInstanceState(Bundle bundle) {
        onSaveInstanceState(bundle);
    }

    public void performStart() {
        this.mChildFragmentManager.P();
        this.mChildFragmentManager.z(true);
        this.mState = 5;
        this.mCalled = false;
        onStart();
        if (this.mCalled) {
            C0311v c0311v = this.mLifecycleRegistry;
            EnumC0303m enumC0303m = EnumC0303m.ON_START;
            c0311v.e(enumC0303m);
            if (this.mView != null) {
                this.mViewLifecycleOwner.f3257e.e(enumC0303m);
            }
            AbstractC0272g0 abstractC0272g0 = this.mChildFragmentManager;
            abstractC0272g0.f3380H = false;
            abstractC0272g0.f3381I = false;
            abstractC0272g0.f3387O.f3432g = false;
            abstractC0272g0.u(5);
            return;
        }
        throw new AndroidRuntimeException(AbstractC0008a.m("Fragment ", this, " did not call through to super.onStart()"));
    }

    public void performStop() {
        AbstractC0272g0 abstractC0272g0 = this.mChildFragmentManager;
        abstractC0272g0.f3381I = true;
        abstractC0272g0.f3387O.f3432g = true;
        abstractC0272g0.u(4);
        if (this.mView != null) {
            this.mViewLifecycleOwner.a(EnumC0303m.ON_STOP);
        }
        this.mLifecycleRegistry.e(EnumC0303m.ON_STOP);
        this.mState = 4;
        this.mCalled = false;
        onStop();
        if (this.mCalled) {
        } else {
            throw new AndroidRuntimeException(AbstractC0008a.m("Fragment ", this, " did not call through to super.onStop()"));
        }
    }

    public void performViewCreated() {
        Bundle bundle;
        Bundle bundle2 = this.mSavedFragmentState;
        if (bundle2 != null) {
            bundle = bundle2.getBundle("savedInstanceState");
        } else {
            bundle = null;
        }
        onViewCreated(this.mView, bundle);
        this.mChildFragmentManager.u(2);
    }

    public void postponeEnterTransition() {
        a().f3286s = true;
    }

    public final <I, O> e.c registerForActivityResult(AbstractC0365a abstractC0365a, e.b bVar) {
        return e(abstractC0365a, new B(this, 0), bVar);
    }

    public void registerForContextMenu(View view) {
        view.setOnCreateContextMenuListener(this);
    }

    @Deprecated
    public final void requestPermissions(String[] permissions, int i) {
        if (this.mHost != null) {
            AbstractC0272g0 parentFragmentManager = getParentFragmentManager();
            if (parentFragmentManager.f3377E != null) {
                parentFragmentManager.f3378F.addLast(new C0264c0(this.mWho, i));
                parentFragmentManager.f3377E.a(permissions);
                return;
            } else {
                parentFragmentManager.f3409w.getClass();
                kotlin.jvm.internal.j.e(permissions, "permissions");
                return;
            }
        }
        throw new IllegalStateException(AbstractC0008a.m("Fragment ", this, " not attached to Activity"));
    }

    public final L requireActivity() {
        L activity = getActivity();
        if (activity != null) {
            return activity;
        }
        throw new IllegalStateException(AbstractC0008a.m("Fragment ", this, " not attached to an activity."));
    }

    public final Bundle requireArguments() {
        Bundle arguments = getArguments();
        if (arguments != null) {
            return arguments;
        }
        throw new IllegalStateException(AbstractC0008a.m("Fragment ", this, " does not have any arguments."));
    }

    public final Context requireContext() {
        Context context = getContext();
        if (context != null) {
            return context;
        }
        throw new IllegalStateException(AbstractC0008a.m("Fragment ", this, " not attached to a context."));
    }

    @Deprecated
    public final AbstractC0272g0 requireFragmentManager() {
        return getParentFragmentManager();
    }

    public final Object requireHost() {
        Object host = getHost();
        if (host != null) {
            return host;
        }
        throw new IllegalStateException(AbstractC0008a.m("Fragment ", this, " not attached to a host."));
    }

    public final G requireParentFragment() {
        G parentFragment = getParentFragment();
        if (parentFragment == null) {
            if (getContext() == null) {
                throw new IllegalStateException(AbstractC0008a.m("Fragment ", this, " is not attached to any Fragment or host"));
            }
            throw new IllegalStateException("Fragment " + this + " is not a child Fragment, it is directly attached to " + getContext());
        }
        return parentFragment;
    }

    public final View requireView() {
        View view = getView();
        if (view != null) {
            return view;
        }
        throw new IllegalStateException(AbstractC0008a.m("Fragment ", this, " did not return a View from onCreateView() or this was called before onCreateView()."));
    }

    public void restoreChildFragmentState() {
        Bundle bundle;
        Bundle bundle2 = this.mSavedFragmentState;
        if (bundle2 != null && (bundle = bundle2.getBundle("childFragmentManager")) != null) {
            this.mChildFragmentManager.V(bundle);
            AbstractC0272g0 abstractC0272g0 = this.mChildFragmentManager;
            abstractC0272g0.f3380H = false;
            abstractC0272g0.f3381I = false;
            abstractC0272g0.f3387O.f3432g = false;
            abstractC0272g0.u(1);
        }
    }

    public final void restoreViewState(Bundle bundle) {
        SparseArray<Parcelable> sparseArray = this.mSavedViewState;
        if (sparseArray != null) {
            this.mView.restoreHierarchyState(sparseArray);
            this.mSavedViewState = null;
        }
        this.mCalled = false;
        onViewStateRestored(bundle);
        if (this.mCalled) {
            if (this.mView != null) {
                this.mViewLifecycleOwner.a(EnumC0303m.ON_CREATE);
                return;
            }
            return;
        }
        throw new AndroidRuntimeException(AbstractC0008a.m("Fragment ", this, " did not call through to super.onViewStateRestored()"));
    }

    public void setAllowEnterTransitionOverlap(boolean z3) {
        a().p = Boolean.valueOf(z3);
    }

    public void setAllowReturnTransitionOverlap(boolean z3) {
        a().f3283o = Boolean.valueOf(z3);
    }

    public void setAnimations(int i, int i3, int i4, int i5) {
        if (this.mAnimationInfo == null && i == 0 && i3 == 0 && i4 == 0 && i5 == 0) {
            return;
        }
        a().f3271b = i;
        a().f3272c = i3;
        a().f3273d = i4;
        a().f3274e = i5;
    }

    public void setArguments(Bundle bundle) {
        if (this.mFragmentManager != null && isStateSaved()) {
            throw new IllegalStateException("Fragment already added and state has been saved");
        }
        this.mArguments = bundle;
    }

    public void setEnterSharedElementCallback(w.t tVar) {
        a().getClass();
    }

    public void setEnterTransition(Object obj) {
        a().i = obj;
    }

    public void setExitSharedElementCallback(w.t tVar) {
        a().getClass();
    }

    public void setExitTransition(Object obj) {
        a().f3279k = obj;
    }

    public void setFocusedView(View view) {
        a().f3285r = view;
    }

    @Deprecated
    public void setHasOptionsMenu(boolean z3) {
        if (this.mHasMenu != z3) {
            this.mHasMenu = z3;
            if (isAdded() && !isHidden()) {
                ((K) this.mHost).f3307e.invalidateMenu();
            }
        }
    }

    public void setInitialSavedState(F f4) {
        Bundle bundle;
        if (this.mFragmentManager == null) {
            if (f4 == null || (bundle = f4.f3300a) == null) {
                bundle = null;
            }
            this.mSavedFragmentState = bundle;
            return;
        }
        throw new IllegalStateException("Fragment already added");
    }

    public void setMenuVisibility(boolean z3) {
        if (this.mMenuVisible != z3) {
            this.mMenuVisible = z3;
            if (this.mHasMenu && isAdded() && !isHidden()) {
                ((K) this.mHost).f3307e.invalidateMenu();
            }
        }
    }

    public void setNextTransition(int i) {
        if (this.mAnimationInfo == null && i == 0) {
            return;
        }
        a();
        this.mAnimationInfo.f3275f = i;
    }

    public void setPopDirection(boolean z3) {
        if (this.mAnimationInfo == null) {
            return;
        }
        a().f3270a = z3;
    }

    public void setPostOnViewCreatedAlpha(float f4) {
        a().f3284q = f4;
    }

    public void setReenterTransition(Object obj) {
        a().f3280l = obj;
    }

    @Deprecated
    public void setRetainInstance(boolean z3) {
        a0.b bVar = a0.c.f2749a;
        a0.c.b(new Violation(this, "Attempting to set retain instance for fragment " + this));
        a0.c.a(this).getClass();
        this.mRetainInstance = z3;
        AbstractC0272g0 abstractC0272g0 = this.mFragmentManager;
        if (abstractC0272g0 != null) {
            if (z3) {
                abstractC0272g0.f3387O.c(this);
                return;
            } else {
                abstractC0272g0.f3387O.f(this);
                return;
            }
        }
        this.mRetainInstanceChangedWhileDetached = true;
    }

    public void setReturnTransition(Object obj) {
        a().f3278j = obj;
    }

    public void setSharedElementEnterTransition(Object obj) {
        a().f3281m = obj;
    }

    public void setSharedElementNames(ArrayList<String> arrayList, ArrayList<String> arrayList2) {
        a();
        D d2 = this.mAnimationInfo;
        d2.f3276g = arrayList;
        d2.f3277h = arrayList2;
    }

    public void setSharedElementReturnTransition(Object obj) {
        a().f3282n = obj;
    }

    @Deprecated
    public void setTargetFragment(G g3, int i) {
        AbstractC0272g0 abstractC0272g0;
        if (g3 != null) {
            a0.b bVar = a0.c.f2749a;
            a0.c.b(new Violation(this, "Attempting to set target fragment " + g3 + " with request code " + i + " for fragment " + this));
            a0.c.a(this).getClass();
        }
        AbstractC0272g0 abstractC0272g02 = this.mFragmentManager;
        if (g3 != null) {
            abstractC0272g0 = g3.mFragmentManager;
        } else {
            abstractC0272g0 = null;
        }
        if (abstractC0272g02 != null && abstractC0272g0 != null && abstractC0272g02 != abstractC0272g0) {
            throw new IllegalArgumentException(AbstractC0008a.m("Fragment ", g3, " must share the same FragmentManager to be set as a target fragment"));
        }
        for (G g4 = g3; g4 != null; g4 = g4.c(false)) {
            if (g4.equals(this)) {
                throw new IllegalArgumentException("Setting " + g3 + " as the target of " + this + " would create a target cycle");
            }
        }
        if (g3 == null) {
            this.mTargetWho = null;
            this.mTarget = null;
        } else if (this.mFragmentManager != null && g3.mFragmentManager != null) {
            this.mTargetWho = g3.mWho;
            this.mTarget = null;
        } else {
            this.mTargetWho = null;
            this.mTarget = g3;
        }
        this.mTargetRequestCode = i;
    }

    @Deprecated
    public void setUserVisibleHint(boolean z3) {
        a0.b bVar = a0.c.f2749a;
        a0.c.b(new Violation(this, "Attempting to set user visible hint to " + z3 + " for fragment " + this));
        a0.c.a(this).getClass();
        boolean z4 = false;
        if (!this.mUserVisibleHint && z3 && this.mState < 5 && this.mFragmentManager != null && isAdded() && this.mIsCreated) {
            AbstractC0272g0 abstractC0272g0 = this.mFragmentManager;
            o0 g3 = abstractC0272g0.g(this);
            G g4 = g3.f3473c;
            if (g4.mDeferStart) {
                if (abstractC0272g0.f3390b) {
                    abstractC0272g0.f3383K = true;
                } else {
                    g4.mDeferStart = false;
                    g3.i();
                }
            }
        }
        this.mUserVisibleHint = z3;
        if (this.mState < 5 && !z3) {
            z4 = true;
        }
        this.mDeferStart = z4;
        if (this.mSavedFragmentState != null) {
            this.mSavedUserVisibleHint = Boolean.valueOf(z3);
        }
    }

    public boolean shouldShowRequestPermissionRationale(String str) {
        S s3 = this.mHost;
        if (s3 != null) {
            return AbstractC0744b.e(str, ((K) s3).f3307e);
        }
        return false;
    }

    public void startActivity(Intent intent) {
        startActivity(intent, null);
    }

    @Deprecated
    public void startActivityForResult(Intent intent, int i) {
        startActivityForResult(intent, i, null);
    }

    @Deprecated
    public void startIntentSenderForResult(IntentSender intent, int i, Intent intent2, int i3, int i4, int i5, Bundle bundle) {
        if (this.mHost != null) {
            if (AbstractC0272g0.J(2)) {
                toString();
                Objects.toString(intent);
                Objects.toString(intent2);
                Objects.toString(bundle);
            }
            AbstractC0272g0 parentFragmentManager = getParentFragmentManager();
            if (parentFragmentManager.f3376D != null) {
                if (bundle != null) {
                    if (intent2 == null) {
                        intent2 = new Intent();
                        intent2.putExtra("androidx.fragment.extra.ACTIVITY_OPTIONS_BUNDLE", true);
                    }
                    if (AbstractC0272g0.J(2)) {
                        bundle.toString();
                        intent2.toString();
                        Objects.toString(this);
                    }
                    intent2.putExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE", bundle);
                }
                kotlin.jvm.internal.j.e(intent, "intentSender");
                e.j jVar = new e.j(intent, intent2, i3, i4);
                parentFragmentManager.f3378F.addLast(new C0264c0(this.mWho, i));
                if (AbstractC0272g0.J(2)) {
                    toString();
                }
                parentFragmentManager.f3376D.a(jVar);
                return;
            }
            S s3 = parentFragmentManager.f3409w;
            s3.getClass();
            kotlin.jvm.internal.j.e(intent, "intent");
            if (i == -1) {
                L l3 = s3.f3320a;
                if (l3 != null) {
                    l3.startIntentSenderForResult(intent, i, intent2, i3, i4, i5, bundle);
                    return;
                }
                throw new IllegalStateException("Starting intent sender with a requestCode requires a FragmentActivity host");
            }
            throw new IllegalStateException("Starting intent sender with a requestCode requires a FragmentActivity host");
        }
        throw new IllegalStateException(AbstractC0008a.m("Fragment ", this, " not attached to Activity"));
    }

    public void startPostponedEnterTransition() {
        if (this.mAnimationInfo != null && a().f3286s) {
            if (this.mHost == null) {
                a().f3286s = false;
            } else if (Looper.myLooper() != this.mHost.f3322c.getLooper()) {
                this.mHost.f3322c.postAtFrontOfQueue(new RunnableC0288x(this, 1));
            } else {
                callStartTransitionListener(true);
            }
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append(getClass().getSimpleName());
        sb.append("{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append("} (");
        sb.append(this.mWho);
        if (this.mFragmentId != 0) {
            sb.append(" id=0x");
            sb.append(Integer.toHexString(this.mFragmentId));
        }
        if (this.mTag != null) {
            sb.append(" tag=");
            sb.append(this.mTag);
        }
        sb.append(")");
        return sb.toString();
    }

    public void unregisterForContextMenu(View view) {
        view.setOnCreateContextMenuListener(null);
    }

    @Deprecated
    public static G instantiate(Context context, String str, Bundle bundle) {
        try {
            G g3 = (G) Z.b(str, context.getClassLoader()).getConstructor(null).newInstance(null);
            if (bundle == null) {
                return g3;
            }
            bundle.setClassLoader(g3.getClass().getClassLoader());
            g3.setArguments(bundle);
            return g3;
        } catch (IllegalAccessException e4) {
            throw new RuntimeException(e0.a.e("Unable to instantiate fragment ", str, ": make sure class name exists, is public, and has an empty constructor that is public"), e4);
        } catch (InstantiationException e5) {
            throw new RuntimeException(e0.a.e("Unable to instantiate fragment ", str, ": make sure class name exists, is public, and has an empty constructor that is public"), e5);
        } catch (NoSuchMethodException e6) {
            throw new RuntimeException(e0.a.e("Unable to instantiate fragment ", str, ": could not find Fragment constructor"), e6);
        } catch (InvocationTargetException e7) {
            throw new RuntimeException(e0.a.e("Unable to instantiate fragment ", str, ": calling Fragment constructor caused an exception"), e7);
        }
    }

    public final String getString(int i, Object... objArr) {
        return getResources().getString(i, objArr);
    }

    public final void postponeEnterTransition(long j2, TimeUnit timeUnit) {
        a().f3286s = true;
        Handler handler = this.mPostponedHandler;
        if (handler != null) {
            handler.removeCallbacks(this.mPostponedDurationRunnable);
        }
        AbstractC0272g0 abstractC0272g0 = this.mFragmentManager;
        if (abstractC0272g0 != null) {
            this.mPostponedHandler = abstractC0272g0.f3409w.f3322c;
        } else {
            this.mPostponedHandler = new Handler(Looper.getMainLooper());
        }
        this.mPostponedHandler.removeCallbacks(this.mPostponedDurationRunnable);
        this.mPostponedHandler.postDelayed(this.mPostponedDurationRunnable, timeUnit.toMillis(j2));
    }

    public final <I, O> e.c registerForActivityResult(AbstractC0365a abstractC0365a, e.h hVar, e.b bVar) {
        return e(abstractC0365a, new B(hVar, 2), bVar);
    }

    public void startActivity(Intent intent, Bundle bundle) {
        S s3 = this.mHost;
        if (s3 != null) {
            kotlin.jvm.internal.j.e(intent, "intent");
            s3.f3321b.startActivity(intent, bundle);
            return;
        }
        throw new IllegalStateException(AbstractC0008a.m("Fragment ", this, " not attached to Activity"));
    }

    @Deprecated
    public void startActivityForResult(Intent intent, int i, Bundle bundle) {
        if (this.mHost != null) {
            AbstractC0272g0 parentFragmentManager = getParentFragmentManager();
            if (parentFragmentManager.f3375C != null) {
                parentFragmentManager.f3378F.addLast(new C0264c0(this.mWho, i));
                if (bundle != null) {
                    intent.putExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE", bundle);
                }
                parentFragmentManager.f3375C.a(intent);
                return;
            }
            S s3 = parentFragmentManager.f3409w;
            s3.getClass();
            kotlin.jvm.internal.j.e(intent, "intent");
            if (i == -1) {
                s3.f3321b.startActivity(intent, bundle);
                return;
            }
            throw new IllegalStateException("Starting activity with a requestCode requires a FragmentActivity host");
        }
        throw new IllegalStateException(AbstractC0008a.m("Fragment ", this, " not attached to Activity"));
    }

    @Deprecated
    public LayoutInflater getLayoutInflater(Bundle bundle) {
        S s3 = this.mHost;
        if (s3 != null) {
            L l3 = ((K) s3).f3307e;
            LayoutInflater cloneInContext = l3.getLayoutInflater().cloneInContext(l3);
            cloneInContext.setFactory2(this.mChildFragmentManager.f3394f);
            return cloneInContext;
        }
        throw new IllegalStateException("onGetLayoutInflater() cannot be executed until the Fragment is attached to the FragmentManager.");
    }

    @Deprecated
    public void onAttach(Activity activity) {
        this.mCalled = true;
    }

    @Deprecated
    public void onInflate(Activity activity, AttributeSet attributeSet, Bundle bundle) {
        this.mCalled = true;
    }
}
