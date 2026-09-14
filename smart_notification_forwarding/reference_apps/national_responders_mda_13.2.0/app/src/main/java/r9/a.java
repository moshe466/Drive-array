package r9;

import ea.o;
import fa.a;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import m8.p;
import m8.y;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    private final ea.e f13802a;

    /* renamed from: b, reason: collision with root package name */
    private final g f13803b;

    /* renamed from: c, reason: collision with root package name */
    private final ConcurrentHashMap<la.a, ua.h> f13804c;

    public a(ea.e eVar, g gVar) {
        y8.k.e(eVar, "resolver");
        y8.k.e(gVar, "kotlinClassFinder");
        this.f13802a = eVar;
        this.f13803b = gVar;
        this.f13804c = new ConcurrentHashMap<>();
    }

    public final ua.h a(f fVar) {
        Collection b10;
        List n02;
        y8.k.e(fVar, "fileClass");
        ConcurrentHashMap<la.a, ua.h> concurrentHashMap = this.f13804c;
        la.a d10 = fVar.d();
        ua.h hVar = concurrentHashMap.get(d10);
        if (hVar == null) {
            la.b h10 = fVar.d().h();
            y8.k.d(h10, "fileClass.classId.packageFqName");
            if (fVar.a().c() == a.EnumC0166a.MULTIFILE_CLASS) {
                List<String> f10 = fVar.a().f();
                b10 = new ArrayList();
                Iterator<T> it = f10.iterator();
                while (it.hasNext()) {
                    la.a m10 = la.a.m(sa.c.d((String) it.next()).e());
                    y8.k.d(m10, "topLevel(JvmClassName.byInternalName(partName).fqNameForTopLevelClassMaybeWithDollars)");
                    o b11 = ea.n.b(this.f13803b, m10);
                    if (b11 != null) {
                        b10.add(b11);
                    }
                }
            } else {
                b10 = p.b(fVar);
            }
            p9.m mVar = new p9.m(this.f13802a.f().p(), h10);
            ArrayList arrayList = new ArrayList();
            Iterator it2 = b10.iterator();
            while (it2.hasNext()) {
                ua.h d11 = this.f13802a.d(mVar, (o) it2.next());
                if (d11 != null) {
                    arrayList.add(d11);
                }
            }
            n02 = y.n0(arrayList);
            ua.h a10 = ua.b.f14499d.a("package " + h10 + " (" + fVar + ')', n02);
            ua.h putIfAbsent = concurrentHashMap.putIfAbsent(d10, a10);
            hVar = putIfAbsent != null ? putIfAbsent : a10;
        }
        y8.k.d(hVar, "cache.getOrPut(fileClass.classId) {\n        val fqName = fileClass.classId.packageFqName\n\n        val parts =\n            if (fileClass.classHeader.kind == KotlinClassHeader.Kind.MULTIFILE_CLASS)\n                fileClass.classHeader.multifilePartNames.mapNotNull { partName ->\n                    val classId = ClassId.topLevel(JvmClassName.byInternalName(partName).fqNameForTopLevelClassMaybeWithDollars)\n                    kotlinClassFinder.findKotlinClass(classId)\n                }\n            else listOf(fileClass)\n\n        val packageFragment = EmptyPackageFragmentDescriptor(resolver.components.moduleDescriptor, fqName)\n\n        val scopes = parts.mapNotNull { part ->\n            resolver.createKotlinPackagePartScope(packageFragment, part)\n        }.toList()\n\n        ChainedMemberScope.create(\"package $fqName ($fileClass)\", scopes)\n    }");
        return hVar;
    }
}
