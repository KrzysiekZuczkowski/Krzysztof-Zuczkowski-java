package com.kodilla.hibernate.manytomany.dao;

import com.kodilla.hibernate.manytomany.Company;
import com.kodilla.hibernate.manytomany.Employee;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class CompanyDaoTestSuite {

    @Autowired
    private CompanyDao companyDao;

    @Autowired
    private EmployeeDao employeeDao;

    @Test
    void testSaveManyToMany() {
        //Given
        Employee johnSmith = new Employee("John", "Smith");
        Employee stephanieClarckson = new Employee("Stephanie", "Clarckson");
        Employee lindaKovalsky = new Employee("Linda", "Kovalsky");

        Company softwareMachine = new Company("Software Machine");
        Company dataMaesters = new Company("Data Maesters");
        Company greyMatter = new Company("Grey Matter");

        softwareMachine.getEmployees().add(johnSmith);
        dataMaesters.getEmployees().add(stephanieClarckson);
        dataMaesters.getEmployees().add(lindaKovalsky);
        greyMatter.getEmployees().add(johnSmith);
        greyMatter.getEmployees().add(lindaKovalsky);

        johnSmith.getCompanies().add(softwareMachine);
        johnSmith.getCompanies().add(greyMatter);
        stephanieClarckson.getCompanies().add(dataMaesters);
        lindaKovalsky.getCompanies().add(dataMaesters);
        lindaKovalsky.getCompanies().add(greyMatter);

        //When
        companyDao.save(softwareMachine);
        int softwareMachineId = softwareMachine.getId();
        companyDao.save(dataMaesters);
        int dataMaestersId = dataMaesters.getId();
        companyDao.save(greyMatter);
        int greyMatterId = greyMatter.getId();

        //Then
        assertNotEquals(0, softwareMachineId);
        assertNotEquals(0, dataMaestersId);
        assertNotEquals(0, greyMatterId);

        //CleanUp
        try {
            companyDao.deleteById(softwareMachineId);
            companyDao.deleteById(dataMaestersId);
            companyDao.deleteById(greyMatterId);
        } catch (Exception e) {
            //do nothing
        }
    }

    @Test
    void testNamedQueries() {
        //Given
        Employee johnSmith = new Employee("John", "Smith");
        Employee lindaKovalsky = new Employee("Linda", "Kovalsky");
        Employee samantaKovalsky = new Employee("Samanta", "Kovalsky");

        Company softwareMachine = new Company("Software Machine");
        Company greyMatter = new Company("Grey Matter");

        softwareMachine.getEmployees().add(lindaKovalsky);
        softwareMachine.getEmployees().add(samantaKovalsky);
        greyMatter.getEmployees().add(johnSmith);
        greyMatter.getEmployees().add(lindaKovalsky);

        johnSmith.getCompanies().add(greyMatter);
        lindaKovalsky.getCompanies().add(softwareMachine);
        lindaKovalsky.getCompanies().add(greyMatter);
        samantaKovalsky.getCompanies().add(softwareMachine);

        companyDao.save(softwareMachine);
        int softwareMachineId = softwareMachine.getId();

        companyDao.save(greyMatter);
//        int greyMatterId = greyMatter.getId();

        //When
        List<Company> firstThreeCharactersCompaniesName =
                companyDao.retrieveCompaniesNameEqualFirstThreeCharacters("Sof");
        List<Company> firstThreeCharactersCompaniesName2 =
                companyDao.retrieveCompaniesNameEqualFirstThreeCharacters("soft");

        List<Employee> lastnameEmployees = employeeDao.retrieveByLastnameEmployees("Kovalsky");
        List<Employee> employees = employeeDao.retrieveEmployeesByPartOfName("%val%");

        //Then
        try {
            assertEquals(1, firstThreeCharactersCompaniesName.size());
            assertEquals(0, firstThreeCharactersCompaniesName2.size());
            assertEquals(2, lastnameEmployees.size());
        }
        finally {
            //CleanUp
            companyDao.deleteById(softwareMachineId);
            //companyDao.deleteById(greyMatterId);
        }
    }
}