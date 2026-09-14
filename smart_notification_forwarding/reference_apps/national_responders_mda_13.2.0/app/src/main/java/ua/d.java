package ua;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import m8.q;
import m8.y;

/* loaded from: classes.dex */
public final class d {

    /* renamed from: c, reason: collision with root package name */
    public static final a f14505c;

    /* renamed from: d, reason: collision with root package name */
    private static int f14506d;

    /* renamed from: e, reason: collision with root package name */
    private static final int f14507e;

    /* renamed from: f, reason: collision with root package name */
    private static final int f14508f;

    /* renamed from: g, reason: collision with root package name */
    private static final int f14509g;

    /* renamed from: h, reason: collision with root package name */
    private static final int f14510h;

    /* renamed from: i, reason: collision with root package name */
    private static final int f14511i;

    /* renamed from: j, reason: collision with root package name */
    private static final int f14512j;

    /* renamed from: k, reason: collision with root package name */
    private static final int f14513k;

    /* renamed from: l, reason: collision with root package name */
    private static final int f14514l;

    /* renamed from: m, reason: collision with root package name */
    private static final int f14515m;

    /* renamed from: n, reason: collision with root package name */
    private static final int f14516n;

    /* renamed from: o, reason: collision with root package name */
    public static final d f14517o;

    /* renamed from: p, reason: collision with root package name */
    public static final d f14518p;

    /* renamed from: q, reason: collision with root package name */
    public static final d f14519q;

    /* renamed from: r, reason: collision with root package name */
    public static final d f14520r;

    /* renamed from: s, reason: collision with root package name */
    public static final d f14521s;

    /* renamed from: t, reason: collision with root package name */
    private static final List<a.C0298a> f14522t;

    /* renamed from: u, reason: collision with root package name */
    private static final List<a.C0298a> f14523u;

    /* renamed from: a, reason: collision with root package name */
    private final List<c> f14524a;

    /* renamed from: b, reason: collision with root package name */
    private final int f14525b;

    /* loaded from: classes.dex */
    public static final class a {

        /* renamed from: ua.d$a$a, reason: collision with other inner class name */
        /* loaded from: classes.dex */
        private static final class C0298a {

            /* renamed from: a, reason: collision with root package name */
            private final int f14526a;

            /* renamed from: b, reason: collision with root package name */
            private final String f14527b;

            public C0298a(int i10, String str) {
                y8.k.e(str, "name");
                this.f14526a = i10;
                this.f14527b = str;
            }

            public final int a() {
                return this.f14526a;
            }

            public final String b() {
                return this.f14527b;
            }
        }

        private a() {
        }

        public /* synthetic */ a(y8.g gVar) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final int l() {
            int i10 = d.f14506d;
            d.f14506d <<= 1;
            return i10;
        }

        public final int b() {
            return d.f14513k;
        }

        public final int c() {
            return d.f14516n;
        }

        public final int d() {
            return d.f14514l;
        }

        public final int e() {
            return d.f14511i;
        }

        public final int f() {
            return d.f14507e;
        }

        public final int g() {
            return d.f14510h;
        }

        public final int h() {
            return d.f14508f;
        }

        public final int i() {
            return d.f14509g;
        }

        public final int j() {
            return d.f14515m;
        }

