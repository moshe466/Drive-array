package androidx.fragment.app;

import F0.AbstractC0008a;
import android.content.res.Resources;
import android.os.BadParcelableException;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.fragment.app.strictmode.Violation;
import androidx.lifecycle.EnumC0304n;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import com.uh.sf.R;
import java.util.ArrayList;
import java.util.Objects;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public final class o0 {

    /* renamed from: a, reason: collision with root package name */
    public final M f3471a;

    /* renamed from: b, reason: collision with root package name */
    public final p0 f3472b;

    /* renamed from: c, reason: collision with root package name */
    public final G f3473c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f3474d = false;

    /* renamed from: e, reason: collision with root package name */
    public int f3475e = -1;

    public o0(M m4, p0 p0Var, G g3) {
        this.f3471a = m4;
        this.f3472b = p0Var;
        this.f3473c = g3;
    }

    public final void a() {
        G g3;
        View view;
        View view2;
        G g4;
        G g5 = this.f3473c;
        View view3 = g5.mContainer;
        while (true) {
            g3 = null;
            if (view3 == null) {
                break;
            }
            Object tag = view3.getTag(R.id.fragment_container_view_tag);
            if (tag instanceof G) {
                g4 = (G) tag;
            } else {
                g4 = null;
            }
            if (g4 != null) {
                g3 = g4;
                break;
            }
            Object parent = view3.getParent();
            if (parent instanceof View) {
                view3 = (View) parent;
            } else {
                view3 = null;
            }
        }
        G parentFragment = g5.getParentFragment();
        if (g3 != null && !g3.equals(parentFragment)) {
            int i = g5.mContainerId;
            a0.b bVar = a0.c.f2749a;
            StringBuilder sb = new StringBuilder("Attempting to nest fragment ");
            sb.append(g5);
            sb.append(" within the view of parent fragment ");
            sb.append(g3);
            sb.append(" via container with ID ");
            a0.c.b(new Violation(g5, AbstractC0008a.r(sb, i, " without using parent's childFragmentManager")));
            a0.c.a(g5).getClass();
        }
        ArrayList arrayList = this.f3472b.f3482a;
        ViewGroup viewGroup = g5.mContainer;
        int i3 = -1;
        if (viewGroup != null) {
            int indexOf = arrayList.indexOf(g5);
            int i4 = indexOf - 1;
            while (true) {
                if (i4 < 0) {
                    while (true) {
                        indexOf++;
                        if (indexOf >= arrayList.size()) {
                            break;
                        }
                        G g6 = (G) arrayList.get(indexOf);
                        if (g6.mContainer == viewGroup && (view = g6.mView) != null) {
                            i3 = viewGroup.indexOfChild(view);
                            break;
                        }
                    }
                } else {
                    G g7 = (G) arrayList.get(i4);
                    if (g7.mContainer == viewGroup && (view2 = g7.mView) != null) {
                        i3 = viewGroup.indexOfChild(view2) + 1;
                        break;
                    }
                    i4--;
                }
            }
        }
        g5.mContainer.addView(g5.mView, i3);
    }

    public final void b() {
        boolean J3 = AbstractC0272g0.J(3);
        G g3 = this.f3473c;
        if (J3) {
            Objects.toString(g3);
        }
        G g4 = g3.mTarget;
        o0 o0Var = null;
        p0 p0Var = this.f3472b;
        if (g4 != null) {
            o0 o0Var2 = (o0) p0Var.f3483b.get(g4.mWho);
            if (o0Var2 != null) {
                g3.mTargetWho = g3.mTarget.mWho;
                g3.mTarget = null;
                o0Var = o0Var2;
            } else {
                throw new IllegalStateException("Fragment " + g3 + " declared target fragment " + g3.mTarget + " that does not belong to this FragmentManager!");
            }
        } else {
            String str = g3.mTargetWho;
            if (str != null && (o0Var = (o0) p0Var.f3483b.get(str)) == null) {
                StringBuilder sb = new StringBuilder("Fragment ");
                sb.append(g3);
                sb.append(" declared target fragment ");
                throw new IllegalStateException(AbstractC0008a.u(sb, g3.mTargetWho, " that does not belong to this FragmentManager!"));
            }
        }
        if (o0Var != null) {
            o0Var.i();
        }
        AbstractC0272g0 abstractC0272g0 = g3.mFragmentManager;
        g3.mHost = abstractC0272g0.f3409w;
        g3.mParentFragment = abstractC0272g0.y;
        M m4 = this.f3471a;
        m4.g(g3, false);
        g3.performAttach();
        m4.b(g3, false);
    }

    public final int c() {
        int i;
        int i3;
        G g3 = this.f3473c;
        if (g3.mFragmentManager == null) {
            return g3.mState;
        }
        int i4 = this.f3475e;
        int ordinal = g3.mMaxState.ordinal();
        int i5 = 0;
        if (ordinal != 1) {
            if (ordinal != 2) {
                if (ordinal != 3) {
                    if (ordinal != 4) {
                        i4 = Math.min(i4, -1);
                    }
                } else {
                    i4 = Math.min(i4, 5);
                }
            } else {
                i4 = Math.min(i4, 1);
            }
        } else {
            i4 = Math.min(i4, 0);
        }
        if (g3.mFromLayout) {
            if (g3.mInLayout) {
                i4 = Math.max(this.f3475e, 2);
                View view = g3.mView;
                if (view != null && view.getParent() == null) {
                    i4 = Math.min(i4, 2);
                }
            } else {
                i4 = this.f3475e < 4 ? Math.min(i4, g3.mState) : Math.min(i4, 1);
            }
        }
        if (g3.mInDynamicContainer && g3.mContainer == null) {
            i4 = Math.min(i4, 4);
        }
        if (!g3.mAdded) {
            i4 = Math.min(i4, 1);
        }
        ViewGroup viewGroup = g3.mContainer;
        if (viewGroup != null) {
            C0281p j2 = C0281p.j(viewGroup, g3.getParentFragmentManager());
            j2.getClass();
            E0 g4 = j2.g(g3);
            if (g4 != null) {
                i = g4.f3290b;
            } else {
                i = 0;
            }
            E0 h2 = j2.h(g3);
            if (h2 != null) {
                i5 = h2.f3290b;
            }
            if (i == 0) {
                i3 = -1;
            } else {
                i3 = F0.f3301a[T.k.b(i)];
            }
            if (i3 != -1 && i3 != 1) {
                i5 = i;
            }
        }
        if (i5 == 2) {
            i4 = Math.min(i4, 6);
        } else if (i5 == 3) {
            i4 = Math.max(i4, 3);
        } else if (g3.mRemoving) {
            if (g3.isInBackStack()) {
                i4 = Math.min(i4, 1);
            } else {
                i4 = Math.min(i4, -1);
            }
        }
        if (g3.mDeferStart && g3.mState < 5) {
            i4 = Math.min(i4, 4);
        }
        if (g3.mTransitioning) {
            i4 = Math.max(i4, 3);
        }
        if (AbstractC0272g0.J(2)) {
            Objects.toString(g3);
        }
        return i4;
    }

    public final void d() {
        Bundle bundle;
        String str;
        G g3 = this.f3473c;
        if (g3.mFromLayout) {
            return;
        }
        if (AbstractC0272g0.J(3)) {
            Objects.toString(g3);
        }
        Bundle bundle2 = g3.mSavedFragmentState;
        ViewGroup viewGroup = null;
        if (bundle2 != null) {
            bundle = bundle2.getBundle("savedInstanceState");
        } else {
            bundle = null;
        }
        LayoutInflater performGetLayoutInflater = g3.performGetLayoutInflater(bundle);
        ViewGroup viewGroup2 = g3.mContainer;
        if (viewGroup2 != null) {
            viewGroup = viewGroup2;
        } else {
            int i = g3.mContainerId;
            if (i != 0) {
                if (i != -1) {
                    viewGroup = (ViewGroup) g3.mFragmentManager.f3410x.b(i);
                    if (viewGroup == null) {
                        if (!g3.mRestored && !g3.mInDynamicContainer) {
                            try {
                                str = g3.getResources().getResourceName(g3.mContainerId);
                            } catch (Resources.NotFoundException unused) {
                                str = "unknown";
                            }
                            throw new IllegalArgumentException("No view found for id 0x" + Integer.toHexString(g3.mContainerId) + " (" + str + ") for fragment " + g3);
                        }
                    } else if (!(viewGroup instanceof P)) {
                        a0.b bVar = a0.c.f2749a;
                        a0.c.b(new Violation(g3, "Attempting to add fragment " + g3 + " to container " + viewGroup + " which is not a FragmentContainerView"));
                        a0.c.a(g3).getClass();
                    }
                } else {
                    throw new IllegalArgumentException(AbstractC0008a.m("Cannot create fragment ", g3, " for a container view with no id"));
                }
            }
        }
        g3.mContainer = viewGroup;
        g3.performCreateView(performGetLayoutInflater, viewGroup, bundle);
        if (g3.mView != null) {
            if (AbstractC0272g0.J(3)) {
                Objects.toString(g3);
            }
            g3.mView.setSaveFromParentEnabled(false);
            g3.mView.setTag(R.id.fragment_container_view_tag, g3);
            if (viewGroup != null) {
                a();
            }
            if (g3.mHidden) {
                g3.mView.setVisibility(8);
            }
            if (g3.mView.isAttachedToWindow()) {
                View view = g3.mView;
                WeakHashMap weakHashMap = J.S.f954a;
                J.H.c(view);
            } else {
                View view2 = g3.mView;
                view2.addOnAttachStateChangeListener(new n0(view2));
            }
            g3.performViewCreated();
            this.f3471a.m(g3, g3.mView, false);
            int visibility = g3.mView.getVisibility();
            g3.setPostOnViewCreatedAlpha(g3.mView.getAlpha());
            if (g3.mContainer != null && visibility == 0) {
                View findFocus = g3.mView.findFocus();
                if (findFocus != null) {
                    g3.setFocusedView(findFocus);
                    if (AbstractC0272g0.J(2)) {
                        findFocus.toString();
                        Objects.toString(g3);
                    }
                }
                g3.mView.setAlpha(0.0f);
            }
        }
        g3.mState = 2;
    }

    public final void e() {
        boolean z3;
        boolean z4;
        G b4;
        boolean J3 = AbstractC0272g0.J(3);
        G g3 = this.f3473c;
        if (J3) {
            Objects.toString(g3);
        }
        boolean z5 = true;
        int i = 0;
        if (g3.mRemoving && !g3.isInBackStack()) {
            z3 = true;
        } else {
            z3 = false;
        }
        p0 p0Var = this.f3472b;
        if (z3 && !g3.mBeingSaved) {
            p0Var.i(null, g3.mWho);
        }
        if (!z3) {
            k0 k0Var = p0Var.f3485d;
            if (k0Var.f3427b.containsKey(g3.mWho) && k0Var.f3430e) {
                z4 = k0Var.f3431f;
            } else {
                z4 = true;
            }
            if (!z4) {
                String str = g3.mTargetWho;
                if (str != null && (b4 = p0Var.b(str)) != null && b4.mRetainInstance) {
                    g3.mTarget = b4;
                }
                g3.mState = 0;
                return;
            }
        }
        S s3 = g3.mHost;
        if (s3 instanceof androidx.lifecycle.a0) {
            z5 = p0Var.f3485d.f3431f;
        } else {
            L l3 = s3.f3321b;
            if (l3 != null) {
                z5 = true ^ l3.isChangingConfigurations();
            }
        }
        if ((z3 && !g3.mBeingSaved) || z5) {
            k0 k0Var2 = p0Var.f3485d;
            k0Var2.getClass();
            if (AbstractC0272g0.J(3)) {
                Objects.toString(g3);
            }
            k0Var2.e(g3.mWho, false);
        }
        g3.performDestroy();
        this.f3471a.d(g3, false);
        ArrayList d2 = p0Var.d();
        int size = d2.size();
        while (i < size) {
            Object obj = d2.get(i);
            i++;
            o0 o0Var = (o0) obj;
            if (o0Var != null) {
                G g4 = o0Var.f3473c;
                if (g3.mWho.equals(g4.mTargetWho)) {
                    g4.mTarget = g3;
                    g4.mTargetWho = null;
                }
            }
        }
        String str2 = g3.mTargetWho;
        if (str2 != null) {
            g3.mTarget = p0Var.b(str2);
        }
        p0Var.h(this);
    }

    public final void f() {
        View view;
        boolean J3 = AbstractC0272g0.J(3);
        G g3 = this.f3473c;
        if (J3) {
            Objects.toString(g3);
        }
        ViewGroup viewGroup = g3.mContainer;
        if (viewGroup != null && (view = g3.mView) != null) {
            viewGroup.removeView(view);
        }
        g3.performDestroyView();
        this.f3471a.n(g3, false);
        g3.mContainer = null;
        g3.mView = null;
        g3.mViewLifecycleOwner = null;
        g3.mViewLifecycleOwnerLiveData.h(null);
        g3.mInLayout = false;
    }

    public final void g() {
        boolean z3;
        boolean J3 = AbstractC0272g0.J(3);
        G g3 = this.f3473c;
        if (J3) {
            Objects.toString(g3);
        }
        g3.performDetach();
        this.f3471a.e(g3, false);
        g3.mState = -1;
        g3.mHost = null;
        g3.mParentFragment = null;
        g3.mFragmentManager = null;
        if (!g3.mRemoving || g3.isInBackStack()) {
            k0 k0Var = this.f3472b.f3485d;
            if (k0Var.f3427b.containsKey(g3.mWho) && k0Var.f3430e) {
                z3 = k0Var.f3431f;
            } else {
                z3 = true;
            }
            if (!z3) {
                return;
            }
        }
        if (AbstractC0272g0.J(3)) {
            Objects.toString(g3);
        }
        g3.initState();
    }

    public final void h() {
        Bundle bundle;
        G g3 = this.f3473c;
        if (g3.mFromLayout && g3.mInLayout && !g3.mPerformedCreateView) {
            if (AbstractC0272g0.J(3)) {
                Objects.toString(g3);
            }
            Bundle bundle2 = g3.mSavedFragmentState;
            if (bundle2 != null) {
                bundle = bundle2.getBundle("savedInstanceState");
            } else {
                bundle = null;
            }
            g3.performCreateView(g3.performGetLayoutInflater(bundle), null, bundle);
            View view = g3.mView;
            if (view != null) {
                view.setSaveFromParentEnabled(false);
                g3.mView.setTag(R.id.fragment_container_view_tag, g3);
                if (g3.mHidden) {
                    g3.mView.setVisibility(8);
                }
                g3.performViewCreated();
                this.f3471a.m(g3, g3.mView, false);
                g3.mState = 2;
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:74:0x0181, code lost:
    
        continue;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void i() {
        /*
            Method dump skipped, instructions count: 580
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.app.o0.i():void");
    }

    public final void j(ClassLoader classLoader) {
        G g3 = this.f3473c;
        Bundle bundle = g3.mSavedFragmentState;
        if (bundle != null) {
            bundle.setClassLoader(classLoader);
            if (g3.mSavedFragmentState.getBundle("savedInstanceState") == null) {
                g3.mSavedFragmentState.putBundle("savedInstanceState", new Bundle());
            }
            try {
                g3.mSavedViewState = g3.mSavedFragmentState.getSparseParcelableArray("viewState");
                g3.mSavedViewRegistryState = g3.mSavedFragmentState.getBundle("viewRegistryState");
                m0 m0Var = (m0) g3.mSavedFragmentState.getParcelable(RemoteConfigConstants.ResponseFieldKey.STATE);
                if (m0Var != null) {
                    g3.mTargetWho = m0Var.p;
                    g3.mTargetRequestCode = m0Var.f3452q;
                    Boolean bool = g3.mSavedUserVisibleHint;
                    if (bool != null) {
                        g3.mUserVisibleHint = bool.booleanValue();
                        g3.mSavedUserVisibleHint = null;
                    } else {
                        g3.mUserVisibleHint = m0Var.f3453r;
                    }
                }
                if (!g3.mUserVisibleHint) {
                    g3.mDeferStart = true;
                }
            } catch (BadParcelableException e4) {
                throw new IllegalStateException("Failed to restore view hierarchy state for fragment " + g3, e4);
            }
        }
    }

    public final void k() {
        boolean J3 = AbstractC0272g0.J(3);
        G g3 = this.f3473c;
        if (J3) {
            Objects.toString(g3);
        }
        View focusedView = g3.getFocusedView();
        if (focusedView != null) {
            if (focusedView != g3.mView) {
                for (ViewParent parent = focusedView.getParent(); parent != null; parent = parent.getParent()) {
                    if (parent != g3.mView) {
                    }
                }
            }
            focusedView.requestFocus();
            if (AbstractC0272g0.J(2)) {
                focusedView.toString();
                Objects.toString(g3);
                Objects.toString(g3.mView.findFocus());
            }
        }
        g3.setFocusedView(null);
        g3.performResume();
        this.f3471a.i(g3, false);
        this.f3472b.i(null, g3.mWho);
        g3.mSavedFragmentState = null;
        g3.mSavedViewState = null;
        g3.mSavedViewRegistryState = null;
    }

    public final Bundle l() {
        Bundle bundle;
        Bundle bundle2 = new Bundle();
        G g3 = this.f3473c;
        if (g3.mState == -1 && (bundle = g3.mSavedFragmentState) != null) {
            bundle2.putAll(bundle);
        }
        bundle2.putParcelable(RemoteConfigConstants.ResponseFieldKey.STATE, new m0(g3));
        if (g3.mState > 0) {
            Bundle bundle3 = new Bundle();
            g3.performSaveInstanceState(bundle3);
            if (!bundle3.isEmpty()) {
                bundle2.putBundle("savedInstanceState", bundle3);
            }
            this.f3471a.j(g3, bundle3, false);
            Bundle bundle4 = new Bundle();
            g3.mSavedStateRegistryController.c(bundle4);
            if (!bundle4.isEmpty()) {
                bundle2.putBundle("registryState", bundle4);
            }
            Bundle W3 = g3.mChildFragmentManager.W();
            if (!W3.isEmpty()) {
                bundle2.putBundle("childFragmentManager", W3);
            }
            if (g3.mView != null) {
                m();
            }
            SparseArray<Parcelable> sparseArray = g3.mSavedViewState;
            if (sparseArray != null) {
                bundle2.putSparseParcelableArray("viewState", sparseArray);
            }
            Bundle bundle5 = g3.mSavedViewRegistryState;
            if (bundle5 != null) {
                bundle2.putBundle("viewRegistryState", bundle5);
            }
        }
        Bundle bundle6 = g3.mArguments;
        if (bundle6 != null) {
            bundle2.putBundle("arguments", bundle6);
        }
        return bundle2;
    }

    public final void m() {
        G g3 = this.f3473c;
        if (g3.mView != null) {
            if (AbstractC0272g0.J(2)) {
                Objects.toString(g3);
                Objects.toString(g3.mView);
            }
            SparseArray<Parcelable> sparseArray = new SparseArray<>();
            g3.mView.saveHierarchyState(sparseArray);
            if (sparseArray.size() > 0) {
                g3.mSavedViewState = sparseArray;
            }
            Bundle bundle = new Bundle();
            g3.mViewLifecycleOwner.f3258f.c(bundle);
            if (!bundle.isEmpty()) {
                g3.mSavedViewRegistryState = bundle;
            }
        }
    }

    public o0(M m4, p0 p0Var, ClassLoader classLoader, Z z3, Bundle bundle) {
        this.f3471a = m4;
        this.f3472b = p0Var;
        m0 m0Var = (m0) bundle.getParcelable(RemoteConfigConstants.ResponseFieldKey.STATE);
        G instantiate = G.instantiate(z3.f3334a.f3409w.f3321b, m0Var.f3440a, null);
        instantiate.mWho = m0Var.f3441b;
        instantiate.mFromLayout = m0Var.f3442c;
        instantiate.mInDynamicContainer = m0Var.f3443d;
        instantiate.mRestored = true;
        instantiate.mFragmentId = m0Var.f3444e;
        instantiate.mContainerId = m0Var.f3445f;
        instantiate.mTag = m0Var.f3446j;
        instantiate.mRetainInstance = m0Var.f3447k;
        instantiate.mRemoving = m0Var.f3448l;
        instantiate.mDetached = m0Var.f3449m;
        instantiate.mHidden = m0Var.f3450n;
        instantiate.mMaxState = EnumC0304n.values()[m0Var.f3451o];
        instantiate.mTargetWho = m0Var.p;
        instantiate.mTargetRequestCode = m0Var.f3452q;
        instantiate.mUserVisibleHint = m0Var.f3453r;
        this.f3473c = instantiate;
        instantiate.mSavedFragmentState = bundle;
        Bundle bundle2 = bundle.getBundle("arguments");
        if (bundle2 != null) {
            bundle2.setClassLoader(classLoader);
        }
        instantiate.setArguments(bundle2);
        if (AbstractC0272g0.J(2)) {
            Objects.toString(instantiate);
        }
    }

    public o0(M m4, p0 p0Var, G g3, Bundle bundle) {
        this.f3471a = m4;
        this.f3472b = p0Var;
        this.f3473c = g3;
        g3.mSavedViewState = null;
        g3.mSavedViewRegistryState = null;
        g3.mBackStackNesting = 0;
        g3.mInLayout = false;
        g3.mAdded = false;
        G g4 = g3.mTarget;
        g3.mTargetWho = g4 != null ? g4.mWho : null;
        g3.mTarget = null;
        g3.mSavedFragmentState = bundle;
        g3.mArguments = bundle.getBundle("arguments");
    }
}
