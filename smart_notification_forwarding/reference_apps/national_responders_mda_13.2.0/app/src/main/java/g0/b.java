package g0;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Parcelable;
import android.view.View;
import android.view.ViewGroup;

@Deprecated
/* loaded from: classes.dex */
public abstract class b extends androidx.viewpager.widget.a {

    /* renamed from: a, reason: collision with root package name */
    private final FragmentManager f9748a;

    /* renamed from: b, reason: collision with root package name */
    private FragmentTransaction f9749b = null;

    /* renamed from: c, reason: collision with root package name */
    private Fragment f9750c = null;

    @Deprecated
    public b(FragmentManager fragmentManager) {
        this.f9748a = fragmentManager;
    }

    private static String o(int i10, long j10) {
        return "android:switcher:" + i10 + ":" + j10;
    }

    @Override // androidx.viewpager.widget.a
    @Deprecated
    public void a(ViewGroup viewGroup, int i10, Object obj) {
        if (this.f9749b == null) {
            this.f9749b = this.f9748a.beginTransaction();
        }
        this.f9749b.detach((Fragment) obj);
    }

    @Override // androidx.viewpager.widget.a
    @Deprecated
    public void b(ViewGroup viewGroup) {
        FragmentTransaction fragmentTransaction = this.f9749b;
        if (fragmentTransaction != null) {
            fragmentTransaction.commitAllowingStateLoss();
            this.f9749b = null;
            this.f9748a.executePendingTransactions();
        }
    }

    @Override // androidx.viewpager.widget.a
    @Deprecated
    public Object f(ViewGroup viewGroup, int i10) {
        if (this.f9749b == null) {
            this.f9749b = this.f9748a.beginTransaction();
        }
        long n10 = n(i10);
        Fragment findFragmentByTag = this.f9748a.findFragmentByTag(o(viewGroup.getId(), n10));
        if (findFragmentByTag != null) {
            this.f9749b.attach(findFragmentByTag);
        } else {
            findFragmentByTag = m(i10);
            this.f9749b.add(viewGroup.getId(), findFragmentByTag, o(viewGroup.getId(), n10));
        }
        if (findFragmentByTag != this.f9750c) {
            findFragmentByTag.setMenuVisibility(false);
            a.a(findFragmentByTag, false);
        }
        return findFragmentByTag;
    }

    @Override // androidx.viewpager.widget.a
    @Deprecated
    public boolean g(View view, Object obj) {
        return ((Fragment) obj).getView() == view;
    }

    @Override // androidx.viewpager.widget.a
    @Deprecated
    public void h(Parcelable parcelable, ClassLoader classLoader) {
    }

    @Override // androidx.viewpager.widget.a
    @Deprecated
    public Parcelable i() {
        return null;
    }

    @Override // androidx.viewpager.widget.a
    @Deprecated
    public void j(ViewGroup viewGroup, int i10, Object obj) {
        Fragment fragment = (Fragment) obj;
        Fragment fragment2 = this.f9750c;
        if (fragment != fragment2) {
            if (fragment2 != null) {
                fragment2.setMenuVisibility(false);
                a.a(this.f9750c, false);
            }
            if (fragment != null) {
                fragment.setMenuVisibility(true);
                a.a(fragment, true);
            }
            this.f9750c = fragment;
        }
    }

    @Override // androidx.viewpager.widget.a
    @Deprecated
    public void l(ViewGroup viewGroup) {
        if (viewGroup.getId() != -1) {
            return;
        }
        throw new IllegalStateException("ViewPager with adapter " + this + " requires a view id");
    }

    @Deprecated
    public abstract Fragment m(int i10);

    @Deprecated
    public long n(int i10) {
        return i10;
    }
}
