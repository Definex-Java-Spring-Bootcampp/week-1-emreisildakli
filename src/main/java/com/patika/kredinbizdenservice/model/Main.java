package com.patika.kredinbizdenservice.model;

import com.patika.kredinbizdenservice.enums.LoanType;
import com.patika.kredinbizdenservice.enums.SectorType;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

public class Main {
    public static void main(String[] args) {

        User userEmre = UserFactory.getInstance().getUser("Emre", "Işıldaklı", LocalDate.of(1998, 11, 15), "emre@gmail.com", "pass", "5564221689", true);
        Loan carLoan = LoanFactory.getInstance().getLoan(LoanType.ARAC_KREDISI, BigDecimal.valueOf(100000), 12, 2.5);
        BankFactory bankFactory = BankFactory.getInstance();
        carLoan.setBank(bankFactory.getBank("Akbank"));
        ApplicationFactory appFactory = ApplicationFactory.getInstance();
        Application carLoanApplication = appFactory.getApplication(carLoan, userEmre, LocalDateTime.now());
        userEmre.addApplication(carLoanApplication);

        CreditCardFactory cardFactory = CreditCardFactory.getInstance();
        CampaignFactory campaignFactory = CampaignFactory.getInstance();
        List<Campaign> campaigns = new ArrayList<>();
        campaigns.add(campaignFactory.getCampaign("Aidatsız kart", "ihtiyac", LocalDate.of(2024, 12, 31), LocalDate.now(), LocalDate.now(), SectorType.MARKET));

        CreditCard card1 = cardFactory.getCreditCard(BigDecimal.valueOf(10000), campaigns);
        CreditCard card2 = cardFactory.getCreditCard(BigDecimal.valueOf(500), new ArrayList<>());
        CreditCard card3 = cardFactory.getCreditCard(BigDecimal.valueOf(9999999), new ArrayList<>());

        //Metotlar aşağıda denenebilir.

        //System.out.println(mostAppliedUser(UserFactory.getInstance().getInstances().values().stream().toList()));
        //System.out.println(highestLoanUser(ApplicationFactory.getInstance().getInstances()));
        //System.out.println(getLastMonthApplications(ApplicationFactory.getInstance().getInstances()));
        // System.out.println(getApplicationsByEmail("emre@gmail.com", appFactory.getInstances()));
        // System.out.println(getSortedCardOffers(cardFactory.getInstances()));

    }

    // En çok başvuru yapan kullanıcıyı bulan methodu yazın.
    public static User mostAppliedUser(List<User> users) {
        if (users.isEmpty()) {
            return null;
        }
        User user = users.getFirst();

        for (User u : users)
            if (u.getApplicationList().size() > user.getApplicationList().size()) {
                user = u;
            }
        return user;
    }

    // En yüksek kredi isteyen kullanıcıyı ve istediği tutarı bulan methodu yazın.
    public static HashMap<BigDecimal, User> highestLoanUser(ArrayList<Application> applications) {
        // productı loan olmayan applicationları filtreliyoruz
        List<Application> loanApplications = applications.stream().filter(application -> application.getLoan() != null).toList();
        if (loanApplications.isEmpty()) {
            return null;
        }

        Application application = loanApplications.getFirst();

        for (Application a : applications)
            if (application.getLoan().getAmount().compareTo(application.getLoan().getAmount()) > 0) {
                application = a;
            }

        HashMap<BigDecimal, User> result = new HashMap<>();
        result.put(application.getLoan().getAmount(), application.getUser());
        return result;
    }

    //Son bir aylık yapılan başvuruları listeleyen methodu yazın.
    public static List<Application> getLastMonthApplications(List<Application> applications) {
        List<Application> lastMonthApplication = applications.stream()
                .filter(application -> application.getLocalDateTime().isAfter(LocalDateTime.now().minusMonths(1)))
                .toList();
        return lastMonthApplication;
    }

    //Kampanya sayısı en çoktan aza doğru olacak şekilde kredi kartı tekliflerini listeleyen methodu yazın.
    public static List<CreditCard> getSortedCardOffers(List<CreditCard> cards) {
        //Treemap otomatik olarak key değerlerine göre sıralıyor, biz çoktan aza istediğimiz için tersini alıyoruz.
        TreeMap<Integer, CreditCard> sortedCards = new TreeMap<>(Collections.reverseOrder());
        for (CreditCard card : cards) {
            sortedCards.put(card.getCampaignList().size(), card);
        }

        return sortedCards.values().stream().toList();
    }

    // Mail adresine sahip kullanıcının bütün başvurularını listeleyen methodu yazın.
    public static List<Application> getApplicationsByEmail(String email, List<Application> applications) {
        if (applications.isEmpty()) {
            return null;
        }

        return applications.stream().filter(application -> application.getUser().getEmail().equals(email)).toList();
    }
}
