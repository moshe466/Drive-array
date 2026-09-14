package m;

import F0.C0035g2;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.view.menu.ActionMenuItemView;
import androidx.appcompat.widget.ActionMenuView;
import com.uh.sf.R;
import java.util.ArrayList;
import l.InterfaceC0497A;
import l.InterfaceC0498B;
import l.SubMenuC0502F;

/* renamed from: m.i, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0548i implements l.z {

    /* renamed from: a, reason: collision with root package name */
    public final Context f5668a;

    /* renamed from: b, reason: collision with root package name */
    public Context f5669b;

    /* renamed from: c, reason: collision with root package name */
    public l.m f5670c;

    /* renamed from: d, reason: collision with root package name */
    public final LayoutInflater f5671d;

    /* renamed from: e, reason: collision with root package name */
    public l.y f5672e;

    /* renamed from: k, reason: collision with root package name */
    public InterfaceC0498B f5675k;

    /* renamed from: l, reason: collision with root package name */
    public C0546h f5676l;

    /* renamed from: m, reason: collision with root package name */
    public Drawable f5677m;

    /* renamed from: n, reason: collision with root package name */
    public boolean f5678n;

    /* renamed from: o, reason: collision with root package name */
    public boolean f5679o;
    public boolean p;

    /* renamed from: q, reason: collision with root package name */
    public int f5680q;

    /* renamed from: r, reason: collision with root package name */
    public int f5681r;

    /* renamed from: s, reason: collision with root package name */
    public int f5682s;

    /* renamed from: t, reason: collision with root package name */
    public boolean f5683t;

    /* renamed from: v, reason: collision with root package name */
    public C0540e f5685v;

    /* renamed from: w, reason: collision with root package name */
    public C0540e f5686w;

    /* renamed from: x, reason: collision with root package name */
    public RunnableC0544g f5687x;
    public C0542f y;

    /* renamed from: f, reason: collision with root package name */
    public final int f5673f = R.layout.abc_action_menu_layout;

    /* renamed from: j, reason: collision with root package name */
    public final int f5674j = R.layout.abc_action_menu_item_layout;

    /* renamed from: u, reason: collision with root package name */
    public final SparseBooleanArray f5684u = new SparseBooleanArray();

    /* renamed from: z, reason: collision with root package name */
    public final C0035g2 f5688z = new C0035g2(this, 18);

    public C0548i(Context context) {
        this.f5668a = context;
        this.f5671d = LayoutInflater.from(context);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v0, types: [android.view.View] */
    /* JADX WARN: Type inference failed for: r5v4, types: [l.A] */
    /* JADX WARN: Type inference failed for: r5v7 */
    /* JADX WARN: Type inference failed for: r5v8 */
    public final View a(l.o oVar, View view, ViewGroup viewGroup) {
        ActionMenuItemView actionMenuItemView;
        View actionView = oVar.getActionView();
        int i = 0;
        if (actionView == null || oVar.e()) {
            if (view instanceof InterfaceC0497A) {
                actionMenuItemView = (InterfaceC0497A) view;
            } else {
                actionMenuItemView = (InterfaceC0497A) this.f5671d.inflate(this.f5674j, viewGroup, false);
            }
            actionMenuItemView.b(oVar);
            ActionMenuItemView actionMenuItemView2 = actionMenuItemView;
            actionMenuItemView2.setItemInvoker((ActionMenuView) this.f5675k);
            if (this.y == null) {
                this.y = new C0542f(this);
            }
            actionMenuItemView2.setPopupCallback(this.y);
            actionView = actionMenuItemView;
        }
        if (oVar.f5427C) {
            i = 8;
        }
        actionView.setVisibility(i);
        ViewGroup.LayoutParams layoutParams = actionView.getLayoutParams();
        ((ActionMenuView) viewGroup).getClass();
        if (!(layoutParams instanceof C0552k)) {
            actionView.setLayoutParams(ActionMenuView.j(layoutParams));
        }
        return actionView;
    }

    @Override // l.z
    public final void b(l.m mVar, boolean z3) {
        g();
        C0540e c0540e = this.f5686w;
        if (c0540e != null && c0540e.b()) {
            c0540e.i.dismiss();
        }
        l.y yVar = this.f5672e;
        if (yVar != null) {
            yVar.b(mVar, z3);
        }
    }

    @Override // l.z
    public final boolean c(l.o oVar) {
        return false;
    }

    @Override // l.z
    public final boolean d() {
        int i;
        ArrayList arrayList;
        int i3;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        C0548i c0548i = this;
        l.m mVar = c0548i.f5670c;
        if (mVar != null) {
            arrayList = mVar.l();
            i = arrayList.size();
        } else {
            i = 0;
            arrayList = null;
        }
        int i4 = c0548i.f5682s;
        int i5 = c0548i.f5681r;
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        ViewGroup viewGroup = (ViewGroup) c0548i.f5675k;
        int i6 = 0;
        boolean z7 = false;
        int i7 = 0;
        int i8 = 0;
        while (true) {
            i3 = 2;
            z3 = true;
            if (i6 >= i) {
                break;
            }
            l.o oVar = (l.o) arrayList.get(i6);
            int i9 = oVar.y;
            if ((i9 & 2) == 2) {
                i7++;
            } else if ((i9 & 1) == 1) {
                i8++;
            } else {
                z7 = true;
            }
            if (c0548i.f5683t && oVar.f5427C) {
                i4 = 0;
            }
            i6++;
        }
        if (c0548i.f5679o && (z7 || i8 + i7 > i4)) {
            i4--;
        }
        int i10 = i4 - i7;
        SparseBooleanArray sparseBooleanArray = c0548i.f5684u;
        sparseBooleanArray.clear();
        int i11 = 0;
        int i12 = 0;
        while (i11 < i) {
            l.o oVar2 = (l.o) arrayList.get(i11);
            int i13 = oVar2.y;
            if ((i13 & 2) == i3) {
                z4 = z3;
            } else {
                z4 = false;
            }
            int i14 = oVar2.f5429b;
            if (z4) {
                View a2 = c0548i.a(oVar2, null, viewGroup);
                a2.measure(makeMeasureSpec, makeMeasureSpec);
                int measuredWidth = a2.getMeasuredWidth();
                i5 -= measuredWidth;
                if (i12 == 0) {
                    i12 = measuredWidth;
                }
                if (i14 != 0) {
                    sparseBooleanArray.put(i14, z3);
                }
                oVar2.f(z3);
            } else if ((i13 & 1) == z3) {
                boolean z8 = sparseBooleanArray.get(i14);
                if ((i10 > 0 || z8) && i5 > 0) {
                    z5 = z3;
                } else {
                    z5 = false;
                }
                if (z5) {
                    View a4 = c0548i.a(oVar2, null, viewGroup);
                    a4.measure(makeMeasureSpec, makeMeasureSpec);
                    int measuredWidth2 = a4.getMeasuredWidth();
                    i5 -= measuredWidth2;
                    if (i12 == 0) {
                        i12 = measuredWidth2;
                    }
                    if (i5 + i12 > 0) {
                        z6 = true;
                    } else {
                        z6 = false;
                    }
                    z5 &= z6;
                }
                if (z5 && i14 != 0) {
                    sparseBooleanArray.put(i14, true);
                } else if (z8) {
                    sparseBooleanArray.put(i14, false);
                    for (int i15 = 0; i15 < i11; i15++) {
                        l.o oVar3 = (l.o) arrayList.get(i15);
                        if (oVar3.f5429b == i14) {
                            if ((oVar3.f5449x & 32) == 32) {
                                i10++;
                            }
                            oVar3.f(false);
                        }
                    }
                }
                if (z5) {
                    i10--;
                }
                oVar2.f(z5);
            } else {
                oVar2.f(false);
                i11++;
                i3 = 2;
                c0548i = this;
                z3 = true;
            }
            i11++;
            i3 = 2;
            c0548i = this;
            z3 = true;
        }
        return z3;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // l.z
    public final void e() {
        int i;
        l.o oVar;
        ViewGroup viewGroup = (ViewGroup) this.f5675k;
        ArrayList arrayList = null;
        boolean z3 = false;
        if (viewGroup != null) {
            l.m mVar = this.f5670c;
            if (mVar != null) {
                mVar.i();
                ArrayList l3 = this.f5670c.l();
                int size = l3.size();
                i = 0;
                for (int i3 = 0; i3 < size; i3++) {
                    l.o oVar2 = (l.o) l3.get(i3);
                    if ((oVar2.f5449x & 32) == 32) {
                        View childAt = viewGroup.getChildAt(i);
                        if (childAt instanceof InterfaceC0497A) {
                            oVar = ((InterfaceC0497A) childAt).getItemData();
                        } else {
                            oVar = null;
                        }
                        View a2 = a(oVar2, childAt, viewGroup);
                        if (oVar2 != oVar) {
                            a2.setPressed(false);
                            a2.jumpDrawablesToCurrentState();
                        }
                        if (a2 != childAt) {
                            ViewGroup viewGroup2 = (ViewGroup) a2.getParent();
                            if (viewGroup2 != null) {
                                viewGroup2.removeView(a2);
                            }
                            ((ViewGroup) this.f5675k).addView(a2, i);
                        }
                        i++;
                    }
                }
            } else {
                i = 0;
            }
            while (i < viewGroup.getChildCount()) {
                if (viewGroup.getChildAt(i) == this.f5676l) {
                    i++;
                } else {
                    viewGroup.removeViewAt(i);
                }
            }
        }
        ((View) this.f5675k).requestLayout();
        l.m mVar2 = this.f5670c;
        if (mVar2 != null) {
            mVar2.i();
            ArrayList arrayList2 = mVar2.i;
            int size2 = arrayList2.size();
            for (int i4 = 0; i4 < size2; i4++) {
                l.p pVar = ((l.o) arrayList2.get(i4)).f5425A;
            }
        }
        l.m mVar3 = this.f5670c;
        if (mVar3 != null) {
            mVar3.i();
            arrayList = mVar3.f5408j;
        }
        if (this.f5679o && arrayList != null) {
            int size3 = arrayList.size();
            if (size3 == 1) {
                z3 = !((l.o) arrayList.get(0)).f5427C;
            } else if (size3 > 0) {
                z3 = true;
            }
        }
        if (z3) {
            if (this.f5676l == null) {
                this.f5676l = new C0546h(this, this.f5668a);
            }
            ViewGroup viewGroup3 = (ViewGroup) this.f5676l.getParent();
            if (viewGroup3 != this.f5675k) {
                if (viewGroup3 != null) {
                    viewGroup3.removeView(this.f5676l);
                }
                ActionMenuView actionMenuView = (ActionMenuView) this.f5675k;
                C0546h c0546h = this.f5676l;
                actionMenuView.getClass();
                C0552k i5 = ActionMenuView.i();
                i5.f5709a = true;
                actionMenuView.addView(c0546h, i5);
            }
        } else {
            C0546h c0546h2 = this.f5676l;
            if (c0546h2 != null) {
                Object parent = c0546h2.getParent();
                Object obj = this.f5675k;
                if (parent == obj) {
                    ((ViewGroup) obj).removeView(this.f5676l);
                }
            }
        }
        ((ActionMenuView) this.f5675k).setOverflowReserved(this.f5679o);
    }

    @Override // l.z
    public final void f(l.y yVar) {
        throw null;
    }

    public final boolean g() {
        Object obj;
        RunnableC0544g runnableC0544g = this.f5687x;
        if (runnableC0544g != null && (obj = this.f5675k) != null) {
            ((View) obj).removeCallbacks(runnableC0544g);
            this.f5687x = null;
            return true;
        }
        C0540e c0540e = this.f5685v;
        if (c0540e != null) {
            if (c0540e.b()) {
                c0540e.i.dismiss();
            }
            return true;
        }
        return false;
    }

    @Override // l.z
    public final void h(Context context, l.m mVar) {
        this.f5669b = context;
        LayoutInflater.from(context);
        this.f5670c = mVar;
        Resources resources = context.getResources();
        if (!this.p) {
            this.f5679o = true;
        }
        int i = 2;
        this.f5680q = context.getResources().getDisplayMetrics().widthPixels / 2;
        Configuration configuration = context.getResources().getConfiguration();
        int i3 = configuration.screenWidthDp;
        int i4 = configuration.screenHeightDp;
        if (configuration.smallestScreenWidthDp <= 600 && i3 <= 600 && ((i3 <= 960 || i4 <= 720) && (i3 <= 720 || i4 <= 960))) {
            if (i3 < 500 && ((i3 <= 640 || i4 <= 480) && (i3 <= 480 || i4 <= 640))) {
                if (i3 >= 360) {
                    i = 3;
                }
            } else {
                i = 4;
            }
        } else {
            i = 5;
        }
        this.f5682s = i;
        int i5 = this.f5680q;
        if (this.f5679o) {
            if (this.f5676l == null) {
                C0546h c0546h = new C0546h(this, this.f5668a);
                this.f5676l = c0546h;
                if (this.f5678n) {
                    c0546h.setImageDrawable(this.f5677m);
                    this.f5677m = null;
                    this.f5678n = false;
                }
                int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
                this.f5676l.measure(makeMeasureSpec, makeMeasureSpec);
            }
            i5 -= this.f5676l.getMeasuredWidth();
        } else {
            this.f5676l = null;
        }
        this.f5681r = i5;
        float f4 = resources.getDisplayMetrics().density;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // l.z
    public final boolean i(SubMenuC0502F subMenuC0502F) {
        boolean z3;
        if (subMenuC0502F.hasVisibleItems()) {
            SubMenuC0502F subMenuC0502F2 = subMenuC0502F;
            while (true) {
                l.m mVar = subMenuC0502F2.f5337A;
                if (mVar == this.f5670c) {
                    break;
                }
                subMenuC0502F2 = (SubMenuC0502F) mVar;
            }
            l.o oVar = subMenuC0502F2.f5338B;
            ViewGroup viewGroup = (ViewGroup) this.f5675k;
            View view = null;
            if (viewGroup != null) {
                int childCount = viewGroup.getChildCount();
                int i = 0;
                while (true) {
                    if (i >= childCount) {
                        break;
                    }
                    View childAt = viewGroup.getChildAt(i);
                    if ((childAt instanceof InterfaceC0497A) && ((InterfaceC0497A) childAt).getItemData() == oVar) {
                        view = childAt;
                        break;
                    }
                    i++;
                }
            }
            if (view != null) {
                subMenuC0502F.f5338B.getClass();
                int size = subMenuC0502F.f5405f.size();
                int i3 = 0;
                while (true) {
                    if (i3 < size) {
                        MenuItem item = subMenuC0502F.getItem(i3);
                        if (item.isVisible() && item.getIcon() != null) {
                            z3 = true;
                            break;
                        }
                        i3++;
                    } else {
                        z3 = false;
                        break;
                    }
                }
                C0540e c0540e = new C0540e(this, this.f5669b, subMenuC0502F, view);
                this.f5686w = c0540e;
                c0540e.f5468g = z3;
                l.u uVar = c0540e.i;
                if (uVar != null) {
                    uVar.n(z3);
                }
                C0540e c0540e2 = this.f5686w;
                if (!c0540e2.b()) {
                    if (c0540e2.f5466e != null) {
                        c0540e2.d(0, 0, false, false);
                    } else {
                        throw new IllegalStateException("MenuPopupHelper cannot be used without an anchor");
                    }
                }
                l.y yVar = this.f5672e;
                if (yVar != null) {
                    yVar.d(subMenuC0502F);
                }
                return true;
            }
        }
        return false;
    }

    @Override // l.z
    public final boolean j(l.o oVar) {
        return false;
    }

    public final boolean k() {
        C0540e c0540e = this.f5685v;
        if (c0540e != null && c0540e.b()) {
            return true;
        }
        return false;
    }

    public final boolean l() {
        l.m mVar;
        if (this.f5679o && !k() && (mVar = this.f5670c) != null && this.f5675k != null && this.f5687x == null) {
            mVar.i();
            if (!mVar.f5408j.isEmpty()) {
                RunnableC0544g runnableC0544g = new RunnableC0544g(this, new C0540e(this, this.f5669b, this.f5670c, this.f5676l));
                this.f5687x = runnableC0544g;
                ((View) this.f5675k).post(runnableC0544g);
                return true;
            }
            return false;
        }
        return false;
    }
}
