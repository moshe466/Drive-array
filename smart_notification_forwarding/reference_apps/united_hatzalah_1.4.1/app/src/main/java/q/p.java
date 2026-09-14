package q;

import F0.C0021d0;
import F0.C0110z2;
import F0.G1;
import F0.RunnableC0091v;
import android.app.KeyguardManager;
import android.content.Context;
import android.content.Intent;
import android.hardware.biometrics.BiometricPrompt;
import android.hardware.biometrics.BiometricPrompt$AuthenticationCallback;
import android.hardware.fingerprint.FingerprintManager;
import android.os.Build;
import android.os.Bundle;
import android.os.CancellationSignal;
import android.os.Handler;
import android.os.Looper;
import android.security.identity.IdentityCredential;
import android.text.TextUtils;
import android.util.Log;
import androidx.fragment.app.AbstractC0272g0;
import androidx.fragment.app.C0259a;
import androidx.fragment.app.L;
import androidx.lifecycle.X;
import androidx.lifecycle.Z;
import com.uh.sf.R;
import d0.AbstractC0356b;
import java.security.Signature;
import java.util.concurrent.Executor;
import javax.crypto.Cipher;
import javax.crypto.Mac;

/* loaded from: classes.dex */
public class p extends androidx.fragment.app.G {

    /* renamed from: a, reason: collision with root package name */
    public final Handler f6035a = new Handler(Looper.getMainLooper());

    /* renamed from: b, reason: collision with root package name */
    public C0601A f6036b;

    public final void dismiss() {
        this.f6036b.f5998k = false;
        g();
        if (!this.f6036b.f6000m && isAdded()) {
            AbstractC0272g0 parentFragmentManager = getParentFragmentManager();
            parentFragmentManager.getClass();
            C0259a c0259a = new C0259a(parentFragmentManager);
            c0259a.h(this);
            c0259a.f(true, true);
        }
        Context context = getContext();
        if (context != null) {
            String str = Build.MODEL;
            if (Build.VERSION.SDK_INT == 29 && str != null) {
                for (String str2 : context.getResources().getStringArray(R.array.delay_showing_prompt_models)) {
                    if (str.equals(str2)) {
                        C0601A c0601a = this.f6036b;
                        c0601a.f6001n = true;
                        this.f6035a.postDelayed(new o(c0601a, 1), 600L);
                        return;
                    }
                }
            }
        }
    }

    public final void f(int i) {
        if (i == 3 || !this.f6036b.f6002o) {
            if (i()) {
                this.f6036b.f5997j = i;
                if (i == 1) {
                    l(10, E1.b.p(getContext(), 10));
                }
            }
            C0601A c0601a = this.f6036b;
            if (c0601a.f5995g == null) {
                c0601a.f5995g = new C0021d0();
            }
            C0021d0 c0021d0 = c0601a.f5995g;
            CancellationSignal cancellationSignal = (CancellationSignal) c0021d0.f479a;
            if (cancellationSignal != null) {
                try {
                    AbstractC0603C.a(cancellationSignal);
                } catch (NullPointerException e4) {
                    Log.e("CancelSignalProvider", "Got NPE while canceling biometric authentication.", e4);
                }
                c0021d0.f479a = null;
            }
            F.c cVar = (F.c) c0021d0.f480b;
            if (cVar != null) {
                try {
                    cVar.a();
                } catch (NullPointerException e5) {
                    Log.e("CancelSignalProvider", "Got NPE while canceling fingerprint authentication.", e5);
                }
                c0021d0.f480b = null;
            }
        }
    }

    public final void g() {
        this.f6036b.f5998k = false;
        if (isAdded()) {
            AbstractC0272g0 parentFragmentManager = getParentFragmentManager();
            I i = (I) parentFragmentManager.D("androidx.biometric.FingerprintDialogFragment");
            if (i != null) {
                if (i.isAdded()) {
                    i.dismissAllowingStateLoss();
                    return;
                }
                C0259a c0259a = new C0259a(parentFragmentManager);
                c0259a.h(i);
                c0259a.f(true, true);
            }
        }
    }

