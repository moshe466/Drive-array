package t0;

import java.util.Objects;

/* loaded from: classes.dex */
public final class n {

    /* renamed from: a, reason: collision with root package name */
    public final p[] f6378a;

    /* renamed from: b, reason: collision with root package name */
    public final String f6379b;

    /* renamed from: c, reason: collision with root package name */
    public final byte[] f6380c;

    /* renamed from: d, reason: collision with root package name */
    public final int f6381d;

    public n(String str, p[] pVarArr) {
        this.f6379b = str;
        this.f6380c = null;
        this.f6378a = pVarArr;
        this.f6381d = 0;
    }

    public final void a(int i) {
        String str;
        int i3 = this.f6381d;
        if (i == i3) {
            return;
        }
        StringBuilder sb = new StringBuilder("Wrong data accessor type detected. ");
        String str2 = "String";
        if (i3 == 0) {
            str = "String";
        } else if (i3 == 1) {
            str = "ArrayBuffer";
        } else {
            str = "Unknown";
        }
        sb.append(str);
        sb.append(" expected, but got ");
        if (i != 0) {
            if (i == 1) {
                str2 = "ArrayBuffer";
            } else {
                str2 = "Unknown";
            }
        }
        sb.append(str2);
        throw new IllegalStateException(sb.toString());
    }

    public n(byte[] bArr, p[] pVarArr) {
        Objects.requireNonNull(bArr);
        this.f6380c = bArr;
        this.f6379b = null;
        this.f6378a = pVarArr;
        this.f6381d = 1;
    }
}
