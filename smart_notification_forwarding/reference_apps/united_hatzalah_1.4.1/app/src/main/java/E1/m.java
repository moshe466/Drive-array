package E1;

import F0.AbstractC0008a;

/* loaded from: classes.dex */
public final class m {

    /* renamed from: a, reason: collision with root package name */
    public final int f152a;

    public m(int i) {
        this.f152a = i;
    }

    public static m a(int i) {
        byte b4 = (byte) (((byte) 1) | 2);
        if (b4 != 3) {
            StringBuilder sb = new StringBuilder();
            if ((b4 & 1) == 0) {
                sb.append(" appUpdateType");
            }
            if ((b4 & 2) == 0) {
                sb.append(" allowAssetPackDeletion");
            }
            throw new IllegalStateException("Missing required properties:".concat(sb.toString()));
        }
        return new m(i);
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if ((obj instanceof m) && this.f152a == ((m) obj).f152a) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return ((this.f152a ^ 1000003) * 1000003) ^ 1237;
    }

    public final String toString() {
        return AbstractC0008a.j(this.f152a, "AppUpdateOptions{appUpdateType=", ", allowAssetPackDeletion=false}");
    }
}
