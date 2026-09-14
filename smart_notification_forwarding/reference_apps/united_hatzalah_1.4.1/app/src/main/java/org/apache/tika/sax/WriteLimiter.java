package org.apache.tika.sax;

/* loaded from: classes.dex */
public interface WriteLimiter {
    int getWriteLimit();

    boolean isThrowOnWriteLimitReached();
}
