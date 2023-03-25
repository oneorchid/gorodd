package devs.moigorod.RegisterLogin.repo;

import devs.moigorod.RegisterLogin.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@EnableJpaRepositories
@Repository
public interface PeopleRepository extends JpaRepository<Person,Integer> {
    Person findByEmail(String email);

    Optional<Person> findOneByEmailAndPassword(String email, String encodedPassword);
}
