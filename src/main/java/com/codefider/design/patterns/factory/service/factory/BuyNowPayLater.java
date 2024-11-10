package com.codefider.design.patterns.factory.service.factory;

import com.codefider.design.patterns.strategyPaymentapp.model.Installment;
import com.codefider.design.patterns.strategyPaymentapp.model.Payment;
import com.codefider.design.patterns.strategyPaymentapp.repository.InstallmentRepository;
import com.codefider.design.patterns.strategyPaymentapp.service.strategy.PaymentStrategy;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import static com.codefider.design.patterns.strategyPaymentapp.constants.PaymentStatus.COMPLETED;

@Service("buy-now-pay-later")
@Slf4j
public class BuyNowPayLater implements PaymentService {

    public static final Double charge = 0.15;  // 15% charge for Buy Now, Pay Later

    @Override
    public Double calculate(Double amount) {
        log.info("BuyNowPayLater: Calculating payment for amount {}", amount);
        // Calculate the additional charge (15%)
        Double additionalCharge = amount * charge;
        log.info("BuyNowPayLater: Calculating payment for amount {}", additionalCharge);
        Double totalAmount = amount + additionalCharge;

        log.info("BuyNowPayLater: Charge applied: {}. Total amount to pay: {}", additionalCharge, totalAmount);

        return totalAmount;
    }

    @Override
    public Payment pay(Payment payment) {
        log.info("Processing Buy Now, Pay Later for amount: {}", payment.getTotalAmount());
        if (payment.getEmiDuration() != null) {
            Integer emiDuration = payment.getEmiDuration();
            // Calculate monthly installment amount
            Double monthlyInstallment = payment.getTotalAmount() / emiDuration;
            log.info("Scheduling {} monthly installments of amount: {}", emiDuration, monthlyInstallment);

            // Simulate scheduling each installment
            for (int month = 1; month <= emiDuration; month++) {
                log.info("Installment {} of {} scheduled: amount {}", month, emiDuration, monthlyInstallment);
                // Here, you might persist each installment to the database or schedule it with an external service
                saveInstallment(month, monthlyInstallment, payment);
            }
            payment.setEmiAmount(monthlyInstallment);
            payment.setStatus(String.valueOf(COMPLETED));
            return payment;
        }

        log.info("Buy Now, Pay Later payment scheduled successfully for amount: {}", payment.getTotalAmount());
        return payment;
    }

    // Simulated method to save each installment
    private void saveInstallment(int month, Double amount, Payment payment) {
        Installment installment = new Installment();
        installment.setMonth(month);
        installment.setAmount(amount);
        installment.setPayment(payment);

        // Persist installment in the database
      //  installmentRepository.save(installment);

        log.info("Saved installment {}: amount {}", month, amount);
    }
}
