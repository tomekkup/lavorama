package pl.tomekkup.lavorama.security.ui;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;
import pl.tomekkup.lavorama.model.authentication.UserPrincipal;
import pl.tomekkup.lavorama.model.enums.UserAuthority;

import jakarta.annotation.PostConstruct;
import java.io.Serializable;

@Component
@SessionScope
public class UserPrincipalBean implements Serializable {

    private UserPrincipal principal;

    @PostConstruct
    protected void initialize() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        this.principal = (UserPrincipal) authentication.getPrincipal();
    }

    public String getFullName() {
        return this.principal.getFullName();
    }

    public String getUsername() {
        return this.principal.getUsername();
    }

    public String getAuthority() {
        return this.principal.getAuthority().name();
    }

    public boolean isIsAdmin() {
        return this.principal.getAuthorities().contains(UserAuthority.ADMIN);
    }
}
