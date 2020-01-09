package bpmn.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.ws.rs.GET;

@Controller
public class FormController {
    @GET
    @RequestMapping(value = "/personaldata")
    public String showPersonalDataForm() {
        return "personal_data_form";
    }

    @GET
    @RequestMapping(value = "/visitdetails")
    public String showCompleteVisitForm() {
        return "complete_visit_details";
    }

    @GET
    @RequestMapping(value = "/freeterms")
    public String showDoctorsFreeTerms() {
        return "doctors_free_terms";
    }
}
