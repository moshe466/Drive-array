package org.apache.tika.detect;

import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import n3.b;
import n3.d;
import org.apache.tika.config.Field;
import org.apache.tika.io.BoundedInputStream;
import org.apache.tika.io.TemporaryResources;
import org.apache.tika.io.TikaInputStream;
import org.apache.tika.metadata.ExternalProcess;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.metadata.Property;
import org.apache.tika.mime.MediaType;
import org.apache.tika.parser.external.ExternalParser;
import org.apache.tika.pipes.PipesConfigBase;
import org.apache.tika.utils.FileProcessResult;
import org.apache.tika.utils.ProcessUtils;
import org.apache.tika.utils.StringUtils;

/* loaded from: classes.dex */
public class FileCommandDetector implements Detector {
    private static final String DEFAULT_FILE_COMMAND_PATH = "file";
    private static final long DEFAULT_TIMEOUT_MS = 6000;
    public static Property FILE_MIME = Property.externalText("file:mime");
    private static final b LOGGER = d.b(FileCommandDetector.class);
    private static boolean HAS_WARNED = false;
    private Boolean hasFileCommand = null;
    private String fileCommandPath = "file";
    private int maxBytes = 1000000;
    private long timeoutMs = DEFAULT_TIMEOUT_MS;
    private boolean useMime = false;

    public static boolean checkHasFile() {
        return checkHasFile("file");
    }

    private MediaType detectOnPath(Path path, Metadata metadata) {
        Path absolutePath;
        String path2;
        String escapeCommandLine = ProcessUtils.escapeCommandLine(this.fileCommandPath);
        absolutePath = path.toAbsolutePath();
        path2 = absolutePath.toString();
        FileProcessResult execute = ProcessUtils.execute(new ProcessBuilder(escapeCommandLine, "-b", "--mime-type", ProcessUtils.escapeCommandLine(path2)), this.timeoutMs, PipesConfigBase.DEFAULT_MAX_FILES_PROCESSED_PER_PROCESS, PipesConfigBase.DEFAULT_MAX_FILES_PROCESSED_PER_PROCESS);
        if (execute.isTimeout()) {
            metadata.set(ExternalProcess.IS_TIMEOUT, true);
            return MediaType.OCTET_STREAM;
        }
        if (execute.getExitValue() != 0) {
            metadata.set(ExternalProcess.EXIT_VALUE, execute.getExitValue());
            return MediaType.OCTET_STREAM;
        }
        String stdout = execute.getStdout();
        if (StringUtils.isBlank(stdout)) {
            return MediaType.OCTET_STREAM;
        }
        metadata.set(FILE_MIME, stdout);
        if (this.useMime) {
            MediaType parse = MediaType.parse(stdout);
            if (parse == null) {
                return MediaType.OCTET_STREAM;
            }
            return parse;
        }
        return MediaType.OCTET_STREAM;
    }

    @Override // org.apache.tika.detect.Detector
    public MediaType detect(InputStream inputStream, Metadata metadata) {
        StandardCopyOption standardCopyOption;
        if (this.hasFileCommand == null) {
            this.hasFileCommand = Boolean.valueOf(checkHasFile(this.fileCommandPath));
        }
        if (!this.hasFileCommand.booleanValue()) {
            if (!HAS_WARNED) {
                LOGGER.u("'file' command isn't working: '" + this.fileCommandPath + "'");
                HAS_WARNED = true;
            }
            return MediaType.OCTET_STREAM;
        }
        TikaInputStream cast = TikaInputStream.cast(inputStream);
        if (cast != null) {
            return detectOnPath(cast.getPath(), metadata);
        }
        inputStream.mark(this.maxBytes);
        try {
            TemporaryResources temporaryResources = new TemporaryResources();
            try {
                Path createTempFile = temporaryResources.createTempFile(metadata);
                BoundedInputStream boundedInputStream = new BoundedInputStream(this.maxBytes, inputStream);
                standardCopyOption = StandardCopyOption.REPLACE_EXISTING;
                Files.copy(boundedInputStream, createTempFile, standardCopyOption);
                MediaType detectOnPath = detectOnPath(createTempFile, metadata);
                temporaryResources.close();
                return detectOnPath;
            } finally {
            }
        } finally {
            inputStream.reset();
        }
    }

    public boolean isUseMime() {
        return this.useMime;
    }

    @Field
    public void setFilePath(String str) {
        this.fileCommandPath = str;
        checkHasFile(str);
    }

    @Field
    public void setMaxBytes(int i) {
        this.maxBytes = i;
    }

    @Field
    public void setTimeoutMs(long j2) {
        this.timeoutMs = j2;
    }

    @Field
    public void setUseMime(boolean z3) {
        this.useMime = z3;
    }

    public static boolean checkHasFile(String str) {
        return ExternalParser.check(new String[]{str, "-v"}, new int[0]);
    }
}
