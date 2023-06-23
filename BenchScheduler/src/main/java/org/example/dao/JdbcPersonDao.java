package org.example.dao;

import org.example.model.Person;

import java.time.LocalDate;
import java.util.List;

public class JdbcPersonDao implements PersonDao{
    @Override
    public Person getPersonById(int personId) {
        return null;
    }

    @Override
    public List<Person> getPeople() {
        return null;
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
}
