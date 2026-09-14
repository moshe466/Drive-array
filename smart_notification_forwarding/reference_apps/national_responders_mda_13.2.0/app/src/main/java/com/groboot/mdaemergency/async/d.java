package com.groboot.mdaemergency.async;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import com.groboot.mdaemergency.MdaEmergencyApplication;
import com.groboot.mdaemergency.async.b;
import com.groboot.mdaemergency.async.d;
import com.groboot.mdaemergency.enums.b;
import com.groboot.mdaemergency.models.AppSettings;
import com.groboot.mdaemergency.models.AppUser;
import com.groboot.mdaemergency.models.CoronaBarcode;
import com.groboot.mdaemergency.models.CoronaBarcodePatient;
import com.groboot.mdaemergency.models.DeliveryObject;
import com.groboot.mdaemergency.models.EligibilityCheck;
import com.groboot.mdaemergency.models.Event;
import com.groboot.mdaemergency.models.Feature;
import com.groboot.mdaemergency.models.FilingComplaint;
import com.groboot.mdaemergency.models.InfectiousDiseaseReportData;
import com.groboot.mdaemergency.models.Message;
import com.groboot.mdaemergency.models.MessageByIdClass;
import com.groboot.mdaemergency.models.OnCallParameter;
import com.groboot.mdaemergency.models.OnCallParameterAnswer;
import com.groboot.mdaemergency.models.PttSettings;
import com.groboot.mdaemergency.models.ReportMessageRequestData;
import com.groboot.mdaemergency.models.SamplerShift;
import com.groboot.mdaemergency.models.SerologyQuestionnaire;
import com.groboot.mdaemergency.models.SettingSound;
import com.groboot.mdaemergency.models.SettingsList;
import com.groboot.mdaemergency.models.SettingsListGroup;
import com.groboot.mdaemergency.models.location.ReportLocationParams;
import g5.e;
import il.org.mda.health.R;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;
import w6.h0;
import w6.l0;
import w6.y;
import w6.z;

/* loaded from: classes.dex */
public class d {

    /* renamed from: m, reason: collision with root package name */
    private static d f7630m;

    /* renamed from: a, reason: collision with root package name */
    Hashtable<String, u> f7631a;

    /* renamed from: b, reason: collision with root package name */
    Activity f7632b;

    /* renamed from: c, reason: collision with root package name */
    public List<Event> f7633c;

    /* renamed from: d, reason: collision with root package name */
    public List<Message> f7634d;

    /* renamed from: e, reason: collision with root package name */
    public List<Feature> f7635e;

    /* renamed from: f, reason: collision with root package name */
    public AppSettings f7636f;

    /* renamed from: g, reason: collision with root package name */
    public String f7637g;

    /* renamed from: h, reason: collision with root package name */
    public Boolean f7638h = Boolean.FALSE;

    /* renamed from: i, reason: collision with root package name */
    private String f7639i;

    /* renamed from: j, reason: collision with root package name */
    public v f7640j;

    /* renamed from: k, reason: collision with root package name */
    q f7641k;

    /* renamed from: l, reason: collision with root package name */
    com.groboot.mdaemergency.async.b f7642l;

    /* loaded from: classes.dex */
    class a implements b.InterfaceC0098b {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ b.InterfaceC0098b f7643a;

        /* renamed from: com.groboot.mdaemergency.async.d$a$a, reason: collision with other inner class name */
        /* loaded from: classes.dex */
        class C0099a extends e5.a<List<SettingsListGroup>> {
            C0099a(a aVar) {
            }
        }

        a(b.InterfaceC0098b interfaceC0098b) {
            this.f7643a = interfaceC0098b;
        }

        @Override // com.groboot.mdaemergency.async.b.InterfaceC0098b
        public void a(b.a aVar) {
            if (aVar != null && aVar.f7614b) {
                try {
                    d.this.f7636f.Settings = (List) new com.google.gson.e().j(aVar.d("Settings").toString(), new C0099a(this).e());
                } catch (Exception unused) {
                }
            }
            this.f7643a.a(aVar);
        }
    }

    /* loaded from: classes.dex */
    class b implements b.InterfaceC0098b {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ b.InterfaceC0098b f7645a;

        /* loaded from: classes.dex */
        class a extends e5.a<List<SettingsListGroup>> {
            a(b bVar) {
            }
        }

        /* renamed from: com.groboot.mdaemergency.async.d$b$b, reason: collision with other inner class name */
        /* loaded from: classes.dex */
        class C0100b extends e5.a<List<SettingSound>> {
            C0100b(b bVar) {
            }
        }

        b(b.InterfaceC0098b interfaceC0098b) {
            this.f7645a = interfaceC0098b;
        }

        @Override // com.groboot.mdaemergency.async.b.InterfaceC0098b
        public void a(b.a aVar) {
            if (aVar.f7614b) {
                try {
                    if (aVar.f("Settings") && !aVar.h("Settings")) {
                        d.this.f7636f.Settings = (List) new com.google.gson.e().j(aVar.d("Settings").toString(), new a(this).e());
                    }
                    if (aVar.f("SettingsSound") && !aVar.h("SettingsSound")) {
                        d.this.f7636f.SettingsSound = (List) new com.google.gson.e().j(aVar.d("SettingsSound").toString(), new C0100b(this).e());
                    }
                } catch (Exception unused) {
                }
            }
            this.f7645a.a(aVar);
        }
    }

    /* loaded from: classes.dex */
    class c implements b.InterfaceC0098b {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ r f7647a;

        c(d dVar, r rVar) {
            this.f7647a = rVar;
        }

        @Override // com.groboot.mdaemergency.async.b.InterfaceC0098b
        public void a(b.a aVar) {
            if (aVar == null) {
                this.f7647a.a(null);
            } else {
                this.f7647a.a((OnCallParameterAnswer) new com.google.gson.e().i(aVar.f7616d, OnCallParameterAnswer.class));
            }
        }
    }

