package gb;

import gb.c;
import java.util.Collection;
import kotlin.reflect.jvm.internal.impl.util.Check;
import n9.x;

/* loaded from: classes.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    private final la.e f10344a;

    /* renamed from: b, reason: collision with root package name */
    private final mb.f f10345b;

    /* renamed from: c, reason: collision with root package name */
    private final Collection<la.e> f10346c;

    /* renamed from: d, reason: collision with root package name */
    private final x8.l<x, String> f10347d;

    /* renamed from: e, reason: collision with root package name */
    private final gb.b[] f10348e;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static final class a extends y8.l implements x8.l {

        /* renamed from: f, reason: collision with root package name */
        public static final a f10349f = new a();

        a() {
            super(1);
        }

        @Override // x8.l
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Void h(x xVar) {
            y8.k.e(xVar, "<this>");
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static final class b extends y8.l implements x8.l {

        /* renamed from: f, reason: collision with root package name */
        public static final b f10350f = new b();

        b() {
            super(1);
        }

        @Override // x8.l
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Void h(x xVar) {
            y8.k.e(xVar, "<this>");
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static final class c extends y8.l implements x8.l {

        /* renamed from: f, reason: collision with root package name */
        public static final c f10351f = new c();

        c() {
            super(1);
        }

        @Override // x8.l
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Void h(x xVar) {
            y8.k.e(xVar, "<this>");
            return null;
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public d(java.util.Collection<la.e> r8, kotlin.reflect.jvm.internal.impl.util.Check[] r9, x8.l<? super n9.x, java.lang.String> r10) {
        /*
            r7 = this;
            java.lang.String r0 = "nameList"
            y8.k.e(r8, r0)
            java.lang.String r0 = "checks"
            y8.k.e(r9, r0)
            java.lang.String r0 = "additionalChecks"
            y8.k.e(r10, r0)
            int r0 = r9.length
            gb.b[] r6 = new gb.b[r0]
            int r0 = r9.length
            r1 = 0
            java.lang.System.arraycopy(r9, r1, r6, r1, r0)
            r2 = 0
            r3 = 0
            r1 = r7
            r4 = r8
            r5 = r10
            r1.<init>(r2, r3, r4, r5, r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: gb.d.<init>(java.util.Collection, gb.b[], x8.l):void");
    }

    public /* synthetic */ d(Collection collection, gb.b[] bVarArr, x8.l lVar, int i10, y8.g gVar) {
        this((Collection<la.e>) collection, (Check[]) bVarArr, (x8.l<? super x, String>) ((i10 & 4) != 0 ? c.f10351f : lVar));
    }

    /* JADX WARN: Multi-variable type inference failed */
    private d(la.e eVar, mb.f fVar, Collection<la.e> collection, x8.l<? super x, String> lVar, Check... checkArr) {
        this.f10344a = eVar;
        this.f10345b = fVar;
        this.f10346c = collection;
        this.f10347d = lVar;
        this.f10348e = checkArr;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public d(la.e r8, kotlin.reflect.jvm.internal.impl.util.Check[] r9, x8.l<? super n9.x, java.lang.String> r10) {
        /*
            r7 = this;
            java.lang.String r0 = "name"
            y8.k.e(r8, r0)
            java.lang.String r0 = "checks"
            y8.k.e(r9, r0)
            java.lang.String r0 = "additionalChecks"
            y8.k.e(r10, r0)
            int r0 = r9.length
            gb.b[] r6 = new gb.b[r0]
            int r0 = r9.length
            r1 = 0
            java.lang.System.arraycopy(r9, r1, r6, r1, r0)
            r3 = 0
            r4 = 0
            r1 = r7
            r2 = r8
            r5 = r10
            r1.<init>(r2, r3, r4, r5, r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: gb.d.<init>(la.e, gb.b[], x8.l):void");
    }

    public /* synthetic */ d(la.e eVar, gb.b[] bVarArr, x8.l lVar, int i10, y8.g gVar) {
        this(eVar, (Check[]) bVarArr, (x8.l<? super x, String>) ((i10 & 4) != 0 ? a.f10349f : lVar));
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public d(mb.f r8, kotlin.reflect.jvm.internal.impl.util.Check[] r9, x8.l<? super n9.x, java.lang.String> r10) {
        /*
            r7 = this;
            java.lang.String r0 = "regex"
            y8.k.e(r8, r0)
            java.lang.String r0 = "checks"
            y8.k.e(r9, r0)
            java.lang.String r0 = "additionalChecks"
            y8.k.e(r10, r0)
            int r0 = r9.length
            gb.b[] r6 = new gb.b[r0]
            int r0 = r9.length
            r1 = 0
            java.lang.System.arraycopy(r9, r1, r6, r1, r0)
            r2 = 0
            r4 = 0
            r1 = r7
            r3 = r8
            r5 = r10
            r1.<init>(r2, r3, r4, r5, r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: gb.d.<init>(mb.f, gb.b[], x8.l):void");
    }

    public /* synthetic */ d(mb.f fVar, gb.b[] bVarArr, x8.l lVar, int i10, y8.g gVar) {
        this(fVar, (Check[]) bVarArr, (x8.l<? super x, String>) ((i10 & 4) != 0 ? b.f10350f : lVar));
    }

    public final gb.c a(x xVar) {
        y8.k.e(xVar, "functionDescriptor");
        gb.b[] bVarArr = this.f10348e;
        int length = bVarArr.length;
        int i10 = 0;
        while (i10 < length) {
            gb.b bVar = bVarArr[i10];
            i10++;
            String c10 = bVar.c(xVar);
            if (c10 != null) {
                return new c.b(c10);
            }
        }
        String h10 = this.f10347d.h(xVar);
        return h10 != null ? new c.b(h10) : c.C0183c.f10343b;
    }

    public final boolean b(x xVar) {
        y8.k.e(xVar, "functionDescriptor");
        if (this.f10344a != null && !y8.k.a(xVar.c(), this.f10344a)) {
            return false;
        }
        if (this.f10345b != null) {
            String k10 = xVar.c().k();
            y8.k.d(k10, "functionDescriptor.name.asString()");
            if (!this.f10345b.b(k10)) {
                return false;
            }
        }
        Collection<la.e> collection = this.f10346c;
        return collection == null || collection.contains(xVar.c());
    }
}
