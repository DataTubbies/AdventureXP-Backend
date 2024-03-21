package dat3.adventurexp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookingNumberService {

    private int lastAssignedBookingNumber = 0; // Startværdi for bookingnummeret

    public synchronized int generateBookingNumber() {
        lastAssignedBookingNumber++;
        return lastAssignedBookingNumber;
    }
}
