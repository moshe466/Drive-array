package org.apache.tika.fork;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.NotSerializableException;
import java.io.OutputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URL;
import org.apache.tika.exception.TikaException;

/* loaded from: classes.dex */
class ForkServer implements Runnable {
    public static final byte CALL = 1;
    public static final byte DONE = 0;
    public static final byte ERROR = -1;
    public static final byte FAILED_TO_START = 5;
    public static final byte INIT_LOADER_PARSER = 7;
    public static final byte INIT_PARSER_FACTORY_FACTORY = 6;
    public static final byte INIT_PARSER_FACTORY_FACTORY_LOADER = 8;
    public static final byte PING = 2;
    public static final byte READY = 4;
    public static final byte RESOURCE = 3;
    private ClassLoader classLoader;
    private final DataInputStream input;
    private final DataOutputStream output;
    private Object parser;
    private boolean parsing;
    private long serverParserTimeoutMillis;
    private long serverPulseMillis;
    private long serverWaitTimeoutMillis;
    private final Object[] lock = new Object[0];
    private final boolean active = true;
    private long since = System.currentTimeMillis();

    public ForkServer(InputStream inputStream, OutputStream outputStream, long j2, long j3, long j4) {
        this.serverPulseMillis = 5000L;
        this.serverParserTimeoutMillis = 60000L;
        this.serverWaitTimeoutMillis = 60000L;
        this.parsing = false;
        this.input = new DataInputStream(inputStream);
        this.output = new DataOutputStream(outputStream);
        this.serverPulseMillis = j2;
        this.serverParserTimeoutMillis = j3;
        this.serverWaitTimeoutMillis = j4;
        this.parsing = false;
    }

    private void call(ClassLoader classLoader, Object obj) {
        synchronized (this.lock) {
            this.parsing = true;
            this.since = System.currentTimeMillis();
        }
        try {
            Method method = getMethod(obj, this.input.readUTF());
            int length = method.getParameterTypes().length;
            Object[] objArr = new Object[length];
            for (int i = 0; i < length; i++) {
                objArr[i] = readObject(classLoader);
            }
            try {
                method.invoke(obj, objArr);
                this.output.write(0);
            } catch (InvocationTargetException e4) {
                this.output.write(-1);
                Throwable cause = e4.getCause();
                try {
                    ForkObjectInputStream.sendObject(cause, this.output);
                } catch (NotSerializableException unused) {
                    TikaException tikaException = new TikaException(cause.getMessage());
                    tikaException.setStackTrace(cause.getStackTrace());
                    ForkObjectInputStream.sendObject(tikaException, this.output);
                }
            }
            synchronized (this.lock) {
                this.parsing = false;
                this.since = System.currentTimeMillis();
            }
        } catch (Throwable th) {
            synchronized (this.lock) {
                this.parsing = false;
                this.since = System.currentTimeMillis();
                throw th;
            }
        }
    }

    private Method getMethod(Object obj, String str) {
        for (Class<?> cls = obj.getClass(); cls != null; cls = cls.getSuperclass()) {
            for (Class<?> cls2 : cls.getInterfaces()) {
                for (Method method : cls2.getMethods()) {
                    if (str.equals(method.getName())) {
                        return method;
                    }
                }
            }
        }
        return null;
    }

    private void initializeParserAndLoader() {
        this.output.writeByte(4);
        this.output.flush();
        int read = this.input.read();
        if (read != -1) {
            Object readObject = readObject(ForkServer.class.getClassLoader());
            if (read != 6) {
                if (read != 7) {
                    if (read == 8) {
                        if (readObject instanceof ParserFactoryFactory) {
                            this.parser = ((ParserFactoryFactory) readObject).build().build();
                            this.classLoader = (ClassLoader) readObject(ForkServer.class.getClassLoader());
                            Thread.currentThread().setContextClassLoader(this.classLoader);
                        } else {
                            throw new IllegalStateException("Expecing ParserFactoryFactory followed by a class loader");
                        }
                    }
                } else if (readObject instanceof ClassLoader) {
                    this.classLoader = (ClassLoader) readObject;
                    Thread.currentThread().setContextClassLoader(this.classLoader);
                    this.parser = readObject(this.classLoader);
                } else {
                    throw new IllegalArgumentException("Expecting ClassLoader followed by a Parser");
                }
            } else if (readObject instanceof ParserFactoryFactory) {
                this.classLoader = ForkServer.class.getClassLoader();
                this.parser = ((ParserFactoryFactory) readObject).build().build();
            } else {
                throw new IllegalArgumentException("Expecting only one object of class ParserFactoryFactory");
            }
            this.output.writeByte(4);
            this.output.flush();
            return;
        }
        throw new TikaException("eof! pipe closed?!");
    }

