package bpmn.app.controller;

import java.util.Locale;

import javax.ws.rs.GET;
import javax.ws.rs.POST;

import bpmn.app.model.AppUser;
import bpmn.app.model.CompleteDetails;
import bpmn.app.model.DataUser;
import bpmn.app.repository.DataUserRepository;
import bpmn.app.service.CompleteDetailsService;
import bpmn.app.service.DataUserService;
import bpmn.app.service.UserService;
import bpmn.app.utilities.UserUtilities;
import bpmn.app.validators.ChangePasswordValidator;
import bpmn.app.validators.EditUserProfileValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ProfilController {

    private UserService userService;

    private MessageSource messageSource;

    private DataUserService dataUserService;

    private CompleteDetailsService completeDetailsService;

    public ProfilController(MessageSource messageSource, UserService userService, DataUserService dataUserService,
                            CompleteDetailsService completeDetailsService) {
        this.messageSource = messageSource;
        this.userService = userService;
        this.dataUserService = dataUserService;
        this.completeDetailsService = completeDetailsService;
    }

    @GET
    @RequestMapping(value = "/profil")
    public String showUserProfilePage(Model model) {
        String username = UserUtilities.getLoggedUser();
        AppUser appUser = userService.findUserByEmail(username);
        boolean isAdmin = appUser.getRoles().iterator().next().getRole().equals("ROLE_ADMIN");
        model.addAttribute("isAdmin", isAdmin);
        model.addAttribute("user", appUser);
        return "profil";
    }

    @GET
    @RequestMapping(value = "/personal_data_form")
    public String showUserData(Model model) {

        return "personal_data_form";
    }

    @GET
    @RequestMapping(value = "/savePersonalData")
    public String savePersonalData(DataUser dataUser, Model model) {
        dataUserService.saveUser(dataUser);
        model.addAttribute("dataUser", new DataUser());
        return "redirect:/complete_visit_details";
    }

    @GET
    @RequestMapping(value = "/complete_visit_details")
    public String showCompleteVisitDetails(Model model) {

        return "complete_visit_details";
    }

    @GET
    @RequestMapping(value = "/saveCompleteDetails")
    public String saveCompleteDetails(CompleteDetails completeDetails, Model model) {

        completeDetailsService.saveCompleteDetails(completeDetails);
        model.addAttribute("completeDetails", new CompleteDetails());
        return "redirect:/complete_visit_details";
    }



    @GET
    @RequestMapping(value = "/editpassword")
    public String editUserPassword(Model model) {
        String username = UserUtilities.getLoggedUser();
        AppUser appUser = userService.findUserByEmail(username);
        model.addAttribute("user", appUser);
        return "editpassword";
    }

    @POST
    @RequestMapping(value = "/updatepass")
    public String changeUSerPassword(AppUser appUser, BindingResult result, Model model, Locale locale) {
        String returnPage;
        new ChangePasswordValidator().validate(appUser, result);
        new ChangePasswordValidator().checkPasswords(appUser.getNewPassword(), result);
        if (result.hasErrors()) {
            returnPage = "editpassword";
        } else {
            userService.updateUserPassword(appUser.getNewPassword(), appUser.getEmail());
            returnPage = "editpassword";
            model.addAttribute("message", messageSource.getMessage("passwordChange.success", null, locale));
        }
        return returnPage;
    }

    @GET
    @RequestMapping(value = "/editprofil")
    public String changeUserData(Model model) {
        String username = UserUtilities.getLoggedUser();
        AppUser appUser = userService.findUserByEmail(username);
        model.addAttribute("user", appUser);
        return "editprofil";
    }

//    @POST
//    @RequestMapping(value = "/updateprofil")
//    public String changeUserDataAction(AppUser appUser, BindingResult result, Model model, Locale locale) {
//        String returnPage;
//        new EditUserProfileValidator().validate(appUser, result);
//        if (result.hasErrors()) {
//            returnPage = "editprofil";
//        } else {
//            userService.updateUserProfile(appUser.getappUser.getEmail(), appUser.getId());
//            model.addAttribute("message", messageSource.getMessage("profilEdit.success", null, locale));
//            returnPage = "afteredit";
//        }
//        return returnPage;
//    }

}