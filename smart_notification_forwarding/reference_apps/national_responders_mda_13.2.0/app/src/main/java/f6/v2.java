package f6;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import com.groboot.mdaemergency.models.Feature;
import com.groboot.mdaemergency.models.ShortcutButtons;
import com.groboot.mdaemergency.ui.views.DynamicGridView;
import il.org.mda.health.R;
import java.util.List;

/* loaded from: classes.dex */
public class v2 extends androidx.fragment.app.e {

    /* renamed from: u0, reason: collision with root package name */
    Context f9610u0;

    /* renamed from: v0, reason: collision with root package name */
    ShortcutButtons f9611v0;

    /* renamed from: w0, reason: collision with root package name */
    DynamicGridView.c f9612w0;

    /* renamed from: x0, reason: collision with root package name */
    DynamicGridView f9613x0;

    /* renamed from: y0, reason: collision with root package name */
    View f9614y0;

    /* loaded from: classes.dex */
    class a implements DynamicGridView.c {
        a() {
        }

        @Override // com.groboot.mdaemergency.ui.views.DynamicGridView.c
        public void a(List<Feature> list) {
            w6.m.C0(ShortcutButtons.saveToLocalData(v2.this.f9611v0));
            v2 v2Var = v2.this;
            DynamicGridView.c cVar = v2Var.f9612w0;
            if (cVar != null) {
                cVar.a(v2Var.f9611v0);
            }
        }

        @Override // com.groboot.mdaemergency.ui.views.DynamicGridView.c
        public void b(int i10) {
            v2.this.f9611v0.addEmptyItemIfNeeded(i10);
        }
    }

    public v2() {
    }

    @SuppressLint({"ValidFragment"})
    public v2(DynamicGridView.c cVar) {
        this.f9612w0 = cVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void k2(View view) {
        W1();
    }

    @Override // androidx.fragment.app.Fragment
    public View F0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        super.B0(bundle);
        View inflate = LayoutInflater.from(this.f9610u0).inflate(R.layout.fragment_shortcut_buttons, (ViewGroup) null, false);
        this.f9614y0 = inflate;
        this.f9613x0 = (DynamicGridView) inflate.findViewById(R.id.gv_buttons);
        this.f9614y0.findViewById(R.id.img_close).setOnClickListener(new View.OnClickListener() { // from class: f6.u2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                v2.this.k2(view);
            }
        });
        this.f9611v0 = new ShortcutButtons(this.f9610u0);
        if (w6.m.N() == 0 || w6.m.L() == null) {
            this.f9611v0.addEmptyItemIfNeeded(0);
        }
        this.f9611v0.sortByShortcutId(w6.m.L());
        this.f9613x0.setAdapter((ListAdapter) new c6.v(A(), this.f9611v0, true, this.f9612w0));
        this.f9613x0.setColumnWidth(-1);
        this.f9613x0.setStretchMode(2);
        this.f9613x0.setCallback(new a());
        w6.m.D0(true);
        return this.f9614y0;
    }

    @Override // androidx.fragment.app.Fragment
    public void W0() {
        super.W0();
        Dialog Z1 = Z1();
        if (Z1 != null) {
            Z1.getWindow().setLayout(-1, -2);
        }
    }

    @Override // androidx.fragment.app.e, androidx.fragment.app.Fragment
    public void y0(Context context) {
        super.y0(context);
        this.f9610u0 = context;
    }
}