    /* renamed from: com.groboot.mdaemergency.async.d$d, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    class C0101d implements b.InterfaceC0098b {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ r f7648a;

        C0101d(d dVar, r rVar) {
            this.f7648a = rVar;
        }

        @Override // com.groboot.mdaemergency.async.b.InterfaceC0098b
        public void a(b.a aVar) {
            if (aVar == null) {
                return;
            }
            this.f7648a.a((OnCallParameterAnswer) new com.google.gson.e().i(aVar.f7616d, OnCallParameterAnswer.class));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class e implements b.InterfaceC0098b {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Activity f7649a;

        e(Activity activity) {
            this.f7649a = activity;
        }

        @Override // com.groboot.mdaemergency.async.b.InterfaceC0098b
        public void a(b.a aVar) {
            d.this.O(this.f7649a, aVar);
        }
    }

    /* loaded from: classes.dex */
    static /* synthetic */ class f {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f7651a;

        static {
            int[] iArr = new int[v.values().length];
            f7651a = iArr;
            try {
                iArr[v.MADA.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f7651a[v.DEV.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f7651a[v.DEBUG.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f7651a[v.PROGRAMMER1.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f7651a[v.PROGRAMMER2.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f7651a[v.PROGRAMMER3.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f7651a[v.PHILIPINE.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class g implements b.InterfaceC0098b {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ p f7652a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Context f7653b;

        g(p pVar, Context context) {
            this.f7652a = pVar;
            this.f7653b = context;
        }

        @Override // com.groboot.mdaemergency.async.b.InterfaceC0098b
        public void a(b.a aVar) {
            p pVar = this.f7652a;
            pVar.f7681b = false;
            pVar.f7682c = aVar.f7614b;
            g5.b.i(this.f7653b).l(d.this.f7641k);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class h implements b.InterfaceC0098b {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Activity f7655a;

        h(d dVar, Activity activity) {
            this.f7655a = activity;
        }

        @Override // com.groboot.mdaemergency.async.b.InterfaceC0098b
        public void a(b.a aVar) {
            if (com.groboot.mdaemergency.ptt.p.c0() != null) {
                com.groboot.mdaemergency.ptt.p.c0().z0(null);
            }
            Activity activity = this.f7655a;
            if (activity != null) {
                a6.h.n(activity);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class i implements b.InterfaceC0098b {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ t f7656a;

        i(d dVar, t tVar) {
            this.f7656a = tVar;
        }

        @Override // com.groboot.mdaemergency.async.b.InterfaceC0098b
        public void a(b.a aVar) {
            y yVar;
            if (aVar != null) {
                try {
                    if (aVar.f7614b && (yVar = (y) new com.google.gson.e().i(aVar.f7616d, y.class)) != null && yVar.f15294a) {
                        this.f7656a.a(yVar.f15295b);
                        return;
                    }
                } catch (Exception unused) {
                }
            }
            this.f7656a.b();
        }
    }

    /* loaded from: classes.dex */
    class j implements b.InterfaceC0098b {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Activity f7657a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ b.InterfaceC0098b f7658b;

        j(Activity activity, b.InterfaceC0098b interfaceC0098b) {
            this.f7657a = activity;
            this.f7658b = interfaceC0098b;
        }

        @Override // com.groboot.mdaemergency.async.b.InterfaceC0098b
        public void a(b.a aVar) {
            if (aVar == null) {
                return;
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append("ServerManager callback. res:");
            sb2.append(aVar.f7616d);
            d.this.N(this.f7657a, aVar);
            this.f7658b.a(aVar);
        }
    }

    /* loaded from: classes.dex */
    class k implements b.InterfaceC0098b {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ x f7660a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ JSONObject f7661b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ h0 f7662c;

        k(d dVar, x xVar, JSONObject jSONObject, h0 h0Var) {
            this.f7660a = xVar;
            this.f7661b = jSONObject;
            this.f7662c = h0Var;
        }

        @Override // com.groboot.mdaemergency.async.b.InterfaceC0098b
        public void a(b.a aVar) {
            x xVar;
            String str;
            JSONObject jSONObject;
            if (aVar == null) {
                this.f7660a.a(l0.v().getString(R.string.server_fault_try_again));
                return;
            }
            if (!aVar.f7614b) {
                if (l0.l0(aVar.f7616d)) {
                    xVar = this.f7660a;
                    str = aVar.f7617e;
                } else {
                    w6.a aVar2 = (w6.a) new com.google.gson.e().i(aVar.f7616d, w6.a.class);
                    xVar = this.f7660a;
                    str = aVar2.f15110b;
                }
                xVar.a(str);
                return;
            }
            w6.a aVar3 = (w6.a) new com.google.gson.e().i(aVar.f7616d, w6.a.class);
            if (!aVar3.f15109a) {
                this.f7660a.a(aVar3.f15110b);
                return;
            }
            this.f7660a.b(aVar.f7616d);
            JSONObject jSONObject2 = null;
            try {
                jSONObject = new JSONObject();
                try {
                    this.f7661b.put("Token", this.f7662c.f15174d);
                    jSONObject.put("RequestHeader", this.f7661b);
                    jSONObject.put("RequestData", this.f7662c.f15175e);
                } catch (JSONException unused) {
                    jSONObject2 = jSONObject;
                    jSONObject = jSONObject2;
                    new JSONObject().put("request", jSONObject.toString());
                }
            } catch (JSONException unused2) {
            }
            try {
                new JSONObject().put("request", jSONObject.toString());
            } catch (JSONException unused3) {
            }
        }
    }

    /* loaded from: classes.dex */
    class l implements b.InterfaceC0098b {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Context f7663a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ w f7664b;

        l(Context context, w wVar) {
            this.f7663a = context;
            this.f7664b = wVar;
        }

        @Override // com.groboot.mdaemergency.async.b.InterfaceC0098b
        public void a(b.a aVar) {
            w wVar;
            StringBuilder sb2;
            String str;
            Message message;
            if (aVar == null) {
                return;
            }
            StringBuilder sb3 = new StringBuilder();
            sb3.append("ServerManager callback. res:");
            String str2 = aVar.f7616d;
            if (str2 == null) {
                str2 = "";
            }
            sb3.append(str2);
            d dVar = d.this;
            Context context = this.f7663a;
            dVar.N(context instanceof Activity ? (Activity) context : null, aVar);
            if (aVar.f7614b) {
                MessageByIdClass messageByIdClass = (MessageByIdClass) new com.google.gson.e().i(aVar.f7616d, MessageByIdClass.class);
                if (messageByIdClass != null && (message = messageByIdClass.Message) != null) {
                    this.f7664b.b(message);
                    return;
                }
                wVar = this.f7664b;
                sb2 = new StringBuilder();
                sb2.append("Json not convert:");
                str = aVar.f7616d;
            } else {
                wVar = this.f7664b;
                sb2 = new StringBuilder();
                sb2.append(this.f7663a.getString(R.string.problem_in_server));
                str = aVar.f7617e;
            }
            sb2.append(str);
            wVar.a(sb2.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class m implements b.InterfaceC0098b {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ boolean f7666a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f7667b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ int f7668c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Location f7669d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ int f7670e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ b.InterfaceC0098b f7671f;

        /* loaded from: classes.dex */
        class a extends TimerTask {
            a() {
            }

            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                m mVar = m.this;
                d.this.b0(mVar.f7666a, mVar.f7668c, mVar.f7669d, mVar.f7670e, mVar.f7667b + 1, mVar.f7671f);
            }
        }

        m(boolean z10, int i10, int i11, Location location, int i12, b.InterfaceC0098b interfaceC0098b) {
            this.f7666a = z10;
            this.f7667b = i10;
            this.f7668c = i11;
            this.f7669d = location;
            this.f7670e = i12;
            this.f7671f = interfaceC0098b;
        }

        @Override // com.groboot.mdaemergency.async.b.InterfaceC0098b
        public void a(b.a aVar) {
            if (aVar == null) {
                return;
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Response: ");
            String str = aVar.f7616d;
            if (str == null) {
                str = aVar.f7614b + "";
            }
            sb2.append(str);
            if (!aVar.f7614b && this.f7666a) {
                StringBuilder sb3 = new StringBuilder();
                sb3.append("server respons - faild ");
                sb3.append(this.f7667b + 1);
                sb3.append(" times! errorCode: ");
                sb3.append(aVar.f7618f);
                sb3.append(" error message: ");
                sb3.append(aVar.f7617e);
                if (this.f7667b < 3) {
                    new Timer().schedule(new a(), TimeUnit.MINUTES.toMillis(5L));
                } else {
                    StringBuilder sb4 = new StringBuilder();
                    sb4.append("try ");
                    sb4.append(this.f7667b);
                    sb4.append("times, not success");
                }
            }
            b.InterfaceC0098b interfaceC0098b = this.f7671f;
            if (interfaceC0098b != null) {
                interfaceC0098b.a(aVar);
            }
        }
    }

    /* loaded from: classes.dex */
    class n implements Runnable {

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ Activity f7674f;

        /* loaded from: classes.dex */
        class a implements b.InterfaceC0098b {
            a() {
            }

            @Override // com.groboot.mdaemergency.async.b.InterfaceC0098b
            public void a(b.a aVar) {
                n nVar = n.this;
                d.this.O(nVar.f7674f, aVar);
            }
        }

        n(Activity activity) {
            this.f7674f = activity;
        }

        @Override // java.lang.Runnable
        public void run() {
            d dVar = d.this;
            dVar.f7632b = this.f7674f;
            JSONObject jSONObject = null;
            try {
                jSONObject = dVar.y("Messages", "GetMessages", true);
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("DeleteEvents", false);
                jSONObject2.put("DeleteMessages", false);
                jSONObject.put("RequestData", jSONObject2.toString());
            } catch (JSONException unused) {
            }
            JSONObject jSONObject3 = new JSONObject();
            try {
                jSONObject3.put("request", jSONObject.toString());
            } catch (JSONException unused2) {
            }
            d.this.u0(jSONObject3.toString(), true, new a());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class o implements Runnable {

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ b.a f7677f;

        /* renamed from: g, reason: collision with root package name */
        final /* synthetic */ Activity f7678g;

        /* loaded from: classes.dex */
        class a extends e5.a<List<Message>> {
            a(o oVar) {
            }
        }

        /* loaded from: classes.dex */
        class b extends e5.a<List<Feature>> {
            b(o oVar) {
            }
        }

        o(b.a aVar, Activity activity) {
            this.f7677f = aVar;
            this.f7678g = activity;
        }

        @Override // java.lang.Runnable
        public void run() {
            b.a aVar = this.f7677f;
            if (aVar == null || !aVar.f7614b) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("ERROR\n");
                sb2.append(this.f7677f);
                for (u uVar : d.this.f7631a.values()) {
                    b.a aVar2 = this.f7677f;
                    if (aVar2 != null) {
                        uVar.a(aVar2.f7617e);
                    } else if (!l0.k0(this.f7678g)) {
                        b.a aVar3 = new b.a(false);
                        String string = this.f7678g.getString(R.string.no_internet);
                        aVar3.f7617e = string;
                        uVar.a(string);
                    }
                }
                return;
            }
            if (aVar.f7613a == null) {
                return;
            }
            if (aVar.f("UpdateRequired") && !this.f7677f.h("UpdateRequired") && this.f7677f.b("UpdateRequired")) {
                String packageName = this.f7678g.getPackageName();
                try {
                    this.f7678g.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=" + packageName)));
                    return;
                } catch (ActivityNotFoundException unused) {
                    this.f7678g.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("http://play.google.com/store/apps/details?id=" + packageName)));
                    return;
                }
            }
            if (this.f7677f.b("TokenIsInvalid")) {
                StringBuilder sb3 = new StringBuilder();
                sb3.append("TokenIsInvalid.    data: ");
                sb3.append(this.f7677f.f7616d);
                w6.m.c();
                a6.h.n(this.f7678g);
                this.f7678g.finish();
                return;
            }
            com.google.gson.e eVar = new com.google.gson.e();
            d.this.f7634d = null;
            if (this.f7677f.f("Messages") && !this.f7677f.h("Messages")) {
                d.this.f7634d = (List) eVar.j(this.f7677f.d("Messages").toString(), new a(this).e());
            }
            if (this.f7677f.f("AppSettings") && !this.f7677f.h("AppSettings")) {
                d.this.f7636f = (AppSettings) new com.google.gson.e().i(this.f7677f.e("AppSettings"), AppSettings.class);
            }
            if (this.f7677f.f("Features") && !this.f7677f.h("Features")) {
                d.this.f7635e = (List) eVar.j(this.f7677f.d("Features").toString(), new b(this).e());
            }
            if (this.f7677f.f("FullName") && !this.f7677f.h("FullName")) {
                w6.m.F0(this.f7677f.e("FullName"));
            }
            if (this.f7677f.f("ShowHealthDeclaration") && !this.f7677f.h("ShowHealthDeclaration")) {
                d.this.f7638h = Boolean.valueOf(this.f7677f.b("ShowHealthDeclaration"));
            }
            d.this.f7637g = this.f7677f.e("FH");
            for (u uVar2 : d.this.f7631a.values()) {
                d dVar = d.this;
                uVar2.c(dVar.f7633c, dVar.f7634d, dVar.f7637g, dVar.f7638h.booleanValue());
                uVar2.b(d.this.f7635e);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class p {

        /* renamed from: a, reason: collision with root package name */
        public String f7680a;

        /* renamed from: b, reason: collision with root package name */
        public boolean f7681b;

        /* renamed from: c, reason: collision with root package name */
        public boolean f7682c;
    }

    /* loaded from: classes.dex */
    public static class q extends ArrayList<p> {
    }

    /* loaded from: classes.dex */
    public interface r {
        void a(OnCallParameterAnswer onCallParameterAnswer);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class s {
        s(d dVar) {
        }
    }

    /* loaded from: classes.dex */
    public interface t {
        void a(y.a aVar);

        void b();
    }

    /* loaded from: classes.dex */
    public interface u {
        void a(String str);

        void b(List<Feature> list);

        void c(List<Event> list, List<Message> list2, String str, boolean z10);
    }

    /* loaded from: classes.dex */
    public enum v {
        MADA,
        DEV,
        DEBUG,
        PROGRAMMER1,
        PROGRAMMER2,
        PROGRAMMER3,
        PHILIPINE;

        public static v getDefault() {
            return w6.m.m() == com.groboot.mdaemergency.enums.a.PHILIPINE ? PHILIPINE : MADA;
        }
    }

    /* loaded from: classes.dex */
    public interface w {
        void a(String str);

        void b(Message message);
    }

    @SuppressLint({"NewApi"})
    /* loaded from: classes.dex */
    public interface x {
        void a(String str);

        void b(String str);
    }

    private d(Context context) {
        String str = w6.d.f15129d;
        this.f7631a = new Hashtable<>();
        this.f7639i = w6.m.I();
        this.f7640j = w6.m.H();
        this.f7641k = g5.b.i(context).g();
    }

    private void G(String str, w6.r rVar, w6.r rVar2, t tVar) {
        JSONObject jSONObject = null;
        try {
            jSONObject = y("PTT", "GetPTTUsers", true);
            s sVar = new s(this);
            l0.a0(str);
            if (rVar != null) {
                rVar.u();
            }
            if (rVar2 != null) {
                rVar2.u();
            }
            jSONObject.put("RequestData", new com.google.gson.e().r(sVar).toString());
        } catch (JSONException unused) {
        }
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("request", jSONObject.toString());
        } catch (JSONException unused2) {
        }
        u0(jSONObject2.toString(), true, new i(this, tVar));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void N(Activity activity, b.a aVar) {
        try {
            if (aVar.f7614b) {
                if (aVar.f("UpdateRequired") && !aVar.h("UpdateRequired") && aVar.b("UpdateRequired")) {
                    String packageName = this.f7632b.getPackageName();
                    try {
                        this.f7632b.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=" + packageName)));
                    } catch (ActivityNotFoundException unused) {
                        this.f7632b.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("http://play.google.com/store/apps/details?id=" + packageName)));
                    }
                } else if (aVar.b("TokenIsInvalid")) {
                    S(new h(this, activity));
                }
            }
        } catch (Exception unused2) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void O(Activity activity, b.a aVar) {
        new Thread(new o(aVar, activity)).start();
    }

    public static void P(Context context) {
        f7630m = new d(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void R(r rVar, b.a aVar) {
        rVar.a((OnCallParameterAnswer) new com.google.gson.e().i(aVar.f7616d, OnCallParameterAnswer.class));
    }

    private b.InterfaceC0098b e0(Activity activity) {
        return new e(activity);
    }

    public static String s() {
        return w6.m.m().serverUrl();
    }

    private void t0(com.groboot.mdaemergency.async.b bVar) {
        if (Build.VERSION.SDK_INT >= 11) {
            bVar.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
        } else {
            bVar.execute(new Void[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u0(String str, boolean z10, b.InterfaceC0098b interfaceC0098b) {
        com.groboot.mdaemergency.async.b bVar = new com.groboot.mdaemergency.async.b(str, z10, interfaceC0098b);
        if (Build.VERSION.SDK_INT >= 11) {
            bVar.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
        } else {
            bVar.execute(new Void[0]);
        }
    }

    public static d v() {
        return f7630m;
    }

    public static d w(Context context) {
        if (f7630m == null) {
            f7630m = new d(context);
        }
        return v();
    }

    private JSONObject x(int i10, String str, String str2, boolean z10) {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("Application", i10);
        jSONObject2.put("Module", str);
        jSONObject2.put("Function", str2);
        if (z10) {
            String c10 = z.b().c();
            jSONObject2.put("Token", c10);
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Module:");
            sb2.append(str);
            sb2.append(" Function:");
            sb2.append(str2);
            sb2.append(" Token:");
            sb2.append(c10);
        } else {
            StringBuilder sb3 = new StringBuilder();
            sb3.append("Module:");
            sb3.append(str);
            sb3.append(" Function:");
            sb3.append(str2);
            sb3.append(" NoToken");
        }
        jSONObject2.put("AppVersion", MdaEmergencyApplication.f7530g);
        jSONObject.put("RequestHeader", jSONObject2);
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject y(String str, String str2, boolean z10) {
        return x(1, str, str2, z10);
    }

    @SuppressLint({"NewApi"})
    public void A(ReportLocationParams reportLocationParams, b.InterfaceC0098b interfaceC0098b) {
        JSONObject jSONObject = null;
        try {
            jSONObject = y("Report", "GetLocationToAddress", true);
            new JSONObject();
            jSONObject.put("RequestData", new com.google.gson.e().r(reportLocationParams));
        } catch (JSONException unused) {
        }
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("request", jSONObject.toString());
        } catch (JSONException unused2) {
        }
        u0(jSONObject2.toString(), true, interfaceC0098b);
    }

    public void B(Context context, String str, w wVar) {
        JSONObject jSONObject = null;
        try {
            jSONObject = y("Messages", "GetMessageObject", true);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("messageId", str);
            jSONObject.put("RequestData", jSONObject2.toString());
        } catch (JSONException unused) {
        }
        JSONObject jSONObject3 = new JSONObject();
        try {
            jSONObject3.put("request", jSONObject.toString());
        } catch (JSONException unused2) {
        }
        u0(jSONObject3.toString(), true, new l(context, wVar));
    }

    @SuppressLint({"NewApi"})
    public void C(Activity activity, String str, b.InterfaceC0098b interfaceC0098b) {
        try {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("ServerManager id:");
            sb2.append(l0.o(str, 12));
        } catch (Exception e10) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append("ServerManager error:");
            sb3.append(e10.getMessage());
        }
        JSONObject jSONObject = null;
        try {
            jSONObject = y("Messages", "GetMessageContent", true);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("MessageID", str);
            jSONObject.put("RequestData", jSONObject2.toString());
        } catch (JSONException unused) {
        }
        JSONObject jSONObject3 = new JSONObject();
        try {
            jSONObject3.put("request", jSONObject.toString());
        } catch (JSONException unused2) {
        }
        u0(jSONObject3.toString(), true, new j(activity, interfaceC0098b));
    }

    @SuppressLint({"NewApi"})
    public void D(Activity activity) {
        new Thread(new n(activity)).start();
    }

    @SuppressLint({"NewApi"})
    public void E(String str, b.InterfaceC0098b interfaceC0098b) {
        JSONObject jSONObject = null;
        try {
            jSONObject = y("InfectiousDiseaseSampleTransport", "GetOpenBarcodes", true);
            jSONObject.put("RequestData", str);
        } catch (JSONException unused) {
        }
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("request", jSONObject.toString());
        } catch (JSONException unused2) {
        }
        u0(jSONObject2.toString(), true, interfaceC0098b);
    }

    public void F(String str, t tVar) {
        G(str, null, null, tVar);
    }

    public void H(w6.r rVar, w6.r rVar2, t tVar) {
        G("", rVar, rVar2, tVar);
    }

    @SuppressLint({"NewApi"})
    public void I(ArrayList<String> arrayList, b.InterfaceC0098b interfaceC0098b) {
        JSONObject jSONObject = null;
        try {
            jSONObject = y("PTT", "GetContactsByIds", true);
            jSONObject.put("RequestData", new com.google.gson.e().r(arrayList));
        } catch (JSONException unused) {
        }
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("request", jSONObject.toString());
        } catch (JSONException unused2) {
        }
        u0(jSONObject2.toString(), true, interfaceC0098b);
    }

    @SuppressLint({"NewApi"})
    public void J(UUID uuid, b.InterfaceC0098b interfaceC0098b) {
        JSONObject jSONObject = null;
        try {
            jSONObject = y("Report", "GetSerologyQuestionnaire", true);
            jSONObject.put("RequestData", uuid);
        } catch (JSONException unused) {
        }
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("request", jSONObject.toString());
        } catch (JSONException unused2) {
        }
        u0(jSONObject2.toString(), true, interfaceC0098b);
    }

    public String K() {
        return this.f7639i;
    }

    @SuppressLint({"NewApi"})
    public void L(b.InterfaceC0098b interfaceC0098b) {
        JSONObject jSONObject;
        try {
            jSONObject = y("Shift", "GetShiftData", true);
        } catch (JSONException unused) {
            jSONObject = null;
        }
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("request", jSONObject.toString());
        } catch (JSONException unused2) {
        }
        u0(jSONObject2.toString(), true, interfaceC0098b);
    }

    @SuppressLint({"NewApi"})
    public void M(String str, b.InterfaceC0098b interfaceC0098b) {
        JSONObject jSONObject = null;
        try {
            jSONObject = y("PTT", "GetUserStatus", true);
            jSONObject.put("RequestData", new com.google.gson.e().r(str));
        } catch (JSONException unused) {
        }
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("request", jSONObject.toString());
        } catch (JSONException unused2) {
        }
        u0(jSONObject2.toString(), true, interfaceC0098b);
    }

    public boolean Q() {
        return K().equals(s());
    }

    @SuppressLint({"NewApi"})
    public void S(b.InterfaceC0098b interfaceC0098b) {
        JSONObject jSONObject;
        try {
            jSONObject = y("Register", "LogOut", true);
        } catch (Exception unused) {
            jSONObject = null;
        }
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("request", jSONObject.toString());
        } catch (JSONException unused2) {
        }
        u0(jSONObject2.toString(), true, interfaceC0098b);
    }

    @SuppressLint({"NewApi"})
    public void T(OnCallParameter onCallParameter, r rVar) {
        JSONObject jSONObject = null;
        try {
            jSONObject = y("OnCall", "Post", true);
            new JSONObject();
            jSONObject.put("RequestData", new com.google.gson.e().r(onCallParameter));
        } catch (JSONException unused) {
        }
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("request", jSONObject.toString());
        } catch (JSONException unused2) {
        }
        u0(jSONObject2.toString(), true, new C0101d(this, rVar));
    }

    @SuppressLint({"NewApi"})
    public void U(x5.m mVar, b.InterfaceC0098b interfaceC0098b) {
        JSONObject jSONObject = null;
        try {
            jSONObject = y("PTT", "OnMessageReceived", true);
            jSONObject.put("RequestData", new com.google.gson.e().r(mVar));
        } catch (JSONException unused) {
        }
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("request", jSONObject.toString());
        } catch (JSONException unused2) {
        }
        u0(jSONObject2.toString(), true, interfaceC0098b);
    }

    @SuppressLint({"NewApi"})
    public void V(AppUser appUser, boolean z10, b.InterfaceC0098b interfaceC0098b) {
        JSONObject jSONObject = null;
        try {
            jSONObject = y("Register", "RegisterStep1v1", false);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("Phone", appUser.getPhone());
            jSONObject2.put("ID", appUser.getID());
            jSONObject2.put("Type", appUser.getType());
            jSONObject2.put("DateOfBirth", appUser.getDateOfBirth());
            jSONObject2.put("isVoiceOTP", z10);
            jSONObject2.put("Code", appUser.getCode());
            jSONObject2.put("DeviceType", appUser.getDeviceType());
            jSONObject2.put("AppVersion", appUser.getAppVersion());
            jSONObject2.put("DeviceName", appUser.getDeviceName());
            jSONObject2.put("IsHealthApp", w6.m.m() == com.groboot.mdaemergency.enums.a.CREW);
            jSONObject2.put("token0", n5.a.a().b(false));
            jSONObject2.put("token1", n5.a.a().c(false));
            jSONObject2.put("token2", n5.a.a().d(false));
            jSONObject2.put("token3", n5.a.a().e(false));
            jSONObject2.put("token4", n5.a.a().f(false));
            jSONObject2.put("token5", n5.a.a().g(false));
            jSONObject2.put("token6", n5.a.a().h(false));
            jSONObject2.put("token7", n5.a.a().i(false));
            jSONObject2.put("token8", n5.a.a().j(false));
            jSONObject2.put("token9", n5.a.a().k(false));
            jSONObject.put("RequestData", jSONObject2.toString());
        } catch (JSONException unused) {
        }
        JSONObject jSONObject3 = new JSONObject();
        try {
            jSONObject3.put("request", jSONObject.toString());
        } catch (JSONException unused2) {
        }
        u0(jSONObject3.toString(), true, interfaceC0098b);
    }

    @SuppressLint({"NewApi"})
    public void W(AppUser appUser, String str, String str2, String str3, com.groboot.mdaemergency.enums.e eVar, b.InterfaceC0098b interfaceC0098b) {
        JSONObject jSONObject = null;
        try {
            jSONObject = y("Register", "RegisterStep2v1", false);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("Phone", appUser.getPhone());
            jSONObject2.put("ID", appUser.getID());
            jSONObject2.put("Type", appUser.getType());
            jSONObject2.put("DateOfBirth", appUser.getDateOfBirth());
            jSONObject2.put("Code", appUser.getCode());
            jSONObject2.put("DeviceID", appUser.getDeviceID());
            jSONObject2.put("TempToken", str);
            jSONObject2.put("SMSCode", str3);
            jSONObject2.put("DeviceType", appUser.getDeviceType());
            jSONObject2.put("AppVersion", appUser.getAppVersion());
            jSONObject2.put("OSVersion", appUser.getOSVersion());
            jSONObject2.put("DeviceName", appUser.getDeviceName());
            jSONObject2.put("pushToken", str2);
            jSONObject2.put("LanguageType", eVar.getId());
            jSONObject2.put("token0", n5.a.a().b(true));
            jSONObject2.put("token1", n5.a.a().c(true));
            jSONObject2.put("token2", n5.a.a().d(true));
            jSONObject2.put("token3", n5.a.a().e(true));
            jSONObject2.put("token4", n5.a.a().f(true));
            jSONObject2.put("token5", n5.a.a().g(true));
            jSONObject2.put("token6", n5.a.a().h(true));
            jSONObject2.put("token7", n5.a.a().i(true));
            jSONObject2.put("token8", n5.a.a().j(true));
            jSONObject2.put("token9", n5.a.a().k(true));
            jSONObject.put("RequestData", jSONObject2.toString());
        } catch (JSONException unused) {
        }
        JSONObject jSONObject3 = new JSONObject();
        try {
            jSONObject3.put("request", jSONObject.toString());
        } catch (JSONException unused2) {
        }
        u0(jSONObject3.toString(), true, interfaceC0098b);
    }

    public void X(String str) {
        if (this.f7631a.contains(str)) {
            this.f7631a.remove(str);
        }
    }

    @SuppressLint({"NewApi"})
    public void Y(int i10, b.InterfaceC0098b interfaceC0098b) {
        JSONObject jSONObject = null;
        try {
            jSONObject = y("Report", "ReportAccuracyMode", true);
            new JSONObject();
            jSONObject.put("RequestData", i10);
        } catch (JSONException unused) {
        }
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("request", jSONObject.toString());
        } catch (JSONException unused2) {
        }
        u0(jSONObject2.toString(), true, interfaceC0098b);
    }

    @SuppressLint({"NewApi"})
    public void Z(com.groboot.mdaemergency.enums.e eVar, b.InterfaceC0098b interfaceC0098b) {
        try {
            JSONObject y10 = y("Report", "ReportLanguage", true);
            y10.put("RequestData", eVar.getId());
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("request", y10.toString());
            u0(jSONObject.toString(), true, new b(interfaceC0098b));
        } catch (JSONException unused) {
        }
    }

    public void a0(Location location, com.groboot.mdaemergency.enums.b bVar, int i10, b.InterfaceC0098b interfaceC0098b) {
        if (bVar == null) {
            return;
        }
        b0(bVar.getTrackingType() == b.a.SLEEPY, bVar.getNum(), location, i10, 0, interfaceC0098b);
        g5.b.i(MdaEmergencyApplication.b()).f("lastLocSent", new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").format(new Date()) + " @B");
    }

    @SuppressLint({"NewApi"})
    public void b(final r rVar) {
        JSONObject jSONObject = null;
        try {
            jSONObject = y("OnCall", "Delete", true);
            jSONObject.put("RequestData", new JSONObject().toString());
        } catch (JSONException unused) {
        }
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("request", jSONObject.toString());
        } catch (JSONException unused2) {
        }
        u0(jSONObject2.toString(), true, new b.InterfaceC0098b() { // from class: o5.k
            @Override // com.groboot.mdaemergency.async.b.InterfaceC0098b
            public final void a(b.a aVar) {
                com.groboot.mdaemergency.async.d.R(d.r.this, aVar);
            }
        });
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0171 A[Catch: Exception -> 0x018d, TryCatch #0 {Exception -> 0x018d, blocks: (B:24:0x016a, B:26:0x0171, B:30:0x0180), top: B:23:0x016a }] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0180 A[Catch: Exception -> 0x018d, TRY_LEAVE, TryCatch #0 {Exception -> 0x018d, blocks: (B:24:0x016a, B:26:0x0171, B:30:0x0180), top: B:23:0x016a }] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0131 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @android.annotation.SuppressLint({"NewApi"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void b0(boolean r14, int r15, android.location.Location r16, int r17, int r18, com.groboot.mdaemergency.async.b.InterfaceC0098b r19) {
        /*
            Method dump skipped, instructions count: 419
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.groboot.mdaemergency.async.d.b0(boolean, int, android.location.Location, int, int, com.groboot.mdaemergency.async.b$b):void");
    }

    @SuppressLint({"NewApi"})
    public void c0(int i10, Location location, int i11, b.InterfaceC0098b interfaceC0098b) {
        b0(true, i10, location, i11, 0, interfaceC0098b);
        g5.b.i(MdaEmergencyApplication.b()).f("lastLocSent", new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").format(new Date()) + " @A");
    }

    @SuppressLint({"NewApi"})
    public void d0(Activity activity, String str, String str2, String str3) {
        JSONObject jSONObject = null;
        try {
            jSONObject = y("Report", "ReportMessage", true);
            ReportMessageRequestData reportMessageRequestData = new ReportMessageRequestData();
            reportMessageRequestData.Data = str;
            reportMessageRequestData.MessageID = str2;
            reportMessageRequestData.Refresh = str3;
            jSONObject.put("RequestData", new com.google.gson.e().r(reportMessageRequestData));
        } catch (JSONException unused) {
        }
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("request", jSONObject.toString());
        } catch (JSONException unused2) {
        }
        boolean equals = str3.equals("0");
        String jSONObject3 = jSONObject2.toString();
        if (equals) {
            u0(jSONObject3, false, e0(activity));
        } else {
            u0(jSONObject3, true, e0(activity));
        }
    }

    @SuppressLint({"NewApi"})
    public void f0(Activity activity, SettingsList settingsList, b.InterfaceC0098b interfaceC0098b) {
        JSONObject jSONObject = null;
        try {
            jSONObject = y("Report", "ReportSettings", true);
            jSONObject.put("RequestData", new com.google.gson.e().r(settingsList).toString());
        } catch (JSONException unused) {
        }
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("request", jSONObject.toString());
        } catch (JSONException unused2) {
        }
        u0(jSONObject2.toString(), true, new a(interfaceC0098b));
    }

    public void g(String str, u uVar) {
        if (this.f7631a.contains(str)) {
            this.f7631a.remove(str);
        }
        this.f7631a.put(str, uVar);
    }

    @SuppressLint({"NewApi"})
    public void g0(SerologyQuestionnaire serologyQuestionnaire, b.InterfaceC0098b interfaceC0098b) {
        JSONObject jSONObject = null;
        try {
            jSONObject = y("Report", "SaveSerologyQuestionnaire", true);
            jSONObject.put("RequestData", new com.google.gson.e().r(serologyQuestionnaire));
        } catch (JSONException unused) {
        }
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("request", jSONObject.toString());
        } catch (JSONException unused2) {
        }
        u0(jSONObject2.toString(), true, interfaceC0098b);
    }

    public void h() {
    }

    public void h0(Context context, p pVar) {
        pVar.f7681b = true;
        JSONObject jSONObject = null;
        try {
            jSONObject = y("Report", "UpdateSampleTaken", true);
            jSONObject.put("RequestData", pVar.f7680a);
        } catch (JSONException unused) {
        }
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("request", jSONObject.toString());
        } catch (JSONException unused2) {
        }
        u0(jSONObject2.toString(), true, new g(pVar, context));
    }

    public List<SettingsListGroup> i() {
        AppSettings appSettings = this.f7636f;
        if (appSettings == null || appSettings.Settings == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(this.f7636f.Settings.size());
        for (SettingsListGroup settingsListGroup : this.f7636f.Settings) {
            arrayList.add(new SettingsListGroup(settingsListGroup));
            Iterator<SettingsList> it = settingsListGroup.List.iterator();
            while (it.hasNext()) {
                SettingsList next = it.next();
                if (next.MultiSelect) {
                    next.setSettingType(com.groboot.mdaemergency.enums.j.MultiSelect);
                }
            }
        }
        return arrayList;
    }

    public void i0(Context context, CoronaBarcodePatient coronaBarcodePatient) {
        p pVar = new p();
        pVar.f7680a = coronaBarcodePatient.updateSampleTakenData;
        this.f7641k.add(pVar);
        g5.b.i(context).l(this.f7641k);
        h0(context, pVar);
    }

    @SuppressLint({"NewApi"})
    public void j(EligibilityCheck eligibilityCheck, b.InterfaceC0098b interfaceC0098b) {
        JSONObject jSONObject = null;
        try {
            jSONObject = y("Covid19Tests", "Check", true);
            jSONObject.put("RequestData", new com.google.gson.e().r(eligibilityCheck));
        } catch (JSONException unused) {
        }
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("request", jSONObject.toString());
        } catch (JSONException unused2) {
        }
        u0(jSONObject2.toString(), true, interfaceC0098b);
    }

    public void j0(Context context) {
        q qVar = new q();
        Iterator<p> it = this.f7641k.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            p next = it.next();
            if (next.f7682c) {
                qVar.add(next);
            } else if (!next.f7681b) {
                h0(context, next);
                break;
            }
        }
        if (qVar.size() > 0) {
            this.f7641k.removeAll(qVar);
            g5.b.i(context).l(this.f7641k);
        }
    }

    @SuppressLint({"NewApi"})
    public void k(FilingComplaint filingComplaint, b.InterfaceC0098b interfaceC0098b) {
        JSONObject jSONObject = null;
        try {
            jSONObject = y("Report", "FilingComplaint", true);
            new JSONObject();
            jSONObject.put("RequestData", new com.google.gson.e().r(filingComplaint));
        } catch (JSONException unused) {
        }
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("request", jSONObject.toString());
        } catch (JSONException unused2) {
        }
        u0(jSONObject2.toString(), true, interfaceC0098b);
    }

    @SuppressLint({"NewApi"})
    public void k0(String str, b.InterfaceC0098b interfaceC0098b) {
        JSONObject jSONObject = null;
        try {
            jSONObject = y("Report", "ReportDeviceId", true);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("DeviceId", str);
            jSONObject.put("RequestData", jSONObject2.toString());
        } catch (JSONException unused) {
        }
        JSONObject jSONObject3 = new JSONObject();
        try {
            jSONObject3.put("request", jSONObject.toString());
        } catch (JSONException unused2) {
        }
        u0(jSONObject3.toString(), true, interfaceC0098b);
    }

    @SuppressLint({"NewApi"})
    public void l(String str, b.InterfaceC0098b interfaceC0098b) {
        JSONObject jSONObject = null;
        try {
            jSONObject = y("Report", "GetAddressToLocations", true);
            new JSONObject();
            jSONObject.put("RequestData", str);
        } catch (JSONException unused) {
        }
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("request", jSONObject.toString());
        } catch (JSONException unused2) {
        }
        u0(jSONObject2.toString(), true, interfaceC0098b);
    }

    @SuppressLint({"NewApi"})
    public void l0(x5.m mVar, b.InterfaceC0098b interfaceC0098b) {
        JSONObject jSONObject = null;
        try {
            jSONObject = y("PTT", "OnMessageSent", true);
            jSONObject.put("RequestData", new com.google.gson.e().r(mVar));
        } catch (JSONException unused) {
        }
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("request", jSONObject.toString());
        } catch (JSONException unused2) {
        }
        u0(jSONObject2.toString(), true, interfaceC0098b);
    }

    @SuppressLint({"NewApi"})
    public void m(b.InterfaceC0098b interfaceC0098b) {
        JSONObject jSONObject;
        try {
            jSONObject = y("Report", "GetAmountOfOpenBarcodesBySites", true);
        } catch (JSONException unused) {
            jSONObject = null;
        }
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("request", jSONObject.toString());
        } catch (JSONException unused2) {
        }
        u0(jSONObject2.toString(), true, interfaceC0098b);
    }

    @SuppressLint({"NewApi"})
    public void m0(boolean z10, SamplerShift samplerShift, b.InterfaceC0098b interfaceC0098b) {
        JSONObject jSONObject = null;
        try {
            jSONObject = y("Shift", z10 ? "RemoveShift" : "CreateShift", true);
            jSONObject.put("RequestData", w6.j.b(samplerShift));
        } catch (JSONException unused) {
        }
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("request", jSONObject.toString());
        } catch (JSONException unused2) {
        }
        u0(jSONObject2.toString(), true, interfaceC0098b);
    }

    @SuppressLint({"NewApi"})
    public void n(UUID uuid, b.InterfaceC0098b interfaceC0098b) {
        JSONObject jSONObject = null;
        try {
            jSONObject = y("InfectiousDiseaseSampleTransport", "GetBarcodesByPackage", true);
            jSONObject.put("RequestData", uuid);
        } catch (JSONException unused) {
        }
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("request", jSONObject.toString());
        } catch (JSONException unused2) {
        }
        u0(jSONObject2.toString(), true, interfaceC0098b);
    }

    @SuppressLint({"NewApi"})
    public void n0(String str, b.InterfaceC0098b interfaceC0098b) {
        JSONObject jSONObject = null;
        try {
            jSONObject = y("Report", "ReportPushToken", true);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("PushToken", str);
            jSONObject.put("RequestData", jSONObject2.toString());
        } catch (JSONException unused) {
        }
        JSONObject jSONObject3 = new JSONObject();
        try {
            jSONObject3.put("request", jSONObject.toString());
        } catch (JSONException unused2) {
        }
        u0(jSONObject3.toString(), false, interfaceC0098b);
    }

    @SuppressLint({"NewApi"})
    public void o(r rVar) {
        JSONObject jSONObject = null;
        try {
            jSONObject = y("OnCall", "Get", true);
            jSONObject.put("RequestData", new JSONObject().toString());
        } catch (JSONException unused) {
        }
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("request", jSONObject.toString());
        } catch (JSONException unused2) {
        }
        u0(jSONObject2.toString(), true, new c(this, rVar));
    }

    @SuppressLint({"NewApi"})
    public void o0(ArrayList<DeliveryObject> arrayList, boolean z10, b.InterfaceC0098b interfaceC0098b) {
        JSONObject jSONObject = null;
        try {
            jSONObject = y("InfectiousDiseaseSampleTransport", z10 ? "UpdateDelivery" : "EndDelivery", true);
            jSONObject.put("RequestData", new com.google.gson.e().r(arrayList));
        } catch (JSONException unused) {
        }
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("request", jSONObject.toString());
        } catch (JSONException unused2) {
        }
        u0(jSONObject2.toString(), true, interfaceC0098b);
    }

    @SuppressLint({"NewApi"})
    public void p(CoronaBarcode coronaBarcode, b.InterfaceC0098b interfaceC0098b) {
        JSONObject jSONObject = null;
        try {
            jSONObject = y("InfectiousDiseaseSampleTransport", "GetHealthCareByBarCode", true);
            jSONObject.put("RequestData", coronaBarcode.barcode);
        } catch (JSONException unused) {
        }
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("request", jSONObject.toString());
        } catch (JSONException unused2) {
        }
        u0(jSONObject2.toString(), true, interfaceC0098b);
    }

    @SuppressLint({"NewApi"})
    public void p0(PttSettings pttSettings, b.InterfaceC0098b interfaceC0098b) {
        JSONObject jSONObject = null;
        try {
            jSONObject = y("Report", "PttSettings", true);
            jSONObject.put("RequestData", new com.google.gson.e().r(pttSettings));
        } catch (JSONException unused) {
        }
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("request", jSONObject.toString());
        } catch (JSONException unused2) {
        }
        u0(jSONObject2.toString(), true, interfaceC0098b);
    }

    @SuppressLint({"NewApi"})
    public void q(b.InterfaceC0098b interfaceC0098b) {
        JSONObject jSONObject;
        try {
            jSONObject = y("InfectiousDiseaseSampleTransport", "GetData", true);
        } catch (JSONException unused) {
            jSONObject = null;
        }
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("request", jSONObject.toString());
        } catch (JSONException unused2) {
        }
        u0(jSONObject2.toString(), true, interfaceC0098b);
    }

    public void q0(v vVar) {
        this.f7640j = vVar;
        w6.m.z0(vVar);
    }

    @SuppressLint({"NewApi"})
    public void r(EligibilityCheck eligibilityCheck, b.InterfaceC0098b interfaceC0098b) {
        JSONObject jSONObject = null;
        try {
            jSONObject = y("Covid19Tests", "Get", true);
            jSONObject.put("RequestData", new com.google.gson.e().r(eligibilityCheck));
        } catch (JSONException unused) {
        }
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("request", jSONObject.toString());
        } catch (JSONException unused2) {
        }
        u0(jSONObject2.toString(), true, interfaceC0098b);
    }

    public void r0(int i10) {
        String str;
        v vVar = v.values()[i10];
        switch (f.f7651a[vVar.ordinal()]) {
            case 1:
                str = w6.d.f15126a;
                break;
            case 2:
                str = w6.d.f15127b;
                break;
            case 3:
                str = w6.d.f15128c;
                break;
            case 4:
                str = w6.d.f15132g;
                break;
            case 5:
                str = w6.d.f15133h;
                break;
            case 6:
                str = w6.d.f15134i;
                break;
            case 7:
                str = w6.d.f15130e;
                break;
            default:
                return;
        }
        q0(vVar);
        s0(str);
    }

    public void s0(String str) {
        this.f7639i = str;
        w6.m.A0(str);
    }

    @SuppressLint({"NewApi"})
    public void t(b.InterfaceC0098b interfaceC0098b) {
        JSONObject jSONObject;
        try {
            jSONObject = y("PTT", "GetDipioId", true);
        } catch (JSONException unused) {
            jSONObject = null;
        }
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("request", jSONObject.toString());
        } catch (JSONException unused2) {
        }
        u0(jSONObject2.toString(), true, interfaceC0098b);
    }

    @SuppressLint({"NewApi"})
    public void u(InfectiousDiseaseReportData infectiousDiseaseReportData, b.InterfaceC0098b interfaceC0098b) {
        JSONObject jSONObject = null;
        try {
            jSONObject = y("Report", "GetInfectiousDiseaseSamplesReport", true);
            jSONObject.put("RequestData", new com.google.gson.e().r(infectiousDiseaseReportData));
        } catch (JSONException unused) {
        }
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("request", jSONObject.toString());
        } catch (JSONException unused2) {
        }
        u0(jSONObject2.toString(), true, interfaceC0098b);
    }

    @SuppressLint({"NewApi"})
    public void v0(String str, boolean z10, b.InterfaceC0098b interfaceC0098b) {
        JSONObject jSONObject = null;
        try {
            jSONObject = y("PTT", "UpdateFavorite", true);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("uid", str);
            jSONObject2.put("op", z10 ? "add" : "delete");
            jSONObject.put("RequestData", jSONObject2.toString());
        } catch (JSONException unused) {
        }
        JSONObject jSONObject3 = new JSONObject();
        try {
            jSONObject3.put("request", jSONObject.toString());
        } catch (JSONException unused2) {
        }
        u0(jSONObject3.toString(), true, interfaceC0098b);
    }

    public void w0(h0 h0Var, x xVar) {
        JSONObject jSONObject;
        JSONObject jSONObject2 = new JSONObject();
        JSONObject jSONObject3 = null;
        try {
            jSONObject = new JSONObject();
            try {
                jSONObject2.put("Application", l0.U(h0Var.f15171a));
                jSONObject2.put("Module", h0Var.f15172b);
                jSONObject2.put("Function", h0Var.f15173c);
                jSONObject2.put("Token", h0Var.f15174d);
                jSONObject2.put("AppVersion", MdaEmergencyApplication.f7530g);
                jSONObject.put("RequestHeader", jSONObject2);
                jSONObject.put("RequestData", new com.google.gson.e().r(h0Var));
            } catch (JSONException unused) {
                jSONObject3 = jSONObject;
                jSONObject = jSONObject3;
                new JSONObject().put("request", jSONObject.toString());
                b.c cVar = b.c.Files;
                com.groboot.mdaemergency.async.b bVar = new com.groboot.mdaemergency.async.b(cVar, this.f7640j, jSONObject.toString(), false, new k(this, xVar, jSONObject2, h0Var));
                bVar.f7610e = cVar;
                t0(bVar);
            }
        } catch (JSONException unused2) {
        }
        try {
            new JSONObject().put("request", jSONObject.toString());
        } catch (JSONException unused3) {
        }
        b.c cVar2 = b.c.Files;
        com.groboot.mdaemergency.async.b bVar2 = new com.groboot.mdaemergency.async.b(cVar2, this.f7640j, jSONObject.toString(), false, new k(this, xVar, jSONObject2, h0Var));
        bVar2.f7610e = cVar2;
        t0(bVar2);
    }

    @SuppressLint({"NewApi"})
    public void x0(e.b bVar, b.InterfaceC0098b interfaceC0098b) {
        JSONObject jSONObject = null;
        try {
            jSONObject = y("Logs", "WriteLogs", true);
            new JSONObject();
            jSONObject.put("RequestData", new com.google.gson.e().r(bVar));
        } catch (JSONException unused) {
        }
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("request", jSONObject.toString());
        } catch (JSONException unused2) {
        }
        u0(jSONObject2.toString(), true, interfaceC0098b);
    }

    public void z() {
        if (this.f7633c != null) {
            Iterator<u> it = this.f7631a.values().iterator();
            while (it.hasNext()) {
                it.next().c(this.f7633c, this.f7634d, this.f7637g, this.f7638h.booleanValue());
            }
        }
    }
}
