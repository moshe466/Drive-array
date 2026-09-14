package m3;

/* loaded from: classes.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private final String f12017a;

    /* loaded from: classes.dex */
    class a extends b {
        a(b bVar, b bVar2, String str) {
            super(bVar2, null);
        }

        @Override // m3.b
        public b b(String str) {
            throw new UnsupportedOperationException("already specified useForNull");
        }
    }

    private b(String str) {
        this.f12017a = (String) d.h(str);
    }

    private b(b bVar) {
        this.f12017a = bVar.f12017a;
    }

    /* synthetic */ b(b bVar, a aVar) {
        this(bVar);
    }

    public static b a(String str) {
        return new b(str);
    }

    public b b(String str) {
        d.h(str);
        return new a(this, this, str);
    }
}
