package kz.iitu.alikhan.petshelter.controller;

import io.swagger.annotations.ApiOperation;
import kz.iitu.alikhan.petshelter.entity.Pet;
import kz.iitu.alikhan.petshelter.entity.User;
import kz.iitu.alikhan.petshelter.exception.NoRoleException;
import kz.iitu.alikhan.petshelter.exception.PetNotFoundException;
import kz.iitu.alikhan.petshelter.exception.UserNotFoundException;
import kz.iitu.alikhan.petshelter.service.PetService;
import kz.iitu.alikhan.petshelter.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/users")
public class UserController {

    private UserService userService;
    private PetService petService;

    @ApiOperation(value = "Get all users", response = List.class)
    @GetMapping("")
    public List<User> getAllUsers() {
        return userService.showAllUsers();
    }

    @ApiOperation(value = "Get user with given id", response = User.class)
    @GetMapping("/{id}")
    public User findUserById(@PathVariable("id") Long id) throws UserNotFoundException {
        User user = userService.findUserById(id).orElse(null);
        if (user == null){
            throw new UserNotFoundException();
        }
        return user;
    }


    @ApiOperation(value = "Adopt a pet by a user", response = User.class)
    @PostMapping("/adopt")
    public User adoptPet(@RequestParam("user_id") Long userId, @RequestParam("pet_id") Long petId) throws UserNotFoundException, PetNotFoundException {
        User user = findUserById(userId);
        Pet pet = petService.findPetById(petId);
        return userService.givePet(pet, user);
    }

    @ApiOperation(value = "return pet that was adopted by a user", response = User.class)
    @PostMapping("/return")
    public User returnPet(@RequestParam("user_id") Long userId, @RequestParam("pet_id") Long petId) throws UserNotFoundException, PetNotFoundException {
        User user = findUserById(userId);
        Pet pet = petService.findPetById(petId);
        return userService.returnPet(pet, user);
    }


    @ApiOperation(value = "Register a new user", response = User.class)
    @PostMapping("/register")
    public User createUser(@RequestBody User user) throws NoRoleException {
        return userService.saveUser(user);
    }
}
