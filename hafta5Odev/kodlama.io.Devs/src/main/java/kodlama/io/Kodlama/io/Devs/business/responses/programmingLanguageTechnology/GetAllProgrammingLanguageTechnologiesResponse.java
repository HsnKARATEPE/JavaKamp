package kodlama.io.Kodlama.io.Devs.business.responses.programmingLanguageTechnology;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllProgrammingLanguageTechnologiesResponse {
	private int id;
	private String name;
	private int programmingLanguageId;
	private String programmingLanguageName;
	
	
}
