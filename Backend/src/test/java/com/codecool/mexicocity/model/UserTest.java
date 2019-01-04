package com.codecool.mexicocity.model;

import com.codecool.mexicocity.dao.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@DataJpaTest
public class UserTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private UserRepository userRepository;

    @Test
    public void whenFindByEmail_ThenReturnUserEmail(){

        //given
        Rooster rooster = new Rooster();
        entityManager.persist(rooster);
        User alex = new User("alex@gmail.com", "Alex","123", rooster);
        entityManager.persist(alex);
        entityManager.flush();

        //when
        User foundAlex = userRepository.findUserByEmail("alex@gmail.com");

        //then
        assertEquals(alex.getEmail(), foundAlex.getEmail());

    }
    @Test
    public void whenFindByName_ThenReturnUserName(){

        //given
        Rooster rooster = new Rooster();
        entityManager.persist(rooster);
        User alex = new User("alex@gmail.com", "Alex","123", rooster);
        entityManager.persist(alex);
        entityManager.flush();

        //when
        User foundAlex = userRepository.findUserByName("Alex");

        //then
        assertEquals(alex.getName(), foundAlex.getName());

    }
}