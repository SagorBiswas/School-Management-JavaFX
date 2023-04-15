/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProjectTables;

import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author SAGOR
 */
public class Student_Off {
    private SimpleStringProperty STUDENT_ID;
    private SimpleStringProperty FIRST_NAME;
    private SimpleStringProperty LAST_NAME;
    private SimpleStringProperty GRADE;
    private SimpleStringProperty SECTION;
    private SimpleStringProperty SESSION;
    private SimpleStringProperty ADDRESS;
    private SimpleStringProperty CONTACT_NUMBER;
    private SimpleStringProperty REMARKS;
    private SimpleStringProperty BLOOD_GROUP;
    private SimpleStringProperty BIRTH_DATE;

    public Student_Off(String ID, String FNAME, String LNAME, String GRD, String SECT, String SESS, String ADDR, String CONT_NUMB, String RMARKS, String BG, String BDATE) {
//        System.out.println("inside student-OFF");
//        System.out.println(LNAME + ID + FNAME + BDATE);
        this.STUDENT_ID = new SimpleStringProperty(ID);
        this.FIRST_NAME = new SimpleStringProperty(FNAME);
        this.LAST_NAME = new SimpleStringProperty(LNAME);
        this.GRADE = new SimpleStringProperty(GRD);
        this.SECTION = new SimpleStringProperty(SECT);
        this.SESSION = new SimpleStringProperty(SESS);
        this.ADDRESS = new SimpleStringProperty(ADDR);
        this.CONTACT_NUMBER = new SimpleStringProperty(CONT_NUMB);
        this.REMARKS = new SimpleStringProperty(RMARKS);
        this.BLOOD_GROUP = new SimpleStringProperty(BG);
        this.BIRTH_DATE = new SimpleStringProperty(BDATE);
        //this.toString();
        System.out.println("done here");
    }
    @Override
    public String toString(){
        return getSTUDENT_ID()+" "+getFIRST_NAME()+" "+getLAST_NAME()+" "+getGRADE()+" "+getSECTION()+" "+getSESSION()+" "+getADDRESS()+" "+getCONTACT_NUMBER()+" "+getREMARKS()+" "+
                getBLOOD_GROUP()+" "+getBIRTH_DATE();
    }

    /**
     * @return the STUDENT_ID
     */
    public String getSTUDENT_ID() {
        return STUDENT_ID.get();
    }

    /**
     * @param STUDENT_ID the STUDENT_ID to set
     */
    public void setSTUDENT_ID(String STUDENT_ID) {
        this.STUDENT_ID.set(STUDENT_ID);
    }

    /**
     * @return the FIRST_NAME
     */
    public String getFIRST_NAME() {
        return FIRST_NAME.get();
    }

    /**
     * @param FIRST_NAME the FIRST_NAME to set
     */
    public void setFIRST_NAME(String FIRST_NAME) {
        this.FIRST_NAME.set(FIRST_NAME);
    }

    /**
     * @return the LAST_NAME
     */
    public String getLAST_NAME() {
        return LAST_NAME.get();
    }

    /**
     * @param LAST_NAME the LAST_NAME to set
     */
    public void setLAST_NAME(String LAST_NAME) {
        this.LAST_NAME.set(LAST_NAME);
    }

    /**
     * @return the GRADE
     */
    public String getGRADE() {
        return GRADE.get();
    }

    /**
     * @param GRADE the GRADE to set
     */
    public void setGRADE(String GRADE) {
        this.GRADE.set(GRADE);
    }

    /**
     * @return the SECTION
     */
    public String getSECTION() {
        return SECTION.get();
    }

    /**
     * @param SECTION the SECTION to set
     */
    public void setSECTION(String SECTION) {
        this.SECTION.set(SECTION);
    }

    /**
     * @return the SESSION
     */
    public String getSESSION() {
        return SESSION.get();
    }

    /**
     * @param SESSION the SESSION to set
     */
    public void setSESSION(String SESSION) {
        this.SESSION.set(SESSION);
    }

    /**
     * @return the ADDRESS
     */
    public String getADDRESS() {
        return ADDRESS.get();
    }

    /**
     * @param ADDRESS the ADDRESS to set
     */
    public void setADDRESS(String ADDRESS) {
        this.ADDRESS.set(ADDRESS);
    }

    /**
     * @return the CONTACT_NUMBER
     */
    public String getCONTACT_NUMBER() {
        return CONTACT_NUMBER.get();
    }

    /**
     * @param CONTACT_NUMBER the CONTACT_NUMBER to set
     */
    public void setCONTACT_NUMBER(String CONTACT_NUMBER) {
        this.CONTACT_NUMBER.set(CONTACT_NUMBER);
    }

    /**
     * @return the REMARKS
     */
    public String getREMARKS() {
        return REMARKS.get();
    }

    /**
     * @param REMARKS the REMARKS to set
     */
    public void setREMARKS(SimpleStringProperty REMARKS) {
        this.REMARKS = REMARKS;
    }

    /**
     * @return the BLOOD_GROUP
     */
    public String getBLOOD_GROUP() {
        return BLOOD_GROUP.get();
    }

    /**
     * @param BLOOD_GROUP the BLOOD_GROUP to set
     */
    public void setBLOOD_GROUP(SimpleStringProperty BLOOD_GROUP) {
        this.BLOOD_GROUP = BLOOD_GROUP;
    }

    /**
     * @return the BIRTH_DATE
     */
    public String getBIRTH_DATE() {
        return BIRTH_DATE.get();
    }

    /**
     * @param BIRTH_DATE the BIRTH_DATE to set
     */
    public void setBIRTH_DATE(SimpleStringProperty BIRTH_DATE) {
        this.BIRTH_DATE = BIRTH_DATE;
    }
}
