package com.kodilla.hibernate.manytomany.facade;

public class FindEmpOrComFacadeDto {

    private int companyId;
    private boolean wasError;

    public int getCompanyId() {
        return companyId;
    }

    public boolean getWasError() {
        return wasError;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }

    public void setWasError(boolean wasError) {
        this.wasError = wasError;
    }
}
