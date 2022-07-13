package com.staffing.enums;

public enum RoleEnum {
    ROLE_ADMIN {
        public String toString() {
            return "ROLE_ADMIN";
        }
    },
    ROLE_USER {
        public String toString() {
            return "ROLE_USER";
        }
    },
    ROLE_ENTERPRISE{
        public String toString() {
            return "ROLE_ENTERPRISE";
        }
    },
    ROLE_HR{
        public String toString() {
            return "ROLE_HR";
        }
    },
    ROLE_ENGINEER{
        public String toString() {
            return "ROLE_ENGINEER";
        }
    },
    ROLE_MANAGER{
        public String toString() {
            return "ROLE_MANAGER";
        }
    }
}
