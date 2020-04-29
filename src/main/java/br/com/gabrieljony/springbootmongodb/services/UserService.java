package br.com.gabrieljony.springbootmongodb.services;

import br.com.gabrieljony.springbootmongodb.domain.User;
import br.com.gabrieljony.springbootmongodb.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> findAll() {
        return userRepository.findAll();
    }
}
