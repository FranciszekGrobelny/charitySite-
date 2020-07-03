package pl.coderslab.charity.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.charity.dao.DonationDao;
import pl.coderslab.charity.dto.donation.CreateDonationDTO;
import pl.coderslab.charity.model.Donation;



@Service
public class DonationService {

    private final DonationDao donationDao;

    public DonationService(DonationDao donationDao) {
        this.donationDao = donationDao;
    }

    @Transactional
    public void save(CreateDonationDTO createDonationDTO){
        Donation donation = new Donation();
        donation.setInstitution(createDonationDTO.getInstitution());
        donation.setQuantity(createDonationDTO.getQuantity());
        donation.setCity(createDonationDTO.getCity());
        donation.setStreet(createDonationDTO.getStreet());
        donation.setPickUpDate(createDonationDTO.getPickUpDate());
        donation.setPickUpTime(createDonationDTO.getPickUpTime());
        donation.setPickUpComment(createDonationDTO.getPickUpComment());
        donation.setZipCode(createDonationDTO.getZipCode());
        donation.setCategories(createDonationDTO.getCategories());
        donationDao.saveDonation(donation);
    }
}
