package dev.shecktar.sharekindess.v1.repository;

import dev.shecktar.sharekindess.v1.model.Donation;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface DonationRepository extends JpaRepository<Donation, UUID> {
}
