package bpmn.app.controller;

import org.activiti.engine.RuntimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.awt.*;

@RestController
public class ActivitiController {

    @Autowired
    private RuntimeService runtimeService;

    @RequestMapping(value="/startmyprocess", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public void startMyprocess(){
        runtimeService.startProcessInstanceByKey("");
    }
}
