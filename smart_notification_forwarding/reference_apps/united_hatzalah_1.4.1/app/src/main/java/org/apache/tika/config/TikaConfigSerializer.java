package org.apache.tika.config;

import F0.AbstractC0008a;
import io.flutter.plugins.firebase.crashlytics.Constants;
import java.io.Writer;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.nio.charset.Charset;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.xml.transform.Transformer;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import n3.b;
import n3.d;
import org.apache.tika.detect.CompositeDetector;
import org.apache.tika.detect.CompositeEncodingDetector;
import org.apache.tika.detect.DefaultDetector;
import org.apache.tika.detect.DefaultEncodingDetector;
import org.apache.tika.detect.Detector;
import org.apache.tika.detect.EncodingDetector;
import org.apache.tika.language.translate.DefaultTranslator;
import org.apache.tika.language.translate.Translator;
import org.apache.tika.mime.MediaType;
import org.apache.tika.parser.CompositeParser;
import org.apache.tika.parser.DefaultParser;
import org.apache.tika.parser.ParseContext;
import org.apache.tika.parser.Parser;
import org.apache.tika.parser.ParserDecorator;
import org.apache.tika.parser.external.ExternalParsersConfigReaderMetKeys;
import org.apache.tika.parser.multiple.AbstractMultipleParser;
import org.apache.tika.utils.StringUtils;
import org.apache.tika.utils.XMLReaderUtils;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

/* loaded from: classes.dex */
public class TikaConfigSerializer {
    private static final b LOG = d.b(TikaConfigSerializer.class);
    private static Map<Class, String> PRIMITIVES;

    /* loaded from: classes.dex */
    public static class MethodTuple {
        Method method;
        String name;
        Class singleParam;

        public MethodTuple(String str, Method method, Class cls) {
            this.name = str;
            this.method = method;
            this.singleParam = cls;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null && getClass() == obj.getClass()) {
                MethodTuple methodTuple = (MethodTuple) obj;
                if (this.name.equals(methodTuple.name) && this.method.equals(methodTuple.method) && this.singleParam.equals(methodTuple.singleParam)) {
                    return true;
                }
            }
            return false;
        }

