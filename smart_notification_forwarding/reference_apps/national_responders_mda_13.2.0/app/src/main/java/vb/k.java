package vb;

import java.net.ProtocolException;
import okhttp3.w;

/* loaded from: classes.dex */
public final class k {

    /* renamed from: a, reason: collision with root package name */
    public final w f14875a;

    /* renamed from: b, reason: collision with root package name */
    public final int f14876b;

    /* renamed from: c, reason: collision with root package name */
    public final String f14877c;

    public k(w wVar, int i10, String str) {
        this.f14875a = wVar;
        this.f14876b = i10;
        this.f14877c = str;
    }

    public static k a(String str) {
        w wVar;
        String str2;
        int i10 = 9;
        if (str.startsWith("HTTP/1.")) {
            if (str.length() < 9 || str.charAt(8) != ' ') {
                throw new ProtocolException("Unexpected status line: " + str);
            }
            int charAt = str.charAt(7) - '0';
            if (charAt == 0) {
                wVar = w.HTTP_1_0;
            } else {
                if (charAt != 1) {
                    throw new ProtocolException("Unexpected status line: " + str);
                }
                wVar = w.HTTP_1_1;
            }
        } else {
            if (!str.startsWith("ICY ")) {
                throw new ProtocolException("Unexpected status line: " + str);
            }
            wVar = w.HTTP_1_0;
            i10 = 4;
        }
        int i11 = i10 + 3;
        if (str.length() < i11) {
            throw new ProtocolException("Unexpected status line: " + str);
        }
        try {
            int parseInt = Integer.parseInt(str.substring(i10, i11));
            if (str.length() <= i11) {
                str2 = "";
            } else {
                if (str.charAt(i11) != ' ') {
                    throw new ProtocolException("Unexpected status line: " + str);
                }
                str2 = str.substring(i10 + 4);
            }
            return new k(wVar, parseInt, str2);
        } catch (NumberFormatException unused) {
            throw new ProtocolException("Unexpected status line: " + str);
        }
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(this.f14875a == w.HTTP_1_0 ? "HTTP/1.0" : "HTTP/1.1");
        sb2.append(' ');
        sb2.append(this.f14876b);
        if (this.f14877c != null) {
            sb2.append(' ');
            sb2.append(this.f14877c);
        }
        return sb2.toString();
    }
}
