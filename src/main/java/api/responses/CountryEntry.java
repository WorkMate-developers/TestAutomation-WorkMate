package api.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CountryEntry {

    public int id;
    public String name;
    public String short_name;
    public Country country;
    public int countryId;

}
