package com.opentok.otc;

/* loaded from: classes.dex */
public class opentokJNI {
    public static final native int OTC_FALSE_get();

    public static final native int OTC_PUBLISHER_VIDEO_TYPE_CAMERA_get();

    public static final native int OTC_PUBLISHER_VIDEO_TYPE_SCREEN_get();

    public static final native int OTC_SUCCESS_get();

    public static final native int OTC_TRUE_get();

    public static final native void delete_otc_session_callbacks(long j10);

    public static final native long new_otc_session_callbacks();

    public static final native int otc_external_audio_get();

    public static final native int otc_external_video_get();

    public static final native int otc_internal_audio_get();

    public static final native int otc_internal_video_get();

    public static final native int otc_publisher_get_publish_video(long j10);

    public static final native int otc_publisher_set_publish_video(long j10, int i10);

    public static final native int otc_session_connect_to_host(long j10, String str, String str2, int i10, int i11, String str3);

    public static final native int otc_session_delete(long j10);

    public static final native int otc_session_disconnect(long j10);

    public static final native String otc_session_get_id(long j10);

    public static final native void otc_session_log_external_device_use(long j10, int i10);

    public static final native long otc_session_new_with_settings(String str, String str2, long j10, otc_session_callbacks otc_session_callbacksVar, long j11);

    public static final native int otc_session_settings_delete(long j10);

    public static final native long otc_session_settings_new();

    public static final native int otc_session_settings_set_connection_events_suppressed(long j10, int i10);

    public static final native int otc_session_settings_set_custom_ice_config_no_struct(long j10, int i10, String[] strArr, String[] strArr2, String[] strArr3, int i11, int i12);

    public static final native int otc_session_settings_set_ip_whitelist(long j10, int i10);

    public static final native int otc_session_settings_set_proxy_url(long j10, String str);
}
