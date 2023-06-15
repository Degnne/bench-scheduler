package main.data;

import java.util.ArrayList;
import java.util.List;

public class Person {

    private PersonName name;
    private List<Bench> trainedBenches = new ArrayList<Bench>();

    public Person(String firstName, String lastName) {
        name = new PersonName(firstName, lastName);
    }

    public void addTrainedBench(Bench benchToAdd) {
        trainedBenches.add(benchToAdd);
    }

    public void removeTrainedBench(Bench benchToRemove) {
        trainedBenches.remove(benchToRemove);
    }

    public PersonName getName() {
        return name;
    }

    public List<Bench> getTrainedBenches() {
        return trainedBenches;
    }
}
