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
        List<Person> listOfPeople = new ArrayList<Person>();
        String sql = "SELECT * FROM person AS p \n" +
                "JOIN person_trained_bench AS ptb ON p.person_id = ptb.person_id\n" +
                "WHERE ptb.bench_id = ?;";
        SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql, benchId);
        while (rowSet.next()) {
            listOfPeople.add(mapRowToPerson(rowSet));
        }
        return listOfPeople;
    }

    @Override
    public List<Person> getPeopleOrderedByFewestTrainedBenches() {
        List<Person> listOfPeople = new ArrayList<Person>();
        String sql = "SELECT p.person_id, p.first_name, p.last_name, COUNT(ptb.bench_id) AS bench_count FROM person AS p\n" +
                "JOIN person_trained_bench AS ptb ON p.person_id = ptb.person_id\n" +
                "GROUP BY p.person_id\n" +
                "ORDER BY bench_count ASC;";
        SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql);
        while (rowSet.next()) {
            listOfPeople.add(mapRowToPerson(rowSet));
        }
        return listOfPeople;
    }

    @Override
    public List<Person> getPeopleWorkingByDate(LocalDate date) {
        List<Person> listOfPeople = new ArrayList<Person>();
        String sql = "SELECT * FROM person_day_schedule AS pds\n" +
                "JOIN person AS p ON pds.person_id = p.person_id\n" +
                "WHERE pds.day = ? AND is_working = true;";
        SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql, date);
        while (rowSet.next()) {
            listOfPeople.add(mapRowToPerson(rowSet));
        }
        return listOfPeople;
    }

    @Override
    public List<Person> getPeopleScheduledByDateAndBenchId(LocalDate date, int bench_id) {
        List<Person> listOfPeople = new ArrayList<Person>();
        String sql = "SELECT * FROM person_day_schedule AS pds\n" +
                "JOIN person AS p ON pds.person_id = p.person_id\n" +
                "WHERE pds.day = ? AND is_working = true AND pds.bench_id = ?;";
        SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql, date, bench_id);
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
