package main.data;

import java.util.*;

public class WorkWeek {

    private Map<DayOfTheWeek, ArrayList<ScheduledPerson>> personWorkSchedule = new LinkedHashMap<DayOfTheWeek, ArrayList<ScheduledPerson>>();
    private Map<DayOfTheWeek, LinkedList<Benchwork>> benchworkSchedule = new LinkedHashMap<DayOfTheWeek, LinkedList<Benchwork>>();

    public void scheduleWorkWeek() {

    }
//    public void scheduleWorkWeek() {
//        for (Map.Entry<DayOfTheWeek, LinkedList<Benchwork>> benchworkForTheDay : benchworkSchedule.entrySet()) {
//            for (Benchwork benchwork : benchworkForTheDay.getValue()) {
//                for (PersonWorking personWorking : personWorkSchedule.get(benchworkForTheDay.getKey())) {
//                    if (!personWorking.isWorking() && personWorking.getPerson().trainedOnBench(benchwork.getBench())) {
//                        benchwork.schedulePerson(personWorking.getPerson());
//                    }
//                }
//            }
//        }
//    }
//
    public void addToPersonWorkSchedule(Person person, LinkedList<DayOfTheWeek> daysWorking) {
        for (Map.Entry<DayOfTheWeek, ArrayList<ScheduledPerson>> dayOfTheWeek : personWorkSchedule.entrySet()) {
            if (daysWorking.contains(dayOfTheWeek.getKey())) {
                dayOfTheWeek.getValue().add(new ScheduledPerson(person));
            }
        }
    }

}
