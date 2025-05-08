package pl.tomekkup.lavorama.security.rememberme;

import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;

/**
 * Repozytorium które woła `create table if not exists`
 * Moze nie musi sie odpalac na H2
 */
public class JdbcTokenRepository extends JdbcTokenRepositoryImpl {

    @Override
    protected void initDao() {
        super.initDao();
        //getJdbcTemplate().execute("create table if not exists persistent_logins (username varchar(64) not null, series varchar(64) primary key, token varchar(64) not null, last_used timestamp not null)");
    }
}
