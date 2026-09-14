package rb;

import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class a {

    /* renamed from: b, reason: collision with root package name */
    public static final a f13827b = new a(0, "NONE");

    /* renamed from: c, reason: collision with root package name */
    public static final a f13828c;

    /* renamed from: d, reason: collision with root package name */
    public static final a f13829d;

    /* renamed from: e, reason: collision with root package name */
    public static final a f13830e;

    /* renamed from: f, reason: collision with root package name */
    public static final a f13831f;

    /* renamed from: g, reason: collision with root package name */
    public static final a f13832g;

    /* renamed from: h, reason: collision with root package name */
    public static final a f13833h;

    /* renamed from: i, reason: collision with root package name */
    public static final a f13834i;

    /* renamed from: j, reason: collision with root package name */
    public static final a f13835j;

    /* renamed from: k, reason: collision with root package name */
    public static final a f13836k;

    /* renamed from: l, reason: collision with root package name */
    public static final a f13837l;

    /* renamed from: m, reason: collision with root package name */
    public static final a f13838m;

    /* renamed from: n, reason: collision with root package name */
    public static final a f13839n;

    /* renamed from: o, reason: collision with root package name */
    public static final a f13840o;

    /* renamed from: p, reason: collision with root package name */
    public static final a f13841p;

    /* renamed from: q, reason: collision with root package name */
    public static final a f13842q;

    /* renamed from: r, reason: collision with root package name */
    public static final a f13843r;

    /* renamed from: s, reason: collision with root package name */
    public static final List<a> f13844s;

    /* renamed from: a, reason: collision with root package name */
    private int f13845a;

    static {
        a aVar = new a(1, "PARTIAL");
        f13828c = aVar;
        a aVar2 = new a(8, "EAN8");
        f13829d = aVar2;
        a aVar3 = new a(9, "UPCE");
        f13830e = aVar3;
        a aVar4 = new a(10, "ISBN10");
        f13831f = aVar4;
        a aVar5 = new a(12, "UPCA");
        f13832g = aVar5;
        a aVar6 = new a(13, "EAN13");
        f13833h = aVar6;
        a aVar7 = new a(14, "ISBN13");
        f13834i = aVar7;
        a aVar8 = new a(25, "I25");
        f13835j = aVar8;
        a aVar9 = new a(34, "DATABAR");
        f13836k = aVar9;
        a aVar10 = new a(35, "DATABAR_EXP");
        f13837l = aVar10;
        a aVar11 = new a(38, "CODABAR");
        f13838m = aVar11;
        a aVar12 = new a(39, "CODE39");
        f13839n = aVar12;
        a aVar13 = new a(57, "PDF417");
        f13840o = aVar13;
        a aVar14 = new a(64, "QRCODE");
        f13841p = aVar14;
        a aVar15 = new a(93, "CODE93");
        f13842q = aVar15;
        a aVar16 = new a(128, "CODE128");
        f13843r = aVar16;
        ArrayList arrayList = new ArrayList();
        f13844s = arrayList;
        arrayList.add(aVar);
        arrayList.add(aVar2);
        arrayList.add(aVar3);
        arrayList.add(aVar4);
        arrayList.add(aVar5);
        arrayList.add(aVar6);
        arrayList.add(aVar7);
        arrayList.add(aVar8);
        arrayList.add(aVar9);
        arrayList.add(aVar10);
        arrayList.add(aVar11);
        arrayList.add(aVar12);
        arrayList.add(aVar13);
        arrayList.add(aVar14);
        arrayList.add(aVar15);
        arrayList.add(aVar16);
    }

    public a(int i10, String str) {
        this.f13845a = i10;
    }

    public static a a(int i10) {
        for (a aVar : f13844s) {
            if (aVar.b() == i10) {
                return aVar;
            }
        }
        return f13827b;
    }

    public int b() {
        return this.f13845a;
    }
}
