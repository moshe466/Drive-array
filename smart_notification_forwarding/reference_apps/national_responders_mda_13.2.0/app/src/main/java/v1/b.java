package v1;

import android.net.Uri;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;

/* loaded from: classes.dex */
final class b extends Thread {

    /* renamed from: f, reason: collision with root package name */
    private final /* synthetic */ Map f14617f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar, Map map) {
        this.f14617f = map;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        String message;
        StringBuilder sb2;
        String str;
        new d();
        Map map = this.f14617f;
        Uri.Builder buildUpon = Uri.parse("https://pagead2.googlesyndication.com/pagead/gen_204?id=gmob-apps").buildUpon();
        for (String str2 : map.keySet()) {
            buildUpon.appendQueryParameter(str2, (String) map.get(str2));
        }
        String uri = buildUpon.build().toString();
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(uri).openConnection();
            try {
                int responseCode = httpURLConnection.getResponseCode();
                if (responseCode < 200 || responseCode >= 300) {
                    StringBuilder sb3 = new StringBuilder(String.valueOf(uri).length() + 65);
                    sb3.append("Received non-success response code ");
                    sb3.append(responseCode);
                    sb3.append(" from pinging URL: ");
                    sb3.append(uri);
                }
            } finally {
                httpURLConnection.disconnect();
            }
        } catch (IOException e10) {
            e = e10;
            message = e.getMessage();
            sb2 = new StringBuilder(String.valueOf(uri).length() + 27 + String.valueOf(message).length());
            str = "Error while pinging URL: ";
            sb2.append(str);
            sb2.append(uri);
            sb2.append(". ");
            sb2.append(message);
        } catch (IndexOutOfBoundsException e11) {
            message = e11.getMessage();
            sb2 = new StringBuilder(String.valueOf(uri).length() + 32 + String.valueOf(message).length());
            str = "Error while parsing ping URL: ";
            sb2.append(str);
            sb2.append(uri);
            sb2.append(". ");
            sb2.append(message);
        } catch (RuntimeException e12) {
            e = e12;
            message = e.getMessage();
            sb2 = new StringBuilder(String.valueOf(uri).length() + 27 + String.valueOf(message).length());
            str = "Error while pinging URL: ";
            sb2.append(str);
            sb2.append(uri);
            sb2.append(". ");
            sb2.append(message);
        }
    }
}
