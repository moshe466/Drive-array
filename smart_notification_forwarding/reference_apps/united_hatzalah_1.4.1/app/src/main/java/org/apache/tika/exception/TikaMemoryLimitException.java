package org.apache.tika.exception;

import F0.AbstractC0008a;
import e0.a;

/* loaded from: classes.dex */
public class TikaMemoryLimitException extends TikaException {
    public TikaMemoryLimitException(String str) {
        super(str);
    }

    private static String msg(long j2, long j3) {
        return a.g(AbstractC0008a.x("Tried to allocate ", " bytes, but ", j2), j3, " is the maximum allowed. Please open an issue https://issues.apache.org/jira/projects/TIKA if you believe this file is not corrupt.");
    }

    public TikaMemoryLimitException(long j2, long j3) {
        super(msg(j2, j3));
    }
}
