package com.egg.inmoDocHouse.repository;


import com.egg.inmoDocHouse.entity.Property;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PropertyRepository extends JpaRepository<Property,Integer> {

    //Add Services search by id and all

    Optional<List<Property>> findByM2(double m2);

    Optional<List<Property>> findByQuantityOfAmbiences(int quantityOfAmbiences);

    Optional<List<Property>> findByPriceLessThanEqual(double price);

    Optional<List<Property>> findByPriceGreaterThanEqual(double price);

    Optional<List<Property>> findByQuantityOfBathrooms(int quantity);

    Optional<List<Property>> findByGarage(boolean garage);

    Optional<List<Property>> findByPrivateNeighborhood(boolean  privateNeighborhood);

    Optional<List<Property>> findByTypeOperation(String typeOperation);

    Optional<List<Property>> findAllByEnteId(int enteId);

    Optional<List<Property>> findByUbication(String ubication);

    Optional<Property> findByAddress(String address);

    @Query("SELECT a FROM Property a WHERE (:ubication is null or a.ubication= :ubication) and" +
            "(:typeOperation is null or a.typeOperation= :typeOperation) and" +
            "(:quantity is null or :quantity = 0 or a.quantityOfAmbiences= :quantity)")
    Optional<List<Property>> findByUbicationAndTypeOperationAndQuantityOfAmbiences(@Param("ubication") String ubication
            , @Param("typeOperation") String typeOperation,@Param("quantity") int quantity);

    Optional<List<Property>> findByUbicationAndTypeOperation(String ubication,String typeOperation);
}
