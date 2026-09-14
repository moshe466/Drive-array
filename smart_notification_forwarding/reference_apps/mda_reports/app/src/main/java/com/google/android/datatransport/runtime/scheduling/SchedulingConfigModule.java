package com.google.android.datatransport.runtime.scheduling;

import com.google.android.datatransport.runtime.scheduling.jobscheduling.SchedulerConfig;
import com.google.android.datatransport.runtime.time.Clock;
import com.google.android.datatransport.runtime.time.WallTime;
import dagger.Module;
import dagger.Provides;

@Module
/* loaded from: classes.dex */
public abstract class SchedulingConfigModule {
    /* JADX INFO: Access modifiers changed from: package-private */
    @Provides
    public static SchedulerConfig a(@WallTime Clock clock) {
        return SchedulerConfig.getDefault(clock);
    }
}
