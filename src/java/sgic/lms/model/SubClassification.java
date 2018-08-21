/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sgic.lms.model;

/**
 *
 * @author Keerththanan
 */

public class SubClassification {
    String sClassificationID;
    String sClassificationName;
    String mClassificationId;
    String mClassificationName;

    public String getmClassificationId() {
        return mClassificationId;
    }

    public void setmClassificationId(String mClassificationId) {
        this.mClassificationId = mClassificationId;
    }
    
    public String getsClassificationID() {
        return sClassificationID;
    }

    public void setsClassificationID(String sClassificationID) {
        this.sClassificationID = sClassificationID;
    }

    public String getmClassificationName() {
        return mClassificationName;
    }

    public void setmClassificationName(String mClassificationName) {
        this.mClassificationName = mClassificationName;
    }

    public String getsClassificationName() {
        return sClassificationName;
    }

    public void setsClassificationName(String sClassificationName) {
        this.sClassificationName = sClassificationName;
    }
    
}
