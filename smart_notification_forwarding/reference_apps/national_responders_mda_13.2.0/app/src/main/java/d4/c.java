package d4;

import com.google.firebase.crashlytics.internal.common.d0;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes.dex */
public class c extends com.google.firebase.crashlytics.internal.common.a implements b {

    /* renamed from: f, reason: collision with root package name */
    private final String f8656f;

    public c(String str, String str2, y3.c cVar, String str3) {
        this(str, str2, cVar, y3.a.POST, str3);
    }

    c(String str, String str2, y3.c cVar, y3.a aVar, String str3) {
        super(str, str2, cVar, aVar);
        this.f8656f = str3;
    }

    private y3.b g(y3.b bVar, c4.a aVar) {
        y3.b d10 = bVar.d("X-CRASHLYTICS-GOOGLE-APP-ID", aVar.f4384b).d("X-CRASHLYTICS-API-CLIENT-TYPE", "android").d("X-CRASHLYTICS-API-CLIENT-VERSION", this.f8656f);
        Iterator<Map.Entry<String, String>> it = aVar.f4385c.a().entrySet().iterator();
        while (it.hasNext()) {
            d10 = d10.e(it.next());
        }
        return d10;
    }

    private y3.b h(y3.b bVar, c4.c cVar) {
        y3.b g10 = bVar.g("report[identifier]", cVar.e());
        if (cVar.c().length == 1) {
            s3.b.f().b("Adding single file " + cVar.d() + " to report " + cVar.e());
            return g10.h("report[file]", cVar.d(), "application/octet-stream", cVar.f());
        }
        int i10 = 0;
        for (File file : cVar.c()) {
            s3.b.f().b("Adding file " + file.getName() + " to report " + cVar.e());
            StringBuilder sb2 = new StringBuilder();
            sb2.append("report[file");
            sb2.append(i10);
            sb2.append("]");
            g10 = g10.h(sb2.toString(), file.getName(), "application/octet-stream", file);
            i10++;
        }
        return g10;
    }

    @Override // d4.b
    public boolean b(c4.a aVar, boolean z10) {
        if (!z10) {
            throw new RuntimeException("An invalid data collection token was used.");
        }
        y3.b h10 = h(g(c(), aVar), aVar.f4385c);
        s3.b.f().b("Sending report to: " + e());
        try {
            y3.d b10 = h10.b();
            int b11 = b10.b();
            s3.b.f().b("Create report request ID: " + b10.d("X-REQUEST-ID"));
            s3.b.f().b("Result was: " + b11);
            return d0.a(b11) == 0;
        } catch (IOException e10) {
            s3.b.f().e("Create report HTTP request failed.", e10);
            throw new RuntimeException(e10);
        }
    }
}
