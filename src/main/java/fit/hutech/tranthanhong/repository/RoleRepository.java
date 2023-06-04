package fit.hutech.tranthanhong.repository;
import fit.hutech.tranthanhong.model.Role;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(String name);
}