    public final boolean h() {
        if (Build.VERSION.SDK_INT <= 28 && m3.b.A(this.f6036b.c())) {
            return true;
        }
        return false;
    }

    public final boolean i() {
        int i = Build.VERSION.SDK_INT;
        if (i >= 28) {
            L activity = getActivity();
            if (activity != null && this.f6036b.f5993e != null) {
                String str = Build.MANUFACTURER;
                String str2 = Build.MODEL;
                if (i == 28) {
                    if (str != null) {
                        for (String str3 : activity.getResources().getStringArray(R.array.crypto_fingerprint_fallback_vendors)) {
                            if (str.equalsIgnoreCase(str3)) {
                                break;
                            }
                        }
                    }
                    String str4 = Build.MODEL;
                    if (str4 != null) {
                        for (String str5 : activity.getResources().getStringArray(R.array.crypto_fingerprint_fallback_prefixes)) {
                            if (!str4.startsWith(str5)) {
                            }
                        }
                    }
                }
            }
            if (Build.VERSION.SDK_INT != 28) {
                return false;
            }
            Context context = getContext();
            if (context == null || context.getPackageManager() == null || !K.a(context.getPackageManager())) {
                return true;
            }
            return false;
        }
        return true;
    }

    public final void j() {
        CharSequence charSequence;
        CharSequence charSequence2;
        L activity = getActivity();
        if (activity == null) {
            Log.e("BiometricFragment", "Failed to check device credential. Client FragmentActivity not found.");
            return;
        }
        KeyguardManager a2 = J.a(activity);
        if (a2 == null) {
            k(12, getString(R.string.generic_error_no_keyguard));
            return;
        }
        v vVar = this.f6036b.f5992d;
        CharSequence charSequence3 = null;
        if (vVar != null) {
            charSequence = vVar.f6042a;
        } else {
            charSequence = null;
        }
        if (vVar != null) {
            charSequence2 = vVar.f6043b;
        } else {
            charSequence2 = null;
        }
        if (vVar != null) {
            charSequence3 = vVar.f6044c;
        }
        if (charSequence2 == null) {
            charSequence2 = charSequence3;
        }
        Intent a4 = AbstractC0614k.a(a2, charSequence, charSequence2);
        if (a4 == null) {
            k(14, getString(R.string.generic_error_no_device_credential));
            return;
        }
        this.f6036b.f6000m = true;
        if (i()) {
            g();
        }
        a4.setFlags(134742016);
        startActivityForResult(a4, 1);
    }

    public final void k(int i, CharSequence charSequence) {
        l(i, charSequence);
        dismiss();
    }

    public final void l(int i, CharSequence charSequence) {
        C0601A c0601a = this.f6036b;
        if (c0601a.f6000m || !c0601a.f5999l) {
            return;
        }
        c0601a.f5999l = false;
        Executor executor = c0601a.f5990b;
        if (executor == null) {
            executor = new F.d(3);
        }
        executor.execute(new RunnableC0609f(this, i, charSequence, 0));
    }

    public final void m(CharSequence charSequence) {
        if (charSequence == null) {
            charSequence = getString(R.string.default_error_msg);
        }
        this.f6036b.f(2);
        this.f6036b.e(charSequence);
    }

