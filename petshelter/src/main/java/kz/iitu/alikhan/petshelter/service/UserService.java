package kz.iitu.alikhan.petshelter.service;


import kz.iitu.alikhan.petshelter.entity.Pet;
import kz.iitu.alikhan.petshelter.entity.Role;
import kz.iitu.alikhan.petshelter.entity.User;
import kz.iitu.alikhan.petshelter.exception.NoRoleException;
import kz.iitu.alikhan.petshelter.repository.PetRepository;
import kz.iitu.alikhan.petshelter.repository.RoleRepository;
import kz.iitu.alikhan.petshelter.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@AllArgsConstructor
@Component
public class UserService implements UserDetailsService {

    private UserRepository userRepository;
    private RoleRepository roleRepository;
    private PetRepository petRepository;

    public Optional<User> findUserById(Long id) {
        System.out.println("Test");
        return userRepository.findById(id);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);

        if (user == null)
            throw new UsernameNotFoundException("User with username: " + username + " is not found");

        return user;
    }

    public List<User> showAllUsers() {
        return userRepository.findAll();
    }

    public User saveUser(User user) throws NoRoleException {
        Set<Role> roles = new HashSet<>();
        Role userRole = roleRepository.findByName(user.getRole());
        System.out.println(userRole);
        if (userRole != null) {
            roles.add(userRole);
        } else
            throw  new NoRoleException();
        user.setRoles(roles);
        user.setPassword(passwordEncoder().encode(user.getPassword()));
        return userRepository.save(user);
    }
//Донат добавить
    public User givePet(Pet pet, User user) {
        Set<Pet> pets = user.getPets();
        pets.add(pet);
        user.setPets(pets);
        return userRepository.save(user);
    }

    public User returnPet(Pet pet, User user) {
        Set<Pet> pets = user.getPets();
        pets.remove(pet);
        user.setPets(pets);
        return userRepository.save(user);
    }

    public User findByUsername(String name) {
        return userRepository.findByUsername(name);
    }

    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
