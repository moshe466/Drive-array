package org.apache.tika.io;

import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.FileAttribute;
import java.util.Iterator;
import java.util.LinkedList;
import n3.b;
import n3.d;
import org.apache.tika.exception.TikaException;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.metadata.TikaCoreProperties;
import org.apache.tika.utils.StringUtils;

/* loaded from: classes.dex */
public class TemporaryResources implements Closeable {
    private static final b LOG = d.b(TemporaryResources.class);
    private final LinkedList<Closeable> resources = new LinkedList<>();
    private Path tempFileDir = null;

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$createTempFile$0(Path path) {
        File file;
        try {
            Files.delete(path);
        } catch (IOException unused) {
            LOG.u("delete tmp file fail, will delete it on exit");
            file = path.toFile();
            file.deleteOnExit();
        }
    }

    public void addResource(Closeable closeable) {
        this.resources.addFirst(closeable);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        Iterator<Closeable> it = this.resources.iterator();
        IOException iOException = null;
        while (it.hasNext()) {
            try {
                it.next().close();
            } catch (IOException e4) {
                if (iOException == null) {
                    iOException = e4;
                } else {
                    iOException.addSuppressed(e4);
                }
            }
        }
        this.resources.clear();
        if (iOException == null) {
        } else {
            throw iOException;
        }
    }

    public Path createTempFile(String str) {
        if (StringUtils.isBlank(str)) {
            str = ".tmp";
        }
        Path path = this.tempFileDir;
        final Path createTempFile = path == null ? Files.createTempFile("apache-tika-", str, new FileAttribute[0]) : Files.createTempFile(path, "apache-tika-", str, new FileAttribute[0]);
        addResource(new Closeable() { // from class: org.apache.tika.io.a
            @Override // java.io.Closeable, java.lang.AutoCloseable
            public final void close() {
                TemporaryResources.lambda$createTempFile$0(createTempFile);
            }
        });
        return createTempFile;
    }

    public File createTemporaryFile() {
        File file;
        file = createTempFile("").toFile();
        return file;
    }

    public void dispose() {
        try {
            close();
        } catch (IOException e4) {
            throw new TikaException("Failed to close temporary resources", e4);
        }
    }

    public <T extends Closeable> T getResource(Class<T> cls) {
        Iterator<Closeable> it = this.resources.iterator();
        while (it.hasNext()) {
            T t3 = (T) it.next();
            if (cls.isAssignableFrom(t3.getClass())) {
                return t3;
            }
        }
        return null;
    }

    public void setTemporaryFileDirectory(Path path) {
        this.tempFileDir = path;
    }

    public void setTemporaryFileDirectory(File file) {
        this.tempFileDir = file == null ? null : file.toPath();
    }

    public Path createTempFile() {
        return createTempFile("");
    }

    public Path createTempFile(Metadata metadata) {
        String str = metadata.get(TikaCoreProperties.RESOURCE_NAME_KEY);
        if (StringUtils.isBlank(str)) {
            return createTempFile("");
        }
        return createTempFile(FilenameUtils.getSuffixFromPath(str));
    }
}
