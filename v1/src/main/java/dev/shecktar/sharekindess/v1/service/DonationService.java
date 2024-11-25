package dev.shecktar.sharekindess.v1.service;

import dev.shecktar.sharekindess.v1.model.Donation;
import dev.shecktar.sharekindess.v1.repository.DonationRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class DonationService {

    private final DonationRepository donationRepository;

    public DonationService(DonationRepository donationRepository) {
        this.donationRepository = donationRepository;
    }

    public Donation createDonation(Donation donation) {
        donation.setId(UUID.randomUUID()); // Only if you're not using @GeneratedValue
        donation.setCreatedAt(LocalDateTime.now());
        donation.setUpdatedAt(LocalDateTime.now());
        return donationRepository.save(donation);
    }

    public List<Donation> getAllDonations() {
        return donationRepository.findAll();
    }

    public Donation getDonationById(UUID id) {
        return donationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Donation not found"));
    }

    public Donation updateDonation(UUID id, Donation updatedDonation) {
        Donation existingDonation = donationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Donation not found"));

        existingDonation.setUpdatedAt(LocalDateTime.now());
        existingDonation.setTitle(updatedDonation.getTitle());
        existingDonation.setDescription(updatedDonation.getDescription());
        // Update other fields as necessary
        return donationRepository.save(existingDonation);
    }

    public void deleteDonation(UUID id) {
        Donation donation = donationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Donation not found"));
        donationRepository.delete(donation);
    }
}
