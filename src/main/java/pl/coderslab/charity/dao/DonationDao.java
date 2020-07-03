package pl.coderslab.charity.dao;

import org.springframework.stereotype.Repository;
import pl.coderslab.charity.model.Donation;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
@Transactional
public class DonationDao {

    @PersistenceContext
    private EntityManager entityManager;

    public void saveDonation(Donation donation) {
        entityManager.persist(donation);
    }

    public void update(Donation donation) {
        entityManager.merge(donation);
    }

    public void delete(Donation donation) {
        entityManager.remove(entityManager.contains(donation) ? donation : entityManager.merge(donation));
    }


}
