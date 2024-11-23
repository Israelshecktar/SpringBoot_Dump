
package dev.sharekindness.user.repository;

import dev.sharekindness.user.model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Long> {
    // ...existing code...
}