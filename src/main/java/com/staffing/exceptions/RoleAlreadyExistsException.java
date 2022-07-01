package com.staffing.exceptions;

public class RoleAlreadyExistsException extends Exception{

        public RoleAlreadyExistsException() {
            super("Role already exists");
        }
}
