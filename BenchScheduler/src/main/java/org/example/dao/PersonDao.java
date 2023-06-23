package org.example.dao;

import org.example.model.Person;

import java.time.LocalDate;
import java.util.List;

public interface PersonDao {

    public Person getPersonById(int personId);

    public List<Person> getPeople();

    public List<Person> getPeopleByTrainedBenchId(int benchId);

    public List<Person> getPeopleWorkingByDate(LocalDate date);

    public List<Person> getPeopleScheduledByDateAndBenchId(LocalDate date, int bench_id);

    public int deletePersonById(int personId);

    public Person updatePersonById(int personId);

    public Person createPerson(Person person);

}
