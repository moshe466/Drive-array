package m;

import android.content.Context;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.appcompat.widget.Toolbar;
import java.util.ArrayList;
import k.InterfaceC0459c;
import l.SubMenuC0502F;

/* loaded from: classes.dex */
public final class n1 implements l.z {

    /* renamed from: a, reason: collision with root package name */
    public l.m f5730a;

    /* renamed from: b, reason: collision with root package name */
    public l.o f5731b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Toolbar f5732c;

    public n1(Toolbar toolbar) {
        this.f5732c = toolbar;
    }

    @Override // l.z
    public final boolean c(l.o oVar) {
        Toolbar toolbar = this.f5732c;
        toolbar.c();
        ViewParent parent = toolbar.f2993k.getParent();
        if (parent != toolbar) {
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(toolbar.f2993k);
            }
            toolbar.addView(toolbar.f2993k);
        }
        View actionView = oVar.getActionView();
        toolbar.f2994l = actionView;
        this.f5731b = oVar;
        ViewParent parent2 = actionView.getParent();
        if (parent2 != toolbar) {
            if (parent2 instanceof ViewGroup) {
                ((ViewGroup) parent2).removeView(toolbar.f2994l);
            }
            o1 h2 = Toolbar.h();
            h2.f5742a = (toolbar.f2998q & 112) | 8388611;
            h2.f5743b = 2;
            toolbar.f2994l.setLayoutParams(h2);
            toolbar.addView(toolbar.f2994l);
        }
        for (int childCount = toolbar.getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = toolbar.getChildAt(childCount);
            if (((o1) childAt.getLayoutParams()).f5743b != 2 && childAt != toolbar.f2986a) {
                toolbar.removeViewAt(childCount);
                toolbar.f2970H.add(childAt);
            }
        }
        toolbar.requestLayout();
        oVar.f5427C = true;
        oVar.f5440n.p(false);
        KeyEvent.Callback callback = toolbar.f2994l;
        if (callback instanceof InterfaceC0459c) {
            ((InterfaceC0459c) callback).onActionViewExpanded();
        }
        toolbar.v();
        return true;
    }

    @Override // l.z
    public final boolean d() {
        return false;
    }

    @Override // l.z
    public final void e() {
        if (this.f5731b != null) {
            l.m mVar = this.f5730a;
            if (mVar != null) {
                int size = mVar.f5405f.size();
                for (int i = 0; i < size; i++) {
                    if (this.f5730a.getItem(i) == this.f5731b) {
                        return;
                    }
                }
            }
            j(this.f5731b);
        }
    }

    @Override // l.z
    public final void h(Context context, l.m mVar) {
        l.o oVar;
        l.m mVar2 = this.f5730a;
        if (mVar2 != null && (oVar = this.f5731b) != null) {
            mVar2.d(oVar);
        }
        this.f5730a = mVar;
    }

    @Override // l.z
    public final boolean i(SubMenuC0502F subMenuC0502F) {
        return false;
    }

    @Override // l.z
    public final boolean j(l.o oVar) {
        Toolbar toolbar = this.f5732c;
        KeyEvent.Callback callback = toolbar.f2994l;
        if (callback instanceof InterfaceC0459c) {
            ((InterfaceC0459c) callback).onActionViewCollapsed();
        }
        toolbar.removeView(toolbar.f2994l);
        toolbar.removeView(toolbar.f2993k);
        toolbar.f2994l = null;
        ArrayList arrayList = toolbar.f2970H;
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            toolbar.addView((View) arrayList.get(size));
        }
        arrayList.clear();
        this.f5731b = null;
        toolbar.requestLayout();
        oVar.f5427C = false;
        oVar.f5440n.p(false);
        toolbar.v();
        return true;
    }

    @Override // l.z
    public final void b(l.m mVar, boolean z3) {
    }
}
