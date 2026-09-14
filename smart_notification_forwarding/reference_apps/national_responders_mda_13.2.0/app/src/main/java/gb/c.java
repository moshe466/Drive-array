package gb;

/* loaded from: classes.dex */
public abstract class c {

    /* renamed from: a, reason: collision with root package name */
    private final boolean f10341a;

    /* loaded from: classes.dex */
    public static final class a extends c {

        /* renamed from: b, reason: collision with root package name */
        public static final a f10342b = new a();

        private a() {
            super(false, null);
        }
    }

    /* loaded from: classes.dex */
    public static final class b extends c {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(String str) {
            super(false, null);
            y8.k.e(str, "error");
        }
    }

    /* renamed from: gb.c$c, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static final class C0183c extends c {

        /* renamed from: b, reason: collision with root package name */
        public static final C0183c f10343b = new C0183c();

        private C0183c() {
            super(true, null);
        }
    }

    private c(boolean z10) {
        this.f10341a = z10;
    }

    public /* synthetic */ c(boolean z10, y8.g gVar) {
        this(z10);
    }

    public final boolean a() {
        return this.f10341a;
    }
}
