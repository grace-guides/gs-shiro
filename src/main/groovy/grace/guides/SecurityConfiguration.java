package grace.guides;

import org.apache.shiro.event.EventBus;
import org.apache.shiro.event.support.DefaultEventBus;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.realm.text.PropertiesRealm;
import org.apache.shiro.session.mgt.SessionFactory;
import org.apache.shiro.session.mgt.SimpleSessionFactory;
import org.apache.shiro.spring.boot.autoconfigure.ShiroBeanAutoConfiguration;
import org.apache.shiro.spring.config.web.autoconfigure.ShiroWebAutoConfiguration;
import org.apache.shiro.spring.web.config.DefaultShiroFilterChainDefinition;
import org.apache.shiro.spring.web.config.ShiroFilterChainDefinition;
import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration(proxyBeanMethods = false)
@AutoConfigureBefore({ ShiroBeanAutoConfiguration.class, ShiroWebAutoConfiguration.class })
public class SecurityConfiguration {

    @Bean(name = "shiroEventBus")
    public EventBus eventBus() {
        return new DefaultEventBus();
    }

    @Bean(name = "shiroSessionFactory")
    public SessionFactory sessionFactory() {
        return new SimpleSessionFactory();
    }

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
        chainDefinition.addPathDefinition("/auth/login", "anon");
        chainDefinition.addPathDefinition("/auth/logout", "authc");

        return chainDefinition;
    }
}
