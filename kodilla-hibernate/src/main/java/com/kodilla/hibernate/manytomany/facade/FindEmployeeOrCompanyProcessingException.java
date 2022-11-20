package com.kodilla.hibernate.manytomany.facade;

public class FindEmployeeOrCompanyProcessingException extends Exception {

    public static String ERR_NO_COMPANY = "There are no companies in the database";
    public static String ERR_NO_EMPLOYEE = "There are no employees in the database";
    public static String ERR_NOT_COMPLETE = "Not all data in the database";
    public static String ERR_COMPANY_BY_NAME = "Companies searched incorrectly";
    public static String ERR_EMPLOYEE_BY_NAME = "Employees searched incorrectly";
    public static String ERR_RESULT = "No results found";

    public FindEmployeeOrCompanyProcessingException(String message) {
        super(message);
    }
}
