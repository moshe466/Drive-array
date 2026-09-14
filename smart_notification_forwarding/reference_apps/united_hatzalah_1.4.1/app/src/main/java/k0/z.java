package k0;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
public final class z {

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList f5279a;

    /* renamed from: b, reason: collision with root package name */
    public final ArrayList f5280b;

    /* renamed from: c, reason: collision with root package name */
    public final List f5281c;

    /* renamed from: d, reason: collision with root package name */
    public int f5282d;

    /* renamed from: e, reason: collision with root package name */
    public int f5283e;

    /* renamed from: f, reason: collision with root package name */
    public y f5284f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ RecyclerView f5285g;

    public z(RecyclerView recyclerView) {
        this.f5285g = recyclerView;
        ArrayList arrayList = new ArrayList();
        this.f5279a = arrayList;
        this.f5280b = new ArrayList();
        this.f5281c = Collections.unmodifiableList(arrayList);
        this.f5282d = 2;
        this.f5283e = 2;
    }

    public final void a(int i) {
        RecyclerView recyclerView = this.f5285g;
        C0472C c0472c = recyclerView.f3699a0;
        if (i >= 0 && i < c0472c.a()) {
            boolean z3 = c0472c.f5166c;
            ArrayList arrayList = this.f5279a;
            if (arrayList.size() <= 0) {
                ArrayList arrayList2 = (ArrayList) recyclerView.f3704d.f471d;
                if (arrayList2.size() <= 0) {
                    ArrayList arrayList3 = this.f5280b;
                    if (arrayList3.size() <= 0) {
                        int k4 = recyclerView.f3702c.k(i, 0);
                        if (k4 >= 0) {
                            throw null;
                        }
                        throw new IndexOutOfBoundsException("Inconsistency detected. Invalid item position " + i + "(offset:" + k4 + ").state:" + c0472c.a() + recyclerView.h());
                    }
                    throw e0.a.b(0, arrayList3);
                }
                RecyclerView.j((View) arrayList2.get(0));
                throw null;
            }
            throw e0.a.b(0, arrayList);
        }
        throw new IndexOutOfBoundsException("Invalid item position " + i + "(" + i + "). Item count:" + c0472c.a() + recyclerView.h());
    }

    public final void b() {
        this.f5283e = this.f5282d;
        ArrayList arrayList = this.f5280b;
        int size = arrayList.size() - 1;
        if (size >= 0 && arrayList.size() > this.f5283e) {
            if (arrayList.get(size) == null) {
                int[] iArr = RecyclerView.f3671k0;
                throw null;
            }
            throw new ClassCastException();
        }
    }
}
