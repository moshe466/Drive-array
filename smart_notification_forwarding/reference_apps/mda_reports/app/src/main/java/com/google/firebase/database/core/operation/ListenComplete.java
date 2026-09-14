package com.google.firebase.database.core.operation;

import com.google.firebase.database.core.Path;
import com.google.firebase.database.core.operation.Operation;
import com.google.firebase.database.snapshot.ChildKey;

/* loaded from: classes2.dex */
public class ListenComplete extends Operation {
    public ListenComplete(OperationSource operationSource, Path path) {
        super(Operation.OperationType.ListenComplete, operationSource, path);
    }

    @Override // com.google.firebase.database.core.operation.Operation
    public Operation operationForChild(ChildKey childKey) {
        return this.c.isEmpty() ? new ListenComplete(this.b, Path.getEmptyPath()) : new ListenComplete(this.b, this.c.popFront());
    }

    public String toString() {
        return String.format("ListenComplete { path=%s, source=%s }", getPath(), getSource());
    }
}
