package com.example.FitTrack;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {

    private final ClientRepository clientRepository;

    public DataInitializer(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public void run(String... args) {
        // Preload admin user if not exists
        if (clientRepository.findByEmail("admin@fittrack.com") == null) {
            Client admin = new Client("Admin", "admin@fittrack.com", "admin", 0, 0, 0, "Other", "Admin Role");
            clientRepository.save(admin);
        }

        // Preload Trainer1 (Fat Loss)
        if (clientRepository.findByEmail("trainer1@fittrack.com") == null) {
            Client trainer1 = new Client("Trainer 1", "trainer1@fittrack.com", "trainer1", 30, 180, 90, "Male", "Fat Loss");
            clientRepository.save(trainer1);
        }

        if (clientRepository.findByEmail("user1@gmail.com") == null) {
            Client admin = new Client("User1", "user1@gmail.com", "user1", 27, 160, 70, "Female", "Fat Loss");
            clientRepository.save(admin);
        }

    }
}
