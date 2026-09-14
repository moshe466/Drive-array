package org.apache.tika.utils;

import H0.g;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.attribute.FileAttribute;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public class ProcessUtils {
    private static final ConcurrentHashMap<String, Process> PROCESS_MAP = new ConcurrentHashMap<>();

    static {
        Runtime.getRuntime().addShutdownHook(new Thread(new com.google.firebase.crashlytics.internal.concurrency.b(3)));
    }

    public static String escapeCommandLine(String str) {
        if (str == null) {
            return str;
        }
        if (str.contains(StringUtils.SPACE) && SystemUtils.IS_OS_WINDOWS && !str.startsWith("\"") && !str.endsWith("\"")) {
            return e0.a.e("\"", str, "\"");
        }
        return str;
    }

    public static FileProcessResult execute(ProcessBuilder processBuilder, long j2, int i, int i3) {
        String str;
        Process start;
        int i4;
        boolean waitFor;
        Process process = null;
        String str2 = null;
        try {
            start = processBuilder.start();
        } catch (Throwable th) {
            th = th;
            str = null;
        }
        try {
            str2 = register(start);
            long currentTimeMillis = System.currentTimeMillis();
            StreamGobbler streamGobbler = new StreamGobbler(start.getInputStream(), i);
            StreamGobbler streamGobbler2 = new StreamGobbler(start.getErrorStream(), i3);
            Thread thread = new Thread(streamGobbler);
            thread.start();
            Thread thread2 = new Thread(streamGobbler2);
            thread2.start();
            long j3 = -1;
            boolean z3 = false;
            try {
                TimeUnit timeUnit = TimeUnit.MILLISECONDS;
                z3 = start.waitFor(j2, TimeUnit.MILLISECONDS);
                j3 = System.currentTimeMillis() - currentTimeMillis;
                if (!z3) {
                    start.destroyForcibly();
                    thread.join(1000L);
                    thread2.join(1000L);
                    waitFor = start.waitFor(500L, TimeUnit.MILLISECONDS);
                    if (waitFor) {
                        try {
                            i4 = start.exitValue();
                        } catch (IllegalThreadStateException unused) {
                        }
                    }
                    i4 = -1;
                } else {
                    i4 = start.exitValue();
                    thread.join(1000L);
                    thread2.join(1000L);
                }
                thread.interrupt();
                thread2.interrupt();
            } catch (InterruptedException unused2) {
                thread.interrupt();
                thread2.interrupt();
                i4 = -1000;
            } catch (Throwable th2) {
                thread.interrupt();
                thread2.interrupt();
                throw th2;
            }
            FileProcessResult fileProcessResult = new FileProcessResult();
            fileProcessResult.processTimeMillis = j3;
            fileProcessResult.stderrLength = streamGobbler2.getStreamLength();
            fileProcessResult.stdoutLength = streamGobbler.getStreamLength();
            fileProcessResult.isTimeout = !z3;
            fileProcessResult.exitValue = i4;
            fileProcessResult.stdout = StringUtils.joinWith("\n", streamGobbler.getLines());
            fileProcessResult.stderr = StringUtils.joinWith("\n", streamGobbler2.getLines());
            fileProcessResult.stdoutTruncated = streamGobbler.getIsTruncated();
            fileProcessResult.stderrTruncated = streamGobbler2.getIsTruncated();
            start.destroyForcibly();
            if (str2 != null) {
                release(str2);
            }
            return fileProcessResult;
        } catch (Throwable th3) {
            th = th3;
            String str3 = str2;
            process = start;
            str = str3;
            if (process != null) {
                process.destroyForcibly();
            }
            if (str != null) {
                release(str);
            }
            throw th;
        }
    }

    public static /* synthetic */ void lambda$static$0() {
        PROCESS_MAP.forEachValue(1L, new g(3));
    }

    private static String register(Process process) {
        String uuid = UUID.randomUUID().toString();
        PROCESS_MAP.put(uuid, process);
        return uuid;
    }

    private static Process release(String str) {
        return PROCESS_MAP.remove(str);
    }

    public static String unescapeCommandLine(String str) {
        if (str.contains(StringUtils.SPACE) && SystemUtils.IS_OS_WINDOWS && str.startsWith("\"") && str.endsWith("\"")) {
            return str.substring(1, str.length() - 1);
        }
        return str;
    }

    public static FileProcessResult execute(ProcessBuilder processBuilder, long j2, Path path, int i) {
        Path parent;
        boolean isDirectory;
        File file;
        String str;
        boolean z3;
        int i3;
        long size;
        Path parent2;
        parent = path.getParent();
        isDirectory = Files.isDirectory(parent, new LinkOption[0]);
        if (!isDirectory) {
            parent2 = path.getParent();
            Files.createDirectories(parent2, new FileAttribute[0]);
        }
        file = path.toFile();
        processBuilder.redirectOutput(file);
        Process process = null;
        String str2 = null;
        try {
            Process start = processBuilder.start();
            try {
                str2 = register(start);
                long currentTimeMillis = System.currentTimeMillis();
                StreamGobbler streamGobbler = new StreamGobbler(start.getErrorStream(), i);
                Thread thread = new Thread(streamGobbler);
                thread.start();
                long j3 = -1;
                try {
                    TimeUnit timeUnit = TimeUnit.MILLISECONDS;
                    z3 = start.waitFor(j2, TimeUnit.MILLISECONDS);
                    try {
                        j3 = System.currentTimeMillis() - currentTimeMillis;
                        if (!z3) {
                            start.destroyForcibly();
                            thread.join(1000L);
                            i3 = -1;
                        } else {
                            i3 = start.exitValue();
                            thread.join(1000L);
                        }
                    } catch (InterruptedException unused) {
                        i3 = -1000;
                        FileProcessResult fileProcessResult = new FileProcessResult();
                        fileProcessResult.processTimeMillis = j3;
                        fileProcessResult.stderrLength = streamGobbler.getStreamLength();
                        size = Files.size(path);
                        fileProcessResult.stdoutLength = size;
                        fileProcessResult.isTimeout = !z3;
                        fileProcessResult.exitValue = i3;
                        fileProcessResult.stdout = "";
                        fileProcessResult.stderr = StringUtils.joinWith("\n", streamGobbler.getLines());
                        fileProcessResult.stdoutTruncated = false;
                        fileProcessResult.stderrTruncated = streamGobbler.getIsTruncated();
                        start.destroyForcibly();
                        release(str2);
                        return fileProcessResult;
                    }
                } catch (InterruptedException unused2) {
                    z3 = false;
                }
                FileProcessResult fileProcessResult2 = new FileProcessResult();
                fileProcessResult2.processTimeMillis = j3;
                fileProcessResult2.stderrLength = streamGobbler.getStreamLength();
                size = Files.size(path);
                fileProcessResult2.stdoutLength = size;
                fileProcessResult2.isTimeout = !z3;
                fileProcessResult2.exitValue = i3;
                fileProcessResult2.stdout = "";
                fileProcessResult2.stderr = StringUtils.joinWith("\n", streamGobbler.getLines());
                fileProcessResult2.stdoutTruncated = false;
                fileProcessResult2.stderrTruncated = streamGobbler.getIsTruncated();
                start.destroyForcibly();
                release(str2);
                return fileProcessResult2;
            } catch (Throwable th) {
                th = th;
                String str3 = str2;
                process = start;
                str = str3;
                if (process != null) {
                    process.destroyForcibly();
                }
                release(str);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            str = null;
        }
    }
}
