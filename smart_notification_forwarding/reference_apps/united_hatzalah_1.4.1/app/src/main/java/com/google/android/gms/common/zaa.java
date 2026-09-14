package com.google.android.gms.common;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.DialogInterface;
import android.content.IntentSender;
import e.c;
import java.util.Objects;
import kotlin.jvm.internal.j;

/* loaded from: classes.dex */
final class zaa implements DialogInterface.OnClickListener {
    final /* synthetic */ Activity zaa;
    final /* synthetic */ int zab;
    final /* synthetic */ c zac;
    final /* synthetic */ GoogleApiAvailability zad;

    public zaa(GoogleApiAvailability googleApiAvailability, Activity activity, int i, c cVar) {
        this.zaa = activity;
        this.zab = i;
        this.zac = cVar;
        Objects.requireNonNull(googleApiAvailability);
        this.zad = googleApiAvailability;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
        PendingIntent errorResolutionPendingIntent = this.zad.getErrorResolutionPendingIntent(this.zaa, this.zab, 0);
        if (errorResolutionPendingIntent == null) {
            return;
        }
        IntentSender intentSender = errorResolutionPendingIntent.getIntentSender();
        j.e(intentSender, "intentSender");
        this.zac.a(new e.j(intentSender, null, 0, 0));
    }
}
