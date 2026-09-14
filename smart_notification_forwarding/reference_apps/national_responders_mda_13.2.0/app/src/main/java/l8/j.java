package l8;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j {

    /* loaded from: classes.dex */
    public /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f11809a;

        static {
            int[] iArr = new int[kotlin.b.values().length];
            iArr[kotlin.b.SYNCHRONIZED.ordinal()] = 1;
            iArr[kotlin.b.PUBLICATION.ordinal()] = 2;
            iArr[kotlin.b.NONE.ordinal()] = 3;
            f11809a = iArr;
        }
    }

    public static <T> h<T> a(kotlin.b bVar, x8.a<? extends T> aVar) {
        y8.k.e(bVar, "mode");
        y8.k.e(aVar, "initializer");
        int i10 = a.f11809a[bVar.ordinal()];
        if (i10 == 1) {
            return new r(aVar, null, 2, null);
        }
        if (i10 == 2) {
            return new q(aVar);
        }
        if (i10 == 3) {
            return new x(aVar);
        }
        throw new l();
    }

    public static <T> h<T> b(x8.a<? extends T> aVar) {
        y8.k.e(aVar, "initializer");
        return new r(aVar, null, 2, null);
    }
}
