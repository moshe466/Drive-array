package kotlin.reflect.jvm.internal.impl.protobuf;

import java.util.Iterator;
import java.util.Map;

/* loaded from: classes.dex */
public class l extends m {

    /* renamed from: e, reason: collision with root package name */
    private final q f11440e;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class b<K> implements Map.Entry<K, Object> {

        /* renamed from: f, reason: collision with root package name */
        private Map.Entry<K, l> f11441f;

        private b(Map.Entry<K, l> entry) {
            this.f11441f = entry;
        }

        @Override // java.util.Map.Entry
        public K getKey() {
            return this.f11441f.getKey();
        }

        @Override // java.util.Map.Entry
        public Object getValue() {
            l value = this.f11441f.getValue();
            if (value == null) {
                return null;
            }
            return value.e();
        }

        @Override // java.util.Map.Entry
        public Object setValue(Object obj) {
            if (obj instanceof q) {
                return this.f11441f.getValue().d((q) obj);
            }
            throw new IllegalArgumentException("LazyField now only used for MessageSet, and the value of MessageSet must be an instance of MessageLite");
        }
    }

    /* loaded from: classes.dex */
    static class c<K> implements Iterator<Map.Entry<K, Object>> {

        /* renamed from: f, reason: collision with root package name */
        private Iterator<Map.Entry<K, Object>> f11442f;

        public c(Iterator<Map.Entry<K, Object>> it) {
            this.f11442f = it;
        }

        @Override // java.util.Iterator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public Map.Entry<K, Object> next() {
            Map.Entry<K, Object> next = this.f11442f.next();
            return next.getValue() instanceof l ? new b(next) : next;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f11442f.hasNext();
        }

        @Override // java.util.Iterator
        public void remove() {
            this.f11442f.remove();
        }
    }

    public q e() {
        return c(this.f11440e);
    }

    public boolean equals(Object obj) {
        return e().equals(obj);
    }

    public int hashCode() {
        return e().hashCode();
    }

    public String toString() {
        return e().toString();
    }
}
