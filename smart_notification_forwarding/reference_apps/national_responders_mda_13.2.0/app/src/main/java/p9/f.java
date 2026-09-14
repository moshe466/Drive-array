package p9;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import n9.a1;
import n9.b;
import n9.d1;
import n9.s0;
import n9.v0;

/* loaded from: classes.dex */
public class f extends p implements n9.d {
    private static final la.e J = la.e.u("<init>");
    protected final boolean I;

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(n9.e eVar, n9.l lVar, kotlin.reflect.jvm.internal.impl.descriptors.annotations.g gVar, boolean z10, b.a aVar, v0 v0Var) {
        super(eVar, lVar, gVar, J, aVar, v0Var);
        if (eVar == null) {
            e0(0);
        }
        if (gVar == null) {
            e0(1);
        }
        if (aVar == null) {
            e0(2);
        }
        if (v0Var == null) {
            e0(3);
        }
        this.I = z10;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0018  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0023  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x005a  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0091  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00a5 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00aa  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0076  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0028  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x002d  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x003a  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x003f  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0044  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0053  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static /* synthetic */ void e0(int r8) {
        /*
            Method dump skipped, instructions count: 324
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: p9.f.e0(int):void");
    }

    public static f x1(n9.e eVar, kotlin.reflect.jvm.internal.impl.descriptors.annotations.g gVar, boolean z10, v0 v0Var) {
        if (eVar == null) {
            e0(4);
        }
        if (gVar == null) {
            e0(5);
        }
        if (v0Var == null) {
            e0(6);
        }
        return new f(eVar, null, gVar, z10, b.a.DECLARATION, v0Var);
    }

    public f A1(List<d1> list, n9.u uVar) {
        if (list == null) {
            e0(13);
        }
        if (uVar == null) {
            e0(14);
        }
        B1(list, uVar, d().B());
        return this;
    }

    public f B1(List<d1> list, n9.u uVar, List<a1> list2) {
        if (list == null) {
            e0(10);
        }
        if (uVar == null) {
            e0(11);
        }
        if (list2 == null) {
            e0(12);
        }
        super.c1(null, v1(), list2, list, null, n9.a0.FINAL, uVar);
        return this;
    }

    @Override // p9.p, n9.m
    public <R, D> R J0(n9.o<R, D> oVar, D d10) {
        return oVar.m(this, d10);
    }

    @Override // n9.l
    public boolean S() {
        return this.I;
    }

    @Override // n9.l
    public n9.e T() {
        n9.e d10 = d();
        if (d10 == null) {
            e0(16);
        }
        return d10;
    }

    @Override // p9.p, p9.k, p9.j, n9.m
    public n9.d a() {
        n9.d dVar = (n9.d) super.a();
        if (dVar == null) {
            e0(17);
        }
        return dVar;
    }

    @Override // p9.p, n9.x, n9.x0
    public n9.d e(bb.a1 a1Var) {
        if (a1Var == null) {
            e0(18);
        }
        return (n9.d) super.e(a1Var);
    }

    @Override // p9.p, n9.x, n9.b, n9.a
    public Collection<? extends n9.x> g() {
        Set emptySet = Collections.emptySet();
        if (emptySet == null) {
            e0(19);
        }
        return emptySet;
    }

    @Override // p9.p, n9.b
    public void r0(Collection<? extends n9.b> collection) {
        if (collection == null) {
            e0(20);
        }
    }

    public s0 v1() {
        n9.e d10 = d();
        if (!d10.m0()) {
            return null;
        }
        n9.m d11 = d10.d();
        if (d11 instanceof n9.e) {
            return ((n9.e) d11).T0();
        }
        return null;
    }

    @Override // p9.p
    /* renamed from: w1, reason: merged with bridge method [inline-methods] */
    public n9.d V0(n9.m mVar, n9.a0 a0Var, n9.u uVar, b.a aVar, boolean z10) {
        n9.d dVar = (n9.d) super.V0(mVar, a0Var, uVar, aVar, z10);
        if (dVar == null) {
            e0(25);
        }
        return dVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // p9.p
    /* renamed from: y1, reason: merged with bridge method [inline-methods] */
    public f W0(n9.m mVar, n9.x xVar, b.a aVar, la.e eVar, kotlin.reflect.jvm.internal.impl.descriptors.annotations.g gVar, v0 v0Var) {
        if (mVar == null) {
            e0(21);
        }
        if (aVar == null) {
            e0(22);
        }
        if (gVar == null) {
            e0(23);
        }
        if (v0Var == null) {
            e0(24);
        }
        b.a aVar2 = b.a.DECLARATION;
        if (aVar == aVar2 || aVar == b.a.SYNTHESIZED) {
            return new f((n9.e) mVar, this, gVar, this.I, aVar2, v0Var);
        }
        throw new IllegalStateException("Attempt at creating a constructor that is not a declaration: \ncopy from: " + this + "\nnewOwner: " + mVar + "\nkind: " + aVar);
    }

    @Override // p9.k, n9.m
    /* renamed from: z1, reason: merged with bridge method [inline-methods] */
    public n9.e d() {
        n9.e eVar = (n9.e) super.d();
        if (eVar == null) {
            e0(15);
        }
        return eVar;
    }
}
