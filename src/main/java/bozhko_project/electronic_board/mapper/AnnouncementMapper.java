package bozhko_project.electronic_board.mapper;

import bozhko_project.electronic_board.dto.dto_ads.AnnouncementDto;
import bozhko_project.electronic_board.entities.ads.Announcement;
import org.mapstruct.Mapper;

import static org.mapstruct.ReportingPolicy.IGNORE;

@Mapper(componentModel = "spring", unmappedTargetPolicy = IGNORE)
public interface AnnouncementMapper {
	Announcement announcementToAnnouncementDTO(AnnouncementDto entity);
	AnnouncementDto createAnnouncementDTO(AnnouncementDto dto);
	Announcement createAnnouncement(AnnouncementDto dto);
	Announcement updateAnnouncement(AnnouncementDto dto, Long id);
}
