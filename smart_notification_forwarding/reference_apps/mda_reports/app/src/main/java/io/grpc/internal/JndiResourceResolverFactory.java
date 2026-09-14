package io.grpc.internal;

import android.annotation.SuppressLint;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Verify;
import io.grpc.Attributes;
import io.grpc.EquivalentAddressGroup;
import io.grpc.internal.DnsNameResolver;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import javax.annotation.Nullable;
import javax.naming.NamingEnumeration;
import javax.naming.NamingException;
import javax.naming.directory.Attribute;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;
import org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class JndiResourceResolverFactory implements DnsNameResolver.ResourceResolverFactory {

    @Nullable
    private static final Throwable JNDI_UNAVAILABILITY_CAUSE = initJndi();

    @SuppressLint({"all"})
    @IgnoreJRERequirement
    @VisibleForTesting
    /* loaded from: classes2.dex */
    static final class JndiRecordFetcher implements RecordFetcher {
        JndiRecordFetcher() {
        }

        private static void checkAvailable() {
            if (JndiResourceResolverFactory.JNDI_UNAVAILABILITY_CAUSE != null) {
                throw new UnsupportedOperationException("JNDI is not currently available", JndiResourceResolverFactory.JNDI_UNAVAILABILITY_CAUSE);
            }
        }

        private static void closeThenThrow(NamingEnumeration<?> namingEnumeration, NamingException namingException) {
            try {
                namingEnumeration.close();
                throw namingException;
            } catch (NamingException unused) {
                throw namingException;
            }
        }

        private static void closeThenThrow(DirContext dirContext, NamingException namingException) {
            try {
                dirContext.close();
                throw namingException;
            } catch (NamingException unused) {
                throw namingException;
            }
        }

        @Override // io.grpc.internal.JndiResourceResolverFactory.RecordFetcher
        public List<String> getAllRecords(String str, String str2) {
            checkAvailable();
            String[] strArr = {str};
            ArrayList arrayList = new ArrayList();
            Hashtable hashtable = new Hashtable();
            hashtable.put("com.sun.jndi.ldap.connect.timeout", "5000");
            hashtable.put("com.sun.jndi.ldap.read.timeout", "5000");
            InitialDirContext initialDirContext = new InitialDirContext(hashtable);
            try {
                NamingEnumeration all = initialDirContext.getAttributes(str2, strArr).getAll();
                while (all.hasMore()) {
                    try {
                        NamingEnumeration all2 = ((Attribute) all.next()).getAll();
                        while (all2.hasMore()) {
                            try {
                                arrayList.add(String.valueOf(all2.next()));
                            } catch (NamingException e) {
                                closeThenThrow((NamingEnumeration<?>) all2, e);
                            }
                        }
                        all2.close();
                    } catch (NamingException e2) {
                        closeThenThrow((NamingEnumeration<?>) all, e2);
                    }
                }
                all.close();
            } catch (NamingException e3) {
                closeThenThrow((DirContext) initialDirContext, e3);
            }
            initialDirContext.close();
            return arrayList;
        }
    }

    @VisibleForTesting
    /* loaded from: classes2.dex */
    static final class JndiResourceResolver implements DnsNameResolver.ResourceResolver {
        private static final Logger logger = Logger.getLogger(JndiResourceResolver.class.getName());
        private static final Pattern whitespace = Pattern.compile("\\s+");
        private final RecordFetcher recordFetcher;

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes2.dex */
        public static final class SrvRecord {
            final String a;
            final int b;

            SrvRecord(String str, int i) {
                this.a = str;
                this.b = i;
            }
        }

        public JndiResourceResolver(RecordFetcher recordFetcher) {
            this.recordFetcher = recordFetcher;
        }

        @VisibleForTesting
        static String a(String str) {
            StringBuilder sb = new StringBuilder(str.length());
            int i = 0;
            boolean z = false;
            while (i < str.length()) {
                char charAt = str.charAt(i);
                if (z) {
                    if (charAt == '\"') {
                        z = false;
                    } else {
                        if (charAt == '\\') {
                            i++;
                            charAt = str.charAt(i);
                        }
                        sb.append(charAt);
                    }
                } else if (charAt != ' ') {
                    if (charAt == '\"') {
                        z = true;
                    }
                    sb.append(charAt);
                }
                i++;
            }
            return sb.toString();
        }

        private static SrvRecord parseSrvRecord(String str) {
            String[] split = whitespace.split(str);
            Verify.verify(split.length == 4, "Bad SRV Record: %s", str);
            return new SrvRecord(split[3], Integer.parseInt(split[2]));
        }

        @Override // io.grpc.internal.DnsNameResolver.ResourceResolver
        public List<EquivalentAddressGroup> resolveSrv(DnsNameResolver.AddressResolver addressResolver, String str) {
            SrvRecord parseSrvRecord;
            if (logger.isLoggable(Level.FINER)) {
                logger.log(Level.FINER, "About to query SRV records for {0}", new Object[]{str});
            }
            List<String> allRecords = this.recordFetcher.getAllRecords("SRV", "dns:///" + str);
            if (logger.isLoggable(Level.FINER)) {
                logger.log(Level.FINER, "Found {0} SRV records", new Object[]{Integer.valueOf(allRecords.size())});
            }
            ArrayList arrayList = new ArrayList(allRecords.size());
            Throwable th = null;
            Level level = Level.WARNING;
            for (String str2 : allRecords) {
                try {
                    parseSrvRecord = parseSrvRecord(str2);
                } catch (RuntimeException e) {
                    e = e;
                    logger.log(level, "Failed to construct SRV record " + str2, e);
                    if (th == null) {
                        level = Level.FINE;
                        th = e;
                    }
                } catch (UnknownHostException e2) {
                    e = e2;
                    logger.log(level, "Can't find address for SRV record " + str2, e);
                    if (th == null) {
                        level = Level.FINE;
                        th = e;
                    }
                }
                if (!parseSrvRecord.a.endsWith(".")) {
                    throw new RuntimeException("Returned SRV host does not end in period: " + parseSrvRecord.a);
                    break;
                }
                String substring = parseSrvRecord.a.substring(0, parseSrvRecord.a.length() - 1);
                List<InetAddress> resolveAddress = addressResolver.resolveAddress(parseSrvRecord.a);
                ArrayList arrayList2 = new ArrayList(resolveAddress.size());
                Iterator<InetAddress> it = resolveAddress.iterator();
                while (it.hasNext()) {
                    arrayList2.add(new InetSocketAddress(it.next(), parseSrvRecord.b));
                }
                arrayList.add(new EquivalentAddressGroup((List<SocketAddress>) Collections.unmodifiableList(arrayList2), Attributes.newBuilder().set(GrpcAttributes.ATTR_LB_ADDR_AUTHORITY, substring).build()));
            }
            if (!arrayList.isEmpty() || th == null) {
                return Collections.unmodifiableList(arrayList);
            }
            throw th;
        }

        @Override // io.grpc.internal.DnsNameResolver.ResourceResolver
        public List<String> resolveTxt(String str) {
            if (logger.isLoggable(Level.FINER)) {
                logger.log(Level.FINER, "About to query TXT records for {0}", new Object[]{str});
            }
            List<String> allRecords = this.recordFetcher.getAllRecords("TXT", "dns:///" + str);
            if (logger.isLoggable(Level.FINER)) {
                logger.log(Level.FINER, "Found {0} TXT records", new Object[]{Integer.valueOf(allRecords.size())});
            }
            ArrayList arrayList = new ArrayList(allRecords.size());
            Iterator<String> it = allRecords.iterator();
            while (it.hasNext()) {
                arrayList.add(a(it.next()));
            }
            return Collections.unmodifiableList(arrayList);
        }
    }

    @VisibleForTesting
    /* loaded from: classes2.dex */
    interface RecordFetcher {
        List<String> getAllRecords(String str, String str2);
    }

    @Nullable
    private static Throwable initJndi() {
        if (GrpcUtil.IS_RESTRICTED_APPENGINE) {
            return new UnsupportedOperationException("Currently running in an AppEngine restricted environment");
        }
        try {
            Class.forName("javax.naming.directory.InitialDirContext");
            Class.forName("com.sun.jndi.dns.DnsContextFactory");
            return null;
        } catch (ClassNotFoundException e) {
            return e;
        } catch (Error e2) {
            return e2;
        } catch (RuntimeException e3) {
            return e3;
        }
    }

    @Override // io.grpc.internal.DnsNameResolver.ResourceResolverFactory
    @Nullable
    public DnsNameResolver.ResourceResolver newResourceResolver() {
        if (unavailabilityCause() != null) {
            return null;
        }
        return new JndiResourceResolver(new JndiRecordFetcher());
    }

    @Override // io.grpc.internal.DnsNameResolver.ResourceResolverFactory
    @Nullable
    public Throwable unavailabilityCause() {
        return JNDI_UNAVAILABILITY_CAUSE;
    }
}
