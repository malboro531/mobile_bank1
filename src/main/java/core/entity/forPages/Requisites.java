package core.entity.forPages;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Requisites {
    String recipientName;
    String recipientAccount;
    String INN;
    String KPP;
    String paymentAppointment;
    String transferSum;
}
