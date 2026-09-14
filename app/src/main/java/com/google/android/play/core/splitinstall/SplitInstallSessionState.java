package com.google.android.play.core.splitinstall;

import java.util.Collections;
import java.util.List;

public abstract class SplitInstallSessionState {
    public abstract int sessionId();
    public abstract int status();
    public abstract int errorCode();
    public abstract long bytesDownloaded();
    public abstract long totalBytesToDownload();
    public List<String> moduleNames() { return Collections.emptyList(); }
}
