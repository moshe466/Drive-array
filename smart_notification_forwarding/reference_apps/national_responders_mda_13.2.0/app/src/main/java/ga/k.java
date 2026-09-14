package ga;

import kotlin.reflect.jvm.internal.impl.protobuf.j;

/* loaded from: classes.dex */
public enum k implements j.a {
    FINAL(0, 0),
    OPEN(1, 1),
    ABSTRACT(2, 2),
    SEALED(3, 3);

    private static j.b<k> internalValueMap = new j.b<k>() { // from class: ga.k.a
        @Override // kotlin.reflect.jvm.internal.impl.protobuf.j.b
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public k a(int i10) {
            return k.valueOf(i10);
        }
    };
    private final int value;

    k(int i10, int i11) {
        this.value = i11;
    }

    public static k valueOf(int i10) {
        if (i10 == 0) {
            return FINAL;
        }
        if (i10 == 1) {
            return OPEN;
        }
        if (i10 == 2) {
            return ABSTRACT;
        }
        if (i10 != 3) {
            return null;
        }
        return SEALED;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.j.a
    public final int getNumber() {
        return this.value;
    }
}
