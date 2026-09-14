package q5;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
import p5.d;

/* loaded from: classes.dex */
public class a {

    /* renamed from: q5.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    class RunnableC0279a implements Runnable {

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ String f13570f;

        /* renamed from: g, reason: collision with root package name */
        final /* synthetic */ String f13571g;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ String f13572h;

        RunnableC0279a(String str, String str2, String str3) {
            this.f13570f = str;
            this.f13571g = str2;
            this.f13572h = str3;
        }

        @Override // java.lang.Runnable
        public void run() {
            a.a(this.f13570f, this.f13571g, this.f13572h);
        }
    }

    /* loaded from: classes.dex */
    class b implements Runnable {

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ List f13573f;

        /* renamed from: g, reason: collision with root package name */
        final /* synthetic */ String f13574g;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ String f13575h;

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ String f13576i;

        b(List list, String str, String str2, String str3) {
            this.f13573f = list;
            this.f13574g = str;
            this.f13575h = str2;
            this.f13576i = str3;
        }

        @Override // java.lang.Runnable
        public void run() {
            a.b(this.f13573f, this.f13574g, this.f13575h, this.f13576i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void a(String str, String str2, String str3) {
        String str4 = d.f13074j;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("message send: ");
        sb2.append(str);
        try {
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put(d.f13065a, str.trim());
            jSONObject.put(d.f13066b, str2);
            jSONObject.put(d.f13067c, "m2");
            jSONObject.put("to", str3);
            jSONObject.put("data", jSONObject2);
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL("https://android.googleapis.com/gcm/send").openConnection();
            httpURLConnection.setRequestProperty("Authorization", "key=" + d.f13075k);
            httpURLConnection.setRequestProperty("Content-Type", "application/json");
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setDoOutput(true);
            httpURLConnection.getOutputStream().write(jSONObject.toString().getBytes());
            httpURLConnection.getInputStream();
            System.out.println("");
            System.out.println("Check your device/emulator for notification or logcat for confirmation of the receipt of the GCM message.");
        } catch (Exception e10) {
            String str5 = d.f13074j;
            System.out.println("Unable to send GCM message.");
            System.out.println("Please ensure that API_KEY has been replaced by the server API key, and that the device's registration token is correct (if specified).");
            e10.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(List<String> list, String str, String str2, String str3) {
        String str4 = d.f13074j;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("sounds send: ");
        sb2.append(list);
        try {
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put(d.f13065a, str.trim());
            JSONObject jSONObject3 = new JSONObject();
            JSONArray jSONArray = new JSONArray();
            Iterator<String> it = list.iterator();
            while (it.hasNext()) {
                jSONArray.put(it.next());
            }
            jSONObject3.put(d.f13072h, jSONArray);
            jSONObject3.put(d.f13069e, "");
            jSONObject2.put("D", jSONObject3);
            jSONObject.put(d.f13066b, str2);
            jSONObject.put(d.f13067c, "m2");
            jSONObject.put("to", str3);
            jSONObject.put("data", jSONObject2);
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL("https://android.googleapis.com/gcm/send").openConnection();
            httpURLConnection.setRequestProperty("Authorization", "key=" + d.f13075k);
            httpURLConnection.setRequestProperty("Content-Type", "application/json");
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setDoOutput(true);
            httpURLConnection.getOutputStream().write(jSONObject.toString().getBytes());
            httpURLConnection.getInputStream();
            System.out.println("");
            System.out.println("Check your device/emulator for notification or logcat for confirmation of the receipt of the GCM message.");
        } catch (Exception e10) {
            String str5 = d.f13074j;
            System.out.println("Unable to send GCM message.");
            System.out.println("Please ensure that API_KEY has been replaced by the server API key, and that the device's registration token is correct (if specified).");
            e10.printStackTrace();
        }
    }

    public static void e(String str, String str2, String str3) {
        new Thread(new RunnableC0279a(str, str2, str3)).start();
    }

    public static void f(List<String> list, String str, String str2, String str3) {
        new Thread(new b(list, str, str2, str3)).start();
    }
}
