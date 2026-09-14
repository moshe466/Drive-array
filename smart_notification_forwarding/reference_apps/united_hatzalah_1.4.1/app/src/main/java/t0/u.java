package t0;

import com.google.firebase.sessions.settings.RemoteSettings;

/* loaded from: classes.dex */
public final class u {

    /* renamed from: a, reason: collision with root package name */
    public final boolean f6385a;

    /* renamed from: b, reason: collision with root package name */
    public final String f6386b;

    /* renamed from: c, reason: collision with root package name */
    public final String f6387c;

    /* renamed from: d, reason: collision with root package name */
    public final t f6388d;

    public u(String str, String str2, boolean z3, t tVar) {
        if (!str2.isEmpty() && str2.charAt(0) == '/') {
            if (str2.endsWith(RemoteSettings.FORWARD_SLASH_STRING)) {
                this.f6386b = str;
                this.f6387c = str2;
                this.f6385a = z3;
                this.f6388d = tVar;
                return;
            }
            throw new IllegalArgumentException("Path should end with a slash '/'");
        }
        throw new IllegalArgumentException("Path should start with a slash '/'.");
    }
}