        public int hashCode() {
            return Objects.hash(this.name, this.method, this.singleParam);
        }
    }

    /* loaded from: classes.dex */
    public static class MethodTuples {
        Map<String, Set<MethodTuple>> tuples;

        public /* synthetic */ MethodTuples(int i) {
            this();
        }

        public void add(MethodTuple methodTuple) {
            Set<MethodTuple> set = this.tuples.get(methodTuple.name);
            if (set == null) {
                set = new HashSet<>();
                this.tuples.put(methodTuple.name, set);
            }
            set.add(methodTuple);
        }

        public int getSize() {
            return this.tuples.size();
        }

        private MethodTuples() {
            this.tuples = new TreeMap();
        }
    }

    /* loaded from: classes.dex */
    public enum Mode {
        MINIMAL,
        CURRENT,
        STATIC,
        STATIC_FULL
    }

    static {
        HashMap hashMap = new HashMap();
        PRIMITIVES = hashMap;
        hashMap.put(Integer.class, "int");
        PRIMITIVES.put(Integer.TYPE, "int");
        PRIMITIVES.put(String.class, "string");
        PRIMITIVES.put(Boolean.class, "bool");
        PRIMITIVES.put(Boolean.TYPE, "bool");
        PRIMITIVES.put(Float.class, "float");
        PRIMITIVES.put(Float.TYPE, "float");
        PRIMITIVES.put(Double.class, "double");
        PRIMITIVES.put(Double.TYPE, "double");
        PRIMITIVES.put(Long.class, "long");
        PRIMITIVES.put(Long.TYPE, "long");
        PRIMITIVES.put(Map.class, "map");
        PRIMITIVES.put(List.class, "list");
    }

    private static void addDetectors(Mode mode, Element element, Document document, TikaConfig tikaConfig) {
        Detector detector = tikaConfig.getDetector();
        if (mode == Mode.MINIMAL && (detector instanceof DefaultDetector)) {
            element.appendChild(document.createComment("for example: <detectors><detector class=\"org.apache.tika.detector.MimeTypes\"></detectors>"));
            return;
        }
        Element createElement = document.createElement("detectors");
        if ((mode == Mode.CURRENT && (detector instanceof DefaultDetector)) || !(detector instanceof CompositeDetector)) {
            Element createElement2 = document.createElement("detector");
            createElement2.setAttribute(Constants.CLASS, detector.getClass().getCanonicalName());
            createElement.appendChild(createElement2);
        } else {
            for (Detector detector2 : ((CompositeDetector) detector).getDetectors()) {
                Element createElement3 = document.createElement("detector");
                createElement3.setAttribute(Constants.CLASS, detector2.getClass().getCanonicalName());
                serializeParams(document, createElement3, detector2);
                createElement.appendChild(createElement3);
            }
        }
        element.appendChild(createElement);
    }

    private static void addEncodingDetectors(Mode mode, Element element, Document document, TikaConfig tikaConfig) {
        EncodingDetector encodingDetector = tikaConfig.getEncodingDetector();
        if (mode == Mode.MINIMAL && (encodingDetector instanceof DefaultEncodingDetector)) {
            element.appendChild(document.createComment("for example: <encodingDetectors><encodingDetector class=\"org.apache.tika.detect.DefaultEncodingDetector\"></encodingDetectors>"));
            return;
        }
        Element createElement = document.createElement("encodingDetectors");
        if ((mode == Mode.CURRENT && (encodingDetector instanceof DefaultEncodingDetector)) || !(encodingDetector instanceof CompositeEncodingDetector)) {
            Element createElement2 = document.createElement("encodingDetector");
            createElement2.setAttribute(Constants.CLASS, encodingDetector.getClass().getCanonicalName());
            createElement.appendChild(createElement2);
        } else {
            for (EncodingDetector encodingDetector2 : ((CompositeEncodingDetector) encodingDetector).getDetectors()) {
                Element createElement3 = document.createElement("encodingDetector");
                createElement3.setAttribute(Constants.CLASS, encodingDetector2.getClass().getCanonicalName());
                serializeParams(document, createElement3, encodingDetector2);
                createElement.appendChild(createElement3);
            }
        }
        element.appendChild(createElement);
    }

    private static void addExecutorService(Mode mode, Element element, Document document, TikaConfig tikaConfig) {
        tikaConfig.getExecutorService();
    }

    private static void addList(Element element, Document document, MethodTuple methodTuple, List<String> list) {
        for (String str : list) {
            Element createElement = document.createElement("string");
            createElement.setTextContent(str);
            element.appendChild(createElement);
        }
    }

    private static void addMap(Element element, Document document, MethodTuple methodTuple, Map<String, String> map) {
        for (Map.Entry entry : new TreeMap(map).entrySet()) {
            Element createElement = document.createElement("string");
            createElement.setAttribute("key", (String) entry.getKey());
            createElement.setAttribute("value", (String) entry.getValue());
            element.appendChild(createElement);
        }
    }

    private static void addMimeComment(Mode mode, Element element, Document document) {
        element.appendChild(document.createComment("for example: <mimeTypeRepository resource=\"/org/apache/tika/mime/tika-mimetypes.xml\"/>"));
    }

    private static void addParser(Mode mode, Element element, Document document, Parser parser) {
        ParserDecorator parserDecorator;
        if ((parser instanceof ParserDecorator) && parser.getClass().getName().startsWith(ParserDecorator.class.getName().concat("$"))) {
            ParserDecorator parserDecorator2 = (ParserDecorator) parser;
            parserDecorator = parserDecorator2;
            parser = parserDecorator2.getWrappedParser();
        } else {
            parserDecorator = null;
        }
        List<Parser> list = Collections.EMPTY_LIST;
        boolean z3 = true;
        if (mode != Mode.CURRENT || !(parser instanceof DefaultParser)) {
            if (parser instanceof CompositeParser) {
                list = ((CompositeParser) parser).getAllComponentParsers();
                z3 = true ^ parser.getClass().equals(CompositeParser.class);
                if ((parser instanceof DefaultParser) && (mode == Mode.STATIC || mode == Mode.STATIC_FULL)) {
                    z3 = false;
                }
            } else if (parser instanceof AbstractMultipleParser) {
                list = ((AbstractMultipleParser) parser).getAllParsers();
            }
        }
        if (z3) {
            element = addParser(mode, element, document, parser, parserDecorator);
        }
        Iterator<Parser> it = list.iterator();
        while (it.hasNext()) {
            addParser(mode, element, document, it.next());
        }
    }

    private static void addParsers(Mode mode, Element element, Document document, TikaConfig tikaConfig) {
        Parser parser = tikaConfig.getParser();
        Mode mode2 = Mode.MINIMAL;
        if (mode == mode2 && (parser instanceof DefaultParser)) {
            return;
        }
        if (mode == mode2) {
            mode = Mode.CURRENT;
        }
        Element createElement = document.createElement("parsers");
        element.appendChild(createElement);
        addParser(mode, createElement, document, parser);
    }

    private static void addServiceLoader(Mode mode, Element element, Document document, TikaConfig tikaConfig) {
        ServiceLoader serviceLoader = tikaConfig.getServiceLoader();
        if (mode == Mode.MINIMAL && serviceLoader.isDynamic() && serviceLoader.getLoadErrorHandler() == LoadErrorHandler.IGNORE) {
            return;
        }
        Element createElement = document.createElement("service-loader");
        createElement.setAttribute("dynamic", Boolean.toString(serviceLoader.isDynamic()));
        createElement.setAttribute("loadErrorHandler", serviceLoader.getLoadErrorHandler().toString());
        element.appendChild(createElement);
    }

    private static void addTranslator(Mode mode, Element element, Document document, TikaConfig tikaConfig) {
        Translator translator = tikaConfig.getTranslator();
        if (mode == Mode.MINIMAL && (translator instanceof DefaultTranslator)) {
            element.appendChild(document.createComment("for example: <translator class=\"org.apache.tika.language.translate.GoogleTranslator\"/>"));
            return;
        }
        if ((translator instanceof DefaultTranslator) && (mode == Mode.STATIC || mode == Mode.STATIC_FULL)) {
            translator = ((DefaultTranslator) translator).getTranslator();
        }
        if (translator != null) {
            Element createElement = document.createElement("translator");
            createElement.setAttribute(Constants.CLASS, translator.getClass().getCanonicalName());
            element.appendChild(createElement);
            return;
        }
        element.appendChild(document.createComment("No translators available"));
    }

    private static Method findGetter(MethodTuple methodTuple, Object obj) {
        Matcher matcher = Pattern.compile("\\A(?:get|is)([A-Z].+)\\Z").matcher("");
        for (Method method : obj.getClass().getMethods()) {
            if (obj.getClass().getName().contains("PDF")) {
                System.out.println(method.getName());
            }
            if (matcher.reset(method.getName()).find()) {
                if (obj.getClass().getName().contains("PDF")) {
                    System.out.println("2: " + method.getName());
                }
                if (methodTuple.name.equals(matcher.group(1))) {
                    if (methodTuple.singleParam.equals(method.getReturnType())) {
                        return method;
                    }
                } else {
                    continue;
                }
            }
        }
        return null;
    }

    private static String methodToParamName(String str) {
        if (StringUtils.isBlank(str)) {
            return str;
        }
        return AbstractC0008a.n(str.substring(0, 1).toLowerCase(Locale.US), str.substring(1));
    }

    private static MethodTuple pickBestSetter(Set<MethodTuple> set) {
        Iterator<MethodTuple> it = set.iterator();
        if (it.hasNext()) {
            return it.next();
        }
        return null;
    }

    private static void processNonPrimitive(String str, Set<MethodTuple> set, Set<MethodTuple> set2, Document document, Element element, Object obj) {
        for (MethodTuple methodTuple : set) {
            for (MethodTuple methodTuple2 : set2) {
                if (methodTuple.singleParam.equals(methodTuple2.singleParam)) {
                    serializeObject(str, document, element, methodTuple, methodTuple2, obj);
                    return;
                }
            }
        }
    }

    public static void serialize(TikaConfig tikaConfig, Mode mode, Writer writer, Charset charset) {
        Document newDocument = XMLReaderUtils.getDocumentBuilder().newDocument();
        Element createElement = newDocument.createElement("properties");
        newDocument.appendChild(createElement);
        addMimeComment(mode, createElement, newDocument);
        addServiceLoader(mode, createElement, newDocument, tikaConfig);
        addExecutorService(mode, createElement, newDocument, tikaConfig);
        addEncodingDetectors(mode, createElement, newDocument, tikaConfig);
        addTranslator(mode, createElement, newDocument, tikaConfig);
        addDetectors(mode, createElement, newDocument, tikaConfig);
        addParsers(mode, createElement, newDocument, tikaConfig);
        Transformer transformer = XMLReaderUtils.getTransformer();
        transformer.setOutputProperty("indent", "yes");
        transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
        transformer.setOutputProperty("encoding", charset.name());
        transformer.transform(new DOMSource(newDocument), new StreamResult(writer));
    }

    private static void serializeNonPrimitives(Document document, Element element, Object obj, MethodTuples methodTuples, MethodTuples methodTuples2) {
        for (Map.Entry<String, Set<MethodTuple>> entry : methodTuples.tuples.entrySet()) {
            Document document2 = document;
            Element element2 = element;
            Object obj2 = obj;
            processNonPrimitive(entry.getKey(), entry.getValue(), methodTuples2.tuples.get(entry.getKey()), document2, element2, obj2);
            if (!methodTuples2.tuples.containsKey(entry.getKey())) {
                LOG.r(entry.getKey(), "no getter for setter non-primitive: {} in {}", obj2.getClass());
            }
            document = document2;
            element = element2;
            obj = obj2;
        }
    }

    private static void serializeObject(String str, Document document, Element element, MethodTuple methodTuple, MethodTuple methodTuple2, Object obj) {
        try {
            Object invoke = methodTuple2.method.invoke(obj, null);
            if (invoke == null) {
                LOG.r(methodTuple2.name, "Getter {} on {} returned null", obj.getClass());
            }
            Element createElement = document.createElement(str);
            createElement.setAttribute(Constants.CLASS, invoke.getClass().getCanonicalName());
            element.appendChild(createElement);
            serializeParams(document, element, invoke);
        } catch (IllegalAccessException | InvocationTargetException e4) {
            LOG.p("couldn't get " + str + " on " + obj.getClass(), e4);
        }
    }

    public static void serializeParams(Document document, Element element, Object obj) {
        Method[] methodArr;
        Matcher matcher = Pattern.compile("\\Aset([A-Z].*)").matcher("");
        Matcher matcher2 = Pattern.compile("\\A(?:get|is)([A-Z].+)\\Z").matcher("");
        int i = 0;
        MethodTuples methodTuples = new MethodTuples(i);
        MethodTuples methodTuples2 = new MethodTuples(i);
        MethodTuples methodTuples3 = new MethodTuples(i);
        MethodTuples methodTuples4 = new MethodTuples(i);
        Method[] methods = obj.getClass().getMethods();
        int length = methods.length;
        int i3 = 0;
        while (i3 < length) {
            Method method = methods[i3];
            Class<?>[] parameterTypes = method.getParameterTypes();
            int i4 = i;
            if (matcher.reset(method.getName()).find()) {
                if (!Modifier.isPublic(method.getModifiers())) {
                    LOG.m("inaccessible setter: {} in {}", method.getName(), obj.getClass());
                } else if (method.getAnnotation(Field.class) != null) {
                    if (parameterTypes.length != 1) {
                        methodArr = methods;
                        LOG.u("setter with wrong number of params " + method.getName() + StringUtils.SPACE + parameterTypes.length);
                    } else {
                        methodArr = methods;
                        String methodToParamName = methodToParamName(matcher.group(1));
                        if (PRIMITIVES.containsKey(parameterTypes[i4])) {
                            methodTuples2.add(new MethodTuple(methodToParamName, method, parameterTypes[i4]));
                        } else {
                            methodTuples.add(new MethodTuple(methodToParamName, method, parameterTypes[i4]));
                        }
                    }
                }
                methodArr = methods;
            } else {
                methodArr = methods;
                if (matcher2.reset(method.getName()).find() && parameterTypes.length == 0) {
                    String methodToParamName2 = methodToParamName(matcher2.group(1));
                    if (PRIMITIVES.containsKey(method.getReturnType())) {
                        methodTuples4.add(new MethodTuple(methodToParamName2, method, method.getReturnType()));
                    } else {
                        methodTuples3.add(new MethodTuple(methodToParamName2, method, method.getReturnType()));
                    }
                }
            }
            i3++;
            i = i4;
            methods = methodArr;
        }
        serializePrimitives(document, element, obj, methodTuples2, methodTuples4);
        serializeNonPrimitives(document, element, obj, methodTuples, methodTuples3);
    }

    private static void serializePrimitives(Document document, Element element, Object obj, MethodTuples methodTuples, MethodTuples methodTuples2) {
        Element element2;
        String obj2;
        Map.Entry<String, Set<MethodTuple>> entry;
        if (obj instanceof AbstractMultipleParser) {
            element2 = document.createElement("params");
            Element createElement = document.createElement("param");
            createElement.setAttribute("name", "metadataPolicy");
            createElement.setAttribute("value", ((AbstractMultipleParser) obj).getMetadataPolicy().toString());
            element2.appendChild(createElement);
            element.appendChild(element2);
        } else {
            element2 = null;
        }
        Iterator<Map.Entry<String, Set<MethodTuple>>> it = methodTuples.tuples.entrySet().iterator();
        Element element3 = element2;
        while (it.hasNext()) {
            Map.Entry<String, Set<MethodTuple>> next = it.next();
            if (!methodTuples2.tuples.containsKey(next.getKey())) {
                LOG.A("no getter for setter: {} in {}", next.getKey(), obj.getClass());
            } else {
                Set<MethodTuple> set = methodTuples2.tuples.get(next.getKey());
                Set<MethodTuple> value = next.getValue();
                MethodTuple methodTuple = null;
                for (MethodTuple methodTuple2 : set) {
                    Iterator<MethodTuple> it2 = value.iterator();
                    while (true) {
                        if (it2.hasNext()) {
                            entry = next;
                            if (methodTuple2.singleParam.equals(it2.next().singleParam)) {
                                methodTuple = methodTuple2;
                                break;
                            }
                            next = entry;
                        } else {
                            entry = next;
                            break;
                        }
                    }
                    next = entry;
                }
                Map.Entry<String, Set<MethodTuple>> entry2 = next;
                if (methodTuple == null) {
                    LOG.x(entry2.getKey(), "Could not find getter to match setter for: {}");
                } else {
                    try {
                        Object invoke = methodTuple.method.invoke(obj, null);
                        if (invoke == null) {
                            LOG.y(methodTuple.name, "null value: {} in {}", obj.getClass());
                        }
                        if (invoke == null) {
                            obj2 = "";
                        } else {
                            obj2 = invoke.toString();
                        }
                        Element createElement2 = document.createElement("param");
                        createElement2.setAttribute("name", methodTuple.name);
                        createElement2.setAttribute("type", PRIMITIVES.get(methodTuple.singleParam));
                        if (List.class.isAssignableFrom(methodTuple.singleParam)) {
                            addList(createElement2, document, methodTuple, (List) invoke);
                        } else if (Map.class.isAssignableFrom(methodTuple.singleParam)) {
                            addMap(createElement2, document, methodTuple, (Map) invoke);
                        } else {
                            createElement2.setTextContent(obj2);
                        }
                        if (element3 == null) {
                            Element createElement3 = document.createElement("params");
                            element.appendChild(createElement3);
                            element3 = createElement3;
                        }
                        element3.appendChild(createElement2);
                    } catch (IllegalAccessException e4) {
                        LOG.e("couldn't invoke " + methodTuple, e4);
                    } catch (InvocationTargetException e5) {
                        LOG.e("couldn't invoke " + methodTuple, e5);
                    }
                }
            }
        }
    }

    private static Element addParser(Mode mode, Element element, Document document, Parser parser, ParserDecorator parserDecorator) {
        ParseContext parseContext = new ParseContext();
        TreeSet treeSet = new TreeSet();
        TreeSet treeSet2 = new TreeSet();
        if (parserDecorator != null) {
            TreeSet treeSet3 = new TreeSet(parserDecorator.getSupportedTypes(parseContext));
            treeSet.addAll(treeSet3);
            for (MediaType mediaType : parser.getSupportedTypes(parseContext)) {
                if (!treeSet3.contains(mediaType)) {
                    treeSet2.add(mediaType);
                }
                treeSet.remove(mediaType);
            }
        } else if (mode == Mode.STATIC_FULL) {
            treeSet.addAll(parser.getSupportedTypes(parseContext));
        }
        String canonicalName = parser.getClass().getCanonicalName();
        Element createElement = document.createElement(ExternalParsersConfigReaderMetKeys.PARSER_TAG);
        createElement.setAttribute(Constants.CLASS, canonicalName);
        element.appendChild(createElement);
        serializeParams(document, createElement, parser);
        Iterator it = treeSet.iterator();
        while (it.hasNext()) {
            MediaType mediaType2 = (MediaType) it.next();
            Element createElement2 = document.createElement("mime");
            createElement2.appendChild(document.createTextNode(mediaType2.toString()));
            createElement.appendChild(createElement2);
        }
        Iterator it2 = treeSet2.iterator();
        while (it2.hasNext()) {
            MediaType mediaType3 = (MediaType) it2.next();
            Element createElement3 = document.createElement("mime-exclude");
            createElement3.appendChild(document.createTextNode(mediaType3.toString()));
            createElement.appendChild(createElement3);
        }
        return createElement;
    }
}
