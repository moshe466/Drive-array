package g2;

import F0.C0110z2;
import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.Cipher;
import javax.crypto.spec.GCMParameterSpec;

/* loaded from: classes.dex */
public final class d extends C0110z2 {
    @Override // F0.C0110z2
    public final String m() {
        return "VGhpcyBpcyB0aGUga2V5IGZvcihBIHNlY3XyZZBzdG9yYWdlIEFFUyBLZXkK";
    }

    @Override // F0.C0110z2
    public final Cipher n() {
        return Cipher.getInstance("AES/GCM/NoPadding");
    }

    @Override // F0.C0110z2
    public final int o() {
        return 12;
    }

    @Override // F0.C0110z2
    public final AlgorithmParameterSpec p(byte[] bArr) {
        return new GCMParameterSpec(128, bArr);
    }
}
