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

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

import static java.lang.Integer.parseInt;

@Controller
public class HomeController {
    int daysUp;
    double totalPriceUp;
    String last_nameUp;

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


    //x-----------x----------x-----------x-----------x----------x-----------x-----------x----------x-----------x//

    //MAKE PAYMENT
    @GetMapping("/payment")
    public String makePayment() {
        return "home/payment/makePayment";
    }

    @GetMapping("/getRentalContractID")
    public String getRentalContractID(HttpServletRequest request, Model m) {
        // Handle inputed Last Name of the Customer
        String userEnteredLastName = request.getParameter("customer_LastName");
        last_nameUp = userEnteredLastName;

        // Make customer list
        List<Customer> customerList = customerService.viewAllCustomer();

        // Get Customer ID associated to inputed Customer last name and assign it to variable
        int wanted_ID = 0;
        for (Customer customer : customerList) {
            if (customer.getCustomer_lastName().equalsIgnoreCase(userEnteredLastName)) {
                wanted_ID = customer.getCustomer_id();
            }
        }

        // Make rentalContract list
        List<RentalContract> rentalContractList = rentalContractService.viewAllRentalContract();

        // Get Motorhome ID , start_date and end_date using Customer ID
        int motorhomeID = 0;
        String startDate = "";
        String endDate = "";
        for (RentalContract rentalContract : rentalContractList) {
            if (rentalContract.getCustomer_id() == wanted_ID) {
                motorhomeID = rentalContract.getMotorhome_id();
                startDate = rentalContract.getRentalContract_startDate();
                endDate = rentalContract.getRentalContract_endDate();
            }
        }

        // Make motorhome list
        List<Motorhome> motorhomeList = motorhomeService.viewAllMotorhome();

        // Get Motohome_brand, Motorhome_model, Motorhome_fuelAmount
        String brand = "";
        String model = "";
        int fuelAmount = 0;
        for (int k = 0; k < motorhomeList.size(); k++) {
            if (motorhomeList.get(k).getMotorhome_id() == motorhomeID) {
                brand = motorhomeList.get(k).getMotorhome_brand();
                model = motorhomeList.get(k).getMotorhome_model();
                fuelAmount = motorhomeList.get(k).getMotorhome_fuelAmount();
            }
        }

        // CALCULATE EVERYTHING
        // METHOD FOR GETTING NUMBER OF DAYS OUT OF STRING/VARCHAR rentalContract_startDate AND rentalContract_endDate
        String date1 = startDate;                // rentalContract_startDate
        String date2 = endDate;                  // rentalContract_endDate

        // Date 1 - Getting days/months/years
        int d1day10 = parseInt(String.valueOf(date1.charAt(0)));
        int d1day1 = parseInt(String.valueOf(date1.charAt(1)));
        int d1days = d1day10 * 10 + d1day1;

        int d1month10 = parseInt(String.valueOf(date1.charAt(3)));
        int d1month1 = parseInt(String.valueOf(date1.charAt(4)));
        int d1months = d1month10 * 10 + d1month1;

        int d1year1000 = parseInt(String.valueOf(date1.charAt(6)));
        int d1year100 = parseInt(String.valueOf(date1.charAt(7)));
        int d1year10 = parseInt(String.valueOf(date1.charAt(8)));
        int d1year1 = parseInt(String.valueOf(date1.charAt(9)));
        int d1years = d1year1000 * 1000 + d1year100 * 100 + d1year10 * 10 + d1year1;

        // Date 2 - Getting days/months/years
        int d2day10 = parseInt(String.valueOf(date2.charAt(0)));
        int d2day1 = parseInt(String.valueOf(date2.charAt(1)));
        int d2days = d2day10 * 10 + d2day1;

        int d2month10 = parseInt(String.valueOf(date2.charAt(3)));
        int d2month1 = parseInt(String.valueOf(date2.charAt(4)));
        int d2months = d2month10 * 10 + d2month1;

        int d2year1000 = parseInt(String.valueOf(date2.charAt(6)));
        int d2year100 = parseInt(String.valueOf(date2.charAt(7)));
        int d2year10 = parseInt(String.valueOf(date2.charAt(8)));
        int d2year1 = parseInt(String.valueOf(date2.charAt(9)));
        int d2years = d2year1000 * 1000 + d2year100 * 100 + d2year10 * 10 + d2year1;

        String d1date = d1days + "/" + d1months + "/" + d1years;
        String d2date = d2days + "/" + d2months + "/" + d2years;

        // Adding the attribute to the model -> Display start date and end date
        m.addAttribute("startingDate", d1date);
        m.addAttribute("endingDate", d2date);

        // FIND NUMBER OF DAYS
        int numberOfDays = 0;

        if ((d1months == d2months) && (d1years == d2years)) {                                                                               // (10/12/2020 - 20/12/2020)
            numberOfDays = d2days - d1days;
        } else if ((d1days < d2days) && (d1months < d2months) && (d1years == d2years)) {                                                    // (11/01/2020 - 22/10/2020)
            numberOfDays = (d2days - d1days) + 30 * (d2months - d1months);
        } else if ((d1days > d2days) && (d1months < d2months) && (d1years == d2years)) {                                                    // (22/01/2020 - 11/10/2020)
            numberOfDays = ((30 - d1days) + d2days) + 30 * (d2months - d1months - 1);
        } else if ((d1days == d2days) && (d1months < d2months) && (d1years == d2years)) {                                                   // (11/01/2020 - 11/10/2020)
            numberOfDays = 30 * (d2months - d1months);
        } else if ((d1days < d2days) && (d1months > d2months) && (d1years < d2years)) {                                                     // (11/10/2019 - 22/01/2020)
            numberOfDays = ((12 - d1months) * 30 + 30 - d1days) + ((d2months - 1) * 30 + d2days) + ((d2years - d1years) - 1) * 360;
        } else if ((d1days > d2days) && (d1months < d2months) && (d1years < d2years)) {                                                     // (22/01/2019 - 11/10/2020)
            numberOfDays = ((30 - d1days) + d2days) + (d2months - (d1months + 1)) * 30 + (d2years - d1years) * 360;
        } else if ((d1days < d2days) && (d1months < d2months) && (d1years < d2years)) {                                                     // (11/01/2019 - 22/10/2020)
            numberOfDays = (30 - d1days + d2days) + (d2months - d1months) * 30 + (d2years - d1years) * 360;
        } else if ((d1days > d2days) && (d1months > d2months) && (d1years < d2years)) {                                                     // (22/10/2019 - 11/01/2020)
            numberOfDays = ((30 - d1days) + d2days) + 30 * ((12 - d1months) - 1) + 30 * d2months;
        }

        // Adding the attribute to the model -> Display number of days
        m.addAttribute("totalNumberOfDays", numberOfDays);

        // INITIATE ALL THE PRICES
        double totalPrice = 0;              // TOTAL PRICE AND RETURNED AT THE END

        // Seasonal prices
        int pricePerDaySeason = 0;
        int seasonPrice = 0;

        // Motorhome prices
        int brandPrice = 0;
        int pricePerDayBrand = 0;
        int modelPrice = 0;
        int pricePerDayModel = 0;


        // 1. Price for all days (Season)
        if ((d1months == 1) || (d1months == 2) || (d1months == 111) || (d1months == 12)) {        // Low season
            pricePerDaySeason = 100;
        } else if ((d1months == 3) || (d1months == 4) || (d1months == 9) || (d1months == 10)) {  // Peak season
            pricePerDaySeason = 130;
        } else if ((d1months == 5) || (d1months == 6) || (d1months == 7) || (d1months == 8)) {   // Mid season
            pricePerDaySeason = 160;
        }
        seasonPrice = numberOfDays * pricePerDaySeason;
        totalPrice += seasonPrice;

        // Adding the attribute to the model -> Display prices
        m.addAttribute("seasonPrice", seasonPrice);
        m.addAttribute("totalPriceAndSeasonPrice", totalPrice);

        // 2. Price for all days (Brand)
        String motorhomeBrand = brand;
        if (motorhomeBrand.equalsIgnoreCase("Winnebago")) {
            pricePerDayBrand = 100;
        } else if (motorhomeBrand.equalsIgnoreCase("Entegra")) {
            pricePerDayBrand = 150;
        }
        brandPrice = numberOfDays * pricePerDayBrand;
        totalPrice += brandPrice;

        // Adding the attribute to the model -> Display prices
        m.addAttribute("brand", motorhomeBrand);
        m.addAttribute("priceForBrand", brandPrice);
        m.addAttribute("totalPriceAndPriceForBrand", totalPrice);

        // 3. Price for all days (Model)
        String motorhomeModel = model;
        if (motorhomeModel.equalsIgnoreCase("Boldt")) {
            pricePerDayModel = 10;
        } else if (motorhomeModel.equalsIgnoreCase("Travato")) {
            pricePerDayModel = 100;
        } else if (motorhomeModel.equalsIgnoreCase("Anthem")) {
            pricePerDayModel = 50;
        } else if (motorhomeModel.equalsIgnoreCase("Emblem ")) {
            pricePerDayModel = 150;
        }
        modelPrice = numberOfDays * pricePerDayModel;
        totalPrice += modelPrice;

        // Adding the attribute to the model -> Display prices
        m.addAttribute("model", motorhomeModel);
        m.addAttribute("priceForModel", modelPrice);
        m.addAttribute("totalPriceAndPriceForModel", totalPrice);

        // 4. Fuel amount
        if (fuelAmount < 50) {
            totalPrice += 70;
        }

        // Adding the attribute to the model -> Display amount of fuel and price
        m.addAttribute("fuelAmount" ,fuelAmount);
        m.addAttribute("totalPriceAfterFuelAmount", totalPrice);

        // Assign the variables to the instance variables which are instantiated at the beginning
        // Those variables will be needed in more methods
        daysUp = numberOfDays;
        totalPriceUp = totalPrice;

        return "home/payment/calculatedPayment";
    }


