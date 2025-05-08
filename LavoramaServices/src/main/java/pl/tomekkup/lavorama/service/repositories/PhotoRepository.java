package pl.tomekkup.lavorama.service.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import pl.tomekkup.lavorama.model.media.Photo;

@RepositoryRestResource(path="photo", collectionResourceRel="photo")
public interface PhotoRepository extends JpaRepository<Photo, Long> {

    Iterable<Photo> findTop10ByOrderByCreatedDateDesc();
}
