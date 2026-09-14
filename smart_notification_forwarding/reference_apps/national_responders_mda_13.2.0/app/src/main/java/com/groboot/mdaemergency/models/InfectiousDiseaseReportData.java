package com.groboot.mdaemergency.models;

import y8.k;

/* loaded from: classes.dex */
public final class InfectiousDiseaseReportData {
    private final String FromDate;
    private final String ToDate;
    private final int type;

    public InfectiousDiseaseReportData(int i10, String str, String str2) {
        k.e(str, "FromDate");
        k.e(str2, "ToDate");
        this.type = i10;
        this.FromDate = str;
        this.ToDate = str2;
    }

    public final String getFromDate() {
        return this.FromDate;
    }

    public final String getToDate() {
        return this.ToDate;
    }

    public final int getType() {
        return this.type;
    }
}
