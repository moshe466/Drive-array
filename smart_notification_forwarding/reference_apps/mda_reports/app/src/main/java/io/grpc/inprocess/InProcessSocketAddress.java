package io.grpc.inprocess;

import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.common.base.Preconditions;
import java.net.SocketAddress;

/* loaded from: classes2.dex */
public final class InProcessSocketAddress extends SocketAddress {
    private static final long serialVersionUID = -2803441206326023474L;
    private final String name;

    public InProcessSocketAddress(String str) {
        this.name = (String) Preconditions.checkNotNull(str, AppMeasurementSdk.ConditionalUserProperty.NAME);
    }

    public boolean equals(Object obj) {
        if (obj instanceof InProcessSocketAddress) {
            return this.name.equals(((InProcessSocketAddress) obj).name);
        }
        return false;
    }

    public String getName() {
        return this.name;
    }

    public int hashCode() {
        return this.name.hashCode();
    }

    public String toString() {
        return this.name;
    }
}
