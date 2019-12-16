package bpmn.app.service;

import java.util.List;

import bpmn.app.model.AddressUser;
import bpmn.app.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service("addressUserService")
@Transactional
public class AddressUserServiceImpl implements AddressUserService{

//    private AddressRepository addressRepository;
//
//    @Autowired
//    public AddressUserServiceImpl(AddressRepository addressRepository) {
//        this.addressRepository = addressRepository;
//    }
//
//    @Transactional
//    public void addAddress(AddressUser addressUser) {
//        addressRepository.save(addressUser);
//    }
//
//    @Transactional
//    public void editAddress(AddressUser addressUser) {
//        addressRepository.save(addressUser);
//    }
//
//    @Transactional
//    public List<AddressUser> listAddress() {
//        return addressRepository.findAll();
//    }
//
//    @Override
//    public void removeAddress(long id) {
//
//    }
//
//    @Override
//    public AddressUser getAddress(long id) {
//        return null;
//    }

}