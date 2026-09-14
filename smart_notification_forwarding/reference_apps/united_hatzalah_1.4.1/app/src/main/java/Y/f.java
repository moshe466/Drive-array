package Y;

import com.google.firebase.sessions.settings.RemoteSettings;

/* loaded from: classes.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    public final long f2647a;

    /* renamed from: b, reason: collision with root package name */
    public final long f2648b;

    public f(long j2, long j3) {
        if (j3 == 0) {
            this.f2647a = 0L;
            this.f2648b = 1L;
        } else {
            this.f2647a = j2;
            this.f2648b = j3;
        }
    }

    public final String toString() {
        return this.f2647a + RemoteSettings.FORWARD_SLASH_STRING + this.f2648b;
    }
}
