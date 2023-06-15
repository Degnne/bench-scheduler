package main.data;

import java.util.*;

public class WorkWeek {

    private Map<DayOfTheWeek, HashMap<Person, Boolean>> personWorkSchedule = new LinkedHashMap<DayOfTheWeek, HashMap<Person, Boolean>>();
    private Map<DayOfTheWeek, LinkedList<Benchwork>> benchworkSchedule = new LinkedHashMap<DayOfTheWeek, LinkedList<Benchwork>>();

    public void scheduleWorkWeek() {
        for (Map.Entry<DayOfTheWeek, LinkedList<Benchwork>> benchworkForTheDay : benchworkSchedule.entrySet()) {
            for (Benchwork benchwork : benchworkForTheDay.getValue()) {
                for (Map.Entry<Person, Boolean> personSchedule : personWorkSchedule.get(benchworkForTheDay.getKey()).entrySet()) {
                    Person person = personSchedule.getKey();
                    boolean isScheduled = personSchedule.getValue();
                    if (!isScheduled && person.trainedOnBench(benchwork.getBench())) {
                        benchwork.schedulePerson(person);
                    }
                }
            }
        }
    }

    public void addToPersonWorkSchedule(Person person, LinkedList<DayOfTheWeek> daysWorking) {
        for (Map.Entry<DayOfTheWeek, HashMap<Person, Boolean>> dayOfTheWeek : personWorkSchedule.entrySet()) {
            if (daysWorking.contains(dayOfTheWeek.getKey())) {
                dayOfTheWeek.getValue().put(person, false);
            }
        }
    }

}
