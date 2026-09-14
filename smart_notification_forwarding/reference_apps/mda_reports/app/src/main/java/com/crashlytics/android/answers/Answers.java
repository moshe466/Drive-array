package com.crashlytics.android.answers;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import io.fabric.sdk.android.Fabric;
import io.fabric.sdk.android.Kit;
import io.fabric.sdk.android.services.common.CommonUtils;
import io.fabric.sdk.android.services.common.Crash;
import io.fabric.sdk.android.services.common.DataCollectionArbiter;
import io.fabric.sdk.android.services.common.FirebaseInfo;
import io.fabric.sdk.android.services.common.IdManager;
import io.fabric.sdk.android.services.settings.Settings;
import io.fabric.sdk.android.services.settings.SettingsData;
import java.io.File;

/* loaded from: classes.dex */
public class Answers extends Kit<Boolean> {
    public static final String TAG = "Answers";
    boolean g = false;
    SessionAnalyticsManager h;

    public static Answers getInstance() {
        return (Answers) Fabric.getKit(Answers.class);
    }

    private void logFirebaseModeEnabledWarning(String str) {
        Fabric.getLogger().w(TAG, "Method " + str + " is not supported when using Crashlytics through Firebase.");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // io.fabric.sdk.android.Kit
    public Boolean a() {
        if (!DataCollectionArbiter.getInstance(getContext()).isDataCollectionEnabled()) {
            Fabric.getLogger().d(Fabric.TAG, "Analytics collection disabled, because data collection is disabled by Firebase.");
            this.h.disable();
            return false;
        }
        try {
            SettingsData awaitSettingsData = Settings.getInstance().awaitSettingsData();
            if (awaitSettingsData == null) {
                Fabric.getLogger().e(TAG, "Failed to retrieve settings");
                return false;
            }
            if (awaitSettingsData.featuresData.collectAnalytics) {
                Fabric.getLogger().d(TAG, "Analytics collection enabled");
                this.h.setAnalyticsSettingsData(awaitSettingsData.analyticsSettingsData, g());
                return true;
            }
            Fabric.getLogger().d(TAG, "Analytics collection disabled");
            this.h.disable();
            return false;
        } catch (Exception e) {
            Fabric.getLogger().e(TAG, "Error dealing with settings", e);
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.fabric.sdk.android.Kit
    @SuppressLint({"NewApi"})
    public boolean f() {
        try {
            Context context = getContext();
            PackageManager packageManager = context.getPackageManager();
            String packageName = context.getPackageName();
            PackageInfo packageInfo = packageManager.getPackageInfo(packageName, 0);
            this.h = SessionAnalyticsManager.build(this, context, c(), Integer.toString(packageInfo.versionCode), packageInfo.versionName == null ? IdManager.DEFAULT_VERSION_NAME : packageInfo.versionName, Build.VERSION.SDK_INT >= 9 ? packageInfo.firstInstallTime : new File(packageManager.getApplicationInfo(packageName, 0).sourceDir).lastModified());
            this.h.enable();
            this.g = new FirebaseInfo().isFirebaseCrashlyticsEnabled(context);
            return true;
        } catch (Exception e) {
            Fabric.getLogger().e(TAG, "Error retrieving app properties", e);
            return false;
        }
    }

    String g() {
        return CommonUtils.getStringsFileValue(getContext(), "com.crashlytics.ApiEndpoint");
    }

    @Override // io.fabric.sdk.android.Kit
    public String getIdentifier() {
        return "com.crashlytics.sdk.android:answers";
    }

    @Override // io.fabric.sdk.android.Kit
    public String getVersion() {
        return "1.4.7.32";
    }

    public void logAddToCart(AddToCartEvent addToCartEvent) {
        if (addToCartEvent == null) {
            throw new NullPointerException("event must not be null");
        }
        if (this.g) {
            logFirebaseModeEnabledWarning("logAddToCart");
            return;
        }
        SessionAnalyticsManager sessionAnalyticsManager = this.h;
        if (sessionAnalyticsManager != null) {
            sessionAnalyticsManager.onPredefined(addToCartEvent);
        }
    }

    public void logContentView(ContentViewEvent contentViewEvent) {
        if (contentViewEvent == null) {
            throw new NullPointerException("event must not be null");
        }
        if (this.g) {
            logFirebaseModeEnabledWarning("logContentView");
            return;
        }
        SessionAnalyticsManager sessionAnalyticsManager = this.h;
        if (sessionAnalyticsManager != null) {
            sessionAnalyticsManager.onPredefined(contentViewEvent);
        }
    }

    public void logCustom(CustomEvent customEvent) {
        if (customEvent == null) {
            throw new NullPointerException("event must not be null");
        }
        if (this.g) {
            logFirebaseModeEnabledWarning("logCustom");
            return;
        }
        SessionAnalyticsManager sessionAnalyticsManager = this.h;
        if (sessionAnalyticsManager != null) {
            sessionAnalyticsManager.onCustom(customEvent);
        }
    }

    public void logInvite(InviteEvent inviteEvent) {
        if (inviteEvent == null) {
            throw new NullPointerException("event must not be null");
        }
        if (this.g) {
            logFirebaseModeEnabledWarning("logInvite");
            return;
        }
        SessionAnalyticsManager sessionAnalyticsManager = this.h;
        if (sessionAnalyticsManager != null) {
            sessionAnalyticsManager.onPredefined(inviteEvent);
        }
    }

    public void logLevelEnd(LevelEndEvent levelEndEvent) {
        if (levelEndEvent == null) {
            throw new NullPointerException("event must not be null");
        }
        if (this.g) {
            logFirebaseModeEnabledWarning("logLevelEnd");
            return;
        }
        SessionAnalyticsManager sessionAnalyticsManager = this.h;
        if (sessionAnalyticsManager != null) {
            sessionAnalyticsManager.onPredefined(levelEndEvent);
        }
    }

    public void logLevelStart(LevelStartEvent levelStartEvent) {
        if (levelStartEvent == null) {
            throw new NullPointerException("event must not be null");
        }
        if (this.g) {
            logFirebaseModeEnabledWarning("logLevelStart");
            return;
        }
        SessionAnalyticsManager sessionAnalyticsManager = this.h;
        if (sessionAnalyticsManager != null) {
            sessionAnalyticsManager.onPredefined(levelStartEvent);
        }
    }

    public void logLogin(LoginEvent loginEvent) {
        if (loginEvent == null) {
            throw new NullPointerException("event must not be null");
        }
        if (this.g) {
            logFirebaseModeEnabledWarning("logLogin");
            return;
        }
        SessionAnalyticsManager sessionAnalyticsManager = this.h;
        if (sessionAnalyticsManager != null) {
            sessionAnalyticsManager.onPredefined(loginEvent);
        }
    }

    public void logPurchase(PurchaseEvent purchaseEvent) {
        if (purchaseEvent == null) {
            throw new NullPointerException("event must not be null");
        }
        if (this.g) {
            logFirebaseModeEnabledWarning("logPurchase");
            return;
        }
        SessionAnalyticsManager sessionAnalyticsManager = this.h;
        if (sessionAnalyticsManager != null) {
            sessionAnalyticsManager.onPredefined(purchaseEvent);
        }
    }

    public void logRating(RatingEvent ratingEvent) {
        if (ratingEvent == null) {
            throw new NullPointerException("event must not be null");
        }
        if (this.g) {
            logFirebaseModeEnabledWarning("logRating");
            return;
        }
        SessionAnalyticsManager sessionAnalyticsManager = this.h;
        if (sessionAnalyticsManager != null) {
            sessionAnalyticsManager.onPredefined(ratingEvent);
        }
    }

    public void logSearch(SearchEvent searchEvent) {
        if (searchEvent == null) {
            throw new NullPointerException("event must not be null");
        }
        if (this.g) {
            logFirebaseModeEnabledWarning("logSearch");
            return;
        }
        SessionAnalyticsManager sessionAnalyticsManager = this.h;
        if (sessionAnalyticsManager != null) {
            sessionAnalyticsManager.onPredefined(searchEvent);
        }
    }

    public void logShare(ShareEvent shareEvent) {
        if (shareEvent == null) {
            throw new NullPointerException("event must not be null");
        }
        if (this.g) {
            logFirebaseModeEnabledWarning("logShare");
            return;
        }
        SessionAnalyticsManager sessionAnalyticsManager = this.h;
        if (sessionAnalyticsManager != null) {
            sessionAnalyticsManager.onPredefined(shareEvent);
        }
    }

    public void logSignUp(SignUpEvent signUpEvent) {
        if (signUpEvent == null) {
            throw new NullPointerException("event must not be null");
        }
        if (this.g) {
            logFirebaseModeEnabledWarning("logSignUp");
            return;
        }
        SessionAnalyticsManager sessionAnalyticsManager = this.h;
        if (sessionAnalyticsManager != null) {
            sessionAnalyticsManager.onPredefined(signUpEvent);
        }
    }

    public void logStartCheckout(StartCheckoutEvent startCheckoutEvent) {
        if (startCheckoutEvent == null) {
            throw new NullPointerException("event must not be null");
        }
        if (this.g) {
            logFirebaseModeEnabledWarning("logStartCheckout");
            return;
        }
        SessionAnalyticsManager sessionAnalyticsManager = this.h;
        if (sessionAnalyticsManager != null) {
            sessionAnalyticsManager.onPredefined(startCheckoutEvent);
        }
    }

    public void onException(Crash.FatalException fatalException) {
        SessionAnalyticsManager sessionAnalyticsManager = this.h;
        if (sessionAnalyticsManager != null) {
            sessionAnalyticsManager.onCrash(fatalException.getSessionId(), fatalException.getExceptionName());
        }
    }

    public void onException(Crash.LoggedException loggedException) {
        SessionAnalyticsManager sessionAnalyticsManager = this.h;
        if (sessionAnalyticsManager != null) {
            sessionAnalyticsManager.onError(loggedException.getSessionId());
        }
    }
}
