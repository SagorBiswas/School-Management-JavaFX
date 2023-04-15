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
public class Teacher_Off {
    private SimpleStringProperty TEACHER_ID;
    private SimpleStringProperty FIRST_NAME;
    private SimpleStringProperty LAST_NAME;
    private SimpleStringProperty SUBJECT;
    private SimpleStringProperty JOIN_DATE;
    private SimpleStringProperty BIRTH_DATE;
    private SimpleStringProperty SALARY;
    private SimpleStringProperty BLOOD_GROUP;
    
    Teacher_Off(String id, String fname, String lname, String sub, String jdate, String bdate, String sal, String BG)
    {
        this.TEACHER_ID = new SimpleStringProperty(id);
        this.FIRST_NAME = new SimpleStringProperty(fname);
        this.LAST_NAME = new SimpleStringProperty(lname);
        this.SUBJECT = new SimpleStringProperty(sub);
        this.JOIN_DATE = new SimpleStringProperty(jdate);
        this.BIRTH_DATE = new SimpleStringProperty(bdate);
        this.SALARY = new SimpleStringProperty(sal);
        this.BLOOD_GROUP = new SimpleStringProperty(BG);
    }

    /**
     * @return the TEACHER_ID
     */
    public String getTEACHER_ID() {
        return TEACHER_ID.get();
    }

    /**
     * @param TEACHER_ID the TEACHER_ID to set
     */
    public void setTEACHER_ID(String TEACHER_ID) {
        this.TEACHER_ID.set(TEACHER_ID);
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
     * @return the SUBJECT
     */
    public String getSUBJECT() {
        return SUBJECT.get();
    }

    /**
     * @param SUBJECT the SUBJECT to set
     */
    public void setSUBJECT(String SUBJECT) {
        this.SUBJECT.set(SUBJECT);
    }

    /**
     * @return the JOIN_DATE
     */
    public String getJOIN_DATE() {
        return JOIN_DATE.get();
    }

    /**
     * @param JOIN_DATE the JOIN_DATE to set
     */
    public void setJOIN_DATE(String JOIN_DATE) {
        this.JOIN_DATE.set(JOIN_DATE);
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
    public void setBIRTH_DATE(String BIRTH_DATE) {
        this.BIRTH_DATE.set(BIRTH_DATE);
    }

    /**
     * @return the SALARY
     */
    public String getSALARY() {
        return SALARY.get();
    }

    /**
     * @param SALARY the SALARY to set
     */
    public void setSALARY(String SALARY) {
        this.SALARY.set(SALARY);
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
    public void setBLOOD_GROUP(String BLOOD_GROUP) {
        this.BLOOD_GROUP.set(BLOOD_GROUP);
    }
}
