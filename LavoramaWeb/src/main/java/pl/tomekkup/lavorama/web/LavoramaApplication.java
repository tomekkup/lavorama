package pl.tomekkup.lavorama.web;

import org.joinfaces.autoconfigure.jetty.JettyAutoConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.freemarker.FreeMarkerAutoConfiguration;
import org.springframework.boot.web.servlet.ServletContextInitializer;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;

import jakarta.servlet.ServletContext;

@EntityScan(
        basePackages = {
            "pl.tomekkup.lavorama.model"
        },
        basePackageClasses = {
            LavoramaApplication.class,
            Jsr310JpaConverters.class
        }
)
@SpringBootApplication(
        exclude = {
            JettyAutoConfiguration.class,
            FreeMarkerAutoConfiguration.class
        }, scanBasePackages = {
                "pl.tomekkup.lavorama"
        }
)
public class LavoramaApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(LavoramaApplication.class, args);
    }

    @Configuration
    static class ConfigureJSFContextParameters implements ServletContextInitializer {

        @Override
        public void onStartup(ServletContext servletContext) {
            servletContext.setInitParameter("facelets.DEVELOPMENT", "true");
        }
    }
}
