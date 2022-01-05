package org.springbootschedulebot.util;

public enum States {

    CREATE(3);

    States(int numOfStages) {
        this.numOfStages = numOfStages;
    }

    private final int numOfStages;

    public int getNumOfStages() {
        return numOfStages;
    }
}
