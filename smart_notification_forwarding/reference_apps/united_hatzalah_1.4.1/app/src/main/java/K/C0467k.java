package k;

import J.Y;
import m.s1;

/* renamed from: k.k, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0467k extends m3.b {

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ int f5153d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f5154e;

    /* renamed from: f, reason: collision with root package name */
    public int f5155f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ Object f5156g;

    public C0467k(C0468l c0468l) {
        this.f5153d = 0;
        this.f5156g = c0468l;
        this.f5154e = false;
        this.f5155f = 0;
    }

    @Override // m3.b, J.Y
    public void a() {
        switch (this.f5153d) {
            case 1:
                this.f5154e = true;
                return;
            default:
                return;
        }
    }

    @Override // m3.b, J.Y
    public final void b() {
        switch (this.f5153d) {
            case 0:
                if (!this.f5154e) {
                    this.f5154e = true;
                    Y y = ((C0468l) this.f5156g).f5160d;
                    if (y != null) {
                        y.b();
                        return;
                    }
                    return;
                }
                return;
            default:
                ((s1) this.f5156g).f5772a.setVisibility(0);
                return;
        }
    }

    @Override // J.Y
    public final void c() {
        switch (this.f5153d) {
            case 0:
                int i = this.f5155f + 1;
                this.f5155f = i;
                C0468l c0468l = (C0468l) this.f5156g;
                if (i == c0468l.f5157a.size()) {
                    Y y = c0468l.f5160d;
                    if (y != null) {
                        y.c();
                    }
                    this.f5155f = 0;
                    this.f5154e = false;
                    c0468l.f5161e = false;
                    return;
                }
                return;
            default:
                if (!this.f5154e) {
                    ((s1) this.f5156g).f5772a.setVisibility(this.f5155f);
                    return;
                }
                return;
        }
    }

    public C0467k(s1 s1Var, int i) {
        this.f5153d = 1;
        this.f5156g = s1Var;
        this.f5155f = i;
        this.f5154e = false;
    }
}
