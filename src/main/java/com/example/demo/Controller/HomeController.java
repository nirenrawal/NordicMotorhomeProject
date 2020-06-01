package com.example.demo.Controller;

import com.example.demo.Model.Customer;
import com.example.demo.Model.Extra;
import com.example.demo.Model.Motorhome;
import com.example.demo.Model.RentalContract;
import com.example.demo.Service.CustomerService;
import com.example.demo.Service.ExtraService;
import com.example.demo.Service.MotorhomeService;
import com.example.demo.Service.RentalContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.context.request.WebRequest;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

@Controller
public class HomeController {

    @Autowired
    CustomerService customerService;
    @Autowired
    MotorhomeService motorhomeService;
    @Autowired
    RentalContractService rentalContractService;
    @Autowired
    ExtraService extraService;

    @GetMapping("/")
    public String login() {
        return "home/login";
    }

    @GetMapping("/index")
    public String index() {
        return "home/index";
    }

    //LOGIN METHOD
    @PostMapping("/index")
    public String mainMenu(WebRequest wr) throws FileNotFoundException {

        String username = wr.getParameter("uname");
        String password = wr.getParameter("psw");

        Scanner scanner = new Scanner(new File("password.txt"));
        String pw = scanner.next();

        if(username.equals("employee") && password.equals(pw)){
            return "home/index";
        } else {
            return "home/login";
        }
    }

    //CUSTOMER
    @GetMapping("/customer")
    public String indexCustomer(Model model) {
        List<Customer> customerList = customerService.viewAllCustomer();
        model.addAttribute("customers", customerList);
        return "home/customer/indexCustomer";
    }

    @GetMapping("/createCustomer")
    public String createCustomer() {
        return "home/customer/createCustomer";
    }

    @PostMapping("/createCustomer")
    public String createCustomer(@ModelAttribute Customer customer) {
        customerService.createCustomer(customer);
        return "redirect:/customer";
    }

    @GetMapping("/customer/findCustomer/{customer_id}")
    public String findCustomer(@PathVariable("customer_id") int customer_id, Model model){
        model.addAttribute("customer", customerService.findCustomer(customer_id));
        return "home/customer/findCustomer";
    }

    @GetMapping("/customer/delete/{customer_id}")
    public String deleteCustomer(@PathVariable("customer_id") int customer_id) {
        boolean deleted = customerService.deleteCustomer(customer_id);
        if (deleted) {
            return "redirect:/customer";
        } else {
            return "redirect:/customer";
        }
    }

    @GetMapping("/customer/updateCustomer/{customer_id}")
    public String updateCustomer(@PathVariable("customer_id") int customer_id, Model model){
        model.addAttribute("customer", customerService.findCustomer(customer_id));
        return "home/customer/updateCustomer";
    }

    @PostMapping("/customer/updateCustomer")
    public String updateCustomer(@ModelAttribute Customer customer) {
        customerService.updateCustomer(customer.getCustomer_id(), customer);
        return "redirect:/customer";
    }

//x-----------x----------x-----------x-----------x----------x-----------x-----------x----------x-----------x//

    //MOTORHOME
    @GetMapping("/motorhome")
    public String indexContract(Model model) {
        List<Motorhome> motorhomeList = motorhomeService.viewAllMotorhome();
        model.addAttribute("motorhomes", motorhomeList);
        return "home/motorhome/indexMotorhome";
    }

    @GetMapping("/createMotorhome")
    public String createMotorhome(){
        return "home/motorhome/createMotorhome";
    }

    @PostMapping("/createMotorhome")
    public String createMotorhome(@ModelAttribute Motorhome motorhome){
        motorhomeService.createMotorhome(motorhome);
        return "redirect:/motorhome";
    }

    @GetMapping("/motorhome/findMotorhome/{motorhome_id}")
    public String findMotorhome(@PathVariable("motorhome_id") int motorhome_id, Model model){
        model.addAttribute("motorhome", motorhomeService.findMotorhome(motorhome_id));
        return "home/motorhome/findMotorhome";
    }


    @GetMapping("/motorhome/delete/{motorhome_id}")
    public String deleteMotorhome(@PathVariable("motorhome_id") int motorhome_id) {
        boolean deleted = motorhomeService.deleteMotorhome(motorhome_id);
        if (deleted) {
            return "redirect:/motorhome";
        } else {
            return "redirect:/motorhome";
        }
    }

    @GetMapping("/motorhome/updateMotorhome/{motorhome_id}")
    public String updateMotorhome(@PathVariable("motorhome_id") int motorhome_id, Model model){
        model.addAttribute("motorhome", motorhomeService.findMotorhome(motorhome_id));
        return "home/motorhome/updateMotorhome";
    }

    @PostMapping("/motorhome/updateMotorhome")
    public String updateMotorhome(@ModelAttribute Motorhome motorhome) {
        motorhomeService.updateMotorhome(motorhome.getMotorhome_id(), motorhome);
        return "redirect:/motorhome";
    }

//x-----------x----------x-----------x-----------x----------x-----------x-----------x----------x-----------x//

    //RENTAL CONTRACT
    @GetMapping("/rentalContract")
    public String indexRentalContract(Model model){
        List<RentalContract> rentalContractList = rentalContractService.viewAllRentalContract();
        model.addAttribute("rentalContracts", rentalContractList);
        return "home/rentalContract/indexRentalContract";
    }

    @GetMapping("/createRentalContract")
    public String createRentalContract(Model model){
        List<Customer> customerList = customerService.viewAllCustomer();
        model.addAttribute("customers", customerList);
        List<Motorhome> motorhomeList = motorhomeService.viewAllMotorhome();
        model.addAttribute("motorhomes", motorhomeList);
        List<Extra> extraList = extraService.viewAllExtra();
        model.addAttribute("extras", extraList);
        return "home/rentalContract/createRentalContract";
    }

    @PostMapping("/createRentalContract")
    public String createRentalContract(@ModelAttribute RentalContract rentalContract){
        rentalContractService.createRentalContract(rentalContract);
        return "redirect:/rentalContract";
    }

    @GetMapping("/rentalContract/findRentalContract/{rentalContract_id}")
    public String findRentalContract(@PathVariable("rentalContract_id") int rentalContract_id, Model model){
        model.addAttribute("rentalContract", rentalContractService.findRentalContract(rentalContract_id));
        return "home/rentalContract/findRentalContract";
    }

    @GetMapping("/rentalContract/delete/{rentalContract_id}")
    public String deleteRentalContract(@PathVariable("rentalContract_id") int rentalContract_id) {
        boolean deleted = rentalContractService.deleteRentalContract(rentalContract_id);
        if (deleted) {
            return "redirect:/rentalContract";
        } else {
            return "redirect:/rentalContract";
        }
    }

    @GetMapping("/rentalContract/updateRentalContract/{rentalContract_id}")
    public String updateRentalContract(@PathVariable("rentalContract_id") int rentalContract_id, Model model){
        model.addAttribute("rentalContract", rentalContractService.findRentalContract(rentalContract_id));
        List<Extra> extraList = extraService.viewAllExtra();
        model.addAttribute("extras", extraList);
        return "home/rentalContract/updateRentalContract";
    }

    @PostMapping("/rentalContract/updateRentalContract")
    public String updateRentalContract(@ModelAttribute RentalContract rentalContract) {
        rentalContractService.updateRentalContract(rentalContract.getRentalContract_id(), rentalContract);
        return "redirect:/rentalContract";
    }


}