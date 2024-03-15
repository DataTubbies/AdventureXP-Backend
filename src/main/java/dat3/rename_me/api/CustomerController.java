package dat3.rename_me.api;

import dat3.rename_me.dto.CustomerDto;
import dat3.rename_me.service.CustomerService;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/customers")
public class CustomerController {

        private CustomerService customerService;

        public CustomerController(CustomerService customerService) {
            this.customerService = customerService;
        }

        @GetMapping
        public Object getAllCustomers(Authentication authentication) {
            if (authentication.getAuthorities().toString().contains("ADMIN") || authentication.getAuthorities().toString().contains("EMPLOYEE")) {
                return customerService.getAllCustomers();
            } else if (authentication.getAuthorities().toString().contains("USER")) {
                // Extract bookings based on user information from authentication object
                String userName = authentication.getName();

                // Assuming you have a method in bookingService to get bookings by user
                UUID userId = UUID.fromString("123e4567-e89b-12d3-a456-426614174000");
                return customerService.getCustomerById(userId);
            } else {
                return "Unauthorized access";
            }
        }

        @GetMapping(path = "/{id}")
        public CustomerDto getCustomerById(@PathVariable UUID id) {
            return customerService.getCustomerById(id);
        }

        @PostMapping
        public CustomerDto createCustomer(@RequestBody CustomerDto requestBody) {
            return customerService.addCustomer(requestBody);
        }
}

