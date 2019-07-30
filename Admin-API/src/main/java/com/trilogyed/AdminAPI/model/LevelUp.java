package com.trilogyed.AdminAPI.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

public class LevelUp implements Serializable {
    private int Id;
    private int customerId;
    private int points;
    private LocalDate memberDate;

    public int getId() {
        return Id;
    }

    public void setId(int levelUpId) {
        this.Id = levelUpId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public LocalDate getMemberDate() {
        return memberDate;
    }

    public void setMemberDate(LocalDate memberDate) {
        this.memberDate = memberDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LevelUp levelUp = (LevelUp) o;
        return Id == levelUp.Id &&
                customerId == levelUp.customerId &&
                points == levelUp.points &&
                memberDate.equals(levelUp.memberDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Id, customerId, points, memberDate);
    }

    @Override
    public String toString() {
        return "LevelUp{" +
                "Id=" + Id +
                ", customerId=" + customerId +
                ", points=" + points +
                ", memberDate=" + memberDate +
                '}';
    }
}

