package com.google.firebase.database.connection;

import com.google.firebase.sessions.settings.RemoteSettings;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class ConnectionUtils {
    public static void hardAssert(boolean z3) {
        hardAssert(z3, "", new Object[0]);
    }

    public static Long longFromObject(Object obj) {
        if (obj instanceof Integer) {
            return Long.valueOf(((Integer) obj).intValue());
        }
        if (obj instanceof Long) {
            return (Long) obj;
        }
        return null;
    }

    public static String pathToString(List<String> list) {
        if (list.isEmpty()) {
            return RemoteSettings.FORWARD_SLASH_STRING;
        }
        StringBuilder sb = new StringBuilder();
        boolean z3 = true;
        for (String str : list) {
            if (!z3) {
                sb.append(RemoteSettings.FORWARD_SLASH_STRING);
            }
            sb.append(str);
            z3 = false;
        }
        return sb.toString();
    }

    public static List<String> stringToPath(String str) {
        ArrayList arrayList = new ArrayList();
        String[] split = str.split(RemoteSettings.FORWARD_SLASH_STRING, -1);
        for (int i = 0; i < split.length; i++) {
            if (!split[i].isEmpty()) {
                arrayList.add(split[i]);
            }
        }
        return arrayList;
    }

    public static void hardAssert(boolean z3, String str, Object... objArr) {
        if (!z3) {
            throw new AssertionError("hardAssert failed: ".concat(String.format(str, objArr)));
        }
    }
}
