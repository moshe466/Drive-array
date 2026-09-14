package m;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.widget.HeaderViewListAdapter;
import android.widget.ListAdapter;
import androidx.appcompat.view.menu.ListMenuItemView;

/* loaded from: classes.dex */
public final class N0 extends C0576w0 {
    public final int p;

    /* renamed from: q, reason: collision with root package name */
    public final int f5565q;

    /* renamed from: r, reason: collision with root package name */
    public J0 f5566r;

    /* renamed from: s, reason: collision with root package name */
    public l.o f5567s;

    public N0(Context context, boolean z3) {
        super(context, z3);
        if (1 == M0.a(context.getResources().getConfiguration())) {
            this.p = 21;
            this.f5565q = 22;
        } else {
            this.p = 22;
            this.f5565q = 21;
        }
    }

    @Override // m.C0576w0, android.view.View
    public final boolean onHoverEvent(MotionEvent motionEvent) {
        l.j jVar;
        int i;
        l.o oVar;
        int pointToPosition;
        int i3;
        if (this.f5566r != null) {
            ListAdapter adapter = getAdapter();
            if (adapter instanceof HeaderViewListAdapter) {
                HeaderViewListAdapter headerViewListAdapter = (HeaderViewListAdapter) adapter;
                i = headerViewListAdapter.getHeadersCount();
                jVar = (l.j) headerViewListAdapter.getWrappedAdapter();
            } else {
                jVar = (l.j) adapter;
                i = 0;
            }
            if (motionEvent.getAction() != 10 && (pointToPosition = pointToPosition((int) motionEvent.getX(), (int) motionEvent.getY())) != -1 && (i3 = pointToPosition - i) >= 0 && i3 < jVar.getCount()) {
                oVar = jVar.getItem(i3);
            } else {
                oVar = null;
            }
            l.o oVar2 = this.f5567s;
            if (oVar2 != oVar) {
                l.m mVar = jVar.f5393a;
                if (oVar2 != null) {
                    this.f5566r.e(mVar, oVar2);
                }
                this.f5567s = oVar;
                if (oVar != null) {
                    this.f5566r.m(mVar, oVar);
                }
            }
        }
        return super.onHoverEvent(motionEvent);
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.view.View, android.view.KeyEvent.Callback
    public final boolean onKeyDown(int i, KeyEvent keyEvent) {
        l.j jVar;
        ListMenuItemView listMenuItemView = (ListMenuItemView) getSelectedView();
        if (listMenuItemView != null && i == this.p) {
            if (listMenuItemView.isEnabled() && listMenuItemView.getItemData().hasSubMenu()) {
                performItemClick(listMenuItemView, getSelectedItemPosition(), getSelectedItemId());
            }
            return true;
        }
        if (listMenuItemView != null && i == this.f5565q) {
            setSelection(-1);
            ListAdapter adapter = getAdapter();
            if (adapter instanceof HeaderViewListAdapter) {
                jVar = (l.j) ((HeaderViewListAdapter) adapter).getWrappedAdapter();
            } else {
                jVar = (l.j) adapter;
            }
            jVar.f5393a.c(false);
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    public void setHoverListener(J0 j02) {
        this.f5566r = j02;
    }

    @Override // m.C0576w0, android.widget.AbsListView
    public /* bridge */ /* synthetic */ void setSelector(Drawable drawable) {
        super.setSelector(drawable);
    }
}
