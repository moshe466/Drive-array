package t3;

import android.os.Bundle;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class d implements b, u3.b {

    /* renamed from: a, reason: collision with root package name */
    private u3.a f14267a;

    private static String b(String str, Bundle bundle) {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        for (String str2 : bundle.keySet()) {
            jSONObject2.put(str2, bundle.get(str2));
        }
        jSONObject.put("name", str);
        jSONObject.put("parameters", jSONObject2);
        return jSONObject.toString();
    }

    @Override // u3.b
    public void a(u3.a aVar) {
        this.f14267a = aVar;
        s3.b.f().b("Registered Firebase Analytics event receiver for breadcrumbs");
    }

    @Override // t3.b
    public void o(String str, Bundle bundle) {
        u3.a aVar = this.f14267a;
        if (aVar != null) {
            try {
                aVar.a("$A$:" + b(str, bundle));
            } catch (JSONException unused) {
                s3.b.f().i("Unable to serialize Firebase Analytics event to breadcrumb.");
            }
        }
    }
}
