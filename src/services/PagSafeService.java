package services;

public class PagSafeService implements OnlinePaymentService {

    @Override
    public Double interest(Double amount, Integer month) {
        return amount + (amount * month / 100);
    }

    @Override
    public Double paymentFee(Double amount) {
        double valueTotal = amount + (amount * 0.05);
        return valueTotal;
    }

}
