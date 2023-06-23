package org.example.dao;

import org.example.model.Person;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import javax.sql.DataSource;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class JdbcPersonDao implements PersonDao{

    private static final String SELECT_FROM_PERSON = "SELECT person_id, first_name, last_name FROM person";

    private JdbcTemplate jdbcTemplate;

    public JdbcPersonDao(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public Person getPersonById(int personId) {
        Person person = null;
        SqlRowSet rowSet = jdbcTemplate.queryForRowSet(SELECT_FROM_PERSON + " WHERE person_id = ?", personId);
        if (rowSet.next()) {
            person = mapRowToPerson(rowSet);
        }
        return person;
    }

    @Override
    public List<Person> getPeople() {
        List<Person> people = new ArrayList<Person>();
        SqlRowSet rowSet = jdbcTemplate.queryForRowSet(SELECT_FROM_PERSON);
        while (rowSet.next()) {
            people.add(mapRowToPerson(rowSet));
        }
        return people;
    }

    @Override
    public List<Person> getPeopleByTrainedBenchId(int benchId) {
        return null;
    }

    @Override
    public List<Person> getPeopleWorkingByDate(LocalDate date) {
        return null;
    }

    @Override
    public List<Person> getPeopleScheduledByDateAndBenchId(LocalDate date, int bench_id) {
        return null;
    }

    @Override
    public int deletePersonById(int personId) {
        return 0;
    }

    @Override
    public Person updatePersonById(int personId) {
        return null;
    }

    @Override
    public Person createPerson(Person person) {
        return null;
    }

    private Person mapRowToPerson(SqlRowSet row) {
        Person person = new Person();
        person.setPersonId(row.getInt("person_id"));
        person.setFirstName(row.getString("first_name"));
        person.setLastName(row.getString("last_name"));
        return person;
    }
}
