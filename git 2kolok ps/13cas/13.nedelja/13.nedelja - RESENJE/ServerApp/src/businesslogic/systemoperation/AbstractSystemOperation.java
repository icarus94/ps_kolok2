/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package businesslogic.systemoperation;

import database.DBBroker;
import domen.PoslovniPartner;
import java.util.List;

/**
 *
 * @author student
 */
public abstract class AbstractSystemOperation {

    protected DBBroker dBBroker;

    public AbstractSystemOperation(DBBroker dBBroker) {
        this.dBBroker = dBBroker;
    }

    public void execute(Object object) throws Exception {
        try {
            validate(object);
            checkPreCondition(object);
            executeOperation(object);
            commit();
        } catch (Exception e) {
            rollback();
            throw e;
        }

    }

    protected abstract void validate(Object object) throws Exception;

    protected abstract void checkPreCondition(Object object) throws Exception;

    protected abstract void executeOperation(Object object) throws Exception;

    private void commit() {
        dBBroker.commit();
    }

    private void rollback() {
        dBBroker.rollback();
    }

}
