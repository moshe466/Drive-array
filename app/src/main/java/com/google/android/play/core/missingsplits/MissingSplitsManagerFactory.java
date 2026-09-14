package com.google.android.play.core.missingsplits;

import android.content.Context;

public class MissingSplitsManagerFactory {
    public static MissingSplitsManager create(Context context) {
        return new MissingSplitsManager() {
            @Override
            public boolean disableAppIfMissingRequiredSplits() {
                return false;
            }

            @Override
            public boolean isMissingRequiredSplits() {
                return false;
            }
        };
    }
}
