package y8;

import java.io.Serializable;

/* loaded from: classes.dex */
public abstract class c implements e9.a, Serializable {

    /* renamed from: l, reason: collision with root package name */
    public static final Object f15932l = a.f15939f;

    /* renamed from: f, reason: collision with root package name */
    private transient e9.a f15933f;

    /* renamed from: g, reason: collision with root package name */
    protected final Object f15934g;

    /* renamed from: h, reason: collision with root package name */
    private final Class f15935h;

    /* renamed from: i, reason: collision with root package name */
    private final String f15936i;

    /* renamed from: j, reason: collision with root package name */
    private final String f15937j;

    /* renamed from: k, reason: collision with root package name */
    private final boolean f15938k;

    /* loaded from: classes.dex */
    private static class a implements Serializable {

        /* renamed from: f, reason: collision with root package name */
        private static final a f15939f = new a();

        private a() {
        }
    }

    public c() {
        this(f15932l);
    }

    protected c(Object obj) {
        this(obj, null, null, null, false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public c(Object obj, Class cls, String str, String str2, boolean z10) {
        this.f15934g = obj;
        this.f15935h = cls;
        this.f15936i = str;
        this.f15937j = str2;
        this.f15938k = z10;
    }

    @Override // e9.a
    public String c() {
        return this.f15936i;
    }

    public e9.a d() {
        e9.a aVar = this.f15933f;
        if (aVar != null) {
            return aVar;
        }
        e9.a i10 = i();
        this.f15933f = i10;
        return i10;
    }

    protected abstract e9.a i();

    public Object j() {
        return this.f15934g;
    }

    public e9.d k() {
        Class cls = this.f15935h;
        if (cls == null) {
            return null;
        }
        return this.f15938k ? w.c(cls) : w.b(cls);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public e9.a l() {
        e9.a d10 = d();
        if (d10 != this) {
            return d10;
        }
        throw new w8.b();
    }

    public String m() {
        return this.f15937j;
    }
}
