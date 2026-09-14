package com.squareup.okhttp.internal;

/* loaded from: classes2.dex */
public abstract class NamedRunnable implements Runnable {
    protected final String a;

    public NamedRunnable(String str, Object... objArr) {
        this.a = String.format(str, objArr);
    }

    protected abstract void execute();

    @Override // java.lang.Runnable
    public final void run() {
        String name = Thread.currentThread().getName();
        Thread.currentThread().setName(this.a);
        try {
            execute();
        } finally {
            Thread.currentThread().setName(name);
        }
    }
}
