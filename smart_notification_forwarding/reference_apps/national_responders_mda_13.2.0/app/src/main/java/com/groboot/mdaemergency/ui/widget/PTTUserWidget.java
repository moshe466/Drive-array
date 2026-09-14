package com.groboot.mdaemergency.ui.widget;

import a6.h;
import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.widget.RemoteViews;
import com.google.gson.e;
import com.groboot.mdaemergency.ptt.PTTService;
import com.groboot.mdaemergency.ptt.p;
import g5.b;
import il.org.mda.health.R;

/* loaded from: classes.dex */
public class PTTUserWidget extends AppWidgetProvider {

    /* loaded from: classes.dex */
    class a implements p.b0 {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Context f8471a;

        a(PTTUserWidget pTTUserWidget, Context context) {
            this.f8471a = context;
        }

        @Override // com.groboot.mdaemergency.ptt.p.b0
        public void a() {
            Context context = this.f8471a;
            h.j(context, context.getString(R.string.message_ptt_not_available2), true, null);
        }

        @Override // com.groboot.mdaemergency.ptt.p.b0
        public void b(p pVar) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(Context context, AppWidgetManager appWidgetManager, int i10) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("update ");
        sb2.append(i10);
        w6.p k10 = b.i(context).k(i10);
        if (k10 == null) {
            return;
        }
        RemoteViews remoteViews = new RemoteViews(context.getPackageName(), R.layout.pttuser_widget);
        remoteViews.setTextViewText(R.id.tv_name, k10.toString());
        e eVar = new e();
        com.groboot.mdaemergency.ptt.a aVar = new com.groboot.mdaemergency.ptt.a();
        aVar.f7788b = k10;
        aVar.f7787a = k10.f15235a;
        String r10 = eVar.r(aVar);
        StringBuilder sb3 = new StringBuilder();
        sb3.append("load contact widget: ");
        sb3.append(r10);
        Intent intent = new Intent(context, (Class<?>) PTTUserWidget.class);
        intent.putExtra(p.f7896v, r10);
        intent.putExtra(p.f7897w, p.f7898x);
        remoteViews.setOnClickPendingIntent(R.id.widget_call, PendingIntent.getBroadcast(context, 0, intent, Build.VERSION.SDK_INT >= 23 ? 201326592 : 134217728));
        appWidgetManager.updateAppWidget(i10, remoteViews);
    }

    @Override // android.appwidget.AppWidgetProvider
    public void onDeleted(Context context, int[] iArr) {
        for (int i10 : iArr) {
        }
    }

    @Override // android.appwidget.AppWidgetProvider
    public void onDisabled(Context context) {
    }

    @Override // android.appwidget.AppWidgetProvider
    public void onEnabled(Context context) {
        super.onEnabled(context);
    }

    @Override // android.appwidget.AppWidgetProvider, android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("onReceive: ");
        sb2.append(intent.getStringExtra(p.f7896v));
    }

    @Override // android.appwidget.AppWidgetProvider
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] iArr) {
        PTTService.j(context);
        p.d0(context, new a(this, context));
        for (int i10 : iArr) {
            a(context, appWidgetManager, i10);
        }
    }
}
