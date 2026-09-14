package n9;

import java.util.Collection;

/* loaded from: classes.dex */
public interface y0 {

    /* loaded from: classes.dex */
    public static final class a implements y0 {

        /* renamed from: a, reason: collision with root package name */
        public static final a f12328a = new a();

        private a() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // n9.y0
        public Collection<bb.b0> a(bb.t0 t0Var, Collection<? extends bb.b0> collection, x8.l<? super bb.t0, ? extends Iterable<? extends bb.b0>> lVar, x8.l<? super bb.b0, l8.w> lVar2) {
            y8.k.e(t0Var, "currentTypeConstructor");
            y8.k.e(collection, "superTypes");
            y8.k.e(lVar, "neighbors");
            y8.k.e(lVar2, "reportLoop");
            return collection;
        }
    }

    Collection<bb.b0> a(bb.t0 t0Var, Collection<? extends bb.b0> collection, x8.l<? super bb.t0, ? extends Iterable<? extends bb.b0>> lVar, x8.l<? super bb.b0, l8.w> lVar2);
}
