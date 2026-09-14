package h4;

import com.google.firebase.crashlytics.internal.common.d0;
import com.google.firebase.crashlytics.internal.common.h;
import java.io.IOException;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public abstract class a extends com.google.firebase.crashlytics.internal.common.a {

    /* renamed from: f, reason: collision with root package name */
    private final String f10457f;

    public a(String str, String str2, y3.c cVar, y3.a aVar, String str3) {
        super(str, str2, cVar, aVar);
        this.f10457f = str3;
    }

    private y3.b g(y3.b bVar, g4.a aVar) {
        return bVar.d("X-CRASHLYTICS-ORG-ID", aVar.f9766a).d("X-CRASHLYTICS-GOOGLE-APP-ID", aVar.f9767b).d("X-CRASHLYTICS-API-CLIENT-TYPE", "android").d("X-CRASHLYTICS-API-CLIENT-VERSION", this.f10457f);
    }

    private y3.b h(y3.b bVar, g4.a aVar) {
        y3.b g10 = bVar.g("org_id", aVar.f9766a).g("app[identifier]", aVar.f9768c).g("app[name]", aVar.f9772g).g("app[display_version]", aVar.f9769d).g("app[build_version]", aVar.f9770e).g("app[source]", Integer.toString(aVar.f9773h)).g("app[minimum_sdk_version]", aVar.f9774i).g("app[built_sdk_version]", aVar.f9775j);
        if (!h.B(aVar.f9771f)) {
            g10.g("app[instance_identifier]", aVar.f9771f);
        }
        return g10;
    }

    public boolean i(g4.a aVar, boolean z10) {
        if (!z10) {
            throw new RuntimeException("An invalid data collection token was used.");
        }
        y3.b h10 = h(g(c(), aVar), aVar);
        s3.b.f().b("Sending app info to " + e());
        try {
            y3.d b10 = h10.b();
            int b11 = b10.b();
            String str = "POST".equalsIgnoreCase(h10.f()) ? "Create" : "Update";
            s3.b.f().b(str + " app request ID: " + b10.d("X-REQUEST-ID"));
            s3.b.f().b("Result was " + b11);
            return d0.a(b11) == 0;
        } catch (IOException e10) {
            s3.b.f().e("HTTP request failed.", e10);
            throw new RuntimeException(e10);
        }
    }
}
