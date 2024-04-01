/**
 * @author <Le Xuan Loc - s3955317>
 */

package org.system.insurance.model;

public class Dependent extends Customer {

    public Dependent(String id, String fullName, String insuranceCardId) {
        super(id, fullName, insuranceCardId);
    }

    @Override
    public String toString() {
        return "Dependent{" +
                "id='" + id + '\'' +
                ", fullName='" + fullName + '\'' +
                ", insuranceCardId='" + insuranceCardId + '\'' +
                '}';
    }
}


