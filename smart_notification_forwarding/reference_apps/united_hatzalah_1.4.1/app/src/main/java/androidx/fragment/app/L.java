package androidx.fragment.app;

import android.app.SharedElementCallback;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.MenuItem;
import android.view.View;
import androidx.lifecycle.C0311v;
import androidx.lifecycle.EnumC0303m;
import androidx.lifecycle.EnumC0304n;
import f0.AbstractC0373b;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import w.InterfaceC0743a;

/* loaded from: classes.dex */
public abstract class L extends c.m implements InterfaceC0743a {
    static final String LIFECYCLE_TAG = "android:support:lifecycle";
    boolean mCreated;
    boolean mResumed;
    final Q mFragments = new Q(new K(this));
    final C0311v mFragmentLifecycleRegistry = new C0311v(this);
    boolean mStopped = true;

    public L() {
        getSavedStateRegistry().c(LIFECYCLE_TAG, new H(this, 0));
        final int i = 0;
        addOnConfigurationChangedListener(new I.a(this) { // from class: androidx.fragment.app.I

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ L f3305b;

            {
                this.f3305b = this;
            }

            @Override // I.a, androidx.window.extensions.core.util.function.Consumer
            public final void accept(Object obj) {
                switch (i) {
                    case 0:
                        this.f3305b.mFragments.a();
                        return;
                    default:
                        this.f3305b.mFragments.a();
                        return;
                }
            }
        });
        final int i3 = 1;
        addOnNewIntentListener(new I.a(this) { // from class: androidx.fragment.app.I

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ L f3305b;

            {
                this.f3305b = this;
            }

            @Override // I.a, androidx.window.extensions.core.util.function.Consumer
            public final void accept(Object obj) {
                switch (i3) {
                    case 0:
                        this.f3305b.mFragments.a();
                        return;
                    default:
                        this.f3305b.mFragments.a();
                        return;
                }
            }
        });
        addOnContextAvailableListener(new d.b() { // from class: androidx.fragment.app.J
            @Override // d.b
            public final void a(c.m mVar) {
                K k4 = L.this.mFragments.f3319a;
                k4.f3323d.b(k4, k4, null);
            }
        });
    }

    public static boolean f(AbstractC0272g0 abstractC0272g0) {
        boolean z3 = false;
        for (G g3 : abstractC0272g0.f3391c.f()) {
            if (g3 != null) {
                if (g3.getHost() != null) {
                    z3 |= f(g3.getChildFragmentManager());
                }
                A0 a02 = g3.mViewLifecycleOwner;
                EnumC0304n enumC0304n = EnumC0304n.f3610d;
                if (a02 != null) {
                    a02.b();
                    if (a02.f3257e.f3618c.compareTo(enumC0304n) >= 0) {
                        g3.mViewLifecycleOwner.f3257e.g();
                        z3 = true;
                    }
                }
                if (g3.mLifecycleRegistry.f3618c.compareTo(enumC0304n) >= 0) {
                    g3.mLifecycleRegistry.g();
                    z3 = true;
                }
            }
        }
        return z3;
    }

