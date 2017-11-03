package com.tabel.data.bootcamp.serices;

import com.tabel.data.bootcamp.model.UserPrincipal;
import com.tabel.data.bootcamp.model.User;
import com.tabel.data.bootcamp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.*;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserServices implements UserDetailsService{

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(s);
        System.out.println(user.toString());
        if (user != null)
            return new UserPrincipal(user);
        else
            return new UserPrincipal(new User());
    }
}
