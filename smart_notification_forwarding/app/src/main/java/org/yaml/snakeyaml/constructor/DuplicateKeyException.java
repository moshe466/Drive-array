package org.yaml.snakeyaml.constructor;

import org.yaml.snakeyaml.error.Mark;

/* loaded from: classes2.dex */
public class DuplicateKeyException extends ConstructorException {
    /* JADX INFO: Access modifiers changed from: protected */
    public DuplicateKeyException(Mark mark, Object obj, Mark mark2) {
        super("while constructing a mapping", mark, "found duplicate key " + String.valueOf(obj), mark2);
    }
}
