package stacks.spock.functionalunittest.servicesimpl;

import org.springframework.stereotype.Service;
import stacks.spock.functionalunittest.interfaces.CalculatorDao;

@Service
public class CalculatorDaoImpl implements CalculatorDao {
    @Override
    public int save(int sum) {
        System.out.println("Saved " + sum);
        return sum + 1;
    }
}
