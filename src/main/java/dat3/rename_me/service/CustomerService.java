package dat3.rename_me.service;

import dat3.rename_me.dto.ActivityDto;
import dat3.rename_me.dto.CustomerDto;
import dat3.rename_me.entity.Activity;
import dat3.rename_me.entity.Customer;
import dat3.rename_me.repository.CustomerRepository;
import dat3.security.entity.Role;
import dat3.security.entity.UserWithRoles;
import dat3.security.repository.RoleRepository;
import dat3.security.repository.UserWithRolesRepository;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;


import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class CustomerService {

    PasswordEncoder pwEncoder;
    RoleRepository roleRepository;
    UserWithRolesRepository userWithRolesRepository;

    CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository, PasswordEncoder pwEncoder, RoleRepository roleRepository, UserWithRolesRepository userWithRolesRepository) {
        this.customerRepository = customerRepository;
        this.pwEncoder = pwEncoder;
        this.roleRepository = roleRepository;
        this.userWithRolesRepository = userWithRolesRepository;
    }

    public List<CustomerDto> getAllCustomers() {
        List<Customer> customers = customerRepository.findAll();
        return customers.stream().map((b)->new CustomerDto(b, true)).collect(Collectors.toList());
    }

    public CustomerDto getCustomerById(UUID id) {
        return new CustomerDto(customerRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Customer not found")), false);
    }


    public CustomerDto addCustomer(CustomerDto c) {
        Customer newCustomer = new Customer();
        updateCustomer(newCustomer, c);
        customerRepository.save(newCustomer);
        return new CustomerDto(newCustomer, false);
    }

    private void updateCustomer(Customer original, CustomerDto r) {
        original.setFirstName(r.getFirstName());
        original.setLastName(r.getLastName());
        original.setEmail(r.getEmail());
        original.setStreetName(r.getStreetName());
        original.setStreetNumber(r.getStreetNumber());
        original.setZipCode(r.getZipCode());
        original.setCity(r.getCity());
        original.setPhoneNumber(r.getPhoneNumber());
        original.setUsername(r.getUsername());
        original.setPassword(r.getPassword());
        original.setCompanyName(r.getCompanyName());
        original.setCvr(r.getCvr());
        original.setCompany(r.isCompany());
    }
}
