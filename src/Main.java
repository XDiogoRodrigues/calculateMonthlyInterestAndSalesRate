import entities.Contract;
import services.ContractService;
import services.PagSafeService;
import services.PaypalService;

void main() {
    Locale.setDefault(Locale.US);
    Scanner sc = new Scanner(System.in);

    System.out.println("Enter the contract details: ");
    System.out.print("Number: ");
    int numberContract = sc.nextInt();
    sc.nextLine();
    System.out.print("Date (dd/MM/yyyy): ");
    LocalDate date = LocalDate.parse(sc.nextLine(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    System.out.print("Contract value: ");
    double valueContract = sc.nextDouble();
    System.out.print("Enter the number of installments: ");
    int installment = sc.nextInt();
    Contract contract = new Contract(numberContract, date, valueContract);
    System.out.print("Enter the type format payment: (payPal=pay/pagSafe=pag) : ");
    sc.nextLine();
    String formatPayment = sc.nextLine();

    if(formatPayment.equals("pay")) {
        ContractService contractService = new ContractService(new PaypalService());
        System.out.println("Payment method: PayPal");
        System.out.println("Installments:");
        System.out.println("Calculations (1% simple monthly interest + 2% payment fee):");
        contractService.processContract(contract, installment);
        contract.showInstallments();
    } else {
        ContractService contractService = new ContractService(new PagSafeService());
        System.out.println("Payment method: PagSafe");
        System.out.println("Installments:");
        System.out.println("Calculations (1% simple monthly interest + 5% payment fee):");
        contractService.processContract(contract, installment);
        contract.showInstallments();
    }




}
