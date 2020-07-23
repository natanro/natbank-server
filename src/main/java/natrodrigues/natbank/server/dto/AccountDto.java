package natrodrigues.natbank.server.dto;

import natrodrigues.natbank.server.models.Account;

public class AccountDto {

    private Long id;
    private String agency;
    private Long number;
    private Double balance;

	public AccountDto(Account newAccount) {
        this.id = newAccount.getId();
        this.agency = newAccount.getAgency();
        this.number = newAccount.getNumber();
        this.balance = newAccount.getBalance();
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

}
