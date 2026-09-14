package org.apache.tika.renderer;

import java.io.InputStream;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import org.apache.tika.config.Initializable;
import org.apache.tika.config.InitializableProblemHandler;
import org.apache.tika.config.Param;
import org.apache.tika.config.ServiceLoader;
import org.apache.tika.exception.TikaException;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.metadata.TikaCoreProperties;
import org.apache.tika.mime.MediaType;
import org.apache.tika.parser.ParseContext;
import org.apache.tika.utils.ServiceLoaderUtils;

/* loaded from: classes.dex */
public class CompositeRenderer implements Renderer, Initializable {
    private Map<MediaType, Renderer> rendererMap;

    public CompositeRenderer(ServiceLoader serviceLoader) {
        this(getDefaultRenderers(serviceLoader));
    }

    private static List<Renderer> getDefaultRenderers(ServiceLoader serviceLoader) {
        List<Renderer> loadStaticServiceProviders = serviceLoader.loadStaticServiceProviders(Renderer.class);
        ServiceLoaderUtils.sortLoadedClasses(loadStaticServiceProviders);
        return loadStaticServiceProviders;
    }

    @Override // org.apache.tika.config.Initializable
    public void checkInitialization(InitializableProblemHandler initializableProblemHandler) {
    }

    public Renderer getLeafRenderer(MediaType mediaType) {
        return this.rendererMap.get(mediaType);
    }

    @Override // org.apache.tika.renderer.Renderer
    public Set<MediaType> getSupportedTypes(ParseContext parseContext) {
        return this.rendererMap.keySet();
    }

    @Override // org.apache.tika.config.Initializable
    public void initialize(Map<String, Param> map) {
    }

    @Override // org.apache.tika.renderer.Renderer
    public RenderResults render(InputStream inputStream, Metadata metadata, ParseContext parseContext, RenderRequest... renderRequestArr) {
        String str = metadata.get(TikaCoreProperties.TYPE);
        if (str != null) {
            MediaType parse = MediaType.parse(str);
            if (parse != null) {
                Renderer renderer = this.rendererMap.get(parse);
                if (renderer != null) {
                    return renderer.render(inputStream, metadata, parseContext, renderRequestArr);
                }
                throw new TikaException("I regret I can't find a renderer for " + parse);
            }
            throw new TikaException("can't parse mediaType: ".concat(str));
        }
        throw new TikaException("need to specify file type in metadata");
    }

    public CompositeRenderer(List<Renderer> list) {
        this.rendererMap = new HashMap();
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        ParseContext parseContext = new ParseContext();
        for (Renderer renderer : list) {
            Iterator<MediaType> it = renderer.getSupportedTypes(parseContext).iterator();
            while (it.hasNext()) {
                concurrentHashMap.put(it.next(), renderer);
            }
        }
        this.rendererMap = Collections.unmodifiableMap(concurrentHashMap);
    }
}
