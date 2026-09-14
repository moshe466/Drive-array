package R;

import java.io.File;
import java.util.LinkedHashSet;

/* renamed from: R.m, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0188m extends kotlin.jvm.internal.k implements F2.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1921a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ P f1922b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ C0188m(P p, int i) {
        super(0);
        this.f1921a = i;
        this.f1922b = p;
    }

    @Override // F2.a
    public final Object invoke() {
        switch (this.f1921a) {
            case 0:
                return ((Y) this.f1922b.f1811j.a()).f1842b;
            default:
                V v2 = this.f1922b.f1803a;
                File canonicalFile = ((File) v2.f1827b.invoke()).getCanonicalFile();
                synchronized (V.f1825d) {
                    String path = canonicalFile.getAbsolutePath();
                    LinkedHashSet linkedHashSet = V.f1824c;
                    if (!linkedHashSet.contains(path)) {
                        kotlin.jvm.internal.j.d(path, "path");
                        linkedHashSet.add(path);
                    } else {
                        throw new IllegalStateException(("There are multiple DataStores active for the same file: " + path + ". You should either maintain your DataStore as a singleton or confirm that there is no two DataStore's active on the same file (by confirming that the scope is cancelled).").toString());
                    }
                }
                return new Y(canonicalFile, (j0) v2.f1826a.invoke(canonicalFile), new U(canonicalFile, 0));
        }
    }
}
