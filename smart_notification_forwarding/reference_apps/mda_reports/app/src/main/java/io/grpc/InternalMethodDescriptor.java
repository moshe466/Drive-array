package io.grpc;

import androidx.core.app.NotificationCompat;
import com.google.common.base.Preconditions;

@Internal
/* loaded from: classes2.dex */
public final class InternalMethodDescriptor {
    private final InternalKnownTransport transport;

    public InternalMethodDescriptor(InternalKnownTransport internalKnownTransport) {
        this.transport = (InternalKnownTransport) Preconditions.checkNotNull(internalKnownTransport, NotificationCompat.CATEGORY_TRANSPORT);
    }

    public Object geRawMethodName(MethodDescriptor<?, ?> methodDescriptor) {
        return methodDescriptor.a(this.transport.ordinal());
    }

    public void setRawMethodName(MethodDescriptor<?, ?> methodDescriptor, Object obj) {
        methodDescriptor.a(this.transport.ordinal(), obj);
    }
}
