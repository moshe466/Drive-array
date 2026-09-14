package io.flutter.plugins.localauth;

import V.n;
import android.app.Activity;
import android.app.KeyguardManager;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import androidx.fragment.app.L;
import androidx.lifecycle.AbstractC0305o;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.embedding.engine.plugins.activity.ActivityAware;
import io.flutter.embedding.engine.plugins.activity.ActivityPluginBinding;
import io.flutter.embedding.engine.plugins.lifecycle.FlutterLifecycleAdapter;
import io.flutter.plugin.common.PluginRegistry;
import io.flutter.plugins.localauth.AuthenticationHelper;
import io.flutter.plugins.localauth.Messages;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import q.s;

/* loaded from: classes.dex */
public class LocalAuthPlugin implements FlutterPlugin, ActivityAware, Messages.LocalAuthApi {
    private static final int LOCK_REQUEST_CODE = 221;
    private Activity activity;
    private AuthenticationHelper authHelper;
    private s biometricManager;
    private KeyguardManager keyguardManager;
    private AbstractC0305o lifecycle;
    Messages.Result<Messages.AuthResult> lockRequestResult;
    final AtomicBoolean authInProgress = new AtomicBoolean(false);
    private final PluginRegistry.ActivityResultListener resultListener = new PluginRegistry.ActivityResultListener() { // from class: io.flutter.plugins.localauth.LocalAuthPlugin.1
        @Override // io.flutter.plugin.common.PluginRegistry.ActivityResultListener
        public boolean onActivityResult(int i, int i3, Intent intent) {
            LocalAuthPlugin localAuthPlugin;
            Messages.Result<Messages.AuthResult> result;
            if (i == LocalAuthPlugin.LOCK_REQUEST_CODE) {
                if (i3 == -1 && (result = (localAuthPlugin = LocalAuthPlugin.this).lockRequestResult) != null) {
                    localAuthPlugin.lambda$createAuthCompletionHandler$0(result, Messages.AuthResult.SUCCESS);
                } else {
                    LocalAuthPlugin localAuthPlugin2 = LocalAuthPlugin.this;
                    localAuthPlugin2.lambda$createAuthCompletionHandler$0(localAuthPlugin2.lockRequestResult, Messages.AuthResult.FAILURE);
                }
                LocalAuthPlugin.this.lockRequestResult = null;
                return false;
            }
            return false;
        }
    };

    private boolean canAuthenticateWithBiometrics() {
        s sVar = this.biometricManager;
        if (sVar == null || sVar.a(255) != 0) {
            return false;
        }
        return true;
    }

    private boolean hasBiometricHardware() {
        s sVar = this.biometricManager;
        if (sVar == null || sVar.a(255) == 12) {
            return false;
        }
        return true;
    }

    private void setServicesFromActivity(Activity activity) {
        if (activity == null) {
            return;
        }
        this.activity = activity;
        Context baseContext = activity.getBaseContext();
        this.biometricManager = new s(new n(activity, 1));
        this.keyguardManager = (KeyguardManager) baseContext.getSystemService("keyguard");
    }

    @Override // io.flutter.plugins.localauth.Messages.LocalAuthApi
    public void authenticate(Messages.AuthOptions authOptions, Messages.AuthStrings authStrings, Messages.Result<Messages.AuthResult> result) {
        if (this.authInProgress.get()) {
            result.success(Messages.AuthResult.ERROR_ALREADY_IN_PROGRESS);
            return;
        }
        Activity activity = this.activity;
        if (activity != null && !activity.isFinishing()) {
            if (!(this.activity instanceof L)) {
                result.success(Messages.AuthResult.ERROR_NOT_FRAGMENT_ACTIVITY);
                return;
            }
            if (!isDeviceSupported().booleanValue()) {
                result.success(Messages.AuthResult.ERROR_NOT_AVAILABLE);
                return;
            }
            boolean z3 = true;
            this.authInProgress.set(true);
            AuthenticationHelper.AuthCompletionHandler createAuthCompletionHandler = createAuthCompletionHandler(result);
            if (authOptions.getBiometricOnly().booleanValue() || !canAuthenticateWithDeviceCredential()) {
                z3 = false;
            }
            sendAuthenticationRequest(authOptions, authStrings, z3, createAuthCompletionHandler);
            return;
        }
        result.success(Messages.AuthResult.ERROR_NO_ACTIVITY);
    }

    public boolean canAuthenticateWithDeviceCredential() {
        if (Build.VERSION.SDK_INT < 30) {
            return isDeviceSecure();
        }
        s sVar = this.biometricManager;
        if (sVar == null || sVar.a(32768) != 0) {
            return false;
        }
        return true;
    }

