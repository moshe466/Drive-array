package com.google.firebase.crashlytics.internal.common;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import org.json.JSONObject;

/* loaded from: classes.dex */
class a0 {

    /* renamed from: b, reason: collision with root package name */
    private static final Charset f7067b = Charset.forName("UTF-8");

    /* renamed from: a, reason: collision with root package name */
    private final File f7068a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a extends JSONObject {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ i0 f7069a;

        a(i0 i0Var) {
            this.f7069a = i0Var;
            put("userId", i0Var.b());
        }
    }

    public a0(File file) {
        this.f7068a = file;
    }

    private static i0 c(String str) {
        JSONObject jSONObject = new JSONObject(str);
        i0 i0Var = new i0();
        i0Var.d(f(jSONObject, "userId"));
        return i0Var;
    }

    private static String e(i0 i0Var) {
        return new a(i0Var).toString();
    }

    private static String f(JSONObject jSONObject, String str) {
        if (jSONObject.isNull(str)) {
            return null;
        }
        return jSONObject.optString(str, null);
    }

    public File a(String str) {
        return new File(this.f7068a, str + "keys.meta");
    }

    public File b(String str) {
        return new File(this.f7068a, str + "user.meta");
    }

    public i0 d(String str) {
        FileInputStream fileInputStream;
        File b10 = b(str);
        if (!b10.exists()) {
            return new i0();
        }
        FileInputStream fileInputStream2 = null;
        try {
            try {
                fileInputStream = new FileInputStream(b10);
            } catch (Exception e10) {
                e = e10;
            }
        } catch (Throwable th) {
            th = th;
        }
        try {
            i0 c10 = c(h.F(fileInputStream));
            h.e(fileInputStream, "Failed to close user metadata file.");
            return c10;
        } catch (Exception e11) {
            e = e11;
            fileInputStream2 = fileInputStream;
            s3.b.f().e("Error deserializing user metadata.", e);
            h.e(fileInputStream2, "Failed to close user metadata file.");
            return new i0();
        } catch (Throwable th2) {
            th = th2;
            fileInputStream2 = fileInputStream;
            h.e(fileInputStream2, "Failed to close user metadata file.");
            throw th;
        }
    }

    public void g(String str, i0 i0Var) {
        String e10;
        BufferedWriter bufferedWriter;
        File b10 = b(str);
        BufferedWriter bufferedWriter2 = null;
        try {
            try {
                e10 = e(i0Var);
                bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(b10), f7067b));
            } catch (Exception e11) {
                e = e11;
            }
        } catch (Throwable th) {
            th = th;
        }
        try {
            bufferedWriter.write(e10);
            bufferedWriter.flush();
            h.e(bufferedWriter, "Failed to close user metadata file.");
        } catch (Exception e12) {
            e = e12;
            bufferedWriter2 = bufferedWriter;
            s3.b.f().e("Error serializing user metadata.", e);
            h.e(bufferedWriter2, "Failed to close user metadata file.");
        } catch (Throwable th2) {
            th = th2;
            bufferedWriter2 = bufferedWriter;
            h.e(bufferedWriter2, "Failed to close user metadata file.");
            throw th;
        }
    }
}
