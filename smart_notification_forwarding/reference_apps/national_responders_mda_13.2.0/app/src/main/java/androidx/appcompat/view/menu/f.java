package androidx.appcompat.view.menu;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import androidx.appcompat.view.menu.n;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class f extends BaseAdapter {

    /* renamed from: f, reason: collision with root package name */
    g f918f;

    /* renamed from: g, reason: collision with root package name */
    private int f919g = -1;

    /* renamed from: h, reason: collision with root package name */
    private boolean f920h;

    /* renamed from: i, reason: collision with root package name */
    private final boolean f921i;

    /* renamed from: j, reason: collision with root package name */
    private final LayoutInflater f922j;

    /* renamed from: k, reason: collision with root package name */
    private final int f923k;

    public f(g gVar, LayoutInflater layoutInflater, boolean z10, int i10) {
        this.f921i = z10;
        this.f922j = layoutInflater;
        this.f918f = gVar;
        this.f923k = i10;
        a();
    }

    void a() {
        i v10 = this.f918f.v();
        if (v10 != null) {
            ArrayList<i> z10 = this.f918f.z();
            int size = z10.size();
            for (int i10 = 0; i10 < size; i10++) {
                if (z10.get(i10) == v10) {
                    this.f919g = i10;
                    return;
                }
            }
        }
        this.f919g = -1;
    }

    public g b() {
        return this.f918f;
    }

    @Override // android.widget.Adapter
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public i getItem(int i10) {
        ArrayList<i> z10 = this.f921i ? this.f918f.z() : this.f918f.E();
        int i11 = this.f919g;
        if (i11 >= 0 && i10 >= i11) {
            i10++;
        }
        return z10.get(i10);
    }

    public void d(boolean z10) {
        this.f920h = z10;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        ArrayList<i> z10 = this.f921i ? this.f918f.z() : this.f918f.E();
        int i10 = this.f919g;
        int size = z10.size();
        return i10 < 0 ? size : size - 1;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i10) {
        return i10;
    }

    @Override // android.widget.Adapter
    public View getView(int i10, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = this.f922j.inflate(this.f923k, viewGroup, false);
        }
        int groupId = getItem(i10).getGroupId();
        int i11 = i10 - 1;
        ListMenuItemView listMenuItemView = (ListMenuItemView) view;
        listMenuItemView.setGroupDividerEnabled(this.f918f.F() && groupId != (i11 >= 0 ? getItem(i11).getGroupId() : groupId));
        n.a aVar = (n.a) view;
        if (this.f920h) {
            listMenuItemView.setForceShowIcon(true);
        }
        aVar.e(getItem(i10), 0);
        return view;
    }

    @Override // android.widget.BaseAdapter
    public void notifyDataSetChanged() {
        a();
        super.notifyDataSetChanged();
    }
}
