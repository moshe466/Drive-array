package l4;

import java.util.Collections;
import java.util.Map;

/* loaded from: classes.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    private final String f11783a;

    /* renamed from: b, reason: collision with root package name */
    private final Map<Class<?>, Object> f11784b;

    private c(String str, Map<Class<?>, Object> map) {
        this.f11783a = str;
        this.f11784b = map;
    }

    public static c b(String str) {
        return new c(str, Collections.emptyMap());
    }

    public String a() {
        return this.f11783a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        return this.f11783a.equals(cVar.f11783a) && this.f11784b.equals(cVar.f11784b);
    }

    public int hashCode() {
        return (this.f11783a.hashCode() * 31) + this.f11784b.hashCode();
    }

    public String toString() {
        return "FieldDescriptor{name=" + this.f11783a + ", properties=" + this.f11784b.values() + "}";
    }
}
