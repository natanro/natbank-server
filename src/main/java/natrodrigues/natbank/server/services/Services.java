package natrodrigues.natbank.server.services;

import natrodrigues.natbank.server.config.exception.NatbankException;
import org.springframework.stereotype.Service;

@Service
public interface Services<T> {
    public void verify(T obj) throws NatbankException;
}
