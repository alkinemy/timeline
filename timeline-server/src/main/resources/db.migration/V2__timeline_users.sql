CREATE TABLE `timeline`.`timeline_users` (

  `id` BIGINT NOT NULL AUTO_INCREMENT COMMENT 'pk',
  `login_id` VARCHAR(100) NOT NULL COMMENT '로그인 id',
  `name` VARCHAR(100) NOT NULL COMMENT '유저 이름',
  `password_hash` VARCHAR(100) NOT NULL COMMENT '비밀번호',
  `created_date` DATETIME NOT NULL COMMENT '등록 일시',
  `modified_date` DATETIME NOT NULL COMMENT '변경 일시',

  PRIMARY KEY (`id`),
  UNIQUE INDEX `timeline_users_uk01` (`login_id`)

) ENGINE=INNODB CHARACTER SET = utf8 COMMENT = '타임라인 서비스 유저';


CREATE TABLE `timeline`.`timeline_follow_mappings` (

  `follower_login_id` VARCHAR(100) NOT NULL COMMENT '팔로워의 login id',
  `following_login_id` VARCHAR(100) NOT NULL COMMENT '팔로잉하는 대상의 login id',

  PRIMARY KEY (`follower_login_id`, `following_login_id`)

) ENGINE = InnoDB CHARACTER SET = utf8 COMMENT = '팔로우 관계';

