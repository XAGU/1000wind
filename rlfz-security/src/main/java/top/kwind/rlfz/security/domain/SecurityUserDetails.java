package top.kwind.rlfz.security.domain;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import top.kwind.rlfz.rbac.pojo.Power;
import top.kwind.rlfz.rbac.pojo.User;
import top.kwind.rlfz.rbac.vo.UserWithPower;

import java.util.Collection;
import java.util.List;

/**
 * 实现SpringSecurity类
 *
 * @author xagu
 */
public class SecurityUserDetails extends UserWithPower implements UserDetails {


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return super.getPassword();
    }

    @Override
    public String getUsername() {
        return super.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return super.getEnable() == 1;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return super.getEnable() == 1;
    }

}
