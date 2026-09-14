package f4;

import com.google.firebase.crashlytics.internal.common.r;
import java.util.Locale;
import org.json.JSONObject;

/* loaded from: classes.dex */
class h implements g {
    private static g4.b b(JSONObject jSONObject, JSONObject jSONObject2) {
        String string = jSONObject2.getString("status");
        boolean equals = "new".equals(string);
        String string2 = jSONObject.getString("bundle_id");
        String string3 = jSONObject.getString("org_id");
        String format = equals ? "https://update.crashlytics.com/spi/v1/platforms/android/apps" : String.format(Locale.US, "https://update.crashlytics.com/spi/v1/platforms/android/apps/%s", string2);
        Locale locale = Locale.US;
        return new g4.b(string, format, String.format(locale, "https://reports.crashlytics.com/spi/v1/platforms/android/apps/%s/reports", string2), String.format(locale, "https://reports.crashlytics.com/sdk-api/v1/platforms/android/apps/%s/minidumps", string2), string2, string3, jSONObject2.optBoolean("update_required", false), jSONObject2.optInt("report_upload_variant", 0), jSONObject2.optInt("native_report_upload_variant", 0));
    }

    private static g4.c c(JSONObject jSONObject) {
        return new g4.c(jSONObject.optBoolean("collect_reports", true));
    }

    private static g4.d d() {
        return new g4.d(8, 4);
    }

    private static long e(r rVar, long j10, JSONObject jSONObject) {
        return jSONObject.has("expires_at") ? jSONObject.optLong("expires_at") : rVar.a() + (j10 * 1000);
    }

    @Override // f4.g
    public g4.f a(r rVar, JSONObject jSONObject) {
        int optInt = jSONObject.optInt("settings_version", 0);
        int optInt2 = jSONObject.optInt("cache_duration", 3600);
        return new g4.f(e(rVar, optInt2, jSONObject), b(jSONObject.getJSONObject("fabric"), jSONObject.getJSONObject("app")), d(), c(jSONObject.getJSONObject("features")), optInt, optInt2);
    }
}
