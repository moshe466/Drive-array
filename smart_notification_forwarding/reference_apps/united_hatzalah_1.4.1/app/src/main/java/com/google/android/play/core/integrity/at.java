package com.google.android.play.core.integrity;

import android.app.Activity;
import android.content.Context;
import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class at {

    /* renamed from: a, reason: collision with root package name */
    private final I1.i f3940a;

    /* renamed from: b, reason: collision with root package name */
    private final I1.i f3941b;

    public at(I1.i iVar, I1.i iVar2) {
        this.f3940a = iVar;
        this.f3941b = iVar2;
    }

    public final as a(Activity activity, TaskCompletionSource taskCompletionSource, I1.d dVar) {
        Object a2 = this.f3940a.a();
        a2.getClass();
        k kVar = (k) this.f3941b.a();
        kVar.getClass();
        activity.getClass();
        dVar.getClass();
        return new as((Context) a2, kVar, activity, taskCompletionSource, dVar);
    }
}
