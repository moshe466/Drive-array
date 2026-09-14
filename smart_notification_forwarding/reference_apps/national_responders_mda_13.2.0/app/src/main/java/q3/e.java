package q3;

import android.os.Bundle;
import p3.a;
import u2.a;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class e implements a.InterfaceC0294a {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ c f13569a;

    public e(c cVar) {
        this.f13569a = cVar;
    }

    @Override // v2.l
    public final void a(String str, String str2, Bundle bundle, long j10) {
        a.b bVar;
        if (str == null || str.equals("crash") || !b.f(str2)) {
            return;
        }
        Bundle bundle2 = new Bundle();
        bundle2.putString("name", str2);
        bundle2.putLong("timestampInMillis", j10);
        bundle2.putBundle("params", bundle);
        bVar = this.f13569a.f13565a;
        bVar.a(3, bundle2);
    }
}
