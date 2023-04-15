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
public class Teacher_Std {
    private SimpleStringProperty TEACHER_ID;
    private SimpleStringProperty TEACHER_NAME;
    private SimpleStringProperty SUBJECT;

    Teacher_Std(String ID, String NAME, String SUB){
        this.TEACHER_ID = new SimpleStringProperty(ID);
        this.TEACHER_NAME = new SimpleStringProperty(NAME);
        this.SUBJECT = new SimpleStringProperty(SUB);

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
     * @return the TEACHER_NAME
     */
    public String getTEACHER_NAME() {
        return TEACHER_NAME.get();
    }

    /**
     * @param TEACHER_NAME the TEACHER_NAME to set
     */
    public void setTEACHER_NAME(String TEACHER_NAME) {
        this.TEACHER_NAME.set(TEACHER_NAME); 
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
}
