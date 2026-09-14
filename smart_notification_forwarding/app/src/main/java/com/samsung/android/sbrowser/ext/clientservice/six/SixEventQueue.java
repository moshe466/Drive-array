package com.samsung.android.sbrowser.ext.clientservice.six;

import com.samsung.android.sbrowser.ext.ExClientService;
import java.util.LinkedList;
import java.util.Queue;

/* compiled from: SixObject.java */
/* loaded from: classes.dex */
class SixEventQueue {
    private ExClientService mClientService;
    private final Queue<String> mIdQueue = new LinkedList();
    private final Queue<SixEvent> mEventQueue = new LinkedList();

    /* JADX INFO: Access modifiers changed from: package-private */
    public SixEventQueue(ExClientService exClientService) {
        this.mClientService = null;
        this.mClientService = exClientService;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void addEventListener(String str) {
        SixEvent peek = this.mEventQueue.peek();
        if (peek == null) {
            this.mIdQueue.add(str);
        } else {
            this.mEventQueue.remove();
            this.mClientService.RunMessage(str, peek.toMsg());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void fireEvent(SixEvent sixEvent) {
        String peek = this.mIdQueue.peek();
        if (peek == null) {
            this.mEventQueue.add(sixEvent);
        } else {
            this.mIdQueue.remove();
            this.mClientService.RunMessage(peek, sixEvent.toMsg());
        }
    }
}
