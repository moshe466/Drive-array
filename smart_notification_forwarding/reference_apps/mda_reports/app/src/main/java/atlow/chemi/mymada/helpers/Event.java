package atlow.chemi.mymada.helpers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public final class Event<T> {
    private Map<String, T> namedListeners = new HashMap();
    private List<T> anonymousListeners = new ArrayList();

    public void addListener(T t) {
        this.anonymousListeners.add(t);
    }

    public void addListener(String str, T t) {
        if (this.namedListeners.containsKey(str)) {
            return;
        }
        this.namedListeners.put(str, t);
    }

    public List<T> listeners() {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(this.namedListeners.values());
        arrayList.addAll(this.anonymousListeners);
        return arrayList;
    }

    public void removeListener(String str) {
        this.namedListeners.remove(str);
    }
}
