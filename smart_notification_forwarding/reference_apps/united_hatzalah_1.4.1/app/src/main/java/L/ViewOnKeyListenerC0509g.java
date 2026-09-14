package l;

import F0.C0035g2;
import J.S;
import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.HeaderViewListAdapter;
import android.widget.ListAdapter;
import android.widget.PopupWindow;
import com.uh.sf.R;
import java.util.ArrayList;
import java.util.WeakHashMap;
import m.C0576w0;
import m.K0;
import m.O0;

/* renamed from: l.g, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class ViewOnKeyListenerC0509g extends u implements View.OnKeyListener, PopupWindow.OnDismissListener {

    /* renamed from: A, reason: collision with root package name */
    public ViewTreeObserver f5362A;

    /* renamed from: B, reason: collision with root package name */
    public PopupWindow.OnDismissListener f5363B;

    /* renamed from: C, reason: collision with root package name */
    public boolean f5364C;

    /* renamed from: b, reason: collision with root package name */
    public final Context f5365b;

    /* renamed from: c, reason: collision with root package name */
    public final int f5366c;

    /* renamed from: d, reason: collision with root package name */
    public final int f5367d;

    /* renamed from: e, reason: collision with root package name */
    public final boolean f5368e;

    /* renamed from: f, reason: collision with root package name */
    public final Handler f5369f;

    /* renamed from: l, reason: collision with root package name */
    public final ViewTreeObserverOnGlobalLayoutListenerC0506d f5372l;

    /* renamed from: m, reason: collision with root package name */
    public final ViewOnAttachStateChangeListenerC0507e f5373m;

    /* renamed from: q, reason: collision with root package name */
    public View f5376q;

    /* renamed from: r, reason: collision with root package name */
    public View f5377r;

    /* renamed from: s, reason: collision with root package name */
    public int f5378s;

    /* renamed from: t, reason: collision with root package name */
    public boolean f5379t;

    /* renamed from: u, reason: collision with root package name */
    public boolean f5380u;

    /* renamed from: v, reason: collision with root package name */
    public int f5381v;

    /* renamed from: w, reason: collision with root package name */
    public int f5382w;
    public boolean y;

    /* renamed from: z, reason: collision with root package name */
    public y f5384z;

    /* renamed from: j, reason: collision with root package name */
    public final ArrayList f5370j = new ArrayList();

    /* renamed from: k, reason: collision with root package name */
    public final ArrayList f5371k = new ArrayList();

    /* renamed from: n, reason: collision with root package name */
    public final C0035g2 f5374n = new C0035g2(this, 17);

    /* renamed from: o, reason: collision with root package name */
    public int f5375o = 0;
    public int p = 0;

    /* renamed from: x, reason: collision with root package name */
    public boolean f5383x = false;

    public ViewOnKeyListenerC0509g(Context context, View view, int i, boolean z3) {
        this.f5372l = new ViewTreeObserverOnGlobalLayoutListenerC0506d(this, r1);
        this.f5373m = new ViewOnAttachStateChangeListenerC0507e(this, r1);
        this.f5365b = context;
        this.f5376q = view;
        this.f5367d = i;
        this.f5368e = z3;
        WeakHashMap weakHashMap = S.f954a;
        this.f5378s = view.getLayoutDirection() != 1 ? 1 : 0;
        Resources resources = context.getResources();
        this.f5366c = Math.max(resources.getDisplayMetrics().widthPixels / 2, resources.getDimensionPixelSize(R.dimen.abc_config_prefDialogWidth));
        this.f5369f = new Handler();
    }

    @Override // l.InterfaceC0500D
    public final boolean a() {
        ArrayList arrayList = this.f5371k;
        if (arrayList.size() <= 0 || !((C0508f) arrayList.get(0)).f5359a.f5533B.isShowing()) {
            return false;
        }
        return true;
    }

    @Override // l.z
    public final void b(m mVar, boolean z3) {
        int i;
        ArrayList arrayList = this.f5371k;
        int size = arrayList.size();
        int i3 = 0;
        while (true) {
            if (i3 < size) {
                if (mVar == ((C0508f) arrayList.get(i3)).f5360b) {
                    break;
                } else {
                    i3++;
                }
            } else {
                i3 = -1;
                break;
            }
        }
        if (i3 >= 0) {
            int i4 = i3 + 1;
            if (i4 < arrayList.size()) {
                ((C0508f) arrayList.get(i4)).f5360b.c(false);
            }
            C0508f c0508f = (C0508f) arrayList.remove(i3);
            m mVar2 = c0508f.f5360b;
            O0 o02 = c0508f.f5359a;
            mVar2.r(this);
            if (this.f5364C) {
                K0.b(o02.f5533B, null);
                o02.f5533B.setAnimationStyle(0);
            }
            o02.dismiss();
            int size2 = arrayList.size();
            if (size2 > 0) {
                this.f5378s = ((C0508f) arrayList.get(size2 - 1)).f5361c;
            } else {
                View view = this.f5376q;
                WeakHashMap weakHashMap = S.f954a;
                if (view.getLayoutDirection() == 1) {
                    i = 0;
                } else {
                    i = 1;
                }
                this.f5378s = i;
            }
            if (size2 == 0) {
                dismiss();
                y yVar = this.f5384z;
                if (yVar != null) {
                    yVar.b(mVar, true);
                }
                ViewTreeObserver viewTreeObserver = this.f5362A;
                if (viewTreeObserver != null) {
                    if (viewTreeObserver.isAlive()) {
                        this.f5362A.removeGlobalOnLayoutListener(this.f5372l);
                    }
                    this.f5362A = null;
                }
                this.f5377r.removeOnAttachStateChangeListener(this.f5373m);
                this.f5363B.onDismiss();
                return;
            }
            if (z3) {
                ((C0508f) arrayList.get(0)).f5360b.c(false);
            }
        }
    }

    @Override // l.z
    public final boolean d() {
        return false;
    }

    @Override // l.InterfaceC0500D
    public final void dismiss() {
        ArrayList arrayList = this.f5371k;
        int size = arrayList.size();
        if (size > 0) {
            C0508f[] c0508fArr = (C0508f[]) arrayList.toArray(new C0508f[size]);
            for (int i = size - 1; i >= 0; i--) {
                C0508f c0508f = c0508fArr[i];
                if (c0508f.f5359a.f5533B.isShowing()) {
                    c0508f.f5359a.dismiss();
                }
            }
        }
    }

    @Override // l.z
    public final void e() {
        ArrayList arrayList = this.f5371k;
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            ListAdapter adapter = ((C0508f) obj).f5359a.f5536c.getAdapter();
            if (adapter instanceof HeaderViewListAdapter) {
                adapter = ((HeaderViewListAdapter) adapter).getWrappedAdapter();
            }
            ((j) adapter).notifyDataSetChanged();
        }
    }

    @Override // l.z
    public final void f(y yVar) {
        this.f5384z = yVar;
    }

    @Override // l.InterfaceC0500D
    public final C0576w0 g() {
        ArrayList arrayList = this.f5371k;
        if (arrayList.isEmpty()) {
            return null;
        }
        return ((C0508f) arrayList.get(arrayList.size() - 1)).f5359a.f5536c;
    }

    @Override // l.z
    public final boolean i(SubMenuC0502F subMenuC0502F) {
        ArrayList arrayList = this.f5371k;
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            C0508f c0508f = (C0508f) obj;
            if (subMenuC0502F == c0508f.f5360b) {
                c0508f.f5359a.f5536c.requestFocus();
                return true;
            }
        }
        if (!subMenuC0502F.hasVisibleItems()) {
            return false;
        }
        k(subMenuC0502F);
        y yVar = this.f5384z;
        if (yVar != null) {
            yVar.d(subMenuC0502F);
        }
        return true;
    }

    @Override // l.u
    public final void k(m mVar) {
        mVar.b(this, this.f5365b);
        if (a()) {
            t(mVar);
        } else {
            this.f5370j.add(mVar);
        }
    }

    @Override // l.u
    public final void m(View view) {
        if (this.f5376q != view) {
            this.f5376q = view;
            int i = this.f5375o;
            WeakHashMap weakHashMap = S.f954a;
            this.p = Gravity.getAbsoluteGravity(i, view.getLayoutDirection());
        }
    }

    @Override // l.u
    public final void n(boolean z3) {
        this.f5383x = z3;
    }

    @Override // l.u
    public final void o(int i) {
        if (this.f5375o != i) {
            this.f5375o = i;
            View view = this.f5376q;
            WeakHashMap weakHashMap = S.f954a;
            this.p = Gravity.getAbsoluteGravity(i, view.getLayoutDirection());
        }
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public final void onDismiss() {
        C0508f c0508f;
        ArrayList arrayList = this.f5371k;
        int size = arrayList.size();
        int i = 0;
        while (true) {
            if (i < size) {
                c0508f = (C0508f) arrayList.get(i);
                if (!c0508f.f5359a.f5533B.isShowing()) {
                    break;
                } else {
                    i++;
                }
            } else {
                c0508f = null;
                break;
            }
        }
        if (c0508f != null) {
            c0508f.f5360b.c(false);
        }
    }

    @Override // android.view.View.OnKeyListener
    public final boolean onKey(View view, int i, KeyEvent keyEvent) {
        if (keyEvent.getAction() == 1 && i == 82) {
            dismiss();
            return true;
        }
        return false;
    }

    @Override // l.u
    public final void p(int i) {
        this.f5379t = true;
        this.f5381v = i;
    }

    @Override // l.u
    public final void q(PopupWindow.OnDismissListener onDismissListener) {
        this.f5363B = onDismissListener;
    }

    @Override // l.u
    public final void r(boolean z3) {
        this.y = z3;
    }

    @Override // l.u
    public final void s(int i) {
        this.f5380u = true;
        this.f5382w = i;
    }

    @Override // l.InterfaceC0500D
    public final void show() {
        if (!a()) {
            ArrayList arrayList = this.f5370j;
            int size = arrayList.size();
            boolean z3 = false;
            int i = 0;
            while (i < size) {
                Object obj = arrayList.get(i);
                i++;
                t((m) obj);
            }
            arrayList.clear();
            View view = this.f5376q;
            this.f5377r = view;
            if (view != null) {
                if (this.f5362A == null) {
                    z3 = true;
                }
                ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
                this.f5362A = viewTreeObserver;
                if (z3) {
                    viewTreeObserver.addOnGlobalLayoutListener(this.f5372l);
                }
                this.f5377r.addOnAttachStateChangeListener(this.f5373m);
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x0159, code lost:
    
        if (((r9.getWidth() + r11[0]) + r5) > r10.right) goto L66;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x015b, code lost:
    
        r9 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x015e, code lost:
    
        r9 = 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x0163, code lost:
    
        if ((r11[0] - r5) < 0) goto L68;
     */
    /* JADX WARN: Removed duplicated region for block: B:18:0x010a  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x01cd  */
    /* JADX WARN: Type inference failed for: r8v3, types: [m.O0, m.I0] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void t(l.m r18) {
        /*
            Method dump skipped, instructions count: 553
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: l.ViewOnKeyListenerC0509g.t(l.m):void");
    }
}
