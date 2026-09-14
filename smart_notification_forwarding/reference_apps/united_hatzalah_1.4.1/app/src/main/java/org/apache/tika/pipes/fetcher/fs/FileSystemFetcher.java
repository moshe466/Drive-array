package org.apache.tika.pipes.fetcher.fs;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;
import java.util.Date;
import java.util.Map;
import k3.a;
import n3.b;
import n3.d;
import org.apache.tika.config.Field;
import org.apache.tika.config.Initializable;
import org.apache.tika.config.InitializableProblemHandler;
import org.apache.tika.config.Param;
import org.apache.tika.exception.TikaConfigException;
import org.apache.tika.io.TikaInputStream;
import org.apache.tika.metadata.FileSystem;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.metadata.Property;
import org.apache.tika.metadata.TikaCoreProperties;
import org.apache.tika.parser.ParseContext;
import org.apache.tika.pipes.fetcher.AbstractFetcher;
import org.apache.tika.pipes.fetcher.fs.config.FileSystemFetcherConfig;

/* loaded from: classes.dex */
public class FileSystemFetcher extends AbstractFetcher implements Initializable {
    private static final b LOG = d.b(FileSystemFetcher.class);
    private Path basePath = null;
    private boolean extractFileSystemMetadata = false;

    public FileSystemFetcher() {
    }

    public static boolean isDescendant(Path path, Path path2) {
        Path absolutePath;
        Path normalize;
        Path absolutePath2;
        Path normalize2;
        boolean startsWith;
        absolutePath = path2.toAbsolutePath();
        normalize = absolutePath.normalize();
        absolutePath2 = path.toAbsolutePath();
        normalize2 = absolutePath2.normalize();
        startsWith = normalize.startsWith(normalize2);
        return startsWith;
    }

    private void updateFileSystemMetadata(Path path, Metadata metadata) {
        BasicFileAttributes readAttributes;
        FileTime creationTime;
        FileTime lastModifiedTime;
        FileTime lastAccessTime;
        if (this.extractFileSystemMetadata) {
            readAttributes = Files.readAttributes(path, (Class<BasicFileAttributes>) a.g(), new LinkOption[0]);
            Property property = FileSystem.CREATED;
            creationTime = readAttributes.creationTime();
            updateFileTime(property, creationTime, metadata);
            Property property2 = FileSystem.MODIFIED;
            lastModifiedTime = readAttributes.lastModifiedTime();
            updateFileTime(property2, lastModifiedTime, metadata);
            Property property3 = FileSystem.ACCESSED;
            lastAccessTime = readAttributes.lastAccessTime();
            updateFileTime(property3, lastAccessTime, metadata);
        }
    }

    private void updateFileTime(Property property, FileTime fileTime, Metadata metadata) {
        long millis;
        if (fileTime != null) {
            millis = fileTime.toMillis();
            metadata.set(property, new Date(millis));
        }
    }

    @Override // org.apache.tika.config.Initializable
    public void checkInitialization(InitializableProblemHandler initializableProblemHandler) {
        String path;
        String path2;
        String path3;
        String path4;
        Path absolutePath;
        String path5;
        Path path6 = this.basePath;
        if (path6 != null) {
            path = path6.toString();
            int length = path.length();
            int i = 0;
            while (i < length) {
                int codePointAt = path.codePointAt(i);
                if (!Character.isWhitespace(codePointAt)) {
                    path2 = this.basePath.toString();
                    if (!path2.startsWith("http://")) {
                        path3 = this.basePath.toString();
                        if (!path3.startsWith("ftp://")) {
                            path4 = this.basePath.toString();
                            if (!path4.startsWith("s3://")) {
                                absolutePath = this.basePath.toAbsolutePath();
                                path5 = absolutePath.toString();
                                if (!path5.contains("\u0000")) {
                                    return;
                                } else {
                                    throw new TikaConfigException("base path must not contain \u0000. Seriously, what were you thinking?");
                                }
                            }
                            throw new TikaConfigException("FileSystemFetcher only works with local file systems.  Please use the tika-fetcher-s3 module");
                        }
                        throw new TikaConfigException("FileSystemFetcher only works with local file systems.  Please consider contributing an ftp fetcher module");
                    }
                    throw new TikaConfigException("FileSystemFetcher only works with local file systems.  Please use the tika-fetcher-http module for http calls");
                }
                i += Character.charCount(codePointAt);
            }
        }
        LOG.u("'basePath' has not been set. This means that client code or clients can read from any file that this process has permissions to read. If you are running tika-server, make absolutely certain that you've locked down access to tika-server and file-permissions for the tika-server process.");
    }

    @Override // org.apache.tika.pipes.fetcher.Fetcher
    public InputStream fetch(String str, Metadata metadata, ParseContext parseContext) {
        Path path;
        boolean isRegularFile;
        Path absolutePath;
        String path2;
        boolean isDirectory;
        Path realPath;
        Path realPath2;
        boolean startsWith;
        if (!str.contains("\u0000")) {
            Path path3 = this.basePath;
            if (path3 != null) {
                path = path3.resolve(str);
                realPath = path.toRealPath(new LinkOption[0]);
                realPath2 = this.basePath.toRealPath(new LinkOption[0]);
                startsWith = realPath.startsWith(realPath2);
                if (!startsWith) {
                    throw new IllegalArgumentException("fetchKey must resolve to be a descendant of the 'basePath'");
                }
            } else {
                path = Paths.get(str, new String[0]);
            }
            metadata.set(TikaCoreProperties.SOURCE_PATH, str);
            updateFileSystemMetadata(path, metadata);
            isRegularFile = Files.isRegularFile(path, new LinkOption[0]);
            if (!isRegularFile) {
                Path path4 = this.basePath;
                if (path4 != null) {
                    isDirectory = Files.isDirectory(path4, new LinkOption[0]);
                    if (!isDirectory) {
                        throw new IOException("BasePath is not a directory: " + this.basePath);
                    }
                }
                absolutePath = path.toAbsolutePath();
                path2 = absolutePath.toString();
                throw new FileNotFoundException(path2);
            }
            return TikaInputStream.get(path, metadata);
        }
        throw new IllegalArgumentException("Path must not contain 'u0000'. Please review the life decisions that led you to requesting a file name with this character in it.");
    }

    public Path getBasePath() {
        return this.basePath;
    }

    @Override // org.apache.tika.config.Initializable
    public void initialize(Map<String, Param> map) {
    }

    @Field
    public void setBasePath(String str) {
        Path path;
        path = Paths.get(str, new String[0]);
        this.basePath = path;
    }

    @Field
    public void setExtractFileSystemMetadata(boolean z3) {
        this.extractFileSystemMetadata = z3;
    }

    public FileSystemFetcher(FileSystemFetcherConfig fileSystemFetcherConfig) {
        setBasePath(fileSystemFetcherConfig.getBasePath());
        setExtractFileSystemMetadata(fileSystemFetcherConfig.isExtractFileSystemMetadata());
    }
}
