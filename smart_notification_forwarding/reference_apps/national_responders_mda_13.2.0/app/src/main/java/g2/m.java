package g2;

import android.os.Process;
import android.os.StrictMode;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/* loaded from: classes.dex */
public class m {

    /* renamed from: a, reason: collision with root package name */
    private static String f9759a;

    /* renamed from: b, reason: collision with root package name */
    private static int f9760b;

    public static String a() {
        BufferedReader bufferedReader;
        if (f9759a == null) {
            int i10 = f9760b;
            if (i10 == 0) {
                i10 = Process.myPid();
                f9760b = i10;
            }
            String str = null;
            str = null;
            str = null;
            BufferedReader bufferedReader2 = null;
            if (i10 > 0) {
                try {
                    String str2 = "/proc/" + i10 + "/cmdline";
                    StrictMode.ThreadPolicy allowThreadDiskReads = StrictMode.allowThreadDiskReads();
                    try {
                        bufferedReader = new BufferedReader(new FileReader(str2));
                        try {
                            String readLine = bufferedReader.readLine();
                            b2.p.k(readLine);
                            str = readLine.trim();
                        } catch (IOException unused) {
                        } catch (Throwable th) {
                            th = th;
                            bufferedReader2 = bufferedReader;
                            k.a(bufferedReader2);
                            throw th;
                        }
                    } finally {
                        StrictMode.setThreadPolicy(allowThreadDiskReads);
                    }
                } catch (IOException unused2) {
                    bufferedReader = null;
                } catch (Throwable th2) {
                    th = th2;
                }
                k.a(bufferedReader);
            }
            f9759a = str;
        }
        return f9759a;
    }
}
