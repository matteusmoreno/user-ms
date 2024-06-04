package br.com.matteusmoreno.user.service;

import br.com.matteusmoreno.user.model.User;
import br.com.matteusmoreno.user.producer.UserProducer;
import br.com.matteusmoreno.user.repository.UserRepository;
import br.com.matteusmoreno.user.request.CreateUserRequest;
import jakarta.transaction.Transactional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final UserProducer userProducer;

    @Autowired
    public UserService(UserRepository userRepository, UserProducer userProducer) {
        this.userRepository = userRepository;
        this.userProducer = userProducer;
    }

    @Transactional
    public User createuser(CreateUserRequest request) {
        User user = new User();
        BeanUtils.copyProperties(request, user);

        userRepository.save(user);
        userProducer.publishMessageEmail(user);

        return user;
    }
}
