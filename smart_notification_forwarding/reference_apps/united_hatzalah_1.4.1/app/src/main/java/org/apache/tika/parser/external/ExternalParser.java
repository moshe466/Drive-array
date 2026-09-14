package org.apache.tika.parser.external;

import F0.Q2;
import F0.RunnableC0064o;
import a3.c;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.nio.charset.StandardCharsets;
import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import n3.b;
import n3.d;
import org.apache.tika.io.TemporaryResources;
import org.apache.tika.io.TikaInputStream;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.mime.MediaType;
import org.apache.tika.parser.ParseContext;
import org.apache.tika.parser.Parser;
import org.apache.tika.sax.XHTMLContentHandler;
import org.apache.tika.utils.StringUtils;
import org.xml.sax.ContentHandler;

/* loaded from: classes.dex */
public class ExternalParser implements Parser {
    public static final String INPUT_FILE_TOKEN = "${INPUT}";
    private static final b LOG = d.b(ExternalParser.class);
    public static final String OUTPUT_FILE_TOKEN = "${OUTPUT}";
    private static final long serialVersionUID = -1079128990650687037L;
    private final long timeoutMs = 60000;
    private Set<MediaType> supportedTypes = Collections.EMPTY_SET;
    private Map<Pattern, String> metadataPatterns = null;
    private String[] command = {"cat"};
    private LineConsumer ignoredLineConsumer = LineConsumer.NULL;

    /* loaded from: classes.dex */
    public interface LineConsumer extends Serializable {
        public static final LineConsumer NULL = new Object();

        static /* synthetic */ void lambda$static$e2402a94$1(String str) {
        }

        void consume(String str);
    }

    public static /* synthetic */ void a(InputStream inputStream) {
        lambda$ignoreStream$0(inputStream);
    }

    public static /* synthetic */ void b(Process process, InputStream inputStream) {
        lambda$sendInput$1(process, inputStream);
    }

    public static boolean check(String str, int... iArr) {
        return check(new String[]{str}, iArr);
    }

    private void extractMetadata(InputStream inputStream, Metadata metadata) {
        Thread thread = new Thread(new K0.b(this, inputStream, metadata, 8));
        thread.start();
        try {
            thread.join();
        } catch (InterruptedException unused) {
        }
    }

