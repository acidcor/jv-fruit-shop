package core.basesyntax.strategy.handler;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationHandler;

public class PurchaseOperation implements OperationHandler {
    @Override
    public void execute(FruitTransaction transaction) {
        if (transaction == null) {
            throw new RuntimeException("Illegal transaction");
        }
        int newValue = Storage.fruitTransactions.get(
                transaction.getName()) - transaction.getQuantity();
        if (newValue < 0) {
            throw new RuntimeException("Illegal action, value below 0");
        }
        Storage.fruitTransactions.put(transaction.getName(), newValue);
    }
}
