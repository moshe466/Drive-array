package h4;

import com.google.firebase.crashlytics.internal.common.h;
import com.google.firebase.crashlytics.internal.common.m;
import g4.g;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class c extends com.google.firebase.crashlytics.internal.common.a implements d {

    /* renamed from: f, reason: collision with root package name */
    private s3.b f10458f;

    public c(String str, String str2, y3.c cVar) {
        this(str, str2, cVar, y3.a.GET, s3.b.f());
    }

    c(String str, String str2, y3.c cVar, y3.a aVar, s3.b bVar) {
        super(str, str2, cVar, aVar);
        this.f10458f = bVar;
    }

    private y3.b g(y3.b bVar, g gVar) {
        h(bVar, "X-CRASHLYTICS-GOOGLE-APP-ID", gVar.f9791a);
        h(bVar, "X-CRASHLYTICS-API-CLIENT-TYPE", "android");
        h(bVar, "X-CRASHLYTICS-API-CLIENT-VERSION", m.i());
        h(bVar, "Accept", "application/json");
        h(bVar, "X-CRASHLYTICS-DEVICE-MODEL", gVar.f9792b);
        h(bVar, "X-CRASHLYTICS-OS-BUILD-VERSION", gVar.f9793c);
        h(bVar, "X-CRASHLYTICS-OS-DISPLAY-VERSION", gVar.f9794d);
        h(bVar, "X-CRASHLYTICS-INSTALLATION-ID", gVar.f9795e.a());
        return bVar;
    }

    private void h(y3.b bVar, String str, String str2) {
        if (str2 != null) {
            bVar.d(str, str2);
        }
    }

    private JSONObject i(String str) {
        try {
            return new JSONObject(str);
        } catch (Exception e10) {
            this.f10458f.c("Failed to parse settings JSON from " + e(), e10);
            this.f10458f.b("Settings response " + str);
            return null;
        }
    }

    private Map<String, String> j(g gVar) {
        HashMap hashMap = new HashMap();
        hashMap.put("build_version", gVar.f9798h);
        hashMap.put("display_version", gVar.f9797g);
        hashMap.put("source", Integer.toString(gVar.f9799i));
        String str = gVar.f9796f;
        if (!h.B(str)) {
            hashMap.put("instance", str);
        }
        return hashMap;
    }

    @Override // h4.d
    public JSONObject a(g gVar, boolean z10) {
        if (!z10) {
            throw new RuntimeException("An invalid data collection token was used.");
        }
        try {
            Map<String, String> j10 = j(gVar);
            y3.b g10 = g(d(j10), gVar);
            this.f10458f.b("Requesting settings from " + e());
            this.f10458f.b("Settings query params were: " + j10);
            y3.d b10 = g10.b();
            this.f10458f.b("Settings request ID: " + b10.d("X-REQUEST-ID"));
            return k(b10);
        } catch (IOException e10) {
            this.f10458f.e("Settings request failed.", e10);
            return null;
        }
    }

    JSONObject k(y3.d dVar) {
        int b10 = dVar.b();
        this.f10458f.b("Settings result was: " + b10);
        if (l(b10)) {
            return i(dVar.a());
        }
        this.f10458f.d("Failed to retrieve settings from " + e());
        return null;
    }

    boolean l(int i10) {
        return i10 == 200 || i10 == 201 || i10 == 202 || i10 == 203;
    }
}
