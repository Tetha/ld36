package org.subquark.ld36.goals;

public enum TimeConstraint {
    LOTS(360), SOME(240), NONE(120);
    
    public final int timeLimit;
    
    private TimeConstraint(int timeLimit) {
        this.timeLimit = timeLimit;
    }
}
