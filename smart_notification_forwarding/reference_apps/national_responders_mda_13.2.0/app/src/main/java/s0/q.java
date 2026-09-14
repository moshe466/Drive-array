package s0;

import android.animation.TimeInterpolator;
import android.util.AndroidRuntimeException;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.Iterator;
import s0.m;

/* loaded from: classes.dex */
public class q extends m {
    int Q;
    private ArrayList<m> O = new ArrayList<>();
    private boolean P = true;
    boolean R = false;
    private int S = 0;

    /* loaded from: classes.dex */
    class a extends n {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ m f13982a;

        a(q qVar, m mVar) {
            this.f13982a = mVar;
        }

        @Override // s0.m.f
        public void b(m mVar) {
            this.f13982a.b0();
            mVar.X(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class b extends n {

        /* renamed from: a, reason: collision with root package name */
        q f13983a;

        b(q qVar) {
            this.f13983a = qVar;
        }

        @Override // s0.m.f
        public void b(m mVar) {
            q qVar = this.f13983a;
            int i10 = qVar.Q - 1;
            qVar.Q = i10;
            if (i10 == 0) {
                qVar.R = false;
                qVar.s();
            }
            mVar.X(this);
        }

        @Override // s0.n, s0.m.f
        public void c(m mVar) {
            q qVar = this.f13983a;
            if (qVar.R) {
                return;
            }
            qVar.i0();
            this.f13983a.R = true;
        }
    }

    private void v0() {
        b bVar = new b(this);
        Iterator<m> it = this.O.iterator();
        while (it.hasNext()) {
            it.next().a(bVar);
        }
        this.Q = this.O.size();
    }

    @Override // s0.m
    public void V(View view) {
        super.V(view);
        int size = this.O.size();
        for (int i10 = 0; i10 < size; i10++) {
            this.O.get(i10).V(view);
        }
    }

    @Override // s0.m
    public void Z(View view) {
        super.Z(view);
        int size = this.O.size();
        for (int i10 = 0; i10 < size; i10++) {
            this.O.get(i10).Z(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // s0.m
    public void b0() {
        if (this.O.isEmpty()) {
            i0();
            s();
            return;
        }
        v0();
        if (this.P) {
            Iterator<m> it = this.O.iterator();
            while (it.hasNext()) {
                it.next().b0();
            }
            return;
        }
        for (int i10 = 1; i10 < this.O.size(); i10++) {
            this.O.get(i10 - 1).a(new a(this, this.O.get(i10)));
        }
        m mVar = this.O.get(0);
        if (mVar != null) {
            mVar.b0();
        }
    }

    @Override // s0.m
    public void d0(m.e eVar) {
        super.d0(eVar);
        this.S |= 8;
        int size = this.O.size();
        for (int i10 = 0; i10 < size; i10++) {
            this.O.get(i10).d0(eVar);
        }
    }

    @Override // s0.m
    public void f0(g gVar) {
        super.f0(gVar);
        this.S |= 4;
        for (int i10 = 0; i10 < this.O.size(); i10++) {
            this.O.get(i10).f0(gVar);
        }
    }

    @Override // s0.m
    public void g0(p pVar) {
        super.g0(pVar);
        this.S |= 2;
        int size = this.O.size();
        for (int i10 = 0; i10 < size; i10++) {
            this.O.get(i10).g0(pVar);
        }
    }

    @Override // s0.m
    public void i(s sVar) {
        if (O(sVar.f13988b)) {
            Iterator<m> it = this.O.iterator();
            while (it.hasNext()) {
                m next = it.next();
                if (next.O(sVar.f13988b)) {
                    next.i(sVar);
                    sVar.f13989c.add(next);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // s0.m
    public String j0(String str) {
        String j02 = super.j0(str);
        for (int i10 = 0; i10 < this.O.size(); i10++) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(j02);
            sb2.append("\n");
            sb2.append(this.O.get(i10).j0(str + "  "));
            j02 = sb2.toString();
        }
        return j02;
    }

    @Override // s0.m
    /* renamed from: k0, reason: merged with bridge method [inline-methods] */
    public q a(m.f fVar) {
        return (q) super.a(fVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // s0.m
    public void l(s sVar) {
        super.l(sVar);
        int size = this.O.size();
        for (int i10 = 0; i10 < size; i10++) {
            this.O.get(i10).l(sVar);
        }
    }

    @Override // s0.m
    /* renamed from: l0, reason: merged with bridge method [inline-methods] */
    public q b(View view) {
        for (int i10 = 0; i10 < this.O.size(); i10++) {
            this.O.get(i10).b(view);
        }
        return (q) super.b(view);
    }

    @Override // s0.m
    public void m(s sVar) {
        if (O(sVar.f13988b)) {
            Iterator<m> it = this.O.iterator();
            while (it.hasNext()) {
                m next = it.next();
                if (next.O(sVar.f13988b)) {
                    next.m(sVar);
                    sVar.f13989c.add(next);
                }
            }
        }
    }

    public q m0(m mVar) {
        this.O.add(mVar);
        mVar.f13963w = this;
        long j10 = this.f13948h;
        if (j10 >= 0) {
            mVar.c0(j10);
        }
        if ((this.S & 1) != 0) {
            mVar.e0(w());
        }
        if ((this.S & 2) != 0) {
            mVar.g0(A());
        }
        if ((this.S & 4) != 0) {
            mVar.f0(z());
        }
        if ((this.S & 8) != 0) {
            mVar.d0(u());
        }
        return this;
    }

    public m n0(int i10) {
        if (i10 < 0 || i10 >= this.O.size()) {
            return null;
        }
        return this.O.get(i10);
    }

    public int o0() {
        return this.O.size();
    }

    @Override // s0.m
    /* renamed from: p */
    public m clone() {
        q qVar = (q) super.clone();
        qVar.O = new ArrayList<>();
        int size = this.O.size();
        for (int i10 = 0; i10 < size; i10++) {
            qVar.m0(this.O.get(i10).clone());
        }
        return qVar;
    }

    @Override // s0.m
    /* renamed from: p0, reason: merged with bridge method [inline-methods] */
    public q X(m.f fVar) {
        return (q) super.X(fVar);
    }

    @Override // s0.m
    /* renamed from: q0, reason: merged with bridge method [inline-methods] */
    public q Y(View view) {
        for (int i10 = 0; i10 < this.O.size(); i10++) {
            this.O.get(i10).Y(view);
        }
        return (q) super.Y(view);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // s0.m
    public void r(ViewGroup viewGroup, t tVar, t tVar2, ArrayList<s> arrayList, ArrayList<s> arrayList2) {
        long C = C();
        int size = this.O.size();
        for (int i10 = 0; i10 < size; i10++) {
            m mVar = this.O.get(i10);
            if (C > 0 && (this.P || i10 == 0)) {
                long C2 = mVar.C();
                if (C2 > 0) {
                    mVar.h0(C2 + C);
                } else {
                    mVar.h0(C);
                }
            }
            mVar.r(viewGroup, tVar, tVar2, arrayList, arrayList2);
        }
    }

    @Override // s0.m
    /* renamed from: r0, reason: merged with bridge method [inline-methods] */
    public q c0(long j10) {
        super.c0(j10);
        if (this.f13948h >= 0) {
            int size = this.O.size();
            for (int i10 = 0; i10 < size; i10++) {
                this.O.get(i10).c0(j10);
            }
        }
        return this;
    }

    @Override // s0.m
    /* renamed from: s0, reason: merged with bridge method [inline-methods] */
    public q e0(TimeInterpolator timeInterpolator) {
        this.S |= 1;
        ArrayList<m> arrayList = this.O;
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i10 = 0; i10 < size; i10++) {
                this.O.get(i10).e0(timeInterpolator);
            }
        }
        return (q) super.e0(timeInterpolator);
    }

    public q t0(int i10) {
        if (i10 == 0) {
            this.P = true;
        } else {
            if (i10 != 1) {
                throw new AndroidRuntimeException("Invalid parameter for TransitionSet ordering: " + i10);
            }
            this.P = false;
        }
        return this;
    }

    @Override // s0.m
    /* renamed from: u0, reason: merged with bridge method [inline-methods] */
    public q h0(long j10) {
        return (q) super.h0(j10);
    }
}
