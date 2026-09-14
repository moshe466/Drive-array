package pa;

import bb.b0;
import bb.i0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import n9.d0;

/* loaded from: classes.dex */
public final class h {

    /* renamed from: a, reason: collision with root package name */
    public static final h f13329a = new h();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static final class a extends y8.l implements x8.l<d0, b0> {

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ b0 f13330f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(b0 b0Var) {
            super(1);
            this.f13330f = b0Var;
        }

        @Override // x8.l
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final b0 h(d0 d0Var) {
            y8.k.e(d0Var, "it");
            return this.f13330f;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static final class b extends y8.l implements x8.l<d0, b0> {

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ k9.i f13331f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(k9.i iVar) {
            super(1);
            this.f13331f = iVar;
        }

        @Override // x8.l
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final b0 h(d0 d0Var) {
            y8.k.e(d0Var, "module");
            i0 N = d0Var.w().N(this.f13331f);
            y8.k.d(N, "module.builtIns.getPrimitiveArrayKotlinType(componentType)");
            return N;
        }
    }

    private h() {
    }

    private final pa.b b(List<?> list, k9.i iVar) {
        List n02;
        n02 = m8.y.n0(list);
        ArrayList arrayList = new ArrayList();
        Iterator it = n02.iterator();
        while (it.hasNext()) {
            g<?> c10 = c(it.next());
            if (c10 != null) {
                arrayList.add(c10);
            }
        }
        return new pa.b(arrayList, new b(iVar));
    }

    public final pa.b a(List<? extends g<?>> list, b0 b0Var) {
        y8.k.e(list, "value");
        y8.k.e(b0Var, "type");
        return new pa.b(list, new a(b0Var));
    }

    public final g<?> c(Object obj) {
        List<?> Q;
        k9.i iVar;
        if (obj instanceof Byte) {
            return new d(((Number) obj).byteValue());
        }
        if (obj instanceof Short) {
            return new u(((Number) obj).shortValue());
        }
        if (obj instanceof Integer) {
            return new m(((Number) obj).intValue());
        }
        if (obj instanceof Long) {
            return new r(((Number) obj).longValue());
        }
        if (obj instanceof Character) {
            return new e(((Character) obj).charValue());
        }
        if (obj instanceof Float) {
            return new l(((Number) obj).floatValue());
        }
        if (obj instanceof Double) {
            return new i(((Number) obj).doubleValue());
        }
        if (obj instanceof Boolean) {
            return new c(((Boolean) obj).booleanValue());
        }
        if (obj instanceof String) {
            return new v((String) obj);
        }
        if (obj instanceof byte[]) {
            Q = m8.k.I((byte[]) obj);
            iVar = k9.i.BYTE;
        } else if (obj instanceof short[]) {
            Q = m8.k.P((short[]) obj);
            iVar = k9.i.SHORT;
        } else if (obj instanceof int[]) {
            Q = m8.k.M((int[]) obj);
            iVar = k9.i.INT;
        } else if (obj instanceof long[]) {
            Q = m8.k.N((long[]) obj);
            iVar = k9.i.LONG;
        } else if (obj instanceof char[]) {
            Q = m8.k.J((char[]) obj);
            iVar = k9.i.CHAR;
        } else if (obj instanceof float[]) {
            Q = m8.k.L((float[]) obj);
            iVar = k9.i.FLOAT;
        } else if (obj instanceof double[]) {
            Q = m8.k.K((double[]) obj);
            iVar = k9.i.DOUBLE;
        } else {
            if (!(obj instanceof boolean[])) {
                if (obj == null) {
                    return new s();
                }
                return null;
            }
            Q = m8.k.Q((boolean[]) obj);
            iVar = k9.i.BOOLEAN;
        }
        return b(Q, iVar);
    }
}
