package ub;

import okhttp3.a0;
import okhttp3.s;
import okhttp3.v;
import okhttp3.y;

/* loaded from: classes.dex */
public final class a implements s {

    /* renamed from: a, reason: collision with root package name */
    public final v f14556a;

    public a(v vVar) {
        this.f14556a = vVar;
    }

    @Override // okhttp3.s
    public a0 a(s.a aVar) {
        vb.g gVar = (vb.g) aVar;
        y e10 = gVar.e();
        g k10 = gVar.k();
        return gVar.j(e10, k10, k10.i(this.f14556a, aVar, !e10.f().equals("GET")), k10.d());
    }
}
