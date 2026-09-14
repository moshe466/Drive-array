package com.google.firebase.database.core.utilities.tuple;

import com.google.firebase.database.core.Path;

/* loaded from: classes.dex */
public class PathAndId {
    private long id;
    private Path path;

    public PathAndId(Path path, long j2) {
        this.path = path;
        this.id = j2;
    }

    public long getId() {
        return this.id;
    }

    public Path getPath() {
        return this.path;
    }
}
