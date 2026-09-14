package i1;

import java.util.Objects;

/* loaded from: classes.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    private final String f10721a;

    private b(String str) {
        Objects.requireNonNull(str, "name is null");
        this.f10721a = str;
    }

    public static b b(String str) {
        return new b(str);
    }

    public String a() {
        return this.f10721a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof b) {
            return this.f10721a.equals(((b) obj).f10721a);
        }
        return false;
    }

    public int hashCode() {
        return this.f10721a.hashCode() ^ 1000003;
    }

    public String toString() {
        return "Encoding{name=\"" + this.f10721a + "\"}";
    }
}
