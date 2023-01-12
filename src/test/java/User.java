import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    // These 3 fields map to the User from Fastmoney Soap Service
    String firstName;
    String lastName;
    String cprNumber;
    // UUID returned for User's account
    String bankId;
    // Internal to DTU Pay
    String uniqueId;
}
