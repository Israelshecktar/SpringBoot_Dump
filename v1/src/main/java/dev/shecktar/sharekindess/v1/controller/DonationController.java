package dev.shecktar.sharekindess.v1.controller;

import dev.shecktar.sharekindess.v1.model.Donation;
import dev.shecktar.sharekindess.v1.service.DonationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/donations")
public class DonationController {

    @Autowired
    private DonationService donationService;

    @PostMapping
    public Donation createDonation(@RequestBody Donation donation) {
        return donationService.createDonation(donation);
    }

    @GetMapping
    public List<Donation> getAllDonations() {
        return donationService.getAllDonations();
    }

    @GetMapping("/{id}")
    public Donation getDonationById(@PathVariable UUID id) {
        return donationService.getDonationById(id);
    }

    @PutMapping("/{id}")
    public Donation updateDonation(@PathVariable UUID id, @RequestBody Donation donation) {
        return donationService.updateDonation(id, donation);
    }

    @DeleteMapping("/{id}")
    public void deleteDonation(@PathVariable UUID id) {
        donationService.deleteDonation(id);
    }
}
