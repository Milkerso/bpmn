package bpmn.app.controller;

import bpmn.app.model.AppUser;
import bpmn.app.service.AdminService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.MessageSource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

@Controller
public class AdminPageController {

    private static final Logger LOG = LoggerFactory.getLogger(AdminPageController.class);

    private static int ELEMENTS = 15;

    private final AdminService adminService;

    private final MessageSource messageSource;

    public AdminPageController(AdminService adminService, MessageSource messageSource) {
        this.adminService = adminService;
        this.messageSource = messageSource;
    }

    @GET
    @RequestMapping(value = "/admin")
    @Secured(value = {"ROLE_ADMIN"})
    public String openAdminMainPage() {
        LOG.info("Administracja strona główna");
        return "admin/admin";
    }

    @GET
    @RequestMapping(value = "/admin/users/{page}")
    @Secured(value = {"ROLE_ADMIN"})
    public String openAdminAllUsersPage(@PathVariable("page") int page, Model model) {
        Page<AppUser> pages = getAllUsersPageable(page - 1, false, null);
        int totalPages = pages.getTotalPages();
        int currentPage = pages.getNumber();
        List<AppUser> appUserList = pages.getContent();
        model.addAttribute("totalPages", totalPages);
        model.addAttribute("currentPage", currentPage + 1);
        model.addAttribute("userList", appUserList);
        model.addAttribute("recordStartCounter", currentPage * ELEMENTS);
        return "admin/users";
    }

    @GET
    @RequestMapping(value = "/admin/users/edit/{id}")
    @Secured(value = {"ROLE_ADMIN"})
    public String getUserToEdit(@PathVariable("id") int id, Model model) {
        AppUser appUser = new AppUser();
        appUser = adminService.findUserById(id);
        Map<Integer, String> roleMap = new HashMap<Integer, String>();
        roleMap = prepareRoleMap();
        Map<Integer, String> activityMap = new HashMap<Integer, String>();
        activityMap = prepareActivityMap();
        int rola = appUser.getRoles().iterator().next().getId();
        appUser.setNrRoli(rola);
        model.addAttribute("roleMap", roleMap);
        model.addAttribute("activityMap", activityMap);
        model.addAttribute("user", appUser);
        return "admin/useredit";
    }

    @POST
    @RequestMapping(value = "/admin/updateuser/{id}")
    @Secured(value = "ROLE_ADMIN")
    public String updateUser(@PathVariable("id") int id, AppUser appUser) {
        int nrRoli = appUser.getNrRoli();
        int czyActive = appUser.getActive();
        adminService.updateUser(id, nrRoli, czyActive);
        return "redirect:/admin/users/1";
    }

    @GET
    @RequestMapping(value = "/admin/users/search/{searchWord}/{page}")
    @Secured(value = "ROLE_ADMIN")
    public String openSearchUsersPage(@PathVariable("searchWord") String searchWord,
                                      @PathVariable("page") int page, Model model) {
        Page<AppUser> pages = getAllUsersPageable(page - 1, true, searchWord);
        int totalPages = pages.getTotalPages();
        int currentPage = pages.getNumber();
        List<AppUser> appUserList = pages.getContent();
        model.addAttribute("totalPages", totalPages);
        model.addAttribute("currentPage", currentPage + 1);
        model.addAttribute("userList", appUserList);
        model.addAttribute("recordStartCounter", currentPage * ELEMENTS);
        model.addAttribute("searchWord", searchWord);
        model.addAttribute("userList", appUserList);
        return "admin/usersearch";
    }


    @DELETE
    @RequestMapping(value = "/admin/users/delete/{id}")
    @Secured(value = "ROLE_ADMIN")
    public String deleteUser(@PathVariable("id") int id) {
        LOG.debug("[WYWOŁANIE >>> AdminPageController.deleteUser > PARAMETR: " + id);
        adminService.deleteUserById(id);
        return "redirect:/admin/users/1";
    }

    // Metody uzytkowe
    // Pobranie listy userów
    private Page<AppUser> getAllUsersPageable(int page, boolean search, String param) {
        Page<AppUser> pages;
        if (!search) {
            pages = adminService.findAll(PageRequest.of(page, ELEMENTS));
        } else {
            pages = adminService.findAllSearch(param, PageRequest.of(page, ELEMENTS));
        }
        for (AppUser users : pages) {
            int numerRoli = users.getRoles().iterator().next().getId();
            users.setNrRoli(numerRoli);
        }
        return pages;
    }

    // przygotowanie mapy ról
    public Map<Integer, String> prepareRoleMap() {
        Locale locale = Locale.getDefault();
        Map<Integer, String> roleMap = new HashMap<Integer, String>();
        roleMap.put(1, messageSource.getMessage("word.admin", null, locale));
        roleMap.put(2, messageSource.getMessage("word.user", null, locale));
        return roleMap;
    }

    // przygotowanie may aktywny/nieaktywny
    public Map<Integer, String> prepareActivityMap() {
        Locale locale = Locale.getDefault();
        Map<Integer, String> activityMap = new HashMap<Integer, String>();
        activityMap.put(0, messageSource.getMessage("word.nie", null, locale));
        activityMap.put(1, messageSource.getMessage("word.tak", null, locale));
        return activityMap;
    }
}
