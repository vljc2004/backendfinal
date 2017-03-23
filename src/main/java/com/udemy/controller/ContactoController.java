package com.udemy.controller;

import com.udemy.entity.Contact;
import com.udemy.service.ContactoService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Julio on 07/03/2017.
 */
@Controller
@RequestMapping("/contacto")
public class ContactoController {

    private static final Log LOG = LogFactory.getLog(ContactoController.class);

    @Autowired
    private ContactoService contactoService;

    @GetMapping("/cancel")
    public String cancel(){
        return "contacts";
    }

    @GetMapping("/contactoForma")
    public String redirectContactForm(Model model){
        model.addAttribute("contacto",new Contact());
        return "contactform";
    }

    @PostMapping("/addContact")
    public String addContact(@ModelAttribute(name="contacto") Contact contacto,Model model){
        LOG.info("+++++++++Contacto "+contacto.toString());
        Contact resp = contactoService.addContact(contacto);
        LOG.info("+++++++++Resp: "+resp.toString());
        model.addAttribute("result",1);
        return "redirect:/contacto/showcontacts";
    }


   @GetMapping("/deleteContact")
    public String deleteContact(@RequestParam(name="id") Long id){

        //ModelAndView mav = new ModelAndView("contacts");
        //mav.addObject("contacto",redirectContactForm());
        contactoService.deleteContact(id);

        //return "redirect:/contacto/showcontacts";
       return "showcontacts";
    }


    @GetMapping("/detailContacto")
    public String detailContacto(@RequestParam(name="id") Long id,Model model){

        model.addAttribute("contacto",contactoService.busrcarPorId(id));
        return "contactform";

    }


    @GetMapping("/showcontacts")
    public ModelAndView redirectContactForm(){
        ModelAndView mav = new ModelAndView("contacts");
        mav.addObject("contacto",contactoService.listAllContact());
        return mav;
    }
}
