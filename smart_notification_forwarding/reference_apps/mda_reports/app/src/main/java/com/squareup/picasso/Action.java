package com.squareup.picasso;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import com.squareup.picasso.Picasso;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public abstract class Action<T> {
    final Picasso a;
    final Request b;
    final WeakReference<T> c;
    final boolean d;
    final int e;
    final int f;
    final int g;
    final Drawable h;
    final String i;
    final Object j;
    boolean k;
    boolean l;

    /* loaded from: classes2.dex */
    static class RequestWeakReference<M> extends WeakReference<M> {
        final Action a;

        RequestWeakReference(Action action, M m, ReferenceQueue<? super M> referenceQueue) {
            super(m, referenceQueue);
            this.a = action;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Action(Picasso picasso, T t, Request request, int i, int i2, int i3, Drawable drawable, String str, Object obj, boolean z) {
        this.a = picasso;
        this.b = request;
        this.c = t == null ? null : new RequestWeakReference(this, t, picasso.g);
        this.e = i;
        this.f = i2;
        this.d = z;
        this.g = i3;
        this.h = drawable;
        this.i = str;
        this.j = obj == null ? this : obj;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a() {
        this.l = true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String b() {
        return this.i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int c() {
        return this.e;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void complete(Bitmap bitmap, Picasso.LoadedFrom loadedFrom);

    /* JADX INFO: Access modifiers changed from: package-private */
    public int d() {
        return this.f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Picasso e() {
        return this.a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void error(Exception exc);

    /* JADX INFO: Access modifiers changed from: package-private */
    public Picasso.Priority f() {
        return this.b.priority;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Request g() {
        return this.b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Object h() {
        return this.j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public T i() {
        WeakReference<T> weakReference = this.c;
        if (weakReference == null) {
            return null;
        }
        return weakReference.get();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean j() {
        return this.l;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean k() {
        return this.k;
    }
}
