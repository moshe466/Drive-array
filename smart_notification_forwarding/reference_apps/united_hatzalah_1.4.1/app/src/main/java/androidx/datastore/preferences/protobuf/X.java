package androidx.datastore.preferences.protobuf;

import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Map;
import t.C0687c;
import t.C0689e;

/* loaded from: classes.dex */
public class X extends AbstractSet {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3146a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Map f3147b;

    public /* synthetic */ X(int i, Map map) {
        this.f3146a = i;
        this.f3147b = map;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean add(Object obj) {
        switch (this.f3146a) {
            case 0:
                Map.Entry entry = (Map.Entry) obj;
                if (!contains(entry)) {
                    ((U) this.f3147b).put((Comparable) entry.getKey(), entry.getValue());
                    return true;
                }
                return false;
            default:
                return super.add(obj);
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public void clear() {
        switch (this.f3146a) {
            case 0:
                ((U) this.f3147b).clear();
                return;
            default:
                super.clear();
                return;
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(Object obj) {
        switch (this.f3146a) {
            case 0:
                Map.Entry entry = (Map.Entry) obj;
                Object obj2 = ((U) this.f3147b).get(entry.getKey());
                Object value = entry.getValue();
                if (obj2 != value && (obj2 == null || !obj2.equals(value))) {
                    return false;
                }
                return true;
            default:
                return super.contains(obj);
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public Iterator iterator() {
        switch (this.f3146a) {
            case 0:
                return new W((U) this.f3147b);
            default:
                return new C0687c((C0689e) this.f3147b);
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean remove(Object obj) {
        switch (this.f3146a) {
            case 0:
                Map.Entry entry = (Map.Entry) obj;
                if (contains(entry)) {
                    ((U) this.f3147b).remove(entry.getKey());
                    return true;
                }
                return false;
            default:
                return super.remove(obj);
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        switch (this.f3146a) {
            case 0:
                return ((U) this.f3147b).size();
            default:
                return ((C0689e) this.f3147b).f6366c;
        }
    }
}
