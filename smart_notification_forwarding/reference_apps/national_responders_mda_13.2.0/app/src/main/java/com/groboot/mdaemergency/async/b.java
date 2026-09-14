package com.groboot.mdaemergency.async;

import android.content.Context;
import android.os.AsyncTask;
import com.google.gson.e;
import com.groboot.mdaemergency.async.d;
import com.groboot.mdaemergency.models.Answer;
import il.org.mda.health.R;
import java.io.IOException;
import java.net.URL;
import okhttp3.f;
import okhttp3.t;
import okhttp3.v;
import okhttp3.y;
import okhttp3.z;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import w6.l0;
import w6.m;

/* loaded from: classes.dex */
public class b extends AsyncTask<Void, Void, String> {

    /* renamed from: h, reason: collision with root package name */
    public static final t f7605h = t.c("application/json; charset=utf-8");

    /* renamed from: a, reason: collision with root package name */
    v f7606a;

    /* renamed from: b, reason: collision with root package name */
    String f7607b;

    /* renamed from: c, reason: collision with root package name */
    boolean f7608c;

    /* renamed from: d, reason: collision with root package name */
    InterfaceC0098b f7609d;

    /* renamed from: e, reason: collision with root package name */
    public c f7610e;

    /* renamed from: f, reason: collision with root package name */
    d.v f7611f;

    /* renamed from: g, reason: collision with root package name */
    a f7612g;

    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        JSONObject f7613a;

        /* renamed from: b, reason: collision with root package name */
        public boolean f7614b;

        /* renamed from: c, reason: collision with root package name */
        public boolean f7615c;

        /* renamed from: d, reason: collision with root package name */
        public String f7616d;

        /* renamed from: e, reason: collision with root package name */
        public String f7617e;

        /* renamed from: f, reason: collision with root package name */
        public int f7618f;

        public a() {
        }

        public a(boolean z10) {
            this.f7614b = z10;
        }

        private boolean g() {
            if (this.f7613a != null) {
                return true;
            }
            try {
                this.f7613a = new JSONObject(this.f7616d);
            } catch (JSONException e10) {
                b.b("MdaServerTask", "ERROR initJsonObject: " + e10.getMessage(), e10);
            }
            return this.f7613a != null;
        }

        public Answer a() {
            try {
                return (Answer) new e().i(this.f7616d, Answer.class);
            } catch (com.google.gson.t e10) {
                e10.getMessage();
                return null;
            }
        }

        public boolean b(String str) {
            try {
                return this.f7613a.getBoolean(str);
            } catch (Exception e10) {
                b.b("MdaServerTask", "ERROR getBoolean: " + e10.getMessage(), e10);
                return false;
            }
        }

        public int c(String str) {
            try {
                return this.f7613a.getInt(str);
            } catch (Exception e10) {
                b.b("MdaServerTask", "ERROR getInt: " + e10.getMessage(), e10);
                return -1;
            }
        }

        public JSONArray d(String str) {
            JSONObject jSONObject = this.f7613a;
            if (jSONObject == null) {
                return null;
            }
            try {
                return jSONObject.getJSONArray(str);
            } catch (JSONException e10) {
                b.b("MdaServerTask", "ERROR getJSONArray: " + e10.getMessage(), e10);
                return new JSONArray();
            }
        }

        public String e(String str) {
            JSONObject jSONObject = this.f7613a;
            if (jSONObject == null) {
                return "";
            }
            try {
                return jSONObject.getString(str);
            } catch (JSONException e10) {
                b.b("MdaServerTask", "ERROR getString: " + e10.getMessage(), e10);
                return "";
            }
        }

        public boolean f(String str) {
            if (g()) {
                return this.f7613a.has(str);
            }
            return false;
        }

