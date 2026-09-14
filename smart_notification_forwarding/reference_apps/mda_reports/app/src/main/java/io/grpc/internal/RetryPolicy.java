package io.grpc.internal;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import com.google.common.collect.ImmutableSet;
import io.grpc.Status;
import java.util.Collection;
import java.util.Collections;
import java.util.Set;
import javax.annotation.Nonnull;
import javax.annotation.concurrent.Immutable;

/* JADX INFO: Access modifiers changed from: package-private */
@Immutable
/* loaded from: classes.dex */
public final class RetryPolicy {
    static final RetryPolicy f = new RetryPolicy(1, 0, 0, 1.0d, Collections.emptySet());
    final int a;
    final long b;
    final long c;
    final double d;
    final Set<Status.Code> e;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public interface Provider {
        RetryPolicy get();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public RetryPolicy(int i, long j, long j2, double d, @Nonnull Set<Status.Code> set) {
        this.a = i;
        this.b = j;
        this.c = j2;
        this.d = d;
        this.e = ImmutableSet.copyOf((Collection) set);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof RetryPolicy)) {
            return false;
        }
        RetryPolicy retryPolicy = (RetryPolicy) obj;
        return this.a == retryPolicy.a && this.b == retryPolicy.b && this.c == retryPolicy.c && Double.compare(this.d, retryPolicy.d) == 0 && Objects.equal(this.e, retryPolicy.e);
    }

    public int hashCode() {
        return Objects.hashCode(Integer.valueOf(this.a), Long.valueOf(this.b), Long.valueOf(this.c), Double.valueOf(this.d), this.e);
    }

    public String toString() {
        return MoreObjects.toStringHelper(this).add("maxAttempts", this.a).add("initialBackoffNanos", this.b).add("maxBackoffNanos", this.c).add("backoffMultiplier", this.d).add("retryableStatusCodes", this.e).toString();
    }
}
