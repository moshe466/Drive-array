package L1;

import F0.G1;
import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;

/* loaded from: classes.dex */
public final class z extends AbstractC0139b {
    /* JADX WARN: Type inference failed for: r4v6, types: [L1.z, java.lang.Object] */
    public static z b(j jVar, G1 g12, Integer num) {
        Y1.a aVar = (Y1.a) g12.f218b;
        j jVar2 = j.y;
        if (jVar != jVar2 && num == null) {
            throw new GeneralSecurityException("For given Variant " + jVar + " the value of idRequirement must be non-null");
        }
        if (jVar == jVar2 && num != null) {
            throw new GeneralSecurityException("For given Variant NO_PREFIX the value of idRequirement must be null");
        }
        if (aVar.f2706a.length == 32) {
            if (jVar == jVar2) {
                Y1.a.a(new byte[0]);
            } else if (jVar == j.f1312x) {
                Y1.a.a(ByteBuffer.allocate(5).put((byte) 0).putInt(num.intValue()).array());
            } else if (jVar == j.f1311w) {
                Y1.a.a(ByteBuffer.allocate(5).put((byte) 1).putInt(num.intValue()).array());
            } else {
                throw new IllegalStateException("Unknown Variant: " + jVar);
            }
            return new Object();
        }
        throw new GeneralSecurityException("XChaCha20Poly1305 key must be constructed with key of length 32 bytes, not " + aVar.f2706a.length);
    }
}
