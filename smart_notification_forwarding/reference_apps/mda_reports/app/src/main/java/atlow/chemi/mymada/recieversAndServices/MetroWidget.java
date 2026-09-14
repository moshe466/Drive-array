package atlow.chemi.mymada.recieversAndServices;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.widget.RemoteViews;
import atlow.chemi.mymada.R;

/* loaded from: classes.dex */
public class MetroWidget extends AppWidgetProvider {
    static void a(Context context, AppWidgetManager appWidgetManager, int i) {
        Intent intent = new Intent(context, (Class<?>) ActionReceiver.class);
        intent.putExtra("action", "widget");
        PendingIntent broadcast = PendingIntent.getBroadcast(context, 0, intent, 0);
        RemoteViews remoteViews = new RemoteViews(context.getPackageName(), R.layout.metro_widget);
        remoteViews.setOnClickPendingIntent(R.id.metro_widget_image, broadcast);
        appWidgetManager.updateAppWidget(i, remoteViews);
    }

    @Override // android.appwidget.AppWidgetProvider
    public void onDisabled(Context context) {
    }

    @Override // android.appwidget.AppWidgetProvider
    public void onEnabled(Context context) {
    }

    @Override // android.appwidget.AppWidgetProvider
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] iArr) {
        for (int i : iArr) {
            a(context, appWidgetManager, i);
        }
    }
}
