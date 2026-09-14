package org.apache.tika.renderer;

import java.io.Closeable;
import java.util.ArrayList;
import java.util.List;
import org.apache.tika.io.TemporaryResources;

/* loaded from: classes.dex */
public class RenderResults implements Closeable {
    private List<RenderResult> results = new ArrayList();
    private final TemporaryResources tmp;

    public RenderResults(TemporaryResources temporaryResources) {
        this.tmp = temporaryResources;
    }

    public void add(RenderResult renderResult) {
        this.tmp.addResource(renderResult);
        this.results.add(renderResult);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.tmp.close();
    }

    public List<RenderResult> getResults() {
        return this.results;
    }
}
