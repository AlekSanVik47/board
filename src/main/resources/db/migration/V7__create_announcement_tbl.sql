CREATE TABLE announcement_tbl (
  announcement_id BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL,
   user_id BIGINT,
   product_id BIGINT,
   CONSTRAINT pk_announcement_tbl PRIMARY KEY (announcement_id)
);

ALTER TABLE announcement_tbl ADD CONSTRAINT FK_ANNOUNCEMENT_TBL_ON_PRODUCT FOREIGN KEY (product_id) REFERENCES product_tbl (id);

ALTER TABLE announcement_tbl ADD CONSTRAINT FK_ANNOUNCEMENT_TBL_ON_USER FOREIGN KEY (user_id) REFERENCES users_tbl (id);