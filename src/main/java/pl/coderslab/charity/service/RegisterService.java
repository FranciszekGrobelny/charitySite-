package pl.coderslab.charity.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.charity.dao.UserDao;
import pl.coderslab.charity.dto.user.RegisterUserDTO;
import pl.coderslab.charity.model.User;
import pl.coderslab.charity.repository.RoleRepository;

@Service
public class RegisterService {

    private final UserDao userDao;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    public RegisterService(UserDao userDao, RoleRepository roleRepository, PasswordEncoder passwordEncoder) {
        this.userDao = userDao;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Transactional
    public void saveUser(RegisterUserDTO registerUserDTO){

        User user = new User();
        user.setEnabled(1);
        user.setUsername(registerUserDTO.getEmail());
        user.getRoles().add(roleRepository.findByName("ROLE_USER"));
        user.setPassword(passwordEncoder.encode(registerUserDTO.getPassword()));

        userDao.saveUser(user);

    }

    @Transactional
    public void saveAdmin(RegisterUserDTO registerUserDTO){

        User user = new User();
        user.setEnabled(1);
        user.setUsername(registerUserDTO.getEmail());
        user.getRoles().add(roleRepository.findByName("ROLE_ADMIN"));
        user.setPassword(passwordEncoder.encode(registerUserDTO.getPassword()));

        userDao.saveUser(user);

    }
}
