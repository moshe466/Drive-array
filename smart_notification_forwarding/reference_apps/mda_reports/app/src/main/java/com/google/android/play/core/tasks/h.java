package com.google.android.play.core.tasks;

/* loaded from: classes.dex */
public final class h<ResultT> {
    private final l<ResultT> a = new l<>();

    public final Task<ResultT> a() {
        return this.a;
    }

    public final boolean a(Exception exc) {
        return this.a.b(exc);
    }

    public final boolean a(ResultT resultt) {
        return this.a.b((l<ResultT>) resultt);
    }
}
