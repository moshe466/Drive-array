package com.google.firebase.database.core.operation;

import com.google.firebase.database.core.Path;
import com.google.firebase.database.snapshot.ChildKey;

/* loaded from: classes2.dex */
public abstract class Operation {
    protected final OperationType a;
    protected final OperationSource b;
    protected final Path c;

    /* loaded from: classes2.dex */
    public enum OperationType {
        Overwrite,
        Merge,
        AckUserWrite,
        ListenComplete
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Operation(OperationType operationType, OperationSource operationSource, Path path) {
        this.a = operationType;
        this.b = operationSource;
        this.c = path;
    }

    public Path getPath() {
        return this.c;
    }

    public OperationSource getSource() {
        return this.b;
    }

    public OperationType getType() {
        return this.a;
    }

    public abstract Operation operationForChild(ChildKey childKey);
}
