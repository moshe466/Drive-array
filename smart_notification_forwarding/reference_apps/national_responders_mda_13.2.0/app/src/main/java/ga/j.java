package ga;

import kotlin.reflect.jvm.internal.impl.protobuf.j;

/* loaded from: classes.dex */
public enum j implements j.a {
    DECLARATION(0, 0),
    FAKE_OVERRIDE(1, 1),
    DELEGATION(2, 2),
    SYNTHESIZED(3, 3);

    private static j.b<j> internalValueMap = new j.b<j>() { // from class: ga.j.a
        @Override // kotlin.reflect.jvm.internal.impl.protobuf.j.b
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public j a(int i10) {
            return j.valueOf(i10);
        }
    };
    private final int value;

    j(int i10, int i11) {
        this.value = i11;
    }

    public static j valueOf(int i10) {
        if (i10 == 0) {
            return DECLARATION;
        }
        if (i10 == 1) {
            return FAKE_OVERRIDE;
        }
        if (i10 == 2) {
            return DELEGATION;
        }
        if (i10 != 3) {
            return null;
        }
        return SYNTHESIZED;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.j.a
    public final int getNumber() {
        return this.value;
    }
}