    @GetMapping("/distance")
    public String distance(HttpServletRequest request, Model m) {

        // 5. Average km driven
        String userInputDistance = request.getParameter("distance");
        double distanceDriven = Double.parseDouble(userInputDistance);

        // Adding the attribute to the model -> Display inputed distance and number of days
        m.addAttribute("distanceDriven",distanceDriven);
        m.addAttribute("days", daysUp);

        double averageKm = distanceDriven / ((double) daysUp);

        if (averageKm > 400) {
            totalPriceUp += (averageKm - 400);
        }

        // Adding the attribute to the model -> Display average km driven and price
        m.addAttribute("averageDistance", averageKm);
        m.addAttribute("totalPriceWithDistanceCost", totalPriceUp);

        return "home/payment/distance";
    }

    @GetMapping("/addExtras")
    public String addExtras(Model model){
        // List of all Extras items that can be rented out too
        List<Extra> extraList = extraService.viewAllExtra();
        model.addAttribute("extras", extraList);
        return "home/payment/extras";
    }

    @GetMapping("/finishCalculation")
    public String finishCalculation(HttpServletRequest request, Model model) {

        // Get total price and number of days from instance variables
        int numberOfDays = daysUp;
        double totalPrice = totalPriceUp;

        // Get all the User's input and parse it to Double type for calculating
        String userInputService = request.getParameter("service");
        double serviceQuantity = Double.parseDouble(userInputService);
        String userInputTransport = request.getParameter("transport");
        double transportQuantity = Double.parseDouble(userInputTransport);
        String userInputItem1 = request.getParameter("item1");
        double item1Quantity = Double.parseDouble(userInputItem1);
        String userInputItem2 = request.getParameter("item2");
        double item2Quantity = Double.parseDouble(userInputItem2);
        String userInputItem3 = request.getParameter("item3");
        double item3Quantity = Double.parseDouble(userInputItem3);
        String userInputItem4 = request.getParameter("item4");
        double item4Quantity = Double.parseDouble(userInputItem4);
        String userInputItem5 = request.getParameter("item5");
        double item5Quantity = Double.parseDouble(userInputItem5);

        // Initiate all the prices
        double priceService = 0.0;
        double priceTransport = 0;
        double priceItem1 = 0;
        double priceItem2 = 0;
        double priceItem3 = 0;
        double priceItem4 = 0;
        double priceItem5 = 0;

        // Calculate the price
        priceService = 500*serviceQuantity;                     // 1 service costs 500€
        priceTransport = 0.70*transportQuantity;                // 1 km cots 0,70€
        priceItem1 = 10*numberOfDays*item1Quantity;
        priceItem2 = 15*numberOfDays*item2Quantity;
        priceItem3 = 20*numberOfDays*item3Quantity;
        priceItem4 = 10*numberOfDays*item4Quantity;
        priceItem5 = 5*numberOfDays*item5Quantity;

        totalPrice = totalPrice + priceService + priceTransport + priceItem1 + priceItem2 + priceItem3 + priceItem4 + priceItem5;
        totalPriceUp = totalPrice;

        // Adding the attribute to the model -> Display customer last name and total price for that Customer
        model.addAttribute("customer", last_nameUp);
        model.addAttribute("finalPrice", totalPriceUp);
        return "home/payment/end";
    }


// ------------------------------------------------------------------------------------------------------------
// ------------------------------------------------------------------------------------------------------------
    //CANCELLATION
    @GetMapping("/cancellation")
    public String cancellation(){
        return "home/cancellation";
    }

