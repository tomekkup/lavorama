package pl.tomekkup.lavorama.service.domain;

import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class AuditorProvider implements AuditorAware<String> {

    private final static Optional<String> SYSTEM_AUDITOR = Optional.of("SYSTEM");

    @Override
    public Optional<String> getCurrentAuditor() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authentication == null || !authentication.isAuthenticated()
                ? SYSTEM_AUDITOR
                : Optional.of(authentication.getName());
    }
}
