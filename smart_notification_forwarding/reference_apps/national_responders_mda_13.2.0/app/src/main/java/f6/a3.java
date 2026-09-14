package f6;

import android.view.View;
import com.groboot.mdaemergency.models.Feature;
import com.groboot.mdaemergency.models.JSFunction;
import com.groboot.mdaemergency.models.NotificationData;
import com.groboot.mdaemergency.ui.views.WebViewMDA;
import java.util.LinkedHashMap;
import java.util.Map;
import w6.m0;

/* loaded from: classes.dex */
public final class a3 extends h1 {
    public static final a L0 = new a(null);
    private static final String M0 = "ShowWhatAppScreen";
    private static final String N0 = "notification_data";
    public Map<Integer, View> I0;
    public NotificationData J0;
    private final String K0;

    /* loaded from: classes.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(y8.g gVar) {
            this();
        }

        public final String a() {
            return a3.N0;
        }

        public final String b() {
            return a3.M0;
        }
    }

    public a3() {
        this.I0 = new LinkedHashMap();
        this.K0 = "WhatApp";
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public a3(Feature<Object> feature, WebViewMDA.k kVar) {
        this();
        y8.k.e(feature, "feature");
        y8.k.e(kVar, "clickHandler");
        this.F0 = feature;
        this.G0 = kVar;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public a3(String str, WebViewMDA.k kVar) {
        this();
        y8.k.e(str, "notificationDataJson");
        y8.k.e(kVar, "clickHandler");
        Object i10 = new com.google.gson.e().i(str, NotificationData.class);
        y8.k.d(i10, "Gson().fromJson<Notifica…ficationData::class.java)");
        K2((NotificationData) i10);
        this.F0 = new Feature(E2().messageData.Id, 3, 2);
        this.G0 = kVar;
    }

    private final void G2() {
        p5.d.o(A(), E2());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void I2(final a3 a3Var, JSFunction jSFunction, String str) {
        y8.k.e(a3Var, "this$0");
        if (str == null) {
            return;
        }
        a3Var.F2();
        StringBuilder sb2 = new StringBuilder();
        sb2.append("loadJavaScriptFunc(");
        sb2.append(jSFunction.getFunction());
        sb2.append(") result: ");
        sb2.append(Boolean.parseBoolean(str));
        if (!Boolean.parseBoolean(str)) {
            a3Var.G2();
            return;
        }
        androidx.fragment.app.j t10 = a3Var.t();
        if (t10 == null) {
            return;
        }
        t10.runOnUiThread(new Runnable() { // from class: f6.z2
            @Override // java.lang.Runnable
            public final void run() {
                a3.J2(a3.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void J2(a3 a3Var) {
        y8.k.e(a3Var, "this$0");
        w6.l0.X0(a3Var.t(), 200);
        w6.m0.c(a3Var.t(), m0.d.tweet);
    }

    public void B2() {
        this.I0.clear();
    }

    public final NotificationData E2() {
        NotificationData notificationData = this.J0;
        if (notificationData != null) {
            return notificationData;
        }
        y8.k.o("notificationData");
        return null;
    }

    public final String F2() {
        return this.K0;
    }

    public final void H2(String str) {
        y8.k.e(str, "notificationDataJson");
        Object i10 = new com.google.gson.e().i(str, NotificationData.class);
        y8.k.d(i10, "Gson().fromJson<Notifica…ficationData::class.java)");
        K2((NotificationData) i10);
        y8.k.j("Payload: ", E2().messageData.Payload);
        final JSFunction jSFunction = (JSFunction) new com.google.gson.e().i(E2().messageData.Payload, JSFunction.class);
        this.A0.l(jSFunction.getFunction(), jSFunction.getData(), new WebViewMDA.j() { // from class: f6.y2
            @Override // com.groboot.mdaemergency.ui.views.WebViewMDA.j
            public final void a(String str2) {
                a3.I2(a3.this, jSFunction, str2);
            }
        });
    }

    @Override // f6.h1, androidx.fragment.app.e, androidx.fragment.app.Fragment
    public /* synthetic */ void I0() {
        super.I0();
        B2();
    }

    public final void K2(NotificationData notificationData) {
        y8.k.e(notificationData, "<set-?>");
        this.J0 = notificationData;
    }

    @Override // f6.h1, a6.a, androidx.fragment.app.Fragment
    public void W0() {
        super.W0();
    }
}
