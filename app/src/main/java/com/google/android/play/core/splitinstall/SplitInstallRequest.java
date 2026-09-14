package com.google.android.play.core.splitinstall;

import java.util.ArrayList;
import java.util.List;

public class SplitInstallRequest {
    public static Builder newBuilder() {
        return new Builder();
    }

    public static class Builder {
        private final List<String> moduleNames = new ArrayList<>();

        public Builder addModule(String moduleName) {
            this.moduleNames.add(moduleName);
            return this;
        }

        public SplitInstallRequest build() {
            return new SplitInstallRequest();
        }
    }
}
