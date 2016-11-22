package fr.afcepf.atod.wine.data.admin.api;

import fr.afcepf.atod.vin.data.exception.WineException;
import fr.afcepf.atod.wine.data.api.IDaoGeneric;
import fr.afcepf.atod.wine.entity.Admin;
import fr.afcepf.atod.wine.entity.Customer;
import fr.afcepf.atod.wine.entity.User;

public interface IDaoAdmin extends IDaoGeneric<User, Integer> {
	User connect(String mail, String password) throws WineException;
	Admin addNewAdmin(Admin admin);
}
