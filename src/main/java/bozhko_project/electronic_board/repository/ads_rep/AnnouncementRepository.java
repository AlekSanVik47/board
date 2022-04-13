package bozhko_project.electronic_board.repository.ads_rep;

import bozhko_project.electronic_board.entities.ads.Announcement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnnouncementRepository extends JpaRepository<Announcement, Long> {
}