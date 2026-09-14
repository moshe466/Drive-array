package com.google.firebase.messaging;

import android.content.res.Resources;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import java.util.Arrays;
import java.util.MissingFormatArgumentException;
import java.util.Objects;
import org.json.JSONArray;
import org.json.JSONException;

/* loaded from: classes.dex */
public class v {

    /* renamed from: a, reason: collision with root package name */
    private final Bundle f7476a;

    public v(Bundle bundle) {
        Objects.requireNonNull(bundle, "data");
        this.f7476a = new Bundle(bundle);
    }

    private static int d(String str) {
        int parseColor = Color.parseColor(str);
        if (parseColor != -16777216) {
            return parseColor;
        }
        throw new IllegalArgumentException("Transparent color is invalid");
    }

    private static boolean s(String str) {
        return str.startsWith("google.c.a.") || str.equals("from");
    }

    public static boolean t(Bundle bundle) {
        return "1".equals(bundle.getString("gcm.n.e")) || "1".equals(bundle.getString(v("gcm.n.e")));
    }

    private static boolean u(String str) {
        return str.startsWith("google.c.") || str.startsWith("gcm.n.") || str.startsWith("gcm.notification.");
    }

    private static String v(String str) {
        return !str.startsWith("gcm.n.") ? str : str.replace("gcm.n.", "gcm.notification.");
    }

    private String w(String str) {
        if (!this.f7476a.containsKey(str) && str.startsWith("gcm.n.")) {
            String v10 = v(str);
            if (this.f7476a.containsKey(v10)) {
                return v10;
            }
        }
        return str;
    }

    private static String z(String str) {
        return str.startsWith("gcm.n.") ? str.substring(6) : str;
    }

    public boolean a(String str) {
        String p10 = p(str);
        return "1".equals(p10) || Boolean.parseBoolean(p10);
    }

    public Integer b(String str) {
        String p10 = p(str);
        if (TextUtils.isEmpty(p10)) {
            return null;
        }
        try {
            return Integer.valueOf(Integer.parseInt(p10));
        } catch (NumberFormatException unused) {
            String z10 = z(str);
            StringBuilder sb2 = new StringBuilder(String.valueOf(z10).length() + 38 + String.valueOf(p10).length());
            sb2.append("Couldn't parse value of ");
            sb2.append(z10);
            sb2.append("(");
            sb2.append(p10);
            sb2.append(") into an int");
            return null;
        }
    }

