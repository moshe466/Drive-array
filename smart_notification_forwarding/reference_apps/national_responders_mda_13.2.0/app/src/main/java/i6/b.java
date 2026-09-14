package i6;

import java.util.ArrayList;
import java.util.Arrays;
import p6.d;
import p6.f;

/* loaded from: classes.dex */
public class b {

    /* renamed from: d, reason: collision with root package name */
    private static b f10739d;

    /* renamed from: a, reason: collision with root package name */
    private ArrayList<p6.b> f10740a = new ArrayList<>();

    /* renamed from: b, reason: collision with root package name */
    private ArrayList<d> f10741b = new ArrayList<>();

    /* renamed from: c, reason: collision with root package name */
    private ArrayList<f> f10742c = new ArrayList<>();

    private b() {
    }

    public static b f() {
        if (f10739d == null) {
            f10739d = new b();
        }
        return f10739d;
    }

    public void a(p6.b bVar) {
        this.f10740a.add(bVar);
    }

    public void b(d dVar) {
        this.f10741b.add(dVar);
    }

    public void c(f fVar) {
        this.f10742c.add(fVar);
    }

    public ArrayList<p6.b> d() {
        return this.f10740a;
    }

    public ArrayList<d> e() {
        return this.f10741b;
    }

    public ArrayList<f> g() {
        return this.f10742c;
    }

    public void h(p6.b[] bVarArr) {
        if (bVarArr != null) {
            this.f10740a = new ArrayList<>(Arrays.asList(bVarArr));
        }
    }

    public void i(d[] dVarArr) {
        if (dVarArr != null) {
            this.f10741b = new ArrayList<>(Arrays.asList(dVarArr));
        }
    }

    public void j(f[] fVarArr) {
        if (fVarArr != null) {
            this.f10742c = new ArrayList<>(Arrays.asList(fVarArr));
        }
    }

    public void k(p6.b bVar, int i10) {
        this.f10740a.set(i10, bVar);
    }
}
