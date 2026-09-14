package com.groboot.mdaemergency.alwaysOn;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import com.groboot.mdaemergency.models.FirstResponderPayload;
import com.groboot.mdaemergency.models.IncidentBasicInfo;
import java.util.Objects;
import v6.o;
import y8.g;
import y8.k;
import y8.w;

/* loaded from: classes.dex */
public enum e {
    TRAVEL_NOTIFICATION { // from class: com.groboot.mdaemergency.alwaysOn.e.c

        /* renamed from: f, reason: collision with root package name */
        private Object f7547f;

        @Override // com.groboot.mdaemergency.alwaysOn.e
        public int getHeight(Context context) {
            k.e(context, "context");
            return getHeight(context, 0.65f, 630);
        }

        @Override // com.groboot.mdaemergency.alwaysOn.e
        public Object getObjectAny() {
            return this.f7547f;
        }

        @Override // com.groboot.mdaemergency.alwaysOn.e
        public e9.b<? extends com.groboot.mdaemergency.alwaysOn.b> getViewTypeClass() {
            return w.b(o.class);
        }

        @Override // com.groboot.mdaemergency.alwaysOn.e
        public int getWidth(Context context) {
            k.e(context, "context");
            return getWidth(context, 0.9f, 470);
        }

        @Override // com.groboot.mdaemergency.alwaysOn.e
        public void setObjectAny(Object obj) {
            if (obj instanceof FirstResponderPayload) {
                this.f7547f = obj;
            }
        }
    },
    EXTERNAL_MESSAGE { // from class: com.groboot.mdaemergency.alwaysOn.e.a

        /* renamed from: f, reason: collision with root package name */
        private Object f7545f;

        @Override // com.groboot.mdaemergency.alwaysOn.e
        public int getHeight(Context context) {
            k.e(context, "context");
            return getHeight(context, 0.9f, 630);
        }

        @Override // com.groboot.mdaemergency.alwaysOn.e
        public Object getObjectAny() {
            return this.f7545f;
        }

        @Override // com.groboot.mdaemergency.alwaysOn.e
        public e9.b<? extends com.groboot.mdaemergency.alwaysOn.b> getViewTypeClass() {
            return w.b(com.groboot.mdaemergency.ui.views.b.class);
        }

        @Override // com.groboot.mdaemergency.alwaysOn.e
        public int getWidth(Context context) {
            k.e(context, "context");
            return getWidth(context, 0.9f, 470);
        }

        @Override // com.groboot.mdaemergency.alwaysOn.e
        public void setObjectAny(Object obj) {
            if (obj instanceof String) {
                this.f7545f = obj;
            }
        }
    },
    PTT { // from class: com.groboot.mdaemergency.alwaysOn.e.b

        /* renamed from: f, reason: collision with root package name */
        private Object f7546f;

        @Override // com.groboot.mdaemergency.alwaysOn.e
        public int getHeight(Context context) {
            k.e(context, "context");
            return getHeight(context, 0.65f, 630);
        }

        @Override // com.groboot.mdaemergency.alwaysOn.e
        public Object getObjectAny() {
            return this.f7546f;
        }

        @Override // com.groboot.mdaemergency.alwaysOn.e
        public e9.b<? extends com.groboot.mdaemergency.alwaysOn.b> getViewTypeClass() {
            return w.b(o.class);
        }

        @Override // com.groboot.mdaemergency.alwaysOn.e
        public int getWidth(Context context) {
            k.e(context, "context");
            return getWidth(context, 0.9f, 470);
        }

        @Override // com.groboot.mdaemergency.alwaysOn.e
        public void setObjectAny(Object obj) {
            if (obj instanceof IncidentBasicInfo) {
                this.f7546f = obj;
            }
        }
    };

    /* synthetic */ e(g gVar) {
        this();
    }

    protected final DisplayMetrics getDisplayMetrics(Context context) {
        k.e(context, "context");
        Object systemService = context.getSystemService("window");
        Objects.requireNonNull(systemService, "null cannot be cast to non-null type android.view.WindowManager");
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) systemService).getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics;
    }

    public abstract int getHeight(Context context);

    protected final int getHeight(Context context, float f10, int i10) {
        k.e(context, "context");
        return getSize(f10, i10, getDisplayMetrics(context).heightPixels);
    }

    public abstract Object getObjectAny();

    protected final int getSize(float f10, int i10, int i11) {
        int i12 = (int) (i11 * f10);
        return (i12 >= i10 || i10 >= i11) ? i12 : i10;
    }

    public abstract e9.b<? extends com.groboot.mdaemergency.alwaysOn.b> getViewTypeClass();

    public abstract int getWidth(Context context);

    protected final int getWidth(Context context, float f10, int i10) {
        k.e(context, "context");
        return getSize(f10, i10, getDisplayMetrics(context).widthPixels);
    }

    public abstract void setObjectAny(Object obj);
}
