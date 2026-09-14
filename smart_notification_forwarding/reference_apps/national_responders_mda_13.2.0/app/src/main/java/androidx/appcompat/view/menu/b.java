package androidx.appcompat.view.menu;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.view.menu.m;
import androidx.appcompat.view.menu.n;
import java.util.ArrayList;

/* loaded from: classes.dex */
public abstract class b implements m {

    /* renamed from: f, reason: collision with root package name */
    protected Context f866f;

    /* renamed from: g, reason: collision with root package name */
    protected Context f867g;

    /* renamed from: h, reason: collision with root package name */
    protected g f868h;

    /* renamed from: i, reason: collision with root package name */
    protected LayoutInflater f869i;

    /* renamed from: j, reason: collision with root package name */
    private m.a f870j;

    /* renamed from: k, reason: collision with root package name */
    private int f871k;

    /* renamed from: l, reason: collision with root package name */
    private int f872l;

    /* renamed from: m, reason: collision with root package name */
    protected n f873m;

    public b(Context context, int i10, int i11) {
        this.f866f = context;
        this.f869i = LayoutInflater.from(context);
        this.f871k = i10;
        this.f872l = i11;
    }

    protected void a(View view, int i10) {
        ViewGroup viewGroup = (ViewGroup) view.getParent();
        if (viewGroup != null) {
            viewGroup.removeView(view);
        }
        ((ViewGroup) this.f873m).addView(view, i10);
    }

    @Override // androidx.appcompat.view.menu.m
    public void b(g gVar, boolean z10) {
        m.a aVar = this.f870j;
        if (aVar != null) {
            aVar.b(gVar, z10);
        }
    }

    public abstract void c(i iVar, n.a aVar);

    @Override // androidx.appcompat.view.menu.m
    public void d(Context context, g gVar) {
        this.f867g = context;
        LayoutInflater.from(context);
        this.f868h = gVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v4, types: [androidx.appcompat.view.menu.g] */
    @Override // androidx.appcompat.view.menu.m
    public boolean e(r rVar) {
        m.a aVar = this.f870j;
        r rVar2 = rVar;
        if (aVar == null) {
            return false;
        }
        if (rVar == null) {
            rVar2 = this.f868h;
        }
        return aVar.c(rVar2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.appcompat.view.menu.m
    public void f(boolean z10) {
        ViewGroup viewGroup = (ViewGroup) this.f873m;
        if (viewGroup == null) {
            return;
        }
        g gVar = this.f868h;
        int i10 = 0;
        if (gVar != null) {
            gVar.r();
            ArrayList<i> E = this.f868h.E();
            int size = E.size();
            int i11 = 0;
            for (int i12 = 0; i12 < size; i12++) {
                i iVar = E.get(i12);
                if (q(i11, iVar)) {
                    View childAt = viewGroup.getChildAt(i11);
                    i itemData = childAt instanceof n.a ? ((n.a) childAt).getItemData() : null;
                    View n10 = n(iVar, childAt, viewGroup);
                    if (iVar != itemData) {
                        n10.setPressed(false);
                        n10.jumpDrawablesToCurrentState();
                    }
                    if (n10 != childAt) {
                        a(n10, i11);
                    }
                    i11++;
                }
            }
            i10 = i11;
        }
        while (i10 < viewGroup.getChildCount()) {
            if (!l(viewGroup, i10)) {
                i10++;
            }
        }
    }

    public n.a h(ViewGroup viewGroup) {
        return (n.a) this.f869i.inflate(this.f872l, viewGroup, false);
    }

    @Override // androidx.appcompat.view.menu.m
    public boolean i(g gVar, i iVar) {
        return false;
    }

    @Override // androidx.appcompat.view.menu.m
    public boolean j(g gVar, i iVar) {
        return false;
    }

    @Override // androidx.appcompat.view.menu.m
    public void k(m.a aVar) {
        this.f870j = aVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean l(ViewGroup viewGroup, int i10) {
        viewGroup.removeViewAt(i10);
        return true;
    }

    public m.a m() {
        return this.f870j;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public View n(i iVar, View view, ViewGroup viewGroup) {
        n.a h10 = view instanceof n.a ? (n.a) view : h(viewGroup);
        c(iVar, h10);
        return (View) h10;
    }

    public n o(ViewGroup viewGroup) {
        if (this.f873m == null) {
            n nVar = (n) this.f869i.inflate(this.f871k, viewGroup, false);
            this.f873m = nVar;
            nVar.b(this.f868h);
            f(true);
        }
        return this.f873m;
    }

    public void p(int i10) {
    }

    public abstract boolean q(int i10, i iVar);
}
