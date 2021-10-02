package com.example.entity;

import javax.persistence.*;
import java.util.Objects;

/*@NamedQueries(
        @NamedQuery(
                name = "findByNumber",
                query = "select bankAccount from BankAccount bankAccount where bankAccount.accNumber=:accNumber"
        )
)*/

@Entity
@Table(name = "BANK_ACCOUNT")
public class BankAccount {
    private Long id;
    private String owner;
    private Long balance;
    private String accNumber;

    public BankAccount(String owner, Long balance, String accNumber) {
        this.owner = owner;
        this.balance = balance;
        this.accNumber = accNumber;
    }

    public BankAccount() {

    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "OWNER")
    public String getOwner() {
        return owner;
    }
    public void setOwner(String owner) {
        this.owner = owner;
    }

    @Column(name = "BALANCE")
    public Long getBalance() {
        return balance;
    }
    public void setBalance(Long balance) {
        this.balance = balance;
    }

    @Column(name = "ACC_NUMBER")
    public String getAccNumber() {
        return accNumber;
    }
    public void setAccNumber(String accNumber) {
        this.accNumber = accNumber;
    }


    @Override
    public String toString() {
        return  "Owner: " + owner + '\n' +
                "Account Number: " + accNumber + '\n' +
                "Balance: " + balance + '\n';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BankAccount that = (BankAccount) o;
        return Objects.equals(id, that.id) && Objects.equals(owner, that.owner) && Objects.equals(balance, that.balance) && Objects.equals(accNumber, that.accNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, owner, balance, accNumber);
    }

}

