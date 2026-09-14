package org.yaml.snakeyaml.emitter;

/* loaded from: classes2.dex */
public final class ScalarAnalysis {
    private boolean allowBlock;
    private boolean allowBlockPlain;
    private boolean allowFlowPlain;
    private boolean allowSingleQuoted;
    private boolean empty;
    private boolean multiline;
    private String scalar;

    public ScalarAnalysis(String str, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6) {
        this.scalar = str;
        this.empty = z;
        this.multiline = z2;
        this.allowFlowPlain = z3;
        this.allowBlockPlain = z4;
        this.allowSingleQuoted = z5;
        this.allowBlock = z6;
    }

    public String getScalar() {
        return this.scalar;
    }

    public boolean isEmpty() {
        return this.empty;
    }

    public boolean isMultiline() {
        return this.multiline;
    }

    public boolean isAllowFlowPlain() {
        return this.allowFlowPlain;
    }

    public boolean isAllowBlockPlain() {
        return this.allowBlockPlain;
    }

    public boolean isAllowSingleQuoted() {
        return this.allowSingleQuoted;
    }

    public boolean isAllowBlock() {
        return this.allowBlock;
    }
}
