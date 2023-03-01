package web.service;

import web.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.repository.UserRepository;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional
    public void saveUser(User user) {
        userRepository.save(user);
    }

    @Transactional
    public void deleteUserById(Long id) {
        userRepository.deleteById(id);
    }

    @Transactional
    public User getUserById(Long id) {
        return userRepository.findById(id).get();
    }

    @Transactional
    public void updateUser(User user, Long id) {
        User ouser = userRepository.findById(id).get();
        ouser.setName(user.getName());
        ouser.setLastName(user.getLastName());
        ouser.setEmail(user.getEmail());
        userRepository.save(ouser);
    }

    @Transactional(readOnly = true)
    public Iterable<User> getAllUsers () {
        return userRepository.findAll();
    }
}
