package com.google.gson;

import a5.d;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public final class f {

    /* renamed from: h, reason: collision with root package name */
    private String f7504h;

    /* renamed from: a, reason: collision with root package name */
    private z4.d f7497a = z4.d.f16177l;

    /* renamed from: b, reason: collision with root package name */
    private u f7498b = u.DEFAULT;

    /* renamed from: c, reason: collision with root package name */
    private d f7499c = c.IDENTITY;

    /* renamed from: d, reason: collision with root package name */
    private final Map<Type, g<?>> f7500d = new HashMap();

    /* renamed from: e, reason: collision with root package name */
    private final List<y> f7501e = new ArrayList();

    /* renamed from: f, reason: collision with root package name */
    private final List<y> f7502f = new ArrayList();

    /* renamed from: g, reason: collision with root package name */
    private boolean f7503g = false;

    /* renamed from: i, reason: collision with root package name */
    private int f7505i = 2;

    /* renamed from: j, reason: collision with root package name */
    private int f7506j = 2;

    /* renamed from: k, reason: collision with root package name */
    private boolean f7507k = false;

    /* renamed from: l, reason: collision with root package name */
    private boolean f7508l = false;

    /* renamed from: m, reason: collision with root package name */
    private boolean f7509m = true;

    /* renamed from: n, reason: collision with root package name */
    private boolean f7510n = false;

    /* renamed from: o, reason: collision with root package name */
    private boolean f7511o = false;

    /* renamed from: p, reason: collision with root package name */
    private boolean f7512p = false;

    /* renamed from: q, reason: collision with root package name */
    private w f7513q = v.DOUBLE;

    /* renamed from: r, reason: collision with root package name */
    private w f7514r = v.LAZILY_PARSED_NUMBER;

    private void a(String str, int i10, int i11, List<y> list) {
        y yVar;
        y yVar2;
        boolean z10 = d5.d.f8664a;
        y yVar3 = null;
        if (str != null && !str.trim().isEmpty()) {
            yVar = d.b.f201b.b(str);
            if (z10) {
                yVar3 = d5.d.f8666c.b(str);
                yVar2 = d5.d.f8665b.b(str);
            }
            yVar2 = null;
        } else {
            if (i10 == 2 || i11 == 2) {
                return;
            }
            y a10 = d.b.f201b.a(i10, i11);
            if (z10) {
                yVar3 = d5.d.f8666c.a(i10, i11);
                y a11 = d5.d.f8665b.a(i10, i11);
                yVar = a10;
                yVar2 = a11;
            } else {
                yVar = a10;
                yVar2 = null;
            }
        }
        list.add(yVar);
        if (z10) {
            list.add(yVar3);
            list.add(yVar2);
        }
    }

    public e b() {
        List<y> arrayList = new ArrayList<>(this.f7501e.size() + this.f7502f.size() + 3);
        arrayList.addAll(this.f7501e);
        Collections.reverse(arrayList);
        ArrayList arrayList2 = new ArrayList(this.f7502f);
        Collections.reverse(arrayList2);
        arrayList.addAll(arrayList2);
        a(this.f7504h, this.f7505i, this.f7506j, arrayList);
        return new e(this.f7497a, this.f7499c, this.f7500d, this.f7503g, this.f7507k, this.f7511o, this.f7509m, this.f7510n, this.f7512p, this.f7508l, this.f7498b, this.f7504h, this.f7505i, this.f7506j, this.f7501e, this.f7502f, arrayList, this.f7513q, this.f7514r);
    }

    public f c(Type type, Object obj) {
        boolean z10 = obj instanceof s;
        z4.a.a(z10 || (obj instanceof j) || (obj instanceof g) || (obj instanceof x));
        if (obj instanceof g) {
            this.f7500d.put(type, (g) obj);
        }
        if (z10 || (obj instanceof j)) {
            this.f7501e.add(a5.l.f(e5.a.b(type), obj));
        }
        if (obj instanceof x) {
            this.f7501e.add(a5.n.a(e5.a.b(type), (x) obj));
        }
        return this;
    }
}
