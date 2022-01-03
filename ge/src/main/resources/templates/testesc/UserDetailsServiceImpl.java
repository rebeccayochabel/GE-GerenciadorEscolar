/* 
package br.com.gerenciadorescolar.ge.security;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import templates.testesc.domain.UserRepository;
import templates.testesc.domain.Usuario;

@Service("userDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService{

    @Autowired
    private UserRepository userRepository;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Usuario usuario = userRepository.findByUsername(username);
        if (usuario != null){
            SimpleGrantedAuthority authority = new SimpleGrantedAuthority(usuario.getRole());
            Set<GrantedAuthority> authorities = new HashSet<>();
            authorities.add(authority);

            User userSpring = new User(usuario.getUsername(), usuario.getPassword(), authorities);

            return userSpring; //user do spring
        }

        return null;
        
    }


    
}
*/
