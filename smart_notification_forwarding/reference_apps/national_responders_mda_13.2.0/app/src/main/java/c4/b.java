package c4;

import c4.c;
import java.io.File;
import java.util.Map;

/* loaded from: classes.dex */
public class b implements c {

    /* renamed from: a, reason: collision with root package name */
    private final File f4386a;

    public b(File file) {
        this.f4386a = file;
    }

    @Override // c4.c
    public Map<String, String> a() {
        return null;
    }

    @Override // c4.c
    public c.a b() {
        return c.a.NATIVE;
    }

    @Override // c4.c
    public File[] c() {
        return this.f4386a.listFiles();
    }

    @Override // c4.c
    public String d() {
        return null;
    }

    @Override // c4.c
    public String e() {
        return this.f4386a.getName();
    }

    @Override // c4.c
    public File f() {
        return null;
    }

    @Override // c4.c
    public void remove() {
        for (File file : c()) {
            s3.b.f().b("Removing native report file at " + file.getPath());
            file.delete();
        }
        s3.b.f().b("Removing native report directory at " + this.f4386a);
        this.f4386a.delete();
    }
}