    public final void n() {
        CharSequence charSequence;
        CharSequence charSequence2;
        CharSequence charSequence3;
        int i;
        if (!this.f6036b.f5998k && getContext() != null) {
            C0601A c0601a = this.f6036b;
            c0601a.f5998k = true;
            c0601a.f5999l = true;
            CharSequence charSequence4 = null;
            r2 = null;
            r2 = null;
            r2 = null;
            C0110z2 c0110z2 = null;
            boolean z3 = false;
            if (i()) {
                Context applicationContext = requireContext().getApplicationContext();
                C.b bVar = new C.b(applicationContext);
                FingerprintManager b4 = C.b.b(applicationContext);
                if (b4 != null && b4.isHardwareDetected()) {
                    FingerprintManager b5 = C.b.b(applicationContext);
                    if (b5 != null && b5.hasEnrolledFingerprints()) {
                        i = 0;
                    } else {
                        i = 11;
                    }
                } else {
                    i = 12;
                }
                if (i != 0) {
                    k(i, E1.b.p(applicationContext, i));
                    return;
                }
                if (isAdded()) {
                    this.f6036b.f6007u = true;
                    String str = Build.MODEL;
                    if (Build.VERSION.SDK_INT == 28 && str != null) {
                        for (String str2 : applicationContext.getResources().getStringArray(R.array.hide_fingerprint_instantly_prefixes)) {
                            if (str.startsWith(str2)) {
                                break;
                            }
                        }
                    }
                    this.f6035a.postDelayed(new RunnableC0610g(this, 1), 500L);
                    new I().show(getParentFragmentManager(), "androidx.biometric.FingerprintDialogFragment");
                    C0601A c0601a2 = this.f6036b;
                    c0601a2.f5997j = 0;
                    K1.m mVar = c0601a2.f5993e;
                    if (mVar != null) {
                        Cipher cipher = (Cipher) mVar.f1103b;
                        if (cipher != null) {
                            c0110z2 = new C0110z2(cipher);
                        } else {
                            Signature signature = (Signature) mVar.f1102a;
                            if (signature != null) {
                                c0110z2 = new C0110z2(signature);
                            } else {
                                Mac mac = (Mac) mVar.f1104c;
                                if (mac != null) {
                                    c0110z2 = new C0110z2(mac);
                                } else if (Build.VERSION.SDK_INT >= 30 && ((IdentityCredential) mVar.f1105d) != null) {
                                    Log.e("CryptoObjectUtils", "Identity credential is not supported by FingerprintManager.");
                                }
                            }
                        }
                    }
                    C0601A c0601a3 = this.f6036b;
                    if (c0601a3.f5995g == null) {
                        c0601a3.f5995g = new C0021d0();
                    }
                    C0021d0 c0021d0 = c0601a3.f5995g;
                    if (((F.c) c0021d0.f480b) == null) {
                        c0021d0.f480b = new Object();
                    }
                    F.c cVar = (F.c) c0021d0.f480b;
                    C0601A c0601a4 = this.f6036b;
                    if (c0601a4.f5994f == null) {
                        c0601a4.f5994f = new C0110z2(new y(c0601a4));
                    }
                    C0110z2 c0110z22 = c0601a4.f5994f;
                    if (((G1) c0110z22.f730c) == null) {
                        c0110z22.f730c = new G1(c0110z22, 23);
                    }
                    try {
                        bVar.a(c0110z2, cVar, (G1) c0110z22.f730c);
                        return;
                    } catch (NullPointerException e4) {
                        Log.e("BiometricFragment", "Got NPE while authenticating with fingerprint.", e4);
                        k(1, E1.b.p(applicationContext, 1));
                        return;
                    }
                }
                return;
            }
            BiometricPrompt.Builder d2 = l.d(requireContext().getApplicationContext());
            v vVar = this.f6036b.f5992d;
            if (vVar != null) {
                charSequence = vVar.f6042a;
            } else {
                charSequence = null;
            }
            if (vVar != null) {
                charSequence2 = vVar.f6043b;
            } else {
                charSequence2 = null;
            }
            if (vVar != null) {
                charSequence3 = vVar.f6044c;
            } else {
                charSequence3 = null;
            }
            if (charSequence != null) {
                l.h(d2, charSequence);
            }
            if (charSequence2 != null) {
                l.g(d2, charSequence2);
            }
            if (charSequence3 != null) {
                l.e(d2, charSequence3);
            }
            C0601A c0601a5 = this.f6036b;
            String str3 = c0601a5.i;
            String str4 = "";
            if (str3 != null) {
                charSequence4 = str3;
            } else {
                v vVar2 = c0601a5.f5992d;
                if (vVar2 != null && (charSequence4 = vVar2.f6045d) == null) {
                    charSequence4 = "";
                }
            }
            if (!TextUtils.isEmpty(charSequence4)) {
                Executor executor = this.f6036b.f5990b;
                if (executor == null) {
                    executor = new F.d(3);
                }
                C0601A c0601a6 = this.f6036b;
                if (c0601a6.f5996h == null) {
                    c0601a6.f5996h = new z(c0601a6);
                }
                l.f(d2, charSequence4, executor, c0601a6.f5996h);
            }
            int i3 = Build.VERSION.SDK_INT;
            if (i3 >= 29) {
                v vVar3 = this.f6036b.f5992d;
                if (vVar3 == null || vVar3.f6046e) {
                    z3 = true;
                }
                m.a(d2, z3);
            }
            int c4 = this.f6036b.c();
            if (i3 >= 30) {
                n.a(d2, c4);
            } else if (i3 >= 29) {
                m.b(d2, m3.b.A(c4));
            }
            BiometricPrompt c5 = l.c(d2);
            Context context = getContext();
            BiometricPrompt.CryptoObject K3 = p3.h.K(this.f6036b.f5993e);
            C0601A c0601a7 = this.f6036b;
            if (c0601a7.f5995g == null) {
                c0601a7.f5995g = new C0021d0();
            }
            C0021d0 c0021d02 = c0601a7.f5995g;
            if (((CancellationSignal) c0021d02.f479a) == null) {
                c0021d02.f479a = AbstractC0603C.b();
            }
            CancellationSignal cancellationSignal = (CancellationSignal) c0021d02.f479a;
            F.d dVar = new F.d(2);
            C0601A c0601a8 = this.f6036b;
            if (c0601a8.f5994f == null) {
                c0601a8.f5994f = new C0110z2(new y(c0601a8));
            }
            C0110z2 c0110z23 = c0601a8.f5994f;
            if (((BiometricPrompt$AuthenticationCallback) c0110z23.f729b) == null) {
                c0110z23.f729b = AbstractC0605b.a((y) c0110z23.f731d);
            }
            BiometricPrompt$AuthenticationCallback biometricPrompt$AuthenticationCallback = (BiometricPrompt$AuthenticationCallback) c0110z23.f729b;
            try {
                if (K3 == null) {
                    l.b(c5, cancellationSignal, dVar, biometricPrompt$AuthenticationCallback);
                } else {
                    l.a(c5, K3, cancellationSignal, dVar, biometricPrompt$AuthenticationCallback);
                }
            } catch (NullPointerException e5) {
                Log.e("BiometricFragment", "Got NPE while authenticating with biometric prompt.", e5);
                if (context != null) {
                    str4 = context.getString(R.string.default_error_msg);
                }
                k(1, str4);
            }
        }
    }

