package com.google.android.play.core.tasks;

/* loaded from: classes.dex */
public class RuntimeExecutionException extends j {
    public RuntimeExecutionException(Throwable th) {
        super(th);
    }

    @Override // com.google.android.play.core.tasks.j
    public int getErrorCode() {
        return -100;
    }
}
