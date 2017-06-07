/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package businesslogic.systemoperation;

import database.DBBroker;
import domen.IDomenskiObjekat;
import domen.Mesto;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author student
 */
public class GetAllPlacesSO extends AbstractSystemOperation {

    private List<Mesto> mesta;

    public GetAllPlacesSO(DBBroker dBBroker) {
        super(dBBroker);
        mesta = new ArrayList<>();
    }

    @Override
    protected void validate(Object object) throws Exception {
    }

    @Override
    protected void checkPreCondition(Object object) throws Exception {
    }

    @Override
    protected void executeOperation(Object object) throws Exception {
        // mesta = dBBroker.vratiSvaMesta();
        List<IDomenskiObjekat> idos = dBBroker.vratiSve(new Mesto());
        for (IDomenskiObjekat ido : idos) {
            mesta.add((Mesto) ido);
        }

    }

    public List<Mesto> getMesta() {
        return mesta;
    }

}
