package f4;

import com.google.firebase.crashlytics.internal.common.r;
import org.json.JSONObject;

/* loaded from: classes.dex */
class b implements g {
    private static g4.b b(JSONObject jSONObject) {
        return new g4.b(jSONObject.getString("status"), jSONObject.getString("url"), jSONObject.getString("reports_url"), jSONObject.getString("ndk_reports_url"), jSONObject.optBoolean("update_required", false));
    }

    private static g4.c c(JSONObject jSONObject) {
        return new g4.c(jSONObject.optBoolean("collect_reports", true));
    }

    private static g4.d d(JSONObject jSONObject) {
        return new g4.d(jSONObject.optInt("max_custom_exception_events", 8), 4);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static g4.e e(r rVar) {
        JSONObject jSONObject = new JSONObject();
        return new g4.f(f(rVar, 3600L, jSONObject), null, d(jSONObject), c(jSONObject), 0, 3600);
    }

    private static long f(r rVar, long j10, JSONObject jSONObject) {
        return jSONObject.has("expires_at") ? jSONObject.optLong("expires_at") : rVar.a() + (j10 * 1000);
    }

    @Override // f4.g
    public g4.f a(r rVar, JSONObject jSONObject) {
        int optInt = jSONObject.optInt("settings_version", 0);
        int optInt2 = jSONObject.optInt("cache_duration", 3600);
        return new g4.f(f(rVar, optInt2, jSONObject), b(jSONObject.getJSONObject("app")), d(jSONObject.getJSONObject("session")), c(jSONObject.getJSONObject("features")), optInt, optInt2);
    }
}
