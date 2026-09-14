package m;

import android.view.View;
import android.widget.AdapterView;
import androidx.appcompat.widget.SearchView;

/* loaded from: classes.dex */
public final class C0 implements AdapterView.OnItemSelectedListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5516a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f5517b;

    public /* synthetic */ C0(Object obj, int i) {
        this.f5516a = i;
        this.f5517b = obj;
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public final void onItemSelected(AdapterView adapterView, View view, int i, long j2) {
        C0576w0 c0576w0;
        switch (this.f5516a) {
            case 0:
                if (i != -1 && (c0576w0 = ((I0) this.f5517b).f5536c) != null) {
                    c0576w0.setListSelectionHidden(false);
                    return;
                }
                return;
            default:
                ((SearchView) this.f5517b).n(i);
                return;
        }
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public final void onNothingSelected(AdapterView adapterView) {
        int i = this.f5516a;
    }

    private final void a(AdapterView adapterView) {
    }

    private final void b(AdapterView adapterView) {
    }
}
