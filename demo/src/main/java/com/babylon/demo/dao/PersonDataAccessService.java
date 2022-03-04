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
        final String sql = "INSERT INTO person (id,first_name,last_name,d_o_b,gender,university_email, university_name,program,password,nationality,dietary,language,shared_occupancy,pet_preference,smoking_habit,drinking_habit) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        return jdbcTemplate.update(sql, new Object[]{id,
                person.getFirst_name(),
                person.getLast_name(),
                person.getD_o_b(),
                person.getGender(),
                person.getUniversity_email(),
                person.getUniversity_name(),
                person.getProgram(),
                person.getPassword(),
                person.getNationality(),
                person.getDietary(),
                person.getLanguage(),
                person.getShared_occupancy(),
                person.getPet_preference(),
                person.getSmoking_habit(),
                person.getDrinking_habit()});
    }

    @Override
    public List<Person> selectAllPeople() {
        final String sql = "SELECT * from person";
        return jdbcTemplate.query(sql, (resultSet, i) -> {
            return new Person(UUID.fromString(resultSet.getString("id")),
                    resultSet.getString("first_name"), resultSet.getString("last_name"), resultSet.getString("d_o_b"), resultSet.getString("gender"),
                    resultSet.getString("university_email"), resultSet.getString("university_name"), resultSet.getString("program"), resultSet.getString("password"), resultSet.getString("nationality"),
                    resultSet.getString("dietary"), resultSet.getString("language"), resultSet.getString("shared_occupancy"),
                    resultSet.getString("pet_preference"),resultSet.getString("smoking_habit"),resultSet.getString("drinking_habit"));
        });
    }

    @Override
    public List<Person> searchPerson(Person person) {
        String gender = person.getGender() == null ? "%" : person.getGender();
        String nationality = person.getNationality() == null ? "%" : person.getNationality();
        String dietary = person.getDietary() == null ? "%" : person.getDietary();
        String language = person.getLanguage() == null ? "%" : person.getLanguage();
        String university_name = person.getUniversity_name() == null ? "%" : person.getUniversity_name();
        String program = person.getProgram() == null ? "%" : person.getProgram();
        String shared_occupancy = person.getShared_occupancy() == null ? "%" : person.getShared_occupancy();
        String pet_preference = person.getPet_preference() == null ? "%" : person.getPet_preference();
        String smoking_habit = person.getSmoking_habit() == null ? "%" : person.getSmoking_habit();
        String drinking_habit = person.getDrinking_habit() == null ? "%" : person.getDrinking_habit();

        final String sql = "SELECT * from person WHERE gender LIKE ? AND nationality LIKE ? AND dietary LIKE ? AND language LIKE ? AND university_name LIKE ? AND program LIKE ? AND shared_occupancy LIKE ? AND pet_preference LIKE ? AND smoking_habit  LIKE ? AND drinking_habit  LIKE ?";
        return jdbcTemplate.query(sql, new Object[]{gender, nationality, dietary, language, university_name, program, shared_occupancy, pet_preference, smoking_habit, drinking_habit}, (resultSet, i) -> {
            return new Person(UUID.fromString(resultSet.getString("id")),
                    resultSet.getString("first_name"), resultSet.getString("last_name"), resultSet.getString("d_o_b"), resultSet.getString("gender"),
                    resultSet.getString("university_email"), resultSet.getString("university_name"), resultSet.getString("program"), resultSet.getString("password"), resultSet.getString("nationality"),
                    resultSet.getString("dietary"), resultSet.getString("language"), resultSet.getString("shared_occupancy"),
                    resultSet.getString("pet_preference"),resultSet.getString("smoking_habit"),resultSet.getString("drinking_habit"));
        });
    }

    @Override
    public Optional<Person> selectPersonById(UUID id) {
        final String sql = "SELECT * from person WHERE id = ?";
        Person person =  jdbcTemplate.queryForObject(sql, new Object[]{id},(resultSet, i) -> {
            return new Person(UUID.fromString(resultSet.getString("id")),
                    resultSet.getString("first_name"), resultSet.getString("last_name"), resultSet.getString("d_o_b"), resultSet.getString("gender"),
                    resultSet.getString("university_email"), resultSet.getString("university_name"), resultSet.getString("program"), resultSet.getString("password"), resultSet.getString("nationality"),
                    resultSet.getString("dietary"), resultSet.getString("language"), resultSet.getString("shared_occupancy"),
                    resultSet.getString("pet_preference"),resultSet.getString("smoking_habit"),resultSet.getString("drinking_habit"));
        });
        return Optional.ofNullable(person);
    }

    @Override
    public Optional<Person> selectPersonByEmail(String university_email) {
        final String sql = "SELECT * from person WHERE university_email LIKE ?";
        Person person =  jdbcTemplate.queryForObject(sql, new Object[]{university_email},(resultSet, i) -> {
            return new Person(UUID.fromString(resultSet.getString("id")),
                    resultSet.getString("first_name"), resultSet.getString("last_name"), resultSet.getString("d_o_b"), resultSet.getString("gender"),
                    resultSet.getString("university_email"), resultSet.getString("university_name"), resultSet.getString("program"), resultSet.getString("password"), resultSet.getString("nationality"),
                    resultSet.getString("dietary"), resultSet.getString("language"), resultSet.getString("shared_occupancy"),
                    resultSet.getString("pet_preference"),resultSet.getString("smoking_habit"),resultSet.getString("drinking_habit"));
        });
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
