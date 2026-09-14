package J0;

import java.util.List;
import kotlin.jvm.internal.j;

/* loaded from: classes.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public final b f1045a;

    /* renamed from: b, reason: collision with root package name */
    public final List f1046b;

    /* renamed from: c, reason: collision with root package name */
    public final List f1047c;

    public c(b bVar, List list, List list2) {
        this.f1045a = bVar;
        this.f1046b = list;
        this.f1047c = list2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        if (j.a(this.f1045a, cVar.f1045a) && j.a(this.f1046b, cVar.f1046b) && j.a(this.f1047c, cVar.f1047c)) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        int hashCode;
        int hashCode2 = (this.f1046b.hashCode() + (this.f1045a.hashCode() * 31)) * 31;
        List list = this.f1047c;
        if (list == null) {
            hashCode = 0;
        } else {
            hashCode = list.hashCode();
        }
        return hashCode2 + hashCode;
    }

    public final String toString() {
        return "SuspiciousAppInfo(packageInfo=" + this.f1045a + ", reasons=" + this.f1046b + ", permissions=" + this.f1047c + ")";
    }
}
