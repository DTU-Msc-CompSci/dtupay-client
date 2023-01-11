package dtu.example;

import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@XmlRootElement // Needed for XML serialization and deserialization
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Transaction {

    private String cid;
    private String mid;
    private int amount;
}
