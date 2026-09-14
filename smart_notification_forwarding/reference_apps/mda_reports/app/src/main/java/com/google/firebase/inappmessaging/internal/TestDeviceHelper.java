package com.google.firebase.inappmessaging.internal;

import com.google.internal.firebase.inappmessaging.v1.CampaignProto;
import com.google.internal.firebase.inappmessaging.v1.sdkserving.FetchEligibleCampaignsResponse;
import java.util.Iterator;
import javax.inject.Inject;

/* loaded from: classes2.dex */
public class TestDeviceHelper {
    private int fetchCount = 0;
    private boolean isFreshInstall = readFreshInstallStatusFromPreferences();
    private boolean isTestDevice = readTestDeviceStatusFromPreferences();
    private final SharedPreferencesUtils sharedPreferencesUtils;

    @Inject
    public TestDeviceHelper(SharedPreferencesUtils sharedPreferencesUtils) {
        this.sharedPreferencesUtils = sharedPreferencesUtils;
    }

    private boolean readFreshInstallStatusFromPreferences() {
        return this.sharedPreferencesUtils.getAndSetBooleanPreference("fresh_install", true);
    }

    private boolean readTestDeviceStatusFromPreferences() {
        return this.sharedPreferencesUtils.getAndSetBooleanPreference("test_device", false);
    }

    private void setFreshInstallStatus(boolean z) {
        this.isFreshInstall = z;
        this.sharedPreferencesUtils.setBooleanPreference("fresh_install", z);
    }

    private void setTestDeviceStatus(boolean z) {
        this.isTestDevice = z;
        this.sharedPreferencesUtils.setBooleanPreference("test_device", z);
    }

    private void updateFreshInstallStatus() {
        if (this.isFreshInstall) {
            this.fetchCount++;
            if (this.fetchCount >= 5) {
                setFreshInstallStatus(false);
            }
        }
    }

    public boolean isAppInstallFresh() {
        return this.isFreshInstall;
    }

    public boolean isDeviceInTestMode() {
        return this.isTestDevice;
    }

    public void processCampaignFetch(FetchEligibleCampaignsResponse fetchEligibleCampaignsResponse) {
        if (this.isTestDevice) {
            return;
        }
        updateFreshInstallStatus();
        Iterator<CampaignProto.ThickContent> it = fetchEligibleCampaignsResponse.getMessagesList().iterator();
        while (it.hasNext()) {
            if (it.next().getIsTestCampaign()) {
                setTestDeviceStatus(true);
                Logging.logi("Setting this device as a test device");
                return;
            }
        }
    }
}
