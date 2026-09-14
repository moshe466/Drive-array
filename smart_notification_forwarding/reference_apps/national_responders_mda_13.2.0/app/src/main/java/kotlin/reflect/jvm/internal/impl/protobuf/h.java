package kotlin.reflect.jvm.internal.impl.protobuf;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.reflect.jvm.internal.impl.protobuf.h.b;
import kotlin.reflect.jvm.internal.impl.protobuf.j;
import kotlin.reflect.jvm.internal.impl.protobuf.l;
import kotlin.reflect.jvm.internal.impl.protobuf.q;
import kotlin.reflect.jvm.internal.impl.protobuf.z;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class h<FieldDescriptorType extends b<FieldDescriptorType>> {

    /* renamed from: d, reason: collision with root package name */
    private static final h f11413d = new h(true);

    /* renamed from: b, reason: collision with root package name */
    private boolean f11415b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f11416c = false;

    /* renamed from: a, reason: collision with root package name */
    private final v<FieldDescriptorType, Object> f11414a = v.o(16);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f11417a;

        /* renamed from: b, reason: collision with root package name */
        static final /* synthetic */ int[] f11418b;

        static {
            int[] iArr = new int[z.b.values().length];
            f11418b = iArr;
            try {
                iArr[z.b.DOUBLE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f11418b[z.b.FLOAT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f11418b[z.b.INT64.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f11418b[z.b.UINT64.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f11418b[z.b.INT32.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f11418b[z.b.FIXED64.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f11418b[z.b.FIXED32.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f11418b[z.b.BOOL.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f11418b[z.b.STRING.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f11418b[z.b.BYTES.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f11418b[z.b.UINT32.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f11418b[z.b.SFIXED32.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                f11418b[z.b.SFIXED64.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                f11418b[z.b.SINT32.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                f11418b[z.b.SINT64.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                f11418b[z.b.GROUP.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                f11418b[z.b.MESSAGE.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                f11418b[z.b.ENUM.ordinal()] = 18;
            } catch (NoSuchFieldError unused18) {
            }
            int[] iArr2 = new int[z.c.values().length];
            f11417a = iArr2;
            try {
                iArr2[z.c.INT.ordinal()] = 1;
            } catch (NoSuchFieldError unused19) {
            }
            try {
                f11417a[z.c.LONG.ordinal()] = 2;
            } catch (NoSuchFieldError unused20) {
            }
            try {
                f11417a[z.c.FLOAT.ordinal()] = 3;
            } catch (NoSuchFieldError unused21) {
            }
            try {
                f11417a[z.c.DOUBLE.ordinal()] = 4;
            } catch (NoSuchFieldError unused22) {
            }
            try {
                f11417a[z.c.BOOLEAN.ordinal()] = 5;
            } catch (NoSuchFieldError unused23) {
            }
            try {
                f11417a[z.c.STRING.ordinal()] = 6;
            } catch (NoSuchFieldError unused24) {
            }
            try {
                f11417a[z.c.BYTE_STRING.ordinal()] = 7;
            } catch (NoSuchFieldError unused25) {
            }
            try {
                f11417a[z.c.ENUM.ordinal()] = 8;
            } catch (NoSuchFieldError unused26) {
            }
            try {
                f11417a[z.c.MESSAGE.ordinal()] = 9;
            } catch (NoSuchFieldError unused27) {
            }
        }
    }

    /* loaded from: classes.dex */
    public interface b<T extends b<T>> extends Comparable<T> {
        q.a e(q.a aVar, q qVar);

        boolean f();

        z.b g();

        int getNumber();

        z.c p();

        boolean q();
    }

    private h() {
    }

    private h(boolean z10) {
        q();
    }

    private Object c(Object obj) {
        if (!(obj instanceof byte[])) {
            return obj;
        }
        byte[] bArr = (byte[]) obj;
        byte[] bArr2 = new byte[bArr.length];
        System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        return bArr2;
    }

    private static int d(z.b bVar, int i10, Object obj) {
        int D = f.D(i10);
        if (bVar == z.b.GROUP) {
            D *= 2;
        }
        return D + e(bVar, obj);
    }

    private static int e(z.b bVar, Object obj) {
        switch (a.f11418b[bVar.ordinal()]) {
            case 1:
                return f.g(((Double) obj).doubleValue());
            case 2:
                return f.m(((Float) obj).floatValue());
            case 3:
                return f.q(((Long) obj).longValue());
            case 4:
                return f.F(((Long) obj).longValue());
            case 5:
                return f.p(((Integer) obj).intValue());
            case 6:
                return f.k(((Long) obj).longValue());
            case 7:
                return f.j(((Integer) obj).intValue());
            case 8:
                return f.b(((Boolean) obj).booleanValue());
            case 9:
                return f.C((String) obj);
            case 10:
                return obj instanceof d ? f.e((d) obj) : f.c((byte[]) obj);
            case 11:
                return f.E(((Integer) obj).intValue());
            case 12:
                return f.x(((Integer) obj).intValue());
            case 13:
                return f.y(((Long) obj).longValue());
            case 14:
                return f.z(((Integer) obj).intValue());
            case 15:
                return f.B(((Long) obj).longValue());
            case 16:
                return f.n((q) obj);
            case 17:
                return obj instanceof l ? f.r((l) obj) : f.t((q) obj);
            case 18:
                return obj instanceof j.a ? f.i(((j.a) obj).getNumber()) : f.i(((Integer) obj).intValue());
            default:
                throw new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
        }
    }

    public static int f(b<?> bVar, Object obj) {
        z.b g10 = bVar.g();
        int number = bVar.getNumber();
        if (!bVar.f()) {
            return d(g10, number, obj);
        }
        int i10 = 0;
        List list = (List) obj;
        if (bVar.q()) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                i10 += e(g10, it.next());
            }
            return f.D(number) + i10 + f.v(i10);
        }
        Iterator it2 = list.iterator();
        while (it2.hasNext()) {
            i10 += d(g10, number, it2.next());
        }
        return i10;
    }

    public static <T extends b<T>> h<T> g() {
        return f11413d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int l(z.b bVar, boolean z10) {
        if (z10) {
            return 2;
        }
        return bVar.getWireType();
    }

    private boolean o(Map.Entry<FieldDescriptorType, Object> entry) {
        FieldDescriptorType key = entry.getKey();
        if (key.p() == z.c.MESSAGE) {
            boolean f10 = key.f();
            Object value = entry.getValue();
            if (f10) {
                Iterator it = ((List) value).iterator();
                while (it.hasNext()) {
                    if (!((q) it.next()).k()) {
                        return false;
                    }
                }
            } else {
                if (!(value instanceof q)) {
                    if (value instanceof l) {
                        return true;
                    }
                    throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
                }
                if (!((q) value).k()) {
                    return false;
                }
            }
        }
        return true;
    }

    private void s(Map.Entry<FieldDescriptorType, Object> entry) {
        v<FieldDescriptorType, Object> vVar;
        Object c10;
        Object h10;
        FieldDescriptorType key = entry.getKey();
        Object value = entry.getValue();
        if (value instanceof l) {
            value = ((l) value).e();
        }
        if (key.f()) {
            Object h11 = h(key);
            if (h11 == null) {
                h11 = new ArrayList();
            }
            Iterator it = ((List) value).iterator();
            while (it.hasNext()) {
                ((List) h11).add(c(it.next()));
            }
            this.f11414a.p(key, h11);
            return;
        }
        if (key.p() != z.c.MESSAGE || (h10 = h(key)) == null) {
            vVar = this.f11414a;
            c10 = c(value);
        } else {
            c10 = key.e(((q) h10).d(), (q) value).c();
            vVar = this.f11414a;
        }
        vVar.p(key, c10);
    }

    public static <T extends b<T>> h<T> t() {
        return new h<>();
    }

    public static Object u(e eVar, z.b bVar, boolean z10) {
        switch (a.f11418b[bVar.ordinal()]) {
            case 1:
                return Double.valueOf(eVar.m());
            case 2:
                return Float.valueOf(eVar.q());
            case 3:
                return Long.valueOf(eVar.t());
            case 4:
                return Long.valueOf(eVar.M());
            case 5:
                return Integer.valueOf(eVar.s());
            case 6:
                return Long.valueOf(eVar.p());
            case 7:
                return Integer.valueOf(eVar.o());
            case 8:
                return Boolean.valueOf(eVar.k());
            case 9:
                return z10 ? eVar.J() : eVar.I();
            case 10:
                return eVar.l();
            case 11:
                return Integer.valueOf(eVar.L());
            case 12:
                return Integer.valueOf(eVar.E());
            case 13:
                return Long.valueOf(eVar.F());
            case 14:
                return Integer.valueOf(eVar.G());
            case 15:
                return Long.valueOf(eVar.H());
            case 16:
                throw new IllegalArgumentException("readPrimitiveField() cannot handle nested groups.");
            case 17:
                throw new IllegalArgumentException("readPrimitiveField() cannot handle embedded messages.");
            case 18:
                throw new IllegalArgumentException("readPrimitiveField() cannot handle enums.");
            default:
                throw new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0024, code lost:
    
        if ((r3 instanceof kotlin.reflect.jvm.internal.impl.protobuf.j.a) == false) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x002d, code lost:
    
        if ((r3 instanceof byte[]) == false) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x001b, code lost:
    
        if ((r3 instanceof kotlin.reflect.jvm.internal.impl.protobuf.l) == false) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x0030, code lost:
    
        r0 = false;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static void w(kotlin.reflect.jvm.internal.impl.protobuf.z.b r2, java.lang.Object r3) {
        /*
            java.util.Objects.requireNonNull(r3)
            int[] r0 = kotlin.reflect.jvm.internal.impl.protobuf.h.a.f11417a
            kotlin.reflect.jvm.internal.impl.protobuf.z$c r2 = r2.getJavaType()
            int r2 = r2.ordinal()
            r2 = r0[r2]
            r0 = 1
            r1 = 0
            switch(r2) {
                case 1: goto L42;
                case 2: goto L3f;
                case 3: goto L3c;
                case 4: goto L39;
                case 5: goto L36;
                case 6: goto L33;
                case 7: goto L27;
                case 8: goto L1e;
                case 9: goto L15;
                default: goto L14;
            }
        L14:
            goto L44
        L15:
            boolean r2 = r3 instanceof kotlin.reflect.jvm.internal.impl.protobuf.q
            if (r2 != 0) goto L31
            boolean r2 = r3 instanceof kotlin.reflect.jvm.internal.impl.protobuf.l
            if (r2 == 0) goto L30
            goto L31
        L1e:
            boolean r2 = r3 instanceof java.lang.Integer
            if (r2 != 0) goto L31
            boolean r2 = r3 instanceof kotlin.reflect.jvm.internal.impl.protobuf.j.a
            if (r2 == 0) goto L30
            goto L31
        L27:
            boolean r2 = r3 instanceof kotlin.reflect.jvm.internal.impl.protobuf.d
            if (r2 != 0) goto L31
            boolean r2 = r3 instanceof byte[]
            if (r2 == 0) goto L30
            goto L31
        L30:
            r0 = 0
        L31:
            r1 = r0
            goto L44
        L33:
            boolean r1 = r3 instanceof java.lang.String
            goto L44
        L36:
            boolean r1 = r3 instanceof java.lang.Boolean
            goto L44
        L39:
            boolean r1 = r3 instanceof java.lang.Double
            goto L44
        L3c:
            boolean r1 = r3 instanceof java.lang.Float
            goto L44
        L3f:
            boolean r1 = r3 instanceof java.lang.Long
            goto L44
        L42:
            boolean r1 = r3 instanceof java.lang.Integer
        L44:
            if (r1 == 0) goto L47
            return
        L47:
            java.lang.IllegalArgumentException r2 = new java.lang.IllegalArgumentException
            java.lang.String r3 = "Wrong object type used with protocol message reflection."
            r2.<init>(r3)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.protobuf.h.w(kotlin.reflect.jvm.internal.impl.protobuf.z$b, java.lang.Object):void");
    }

    private static void x(f fVar, z.b bVar, int i10, Object obj) {
        if (bVar == z.b.GROUP) {
            fVar.Y(i10, (q) obj);
        } else {
            fVar.w0(i10, l(bVar, false));
            y(fVar, bVar, obj);
        }
    }

    private static void y(f fVar, z.b bVar, Object obj) {
        switch (a.f11418b[bVar.ordinal()]) {
            case 1:
                fVar.R(((Double) obj).doubleValue());
                return;
            case 2:
                fVar.X(((Float) obj).floatValue());
                return;
            case 3:
                fVar.c0(((Long) obj).longValue());
                return;
            case 4:
                fVar.z0(((Long) obj).longValue());
                return;
            case 5:
                fVar.b0(((Integer) obj).intValue());
                return;
            case 6:
                fVar.V(((Long) obj).longValue());
                return;
            case 7:
                fVar.U(((Integer) obj).intValue());
                return;
            case 8:
                fVar.M(((Boolean) obj).booleanValue());
                return;
            case 9:
                fVar.v0((String) obj);
                return;
            case 10:
                if (obj instanceof d) {
                    fVar.P((d) obj);
                    return;
                } else {
                    fVar.N((byte[]) obj);
                    return;
                }
            case 11:
                fVar.y0(((Integer) obj).intValue());
                return;
            case 12:
                fVar.q0(((Integer) obj).intValue());
                return;
            case 13:
                fVar.r0(((Long) obj).longValue());
                return;
            case 14:
                fVar.s0(((Integer) obj).intValue());
                return;
            case 15:
                fVar.u0(((Long) obj).longValue());
                return;
            case 16:
                fVar.Z((q) obj);
                return;
            case 17:
                fVar.e0((q) obj);
                return;
            case 18:
                fVar.T(obj instanceof j.a ? ((j.a) obj).getNumber() : ((Integer) obj).intValue());
                return;
            default:
                return;
        }
    }

    public static void z(b<?> bVar, Object obj, f fVar) {
        z.b g10 = bVar.g();
        int number = bVar.getNumber();
        if (!bVar.f()) {
            if (obj instanceof l) {
                x(fVar, g10, number, ((l) obj).e());
                return;
            } else {
                x(fVar, g10, number, obj);
                return;
            }
        }
        List list = (List) obj;
        if (!bVar.q()) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                x(fVar, g10, number, it.next());
            }
            return;
        }
        fVar.w0(number, 2);
        int i10 = 0;
        Iterator it2 = list.iterator();
        while (it2.hasNext()) {
            i10 += e(g10, it2.next());
        }
        fVar.o0(i10);
        Iterator it3 = list.iterator();
        while (it3.hasNext()) {
            y(fVar, g10, it3.next());
        }
    }

    public void a(FieldDescriptorType fielddescriptortype, Object obj) {
        List list;
        if (!fielddescriptortype.f()) {
            throw new IllegalArgumentException("addRepeatedField() can only be called on repeated fields.");
        }
        w(fielddescriptortype.g(), obj);
        Object h10 = h(fielddescriptortype);
        if (h10 == null) {
            list = new ArrayList();
            this.f11414a.p(fielddescriptortype, list);
        } else {
            list = (List) h10;
        }
        list.add(obj);
    }

    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public h<FieldDescriptorType> clone() {
        h<FieldDescriptorType> t10 = t();
        for (int i10 = 0; i10 < this.f11414a.i(); i10++) {
            Map.Entry<FieldDescriptorType, Object> h10 = this.f11414a.h(i10);
            t10.v(h10.getKey(), h10.getValue());
        }
        for (Map.Entry<FieldDescriptorType, Object> entry : this.f11414a.j()) {
            t10.v(entry.getKey(), entry.getValue());
        }
        t10.f11416c = this.f11416c;
        return t10;
    }

    public Object h(FieldDescriptorType fielddescriptortype) {
        Object obj = this.f11414a.get(fielddescriptortype);
        return obj instanceof l ? ((l) obj).e() : obj;
    }

    public Object i(FieldDescriptorType fielddescriptortype, int i10) {
        if (!fielddescriptortype.f()) {
            throw new IllegalArgumentException("getRepeatedField() can only be called on repeated fields.");
        }
        Object h10 = h(fielddescriptortype);
        if (h10 != null) {
            return ((List) h10).get(i10);
        }
        throw new IndexOutOfBoundsException();
    }

    public int j(FieldDescriptorType fielddescriptortype) {
        if (!fielddescriptortype.f()) {
            throw new IllegalArgumentException("getRepeatedField() can only be called on repeated fields.");
        }
        Object h10 = h(fielddescriptortype);
        if (h10 == null) {
            return 0;
        }
        return ((List) h10).size();
    }

    public int k() {
        int i10 = 0;
        for (int i11 = 0; i11 < this.f11414a.i(); i11++) {
            Map.Entry<FieldDescriptorType, Object> h10 = this.f11414a.h(i11);
            i10 += f(h10.getKey(), h10.getValue());
        }
        for (Map.Entry<FieldDescriptorType, Object> entry : this.f11414a.j()) {
            i10 += f(entry.getKey(), entry.getValue());
        }
        return i10;
    }

    public boolean m(FieldDescriptorType fielddescriptortype) {
        if (fielddescriptortype.f()) {
            throw new IllegalArgumentException("hasField() can only be called on non-repeated fields.");
        }
        return this.f11414a.get(fielddescriptortype) != null;
    }

    public boolean n() {
        for (int i10 = 0; i10 < this.f11414a.i(); i10++) {
            if (!o(this.f11414a.h(i10))) {
                return false;
            }
        }
        Iterator<Map.Entry<FieldDescriptorType, Object>> it = this.f11414a.j().iterator();
        while (it.hasNext()) {
            if (!o(it.next())) {
                return false;
            }
        }
        return true;
    }

    public Iterator<Map.Entry<FieldDescriptorType, Object>> p() {
        return this.f11416c ? new l.c(this.f11414a.entrySet().iterator()) : this.f11414a.entrySet().iterator();
    }

    public void q() {
        if (this.f11415b) {
            return;
        }
        this.f11414a.n();
        this.f11415b = true;
    }

    public void r(h<FieldDescriptorType> hVar) {
        for (int i10 = 0; i10 < hVar.f11414a.i(); i10++) {
            s(hVar.f11414a.h(i10));
        }
        Iterator<Map.Entry<FieldDescriptorType, Object>> it = hVar.f11414a.j().iterator();
        while (it.hasNext()) {
            s(it.next());
        }
    }

    public void v(FieldDescriptorType fielddescriptortype, Object obj) {
        if (!fielddescriptortype.f()) {
            w(fielddescriptortype.g(), obj);
        } else {
            if (!(obj instanceof List)) {
                throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
            }
            ArrayList arrayList = new ArrayList();
            arrayList.addAll((List) obj);
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                w(fielddescriptortype.g(), it.next());
            }
            obj = arrayList;
        }
        if (obj instanceof l) {
            this.f11416c = true;
        }
        this.f11414a.p(fielddescriptortype, obj);
    }
}
