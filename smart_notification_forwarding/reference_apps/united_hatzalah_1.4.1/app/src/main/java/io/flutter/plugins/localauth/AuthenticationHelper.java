package io.flutter.plugins.localauth;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Application;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.AbstractC0272g0;
import androidx.fragment.app.L;
import androidx.lifecycle.AbstractC0305o;
import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.InterfaceC0309t;
import io.flutter.plugins.localauth.Messages;
import java.util.concurrent.Executor;
import q.p;
import q.t;
import q.u;
import q.v;
import q.w;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class AuthenticationHelper extends t implements Application.ActivityLifecycleCallbacks, DefaultLifecycleObserver {
    private final L activity;
    private w biometricPrompt;
    private final AuthCompletionHandler completionHandler;
    private final boolean isAuthSticky;
    private final AbstractC0305o lifecycle;
    private final v promptInfo;
    private final Messages.AuthStrings strings;
    private final boolean useErrorDialogs;
    private boolean activityPaused = false;
    private final UiThreadExecutor uiThreadExecutor = new UiThreadExecutor();

    /* loaded from: classes.dex */
    public interface AuthCompletionHandler {
        void complete(Messages.AuthResult authResult);
    }

    /* loaded from: classes.dex */
    public static class UiThreadExecutor implements Executor {
        final Handler handler = new Handler(Looper.getMainLooper());

        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            this.handler.post(runnable);
        }
    }

    public AuthenticationHelper(AbstractC0305o abstractC0305o, L l3, Messages.AuthOptions authOptions, Messages.AuthStrings authStrings, AuthCompletionHandler authCompletionHandler, boolean z3) {
        String cancelButton;
        int i;
        String str;
        this.lifecycle = abstractC0305o;
        this.activity = l3;
        this.completionHandler = authCompletionHandler;
        this.strings = authStrings;
        this.isAuthSticky = authOptions.getSticky().booleanValue();
        this.useErrorDialogs = authOptions.getUseErrorDialgs().booleanValue();
        String reason = authStrings.getReason();
        String signInTitle = authStrings.getSignInTitle();
        String biometricHint = authStrings.getBiometricHint();
        boolean booleanValue = authOptions.getSensitiveTransaction().booleanValue();
        if (z3) {
            cancelButton = null;
            i = 33023;
        } else {
            cancelButton = authStrings.getCancelButton();
            i = 255;
        }
        String str2 = cancelButton;
        if (!TextUtils.isEmpty(signInTitle)) {
            if (!m3.b.C(i)) {
                StringBuilder sb = new StringBuilder("Authenticator combination is unsupported on API ");
                sb.append(Build.VERSION.SDK_INT);
                sb.append(": ");
                if (i != 15) {
                    if (i != 255) {
                        if (i != 32768) {
                            if (i != 32783) {
                                if (i != 33023) {
                                    str = String.valueOf(i);
                                } else {
                                    str = "BIOMETRIC_WEAK | DEVICE_CREDENTIAL";
                                }
                            } else {
                                str = "BIOMETRIC_STRONG | DEVICE_CREDENTIAL";
                            }
                        } else {
                            str = "DEVICE_CREDENTIAL";
                        }
                    } else {
                        str = "BIOMETRIC_WEAK";
                    }
                } else {
                    str = "BIOMETRIC_STRONG";
                }
                sb.append(str);
                throw new IllegalArgumentException(sb.toString());
            }
            boolean A3 = i != 0 ? m3.b.A(i) : false;
            if (TextUtils.isEmpty(str2) && !A3) {
                throw new IllegalArgumentException("Negative text must be set and non-empty.");
            }
            if (!TextUtils.isEmpty(str2) && A3) {
                throw new IllegalArgumentException("Negative text must not be set if device credential authentication is allowed.");
            }
            this.promptInfo = new v(signInTitle, biometricHint, reason, str2, booleanValue, i);
            return;
        }
        throw new IllegalArgumentException("Title must be set and non-empty.");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onActivityResumed$0(w wVar) {
        wVar.a(this.promptInfo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showGoToSettingsDialog$1(DialogInterface dialogInterface, int i) {
        this.completionHandler.complete(Messages.AuthResult.FAILURE);
        stop();
        this.activity.startActivity(new Intent("android.settings.SECURITY_SETTINGS"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showGoToSettingsDialog$2(DialogInterface dialogInterface, int i) {
        this.completionHandler.complete(Messages.AuthResult.FAILURE);
        stop();
    }

    private void showGoToSettingsDialog(String str, String str2) {
        View inflate = LayoutInflater.from(this.activity).inflate(R.layout.go_to_setting, (ViewGroup) null, false);
        TextView textView = (TextView) inflate.findViewById(R.id.fingerprint_required);
        TextView textView2 = (TextView) inflate.findViewById(R.id.go_to_setting_description);
        textView.setText(str);
        textView2.setText(str2);
        ContextThemeWrapper contextThemeWrapper = new ContextThemeWrapper(this.activity, R.style.AlertDialogCustom);
        final int i = 0;
        DialogInterface.OnClickListener onClickListener = new DialogInterface.OnClickListener(this) { // from class: io.flutter.plugins.localauth.a

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ AuthenticationHelper f5084b;

            {
                this.f5084b = this;
            }

            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                switch (i) {
                    case 0:
                        this.f5084b.lambda$showGoToSettingsDialog$1(dialogInterface, i3);
                        return;
                    default:
                        this.f5084b.lambda$showGoToSettingsDialog$2(dialogInterface, i3);
                        return;
                }
            }
        };
        final int i3 = 1;
        new AlertDialog.Builder(contextThemeWrapper).setView(inflate).setPositiveButton(this.strings.getGoToSettingsButton(), onClickListener).setNegativeButton(this.strings.getCancelButton(), new DialogInterface.OnClickListener(this) { // from class: io.flutter.plugins.localauth.a

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ AuthenticationHelper f5084b;

            {
                this.f5084b = this;
            }

            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i32) {
                switch (i3) {
                    case 0:
                        this.f5084b.lambda$showGoToSettingsDialog$1(dialogInterface, i32);
                        return;
                    default:
                        this.f5084b.lambda$showGoToSettingsDialog$2(dialogInterface, i32);
                        return;
                }
            }
        }).setCancelable(false).show();
    }

    private void stop() {
        AbstractC0305o abstractC0305o = this.lifecycle;
        if (abstractC0305o != null) {
            abstractC0305o.b(this);
        } else {
            this.activity.getApplication().unregisterActivityLifecycleCallbacks(this);
        }
    }

    public void authenticate() {
        AbstractC0305o abstractC0305o = this.lifecycle;
        if (abstractC0305o != null) {
            abstractC0305o.a(this);
        } else {
            this.activity.getApplication().registerActivityLifecycleCallbacks(this);
        }
        w wVar = new w(this.activity, this.uiThreadExecutor, this);
        this.biometricPrompt = wVar;
        wVar.a(this.promptInfo);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
        if (this.isAuthSticky) {
            this.activityPaused = true;
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
        if (this.isAuthSticky) {
            this.activityPaused = false;
            final w wVar = new w(this.activity, this.uiThreadExecutor, this);
            this.uiThreadExecutor.handler.post(new Runnable() { // from class: io.flutter.plugins.localauth.b
                @Override // java.lang.Runnable
                public final void run() {
                    AuthenticationHelper.this.lambda$onActivityResumed$0(wVar);
                }
            });
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
    }

    @Override // q.t
    public void onAuthenticationError(int i, CharSequence charSequence) {
        if (i != 1) {
            if (i != 7) {
                if (i != 9) {
                    if (i != 14) {
                        if (i != 4) {
                            if (i != 5) {
                                if (i != 11) {
                                    if (i != 12) {
                                        this.completionHandler.complete(Messages.AuthResult.FAILURE);
                                    }
                                }
                            } else if (this.activityPaused && this.isAuthSticky) {
                                return;
                            } else {
                                this.completionHandler.complete(Messages.AuthResult.FAILURE);
                            }
                        }
                        if (this.useErrorDialogs) {
                            showGoToSettingsDialog(this.strings.getBiometricRequiredTitle(), this.strings.getGoToSettingsDescription());
                            return;
                        }
                        this.completionHandler.complete(Messages.AuthResult.ERROR_NOT_ENROLLED);
                    } else {
                        if (this.useErrorDialogs) {
                            showGoToSettingsDialog(this.strings.getDeviceCredentialsRequiredTitle(), this.strings.getDeviceCredentialsSetupDescription());
                            return;
                        }
                        this.completionHandler.complete(Messages.AuthResult.ERROR_NOT_AVAILABLE);
                    }
                } else {
                    this.completionHandler.complete(Messages.AuthResult.ERROR_LOCKED_OUT_PERMANENTLY);
                }
            } else {
                this.completionHandler.complete(Messages.AuthResult.ERROR_LOCKED_OUT_TEMPORARILY);
            }
            stop();
        }
        this.completionHandler.complete(Messages.AuthResult.ERROR_NOT_AVAILABLE);
        stop();
    }

    @Override // q.t
    public void onAuthenticationFailed() {
    }

    @Override // q.t
    public void onAuthenticationSucceeded(u uVar) {
        this.completionHandler.complete(Messages.AuthResult.SUCCESS);
        stop();
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public void onCreate(InterfaceC0309t interfaceC0309t) {
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public void onDestroy(InterfaceC0309t interfaceC0309t) {
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public void onPause(InterfaceC0309t interfaceC0309t) {
        onActivityPaused(null);
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public void onResume(InterfaceC0309t interfaceC0309t) {
        onActivityResumed(null);
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public void onStart(InterfaceC0309t interfaceC0309t) {
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public void onStop(InterfaceC0309t interfaceC0309t) {
    }

    public void stopAuthentication() {
        w wVar = this.biometricPrompt;
        if (wVar != null) {
            AbstractC0272g0 abstractC0272g0 = wVar.f6048a;
            if (abstractC0272g0 == null) {
                Log.e("BiometricPromptCompat", "Unable to start authentication. Client fragment manager was null.");
            } else {
                p pVar = (p) abstractC0272g0.D("androidx.biometric.BiometricFragment");
                if (pVar == null) {
                    Log.e("BiometricPromptCompat", "Unable to cancel authentication. BiometricFragment not found.");
                } else {
                    pVar.f(3);
                }
            }
            this.biometricPrompt = null;
        }
    }
}