    public static void main(String[] strArr) {
        long parseLong = Long.parseLong(strArr[0]);
        long parseLong2 = Long.parseLong(strArr[1]);
        long parseLong3 = Long.parseLong(strArr[2]);
        URL.setURLStreamHandlerFactory(new MemoryURLStreamHandlerFactory());
        ForkServer forkServer = new ForkServer(System.in, System.out, parseLong, parseLong2, parseLong3);
        System.setIn(new ByteArrayInputStream(new byte[0]));
        System.setOut(System.err);
        Thread thread = new Thread(forkServer, "Tika Watchdog");
        thread.setDaemon(true);
        thread.start();
        forkServer.processRequests();
    }

    private Object readObject(ClassLoader classLoader) {
        Object readObject = ForkObjectInputStream.readObject(this.input, classLoader);
        if (readObject instanceof ForkProxy) {
            ((ForkProxy) readObject).init(this.input, this.output);
        }
        this.output.writeByte(0);
        this.output.flush();
        return readObject;
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x002f, code lost:
    
        throw new java.lang.IllegalStateException("Unexpected request");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void processRequests() {
        /*
            r2 = this;
            r2.initializeParserAndLoader()     // Catch: java.lang.Throwable -> L39
        L3:
            java.io.DataInputStream r0 = r2.input     // Catch: java.lang.Throwable -> L16
            int r0 = r0.read()     // Catch: java.lang.Throwable -> L16
            r1 = -1
            if (r0 != r1) goto Ld
            goto L33
        Ld:
            r1 = 2
            if (r0 != r1) goto L18
            java.io.DataOutputStream r0 = r2.output     // Catch: java.lang.Throwable -> L16
            r0.writeByte(r1)     // Catch: java.lang.Throwable -> L16
            goto L22
        L16:
            r0 = move-exception
            goto L30
        L18:
            r1 = 1
            if (r0 != r1) goto L28
            java.lang.ClassLoader r0 = r2.classLoader     // Catch: java.lang.Throwable -> L16
            java.lang.Object r1 = r2.parser     // Catch: java.lang.Throwable -> L16
            r2.call(r0, r1)     // Catch: java.lang.Throwable -> L16
        L22:
            java.io.DataOutputStream r0 = r2.output     // Catch: java.lang.Throwable -> L16
            r0.flush()     // Catch: java.lang.Throwable -> L16
            goto L3
        L28:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException     // Catch: java.lang.Throwable -> L16
            java.lang.String r1 = "Unexpected request"
            r0.<init>(r1)     // Catch: java.lang.Throwable -> L16
            throw r0     // Catch: java.lang.Throwable -> L16
        L30:
            r0.printStackTrace()
        L33:
            java.io.PrintStream r0 = java.lang.System.err
            r0.flush()
            return
        L39:
            r0 = move-exception
            r0.printStackTrace()
            java.io.PrintStream r0 = java.lang.System.err
            r0.flush()
            java.io.DataOutputStream r0 = r2.output     // Catch: java.io.IOException -> L4e
            r1 = 5
            r0.writeByte(r1)     // Catch: java.io.IOException -> L4e
            java.io.DataOutputStream r0 = r2.output     // Catch: java.io.IOException -> L4e
            r0.flush()     // Catch: java.io.IOException -> L4e
            goto L57
        L4e:
            r0 = move-exception
            r0.printStackTrace()
            java.io.PrintStream r0 = java.lang.System.err
            r0.flush()
        L57:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.tika.fork.ForkServer.processRequests():void");
    }

    @Override // java.lang.Runnable
    public void run() {
        while (true) {
            try {
                synchronized (this.lock) {
                    try {
                        long currentTimeMillis = System.currentTimeMillis() - this.since;
                        boolean z3 = this.parsing;
                        if (!z3 || currentTimeMillis <= this.serverParserTimeoutMillis) {
                            if (!z3) {
                                long j2 = this.serverWaitTimeoutMillis;
                                if (j2 > 0 && currentTimeMillis > j2) {
                                }
                            }
                        }
                    } finally {
                    }
                }
                Thread.sleep(this.serverPulseMillis);
            } catch (InterruptedException unused) {
                return;
            }
        }
        System.exit(0);
    }
}
