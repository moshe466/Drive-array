package io.grpc.internal;

import io.grpc.Attributes;
import javax.annotation.concurrent.ThreadSafe;

@ThreadSafe
/* loaded from: classes.dex */
public interface ConnectionClientTransport extends ManagedClientTransport {
    Attributes getAttributes();
}
