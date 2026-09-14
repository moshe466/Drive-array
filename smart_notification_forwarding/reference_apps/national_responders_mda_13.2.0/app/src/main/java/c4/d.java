package c4;

import c4.c;
import java.io.File;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class d implements c {

    /* renamed from: a, reason: collision with root package name */
    private final File f4387a;

    /* renamed from: b, reason: collision with root package name */
    private final File[] f4388b;

    /* renamed from: c, reason: collision with root package name */
    private final Map<String, String> f4389c;

    public d(File file) {
        this(file, Collections.emptyMap());
    }

    public d(File file, Map<String, String> map) {
        this.f4387a = file;
        this.f4388b = new File[]{file};
        this.f4389c = new HashMap(map);
    }

    @Override // c4.c
    public Map<String, String> a() {
        return Collections.unmodifiableMap(this.f4389c);
    }

    @Override // c4.c
    public c.a b() {
        return c.a.JAVA;
    }

    @Override // c4.c
    public File[] c() {
        return this.f4388b;
    }

    @Override // c4.c
    public String d() {
        return f().getName();
    }

    @Override // c4.c
    public String e() {
        String d10 = d();
        return d10.substring(0, d10.lastIndexOf(46));
    }

    @Override // c4.c
    public File f() {
        return this.f4387a;
    }

    @Override // c4.c
    public void remove() {
        s3.b.f().b("Removing report at " + this.f4387a.getPath());
        this.f4387a.delete();
    }
}
