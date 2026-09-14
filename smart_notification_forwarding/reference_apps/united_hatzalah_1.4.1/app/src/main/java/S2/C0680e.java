package s2;

import java.io.Serializable;
import kotlin.jvm.internal.j;

/* renamed from: s2.e, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0680e implements Serializable {

    /* renamed from: a, reason: collision with root package name */
    public final Throwable f6334a;

    public C0680e(Throwable exception) {
        j.e(exception, "exception");
        this.f6334a = exception;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof C0680e) {
            if (j.a(this.f6334a, ((C0680e) obj).f6334a)) {
                return true;
            }
            return false;
        }
        return false;
    }

    public final int hashCode() {
        return this.f6334a.hashCode();
    }

    public final String toString() {
        return "Failure(" + this.f6334a + ')';
    }
}
