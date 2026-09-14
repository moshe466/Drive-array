package bc;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.logging.Level;
import java.util.logging.Logger;

/* loaded from: classes.dex */
public final class l {

    /* renamed from: a, reason: collision with root package name */
    static final Logger f4316a = Logger.getLogger(l.class.getName());

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public final class a implements r {

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ t f4317f;

        /* renamed from: g, reason: collision with root package name */
        final /* synthetic */ OutputStream f4318g;

        a(t tVar, OutputStream outputStream) {
            this.f4317f = tVar;
            this.f4318g = outputStream;
        }

        @Override // bc.r, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            this.f4318g.close();
        }

        @Override // bc.r
        public t e() {
            return this.f4317f;
        }

        @Override // bc.r, java.io.Flushable
        public void flush() {
            this.f4318g.flush();
        }

        @Override // bc.r
        public void l(bc.c cVar, long j10) {
            u.b(cVar.f4298g, 0L, j10);
            while (j10 > 0) {
                this.f4317f.f();
                o oVar = cVar.f4297f;
                int min = (int) Math.min(j10, oVar.f4330c - oVar.f4329b);
                this.f4318g.write(oVar.f4328a, oVar.f4329b, min);
                int i10 = oVar.f4329b + min;
                oVar.f4329b = i10;
                long j11 = min;
                j10 -= j11;
                cVar.f4298g -= j11;
                if (i10 == oVar.f4330c) {
                    cVar.f4297f = oVar.b();
                    p.a(oVar);
                }
            }
        }

        public String toString() {
            return "sink(" + this.f4318g + ")";
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public final class b implements s {

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ t f4319f;

        /* renamed from: g, reason: collision with root package name */
        final /* synthetic */ InputStream f4320g;

        b(t tVar, InputStream inputStream) {
            this.f4319f = tVar;
            this.f4320g = inputStream;
        }

        @Override // bc.s
        public long G(bc.c cVar, long j10) {
            if (j10 < 0) {
                throw new IllegalArgumentException("byteCount < 0: " + j10);
            }
            if (j10 == 0) {
                return 0L;
            }
            try {
                this.f4319f.f();
                o q02 = cVar.q0(1);
                int read = this.f4320g.read(q02.f4328a, q02.f4330c, (int) Math.min(j10, 8192 - q02.f4330c));
                if (read == -1) {
                    return -1L;
                }
                q02.f4330c += read;
                long j11 = read;
                cVar.f4298g += j11;
                return j11;
            } catch (AssertionError e10) {
                if (l.c(e10)) {
                    throw new IOException(e10);
                }
                throw e10;
            }
        }

        @Override // bc.s, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            this.f4320g.close();
        }

        @Override // bc.s
        public t e() {
            return this.f4319f;
        }

        public String toString() {
            return "source(" + this.f4320g + ")";
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public final class c extends bc.a {

        /* renamed from: k, reason: collision with root package name */
        final /* synthetic */ Socket f4321k;

        c(Socket socket) {
            this.f4321k = socket;
        }

        @Override // bc.a
        protected IOException o(IOException iOException) {
            SocketTimeoutException socketTimeoutException = new SocketTimeoutException("timeout");
            if (iOException != null) {
                socketTimeoutException.initCause(iOException);
            }
            return socketTimeoutException;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // bc.a
        protected void t() {
            Level level;
            StringBuilder sb2;
            Logger logger;
            Exception exc;
            try {
                this.f4321k.close();
            } catch (AssertionError e10) {
                if (!l.c(e10)) {
                    throw e10;
                }
                Logger logger2 = l.f4316a;
                level = Level.WARNING;
                sb2 = new StringBuilder();
                exc = e10;
                logger = logger2;
                sb2.append("Failed to close timed out socket ");
                sb2.append(this.f4321k);
                logger.log(level, sb2.toString(), (Throwable) exc);
            } catch (Exception e11) {
                Logger logger3 = l.f4316a;
                level = Level.WARNING;
                sb2 = new StringBuilder();
                exc = e11;
                logger = logger3;
                sb2.append("Failed to close timed out socket ");
                sb2.append(this.f4321k);
                logger.log(level, sb2.toString(), (Throwable) exc);
            }
        }
    }

    private l() {
    }

    public static d a(r rVar) {
        return new m(rVar);
    }

    public static e b(s sVar) {
        return new n(sVar);
    }

    static boolean c(AssertionError assertionError) {
        return (assertionError.getCause() == null || assertionError.getMessage() == null || !assertionError.getMessage().contains("getsockname failed")) ? false : true;
    }

    private static r d(OutputStream outputStream, t tVar) {
        if (outputStream == null) {
            throw new IllegalArgumentException("out == null");
        }
        if (tVar != null) {
            return new a(tVar, outputStream);
        }
        throw new IllegalArgumentException("timeout == null");
    }

    public static r e(Socket socket) {
        if (socket == null) {
            throw new IllegalArgumentException("socket == null");
        }
        if (socket.getOutputStream() == null) {
            throw new IOException("socket's output stream == null");
        }
        bc.a j10 = j(socket);
        return j10.r(d(socket.getOutputStream(), j10));
    }

    public static s f(File file) {
        if (file != null) {
            return g(new FileInputStream(file));
        }
        throw new IllegalArgumentException("file == null");
    }

    public static s g(InputStream inputStream) {
        return h(inputStream, new t());
    }

    private static s h(InputStream inputStream, t tVar) {
        if (inputStream == null) {
            throw new IllegalArgumentException("in == null");
        }
        if (tVar != null) {
            return new b(tVar, inputStream);
        }
        throw new IllegalArgumentException("timeout == null");
    }

    public static s i(Socket socket) {
        if (socket == null) {
            throw new IllegalArgumentException("socket == null");
        }
        if (socket.getInputStream() == null) {
            throw new IOException("socket's input stream == null");
        }
        bc.a j10 = j(socket);
        return j10.s(h(socket.getInputStream(), j10));
    }

    private static bc.a j(Socket socket) {
        return new c(socket);
    }
}
