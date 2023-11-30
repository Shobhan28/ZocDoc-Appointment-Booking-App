package com.zocdoc.web.Controller;


import com.zocdoc.web.Entity.Appointment;
import com.zocdoc.web.Model.AppointmentKey;
import com.zocdoc.web.Service.AppointmentService;
import com.zocdoc.web.Service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/appointment")
public class AppointmentController {

    @Autowired
    private AppointmentService appointmentService;

    @Autowired
    private AuthenticationService authService;
   
    @PostMapping("/book")
    public ResponseEntity<String> bookAppointment(@RequestBody Appointment appointment){
        String msg=null;
        HttpStatus status;
        try{
            appointmentService.bookAppointment(appointment);
            msg = " Appointment booked successfully";
            status = HttpStatus.OK;
        }catch(Exception e){
            msg = "Book Another Appointment as this appointment is already booked";
            status = HttpStatus.BAD_REQUEST;
        }
        return new ResponseEntity<String>(msg, status);
    }
    @DeleteMapping("/cancel")
    ResponseEntity<Void> cancelAppointment(@RequestParam String userEmail,@RequestParam String token,
                                           @RequestBody AppointmentKey key)
    {

        HttpStatus status;
        if(authService.authenticate(userEmail,token))
        {
            appointmentService.cancelAppointment(key);
            status = HttpStatus.OK;
        }
        else
        {
            status = HttpStatus.FORBIDDEN;
        }

        return new ResponseEntity<Void>(status);

    }


    
}
