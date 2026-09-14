package q3;

import android.os.Bundle;
import p3.a;
import u2.a;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class d implements a.InterfaceC0294a {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ a f13568a;

    public d(a aVar) {
        this.f13568a = aVar;
    }

    @Override // v2.l
    public final void a(String str, String str2, Bundle bundle, long j10) {
        a.b bVar;
        if (this.f13568a.f13555a.contains(str2)) {
            Bundle bundle2 = new Bundle();
            bundle2.putString("events", b.g(str2));
            bVar = this.f13568a.f13556b;
            bVar.a(2, bundle2);
        }
    }
}
