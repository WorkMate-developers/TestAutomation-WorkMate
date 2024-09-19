package api.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CountryResponse {

    public List<CountryEntry> response; // note: the node is not called response, see if it will work
}
