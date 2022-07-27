package com.staffing.enums;

public enum LeaveEnum {
    sickLeave {
        @Override
        public String toString() {
            return "Sick Leave";
        }
    },
    paidLeave {
        @Override
        public String toString() {
            return "Paid Leave";
        }
    },
    unpaidLeave {
        @Override
        public String toString() {
            return "Unpaid Leave";
        }
    },
    administrativeLeave {
        @Override
        public String toString() {
            return "Administrative Leave";
        }
    },
}
