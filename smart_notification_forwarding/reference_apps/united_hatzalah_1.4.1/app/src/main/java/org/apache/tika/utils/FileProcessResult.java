package org.apache.tika.utils;

import F0.AbstractC0008a;

/* loaded from: classes.dex */
public class FileProcessResult {
    String stderr = "";
    String stdout = "";
    int exitValue = -1;
    long processTimeMillis = -1;
    boolean isTimeout = false;
    long stdoutLength = -1;
    long stderrLength = -1;
    boolean stderrTruncated = false;
    boolean stdoutTruncated = false;

    public int getExitValue() {
        return this.exitValue;
    }

    public long getProcessTimeMillis() {
        return this.processTimeMillis;
    }

    public String getStderr() {
        return this.stderr;
    }

    public long getStderrLength() {
        return this.stderrLength;
    }

    public String getStdout() {
        return this.stdout;
    }

    public long getStdoutLength() {
        return this.stdoutLength;
    }

    public boolean isStderrTruncated() {
        return this.stderrTruncated;
    }

    public boolean isStdoutTruncated() {
        return this.stdoutTruncated;
    }

    public boolean isTimeout() {
        return this.isTimeout;
    }

    public void setExitValue(int i) {
        this.exitValue = i;
    }

    public void setProcessTimeMillis(long j2) {
        this.processTimeMillis = j2;
    }

    public void setStderr(String str) {
        this.stderr = str;
    }

    public void setStderrLength(long j2) {
        this.stderrLength = j2;
    }

    public void setStderrTruncated(boolean z3) {
        this.stderrTruncated = z3;
    }

    public void setStdout(String str) {
        this.stdout = str;
    }

    public void setStdoutLength(long j2) {
        this.stdoutLength = j2;
    }

    public void setStdoutTruncated(boolean z3) {
        this.stdoutTruncated = z3;
    }

    public void setTimeout(boolean z3) {
        this.isTimeout = z3;
    }

    public String toString() {
        String str = this.stderr;
        String str2 = this.stdout;
        int i = this.exitValue;
        long j2 = this.processTimeMillis;
        boolean z3 = this.isTimeout;
        long j3 = this.stdoutLength;
        long j4 = this.stderrLength;
        boolean z4 = this.stderrTruncated;
        boolean z5 = this.stdoutTruncated;
        StringBuilder y = AbstractC0008a.y("FileProcessResult{stderr='", str, "', stdout='", str2, "', exitValue=");
        y.append(i);
        y.append(", processTimeMillis=");
        y.append(j2);
        y.append(", isTimeout=");
        y.append(z3);
        y.append(", stdoutLength=");
        y.append(j3);
        y.append(", stderrLength=");
        y.append(j4);
        y.append(", stderrTruncated=");
        y.append(z4);
        y.append(", stdoutTruncated=");
        y.append(z5);
        y.append("}");
        return y.toString();
    }
}
