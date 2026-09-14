package d4;

import com.google.firebase.crashlytics.internal.common.d0;
import com.google.firebase.crashlytics.internal.common.m;
import java.io.File;
import java.io.IOException;

/* loaded from: classes.dex */
public class d extends com.google.firebase.crashlytics.internal.common.a implements b {

    /* renamed from: f, reason: collision with root package name */
    private final String f8657f;

    public d(String str, String str2, y3.c cVar, String str3) {
        super(str, str2, cVar, y3.a.POST);
        this.f8657f = str3;
    }

    private y3.b g(y3.b bVar, String str) {
        bVar.d("User-Agent", "Crashlytics Android SDK/" + m.i()).d("X-CRASHLYTICS-API-CLIENT-TYPE", "android").d("X-CRASHLYTICS-API-CLIENT-VERSION", this.f8657f).d("X-CRASHLYTICS-GOOGLE-APP-ID", str);
        return bVar;
    }

    private y3.b h(y3.b bVar, String str, c4.c cVar) {
        String name;
        String str2;
        if (str != null) {
            bVar.g("org_id", str);
        }
        bVar.g("report_id", cVar.e());
        for (File file : cVar.c()) {
            if (file.getName().equals("minidump")) {
                name = file.getName();
                str2 = "minidump_file";
            } else if (file.getName().equals("metadata")) {
                name = file.getName();
                str2 = "crash_meta_file";
            } else if (file.getName().equals("binaryImages")) {
                name = file.getName();
                str2 = "binary_images_file";
            } else if (file.getName().equals("session")) {
                name = file.getName();
                str2 = "session_meta_file";
            } else if (file.getName().equals("app")) {
                name = file.getName();
                str2 = "app_meta_file";
            } else if (file.getName().equals("device")) {
                name = file.getName();
                str2 = "device_meta_file";
            } else if (file.getName().equals("os")) {
                name = file.getName();
                str2 = "os_meta_file";
            } else if (file.getName().equals("user")) {
                name = file.getName();
                str2 = "user_meta_file";
            } else if (file.getName().equals("logs")) {
                name = file.getName();
                str2 = "logs_file";
            } else if (file.getName().equals("keys")) {
                name = file.getName();
                str2 = "keys_file";
            }
            bVar.h(str2, name, "application/octet-stream", file);
        }
        return bVar;
    }

    @Override // d4.b
    public boolean b(c4.a aVar, boolean z10) {
        if (!z10) {
            throw new RuntimeException("An invalid data collection token was used.");
        }
        y3.b h10 = h(g(c(), aVar.f4384b), aVar.f4383a, aVar.f4385c);
        s3.b.f().b("Sending report to: " + e());
        try {
            int b10 = h10.b().b();
            s3.b.f().b("Result was: " + b10);
            return d0.a(b10) == 0;
        } catch (IOException e10) {
            throw new RuntimeException(e10);
        }
    }
}
