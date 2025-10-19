package com.example.minnanonihongo_test_demo.service;

import com.example.minnanonihongo_test_demo.entity.User;
import com.example.minnanonihongo_test_demo.repository.UserRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    public CustomUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // 1. Tìm người dùng (User Entity) từ DB
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> 
                    new UsernameNotFoundException("Tên đăng nhập không tồn tại: " + username));
        
        // 2. Chuyển đổi Set<Role> thành Set<GrantedAuthority>
        Set<GrantedAuthority> authorities = user.getRoles().stream()
                // Tạo SimpleGrantedAuthority với tên vai trò (ví dụ: "ROLE_ADMIN")
                .map(role -> new SimpleGrantedAuthority(role.getName()))
                .collect(Collectors.toSet());

        // 3. Trả về đối tượng UserDetails (đối tượng User của Spring Security)
        return new org.springframework.security.core.userdetails.User(
                user.getUsername(),     // Tên đăng nhập
                user.getPassword(),     // Mật khẩu đã được mã hóa (BCrypt)
                user.isEnabled(),       // Trạng thái kích hoạt
                true,                   // isAccountNonExpired
                true,                   // isCredentialsNonExpired
                true,                   // isAccountNonLocked
                authorities             // Danh sách các vai trò đã chuyển đổi
        );
    }
}