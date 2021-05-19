package ConsomiTounsi.Service;


import ConsomiTounsi.entities.Deliverer;
import ConsomiTounsi.entities.User;

import java.util.List;
import java.util.Optional;

public interface DelivererManagerInterface {
	
	List<Deliverer> retrieveAllDeliverer();
    Deliverer addDeliverer(Deliverer D);
    void DelivererOfTheMonthMail();
    void deleteDelivererById(Long id);
    void deleteDelivererById(String id);
    void updateDeliverer(Deliverer D , String password);
    Deliverer FindDelivererById(Long id);
    Deliverer FindDelivererById(String id);
    long getNbAvailableDeliveres();
	long getNbDeliverer();
	Deliverer getDelivererOfTheMonth();
    double SommeSaliareDeliverer();
    void resetBonus();

    void salaireAvecPrime();
    double updateprimeDeliverer(long id);

    double calculatePrime(long id);

    void electDelivererOftheMonth();

    Deliverer updateDeliverer(Deliverer D);

	long FindMaxScore();
    Optional<Deliverer> FindDelivererByIdOpt(String id);
    Optional<Deliverer> FindDelivererByIdOpt(Long id);

}
