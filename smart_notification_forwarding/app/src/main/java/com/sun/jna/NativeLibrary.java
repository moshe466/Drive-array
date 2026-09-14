package com.sun.jna;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.samsung.android.sbrowser.ext.clientservice.texttrack.Cue;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;

/* loaded from: classes.dex */
public class NativeLibrary {
    private static final Level DEBUG_LOAD_LEVEL;
    private static final int DEFAULT_OPEN_OPTIONS = -1;
    private static final Logger LOG = Logger.getLogger(NativeLibrary.class.getName());
    private static Method addSuppressedMethod;
    private static final Map<String, Reference<NativeLibrary>> libraries;
    private static final LinkedHashSet<String> librarySearchPath;
    private static final Map<String, List<String>> searchPaths;
    final int callFlags;
    private String encoding;
    private final Map<String, Function> functions;
    private long handle;
    private final String libraryName;
    private final String libraryPath;
    final Map<String, ?> options;

    static {
        DEBUG_LOAD_LEVEL = Native.DEBUG_LOAD ? Level.INFO : Level.FINE;
        libraries = new HashMap();
        searchPaths = Collections.synchronizedMap(new HashMap());
        librarySearchPath = new LinkedHashSet<>();
        if (Native.POINTER_SIZE == 0) {
            throw new Error("Native library not initialized");
        }
        addSuppressedMethod = null;
        try {
            addSuppressedMethod = Throwable.class.getMethod("addSuppressed", Throwable.class);
        } catch (NoSuchMethodException unused) {
        } catch (SecurityException e) {
            Logger.getLogger(NativeLibrary.class.getName()).log(Level.SEVERE, "Failed to initialize 'addSuppressed' method", (Throwable) e);
        }
        String webStartLibraryPath = Native.getWebStartLibraryPath("jnidispatch");
        if (webStartLibraryPath != null) {
            librarySearchPath.add(webStartLibraryPath);
        }
        if (System.getProperty("jna.platform.library.path") == null && !Platform.isWindows()) {
            String str = (Platform.isLinux() || Platform.isSolaris() || Platform.isFreeBSD() || Platform.iskFreeBSD()) ? (Platform.isSolaris() ? "/" : JsonProperty.USE_DEFAULT_NAME) + (Native.POINTER_SIZE * 8) : JsonProperty.USE_DEFAULT_NAME;
            String[] strArr = {"/usr/lib" + str, "/lib" + str, "/usr/lib", "/lib"};
            if (Platform.isLinux() || Platform.iskFreeBSD() || Platform.isGNU()) {
                String multiArchPath = getMultiArchPath();
                strArr = new String[]{"/usr/lib/" + multiArchPath, "/lib/" + multiArchPath, "/usr/lib" + str, "/lib" + str, "/usr/lib", "/lib"};
            }
            if (Platform.isLinux()) {
                ArrayList<String> linuxLdPaths = getLinuxLdPaths();
                for (int length = strArr.length - 1; length >= 0; length--) {
                    int indexOf = linuxLdPaths.indexOf(strArr[length]);
                    if (indexOf != -1) {
                        linuxLdPaths.remove(indexOf);
                    }
                    linuxLdPaths.add(0, strArr[length]);
                }
                strArr = (String[]) linuxLdPaths.toArray(new String[0]);
            }
            String str2 = JsonProperty.USE_DEFAULT_NAME;
            String str3 = str2;
            for (int i = 0; i < strArr.length; i++) {
                File file = new File(strArr[i]);
                if (file.exists() && file.isDirectory()) {
                    str2 = str2 + str3 + strArr[i];
                    str3 = File.pathSeparator;
                }
            }
            if (!JsonProperty.USE_DEFAULT_NAME.equals(str2)) {
                System.setProperty("jna.platform.library.path", str2);
            }
        }
        librarySearchPath.addAll(initPaths("jna.platform.library.path"));
    }

    private static String functionKey(String str, int i, String str2) {
        return str + "|" + i + "|" + str2;
    }

