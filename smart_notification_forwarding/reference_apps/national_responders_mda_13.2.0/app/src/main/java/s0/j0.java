package s0;

import android.os.IBinder;

/* loaded from: classes.dex */
class j0 implements l0 {

    /* renamed from: a, reason: collision with root package name */
    private final IBinder f13941a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j0(IBinder iBinder) {
        this.f13941a = iBinder;
    }

    public boolean equals(Object obj) {
        return (obj instanceof j0) && ((j0) obj).f13941a.equals(this.f13941a);
    }

    public int hashCode() {
        return this.f13941a.hashCode();
    }
}
