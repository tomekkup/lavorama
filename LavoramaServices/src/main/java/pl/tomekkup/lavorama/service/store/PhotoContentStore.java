package pl.tomekkup.lavorama.service.store;

import org.springframework.content.commons.repository.ContentStore;
import org.springframework.content.rest.StoreRestResource;
import pl.tomekkup.lavorama.model.media.Photo;

import java.util.UUID;

@StoreRestResource(path = "datastore-photos")
public interface PhotoContentStore extends ContentStore<Photo, UUID> {

}
