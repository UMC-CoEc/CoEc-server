package com.umc.coec.config.auth;

import com.umc.coec.domain.user.User;
import com.umc.coec.domain.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class PrincipalDetailsService implements UserDetailsService {

      private Logger logger = LoggerFactory.getLogger(getClass());
      
      private final UserRepository userRepository;

      @Override
      public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
            User principal = userRepository
                        .findByEmail(email)
                        .orElseThrow(()->{
                              logger.info("해당 이메일을 사용하는 사용자가 존재하지 않음.");
                              return new UsernameNotFoundException("해당 이메일을 사용하는 사용자가 존재하지 않습니다.");
                        });
            return new PrincipalDetails(principal);
      }
}
