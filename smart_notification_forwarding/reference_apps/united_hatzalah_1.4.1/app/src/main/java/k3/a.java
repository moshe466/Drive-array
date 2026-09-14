package k3;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;

/* loaded from: classes.dex */
public abstract /* synthetic */ class a {
    public static /* bridge */ /* synthetic */ long a(Path path) {
        return Files.size(path);
    }

    public static /* bridge */ /* synthetic */ File e(Path path) {
        return path.toFile();
    }

    public static /* bridge */ /* synthetic */ Class g() {
        return BasicFileAttributes.class;
    }

    public static /* bridge */ /* synthetic */ void u(Process process) {
        process.destroyForcibly();
    }

    public static /* bridge */ /* synthetic */ boolean z(Path path, LinkOption[] linkOptionArr) {
        return Files.isDirectory(path, linkOptionArr);
    }
}
