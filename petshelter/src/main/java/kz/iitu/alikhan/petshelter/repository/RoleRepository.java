package kz.iitu.alikhan.petshelter.repository;

import kz.iitu.alikhan.petshelter.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;


public interface RoleRepository  extends JpaRepository<Role, Long> {
    Role findByName(String name);
}
