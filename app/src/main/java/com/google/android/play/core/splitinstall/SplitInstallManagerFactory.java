package com.google.android.play.core.splitinstall;

import android.content.Context;
import com.google.android.play.core.tasks.Task;
import java.util.Collections;
import java.util.Set;

public class SplitInstallManagerFactory {
    public static SplitInstallManager create(Context context) {
        return new SplitInstallManager() {
            @Override
            public void registerListener(SplitInstallStateUpdatedListener listener) {}

            @Override
            public void unregisterListener(SplitInstallStateUpdatedListener listener) {}

            @Override
            public Task<Integer> startInstall(SplitInstallRequest request) {
                return new Task<>();
            }

            @Override
            public Set<String> getInstalledModules() {
                return Collections.emptySet();
            }
        };
    }
}
