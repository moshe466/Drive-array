package q0;

import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import q.C0602B;

/* loaded from: classes.dex */
public class v extends q {

    /* renamed from: A, reason: collision with root package name */
    public int f6129A;
    public ArrayList y = new ArrayList();

    /* renamed from: z, reason: collision with root package name */
    public boolean f6132z = true;

    /* renamed from: B, reason: collision with root package name */
    public boolean f6130B = false;

    /* renamed from: C, reason: collision with root package name */
    public int f6131C = 0;

    @Override // q0.q
    public final void A(T.b bVar) {
        this.f6120t = bVar;
        this.f6131C |= 8;
        int size = this.y.size();
        for (int i = 0; i < size; i++) {
            ((q) this.y.get(i)).A(bVar);
        }
    }

    @Override // q0.q
    public final void B() {
        this.f6131C |= 1;
        ArrayList arrayList = this.y;
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                ((q) this.y.get(i)).B();
            }
        }
    }

    @Override // q0.q
    public final void C(C0602B c0602b) {
        super.C(c0602b);
        this.f6131C |= 4;
        if (this.y != null) {
            for (int i = 0; i < this.y.size(); i++) {
                ((q) this.y.get(i)).C(c0602b);
            }
        }
    }

    @Override // q0.q
    public final void D() {
        this.f6131C |= 2;
        int size = this.y.size();
        for (int i = 0; i < size; i++) {
            ((q) this.y.get(i)).D();
        }
    }

    @Override // q0.q
    public final void E(long j2) {
        this.f6106b = j2;
    }

    @Override // q0.q
    public final String G(String str) {
        String G3 = super.G(str);
        for (int i = 0; i < this.y.size(); i++) {
            StringBuilder i3 = e0.a.i(G3, "\n");
            i3.append(((q) this.y.get(i)).G(str + "  "));
            G3 = i3.toString();
        }
        return G3;
    }

    public final void H(q qVar) {
        this.y.add(qVar);
        qVar.f6111j = this;
        if ((this.f6131C & 1) != 0) {
            qVar.B();
        }
        if ((this.f6131C & 2) != 0) {
            qVar.D();
        }
        if ((this.f6131C & 4) != 0) {
            qVar.C(this.f6121u);
        }
        if ((this.f6131C & 8) != 0) {
            qVar.A(this.f6120t);
        }
    }

    @Override // q0.q
    public final void b(View view) {
        for (int i = 0; i < this.y.size(); i++) {
            ((q) this.y.get(i)).b(view);
        }
        this.f6108d.add(view);
    }

    @Override // q0.q
    public final void d() {
        super.d();
        int size = this.y.size();
        for (int i = 0; i < size; i++) {
            ((q) this.y.get(i)).d();
        }
    }

    @Override // q0.q
    public final void e(x xVar) {
        if (t(xVar.f6137b)) {
            ArrayList arrayList = this.y;
            int size = arrayList.size();
            int i = 0;
            while (i < size) {
                Object obj = arrayList.get(i);
                i++;
                q qVar = (q) obj;
                if (qVar.t(xVar.f6137b)) {
                    qVar.e(xVar);
                    xVar.f6138c.add(qVar);
                }
            }
        }
    }

    @Override // q0.q
    public final void g(x xVar) {
        int size = this.y.size();
        for (int i = 0; i < size; i++) {
            ((q) this.y.get(i)).g(xVar);
        }
    }

    @Override // q0.q
    public final void h(x xVar) {
        if (t(xVar.f6137b)) {
            ArrayList arrayList = this.y;
            int size = arrayList.size();
            int i = 0;
            while (i < size) {
                Object obj = arrayList.get(i);
                i++;
                q qVar = (q) obj;
                if (qVar.t(xVar.f6137b)) {
                    qVar.h(xVar);
                    xVar.f6138c.add(qVar);
                }
            }
        }
    }

    @Override // q0.q
    /* renamed from: k */
    public final q clone() {
        v vVar = (v) super.clone();
        vVar.y = new ArrayList();
        int size = this.y.size();
        for (int i = 0; i < size; i++) {
            q clone = ((q) this.y.get(i)).clone();
            vVar.y.add(clone);
            clone.f6111j = vVar;
        }
        return vVar;
    }

    @Override // q0.q
    public final void m(ViewGroup viewGroup, K1.m mVar, K1.m mVar2, ArrayList arrayList, ArrayList arrayList2) {
        long j2 = this.f6106b;
        int size = this.y.size();
        for (int i = 0; i < size; i++) {
            q qVar = (q) this.y.get(i);
            if (j2 > 0 && (this.f6132z || i == 0)) {
                long j3 = qVar.f6106b;
                if (j3 > 0) {
                    qVar.E(j3 + j2);
                } else {
                    qVar.E(j2);
                }
            }
            qVar.m(viewGroup, mVar, mVar2, arrayList, arrayList2);
        }
    }

    @Override // q0.q
    public final void v(View view) {
        super.v(view);
        int size = this.y.size();
        for (int i = 0; i < size; i++) {
            ((q) this.y.get(i)).v(view);
        }
    }

    @Override // q0.q
    public final void x(View view) {
        for (int i = 0; i < this.y.size(); i++) {
            ((q) this.y.get(i)).x(view);
        }
        this.f6108d.remove(view);
    }

    @Override // q0.q
    public final void y(View view) {
        super.y(view);
        int size = this.y.size();
        for (int i = 0; i < size; i++) {
            ((q) this.y.get(i)).y(view);
        }
    }

    @Override // q0.q
    public final void z() {
        if (this.y.isEmpty()) {
            F();
            n();
            return;
        }
        g gVar = new g();
        gVar.f6085b = this;
        ArrayList arrayList = this.y;
        int size = arrayList.size();
        int i = 0;
        int i3 = 0;
        while (i3 < size) {
            Object obj = arrayList.get(i3);
            i3++;
            ((q) obj).a(gVar);
        }
        this.f6129A = this.y.size();
        if (!this.f6132z) {
            for (int i4 = 1; i4 < this.y.size(); i4++) {
                ((q) this.y.get(i4 - 1)).a(new g((q) this.y.get(i4), 1));
            }
            q qVar = (q) this.y.get(0);
            if (qVar != null) {
                qVar.z();
                return;
            }
            return;
        }
        ArrayList arrayList2 = this.y;
        int size2 = arrayList2.size();
        while (i < size2) {
            Object obj2 = arrayList2.get(i);
            i++;
            ((q) obj2).z();
        }
    }
}
