package P;

import android.database.DataSetObserver;
import m.I0;
import m.f1;

/* loaded from: classes.dex */
public final class b extends DataSetObserver {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1550a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f1551b;

    public /* synthetic */ b(Object obj, int i) {
        this.f1550a = i;
        this.f1551b = obj;
    }

    @Override // android.database.DataSetObserver
    public final void onChanged() {
        switch (this.f1550a) {
            case 0:
                f1 f1Var = (f1) this.f1551b;
                f1Var.f1552a = true;
                f1Var.notifyDataSetChanged();
                return;
            default:
                I0 i02 = (I0) this.f1551b;
                if (i02.f5533B.isShowing()) {
                    i02.show();
                    return;
                }
                return;
        }
    }

    @Override // android.database.DataSetObserver
    public final void onInvalidated() {
        switch (this.f1550a) {
            case 0:
                f1 f1Var = (f1) this.f1551b;
                f1Var.f1552a = false;
                f1Var.notifyDataSetInvalidated();
                return;
            default:
                ((I0) this.f1551b).dismiss();
                return;
        }
    }
}
