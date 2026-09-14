package m1;

import com.google.android.gms.common.api.Api;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* renamed from: m1.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0587a {

    /* renamed from: a, reason: collision with root package name */
    public static final ThreadPoolExecutor f5865a = new ThreadPoolExecutor(0, Api.BaseClientBuilder.API_PRIORITY_OTHER, 60, TimeUnit.SECONDS, new SynchronousQueue());
}