        public boolean h(String str) {
            return this.f7613a.isNull(str);
        }
    }

    /* renamed from: com.groboot.mdaemergency.async.b$b, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0098b {
        void a(a aVar);
    }

    /* loaded from: classes.dex */
    public enum c {
        Regular,
        Files
    }

    public b(c cVar, d.v vVar, String str, boolean z10, InterfaceC0098b interfaceC0098b) {
        this.f7610e = cVar;
        this.f7611f = vVar;
        this.f7607b = str;
        this.f7608c = z10;
        this.f7609d = interfaceC0098b;
        a("MdaServerTask", "new MDAServerTask " + str);
    }

    public b(String str, boolean z10, InterfaceC0098b interfaceC0098b) {
        this.f7610e = c.Regular;
        this.f7607b = str;
        this.f7608c = z10;
        this.f7609d = interfaceC0098b;
        a("MdaServerTask", "new MDAServerTask: " + str);
    }

    private static void a(String str, String str2) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(String str, String str2, Exception exc) {
    }

    private void g(a aVar) {
        aVar.f7614b = true;
        aVar.f7615c = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public String doInBackground(Void... voidArr) {
        a("MdaServerTask", "doInBackground");
        try {
            String K = d.v().K();
            String str = w6.d.f15135j;
            if (this.f7610e == c.Files) {
                d.v vVar = this.f7611f;
                if (vVar == null || vVar == d.v.MADA) {
                    K = w6.d.f15129d;
                }
                str = w6.d.f15137l;
            } else if (!this.f7608c) {
                str = w6.d.f15136k;
            }
            URL url = new URL(K + str);
            this.f7606a = new v.b().c(new f.a().a(url.getHost(), (String[]) m.m().getPublicKeysSHA256().toArray(new String[0])).b()).a();
            i(this.f7606a.w(new y.a().i(url).f(z.d(f7605h, this.f7607b)).a()).f().c().D());
        } catch (IOException e10) {
            e10.printStackTrace();
            a("MdaServerTask", "ERROR = " + e10.getMessage());
            i(null);
        }
        return null;
    }

    public void e(a aVar, int i10) {
        StringBuilder sb2;
        Context v10;
        int i11;
        aVar.f7614b = false;
        aVar.f7618f = i10;
        if (i10 == 7050) {
            aVar.f7615c = false;
            sb2 = new StringBuilder();
            sb2.append(l0.v().getString(R.string.fault));
            sb2.append(i10);
            sb2.append("\n");
            v10 = l0.v();
            i11 = R.string.comunication_problem_description;
        } else if (i10 == 7030) {
            aVar.f7615c = false;
            sb2 = new StringBuilder();
            sb2.append(l0.v().getString(R.string.fault));
            sb2.append(i10);
            sb2.append("\n");
            v10 = l0.v();
            i11 = R.string.problem_process_data_in_server;
        } else if (i10 == 7018) {
            aVar.f7615c = false;
            sb2 = new StringBuilder();
            sb2.append(l0.v().getString(R.string.fault));
            sb2.append(i10);
            sb2.append("\n");
            v10 = l0.v();
            i11 = R.string.server_fault_try_again;
        } else {
            aVar.f7615c = true;
            sb2 = new StringBuilder();
            sb2.append(l0.v().getString(R.string.fault));
            sb2.append(i10);
            sb2.append("\n");
            v10 = l0.v();
            i11 = R.string.invalid_data;
        }
        sb2.append(v10.getString(i11));
        aVar.f7617e = sb2.toString();
    }

    public void f(a aVar) {
        aVar.f7614b = false;
        aVar.f7615c = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public void onPostExecute(String str) {
        super.onPostExecute(str);
        InterfaceC0098b interfaceC0098b = this.f7609d;
        if (interfaceC0098b != null) {
            interfaceC0098b.a(this.f7612g);
        }
    }

    protected void i(String str) {
        a aVar;
        a aVar2;
        int i10;
        a aVar3 = new a();
        this.f7612g = aVar3;
        if (str == null) {
            e(aVar3, 7050);
            return;
        }
        if (str.length() == 0) {
            aVar2 = this.f7612g;
            i10 = 7015;
        } else {
            if (str.equals("SERVER_CRASH")) {
                e(this.f7612g, 7050);
                return;
            }
            if (str.equals("Error")) {
                aVar2 = this.f7612g;
                i10 = 7016;
            } else if (str.equals("TimeOut internal service")) {
                aVar2 = this.f7612g;
                i10 = 7017;
            } else if (str.indexOf("TimeOut external service") > -1) {
                aVar2 = this.f7612g;
                i10 = 7018;
            } else if (str.equals("The service is unavailable.")) {
                aVar2 = this.f7612g;
                i10 = 7019;
            } else if (str.equals("Maximum requests count exceeded")) {
                aVar2 = this.f7612g;
                i10 = 7020;
            } else if (str.indexOf("{") == -1) {
                aVar2 = this.f7612g;
                i10 = 7030;
            } else {
                if (!str.equals("{\"d\":\"\"}\n")) {
                    try {
                        JSONObject jSONObject = new JSONObject(str);
                        if (!jSONObject.has("d") || jSONObject.get("d").getClass() != Boolean.class) {
                            JSONObject jSONObject2 = new JSONObject(jSONObject.getString("d"));
                            this.f7612g.f7616d = jSONObject2.toString();
                            if (this.f7612g.f("Success")) {
                                this.f7612g.f7614b = jSONObject2.getBoolean("Success");
                            } else {
                                this.f7612g.f7614b = false;
                            }
                            if (this.f7612g.f("Message")) {
                                this.f7612g.f7617e = jSONObject2.getString("Message");
                            }
                            if (this.f7612g.f("ErrorMsg")) {
                                this.f7612g.f7617e = jSONObject2.getString("ErrorMsg");
                            }
                            if (!this.f7612g.f("d")) {
                                return;
                            } else {
                                aVar = this.f7612g;
                            }
                        } else {
                            if (!jSONObject.getBoolean("d")) {
                                f(this.f7612g);
                                return;
                            }
                            aVar = this.f7612g;
                        }
                        g(aVar);
                        return;
                    } catch (Exception e10) {
                        e(this.f7612g, 7031);
                        StringBuilder sb2 = new StringBuilder();
                        a aVar4 = this.f7612g;
                        sb2.append(aVar4.f7617e);
                        sb2.append("\n");
                        sb2.append(e10.getMessage());
                        sb2.append("\n");
                        sb2.append(str);
                        aVar4.f7617e = sb2.toString();
                        a("MdaServerTask", "ERROR: jsonObject" + e10.getMessage());
                        return;
                    }
                }
                aVar2 = this.f7612g;
                i10 = 7047;
            }
        }
        e(aVar2, i10);
    }
}
