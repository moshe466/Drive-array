package androidx.fragment.app;

import android.R;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleRes;

/* loaded from: classes.dex */
public class DialogFragment extends Fragment implements DialogInterface.OnCancelListener, DialogInterface.OnDismissListener {
    private static final String SAVED_BACK_STACK_ID = "android:backStackId";
    private static final String SAVED_CANCELABLE = "android:cancelable";
    private static final String SAVED_DIALOG_STATE_TAG = "android:savedDialogState";
    private static final String SAVED_SHOWS_DIALOG = "android:showsDialog";
    private static final String SAVED_STYLE = "android:style";
    private static final String SAVED_THEME = "android:theme";
    public static final int STYLE_NORMAL = 0;
    public static final int STYLE_NO_FRAME = 2;
    public static final int STYLE_NO_INPUT = 3;
    public static final int STYLE_NO_TITLE = 1;

    @Nullable
    Dialog c0;
    boolean d0;
    boolean e0;
    boolean f0;
    private Handler mHandler;
    private Runnable mDismissRunnable = new Runnable() { // from class: androidx.fragment.app.DialogFragment.1
        @Override // java.lang.Runnable
        public void run() {
            DialogFragment dialogFragment = DialogFragment.this;
            Dialog dialog = dialogFragment.c0;
            if (dialog != null) {
                dialogFragment.onDismiss(dialog);
            }
        }
    };
    int X = 0;
    int Y = 0;
    boolean Z = true;
    boolean a0 = true;
    int b0 = -1;

    void a(boolean z, boolean z2) {
        if (this.e0) {
            return;
        }
        this.e0 = true;
        this.f0 = false;
        Dialog dialog = this.c0;
        if (dialog != null) {
            dialog.setOnDismissListener(null);
            this.c0.dismiss();
            if (!z2) {
                if (Looper.myLooper() == this.mHandler.getLooper()) {
                    onDismiss(this.c0);
                } else {
                    this.mHandler.post(this.mDismissRunnable);
                }
            }
        }
        this.d0 = true;
        if (this.b0 >= 0) {
            requireFragmentManager().popBackStack(this.b0, 1);
            this.b0 = -1;
            return;
        }
        FragmentTransaction beginTransaction = requireFragmentManager().beginTransaction();
        beginTransaction.remove(this);
        if (z) {
            beginTransaction.commitAllowingStateLoss();
        } else {
            beginTransaction.commit();
        }
    }

    public void dismiss() {
        a(false, false);
    }

    public void dismissAllowingStateLoss() {
        a(true, false);
    }

    @Nullable
    public Dialog getDialog() {
        return this.c0;
    }

    public boolean getShowsDialog() {
        return this.a0;
    }

    @StyleRes
    public int getTheme() {
        return this.Y;
    }

