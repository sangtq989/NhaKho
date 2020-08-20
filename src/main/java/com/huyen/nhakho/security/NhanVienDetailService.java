package com.huyen.nhakho.security;

import com.huyen.nhakho.entity.NhanVien;
import com.huyen.nhakho.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class NhanVienDetailService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        NhanVien user = userRepository.getUserByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("Could not find user");
        }
        return new NhanVienDetail(user);
    }
}
