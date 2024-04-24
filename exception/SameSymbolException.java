package exception;


import models.Player;
import models.Symbol;

import java.util.List;

public class SameSymbolException extends Exception {
    public SameSymbolException(String message) {
        super(message);
    }
}
