package com.egg.inmoDocHouse.service;

import com.egg.inmoDocHouse.entity.Property;
import com.egg.inmoDocHouse.exception.PropertyCreateException;
import com.egg.inmoDocHouse.exception.PropertyException;
import com.egg.inmoDocHouse.repository.PropertyRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PropertyService {

    @Autowired
    PropertyRepository propertyRepository;

    public List<Property> findByM2(double m2) {

        if (m2 != 0) {
            return propertyRepository.findByM2(m2).orElse(null);

        } else {

            throw new NullPointerException();
        }

    }

    public List<Property> findByQuantityOfAmbiences(int quantityOfAmbiences) {


        if (quantityOfAmbiences != 0) {
            return propertyRepository.findByQuantityOfAmbiences(quantityOfAmbiences).orElse(null);

        } else {

            throw new NullPointerException();
        }

    }

    public List<Property> findByPriceLessThanEquals(double price)  {

        if (price != 0) {
            return propertyRepository.findByPriceLessThanEqual(price).orElse(null);

        } else {

            throw new NullPointerException();
        }

    }

    public List<Property> findByPriceGreaterThanEquals(double price) {

        if (price != 0) {
            return propertyRepository.findByPriceGreaterThanEqual(price).orElse(null);

        } else {

            throw new NullPointerException();
        }
    }

    public List<Property> findByQuantityOfBathrooms(int quantity) {

        if (quantity != 0) {
            return propertyRepository.findByQuantityOfBathrooms(quantity).orElse(null);

        } else {

            throw new NullPointerException();
        }

    }

    public List<Property> findByGarage(Boolean garage) {

        if (!garage.equals(null)) {
            return propertyRepository.findByGarage(garage).orElse(null);

        } else {

            throw new NullPointerException();
        }
    }


    public List<Property> findByPrivateNeighborhood(Boolean privateNeighborhood) {

        if (!privateNeighborhood.equals(null)) {
            return propertyRepository.findByPrivateNeighborhood(privateNeighborhood).orElse(null);

        } else {

            throw new NullPointerException();
        }
    }

    public List<Property> findByTypeOperation(String typeOperation){

        if (!typeOperation.equals(null) || typeOperation.isEmpty()) {
            return propertyRepository.findByTypeOperation(typeOperation).orElse(null);

        } else {

            throw new NullPointerException();
        }

    }

    public List<Property> findAll() {
            return propertyRepository.findAll();
    }

    public Property findById(int userId) {

        if (userId != 0) {
            return propertyRepository.findById(userId).orElse(null);

        } else {

            throw new NullPointerException();
        }


    }
    public List<Property> findByUserId(int userId) {

        if (userId != 0) {
            return propertyRepository.findByUserId(userId).orElse(null);

        } else {

            throw new NullPointerException();
        }


    }

    public List<Property> findByUbication(String ubication) {

        if (!ubication.equals(null)) {
            return propertyRepository.findByUbication(ubication).orElse(null);

        } else {

            throw new NullPointerException();
        }

    }

    @Transactional
    public Property save(Property property) {

        if (validateProperty(property)) {

            System.out.println(property.getAddress());
            List<Property> properties = propertyRepository.findAll();
            properties.forEach(p -> {
                if(p.getAddress().equals(property.getAddress())){
                    throw new PropertyException();
                }
            });

            return propertyRepository.save(property);
        } else {
            throw new NullPointerException();
        }
    }

    @Transactional
    public Property update(Property updateProperty, int id) {

        Property propertyToUpdate = propertyRepository.findById(id).get();
        if (validateProperty(updateProperty)  ) {
            //propertyToUpdate.setId(propertyToUpdate.getId());
            propertyToUpdate.setM2(updateProperty.getM2());
            propertyToUpdate.setGarage(updateProperty.getGarage());
            propertyToUpdate.setPrice(updateProperty.getPrice());
            propertyToUpdate.setExpense(updateProperty.getExpense());
            propertyToUpdate.setQuantityOfAmbiences(updateProperty.getQuantityOfAmbiences());
            propertyToUpdate.setPrivateNeighborhood(updateProperty.isPrivateNeighborhood());
            propertyToUpdate.setQuantityOfBathrooms(updateProperty.getQuantityOfBathrooms());
            propertyToUpdate.setUserId(updateProperty.getUserId());
            propertyToUpdate.setTypeOperation(updateProperty.getTypeOperation());
            propertyToUpdate.setUbication(updateProperty.getUbication());
                return propertyRepository.save(propertyToUpdate);

        } else {
            throw new NullPointerException();
        }
    }

    @Transactional
    public void delete(int id) {

        if (id != 0) {

            propertyRepository.deleteById(id);

        } else {
            throw new NullPointerException();
        }

    }


    public boolean validateProperty(Property property) {

        if(property.getId() == 0 &
                property.getM2() == 0 &
                property.getQuantityOfAmbiences() == 0 &
                property.getQuantityOfBathrooms() == 0 &
                property.getGarage() == 0 &
                property.getExpense() == 0 &
//                !property.getTypeOperation().equals(null) || !property.equals("") &
//                !property.getUbication().equals(null) || !property.equals("") &
                property.getUserId() == 0){

            throw new PropertyCreateException();
        }
        return true;
    }

    public List<Property> searchWithFilters(String ubication, String typeOperation,int quantity){
        if(ubication.isEmpty() && typeOperation.isEmpty() && quantity == 0){
            throw  new IllegalArgumentException();
        }else if(quantity == 0){
            return propertyRepository.findByUbicationAndTypeOperation(ubication,typeOperation).get();
        } else if (typeOperation.isEmpty() && quantity == 0) {
            return propertyRepository.findByUbication(ubication).get();
        } else if (typeOperation.isEmpty() && typeOperation.isEmpty()){
            return propertyRepository.findByQuantityOfAmbiences(quantity).get();
        }


        return propertyRepository.findByUbicationAndTypeOperationAndQuantityOfAmbiences(ubication,
                typeOperation,quantity).get();
    }


}
