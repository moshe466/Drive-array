package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.transition.Transition;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.widget.HeaderViewListAdapter;
import android.widget.ListAdapter;
import android.widget.PopupWindow;
import androidx.appcompat.view.menu.ListMenuItemView;
import java.lang.reflect.Method;

/* loaded from: classes.dex */
public class n0 extends l0 implements m0 {
    private static Method O;
    private m0 N;

    /* loaded from: classes.dex */
    static class a {
        static void a(PopupWindow popupWindow, Transition transition) {
            popupWindow.setEnterTransition(transition);
        }

        static void b(PopupWindow popupWindow, Transition transition) {
            popupWindow.setExitTransition(transition);
        }
    }

    /* loaded from: classes.dex */
    static class b {
        static void a(PopupWindow popupWindow, boolean z10) {
            popupWindow.setTouchModal(z10);
        }
    }

    /* loaded from: classes.dex */
    public static class c extends h0 {

        /* renamed from: t, reason: collision with root package name */
        final int f1443t;

        /* renamed from: u, reason: collision with root package name */
        final int f1444u;

        /* renamed from: v, reason: collision with root package name */
        private m0 f1445v;

        /* renamed from: w, reason: collision with root package name */
        private MenuItem f1446w;

        /* loaded from: classes.dex */
        static class a {
            static int a(Configuration configuration) {
                return configuration.getLayoutDirection();
            }
        }

        public c(Context context, boolean z10) {
            super(context, z10);
            Configuration configuration = context.getResources().getConfiguration();
            if (Build.VERSION.SDK_INT < 17 || 1 != a.a(configuration)) {
                this.f1443t = 22;
                this.f1444u = 21;
            } else {
                this.f1443t = 21;
                this.f1444u = 22;
            }
        }

        @Override // androidx.appcompat.widget.h0, android.view.View
        public boolean onHoverEvent(MotionEvent motionEvent) {
            int i10;
            int pointToPosition;
            int i11;
            if (this.f1445v != null) {
                ListAdapter adapter = getAdapter();
                if (adapter instanceof HeaderViewListAdapter) {
                    HeaderViewListAdapter headerViewListAdapter = (HeaderViewListAdapter) adapter;
                    i10 = headerViewListAdapter.getHeadersCount();
                    adapter = headerViewListAdapter.getWrappedAdapter();
                } else {
                    i10 = 0;
                }
                androidx.appcompat.view.menu.f fVar = (androidx.appcompat.view.menu.f) adapter;
                androidx.appcompat.view.menu.i iVar = null;
                if (motionEvent.getAction() != 10 && (pointToPosition = pointToPosition((int) motionEvent.getX(), (int) motionEvent.getY())) != -1 && (i11 = pointToPosition - i10) >= 0 && i11 < fVar.getCount()) {
                    iVar = fVar.getItem(i11);
                }
                MenuItem menuItem = this.f1446w;
                if (menuItem != iVar) {
                    androidx.appcompat.view.menu.g b10 = fVar.b();
                    if (menuItem != null) {
                        this.f1445v.f(b10, menuItem);
                    }
                    this.f1446w = iVar;
                    if (iVar != null) {
                        this.f1445v.e(b10, iVar);
                    }
                }
            }
            return super.onHoverEvent(motionEvent);
        }

        @Override // android.widget.ListView, android.widget.AbsListView, android.view.View, android.view.KeyEvent.Callback
        public boolean onKeyDown(int i10, KeyEvent keyEvent) {
            ListMenuItemView listMenuItemView = (ListMenuItemView) getSelectedView();
            if (listMenuItemView != null && i10 == this.f1443t) {
                if (listMenuItemView.isEnabled() && listMenuItemView.getItemData().hasSubMenu()) {
                    performItemClick(listMenuItemView, getSelectedItemPosition(), getSelectedItemId());
                }
                return true;
            }
            if (listMenuItemView == null || i10 != this.f1444u) {
                return super.onKeyDown(i10, keyEvent);
            }
            setSelection(-1);
            ListAdapter adapter = getAdapter();
            if (adapter instanceof HeaderViewListAdapter) {
                adapter = ((HeaderViewListAdapter) adapter).getWrappedAdapter();
            }
            ((androidx.appcompat.view.menu.f) adapter).b().e(false);
            return true;
        }

        public void setHoverListener(m0 m0Var) {
            this.f1445v = m0Var;
        }

        @Override // androidx.appcompat.widget.h0, android.widget.AbsListView
        public /* bridge */ /* synthetic */ void setSelector(Drawable drawable) {
            super.setSelector(drawable);
        }
    }

    static {
        try {
            if (Build.VERSION.SDK_INT <= 28) {
                O = PopupWindow.class.getDeclaredMethod("setTouchModal", Boolean.TYPE);
            }
        } catch (NoSuchMethodException unused) {
        }
    }

    public n0(Context context, AttributeSet attributeSet, int i10, int i11) {
        super(context, attributeSet, i10, i11);
    }

    public void N(Object obj) {
        if (Build.VERSION.SDK_INT >= 23) {
            a.a(this.J, (Transition) obj);
        }
    }

    public void O(Object obj) {
        if (Build.VERSION.SDK_INT >= 23) {
            a.b(this.J, (Transition) obj);
        }
    }

    public void P(m0 m0Var) {
        this.N = m0Var;
    }

    public void Q(boolean z10) {
        if (Build.VERSION.SDK_INT > 28) {
            b.a(this.J, z10);
            return;
        }
        Method method = O;
        if (method != null) {
            try {
                method.invoke(this.J, Boolean.valueOf(z10));
            } catch (Exception unused) {
            }
        }
    }

    @Override // androidx.appcompat.widget.m0
    public void e(androidx.appcompat.view.menu.g gVar, MenuItem menuItem) {
        m0 m0Var = this.N;
        if (m0Var != null) {
            m0Var.e(gVar, menuItem);
        }
    }

    @Override // androidx.appcompat.widget.m0
    public void f(androidx.appcompat.view.menu.g gVar, MenuItem menuItem) {
        m0 m0Var = this.N;
        if (m0Var != null) {
            m0Var.f(gVar, menuItem);
        }
    }

    @Override // androidx.appcompat.widget.l0
    h0 s(Context context, boolean z10) {
        c cVar = new c(context, z10);
        cVar.setHoverListener(this);
        return cVar;
    }
}
