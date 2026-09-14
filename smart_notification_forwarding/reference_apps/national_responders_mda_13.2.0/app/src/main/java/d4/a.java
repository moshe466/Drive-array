package d4;

import c4.c;

/* loaded from: classes.dex */
public class a implements b {

    /* renamed from: a, reason: collision with root package name */
    private final c f8653a;

    /* renamed from: b, reason: collision with root package name */
    private final d f8654b;

    /* renamed from: d4.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    static /* synthetic */ class C0140a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f8655a;

        static {
            int[] iArr = new int[c.a.values().length];
            f8655a = iArr;
            try {
                iArr[c.a.JAVA.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f8655a[c.a.NATIVE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public a(c cVar, d dVar) {
        this.f8653a = cVar;
        this.f8654b = dVar;
    }

    @Override // d4.b
    public boolean b(c4.a aVar, boolean z10) {
        int i10 = C0140a.f8655a[aVar.f4385c.b().ordinal()];
        if (i10 == 1) {
            this.f8653a.b(aVar, z10);
            return true;
        }
        if (i10 != 2) {
            return false;
        }
        this.f8654b.b(aVar, z10);
        return true;
    }
}
