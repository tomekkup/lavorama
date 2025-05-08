package pl.tomekkup.lavorama.service.store.listener;

import org.apache.tika.Tika;
import org.springframework.content.commons.annotations.StoreEventHandler;
import org.springframework.content.commons.repository.events.AbstractStoreEventListener;
import org.springframework.content.commons.repository.events.AfterSetContentEvent;
import pl.tomekkup.lavorama.model.base.AbstractMediaEntity;

import java.io.IOException;
import java.io.InputStream;

@StoreEventHandler
public class TikaEventListener extends AbstractStoreEventListener {

    private final Tika tika = new Tika();

    @Override
    protected void onAfterSetContent(AfterSetContentEvent event) {
        /*
        AbstractMediaEntity result = (AbstractMediaEntity) event.getResult();
        InputStream inputStream = event.getStore().getContent(event.getSource());
        String mimeType = null;
        try {
            mimeType = tika.detect(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        result.setMimeType(mimeType);
            */
    }
}
