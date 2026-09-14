package com.squareup.picasso;

import android.app.Notification;
import android.app.NotificationManager;
import android.appwidget.AppWidgetManager;
import android.graphics.Bitmap;
import android.widget.RemoteViews;
import com.squareup.picasso.Picasso;

/* loaded from: classes2.dex */
abstract class RemoteViewsAction extends Action<RemoteViewsTarget> {
    final RemoteViews m;
    final int n;
    Callback o;
    private RemoteViewsTarget target;

    /* loaded from: classes2.dex */
    static class AppWidgetAction extends RemoteViewsAction {
        private final int[] appWidgetIds;

        /* JADX INFO: Access modifiers changed from: package-private */
        public AppWidgetAction(Picasso picasso, Request request, RemoteViews remoteViews, int i, int[] iArr, int i2, int i3, String str, Object obj, int i4, Callback callback) {
            super(picasso, request, remoteViews, i, i4, i2, i3, obj, str, callback);
            this.appWidgetIds = iArr;
        }

        @Override // com.squareup.picasso.RemoteViewsAction, com.squareup.picasso.Action
        /* bridge */ /* synthetic */ RemoteViewsTarget i() {
            return super.i();
        }

        @Override // com.squareup.picasso.RemoteViewsAction
        void l() {
            AppWidgetManager.getInstance(this.a.a).updateAppWidget(this.appWidgetIds, this.m);
        }
    }

    /* loaded from: classes2.dex */
    static class NotificationAction extends RemoteViewsAction {
        private final Notification notification;
        private final int notificationId;
        private final String notificationTag;

        /* JADX INFO: Access modifiers changed from: package-private */
        public NotificationAction(Picasso picasso, Request request, RemoteViews remoteViews, int i, int i2, Notification notification, String str, int i3, int i4, String str2, Object obj, int i5, Callback callback) {
            super(picasso, request, remoteViews, i, i5, i3, i4, obj, str2, callback);
            this.notificationId = i2;
            this.notificationTag = str;
            this.notification = notification;
        }

        @Override // com.squareup.picasso.RemoteViewsAction, com.squareup.picasso.Action
        /* bridge */ /* synthetic */ RemoteViewsTarget i() {
            return super.i();
        }

        @Override // com.squareup.picasso.RemoteViewsAction
        void l() {
            ((NotificationManager) Utils.a(this.a.a, "notification")).notify(this.notificationTag, this.notificationId, this.notification);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class RemoteViewsTarget {
        final RemoteViews a;
        final int b;

        /* JADX INFO: Access modifiers changed from: package-private */
        public RemoteViewsTarget(RemoteViews remoteViews, int i) {
            this.a = remoteViews;
            this.b = i;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || RemoteViewsTarget.class != obj.getClass()) {
                return false;
            }
            RemoteViewsTarget remoteViewsTarget = (RemoteViewsTarget) obj;
            return this.b == remoteViewsTarget.b && this.a.equals(remoteViewsTarget.a);
        }

        public int hashCode() {
            return (this.a.hashCode() * 31) + this.b;
        }
    }

    RemoteViewsAction(Picasso picasso, Request request, RemoteViews remoteViews, int i, int i2, int i3, int i4, Object obj, String str, Callback callback) {
        super(picasso, null, request, i3, i4, i2, null, str, obj, false);
        this.m = remoteViews;
        this.n = i;
        this.o = callback;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.squareup.picasso.Action
    public void a() {
        super.a();
        if (this.o != null) {
            this.o = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(int i) {
        this.m.setImageViewResource(this.n, i);
        l();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.squareup.picasso.Action
    public void complete(Bitmap bitmap, Picasso.LoadedFrom loadedFrom) {
        this.m.setImageViewBitmap(this.n, bitmap);
        l();
        Callback callback = this.o;
        if (callback != null) {
            callback.onSuccess();
        }
    }

    @Override // com.squareup.picasso.Action
    public void error(Exception exc) {
        int i = this.g;
        if (i != 0) {
            a(i);
        }
        Callback callback = this.o;
        if (callback != null) {
            callback.onError(exc);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.squareup.picasso.Action
    public RemoteViewsTarget i() {
        if (this.target == null) {
            this.target = new RemoteViewsTarget(this.m, this.n);
        }
        return this.target;
    }

    abstract void l();
}
