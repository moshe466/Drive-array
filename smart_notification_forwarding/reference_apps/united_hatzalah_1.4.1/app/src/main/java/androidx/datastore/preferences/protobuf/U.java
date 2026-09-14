package androidx.datastore.preferences.protobuf;

import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

/* loaded from: classes.dex */
public final class U extends AbstractMap {

    /* renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ int f3133f = 0;

    /* renamed from: a, reason: collision with root package name */
    public List f3134a;

    /* renamed from: b, reason: collision with root package name */
    public Map f3135b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f3136c;

    /* renamed from: d, reason: collision with root package name */
    public volatile X f3137d;

    /* renamed from: e, reason: collision with root package name */
    public Map f3138e;

    /* JADX WARN: Type inference failed for: r0v0, types: [java.util.AbstractMap, androidx.datastore.preferences.protobuf.U] */
    public static U f() {
        ?? abstractMap = new AbstractMap();
        abstractMap.f3134a = Collections.EMPTY_LIST;
        Map map = Collections.EMPTY_MAP;
        abstractMap.f3135b = map;
        abstractMap.f3138e = map;
        return abstractMap;
    }

    public final int a(Comparable comparable) {
        int i;
        int size = this.f3134a.size();
        int i3 = size - 1;
        if (i3 >= 0) {
            int compareTo = comparable.compareTo(((V) this.f3134a.get(i3)).f3139a);
            if (compareTo > 0) {
                i = size + 1;
                return -i;
            }
            if (compareTo == 0) {
                return i3;
            }
        }
        int i4 = 0;
        while (i4 <= i3) {
            int i5 = (i4 + i3) / 2;
            int compareTo2 = comparable.compareTo(((V) this.f3134a.get(i5)).f3139a);
            if (compareTo2 < 0) {
                i3 = i5 - 1;
            } else if (compareTo2 > 0) {
                i4 = i5 + 1;
            } else {
                return i5;
            }
        }
        i = i4 + 1;
        return -i;
    }

    public final void b() {
        if (!this.f3136c) {
        } else {
            throw new UnsupportedOperationException();
        }
    }

    public final Map.Entry c(int i) {
        return (Map.Entry) this.f3134a.get(i);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final void clear() {
        b();
        if (!this.f3134a.isEmpty()) {
            this.f3134a.clear();
        }
        if (!this.f3135b.isEmpty()) {
            this.f3135b.clear();
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean containsKey(Object obj) {
        Comparable comparable = (Comparable) obj;
        if (a(comparable) < 0 && !this.f3135b.containsKey(comparable)) {
            return false;
        }
        return true;
    }

    public final Set d() {
        if (this.f3135b.isEmpty()) {
            return Collections.EMPTY_SET;
        }
        return this.f3135b.entrySet();
    }

    public final SortedMap e() {
        b();
        if (this.f3135b.isEmpty() && !(this.f3135b instanceof TreeMap)) {
            TreeMap treeMap = new TreeMap();
            this.f3135b = treeMap;
            this.f3138e = treeMap.descendingMap();
        }
        return (SortedMap) this.f3135b;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Set entrySet() {
        if (this.f3137d == null) {
            this.f3137d = new X(0, this);
        }
        return this.f3137d;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean equals(Object obj) {
        if (this != obj) {
            if (!(obj instanceof U)) {
                return super.equals(obj);
            }
            U u3 = (U) obj;
            int size = size();
            if (size == u3.size()) {
                int size2 = this.f3134a.size();
                if (size2 != u3.f3134a.size()) {
                    return ((AbstractSet) entrySet()).equals(u3.entrySet());
                }
                for (int i = 0; i < size2; i++) {
                    if (c(i).equals(u3.c(i))) {
                    }
                }
                if (size2 != size) {
                    return this.f3135b.equals(u3.f3135b);
                }
                return true;
            }
            return false;
        }
        return true;
    }

    @Override // java.util.AbstractMap, java.util.Map
    /* renamed from: g, reason: merged with bridge method [inline-methods] */
    public final Object put(Comparable comparable, Object obj) {
        b();
        int a2 = a(comparable);
        if (a2 >= 0) {
            return ((V) this.f3134a.get(a2)).setValue(obj);
        }
        b();
        if (this.f3134a.isEmpty() && !(this.f3134a instanceof ArrayList)) {
            this.f3134a = new ArrayList(16);
        }
        int i = -(a2 + 1);
        if (i >= 16) {
            return e().put(comparable, obj);
        }
        if (this.f3134a.size() == 16) {
            V v2 = (V) this.f3134a.remove(15);
            e().put(v2.f3139a, v2.f3140b);
        }
        this.f3134a.add(i, new V(this, comparable, obj));
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Object get(Object obj) {
        Comparable comparable = (Comparable) obj;
        int a2 = a(comparable);
        if (a2 >= 0) {
            return ((V) this.f3134a.get(a2)).f3140b;
        }
        return this.f3135b.get(comparable);
    }

    public final Object h(int i) {
        b();
        Object obj = ((V) this.f3134a.remove(i)).f3140b;
        if (!this.f3135b.isEmpty()) {
            Iterator it = e().entrySet().iterator();
            List list = this.f3134a;
            Map.Entry entry = (Map.Entry) it.next();
            list.add(new V(this, (Comparable) entry.getKey(), entry.getValue()));
            it.remove();
        }
        return obj;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final int hashCode() {
        int size = this.f3134a.size();
        int i = 0;
        for (int i3 = 0; i3 < size; i3++) {
            i += ((V) this.f3134a.get(i3)).hashCode();
        }
        if (this.f3135b.size() > 0) {
            return this.f3135b.hashCode() + i;
        }
        return i;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Object remove(Object obj) {
        b();
        Comparable comparable = (Comparable) obj;
        int a2 = a(comparable);
        if (a2 >= 0) {
            return h(a2);
        }
        if (this.f3135b.isEmpty()) {
            return null;
        }
        return this.f3135b.remove(comparable);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final int size() {
        return this.f3135b.size() + this.f3134a.size();
    }
}
