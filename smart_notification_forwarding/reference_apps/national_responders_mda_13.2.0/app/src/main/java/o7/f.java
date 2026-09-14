package o7;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.zip.GZIPInputStream;

/* loaded from: classes.dex */
public class f {

    /* renamed from: a, reason: collision with root package name */
    private String f12572a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a implements Runnable {

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ com.google.gson.n f12573f;

        /* renamed from: g, reason: collision with root package name */
        final /* synthetic */ m f12574g;

        a(com.google.gson.n nVar, m mVar) {
            this.f12573f = nVar;
            this.f12574g = mVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(f.this.f12572a).openConnection();
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setRequestProperty("User-Agent", "Mozilla/5.0 ( compatible ) ");
                httpURLConnection.setRequestProperty("Content-Type", "application/json");
                httpURLConnection.setRequestProperty("Accept", "application/json");
                httpURLConnection.setRequestProperty("Accept", "*/*");
                httpURLConnection.setRequestProperty("Accept-Encoding", "gzip");
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.connect();
                OutputStream outputStream = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                bufferedWriter.write(new com.google.gson.e().q(this.f12573f));
                bufferedWriter.close();
                outputStream.close();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader("gzip".equals(httpURLConnection.getContentEncoding()) ? new GZIPInputStream(httpURLConnection.getInputStream()) : httpURLConnection.getInputStream(), "UTF-8"));
                StringBuilder sb2 = new StringBuilder();
                while (true) {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        bufferedReader.close();
                        this.f12574g.c(new com.google.gson.p().a(sb2.toString()).g());
                        return;
                    }
                    sb2.append(readLine);
                }
            } catch (Throwable th) {
                this.f12574g.a(1, th.getMessage());
            }
        }
    }

    public f(String str) {
        this.f12572a = str;
    }

    public void b(com.google.gson.n nVar, g gVar) {
        new Thread(new a(nVar, new m(nVar, gVar))).start();
    }
}
