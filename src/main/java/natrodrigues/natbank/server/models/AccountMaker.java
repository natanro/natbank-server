package natrodrigues.natbank.server.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "account_maker")
public class AccountMaker {

    @Id
    private Long id;
    private String agency;
    private Long number;

    public AccountMaker() {
    }

    public AccountMaker(Long id, String agency, Long number) {
        this.id = id;
        this.agency = agency;
        this.number = number;
	}

	public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setNumber(Long number) {
        this.number = number;
    }

    public void setAgency(String agency) {
        this.agency = agency;
    }

    public String getAgency() {
        return agency;
    }

    public Long getNumber() {
        number++;
        return number;
    }
}
