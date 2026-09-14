package com.google.firebase.sessions;

import N2.n;
import android.util.Base64;

/* loaded from: classes.dex */
public final class SessionDataStoreConfigs {
    public static final SessionDataStoreConfigs INSTANCE = new SessionDataStoreConfigs();
    private static final String PROCESS_NAME;
    private static final String SESSIONS_CONFIG_NAME;
    private static final String SETTINGS_CONFIG_NAME;

    static {
        String encodeToString = Base64.encodeToString(n.H(ProcessDetailsProvider.INSTANCE.getProcessName$com_google_firebase_firebase_sessions()), 10);
        PROCESS_NAME = encodeToString;
        SESSIONS_CONFIG_NAME = e0.a.e("firebase_session_", encodeToString, "_data");
        SETTINGS_CONFIG_NAME = e0.a.e("firebase_session_", encodeToString, "_settings");
    }

    private SessionDataStoreConfigs() {
    }

    public final String getSESSIONS_CONFIG_NAME() {
        return SESSIONS_CONFIG_NAME;
    }

    public final String getSETTINGS_CONFIG_NAME() {
        return SETTINGS_CONFIG_NAME;
    }
}
