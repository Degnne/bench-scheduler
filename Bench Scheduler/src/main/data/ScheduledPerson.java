package main.data;

public class ScheduledPerson {

    private Person person;
    private boolean isScheduled;

    public ScheduledPerson(Person person) {
        this.person = person;
    }

    public Person getPerson() {
        return person;
    }

    public boolean isScheduled() {
        return isScheduled;
    }

    public void setScheduled(boolean scheduled) {
        isScheduled = scheduled;
    }
}
