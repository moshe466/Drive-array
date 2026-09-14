package q0;

import android.view.View;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class j implements p {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ View f6087a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ArrayList f6088b;

    public j(View view, ArrayList arrayList) {
        this.f6087a = view;
        this.f6088b = arrayList;
    }

    @Override // q0.p
    public final void a(q qVar) {
        qVar.w(this);
        qVar.a(this);
    }

    @Override // q0.p
    public final void e(q qVar) {
        qVar.w(this);
        this.f6087a.setVisibility(8);
        ArrayList arrayList = this.f6088b;
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            ((View) arrayList.get(i)).setVisibility(0);
        }
    }

    @Override // q0.p
    public final void b() {
    }

    @Override // q0.p
    public final void c() {
    }

    @Override // q0.p
    public final void d() {
    }
}
