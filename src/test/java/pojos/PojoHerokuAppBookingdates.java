package pojos;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PojoHerokuAppBookingdates {

    // 1- Tum variable'lari private olarak olustur.

    private String checkin;
    private String checkout;

    // 2- Tum variable'lar icin getter ve setter methodlari olusturalim.

    public String getCheckin() {
        return checkin;
    }

    public void setCheckin(String checkin) {
        this.checkin = checkin;
    }

    public String getCheckout() {
        return checkout;
    }

    public void setCheckout(String checkout) {
        this.checkout = checkout;
    }


    // 3- Tum parametreleri kullanarak bir constructor olusturalim.

    // 4- Default constructor yerine manuel olarak parametresiz bir constructor olusturalim.

    // 5- toString methodu olusturalim.


    @Override
    public String toString() {
        return "PojoHerokuappBookingdates{" +
                "checkin='" + checkin + '\'' +
                ", checkout='" + checkout + '\'' +
                '}';
    }
}
