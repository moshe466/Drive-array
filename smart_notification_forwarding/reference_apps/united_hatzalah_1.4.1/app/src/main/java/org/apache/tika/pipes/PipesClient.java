package org.apache.tika.pipes;

import F0.AbstractC0008a;
import com.google.firebase.remoteconfig.internal.Code;
import e3.i;
import f3.c;
import java.io.Closeable;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.ProcessBuilder;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicInteger;
import n3.b;
import n3.d;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.metadata.TikaCoreProperties;
import org.apache.tika.parser.ParseContext;
import org.apache.tika.pipes.PipesResult;
import org.apache.tika.pipes.PipesServer;
import org.apache.tika.pipes.emitter.EmitData;
import org.apache.tika.pipes.emitter.EmitKey;
import org.apache.tika.utils.ProcessUtils;
import org.apache.tika.utils.StringUtils;

/* loaded from: classes.dex */
public class PipesClient implements Closeable {
    private static final int MAX_BYTES_BEFORE_READY = 20000;
    private static final long WAIT_ON_DESTROY_MS = 10000;
    private DataInputStream input;
    private DataOutputStream output;
    private final PipesConfigBase pipesConfig;
    private Process process;
    private static final b LOG = d.b(PipesClient.class);
    private static AtomicInteger CLIENT_COUNTER = new AtomicInteger(0);
    private final Object[] executorServiceLock = new Object[0];
    private volatile boolean closed = false;
    private ExecutorService executorService = Executors.newFixedThreadPool(1);
    private int filesProcessed = 0;
    private final int pipesClientId = CLIENT_COUNTER.getAndIncrement();

    /* renamed from: org.apache.tika.pipes.PipesClient$1 */
    /* loaded from: classes.dex */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$apache$tika$pipes$PipesServer$STATUS;

