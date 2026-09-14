package com.google.android.play.core.integrity;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.play.core.common.PlayCoreDialogWrapperActivity;

/* loaded from: classes.dex */
final class as extends I1.w {

    /* renamed from: a, reason: collision with root package name */
    final TaskCompletionSource f3934a;

    /* renamed from: b, reason: collision with root package name */
    final I1.d f3935b;

    /* renamed from: c, reason: collision with root package name */
    private final I1.y f3936c;

    /* renamed from: d, reason: collision with root package name */
    private final String f3937d;

    /* renamed from: e, reason: collision with root package name */
    private final k f3938e;

    /* renamed from: f, reason: collision with root package name */
    private final Activity f3939f;

    public as(Context context, k kVar, Activity activity, TaskCompletionSource taskCompletionSource, I1.d dVar) {
        super("com.google.android.play.core.integrity.protocol.IRequestDialogCallback");
        this.f3936c = new I1.y("RequestDialogCallbackImpl");
        this.f3937d = context.getPackageName();
        this.f3938e = kVar;
        this.f3934a = taskCompletionSource;
        this.f3939f = activity;
        this.f3935b = dVar;
    }

    @Override // I1.x
    public final void b(Bundle bundle) {
        this.f3935b.d(this.f3934a);
        this.f3936c.b("onRequestDialog(%s)", this.f3937d);
        ApiException a2 = this.f3938e.a(bundle);
        if (a2 != null) {
            this.f3934a.trySetException(a2);
            return;
        }
        PendingIntent pendingIntent = (PendingIntent) bundle.getParcelable("dialog.intent");
        if (pendingIntent == null) {
            I1.y yVar = this.f3936c;
            Object[] objArr = {this.f3937d};
            yVar.getClass();
            if (Log.isLoggable("PlayCore", 6)) {
                Log.e("PlayCore", I1.y.c(yVar.f929a, "onRequestDialog(%s): got null dialog intent", objArr));
            }
            this.f3934a.trySetResult(0);
            return;
        }
        Intent intent = new Intent(this.f3939f, (Class<?>) PlayCoreDialogWrapperActivity.class);
        intent.putExtra("confirmation_intent", pendingIntent);
        intent.setFlags(536870912);
        intent.putExtra("result_receiver", new ar(this, this.f3935b.a()));
        I1.y yVar2 = this.f3936c;
        Object[] objArr2 = new Object[0];
        yVar2.getClass();
        if (Log.isLoggable("PlayCore", 3)) {
            I1.y.c(yVar2.f929a, "Starting dialog intent...", objArr2);
        }
        this.f3939f.startActivityForResult(intent, 0);
    }
}