    private NativeLibrary(String str, String str2, long j, Map<String, ?> map) {
        HashMap hashMap = new HashMap();
        this.functions = hashMap;
        String libraryName = getLibraryName(str);
        this.libraryName = libraryName;
        this.libraryPath = str2;
        this.handle = j;
        Object obj = map.get(Library.OPTION_CALLING_CONVENTION);
        int intValue = obj instanceof Number ? ((Number) obj).intValue() : 0;
        this.callFlags = intValue;
        this.options = map;
        String str3 = (String) map.get(Library.OPTION_STRING_ENCODING);
        this.encoding = str3;
        if (str3 == null) {
            this.encoding = Native.getDefaultStringEncoding();
        }
        if (Platform.isWindows() && "kernel32".equals(libraryName.toLowerCase())) {
            synchronized (hashMap) {
                hashMap.put(functionKey("GetLastError", intValue, this.encoding), new Function(this, "GetLastError", 63, this.encoding) { // from class: com.sun.jna.NativeLibrary.1
                    @Override // com.sun.jna.Function
                    Object invoke(Object[] objArr, Class<?> cls, boolean z, int i) {
                        return Integer.valueOf(Native.getLastError());
                    }

                    /* JADX INFO: Access modifiers changed from: package-private */
                    @Override // com.sun.jna.Function
                    public Object invoke(Method method, Class<?>[] clsArr, Class<?> cls, Object[] objArr, Map<String, ?> map2) {
                        return Integer.valueOf(Native.getLastError());
                    }
                });
            }
        }
    }

    private static int openFlags(Map<String, ?> map) {
        Object obj = map.get(Library.OPTION_OPEN_FLAGS);
        if (obj instanceof Number) {
            return ((Number) obj).intValue();
        }
        return -1;
    }