        static {
            int[] iArr = new int[PipesServer.STATUS.values().length];
            $SwitchMap$org$apache$tika$pipes$PipesServer$STATUS = iArr;
            try {
                iArr[PipesServer.STATUS.OOM.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$apache$tika$pipes$PipesServer$STATUS[PipesServer.STATUS.TIMEOUT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$org$apache$tika$pipes$PipesServer$STATUS[PipesServer.STATUS.EMIT_EXCEPTION.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$org$apache$tika$pipes$PipesServer$STATUS[PipesServer.STATUS.EMITTER_NOT_FOUND.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$org$apache$tika$pipes$PipesServer$STATUS[PipesServer.STATUS.FETCHER_NOT_FOUND.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$org$apache$tika$pipes$PipesServer$STATUS[PipesServer.STATUS.FETCHER_INITIALIZATION_EXCEPTION.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$org$apache$tika$pipes$PipesServer$STATUS[PipesServer.STATUS.FETCH_EXCEPTION.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$org$apache$tika$pipes$PipesServer$STATUS[PipesServer.STATUS.INTERMEDIATE_RESULT.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$org$apache$tika$pipes$PipesServer$STATUS[PipesServer.STATUS.PARSE_SUCCESS.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$org$apache$tika$pipes$PipesServer$STATUS[PipesServer.STATUS.PARSE_EXCEPTION_NO_EMIT.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                $SwitchMap$org$apache$tika$pipes$PipesServer$STATUS[PipesServer.STATUS.EMIT_SUCCESS.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                $SwitchMap$org$apache$tika$pipes$PipesServer$STATUS[PipesServer.STATUS.EMIT_SUCCESS_PARSE_EXCEPTION.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                $SwitchMap$org$apache$tika$pipes$PipesServer$STATUS[PipesServer.STATUS.EMPTY_OUTPUT.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                $SwitchMap$org$apache$tika$pipes$PipesServer$STATUS[PipesServer.STATUS.READY.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                $SwitchMap$org$apache$tika$pipes$PipesServer$STATUS[PipesServer.STATUS.CALL.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                $SwitchMap$org$apache$tika$pipes$PipesServer$STATUS[PipesServer.STATUS.PING.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                $SwitchMap$org$apache$tika$pipes$PipesServer$STATUS[PipesServer.STATUS.FAILED_TO_START.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
        }
    }

    public PipesClient(PipesConfigBase pipesConfigBase) {
        this.pipesConfig = pipesConfigBase;
    }

    private PipesResult actuallyProcess(final FetchEmitTuple fetchEmitTuple) {
        boolean isAlive;
        boolean isAlive2;
        final long currentTimeMillis = System.currentTimeMillis();
        final PipesResult[] pipesResultArr = new PipesResult[1];
        FutureTask futureTask = new FutureTask(new Callable() { // from class: org.apache.tika.pipes.a
            @Override // java.util.concurrent.Callable
            public final Object call() {
                PipesResult lambda$actuallyProcess$0;
                lambda$actuallyProcess$0 = PipesClient.this.lambda$actuallyProcess$0(fetchEmitTuple, currentTimeMillis, pipesResultArr);
                return lambda$actuallyProcess$0;
            }
        });
        try {
            try {
                try {
                    try {
                        if (!this.closed) {
                            this.executorService.execute(futureTask);
                            PipesResult pipesResult = (PipesResult) futureTask.get(this.pipesConfig.getTimeoutMillis(), TimeUnit.MILLISECONDS);
                            futureTask.cancel(true);
                            return pipesResult;
                        }
                        throw new IllegalArgumentException("pipesClientId=" + this.pipesClientId + ": PipesClient closed");
                    } catch (ExecutionException e4) {
                        b bVar = LOG;
                        bVar.e("pipesClientId=" + this.pipesClientId + ": execution exception", e4);
                        long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                        pauseThenDestroy();
                        isAlive = this.process.isAlive();
                        if (!isAlive && 17 == this.process.exitValue()) {
                            bVar.h("pipesClientId={} server timeout: {} in {} ms", Integer.valueOf(this.pipesClientId), fetchEmitTuple.getId(), Long.valueOf(currentTimeMillis2));
                            PipesResult buildFatalResult = buildFatalResult(PipesResult.TIMEOUT, pipesResultArr);
                            futureTask.cancel(true);
                            return buildFatalResult;
                        }
                        Process process = this.process;
                        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
                        process.waitFor(500L, TimeUnit.MILLISECONDS);
                        isAlive2 = this.process.isAlive();
                        if (isAlive2) {
                            bVar.h("pipesClientId={} crash: {} in {} ms with no exit code available", Integer.valueOf(this.pipesClientId), fetchEmitTuple.getId(), Long.valueOf(currentTimeMillis2));
                        } else {
                            bVar.h("pipesClientId={} crash: {} in {} ms with exit code {}", Integer.valueOf(this.pipesClientId), fetchEmitTuple.getId(), Long.valueOf(currentTimeMillis2), Integer.valueOf(this.process.exitValue()));
                        }
                        PipesResult buildFatalResult2 = buildFatalResult(PipesResult.UNSPECIFIED_CRASH, pipesResultArr);
                        futureTask.cancel(true);
                        return buildFatalResult2;
                    }
                } catch (TimeoutException unused) {
                    long currentTimeMillis3 = System.currentTimeMillis() - currentTimeMillis;
                    destroyForcibly();
                    LOG.h("pipesClientId={} client timeout: {} in {} ms", Integer.valueOf(this.pipesClientId), fetchEmitTuple.getId(), Long.valueOf(currentTimeMillis3));
                    PipesResult buildFatalResult3 = buildFatalResult(PipesResult.TIMEOUT, pipesResultArr);
                    futureTask.cancel(true);
                    return buildFatalResult3;
                }
            } catch (InterruptedException e5) {
                destroyForcibly();
                throw e5;
            }
        } catch (Throwable th) {
            futureTask.cancel(true);
            throw th;
        }
    }

    private PipesResult buildFatalResult(PipesResult pipesResult, PipesResult[] pipesResultArr) {
        if (pipesResultArr[0] == null) {
            return pipesResult;
        }
        b bVar = LOG;
        if (bVar.k()) {
            bVar.f(pipesResultArr[0].getEmitData(), "intermediate result: {}");
        }
        pipesResultArr[0].getEmitData().getMetadataList().get(0).set(TikaCoreProperties.PIPES_RESULT, pipesResult.getStatus().toString());
        return new PipesResult(pipesResult.getStatus(), pipesResultArr[0].getEmitData(), true);
    }

    /* JADX WARN: Type inference failed for: r2v2, types: [e3.h, b3.d] */
    private PipesResult deserializeEmitData() {
        byte[] bArr = new byte[this.input.readInt()];
        this.input.readFully(bArr);
        try {
            int i = i.f4469e;
            ?? dVar = new b3.d();
            dVar.M(bArr);
            ObjectInputStream objectInputStream = new ObjectInputStream(dVar.L());
            try {
                EmitData emitData = (EmitData) objectInputStream.readObject();
                String containerStackTrace = emitData.getContainerStackTrace();
                if (StringUtils.isBlank(containerStackTrace)) {
                    PipesResult pipesResult = new PipesResult(emitData);
                    objectInputStream.close();
                    return pipesResult;
                }
                PipesResult pipesResult2 = new PipesResult(emitData, containerStackTrace);
                objectInputStream.close();
                return pipesResult2;
            } catch (Throwable th) {
                try {
                    objectInputStream.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        } catch (ClassNotFoundException e4) {
            LOG.e("class not found exception deserializing data", e4);
            throw new RuntimeException(e4);
        }
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [e3.h, b3.d] */
    private PipesResult deserializeIntermediateResult(EmitKey emitKey, ParseContext parseContext) {
        byte[] bArr = new byte[this.input.readInt()];
        this.input.readFully(bArr);
        try {
            int i = i.f4469e;
            ?? dVar = new b3.d();
            dVar.M(bArr);
            ObjectInputStream objectInputStream = new ObjectInputStream(dVar.L());
            try {
                PipesResult pipesResult = new PipesResult(PipesResult.STATUS.INTERMEDIATE_RESULT, new EmitData(emitKey, Collections.singletonList((Metadata) objectInputStream.readObject())), true);
                objectInputStream.close();
                return pipesResult;
            } finally {
            }
        } catch (ClassNotFoundException e4) {
            LOG.e("class not found exception deserializing data", e4);
            throw new RuntimeException(e4);
        }
    }

    private void destroyForcibly() {
        boolean isAlive;
        this.process.destroyForcibly();
        Process process = this.process;
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        process.waitFor(10000L, TimeUnit.MILLISECONDS);
        try {
            this.input.close();
        } catch (IOException unused) {
        }
        try {
            this.output.close();
        } catch (IOException unused2) {
        }
        isAlive = this.process.isAlive();
        if (isAlive) {
            LOG.q(10000L, "Process still alive after {}ms");
        }
    }

    private String[] getCommandline() {
        Path absolutePath;
        String path;
        List<String> forkedJvmArgs = this.pipesConfig.getForkedJvmArgs();
        String str = null;
        boolean z3 = false;
        boolean z4 = false;
        boolean z5 = false;
        boolean z6 = false;
        String str2 = null;
        for (String str3 : forkedJvmArgs) {
            if (str3.startsWith("-Djava.awt.headless")) {
                z4 = true;
            }
            if (str3.equals("-cp") || str3.equals("--classpath")) {
                z3 = true;
            }
            if (str3.equals("-XX:+ExitOnOutOfMemoryError") || str3.equals("-XX:+CrashOnOutOfMemoryError")) {
                z5 = true;
            }
            if (str3.startsWith("-Dlog4j.configuration")) {
                z6 = true;
            }
            if (str3.startsWith("-Xloggc:")) {
                str2 = str3.replace("${pipesClientId}", "id-" + this.pipesClientId);
                str = str3;
            }
        }
        if (str != null && str2 != null) {
            forkedJvmArgs.remove(str);
            forkedJvmArgs.add(str2);
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(ProcessUtils.escapeCommandLine(this.pipesConfig.getJavaPath()));
        if (!z3) {
            arrayList.add("-cp");
            arrayList.add(System.getProperty("java.class.path"));
        }
        if (!z4) {
            arrayList.add("-Djava.awt.headless=true");
        }
        if (z5) {
            LOG.u("I notice that you have an exit/crash on OOM. If you run heavy external processes like tesseract, this setting may result in orphaned processes which could be disastrous for performance.");
        }
        if (!z6) {
            arrayList.add("-Dlog4j.configurationFile=classpath:pipes-fork-server-default-log4j2.xml");
        }
        arrayList.add("-DpipesClientId=" + this.pipesClientId);
        arrayList.addAll(forkedJvmArgs);
        arrayList.add("org.apache.tika.pipes.PipesServer");
        absolutePath = this.pipesConfig.getTikaConfig().toAbsolutePath();
        path = absolutePath.toString();
        arrayList.add(ProcessUtils.escapeCommandLine(path));
        arrayList.add(Long.toString(this.pipesConfig.getMaxForEmitBatchBytes()));
        arrayList.add(Long.toString(this.pipesConfig.getTimeoutMillis()));
        arrayList.add(Long.toString(this.pipesConfig.getShutdownClientAfterMillis()));
        LOG.y(Integer.valueOf(this.pipesClientId), "pipesClientId={}: commandline: {}", arrayList);
        return (String[]) arrayList.toArray(new String[0]);
    }

    private static String getMsg(String str, c cVar) {
        Charset charset = StandardCharsets.UTF_8;
        cVar.getClass();
        String str2 = new String(cVar.b(), charset);
        if (StringUtils.isBlank(str2)) {
            return str;
        }
        return str + "So far, I've read: >" + str2 + "<";
    }

    public PipesResult lambda$actuallyProcess$0(FetchEmitTuple fetchEmitTuple, long j2, PipesResult[] pipesResultArr) {
        int i = c.f4619f;
        new b3.d();
        c cVar = new c();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(cVar);
        try {
            objectOutputStream.writeObject(fetchEmitTuple);
            objectOutputStream.close();
            byte[] b4 = cVar.b();
            this.output.write(PipesServer.STATUS.CALL.getByte());
            this.output.writeInt(b4.length);
            this.output.write(b4);
            this.output.flush();
            b bVar = LOG;
            if (bVar.k()) {
                bVar.m("pipesClientId={}: timer -- write tuple: {} ms", Integer.valueOf(this.pipesClientId), Long.valueOf(System.currentTimeMillis() - j2));
            }
            long currentTimeMillis = System.currentTimeMillis();
            if (!Thread.currentThread().isInterrupted()) {
                PipesResult readResults = readResults(fetchEmitTuple, j2);
                while (readResults.getStatus().equals(PipesResult.STATUS.INTERMEDIATE_RESULT)) {
                    pipesResultArr[0] = readResults;
                    readResults = readResults(fetchEmitTuple, j2);
                }
                b bVar2 = LOG;
                if (bVar2.b()) {
                    bVar2.x(Long.valueOf(System.currentTimeMillis() - currentTimeMillis), "finished reading result in {} ms");
                }
                if (bVar2.k()) {
                    bVar2.m("pipesClientId={}: timer -- read result: {} ms", Integer.valueOf(this.pipesClientId), Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                }
                if (readResults.getStatus() == PipesResult.STATUS.OOM) {
                    return buildFatalResult(readResults, pipesResultArr);
                }
                return readResults;
            }
            throw new InterruptedException("thread interrupt");
        } catch (Throwable th) {
            try {
                objectOutputStream.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    public Integer lambda$restart$1(c cVar) {
        boolean isAlive;
        int read = this.input.read();
        int i = 1;
        while (i < MAX_BYTES_BEFORE_READY && read != PipesServer.STATUS.READY.getByte()) {
            if (read != -1) {
                cVar.write(read);
                read = this.input.read();
                i++;
            } else {
                int i3 = this.pipesClientId;
                isAlive = this.process.isAlive();
                throw new RuntimeException(getMsg("pipesClientId=" + i3 + ": Couldn't start server -- read EOF before 'ready' byte.\n process isAlive=" + isAlive, cVar));
            }
        }
        if (i < MAX_BYTES_BEFORE_READY) {
            if (cVar.f4621b > 0) {
                LOG.r(Integer.valueOf(this.pipesClientId), "pipesClientId={}: From forked process before start byte: {}", new String(cVar.b(), StandardCharsets.UTF_8));
            }
            return 1;
        }
        throw new RuntimeException(getMsg(AbstractC0008a.j(this.pipesClientId, "pipesClientId=", ": Couldn't start server: read too many bytes before 'ready' byte.\n Make absolutely certain that your logger is not writing to stdout.\n"), cVar));
    }

    private void pauseThenDestroy() {
        try {
            Process process = this.process;
            TimeUnit timeUnit = TimeUnit.MILLISECONDS;
            process.waitFor(200L, TimeUnit.MILLISECONDS);
        } finally {
            destroyForcibly();
        }
    }

    private boolean ping() {
        boolean isAlive;
        Process process = this.process;
        if (process != null) {
            isAlive = process.isAlive();
            if (isAlive) {
                try {
                    DataOutputStream dataOutputStream = this.output;
                    PipesServer.STATUS status = PipesServer.STATUS.PING;
                    dataOutputStream.write(status.getByte());
                    this.output.flush();
                    if (this.input.read() == status.getByte()) {
                        return true;
                    }
                    return false;
                } catch (IOException unused) {
                    return false;
                }
            }
            return false;
        }
        return false;
    }

    private PipesResult readMessage(PipesResult.STATUS status) {
        byte[] bArr = new byte[this.input.readInt()];
        this.input.readFully(bArr);
        return new PipesResult(status, new String(bArr, StandardCharsets.UTF_8));
    }

    private PipesResult readResults(FetchEmitTuple fetchEmitTuple, long j2) {
        String str;
        int read = this.input.read();
        long currentTimeMillis = System.currentTimeMillis() - j2;
        try {
            PipesServer.STATUS lookup = PipesServer.STATUS.lookup(read);
            switch (AnonymousClass1.$SwitchMap$org$apache$tika$pipes$PipesServer$STATUS[lookup.ordinal()]) {
                case 1:
                    LOG.h("pipesClientId={} oom: {} in {} ms", Integer.valueOf(this.pipesClientId), fetchEmitTuple.getId(), Long.valueOf(currentTimeMillis));
                    return PipesResult.OOM;
                case 2:
                    LOG.h("pipesClientId={} server response timeout: {} in {} ms", Integer.valueOf(this.pipesClientId), fetchEmitTuple.getId(), Long.valueOf(currentTimeMillis));
                    return PipesResult.TIMEOUT;
                case 3:
                    LOG.h("pipesClientId={} emit exception: {} in {} ms", Integer.valueOf(this.pipesClientId), fetchEmitTuple.getId(), Long.valueOf(currentTimeMillis));
                    return readMessage(PipesResult.STATUS.EMIT_EXCEPTION);
                case 4:
                    LOG.h("pipesClientId={} emitter not found: {} in {} ms", Integer.valueOf(this.pipesClientId), fetchEmitTuple.getId(), Long.valueOf(currentTimeMillis));
                    return readMessage(PipesResult.STATUS.NO_EMITTER_FOUND);
                case 5:
                    LOG.h("pipesClientId={} fetcher not found: {} in {} ms", Integer.valueOf(this.pipesClientId), fetchEmitTuple.getId(), Long.valueOf(currentTimeMillis));
                    return readMessage(PipesResult.STATUS.NO_FETCHER_FOUND);
                case 6:
                    LOG.h("pipesClientId={} fetcher initialization exception: {} in {} ms", Integer.valueOf(this.pipesClientId), fetchEmitTuple.getId(), Long.valueOf(currentTimeMillis));
                    return readMessage(PipesResult.STATUS.FETCHER_INITIALIZATION_EXCEPTION);
                case 7:
                    LOG.h("pipesClientId={} fetch exception: {} in {} ms", Integer.valueOf(this.pipesClientId), fetchEmitTuple.getId(), Long.valueOf(currentTimeMillis));
                    return readMessage(PipesResult.STATUS.FETCH_EXCEPTION);
                case 8:
                    LOG.n("pipesClientId={} intermediate success: {} in {} ms", Integer.valueOf(this.pipesClientId), fetchEmitTuple.getId(), Long.valueOf(currentTimeMillis));
                    return deserializeIntermediateResult(fetchEmitTuple.getEmitKey(), fetchEmitTuple.getParseContext());
                case 9:
                    LOG.n("pipesClientId={} parse success: {} in {} ms", Integer.valueOf(this.pipesClientId), fetchEmitTuple.getId(), Long.valueOf(currentTimeMillis));
                    return deserializeEmitData();
                case 10:
                    return readMessage(PipesResult.STATUS.PARSE_EXCEPTION_NO_EMIT);
                case 11:
                    LOG.n("pipesClientId={} emit success: {} in {} ms", Integer.valueOf(this.pipesClientId), fetchEmitTuple.getId(), Long.valueOf(currentTimeMillis));
                    return PipesResult.EMIT_SUCCESS;
                case Code.UNIMPLEMENTED /* 12 */:
                    return readMessage(PipesResult.STATUS.EMIT_SUCCESS_PARSE_EXCEPTION);
                case 13:
                    return PipesResult.EMPTY_OUTPUT;
                case 14:
                case 15:
                case 16:
                case 17:
                    throw new IOException("Not expecting this status: " + lookup);
                default:
                    throw new IOException("Need to handle procesing for: " + lookup);
            }
        } catch (IllegalArgumentException e4) {
            if (read > -1) {
                str = String.format(Locale.US, "%02x", Byte.valueOf((byte) read));
            } else {
                str = "-1";
            }
            throw new IOException("problem reading response from server: ".concat(str), e4);
        }
    }

    private void restart() {
        boolean waitFor;
        ProcessBuilder.Redirect unused;
        if (this.process != null) {
            b bVar = LOG;
            bVar.j("process still alive; trying to destroy it");
            destroyForcibly();
            Process process = this.process;
            TimeUnit timeUnit = TimeUnit.SECONDS;
            waitFor = process.waitFor(30L, TimeUnit.SECONDS);
            if (!waitFor) {
                bVar.l("pipesClientId={}: process has not yet ended", Integer.valueOf(this.pipesClientId));
            }
            this.executorService.shutdownNow();
            if (!this.executorService.awaitTermination(30L, timeUnit)) {
                bVar.l("pipesClientId={}: executorService has not yet shutdown", Integer.valueOf(this.pipesClientId));
            }
            synchronized (this.executorServiceLock) {
                if (!this.closed) {
                    this.executorService = Executors.newFixedThreadPool(1);
                } else {
                    throw new IllegalArgumentException("pipesClientId=" + this.pipesClientId + ": PipesClient closed");
                }
            }
            bVar.z("pipesClientId={}: restarting process", Integer.valueOf(this.pipesClientId));
        } else {
            LOG.z("pipesClientId={}: starting process", Integer.valueOf(this.pipesClientId));
        }
        ProcessBuilder processBuilder = new ProcessBuilder(getCommandline());
        unused = ProcessBuilder.Redirect.INHERIT;
        processBuilder.redirectError(ProcessBuilder.Redirect.INHERIT);
        try {
            this.process = processBuilder.start();
            this.input = new DataInputStream(this.process.getInputStream());
            this.output = new DataOutputStream(this.process.getOutputStream());
            int i = c.f4619f;
            new b3.d();
            c cVar = new c();
            FutureTask futureTask = new FutureTask(new com.google.firebase.remoteconfig.b(4, this, cVar));
            long currentTimeMillis = System.currentTimeMillis();
            this.executorService.submit(futureTask);
            try {
                try {
                    try {
                        futureTask.get(this.pipesConfig.getStartupTimeoutMillis(), TimeUnit.MILLISECONDS);
                    } finally {
                        futureTask.cancel(true);
                    }
                } catch (InterruptedException e4) {
                    destroyForcibly();
                    throw e4;
                }
            } catch (ExecutionException e5) {
                LOG.e("pipesClientId=" + this.pipesClientId + ": couldn't start server", e5);
                destroyForcibly();
                throw new RuntimeException(e5);
            } catch (TimeoutException e6) {
                LOG.o(Integer.valueOf(this.pipesClientId), Long.valueOf(this.pipesConfig.getStartupTimeoutMillis()), Long.valueOf(System.currentTimeMillis() - currentTimeMillis), new String(cVar.b(), StandardCharsets.UTF_8));
                destroyForcibly();
                throw e6;
            }
        } catch (Exception e7) {
            LOG.e("failed to start client", e7);
            throw new FailedToStartClientException(e7);
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (this.process != null) {
            try {
                destroyForcibly();
            } catch (InterruptedException unused) {
            }
        }
        synchronized (this.executorServiceLock) {
            try {
                ExecutorService executorService = this.executorService;
                if (executorService != null) {
                    executorService.shutdownNow();
                }
                this.closed = true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public int getFilesProcessed() {
        return this.filesProcessed;
    }

    public PipesResult process(FetchEmitTuple fetchEmitTuple) {
        if (ping()) {
            if (this.pipesConfig.getMaxFilesProcessedPerProcess() > 0 && this.filesProcessed >= this.pipesConfig.getMaxFilesProcessedPerProcess()) {
                LOG.A("pipesClientId={}: restarting server after hitting max files: {}", Integer.valueOf(this.pipesClientId), Integer.valueOf(this.filesProcessed));
            }
            return actuallyProcess(fetchEmitTuple);
        }
        boolean z3 = false;
        while (!z3) {
            try {
                restart();
                z3 = true;
            } catch (TimeoutException unused) {
                LOG.r(Integer.valueOf(this.pipesClientId), "pipesClientId={}: couldn't restart within {} ms (startupTimeoutMillis)", Long.valueOf(this.pipesConfig.getStartupTimeoutMillis()));
                Thread.sleep(this.pipesConfig.getSleepOnStartupTimeoutMillis());
            }
        }
        return actuallyProcess(fetchEmitTuple);
    }
}
