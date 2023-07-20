package org.kata.enums;

public enum IndividualStatus {
    NOT_CLIENT,
    PROSPECT,
    CLIENT;

    public String toString () {
        return this.name();
    }
}
