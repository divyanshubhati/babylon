package com.babylon.demo.dao;

import com.babylon.demo.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("postgres")
public class PersonDataAccessService implements PersonDAO{
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public PersonDataAccessService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int insertPerson(UUID id, Person person) {
        final String sql = "INSERT INTO person (id, name) VALUES (?,?)";
        return jdbcTemplate.update(sql, new Object[]{id, person.getName()});
    }

    @Override
    public List<Person> selectAllPeople() {
        final String sql = "SELECT id, name from person";
        return jdbcTemplate.query(sql, (resultSet, i) -> new Person(UUID.fromString(resultSet.getString("id")), resultSet.getString("name")));
    }

    @Override
    public Optional<Person> selectPersonById(UUID id) {
        final String sql = "SELECT id, name from person WHERE id = ?";
        Person person =  jdbcTemplate.queryForObject(sql, new Object[]{id},(resultSet, i) -> new Person(UUID.fromString(resultSet.getString("id")), resultSet.getString("name")));
        return Optional.ofNullable(person);
    }

    @Override
    public int deletePersonById(UUID id) {
        return 0;
    }

    @Override
    public int updatePersonById(UUID id, Person person) {
        return 0;
    }
}
