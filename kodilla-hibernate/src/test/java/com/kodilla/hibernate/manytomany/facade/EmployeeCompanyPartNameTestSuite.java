package com.kodilla.hibernate.manytomany.facade;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertFalse;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class EmployeeCompanyPartNameTestSuite {

    @Autowired
    private FindEmployeeOrCompanyFacade facade;

    @Test
    void testFindEmployeeOrCompanyFacade() {
        try {
            facade.processFindEmpOrCom("val", "tt");
        }
        catch (FindEmployeeOrCompanyProcessingException e) {
            assertFalse(FindEmployeeOrCompanyFacade.getFacadeDto().getWasError());
        }
        finally {
            facade.getCompanyDao().deleteById(
                    FindEmployeeOrCompanyFacade.getFacadeDto().getCompanyId());
        }
    }
}
/*
Cześć jak próbowałem query = "FROM Company WHERE name LIKE %:PART_OF_NAME%"
    wywalało taki błąd
        Company.retrieveCompaniesByPartOfName failed because of:org.hibernate.hql.internal.ast.QuerySyntaxException:unexpected token: % near line 1, column 63 [FROM com.kodilla.hibernate.manytomany.Company WHERE name LIKE %:PART_OF_NAME%]
        zadziałało dopiero z comcat()
 */