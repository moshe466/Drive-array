package com.google.android.play.core.tasks;

/* loaded from: classes.dex */
public abstract class j extends RuntimeException {
    public j(String str) {
        super(str);
    }

    public j(Throwable th) {
        super(th);
    }

    public abstract int getErrorCode();
}
