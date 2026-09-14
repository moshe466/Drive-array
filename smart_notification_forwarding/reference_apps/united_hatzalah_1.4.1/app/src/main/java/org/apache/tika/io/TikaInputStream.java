package org.apache.tika.io;

import e3.e;
import e3.i;
import io.flutter.plugins.firebase.crashlytics.Constants;
import java.io.BufferedInputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.sql.Blob;
import java.sql.SQLException;
import org.apache.tika.metadata.HttpHeaders;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.metadata.TikaCoreProperties;
import org.apache.tika.utils.StringUtils;

/* loaded from: classes.dex */
public class TikaInputStream extends e {
    private static final int BLOB_SIZE_THRESHOLD = 1048576;
    private static final int MAX_CONSECUTIVE_EOFS = 1000;
    private int consecutiveEOFs;
    private long length;
    private long mark;
    private Object openContainer;
    private Path path;
    private long position;
    private byte[] skipBuffer;
    private InputStreamFactory streamFactory;
    private String suffix;
    private final TemporaryResources tmp;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private TikaInputStream(java.nio.file.Path r5) {
        /*
            r4 = this;
            java.io.BufferedInputStream r0 = new java.io.BufferedInputStream
            r1 = 0
            java.nio.file.OpenOption[] r2 = new java.nio.file.OpenOption[r1]
            java.io.InputStream r2 = k3.a.f(r5, r2)
            r0.<init>(r2)
            r4.<init>(r0)
            r2 = 0
            r4.position = r2
            r2 = -1
            r4.mark = r2
            r4.consecutiveEOFs = r1
            r0 = 0
            r4.suffix = r0
            r4.path = r5
            org.apache.tika.io.TemporaryResources r0 = new org.apache.tika.io.TemporaryResources
            r0.<init>()
            r4.tmp = r0
            long r0 = k3.a.a(r5)
            r4.length = r0
            java.nio.file.Path r5 = k3.a.A(r5)
            java.lang.String r5 = k3.a.i(r5)
            java.lang.String r5 = org.apache.tika.io.FilenameUtils.getSuffixFromPath(r5)
            r4.suffix = r5
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.tika.io.TikaInputStream.<init>(java.nio.file.Path):void");
    }

    public static TikaInputStream cast(InputStream inputStream) {
        if (inputStream instanceof TikaInputStream) {
            return (TikaInputStream) inputStream;
        }
        return null;
    }

    public static TikaInputStream get(InputStream inputStream, TemporaryResources temporaryResources, Metadata metadata) {
        if (inputStream != null) {
            if (inputStream instanceof TikaInputStream) {
                return (TikaInputStream) inputStream;
            }
            return new TikaInputStream(!inputStream.markSupported() ? new BufferedInputStream(inputStream) : inputStream, temporaryResources, -1L, getExtension(metadata));
        }
        throw new NullPointerException("The Stream must not be null");
    }

    private static String getExtension(Metadata metadata) {
        if (metadata == null) {
            return "";
        }
        return FilenameUtils.getSuffixFromPath(metadata.get(TikaCoreProperties.RESOURCE_NAME_KEY));
    }

    public static boolean isTikaInputStream(InputStream inputStream) {
        return inputStream instanceof TikaInputStream;
    }

    public void addCloseableResource(Closeable closeable) {
        this.tmp.addResource(closeable);
    }

    @Override // e3.d
    public void afterRead(int i) {
        if (i != -1) {
            this.position += i;
            return;
        }
        int i3 = this.consecutiveEOFs + 1;
        this.consecutiveEOFs = i3;
        if (i3 <= 1000) {
        } else {
            throw new IOException("Read too many -1 (EOFs); there could be an infinite loop.If you think your file is not corrupt, please open an issue on Tika's JIRA");
        }
    }

    @Override // java.io.FilterInputStream, java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.path = null;
        this.mark = -1L;
        this.tmp.addResource(((FilterInputStream) this).in);
        this.tmp.close();
    }

    public File getFile() {
        File file;
        file = getPath().toFile();
        return file;
    }

    public FileChannel getFileChannel() {
        FileChannel open;
        open = FileChannel.open(getPath(), new OpenOption[0]);
        this.tmp.addResource(open);
        return open;
    }

    public InputStreamFactory getInputStreamFactory() {
        return this.streamFactory;
    }

    public long getLength() {
        if (this.length == -1) {
            getPath();
        }
        return this.length;
    }

    public Object getOpenContainer() {
        return this.openContainer;
    }

    public Path getPath() {
        return getPath(-1);
    }

    public long getPosition() {
        return this.position;
    }

    public boolean hasFile() {
        if (this.path != null) {
            return true;
        }
        return false;
    }

    public boolean hasInputStreamFactory() {
        if (this.streamFactory != null) {
            return true;
        }
        return false;
    }

    public boolean hasLength() {
        if (this.length != -1) {
            return true;
        }
        return false;
    }

    @Override // e3.d, java.io.FilterInputStream, java.io.InputStream
    public void mark(int i) {
        super.mark(i);
        this.mark = this.position;
    }

    @Override // e3.d, java.io.FilterInputStream, java.io.InputStream
    public boolean markSupported() {
        return true;
    }

    public int peek(byte[] bArr) {
        mark(bArr.length);
        int read = read(bArr);
        int i = 0;
        while (read != -1) {
            i += read;
            if (i < bArr.length) {
                read = read(bArr, i, bArr.length - i);
            } else {
                read = -1;
            }
        }
        reset();
        return i;
    }

    @Override // e3.d, java.io.FilterInputStream, java.io.InputStream
    public void reset() {
        super.reset();
        this.position = this.mark;
        this.mark = -1L;
        this.consecutiveEOFs = 0;
    }

    public void setOpenContainer(Object obj) {
        this.openContainer = obj;
        if (obj instanceof Closeable) {
            this.tmp.addResource((Closeable) obj);
        }
    }

    @Override // e3.d, java.io.FilterInputStream, java.io.InputStream
    public long skip(long j2) {
        if (this.skipBuffer == null) {
            this.skipBuffer = new byte[4096];
        }
        long skip = IOUtils.skip(((FilterInputStream) this).in, j2, this.skipBuffer);
        this.position += skip;
        return skip;
    }

    public String toString() {
        String d2;
        String path;
        if (hasFile()) {
            path = this.path.toString();
            d2 = e0.a.d("TikaInputStream of ", path);
        } else {
            d2 = e0.a.d("TikaInputStream of ", ((FilterInputStream) this).in.toString());
        }
        Object obj = this.openContainer;
        if (obj != null) {
            return d2 + " (in " + obj + ")";
        }
        return d2;
    }

    public Path getPath(int i) {
        StandardCopyOption standardCopyOption;
        InputStream newInputStream;
        long size;
        StandardCopyOption standardCopyOption2;
        Path path = this.path;
        if (path != null) {
            return path;
        }
        if (this.position <= 0) {
            Path createTempFile = this.tmp.createTempFile(this.suffix);
            if (i <= -1) {
                standardCopyOption = StandardCopyOption.REPLACE_EXISTING;
                Files.copy(this, createTempFile, standardCopyOption);
            } else {
                BoundedInputStream boundedInputStream = new BoundedInputStream(i, this);
                try {
                    boundedInputStream.mark(i);
                    try {
                        standardCopyOption2 = StandardCopyOption.REPLACE_EXISTING;
                        Files.copy(boundedInputStream, createTempFile, standardCopyOption2);
                        if (boundedInputStream.hasHitBound()) {
                            boundedInputStream.close();
                            return null;
                        }
                        boundedInputStream.close();
                    } finally {
                        boundedInputStream.reset();
                    }
                } catch (Throwable th) {
                    try {
                        boundedInputStream.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                    throw th;
                }
            }
            this.path = createTempFile;
            newInputStream = Files.newInputStream(createTempFile, new OpenOption[0]);
            this.tmp.addResource(newInputStream);
            final InputStream inputStream = ((FilterInputStream) this).in;
            ((FilterInputStream) this).in = new BufferedInputStream(newInputStream) { // from class: org.apache.tika.io.TikaInputStream.1
                @Override // java.io.BufferedInputStream, java.io.FilterInputStream, java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
                public void close() {
                    inputStream.close();
                }
            };
            size = Files.size(this.path);
            this.length = size;
            this.position = 0L;
            this.mark = -1L;
            return this.path;
        }
        throw new IOException("Stream is already being read");
    }

    public static TikaInputStream get(InputStream inputStream) {
        return get(inputStream, new TemporaryResources(), (Metadata) null);
    }

    public static TikaInputStream get(byte[] bArr) {
        return get(bArr, new Metadata());
    }

    public static TikaInputStream get(byte[] bArr, Metadata metadata) {
        metadata.set(HttpHeaders.CONTENT_LENGTH, Integer.toString(bArr.length));
        return new TikaInputStream(new i(bArr), new TemporaryResources(), bArr.length, getExtension(metadata));
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private TikaInputStream(java.nio.file.Path r5, org.apache.tika.io.TemporaryResources r6, long r7) {
        /*
            r4 = this;
            java.io.BufferedInputStream r0 = new java.io.BufferedInputStream
            r1 = 0
            java.nio.file.OpenOption[] r2 = new java.nio.file.OpenOption[r1]
            java.io.InputStream r2 = k3.a.f(r5, r2)
            r0.<init>(r2)
            r4.<init>(r0)
            r2 = 0
            r4.position = r2
            r2 = -1
            r4.mark = r2
            r4.consecutiveEOFs = r1
            r0 = 0
            r4.suffix = r0
            r4.path = r5
            r4.tmp = r6
            r4.length = r7
            java.nio.file.Path r5 = k3.a.A(r5)
            java.lang.String r5 = k3.a.i(r5)
            java.lang.String r5 = org.apache.tika.io.FilenameUtils.getSuffixFromPath(r5)
            r4.suffix = r5
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.tika.io.TikaInputStream.<init>(java.nio.file.Path, org.apache.tika.io.TemporaryResources, long):void");
    }

    public static TikaInputStream get(Path path) {
        return get(path, new Metadata());
    }

    public static TikaInputStream get(Path path, Metadata metadata) {
        long size;
        Path fileName;
        String path2;
        if (StringUtils.isBlank(metadata.get(TikaCoreProperties.RESOURCE_NAME_KEY))) {
            fileName = path.getFileName();
            path2 = fileName.toString();
            metadata.set(TikaCoreProperties.RESOURCE_NAME_KEY, path2);
        }
        size = Files.size(path);
        metadata.set(HttpHeaders.CONTENT_LENGTH, Long.toString(size));
        return new TikaInputStream(path);
    }

    public static TikaInputStream get(Path path, Metadata metadata, TemporaryResources temporaryResources) {
        long size;
        Path fileName;
        String path2;
        size = Files.size(path);
        if (StringUtils.isBlank(metadata.get(TikaCoreProperties.RESOURCE_NAME_KEY))) {
            fileName = path.getFileName();
            path2 = fileName.toString();
            metadata.set(TikaCoreProperties.RESOURCE_NAME_KEY, path2);
        }
        metadata.set(HttpHeaders.CONTENT_LENGTH, Long.toString(size));
        return new TikaInputStream(path, temporaryResources, size);
    }

    @Deprecated
    private TikaInputStream(File file) {
        super(new BufferedInputStream(new FileInputStream(file)));
        Path path;
        Path fileName;
        String path2;
        this.position = 0L;
        this.mark = -1L;
        this.consecutiveEOFs = 0;
        this.suffix = null;
        path = file.toPath();
        this.path = path;
        this.tmp = new TemporaryResources();
        this.length = file.length();
        fileName = this.path.getFileName();
        path2 = fileName.toString();
        this.suffix = FilenameUtils.getSuffixFromPath(path2);
    }

    @Deprecated
    public static TikaInputStream get(File file) {
        return get(file, new Metadata());
    }

    @Deprecated
    public static TikaInputStream get(File file, Metadata metadata) {
        if (StringUtils.isBlank(metadata.get(TikaCoreProperties.RESOURCE_NAME_KEY))) {
            metadata.set(TikaCoreProperties.RESOURCE_NAME_KEY, file.getName());
        }
        metadata.set(HttpHeaders.CONTENT_LENGTH, Long.toString(file.length()));
        return new TikaInputStream(file);
    }

    public static TikaInputStream get(InputStreamFactory inputStreamFactory) {
        return get(inputStreamFactory, new TemporaryResources());
    }

    private TikaInputStream(InputStream inputStream, TemporaryResources temporaryResources, long j2, String str) {
        super(inputStream);
        this.position = 0L;
        this.mark = -1L;
        this.consecutiveEOFs = 0;
        this.path = null;
        this.tmp = temporaryResources;
        this.length = j2;
        this.suffix = str;
    }

    public static TikaInputStream get(InputStreamFactory inputStreamFactory, TemporaryResources temporaryResources) {
        TikaInputStream tikaInputStream = get(inputStreamFactory.getInputStream(), temporaryResources, (Metadata) null);
        tikaInputStream.streamFactory = inputStreamFactory;
        return tikaInputStream;
    }

    public static TikaInputStream get(Blob blob) {
        return get(blob, new Metadata());
    }

    public static TikaInputStream get(Blob blob, Metadata metadata) {
        long j2;
        try {
            j2 = blob.length();
            try {
                metadata.set(HttpHeaders.CONTENT_LENGTH, Long.toString(j2));
            } catch (SQLException unused) {
            }
        } catch (SQLException unused2) {
            j2 = -1;
        }
        long j3 = j2;
        if (0 <= j3 && j3 <= 1048576) {
            return get(blob.getBytes(1L, (int) j3), metadata);
        }
        return new TikaInputStream(new BufferedInputStream(blob.getBinaryStream()), new TemporaryResources(), j3, getExtension(metadata));
    }

    public static TikaInputStream get(URI uri) {
        return get(uri, new Metadata());
    }

    public static TikaInputStream get(URI uri, Metadata metadata) {
        Path path;
        boolean isRegularFile;
        if (Constants.FILE.equalsIgnoreCase(uri.getScheme())) {
            path = Paths.get(uri);
            isRegularFile = Files.isRegularFile(path, new LinkOption[0]);
            if (isRegularFile) {
                return get(path, metadata);
            }
        }
        return get(uri.toURL(), metadata);
    }

    public static TikaInputStream get(URL url) {
        return get(url, new Metadata());
    }

    public static TikaInputStream get(URL url, Metadata metadata) {
        Path path;
        boolean isRegularFile;
        if (Constants.FILE.equalsIgnoreCase(url.getProtocol())) {
            try {
                path = Paths.get(url.toURI());
                isRegularFile = Files.isRegularFile(path, new LinkOption[0]);
                if (isRegularFile) {
                    return get(path, metadata);
                }
            } catch (URISyntaxException unused) {
            }
        }
        URLConnection openConnection = url.openConnection();
        String path2 = url.getPath();
        int lastIndexOf = path2.lastIndexOf(47) + 1;
        if (lastIndexOf < path2.length()) {
            metadata.set(TikaCoreProperties.RESOURCE_NAME_KEY, path2.substring(lastIndexOf));
        }
        String contentType = openConnection.getContentType();
        if (contentType != null) {
            metadata.set(HttpHeaders.CONTENT_TYPE, contentType);
        }
        String contentEncoding = openConnection.getContentEncoding();
        if (contentEncoding != null) {
            metadata.set(HttpHeaders.CONTENT_ENCODING, contentEncoding);
        }
        int contentLength = openConnection.getContentLength();
        if (contentLength >= 0) {
            metadata.set(HttpHeaders.CONTENT_LENGTH, Integer.toString(contentLength));
        }
        return new TikaInputStream(new BufferedInputStream(openConnection.getInputStream()), new TemporaryResources(), contentLength, getExtension(metadata));
    }
}
