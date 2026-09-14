package org.apache.tika.renderer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.tika.io.TemporaryResources;
import org.apache.tika.metadata.TikaPagedText;

/* loaded from: classes.dex */
public class PageBasedRenderResults extends RenderResults {
    Map<Integer, List<RenderResult>> results;

    public PageBasedRenderResults(TemporaryResources temporaryResources) {
        super(temporaryResources);
        this.results = new HashMap();
    }

    @Override // org.apache.tika.renderer.RenderResults
    public void add(RenderResult renderResult) {
        Integer num = renderResult.getMetadata().getInt(TikaPagedText.PAGE_NUMBER);
        if (num != null) {
            List<RenderResult> list = this.results.get(num);
            if (list == null) {
                list = new ArrayList<>();
                this.results.put(num, list);
            }
            list.add(renderResult);
        }
        super.add(renderResult);
    }

    public List<RenderResult> getPage(int i) {
        return this.results.get(Integer.valueOf(i));
    }
}
