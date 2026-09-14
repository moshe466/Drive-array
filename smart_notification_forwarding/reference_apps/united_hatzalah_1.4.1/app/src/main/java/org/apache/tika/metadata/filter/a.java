package org.apache.tika.metadata.filter;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.FileAttribute;

/* loaded from: classes.dex */
public abstract /* synthetic */ class a {
    public static /* bridge */ /* synthetic */ Path f(Object obj) {
        return (Path) obj;
    }

    public static /* bridge */ /* synthetic */ Path g(Path path) {
        return path.getParent();
    }

    public static /* bridge */ /* synthetic */ void q(Path path, FileAttribute[] fileAttributeArr) {
        Files.createDirectories(path, fileAttributeArr);
    }

    public static /* bridge */ /* synthetic */ boolean r(Object obj) {
        return obj instanceof Path;
    }
}
