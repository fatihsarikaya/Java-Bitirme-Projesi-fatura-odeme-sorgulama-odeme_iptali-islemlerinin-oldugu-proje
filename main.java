// Custom exception class
class InsufficientBalanceException extends Exception {
    public InsufficientBalanceException(String message) {
        super(message);
    }
}

// Fatura tipleri enum
enum BillType {
    TELEFON,
    INTERNET,
    SU
}

// Fatura model class
class Invoice {
    private double amount;
    private LocalDate processDate;
    private BillType billType;

    // Constructor, getters, setters...
}

// Üye hesabı model class
class MemberAccount {
    private int id;
    private String firstName;
    private String lastName;
    private String memberCode;
    private double balance;

    // Constructor, getters, setters...
}

// Üye hesabı servis class
class MemberAccountService {
    // create/read/update/delete işlemleri
    public void createMemberAccount(MemberAccount memberAccount) { /* ... */ }
    public MemberAccount readMemberAccount(int id) { /* ... */ }
    public void updateMemberAccount(MemberAccount memberAccount) { /* ... */ }
    public void deleteMemberAccount(int id) { /* ... */ }

    // Member kodu oluştur
    public String generateMemberCode(String firstName, String lastName) {
        // İlk 2 harfi alarak kod oluştur
        // ...
    }
}

// Fatura servis class
class InvoiceService {
    // Fatura ödeme işlemi
    public void payInvoice(MemberAccount memberAccount, BillType billType, double amount, LocalDate processDate) throws InsufficientBalanceException {
        // Üye hesabında yeterli bakiye var mı kontrol et
        if (memberAccount.getBalance() >= amount) {
            // Fatura ödeme işlemi yap
            // ...
            memberAccount.setBalance(memberAccount.getBalance() - amount);
        } else {
            throw new InsufficientBalanceException("Yetersiz bakiye!");
        }
    }

    // Fatura sorgulama işlemi
    public void inquireInvoice(MemberAccount memberAccount, BillType billType) {
        // ...
    }

    // Fatura ödeme iptali işlemi
    public void cancelInvoicePayment(MemberAccount memberAccount, BillType billType, double amount, LocalDate processDate) {
        // ...
    }
}

// Client class
class Client extends InvoiceService {
    // Fatura ödeme işlemi overload
    public void payInvoice(MemberAccount memberAccount, BillType billType, double amount, LocalDate processDate) throws InsufficientBalanceException {
        super.payInvoice(memberAccount, billType, amount, processDate);
        System.out.println("Fatura ödendi.");
    }

    // Diğer overload metotlar
    // ...
}

public class Main {
    public static void main(String[] args) {
        // Kullanıcıdan girdileri al ve işlemleri gerçekleştir
        // ...
    }
}
