package com.google.firebase.inappmessaging.internal;

import com.google.firebase.DataCollectionDefaultChange;
import com.google.firebase.FirebaseApp;
import com.google.firebase.events.Subscriber;
import com.google.firebase.iid.FirebaseInstanceId;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.inject.Inject;

/* loaded from: classes2.dex */
public class DataCollectionHelper {
    private AtomicBoolean isGlobalAutomaticDataCollectionEnabled;
    private SharedPreferencesUtils sharedPreferencesUtils;

    @Inject
    public DataCollectionHelper(FirebaseApp firebaseApp, SharedPreferencesUtils sharedPreferencesUtils, FirebaseInstanceId firebaseInstanceId, Subscriber subscriber) {
        this.sharedPreferencesUtils = sharedPreferencesUtils;
        this.isGlobalAutomaticDataCollectionEnabled = new AtomicBoolean(firebaseApp.isDataCollectionDefaultEnabled());
        if (isAutomaticDataCollectionEnabled()) {
            firebaseInstanceId.getToken();
        }
        subscriber.subscribe(DataCollectionDefaultChange.class, DataCollectionHelper$$Lambda$1.lambdaFactory$(this));
    }

    private boolean isProductManifestSet() {
        return this.sharedPreferencesUtils.isManifestSet("firebase_inapp_messaging_auto_data_collection_enabled");
    }

    private boolean isProductManuallySet() {
        return this.sharedPreferencesUtils.isPreferenceSet("auto_init");
    }

    private boolean readAutomaticDataCollectionEnabledFromPreferences() {
        return this.sharedPreferencesUtils.getBooleanPreference("auto_init", true);
    }

    public boolean isAutomaticDataCollectionEnabled() {
        return isProductManuallySet() ? this.sharedPreferencesUtils.getBooleanPreference("auto_init", true) : isProductManifestSet() ? this.sharedPreferencesUtils.getBooleanManifestValue("firebase_inapp_messaging_auto_data_collection_enabled", true) : this.isGlobalAutomaticDataCollectionEnabled.get();
    }

    public void setAutomaticDataCollectionEnabled(boolean z) {
        this.sharedPreferencesUtils.setBooleanPreference("auto_init", z);
    }
}
