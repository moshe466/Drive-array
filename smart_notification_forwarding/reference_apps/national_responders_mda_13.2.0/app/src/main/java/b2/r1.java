package b2;

import android.os.IBinder;

/* loaded from: classes.dex */
public final class r1 extends o2.a implements k {
    /* JADX INFO: Access modifiers changed from: package-private */
    public r1(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.common.internal.ICancelToken");
    }

    @Override // b2.k
    public final void cancel() {
        n(2, p());
    }
}
