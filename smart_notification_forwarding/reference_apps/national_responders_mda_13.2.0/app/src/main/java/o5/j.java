package o5;

import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class j {
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v4, types: [java.util.ArrayList<java.lang.String>] */
    /* JADX WARN: Type inference failed for: r0v7, types: [java.util.ArrayList<java.lang.String>, java.util.ArrayList] */
    public ArrayList<String> a(String str) {
        HttpURLConnection httpURLConnection;
        int i10;
        StringBuilder sb2 = new StringBuilder();
        HttpURLConnection httpURLConnection2 = null;
        try {
            StringBuilder sb3 = new StringBuilder("https://maps.googleapis.com/maps/api/place/autocomplete/json");
            sb3.append("?key=AIzaSyDlNZxMZ_a0CN1cZjCGNJ3MeZ4YNaFIy-I");
            sb3.append("&input=" + URLEncoder.encode(str, "utf8"));
            httpURLConnection = (HttpURLConnection) new URL(sb3.toString()).openConnection();
            try {
                InputStreamReader inputStreamReader = new InputStreamReader(httpURLConnection.getInputStream());
                char[] cArr = new char[1024];
                while (true) {
                    int read = inputStreamReader.read(cArr);
                    if (read == -1) {
                        break;
                    }
                    sb2.append(cArr, 0, read);
                }
                httpURLConnection.disconnect();
                try {
                    JSONArray jSONArray = new JSONObject(sb2.toString()).getJSONArray("predictions");
                    ?? arrayList = new ArrayList(jSONArray.length());
                    for (i10 = 0; i10 < jSONArray.length(); i10++) {
                        try {
                            arrayList.add(jSONArray.getJSONObject(i10).getString("description"));
                        } catch (JSONException unused) {
                            httpURLConnection2 = arrayList;
                            return httpURLConnection2;
                        }
                    }
                    return arrayList;
                } catch (JSONException unused2) {
                }
            } catch (Exception unused3) {
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
                return null;
            } catch (Throwable th) {
                th = th;
                httpURLConnection2 = httpURLConnection;
                if (httpURLConnection2 != null) {
                    httpURLConnection2.disconnect();
                }
                throw th;
            }
        } catch (Exception unused4) {
            httpURLConnection = null;
        } catch (Throwable th2) {
            th = th2;
        }
    }
}
