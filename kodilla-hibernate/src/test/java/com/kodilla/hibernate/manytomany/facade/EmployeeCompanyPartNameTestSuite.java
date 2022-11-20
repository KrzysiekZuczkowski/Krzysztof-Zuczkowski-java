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
            facade.processFindEmpOrCom("%val%", "%tt%");
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
