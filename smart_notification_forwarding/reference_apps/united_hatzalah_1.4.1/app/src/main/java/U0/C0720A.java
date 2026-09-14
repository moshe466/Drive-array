package u0;

import F0.AbstractC0008a;
import java.util.Objects;
import org.chromium.support_lib_boundary.WebMessagePayloadBoundaryInterface;

/* renamed from: u0.A, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0720A implements WebMessagePayloadBoundaryInterface {

    /* renamed from: a, reason: collision with root package name */
    public final int f6502a;

    /* renamed from: b, reason: collision with root package name */
    public final String f6503b;

    /* renamed from: c, reason: collision with root package name */
    public final byte[] f6504c;

    public C0720A(String str) {
        this.f6502a = 0;
        this.f6503b = str;
        this.f6504c = null;
    }

    public final void a(int i) {
        int i3 = this.f6502a;
        if (i3 == i) {
        } else {
            throw new IllegalStateException(AbstractC0008a.k("Expected ", i, i3, ", but type is "));
        }
    }

    @Override // org.chromium.support_lib_boundary.WebMessagePayloadBoundaryInterface
    public final byte[] getAsArrayBuffer() {
        a(1);
        byte[] bArr = this.f6504c;
        Objects.requireNonNull(bArr);
        return bArr;
    }

    @Override // org.chromium.support_lib_boundary.WebMessagePayloadBoundaryInterface
    public final String getAsString() {
        a(0);
        return this.f6503b;
    }

    @Override // org.chromium.support_lib_boundary.FeatureFlagHolderBoundaryInterface
    public final String[] getSupportedFeatures() {
        return new String[0];
    }

    @Override // org.chromium.support_lib_boundary.WebMessagePayloadBoundaryInterface
    public final int getType() {
        return this.f6502a;
    }

    public C0720A(byte[] bArr) {
        this.f6502a = 1;
        this.f6503b = null;
        this.f6504c = bArr;
    }
}
