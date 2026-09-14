package x6;

import android.media.MediaPlayer;
import android.os.Environment;
import java.io.File;
import java.io.RandomAccessFile;
import java.util.Timer;
import java.util.TimerTask;
import java.util.UUID;

/* loaded from: classes.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    d f15456a;

    /* renamed from: b, reason: collision with root package name */
    public String f15457b;

    /* renamed from: c, reason: collision with root package name */
    x6.a f15458c;

    /* renamed from: d, reason: collision with root package name */
    MediaPlayer f15459d;

    /* renamed from: e, reason: collision with root package name */
    private f f15460e;

    /* renamed from: f, reason: collision with root package name */
    public int f15461f = 0;

    /* renamed from: g, reason: collision with root package name */
    String f15462g = "";

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a extends TimerTask {
        a() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            c cVar = c.this;
            if (cVar.f15456a == null) {
                cancel();
                return;
            }
            if (cVar.c() != f.Recording) {
                cancel();
                return;
            }
            c cVar2 = c.this;
            int i10 = cVar2.f15461f + 1;
            cVar2.f15461f = i10;
            cVar2.f15456a.a(i10);
        }
    }

    /* loaded from: classes.dex */
    class b implements Runnable {
        b(c cVar) {
        }

        @Override // java.lang.Runnable
        public void run() {
        }
    }

    public c(UUID uuid) {
        this.f15457b = g(uuid + "");
        i();
    }

    public static c a() {
        return new c(UUID.randomUUID());
    }

    private e d(Exception exc) {
        String message = exc.getMessage();
        this.f15462g = message;
        if (message == null) {
            this.f15462g = "תקלה בלתי צפוייה";
        }
        return e.SYSTEM_EXCEPTION;
    }

    private String g(String str) {
        if (!str.startsWith("/")) {
            str = "/" + str;
        }
        if (!str.endsWith(".3gp")) {
            str = str + ".3gp";
        }
        return Environment.getExternalStorageDirectory().getAbsolutePath() + "/mvm" + str;
    }

    private void i() {
        j(new File(this.f15457b).exists() ? f.Exist : f.NotExist);
    }

    private void k() {
        if (this.f15456a == null) {
            return;
        }
        new Timer().scheduleAtFixedRate(new a(), 1000L, 1000L);
    }

    private e m() {
        if (c() != f.Playing) {
            return e.NO_STOP_ACTION_AVAILABLE;
        }
        this.f15459d.stop();
        this.f15459d = null;
        j(f.Exist);
        return e.OK;
    }

    private e n() {
        if (c() != f.Recording) {
            return e.NO_STOP_ACTION_AVAILABLE;
        }
        try {
            j(f.Exist);
            this.f15458c.c();
            this.f15458c = null;
            return e.OK;
        } catch (Exception e10) {
            return d(e10);
        }
    }

    public String b() {
        int i10 = this.f15461f;
        if (i10 < 1) {
            return "00:00";
        }
        int i11 = i10 % 60;
        int i12 = i10 / 60;
        int i13 = i12 / 60;
        int i14 = i12 % 60;
        if (i13 == 0) {
            return String.format("%02d", Integer.valueOf(i14)) + ":" + String.format("%02d", Integer.valueOf(i11));
        }
        return String.format("%02d", Integer.valueOf(i13)) + ":" + String.format("%02d", Integer.valueOf(i14)) + ":" + String.format("%02d", Integer.valueOf(i11));
    }

    public f c() {
        return this.f15460e;
    }

    public e e() {
        return c() == f.Playing ? e.FILE_PLAYING : c() == f.Recording ? e.FILE_RECORDING : c() == f.Downloading ? e.FILE_DOWNLOADING : c() == f.Uploading ? e.FILE_UPLOADING : e.OK;
    }

    public e f() {
        e e10 = e();
        e eVar = e.OK;
        if (e10 != eVar) {
            return e10;
        }
        if (c() == f.Exist) {
            return e.FILE_ALREADY_EXIST;
        }
        try {
            this.f15461f = 0;
            this.f15458c = new x6.a(this.f15457b);
            j(f.Recording);
            d dVar = this.f15456a;
            if (dVar != null) {
                dVar.a(0);
            }
            this.f15458c.b();
            k();
            return eVar;
        } catch (Exception e11) {
            return d(e11);
        }
    }

    public void h(d dVar) {
        this.f15456a = dVar;
    }

    public void j(f fVar) {
        this.f15460e = fVar;
        d dVar = this.f15456a;
        if (dVar != null) {
            dVar.b();
        }
    }

    public e l() {
        return c() == f.Playing ? m() : c() == f.Recording ? n() : e.NO_STOP_ACTION_AVAILABLE;
    }

    public e o() {
        e e10 = e();
        if (e10 != e.OK) {
            return e10;
        }
        if (c() != f.Exist) {
            return e.FILE_NOT_EXIST;
        }
        if (this.f15456a == null) {
            return e.NO_UPLOAD_HANDLER;
        }
        j(f.Uploading);
        try {
            RandomAccessFile randomAccessFile = new RandomAccessFile(this.f15457b, "r");
            int length = (int) randomAccessFile.length();
            randomAccessFile.read(new byte[length]);
            if (length == 0) {
                return e.ERROR_READING_FILE;
            }
            new Thread(new b(this)).start();
            return e.FILE_UPLOADING;
        } catch (Exception e11) {
            return d(e11);
        }
    }
}
