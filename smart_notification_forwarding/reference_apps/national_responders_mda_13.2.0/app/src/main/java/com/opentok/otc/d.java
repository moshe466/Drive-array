package com.opentok.otc;

/* loaded from: classes.dex */
public class d {
    public static int a(b bVar) {
        return opentokJNI.otc_session_delete(b.a(bVar));
    }

    public static int b(b bVar, String str, String str2, int i10, int i11, String str3) {
        return opentokJNI.otc_session_connect_to_host(b.a(bVar), str, str2, i10, i11, str3);
    }

    public static int c(c cVar) {
        return opentokJNI.otc_session_settings_delete(c.a(cVar));
    }

    public static int d(c cVar, int i10) {
        return opentokJNI.otc_session_settings_set_connection_events_suppressed(c.a(cVar), i10);
    }

    public static int e(c cVar, int i10, String[] strArr, String[] strArr2, String[] strArr3, int i11, int i12) {
        return opentokJNI.otc_session_settings_set_custom_ice_config_no_struct(c.a(cVar), i10, strArr, strArr2, strArr3, i11, i12);
    }

    public static int f(c cVar, String str) {
        return opentokJNI.otc_session_settings_set_proxy_url(c.a(cVar), str);
    }

    public static b g(String str, String str2, otc_session_callbacks otc_session_callbacksVar, c cVar) {
        long otc_session_new_with_settings = opentokJNI.otc_session_new_with_settings(str, str2, otc_session_callbacks.b(otc_session_callbacksVar), otc_session_callbacksVar, c.a(cVar));
        if (otc_session_new_with_settings == 0) {
            return null;
        }
        return new b(otc_session_new_with_settings, false);
    }

    public static void h(b bVar, z6.b bVar2) {
        opentokJNI.otc_session_log_external_device_use(b.a(bVar), bVar2.a());
    }

    public static int i(b bVar) {
        return opentokJNI.otc_session_disconnect(b.a(bVar));
    }

    public static int j(c cVar, int i10) {
        return opentokJNI.otc_session_settings_set_ip_whitelist(c.a(cVar), i10);
    }

    public static int k(a aVar, int i10) {
        return opentokJNI.otc_publisher_set_publish_video(a.a(aVar), i10);
    }

    public static c l() {
        long otc_session_settings_new = opentokJNI.otc_session_settings_new();
        if (otc_session_settings_new == 0) {
            return null;
        }
        return new c(otc_session_settings_new, false);
    }

    public static int m(a aVar) {
        return opentokJNI.otc_publisher_get_publish_video(a.a(aVar));
    }

    public static String n(b bVar) {
        return opentokJNI.otc_session_get_id(b.a(bVar));
    }
}
