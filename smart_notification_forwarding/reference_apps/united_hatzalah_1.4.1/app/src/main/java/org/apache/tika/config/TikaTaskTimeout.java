package org.apache.tika.config;

import org.apache.tika.parser.ParseContext;

/* loaded from: classes.dex */
public class TikaTaskTimeout {
    private final long timeoutMillis;

    public TikaTaskTimeout(long j2) {
        this.timeoutMillis = j2;
    }

    public long getTimeoutMillis() {
        return this.timeoutMillis;
    }

    public static long getTimeoutMillis(ParseContext parseContext, long j2) {
        TikaTaskTimeout tikaTaskTimeout = (TikaTaskTimeout) parseContext.get(TikaTaskTimeout.class);
        return tikaTaskTimeout == null ? j2 : tikaTaskTimeout.getTimeoutMillis();
    }
}
