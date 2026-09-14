package org.apache.tika.parser;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import org.apache.tika.metadata.Metadata;

/* loaded from: classes.dex */
public class ParseRecord {
    private static final int MAX_EXCEPTIONS = 100;
    private static final int MAX_METADATA_LIST_SIZE = 100;
    private static int MAX_PARSERS = 100;
    private static final int MAX_WARNINGS = 100;
    private int depth = 0;
    private final Set<String> parsers = new LinkedHashSet();
    private final List<Exception> exceptions = new ArrayList();
    private final List<String> warnings = new ArrayList();
    private final List<Metadata> metadataList = new ArrayList();
    private boolean writeLimitReached = false;

    public void addException(Exception exc) {
        if (this.exceptions.size() < 100) {
            this.exceptions.add(exc);
        }
    }

    public void addMetadata(Metadata metadata) {
        if (this.metadataList.size() < 100) {
            this.metadataList.add(metadata);
        }
    }

    public void addParserClass(String str) {
        if (this.parsers.size() < MAX_PARSERS) {
            this.parsers.add(str);
        }
    }

    public void addWarning(String str) {
        if (this.warnings.size() < 100) {
            this.warnings.add(str);
        }
    }

    public void afterParse() {
        this.depth--;
    }

    public void beforeParse() {
        this.depth++;
    }

    public int getDepth() {
        return this.depth;
    }

    public List<Exception> getExceptions() {
        return this.exceptions;
    }

    public List<Metadata> getMetadataList() {
        return this.metadataList;
    }

    public String[] getParsers() {
        return (String[]) this.parsers.toArray(new String[0]);
    }

    public List<String> getWarnings() {
        return this.warnings;
    }

    public boolean isWriteLimitReached() {
        return this.writeLimitReached;
    }

    public void setWriteLimitReached(boolean z3) {
        this.writeLimitReached = z3;
    }
}