        public final int k() {
            return d.f14512j;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    static {
        a.C0298a c0298a;
        a.C0298a c0298a2;
        a aVar = new a(null);
        f14505c = aVar;
        f14506d = 1;
        f14507e = aVar.l();
        f14508f = aVar.l();
        f14509g = aVar.l();
        f14510h = aVar.l();
        f14511i = aVar.l();
        f14512j = aVar.l();
        f14513k = aVar.l() - 1;
        f14514l = aVar.f() | aVar.h() | aVar.i();
        f14515m = aVar.h() | aVar.e() | aVar.k();
        f14516n = aVar.e() | aVar.k();
        int i10 = 2;
        f14517o = new d(aVar.b(), 0 == true ? 1 : 0, i10, 0 == true ? 1 : 0);
        f14518p = new d(aVar.c(), 0 == true ? 1 : 0, i10, 0 == true ? 1 : 0);
        new d(aVar.f(), 0 == true ? 1 : 0, i10, 0 == true ? 1 : 0);
        new d(aVar.h(), 0 == true ? 1 : 0, i10, 0 == true ? 1 : 0);
        new d(aVar.i(), 0 == true ? 1 : 0, i10, 0 == true ? 1 : 0);
        f14519q = new d(aVar.d(), 0 == true ? 1 : 0, i10, 0 == true ? 1 : 0);
        new d(aVar.g(), 0 == true ? 1 : 0, i10, 0 == true ? 1 : 0);
        f14520r = new d(aVar.e(), 0 == true ? 1 : 0, i10, 0 == true ? 1 : 0);
        f14521s = new d(aVar.k(), 0 == true ? 1 : 0, i10, 0 == true ? 1 : 0);
        new d(aVar.j(), 0 == true ? 1 : 0, i10, 0 == true ? 1 : 0);
        Field[] fields = d.class.getFields();
        y8.k.d(fields, "T::class.java.fields");
        ArrayList<Field> arrayList = new ArrayList();
        for (Field field : fields) {
            if (Modifier.isStatic(field.getModifiers())) {
                arrayList.add(field);
            }
        }
        ArrayList arrayList2 = new ArrayList();
        for (Field field2 : arrayList) {
            Object obj = field2.get(null);
            d dVar = obj instanceof d ? (d) obj : null;
            if (dVar != null) {
                int o10 = dVar.o();
                String name = field2.getName();
                y8.k.d(name, "field.name");
                c0298a2 = new a.C0298a(o10, name);
            } else {
                c0298a2 = null;
            }
            if (c0298a2 != null) {
                arrayList2.add(c0298a2);
            }
        }
        f14522t = arrayList2;
        Field[] fields2 = d.class.getFields();
        y8.k.d(fields2, "T::class.java.fields");
        ArrayList arrayList3 = new ArrayList();
        for (Field field3 : fields2) {
            if (Modifier.isStatic(field3.getModifiers())) {
                arrayList3.add(field3);
            }
        }
        ArrayList<Field> arrayList4 = new ArrayList();
        for (Object obj2 : arrayList3) {
            if (y8.k.a(((Field) obj2).getType(), Integer.TYPE)) {
                arrayList4.add(obj2);
            }
        }
        ArrayList arrayList5 = new ArrayList();
        for (Field field4 : arrayList4) {
            Object obj3 = field4.get(null);
            Objects.requireNonNull(obj3, "null cannot be cast to non-null type kotlin.Int");
            int intValue = ((Integer) obj3).intValue();
            if (intValue == ((-intValue) & intValue)) {
                String name2 = field4.getName();
                y8.k.d(name2, "field.name");
                c0298a = new a.C0298a(intValue, name2);
            } else {
                c0298a = null;
            }
            if (c0298a != null) {
                arrayList5.add(c0298a);
            }
        }
        f14523u = arrayList5;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public d(int i10, List<? extends c> list) {
        y8.k.e(list, "excludes");
        this.f14524a = list;
        Iterator it = list.iterator();
        while (it.hasNext()) {
            i10 &= ~((c) it.next()).a();
        }
        this.f14525b = i10;
    }

    public /* synthetic */ d(int i10, List list, int i11, y8.g gVar) {
        this(i10, (i11 & 2) != 0 ? q.d() : list);
    }

    public final boolean a(int i10) {
        return (i10 & this.f14525b) != 0;
    }

    public final List<c> n() {
        return this.f14524a;
    }

    public final int o() {
        return this.f14525b;
    }

    public final d p(int i10) {
        int i11 = i10 & this.f14525b;
        if (i11 == 0) {
            return null;
        }
        return new d(i11, this.f14524a);
    }

    public String toString() {
        Object obj;
        Iterator<T> it = f14522t.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (((a.C0298a) obj).a() == o()) {
                break;
            }
        }
        a.C0298a c0298a = (a.C0298a) obj;
        String b10 = c0298a == null ? null : c0298a.b();
        if (b10 == null) {
            List<a.C0298a> list = f14523u;
            ArrayList arrayList = new ArrayList();
            for (a.C0298a c0298a2 : list) {
                String b11 = a(c0298a2.a()) ? c0298a2.b() : null;
                if (b11 != null) {
                    arrayList.add(b11);
                }
            }
            b10 = y.Q(arrayList, " | ", null, null, 0, null, null, 62, null);
        }
        return "DescriptorKindFilter(" + b10 + ", " + this.f14524a + ')';
    }
}
