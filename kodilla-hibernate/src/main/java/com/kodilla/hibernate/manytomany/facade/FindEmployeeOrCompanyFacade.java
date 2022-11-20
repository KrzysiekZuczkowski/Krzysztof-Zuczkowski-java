package com.kodilla.hibernate.manytomany.facade;

import com.kodilla.hibernate.manytomany.Company;
import com.kodilla.hibernate.manytomany.Employee;
import com.kodilla.hibernate.manytomany.dao.CompanyDao;
import com.kodilla.hibernate.manytomany.dao.EmployeeDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FindEmployeeOrCompanyFacade {

    private static final Logger LOGGER = LoggerFactory.getLogger(FindEmployeeOrCompanyFacade.class);
    private static FindEmpOrComFacadeDto facadeDto = new FindEmpOrComFacadeDto();

    private final EmployeeDao employeeDao;
    private final CompanyDao companyDao;

    @Autowired
    public FindEmployeeOrCompanyFacade(final EmployeeDao employeeDao, final CompanyDao companyDao) {
        this.employeeDao = employeeDao;
        this.companyDao = companyDao;
    }

    public static FindEmpOrComFacadeDto getFacadeDto() {
        return facadeDto;
    }

    public CompanyDao getCompanyDao() {
        return companyDao;
    }

    public void processFindEmpOrCom(String empPartName, String comPartName) throws FindEmployeeOrCompanyProcessingException {
        LOGGER.info("Data creation");
        Employee johnSmith = new Employee("John", "Smith");
        Employee lindaKovalsky = new Employee("Linda", "Kovalsky");

        Company softwareMachine = new Company("Software Machine");
        Company greyMatter = new Company("Grey Matter");

        softwareMachine.getEmployees().add(lindaKovalsky);
        greyMatter.getEmployees().add(lindaKovalsky);
        greyMatter.getEmployees().add(johnSmith);

        johnSmith.getCompanies().add(greyMatter);
        lindaKovalsky.getCompanies().add(softwareMachine);
        lindaKovalsky.getCompanies().add(greyMatter);
        try {
            LOGGER.info("Adding employees and companies to the database");
            companyDao.save(softwareMachine);
            companyDao.save(greyMatter);
            if(companyDao.findAll().size() == 0) {
                LOGGER.error(FindEmployeeOrCompanyProcessingException.ERR_NO_COMPANY);
                facadeDto.setWasError(true);
                throw new FindEmployeeOrCompanyProcessingException(
                        FindEmployeeOrCompanyProcessingException.ERR_NO_COMPANY);
            }
            facadeDto.setCompanyId(softwareMachine.getId());
            if(employeeDao.findAll().size() == 0) {
                LOGGER.error(FindEmployeeOrCompanyProcessingException.ERR_NO_EMPLOYEE);
                facadeDto.setWasError(true);
                throw new FindEmployeeOrCompanyProcessingException(
                        FindEmployeeOrCompanyProcessingException.ERR_NO_EMPLOYEE);
            }
            if(!(companyDao.findAll().size() == 2 && employeeDao.findAll().size() == 2)) {
                LOGGER.error(FindEmployeeOrCompanyProcessingException.ERR_NOT_COMPLETE);
                facadeDto.setWasError(true);
                throw new FindEmployeeOrCompanyProcessingException(
                        FindEmployeeOrCompanyProcessingException.ERR_NOT_COMPLETE);
            }
            LOGGER.info("Data ready for searching...");
            List<Company> companiesByPartOfName =  companyDao.retrieveCompaniesByPartOfName(comPartName);
            if(!(companiesByPartOfName.size() == 1)) {
                LOGGER.error(FindEmployeeOrCompanyProcessingException.ERR_COMPANY_BY_NAME);
                facadeDto.setWasError(true);
                throw new FindEmployeeOrCompanyProcessingException(
                        FindEmployeeOrCompanyProcessingException.ERR_COMPANY_BY_NAME);
            }
            List<Employee> employeesByPartOfName =  employeeDao.retrieveEmployeesByPartOfName(empPartName);
            if(!(employeesByPartOfName.size() == 1)) {
                LOGGER.error(FindEmployeeOrCompanyProcessingException.ERR_EMPLOYEE_BY_NAME);
                facadeDto.setWasError(true);
                throw new FindEmployeeOrCompanyProcessingException(
                        FindEmployeeOrCompanyProcessingException.ERR_EMPLOYEE_BY_NAME);
            }
        }
        finally {
            if (facadeDto.getWasError()) {
                LOGGER.error(FindEmployeeOrCompanyProcessingException.ERR_RESULT);
            }
        }
    }
}
