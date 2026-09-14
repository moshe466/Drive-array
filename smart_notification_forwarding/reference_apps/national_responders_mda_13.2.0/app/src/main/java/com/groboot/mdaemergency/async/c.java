package com.groboot.mdaemergency.async;

import com.groboot.mdaemergency.models.NetworkSettings;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.Hashtable;
import w6.z;

/* loaded from: classes.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    b f7619a;

    /* renamed from: b, reason: collision with root package name */
    Hashtable<b, Date> f7620b;

    /* renamed from: c, reason: collision with root package name */
    int f7621c;

    /* renamed from: d, reason: collision with root package name */
    Socket f7622d;

    /* renamed from: e, reason: collision with root package name */
    InputStream f7623e;

    /* renamed from: f, reason: collision with root package name */
    OutputStream f7624f;

    /* renamed from: g, reason: collision with root package name */
    a f7625g;

    /* renamed from: h, reason: collision with root package name */
    String f7626h;

    /* renamed from: i, reason: collision with root package name */
    int f7627i;

    /* renamed from: j, reason: collision with root package name */
    int f7628j;

    /* renamed from: k, reason: collision with root package name */
    String f7629k = "[OpenSocket].[NetworkTask]";

    /* loaded from: classes.dex */
    public interface a {
        void a(int i10, b bVar);

        void b(int i10, String str);
    }

    /* loaded from: classes.dex */
    public enum b {
        init,
        connecting,
        connect,
        failed,
        close
    }

    public c(NetworkSettings networkSettings, int i10) {
        this.f7626h = networkSettings.IP;
        this.f7627i = networkSettings.port;
        this.f7628j = networkSettings.timeout;
        this.f7621c = i10;
        Hashtable<b, Date> hashtable = new Hashtable<>();
        this.f7620b = hashtable;
        hashtable.put(b.init, new Date());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public Boolean g() {
        boolean z10 = true;
        try {
            try {
                k(b.connecting);
                InetSocketAddress inetSocketAddress = new InetSocketAddress(this.f7626h, this.f7627i);
                Socket socket = new Socket();
                this.f7622d = socket;
                socket.connect(inetSocketAddress, this.f7628j);
                if (this.f7622d.isConnected()) {
                    this.f7623e = this.f7622d.getInputStream();
                    this.f7624f = this.f7622d.getOutputStream();
                    k(b.connect);
                    b("Token:" + z.b().c());
                    byte[] bArr = new byte[4096];
                    InputStream inputStream = this.f7623e;
                    while (true) {
                        int read = inputStream.read(bArr, 0, 4096);
                        if (read == -1 || this.f7619a != b.connect) {
                            break;
                        }
                        byte[] bArr2 = new byte[read];
                        System.arraycopy(bArr, 0, bArr2, 0, read);
                        h(bArr2);
                        inputStream = this.f7623e;
                    }
                    z10 = false;
                } else {
                    k(b.failed);
                }
            } catch (Exception e10) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("ERROR_1: ");
                sb2.append(e10.getMessage());
                e10.printStackTrace();
                StringBuilder sb3 = new StringBuilder();
                sb3.append("ERROR_1: ");
                sb3.append(e10.getMessage());
                k(b.failed);
            }
            return Boolean.valueOf(z10);
        } finally {
            c();
        }
    }

    private void k(b bVar) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("NetworkTask[");
        sb2.append(this.f7621c);
        sb2.append("] ");
        StringBuilder sb3 = new StringBuilder();
        sb3.append("set status: ");
        sb3.append(this.f7619a);
        sb3.append("-->>");
        sb3.append(bVar);
        this.f7619a = bVar;
        a aVar = this.f7625g;
        if (aVar != null) {
            aVar.a(this.f7621c, bVar);
        }
        if (f(bVar) == null) {
            this.f7620b.put(bVar, new Date());
        }
    }

    public boolean b(String str) {
        Socket socket;
        OutputStream outputStream;
        try {
            if (this.f7619a != b.connect || (socket = this.f7622d) == null || !socket.isConnected() || (outputStream = this.f7624f) == null) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("NetworkTask[");
                sb2.append(this.f7621c);
                sb2.append("] ");
                return false;
            }
            outputStream.write(str.getBytes());
            this.f7624f.flush();
            StringBuilder sb3 = new StringBuilder();
            sb3.append("sendDataToNetwork: ");
            sb3.append(str);
            return true;
        } catch (Exception e10) {
            StringBuilder sb4 = new StringBuilder();
            sb4.append("NetworkTask[");
            sb4.append(this.f7621c);
            sb4.append("] ");
            StringBuilder sb5 = new StringBuilder();
            sb5.append("send data Exception ");
            sb5.append(e10.getMessage());
            return false;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void c() {
        try {
            InputStream inputStream = this.f7623e;
            if (inputStream != null) {
                inputStream.close();
            }
        } catch (Exception e10) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("ERROR_2: ");
            sb2.append(e10.getMessage());
            StringBuilder sb3 = new StringBuilder();
            sb3.append("ERROR_2: ");
            sb3.append(e10.getMessage());
            k(b.failed);
            e10.printStackTrace();
        }
        try {
            OutputStream outputStream = this.f7624f;
            if (outputStream != null) {
                outputStream.close();
            }
        } catch (Exception e11) {
            StringBuilder sb4 = new StringBuilder();
            sb4.append("ERROR_2: ");
            sb4.append(e11.getMessage());
            StringBuilder sb5 = new StringBuilder();
            sb5.append("ERROR_2: ");
            sb5.append(e11.getMessage());
            k(b.failed);
            e11.printStackTrace();
        }
        try {
            try {
                Socket socket = this.f7622d;
                if (socket != null) {
                    socket.close();
                }
            } finally {
                this.f7623e = null;
                this.f7624f = null;
                this.f7622d = null;
                k(b.close);
            }
        } catch (Exception e12) {
            StringBuilder sb6 = new StringBuilder();
            sb6.append("ERROR_2: ");
            sb6.append(e12.getMessage());
            StringBuilder sb7 = new StringBuilder();
            sb7.append("ERROR_2: ");
            sb7.append(e12.getMessage());
            k(b.failed);
            e12.printStackTrace();
        }
    }

    public int e() {
        return this.f7621c;
    }

    public Date f(b bVar) {
        if (this.f7620b.containsKey(bVar)) {
            return this.f7620b.get(bVar);
        }
        return null;
    }

    protected void h(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            return;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("NetworkTask[");
        sb2.append(this.f7621c);
        sb2.append("] ");
        StringBuilder sb3 = new StringBuilder();
        sb3.append(" data received. length:");
        sb3.append(bArr.length);
        StringBuilder sb4 = new StringBuilder();
        sb4.append("onDataReceived: ");
        sb4.append(bArr.length);
        sb4.append(" bytes received.");
        this.f7625g.b(this.f7621c, new String(bArr, StandardCharsets.UTF_8));
    }

    public void i() {
        Thread thread = new Thread(new Runnable() { // from class: o5.h
            @Override // java.lang.Runnable
            public final void run() {
                com.groboot.mdaemergency.async.c.this.g();
            }
        });
        thread.setPriority(10);
        thread.start();
    }

    public void j(a aVar) {
        this.f7625g = aVar;
    }
}
