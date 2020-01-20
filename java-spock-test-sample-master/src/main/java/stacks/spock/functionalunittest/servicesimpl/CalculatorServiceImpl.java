package stacks.spock.functionalunittest.servicesimpl;

import stacks.spock.functionalunittest.interfaces.CalculatorDao;
import stacks.spock.functionalunittest.interfaces.CalculatorService;

public class CalculatorServiceImpl implements CalculatorService {

    private final CalculatorDao machineDao;

    public CalculatorServiceImpl(CalculatorDao machineDao) {
        this.machineDao = machineDao;
    }

    @Override
    public int calculateAndPersist(int x, int y) {

        int sum = Calculator.take(x).add(y).calculate();

        sum = machineDao.save(sum);

        return sum;
    }
}
