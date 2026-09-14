package q;

import F0.C0047j2;
import F0.C0092v0;
import F0.C0110z2;
import F0.G1;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.TypedArray;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.DialogInterfaceOnCancelListenerC0285u;
import androidx.fragment.app.L;
import androidx.lifecycle.X;
import androidx.lifecycle.Z;
import com.uh.sf.R;
import d0.AbstractC0356b;
import h.C0435e;
import h.DialogInterfaceC0438h;

/* loaded from: classes.dex */
public class I extends DialogInterfaceOnCancelListenerC0285u {

    /* renamed from: a, reason: collision with root package name */
    public final Handler f6011a = new Handler(Looper.getMainLooper());

    /* renamed from: b, reason: collision with root package name */
    public final G.a f6012b = new G.a(this, 9);

    /* renamed from: c, reason: collision with root package name */
    public C0601A f6013c;

    /* renamed from: d, reason: collision with root package name */
    public int f6014d;

    /* renamed from: e, reason: collision with root package name */
    public int f6015e;

    /* renamed from: f, reason: collision with root package name */
    public ImageView f6016f;

    /* renamed from: j, reason: collision with root package name */
    public TextView f6017j;

    public final int g(int i) {
        Context context = getContext();
        L activity = getActivity();
        if (context == null || activity == null) {
            return 0;
        }
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(i, typedValue, true);
        TypedArray obtainStyledAttributes = activity.obtainStyledAttributes(typedValue.data, new int[]{i});
        int color = obtainStyledAttributes.getColor(0, 0);
        obtainStyledAttributes.recycle();
        return color;
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [androidx.lifecycle.B, androidx.lifecycle.A] */
    @Override // androidx.fragment.app.DialogInterfaceOnCancelListenerC0285u, android.content.DialogInterface.OnCancelListener
    public final void onCancel(DialogInterface dialogInterface) {
        C0601A c0601a = this.f6013c;
        if (c0601a.f6008v == null) {
            c0601a.f6008v = new androidx.lifecycle.A();
        }
        C0601A.h(c0601a.f6008v, Boolean.TRUE);
    }

    /* JADX WARN: Type inference failed for: r0v10, types: [androidx.lifecycle.B, androidx.lifecycle.A] */
    /* JADX WARN: Type inference failed for: r0v11, types: [androidx.lifecycle.B, androidx.lifecycle.A] */
    @Override // androidx.fragment.app.DialogInterfaceOnCancelListenerC0285u, androidx.fragment.app.G
    public final void onCreate(Bundle bundle) {
        int i;
        super.onCreate(bundle);
        L activity = getActivity();
        if (activity != null) {
            Z store = activity.getViewModelStore();
            X factory = activity.getDefaultViewModelProviderFactory();
            AbstractC0356b defaultCreationExtras = activity.getDefaultViewModelCreationExtras();
            kotlin.jvm.internal.j.e(store, "store");
            kotlin.jvm.internal.j.e(factory, "factory");
            kotlin.jvm.internal.j.e(defaultCreationExtras, "defaultCreationExtras");
            C0110z2 c0110z2 = new C0110z2(store, factory, defaultCreationExtras);
            kotlin.jvm.internal.e a2 = kotlin.jvm.internal.s.a(C0601A.class);
            String b4 = a2.b();
            if (b4 != null) {
                C0601A c0601a = (C0601A) c0110z2.r(a2, "androidx.lifecycle.ViewModelProvider.DefaultKey:".concat(b4));
                this.f6013c = c0601a;
                if (c0601a.f6010x == null) {
                    c0601a.f6010x = new androidx.lifecycle.A();
                }
                c0601a.f6010x.d(this, new C0047j2(this, 21));
                C0601A c0601a2 = this.f6013c;
                if (c0601a2.y == null) {
                    c0601a2.y = new androidx.lifecycle.A();
                }
                c0601a2.y.d(this, new G1(this, 24));
            } else {
                throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
            }
        }
        if (Build.VERSION.SDK_INT >= 26) {
            this.f6014d = g(H.a());
        } else {
            Context context = getContext();
            if (context != null) {
                i = context.getColor(R.color.biometric_error_color);
            } else {
                i = 0;
            }
            this.f6014d = i;
        }
        this.f6015e = g(android.R.attr.textColorSecondary);
    }

    @Override // androidx.fragment.app.DialogInterfaceOnCancelListenerC0285u
    public final Dialog onCreateDialog(Bundle bundle) {
        CharSequence charSequence;
        CharSequence charSequence2;
        CharSequence charSequence3;
        C0092v0 c0092v0 = new C0092v0(requireContext());
        C0435e c0435e = (C0435e) c0092v0.f693b;
        v vVar = this.f6013c.f5992d;
        CharSequence charSequence4 = null;
        if (vVar != null) {
            charSequence = vVar.f6042a;
        } else {
            charSequence = null;
        }
        c0435e.f4786d = charSequence;
        View inflate = LayoutInflater.from(c0435e.f4783a).inflate(R.layout.fingerprint_dialog_layout, (ViewGroup) null);
        TextView textView = (TextView) inflate.findViewById(R.id.fingerprint_subtitle);
        if (textView != null) {
            v vVar2 = this.f6013c.f5992d;
            if (vVar2 != null) {
                charSequence3 = vVar2.f6043b;
            } else {
                charSequence3 = null;
            }
            if (TextUtils.isEmpty(charSequence3)) {
                textView.setVisibility(8);
            } else {
                textView.setVisibility(0);
                textView.setText(charSequence3);
            }
        }
        TextView textView2 = (TextView) inflate.findViewById(R.id.fingerprint_description);
        if (textView2 != null) {
            v vVar3 = this.f6013c.f5992d;
            if (vVar3 != null) {
                charSequence2 = vVar3.f6044c;
            } else {
                charSequence2 = null;
            }
            if (TextUtils.isEmpty(charSequence2)) {
                textView2.setVisibility(8);
            } else {
                textView2.setVisibility(0);
                textView2.setText(charSequence2);
            }
        }
        this.f6016f = (ImageView) inflate.findViewById(R.id.fingerprint_icon);
        this.f6017j = (TextView) inflate.findViewById(R.id.fingerprint_error);
        if (m3.b.A(this.f6013c.c())) {
            charSequence4 = getString(R.string.confirm_device_credential_password);
        } else {
            C0601A c0601a = this.f6013c;
            String str = c0601a.i;
            if (str != null) {
                charSequence4 = str;
            } else {
                v vVar4 = c0601a.f5992d;
                if (vVar4 != null && (charSequence4 = vVar4.f6045d) == null) {
                    charSequence4 = "";
                }
            }
        }
        z zVar = new z(this);
        c0435e.i = charSequence4;
        c0435e.f4791j = zVar;
        c0435e.f4796o = inflate;
        DialogInterfaceC0438h b4 = c0092v0.b();
        b4.setCanceledOnTouchOutside(false);
        return b4;
    }

    @Override // androidx.fragment.app.G
    public final void onPause() {
        super.onPause();
        this.f6011a.removeCallbacksAndMessages(null);
    }

    @Override // androidx.fragment.app.G
    public final void onResume() {
        super.onResume();
        C0601A c0601a = this.f6013c;
        c0601a.f6009w = 0;
        c0601a.f(1);
        this.f6013c.e(getString(R.string.fingerprint_dialog_touch_sensor));
    }
}
