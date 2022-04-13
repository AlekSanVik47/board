CREATE TABLE IF NOT EXISTS public.user_role_tbl
(user_id smallint NOT NULL,
role_id smallint NOT NULL);
ALTER TABLE user_role_tbl ADD CONSTRAINT fk_userroletbl_on_role FOREIGN KEY (role_id) REFERENCES role_tbl (role_id);
ALTER TABLE user_role_tbl ADD CONSTRAINT fk_userroletbl_on_user FOREIGN KEY (user_id) REFERENCES users_tbl (id);