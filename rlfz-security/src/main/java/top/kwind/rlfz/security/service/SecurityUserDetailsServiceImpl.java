package top.kwind.rlfz.security.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import top.kwind.rlfz.rbac.mapper.PowerMapper;
import top.kwind.rlfz.rbac.mapper.UserMapper;
import top.kwind.rlfz.rbac.pojo.Power;
import top.kwind.rlfz.rbac.pojo.User;
import top.kwind.rlfz.rbac.service.RolePowerService;
import top.kwind.rlfz.security.domain.SecurityUserDetails;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author xagu
 */
@Component("securityUserDetailsService")
public class SecurityUserDetailsServiceImpl implements UserDetailsService {

    @Resource
    private UserMapper userMapper;

    @Resource
    private PowerMapper powerMapper;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {

        //拿用户
        User user = userMapper.loadUserByUsername(s);
        SecurityUserDetails securityUserDetails = new SecurityUserDetails();
        if (user != null) {
            List<Power> powers = powerMapper.selectPowerByUserId(user.getUserId());
            securityUserDetails.setEnable(user.getEnable());
            securityUserDetails.setPassword(user.getPassword());
            securityUserDetails.setUserId(user.getUserId());
            securityUserDetails.setEmail(user.getEmail());
            securityUserDetails.setRealName(user.getRealName());
            securityUserDetails.setUsername(user.getUsername());
            securityUserDetails.setRegTime(user.getRegTime());
            securityUserDetails.setDesc(user.getDesc());
            securityUserDetails.setHeadImg(user.getHeadImg());
            securityUserDetails.setSchoolName(user.getSchoolName());
            securityUserDetails.setPhoneNum(user.getPhoneNum());
            securityUserDetails.setPowers(powers);
        }
        return securityUserDetails;
    }
}
