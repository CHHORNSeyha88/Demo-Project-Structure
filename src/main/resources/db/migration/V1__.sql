CREATE TABLE permisson
(
    id             BIGINT AUTO_INCREMENT NOT NULL,
    created_date   datetime NOT NULL,
    modified_date  datetime NULL,
    permisson_name VARCHAR(255) NULL,
    module         VARCHAR(255) NULL,
    permisson_code VARCHAR(255) NULL,
    CONSTRAINT pk_permisson PRIMARY KEY (id)
);

CREATE TABLE `role`
(
    id            BIGINT AUTO_INCREMENT NOT NULL,
    created_date  datetime NOT NULL,
    modified_date datetime NULL,
    name          VARCHAR(255) NULL,
    code          VARCHAR(255) NULL,
    module        VARCHAR(255) NULL,
    CONSTRAINT pk_role PRIMARY KEY (id)
);

CREATE TABLE role_has_permisson
(
    permission_id BIGINT NOT NULL,
    role_id       BIGINT NOT NULL
);

CREATE TABLE user
(
    id            BIGINT AUTO_INCREMENT NOT NULL,
    created_date  datetime     NOT NULL,
    modified_date datetime NULL,
    name          VARCHAR(255) NOT NULL,
    username      VARCHAR(255) NOT NULL,
    email         VARCHAR(255) NOT NULL,
    bio           VARCHAR(255) NULL,
    avatar        VARCHAR(255) NULL,
    address       VARCHAR(255) NULL,
    phone         VARCHAR(255) NULL,
    role_id       BIGINT NULL,
    CONSTRAINT pk_user PRIMARY KEY (id)
);

ALTER TABLE user
    ADD CONSTRAINT uc_user_email UNIQUE (email);

ALTER TABLE user
    ADD CONSTRAINT FK_USER_ON_ROLE FOREIGN KEY (role_id) REFERENCES `role` (id);

ALTER TABLE role_has_permisson
    ADD CONSTRAINT fk_rolhasper_on_permission_entity FOREIGN KEY (permission_id) REFERENCES permisson (id);

ALTER TABLE role_has_permisson
    ADD CONSTRAINT fk_rolhasper_on_role_entity FOREIGN KEY (role_id) REFERENCES `role` (id);