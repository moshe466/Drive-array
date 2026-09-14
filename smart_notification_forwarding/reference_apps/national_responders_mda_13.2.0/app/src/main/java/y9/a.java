package y9;

import ca.z;
import java.util.ArrayList;
import java.util.EnumMap;
import java.util.Iterator;
import java.util.List;
import n9.m;
import v9.c;
import v9.s;
import v9.w;
import y8.l;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: y9.a$a */
    /* loaded from: classes.dex */
    public static final class C0338a extends l implements x8.a<w> {

        /* renamed from: f */
        final /* synthetic */ g f15954f;

        /* renamed from: g */
        final /* synthetic */ n9.g f15955g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C0338a(g gVar, n9.g gVar2) {
            super(0);
            this.f15954f = gVar;
            this.f15955g = gVar2;
        }

        @Override // x8.a
        /* renamed from: a */
        public final w b() {
            return a.g(this.f15954f, this.f15955g.u());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static final class b extends l implements x8.a<w> {

        /* renamed from: f */
        final /* synthetic */ g f15956f;

        /* renamed from: g */
        final /* synthetic */ kotlin.reflect.jvm.internal.impl.descriptors.annotations.g f15957g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(g gVar, kotlin.reflect.jvm.internal.impl.descriptors.annotations.g gVar2) {
            super(0);
            this.f15956f = gVar;
            this.f15957g = gVar2;
        }

        @Override // x8.a
        /* renamed from: a */
        public final w b() {
            return a.g(this.f15956f, this.f15957g);
        }
    }

    private static final g a(g gVar, m mVar, z zVar, int i10, l8.h<w> hVar) {
        y9.b a10 = gVar.a();
        k hVar2 = zVar == null ? null : new h(gVar, mVar, zVar, i10);
        if (hVar2 == null) {
            hVar2 = gVar.f();
        }
        return new g(a10, hVar2, hVar);
    }

    public static final g b(g gVar, k kVar) {
        y8.k.e(gVar, "<this>");
        y8.k.e(kVar, "typeParameterResolver");
        return new g(gVar.a(), kVar, gVar.c());
    }

    public static final g c(g gVar, n9.g gVar2, z zVar, int i10) {
        l8.h a10;
        y8.k.e(gVar, "<this>");
        y8.k.e(gVar2, "containingDeclaration");
        a10 = l8.j.a(kotlin.b.NONE, new C0338a(gVar, gVar2));
        return a(gVar, gVar2, zVar, i10, a10);
    }

    public static /* synthetic */ g d(g gVar, n9.g gVar2, z zVar, int i10, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            zVar = null;
        }
        if ((i11 & 4) != 0) {
            i10 = 0;
        }
        return c(gVar, gVar2, zVar, i10);
    }

    public static final g e(g gVar, m mVar, z zVar, int i10) {
        y8.k.e(gVar, "<this>");
        y8.k.e(mVar, "containingDeclaration");
        y8.k.e(zVar, "typeParameterOwner");
        return a(gVar, mVar, zVar, i10, gVar.c());
    }

    public static /* synthetic */ g f(g gVar, m mVar, z zVar, int i10, int i11, Object obj) {
        if ((i11 & 4) != 0) {
            i10 = 0;
        }
        return e(gVar, mVar, zVar, i10);
    }

    public static final w g(g gVar, kotlin.reflect.jvm.internal.impl.descriptors.annotations.g gVar2) {
        EnumMap<v9.a, s> b10;
        y8.k.e(gVar, "<this>");
        y8.k.e(gVar2, "additionalAnnotations");
        if (gVar.a().h().a()) {
            return gVar.b();
        }
        ArrayList<s> arrayList = new ArrayList();
        Iterator<kotlin.reflect.jvm.internal.impl.descriptors.annotations.c> it = gVar2.iterator();
        while (it.hasNext()) {
            s i10 = i(gVar, it.next());
            if (i10 != null) {
                arrayList.add(i10);
            }
        }
        if (arrayList.isEmpty()) {
            return gVar.b();
        }
        w b11 = gVar.b();
        EnumMap enumMap = null;
        if (b11 != null && (b10 = b11.b()) != null) {
            enumMap = new EnumMap((EnumMap) b10);
        }
        if (enumMap == null) {
            enumMap = new EnumMap(v9.a.class);
        }
        boolean z10 = false;
        for (s sVar : arrayList) {
            Iterator<v9.a> it2 = sVar.f().iterator();
            while (it2.hasNext()) {
                enumMap.put((EnumMap) it2.next(), (v9.a) sVar);
                z10 = true;
            }
        }
        return !z10 ? gVar.b() : new w(enumMap);
    }

    public static final g h(g gVar, kotlin.reflect.jvm.internal.impl.descriptors.annotations.g gVar2) {
        l8.h a10;
        y8.k.e(gVar, "<this>");
        y8.k.e(gVar2, "additionalAnnotations");
        if (gVar2.isEmpty()) {
            return gVar;
        }
        y9.b a11 = gVar.a();
        k f10 = gVar.f();
        a10 = l8.j.a(kotlin.b.NONE, new b(gVar, gVar2));
        return new g(a11, f10, a10);
    }

    private static final s i(g gVar, kotlin.reflect.jvm.internal.impl.descriptors.annotations.c cVar) {
        v9.c a10 = gVar.a().a();
        s l10 = a10.l(cVar);
        if (l10 != null) {
            return l10;
        }
        c.a n10 = a10.n(cVar);
        if (n10 == null) {
            return null;
        }
        kotlin.reflect.jvm.internal.impl.descriptors.annotations.c a11 = n10.a();
        List<v9.a> b10 = n10.b();
        jb.h k10 = a10.k(cVar);
        if (k10 == null) {
            k10 = a10.j(a11);
        }
        if (k10.isIgnore()) {
            return null;
        }
        da.i h10 = gVar.a().q().h(a11, gVar.a().p().b(), false);
        da.i b11 = h10 == null ? null : da.i.b(h10, null, k10.isWarning(), 1, null);
        if (b11 == null) {
            return null;
        }
        return new s(b11, b10, false, 4, null);
    }

    public static final g j(g gVar, y9.b bVar) {
        y8.k.e(gVar, "<this>");
        y8.k.e(bVar, "components");
        return new g(bVar, gVar.f(), gVar.c());
    }
}