    public final View dispatchFragmentsOnCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        return this.mFragments.f3319a.f3323d.f3394f.onCreateView(view, str, context, attributeSet);
    }

    @Override // android.app.Activity
    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        super.dump(str, fileDescriptor, printWriter, strArr);
        if (!shouldDumpInternalState(strArr)) {
            return;
        }
        printWriter.print(str);
        printWriter.print("Local FragmentActivity ");
        printWriter.print(Integer.toHexString(System.identityHashCode(this)));
        printWriter.println(" State:");
        String str2 = str + "  ";
        printWriter.print(str2);
        printWriter.print("mCreated=");
        printWriter.print(this.mCreated);
        printWriter.print(" mResumed=");
        printWriter.print(this.mResumed);
        printWriter.print(" mStopped=");
        printWriter.print(this.mStopped);
        if (getApplication() != null) {
            AbstractC0373b.a(this).b(str2, fileDescriptor, printWriter, strArr);
        }
        this.mFragments.f3319a.f3323d.v(str, fileDescriptor, printWriter, strArr);
    }

    public AbstractC0272g0 getSupportFragmentManager() {
        return this.mFragments.f3319a.f3323d;
    }

    @Deprecated
    public AbstractC0373b getSupportLoaderManager() {
        return AbstractC0373b.a(this);
    }

    public void markFragmentsCreated() {
        do {
        } while (f(getSupportFragmentManager()));
    }

    @Override // c.m, android.app.Activity
    public void onActivityResult(int i, int i3, Intent intent) {
        this.mFragments.a();
        super.onActivityResult(i, i3, intent);
    }

    @Deprecated
    public void onAttachFragment(G g3) {
    }

    @Override // c.m, w.f, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mFragmentLifecycleRegistry.e(EnumC0303m.ON_CREATE);
        h0 h0Var = this.mFragments.f3319a.f3323d;
        h0Var.f3380H = false;
        h0Var.f3381I = false;
        h0Var.f3387O.f3432g = false;
        h0Var.u(1);
    }

    @Override // android.app.Activity, android.view.LayoutInflater.Factory2
    public View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        View dispatchFragmentsOnCreateView = dispatchFragmentsOnCreateView(view, str, context, attributeSet);
        return dispatchFragmentsOnCreateView == null ? super.onCreateView(view, str, context, attributeSet) : dispatchFragmentsOnCreateView;
    }

    @Override // android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.mFragments.f3319a.f3323d.l();
        this.mFragmentLifecycleRegistry.e(EnumC0303m.ON_DESTROY);
    }

    @Override // c.m, android.app.Activity, android.view.Window.Callback
    public boolean onMenuItemSelected(int i, MenuItem menuItem) {
        if (super.onMenuItemSelected(i, menuItem)) {
            return true;
        }
        if (i == 6) {
            return this.mFragments.f3319a.f3323d.j(menuItem);
        }
        return false;
    }

    @Override // android.app.Activity
    public void onPause() {
        super.onPause();
        this.mResumed = false;
        this.mFragments.f3319a.f3323d.u(5);
        this.mFragmentLifecycleRegistry.e(EnumC0303m.ON_PAUSE);
    }

    @Override // android.app.Activity
    public void onPostResume() {
        super.onPostResume();
        onResumeFragments();
    }

    @Override // c.m, android.app.Activity
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        this.mFragments.a();
        super.onRequestPermissionsResult(i, strArr, iArr);
    }

    @Override // android.app.Activity
    public void onResume() {
        this.mFragments.a();
        super.onResume();
        this.mResumed = true;
        this.mFragments.f3319a.f3323d.z(true);
    }

    public void onResumeFragments() {
        this.mFragmentLifecycleRegistry.e(EnumC0303m.ON_RESUME);
        h0 h0Var = this.mFragments.f3319a.f3323d;
        h0Var.f3380H = false;
        h0Var.f3381I = false;
        h0Var.f3387O.f3432g = false;
        h0Var.u(7);
    }

    @Override // android.app.Activity
    public void onStart() {
        this.mFragments.a();
        super.onStart();
        this.mStopped = false;
        if (!this.mCreated) {
            this.mCreated = true;
            h0 h0Var = this.mFragments.f3319a.f3323d;
            h0Var.f3380H = false;
            h0Var.f3381I = false;
            h0Var.f3387O.f3432g = false;
            h0Var.u(4);
        }
        this.mFragments.f3319a.f3323d.z(true);
        this.mFragmentLifecycleRegistry.e(EnumC0303m.ON_START);
        h0 h0Var2 = this.mFragments.f3319a.f3323d;
        h0Var2.f3380H = false;
        h0Var2.f3381I = false;
        h0Var2.f3387O.f3432g = false;
        h0Var2.u(5);
    }

    @Override // android.app.Activity
    public void onStateNotSaved() {
        this.mFragments.a();
    }

    @Override // android.app.Activity
    public void onStop() {
        super.onStop();
        this.mStopped = true;
        markFragmentsCreated();
        h0 h0Var = this.mFragments.f3319a.f3323d;
        h0Var.f3381I = true;
        h0Var.f3387O.f3432g = true;
        h0Var.u(4);
        this.mFragmentLifecycleRegistry.e(EnumC0303m.ON_STOP);
    }

    public void setEnterSharedElementCallback(w.t tVar) {
        setEnterSharedElementCallback((SharedElementCallback) null);
    }

    public void setExitSharedElementCallback(w.t tVar) {
        setExitSharedElementCallback((SharedElementCallback) null);
    }

    public void startActivityFromFragment(G g3, Intent intent, int i, Bundle bundle) {
        if (i == -1) {
            startActivityForResult(intent, -1, bundle);
        } else {
            g3.startActivityForResult(intent, i, bundle);
        }
    }

    @Deprecated
    public void startIntentSenderFromFragment(G g3, IntentSender intentSender, int i, Intent intent, int i3, int i4, int i5, Bundle bundle) {
        if (i == -1) {
            startIntentSenderForResult(intentSender, i, intent, i3, i4, i5, bundle);
        } else {
            g3.startIntentSenderForResult(intentSender, i, intent, i3, i4, i5, bundle);
        }
    }

    public void supportFinishAfterTransition() {
        finishAfterTransition();
    }

    @Deprecated
    public void supportInvalidateOptionsMenu() {
        invalidateMenu();
    }

    public void supportPostponeEnterTransition() {
        postponeEnterTransition();
    }

    public void supportStartPostponedEnterTransition() {
        startPostponedEnterTransition();
    }

    @Override // w.InterfaceC0743a
    @Deprecated
    public final void validateRequestPermissionsRequestCode(int i) {
    }

    @Override // android.app.Activity, android.view.LayoutInflater.Factory
    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        View dispatchFragmentsOnCreateView = dispatchFragmentsOnCreateView(null, str, context, attributeSet);
        return dispatchFragmentsOnCreateView == null ? super.onCreateView(str, context, attributeSet) : dispatchFragmentsOnCreateView;
    }

    public void startActivityFromFragment(G g3, Intent intent, int i) {
        startActivityFromFragment(g3, intent, i, (Bundle) null);
    }
}
