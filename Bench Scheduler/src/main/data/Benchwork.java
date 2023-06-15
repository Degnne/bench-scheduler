package main.data;

import java.util.ArrayList;
import java.util.List;

public class Benchwork {

    private Bench bench;
    private int numberOfPeopleRequired;
    private List<Person> peopleScheduled = new ArrayList<Person>();

    public Bench getBench() {
        return bench;
    }

    public int getNumberOfPeopleRequired() {
        return numberOfPeopleRequired;
    }

    public List<Person> getPeopleScheduled() {
        return peopleScheduled;
    }

    public boolean isBenchFull() {
        return peopleScheduled.size() >= numberOfPeopleRequired;
    }
}
