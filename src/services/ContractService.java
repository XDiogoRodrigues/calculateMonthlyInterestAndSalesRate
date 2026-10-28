package services;

import entities.Contract;
import entities.Installment;

import java.time.LocalDate;

public class ContractService {
    private OnlinePaymentService onlinePaymentService;

    public ContractService(OnlinePaymentService onlinePaymentService) {
        this.onlinePaymentService = onlinePaymentService;
    }

    public OnlinePaymentService getOnlinePaymentService() {
        return onlinePaymentService;
    }

    public void setOnlinePaymentService(OnlinePaymentService onlinePaymentService) {
        this.onlinePaymentService = onlinePaymentService;
    }

    public void processContract(Contract contract, Integer months) {
        double installmentAmount = contract.getTotalValue() / months;
        LocalDate currentDate = contract.getDate();
        for(int i = 1; i <= months; i++) {
            double interest = onlinePaymentService.interest(installmentAmount,i);
            double paymentFee = onlinePaymentService.paymentFee(interest);
            LocalDate currentDateModify = currentDate.plusMonths(i);
            contract.setInstallments(new Installment(currentDateModify, paymentFee, i));
        }
    }
}
