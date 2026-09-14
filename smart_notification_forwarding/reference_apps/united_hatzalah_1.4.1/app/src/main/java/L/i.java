package l;

import F0.C0092v0;
import android.content.Context;
import android.content.ContextWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import androidx.appcompat.view.menu.ExpandedMenuView;
import h.C0435e;
import h.DialogInterfaceC0438h;

/* loaded from: classes.dex */
public final class i implements z, AdapterView.OnItemClickListener {

    /* renamed from: a, reason: collision with root package name */
    public Context f5387a;

    /* renamed from: b, reason: collision with root package name */
    public LayoutInflater f5388b;

    /* renamed from: c, reason: collision with root package name */
    public m f5389c;

    /* renamed from: d, reason: collision with root package name */
    public ExpandedMenuView f5390d;

    /* renamed from: e, reason: collision with root package name */
    public y f5391e;

    /* renamed from: f, reason: collision with root package name */
    public C0510h f5392f;

    public i(ContextWrapper contextWrapper) {
        this.f5387a = contextWrapper;
        this.f5388b = LayoutInflater.from(contextWrapper);
    }

    @Override // l.z
    public final void b(m mVar, boolean z3) {
        y yVar = this.f5391e;
        if (yVar != null) {
            yVar.b(mVar, z3);
        }
    }

    @Override // l.z
    public final boolean c(o oVar) {
        return false;
    }

    @Override // l.z
    public final boolean d() {
        return false;
    }

    @Override // l.z
    public final void e() {
        C0510h c0510h = this.f5392f;
        if (c0510h != null) {
            c0510h.notifyDataSetChanged();
        }
    }

    @Override // l.z
    public final void f(y yVar) {
        throw null;
    }

    @Override // l.z
    public final void h(Context context, m mVar) {
        if (this.f5387a != null) {
            this.f5387a = context;
            if (this.f5388b == null) {
                this.f5388b = LayoutInflater.from(context);
            }
        }
        this.f5389c = mVar;
        C0510h c0510h = this.f5392f;
        if (c0510h != null) {
            c0510h.notifyDataSetChanged();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [android.content.DialogInterface$OnClickListener, l.y, java.lang.Object, l.n, android.content.DialogInterface$OnDismissListener] */
    @Override // l.z
    public final boolean i(SubMenuC0502F subMenuC0502F) {
        boolean hasVisibleItems = subMenuC0502F.hasVisibleItems();
        Context context = subMenuC0502F.f5400a;
        if (!hasVisibleItems) {
            return false;
        }
        ?? obj = new Object();
        obj.f5422a = subMenuC0502F;
        C0092v0 c0092v0 = new C0092v0(context);
        C0435e c0435e = (C0435e) c0092v0.f693b;
        i iVar = new i(c0435e.f4783a);
        obj.f5424c = iVar;
        iVar.f5391e = obj;
        subMenuC0502F.b(iVar, context);
        i iVar2 = obj.f5424c;
        if (iVar2.f5392f == null) {
            iVar2.f5392f = new C0510h(iVar2);
        }
        c0435e.f4794m = iVar2.f5392f;
        c0435e.f4795n = obj;
        View view = subMenuC0502F.f5413o;
        if (view != null) {
            c0435e.f4787e = view;
        } else {
            c0435e.f4785c = subMenuC0502F.f5412n;
            c0435e.f4786d = subMenuC0502F.f5411m;
        }
        c0435e.f4793l = obj;
        DialogInterfaceC0438h b4 = c0092v0.b();
        obj.f5423b = b4;
        b4.setOnDismissListener(obj);
        WindowManager.LayoutParams attributes = obj.f5423b.getWindow().getAttributes();
        attributes.type = 1003;
        attributes.flags |= 131072;
        obj.f5423b.show();
        y yVar = this.f5391e;
        if (yVar != null) {
            yVar.d(subMenuC0502F);
            return true;
        }
        return true;
    }

    @Override // l.z
    public final boolean j(o oVar) {
        return false;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public final void onItemClick(AdapterView adapterView, View view, int i, long j2) {
        this.f5389c.q(this.f5392f.getItem(i), this, 0);
    }
}
