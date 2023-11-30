package com.zocdoc.web.Controller;


import com.zocdoc.web.Entity.Appointment;
import com.zocdoc.web.Service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/appointment")
public class AppointmentController {

    @Autowired
    private AppointmentService appointmentService;
   
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


    
}
