package h;

import android.content.DialogInterface;
import android.view.View;
import android.widget.AdapterView;

/* renamed from: h.d, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0434d implements AdapterView.OnItemClickListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ C0437g f4781a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ C0435e f4782b;

    public C0434d(C0435e c0435e, C0437g c0437g) {
        this.f4782b = c0435e;
        this.f4781a = c0437g;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public final void onItemClick(AdapterView adapterView, View view, int i, long j2) {
        C0435e c0435e = this.f4782b;
        DialogInterface.OnClickListener onClickListener = c0435e.f4795n;
        C0437g c0437g = this.f4781a;
        onClickListener.onClick(c0437g.f4805b, i);
        if (!c0435e.p) {
            c0437g.f4805b.dismiss();
        }
    }
}
