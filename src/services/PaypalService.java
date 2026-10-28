package services;

public class PaypalService implements OnlinePaymentService {

    @Override
    public Double interest(Double amount, Integer month) {
        return amount + (amount * month / 100);
    }

    @Override
    public Double paymentFee(Double amount) {
        double valueTotal = amount + (amount * 0.02);
        return valueTotal;
    }
}
