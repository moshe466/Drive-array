package o5;

import com.groboot.mdaemergency.models.PDFFile;
import java.io.File;

/* loaded from: classes.dex */
public class a extends Thread {

    /* renamed from: o5.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    class RunnableC0263a implements Runnable {
        RunnableC0263a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                File file = new File(PDFFile.getFolderPath());
                if (!file.exists()) {
                    file.mkdirs();
                }
                for (String str : file.list()) {
                    new File(file, str).delete();
                }
            } catch (Exception unused) {
            }
        }
    }

    public a() {
        super(new RunnableC0263a());
    }
}
