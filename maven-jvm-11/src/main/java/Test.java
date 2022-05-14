import com.dnsimple.Client;
import com.dnsimple.data.DomainCheck;

public class Test {
  public static void main(String[] args) {
    String accessToken = "foobar";
    Client client = new Client.Builder().sandbox().accessToken(accessToken).build();
    long accountId = client.identity.whoami().getData().getAccount().getId();

    DomainCheck isAvailable = client.registrar.checkDomain(accountId, "google.com").getData();
    System.out.println(isAvailable.isAvailable());
    System.out.println(isAvailable.getDomainName());
    System.out.println(isAvailable.isPremium());
  }
}