    public AuthenticationHelper.AuthCompletionHandler createAuthCompletionHandler(final Messages.Result<Messages.AuthResult> result) {
        return new AuthenticationHelper.AuthCompletionHandler() { // from class: io.flutter.plugins.localauth.c
            @Override // io.flutter.plugins.localauth.AuthenticationHelper.AuthCompletionHandler
            public final void complete(Messages.AuthResult authResult) {
                LocalAuthPlugin.this.lambda$createAuthCompletionHandler$0(result, authResult);
            }
        };
    }

    @Override // io.flutter.plugins.localauth.Messages.LocalAuthApi
    public Boolean deviceCanSupportBiometrics() {
        return Boolean.valueOf(hasBiometricHardware());
    }

    public final Activity getActivity() {
        return this.activity;
    }

    @Override // io.flutter.plugins.localauth.Messages.LocalAuthApi
    public List<Messages.AuthClassification> getEnrolledBiometrics() {
        ArrayList arrayList = new ArrayList();
        if (this.biometricManager.a(255) == 0) {
            arrayList.add(Messages.AuthClassification.WEAK);
        }
        if (this.biometricManager.a(15) == 0) {
            arrayList.add(Messages.AuthClassification.STRONG);
        }
        return arrayList;
    }

    public boolean isDeviceSecure() {
        KeyguardManager keyguardManager = this.keyguardManager;
        if (keyguardManager == null) {
            return false;
        }
        return keyguardManager.isDeviceSecure();
    }

    @Override // io.flutter.plugins.localauth.Messages.LocalAuthApi
    public Boolean isDeviceSupported() {
        boolean z3;
        if (!isDeviceSecure() && !canAuthenticateWithBiometrics()) {
            z3 = false;
        } else {
            z3 = true;
        }
        return Boolean.valueOf(z3);
    }

    @Override // io.flutter.embedding.engine.plugins.activity.ActivityAware
    public void onAttachedToActivity(ActivityPluginBinding activityPluginBinding) {
        activityPluginBinding.addActivityResultListener(this.resultListener);
        setServicesFromActivity(activityPluginBinding.getActivity());
        this.lifecycle = FlutterLifecycleAdapter.getActivityLifecycle(activityPluginBinding);
    }

    @Override // io.flutter.embedding.engine.plugins.FlutterPlugin
    public void onAttachedToEngine(FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        Messages.LocalAuthApi.setUp(flutterPluginBinding.getBinaryMessenger(), this);
    }

    /* renamed from: onAuthenticationCompleted, reason: merged with bridge method [inline-methods] */
    public void lambda$createAuthCompletionHandler$0(Messages.Result<Messages.AuthResult> result, Messages.AuthResult authResult) {
        if (this.authInProgress.compareAndSet(true, false)) {
            result.success(authResult);
        }
    }

    @Override // io.flutter.embedding.engine.plugins.activity.ActivityAware
    public void onDetachedFromActivity() {
        this.lifecycle = null;
        this.activity = null;
    }

    @Override // io.flutter.embedding.engine.plugins.activity.ActivityAware
    public void onDetachedFromActivityForConfigChanges() {
        this.lifecycle = null;
        this.activity = null;
    }

    @Override // io.flutter.embedding.engine.plugins.FlutterPlugin
    public void onDetachedFromEngine(FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        Messages.LocalAuthApi.setUp(flutterPluginBinding.getBinaryMessenger(), null);
    }

    @Override // io.flutter.embedding.engine.plugins.activity.ActivityAware
    public void onReattachedToActivityForConfigChanges(ActivityPluginBinding activityPluginBinding) {
        activityPluginBinding.addActivityResultListener(this.resultListener);
        setServicesFromActivity(activityPluginBinding.getActivity());
        this.lifecycle = FlutterLifecycleAdapter.getActivityLifecycle(activityPluginBinding);
    }

    public void sendAuthenticationRequest(Messages.AuthOptions authOptions, Messages.AuthStrings authStrings, boolean z3, AuthenticationHelper.AuthCompletionHandler authCompletionHandler) {
        AuthenticationHelper authenticationHelper = new AuthenticationHelper(this.lifecycle, (L) this.activity, authOptions, authStrings, authCompletionHandler, z3);
        this.authHelper = authenticationHelper;
        authenticationHelper.authenticate();
    }

    public void setBiometricManager(s sVar) {
        this.biometricManager = sVar;
    }

    public void setKeyguardManager(KeyguardManager keyguardManager) {
        this.keyguardManager = keyguardManager;
    }

    @Override // io.flutter.plugins.localauth.Messages.LocalAuthApi
    public Boolean stopAuthentication() {
        try {
            if (this.authHelper != null && this.authInProgress.get()) {
                this.authHelper.stopAuthentication();
                this.authHelper = null;
            }
            this.authInProgress.set(false);
            return Boolean.TRUE;
        } catch (Exception unused) {
            return Boolean.FALSE;
        }
    }
}
