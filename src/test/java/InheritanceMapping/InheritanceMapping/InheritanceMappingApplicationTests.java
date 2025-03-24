package InheritanceMapping.InheritanceMapping;

import InheritanceMapping.InheritanceMapping.entities.Check;
import InheritanceMapping.InheritanceMapping.entities.CreditCard;
import InheritanceMapping.InheritanceMapping.repos.PaymentRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
class InheritanceMappingApplicationTests {

	@Autowired
	PaymentRepository paymentRepository;

	@Test
	void contextLoads() {
	}

	@Test
	public void createCreditCrdPayment() {
		CreditCard cc = new CreditCard();
		cc.setId(123);
		cc.setAmount(1000);
		cc.setCardnumber("1234567890");
		paymentRepository.save(cc);

		Check ch = new Check();
		ch.setId(234);
		ch.setAmount(2000);
		ch.setChecknumber("9874563210");
		paymentRepository.save(ch);
	}
}
