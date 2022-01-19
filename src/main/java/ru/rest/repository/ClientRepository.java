package ru.rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.rest.model.Client;

public interface ClientRepository extends JpaRepository<Client,Integer> {
}
