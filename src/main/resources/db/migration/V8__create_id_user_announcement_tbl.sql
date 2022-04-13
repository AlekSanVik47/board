CREATE TABLE user_announcement_tbl (
  announcement_id BIGINT NOT NULL,
   user_id BIGINT NOT NULL
);

ALTER TABLE user_announcement_tbl ADD CONSTRAINT fk_useanntbl_on_announcement FOREIGN KEY (announcement_id) REFERENCES announcement_tbl (announcement_id);

ALTER TABLE user_announcement_tbl ADD CONSTRAINT fk_useanntbl_on_user FOREIGN KEY (user_id) REFERENCES users_tbl (id);