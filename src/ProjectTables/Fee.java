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
public class Fee {
    private SimpleStringProperty FEE_ID;
    private SimpleStringProperty FEE_DESCRIPTION;
    private SimpleStringProperty FEE_AMOUNT;
    private SimpleStringProperty LAST_PAYMENT_DATE;
    
    Fee(String ID, String DESC, String AMOUNT, String LAST_DATE){
        this.FEE_ID = new SimpleStringProperty(ID);
        this.FEE_DESCRIPTION = new SimpleStringProperty(DESC);
        this.FEE_AMOUNT = new SimpleStringProperty(AMOUNT);
        this.LAST_PAYMENT_DATE = new SimpleStringProperty(LAST_DATE);
    }

    /**
     * @return the FEE_ID
     */
    public String getFEE_ID() {
        return FEE_ID.get();
    }

    /**
     * @param FEE_ID the FEE_ID to set
     */
    public void setFEE_ID(String FEE_ID) {
        this.FEE_ID.set(FEE_ID);
    }

    /**
     * @return the FEE_DESCRIPTION
     */
    public String getFEE_DESCRIPTION() {
        return FEE_DESCRIPTION.get();
    }

    /**
     * @param FEE_DESCRIPTION the FEE_DESCRIPTION to set
     */
    public void setFEE_DESCRIPTION(String FEE_DESCRIPTION) {
        this.FEE_DESCRIPTION.set(FEE_DESCRIPTION);
    }

    /**
     * @return the FEE_AMOUNT
     */
    public String getFEE_AMOUNT() {
        return FEE_AMOUNT.get();
    }

    /**
     * @param FEE_AMOUNT the FEE_AMOUNT to set
     */
    public void setFEE_AMOUNT(String FEE_AMOUNT) {
        this.FEE_AMOUNT.set(FEE_AMOUNT);
    }

    /**
     * @return the LAST_PAYMENT_DATE
     */
    public String getLAST_PAYMENT_DATE() {
        return LAST_PAYMENT_DATE.get();
    }

    /**
     * @param LAST_PAYMENT_DATE the LAST_PAYMENT_DATE to set
     */
    public void setLAST_PAYMENT_DATE(String LAST_PAYMENT_DATE) {
        this.LAST_PAYMENT_DATE.set(LAST_PAYMENT_DATE);
    }
    
    @Override
    public String toString(){
        return FEE_ID.get()+" "+FEE_DESCRIPTION.get()+" "+FEE_AMOUNT.get();
    }
}
