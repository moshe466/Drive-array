package K2;

import kotlin.jvm.internal.j;

/* loaded from: classes.dex */
public final class c extends a {
    static {
        new a((char) 1, (char) 0);
    }

    public final boolean equals(Object obj) {
        if (obj instanceof c) {
            char c4 = this.f1111a;
            char c5 = this.f1112b;
            if (j.f(c4, c5) > 0) {
                c cVar = (c) obj;
                if (j.f(cVar.f1111a, cVar.f1112b) > 0) {
                    return true;
                }
            }
            c cVar2 = (c) obj;
            if (c4 == cVar2.f1111a && c5 == cVar2.f1112b) {
                return true;
            }
            return false;
        }
        return false;
    }

    public final int hashCode() {
        char c4 = this.f1111a;
        char c5 = this.f1112b;
        if (j.f(c4, c5) > 0) {
            return -1;
        }
        return (c4 * 31) + c5;
    }

    public final String toString() {
        return this.f1111a + ".." + this.f1112b;
    }
}
