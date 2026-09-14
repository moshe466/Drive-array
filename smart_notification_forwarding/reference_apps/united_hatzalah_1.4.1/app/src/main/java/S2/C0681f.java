package s2;

import java.io.Serializable;
import kotlin.jvm.internal.j;

/* renamed from: s2.f, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0681f implements Serializable {

    /* renamed from: a, reason: collision with root package name */
    public final Object f6335a;

    public static final Throwable a(Object obj) {
        if (obj instanceof C0680e) {
            return ((C0680e) obj).f6334a;
        }
        return null;
    }

    public static final boolean b(Object obj) {
        return obj instanceof C0680e;
    }

    public final /* synthetic */ Object c() {
        return this.f6335a;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof C0681f) {
            if (!j.a(this.f6335a, ((C0681f) obj).f6335a)) {
                return false;
            }
            return true;
        }
        return false;
    }

    public final int hashCode() {
        Object obj = this.f6335a;
        if (obj == null) {
            return 0;
        }
        return obj.hashCode();
    }

    public final String toString() {
        Object obj = this.f6335a;
        if (obj instanceof C0680e) {
            return ((C0680e) obj).toString();
        }
        return "Success(" + obj + ')';
    }
}
