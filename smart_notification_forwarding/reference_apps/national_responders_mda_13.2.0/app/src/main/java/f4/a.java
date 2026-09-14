package f4;

import android.content.Context;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import org.json.JSONObject;
import z3.i;

/* loaded from: classes.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private final Context f9358a;

    public a(Context context) {
        this.f9358a = context;
    }

    private File a() {
        return new File(new i(this.f9358a).b(), "com.crashlytics.settings.json");
    }

    public JSONObject b() {
        Throwable th;
        FileInputStream fileInputStream;
        JSONObject jSONObject;
        s3.b.f().b("Reading cached settings...");
        FileInputStream fileInputStream2 = null;
        try {
            try {
                File a10 = a();
                if (a10.exists()) {
                    fileInputStream = new FileInputStream(a10);
                    try {
                        jSONObject = new JSONObject(com.google.firebase.crashlytics.internal.common.h.F(fileInputStream));
                        fileInputStream2 = fileInputStream;
                    } catch (Exception e10) {
                        e = e10;
                        s3.b.f().e("Failed to fetch cached settings", e);
                        com.google.firebase.crashlytics.internal.common.h.e(fileInputStream, "Error while closing settings cache file.");
                        return null;
                    }
                } else {
                    s3.b.f().b("No cached settings found.");
                    jSONObject = null;
                }
                com.google.firebase.crashlytics.internal.common.h.e(fileInputStream2, "Error while closing settings cache file.");
                return jSONObject;
            } catch (Throwable th2) {
                th = th2;
                com.google.firebase.crashlytics.internal.common.h.e(null, "Error while closing settings cache file.");
                throw th;
            }
        } catch (Exception e11) {
            e = e11;
            fileInputStream = null;
        } catch (Throwable th3) {
            th = th3;
            com.google.firebase.crashlytics.internal.common.h.e(null, "Error while closing settings cache file.");
            throw th;
        }
    }

    public void c(long j10, JSONObject jSONObject) {
        FileWriter fileWriter;
        s3.b.f().b("Writing settings to cache file...");
        if (jSONObject != null) {
            FileWriter fileWriter2 = null;
            try {
                try {
                    jSONObject.put("expires_at", j10);
                    fileWriter = new FileWriter(a());
                } catch (Throwable th) {
                    th = th;
                }
            } catch (Exception e10) {
                e = e10;
            }
            try {
                fileWriter.write(jSONObject.toString());
                fileWriter.flush();
                com.google.firebase.crashlytics.internal.common.h.e(fileWriter, "Failed to close settings writer.");
            } catch (Exception e11) {
                e = e11;
                fileWriter2 = fileWriter;
                s3.b.f().e("Failed to cache settings", e);
                com.google.firebase.crashlytics.internal.common.h.e(fileWriter2, "Failed to close settings writer.");
            } catch (Throwable th2) {
                th = th2;
                fileWriter2 = fileWriter;
                com.google.firebase.crashlytics.internal.common.h.e(fileWriter2, "Failed to close settings writer.");
                throw th;
            }
        }
    }
}
