package io.grpc.internal;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import com.google.common.collect.ImmutableSet;
import io.grpc.Status;
import java.util.Collection;
import java.util.Collections;
import java.util.Set;
import javax.annotation.concurrent.Immutable;

/* JADX INFO: Access modifiers changed from: package-private */
@Immutable
/* loaded from: classes2.dex */
public final class HedgingPolicy {
    static final HedgingPolicy d = new HedgingPolicy(1, 0, Collections.emptySet());
    final int a;
    final long b;
    final Set<Status.Code> c;

    /* loaded from: classes2.dex */
    interface Provider {
        HedgingPolicy get();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public HedgingPolicy(int i, long j, Set<Status.Code> set) {
        this.a = i;
        this.b = j;
        this.c = ImmutableSet.copyOf((Collection) set);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || HedgingPolicy.class != obj.getClass()) {
            return false;
        }
        HedgingPolicy hedgingPolicy = (HedgingPolicy) obj;
        return this.a == hedgingPolicy.a && this.b == hedgingPolicy.b && Objects.equal(this.c, hedgingPolicy.c);
    }

    public int hashCode() {
        return Objects.hashCode(Integer.valueOf(this.a), Long.valueOf(this.b), this.c);
    }

    public String toString() {
        return MoreObjects.toStringHelper(this).add("maxAttempts", this.a).add("hedgingDelayNanos", this.b).add("nonFatalStatusCodes", this.c).toString();
    }
}
