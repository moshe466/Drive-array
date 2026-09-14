package w6;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;

/* loaded from: classes.dex */
public class h {

    /* renamed from: a, reason: collision with root package name */
    public String f15163a;

    /* renamed from: b, reason: collision with root package name */
    public String f15164b;

    /* renamed from: c, reason: collision with root package name */
    public a f15165c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f15166d = false;

    /* renamed from: e, reason: collision with root package name */
    public boolean f15167e = false;

    /* renamed from: f, reason: collision with root package name */
    public int f15168f = 0;

    /* renamed from: g, reason: collision with root package name */
    public int f15169g = 0;

    /* loaded from: classes.dex */
    public interface a {
        void a(h hVar, int i10, int i11);

        void b(h hVar, String str);

        void c(h hVar);
    }

    /* loaded from: classes.dex */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            h hVar;
            StringBuilder sb2;
            int lastIndexOf;
            File file = new File(h.this.f15164b);
            try {
                try {
                    try {
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append("download from:");
                        sb3.append(h.this.f15163a);
                        sb3.append(" to:");
                        sb3.append(h.this.f15164b);
                        StringBuilder sb4 = new StringBuilder();
                        sb4.append("create new local file:");
                        sb4.append(h.this.f15164b);
                        lastIndexOf = h.this.f15164b.lastIndexOf("/");
                    } catch (Exception e10) {
                        h.this.d("Exception: " + e10.getMessage());
                        if (h.this.f15166d) {
                            try {
                                file.delete();
                            } catch (Exception e11) {
                                e = e11;
                                hVar = h.this;
                                sb2 = new StringBuilder();
                                sb2.append("After failed delete file exception: ");
                                sb2.append(e.getMessage());
                                hVar.d(sb2.toString());
                                h.this.f15167e = false;
                            }
                        }
                    }
                } catch (FileNotFoundException e12) {
                    h.this.d("FileNotFoundException: " + e12.getMessage());
                    if (h.this.f15166d) {
                        try {
                            file.delete();
                        } catch (Exception e13) {
                            e = e13;
                            hVar = h.this;
                            sb2 = new StringBuilder();
                            sb2.append("After failed delete file exception: ");
                            sb2.append(e.getMessage());
                            hVar.d(sb2.toString());
                            h.this.f15167e = false;
                        }
                    }
                } catch (IOException e14) {
                    h.this.d("IOException: " + e14.getMessage());
                    if (h.this.f15166d) {
                        try {
                            file.delete();
                        } catch (Exception e15) {
                            e = e15;
                            hVar = h.this;
                            sb2 = new StringBuilder();
                            sb2.append("After failed delete file exception: ");
                            sb2.append(e.getMessage());
                            hVar.d(sb2.toString());
                            h.this.f15167e = false;
                        }
                    }
                }
                if (lastIndexOf == -1) {
                    h.this.d("the local file name is invalid\n" + h.this.f15164b + "\n\nuse char:/");
                    return;
                }
                String substring = h.this.f15164b.substring(0, lastIndexOf);
                StringBuilder sb5 = new StringBuilder();
                String str = h.this.f15164b;
                sb5.append(str.substring(0, str.lastIndexOf("/")));
                sb5.append("/_tmp_");
                String str2 = h.this.f15164b;
                sb5.append(str2.substring(str2.lastIndexOf("/") + 1));
                String sb6 = sb5.toString();
                File file2 = new File(sb6);
                if (!file2.exists()) {
                    File file3 = new File(substring);
                    StringBuilder sb7 = new StringBuilder();
                    sb7.append("check directory:");
                    sb7.append(substring);
                    if (file3.exists()) {
                        StringBuilder sb8 = new StringBuilder();
                        sb8.append("exist directory:");
                        sb8.append(substring);
                    } else {
                        StringBuilder sb9 = new StringBuilder();
                        sb9.append("create directory:");
                        sb9.append(substring);
                        file3.mkdirs();
                    }
                    StringBuilder sb10 = new StringBuilder();
                    sb10.append("save new file:");
                    sb10.append(sb6);
                    file2.createNewFile();
                }
                URL url = new URL(h.this.f15163a);
                StringBuilder sb11 = new StringBuilder();
                sb11.append("open connection:");
                sb11.append(h.this.f15163a);
                h.this.f15169g = url.openConnection().getContentLength();
                BufferedInputStream bufferedInputStream = new BufferedInputStream(url.openStream());
                FileOutputStream fileOutputStream = new FileOutputStream(file2);
                byte[] bArr = new byte[65536];
                h hVar2 = h.this;
                hVar2.f15168f = 0;
                while (true) {
                    hVar2.e();
                    int read = bufferedInputStream.read(bArr);
                    if (read == -1) {
                        break;
                    }
                    h.this.f15168f += read;
                    fileOutputStream.write(bArr, 0, read);
                    StringBuilder sb12 = new StringBuilder();
                    sb12.append("read ");
                    sb12.append(read);
                    sb12.append(" bytes");
                    hVar2 = h.this;
                }
                h hVar3 = h.this;
                hVar3.f15168f = hVar3.f15169g;
                h.this.f();
                if (file.exists()) {
                    file.delete();
                }
                file2.renameTo(file);
                fileOutputStream.flush();
                fileOutputStream.close();
                bufferedInputStream.close();
                if (h.this.f15166d) {
                    try {
                        file.delete();
                    } catch (Exception e16) {
                        e = e16;
                        hVar = h.this;
                        sb2 = new StringBuilder();
                        sb2.append("After failed delete file exception: ");
                        sb2.append(e.getMessage());
                        hVar.d(sb2.toString());
                        h.this.f15167e = false;
                    }
                }
                h.this.f15167e = false;
            } finally {
                if (h.this.f15166d) {
                    try {
                        file.delete();
                    } catch (Exception e17) {
                        h.this.d("After failed delete file exception: " + e17.getMessage());
                    }
                }
                h.this.f15167e = false;
            }
        }
    }

    public h(String str, String str2, boolean z10, a aVar) {
        this.f15163a = str2;
        this.f15164b = str;
        this.f15165c = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(String str) {
        this.f15166d = true;
        this.f15165c.b(this, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        this.f15165c.a(this, this.f15168f, this.f15169g);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        this.f15165c.c(this);
    }

    public void g() {
        if (this.f15167e) {
            d("the file is already downloading...");
        } else {
            this.f15167e = true;
            new Thread(new b()).start();
        }
    }
}
