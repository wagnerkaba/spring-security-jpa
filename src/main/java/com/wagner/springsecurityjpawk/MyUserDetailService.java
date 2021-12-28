package com.wagner.springsecurityjpawk;

import com.wagner.springsecurityjpawk.models.MyUser;
import com.wagner.springsecurityjpawk.models.MyUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MyUserDetailService implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    // carrega os dados do usuário através do JPA e retorna uma instância de UserDetails
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Optional<MyUser> optionalMyUser = userRepository.findByUsername(username);

        //if user does not exists, it throws an exception
        optionalMyUser.orElseThrow(()-> new UsernameNotFoundException("Not found: " + username));

        // converte optionalMyUser em MyUserDetails
        MyUserDetails myUserDetails = optionalMyUser.map(MyUserDetails::new).get();

        return myUserDetails;

    }
}
