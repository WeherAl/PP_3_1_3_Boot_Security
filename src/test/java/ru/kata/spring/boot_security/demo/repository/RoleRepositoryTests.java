package ru.kata.spring.boot_security.demo.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import ru.kata.spring.boot_security.demo.model.Role;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class RoleRepositoryTests {

    private final RoleRepository repo;

    @Autowired
    public RoleRepositoryTests(RoleRepository repo) {
        this.repo = repo;
    }

    @Test
    public void testCreateRoles() {
        Role user = new Role("ROLE_USER");
        Role admin = new Role("ROLE_ADMIN");

        repo.saveAll(List.of(user, admin));

        List<Role> listRoles = repo.findAll();

        assertThat(listRoles.size()).isEqualTo(2);
    }

}