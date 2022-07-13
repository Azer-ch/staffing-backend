package com.staffing.enums;

public enum GenderEnum {
    MALE{
        @Override
        public String toString() {
            return "MALE";
        }
    },
    FEMALE{
        @Override
        public String toString() {
            return "FEMALE";
        }
    }
}
