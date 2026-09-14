package com.sun.jna;

import com.sun.jna.Library;
import com.sun.jna.Structure;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public class CallbackReference extends WeakReference<Callback> {
    private static final Class<?> DLL_CALLBACK_CLASS;
    private static final Method PROXY_CALLBACK_METHOD;
    private static final Map<Callback, CallbackThreadInitializer> initializers;
    int callingConvention;
    Pointer cbstruct;
    Method method;
    CallbackProxy proxy;
    Pointer trampoline;
    static final Map<Callback, CallbackReference> callbackMap = new WeakHashMap();
    static final Map<Callback, CallbackReference> directCallbackMap = new WeakHashMap();
    static final Map<Pointer, Reference<Callback>[]> pointerCallbackMap = new WeakHashMap();
    static final Map<Object, Object> allocations = Collections.synchronizedMap(new WeakHashMap());
    private static final Map<CallbackReference, Reference<CallbackReference>> allocatedMemory = Collections.synchronizedMap(new WeakHashMap());

    static {
        try {
            PROXY_CALLBACK_METHOD = CallbackProxy.class.getMethod(Callback.METHOD_NAME, Object[].class);
            if (Platform.isWindows()) {
                try {
                    DLL_CALLBACK_CLASS = Class.forName("com.sun.jna.win32.DLLCallback");
                } catch (ClassNotFoundException e) {
                    throw new Error("Error loading DLLCallback class", e);
                }
            } else {
                DLL_CALLBACK_CLASS = null;
            }
            initializers = new WeakHashMap();
        } catch (Exception unused) {
            throw new Error("Error looking up CallbackProxy.callback() method");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static CallbackThreadInitializer setCallbackThreadInitializer(Callback callback, CallbackThreadInitializer callbackThreadInitializer) {
        Map<Callback, CallbackThreadInitializer> map = initializers;
        synchronized (map) {
            if (callbackThreadInitializer != null) {
                return map.put(callback, callbackThreadInitializer);
            }
            return map.remove(callback);
        }
    }

    /* loaded from: classes.dex */
    static class AttachOptions extends Structure {
        public static final List<String> FIELDS = createFieldsOrder("daemon", "detach", "name");
        public boolean daemon;
        public boolean detach;
        public String name;

        AttachOptions() {
            setStringEncoding("utf8");
        }

        @Override // com.sun.jna.Structure
        protected List<String> getFieldOrder() {
            return FIELDS;
        }
    }

    private static ThreadGroup initializeThread(Callback callback, AttachOptions attachOptions) {
        CallbackThreadInitializer callbackThreadInitializer;
        if (callback instanceof DefaultCallbackProxy) {
            callback = ((DefaultCallbackProxy) callback).getCallback();
        }
        Map<Callback, CallbackThreadInitializer> map = initializers;
        synchronized (map) {
            callbackThreadInitializer = map.get(callback);
        }
        if (callbackThreadInitializer == null) {
            return null;
        }
        ThreadGroup threadGroup = callbackThreadInitializer.getThreadGroup(callback);
        attachOptions.name = callbackThreadInitializer.getName(callback);
        attachOptions.daemon = callbackThreadInitializer.isDaemon(callback);
        attachOptions.detach = callbackThreadInitializer.detach(callback);
        attachOptions.write();
        return threadGroup;
    }

    public static Callback getCallback(Class<?> cls, Pointer pointer) {
        return getCallback(cls, pointer, false);
    }

    private static Callback getCallback(Class<?> cls, Pointer pointer, boolean z) {
        if (pointer == null) {
            return null;
        }
        if (!cls.isInterface()) {
            throw new IllegalArgumentException("Callback type must be an interface");
        }
        Map<Callback, CallbackReference> map = z ? directCallbackMap : callbackMap;
        Map<Pointer, Reference<Callback>[]> map2 = pointerCallbackMap;
        synchronized (map2) {
            Reference<Callback>[] referenceArr = map2.get(pointer);
            Callback typeAssignableCallback = getTypeAssignableCallback(cls, referenceArr);
            if (typeAssignableCallback != null) {
                return typeAssignableCallback;
            }
            Callback createCallback = createCallback(cls, pointer);
            map2.put(pointer, addCallbackToArray(createCallback, referenceArr));
            map.remove(createCallback);
            return createCallback;
        }
    }

    private static Callback getTypeAssignableCallback(Class<?> cls, Reference<Callback>[] referenceArr) {
        if (referenceArr == null) {
            return null;
        }
        for (Reference<Callback> reference : referenceArr) {
            Callback callback = reference.get();
            if (callback != null && cls.isAssignableFrom(callback.getClass())) {
                return callback;
            }
        }
        return null;
    }

    private static Reference<Callback>[] addCallbackToArray(Callback callback, Reference<Callback>[] referenceArr) {
        int i = 0;
        int i2 = 1;
        if (referenceArr != null) {
            for (int i3 = 0; i3 < referenceArr.length; i3++) {
                if (referenceArr[i3].get() == null) {
                    referenceArr[i3] = null;
                } else {
                    i2++;
                }
            }
        }
        Reference<Callback>[] referenceArr2 = new Reference[i2];
        if (referenceArr != null) {
            int i4 = 0;
            while (i < referenceArr.length) {
                Reference<Callback> reference = referenceArr[i];
                if (reference != null) {
                    referenceArr2[i4] = reference;
                    i4++;
                }
                i++;
            }
            i = i4;
        }
        referenceArr2[i] = new WeakReference(callback);
        return referenceArr2;
    }

    private static Callback createCallback(Class<?> cls, Pointer pointer) {
        int i = AltCallingConvention.class.isAssignableFrom(cls) ? 63 : 0;
        HashMap hashMap = new HashMap(Native.getLibraryOptions(cls));
        hashMap.put("invoking-method", getCallbackMethod(cls));
        return (Callback) Proxy.newProxyInstance(cls.getClassLoader(), new Class[]{cls}, new NativeFunctionHandler(pointer, i, hashMap));
    }

    private CallbackReference(Callback callback, int i, boolean z) {
        super(callback);
        long createNativeCallback;
        TypeMapper typeMapper = Native.getTypeMapper(callback.getClass());
        this.callingConvention = i;
        boolean isPPC = Platform.isPPC();
        int i2 = 0;
        if (z) {
            Method callbackMethod = getCallbackMethod(callback);
            Class<?>[] parameterTypes = callbackMethod.getParameterTypes();
            for (int i3 = 0; i3 < parameterTypes.length; i3++) {
                if ((isPPC && (parameterTypes[i3] == Float.TYPE || parameterTypes[i3] == Double.TYPE)) || (typeMapper != null && typeMapper.getFromNativeConverter(parameterTypes[i3]) != null)) {
                    z = false;
                    break;
                }
            }
            if (typeMapper != null && typeMapper.getToNativeConverter(callbackMethod.getReturnType()) != null) {
                z = false;
            }
        }
        String stringEncoding = Native.getStringEncoding(callback.getClass());
        if (z) {
            Method callbackMethod2 = getCallbackMethod(callback);
            this.method = callbackMethod2;
            Class<?>[] parameterTypes2 = callbackMethod2.getParameterTypes();
            Class<?> returnType = this.method.getReturnType();
            Class<?> cls = DLL_CALLBACK_CLASS;
            createNativeCallback = Native.createNativeCallback(callback, this.method, parameterTypes2, returnType, i, (cls == null || !cls.isInstance(callback)) ? 1 : 3, stringEncoding);
        } else {
            if (callback instanceof CallbackProxy) {
                this.proxy = (CallbackProxy) callback;
            } else {
                this.proxy = new DefaultCallbackProxy(getCallbackMethod(callback), typeMapper, stringEncoding);
            }
            Class<?>[] parameterTypes3 = this.proxy.getParameterTypes();
            Class<?> returnType2 = this.proxy.getReturnType();
            if (typeMapper != null) {
                for (int i4 = 0; i4 < parameterTypes3.length; i4++) {
                    FromNativeConverter fromNativeConverter = typeMapper.getFromNativeConverter(parameterTypes3[i4]);
                    if (fromNativeConverter != null) {
                        parameterTypes3[i4] = fromNativeConverter.nativeType();
                    }
                }
                ToNativeConverter toNativeConverter = typeMapper.getToNativeConverter(returnType2);
                if (toNativeConverter != null) {
                    returnType2 = toNativeConverter.nativeType();
                }
            }
            for (int i5 = 0; i5 < parameterTypes3.length; i5++) {
                Class<?> nativeType = getNativeType(parameterTypes3[i5]);
                parameterTypes3[i5] = nativeType;
                if (!isAllowableNativeType(nativeType)) {
                    throw new IllegalArgumentException("Callback argument " + parameterTypes3[i5] + " requires custom type conversion");
                }
            }
            Class<?> nativeType2 = getNativeType(returnType2);
            if (!isAllowableNativeType(nativeType2)) {
                throw new IllegalArgumentException("Callback return type " + nativeType2 + " requires custom type conversion");
            }
            Class<?> cls2 = DLL_CALLBACK_CLASS;
            if (cls2 != null && cls2.isInstance(callback)) {
                i2 = 2;
            }
            createNativeCallback = Native.createNativeCallback(this.proxy, PROXY_CALLBACK_METHOD, parameterTypes3, nativeType2, i, i2, stringEncoding);
        }
        this.cbstruct = createNativeCallback != 0 ? new Pointer(createNativeCallback) : null;
        allocatedMemory.put(this, new WeakReference(this));
    }

    private Class<?> getNativeType(Class<?> cls) {
        if (Structure.class.isAssignableFrom(cls)) {
            Structure.validate(cls);
            if (!Structure.ByValue.class.isAssignableFrom(cls)) {
                return Pointer.class;
            }
        } else {
            if (NativeMapped.class.isAssignableFrom(cls)) {
                return NativeMappedConverter.getInstance(cls).nativeType();
            }
            if (cls == String.class || cls == WString.class || cls == String[].class || cls == WString[].class || Callback.class.isAssignableFrom(cls)) {
                return Pointer.class;
            }
        }
        return cls;
    }

    private static Method checkMethod(Method method) {
        if (method.getParameterTypes().length <= 256) {
            return method;
        }
        throw new UnsupportedOperationException("Method signature exceeds the maximum parameter count: " + method);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Class<?> findCallbackClass(Class<?> cls) {
        if (!Callback.class.isAssignableFrom(cls)) {
            throw new IllegalArgumentException(cls.getName() + " is not derived from com.sun.jna.Callback");
        }
        if (!cls.isInterface()) {
            Class<?>[] interfaces = cls.getInterfaces();
            int i = 0;
            while (true) {
                if (i >= interfaces.length) {
                    break;
                }
                if (Callback.class.isAssignableFrom(interfaces[i])) {
                    try {
                        getCallbackMethod(interfaces[i]);
                        return interfaces[i];
                    } catch (IllegalArgumentException unused) {
                        return Callback.class.isAssignableFrom(cls.getSuperclass()) ? findCallbackClass(cls.getSuperclass()) : cls;
                    }
                }
                i++;
            }
        } else {
            return cls;
        }
    }

    private static Method getCallbackMethod(Callback callback) {
        return getCallbackMethod(findCallbackClass(callback.getClass()));
    }

    private static Method getCallbackMethod(Class<?> cls) {
        Method[] declaredMethods = cls.getDeclaredMethods();
        Method[] methods = cls.getMethods();
        HashSet hashSet = new HashSet(Arrays.asList(declaredMethods));
        hashSet.retainAll(Arrays.asList(methods));
        Iterator it = hashSet.iterator();
        while (it.hasNext()) {
            if (Callback.FORBIDDEN_NAMES.contains(((Method) it.next()).getName())) {
                it.remove();
            }
        }
        Method[] methodArr = (Method[]) hashSet.toArray(new Method[0]);
        if (methodArr.length == 1) {
            return checkMethod(methodArr[0]);
        }
        for (Method method : methodArr) {
            if (Callback.METHOD_NAME.equals(method.getName())) {
                return checkMethod(method);
            }
        }
        throw new IllegalArgumentException("Callback must implement a single public method, or one public method named 'callback'");
    }

    private void setCallbackOptions(int i) {
        this.cbstruct.setInt(Native.POINTER_SIZE, i);
    }

    public Pointer getTrampoline() {
        if (this.trampoline == null) {
            this.trampoline = this.cbstruct.getPointer(0L);
        }
        return this.trampoline;
    }

    protected void finalize() {
        dispose();
    }

    protected synchronized void dispose() {
        Pointer pointer = this.cbstruct;
        if (pointer != null) {
            try {
                Native.freeNativeCallback(pointer.peer);
                this.cbstruct.peer = 0L;
                this.cbstruct = null;
                allocatedMemory.remove(this);
            } catch (Throwable th) {
                this.cbstruct.peer = 0L;
                this.cbstruct = null;
                allocatedMemory.remove(this);
                throw th;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void disposeAll() {
        Iterator it = new LinkedList(allocatedMemory.keySet()).iterator();
        while (it.hasNext()) {
            ((CallbackReference) it.next()).dispose();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Callback getCallback() {
        return (Callback) get();
    }

    private static Pointer getNativeFunctionPointer(Callback callback) {
        if (!Proxy.isProxyClass(callback.getClass())) {
            return null;
        }
        InvocationHandler invocationHandler = Proxy.getInvocationHandler(callback);
        if (invocationHandler instanceof NativeFunctionHandler) {
            return ((NativeFunctionHandler) invocationHandler).getPointer();
        }
        return null;
    }

    public static Pointer getFunctionPointer(Callback callback) {
        return getFunctionPointer(callback, false);
    }

    private static Pointer getFunctionPointer(Callback callback, boolean z) {
        int intValue;
        Pointer trampoline;
        if (callback == null) {
            return null;
        }
        Pointer nativeFunctionPointer = getNativeFunctionPointer(callback);
        if (nativeFunctionPointer != null) {
            return nativeFunctionPointer;
        }
        Map<String, Object> libraryOptions = Native.getLibraryOptions(callback.getClass());
        if (callback instanceof AltCallingConvention) {
            intValue = 63;
        } else {
            intValue = (libraryOptions == null || !libraryOptions.containsKey(Library.OPTION_CALLING_CONVENTION)) ? 0 : ((Integer) libraryOptions.get(Library.OPTION_CALLING_CONVENTION)).intValue();
        }
        Map<Callback, CallbackReference> map = z ? directCallbackMap : callbackMap;
        Map<Pointer, Reference<Callback>[]> map2 = pointerCallbackMap;
        synchronized (map2) {
            CallbackReference callbackReference = map.get(callback);
            if (callbackReference == null) {
                callbackReference = new CallbackReference(callback, intValue, z);
                map.put(callback, callbackReference);
                map2.put(callbackReference.getTrampoline(), addCallbackToArray(callback, null));
                if (initializers.containsKey(callback)) {
                    callbackReference.setCallbackOptions(1);
                }
            }
            trampoline = callbackReference.getTrampoline();
        }
        return trampoline;
    }

    /* loaded from: classes.dex */
    private class DefaultCallbackProxy implements CallbackProxy {
        private final Method callbackMethod;
        private final String encoding;
        private final FromNativeConverter[] fromNative;
        private ToNativeConverter toNative;

        public DefaultCallbackProxy(Method method, TypeMapper typeMapper, String str) {
            this.callbackMethod = method;
            this.encoding = str;
            Class<?>[] parameterTypes = method.getParameterTypes();
            Class<?> returnType = method.getReturnType();
            this.fromNative = new FromNativeConverter[parameterTypes.length];
            if (NativeMapped.class.isAssignableFrom(returnType)) {
                this.toNative = NativeMappedConverter.getInstance(returnType);
            } else if (typeMapper != null) {
                this.toNative = typeMapper.getToNativeConverter(returnType);
            }
            for (int i = 0; i < this.fromNative.length; i++) {
                if (NativeMapped.class.isAssignableFrom(parameterTypes[i])) {
                    this.fromNative[i] = new NativeMappedConverter(parameterTypes[i]);
                } else if (typeMapper != null) {
                    this.fromNative[i] = typeMapper.getFromNativeConverter(parameterTypes[i]);
                }
            }
            if (method.isAccessible()) {
                return;
            }
            try {
                method.setAccessible(true);
            } catch (SecurityException unused) {
                throw new IllegalArgumentException("Callback method is inaccessible, make sure the interface is public: " + method);
            }
        }

        public Callback getCallback() {
            return CallbackReference.this.getCallback();
        }

        /* JADX WARN: Removed duplicated region for block: B:17:0x0065  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        private java.lang.Object invokeCallback(java.lang.Object[] r10) {
            /*
                r9 = this;
                java.lang.reflect.Method r0 = r9.callbackMethod
                java.lang.Class[] r0 = r0.getParameterTypes()
                int r1 = r10.length
                java.lang.Object[] r2 = new java.lang.Object[r1]
                r3 = 0
                r4 = r3
            Lb:
                int r5 = r10.length
                if (r4 >= r5) goto L33
                r5 = r0[r4]
                r6 = r10[r4]
                com.sun.jna.FromNativeConverter[] r7 = r9.fromNative
                r7 = r7[r4]
                if (r7 == 0) goto L2a
                com.sun.jna.CallbackParameterContext r7 = new com.sun.jna.CallbackParameterContext
                java.lang.reflect.Method r8 = r9.callbackMethod
                r7.<init>(r5, r8, r10, r4)
                com.sun.jna.FromNativeConverter[] r5 = r9.fromNative
                r5 = r5[r4]
                java.lang.Object r5 = r5.fromNative(r6, r7)
                r2[r4] = r5
                goto L30
            L2a:
                java.lang.Object r5 = r9.convertArgument(r6, r5)
                r2[r4] = r5
            L30:
                int r4 = r4 + 1
                goto Lb
            L33:
                com.sun.jna.Callback r10 = r9.getCallback()
                if (r10 == 0) goto L62
                java.lang.reflect.Method r0 = r9.callbackMethod     // Catch: java.lang.reflect.InvocationTargetException -> L44 java.lang.IllegalAccessException -> L51 java.lang.IllegalArgumentException -> L5a
                java.lang.Object r0 = r0.invoke(r10, r2)     // Catch: java.lang.reflect.InvocationTargetException -> L44 java.lang.IllegalAccessException -> L51 java.lang.IllegalArgumentException -> L5a
                java.lang.Object r10 = r9.convertResult(r0)     // Catch: java.lang.reflect.InvocationTargetException -> L44 java.lang.IllegalAccessException -> L51 java.lang.IllegalArgumentException -> L5a
                goto L63
            L44:
                r0 = move-exception
                com.sun.jna.Callback$UncaughtExceptionHandler r4 = com.sun.jna.Native.getCallbackExceptionHandler()
                java.lang.Throwable r0 = r0.getTargetException()
                r4.uncaughtException(r10, r0)
                goto L62
            L51:
                r0 = move-exception
                com.sun.jna.Callback$UncaughtExceptionHandler r4 = com.sun.jna.Native.getCallbackExceptionHandler()
                r4.uncaughtException(r10, r0)
                goto L62
            L5a:
                r0 = move-exception
                com.sun.jna.Callback$UncaughtExceptionHandler r4 = com.sun.jna.Native.getCallbackExceptionHandler()
                r4.uncaughtException(r10, r0)
            L62:
                r10 = 0
            L63:
                if (r3 >= r1) goto L77
                r0 = r2[r3]
                boolean r4 = r0 instanceof com.sun.jna.Structure
                if (r4 == 0) goto L74
                boolean r4 = r0 instanceof com.sun.jna.Structure.ByValue
                if (r4 != 0) goto L74
                com.sun.jna.Structure r0 = (com.sun.jna.Structure) r0
                r0.autoWrite()
            L74:
                int r3 = r3 + 1
                goto L63
            L77:
                return r10
            */
            throw new UnsupportedOperationException("Method not decompiled: com.sun.jna.CallbackReference.DefaultCallbackProxy.invokeCallback(java.lang.Object[]):java.lang.Object");
        }

        @Override // com.sun.jna.CallbackProxy
        public Object callback(Object[] objArr) {
            try {
                return invokeCallback(objArr);
            } catch (Throwable th) {
                Native.getCallbackExceptionHandler().uncaughtException(getCallback(), th);
                return null;
            }
        }

        private Object convertArgument(Object obj, Class<?> cls) {
            Object obj2;
            if (obj instanceof Pointer) {
                if (cls == String.class) {
                    return ((Pointer) obj).getString(0L, this.encoding);
                }
                if (cls == WString.class) {
                    obj2 = new WString(((Pointer) obj).getWideString(0L));
                } else {
                    if (cls == String[].class) {
                        return ((Pointer) obj).getStringArray(0L, this.encoding);
                    }
                    if (cls == WString[].class) {
                        return ((Pointer) obj).getWideStringArray(0L);
                    }
                    if (Callback.class.isAssignableFrom(cls)) {
                        return CallbackReference.getCallback(cls, (Pointer) obj);
                    }
                    if (!Structure.class.isAssignableFrom(cls)) {
                        return obj;
                    }
                    if (Structure.ByValue.class.isAssignableFrom(cls)) {
                        Structure newInstance = Structure.newInstance(cls);
                        int size = newInstance.size();
                        byte[] bArr = new byte[size];
                        ((Pointer) obj).read(0L, bArr, 0, size);
                        newInstance.getPointer().write(0L, bArr, 0, size);
                        newInstance.read();
                        obj2 = newInstance;
                    } else {
                        Structure newInstance2 = Structure.newInstance((Class<Structure>) cls, (Pointer) obj);
                        newInstance2.conditionalAutoRead();
                        return newInstance2;
                    }
                }
                return obj2;
            }
            if ((Boolean.TYPE == cls || Boolean.class == cls) && (obj instanceof Number)) {
                return Function.valueOf(((Number) obj).intValue() != 0);
            }
            return obj;
        }

        private Object convertResult(Object obj) {
            ToNativeConverter toNativeConverter = this.toNative;
            if (toNativeConverter != null) {
                obj = toNativeConverter.toNative(obj, new CallbackResultContext(this.callbackMethod));
            }
            if (obj == null) {
                return null;
            }
            Class<?> cls = obj.getClass();
            if (Structure.class.isAssignableFrom(cls)) {
                return Structure.ByValue.class.isAssignableFrom(cls) ? obj : ((Structure) obj).getPointer();
            }
            if (cls == Boolean.TYPE || cls == Boolean.class) {
                return Boolean.TRUE.equals(obj) ? Function.INTEGER_TRUE : Function.INTEGER_FALSE;
            }
            if (cls == String.class || cls == WString.class) {
                return CallbackReference.getNativeString(obj, cls == WString.class);
            }
            if (cls != String[].class && cls != WString[].class) {
                return Callback.class.isAssignableFrom(cls) ? CallbackReference.getFunctionPointer((Callback) obj) : obj;
            }
            StringArray stringArray = cls == String[].class ? new StringArray((String[]) obj, this.encoding) : new StringArray((WString[]) obj);
            CallbackReference.allocations.put(obj, stringArray);
            return stringArray;
        }

        @Override // com.sun.jna.CallbackProxy
        public Class<?>[] getParameterTypes() {
            return this.callbackMethod.getParameterTypes();
        }

        @Override // com.sun.jna.CallbackProxy
        public Class<?> getReturnType() {
            return this.callbackMethod.getReturnType();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class NativeFunctionHandler implements InvocationHandler {
        private final Function function;
        private final Map<String, ?> options;

        public NativeFunctionHandler(Pointer pointer, int i, Map<String, ?> map) {
            this.options = map;
            this.function = new Function(pointer, i, (String) map.get(Library.OPTION_STRING_ENCODING));
        }

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
            if (Library.Handler.OBJECT_TOSTRING.equals(method)) {
                return ("Proxy interface to " + this.function) + " (" + CallbackReference.findCallbackClass(((Method) this.options.get("invoking-method")).getDeclaringClass()).getName() + ")";
            }
            if (Library.Handler.OBJECT_HASHCODE.equals(method)) {
                return Integer.valueOf(hashCode());
            }
            if (Library.Handler.OBJECT_EQUALS.equals(method)) {
                Object obj2 = objArr[0];
                if (obj2 == null || !Proxy.isProxyClass(obj2.getClass())) {
                    return Boolean.FALSE;
                }
                return Function.valueOf(Proxy.getInvocationHandler(obj2) == this);
            }
            if (Function.isVarArgs(method)) {
                objArr = Function.concatenateVarArgs(objArr);
            }
            return this.function.invoke(method.getReturnType(), objArr, this.options);
        }

        public Pointer getPointer() {
            return this.function;
        }
    }

    private static boolean isAllowableNativeType(Class<?> cls) {
        return cls == Void.TYPE || cls == Void.class || cls == Boolean.TYPE || cls == Boolean.class || cls == Byte.TYPE || cls == Byte.class || cls == Short.TYPE || cls == Short.class || cls == Character.TYPE || cls == Character.class || cls == Integer.TYPE || cls == Integer.class || cls == Long.TYPE || cls == Long.class || cls == Float.TYPE || cls == Float.class || cls == Double.TYPE || cls == Double.class || (Structure.ByValue.class.isAssignableFrom(cls) && Structure.class.isAssignableFrom(cls)) || Pointer.class.isAssignableFrom(cls);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Pointer getNativeString(Object obj, boolean z) {
        if (obj == null) {
            return null;
        }
        NativeString nativeString = new NativeString(obj.toString(), z);
        allocations.put(obj, nativeString);
        return nativeString.getPointer();
    }
}
