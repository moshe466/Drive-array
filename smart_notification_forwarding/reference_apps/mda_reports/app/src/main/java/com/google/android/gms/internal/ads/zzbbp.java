package com.google.android.gms.internal.ads;

import android.net.Uri;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.net.HttpURLConnection;
import java.net.Socket;
import java.net.SocketException;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;
import java.util.regex.Pattern;
import javax.net.ssl.SSLSocketFactory;

/* loaded from: classes.dex */
final class zzbbp implements zznl {
    private static final Pattern zzbew = Pattern.compile("^bytes (\\d+)-(\\d+)/(\\d+)$");
    private static final AtomicReference<byte[]> zzbex = new AtomicReference<>();
    private zznq zzbev;
    private final int zzbez;
    private final int zzbfa;
    private final String zzbfb;
    private final zznz<? super zzbbp> zzbff;
    private HttpURLConnection zzbfg;
    private InputStream zzbfh;
    private boolean zzbfi;
    private long zzbfj;
    private long zzbfk;
    private long zzbfl;
    private long zzcf;
    private int zzebr;
    private SSLSocketFactory zzebq = new zzbbo(this);
    private Set<Socket> zzebs = new HashSet();
    private final zznt zzbfe = new zznt();

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbbp(String str, zznz<? super zzbbp> zznzVar, int i, int i2, int i3) {
        this.zzbfb = zzoc.checkNotEmpty(str);
        this.zzbff = zznzVar;
        this.zzbez = i;
        this.zzbfa = i2;
        this.zzebr = i3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzb(Socket socket) {
        this.zzebs.add(socket);
    }

    /* JADX WARN: Removed duplicated region for block: B:25:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:6:0x0042  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static long zzc(java.net.HttpURLConnection r9) {
        /*
            java.lang.String r0 = "Content-Length"
            java.lang.String r0 = r9.getHeaderField(r0)
            boolean r1 = android.text.TextUtils.isEmpty(r0)
            java.lang.String r2 = "]"
            if (r1 != 0) goto L34
            long r3 = java.lang.Long.parseLong(r0)     // Catch: java.lang.NumberFormatException -> L13
            goto L36
        L13:
            java.lang.String r1 = java.lang.String.valueOf(r0)
            int r1 = r1.length()
            int r1 = r1 + 28
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>(r1)
            java.lang.String r1 = "Unexpected Content-Length ["
            r3.append(r1)
            r3.append(r0)
            r3.append(r2)
            java.lang.String r1 = r3.toString()
            com.google.android.gms.internal.ads.zzayu.zzex(r1)
        L34:
            r3 = -1
        L36:
            java.lang.String r1 = "Content-Range"
            java.lang.String r9 = r9.getHeaderField(r1)
            boolean r1 = android.text.TextUtils.isEmpty(r9)
            if (r1 != 0) goto Lc9
            java.util.regex.Pattern r1 = com.google.android.gms.internal.ads.zzbbp.zzbew
            java.util.regex.Matcher r1 = r1.matcher(r9)
            boolean r5 = r1.find()
            if (r5 == 0) goto Lc9
            r5 = 2
            java.lang.String r5 = r1.group(r5)     // Catch: java.lang.NumberFormatException -> La8
            long r5 = java.lang.Long.parseLong(r5)     // Catch: java.lang.NumberFormatException -> La8
            r7 = 1
            java.lang.String r1 = r1.group(r7)     // Catch: java.lang.NumberFormatException -> La8
            long r7 = java.lang.Long.parseLong(r1)     // Catch: java.lang.NumberFormatException -> La8
            long r5 = r5 - r7
            r7 = 1
            long r5 = r5 + r7
            r7 = 0
            int r1 = (r3 > r7 ? 1 : (r3 == r7 ? 0 : -1))
            if (r1 >= 0) goto L6c
            r3 = r5
            goto Lc9
        L6c:
            int r1 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r1 == 0) goto Lc9
            java.lang.String r1 = java.lang.String.valueOf(r0)     // Catch: java.lang.NumberFormatException -> La8
            int r1 = r1.length()     // Catch: java.lang.NumberFormatException -> La8
            int r1 = r1 + 26
            java.lang.String r7 = java.lang.String.valueOf(r9)     // Catch: java.lang.NumberFormatException -> La8
            int r7 = r7.length()     // Catch: java.lang.NumberFormatException -> La8
            int r1 = r1 + r7
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch: java.lang.NumberFormatException -> La8
            r7.<init>(r1)     // Catch: java.lang.NumberFormatException -> La8
            java.lang.String r1 = "Inconsistent headers ["
            r7.append(r1)     // Catch: java.lang.NumberFormatException -> La8
            r7.append(r0)     // Catch: java.lang.NumberFormatException -> La8
            java.lang.String r0 = "] ["
            r7.append(r0)     // Catch: java.lang.NumberFormatException -> La8
            r7.append(r9)     // Catch: java.lang.NumberFormatException -> La8
            r7.append(r2)     // Catch: java.lang.NumberFormatException -> La8
            java.lang.String r0 = r7.toString()     // Catch: java.lang.NumberFormatException -> La8
            com.google.android.gms.internal.ads.zzayu.zzez(r0)     // Catch: java.lang.NumberFormatException -> La8
            long r0 = java.lang.Math.max(r3, r5)     // Catch: java.lang.NumberFormatException -> La8
            r3 = r0
            goto Lc9
        La8:
            java.lang.String r0 = java.lang.String.valueOf(r9)
            int r0 = r0.length()
            int r0 = r0 + 27
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>(r0)
            java.lang.String r0 = "Unexpected Content-Range ["
            r1.append(r0)
            r1.append(r9)
            r1.append(r2)
            java.lang.String r9 = r1.toString()
            com.google.android.gms.internal.ads.zzayu.zzex(r9)
        Lc9:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbbp.zzc(java.net.HttpURLConnection):long");
    }

    private final void zzij() {
        HttpURLConnection httpURLConnection = this.zzbfg;
        if (httpURLConnection != null) {
            try {
                httpURLConnection.disconnect();
            } catch (Exception e) {
                zzayu.zzc("Unexpected error while disconnecting", e);
            }
            this.zzbfg = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(int i) {
        this.zzebr = i;
        for (Socket socket : this.zzebs) {
            if (!socket.isClosed()) {
                try {
                    socket.setReceiveBufferSize(this.zzebr);
                } catch (SocketException e) {
                    zzayu.zzd("Failed to update receive buffer size.", e);
                }
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:34:0x0038, code lost:
    
        if (r3 > android.support.v4.media.session.PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH) goto L21;
     */
    @Override // com.google.android.gms.internal.ads.zznl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void close() {
        /*
            r9 = this;
            r0 = 0
            r1 = 0
            java.io.InputStream r2 = r9.zzbfh     // Catch: java.lang.Throwable -> L93
            if (r2 == 0) goto L7b
            java.net.HttpURLConnection r2 = r9.zzbfg     // Catch: java.lang.Throwable -> L93
            long r3 = r9.zzbfk     // Catch: java.lang.Throwable -> L93
            r5 = -1
            int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r7 != 0) goto L13
            long r3 = r9.zzbfk     // Catch: java.lang.Throwable -> L93
            goto L18
        L13:
            long r3 = r9.zzbfk     // Catch: java.lang.Throwable -> L93
            long r7 = r9.zzcf     // Catch: java.lang.Throwable -> L93
            long r3 = r3 - r7
        L18:
            int r7 = com.google.android.gms.internal.ads.zzoq.SDK_INT     // Catch: java.lang.Throwable -> L93
            r8 = 19
            if (r7 == r8) goto L24
            int r7 = com.google.android.gms.internal.ads.zzoq.SDK_INT     // Catch: java.lang.Throwable -> L93
            r8 = 20
            if (r7 != r8) goto L6b
        L24:
            java.io.InputStream r2 = r2.getInputStream()     // Catch: java.lang.Exception -> L6b java.lang.Throwable -> L93
            int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r7 != 0) goto L34
            int r3 = r2.read()     // Catch: java.lang.Exception -> L6b java.lang.Throwable -> L93
            r4 = -1
            if (r3 != r4) goto L3a
            goto L6b
        L34:
            r5 = 2048(0x800, double:1.0118E-320)
            int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r7 <= 0) goto L6b
        L3a:
            java.lang.Class r3 = r2.getClass()     // Catch: java.lang.Exception -> L6b java.lang.Throwable -> L93
            java.lang.String r3 = r3.getName()     // Catch: java.lang.Exception -> L6b java.lang.Throwable -> L93
            java.lang.String r4 = "com.android.okhttp.internal.http.HttpTransport$ChunkedInputStream"
            boolean r4 = r3.equals(r4)     // Catch: java.lang.Exception -> L6b java.lang.Throwable -> L93
            if (r4 != 0) goto L52
            java.lang.String r4 = "com.android.okhttp.internal.http.HttpTransport$FixedLengthInputStream"
            boolean r3 = r3.equals(r4)     // Catch: java.lang.Exception -> L6b java.lang.Throwable -> L93
            if (r3 == 0) goto L6b
        L52:
            java.lang.Class r3 = r2.getClass()     // Catch: java.lang.Exception -> L6b java.lang.Throwable -> L93
            java.lang.Class r3 = r3.getSuperclass()     // Catch: java.lang.Exception -> L6b java.lang.Throwable -> L93
            java.lang.String r4 = "unexpectedEndOfInput"
            java.lang.Class[] r5 = new java.lang.Class[r1]     // Catch: java.lang.Exception -> L6b java.lang.Throwable -> L93
            java.lang.reflect.Method r3 = r3.getDeclaredMethod(r4, r5)     // Catch: java.lang.Exception -> L6b java.lang.Throwable -> L93
            r4 = 1
            r3.setAccessible(r4)     // Catch: java.lang.Exception -> L6b java.lang.Throwable -> L93
            java.lang.Object[] r4 = new java.lang.Object[r1]     // Catch: java.lang.Exception -> L6b java.lang.Throwable -> L93
            r3.invoke(r2, r4)     // Catch: java.lang.Exception -> L6b java.lang.Throwable -> L93
        L6b:
            java.io.InputStream r2 = r9.zzbfh     // Catch: java.io.IOException -> L71 java.lang.Throwable -> L93
            r2.close()     // Catch: java.io.IOException -> L71 java.lang.Throwable -> L93
            goto L7b
        L71:
            r2 = move-exception
            com.google.android.gms.internal.ads.zznr r3 = new com.google.android.gms.internal.ads.zznr     // Catch: java.lang.Throwable -> L93
            com.google.android.gms.internal.ads.zznq r4 = r9.zzbev     // Catch: java.lang.Throwable -> L93
            r5 = 3
            r3.<init>(r2, r4, r5)     // Catch: java.lang.Throwable -> L93
            throw r3     // Catch: java.lang.Throwable -> L93
        L7b:
            r9.zzbfh = r0
            r9.zzij()
            boolean r0 = r9.zzbfi
            if (r0 == 0) goto L8d
            r9.zzbfi = r1
            com.google.android.gms.internal.ads.zznz<? super com.google.android.gms.internal.ads.zzbbp> r0 = r9.zzbff
            if (r0 == 0) goto L8d
            r0.zze(r9)
        L8d:
            java.util.Set<java.net.Socket> r0 = r9.zzebs
            r0.clear()
            return
        L93:
            r2 = move-exception
            r9.zzbfh = r0
            r9.zzij()
            boolean r0 = r9.zzbfi
            if (r0 == 0) goto La6
            r9.zzbfi = r1
            com.google.android.gms.internal.ads.zznz<? super com.google.android.gms.internal.ads.zzbbp> r0 = r9.zzbff
            if (r0 == 0) goto La6
            r0.zze(r9)
        La6:
            java.util.Set<java.net.Socket> r0 = r9.zzebs
            r0.clear()
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbbp.close():void");
    }

    @Override // com.google.android.gms.internal.ads.zznl
    public final Uri getUri() {
        HttpURLConnection httpURLConnection = this.zzbfg;
        if (httpURLConnection == null) {
            return null;
        }
        return Uri.parse(httpURLConnection.getURL().toString());
    }

    @Override // com.google.android.gms.internal.ads.zznl
    public final int read(byte[] bArr, int i, int i2) {
        try {
            if (this.zzbfl != this.zzbfj) {
                byte[] andSet = zzbex.getAndSet(null);
                if (andSet == null) {
                    andSet = new byte[4096];
                }
                while (this.zzbfl != this.zzbfj) {
                    int read = this.zzbfh.read(andSet, 0, (int) Math.min(this.zzbfj - this.zzbfl, andSet.length));
                    if (Thread.interrupted()) {
                        throw new InterruptedIOException();
                    }
                    if (read == -1) {
                        throw new EOFException();
                    }
                    this.zzbfl += read;
                    if (this.zzbff != null) {
                        this.zzbff.zzc(this, read);
                    }
                }
                zzbex.set(andSet);
            }
            if (i2 == 0) {
                return 0;
            }
            if (this.zzbfk != -1) {
                long j = this.zzbfk - this.zzcf;
                if (j == 0) {
                    return -1;
                }
                i2 = (int) Math.min(i2, j);
            }
            int read2 = this.zzbfh.read(bArr, i, i2);
            if (read2 == -1) {
                if (this.zzbfk == -1) {
                    return -1;
                }
                throw new EOFException();
            }
            this.zzcf += read2;
            if (this.zzbff != null) {
                this.zzbff.zzc(this, read2);
            }
            return read2;
        } catch (IOException e) {
            throw new zznr(e, this.zzbev, 2);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:46:0x012d, code lost:
    
        r23.zzbfg = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x012f, code lost:
    
        r0 = r23.zzbfg.getResponseCode();
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x0137, code lost:
    
        if (r0 < 200) goto L83;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x013b, code lost:
    
        if (r0 <= 299) goto L58;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x013e, code lost:
    
        if (r0 != 200) goto L62;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x0140, code lost:
    
        r4 = r24.zzamw;
        r8 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x0146, code lost:
    
        if (r4 == 0) goto L63;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x014b, code lost:
    
        r4 = r8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x014c, code lost:
    
        r23.zzbfj = r4;
        r0 = r24.zzbb(1);
        r3 = r24.zzce;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x0155, code lost:
    
        if (r0 != false) goto L73;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x015b, code lost:
    
        if (r3 == (-1)) goto L69;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x015e, code lost:
    
        r3 = zzc(r23.zzbfg);
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x0166, code lost:
    
        if (r3 == (-1)) goto L72;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x0168, code lost:
    
        r3 = r3 - r23.zzbfj;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x016c, code lost:
    
        r3 = -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x016d, code lost:
    
        r23.zzbfk = r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x016f, code lost:
    
        r23.zzbfh = r23.zzbfg.getInputStream();
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x0177, code lost:
    
        r23.zzbfi = true;
        r0 = r23.zzbff;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x017c, code lost:
    
        if (r0 == null) goto L78;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x017e, code lost:
    
        r0.zza(r23, r24);
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x0183, code lost:
    
        return r23.zzbfk;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x0184, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x0185, code lost:
    
        zzij();
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x018e, code lost:
    
        throw new com.google.android.gms.internal.ads.zznr(r0, r24, 1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x0149, code lost:
    
        r8 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x018f, code lost:
    
        r3 = r23.zzbfg.getHeaderFields();
        zzij();
        r4 = new com.google.android.gms.internal.ads.zznu(r0, r3, r24);
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x019f, code lost:
    
        if (r0 != 416) goto L133;
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x01a1, code lost:
    
        r4.initCause(new com.google.android.gms.internal.ads.zznn(0));
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x01aa, code lost:
    
        throw r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:83:?, code lost:
    
        throw r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:85:0x01ab, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:86:0x01ac, code lost:
    
        zzij();
        r5 = java.lang.String.valueOf(r24.uri.toString());
     */
    /* JADX WARN: Code restructure failed: missing block: B:87:0x01bf, code lost:
    
        if (r5.length() != 0) goto L90;
     */
    /* JADX WARN: Code restructure failed: missing block: B:88:0x01c1, code lost:
    
        r3 = "Unable to connect to ".concat(r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:90:0x01d0, code lost:
    
        throw new com.google.android.gms.internal.ads.zznr(r3, r0, r24, 1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:91:0x01c6, code lost:
    
        r3 = new java.lang.String("Unable to connect to ");
     */
    /* JADX WARN: Removed duplicated region for block: B:110:0x021d A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:114:0x00ea  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00db A[Catch: IOException -> 0x023e, TryCatch #1 {IOException -> 0x023e, blocks: (B:3:0x000f, B:4:0x0027, B:6:0x002d, B:8:0x0037, B:9:0x003f, B:10:0x0057, B:12:0x005d, B:20:0x00d2, B:22:0x00db, B:23:0x00e2, B:26:0x00eb, B:28:0x00f0, B:30:0x00f8, B:31:0x010d, B:46:0x012d, B:94:0x01d5, B:96:0x01e0, B:98:0x01f1, B:101:0x01f9, B:103:0x0207, B:104:0x0211, B:105:0x0214, B:106:0x020c, B:111:0x021d, B:112:0x0224, B:113:0x010a, B:115:0x0087, B:117:0x00a3, B:118:0x00cd, B:121:0x0225, B:122:0x023d), top: B:2:0x000f }] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00e8  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00f0 A[Catch: IOException -> 0x023e, TryCatch #1 {IOException -> 0x023e, blocks: (B:3:0x000f, B:4:0x0027, B:6:0x002d, B:8:0x0037, B:9:0x003f, B:10:0x0057, B:12:0x005d, B:20:0x00d2, B:22:0x00db, B:23:0x00e2, B:26:0x00eb, B:28:0x00f0, B:30:0x00f8, B:31:0x010d, B:46:0x012d, B:94:0x01d5, B:96:0x01e0, B:98:0x01f1, B:101:0x01f9, B:103:0x0207, B:104:0x0211, B:105:0x0214, B:106:0x020c, B:111:0x021d, B:112:0x0224, B:113:0x010a, B:115:0x0087, B:117:0x00a3, B:118:0x00cd, B:121:0x0225, B:122:0x023d), top: B:2:0x000f }] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0115  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x01e0 A[Catch: IOException -> 0x023e, TryCatch #1 {IOException -> 0x023e, blocks: (B:3:0x000f, B:4:0x0027, B:6:0x002d, B:8:0x0037, B:9:0x003f, B:10:0x0057, B:12:0x005d, B:20:0x00d2, B:22:0x00db, B:23:0x00e2, B:26:0x00eb, B:28:0x00f0, B:30:0x00f8, B:31:0x010d, B:46:0x012d, B:94:0x01d5, B:96:0x01e0, B:98:0x01f1, B:101:0x01f9, B:103:0x0207, B:104:0x0211, B:105:0x0214, B:106:0x020c, B:111:0x021d, B:112:0x0224, B:113:0x010a, B:115:0x0087, B:117:0x00a3, B:118:0x00cd, B:121:0x0225, B:122:0x023d), top: B:2:0x000f }] */
    @Override // com.google.android.gms.internal.ads.zznl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final long zza(com.google.android.gms.internal.ads.zznq r24) {
        /*
            Method dump skipped, instructions count: 611
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbbp.zza(com.google.android.gms.internal.ads.zznq):long");
    }
}
