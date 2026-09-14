package r3;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final /* synthetic */ class f implements r4.b {

    /* renamed from: a, reason: collision with root package name */
    private final String f13738a;

    private f(String str) {
        this.f13738a = str;
    }

    public static r4.b a(String str) {
        return new f(str);
    }

    @Override // r4.b
    public Object get() {
        i c10;
        c10 = g.c(this.f13738a);
        return c10;
    }
}
