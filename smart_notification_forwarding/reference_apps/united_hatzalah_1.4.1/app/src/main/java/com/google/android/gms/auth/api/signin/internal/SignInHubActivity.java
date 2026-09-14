package com.google.android.gms.auth.api.signin.internal;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.util.Log;
import android.view.accessibility.AccessibilityEvent;
import androidx.fragment.app.L;
import androidx.loader.content.e;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInApi;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInStatusCodes;
import com.google.android.gms.auth.api.signin.SignInAccount;
import com.google.android.gms.common.api.Status;
import f0.AbstractC0373b;
import f0.C0374c;
import f0.C0375d;
import f0.C0376e;
import f0.C0377f;
import java.lang.reflect.Modifier;
import t.C0695k;

/* loaded from: classes.dex */
public class SignInHubActivity extends L {
    private static boolean zba = false;
    private boolean zbb = false;
    private SignInConfiguration zbc;
    private boolean zbd;
    private int zbe;
    private Intent zbf;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v0, types: [androidx.lifecycle.t, java.lang.Object] */
    private final void zbc() {
        AbstractC0373b supportLoaderManager = getSupportLoaderManager();
        zbw zbwVar = new zbw(this, null);
        C0377f c0377f = (C0377f) supportLoaderManager;
        ?? r3 = c0377f.f4488a;
        C0376e c0376e = c0377f.f4489b;
        boolean z3 = c0376e.f4487c;
        C0695k c0695k = c0376e.f4486b;
        if (!z3) {
            if (Looper.getMainLooper() == Looper.myLooper()) {
                C0374c c0374c = (C0374c) c0695k.b(0);
                if (c0374c == 0) {
                    try {
                        c0376e.f4487c = true;
                        e onCreateLoader = zbwVar.onCreateLoader(0, null);
                        if (onCreateLoader != null) {
                            if (onCreateLoader.getClass().isMemberClass() && !Modifier.isStatic(onCreateLoader.getClass().getModifiers())) {
                                throw new IllegalArgumentException("Object returned from onCreateLoader must not be a non-static inner member class: " + onCreateLoader);
                            }
                            C0374c c0374c2 = new C0374c(onCreateLoader);
                            c0695k.c(0, c0374c2);
                            c0376e.f4487c = false;
                            C0375d c0375d = new C0375d(c0374c2.f4479l, zbwVar);
                            c0374c2.d(r3, c0375d);
                            C0375d c0375d2 = c0374c2.f4481n;
                            if (c0375d2 != null) {
                                c0374c2.g(c0375d2);
                            }
                            c0374c2.f4480m = r3;
                            c0374c2.f4481n = c0375d;
                        } else {
                            throw new IllegalArgumentException("Object returned from onCreateLoader must not be null");
                        }
                    } catch (Throwable th) {
                        c0376e.f4487c = false;
                        throw th;
                    }
                } else {
                    C0375d c0375d3 = new C0375d(c0374c.f4479l, zbwVar);
                    c0374c.d(r3, c0375d3);
                    C0375d c0375d4 = c0374c.f4481n;
                    if (c0375d4 != null) {
                        c0374c.g(c0375d4);
                    }
                    c0374c.f4480m = r3;
                    c0374c.f4481n = c0375d3;
                }
                zba = false;
                return;
            }
            throw new IllegalStateException("initLoader must be called on the main thread");
        }
        throw new IllegalStateException("Called while creating a loader");
    }

    private final void zbd(int i) {
        Status status = new Status(i);
        Intent intent = new Intent();
        intent.putExtra("googleSignInStatus", status);
        setResult(0, intent);
        finish();
        zba = false;
    }

    private final void zbe(String str) {
        Intent intent = new Intent(str);
        if (str.equals("com.google.android.gms.auth.GOOGLE_SIGN_IN")) {
            intent.setPackage("com.google.android.gms");
        } else {
            intent.setPackage(getPackageName());
        }
        intent.putExtra("config", this.zbc);
        try {
            startActivityForResult(intent, 40962);
        } catch (ActivityNotFoundException unused) {
            this.zbb = true;
            zbd(17);
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public final boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        return true;
    }

    @Override // androidx.fragment.app.L, c.m, android.app.Activity
    public final void onActivityResult(int i, int i3, Intent intent) {
        if (!this.zbb) {
            setResult(0);
            if (i != 40962) {
                return;
            }
            if (intent != null) {
                SignInAccount signInAccount = (SignInAccount) intent.getParcelableExtra(GoogleSignInApi.EXTRA_SIGN_IN_ACCOUNT);
                if (signInAccount != null && signInAccount.zba() != null) {
                    GoogleSignInAccount zba2 = signInAccount.zba();
                    zbn zbc = zbn.zbc(this);
                    GoogleSignInOptions zba3 = this.zbc.zba();
                    zba2.getClass();
                    zbc.zbe(zba3, zba2);
                    intent.removeExtra(GoogleSignInApi.EXTRA_SIGN_IN_ACCOUNT);
                    intent.putExtra("googleSignInAccount", zba2);
                    this.zbd = true;
                    this.zbe = i3;
                    this.zbf = intent;
                    zbc();
                    return;
                }
                if (intent.hasExtra("errorCode")) {
                    int intExtra = intent.getIntExtra("errorCode", 8);
                    if (intExtra == 13) {
                        intExtra = GoogleSignInStatusCodes.SIGN_IN_CANCELLED;
                    }
                    zbd(intExtra);
                    return;
                }
            }
            zbd(8);
        }
    }

    @Override // androidx.fragment.app.L, c.m, w.f, android.app.Activity
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Intent intent = getIntent();
        String action = intent.getAction();
        action.getClass();
        if ("com.google.android.gms.auth.NO_IMPL".equals(action)) {
            zbd(GoogleSignInStatusCodes.SIGN_IN_FAILED);
            return;
        }
        if (!action.equals("com.google.android.gms.auth.GOOGLE_SIGN_IN") && !action.equals("com.google.android.gms.auth.APPAUTH_SIGN_IN")) {
            Log.e("AuthSignInClient", "Unknown action: ".concat(String.valueOf(intent.getAction())));
            finish();
            return;
        }
        Bundle bundleExtra = intent.getBundleExtra("config");
        bundleExtra.getClass();
        SignInConfiguration signInConfiguration = (SignInConfiguration) bundleExtra.getParcelable("config");
        if (signInConfiguration == null) {
            Log.e("AuthSignInClient", "Activity started with invalid configuration.");
            setResult(0);
            finish();
            return;
        }
        this.zbc = signInConfiguration;
        if (bundle == null) {
            if (zba) {
                setResult(0);
                zbd(GoogleSignInStatusCodes.SIGN_IN_CURRENTLY_IN_PROGRESS);
                return;
            } else {
                zba = true;
                zbe(action);
                return;
            }
        }
        boolean z3 = bundle.getBoolean("signingInGoogleApiClients");
        this.zbd = z3;
        if (z3) {
            this.zbe = bundle.getInt("signInResultCode");
            Intent intent2 = (Intent) bundle.getParcelable("signInResultData");
            intent2.getClass();
            this.zbf = intent2;
            zbc();
        }
    }

    @Override // androidx.fragment.app.L, android.app.Activity
    public final void onDestroy() {
        super.onDestroy();
        zba = false;
    }

    @Override // c.m, w.f, android.app.Activity
    public final void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean("signingInGoogleApiClients", this.zbd);
        if (this.zbd) {
            bundle.putInt("signInResultCode", this.zbe);
            bundle.putParcelable("signInResultData", this.zbf);
        }
    }
}
