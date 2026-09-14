package com.google.android.play.core.splitinstall;

import com.google.android.play.core.tasks.Task;
import java.util.Set;

public interface SplitInstallManager {
    void registerListener(SplitInstallStateUpdatedListener listener);
    void unregisterListener(SplitInstallStateUpdatedListener listener);
    Task<Integer> startInstall(SplitInstallRequest request);
    Set<String> getInstalledModules();
}
