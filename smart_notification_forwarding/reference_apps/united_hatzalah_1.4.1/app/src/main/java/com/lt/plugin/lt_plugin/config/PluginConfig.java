package com.lt.plugin.lt_plugin.config;

import android.content.Context;
import android.content.res.Resources;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public class PluginConfig {
    private static PluginConfig instance;
    private Map<String, Object> configMap;
    private Context context;

    private PluginConfig(Context context) {
        this.context = context;
        loadConfig();
    }

    public static synchronized PluginConfig getInstance(Context context) {
        PluginConfig pluginConfig;
        synchronized (PluginConfig.class) {
            try {
                if (instance == null) {
                    instance = new PluginConfig(context);
                }
                pluginConfig = instance;
            } catch (Throwable th) {
                throw th;
            }
        }
        return pluginConfig;
    }

    public static String getLocalized(Context context, String str, String str2) {
        try {
            int identifier = context.getResources().getIdentifier(str, "string", context.getPackageName());
            if (identifier != 0) {
                return context.getString(identifier);
            }
        } catch (Exception unused) {
        }
        return str2;
    }

    private void loadConfig() {
        this.configMap = new HashMap();
        setDefaults();
        try {
            Resources resources = this.context.getResources();
            String packageName = this.context.getPackageName();
            String[] strArr = {"enable_javascript_interface", "enable_location_service", "block_mock_locations", "enable_floating_window", "enable_floating_window_secure", "enable_background_service", "enable_boot_receiver", "enable_firebase", "enable_firebase_auth", "enable_firebase_remote_config", "enable_firebase_data_service", "enable_file_chooser", "enable_camera", "enable_gallery", "enable_permission_management", "enable_notification_management", "enable_vibration", "enable_cache_management", "enable_network_monitoring", "enable_webview_features", "enable_print", "enable_notification_listener_check", "enable_accessibility_service_check", "enable_isolated_profile_check", "enable_sideload_listener_check"};
            for (int i = 0; i < 25; i++) {
                String str = strArr[i];
                int identifier = resources.getIdentifier(str, "bool", packageName);
                if (identifier != 0) {
                    this.configMap.put(str, Boolean.valueOf(resources.getBoolean(identifier)));
                }
            }
            String[] strArr2 = {"tracking_mode", "firebase_location", "token_server_url", "default_notification_channel_id", "default_notification_channel_title", "default_notification_channel_description", "fcm_token_db_key_android", "fcm_token_db_key_android_legacy", "floating_window_layout", "floating_window_transparency_activity", "floating_window_bg_color", "floating_window_header_bg_color", "floating_window_title_text_color", "floating_window_close_bg_color", "floating_window_close_text_color", "floating_window_close_text", "floating_window_body_bg_color", "floating_window_body_text_color"};
            for (int i3 = 0; i3 < 18; i3++) {
                String str2 = strArr2[i3];
                int identifier2 = resources.getIdentifier(str2, "string", packageName);
                if (identifier2 != 0) {
                    this.configMap.put(str2, resources.getString(identifier2));
                }
            }
            String[] strArr3 = {"floating_window_padding_px", "floating_window_header_height_dp", "floating_window_title_text_size_px", "floating_window_close_text_size_px", "floating_window_body_text_size_px", "floating_window_title_weight", "floating_window_close_weight"};
            for (int i4 = 0; i4 < 7; i4++) {
                String str3 = strArr3[i4];
                int identifier3 = resources.getIdentifier(str3, "integer", packageName);
                if (identifier3 != 0) {
                    this.configMap.put(str3, Integer.valueOf(resources.getInteger(identifier3)));
                }
            }
            int identifier4 = resources.getIdentifier("required_permissions", "array", packageName);
            if (identifier4 != 0) {
                this.configMap.put("required_permissions", resources.getStringArray(identifier4));
            }
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    private void setDefaults() {
        Map<String, Object> map = this.configMap;
        Boolean bool = Boolean.FALSE;
        map.put("enable_javascript_interface", bool);
        this.configMap.put("enable_location_service", bool);
        this.configMap.put("block_mock_locations", bool);
        this.configMap.put("tracking_mode", "OFF");
        this.configMap.put("enable_floating_window", bool);
        this.configMap.put("enable_floating_window_secure", Boolean.TRUE);
        this.configMap.put("enable_background_service", bool);
        this.configMap.put("enable_boot_receiver", bool);
        this.configMap.put("enable_firebase", bool);
        this.configMap.put("enable_firebase_auth", bool);
        this.configMap.put("enable_firebase_remote_config", bool);
        this.configMap.put("enable_firebase_data_service", bool);
        this.configMap.put("firebase_location", "js");
        this.configMap.put("token_server_url", "");
        this.configMap.put("enable_file_chooser", bool);
        this.configMap.put("enable_camera", bool);
        this.configMap.put("enable_gallery", bool);
        this.configMap.put("enable_permission_management", bool);
        this.configMap.put("enable_notification_management", bool);
        this.configMap.put("enable_vibration", bool);
        this.configMap.put("enable_cache_management", bool);
        this.configMap.put("enable_network_monitoring", bool);
        this.configMap.put("enable_webview_features", bool);
        this.configMap.put("enable_notification_listener_check", bool);
        this.configMap.put("enable_accessibility_service_check", bool);
        this.configMap.put("enable_isolated_profile_check", bool);
        this.configMap.put("enable_sideload_listener_check", bool);
        this.configMap.put("default_notification_channel_id", "");
        this.configMap.put("default_notification_channel_title", "");
        this.configMap.put("default_notification_channel_description", "");
    }

    public boolean getBoolean(String str, boolean z3) {
        Object obj = this.configMap.get(str);
        if (obj != null) {
            if (obj instanceof Boolean) {
                return ((Boolean) obj).booleanValue();
            }
            if (obj instanceof String) {
                return Boolean.parseBoolean((String) obj);
            }
        }
        return z3;
    }

    public String getDefaultNotificationChannelDescription() {
        return getString("default_notification_channel_description", "");
    }

    public String getDefaultNotificationChannelId() {
        return getString("default_notification_channel_id", "");
    }

    public String getDefaultNotificationChannelTitle() {
        return getString("default_notification_channel_title", "");
    }

    public String getFcmTokenDbKeyAndroid() {
        return getString("fcm_token_db_key_android", "androidToken");
    }

    public String getFcmTokenDbKeyAndroidLegacy() {
        return getString("fcm_token_db_key_android_legacy", "");
    }

    public String getFirebaseLocation() {
        return getString("firebase_location", "js");
    }

    public String getFloatingWindowBgColor() {
        return getString("floating_window_bg_color", "#FFFFFF");
    }

    public String getFloatingWindowBodyBgColor() {
        return getString("floating_window_body_bg_color", "#FFFFFF");
    }

    public String getFloatingWindowBodyTextColor() {
        return getString("floating_window_body_text_color", "#000000");
    }

    public int getFloatingWindowBodyTextSizePx() {
        return getInt("floating_window_body_text_size_px", 50);
    }

    public String getFloatingWindowCloseBgColor() {
        return getString("floating_window_close_bg_color", getFloatingWindowHeaderBgColor());
    }

    public String getFloatingWindowCloseText() {
        return getString("floating_window_close_text", "X");
    }

    public String getFloatingWindowCloseTextColor() {
        return getString("floating_window_close_text_color", getFloatingWindowTitleTextColor());
    }

    public int getFloatingWindowCloseTextSizePx() {
        return getInt("floating_window_close_text_size_px", 40);
    }

    public int getFloatingWindowCloseWeight() {
        return getInt("floating_window_close_weight", 8);
    }

    public String getFloatingWindowHeaderBgColor() {
        return getString("floating_window_header_bg_color", getFloatingWindowBgColor());
    }

    public int getFloatingWindowHeaderHeightDp() {
        return getInt("floating_window_header_height_dp", 40);
    }

    public String getFloatingWindowLayout() {
        return getString("floating_window_layout", "");
    }

    public int getFloatingWindowPaddingPx() {
        return getInt("floating_window_padding_px", 5);
    }

    public String getFloatingWindowTitleTextColor() {
        return getString("floating_window_title_text_color", "#000000");
    }

    public int getFloatingWindowTitleTextSizePx() {
        return getInt("floating_window_title_text_size_px", 50);
    }

    public int getFloatingWindowTitleWeight() {
        return getInt("floating_window_title_weight", 1);
    }

    public String getFloatingWindowTransparencyActivity() {
        return getString("floating_window_transparency_activity", "");
    }

    public int getInt(String str, int i) {
        Object obj = this.configMap.get(str);
        if (obj != null) {
            if (obj instanceof Integer) {
                return ((Integer) obj).intValue();
            }
            try {
                return Integer.parseInt(obj.toString());
            } catch (NumberFormatException unused) {
            }
        }
        return i;
    }

    public List<String> getRequiredPermissions() {
        Object obj = this.configMap.get("required_permissions");
        if (obj instanceof String[]) {
            return Arrays.asList((String[]) obj);
        }
        return new ArrayList();
    }

    public String getString(String str, String str2) {
        Object obj = this.configMap.get(str);
        if (obj == null) {
            return str2;
        }
        return obj.toString();
    }

    public String getTokenServerUrl() {
        return getString("token_server_url", "");
    }

    public String getTrackingMode() {
        return getString("tracking_mode", "OFF");
    }

    public boolean isAccessibilityServiceCheckEnabled() {
        return getBoolean("enable_accessibility_service_check", false);
    }

    public boolean isBackgroundServiceEnabled() {
        return getBoolean("enable_background_service", false);
    }

    public boolean isBootReceiverEnabled() {
        return getBoolean("enable_boot_receiver", false);
    }

    public boolean isCacheManagementEnabled() {
        return getBoolean("enable_cache_management", false);
    }

    public boolean isCameraEnabled() {
        return getBoolean("enable_camera", false);
    }

    public boolean isFileChooserEnabled() {
        return getBoolean("enable_file_chooser", false);
    }

    public boolean isFirebaseAuthEnabled() {
        return getBoolean("enable_firebase_auth", false);
    }

    public boolean isFirebaseDataServiceEnabled() {
        return getBoolean("enable_firebase_data_service", false);
    }

    public boolean isFirebaseEnabled() {
        return getBoolean("enable_firebase", false);
    }

    public boolean isFirebaseRemoteConfigEnabled() {
        return getBoolean("enable_firebase_remote_config", false);
    }

    public boolean isFloatingWindowEnabled() {
        return getBoolean("enable_floating_window", false);
    }

    public boolean isFloatingWindowSecureEnabled() {
        return getBoolean("enable_floating_window_secure", true);
    }

    public boolean isGalleryEnabled() {
        return getBoolean("enable_gallery", false);
    }

    public boolean isIsolatedProfileCheckEnabled() {
        return getBoolean("enable_isolated_profile_check", false);
    }

    public boolean isJavaScriptInterfaceEnabled() {
        return getBoolean("enable_javascript_interface", false);
    }

    public boolean isLocationServiceEnabled() {
        return getBoolean("enable_location_service", false);
    }

    public boolean isMockLocationBlockingEnabled() {
        return getBoolean("block_mock_locations", false);
    }

    public boolean isNetworkMonitoringEnabled() {
        return getBoolean("enable_network_monitoring", false);
    }

    public boolean isNotificationListenerCheckEnabled() {
        return getBoolean("enable_notification_listener_check", false);
    }

    public boolean isNotificationManagementEnabled() {
        return getBoolean("enable_notification_management", false);
    }

    public boolean isPermissionManagementEnabled() {
        return getBoolean("enable_permission_management", false);
    }

    public boolean isPrintEnabled() {
        return getBoolean("enable_print", false);
    }

    public boolean isSideloadListenerCheckEnabled() {
        return getBoolean("enable_sideload_listener_check", false);
    }

    public boolean isVibrationEnabled() {
        return getBoolean("enable_vibration", false);
    }

    public boolean isWebViewFeaturesEnabled() {
        return getBoolean("enable_webview_features", false);
    }

    public static String getLocalized(Context context, String str, String str2, Object... objArr) {
        try {
            int identifier = context.getResources().getIdentifier(str, "string", context.getPackageName());
            if (identifier != 0) {
                return context.getString(identifier, objArr);
            }
        } catch (Exception unused) {
        }
        return String.format(str2, objArr);
    }
}
