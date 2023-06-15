package main.data;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;

public class WorkWeek {

    private Map<DayOfTheWeek, ArrayList<Person>> personWorkSchedule = new LinkedHashMap<DayOfTheWeek, ArrayList<Person>>();
    private Map<DayOfTheWeek, LinkedList<Benchwork>> benchworkSchedule = new LinkedHashMap<DayOfTheWeek, LinkedList<Benchwork>>();

}