    private void extractOutput(InputStream inputStream, XHTMLContentHandler xHTMLContentHandler) {
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
        try {
            xHTMLContentHandler.startDocument();
            xHTMLContentHandler.startElement("p");
            char[] cArr = new char[1024];
            while (true) {
                int read = inputStreamReader.read(cArr);
                if (read != -1) {
                    xHTMLContentHandler.characters(cArr, 0, read);
                } else {
                    xHTMLContentHandler.endElement("p");
                    xHTMLContentHandler.endDocument();
                    inputStreamReader.close();
                    return;
                }
            }
        } catch (Throwable th) {
            try {
                inputStreamReader.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    private static void ignoreStream(InputStream inputStream) {
        ignoreStream(inputStream, true);
    }

    public void lambda$extractMetadata$2(InputStream inputStream, Metadata metadata) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8));
        while (true) {
            try {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    break;
                }
                boolean z3 = false;
                for (Map.Entry<Pattern, String> entry : this.metadataPatterns.entrySet()) {
                    Matcher matcher = entry.getKey().matcher(readLine);
                    if (matcher.find()) {
                        if (entry.getValue() != null && !entry.getValue().equals("")) {
                            metadata.add(entry.getValue(), matcher.group(1));
                        } else {
                            metadata.add(matcher.group(1), matcher.group(2));
                        }
                        z3 = true;
                    }
                }
                if (!z3) {
                    this.ignoredLineConsumer.consume(readLine);
                }
            } catch (IOException unused) {
            } catch (Throwable th) {
                c.a(bufferedReader);
                c.a(inputStream);
                throw th;
            }
        }
        c.a(bufferedReader);
        c.a(inputStream);
    }

    public static void lambda$ignoreStream$0(InputStream inputStream) {
        try {
            c.b(inputStream, f3.a.f4613a);
        } catch (IOException unused) {
        } finally {
            c.a(inputStream);
        }
    }

    public static /* synthetic */ void lambda$sendInput$1(Process process, InputStream inputStream) {
        try {
            c.b(inputStream, process.getOutputStream());
        } catch (IOException unused) {
        }
    }

    private void sendInput(Process process, InputStream inputStream) {
        Thread thread = new Thread(new RunnableC0064o(18, process, inputStream));
        thread.start();
        try {
            thread.join();
        } catch (InterruptedException unused) {
        }
    }

    public String[] getCommand() {
        return this.command;
    }

    public LineConsumer getIgnoredLineConsumer() {
        return this.ignoredLineConsumer;
    }

    public Map<Pattern, String> getMetadataExtractionPatterns() {
        return this.metadataPatterns;
    }

    @Override // org.apache.tika.parser.Parser
    public Set<MediaType> getSupportedTypes(ParseContext parseContext) {
        return getSupportedTypes();
    }

    @Override // org.apache.tika.parser.Parser
    public void parse(InputStream inputStream, ContentHandler contentHandler, Metadata metadata, ParseContext parseContext) {
        XHTMLContentHandler xHTMLContentHandler = new XHTMLContentHandler(contentHandler, metadata);
        TemporaryResources temporaryResources = new TemporaryResources();
        try {
            parse(TikaInputStream.get(inputStream, temporaryResources, metadata), xHTMLContentHandler, metadata, temporaryResources);
        } finally {
            temporaryResources.dispose();
        }
    }

    public void setCommand(String... strArr) {
        this.command = strArr;
    }

    public void setIgnoredLineConsumer(LineConsumer lineConsumer) {
        this.ignoredLineConsumer = lineConsumer;
    }

    public void setMetadataExtractionPatterns(Map<Pattern, String> map) {
        this.metadataPatterns = map;
    }

    public void setSupportedTypes(Set<MediaType> set) {
        this.supportedTypes = Collections.unmodifiableSet(new HashSet(set));
    }

    /* JADX WARN: Code restructure failed: missing block: B:30:0x00bf, code lost:
    
        if (0 == 0) goto L97;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x00c2, code lost:
    
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x00a1, code lost:
    
        null.destroyForcibly();
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x009f, code lost:
    
        if (0 != 0) goto L91;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static boolean check(java.lang.String[] r8, int... r9) {
        /*
            int r0 = r9.length
            r1 = 1
            r2 = 0
            if (r0 != 0) goto Lb
            int[] r9 = new int[r1]
            r0 = 127(0x7f, float:1.78E-43)
            r9[r2] = r0
        Lb:
            r0 = 0
            java.lang.Runtime r3 = java.lang.Runtime.getRuntime()     // Catch: java.lang.Throwable -> L52 java.lang.Error -> L55 java.lang.SecurityException -> L57 java.util.concurrent.TimeoutException -> L59 java.lang.InterruptedException -> L5b java.io.IOException -> L5d
            java.lang.Process r0 = r3.exec(r8)     // Catch: java.lang.Throwable -> L52 java.lang.Error -> L55 java.lang.SecurityException -> L57 java.util.concurrent.TimeoutException -> L59 java.lang.InterruptedException -> L5b java.io.IOException -> L5d
            java.io.InputStream r3 = r0.getErrorStream()     // Catch: java.lang.Throwable -> L52 java.lang.Error -> L55 java.lang.SecurityException -> L57 java.util.concurrent.TimeoutException -> L59 java.lang.InterruptedException -> L5b java.io.IOException -> L5d
            java.lang.Thread r3 = ignoreStream(r3, r2)     // Catch: java.lang.Throwable -> L52 java.lang.Error -> L55 java.lang.SecurityException -> L57 java.util.concurrent.TimeoutException -> L59 java.lang.InterruptedException -> L5b java.io.IOException -> L5d
            java.io.InputStream r4 = r0.getInputStream()     // Catch: java.lang.Throwable -> L52 java.lang.Error -> L55 java.lang.SecurityException -> L57 java.util.concurrent.TimeoutException -> L59 java.lang.InterruptedException -> L5b java.io.IOException -> L5d
            java.lang.Thread r4 = ignoreStream(r4, r2)     // Catch: java.lang.Throwable -> L52 java.lang.Error -> L55 java.lang.SecurityException -> L57 java.util.concurrent.TimeoutException -> L59 java.lang.InterruptedException -> L5b java.io.IOException -> L5d
            r3.join()     // Catch: java.lang.Throwable -> L52 java.lang.Error -> L55 java.lang.SecurityException -> L57 java.util.concurrent.TimeoutException -> L59 java.lang.InterruptedException -> L5b java.io.IOException -> L5d
            r4.join()     // Catch: java.lang.Throwable -> L52 java.lang.Error -> L55 java.lang.SecurityException -> L57 java.util.concurrent.TimeoutException -> L59 java.lang.InterruptedException -> L5b java.io.IOException -> L5d
            java.util.concurrent.TimeUnit r3 = java.util.concurrent.TimeUnit.MILLISECONDS     // Catch: java.lang.Throwable -> L52 java.lang.Error -> L55 java.lang.SecurityException -> L57 java.util.concurrent.TimeoutException -> L59 java.lang.InterruptedException -> L5b java.io.IOException -> L5d
            boolean r3 = org.apache.tika.metadata.filter.a.s(r0)     // Catch: java.lang.Throwable -> L52 java.lang.Error -> L55 java.lang.SecurityException -> L57 java.util.concurrent.TimeoutException -> L59 java.lang.InterruptedException -> L5b java.io.IOException -> L5d
            if (r3 == 0) goto L63
            int r3 = r0.exitValue()     // Catch: java.lang.Throwable -> L52 java.lang.Error -> L55 java.lang.SecurityException -> L57 java.util.concurrent.TimeoutException -> L59 java.lang.InterruptedException -> L5b java.io.IOException -> L5d
            n3.b r4 = org.apache.tika.parser.external.ExternalParser.LOG     // Catch: java.lang.Throwable -> L52 java.lang.Error -> L55 java.lang.SecurityException -> L57 java.util.concurrent.TimeoutException -> L59 java.lang.InterruptedException -> L5b java.io.IOException -> L5d
            java.lang.String r5 = "exit value for {}: {}"
            r6 = r8[r2]     // Catch: java.lang.Throwable -> L52 java.lang.Error -> L55 java.lang.SecurityException -> L57 java.util.concurrent.TimeoutException -> L59 java.lang.InterruptedException -> L5b java.io.IOException -> L5d
            java.lang.Integer r7 = java.lang.Integer.valueOf(r3)     // Catch: java.lang.Throwable -> L52 java.lang.Error -> L55 java.lang.SecurityException -> L57 java.util.concurrent.TimeoutException -> L59 java.lang.InterruptedException -> L5b java.io.IOException -> L5d
            r4.y(r6, r5, r7)     // Catch: java.lang.Throwable -> L52 java.lang.Error -> L55 java.lang.SecurityException -> L57 java.util.concurrent.TimeoutException -> L59 java.lang.InterruptedException -> L5b java.io.IOException -> L5d
            int r4 = r9.length     // Catch: java.lang.Throwable -> L52 java.lang.Error -> L55 java.lang.SecurityException -> L57 java.util.concurrent.TimeoutException -> L59 java.lang.InterruptedException -> L5b java.io.IOException -> L5d
            r5 = r2
        L45:
            if (r5 >= r4) goto L5f
            r6 = r9[r5]     // Catch: java.lang.Throwable -> L52 java.lang.Error -> L55 java.lang.SecurityException -> L57 java.util.concurrent.TimeoutException -> L59 java.lang.InterruptedException -> L5b java.io.IOException -> L5d
            if (r3 != r6) goto L4f
            k3.a.u(r0)
            return r2
        L4f:
            int r5 = r5 + 1
            goto L45
        L52:
            r8 = move-exception
            goto Lc3
        L55:
            r9 = move-exception
            goto L69
        L57:
            r8 = move-exception
            goto La6
        L59:
            r9 = move-exception
            goto La7
        L5b:
            r9 = move-exception
            goto La7
        L5d:
            r9 = move-exception
            goto La7
        L5f:
            k3.a.u(r0)
            return r1
        L63:
            java.util.concurrent.TimeoutException r9 = new java.util.concurrent.TimeoutException     // Catch: java.lang.Throwable -> L52 java.lang.Error -> L55 java.lang.SecurityException -> L57 java.util.concurrent.TimeoutException -> L59 java.lang.InterruptedException -> L5b java.io.IOException -> L5d
            r9.<init>()     // Catch: java.lang.Throwable -> L52 java.lang.Error -> L55 java.lang.SecurityException -> L57 java.util.concurrent.TimeoutException -> L59 java.lang.InterruptedException -> L5b java.io.IOException -> L5d
            throw r9     // Catch: java.lang.Throwable -> L52 java.lang.Error -> L55 java.lang.SecurityException -> L57 java.util.concurrent.TimeoutException -> L59 java.lang.InterruptedException -> L5b java.io.IOException -> L5d
        L69:
            java.lang.String r1 = r9.getMessage()     // Catch: java.lang.Throwable -> L52
            if (r1 == 0) goto La5
            java.lang.String r1 = r9.getMessage()     // Catch: java.lang.Throwable -> L52
            java.lang.String r3 = "posix_spawn"
            boolean r1 = r1.contains(r3)     // Catch: java.lang.Throwable -> L52
            if (r1 != 0) goto L87
            java.lang.String r1 = r9.getMessage()     // Catch: java.lang.Throwable -> L52
            java.lang.String r3 = "UNIXProcess"
            boolean r1 = r1.contains(r3)     // Catch: java.lang.Throwable -> L52
            if (r1 == 0) goto La5
        L87:
            n3.b r1 = org.apache.tika.parser.external.ExternalParser.LOG     // Catch: java.lang.Throwable -> L52
            r8 = r8[r2]     // Catch: java.lang.Throwable -> L52
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L52
            r3.<init>()     // Catch: java.lang.Throwable -> L52
            java.lang.String r4 = "(TIKA-1526): exception trying to run: "
            r3.append(r4)     // Catch: java.lang.Throwable -> L52
            r3.append(r8)     // Catch: java.lang.Throwable -> L52
            java.lang.String r8 = r3.toString()     // Catch: java.lang.Throwable -> L52
            r1.s(r8, r9)     // Catch: java.lang.Throwable -> L52
            if (r0 == 0) goto Lc2
        La1:
            k3.a.u(r0)
            goto Lc2
        La5:
            throw r9     // Catch: java.lang.Throwable -> L52
        La6:
            throw r8     // Catch: java.lang.Throwable -> L52
        La7:
            n3.b r1 = org.apache.tika.parser.external.ExternalParser.LOG     // Catch: java.lang.Throwable -> L52
            r8 = r8[r2]     // Catch: java.lang.Throwable -> L52
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L52
            r3.<init>()     // Catch: java.lang.Throwable -> L52
            java.lang.String r4 = "exception trying to run  "
            r3.append(r4)     // Catch: java.lang.Throwable -> L52
            r3.append(r8)     // Catch: java.lang.Throwable -> L52
            java.lang.String r8 = r3.toString()     // Catch: java.lang.Throwable -> L52
            r1.s(r8, r9)     // Catch: java.lang.Throwable -> L52
            if (r0 == 0) goto Lc2
            goto La1
        Lc2:
            return r2
        Lc3:
            if (r0 == 0) goto Lc8
            k3.a.u(r0)
        Lc8:
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.tika.parser.external.ExternalParser.check(java.lang.String[], int[]):boolean");
    }

    private static Thread ignoreStream(InputStream inputStream, boolean z3) {
        Thread thread = new Thread(new Q2(inputStream, 15));
        thread.start();
        if (z3) {
            try {
                thread.join();
            } catch (InterruptedException unused) {
            }
        }
        return thread;
    }

    public Set<MediaType> getSupportedTypes() {
        return this.supportedTypes;
    }

    private void parse(TikaInputStream tikaInputStream, XHTMLContentHandler xHTMLContentHandler, Metadata metadata, TemporaryResources temporaryResources) {
        String[] strArr;
        Process exec;
        Map<Pattern, String> map = this.metadataPatterns;
        boolean z3 = (map == null || map.isEmpty()) ? false : true;
        String[] strArr2 = this.command;
        if (strArr2.length == 1) {
            strArr = strArr2[0].split(StringUtils.SPACE);
        } else {
            String[] strArr3 = new String[strArr2.length];
            System.arraycopy(strArr2, 0, strArr3, 0, strArr2.length);
            strArr = strArr3;
        }
        Process process = null;
        boolean z4 = true;
        boolean z5 = true;
        File file = null;
        for (int i = 0; i < strArr.length; i++) {
            if (strArr[i].contains(INPUT_FILE_TOKEN)) {
                strArr[i] = strArr[i].replace(INPUT_FILE_TOKEN, tikaInputStream.getFile().getPath());
                z4 = false;
            }
            if (strArr[i].contains(OUTPUT_FILE_TOKEN)) {
                file = temporaryResources.createTemporaryFile();
                strArr[i] = strArr[i].replace(OUTPUT_FILE_TOKEN, file.getPath());
                z5 = false;
            }
        }
        try {
            if (strArr.length == 1) {
                exec = Runtime.getRuntime().exec(strArr[0]);
            } else {
                exec = Runtime.getRuntime().exec(strArr);
            }
            process = exec;
        } catch (Exception e4) {
            LOG.p("problem with process exec", e4);
        }
        try {
            if (z4) {
                sendInput(process, tikaInputStream);
            } else {
                process.getOutputStream().close();
            }
            InputStream inputStream = process.getInputStream();
            InputStream errorStream = process.getErrorStream();
            if (z3) {
                extractMetadata(errorStream, metadata);
                if (z5) {
                    extractOutput(inputStream, xHTMLContentHandler);
                } else {
                    extractMetadata(inputStream, metadata);
                }
            } else {
                ignoreStream(errorStream);
                if (z5) {
                    extractOutput(inputStream, xHTMLContentHandler);
                } else {
                    ignoreStream(inputStream);
                }
            }
            try {
                process.waitFor();
            } catch (InterruptedException unused) {
            }
            if (z5) {
                return;
            }
            FileInputStream fileInputStream = new FileInputStream(file);
            try {
                extractOutput(fileInputStream, xHTMLContentHandler);
                fileInputStream.close();
            } catch (Throwable th) {
                try {
                    fileInputStream.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        } catch (Throwable th3) {
            try {
                process.waitFor();
            } catch (InterruptedException unused2) {
            }
            throw th3;
        }
    }
}
