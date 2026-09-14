package W0;

import com.google.android.gms.common.api.Api;

/* loaded from: classes.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    public final int f2456a;

    /* renamed from: b, reason: collision with root package name */
    public final int f2457b;

    public f(int i, int i3) {
        this.f2456a = i;
        this.f2457b = i3;
    }

    public static f a(int i) {
        return new f(i, Api.BaseClientBuilder.API_PRIORITY_OTHER);
    }

    public final String toString() {
        String str;
        StringBuilder sb = new StringBuilder("[");
        sb.append(this.f2456a);
        sb.append(", ");
        int i = this.f2457b;
        if (i < Integer.MAX_VALUE) {
            str = i + "]";
        } else {
            str = "∞)";
        }
        sb.append(str);
        return sb.toString();
    }
}
