package com.google.firebase.inappmessaging.internal;

import android.app.Application;
import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Parser;
import defpackage.a;
import io.reactivex.Completable;
import io.reactivex.Maybe;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import javax.annotation.concurrent.ThreadSafe;

@ThreadSafe
/* loaded from: classes2.dex */
public class ProtoStorageClient {
    private final Application application;
    private final String fileName;

    private static /* synthetic */ void $closeResource(Throwable th, AutoCloseable autoCloseable) {
        if (th == null) {
            autoCloseable.close();
        } else {
            try {
                autoCloseable.close();
            } catch (Throwable unused) {
            }
        }
    }

    public ProtoStorageClient(Application application, String str) {
        this.application = application;
        this.fileName = str;
    }

    public static /* synthetic */ AbstractMessageLite a(ProtoStorageClient protoStorageClient, Parser parser) {
        synchronized (protoStorageClient) {
            try {
                FileInputStream openFileInput = protoStorageClient.application.openFileInput(protoStorageClient.fileName);
                try {
                    AbstractMessageLite abstractMessageLite = (AbstractMessageLite) parser.parseFrom(openFileInput);
                    if (openFileInput != null) {
                        a.a(null, openFileInput);
                    }
                    return abstractMessageLite;
                } finally {
                }
            } catch (InvalidProtocolBufferException | FileNotFoundException e) {
                Logging.logi("Recoverable exception while reading cache: " + e.getMessage());
                return null;
            }
        }
    }

    public static /* synthetic */ Object a(ProtoStorageClient protoStorageClient, AbstractMessageLite abstractMessageLite) {
        synchronized (protoStorageClient) {
            FileOutputStream openFileOutput = protoStorageClient.application.openFileOutput(protoStorageClient.fileName, 0);
            try {
                openFileOutput.write(abstractMessageLite.toByteArray());
                if (openFileOutput != null) {
                    a.a(null, openFileOutput);
                }
            } finally {
            }
        }
        return abstractMessageLite;
    }

    public <T extends AbstractMessageLite> Maybe<T> read(Parser<T> parser) {
        return Maybe.fromCallable(ProtoStorageClient$$Lambda$2.lambdaFactory$(this, parser));
    }

    public Completable write(AbstractMessageLite abstractMessageLite) {
        return Completable.fromCallable(ProtoStorageClient$$Lambda$1.lambdaFactory$(this, abstractMessageLite));
    }
}
