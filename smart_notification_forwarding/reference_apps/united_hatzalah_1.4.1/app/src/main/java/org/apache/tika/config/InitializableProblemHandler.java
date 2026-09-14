package org.apache.tika.config;

import n3.d;
import org.apache.tika.exception.TikaConfigException;

/* loaded from: classes.dex */
public interface InitializableProblemHandler {
    public static final InitializableProblemHandler DEFAULT;
    public static final InitializableProblemHandler IGNORE = new InitializableProblemHandler() { // from class: org.apache.tika.config.InitializableProblemHandler.1
        @Override // org.apache.tika.config.InitializableProblemHandler
        public void handleInitializableProblem(String str, String str2) {
        }

        public String toString() {
            return "IGNORE";
        }
    };
    public static final InitializableProblemHandler INFO = new InitializableProblemHandler() { // from class: org.apache.tika.config.InitializableProblemHandler.2
        @Override // org.apache.tika.config.InitializableProblemHandler
        public void handleInitializableProblem(String str, String str2) {
            d.c(str).t(str2);
        }

        public String toString() {
            return "INFO";
        }
    };
    public static final InitializableProblemHandler THROW;
    public static final InitializableProblemHandler WARN;

    static {
        InitializableProblemHandler initializableProblemHandler = new InitializableProblemHandler() { // from class: org.apache.tika.config.InitializableProblemHandler.3
            @Override // org.apache.tika.config.InitializableProblemHandler
            public void handleInitializableProblem(String str, String str2) {
                d.c(str).u(str2);
            }

            public String toString() {
                return "WARN";
            }
        };
        WARN = initializableProblemHandler;
        THROW = new InitializableProblemHandler() { // from class: org.apache.tika.config.InitializableProblemHandler.4
            @Override // org.apache.tika.config.InitializableProblemHandler
            public void handleInitializableProblem(String str, String str2) {
                throw new TikaConfigException(str2);
            }

            public String toString() {
                return "THROW";
            }
        };
        DEFAULT = initializableProblemHandler;
    }

    void handleInitializableProblem(String str, String str2);
}
