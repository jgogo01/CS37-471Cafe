// Natdanai Pinaves 6510405482
package ku.cs.kafe.service;

import ku.cs.kafe.entity.User;
import ku.cs.kafe.repository.UserRepository;
import ku.cs.kafe.request.SignupRequest;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class SignupService {


    @Autowired
    private UserRepository repository;


    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private ModelMapper modelMapper;

    public boolean isUsernameAvailable(String username) {
        return repository.findByUsername(username) == null;
    }


    public void createUser(SignupRequest user) {
        User record = modelMapper.map(user, User.class);
        record.setRole("ROLE_USER");


        String hashedPassword = passwordEncoder.encode(user.getPassword());
        record.setPassword(hashedPassword);


        repository.save(record);
    }


    public User getUser(String username) {
        return repository.findByUsername(username);
    }
}
