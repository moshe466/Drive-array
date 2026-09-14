package i6;

import android.os.AsyncTask;
import com.groboot.mdaemergency.MdaEmergencyApplication;
import com.groboot.mdaemergency.async.b;
import org.json.JSONException;
import org.json.JSONObject;
import w6.j;
import w6.z;

/* loaded from: classes.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private final JSONObject f10738a;

    public a(j6.a aVar) {
        this.f10738a = a(aVar, null);
    }

    public a(j6.a aVar, Object obj) {
        this.f10738a = a(aVar, obj);
    }

    private JSONObject a(j6.a aVar, Object obj) {
        String jSONObject;
        JSONObject jSONObject2 = null;
        try {
            jSONObject2 = b(j6.b.ISOLATION.toString(), aVar.toString());
            jSONObject2.put("RequestData", j.b(obj));
        } catch (JSONException unused) {
        }
        JSONObject jSONObject3 = new JSONObject();
        if (jSONObject2 != null) {
            try {
                jSONObject = jSONObject2.toString();
            } catch (JSONException unused2) {
            }
        } else {
            jSONObject = "";
        }
        jSONObject3.put("request", jSONObject);
        return jSONObject3;
    }

    private JSONObject b(String str, String str2) {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("Application", 1);
        jSONObject2.put("Module", str);
        jSONObject2.put("Function", str2);
        String c10 = z.b().c();
        jSONObject2.put("Token", c10);
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Module:");
        sb2.append(str);
        sb2.append(" Function:");
        sb2.append(str2);
        sb2.append(" Token:");
        sb2.append(c10);
        jSONObject2.put("AppVersion", MdaEmergencyApplication.f7530g);
        jSONObject.put("RequestHeader", jSONObject2);
        return jSONObject;
    }

    public JSONObject c() {
        return this.f10738a;
    }

    public void d(b.InterfaceC0098b interfaceC0098b) {
        new com.groboot.mdaemergency.async.b(this.f10738a.toString(), true, interfaceC0098b).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
    }
}
