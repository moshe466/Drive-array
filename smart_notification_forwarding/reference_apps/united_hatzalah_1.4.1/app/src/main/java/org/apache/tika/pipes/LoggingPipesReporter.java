package org.apache.tika.pipes;

import n3.b;
import n3.d;

/* loaded from: classes.dex */
public class LoggingPipesReporter extends PipesReporter {
    b LOGGER = d.b(LoggingPipesReporter.class);

    @Override // org.apache.tika.pipes.PipesReporter
    public void error(Throwable th) {
        this.LOGGER.e("pipes error", th);
    }

    @Override // org.apache.tika.pipes.PipesReporter
    public void report(FetchEmitTuple fetchEmitTuple, PipesResult pipesResult, long j2) {
        this.LOGGER.n("{} {} {}", fetchEmitTuple, pipesResult, Long.valueOf(j2));
    }

    @Override // org.apache.tika.pipes.PipesReporter
    public void error(String str) {
        this.LOGGER.q(str, "error {}");
    }
}
