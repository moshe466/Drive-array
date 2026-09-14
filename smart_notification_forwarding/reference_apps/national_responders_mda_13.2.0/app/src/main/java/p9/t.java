package p9;

import bb.y0;

/* loaded from: classes.dex */
public abstract class t implements n9.e {

    /* renamed from: f, reason: collision with root package name */
    public static final a f13302f = new a(null);

    /* loaded from: classes.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(y8.g gVar) {
            this();
        }

        public final ua.h a(n9.e eVar, y0 y0Var, kotlin.reflect.jvm.internal.impl.types.checker.g gVar) {
            y8.k.e(eVar, "<this>");
            y8.k.e(y0Var, "typeSubstitution");
            y8.k.e(gVar, "kotlinTypeRefiner");
            t tVar = eVar instanceof t ? (t) eVar : null;
            if (tVar != null) {
                return tVar.e0(y0Var, gVar);
            }
            ua.h J = eVar.J(y0Var);
            y8.k.d(J, "this.getMemberScope(\n                typeSubstitution\n            )");
            return J;
        }

        public final ua.h b(n9.e eVar, kotlin.reflect.jvm.internal.impl.types.checker.g gVar) {
            y8.k.e(eVar, "<this>");
            y8.k.e(gVar, "kotlinTypeRefiner");
            t tVar = eVar instanceof t ? (t) eVar : null;
            if (tVar != null) {
                return tVar.v0(gVar);
            }
            ua.h E0 = eVar.E0();
            y8.k.d(E0, "this.unsubstitutedMemberScope");
            return E0;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract ua.h e0(y0 y0Var, kotlin.reflect.jvm.internal.impl.types.checker.g gVar);

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract ua.h v0(kotlin.reflect.jvm.internal.impl.types.checker.g gVar);
}
