package m;

import android.view.View;
import android.widget.AdapterView;
import androidx.appcompat.widget.SearchView;

/* loaded from: classes.dex */
public final class M implements AdapterView.OnItemClickListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5561a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f5562b;

    public /* synthetic */ M(Object obj, int i) {
        this.f5561a = i;
        this.f5562b = obj;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public final void onItemClick(AdapterView adapterView, View view, int i, long j2) {
        switch (this.f5561a) {
            case 0:
                O o2 = (O) this.f5562b;
                S s3 = o2.f5572I;
                s3.setSelection(i);
                if (s3.getOnItemClickListener() != null) {
                    s3.performItemClick(view, i, o2.f5569F.getItemId(i));
                }
                o2.dismiss();
                return;
            default:
                ((SearchView) this.f5562b).m(i);
                return;
        }
    }
}
