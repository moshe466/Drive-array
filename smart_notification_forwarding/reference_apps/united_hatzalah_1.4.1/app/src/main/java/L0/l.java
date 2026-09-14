package L0;

import F0.C0047j2;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class l {

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList f1262a = new ArrayList();

    /* renamed from: b, reason: collision with root package name */
    public final ArrayList f1263b = new ArrayList();

    /* renamed from: c, reason: collision with root package name */
    public final ArrayList f1264c = new ArrayList();

    /* renamed from: d, reason: collision with root package name */
    public final ArrayList f1265d = new ArrayList();

    /* renamed from: e, reason: collision with root package name */
    public final ArrayList f1266e = new ArrayList();

    /* renamed from: f, reason: collision with root package name */
    public final ArrayList f1267f = new ArrayList();

    /* renamed from: g, reason: collision with root package name */
    public final ArrayList f1268g = new ArrayList();

    /* renamed from: h, reason: collision with root package name */
    public final ArrayList f1269h = new ArrayList();
    public final ArrayList i = new ArrayList();

    /* renamed from: j, reason: collision with root package name */
    public C0047j2 f1270j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f1271k;

    /* renamed from: l, reason: collision with root package name */
    public boolean f1272l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f1273m;

    /* renamed from: n, reason: collision with root package name */
    public boolean f1274n;

    /* renamed from: o, reason: collision with root package name */
    public boolean f1275o;
    public n p;

    public static void a(l lVar, N0.n nVar) {
        if (nVar != null) {
            ArrayList arrayList = nVar.f1479g;
            if (nVar.a()) {
                lVar.f1262a.addAll(nVar.i);
            }
            if (nVar.b()) {
                lVar.f1263b.addAll(nVar.f1480h);
            }
            int i = nVar.f1430a;
            int i3 = 0;
            if (i != 0) {
                if (i != 31) {
                    if (i != 2) {
                        if (i != 3) {
                            if (i == 4) {
                                lVar.f1275o = nVar.f1431b;
                                int size = arrayList.size();
                                while (i3 < size) {
                                    Object obj = arrayList.get(i3);
                                    i3++;
                                    lVar.i.add(new k((N0.m) obj));
                                }
                                return;
                            }
                            throw new IllegalArgumentException("Unknown Signing Block Scheme Id");
                        }
                        lVar.f1273m = nVar.f1431b;
                        int size2 = arrayList.size();
                        while (i3 < size2) {
                            Object obj2 = arrayList.get(i3);
                            i3++;
                            lVar.f1268g.add(new j((N0.m) obj2));
                        }
                        if (lVar.p == null) {
                            lVar.p = nVar.f1478f;
                            return;
                        }
                        return;
                    }
                    lVar.f1272l = nVar.f1431b;
                    int size3 = arrayList.size();
                    while (i3 < size3) {
                        Object obj3 = arrayList.get(i3);
                        i3++;
                        lVar.f1267f.add(new h((N0.m) obj3));
                    }
                    return;
                }
                lVar.f1274n = nVar.f1431b;
                int size4 = arrayList.size();
                while (i3 < size4) {
                    Object obj4 = arrayList.get(i3);
                    i3++;
                    lVar.f1269h.add(new j((N0.m) obj4));
                }
                lVar.p = nVar.f1478f;
                return;
            }
            if (!arrayList.isEmpty()) {
                lVar.f1270j = new C0047j2((N0.e) arrayList.get(0));
            }
        }
    }

    public static void b(l lVar, N0.c cVar) {
        int i = cVar.f1430a;
        ArrayList arrayList = (ArrayList) cVar.f1432c;
        if (i == 0) {
            if (!arrayList.isEmpty()) {
                lVar.f1270j = new C0047j2((N0.e) arrayList.get(0));
            }
        } else {
            throw new IllegalArgumentException("Unknown ApkSigResult Signing Block Scheme Id " + i);
        }
    }

    public final void c(e eVar, Object... objArr) {
        this.f1262a.add(new f(eVar, objArr));
    }

    public final boolean d() {
        if (this.f1262a.isEmpty()) {
            ArrayList arrayList = this.f1265d;
            if (!arrayList.isEmpty()) {
                int size = arrayList.size();
                int i = 0;
                while (i < size) {
                    Object obj = arrayList.get(i);
                    i++;
                    if (!((g) obj).f1251c.isEmpty()) {
                        return true;
                    }
                }
            }
            ArrayList arrayList2 = this.f1267f;
            if (!arrayList2.isEmpty()) {
                int size2 = arrayList2.size();
                int i3 = 0;
                while (i3 < size2) {
                    Object obj2 = arrayList2.get(i3);
                    i3++;
                    if (!((h) obj2).f1254c.isEmpty()) {
                        return true;
                    }
                }
            }
            ArrayList arrayList3 = this.f1268g;
            if (!arrayList3.isEmpty()) {
                int size3 = arrayList3.size();
                int i4 = 0;
                while (i4 < size3) {
                    Object obj3 = arrayList3.get(i4);
                    i4++;
                    if (!((j) obj3).f1258b.isEmpty()) {
                        return true;
                    }
                }
            }
            ArrayList arrayList4 = this.f1269h;
            if (!arrayList4.isEmpty()) {
                int size4 = arrayList4.size();
                int i5 = 0;
                while (i5 < size4) {
                    Object obj4 = arrayList4.get(i5);
                    i5++;
                    if (!((j) obj4).f1258b.isEmpty()) {
                        return true;
                    }
                }
            }
            C0047j2 c0047j2 = this.f1270j;
            if (c0047j2 == null || ((ArrayList) c0047j2.f546b).isEmpty()) {
                return false;
            }
            return true;
        }
        return true;
    }

    public final ArrayList e() {
        return this.f1265d;
    }

    public final ArrayList f() {
        return this.f1267f;
    }

    public final ArrayList g() {
        return this.f1269h;
    }

    public final ArrayList h() {
        return this.f1268g;
    }

    public final boolean i() {
        return this.f1271k;
    }

    public final boolean j() {
        return this.f1272l;
    }

    public final boolean k() {
        return this.f1274n;
    }

    public final boolean l() {
        return this.f1273m;
    }
}
