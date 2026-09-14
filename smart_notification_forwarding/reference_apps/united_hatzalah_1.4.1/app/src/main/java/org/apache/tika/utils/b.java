package org.apache.tika.utils;

import java.io.File;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public abstract /* synthetic */ class b {
    public static /* bridge */ /* synthetic */ void f(ProcessBuilder processBuilder, File file) {
        processBuilder.redirectOutput(file);
    }

    public static /* bridge */ /* synthetic */ boolean h(Process process) {
        return process.waitFor(500L, TimeUnit.MILLISECONDS);
    }

    public static /* bridge */ /* synthetic */ boolean i(Process process, long j2) {
        return process.waitFor(j2, TimeUnit.MILLISECONDS);
    }
}
