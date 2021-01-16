package com.htne.helpthehomeless.configuration;

import com.htne.helpthehomeless.dal.dao.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class HTHUserDetailsService implements UserDetailsService {
    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(final String username) {
        return new HTHUserDetails(userRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException(username)));
    }
}