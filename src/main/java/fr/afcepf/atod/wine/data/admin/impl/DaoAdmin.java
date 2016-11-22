package fr.afcepf.atod.wine.data.admin.impl;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import fr.afcepf.atod.vin.data.exception.WineErrorCode;
import fr.afcepf.atod.vin.data.exception.WineException;
import fr.afcepf.atod.wine.data.admin.api.IDaoAdmin;
import fr.afcepf.atod.wine.data.impl.DaoGeneric;
import fr.afcepf.atod.wine.entity.Admin;
import fr.afcepf.atod.wine.entity.User;

@Service
@Transactional
public class DaoAdmin extends DaoGeneric<User, Integer> implements IDaoAdmin {
    /*****************************************************.
     *                  Requetes HQL
     ****************************************************/

    private static final String REQCONNEXION = "SELECT u FROM User u "
                + "WHERE  u.mail     = :paramMail "
                + "AND   u.password = :paramPassword "
                + "AND u.user_type = 'ADMIN'";

    /****************************************************.
     *                 Fin Requetes HQL
     ****************************************************/
    @Override
    public User connect(String paramMail, String paramPassword) throws WineException {
        User user = null;
        if (!paramMail.equalsIgnoreCase("") && 
                !paramPassword.equalsIgnoreCase("")) {
           user = (User) (getSf().getCurrentSession()
                   .createQuery(REQCONNEXION)
                   .setParameter("paramMail", paramMail)
                   .setParameter("paramPassword", paramPassword)
                   .uniqueResult());
 
            if (!user.getLastname().equalsIgnoreCase("")){
                return user;
            } else {
                throw  new WineException(WineErrorCode.LOGIN_MDP_INVALIDE, 
                    "user not in the db");
            }
        } else {
            throw  new WineException(WineErrorCode.LOGIN_MDP_INVALIDE, 
                    "mail  or password invalid");
        }
    }

    @Override
    public Admin addNewAdmin(Admin paramAdmin) {
        Admin admin = null;
        admin = (Admin) getSf().getCurrentSession().save(paramAdmin);
        return admin;
    }

    

}
