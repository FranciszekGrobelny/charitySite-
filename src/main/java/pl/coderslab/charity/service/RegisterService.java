package pl.coderslab.charity.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.charity.dao.UserDao;
import pl.coderslab.charity.dto.user.RegisterUserDTO;
import pl.coderslab.charity.model.User;

@Service
public class RegisterService {

    private final UserDao userDao;

    public RegisterService(UserDao userDao) {
        this.userDao = userDao;
    }

    @Transactional
    public void saveUser(RegisterUserDTO registerUserDTO){
        if(registerUserDTO.getPassword().equals(registerUserDTO.getPassword2())){

            User user = new User();
            user.setEmail(registerUserDTO.getEmail());
            user.setPassword(registerUserDTO.getPassword());

            userDao.saveUser(user);
        }
    }
}
