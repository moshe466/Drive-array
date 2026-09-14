package f4;

import com.google.firebase.crashlytics.internal.common.r;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class f {

    /* renamed from: a, reason: collision with root package name */
    private final r f9369a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(r rVar) {
        this.f9369a = rVar;
    }

    private static g a(int i10) {
        return i10 != 3 ? new b() : new h();
    }

    public g4.f b(JSONObject jSONObject) {
        return a(jSONObject.getInt("settings_version")).a(this.f9369a, jSONObject);
    }
}
