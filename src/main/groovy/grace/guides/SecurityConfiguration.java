package grace.guides;

import org.apache.shiro.realm.Realm;
import org.apache.shiro.realm.text.PropertiesRealm;
import org.apache.shiro.spring.web.config.DefaultShiroFilterChainDefinition;
import org.apache.shiro.spring.web.config.ShiroFilterChainDefinition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SecurityConfiguration {

    @Bean
    public Realm realm() {
        return new PropertiesRealm();
    }

    @Bean
    public ShiroFilterChainDefinition shiroFilterChainDefinition() {
        DefaultShiroFilterChainDefinition chainDefinition = new DefaultShiroFilterChainDefinition();

        // logged in users with the 'ADMIN' role
        chainDefinition.addPathDefinition("/admin/**", "authc, roles[ADMIN]");

        // logged in users with the 'post:management' permission
        chainDefinition.addPathDefinition("/post/**", "authc, perms[post:management]");

        // all other paths require a logged in user
        chainDefinition.addPathDefinition("/", "anon");
        chainDefinition.addPathDefinition("/auth/index", "anon");

        return chainDefinition;
    }
}
