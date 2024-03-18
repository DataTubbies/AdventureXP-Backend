package dat3.adventurexp.api;

import dat3.adventurexp.dto.CustomerDto;
import dat3.adventurexp.service.CustomerService;
import dat3.security.dto.UserWithRolesRequest;
import dat3.security.service.UserWithRolesService;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/customers")
public class CustomerController {

        private CustomerService customerService;

        private UserWithRolesService userWithRolesService;

        public CustomerController(CustomerService customerService, UserWithRolesService userWithRolesService) {
            this.userWithRolesService = userWithRolesService;
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
            System.out.print("THIS IS WHAT I AM SEEING: " + requestBody);
            // Create a user with roles
            UserWithRolesRequest request = new UserWithRolesRequest();
            request.setUsername(requestBody.getUsername());
            request.setPassword(requestBody.getPassword());
            request.setEmail(requestBody.getEmail());
            userWithRolesService.addUserWithRoles(request);

            // Create a customer
            return customerService.addCustomer(requestBody);
        }
}

