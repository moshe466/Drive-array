package org.apache.tika.parser;

import H0.g;
import com.google.firebase.crashlytics.internal.concurrency.b;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes.dex */
public abstract class AbstractExternalProcessParser implements Parser {
    private static final ConcurrentHashMap<String, Process> PROCESS_MAP = new ConcurrentHashMap<>();
    private static final long serialVersionUID = 7186985395903074255L;

    static {
        Runtime.getRuntime().addShutdownHook(new Thread(new b(2)));
    }

    public static /* synthetic */ void lambda$static$0() {
        PROCESS_MAP.forEachValue(1L, new g(2));
    }

    public String register(Process process) {
        String uuid = UUID.randomUUID().toString();
        PROCESS_MAP.put(uuid, process);
        return uuid;
    }

    public Process release(String str) {
        return PROCESS_MAP.remove(str);
    }
}
