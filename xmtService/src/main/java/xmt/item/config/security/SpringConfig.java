package xmt.item.config.security;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.csrf.CsrfTokenRepository;
import org.springframework.security.web.csrf.HttpSessionCsrfTokenRepository;

@EnableWebSecurity
public class SpringConfig extends WebSecurityConfigurerAdapter {
    //get方法放行 post验证
    @Override
    protected void configure(HttpSecurity http) throws Exception {
//        http.formLogin().and().
//                authorizeRequests().antMatchers("/admin/login").permitAll()
//                .anyRequest().authenticated();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.inMemoryAuthentication().passwordEncoder(new BCryptPasswordEncoder())
//                .withUser("123456").password(new BCryptPasswordEncoder().encode("123456")).roles("Admin").and()
//                .withUser("yangruiying").password(new BCryptPasswordEncoder().encode("123")).roles("USER");

    }
}
