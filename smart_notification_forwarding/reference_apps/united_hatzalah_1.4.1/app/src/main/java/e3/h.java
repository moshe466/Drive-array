package e3;

import com.google.android.gms.fido.u2f.api.common.ClientData;
import java.util.Objects;

/* loaded from: classes.dex */
public final class h extends b3.d {

    /* renamed from: d, reason: collision with root package name */
    public int f4468d;

    public final i L() {
        b3.a aVar = this.f3807c;
        if (aVar != null) {
            return new i((byte[]) aVar.f3806c, this.f4468d);
        }
        throw new IllegalStateException("origin == null");
    }

    public final void M(byte[] bArr) {
        Objects.requireNonNull(bArr, ClientData.KEY_ORIGIN);
        this.f4468d = bArr.length;
        this.f3807c = new b3.a(bArr);
    }
}
