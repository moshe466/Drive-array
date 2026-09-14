package h9;

import h9.d;
import ja.a;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Objects;
import ka.e;
import kotlin.reflect.jvm.internal.impl.protobuf.i;
import n9.p0;

/* loaded from: classes.dex */
public abstract class e {

    /* loaded from: classes.dex */
    public static final class a extends e {

        /* renamed from: a, reason: collision with root package name */
        private final Field f10519a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(Field field) {
            super(null);
            y8.k.e(field, "field");
            this.f10519a = field;
        }

        @Override // h9.e
        public String a() {
            StringBuilder sb2 = new StringBuilder();
            String name = this.f10519a.getName();
            y8.k.d(name, "field.name");
            sb2.append(v9.x.a(name));
            sb2.append("()");
            Class<?> type = this.f10519a.getType();
            y8.k.d(type, "field.type");
            sb2.append(s9.b.c(type));
            return sb2.toString();
        }

        public final Field b() {
            return this.f10519a;
        }
    }

    /* loaded from: classes.dex */
    public static final class b extends e {

        /* renamed from: a, reason: collision with root package name */
        private final Method f10520a;

        /* renamed from: b, reason: collision with root package name */
        private final Method f10521b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(Method method, Method method2) {
            super(null);
            y8.k.e(method, "getterMethod");
            this.f10520a = method;
            this.f10521b = method2;
        }

        @Override // h9.e
        public String a() {
            String b10;
            b10 = i0.b(this.f10520a);
            return b10;
        }

        public final Method b() {
            return this.f10520a;
        }

        public final Method c() {
            return this.f10521b;
        }
    }

    /* loaded from: classes.dex */
    public static final class c extends e {

        /* renamed from: a, reason: collision with root package name */
        private final String f10522a;

        /* renamed from: b, reason: collision with root package name */
        private final p0 f10523b;

        /* renamed from: c, reason: collision with root package name */
        private final ga.n f10524c;

        /* renamed from: d, reason: collision with root package name */
        private final a.d f10525d;

        /* renamed from: e, reason: collision with root package name */
        private final ia.c f10526e;

        /* renamed from: f, reason: collision with root package name */
        private final ia.g f10527f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(p0 p0Var, ga.n nVar, a.d dVar, ia.c cVar, ia.g gVar) {
            super(null);
            String str;
            y8.k.e(p0Var, "descriptor");
            y8.k.e(nVar, "proto");
            y8.k.e(dVar, "signature");
            y8.k.e(cVar, "nameResolver");
            y8.k.e(gVar, "typeTable");
            this.f10523b = p0Var;
            this.f10524c = nVar;
            this.f10525d = dVar;
            this.f10526e = cVar;
            this.f10527f = gVar;
            if (dVar.F()) {
                StringBuilder sb2 = new StringBuilder();
                a.c A = dVar.A();
                y8.k.d(A, "signature.getter");
                sb2.append(cVar.a(A.y()));
                a.c A2 = dVar.A();
                y8.k.d(A2, "signature.getter");
                sb2.append(cVar.a(A2.x()));
                str = sb2.toString();
            } else {
                e.a d10 = ka.h.d(ka.h.f11321a, nVar, cVar, gVar, false, 8, null);
                if (d10 == null) {
                    throw new b0("No field signature for property: " + p0Var);
                }
                String d11 = d10.d();
                str = v9.x.a(d11) + c() + "()" + d10.e();
            }
            this.f10522a = str;
        }

        private final String c() {
            StringBuilder sb2;
            String k10;
            String str;
            n9.m d10 = this.f10523b.d();
            y8.k.d(d10, "descriptor.containingDeclaration");
            if (y8.k.a(this.f10523b.h(), n9.t.f12302d) && (d10 instanceof za.d)) {
                ga.c i12 = ((za.d) d10).i1();
                i.f<ga.c, Integer> fVar = ja.a.f10981i;
                y8.k.d(fVar, "JvmProtoBuf.classModuleName");
                Integer num = (Integer) ia.e.a(i12, fVar);
                if (num == null || (str = this.f10526e.a(num.intValue())) == null) {
                    str = "main";
                }
                sb2 = new StringBuilder();
                sb2.append("$");
                k10 = la.f.a(str);
            } else {
                if (!y8.k.a(this.f10523b.h(), n9.t.f12299a) || !(d10 instanceof n9.g0)) {
                    return "";
                }
                p0 p0Var = this.f10523b;
                Objects.requireNonNull(p0Var, "null cannot be cast to non-null type org.jetbrains.kotlin.serialization.deserialization.descriptors.DeserializedPropertyDescriptor");
                za.f F = ((za.j) p0Var).F();
                if (!(F instanceof ea.i)) {
                    return "";
                }
                ea.i iVar = (ea.i) F;
                if (iVar.e() == null) {
                    return "";
                }
                sb2 = new StringBuilder();
                sb2.append("$");
                k10 = iVar.g().k();
            }
            sb2.append(k10);
            return sb2.toString();
        }

        @Override // h9.e
        public String a() {
            return this.f10522a;
        }

        public final p0 b() {
            return this.f10523b;
        }

        public final ia.c d() {
            return this.f10526e;
        }

        public final ga.n e() {
            return this.f10524c;
        }

        public final a.d f() {
            return this.f10525d;
        }

        public final ia.g g() {
            return this.f10527f;
        }
    }

    /* loaded from: classes.dex */
    public static final class d extends e {

        /* renamed from: a, reason: collision with root package name */
        private final d.e f10528a;

        /* renamed from: b, reason: collision with root package name */
        private final d.e f10529b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(d.e eVar, d.e eVar2) {
            super(null);
            y8.k.e(eVar, "getterSignature");
            this.f10528a = eVar;
            this.f10529b = eVar2;
        }

        @Override // h9.e
        public String a() {
            return this.f10528a.a();
        }

        public final d.e b() {
            return this.f10528a;
        }

        public final d.e c() {
            return this.f10529b;
        }
    }

    private e() {
    }

    public /* synthetic */ e(y8.g gVar) {
        this();
    }

    public abstract String a();
}
