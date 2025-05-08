package pl.tomekkup.lavorama.service.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.content.fs.config.EnableFilesystemStores;
import org.springframework.content.fs.config.FilesystemStoreConfigurer;
import org.springframework.content.fs.config.FilesystemStoreConverter;
import org.springframework.content.fs.io.FileSystemResourceLoader;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.util.FileSystemUtils;
import pl.tomekkup.lavorama.service.store.listener.TikaEventListener;

import java.io.File;
import java.util.UUID;

@Configuration
@EnableFilesystemStores("pl.tomekkup.lavorama.store")
public class ContentStoreConfiguration {

    @Bean("contentStoreDirectory")
    protected File getStoreFile(@Value("${lavorama.content-store.path}") String basePath) {
        final File file = new File(basePath);
        FileSystemUtils.deleteRecursively(file);
        file.mkdir();
        return file;
    }

    @Bean
    FileSystemResourceLoader fileSystemResourceLoader(@Autowired @Qualifier("contentStoreDirectory") File storeFile) {
        return new FileSystemResourceLoader(storeFile.getPath());
    }

    /**
     * nie zamieniaj na lambde bo nie rozpozna typu i nie wybootuje
     * @return
     */
    public Converter<UUID,String> converter() {
        return new FilesystemStoreConverter<UUID,String>() {

            @Override
            public String convert(UUID source) {
                return String.format("/%s", source.toString().replaceAll("-", File.pathSeparator));
            }
        };
    }

    @Bean
    public FilesystemStoreConfigurer configurer() {
        return registry -> registry.addConverter(converter());
    }

    //@Bean
    //public TikaEventListener tikaEventListener() {
    //    return new TikaEventListener();
    //}
}