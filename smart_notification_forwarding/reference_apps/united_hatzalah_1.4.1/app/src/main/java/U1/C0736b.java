package u1;

import A.n;
import F0.AbstractC0008a;
import android.content.Context;

/* renamed from: u1.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0736b extends c {

    /* renamed from: a, reason: collision with root package name */
    public final Context f6587a;

    /* renamed from: b, reason: collision with root package name */
    public final n f6588b;

    /* renamed from: c, reason: collision with root package name */
    public final n f6589c;

    /* renamed from: d, reason: collision with root package name */
    public final String f6590d;

    public C0736b(Context context, n nVar, n nVar2, String str) {
        if (context != null) {
            this.f6587a = context;
            if (nVar != null) {
                this.f6588b = nVar;
                if (nVar2 != null) {
                    this.f6589c = nVar2;
                    if (str != null) {
                        this.f6590d = str;
                        return;
                    }
                    throw new NullPointerException("Null backendName");
                }
                throw new NullPointerException("Null monotonicClock");
            }
            throw new NullPointerException("Null wallClock");
        }
        throw new NullPointerException("Null applicationContext");
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof c) {
            c cVar = (c) obj;
            if (this.f6587a.equals(((C0736b) cVar).f6587a)) {
                C0736b c0736b = (C0736b) cVar;
                if (this.f6588b.equals(c0736b.f6588b) && this.f6589c.equals(c0736b.f6589c) && this.f6590d.equals(c0736b.f6590d)) {
                    return true;
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        return ((((((this.f6587a.hashCode() ^ 1000003) * 1000003) ^ this.f6588b.hashCode()) * 1000003) ^ this.f6589c.hashCode()) * 1000003) ^ this.f6590d.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("CreationContext{applicationContext=");
        sb.append(this.f6587a);
        sb.append(", wallClock=");
        sb.append(this.f6588b);
        sb.append(", monotonicClock=");
        sb.append(this.f6589c);
        sb.append(", backendName=");
        return AbstractC0008a.u(sb, this.f6590d, "}");
    }
}
