package com.example;

import com.example.entity.BankAccount;
import com.example.service.BankAccountService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "BankAccountServlet", value = "/bankAccount")
public class BankAccountServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Todo: search account
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // method for create account

        // get parameters from request object
        String owner = request.getParameter("owner");
        String balance = request.getParameter("balance");
        String accNumber = request.getParameter("accNumber");

        // create a bank account object
        BankAccount bankAccount = new BankAccount(owner, Long.parseLong(balance), accNumber);

        BankAccountService bankAccountService = new BankAccountService();

        String message;

        // try to persist bank account object and get result
        if (bankAccountService.create(bankAccount) != null) {
            message = "<h1 style=\"color: green\"> Account Created Successfully :) </h1>";
        } else {
            message = "<h1 style=\"color: red\"> Account Created Unsuccessfully :( </h1>";
        }

        try (PrintWriter out = response.getWriter()) {
            out.println("<html><body>");
            out.println(message);
            out.println("</body></html>");
        }
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Todo: delete account
    }
}
