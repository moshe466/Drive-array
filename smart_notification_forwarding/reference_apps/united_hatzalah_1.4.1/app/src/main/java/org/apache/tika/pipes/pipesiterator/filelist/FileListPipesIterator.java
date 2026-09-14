package org.apache.tika.pipes.pipesiterator.filelist;

import e0.a;
import java.io.BufferedReader;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import org.apache.tika.config.Field;
import org.apache.tika.config.Initializable;
import org.apache.tika.config.InitializableProblemHandler;
import org.apache.tika.config.TikaConfig;
import org.apache.tika.exception.TikaConfigException;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.parser.ParseContext;
import org.apache.tika.pipes.FetchEmitTuple;
import org.apache.tika.pipes.HandlerConfig;
import org.apache.tika.pipes.emitter.EmitKey;
import org.apache.tika.pipes.fetcher.FetchKey;
import org.apache.tika.pipes.pipesiterator.PipesIterator;
import org.apache.tika.utils.StringUtils;

/* loaded from: classes.dex */
public class FileListPipesIterator extends PipesIterator implements Initializable {

    @Field
    private String fileList;
    private Path fileListPath;

    @Field
    private boolean hasHeader = false;

    @Override // org.apache.tika.pipes.pipesiterator.PipesIterator, org.apache.tika.config.Initializable
    public void checkInitialization(InitializableProblemHandler initializableProblemHandler) {
        Path path;
        boolean isRegularFile;
        TikaConfig.mustNotBeEmpty("fileList", this.fileList);
        TikaConfig.mustNotBeEmpty("fetcherName", getFetcherName());
        TikaConfig.mustNotBeEmpty("emitterName", getFetcherName());
        path = Paths.get(this.fileList, new String[0]);
        this.fileListPath = path;
        isRegularFile = Files.isRegularFile(path, new LinkOption[0]);
        if (isRegularFile) {
        } else {
            throw new TikaConfigException(a.e("file list ", this.fileList, " does not exist. Must specify an existing file"));
        }
    }

    @Override // org.apache.tika.pipes.pipesiterator.PipesIterator
    public void enqueue() {
        BufferedReader newBufferedReader;
        Path path = this.fileListPath;
        Charset charset = StandardCharsets.UTF_8;
        newBufferedReader = Files.newBufferedReader(path, StandardCharsets.UTF_8);
        try {
            if (this.hasHeader) {
                newBufferedReader.readLine();
            }
            for (String readLine = newBufferedReader.readLine(); readLine != null; readLine = newBufferedReader.readLine()) {
                if (!readLine.startsWith("#") && !StringUtils.isBlank(readLine)) {
                    FetchKey fetchKey = new FetchKey(getFetcherName(), readLine);
                    EmitKey emitKey = new EmitKey(getEmitterName(), readLine);
                    ParseContext parseContext = new ParseContext();
                    parseContext.set(HandlerConfig.class, getHandlerConfig());
                    tryToAdd(new FetchEmitTuple(readLine, fetchKey, emitKey, new Metadata(), parseContext, getOnParseException()));
                }
            }
            newBufferedReader.close();
        } catch (Throwable th) {
            if (newBufferedReader != null) {
                try {
                    newBufferedReader.close();
                    throw th;
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                    throw th;
                }
            }
            throw th;
        }
    }

    @Field
    public void setFileList(String str) {
        this.fileList = str;
    }

    @Field
    public void setHasHeader(boolean z3) {
        this.hasHeader = z3;
    }
}
