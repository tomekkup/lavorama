package pl.tomekkup.lavorama.web.controllers;

import jakarta.faces.model.SelectItem;
import org.springframework.stereotype.Component;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lombok.Getter;
import lombok.Setter;
import pl.tomekkup.lavorama.service.repositories.UserPrincipalRepository;
import pl.tomekkup.lavorama.model.authentication.UserPrincipal;
import pl.tomekkup.lavorama.model.enums.UserAuthority;

/**
 *
 * @author tomek
 */
@Component
@ViewScoped
public class PrincipalListBean implements Serializable {
    
    @Inject
    private UserPrincipalRepository principalsRepository;
 
    @Getter @Setter
    private UserPrincipal selection;
    
    @Getter(lazy = true)
    private final List<SelectItem> authoritiesSI = initAuthoritiesSI();
    
    public Iterable<UserPrincipal> getPrincipals() {
        return principalsRepository.findAll();
    }
    
    public void onRowEdit() {
        
    }

    private List<SelectItem> initAuthoritiesSI() {
        return Arrays.stream(UserAuthority.values())
                .map(a -> new SelectItem(a.name(), a.name()))
                .collect(Collectors.toList());
    }
    
}