    public boolean isCancelable() {
        return this.Z;
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityCreated(@Nullable Bundle bundle) {
        Bundle bundle2;
        super.onActivityCreated(bundle);
        if (this.a0) {
            View view = getView();
            if (view != null) {
                if (view.getParent() != null) {
                    throw new IllegalStateException("DialogFragment can not be attached to a container view");
                }
                this.c0.setContentView(view);
            }
            FragmentActivity activity = getActivity();
            if (activity != null) {
                this.c0.setOwnerActivity(activity);
            }
            this.c0.setCancelable(this.Z);
            this.c0.setOnCancelListener(this);
            this.c0.setOnDismissListener(this);
            if (bundle == null || (bundle2 = bundle.getBundle(SAVED_DIALOG_STATE_TAG)) == null) {
                return;
            }
            this.c0.onRestoreInstanceState(bundle2);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (this.f0) {
            return;
        }
        this.e0 = false;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(@NonNull DialogInterface dialogInterface) {
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        this.mHandler = new Handler();
        this.a0 = this.x == 0;
        if (bundle != null) {
            this.X = bundle.getInt(SAVED_STYLE, 0);
            this.Y = bundle.getInt(SAVED_THEME, 0);
            this.Z = bundle.getBoolean(SAVED_CANCELABLE, true);
            this.a0 = bundle.getBoolean(SAVED_SHOWS_DIALOG, this.a0);
            this.b0 = bundle.getInt(SAVED_BACK_STACK_ID, -1);
        }
    }

    @NonNull
    public Dialog onCreateDialog(@Nullable Bundle bundle) {
        return new Dialog(requireContext(), getTheme());
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        Dialog dialog = this.c0;
        if (dialog != null) {
            this.d0 = true;
            dialog.setOnDismissListener(null);
            this.c0.dismiss();
            if (!this.e0) {
                onDismiss(this.c0);
            }
            this.c0 = null;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onDetach() {
        super.onDetach();
        if (this.f0 || this.e0) {
            return;
        }
        this.e0 = true;
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(@NonNull DialogInterface dialogInterface) {
        if (this.d0) {
            return;
        }
        a(true, true);
    }

    @Override // androidx.fragment.app.Fragment
    @NonNull
    public LayoutInflater onGetLayoutInflater(@Nullable Bundle bundle) {
        Context b;
        if (!this.a0) {
            return super.onGetLayoutInflater(bundle);
        }
        this.c0 = onCreateDialog(bundle);
        Dialog dialog = this.c0;
        if (dialog != null) {
            setupDialog(dialog, this.X);
            b = this.c0.getContext();
        } else {
            b = this.s.b();
        }
        return (LayoutInflater) b.getSystemService("layout_inflater");
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(@NonNull Bundle bundle) {
        Bundle onSaveInstanceState;
        super.onSaveInstanceState(bundle);
        Dialog dialog = this.c0;
        if (dialog != null && (onSaveInstanceState = dialog.onSaveInstanceState()) != null) {
            bundle.putBundle(SAVED_DIALOG_STATE_TAG, onSaveInstanceState);
        }
        int i = this.X;
        if (i != 0) {
            bundle.putInt(SAVED_STYLE, i);
        }
        int i2 = this.Y;
        if (i2 != 0) {
            bundle.putInt(SAVED_THEME, i2);
        }
        boolean z = this.Z;
        if (!z) {
            bundle.putBoolean(SAVED_CANCELABLE, z);
        }
        boolean z2 = this.a0;
        if (!z2) {
            bundle.putBoolean(SAVED_SHOWS_DIALOG, z2);
        }
        int i3 = this.b0;
        if (i3 != -1) {
            bundle.putInt(SAVED_BACK_STACK_ID, i3);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        Dialog dialog = this.c0;
        if (dialog != null) {
            this.d0 = false;
            dialog.show();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        Dialog dialog = this.c0;
        if (dialog != null) {
            dialog.hide();
        }
    }

    @NonNull
    public final Dialog requireDialog() {
        Dialog dialog = getDialog();
        if (dialog != null) {
            return dialog;
        }
        throw new IllegalStateException("DialogFragment " + this + " does not have a Dialog.");
    }

    public void setCancelable(boolean z) {
        this.Z = z;
        Dialog dialog = this.c0;
        if (dialog != null) {
            dialog.setCancelable(z);
        }
    }

    public void setShowsDialog(boolean z) {
        this.a0 = z;
    }

    public void setStyle(int i, @StyleRes int i2) {
        this.X = i;
        int i3 = this.X;
        if (i3 == 2 || i3 == 3) {
            this.Y = R.style.Theme.Panel;
        }
        if (i2 != 0) {
            this.Y = i2;
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void setupDialog(@NonNull Dialog dialog, int i) {
        if (i != 1 && i != 2) {
            if (i != 3) {
                return;
            } else {
                dialog.getWindow().addFlags(24);
            }
        }
        dialog.requestWindowFeature(1);
    }

    public int show(@NonNull FragmentTransaction fragmentTransaction, @Nullable String str) {
        this.e0 = false;
        this.f0 = true;
        fragmentTransaction.add(this, str);
        this.d0 = false;
        this.b0 = fragmentTransaction.commit();
        return this.b0;
    }

    public void show(@NonNull FragmentManager fragmentManager, @Nullable String str) {
        this.e0 = false;
        this.f0 = true;
        FragmentTransaction beginTransaction = fragmentManager.beginTransaction();
        beginTransaction.add(this, str);
        beginTransaction.commit();
    }

    public void showNow(@NonNull FragmentManager fragmentManager, @Nullable String str) {
        this.e0 = false;
        this.f0 = true;
        FragmentTransaction beginTransaction = fragmentManager.beginTransaction();
        beginTransaction.add(this, str);
        beginTransaction.commitNow();
    }
}
