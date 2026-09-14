package l;

import android.content.Context;
import android.graphics.Rect;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.HeaderViewListAdapter;
import android.widget.ListAdapter;
import android.widget.PopupWindow;

/* loaded from: classes.dex */
public abstract class u implements InterfaceC0500D, z, AdapterView.OnItemClickListener {

    /* renamed from: a, reason: collision with root package name */
    public Rect f5460a;

    public static int l(ListAdapter listAdapter, Context context, int i) {
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(0, 0);
        int count = listAdapter.getCount();
        int i3 = 0;
        int i4 = 0;
        FrameLayout frameLayout = null;
        View view = null;
        for (int i5 = 0; i5 < count; i5++) {
            int itemViewType = listAdapter.getItemViewType(i5);
            if (itemViewType != i4) {
                view = null;
                i4 = itemViewType;
            }
            if (frameLayout == null) {
                frameLayout = new FrameLayout(context);
            }
            view = listAdapter.getView(i5, view, frameLayout);
            view.measure(makeMeasureSpec, makeMeasureSpec2);
            int measuredWidth = view.getMeasuredWidth();
            if (measuredWidth >= i) {
                return i;
            }
            if (measuredWidth > i3) {
                i3 = measuredWidth;
            }
        }
        return i3;
    }

    @Override // l.z
    public final boolean c(o oVar) {
        return false;
    }

    @Override // l.z
    public final boolean j(o oVar) {
        return false;
    }

    public abstract void k(m mVar);

    public abstract void m(View view);

    public abstract void n(boolean z3);

    public abstract void o(int i);

    @Override // android.widget.AdapterView.OnItemClickListener
    public final void onItemClick(AdapterView adapterView, View view, int i, long j2) {
        j jVar;
        int i3;
        ListAdapter listAdapter = (ListAdapter) adapterView.getAdapter();
        if (listAdapter instanceof HeaderViewListAdapter) {
            jVar = (j) ((HeaderViewListAdapter) listAdapter).getWrappedAdapter();
        } else {
            jVar = (j) listAdapter;
        }
        m mVar = jVar.f5393a;
        MenuItem menuItem = (MenuItem) listAdapter.getItem(i);
        if (!(this instanceof ViewOnKeyListenerC0509g)) {
            i3 = 0;
        } else {
            i3 = 4;
        }
        mVar.q(menuItem, this, i3);
    }

    public abstract void p(int i);

    public abstract void q(PopupWindow.OnDismissListener onDismissListener);

    public abstract void r(boolean z3);

    public abstract void s(int i);

    @Override // l.z
    public final void h(Context context, m mVar) {
    }
}
