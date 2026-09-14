package b3;

import com.google.android.gms.fido.u2f.api.common.ClientData;
import java.util.Objects;
import p3.h;

/* loaded from: classes.dex */
public final class a extends h {

    /* renamed from: c, reason: collision with root package name */
    public final Object f3806c;

    public a(byte[] bArr) {
        Objects.requireNonNull(bArr, ClientData.KEY_ORIGIN);
        this.f3806c = bArr;
    }

    public final String toString() {
        return a.class.getSimpleName() + "[" + this.f3806c.toString() + "]";
    }
}
