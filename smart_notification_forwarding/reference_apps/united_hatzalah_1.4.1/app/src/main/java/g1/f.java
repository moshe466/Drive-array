package g1;

import F0.C0021d0;
import android.app.KeyguardManager;
import android.app.admin.DevicePolicyManager;

/* loaded from: classes.dex */
public final class f extends kotlin.jvm.internal.k implements F2.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4685a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ C0021d0 f4686b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ f(C0021d0 c0021d0, int i) {
        super(0);
        this.f4685a = i;
        this.f4686b = c0021d0;
    }

    @Override // F2.a
    public final Object invoke() {
        switch (this.f4685a) {
            case 0:
                DevicePolicyManager devicePolicyManager = (DevicePolicyManager) this.f4686b.f479a;
                kotlin.jvm.internal.j.b(devicePolicyManager);
                int storageEncryptionStatus = devicePolicyManager.getStorageEncryptionStatus();
                if (storageEncryptionStatus != 0) {
                    if (storageEncryptionStatus != 1) {
                        if (storageEncryptionStatus != 2) {
                            if (storageEncryptionStatus != 3) {
                                if (storageEncryptionStatus != 5) {
                                    return "";
                                }
                                return "active_per_user";
                            }
                            return "active";
                        }
                        return "activating";
                    }
                    return "inactive";
                }
                return "unsupported";
            default:
                KeyguardManager keyguardManager = (KeyguardManager) this.f4686b.f480b;
                kotlin.jvm.internal.j.b(keyguardManager);
                return Boolean.valueOf(keyguardManager.isKeyguardSecure());
        }
    }
}