    @PostMapping("/cancellationBill")
    public String cancellationBill(HttpServletRequest request, Model m){
        String userInputID = request.getParameter("inputID");
        String userInputDate = request.getParameter("inputDate");
        int id = Integer.parseInt(userInputID);
        String date = "";
        int motID = 0;

        List<RentalContract> rentalContractList = rentalContractService.viewAllRentalContract();
        for(int i = 0; i < rentalContractList.size(); i++){
            if(rentalContractList.get(i).getRentalContract_id()==id){
                date = rentalContractList.get(i).getRentalContract_startDate();
                motID = rentalContractList.get(i).getMotorhome_id();
            }
        }
        String date1 = userInputDate;          // today
        String date2 = date;                  // rentalContract_startDate

        // Date 1 - Getting days/months/years
        int d1day10 = parseInt(String.valueOf(date1.charAt(0)));
        int d1day1 = parseInt(String.valueOf(date1.charAt(1)));
        int d1days = d1day10 * 10 + d1day1;

        int d1month10 = parseInt(String.valueOf(date1.charAt(3)));
        int d1month1 = parseInt(String.valueOf(date1.charAt(4)));
        int d1months = d1month10 * 10 + d1month1;

        int d1year1000 = parseInt(String.valueOf(date1.charAt(6)));
        int d1year100 = parseInt(String.valueOf(date1.charAt(7)));
        int d1year10 = parseInt(String.valueOf(date1.charAt(8)));
        int d1year1 = parseInt(String.valueOf(date1.charAt(9)));
        int d1years = d1year1000 * 1000 + d1year100 * 100 + d1year10 * 10 + d1year1;

        // Date 2 - Getting days/months/years
        int d2day10 = parseInt(String.valueOf(date2.charAt(0)));
        int d2day1 = parseInt(String.valueOf(date2.charAt(1)));
        int d2days = d2day10 * 10 + d2day1;

        int d2month10 = parseInt(String.valueOf(date2.charAt(3)));
        int d2month1 = parseInt(String.valueOf(date2.charAt(4)));
        int d2months = d2month10 * 10 + d2month1;

        int d2year1000 = parseInt(String.valueOf(date2.charAt(6)));
        int d2year100 = parseInt(String.valueOf(date2.charAt(7)));
        int d2year10 = parseInt(String.valueOf(date2.charAt(8)));
        int d2year1 = parseInt(String.valueOf(date2.charAt(9)));
        int d2years = d2year1000 * 1000 + d2year100 * 100 + d2year10 * 10 + d2year1;

        String d1date = d1days + "/" + d1months + "/" + d1years;
        String d2date = d2days + "/" + d2months + "/" + d2years;


        // FIND NUMBER OF DAYS
        int cancelNumberOfDays = 0;
        // months == and years == (10/12/2020 - 20/12/2020)
        if ((d1months == d2months) && (d1years == d2years)) {
            cancelNumberOfDays = d2days - d1days;
        } else if ((d1days < d2days) && (d1months < d2months) && (d1years == d2years)) {                    // (11/01/2020 - 22/10/2020)
            cancelNumberOfDays = (d2days - d1days) + 30 * (d2months - d1months);
        } else if ((d1days > d2days) && (d1months < d2months) && (d1years == d2years)) {                    // (22/01/2020 - 11/10/2020)
            cancelNumberOfDays = ((30 - d1days) + d2days) + 30 * (d2months - d1months - 1);
        } else if ((d1days == d2days) && (d1months < d2months) && (d1years == d2years)) {                     // (11/01/2020 - 11/10/2020)
            cancelNumberOfDays = 30 * (d2months - d1months);
        } else if ((d1days < d2days) && (d1months > d2months) && (d1years < d2years)) {                     // (11/10/2019 - 22/01/2020)
            cancelNumberOfDays = ((12 - d1months) * 30 + 30 - d1days) + ((d2months - 1) * 30 + d2days) + ((d2years - d1years) - 1) * 360;
        } else if ((d1days > d2days) && (d1months < d2months) && (d1years < d2years)) {                           // (22/01/2019 - 11/10/2020)
            cancelNumberOfDays = ((30 - d1days) + d2days) + (d2months - (d1months + 1)) * 30 + (d2years - d1years) * 360;
        } else if ((d1days < d2days) && (d1months < d2months) && (d1years < d2years)) {                     // (11/01/2019 - 22/10/2020)
            cancelNumberOfDays = (30 - d1days + d2days) + (d2months - d1months) * 30 + (d2years - d1years) * 360;
        } else if ((d1days > d2days) && (d1months > d2months) && (d1years < d2years)) {                           // (22/10/2019 - 11/01/2020)
            cancelNumberOfDays = ((30 - d1days) + d2days) + 30 * ((12 - d1months) - 1) + 30 * d2months;
        }

        // add cancel number of days to the model
        m.addAttribute("cancelNumberOfDays", cancelNumberOfDays);


        String startDate = "";
        String endDate = "";
        for (RentalContract rentalContract : rentalContractList) {
            if (rentalContract.getRentalContract_id() == id) {
                startDate = rentalContract.getRentalContract_startDate();
                endDate = rentalContract.getRentalContract_endDate();
            }
        }

        String date3 = startDate;                // rentalContract_startDate
        String date4 = endDate;                  // rentalContract_endDate

        // Date 3 - Getting days/months/years
        int d3day10 = parseInt(String.valueOf(date3.charAt(0)));
        int d3day1 = parseInt(String.valueOf(date3.charAt(1)));
        int d3days = d3day10 * 10 + d3day1;

        int d3month10 = parseInt(String.valueOf(date3.charAt(3)));
        int d3month1 = parseInt(String.valueOf(date3.charAt(4)));
        int d3months = d3month10 * 10 + d3month1;

        int d3year1000 = parseInt(String.valueOf(date3.charAt(6)));
        int d3year100 = parseInt(String.valueOf(date3.charAt(7)));
        int d3year10 = parseInt(String.valueOf(date3.charAt(8)));
        int d3year1 = parseInt(String.valueOf(date3.charAt(9)));
        int d3years = d3year1000 * 1000 + d3year100 * 100 + d3year10 * 10 + d3year1;

        // Date 4 - Getting days/months/years
        int d4day10 = parseInt(String.valueOf(date4.charAt(0)));
        int d4day1 = parseInt(String.valueOf(date4.charAt(1)));
        int d4days = d4day10 * 10 + d4day1;

        int d4month10 = parseInt(String.valueOf(date4.charAt(3)));
        int d4month1 = parseInt(String.valueOf(date4.charAt(4)));
        int d4months = d4month10 * 10 + d4month1;

        int d4year1000 = parseInt(String.valueOf(date4.charAt(6)));
        int d4year100 = parseInt(String.valueOf(date4.charAt(7)));
        int d4year10 = parseInt(String.valueOf(date4.charAt(8)));
        int d4year1 = parseInt(String.valueOf(date4.charAt(9)));
        int d4years = d4year1000 * 1000 + d4year100 * 100 + d4year10 * 10 + d4year1;

        String d3date = d3days + "/" + d3months + "/" + d3years;
        String d4date = d4days + "/" + d4months + "/" + d4years;


        // FIND NUMBER OF DAYS
        int numberOfDays = 0;
        // months == and years == (10/12/2020 - 20/12/2020)
        if ((d3months == d4months) && (d3years == d4years)) {
            numberOfDays = d4days - d3days;
        } else if ((d3days < d4days) && (d3months < d4months) && (d3years == d4years)) {                    // (11/01/2020 - 22/10/2020)
            numberOfDays = (d4days - d3days) + 30 * (d4months - d3months);
        } else if ((d3days > d4days) && (d3months < d4months) && (d3years == d4years)) {                    // (22/01/2020 - 11/10/2020)
            numberOfDays = ((30 - d3days) + d4days) + 30 * (d4months - d3months - 1);
        } else if ((d3days == d4days) && (d3months < d4months) && (d3years == d4years)) {                     // (11/01/2020 - 11/10/2020)
            numberOfDays = 30 * (d4months - d3months);
        } else if ((d3days < d4days) && (d3months > d4months) && (d3years < d4years)) {                     // (11/10/2019 - 22/01/2020)
            numberOfDays = ((12 - d3months) * 30 + 30 - d3days) + ((d4months - 1) * 30 + d4days) + ((d4years - d3years) - 1) * 360;
        } else if ((d3days > d4days) && (d3months < d4months) && (d3years < d4years)) {                           // (22/01/2019 - 11/10/2020)
            numberOfDays = ((30 - d3days) + d4days) + (d4months - (d3months + 1)) * 30 + (d4years - d3years) * 360;
        } else if ((d3days < d4days) && (d3months < d4months) && (d3years < d4years)) {                     // (11/01/2019 - 22/10/2020)
            numberOfDays = (30 - d3days + d4days) + (d4months - d3months) * 30 + (d4years - d3years) * 360;
        } else if ((d3days > d4days) && (d3months > d4months) && (d3years < d4years)) {                           // (22/10/2019 - 11/01/2020)
            numberOfDays = ((30 - d3days) + d4days) + 30 * ((12 - d3months) - 1) + 30 * d4months;
        }

        List<Motorhome> motorhomeList = motorhomeService.viewAllMotorhome();
        String brand ="";
        String model = "";
        for(int i = 0; i < motorhomeList.size(); i++){
            if(motorhomeList.get(i).getMotorhome_id()==motID){
                brand = motorhomeList.get(i).getMotorhome_brand();
                model = motorhomeList.get(i).getMotorhome_model();
            }
        }

        // INITIATE ALL THE PRICES
        // sum of all prices
        double totalPrice = 0;

        // seasonal prices
        int pricePerDaySeason = 0;
        int seasonPrice = 0;

        // motorhome prices
        int brandPrice = 0;
        int pricePerDayBrand = 0;
        int modelPrice = 0;
        int pricePerDayModel = 0;


        // 1. Price for all days (Season)
        if ((d3months == 1) || (d3months == 2) || (d3months == 111) || (d3months == 12)) {        // Low season
            pricePerDaySeason = 100;
        } else if ((d3months == 3) || (d3months == 4) || (d3months == 9) || (d3months == 10)) {  // Peak season
            pricePerDaySeason = 130;
        } else if ((d3months == 5) || (d3months == 6) || (d3months == 7) || (d3months == 8)) {   // Mid season
            pricePerDaySeason = 160;
        }
        seasonPrice = numberOfDays * pricePerDaySeason;
        totalPrice += seasonPrice;


        // 2. Price for all days (Brand)
        String motorhomeBrand = brand;
        if (motorhomeBrand.equalsIgnoreCase("Winnebago")) {
            pricePerDayBrand = 100;
        } else if (motorhomeBrand.equalsIgnoreCase("Entegra")) {
            pricePerDayBrand = 150;
        }
        brandPrice = numberOfDays * pricePerDayBrand;
        totalPrice += brandPrice;


        // 3. Price for all days (Model)
        String motorhomeModel = model;
        if (motorhomeModel.equalsIgnoreCase("Boldt")) {
            pricePerDayModel = 10;
        } else if (motorhomeModel.equalsIgnoreCase("Travato")) {
            pricePerDayModel = 100;
        } else if (motorhomeModel.equalsIgnoreCase("Anthem")) {
            pricePerDayModel = 50;
        } else if (motorhomeModel.equalsIgnoreCase("Emblem ")) {
            pricePerDayModel = 150;
        }
        modelPrice = numberOfDays * pricePerDayModel;
        totalPrice += modelPrice;

        double cancelFee = 0.0;
        if(cancelNumberOfDays >= 50){
            cancelFee = 0.2 * totalPrice;
        } else if(cancelNumberOfDays >= 15 && cancelNumberOfDays <= 49){
            cancelFee = 0.5 * totalPrice;
        } else if(cancelNumberOfDays < 15 && cancelNumberOfDays >= 1){
            cancelFee = 0.8 * totalPrice;
        } else if(cancelNumberOfDays < 1){
            cancelFee = 0.95 * totalPrice;
        }

        double finalFee = cancelFee;
        m.addAttribute("finalCancelFee", finalFee);

        return "home/cancellationBill";
    }

}