package jb;

import java.util.ArrayList;
import java.util.Map;
import java.util.Objects;
import m8.l0;
import y8.l;

/* loaded from: classes.dex */
public final class e {

    /* renamed from: i, reason: collision with root package name */
    public static final h f11067i;

    /* renamed from: j, reason: collision with root package name */
    public static final e f11068j;

    /* renamed from: a, reason: collision with root package name */
    private final h f11069a;

    /* renamed from: b, reason: collision with root package name */
    private final h f11070b;

    /* renamed from: c, reason: collision with root package name */
    private final Map<String, h> f11071c;

    /* renamed from: d, reason: collision with root package name */
    private final boolean f11072d;

    /* renamed from: e, reason: collision with root package name */
    private final h f11073e;

    /* renamed from: f, reason: collision with root package name */
    private final l8.h f11074f;

    /* renamed from: g, reason: collision with root package name */
    private final boolean f11075g;

    /* renamed from: h, reason: collision with root package name */
    private final boolean f11076h;

    /* loaded from: classes.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(y8.g gVar) {
            this();
        }
    }

    /* loaded from: classes.dex */
    static final class b extends l implements x8.a<String[]> {
        b() {
            super(0);
        }

        @Override // x8.a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final String[] b() {
            ArrayList arrayList = new ArrayList();
            arrayList.add(e.this.d().getDescription());
            h f10 = e.this.f();
            if (f10 != null) {
                arrayList.add(y8.k.j("under-migration:", f10.getDescription()));
            }
            for (Map.Entry<String, h> entry : e.this.g().entrySet()) {
                arrayList.add('@' + entry.getKey() + ':' + entry.getValue().getDescription());
            }
            Object[] array = arrayList.toArray(new String[0]);
            Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
            return (String[]) array;
        }
    }

    static {
        Map h10;
        Map h11;
        Map h12;
        new a(null);
        h hVar = h.WARN;
        f11067i = hVar;
        h10 = l0.h();
        new e(hVar, null, h10, false, null, 24, null);
        h hVar2 = h.IGNORE;
        h11 = l0.h();
        f11068j = new e(hVar2, hVar2, h11, false, null, 24, null);
        h hVar3 = h.STRICT;
        h12 = l0.h();
        new e(hVar3, hVar3, h12, false, null, 24, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public e(h hVar, h hVar2, Map<String, ? extends h> map, boolean z10, h hVar3) {
        l8.h b10;
        y8.k.e(hVar, "globalJsr305Level");
        y8.k.e(map, "userDefinedLevelForSpecificJsr305Annotation");
        y8.k.e(hVar3, "jspecifyReportLevel");
        this.f11069a = hVar;
        this.f11070b = hVar2;
        this.f11071c = map;
        this.f11072d = z10;
        this.f11073e = hVar3;
        b10 = l8.j.b(new b());
        this.f11074f = b10;
        h hVar4 = h.IGNORE;
        boolean z11 = true;
        boolean z12 = hVar == hVar4 && hVar2 == hVar4 && map.isEmpty();
        this.f11075g = z12;
        if (!z12 && hVar3 != hVar4) {
            z11 = false;
        }
        this.f11076h = z11;
    }

    public /* synthetic */ e(h hVar, h hVar2, Map map, boolean z10, h hVar3, int i10, y8.g gVar) {
        this(hVar, hVar2, map, (i10 & 8) != 0 ? true : z10, (i10 & 16) != 0 ? f11067i : hVar3);
    }

    public final boolean a() {
        return this.f11076h;
    }

    public final boolean b() {
        return this.f11075g;
    }

    public final boolean c() {
        return this.f11072d;
    }

    public final h d() {
        return this.f11069a;
    }

    public final h e() {
        return this.f11073e;
    }

    public final h f() {
        return this.f11070b;
    }

    public final Map<String, h> g() {
        return this.f11071c;
    }
}
