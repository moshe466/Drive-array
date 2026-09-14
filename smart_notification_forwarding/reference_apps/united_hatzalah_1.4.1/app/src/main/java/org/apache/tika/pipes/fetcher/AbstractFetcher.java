package org.apache.tika.pipes.fetcher;

import org.apache.tika.config.Field;

/* loaded from: classes.dex */
public abstract class AbstractFetcher implements Fetcher {
    private String name;

    public AbstractFetcher() {
    }

    @Override // org.apache.tika.pipes.fetcher.Fetcher
    public String getName() {
        return this.name;
    }

    @Field
    public void setName(String str) {
        this.name = str;
    }

    public AbstractFetcher(String str) {
        this.name = str;
    }
}
