package androidx.appcompat.view.menu;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import androidx.appcompat.view.menu.m;
import androidx.appcompat.view.menu.n;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class e implements m, AdapterView.OnItemClickListener {

    /* renamed from: f, reason: collision with root package name */
    Context f907f;

    /* renamed from: g, reason: collision with root package name */
    LayoutInflater f908g;

    /* renamed from: h, reason: collision with root package name */
    g f909h;

    /* renamed from: i, reason: collision with root package name */
    ExpandedMenuView f910i;

    /* renamed from: j, reason: collision with root package name */
    int f911j;

    /* renamed from: k, reason: collision with root package name */
    int f912k;

    /* renamed from: l, reason: collision with root package name */
    int f913l;

    /* renamed from: m, reason: collision with root package name */
    private m.a f914m;

    /* renamed from: n, reason: collision with root package name */
    a f915n;

    /* loaded from: classes.dex */
    private class a extends BaseAdapter {

        /* renamed from: f, reason: collision with root package name */
        private int f916f = -1;

        public a() {
            a();
        }

        void a() {
            i v10 = e.this.f909h.v();
            if (v10 != null) {
                ArrayList<i> z10 = e.this.f909h.z();
                int size = z10.size();
                for (int i10 = 0; i10 < size; i10++) {
                    if (z10.get(i10) == v10) {
                        this.f916f = i10;
                        return;
                    }
                }
            }
            this.f916f = -1;
        }

        @Override // android.widget.Adapter
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public i getItem(int i10) {
            ArrayList<i> z10 = e.this.f909h.z();
            int i11 = i10 + e.this.f911j;
            int i12 = this.f916f;
            if (i12 >= 0 && i11 >= i12) {
                i11++;
            }
            return z10.get(i11);
        }

        @Override // android.widget.Adapter
        public int getCount() {
            int size = e.this.f909h.z().size() - e.this.f911j;
            return this.f916f < 0 ? size : size - 1;
        }

        @Override // android.widget.Adapter
        public long getItemId(int i10) {
            return i10;
        }

        @Override // android.widget.Adapter
        public View getView(int i10, View view, ViewGroup viewGroup) {
            if (view == null) {
                e eVar = e.this;
                view = eVar.f908g.inflate(eVar.f913l, viewGroup, false);
            }
            ((n.a) view).e(getItem(i10), 0);
            return view;
        }

        @Override // android.widget.BaseAdapter
        public void notifyDataSetChanged() {
            a();
            super.notifyDataSetChanged();
        }
    }

    public e(int i10, int i11) {
        this.f913l = i10;
        this.f912k = i11;
    }

    public e(Context context, int i10) {
        this(i10, 0);
        this.f907f = context;
        this.f908g = LayoutInflater.from(context);
    }

    public ListAdapter a() {
        if (this.f915n == null) {
            this.f915n = new a();
        }
        return this.f915n;
    }

    @Override // androidx.appcompat.view.menu.m
    public void b(g gVar, boolean z10) {
        m.a aVar = this.f914m;
        if (aVar != null) {
            aVar.b(gVar, z10);
        }
    }

    public n c(ViewGroup viewGroup) {
        if (this.f910i == null) {
            this.f910i = (ExpandedMenuView) this.f908g.inflate(e.g.f8962g, viewGroup, false);
            if (this.f915n == null) {
                this.f915n = new a();
            }
            this.f910i.setAdapter((ListAdapter) this.f915n);
            this.f910i.setOnItemClickListener(this);
        }
        return this.f910i;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0029  */
    @Override // androidx.appcompat.view.menu.m
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void d(android.content.Context r3, androidx.appcompat.view.menu.g r4) {
        /*
            r2 = this;
            int r0 = r2.f912k
            if (r0 == 0) goto L14
            android.view.ContextThemeWrapper r0 = new android.view.ContextThemeWrapper
            int r1 = r2.f912k
            r0.<init>(r3, r1)
            r2.f907f = r0
            android.view.LayoutInflater r3 = android.view.LayoutInflater.from(r0)
        L11:
            r2.f908g = r3
            goto L23
        L14:
            android.content.Context r0 = r2.f907f
            if (r0 == 0) goto L23
            r2.f907f = r3
            android.view.LayoutInflater r0 = r2.f908g
            if (r0 != 0) goto L23
            android.view.LayoutInflater r3 = android.view.LayoutInflater.from(r3)
            goto L11
        L23:
            r2.f909h = r4
            androidx.appcompat.view.menu.e$a r3 = r2.f915n
            if (r3 == 0) goto L2c
            r3.notifyDataSetChanged()
        L2c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.view.menu.e.d(android.content.Context, androidx.appcompat.view.menu.g):void");
    }

    @Override // androidx.appcompat.view.menu.m
    public boolean e(r rVar) {
        if (!rVar.hasVisibleItems()) {
            return false;
        }
        new h(rVar).d(null);
        m.a aVar = this.f914m;
        if (aVar == null) {
            return true;
        }
        aVar.c(rVar);
        return true;
    }

    @Override // androidx.appcompat.view.menu.m
    public void f(boolean z10) {
        a aVar = this.f915n;
        if (aVar != null) {
            aVar.notifyDataSetChanged();
        }
    }

    @Override // androidx.appcompat.view.menu.m
    public boolean g() {
        return false;
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
        this.f914m = aVar;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i10, long j10) {
        this.f909h.M(this.f915n.getItem(i10), this, 0);
    }
}
