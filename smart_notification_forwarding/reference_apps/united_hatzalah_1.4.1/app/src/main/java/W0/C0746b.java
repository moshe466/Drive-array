package w0;

import F0.AbstractC0008a;
import android.graphics.Rect;
import kotlin.jvm.internal.j;

/* renamed from: w0.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0746b {

    /* renamed from: a, reason: collision with root package name */
    public final int f6682a;

    /* renamed from: b, reason: collision with root package name */
    public final int f6683b;

    /* renamed from: c, reason: collision with root package name */
    public final int f6684c;

    /* renamed from: d, reason: collision with root package name */
    public final int f6685d;

    public C0746b(Rect rect) {
        int i = rect.left;
        int i3 = rect.top;
        int i4 = rect.right;
        int i5 = rect.bottom;
        this.f6682a = i;
        this.f6683b = i3;
        this.f6684c = i4;
        this.f6685d = i5;
        if (i <= i4) {
            if (i3 <= i5) {
                return;
            } else {
                throw new IllegalArgumentException(AbstractC0008a.k("top must be less than or equal to bottom, top: ", i3, i5, ", bottom: ").toString());
            }
        }
        throw new IllegalArgumentException(AbstractC0008a.k("Left must be less than or equal to right, left: ", i, i4, ", right: ").toString());
    }

    public final Rect a() {
        return new Rect(this.f6682a, this.f6683b, this.f6684c, this.f6685d);
    }

    public final boolean equals(Object obj) {
        Class<?> cls;
        if (this == obj) {
            return true;
        }
        if (obj != null) {
            cls = obj.getClass();
        } else {
            cls = null;
        }
        if (!C0746b.class.equals(cls)) {
            return false;
        }
        j.c(obj, "null cannot be cast to non-null type androidx.window.core.Bounds");
        C0746b c0746b = (C0746b) obj;
        if (this.f6682a == c0746b.f6682a && this.f6683b == c0746b.f6683b && this.f6684c == c0746b.f6684c && this.f6685d == c0746b.f6685d) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return (((((this.f6682a * 31) + this.f6683b) * 31) + this.f6684c) * 31) + this.f6685d;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(C0746b.class.getSimpleName());
        sb.append(" { [");
        sb.append(this.f6682a);
        sb.append(',');
        sb.append(this.f6683b);
        sb.append(',');
        sb.append(this.f6684c);
        sb.append(',');
        return AbstractC0008a.r(sb, this.f6685d, "] }");
    }
}
