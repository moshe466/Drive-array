package com.google.firebase.database;

import androidx.annotation.NonNull;
import com.google.firebase.database.core.ServerValues;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes2.dex */
public class ServerValue {

    @NonNull
    public static final Map<String, String> TIMESTAMP = createServerValuePlaceholder("timestamp");

    private static Map<String, String> createServerValuePlaceholder(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put(ServerValues.NAME_SUBKEY_SERVERVALUE, str);
        return Collections.unmodifiableMap(hashMap);
    }
}
