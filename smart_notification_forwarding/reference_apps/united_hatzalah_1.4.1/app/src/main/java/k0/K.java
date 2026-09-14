package k0;

import android.view.View;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class K {

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList f5192a = new ArrayList();

    /* renamed from: b, reason: collision with root package name */
    public int f5193b = Integer.MIN_VALUE;

    /* renamed from: c, reason: collision with root package name */
    public int f5194c = Integer.MIN_VALUE;

    /* renamed from: d, reason: collision with root package name */
    public final int f5195d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ StaggeredGridLayoutManager f5196e;

    public K(StaggeredGridLayoutManager staggeredGridLayoutManager, int i) {
        this.f5196e = staggeredGridLayoutManager;
        this.f5195d = i;
    }

    public final int a(int i) {
        int i3 = this.f5194c;
        if (i3 != Integer.MIN_VALUE) {
            return i3;
        }
        if (this.f5192a.size() == 0) {
            return i;
        }
        View view = (View) this.f5192a.get(r3.size() - 1);
        H h2 = (H) view.getLayoutParams();
        this.f5194c = this.f5196e.f3730j.h(view);
        h2.getClass();
        return this.f5194c;
    }
}