    @Override // androidx.fragment.app.G
    public final void onActivityResult(int i, int i3, Intent intent) {
        super.onActivityResult(i, i3, intent);
        if (i == 1) {
            C0601A c0601a = this.f6036b;
            c0601a.f6000m = false;
            if (i3 == -1) {
                u uVar = new u(null, 1);
                if (c0601a.f5999l) {
                    c0601a.f5999l = false;
                    Executor executor = c0601a.f5990b;
                    if (executor == null) {
                        executor = new F.d(3);
                    }
                    executor.execute(new RunnableC0091v(this, uVar, 6, false));
                }
                dismiss();
                return;
            }
            k(10, getString(R.string.generic_error_user_canceled));
        }
    }

    /* JADX WARN: Type inference failed for: r0v17, types: [androidx.lifecycle.B, androidx.lifecycle.A] */
    /* JADX WARN: Type inference failed for: r0v18, types: [androidx.lifecycle.B, androidx.lifecycle.A] */
    /* JADX WARN: Type inference failed for: r0v19, types: [androidx.lifecycle.B, androidx.lifecycle.A] */
    /* JADX WARN: Type inference failed for: r0v20, types: [androidx.lifecycle.B, androidx.lifecycle.A] */
    /* JADX WARN: Type inference failed for: r0v21, types: [androidx.lifecycle.B, androidx.lifecycle.A] */
    /* JADX WARN: Type inference failed for: r0v22, types: [androidx.lifecycle.B, androidx.lifecycle.A] */
    @Override // androidx.fragment.app.G
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (getActivity() == null) {
            return;
        }
        L owner = getActivity();
        kotlin.jvm.internal.j.e(owner, "owner");
        Z store = owner.getViewModelStore();
        X factory = owner.getDefaultViewModelProviderFactory();
        AbstractC0356b defaultCreationExtras = owner.getDefaultViewModelCreationExtras();
        kotlin.jvm.internal.j.e(store, "store");
        kotlin.jvm.internal.j.e(factory, "factory");
        kotlin.jvm.internal.j.e(defaultCreationExtras, "defaultCreationExtras");
        C0110z2 c0110z2 = new C0110z2(store, factory, defaultCreationExtras);
        kotlin.jvm.internal.e a2 = kotlin.jvm.internal.s.a(C0601A.class);
        String b4 = a2.b();
        if (b4 != null) {
            C0601A c0601a = (C0601A) c0110z2.r(a2, "androidx.lifecycle.ViewModelProvider.DefaultKey:".concat(b4));
            this.f6036b = c0601a;
            if (c0601a.p == null) {
                c0601a.p = new androidx.lifecycle.A();
            }
            c0601a.p.d(this, new C0611h(this, 0));
            C0601A c0601a2 = this.f6036b;
            if (c0601a2.f6003q == null) {
                c0601a2.f6003q = new androidx.lifecycle.A();
            }
            c0601a2.f6003q.d(this, new C0612i(this, 0));
            C0601A c0601a3 = this.f6036b;
            if (c0601a3.f6004r == null) {
                c0601a3.f6004r = new androidx.lifecycle.A();
            }
            c0601a3.f6004r.d(this, new C0613j(this, 0));
            C0601A c0601a4 = this.f6036b;
            if (c0601a4.f6005s == null) {
                c0601a4.f6005s = new androidx.lifecycle.A();
            }
            c0601a4.f6005s.d(this, new C0611h(this, 1));
            C0601A c0601a5 = this.f6036b;
            if (c0601a5.f6006t == null) {
                c0601a5.f6006t = new androidx.lifecycle.A();
            }
            c0601a5.f6006t.d(this, new C0612i(this, 1));
            C0601A c0601a6 = this.f6036b;
            if (c0601a6.f6008v == null) {
                c0601a6.f6008v = new androidx.lifecycle.A();
            }
            c0601a6.f6008v.d(this, new C0613j(this, 1));
            return;
        }
        throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
    }

    @Override // androidx.fragment.app.G
    public final void onStart() {
        super.onStart();
        if (Build.VERSION.SDK_INT == 29 && m3.b.A(this.f6036b.c())) {
            C0601A c0601a = this.f6036b;
            c0601a.f6002o = true;
            this.f6035a.postDelayed(new o(c0601a, 2), 250L);
        }
    }

    @Override // androidx.fragment.app.G
    public final void onStop() {
        super.onStop();
        if (Build.VERSION.SDK_INT < 29 && !this.f6036b.f6000m) {
            L activity = getActivity();
            if (activity == null || !activity.isChangingConfigurations()) {
                f(0);
            }
        }
    }
}
