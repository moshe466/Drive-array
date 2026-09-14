package m0;

import android.security.keystore.KeyGenParameterSpec;
import com.google.android.gms.fido.fido2.api.common.UserVerificationMethods;
import com.google.android.gms.stats.CodePackage;

/* renamed from: m0.d, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0586d {

    /* renamed from: a, reason: collision with root package name */
    public static final Object f5864a;

    static {
        new KeyGenParameterSpec.Builder("_androidx_security_master_key_", 3).setBlockModes(CodePackage.GCM).setEncryptionPaddings("NoPadding").setKeySize(UserVerificationMethods.USER_VERIFY_HANDPRINT).build();
        f5864a = new Object();
    }
}
