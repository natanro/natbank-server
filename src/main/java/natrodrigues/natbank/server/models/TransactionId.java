package natrodrigues.natbank.server.models;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Embeddable
public class TransactionId implements Serializable {
    
    private static final long serialVersionUID = 1L;
    private String uuid;
    @Enumerated(EnumType.STRING)
    private TransactionType type;

    public TransactionId() {}

    public TransactionId(String uuid, TransactionType type) {
        this.uuid = uuid;
        this.type = type;
    }

    public TransactionId(String uuid) {
        this.uuid = uuid;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String id) {
        this.uuid = id;
    }

    public TransactionType getType() {
        return type;
    }

    public void setType(TransactionType type) {
        this.type = type;
    }

    @Override
    public int hashCode() {
        return uuid.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof TransactionId &&
         ((TransactionId)obj).getType() == this.type &&
          ((TransactionId)obj).getUuid() == this.uuid;
    }
}