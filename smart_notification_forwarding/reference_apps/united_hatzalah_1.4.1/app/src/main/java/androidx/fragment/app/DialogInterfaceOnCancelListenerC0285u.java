package androidx.fragment.app;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.lifecycle.AbstractC0315z;
import androidx.lifecycle.C0314y;
import com.uh.sf.R;

/* renamed from: androidx.fragment.app.u, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class DialogInterfaceOnCancelListenerC0285u extends G implements DialogInterface.OnCancelListener, DialogInterface.OnDismissListener {
    private static final String SAVED_BACK_STACK_ID = "android:backStackId";
    private static final String SAVED_CANCELABLE = "android:cancelable";
    private static final String SAVED_DIALOG_STATE_TAG = "android:savedDialogState";
    private static final String SAVED_INTERNAL_DIALOG_SHOWING = "android:dialogShowing";
    private static final String SAVED_SHOWS_DIALOG = "android:showsDialog";
    private static final String SAVED_STYLE = "android:style";
    private static final String SAVED_THEME = "android:theme";
    public static final int STYLE_NORMAL = 0;
    public static final int STYLE_NO_FRAME = 2;
    public static final int STYLE_NO_INPUT = 3;
    public static final int STYLE_NO_TITLE = 1;
    private boolean mCreatingDialog;
    private Dialog mDialog;
    private boolean mDismissed;
    private Handler mHandler;
    private boolean mShownByMe;
    private boolean mViewDestroyed;
    private Runnable mDismissRunnable = new RunnableC0282q(this, 0);
    private DialogInterface.OnCancelListener mOnCancelListener = new r(this);
    private DialogInterface.OnDismissListener mOnDismissListener = new DialogInterfaceOnDismissListenerC0283s(this);
    private int mStyle = 0;
    private int mTheme = 0;
    private boolean mCancelable = true;
    private boolean mShowsDialog = true;
    private int mBackStackId = -1;
    private androidx.lifecycle.C mObserver = new B(this, 1);
    private boolean mDialogCreated = false;

    @Override // androidx.fragment.app.G
    public O createFragmentContainer() {
        return new C0284t(this, super.createFragmentContainer());
    }

    public void dismiss() {
        f(false, false, false);
    }

    public void dismissAllowingStateLoss() {
        f(true, false, false);
    }

    public void dismissNow() {
        f(false, false, true);
    }

    public final void f(boolean z3, boolean z4, boolean z5) {
        if (this.mDismissed) {
            return;
        }
        this.mDismissed = true;
        this.mShownByMe = false;
        Dialog dialog = this.mDialog;
        if (dialog != null) {
            dialog.setOnDismissListener(null);
            this.mDialog.dismiss();
            if (!z4) {
                if (Looper.myLooper() == this.mHandler.getLooper()) {
                    onDismiss(this.mDialog);
                } else {
                    this.mHandler.post(this.mDismissRunnable);
                }
            }
        }
        this.mViewDestroyed = true;
        if (this.mBackStackId >= 0) {
            if (z5) {
                AbstractC0272g0 parentFragmentManager = getParentFragmentManager();
                int i = this.mBackStackId;
                if (i >= 0) {
                    parentFragmentManager.R(i, 1);
                } else {
                    parentFragmentManager.getClass();
                    throw new IllegalArgumentException(e0.a.c(i, "Bad id: "));
                }
            } else {
                AbstractC0272g0 parentFragmentManager2 = getParentFragmentManager();
                int i3 = this.mBackStackId;
                parentFragmentManager2.getClass();
                if (i3 >= 0) {
                    parentFragmentManager2.x(new C0268e0(parentFragmentManager2, i3), z3);
                } else {
                    throw new IllegalArgumentException(e0.a.c(i3, "Bad id: "));
                }
            }
            this.mBackStackId = -1;
            return;
        }
        AbstractC0272g0 parentFragmentManager3 = getParentFragmentManager();
        parentFragmentManager3.getClass();
        C0259a c0259a = new C0259a(parentFragmentManager3);
        c0259a.f3510o = true;
        c0259a.h(this);
        if (z5) {
            if (!c0259a.f3503g) {
                c0259a.f3335q.A(c0259a, false);
                return;
            }
            throw new IllegalStateException("This transaction is already being added to the back stack");
        }
        if (z3) {
            c0259a.f(true, true);
        } else {
            c0259a.f(false, true);
        }
    }

    public Dialog getDialog() {
        return this.mDialog;
    }

    public boolean getShowsDialog() {
        return this.mShowsDialog;
    }

    public int getTheme() {
        return this.mTheme;
    }

    public boolean isCancelable() {
        return this.mCancelable;
    }

    @Override // androidx.fragment.app.G
    @Deprecated
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
    }

    @Override // androidx.fragment.app.G
    public void onAttach(Context context) {
        Object obj;
        super.onAttach(context);
        androidx.lifecycle.A viewLifecycleOwnerLiveData = getViewLifecycleOwnerLiveData();
        androidx.lifecycle.C c4 = this.mObserver;
        viewLifecycleOwnerLiveData.getClass();
        androidx.lifecycle.A.a("observeForever");
        AbstractC0315z abstractC0315z = new AbstractC0315z(viewLifecycleOwnerLiveData, c4);
        o.f fVar = viewLifecycleOwnerLiveData.f3541b;
        o.c d2 = fVar.d(c4);
        if (d2 != null) {
            obj = d2.f5900b;
        } else {
            o.c cVar = new o.c(c4, abstractC0315z);
            fVar.f5909d++;
            o.c cVar2 = fVar.f5907b;
            if (cVar2 == null) {
                fVar.f5906a = cVar;
                fVar.f5907b = cVar;
            } else {
                cVar2.f5901c = cVar;
                cVar.f5902d = cVar2;
                fVar.f5907b = cVar;
            }
            obj = null;
        }
        AbstractC0315z abstractC0315z2 = (AbstractC0315z) obj;
        if (!(abstractC0315z2 instanceof C0314y)) {
            if (abstractC0315z2 == null) {
                abstractC0315z.b(true);
            }
            if (!this.mShownByMe) {
                this.mDismissed = false;
                return;
            }
            return;
        }
        throw new IllegalArgumentException("Cannot add the same observer with different lifecycles");
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
    }

    @Override // androidx.fragment.app.G
    public void onCreate(Bundle bundle) {
        boolean z3;
        super.onCreate(bundle);
        this.mHandler = new Handler();
        if (this.mContainerId == 0) {
            z3 = true;
        } else {
            z3 = false;
        }
        this.mShowsDialog = z3;
        if (bundle != null) {
            this.mStyle = bundle.getInt(SAVED_STYLE, 0);
            this.mTheme = bundle.getInt(SAVED_THEME, 0);
            this.mCancelable = bundle.getBoolean(SAVED_CANCELABLE, true);
            this.mShowsDialog = bundle.getBoolean(SAVED_SHOWS_DIALOG, this.mShowsDialog);
            this.mBackStackId = bundle.getInt(SAVED_BACK_STACK_ID, -1);
        }
    }

    public Dialog onCreateDialog(Bundle bundle) {
        if (AbstractC0272g0.J(3)) {
            toString();
        }
        return new c.n(requireContext(), getTheme());
    }

    @Override // androidx.fragment.app.G
    public void onDestroyView() {
        super.onDestroyView();
        Dialog dialog = this.mDialog;
        if (dialog != null) {
            this.mViewDestroyed = true;
            dialog.setOnDismissListener(null);
            this.mDialog.dismiss();
            if (!this.mDismissed) {
                onDismiss(this.mDialog);
            }
            this.mDialog = null;
            this.mDialogCreated = false;
        }
    }

    @Override // androidx.fragment.app.G
    public void onDetach() {
        super.onDetach();
        if (!this.mShownByMe && !this.mDismissed) {
            this.mDismissed = true;
        }
        getViewLifecycleOwnerLiveData().g(this.mObserver);
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        if (!this.mViewDestroyed) {
            if (AbstractC0272g0.J(3)) {
                toString();
            }
            f(true, true, false);
        }
    }

    public View onFindViewById(int i) {
        Dialog dialog = this.mDialog;
        if (dialog != null) {
            return dialog.findViewById(i);
        }
        return null;
    }

    @Override // androidx.fragment.app.G
    public LayoutInflater onGetLayoutInflater(Bundle bundle) {
        LayoutInflater onGetLayoutInflater = super.onGetLayoutInflater(bundle);
        boolean z3 = this.mShowsDialog;
        if (z3 && !this.mCreatingDialog) {
            if (z3 && !this.mDialogCreated) {
                try {
                    this.mCreatingDialog = true;
                    Dialog onCreateDialog = onCreateDialog(bundle);
                    this.mDialog = onCreateDialog;
                    if (this.mShowsDialog) {
                        setupDialog(onCreateDialog, this.mStyle);
                        Context context = getContext();
                        if (context instanceof Activity) {
                            this.mDialog.setOwnerActivity((Activity) context);
                        }
                        this.mDialog.setCancelable(this.mCancelable);
                        this.mDialog.setOnCancelListener(this.mOnCancelListener);
                        this.mDialog.setOnDismissListener(this.mOnDismissListener);
                        this.mDialogCreated = true;
                    } else {
                        this.mDialog = null;
                    }
                    this.mCreatingDialog = false;
                } catch (Throwable th) {
                    this.mCreatingDialog = false;
                    throw th;
                }
            }
            if (AbstractC0272g0.J(2)) {
                toString();
            }
            Dialog dialog = this.mDialog;
            if (dialog != null) {
                return onGetLayoutInflater.cloneInContext(dialog.getContext());
            }
        } else if (AbstractC0272g0.J(2)) {
            toString();
        }
        return onGetLayoutInflater;
    }

    public boolean onHasView() {
        return this.mDialogCreated;
    }

    @Override // androidx.fragment.app.G
    public void onSaveInstanceState(Bundle bundle) {
        Dialog dialog = this.mDialog;
        if (dialog != null) {
            Bundle onSaveInstanceState = dialog.onSaveInstanceState();
            onSaveInstanceState.putBoolean(SAVED_INTERNAL_DIALOG_SHOWING, false);
            bundle.putBundle(SAVED_DIALOG_STATE_TAG, onSaveInstanceState);
        }
        int i = this.mStyle;
        if (i != 0) {
            bundle.putInt(SAVED_STYLE, i);
        }
        int i3 = this.mTheme;
        if (i3 != 0) {
            bundle.putInt(SAVED_THEME, i3);
        }
        boolean z3 = this.mCancelable;
        if (!z3) {
            bundle.putBoolean(SAVED_CANCELABLE, z3);
        }
        boolean z4 = this.mShowsDialog;
        if (!z4) {
            bundle.putBoolean(SAVED_SHOWS_DIALOG, z4);
        }
        int i4 = this.mBackStackId;
        if (i4 != -1) {
            bundle.putInt(SAVED_BACK_STACK_ID, i4);
        }
    }

    @Override // androidx.fragment.app.G
    public void onStart() {
        super.onStart();
        Dialog dialog = this.mDialog;
        if (dialog != null) {
            this.mViewDestroyed = false;
            dialog.show();
            View decorView = this.mDialog.getWindow().getDecorView();
            androidx.lifecycle.P.f(decorView, this);
            decorView.setTag(R.id.view_tree_view_model_store_owner, this);
            T.b.H(decorView, this);
        }
    }

    @Override // androidx.fragment.app.G
    public void onStop() {
        super.onStop();
        Dialog dialog = this.mDialog;
        if (dialog != null) {
            dialog.hide();
        }
    }

    @Override // androidx.fragment.app.G
    public void onViewStateRestored(Bundle bundle) {
        Bundle bundle2;
        super.onViewStateRestored(bundle);
        if (this.mDialog != null && bundle != null && (bundle2 = bundle.getBundle(SAVED_DIALOG_STATE_TAG)) != null) {
            this.mDialog.onRestoreInstanceState(bundle2);
        }
    }

    @Override // androidx.fragment.app.G
    public void performCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Bundle bundle2;
        super.performCreateView(layoutInflater, viewGroup, bundle);
        if (this.mView == null && this.mDialog != null && bundle != null && (bundle2 = bundle.getBundle(SAVED_DIALOG_STATE_TAG)) != null) {
            this.mDialog.onRestoreInstanceState(bundle2);
        }
    }

    public final c.n requireComponentDialog() {
        Dialog requireDialog = requireDialog();
        if (requireDialog instanceof c.n) {
            return (c.n) requireDialog;
        }
        throw new IllegalStateException("DialogFragment " + this + " did not return a ComponentDialog instance from requireDialog(). The actual Dialog is " + requireDialog);
    }

    public final Dialog requireDialog() {
        Dialog dialog = getDialog();
        if (dialog != null) {
            return dialog;
        }
        throw new IllegalStateException("DialogFragment " + this + " does not have a Dialog.");
    }

    public void setCancelable(boolean z3) {
        this.mCancelable = z3;
        Dialog dialog = this.mDialog;
        if (dialog != null) {
            dialog.setCancelable(z3);
        }
    }

    public void setShowsDialog(boolean z3) {
        this.mShowsDialog = z3;
    }

    public void setStyle(int i, int i3) {
        if (AbstractC0272g0.J(2)) {
            toString();
        }
        this.mStyle = i;
        if (i == 2 || i == 3) {
            this.mTheme = android.R.style.Theme.Panel;
        }
        if (i3 != 0) {
            this.mTheme = i3;
        }
    }

    public void setupDialog(Dialog dialog, int i) {
        if (i != 1 && i != 2) {
            if (i != 3) {
                return;
            }
            Window window = dialog.getWindow();
            if (window != null) {
                window.addFlags(24);
            }
        }
        dialog.requestWindowFeature(1);
    }

    public void show(AbstractC0272g0 abstractC0272g0, String str) {
        this.mDismissed = false;
        this.mShownByMe = true;
        abstractC0272g0.getClass();
        C0259a c0259a = new C0259a(abstractC0272g0);
        c0259a.f3510o = true;
        c0259a.c(0, this, str);
        c0259a.f(false, true);
    }

    public void showNow(AbstractC0272g0 abstractC0272g0, String str) {
        this.mDismissed = false;
        this.mShownByMe = true;
        abstractC0272g0.getClass();
        C0259a c0259a = new C0259a(abstractC0272g0);
        c0259a.f3510o = true;
        c0259a.c(0, this, str);
        if (!c0259a.f3503g) {
            c0259a.f3335q.A(c0259a, false);
            return;
        }
        throw new IllegalStateException("This transaction is already being added to the back stack");
    }

    public int show(r0 r0Var, String str) {
        this.mDismissed = false;
        this.mShownByMe = true;
        r0Var.c(0, this, str);
        this.mViewDestroyed = false;
        int f4 = ((C0259a) r0Var).f(false, true);
        this.mBackStackId = f4;
        return f4;
    }
}
