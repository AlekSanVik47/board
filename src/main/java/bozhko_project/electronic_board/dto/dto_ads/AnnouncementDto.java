package bozhko_project.electronic_board.dto.dto_ads;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
public class AnnouncementDto implements Serializable {
	private final Long userIdId;
	private final String userIdLogin;
	private final String userIdPassword;
	private final String userIdName;
	private final String userIdSurname;
	private final String userIdEmail;
	private final String userIdPhone;
	private final Long productIdId;
	private final String productIdProductName;
	@NotNull(message = "категория не выбрана")
	private final Long productIdCategoryId;
	private final String productIdDescription;
	private final double productIdPrice;
	private final Long productIdBrandId;
	private final Long productIdImageId;
}
