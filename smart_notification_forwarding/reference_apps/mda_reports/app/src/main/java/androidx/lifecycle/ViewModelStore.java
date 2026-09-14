package androidx.lifecycle;

import java.util.HashMap;
import java.util.Iterator;

/* loaded from: classes.dex */
public class ViewModelStore {
    private final HashMap<String, ViewModel> mMap = new HashMap<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    public final ViewModel a(String str) {
        return this.mMap.get(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(String str, ViewModel viewModel) {
        ViewModel put = this.mMap.put(str, viewModel);
        if (put != null) {
            put.b();
        }
    }

    public final void clear() {
        Iterator<ViewModel> it = this.mMap.values().iterator();
        while (it.hasNext()) {
            it.next().a();
        }
        this.mMap.clear();
    }
}
