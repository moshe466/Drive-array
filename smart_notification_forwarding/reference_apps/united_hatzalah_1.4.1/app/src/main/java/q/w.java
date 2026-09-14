package q;

import F0.C0110z2;
import android.os.Build;
import android.util.Log;
import androidx.fragment.app.AbstractC0272g0;
import androidx.fragment.app.C0259a;
import androidx.fragment.app.L;
import androidx.lifecycle.X;
import androidx.lifecycle.Z;
import com.uh.sf.R;
import d0.AbstractC0356b;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public final class w {

    /* renamed from: a, reason: collision with root package name */
    public final AbstractC0272g0 f6048a;

    public w(L l3, Executor executor, t tVar) {
        if (l3 != null) {
            if (executor != null) {
                AbstractC0272g0 supportFragmentManager = l3.getSupportFragmentManager();
                Z store = l3.getViewModelStore();
                X factory = l3.getDefaultViewModelProviderFactory();
                AbstractC0356b defaultCreationExtras = l3.getDefaultViewModelCreationExtras();
                kotlin.jvm.internal.j.e(store, "store");
                kotlin.jvm.internal.j.e(factory, "factory");
                kotlin.jvm.internal.j.e(defaultCreationExtras, "defaultCreationExtras");
                C0110z2 c0110z2 = new C0110z2(store, factory, defaultCreationExtras);
                kotlin.jvm.internal.e a2 = kotlin.jvm.internal.s.a(C0601A.class);
                String b4 = a2.b();
                if (b4 != null) {
                    C0601A c0601a = (C0601A) c0110z2.r(a2, "androidx.lifecycle.ViewModelProvider.DefaultKey:".concat(b4));
                    this.f6048a = supportFragmentManager;
                    c0601a.f5990b = executor;
                    c0601a.f5991c = tVar;
                    return;
                }
                throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
            }
            throw new IllegalArgumentException("Executor must not be null.");
        }
        throw new IllegalArgumentException("FragmentActivity must not be null.");
    }

    public final void a(v vVar) {
        if (vVar != null) {
            AbstractC0272g0 abstractC0272g0 = this.f6048a;
            if (abstractC0272g0 == null) {
                Log.e("BiometricPromptCompat", "Unable to start authentication. Client fragment manager was null.");
                return;
            }
            if (abstractC0272g0.N()) {
                Log.e("BiometricPromptCompat", "Unable to start authentication. Called after onSaveInstanceState().");
                return;
            }
            AbstractC0272g0 abstractC0272g02 = this.f6048a;
            p pVar = (p) abstractC0272g02.D("androidx.biometric.BiometricFragment");
            if (pVar == null) {
                pVar = new p();
                C0259a c0259a = new C0259a(abstractC0272g02);
                c0259a.c(0, pVar, "androidx.biometric.BiometricFragment");
                c0259a.f(true, true);
                abstractC0272g02.z(true);
                abstractC0272g02.E();
            }
            L activity = pVar.getActivity();
            if (activity == null) {
                Log.e("BiometricFragment", "Not launching prompt. Client activity was null.");
                return;
            }
            C0601A c0601a = pVar.f6036b;
            c0601a.f5992d = vVar;
            int i = vVar.f6047f;
            if (i == 0) {
                i = 255;
            }
            if (Build.VERSION.SDK_INT < 30 && i == 15) {
                c0601a.f5993e = p3.h.m();
            } else {
                c0601a.f5993e = null;
            }
            if (pVar.h()) {
                pVar.f6036b.i = pVar.getString(R.string.confirm_device_credential_password);
            } else {
                pVar.f6036b.i = null;
            }
            if (pVar.h() && new s(new V.n(activity, 1)).a(255) != 0) {
                pVar.f6036b.f5999l = true;
                pVar.j();
                return;
            } else if (pVar.f6036b.f6001n) {
                pVar.f6035a.postDelayed(new o(pVar), 600L);
                return;
            } else {
                pVar.n();
                return;
            }
        }
        throw new IllegalArgumentException("PromptInfo cannot be null.");
    }
}
