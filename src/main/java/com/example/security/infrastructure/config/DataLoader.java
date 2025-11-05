package com.example.security.infrastructure.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.example.security.domain.entity.Role;
import com.example.security.domain.entity.RoleUser;
import com.example.security.domain.entity.User;
import com.example.security.domain.repository.RoleRepository;
import com.example.security.domain.repository.RoleUserRepository;
import com.example.security.domain.repository.UserRepository;

@Component
public class DataLoader implements CommandLineRunner {

    private final RoleRepository roleRepository;
    private final UserRepository userRepository;
    private final RoleUserRepository roleUserRepository;
    private final PasswordEncoder passwordEncoder;

    public DataLoader(RoleRepository roleRepository, UserRepository userRepository,
                     RoleUserRepository roleUserRepository, PasswordEncoder passwordEncoder) {
        this.roleRepository = roleRepository;
        this.userRepository = userRepository;
        this.roleUserRepository = roleUserRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void run(String... args) throws Exception {
        // Crear rol Admin si no existe
        if (roleRepository.findByName("Admin").isEmpty()) {
            Role adminRole = new Role();
            adminRole.setName("Admin");
            adminRole.setDescription("Administrator role with full access");
            roleRepository.save(adminRole);

            // Crear usuario admin por defecto
            if (userRepository.findByEmail("admin@example.com").isEmpty()) {
                User adminUser = new User();
                adminUser.setEmail("admin@example.com");
                adminUser.setPassword(passwordEncoder.encode("admin123"));
                adminUser.setActive(true);
                userRepository.save(adminUser);

                // Asignar rol Admin al usuario
                RoleUser roleUser = new RoleUser();
                roleUser.setUser(adminUser);
                roleUser.setRole(adminRole);
                roleUserRepository.save(roleUser);
            }
        }
    }
}