    /* JADX WARN: Finally extract failed */
    /* JADX WARN: Unreachable blocks removed: 2, instructions: 2 */
    private static NativeLibrary loadLibrary(String str, Map<String, ?> map) {
        long j;
        Logger logger = LOG;
        Level level = DEBUG_LOAD_LEVEL;
        logger.log(level, "Looking for library '" + str + "'");
        ArrayList<Throwable> arrayList = new ArrayList();
        boolean isAbsolute = new File(str).isAbsolute();
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        int openFlags = openFlags(map);
        List<String> list = searchPaths.get(str);
        if (list != null) {
            synchronized (list) {
                linkedHashSet.addAll(list);
            }
        }
        String webStartLibraryPath = Native.getWebStartLibraryPath(str);
        if (webStartLibraryPath != null) {
            logger.log(level, "Adding web start path " + webStartLibraryPath);
            linkedHashSet.add(webStartLibraryPath);
        }
        logger.log(level, "Adding paths from jna.library.path: " + System.getProperty("jna.library.path"));
        linkedHashSet.addAll(initPaths("jna.library.path"));
        String findLibraryPath = findLibraryPath(str, linkedHashSet);
        try {
            logger.log(level, "Trying " + findLibraryPath);
            j = Native.open(findLibraryPath, openFlags);
        } catch (UnsatisfiedLinkError e) {
            Logger logger2 = LOG;
            Level level2 = DEBUG_LOAD_LEVEL;
            logger2.log(level2, "Loading failed with message: " + e.getMessage());
            StringBuilder sb = new StringBuilder("Adding system paths: ");
            LinkedHashSet<String> linkedHashSet2 = librarySearchPath;
            logger2.log(level2, sb.append(linkedHashSet2).toString());
            arrayList.add(e);
            linkedHashSet.addAll(linkedHashSet2);
            j = 0;
        }
        if (j == 0) {
            try {
                findLibraryPath = findLibraryPath(str, linkedHashSet);
                LOG.log(DEBUG_LOAD_LEVEL, "Trying " + findLibraryPath);
                j = Native.open(findLibraryPath, openFlags);
                if (j == 0) {
                    throw new UnsatisfiedLinkError("Failed to load library '" + str + "'");
                }
            } catch (UnsatisfiedLinkError e2) {
                Logger logger3 = LOG;
                Level level3 = DEBUG_LOAD_LEVEL;
                logger3.log(level3, "Loading failed with message: " + e2.getMessage());
                arrayList.add(e2);
                if (Platform.isAndroid()) {
                    try {
                        logger3.log(level3, "Preload (via System.loadLibrary) " + str);
                        System.loadLibrary(str);
                        j = Native.open(findLibraryPath, openFlags);
                    } catch (UnsatisfiedLinkError e3) {
                        LOG.log(DEBUG_LOAD_LEVEL, "Loading failed with message: " + e3.getMessage());
                        arrayList.add(e3);
                    }
                } else if (Platform.isLinux() || Platform.isFreeBSD()) {
                    logger3.log(level3, "Looking for version variants");
                    findLibraryPath = matchLibrary(str, linkedHashSet);
                    if (findLibraryPath != null) {
                        logger3.log(level3, "Trying " + findLibraryPath);
                        try {
                            j = Native.open(findLibraryPath, openFlags);
                        } catch (UnsatisfiedLinkError e4) {
                            LOG.log(DEBUG_LOAD_LEVEL, "Loading failed with message: " + e4.getMessage());
                            arrayList.add(e4);
                        }
                    }
                } else if (Platform.isMac() && !str.endsWith(".dylib")) {
                    String[] matchFramework = matchFramework(str);
                    int length = matchFramework.length;
                    int i = 0;
                    while (true) {
                        if (i >= length) {
                            break;
                        }
                        String str2 = matchFramework[i];
                        try {
                            LOG.log(DEBUG_LOAD_LEVEL, "Trying " + str2);
                            j = Native.open(str2, openFlags);
                            break;
                        } catch (UnsatisfiedLinkError e5) {
                            LOG.log(DEBUG_LOAD_LEVEL, "Loading failed with message: " + e5.getMessage());
                            arrayList.add(e5);
                            i++;
                        }
                    }
                } else if (Platform.isWindows() && !isAbsolute) {
                    logger3.log(level3, "Looking for lib- prefix");
                    findLibraryPath = findLibraryPath("lib" + str, linkedHashSet);
                    if (findLibraryPath != null) {
                        logger3.log(level3, "Trying " + findLibraryPath);
                        try {
                            j = Native.open(findLibraryPath, openFlags);
                        } catch (UnsatisfiedLinkError e6) {
                            LOG.log(DEBUG_LOAD_LEVEL, "Loading failed with message: " + e6.getMessage());
                            arrayList.add(e6);
                        }
                    }
                }
                if (j == 0) {
                    try {
                        File extractFromResourcePath = Native.extractFromResourcePath(str, (ClassLoader) map.get(Library.OPTION_CLASSLOADER));
                        try {
                            j = Native.open(extractFromResourcePath.getAbsolutePath(), openFlags);
                            findLibraryPath = extractFromResourcePath.getAbsolutePath();
                            if (Native.isUnpacked(extractFromResourcePath)) {
                                Native.deleteLibrary(extractFromResourcePath);
                            }
                        } catch (Throwable th) {
                            if (Native.isUnpacked(extractFromResourcePath)) {
                                Native.deleteLibrary(extractFromResourcePath);
                            }
                            throw th;
                        }
                    } catch (IOException e7) {
                        LOG.log(DEBUG_LOAD_LEVEL, "Loading failed with message: " + e7.getMessage());
                        arrayList.add(e7);
                    }
                }
                if (j == 0) {
                    StringBuilder sb2 = new StringBuilder("Unable to load library '");
                    sb2.append(str);
                    sb2.append("':");
                    for (Throwable th2 : arrayList) {
                        sb2.append("\n");
                        sb2.append(th2.getMessage());
                    }
                    UnsatisfiedLinkError unsatisfiedLinkError = new UnsatisfiedLinkError(sb2.toString());
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        addSuppressedReflected(unsatisfiedLinkError, (Throwable) it.next());
                    }
                    throw unsatisfiedLinkError;
                }
            }
        }
        String str3 = findLibraryPath;
        LOG.log(DEBUG_LOAD_LEVEL, "Found library '" + str + "' at " + str3);
        return new NativeLibrary(str, str3, j, map);
    }

    private static void addSuppressedReflected(Throwable th, Throwable th2) {
        Method method = addSuppressedMethod;
        if (method == null) {
            return;
        }
        try {
            method.invoke(th, th2);
        } catch (IllegalAccessException e) {
            throw new RuntimeException("Failed to call addSuppressedMethod", e);
        } catch (IllegalArgumentException e2) {
            throw new RuntimeException("Failed to call addSuppressedMethod", e2);
        } catch (InvocationTargetException e3) {
            throw new RuntimeException("Failed to call addSuppressedMethod", e3);
        }
    }

    static String[] matchFramework(String str) {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        File file = new File(str);
        if (file.isAbsolute()) {
            if (str.contains(".framework")) {
                if (file.exists()) {
                    return new String[]{file.getAbsolutePath()};
                }
                linkedHashSet.add(file.getAbsolutePath());
            } else {
                File file2 = new File(new File(file.getParentFile(), file.getName() + ".framework"), file.getName());
                if (file2.exists()) {
                    return new String[]{file2.getAbsolutePath()};
                }
                linkedHashSet.add(file2.getAbsolutePath());
            }
        } else {
            String[] strArr = {System.getProperty("user.home"), JsonProperty.USE_DEFAULT_NAME, "/System"};
            if (!str.contains(".framework")) {
                str = str + ".framework/" + str;
            }
            for (int i = 0; i < 3; i++) {
                File file3 = new File(strArr[i] + "/Library/Frameworks/" + str);
                if (file3.exists()) {
                    return new String[]{file3.getAbsolutePath()};
                }
                linkedHashSet.add(file3.getAbsolutePath());
            }
        }
        return (String[]) linkedHashSet.toArray(new String[0]);
    }

    private String getLibraryName(String str) {
        String mapSharedLibraryName = mapSharedLibraryName("---");
        int indexOf = mapSharedLibraryName.indexOf("---");
        if (indexOf > 0 && str.startsWith(mapSharedLibraryName.substring(0, indexOf))) {
            str = str.substring(indexOf);
        }
        int indexOf2 = str.indexOf(mapSharedLibraryName.substring(indexOf + 3));
        return indexOf2 != -1 ? str.substring(0, indexOf2) : str;
    }

    public static final NativeLibrary getInstance(String str) {
        return getInstance(str, (Map<String, ?>) Collections.emptyMap());
    }

    public static final NativeLibrary getInstance(String str, ClassLoader classLoader) {
        return getInstance(str, (Map<String, ?>) Collections.singletonMap(Library.OPTION_CLASSLOADER, classLoader));
    }

    public static final NativeLibrary getInstance(String str, Map<String, ?> map) {
        NativeLibrary nativeLibrary;
        NativeLibrary loadLibrary;
        HashMap hashMap = new HashMap(map);
        if (hashMap.get(Library.OPTION_CALLING_CONVENTION) == null) {
            hashMap.put(Library.OPTION_CALLING_CONVENTION, 0);
        }
        if ((Platform.isLinux() || Platform.isFreeBSD() || Platform.isAIX()) && Platform.C_LIBRARY_NAME.equals(str)) {
            str = null;
        }
        Map<String, Reference<NativeLibrary>> map2 = libraries;
        synchronized (map2) {
            Reference<NativeLibrary> reference = map2.get(str + hashMap);
            nativeLibrary = reference != null ? reference.get() : null;
            if (nativeLibrary == null) {
                if (str == null) {
                    loadLibrary = new NativeLibrary("<process>", null, Native.open(null, openFlags(hashMap)), hashMap);
                } else {
                    loadLibrary = loadLibrary(str, hashMap);
                }
                nativeLibrary = loadLibrary;
                WeakReference weakReference = new WeakReference(nativeLibrary);
                map2.put(nativeLibrary.getName() + hashMap, weakReference);
                File file = nativeLibrary.getFile();
                if (file != null) {
                    map2.put(file.getAbsolutePath() + hashMap, weakReference);
                    map2.put(file.getName() + hashMap, weakReference);
                }
            }
        }
        return nativeLibrary;
    }

    public static final synchronized NativeLibrary getProcess() {
        NativeLibrary nativeLibrary;
        synchronized (NativeLibrary.class) {
            nativeLibrary = getInstance(null);
        }
        return nativeLibrary;
    }

    public static final synchronized NativeLibrary getProcess(Map<String, ?> map) {
        NativeLibrary nativeLibrary;
        synchronized (NativeLibrary.class) {
            nativeLibrary = getInstance((String) null, map);
        }
        return nativeLibrary;
    }

    public static final void addSearchPath(String str, String str2) {
        Map<String, List<String>> map = searchPaths;
        synchronized (map) {
            List<String> list = map.get(str);
            if (list == null) {
                list = Collections.synchronizedList(new ArrayList());
                map.put(str, list);
            }
            list.add(str2);
        }
    }

    public Function getFunction(String str) {
        return getFunction(str, this.callFlags);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Function getFunction(String str, Method method) {
        FunctionMapper functionMapper = (FunctionMapper) this.options.get(Library.OPTION_FUNCTION_MAPPER);
        if (functionMapper != null) {
            str = functionMapper.getFunctionName(this, method);
        }
        String property = System.getProperty("jna.profiler.prefix", "$$YJP$$");
        if (str.startsWith(property)) {
            str = str.substring(property.length());
        }
        int i = this.callFlags;
        for (Class<?> cls : method.getExceptionTypes()) {
            if (LastErrorException.class.isAssignableFrom(cls)) {
                i |= 64;
            }
        }
        return getFunction(str, i);
    }

    public Function getFunction(String str, int i) {
        return getFunction(str, i, this.encoding);
    }

    public Function getFunction(String str, int i, String str2) {
        Function function;
        if (str == null) {
            throw new NullPointerException("Function name may not be null");
        }
        synchronized (this.functions) {
            String functionKey = functionKey(str, i, str2);
            function = this.functions.get(functionKey);
            if (function == null) {
                function = new Function(this, str, i, str2);
                this.functions.put(functionKey, function);
            }
        }
        return function;
    }

    public Map<String, ?> getOptions() {
        return this.options;
    }

    public Pointer getGlobalVariableAddress(String str) {
        try {
            return new Pointer(getSymbolAddress(str));
        } catch (UnsatisfiedLinkError e) {
            throw new UnsatisfiedLinkError("Error looking up '" + str + "': " + e.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long getSymbolAddress(String str) {
        long j = this.handle;
        if (j == 0) {
            throw new UnsatisfiedLinkError("Library has been unloaded");
        }
        return Native.findSymbol(j, str);
    }

    public String toString() {
        return "Native Library <" + this.libraryPath + "@" + this.handle + ">";
    }

    public String getName() {
        return this.libraryName;
    }

    public File getFile() {
        if (this.libraryPath == null) {
            return null;
        }
        return new File(this.libraryPath);
    }

    protected void finalize() {
        dispose();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void disposeAll() {
        LinkedHashSet linkedHashSet;
        Map<String, Reference<NativeLibrary>> map = libraries;
        synchronized (map) {
            linkedHashSet = new LinkedHashSet(map.values());
        }
        Iterator it = linkedHashSet.iterator();
        while (it.hasNext()) {
            NativeLibrary nativeLibrary = (NativeLibrary) ((Reference) it.next()).get();
            if (nativeLibrary != null) {
                nativeLibrary.dispose();
            }
        }
    }

    public void dispose() {
        HashSet hashSet = new HashSet();
        Map<String, Reference<NativeLibrary>> map = libraries;
        synchronized (map) {
            for (Map.Entry<String, Reference<NativeLibrary>> entry : map.entrySet()) {
                if (entry.getValue().get() == this) {
                    hashSet.add(entry.getKey());
                }
            }
            Iterator it = hashSet.iterator();
            while (it.hasNext()) {
                libraries.remove((String) it.next());
            }
        }
        synchronized (this) {
            long j = this.handle;
            if (j != 0) {
                Native.close(j);
                this.handle = 0L;
            }
        }
    }

    private static List<String> initPaths(String str) {
        String property = System.getProperty(str, JsonProperty.USE_DEFAULT_NAME);
        if (JsonProperty.USE_DEFAULT_NAME.equals(property)) {
            return Collections.emptyList();
        }
        StringTokenizer stringTokenizer = new StringTokenizer(property, File.pathSeparator);
        ArrayList arrayList = new ArrayList();
        while (stringTokenizer.hasMoreTokens()) {
            String nextToken = stringTokenizer.nextToken();
            if (!JsonProperty.USE_DEFAULT_NAME.equals(nextToken)) {
                arrayList.add(nextToken);
            }
        }
        return arrayList;
    }

    private static String findLibraryPath(String str, Collection<String> collection) {
        if (new File(str).isAbsolute()) {
            return str;
        }
        String mapSharedLibraryName = mapSharedLibraryName(str);
        for (String str2 : collection) {
            File file = new File(str2, mapSharedLibraryName);
            if (file.exists()) {
                return file.getAbsolutePath();
            }
            if (Platform.isMac() && mapSharedLibraryName.endsWith(".dylib")) {
                File file2 = new File(str2, mapSharedLibraryName.substring(0, mapSharedLibraryName.lastIndexOf(".dylib")) + ".jnilib");
                if (file2.exists()) {
                    return file2.getAbsolutePath();
                }
            }
        }
        return mapSharedLibraryName;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String mapSharedLibraryName(String str) {
        if (Platform.isMac()) {
            if (str.startsWith("lib") && (str.endsWith(".dylib") || str.endsWith(".jnilib"))) {
                return str;
            }
            String mapLibraryName = System.mapLibraryName(str);
            return mapLibraryName.endsWith(".jnilib") ? mapLibraryName.substring(0, mapLibraryName.lastIndexOf(".jnilib")) + ".dylib" : mapLibraryName;
        }
        if (Platform.isLinux() || Platform.isFreeBSD()) {
            if (isVersionedName(str) || str.endsWith(".so")) {
                return str;
            }
        } else if (Platform.isAIX()) {
            if (str.startsWith("lib")) {
                return str;
            }
        } else if (Platform.isWindows() && (str.endsWith(".drv") || str.endsWith(".dll") || str.endsWith(".ocx"))) {
            return str;
        }
        return System.mapLibraryName(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean isVersionedName(String str) {
        int lastIndexOf;
        int i;
        if (!str.startsWith("lib") || (lastIndexOf = str.lastIndexOf(".so.")) == -1 || (i = lastIndexOf + 4) >= str.length()) {
            return false;
        }
        for (i = lastIndexOf + 4; i < str.length(); i++) {
            char charAt = str.charAt(i);
            if (!Character.isDigit(charAt) && charAt != '.') {
                return false;
            }
        }
        return true;
    }

    static String matchLibrary(final String str, Collection<String> collection) {
        File file = new File(str);
        if (file.isAbsolute()) {
            collection = Arrays.asList(file.getParent());
        }
        FilenameFilter filenameFilter = new FilenameFilter() { // from class: com.sun.jna.NativeLibrary.2
            @Override // java.io.FilenameFilter
            public boolean accept(File file2, String str2) {
                return (str2.startsWith(new StringBuilder("lib").append(str).append(".so").toString()) || (str2.startsWith(new StringBuilder().append(str).append(".so").toString()) && str.startsWith("lib"))) && NativeLibrary.isVersionedName(str2);
            }
        };
        LinkedList linkedList = new LinkedList();
        Iterator<String> it = collection.iterator();
        while (it.hasNext()) {
            File[] listFiles = new File(it.next()).listFiles(filenameFilter);
            if (listFiles != null && listFiles.length > 0) {
                linkedList.addAll(Arrays.asList(listFiles));
            }
        }
        Iterator it2 = linkedList.iterator();
        double d = -1.0d;
        String str2 = null;
        while (it2.hasNext()) {
            String absolutePath = ((File) it2.next()).getAbsolutePath();
            double parseVersion = parseVersion(absolutePath.substring(absolutePath.lastIndexOf(".so.") + 4));
            if (parseVersion > d) {
                str2 = absolutePath;
                d = parseVersion;
            }
        }
        return str2;
    }

    static double parseVersion(String str) {
        String str2;
        int indexOf = str.indexOf(".");
        double d = 1.0d;
        double d2 = 0.0d;
        while (str != null) {
            if (indexOf != -1) {
                String substring = str.substring(0, indexOf);
                String substring2 = str.substring(indexOf + 1);
                indexOf = substring2.indexOf(".");
                str2 = substring2;
                str = substring;
            } else {
                str2 = null;
            }
            try {
                d2 += Integer.parseInt(str) / d;
                d *= 100.0d;
                str = str2;
            } catch (NumberFormatException unused) {
                return Cue.INVALID_SEC;
            }
        }
        return d2;
    }

    private static String getMultiArchPath() {
        String str;
        String str2 = Platform.ARCH;
        if (Platform.iskFreeBSD()) {
            str = "-kfreebsd";
        } else {
            str = Platform.isGNU() ? JsonProperty.USE_DEFAULT_NAME : "-linux";
        }
        String str3 = "-gnu";
        if (Platform.isIntel()) {
            str2 = Platform.is64Bit() ? "x86_64" : "i386";
        } else if (Platform.isPPC()) {
            str2 = Platform.is64Bit() ? "powerpc64" : "powerpc";
        } else if (Platform.isARM()) {
            str2 = "arm";
            str3 = "-gnueabi";
        } else if (Platform.ARCH.equals("mips64el")) {
            str3 = "-gnuabi64";
        }
        return str2 + str + str3;
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x004a, code lost:
    
        if (r2 == null) goto L36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x006d, code lost:
    
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x004c, code lost:
    
        r2.waitFor();
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x006a, code lost:
    
        if (r2 == null) goto L36;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static java.util.ArrayList<java.lang.String> getLinuxLdPaths() {
        /*
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            r1 = 0
            java.lang.Runtime r2 = java.lang.Runtime.getRuntime()     // Catch: java.lang.Throwable -> L57 java.lang.Exception -> L64
            java.lang.String r3 = "/sbin/ldconfig -p"
            java.lang.Process r2 = r2.exec(r3)     // Catch: java.lang.Throwable -> L57 java.lang.Exception -> L64
            java.io.BufferedReader r3 = new java.io.BufferedReader     // Catch: java.lang.Throwable -> L55 java.lang.Exception -> L65
            java.io.InputStreamReader r4 = new java.io.InputStreamReader     // Catch: java.lang.Throwable -> L55 java.lang.Exception -> L65
            java.io.InputStream r5 = r2.getInputStream()     // Catch: java.lang.Throwable -> L55 java.lang.Exception -> L65
            r4.<init>(r5)     // Catch: java.lang.Throwable -> L55 java.lang.Exception -> L65
            r3.<init>(r4)     // Catch: java.lang.Throwable -> L55 java.lang.Exception -> L65
        L1e:
            java.lang.String r1 = r3.readLine()     // Catch: java.lang.Throwable -> L50 java.lang.Exception -> L53
            if (r1 == 0) goto L47
            java.lang.String r4 = " => "
            int r4 = r1.indexOf(r4)     // Catch: java.lang.Throwable -> L50 java.lang.Exception -> L53
            r5 = 47
            int r5 = r1.lastIndexOf(r5)     // Catch: java.lang.Throwable -> L50 java.lang.Exception -> L53
            r6 = -1
            if (r4 == r6) goto L1e
            if (r5 == r6) goto L1e
            if (r4 >= r5) goto L1e
            int r4 = r4 + 4
            java.lang.String r1 = r1.substring(r4, r5)     // Catch: java.lang.Throwable -> L50 java.lang.Exception -> L53
            boolean r4 = r0.contains(r1)     // Catch: java.lang.Throwable -> L50 java.lang.Exception -> L53
            if (r4 != 0) goto L1e
            r0.add(r1)     // Catch: java.lang.Throwable -> L50 java.lang.Exception -> L53
            goto L1e
        L47:
            r3.close()     // Catch: java.io.IOException -> L4a
        L4a:
            if (r2 == 0) goto L6d
        L4c:
            r2.waitFor()     // Catch: java.lang.InterruptedException -> L6d
            goto L6d
        L50:
            r0 = move-exception
            r1 = r3
            goto L59
        L53:
            r1 = r3
            goto L65
        L55:
            r0 = move-exception
            goto L59
        L57:
            r0 = move-exception
            r2 = r1
        L59:
            if (r1 == 0) goto L5e
            r1.close()     // Catch: java.io.IOException -> L5e
        L5e:
            if (r2 == 0) goto L63
            r2.waitFor()     // Catch: java.lang.InterruptedException -> L63
        L63:
            throw r0
        L64:
            r2 = r1
        L65:
            if (r1 == 0) goto L6a
            r1.close()     // Catch: java.io.IOException -> L6a
        L6a:
            if (r2 == 0) goto L6d
            goto L4c
        L6d:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sun.jna.NativeLibrary.getLinuxLdPaths():java.util.ArrayList");
    }
}
