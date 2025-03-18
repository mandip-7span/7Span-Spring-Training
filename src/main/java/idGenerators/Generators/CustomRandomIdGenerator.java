package idGenerators.Generators;

import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

import java.io.Serializable;
import java.util.Random;

public class CustomRandomIdGenerator implements IdentifierGenerator {
    @Override
    public Serializable generate(SharedSessionContractImplementor si, Object o) {
        Random random = null;
        long id = 0;
        random = new Random();
        id = random.nextInt(100000);
        return id;
    }
}
