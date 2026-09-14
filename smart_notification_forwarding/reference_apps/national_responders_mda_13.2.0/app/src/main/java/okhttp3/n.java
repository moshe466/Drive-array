package okhttp3;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes.dex */
public interface n {

    /* renamed from: a, reason: collision with root package name */
    public static final n f12788a = new a();

    /* loaded from: classes.dex */
    class a implements n {
        a() {
        }

        @Override // okhttp3.n
        public List<InetAddress> a(String str) {
            if (str == null) {
                throw new UnknownHostException("hostname == null");
            }
            try {
                return Arrays.asList(InetAddress.getAllByName(str));
            } catch (NullPointerException e10) {
                UnknownHostException unknownHostException = new UnknownHostException("Broken system behaviour for dns lookup of " + str);
                unknownHostException.initCause(e10);
                throw unknownHostException;
            }
        }
    }

    List<InetAddress> a(String str);
}
