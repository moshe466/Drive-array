package io.grpc;

import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Map;
import java.util.Set;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;

@ExperimentalApi("https://github.com/grpc/grpc-java/issues/1764")
@Immutable
/* loaded from: classes2.dex */
public final class Attributes {
    public static final Attributes EMPTY = new Attributes(Collections.emptyMap());
    static final /* synthetic */ boolean a = false;
    private final Map<Key<?>, Object> data;

    /* loaded from: classes2.dex */
    public static final class Builder {
        private Attributes base;
        private Map<Key<?>, Object> newdata;

        private Builder(Attributes attributes) {
            this.base = attributes;
        }

        private Map<Key<?>, Object> data(int i) {
            if (this.newdata == null) {
                this.newdata = new IdentityHashMap(i);
            }
            return this.newdata;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public Attributes build() {
            if (this.newdata != null) {
                for (Map.Entry entry : this.base.data.entrySet()) {
                    if (!this.newdata.containsKey(entry.getKey())) {
                        this.newdata.put(entry.getKey(), entry.getValue());
                    }
                }
                this.base = new Attributes(this.newdata);
                this.newdata = null;
            }
            return this.base;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public <T> Builder set(Key<T> key, T t) {
            data(1).put(key, t);
            return this;
        }

        public <T> Builder setAll(Attributes attributes) {
            data(attributes.data.size()).putAll(attributes.data);
            return this;
        }
    }

    @Immutable
    /* loaded from: classes2.dex */
    public static final class Key<T> {
        private final String debugString;

        private Key(String str) {
            this.debugString = str;
        }

        public static <T> Key<T> create(String str) {
            return new Key<>(str);
        }

        @Deprecated
        public static <T> Key<T> of(String str) {
            return new Key<>(str);
        }

        public String toString() {
            return this.debugString;
        }
    }

    private Attributes(Map<Key<?>, Object> map) {
        if (!a && map == null) {
            throw new AssertionError();
        }
        this.data = map;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    @Deprecated
    public static Builder newBuilder(Attributes attributes) {
        Preconditions.checkNotNull(attributes, "base");
        return new Builder();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || Attributes.class != obj.getClass()) {
            return false;
        }
        Attributes attributes = (Attributes) obj;
        if (this.data.size() != attributes.data.size()) {
            return false;
        }
        for (Map.Entry<Key<?>, Object> entry : this.data.entrySet()) {
            if (!attributes.data.containsKey(entry.getKey()) || !Objects.equal(entry.getValue(), attributes.data.get(entry.getKey()))) {
                return false;
            }
        }
        return true;
    }

    @Nullable
    public <T> T get(Key<T> key) {
        return (T) this.data.get(key);
    }

    public int hashCode() {
        int i = 0;
        for (Map.Entry<Key<?>, Object> entry : this.data.entrySet()) {
            i += Objects.hashCode(entry.getKey(), entry.getValue());
        }
        return i;
    }

    @Deprecated
    public Set<Key<?>> keys() {
        return Collections.unmodifiableSet(this.data.keySet());
    }

    public Builder toBuilder() {
        return new Builder();
    }

    public String toString() {
        return this.data.toString();
    }
}
