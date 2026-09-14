package x6;

import android.media.MediaRecorder;
import android.os.Environment;
import java.io.File;
import java.io.IOException;

/* loaded from: classes.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    final MediaRecorder f15454a = new MediaRecorder();

    /* renamed from: b, reason: collision with root package name */
    public final String f15455b;

    public a(String str) {
        this.f15455b = a(str);
    }

    private String a(String str) {
        if (!str.startsWith("/")) {
            str = "/" + str;
        }
        if (str.endsWith(".3gp")) {
            return str;
        }
        return str + ".3gp";
    }

    public void b() {
        String externalStorageState = Environment.getExternalStorageState();
        if (!externalStorageState.equals("mounted")) {
            throw new IOException("SD Card is not mounted.  It is " + externalStorageState + ".");
        }
        File parentFile = new File(this.f15455b).getParentFile();
        if (!parentFile.exists() && !parentFile.mkdirs()) {
            throw new IOException("Path to file could not be created.");
        }
        this.f15454a.setAudioSource(1);
        this.f15454a.setOutputFormat(0);
        this.f15454a.setAudioEncoder(2);
        this.f15454a.setOutputFile(this.f15455b);
        this.f15454a.prepare();
        this.f15454a.start();
    }

    public void c() {
        this.f15454a.stop();
        this.f15454a.release();
    }
}