    public JSONArray c(String str) {
        String p10 = p(str);
        if (TextUtils.isEmpty(p10)) {
            return null;
        }
        try {
            return new JSONArray(p10);
        } catch (JSONException unused) {
            String z10 = z(str);
            StringBuilder sb2 = new StringBuilder(String.valueOf(z10).length() + 50 + String.valueOf(p10).length());
            sb2.append("Malformed JSON for key ");
            sb2.append(z10);
            sb2.append(": ");
            sb2.append(p10);
            sb2.append(", falling back to default");
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int[] e() {
        JSONArray c10 = c("gcm.n.light_settings");
        if (c10 == null) {
            return null;
        }
        int[] iArr = new int[3];
        try {
            if (c10.length() != 3) {
                throw new JSONException("lightSettings don't have all three fields");
            }
            iArr[0] = d(c10.optString(0));
            iArr[1] = c10.optInt(1);
            iArr[2] = c10.optInt(2);
            return iArr;
        } catch (IllegalArgumentException e10) {
            String valueOf = String.valueOf(c10);
            String message = e10.getMessage();
            StringBuilder sb2 = new StringBuilder(valueOf.length() + 60 + String.valueOf(message).length());
            sb2.append("LightSettings is invalid: ");
            sb2.append(valueOf);
            sb2.append(". ");
            sb2.append(message);
            sb2.append(". Skipping setting LightSettings");
            return null;
        } catch (JSONException unused) {
            String valueOf2 = String.valueOf(c10);
            StringBuilder sb3 = new StringBuilder(valueOf2.length() + 58);
            sb3.append("LightSettings is invalid: ");
            sb3.append(valueOf2);
            sb3.append(". Skipping setting LightSettings");
            return null;
        }
    }

    public Uri f() {
        String p10 = p("gcm.n.link_android");
        if (TextUtils.isEmpty(p10)) {
            p10 = p("gcm.n.link");
        }
        if (TextUtils.isEmpty(p10)) {
            return null;
        }
        return Uri.parse(p10);
    }

    public Object[] g(String str) {
        JSONArray c10 = c(String.valueOf(str).concat("_loc_args"));
        if (c10 == null) {
            return null;
        }
        int length = c10.length();
        String[] strArr = new String[length];
        for (int i10 = 0; i10 < length; i10++) {
            strArr[i10] = c10.optString(i10);
        }
        return strArr;
    }

    public String h(String str) {
        return p(String.valueOf(str).concat("_loc_key"));
    }

    public String i(Resources resources, String str, String str2) {
        StringBuilder sb2;
        String h10 = h(str2);
        if (TextUtils.isEmpty(h10)) {
            return null;
        }
        int identifier = resources.getIdentifier(h10, "string", str);
        if (identifier == 0) {
            String z10 = z(String.valueOf(str2).concat("_loc_key"));
            sb2 = new StringBuilder(String.valueOf(z10).length() + 49 + String.valueOf(str2).length());
            sb2.append(z10);
            sb2.append(" resource not found: ");
            sb2.append(str2);
        } else {
            Object[] g10 = g(str2);
            if (g10 == null) {
                return resources.getString(identifier);
            }
            try {
                return resources.getString(identifier, g10);
            } catch (MissingFormatArgumentException unused) {
                String z11 = z(str2);
                String arrays = Arrays.toString(g10);
                sb2 = new StringBuilder(String.valueOf(z11).length() + 58 + String.valueOf(arrays).length());
                sb2.append("Missing format argument for ");
                sb2.append(z11);
                sb2.append(": ");
                sb2.append(arrays);
            }
        }
        sb2.append(" Default value will be used.");
        return null;
    }

    public Long j(String str) {
        String p10 = p(str);
        if (TextUtils.isEmpty(p10)) {
            return null;
        }
        try {
            return Long.valueOf(Long.parseLong(p10));
        } catch (NumberFormatException unused) {
            String z10 = z(str);
            StringBuilder sb2 = new StringBuilder(String.valueOf(z10).length() + 38 + String.valueOf(p10).length());
            sb2.append("Couldn't parse value of ");
            sb2.append(z10);
            sb2.append("(");
            sb2.append(p10);
            sb2.append(") into a long");
            return null;
        }
    }

    public String k() {
        return p("gcm.n.android_channel_id");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Integer l() {
        Integer b10 = b("gcm.n.notification_count");
        if (b10 == null) {
            return null;
        }
        if (b10.intValue() >= 0) {
            return b10;
        }
        String valueOf = String.valueOf(b10);
        StringBuilder sb2 = new StringBuilder(valueOf.length() + 67);
        sb2.append("notificationCount is invalid: ");
        sb2.append(valueOf);
        sb2.append(". Skipping setting notificationCount.");
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Integer m() {
        Integer b10 = b("gcm.n.notification_priority");
        if (b10 == null) {
            return null;
        }
        if (b10.intValue() >= -2 && b10.intValue() <= 2) {
            return b10;
        }
        String valueOf = String.valueOf(b10);
        StringBuilder sb2 = new StringBuilder(valueOf.length() + 72);
        sb2.append("notificationPriority is invalid ");
        sb2.append(valueOf);
        sb2.append(". Skipping setting notificationPriority.");
        return null;
    }

    public String n(Resources resources, String str, String str2) {
        String p10 = p(str2);
        return !TextUtils.isEmpty(p10) ? p10 : i(resources, str, str2);
    }

    public String o() {
        String p10 = p("gcm.n.sound2");
        return TextUtils.isEmpty(p10) ? p("gcm.n.sound") : p10;
    }

    public String p(String str) {
        return this.f7476a.getString(w(str));
    }

    public long[] q() {
        JSONArray c10 = c("gcm.n.vibrate_timings");
        if (c10 == null) {
            return null;
        }
        try {
            if (c10.length() <= 1) {
                throw new JSONException("vibrateTimings have invalid length");
            }
            int length = c10.length();
            long[] jArr = new long[length];
            for (int i10 = 0; i10 < length; i10++) {
                jArr[i10] = c10.optLong(i10);
            }
            return jArr;
        } catch (NumberFormatException | JSONException unused) {
            String valueOf = String.valueOf(c10);
            StringBuilder sb2 = new StringBuilder(valueOf.length() + 74);
            sb2.append("User defined vibrateTimings is invalid: ");
            sb2.append(valueOf);
            sb2.append(". Skipping setting vibrateTimings.");
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Integer r() {
        Integer b10 = b("gcm.n.visibility");
        if (b10 == null) {
            return null;
        }
        if (b10.intValue() >= -1 && b10.intValue() <= 1) {
            return b10;
        }
        String valueOf = String.valueOf(b10);
        StringBuilder sb2 = new StringBuilder(valueOf.length() + 53);
        sb2.append("visibility is invalid: ");
        sb2.append(valueOf);
        sb2.append(". Skipping setting visibility.");
        return null;
    }

    public Bundle x() {
        Bundle bundle = new Bundle(this.f7476a);
        for (String str : this.f7476a.keySet()) {
            if (!s(str)) {
                bundle.remove(str);
            }
        }
        return bundle;
    }

    public Bundle y() {
        Bundle bundle = new Bundle(this.f7476a);
        for (String str : this.f7476a.keySet()) {
            if (u(str)) {
                bundle.remove(str);
            }
        }
        return bundle;
    }
}
