package main;

import main.data.Lab;
import main.data.WorkWeek;

public class Scheduler {

    private Lab lab = new Lab();
    private WorkWeek workWeek = new WorkWeek();

    public void scheduleWorkWeek() {
        workWeek.scheduleWorkWeek();
    }

}
