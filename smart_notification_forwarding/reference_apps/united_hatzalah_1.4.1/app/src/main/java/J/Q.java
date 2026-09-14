package J;

import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import com.uh.sf.R;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public final class Q {

    /* renamed from: d, reason: collision with root package name */
    public static final ArrayList f950d = new ArrayList();

    /* renamed from: a, reason: collision with root package name */
    public WeakHashMap f951a;

    /* renamed from: b, reason: collision with root package name */
    public SparseArray f952b;

    /* renamed from: c, reason: collision with root package name */
    public WeakReference f953c;

    public final View a(View view) {
        int size;
        WeakHashMap weakHashMap = this.f951a;
        if (weakHashMap != null && weakHashMap.containsKey(view)) {
            if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                    View a2 = a(viewGroup.getChildAt(childCount));
                    if (a2 != null) {
                        return a2;
                    }
                }
            }
            ArrayList arrayList = (ArrayList) view.getTag(R.id.tag_unhandled_key_listeners);
            if (arrayList != null && arrayList.size() - 1 >= 0) {
                throw e0.a.b(size, arrayList);
            }
            return null;
        }
        return null;
    }
}
