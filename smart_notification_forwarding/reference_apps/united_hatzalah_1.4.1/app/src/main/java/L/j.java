package l;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import androidx.appcompat.view.menu.ListMenuItemView;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class j extends BaseAdapter {

    /* renamed from: a, reason: collision with root package name */
    public final m f5393a;

    /* renamed from: b, reason: collision with root package name */
    public int f5394b = -1;

    /* renamed from: c, reason: collision with root package name */
    public boolean f5395c;

    /* renamed from: d, reason: collision with root package name */
    public final boolean f5396d;

    /* renamed from: e, reason: collision with root package name */
    public final LayoutInflater f5397e;

    /* renamed from: f, reason: collision with root package name */
    public final int f5398f;

    public j(m mVar, LayoutInflater layoutInflater, boolean z3, int i) {
        this.f5396d = z3;
        this.f5397e = layoutInflater;
        this.f5393a = mVar;
        this.f5398f = i;
        a();
    }

    public final void a() {
        m mVar = this.f5393a;
        o oVar = mVar.f5420w;
        if (oVar != null) {
            mVar.i();
            ArrayList arrayList = mVar.f5408j;
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                if (((o) arrayList.get(i)) == oVar) {
                    this.f5394b = i;
                    return;
                }
            }
        }
        this.f5394b = -1;
    }

    @Override // android.widget.Adapter
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public final o getItem(int i) {
        ArrayList l3;
        boolean z3 = this.f5396d;
        m mVar = this.f5393a;
        if (z3) {
            mVar.i();
            l3 = mVar.f5408j;
        } else {
            l3 = mVar.l();
        }
        int i3 = this.f5394b;
        if (i3 >= 0 && i >= i3) {
            i++;
        }
        return (o) l3.get(i);
    }

    @Override // android.widget.Adapter
    public final int getCount() {
        ArrayList l3;
        boolean z3 = this.f5396d;
        m mVar = this.f5393a;
        if (z3) {
            mVar.i();
            l3 = mVar.f5408j;
        } else {
            l3 = mVar.l();
        }
        if (this.f5394b < 0) {
            return l3.size();
        }
        return l3.size() - 1;
    }

    @Override // android.widget.Adapter
    public final long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public final View getView(int i, View view, ViewGroup viewGroup) {
        int i3;
        boolean z3 = false;
        if (view == null) {
            view = this.f5397e.inflate(this.f5398f, viewGroup, false);
        }
        int i4 = getItem(i).f5429b;
        int i5 = i - 1;
        if (i5 >= 0) {
            i3 = getItem(i5).f5429b;
        } else {
            i3 = i4;
        }
        ListMenuItemView listMenuItemView = (ListMenuItemView) view;
        if (this.f5393a.m() && i4 != i3) {
            z3 = true;
        }
        listMenuItemView.setGroupDividerEnabled(z3);
        InterfaceC0497A interfaceC0497A = (InterfaceC0497A) view;
        if (this.f5395c) {
            listMenuItemView.setForceShowIcon(true);
        }
        interfaceC0497A.b(getItem(i));
        return view;
    }

    @Override // android.widget.BaseAdapter
    public final void notifyDataSetChanged() {
        a();
        super.notifyDataSetChanged();
    }
}
