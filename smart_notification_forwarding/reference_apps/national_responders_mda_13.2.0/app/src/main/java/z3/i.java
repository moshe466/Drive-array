package z3;

import android.content.Context;
import java.io.File;

/* loaded from: classes.dex */
public class i implements h {

    /* renamed from: a, reason: collision with root package name */
    private final Context f16158a;

    public i(Context context) {
        this.f16158a = context;
    }

    @Override // z3.h
    public String a() {
        return new File(this.f16158a.getFilesDir(), ".com.google.firebase.crashlytics").getPath();
    }

    @Override // z3.h
    public File b() {
        return c(new File(this.f16158a.getFilesDir(), ".com.google.firebase.crashlytics"));
    }

    File c(File file) {
        if (file == null) {
            s3.b.f().b("Null File");
            return null;
        }
        if (file.exists() || file.mkdirs()) {
            return file;
        }
        s3.b.f().i("Couldn't create file");
        return null;
    }
}
