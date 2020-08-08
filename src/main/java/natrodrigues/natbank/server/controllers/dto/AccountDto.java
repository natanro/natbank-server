package natrodrigues.natbank.server.controllers.dto;

import natrodrigues.natbank.server.models.Account;

public class AccountDto {

    private Long id;
    private String agency;
    private Long number;
    private Double balance;
    private String name;

	public AccountDto(Account newAccount) {
        this.id = newAccount.getId();
        this.agency = newAccount.getAgency();
        this.number = newAccount.getNumber();
        this.balance = newAccount.getBalance();
        this.name = newAccount.getUser().getName();
    }
    
    public Long getId() {
        return id;
    }

    public String getAgency() {
        return agency;
    }

    public Double getBalance() {
        return balance;
    }

    public Long getNumber() {
        return number;
    }

    public String getName() {
        return name;
    }
}
