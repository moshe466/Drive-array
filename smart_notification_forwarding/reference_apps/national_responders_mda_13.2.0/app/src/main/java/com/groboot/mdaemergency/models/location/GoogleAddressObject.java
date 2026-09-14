package com.groboot.mdaemergency.models.location;

import java.util.List;

/* loaded from: classes.dex */
public class GoogleAddressObject {
    public List<Result> results;
    public String status;

    public List<Result> getResults() {
        return this.results;
    }

    public String getStatus() {
        return this.status;
    }

    public void setResults(List<Result> list) {
        this.results = list;
    }

    public void setStatus(String str) {
        this.status = str;
    }
}
