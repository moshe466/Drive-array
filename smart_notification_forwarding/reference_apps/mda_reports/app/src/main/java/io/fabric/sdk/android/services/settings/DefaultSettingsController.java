package io.fabric.sdk.android.services.settings;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import io.fabric.sdk.android.Fabric;
import io.fabric.sdk.android.Kit;
import io.fabric.sdk.android.Logger;
import io.fabric.sdk.android.services.common.CommonUtils;
import io.fabric.sdk.android.services.common.CurrentTimeProvider;
import io.fabric.sdk.android.services.common.DataCollectionArbiter;
import io.fabric.sdk.android.services.persistence.PreferenceStore;
import io.fabric.sdk.android.services.persistence.PreferenceStoreImpl;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class DefaultSettingsController implements SettingsController {
    private static final String LOAD_ERROR_MESSAGE = "Unknown error while loading Crashlytics settings. Crashes will be cached until settings can be retrieved.";
    private static final String PREFS_BUILD_INSTANCE_IDENTIFIER = "existing_instance_identifier";
    private final CachedSettingsIo cachedSettingsIo;
    private final CurrentTimeProvider currentTimeProvider;
    private final DataCollectionArbiter dataCollectionArbiter;
    private final Kit kit;
    private final PreferenceStore preferenceStore;
    private final SettingsJsonTransform settingsJsonTransform;
    private final SettingsRequest settingsRequest;
    private final SettingsSpiCall settingsSpiCall;

    public DefaultSettingsController(Kit kit, SettingsRequest settingsRequest, CurrentTimeProvider currentTimeProvider, SettingsJsonTransform settingsJsonTransform, CachedSettingsIo cachedSettingsIo, SettingsSpiCall settingsSpiCall, DataCollectionArbiter dataCollectionArbiter) {
        this.kit = kit;
        this.settingsRequest = settingsRequest;
        this.currentTimeProvider = currentTimeProvider;
        this.settingsJsonTransform = settingsJsonTransform;
        this.cachedSettingsIo = cachedSettingsIo;
        this.settingsSpiCall = settingsSpiCall;
        this.dataCollectionArbiter = dataCollectionArbiter;
        this.preferenceStore = new PreferenceStoreImpl(this.kit);
    }

    private SettingsData getCachedSettingsData(SettingsCacheBehavior settingsCacheBehavior) {
        Logger logger;
        String str;
        SettingsData settingsData = null;
        try {
            if (SettingsCacheBehavior.SKIP_CACHE_LOOKUP.equals(settingsCacheBehavior)) {
                return null;
            }
            JSONObject readCachedSettings = this.cachedSettingsIo.readCachedSettings();
            if (readCachedSettings != null) {
                SettingsData buildFromJson = this.settingsJsonTransform.buildFromJson(this.currentTimeProvider, readCachedSettings);
                if (buildFromJson == null) {
                    Fabric.getLogger().e(Fabric.TAG, "Failed to transform cached settings data.", null);
                    return null;
                }
                logSettings(readCachedSettings, "Loaded cached settings: ");
                long currentTimeMillis = this.currentTimeProvider.getCurrentTimeMillis();
                if (!SettingsCacheBehavior.IGNORE_CACHE_EXPIRATION.equals(settingsCacheBehavior) && buildFromJson.isExpired(currentTimeMillis)) {
                    logger = Fabric.getLogger();
                    str = "Cached settings have expired.";
                }
                try {
                    Fabric.getLogger().d(Fabric.TAG, "Returning cached settings.");
                    return buildFromJson;
                } catch (Exception e) {
                    e = e;
                    settingsData = buildFromJson;
                    Fabric.getLogger().e(Fabric.TAG, "Failed to get cached settings", e);
                    return settingsData;
                }
            }
            logger = Fabric.getLogger();
            str = "No cached settings data found.";
            logger.d(Fabric.TAG, str);
            return null;
        } catch (Exception e2) {
            e = e2;
        }
    }

    private void logSettings(JSONObject jSONObject, String str) {
        Fabric.getLogger().d(Fabric.TAG, str + jSONObject.toString());
    }

    boolean a() {
        return !c().equals(b());
    }

    @SuppressLint({"CommitPrefEdits"})
    boolean a(String str) {
        SharedPreferences.Editor edit = this.preferenceStore.edit();
        edit.putString(PREFS_BUILD_INSTANCE_IDENTIFIER, str);
        return this.preferenceStore.save(edit);
    }

    String b() {
        return CommonUtils.createInstanceIdFrom(CommonUtils.resolveBuildId(this.kit.getContext()));
    }

    String c() {
        return this.preferenceStore.get().getString(PREFS_BUILD_INSTANCE_IDENTIFIER, "");
    }

    @Override // io.fabric.sdk.android.services.settings.SettingsController
    public SettingsData loadSettingsData() {
        return loadSettingsData(SettingsCacheBehavior.USE_CACHE);
    }

    @Override // io.fabric.sdk.android.services.settings.SettingsController
    public SettingsData loadSettingsData(SettingsCacheBehavior settingsCacheBehavior) {
        JSONObject invoke;
        SettingsData settingsData = null;
        if (!this.dataCollectionArbiter.isDataCollectionEnabled()) {
            Fabric.getLogger().d(Fabric.TAG, "Not fetching settings, because data collection is disabled by Firebase.");
            return null;
        }
        try {
            if (!Fabric.isDebuggable() && !a()) {
                settingsData = getCachedSettingsData(settingsCacheBehavior);
            }
            if (settingsData == null && (invoke = this.settingsSpiCall.invoke(this.settingsRequest)) != null) {
                settingsData = this.settingsJsonTransform.buildFromJson(this.currentTimeProvider, invoke);
                this.cachedSettingsIo.writeCachedSettings(settingsData.expiresAtMillis, invoke);
                logSettings(invoke, "Loaded settings: ");
                a(b());
            }
            return settingsData == null ? getCachedSettingsData(SettingsCacheBehavior.IGNORE_CACHE_EXPIRATION) : settingsData;
        } catch (Exception e) {
            Fabric.getLogger().e(Fabric.TAG, LOAD_ERROR_MESSAGE, e);
            return null;
        }
    }
}
