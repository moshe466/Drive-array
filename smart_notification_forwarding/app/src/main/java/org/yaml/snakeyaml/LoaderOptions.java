package org.yaml.snakeyaml;

/* loaded from: classes2.dex */
public class LoaderOptions {
    private boolean allowDuplicateKeys = true;
    private boolean wrappedToRootException = false;
    private int maxAliasesForCollections = 50;
    private boolean allowRecursiveKeys = false;
    private boolean processComments = false;
    private boolean enumCaseSensitive = true;
    private int nestingDepthLimit = 50;

    public boolean isAllowDuplicateKeys() {
        return this.allowDuplicateKeys;
    }

    public void setAllowDuplicateKeys(boolean z) {
        this.allowDuplicateKeys = z;
    }

    public boolean isWrappedToRootException() {
        return this.wrappedToRootException;
    }

    public void setWrappedToRootException(boolean z) {
        this.wrappedToRootException = z;
    }

    public int getMaxAliasesForCollections() {
        return this.maxAliasesForCollections;
    }

    public void setMaxAliasesForCollections(int i) {
        this.maxAliasesForCollections = i;
    }

    public void setAllowRecursiveKeys(boolean z) {
        this.allowRecursiveKeys = z;
    }

    public boolean getAllowRecursiveKeys() {
        return this.allowRecursiveKeys;
    }

    public void setProcessComments(boolean z) {
        this.processComments = z;
    }

    public boolean isProcessComments() {
        return this.processComments;
    }

    public boolean isEnumCaseSensitive() {
        return this.enumCaseSensitive;
    }

    public void setEnumCaseSensitive(boolean z) {
        this.enumCaseSensitive = z;
    }

    public int getNestingDepthLimit() {
        return this.nestingDepthLimit;
    }

    public void setNestingDepthLimit(int i) {
        this.nestingDepthLimit = i;
    }
}
