package l;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.uh.sf.R;
import java.util.ArrayList;

/* renamed from: l.h, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0510h extends BaseAdapter {

    /* renamed from: a, reason: collision with root package name */
    public int f5385a = -1;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ i f5386b;

    public C0510h(i iVar) {
        this.f5386b = iVar;
        a();
    }

    public final void a() {
        m mVar = this.f5386b.f5389c;
        o oVar = mVar.f5420w;
        if (oVar != null) {
            mVar.i();
            ArrayList arrayList = mVar.f5408j;
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                if (((o) arrayList.get(i)) == oVar) {
                    this.f5385a = i;
                    return;
                }
            }
        }
        this.f5385a = -1;
    }

    @Override // android.widget.Adapter
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public final o getItem(int i) {
        i iVar = this.f5386b;
        m mVar = iVar.f5389c;
        mVar.i();
        ArrayList arrayList = mVar.f5408j;
        iVar.getClass();
        int i3 = this.f5385a;
        if (i3 >= 0 && i >= i3) {
            i++;
        }
        return (o) arrayList.get(i);
    }

    @Override // android.widget.Adapter
    public final int getCount() {
        i iVar = this.f5386b;
        m mVar = iVar.f5389c;
        mVar.i();
        int size = mVar.f5408j.size();
        iVar.getClass();
        if (this.f5385a < 0) {
            return size;
        }
        return size - 1;
    }

    @Override // android.widget.Adapter
    public final long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public final View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = this.f5386b.f5388b.inflate(R.layout.abc_list_menu_item_layout, viewGroup, false);
        }
        ((InterfaceC0497A) view).b(getItem(i));
        return view;
    }

    @Override // android.widget.BaseAdapter
    public final void notifyDataSetChanged() {
        a();
        super.notifyDataSetChanged();
    }
}
