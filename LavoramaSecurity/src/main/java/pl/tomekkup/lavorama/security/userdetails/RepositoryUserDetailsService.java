package pl.tomekkup.lavorama.security.userdetails;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.tomekkup.lavorama.model.authentication.UserPrincipal;
import pl.tomekkup.lavorama.service.repositories.UserPrincipalRepository;

import java.util.Optional;

@Service
@Transactional
public class RepositoryUserDetailsService implements UserDetailsService {

    @Autowired
    private UserPrincipalRepository userPrincipalRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<UserPrincipal> optionalPrincipal = userPrincipalRepository.findByUsername(username);

        return optionalPrincipal.orElseThrow(() -> new UsernameNotFoundException("user not found"));
    }
}
