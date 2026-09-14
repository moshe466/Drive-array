package g9;

import e9.d;
import e9.e;
import ga.t;
import h9.k0;
import ka.f;
import ka.g;
import ka.h;
import kotlin.Metadata;
import l8.c;
import l8.n;
import n9.u0;
import x8.p;
import xa.u;
import y8.i;
import y8.k;
import y8.w;

/* loaded from: classes.dex */
public final class b {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static final /* synthetic */ class a extends i implements p<u, ga.i, u0> {

        /* renamed from: o, reason: collision with root package name */
        public static final a f9913o = new a();

        a() {
            super(2);
        }

        @Override // y8.c, e9.a
        public final String c() {
            return "loadFunction";
        }

        @Override // y8.c
        public final d k() {
            return w.b(u.class);
        }

        @Override // y8.c
        public final String m() {
            return "loadFunction(Lorg/jetbrains/kotlin/metadata/ProtoBuf$Function;)Lorg/jetbrains/kotlin/descriptors/SimpleFunctionDescriptor;";
        }

        @Override // x8.p
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final u0 g(u uVar, ga.i iVar) {
            k.e(uVar, "p1");
            k.e(iVar, "p2");
            return uVar.n(iVar);
        }
    }

    public static final <R> e<R> a(c<? extends R> cVar) {
        k.e(cVar, "$this$reflect");
        Metadata metadata = (Metadata) cVar.getClass().getAnnotation(Metadata.class);
        if (metadata != null) {
            String[] d12 = metadata.d1();
            if (d12.length == 0) {
                d12 = null;
            }
            if (d12 != null) {
                n<g, ga.i> j10 = h.j(d12, metadata.d2());
                g a10 = j10.a();
                ga.i b10 = j10.b();
                f fVar = new f(metadata.mv(), (metadata.xi() & 8) != 0);
                Class<?> cls = cVar.getClass();
                t g02 = b10.g0();
                k.d(g02, "proto.typeTable");
                u0 u0Var = (u0) k0.e(cls, b10, a10, new ia.g(g02), fVar, a.f9913o);
                if (u0Var != null) {
                    return new h9.k(h9.b.f10502i, u0Var);
                }
            }
        }
        return null;
    }
}
